package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineContextModule_ComputationCoroutineContextFactory implements Factory<CoroutineContext> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.di.schedulers.CoroutineContextModule_ComputationCoroutineContextFactory$a */
    private static final class C4953a {

        /* JADX INFO: renamed from: a */
        private static final CoroutineContextModule_ComputationCoroutineContextFactory f7478a = new CoroutineContextModule_ComputationCoroutineContextFactory();
    }

    public static CoroutineContext computationCoroutineContext() {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(CoroutineContextModule.INSTANCE.computationCoroutineContext());
    }

    public static CoroutineContextModule_ComputationCoroutineContextFactory create() {
        return C4953a.f7478a;
    }

    @Override // javax.inject.Provider
    public CoroutineContext get() {
        return computationCoroutineContext();
    }
}
