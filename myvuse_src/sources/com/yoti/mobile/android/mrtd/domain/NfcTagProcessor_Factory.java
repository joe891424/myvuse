package com.yoti.mobile.android.mrtd.domain;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class NfcTagProcessor_Factory implements Factory<NfcTagProcessor> {
    private final Provider<LocalBroadcastManager> broadcastManagerProvider;

    public NfcTagProcessor_Factory(Provider<LocalBroadcastManager> provider) {
        this.broadcastManagerProvider = provider;
    }

    public static NfcTagProcessor_Factory create(Provider<LocalBroadcastManager> provider) {
        return new NfcTagProcessor_Factory(provider);
    }

    public static NfcTagProcessor newInstance(LocalBroadcastManager localBroadcastManager) {
        return new NfcTagProcessor(localBroadcastManager);
    }

    @Override // javax.inject.Provider
    public NfcTagProcessor get() {
        return newInstance(this.broadcastManagerProvider.get());
    }
}
