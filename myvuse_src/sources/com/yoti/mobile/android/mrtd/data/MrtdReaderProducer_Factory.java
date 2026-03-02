package com.yoti.mobile.android.mrtd.data;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdReaderProducer_Factory implements Factory<MrtdReaderProducer> {
    private final Provider<LocalBroadcastManager> broadcastManagerProvider;
    private final Provider<MrtdControllerFactory> controllerFactoryProvider;
    private final Provider<ReaderQueueFactory> queueFactoryProvider;
    private final Provider<MrtdReaderFactory> readerFactoryProvider;

    public MrtdReaderProducer_Factory(Provider<LocalBroadcastManager> provider, Provider<ReaderQueueFactory> provider2, Provider<MrtdControllerFactory> provider3, Provider<MrtdReaderFactory> provider4) {
        this.broadcastManagerProvider = provider;
        this.queueFactoryProvider = provider2;
        this.controllerFactoryProvider = provider3;
        this.readerFactoryProvider = provider4;
    }

    public static MrtdReaderProducer_Factory create(Provider<LocalBroadcastManager> provider, Provider<ReaderQueueFactory> provider2, Provider<MrtdControllerFactory> provider3, Provider<MrtdReaderFactory> provider4) {
        return new MrtdReaderProducer_Factory(provider, provider2, provider3, provider4);
    }

    public static MrtdReaderProducer newInstance(LocalBroadcastManager localBroadcastManager, ReaderQueueFactory readerQueueFactory, MrtdControllerFactory mrtdControllerFactory, MrtdReaderFactory mrtdReaderFactory) {
        return new MrtdReaderProducer(localBroadcastManager, readerQueueFactory, mrtdControllerFactory, mrtdReaderFactory);
    }

    @Override // javax.inject.Provider
    public MrtdReaderProducer get() {
        return newInstance(this.broadcastManagerProvider.get(), this.queueFactoryProvider.get(), this.controllerFactoryProvider.get(), this.readerFactoryProvider.get());
    }
}
