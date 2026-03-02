package com.salesforce.marketingcloud.messages.iam;

import android.graphics.Typeface;
import com.salesforce.marketingcloud.UrlHandler;
import com.salesforce.marketingcloud.media.C4217o;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.iam.i */
/* JADX INFO: loaded from: classes6.dex */
interface InterfaceC4258i {
    boolean canDisplay(InAppMessage inAppMessage);

    int getStatusBarColor();

    Typeface getTypeface();

    void handleMessageFinished(InAppMessage inAppMessage, C4259j c4259j);

    C4217o imageHandler();

    UrlHandler urlHandler();
}
