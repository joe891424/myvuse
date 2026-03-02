package com.rnfs;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.rnfs.DownloadParams;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> implements TraceFieldInterface {
    public Trace _nr_trace;
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private DownloadParams mParam;
    DownloadResult res;

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    protected void onPostExecute(Exception exc) {
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ DownloadResult doInBackground(DownloadParams[] downloadParamsArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "Downloader#doInBackground", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "Downloader#doInBackground", null);
        }
        DownloadResult downloadResultDoInBackground2 = doInBackground2(downloadParamsArr);
        TraceMachine.exitMethod();
        return downloadResultDoInBackground2;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected DownloadResult doInBackground2(DownloadParams... downloadParamsArr) {
        this.mParam = downloadParamsArr[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Downloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Downloader downloader = Downloader.this;
                    downloader.download(downloader.mParam, Downloader.this.res);
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                } catch (Exception e) {
                    Downloader.this.res.exception = e;
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0235  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void download(com.rnfs.DownloadParams r31, com.rnfs.DownloadResult r32) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Downloader.download(com.rnfs.DownloadParams, com.rnfs.DownloadResult):void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getContentLengthLong();
    }

    protected void stop() {
        this.mAbort.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(long[]... jArr) {
        super.onProgressUpdate((Object[]) jArr);
        if (this.mParam.onDownloadProgress != null) {
            DownloadParams.OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
            long[] jArr2 = jArr[0];
            onDownloadProgress.onDownloadProgress(jArr2[0], jArr2[1]);
        }
    }
}
