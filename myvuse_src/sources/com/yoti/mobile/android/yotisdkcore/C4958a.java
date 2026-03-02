package com.yoti.mobile.android.yotisdkcore;

import com.yoti.mobile.android.yotisdkcore.core.SessionStatusProvider;
import com.yoti.mobile.android.yotisdkcore.stepTracker.launcher.StepTrackerLauncher;
import dagger.MembersInjector;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.a */
/* JADX INFO: loaded from: classes4.dex */
public final class C4958a implements MembersInjector<YotiSdk> {
    /* JADX INFO: renamed from: a */
    public static void m5091a(YotiSdk yotiSdk, SessionStatusProvider sessionStatusProvider) {
        yotiSdk.sessionStatusProvider = sessionStatusProvider;
    }

    /* JADX INFO: renamed from: a */
    public static void m5092a(YotiSdk yotiSdk, StepTrackerLauncher stepTrackerLauncher) {
        yotiSdk.stepTrackerLauncher = stepTrackerLauncher;
    }
}
