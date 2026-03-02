package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineContextModule_IoCoroutineContextFactory implements Factory<CoroutineContext> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.di.schedulers.CoroutineContextModule_IoCoroutineContextFactory$a */
    private static final class C4954a {

        /* JADX INFO: renamed from: a */
        private static final CoroutineContextModule_IoCoroutineContextFactory f7479a = new CoroutineContextModule_IoCoroutineContextFactory();
    }

    public static CoroutineContextModule_IoCoroutineContextFactory create() {
        return C4954a.f7479a;
    }

    public static CoroutineContext ioCoroutineContext() {
        return (CoroutineContext) Preconditions.checkNotNullFromProvides(CoroutineContextModule.INSTANCE.ioCoroutineContext());
    }

    @Override // javax.inject.Provider
    public CoroutineContext get() {
        return ioCoroutineContext();
    }
}
