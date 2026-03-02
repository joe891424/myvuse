package com.salesforce.marketingcloud;

import android.app.PendingIntent;
import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes6.dex */
public interface UrlHandler {
    public static final String ACTION = "action";

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.UrlHandler$a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC4090a {
    }

    PendingIntent handleUrl(Context context, String str, String str2);
}
