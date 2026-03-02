package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> implements TraceFieldInterface {
    public Trace _nr_trace;
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private UploadParams mParams;
    private UploadResult res;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ UploadResult doInBackground(UploadParams[] uploadParamsArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "Uploader#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "Uploader#doInBackground", null);
        }
        UploadResult uploadResultDoInBackground2 = doInBackground2(uploadParamsArr);
        TraceMachine.exitMethod();
        return uploadResultDoInBackground2;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected UploadResult doInBackground2(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Uploader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0382  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void upload(com.rnfs.UploadParams r37, com.rnfs.UploadResult r38) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.upload(com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    protected String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    protected void stop() {
        this.mAbort.set(true);
    }
}
