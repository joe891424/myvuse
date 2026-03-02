package com.reactnativenavigation.views.sidemenu;

import android.content.Context;
import androidx.drawerlayout.widget.DrawerLayout;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import com.reactnativenavigation.utils.LogKt;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenu extends DrawerLayout {
    public SideMenu(Context context) {
        super(context);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void openDrawer(int i, boolean z) {
        try {
            super.openDrawer(i, z);
        } catch (IllegalArgumentException unused) {
            LogInstrumentation.m2734w(LogKt.MAIN_LIB_TAG, "Tried to open sideMenu, but it's not defined");
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout
    public void setDrawerLockMode(int i, int i2) {
        if (getDrawerLockMode(i2) != i) {
            super.setDrawerLockMode(i, i2);
        }
    }
}
