package com.yoti.mobile.android.yotidocs.common.p079di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonModule_ApplicationContextFactory implements Factory<Context> {

    /* JADX INFO: renamed from: a */
    private final CommonModule f7477a;

    public CommonModule_ApplicationContextFactory(CommonModule commonModule) {
        this.f7477a = commonModule;
    }

    public static Context applicationContext(CommonModule commonModule) {
        return (Context) Preconditions.checkNotNullFromProvides(commonModule.getF7476a());
    }

    public static CommonModule_ApplicationContextFactory create(CommonModule commonModule) {
        return new CommonModule_ApplicationContextFactory(commonModule);
    }

    @Override // javax.inject.Provider
    public Context get() {
        return applicationContext(this.f7477a);
    }
}
