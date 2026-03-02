package com.RNFetchBlob;

import android.net.Uri;
import android.util.Base64;
import androidx.webkit.internal.AssetHelper;
import androidx.work.Data;
import com.RNFetchBlob.RNFetchBlobReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes.dex */
class RNFetchBlobBody extends RequestBody {
    private File bodyCache;
    private ReadableArray form;
    private String mTaskId;
    private MediaType mime;
    private String rawBody;
    private InputStream requestStream;
    private RNFetchBlobReq.RequestType requestType;
    private long contentLength = 0;
    int reported = 0;
    private Boolean chunkedEncoding = false;

    RNFetchBlobBody(String str) {
        this.mTaskId = str;
    }

    RNFetchBlobBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    RNFetchBlobBody setMIME(MediaType mediaType) {
        this.mime = mediaType;
        return this;
    }

    RNFetchBlobBody setRequestType(RNFetchBlobReq.RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    RNFetchBlobBody setBody(String str) {
        this.rawBody = str;
        if (str == null) {
            this.rawBody = "";
            this.requestType = RNFetchBlobReq.RequestType.AsIs;
        }
        try {
            int i = C13501.$SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                this.requestStream = getRequestStream();
                this.contentLength = r3.available();
            } else if (i == 2) {
                this.contentLength = this.rawBody.getBytes().length;
                this.requestStream = new ByteArrayInputStream(this.rawBody.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            RNFetchBlobUtils.emitWarningEvent("RNFetchBlob failed to create single content request body :" + e.getLocalizedMessage() + "\r\n");
        }
        return this;
    }

    /* JADX INFO: renamed from: com.RNFetchBlob.RNFetchBlobBody$1 */
    static /* synthetic */ class C13501 {
        static final /* synthetic */ int[] $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType;

        static {
            int[] iArr = new int[RNFetchBlobReq.RequestType.values().length];
            $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType = iArr;
            try {
                iArr[RNFetchBlobReq.RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[RNFetchBlobReq.RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$RNFetchBlob$RNFetchBlobReq$RequestType[RNFetchBlobReq.RequestType.Others.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    RNFetchBlobBody setBody(ReadableArray readableArray) {
        this.form = readableArray;
        try {
            this.bodyCache = createMultipartBodyCache();
            this.requestStream = new FileInputStream(this.bodyCache);
            this.contentLength = this.bodyCache.length();
        } catch (Exception e) {
            e.printStackTrace();
            RNFetchBlobUtils.emitWarningEvent("RNFetchBlob failed to create request multipart body :" + e.getLocalizedMessage());
        }
        return this;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1L;
        }
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType getContentType() {
        return this.mime;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(this.requestStream, bufferedSink);
        } catch (Exception e) {
            RNFetchBlobUtils.emitWarningEvent(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    boolean clearRequestBody() {
        try {
            File file = this.bodyCache;
            if (file == null || !file.exists()) {
                return true;
            }
            this.bodyCache.delete();
            return true;
        } catch (Exception e) {
            RNFetchBlobUtils.emitWarningEvent(e.getLocalizedMessage());
            return false;
        }
    }

    private InputStream getRequestStream() throws Exception {
        if (this.rawBody.startsWith(RNFetchBlobConst.FILE_PREFIX)) {
            String strNormalizePath = RNFetchBlobFS.normalizePath(this.rawBody.substring(RNFetchBlobConst.FILE_PREFIX.length()));
            if (RNFetchBlobFS.isAsset(strNormalizePath)) {
                try {
                    return RNFetchBlob.RCTContext.getAssets().open(strNormalizePath.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                } catch (Exception e) {
                    throw new Exception("error when getting request stream from asset : " + e.getLocalizedMessage());
                }
            }
            File file = new File(RNFetchBlobFS.normalizePath(strNormalizePath));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                return new FileInputStream(file);
            } catch (Exception e2) {
                throw new Exception("error when getting request stream: " + e2.getLocalizedMessage());
            }
        }
        if (this.rawBody.startsWith(RNFetchBlobConst.CONTENT_PREFIX)) {
            String strSubstring = this.rawBody.substring(RNFetchBlobConst.CONTENT_PREFIX.length());
            try {
                return RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(strSubstring));
            } catch (Exception e3) {
                throw new Exception("error when getting request stream for content URI: " + strSubstring, e3);
            }
        }
        try {
            return new ByteArrayInputStream(Base64.decode(this.rawBody, 0));
        } catch (Exception e4) {
            throw new Exception("error when getting request stream: " + e4.getLocalizedMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0154 A[DONT_GENERATE, PHI: r9
      0x0154: PHI (r9v5 java.io.InputStream) = (r9v4 java.io.InputStream), (r9v6 java.io.InputStream) binds: [B:33:0x017e, B:27:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.File createMultipartBodyCache() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobBody.createMultipartBodyCache():java.io.File");
    }

    private void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr, 0, Data.MAX_DATA_BYTES);
            if (i > 0) {
                bufferedSink.write(bArr, 0, i);
                j += (long) i;
                emitUploadProgress(j);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[Data.MAX_DATA_BYTES];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                fileOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[PHI: r2 r7
      0x00b4: PHI (r2v3 long) = (r2v1 long), (r2v4 long) binds: [B:30:0x00df, B:24:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v10 java.io.InputStream) = (r7v9 java.io.InputStream), (r7v11 java.io.InputStream) binds: [B:30:0x00df, B:24:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.RNFetchBlob.RNFetchBlobBody.FormField> countFormDataLength() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobBody.countFormDataLength():java.util.ArrayList");
    }

    private class FormField {
        public String data;
        String filename;
        String mime;
        public String name;

        FormField(ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? AssetHelper.DEFAULT_MIME_TYPE : "application/octet-stream";
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    private void emitUploadProgress(long j) {
        RNFetchBlobProgressConfig reportUploadProgress = RNFetchBlobReq.getReportUploadProgress(this.mTaskId);
        if (reportUploadProgress != null) {
            long j2 = this.contentLength;
            if (j2 == 0 || !reportUploadProgress.shouldReport(j / j2)) {
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, this.mTaskId);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(this.contentLength));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_UPLOAD_PROGRESS, writableMapCreateMap);
        }
    }
}
