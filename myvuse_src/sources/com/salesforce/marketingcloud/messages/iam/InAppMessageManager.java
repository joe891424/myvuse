package com.salesforce.marketingcloud.messages.iam;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes6.dex */
public interface InAppMessageManager {

    public interface EventListener {
        void didCloseMessage(InAppMessage inAppMessage);

        void didShowMessage(InAppMessage inAppMessage);

        boolean shouldShowMessage(InAppMessage inAppMessage);
    }

    void setInAppMessageListener(EventListener eventListener);

    void setStatusBarColor(int i);

    void setTypeface(Typeface typeface);

    void showMessage(String str);
}
