package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineContextModule_MainThreadCoroutineContextFactory implements Factory<CoroutineContext> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.di.schedulers.CoroutineContextModule_MainThreadCoroutineContextFactory$a */
    private static final class C4955a {

        /* JADX INFO: renamed from: a */
        private static final CoroutineContextModule_MainThreadCoroutineContextFactory f7480a = new CoroutineContextModule_MainThreadCoroutineContextFactory();
    }

    public static CoroutineContextModule_MainThreadCoroutineContextFactory create() {
        return C4955a.f7480a;
    }

    public static CoroutineContext mainThreadCoroutineContext() {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(CoroutineContextModule.INSTANCE.mainThreadCoroutineContext());
    }

    @Override // javax.inject.Provider
    public CoroutineContext get() {
        return mainThreadCoroutineContext();
    }
}
