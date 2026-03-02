package com.yoti.mobile.android.common.p049ui.widgets.utils;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: classes5.dex */
public class AccessibilityInformationProvider {
    public boolean isAccessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }
}
