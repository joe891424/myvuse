package com.yoti.mobile.android.yotidocs.common.p079di.schedulers;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/di/schedulers/CoroutineContextModule;", "", "()V", "computationCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "ioCoroutineContext", "mainThreadCoroutineContext", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public final class CoroutineContextModule {
    public static final CoroutineContextModule INSTANCE = new CoroutineContextModule();

    private CoroutineContextModule() {
    }

    @Provides
    @ForComputation
    public final CoroutineContext computationCoroutineContext() {
        return Dispatchers.getDefault();
    }

    @ForIo
    @Provides
    public final CoroutineContext ioCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Provides
    @ForMainThread
    public final CoroutineContext mainThreadCoroutineContext() {
        return Dispatchers.getMain();
    }
}
