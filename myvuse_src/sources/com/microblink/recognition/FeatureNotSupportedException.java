package com.microblink.recognition;

import com.microblink.view.NotSupportedReason;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class FeatureNotSupportedException extends Exception {
    private NotSupportedReason llIIlIlIIl;

    public FeatureNotSupportedException(NotSupportedReason notSupportedReason) {
        super(notSupportedReason.getDescription());
        this.llIIlIlIIl = notSupportedReason;
    }

    public NotSupportedReason getReason() {
        return this.llIIlIlIIl;
    }

    public FeatureNotSupportedException(NotSupportedReason notSupportedReason, Throwable th) {
        super(notSupportedReason.getDescription(), th);
        this.llIIlIlIIl = notSupportedReason;
    }
}
