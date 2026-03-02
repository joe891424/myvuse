package com.yoti.mobile.android.yotidocs.common.debug;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugPreferencesFactory_Factory implements Factory<DebugPreferencesFactory> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.debug.DebugPreferencesFactory_Factory$a */
    private static final class C4952a {

        /* JADX INFO: renamed from: a */
        private static final DebugPreferencesFactory_Factory f7475a = new DebugPreferencesFactory_Factory();
    }

    public static DebugPreferencesFactory_Factory create() {
        return C4952a.f7475a;
    }

    public static DebugPreferencesFactory newInstance() {
        return new DebugPreferencesFactory();
    }

    @Override // javax.inject.Provider
    public DebugPreferencesFactory get() {
        return newInstance();
    }
}
