package com.microblink.activity.result;

import android.content.Intent;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes2.dex */
public class ScanResult {
    private Intent IlIllIlIIl;
    private Throwable IllIIIllII;
    private ResultStatus llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    public enum ResultStatus {
        FINISHED,
        CANCELLED,
        EXCEPTION
    }

    public ScanResult(ResultStatus resultStatus, Intent intent, Throwable th) {
        this.llIIlIlIIl = resultStatus;
        this.IlIllIlIIl = intent;
        this.IllIIIllII = th;
    }

    public Intent getData() {
        return this.IlIllIlIIl;
    }

    public Throwable getException() {
        return this.IllIIIllII;
    }

    public ResultStatus getResultStatus() {
        return this.llIIlIlIIl;
    }
}
