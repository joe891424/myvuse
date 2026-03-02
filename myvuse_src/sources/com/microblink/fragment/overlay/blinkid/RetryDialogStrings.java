package com.microblink.fragment.overlay.blinkid;

import android.content.Context;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class RetryDialogStrings {
    public final String message;
    public final String retryButton;
    public final String title;

    public RetryDialogStrings(String str, String str2, String str3) {
        this.title = str;
        this.message = str2;
        this.retryButton = str3;
    }

    public RetryDialogStrings(Context context, int i, int i2, int i3) {
        this.title = context.getString(i);
        this.message = context.getString(i2);
        this.retryButton = context.getString(i3);
    }
}
