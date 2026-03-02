package com.rnziparchive;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.rnziparchive.StreamUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.jose4j.keys.AesKey;

/* JADX INFO: loaded from: classes6.dex */
public class RNZipArchiveModule extends ReactContextBaseJavaModule {
    private static final String EVENT_KEY_FILENAME = "filePath";
    private static final String EVENT_KEY_PROGRESS = "progress";
    private static final String PROGRESS_EVENT_NAME = "zipArchiveProgressEvent";
    private static final String TAG = "RNZipArchiveModule";

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNZipArchiveModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNZipArchive";
    }

    @ReactMethod
    public void isPasswordProtected(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(new ZipFile(str).isEncrypted()));
        } catch (ZipException e) {
            promise.reject((String) null, String.format("Unable to check for encryption due to: %s", getStackTrace(e)));
        }
    }

    @ReactMethod
    public void unzipWithPassword(final String str, final String str2, final String str3, final Promise promise) {
        new Thread(new Runnable() { // from class: com.rnziparchive.RNZipArchiveModule.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ZipFile zipFile = new ZipFile(str);
                    if (zipFile.isEncrypted()) {
                        zipFile.setPassword(str3.toCharArray());
                    } else {
                        promise.reject((String) null, String.format("Zip file: %s is not password protected", str));
                    }
                    List<FileHeader> fileHeaders = zipFile.getFileHeaders();
                    ArrayList arrayList = new ArrayList();
                    int size = fileHeaders.size();
                    RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                    int i = 0;
                    while (i < size) {
                        FileHeader fileHeader = fileHeaders.get(i);
                        String canonicalPath = new File(str2, fileHeader.getFileName()).getCanonicalPath();
                        if (!canonicalPath.startsWith(new File(str2).getCanonicalPath() + File.separator)) {
                            throw new SecurityException(String.format("Found Zip Path Traversal Vulnerability with %s", canonicalPath));
                        }
                        if (!fileHeader.isDirectory()) {
                            zipFile.extractFile(fileHeader, str2);
                            arrayList.add(fileHeader.getFileName());
                        }
                        int i2 = i + 1;
                        RNZipArchiveModule.this.updateProgress(i2, size, str);
                        i = i2;
                    }
                    promise.resolve(Arguments.fromList(arrayList));
                } catch (Exception e) {
                    RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                    promise.reject((String) null, String.format("Failed to unzip file, due to: %s", RNZipArchiveModule.this.getStackTrace(e)));
                }
            }
        }).start();
    }

    @ReactMethod
    public void unzip(final String str, final String str2, final String str3, final Promise promise) {
        new Thread(new Runnable() { // from class: com.rnziparchive.RNZipArchiveModule.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new File(str);
                    try {
                        RNZipArchiveModule.this.getUncompressedSize(str, str3);
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                        ZipFile zipFile = new ZipFile(str);
                        zipFile.setCharset(Charset.forName(str3));
                        zipFile.extractAll(str2);
                        zipFile.close();
                        RNZipArchiveModule.this.updateProgress(1L, 1L, str);
                        promise.resolve(str2);
                    } catch (Exception e) {
                        RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                        promise.reject((String) null, "Failed to extract file " + e.getLocalizedMessage());
                    }
                } catch (NullPointerException unused) {
                    promise.reject((String) null, "Couldn't open file " + str + ". ");
                }
            }
        }).start();
    }

    @ReactMethod
    public void unzipAssets(final String str, final String str2, final Promise promise) {
        new Thread(new Runnable() { // from class: com.rnziparchive.RNZipArchiveModule.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InputStream inputStreamOpen = RNZipArchiveModule.this.getReactApplicationContext().getAssets().open(str);
                    final long length = RNZipArchiveModule.this.getReactApplicationContext().getAssets().openFd(str).getLength();
                    try {
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        ZipInputStream zipInputStream = new ZipInputStream(inputStreamOpen);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
                        final long[] jArr = {0};
                        final int[] iArr = {0};
                        RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                        while (true) {
                            final ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                if (!nextEntry.isDirectory()) {
                                    File file2 = new File(str2, nextEntry.getName());
                                    String canonicalPath = file2.getCanonicalPath();
                                    if (!canonicalPath.startsWith(new File(str2).getCanonicalPath() + File.separator)) {
                                        throw new SecurityException(String.format("Found Zip Path Traversal Vulnerability with %s", canonicalPath));
                                    }
                                    if (!file2.exists()) {
                                        new File(file2.getParent()).mkdirs();
                                    }
                                    StreamUtil.ProgressCallback progressCallback = new StreamUtil.ProgressCallback() { // from class: com.rnziparchive.RNZipArchiveModule.3.1
                                        @Override // com.rnziparchive.StreamUtil.ProgressCallback
                                        public void onCopyProgress(long j) {
                                            long[] jArr2 = jArr;
                                            long j2 = jArr2[0] + j;
                                            jArr2[0] = j2;
                                            int[] iArr2 = iArr;
                                            int i = (int) ((j2 * 100.0d) / length);
                                            if (i > iArr2[0]) {
                                                iArr2[0] = i;
                                                RNZipArchiveModule.this.updateProgress(jArr[0], length, nextEntry.getName());
                                            }
                                        }
                                    };
                                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    StreamUtil.copy(bufferedInputStream, bufferedOutputStream, progressCallback);
                                    bufferedOutputStream.close();
                                    fileOutputStream.close();
                                }
                            } else {
                                RNZipArchiveModule.this.updateProgress(1L, 1L, str);
                                bufferedInputStream.close();
                                zipInputStream.close();
                                promise.resolve(str2);
                                return;
                            }
                        }
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                            RNZipArchiveModule.this.updateProgress(0L, 1L, str);
                            throw new Exception(String.format("Couldn't extract %s", str));
                        } catch (Exception e2) {
                            promise.reject((String) null, e2.getMessage());
                        }
                    }
                } catch (IOException unused) {
                    promise.reject((String) null, String.format("Asset file `%s` could not be opened", str));
                }
            }
        }).start();
    }

    @ReactMethod
    public void zipFiles(ReadableArray readableArray, String str, Promise promise) {
        zip(readableArray.toArrayList(), str, promise);
    }

    @ReactMethod
    public void zipFolder(String str, String str2, Promise promise) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(str);
        zip(arrayList, str2, promise);
    }

    @ReactMethod
    public void zipFilesWithPassword(ReadableArray readableArray, String str, String str2, String str3, Promise promise) {
        zipWithPassword(readableArray.toArrayList(), str, str2, str3, promise);
    }

    @ReactMethod
    public void zipFolderWithPassword(String str, String str2, String str3, String str4, Promise promise) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(str);
        zipWithPassword(arrayList, str2, str3, str4, promise);
    }

    private void zipWithPassword(ArrayList<Object> arrayList, String str, String str2, String str3, Promise promise) {
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
            zipParameters.setCompressionLevel(CompressionLevel.NORMAL);
            String[] strArrSplit = str3.split("-");
            if (str2 != null && !str2.isEmpty()) {
                zipParameters.setEncryptFiles(true);
                if (strArrSplit[0].equals(AesKey.ALGORITHM)) {
                    zipParameters.setEncryptionMethod(EncryptionMethod.AES);
                    if (!strArrSplit[1].equals("128") && strArrSplit[1].equals("256")) {
                        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
                    } else {
                        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_128);
                    }
                } else if (str3.equals("STANDARD")) {
                    zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);
                    LogInstrumentation.m2726d(TAG, "Standard Encryption");
                } else {
                    zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
                    LogInstrumentation.m2726d(TAG, "Encryption type not supported default to Standard Encryption");
                }
            } else {
                promise.reject((String) null, "Password is empty");
            }
            processZip(arrayList, str, zipParameters, promise, str2.toCharArray());
        } catch (Exception e) {
            promise.reject((String) null, e.getMessage());
        }
    }

    private void zip(ArrayList<Object> arrayList, String str, Promise promise) {
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
            zipParameters.setCompressionLevel(CompressionLevel.NORMAL);
            processZip(arrayList, str, zipParameters, promise, null);
        } catch (Exception e) {
            promise.reject((String) null, e.getMessage());
        }
    }

    private void processZip(final ArrayList<Object> arrayList, final String str, final ZipParameters zipParameters, final Promise promise, final char[] cArr) {
        new Thread(new Runnable() { // from class: com.rnziparchive.RNZipArchiveModule.4
            @Override // java.lang.Runnable
            public void run() {
                ZipFile zipFile;
                try {
                    if (cArr != null) {
                        zipFile = new ZipFile(str, cArr);
                    } else {
                        zipFile = new ZipFile(str);
                    }
                    RNZipArchiveModule.this.updateProgress(0L, 100L, str);
                    int size = 0;
                    int i = 0;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        File file = new File(arrayList.get(i2).toString());
                        if (file.exists()) {
                            if (file.isDirectory()) {
                                List listAsList = Arrays.asList(file.listFiles());
                                size += listAsList.size();
                                for (int i3 = 0; i3 < listAsList.size(); i3++) {
                                    if (((File) listAsList.get(i3)).isDirectory()) {
                                        zipFile.addFolder((File) listAsList.get(i3), zipParameters);
                                    } else {
                                        zipFile.addFile((File) listAsList.get(i3), zipParameters);
                                    }
                                    i++;
                                    RNZipArchiveModule.this.updateProgress(i, size, str);
                                }
                            } else {
                                size++;
                                zipFile.addFile(file, zipParameters);
                                i++;
                                RNZipArchiveModule.this.updateProgress(i, size, str);
                            }
                        } else {
                            promise.reject((String) null, "File or folder does not exist");
                        }
                        RNZipArchiveModule.this.updateProgress(1L, 1L, str);
                    }
                    promise.resolve(str);
                } catch (Exception e) {
                    promise.reject((String) null, e.getMessage());
                }
            }
        }).start();
    }

    protected void updateProgress(long j, long j2, String str) {
        double dMin = Math.min(j / j2, 1.0d);
        LogInstrumentation.m2726d(TAG, String.format("updateProgress: %.0f%%", Double.valueOf(100.0d * dMin)));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(EVENT_KEY_FILENAME, str);
        writableMapCreateMap.putDouble("progress", dMin);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(PROGRESS_EVENT_NAME, writableMapCreateMap);
    }

    @ReactMethod
    public void getUncompressedSize(String str, String str2, Promise promise) {
        promise.resolve(Double.valueOf(getUncompressedSize(str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getUncompressedSize(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            zipFile.setCharset(Charset.forName(str2));
            Iterator<FileHeader> it2 = zipFile.getFileHeaders().iterator();
            long j = 0;
            while (it2.hasNext()) {
                long uncompressedSize = it2.next().getUncompressedSize();
                if (uncompressedSize != -1) {
                    j += uncompressedSize;
                }
            }
            zipFile.close();
            return j;
        } catch (IOException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStackTrace(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
