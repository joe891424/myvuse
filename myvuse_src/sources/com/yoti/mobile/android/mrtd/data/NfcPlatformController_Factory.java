package com.yoti.mobile.android.mrtd.data;

import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcPlatformController_Factory implements Factory<NfcPlatformController> {
    private final Provider<NfcEventMapper> eventMapperProvider;
    private final Provider<MrtdAuthentication> nfcAuthenticationProvider;
    private final Provider<MrtdReaderProducer> readerProducerProvider;

    public NfcPlatformController_Factory(Provider<MrtdAuthentication> provider, Provider<MrtdReaderProducer> provider2, Provider<NfcEventMapper> provider3) {
        this.nfcAuthenticationProvider = provider;
        this.readerProducerProvider = provider2;
        this.eventMapperProvider = provider3;
    }

    public static NfcPlatformController_Factory create(Provider<MrtdAuthentication> provider, Provider<MrtdReaderProducer> provider2, Provider<NfcEventMapper> provider3) {
        return new NfcPlatformController_Factory(provider, provider2, provider3);
    }

    public static NfcPlatformController newInstance(MrtdAuthentication mrtdAuthentication, MrtdReaderProducer mrtdReaderProducer, NfcEventMapper nfcEventMapper) {
        return new NfcPlatformController(mrtdAuthentication, mrtdReaderProducer, nfcEventMapper);
    }

    @Override // javax.inject.Provider
    public NfcPlatformController get() {
        return newInstance(this.nfcAuthenticationProvider.get(), this.readerProducerProvider.get(), this.eventMapperProvider.get());
    }
}
