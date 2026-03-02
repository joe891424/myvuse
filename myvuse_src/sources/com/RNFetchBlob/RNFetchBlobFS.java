package com.RNFetchBlob;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import com.RNFetchBlob.Utils.PathResolver;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.jose4j.lang.HashUtil;
import org.jose4j.lang.StringUtil;

/* JADX INFO: loaded from: classes.dex */
class RNFetchBlobFS {
    private static HashMap<String, RNFetchBlobFS> fileStreams = new HashMap<>();
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;
    private String encoding = RNFetchBlobConst.RNFB_RESPONSE_BASE64;
    private OutputStream writeStreamInstance = null;

    RNFetchBlobFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    static void writeFile(String str, String str2, String str3, boolean z, Promise promise) {
        int length;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject("EUNSPECIFIED", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            if (str2.equalsIgnoreCase("uri")) {
                String strNormalizePath = normalizePath(str3);
                File file2 = new File(strNormalizePath);
                if (!file2.exists()) {
                    promise.reject("ENOENT", "No such file '" + str + "' ('" + strNormalizePath + "')");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        fileOutputStream = new FileOutputStream(file, z);
                        length = 0;
                        while (true) {
                            try {
                                int i = fileInputStream2.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                length += i;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        fileInputStream2.close();
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } else {
                byte[] bArrStringToBytes = stringToBytes(str3, str2);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(bArrStringToBytes);
                    length = bArrStringToBytes.length;
                } finally {
                    fileOutputStream2.close();
                }
            }
            promise.resolve(Integer.valueOf(length));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created, or it is a directory");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            try {
                byte[] bArr = new byte[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    bArr[i] = (byte) readableArray.getInt(i);
                }
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                promise.resolve(Integer.valueOf(readableArray.size()));
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void readFile(java.lang.String r7, java.lang.String r8, com.facebook.react.bridge.Promise r9) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.readFile(java.lang.String, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap map = new HashMap();
        map.put("DocumentDir", reactApplicationContext.getFilesDir().getAbsolutePath());
        map.put("CacheDir", reactApplicationContext.getCacheDir().getAbsolutePath());
        map.put("DCIMDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath());
        map.put("PictureDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        map.put("MusicDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        map.put("DownloadDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        map.put("MovieDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        map.put("RingtoneDir", reactApplicationContext.getExternalFilesDir(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            map.put("SDCardDir", reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                map.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                map.put("SDCardApplicationDir", "");
            }
        }
        map.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        return map;
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            promise.resolve(reactApplicationContext.getExternalFilesDir(null).getAbsolutePath());
        } else {
            promise.reject("RNFetchBlob.getSDCardDir", "External storage not mounted");
        }
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir(null).getParentFile().getAbsolutePath());
                return;
            } catch (Exception e) {
                promise.reject("RNFetchBlob.getSDCardApplicationDir", e.getLocalizedMessage());
                return;
            }
        }
        promise.reject("RNFetchBlob.getSDCardApplicationDir", "External storage not mounted");
    }

    static String getTmpPath(String str) {
        return RNFetchBlob.RCTContext.getFilesDir() + "/RNFetchBlobTmp_" + str;
    }

    void readStream(String str, String str2, int i, int i2, String str3) {
        String str4;
        String strNormalizePath = normalizePath(str);
        String str5 = strNormalizePath != null ? strNormalizePath : str;
        try {
            int i3 = str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64) ? 4095 : 4096;
            if (i > 0) {
                i3 = i;
            }
            InputStream inputStreamOpenInputStream = (strNormalizePath == null || !str5.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) ? strNormalizePath == null ? RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(str5)) : new FileInputStream(new File(str5)) : RNFetchBlob.RCTContext.getAssets().open(str5.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            byte[] bArr = new byte[i3];
            int i4 = -1;
            String str6 = "data";
            if (str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_UTF8)) {
                CharsetEncoder charsetEncoderNewEncoder = Charset.forName("UTF-8").newEncoder();
                while (true) {
                    int i5 = inputStreamOpenInputStream.read(bArr);
                    if (i5 == i4) {
                        break;
                    }
                    charsetEncoderNewEncoder.encode(ByteBuffer.wrap(bArr).asCharBuffer());
                    emitStreamEvent(str3, str6, new String(bArr, 0, i5));
                    if (i2 > 0) {
                        str4 = str6;
                        SystemClock.sleep(i2);
                    } else {
                        str4 = str6;
                    }
                    str6 = str4;
                    i4 = -1;
                }
            } else {
                String str7 = "data";
                if (str2.equalsIgnoreCase("ascii")) {
                    while (true) {
                        int i6 = inputStreamOpenInputStream.read(bArr);
                        if (i6 == -1) {
                            break;
                        }
                        WritableArray writableArrayCreateArray = Arguments.createArray();
                        for (int i7 = 0; i7 < i6; i7++) {
                            writableArrayCreateArray.pushInt(bArr[i7]);
                        }
                        String str8 = str7;
                        emitStreamEvent(str3, str8, writableArrayCreateArray);
                        if (i2 > 0) {
                            SystemClock.sleep(i2);
                        }
                        str7 = str8;
                    }
                } else {
                    if (!str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
                        emitStreamEvent(str3, "error", "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                        inputStreamOpenInputStream.close();
                    }
                    while (true) {
                        int i8 = inputStreamOpenInputStream.read(bArr);
                        if (i8 == -1) {
                            break;
                        }
                        if (i8 < i3) {
                            byte[] bArr2 = new byte[i8];
                            System.arraycopy(bArr, 0, bArr2, 0, i8);
                            emitStreamEvent(str3, str7, Base64.encodeToString(bArr2, 2));
                        } else {
                            emitStreamEvent(str3, str7, Base64.encodeToString(bArr, 2));
                        }
                        if (i2 > 0) {
                            SystemClock.sleep(i2);
                        }
                    }
                }
            }
            emitStreamEvent(str3, ViewProps.END, "");
            inputStreamOpenInputStream.close();
        } catch (FileNotFoundException unused) {
            emitStreamEvent(str3, "error", "ENOENT", "No such file '" + str5 + "'");
        } catch (Exception e) {
            emitStreamEvent(str3, "error", "EUNSPECIFIED", "Failed to convert data to " + str2 + " encoded string. This might be because this encoding cannot be used for this data.");
            e.printStackTrace();
        }
    }

    void writeStream(String str, String str2, boolean z, Callback callback) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            this.encoding = str2;
            String string = UUID.randomUUID().toString();
            fileStreams.put(string, this);
            this.writeStreamInstance = fileOutputStream;
            callback.invoke(null, null, string);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        RNFetchBlobFS rNFetchBlobFS = fileStreams.get(str);
        try {
            rNFetchBlobFS.writeStreamInstance.write(stringToBytes(str2, rNFetchBlobFS.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            fileStreams.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
            for (File file2 : fileArrListFiles) {
                deleteRecursive(file2);
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    static void mkdir(String str, Promise promise) {
        File file = new File(str);
        if (file.exists()) {
            promise.reject("EEXIST", (file.isDirectory() ? "Folder" : "File") + " '" + str + "' already exists");
            return;
        }
        try {
            if (file.mkdirs()) {
                promise.resolve(true);
            } else {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + str + "'");
            }
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f7 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #6 {Exception -> 0x00f3, blocks: (B:58:0x00ef, B:62:0x00f7), top: B:72:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: cp */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void m1237cp(java.lang.String r6, java.lang.String r7, com.facebook.react.bridge.Callback r8) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.m1237cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    /* JADX INFO: renamed from: mv */
    static void m1240mv(String str, String str2, Callback callback) {
        File file = new File(str);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + str + "` does not exist");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    file.delete();
                    callback.invoke(new Object[0]);
                    return;
                }
            }
        } catch (FileNotFoundException unused) {
            callback.invoke("Source file not found.");
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                RNFetchBlob.RCTContext.getAssets().openFd(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
                return;
            } catch (IOException unused) {
                callback.invoke(false, false);
                return;
            }
        }
        String strNormalizePath = normalizePath(str);
        if (strNormalizePath != null) {
            callback.invoke(Boolean.valueOf(new File(strNormalizePath).exists()), Boolean.valueOf(new File(strNormalizePath).isDirectory()));
            return;
        }
        callback.invoke(false, false);
    }

    /* JADX INFO: renamed from: ls */
    static void m1239ls(String str, Promise promise) {
        try {
            String strNormalizePath = normalizePath(str);
            File file = new File(strNormalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strNormalizePath + "'");
                return;
            }
            if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + strNormalizePath + "'");
                return;
            }
            String[] list = new File(strNormalizePath).list();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            for (String str2 : list) {
                writableArrayCreateArray.pushString(str2);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String strNormalizePath = normalizePath(str);
            File file = new File(strNormalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + strNormalizePath + "' is a directory");
                return;
            }
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + strNormalizePath + "'");
                return;
            }
            int length = (int) file.length();
            int iMin = Math.min(length, i2) - i;
            FileInputStream fileInputStream = new FileInputStream(new File(strNormalizePath));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            int iSkip = (int) fileInputStream.skip(i);
            if (iSkip != i) {
                promise.reject("EUNSPECIFIED", "Skipped " + iSkip + " instead of the specified " + i + " bytes, size is " + length);
                return;
            }
            byte[] bArr = new byte[Data.MAX_DATA_BYTES];
            int i3 = 0;
            while (i3 < iMin) {
                int i4 = fileInputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
                int i5 = iMin - i3;
                if (i4 <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, Math.min(i5, i4));
                i3 += i4;
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            promise.resolve(str2);
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, Callback callback) {
        String strNormalizePath = normalizePath(str);
        AsyncTaskC13511 asyncTaskC13511 = new AsyncTaskC13511(callback);
        String[] strArr = {strNormalizePath};
        if (asyncTaskC13511 instanceof AsyncTask) {
            AsyncTaskInstrumentation.execute(asyncTaskC13511, strArr);
        } else {
            asyncTaskC13511.execute(strArr);
        }
    }

    /* JADX INFO: renamed from: com.RNFetchBlob.RNFetchBlobFS$1 */
    class AsyncTaskC13511 extends AsyncTask<String, Integer, Integer> implements TraceFieldInterface {
        public Trace _nr_trace;
        final /* synthetic */ Callback val$callback;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC13511(Callback callback) {
            this.val$callback = callback;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Integer doInBackground(String[] strArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "RNFetchBlobFS$1#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "RNFetchBlobFS$1#doInBackground", null);
            }
            Integer numDoInBackground2 = doInBackground2(strArr);
            TraceMachine.exitMethod();
            return numDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Integer doInBackground2(String... strArr) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            if (strArr[0] == null) {
                this.val$callback.invoke("the path specified for lstat is either `null` or `undefined`.");
                return 0;
            }
            File file = new File(strArr[0]);
            if (!file.exists()) {
                this.val$callback.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                return 0;
            }
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    writableArrayCreateArray.pushMap(RNFetchBlobFS.statFile(file.getPath() + "/" + str));
                }
            } else {
                writableArrayCreateArray.pushMap(RNFetchBlobFS.statFile(file.getAbsolutePath()));
            }
            this.val$callback.invoke(null, writableArrayCreateArray);
            return 0;
        }
    }

    static void stat(String str, Callback callback) {
        try {
            String strNormalizePath = normalizePath(str);
            WritableMap writableMapStatFile = statFile(strNormalizePath);
            if (writableMapStatFile == null) {
                callback.invoke("failed to stat path `" + strNormalizePath + "` because it does not exist or it is not a folder", null);
            } else {
                callback.invoke(null, writableMapStatFile);
            }
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String strNormalizePath = normalizePath(str);
            WritableMap writableMapCreateMap = Arguments.createMap();
            if (isAsset(strNormalizePath)) {
                String strReplace = strNormalizePath.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor assetFileDescriptorOpenFd = RNFetchBlob.RCTContext.getAssets().openFd(strReplace);
                writableMapCreateMap.putString("filename", strReplace);
                writableMapCreateMap.putString("path", strNormalizePath);
                writableMapCreateMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                writableMapCreateMap.putString("size", String.valueOf(assetFileDescriptorOpenFd.getLength()));
                writableMapCreateMap.putInt("lastModified", 0);
            } else {
                File file = new File(strNormalizePath);
                if (!file.exists()) {
                    return null;
                }
                writableMapCreateMap.putString("filename", file.getName());
                writableMapCreateMap.putString("path", file.getPath());
                writableMapCreateMap.putString("type", file.isDirectory() ? "directory" : "file");
                writableMapCreateMap.putString("size", String.valueOf(file.length()));
                writableMapCreateMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return writableMapCreateMap;
        } catch (Exception unused) {
            return null;
        }
    }

    void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.RNFetchBlob.RNFetchBlobFS.2
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap map = new HashMap();
            map.put("md5", "MD5");
            map.put("sha1", "SHA-1");
            map.put("sha224", "SHA-224");
            map.put("sha256", HashUtil.SHA_256);
            map.put("sha384", "SHA-384");
            map.put("sha512", "SHA-512");
            if (!map.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            File file = new File(str);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + str + "'");
                return;
            }
            MessageDigest messageDigest = MessageDigest.getInstance((String) map.get(str2));
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1048576];
            long length = file.length();
            if (length != 0) {
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        messageDigest.update(bArr, 0, i);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest.digest()) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            promise.resolve(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            File file = new File(str);
            boolean zCreateNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(RNFetchBlobConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int i = fileInputStream.read(bArr); i > 0; i = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else {
                if (!zCreateNewFile) {
                    promise.reject("EEXIST", "File `" + str + "` already exists");
                    return;
                }
                new FileOutputStream(file).write(stringToBytes(str2, str3));
            }
            promise.resolve(str);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            File file = new File(str);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + str + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(str);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX INFO: renamed from: df */
    static void m1238df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        writableMapCreateMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        StatFs statFs2 = new StatFs(reactApplicationContext.getExternalFilesDir(null).getPath());
        writableMapCreateMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
        writableMapCreateMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        callback.invoke(null, writableMapCreateMap);
    }

    /* JADX INFO: renamed from: com.RNFetchBlob.RNFetchBlobFS$3 */
    class AsyncTaskC13533 extends AsyncTask<ReadableArray, Integer, Integer> implements TraceFieldInterface {
        public Trace _nr_trace;
        final /* synthetic */ Callback val$callback;

        @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        AsyncTaskC13533(Callback callback) {
            this.val$callback = callback;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Integer doInBackground(ReadableArray[] readableArrayArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "RNFetchBlobFS$3#doInBackground", null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod(null, "RNFetchBlobFS$3#doInBackground", null);
            }
            Integer numDoInBackground2 = doInBackground2(readableArrayArr);
            TraceMachine.exitMethod();
            return numDoInBackground2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Integer doInBackground2(ReadableArray... readableArrayArr) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < readableArrayArr[0].size(); i++) {
                    String string = readableArrayArr[0].getString(i);
                    File file = new File(string);
                    if (file.exists() && !file.delete()) {
                        arrayList.add(string);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.val$callback.invoke(null, true);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to delete: ");
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        sb.append((String) it2.next()).append(", ");
                    }
                    this.val$callback.invoke(sb.toString());
                }
            } catch (Exception e) {
                this.val$callback.invoke(e.getLocalizedMessage());
            }
            return Integer.valueOf(readableArrayArr[0].size());
        }
    }

    static void removeSession(ReadableArray readableArray, Callback callback) {
        AsyncTaskC13533 asyncTaskC13533 = new AsyncTaskC13533(callback);
        ReadableArray[] readableArrayArr = {readableArray};
        if (asyncTaskC13533 instanceof AsyncTask) {
            AsyncTaskInstrumentation.execute(asyncTaskC13533, readableArrayArr);
        } else {
            asyncTaskC13533.execute(readableArrayArr);
        }
    }

    private static byte[] stringToBytes(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName(StringUtil.US_ASCII));
        }
        if (str2.toLowerCase().contains(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_UTF8)) {
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return str.getBytes(Charset.forName(StringUtil.US_ASCII));
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString("detail", str3);
        this.emitter.emit(str, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putArray("detail", writableArray);
        this.emitter.emit(str, writableMapCreateMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        writableMapCreateMap.putString("code", str3);
        writableMapCreateMap.putString("detail", str4);
        this.emitter.emit(str, writableMapCreateMap);
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return RNFetchBlob.RCTContext.getAssets().open(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }

    private static boolean isPathExists(String str) {
        if (str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
            try {
                RNFetchBlob.RCTContext.getAssets().open(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return new File(str).exists();
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET);
    }

    static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        if (!str.matches("\\w+\\:.*")) {
            return str;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        return str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET) ? str : PathResolver.getRealPathFromURI(RNFetchBlob.RCTContext, Uri.parse(str));
    }
}
