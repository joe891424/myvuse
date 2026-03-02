package com.yoti.mobile.android.mrtd.domain;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdGetReadEventsUseCase_Factory implements Factory<MrtdGetReadEventsUseCase> {
    private final Provider<INfcReadController> controllerProvider;
    private final Provider<MrtdErrorHandler> errorHandlerProvider;

    public MrtdGetReadEventsUseCase_Factory(Provider<INfcReadController> provider, Provider<MrtdErrorHandler> provider2) {
        this.controllerProvider = provider;
        this.errorHandlerProvider = provider2;
    }

    public static MrtdGetReadEventsUseCase_Factory create(Provider<INfcReadController> provider, Provider<MrtdErrorHandler> provider2) {
        return new MrtdGetReadEventsUseCase_Factory(provider, provider2);
    }

    public static MrtdGetReadEventsUseCase newInstance(INfcReadController iNfcReadController, MrtdErrorHandler mrtdErrorHandler) {
        return new MrtdGetReadEventsUseCase(iNfcReadController, mrtdErrorHandler);
    }

    @Override // javax.inject.Provider
    public MrtdGetReadEventsUseCase get() {
        return newInstance(this.controllerProvider.get(), this.errorHandlerProvider.get());
    }
}
