package com.RNFetchBlob.Response;

import com.RNFetchBlob.RNFetchBlobConst;
import com.RNFetchBlob.RNFetchBlobProgressConfig;
import com.RNFetchBlob.RNFetchBlobReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetchConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes.dex */
public class RNFetchBlobFileResp extends ResponseBody {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesDownloaded = 0;
    boolean isEndMarkerReceived = false;
    String mPath;
    String mTaskId;
    FileOutputStream ofStream;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public RNFetchBlobFileResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, String str2, boolean z) throws IOException {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.mPath = str2;
        if (str2 != null) {
            boolean z2 = !z;
            String strReplace = str2.replace("?append=true", "");
            this.mPath = strReplace;
            File file = new File(strReplace);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parentFile);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            this.ofStream = new FileOutputStream(new File(strReplace), z2);
        }
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.originalBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.originalBody.getContentLength();
    }

    public boolean isDownloadComplete() {
        return this.bytesDownloaded == getContentLength() || (getContentLength() == -1 && this.isEndMarkerReceived);
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getSource() {
        return Okio.buffer(new ProgressReportingSource());
    }

    private class ProgressReportingSource implements Source {
        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public Timeout getTimeout() {
            return null;
        }

        private ProgressReportingSource() {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            int i = (int) j;
            try {
                byte[] bArr = new byte[i];
                long j2 = RNFetchBlobFileResp.this.originalBody.byteStream().read(bArr, 0, i);
                RNFetchBlobFileResp.this.bytesDownloaded += j2 > 0 ? j2 : 0L;
                if (j2 > 0) {
                    RNFetchBlobFileResp.this.ofStream.write(bArr, 0, (int) j2);
                } else if (RNFetchBlobFileResp.this.getContentLength() == -1 && j2 == -1) {
                    RNFetchBlobFileResp.this.isEndMarkerReceived = true;
                }
                RNFetchBlobProgressConfig reportProgress = RNFetchBlobReq.getReportProgress(RNFetchBlobFileResp.this.mTaskId);
                if (RNFetchBlobFileResp.this.getContentLength() != 0) {
                    float contentLength = RNFetchBlobFileResp.this.getContentLength() != -1 ? RNFetchBlobFileResp.this.bytesDownloaded / RNFetchBlobFileResp.this.getContentLength() : RNFetchBlobFileResp.this.isEndMarkerReceived ? 1.0f : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(contentLength)) {
                        if (RNFetchBlobFileResp.this.getContentLength() != -1) {
                            reportProgress(RNFetchBlobFileResp.this.mTaskId, RNFetchBlobFileResp.this.bytesDownloaded, RNFetchBlobFileResp.this.getContentLength());
                        } else if (!RNFetchBlobFileResp.this.isEndMarkerReceived) {
                            reportProgress(RNFetchBlobFileResp.this.mTaskId, 0L, RNFetchBlobFileResp.this.getContentLength());
                        } else {
                            reportProgress(RNFetchBlobFileResp.this.mTaskId, RNFetchBlobFileResp.this.bytesDownloaded, RNFetchBlobFileResp.this.bytesDownloaded);
                        }
                    }
                }
                return j2;
            } catch (Exception unused) {
                return -1L;
            }
        }

        private void reportProgress(String str, long j, long j2) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(BackgroundFetchConfig.FIELD_TASK_ID, str);
            writableMapCreateMap.putString("written", String.valueOf(j));
            writableMapCreateMap.putString("total", String.valueOf(j2));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) RNFetchBlobFileResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_PROGRESS, writableMapCreateMap);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RNFetchBlobFileResp.this.ofStream.close();
        }
    }
}
