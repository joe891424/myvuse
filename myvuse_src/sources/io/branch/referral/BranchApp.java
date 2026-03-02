package io.branch.referral;

import android.app.Application;

/* JADX INFO: loaded from: classes4.dex */
public class BranchApp extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Branch.getAutoInstance(this);
    }
}
