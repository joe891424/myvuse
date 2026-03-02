package com.qualtrics.digital;

/* JADX INFO: loaded from: classes6.dex */
public class InitializationResult {
    private String mMessage;
    private Boolean mResult;

    InitializationResult(Boolean bool, String str) {
        this.mResult = bool;
        this.mMessage = str;
    }

    public boolean passed() {
        return this.mResult.booleanValue();
    }

    public String getMessage() {
        return this.mMessage;
    }
}
