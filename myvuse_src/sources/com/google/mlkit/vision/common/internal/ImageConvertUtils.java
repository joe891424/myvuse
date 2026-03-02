package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class ImageConvertUtils {
    private static final ImageConvertUtils zza = new ImageConvertUtils();

    private ImageConvertUtils() {
    }

    public static ImageConvertUtils getInstance() {
        return zza;
    }

    public static ByteBuffer zza(ByteBuffer byteBuffer, boolean z) {
        int i;
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit / 6;
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(iLimit) : ByteBuffer.allocateDirect(iLimit);
        int i3 = 0;
        while (true) {
            i = i2 * 4;
            if (i3 >= i) {
                break;
            }
            byteBufferAllocate.put(i3, byteBuffer.get(i3));
            i3++;
        }
        for (int i4 = 0; i4 < i2 + i2; i4++) {
            byteBufferAllocate.put(i + i4, byteBuffer.get(((i4 % 2) * i2) + i + (i4 / 2)));
        }
        return byteBufferAllocate;
    }

    static final ByteBuffer zzb(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr = new byte[i4 + i4 + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i5 = (i3 + i3) / 4;
        boolean z = buffer2.remaining() == i5 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i5 - 1);
        } else {
            zzf(planeArr[0], i, i2, bArr, 0, 1);
            zzf(planeArr[1], i, i2, bArr, i3 + 1, 2);
            zzf(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    private static byte[] zzc(byte[] bArr, int i, int i2) throws MlKitException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException unused) {
            LogInstrumentation.m2734w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
            throw new MlKitException("Image conversion error from NV21 format", 13);
        }
    }

    private final Bitmap zzd(ByteBuffer byteBuffer, int i, int i2, int i3) throws MlKitException {
        byte[] bArrZzc = zzc(byteBufferToByteArray(byteBuffer), i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArrZzc, 0, bArrZzc.length);
        return zze(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    private static Bitmap zze(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    private static final void zzf(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i5 = i / (i2 / iLimit);
        int rowStride = 0;
        for (int i6 = 0; i6 < iLimit; i6++) {
            int pixelStride = rowStride;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i3] = buffer.get(pixelStride);
                i3 += i4;
                pixelStride += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    public byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    public ByteBuffer cloneByteBuffer(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferAllocateDirect = byteBuffer.isDirect() ? ByteBuffer.allocateDirect(iCapacity) : ByteBuffer.allocate(iCapacity);
        byteBufferAllocateDirect.limit(byteBuffer.limit());
        byteBufferAllocateDirect.put((ByteBuffer) byteBuffer.rewind());
        byteBufferAllocateDirect.position(iPosition);
        byteBuffer.position(iPosition);
        return byteBufferAllocateDirect;
    }

    public Bitmap convertJpegToUpRightBitmap(Image image, int i) {
        Preconditions.checkArgument(image.getFormat() == 256, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.get(bArr);
        return zze(BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, iRemaining), i, image.getWidth(), image.getHeight());
    }

    public ByteBuffer convertToNv21Buffer(InputImage inputImage, boolean z) throws MlKitException {
        int format = inputImage.getFormat();
        if (format != -1) {
            if (format != 17) {
                if (format == 35) {
                    return zzb((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight());
                }
                if (format == 842094169) {
                    return zza((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), z);
                }
                throw new MlKitException("Unsupported image format", 13);
            }
            if (!z) {
                return (ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer());
            }
            ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer());
            if (byteBuffer.hasArray()) {
                return byteBuffer;
            }
            byteBuffer.rewind();
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
            return ByteBuffer.wrap(bArr);
        }
        Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (int) Math.ceil(((double) height) / 2.0d);
        int iCeil2 = ((iCeil + iCeil) * ((int) Math.ceil(((double) width) / 2.0d))) + i;
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(iCeil2) : ByteBuffer.allocateDirect(iCeil2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            int i5 = 0;
            while (i5 < width) {
                int i6 = iArr[i2];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                int i9 = i6 & 255;
                int i10 = (((((i7 * (-38)) - (i8 * 74)) + (i9 * 112)) + 128) >> 8) + 128;
                int i11 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i12 = i3 + 1;
                byteBufferAllocate.put(i3, (byte) Math.min(255, (((((i7 * 66) + (i8 * 129)) + (i9 * 25)) + 128) >> 8) + 16));
                if (i4 % 2 == 0 && i2 % 2 == 0) {
                    int i13 = i + 1;
                    byteBufferAllocate.put(i, (byte) Math.min(255, i11));
                    i += 2;
                    byteBufferAllocate.put(i13, (byte) Math.min(255, i10));
                }
                i2++;
                i5++;
                i3 = i12;
            }
        }
        return byteBufferAllocate;
    }

    public Bitmap convertToUpRightBitmap(InputImage inputImage) throws MlKitException {
        int format = inputImage.getFormat();
        if (format == -1) {
            return zze((Bitmap) Preconditions.checkNotNull(inputImage.getBitmapInternal()), inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight());
        }
        if (format == 17) {
            return zzd((ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format == 35) {
            return zzd(zzb((Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes()), inputImage.getWidth(), inputImage.getHeight()), inputImage.getWidth(), inputImage.getHeight(), inputImage.getRotationDegrees());
        }
        if (format != 842094169) {
            throw new MlKitException("Unsupported image format", 13);
        }
        ByteBuffer byteBuffer = (ByteBuffer) Preconditions.checkNotNull(inputImage.getByteBuffer());
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        int rotationDegrees = inputImage.getRotationDegrees();
        byte[] bArrZzc = zzc(zza(byteBuffer, true).array(), width, height);
        Bitmap bitmapDecodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(bArrZzc, 0, bArrZzc.length);
        return zze(bitmapDecodeByteArray, rotationDegrees, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    public Bitmap getUpRightBitmap(InputImage inputImage) throws MlKitException {
        Bitmap bitmapInternal = inputImage.getBitmapInternal();
        return bitmapInternal != null ? zze(bitmapInternal, inputImage.getRotationDegrees(), inputImage.getWidth(), inputImage.getHeight()) : convertToUpRightBitmap(inputImage);
    }
}
