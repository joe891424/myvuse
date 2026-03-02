package androidx.camera.core;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
final class ImageSaver implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mOrientation;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    public interface OnImageSavedCallback {
        void onError(SaveError saveError, String message, Throwable cause);

        void onImageSaved(ImageCapture.OutputFileResults outputFileResults);
    }

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    ImageSaver(ImageProxy image, ImageCapture.OutputFileOptions outputFileOptions, int orientation, Executor userCallbackExecutor, Executor sequentialIoExecutor, OnImageSavedCallback callback) {
        this.mImage = image;
        this.mOutputFileOptions = outputFileOptions;
        this.mOrientation = orientation;
        this.mCallback = callback;
        this.mUserCallbackExecutor = userCallbackExecutor;
        this.mSequentialIoExecutor = sequentialIoExecutor;
    }

    @Override // java.lang.Runnable
    public void run() {
        final File fileSaveImageToTempFile = saveImageToTempFile();
        if (fileSaveImageToTempFile != null) {
            this.mSequentialIoExecutor.execute(new Runnable() { // from class: androidx.camera.core.ImageSaver$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5735lambda$run$0$androidxcameracoreImageSaver(fileSaveImageToTempFile);
                }
            });
        }
    }

    private File saveImageToTempFile() {
        SaveError saveError;
        String str;
        Throwable th;
        try {
            File fileCreateTempFile = File.createTempFile(TEMP_FILE_PREFIX, ".tmp");
            try {
                ImageProxy imageProxy = this.mImage;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    try {
                        fileOutputStream.write(ImageUtil.imageToJpegByteArray(this.mImage));
                        Exif exifCreateFromFile = Exif.createFromFile(fileCreateTempFile);
                        exifCreateFromFile.attachTimestamp();
                        if (new ExifRotationAvailability().shouldUseExifOrientation(this.mImage)) {
                            ByteBuffer buffer = this.mImage.getPlanes()[0].getBuffer();
                            buffer.rewind();
                            byte[] bArr = new byte[buffer.capacity()];
                            buffer.get(bArr);
                            exifCreateFromFile.setOrientation(Exif.createFromInputStream(new ByteArrayInputStream(bArr)).getOrientation());
                        } else {
                            exifCreateFromFile.rotate(this.mOrientation);
                        }
                        ImageCapture.Metadata metadata = this.mOutputFileOptions.getMetadata();
                        if (metadata.isReversedHorizontal()) {
                            exifCreateFromFile.flipHorizontally();
                        }
                        if (metadata.isReversedVertical()) {
                            exifCreateFromFile.flipVertically();
                        }
                        if (metadata.getLocation() != null) {
                            exifCreateFromFile.attachLocation(this.mOutputFileOptions.getMetadata().getLocation());
                        }
                        exifCreateFromFile.save();
                        fileOutputStream.close();
                        if (imageProxy != null) {
                            imageProxy.close();
                        }
                        th = null;
                        saveError = null;
                        str = null;
                    } finally {
                    }
                } catch (Throwable th2) {
                    if (imageProxy != null) {
                        try {
                            imageProxy.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (ImageUtil.CodecFailedException e) {
                int i = C04461.f1708x12b8ec9c[e.getFailureType().ordinal()];
                if (i == 1) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    th = e;
                } else if (i == 2) {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    th = e;
                } else {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    th = e;
                }
            } catch (IOException e2) {
                e = e2;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            } catch (IllegalArgumentException e3) {
                e = e3;
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                th = e;
            }
            if (saveError == null) {
                return fileCreateTempFile;
            }
            postError(saveError, str, th);
            fileCreateTempFile.delete();
            return null;
        } catch (IOException e4) {
            postError(SaveError.FILE_IO_FAILED, "Failed to create temp file", e4);
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.core.ImageSaver$1 */
    static /* synthetic */ class C04461 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType */
        static final /* synthetic */ int[] f1708x12b8ec9c;

        static {
            int[] iArr = new int[ImageUtil.CodecFailedException.FailureType.values().length];
            f1708x12b8ec9c = iArr;
            try {
                iArr[ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1708x12b8ec9c[ImageUtil.CodecFailedException.FailureType.DECODE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1708x12b8ec9c[ImageUtil.CodecFailedException.FailureType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: copyTempFileToDestination, reason: merged with bridge method [inline-methods] */
    public void m5735lambda$run$0$androidxcameracoreImageSaver(File tempFile) {
        Uri uriInsert;
        SaveError saveError;
        String str;
        ContentValues contentValues;
        Preconditions.checkNotNull(tempFile);
        Throwable e = null;
        try {
            try {
                if (isSaveToMediaStore()) {
                    if (this.mOutputFileOptions.getContentValues() != null) {
                        contentValues = new ContentValues(this.mOutputFileOptions.getContentValues());
                    } else {
                        contentValues = new ContentValues();
                    }
                    setContentValuePending(contentValues, 1);
                    uriInsert = this.mOutputFileOptions.getContentResolver().insert(this.mOutputFileOptions.getSaveCollection(), contentValues);
                    try {
                        if (uriInsert == null) {
                            saveError = SaveError.FILE_IO_FAILED;
                            str = "Failed to insert URI.";
                        } else {
                            if (copyTempFileToUri(tempFile, uriInsert)) {
                                saveError = null;
                                str = null;
                            } else {
                                saveError = SaveError.FILE_IO_FAILED;
                                str = "Failed to save to URI.";
                            }
                            setUriNotPending(uriInsert);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        saveError = SaveError.FILE_IO_FAILED;
                        str = "Failed to write destination file.";
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        saveError = SaveError.FILE_IO_FAILED;
                        str = "Failed to write destination file.";
                    }
                } else {
                    if (isSaveToOutputStream()) {
                        copyTempFileToOutputStream(tempFile, this.mOutputFileOptions.getOutputStream());
                    } else if (isSaveToFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.mOutputFileOptions.getFile());
                        try {
                            FileLock fileLockLock = fileOutputStream.getChannel().lock();
                            copyTempFileToOutputStream(tempFile, fileOutputStream);
                            fileLockLock.release();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    uriInsert = null;
                    saveError = null;
                    str = null;
                }
            } finally {
                tempFile.delete();
            }
        } catch (IOException | IllegalArgumentException e4) {
            uriInsert = null;
            e = e4;
        }
        if (saveError != null) {
            postError(saveError, str, e);
        } else {
            postSuccess(uriInsert);
        }
    }

    private boolean isSaveToMediaStore() {
        return (this.mOutputFileOptions.getSaveCollection() == null || this.mOutputFileOptions.getContentResolver() == null || this.mOutputFileOptions.getContentValues() == null) ? false : true;
    }

    private boolean isSaveToFile() {
        return this.mOutputFileOptions.getFile() != null;
    }

    private boolean isSaveToOutputStream() {
        return this.mOutputFileOptions.getOutputStream() != null;
    }

    private void setUriNotPending(Uri outputUri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePending(contentValues, 0);
            this.mOutputFileOptions.getContentResolver().update(outputUri, contentValues, null, null);
        }
    }

    private void setContentValuePending(ContentValues values, int isPending) {
        if (Build.VERSION.SDK_INT >= 29) {
            values.put("is_pending", Integer.valueOf(isPending));
        }
    }

    private boolean copyTempFileToUri(File tempFile, Uri uri) throws IOException {
        OutputStream outputStreamOpenOutputStream = this.mOutputFileOptions.getContentResolver().openOutputStream(uri);
        if (outputStreamOpenOutputStream == null) {
            if (outputStreamOpenOutputStream == null) {
                return false;
            }
            outputStreamOpenOutputStream.close();
            return false;
        }
        try {
            copyTempFileToOutputStream(tempFile, outputStreamOpenOutputStream);
            if (outputStreamOpenOutputStream == null) {
                return true;
            }
            outputStreamOpenOutputStream.close();
            return true;
        } catch (Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void copyTempFileToOutputStream(File tempFile, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(tempFile);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    outputStream.write(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void postSuccess(final Uri outputUri) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: androidx.camera.core.ImageSaver$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5734lambda$postSuccess$1$androidxcameracoreImageSaver(outputUri);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.m1139e(TAG, "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    /* JADX INFO: renamed from: lambda$postSuccess$1$androidx-camera-core-ImageSaver, reason: not valid java name */
    /* synthetic */ void m5734lambda$postSuccess$1$androidxcameracoreImageSaver(Uri uri) {
        this.mCallback.onImageSaved(new ImageCapture.OutputFileResults(uri));
    }

    private void postError(final SaveError saveError, final String message, final Throwable cause) {
        try {
            this.mUserCallbackExecutor.execute(new Runnable() { // from class: androidx.camera.core.ImageSaver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5733lambda$postError$2$androidxcameracoreImageSaver(saveError, message, cause);
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.m1139e(TAG, "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    /* JADX INFO: renamed from: lambda$postError$2$androidx-camera-core-ImageSaver, reason: not valid java name */
    /* synthetic */ void m5733lambda$postError$2$androidxcameracoreImageSaver(SaveError saveError, String str, Throwable th) {
        this.mCallback.onError(saveError, str, th);
    }
}
