package com.yoti.mobile.android.yotisdkcore.core.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class FeatureLauncherFactory_Factory implements Factory<FeatureLauncherFactory> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.core.view.FeatureLauncherFactory_Factory$a */
    private static final class C4983a {

        /* JADX INFO: renamed from: a */
        private static final FeatureLauncherFactory_Factory f7609a = new FeatureLauncherFactory_Factory();
    }

    public static FeatureLauncherFactory_Factory create() {
        return C4983a.f7609a;
    }

    public static FeatureLauncherFactory newInstance() {
        return new FeatureLauncherFactory();
    }

    @Override // javax.inject.Provider
    public FeatureLauncherFactory get() {
        return newInstance();
    }
}
