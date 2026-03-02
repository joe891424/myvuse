package com.yoti.mobile.android.mrtd.p073di;

import android.content.Context;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class MrtdCaptureModule_ProvideBroadcastManagerFactory implements Factory<LocalBroadcastManager> {
    private final Provider<Context> contextProvider;
    private final MrtdCaptureModule module;

    public MrtdCaptureModule_ProvideBroadcastManagerFactory(MrtdCaptureModule mrtdCaptureModule, Provider<Context> provider) {
        this.module = mrtdCaptureModule;
        this.contextProvider = provider;
    }

    public static MrtdCaptureModule_ProvideBroadcastManagerFactory create(MrtdCaptureModule mrtdCaptureModule, Provider<Context> provider) {
        return new MrtdCaptureModule_ProvideBroadcastManagerFactory(mrtdCaptureModule, provider);
    }

    public static LocalBroadcastManager provideBroadcastManager(MrtdCaptureModule mrtdCaptureModule, Context context) {
        return (LocalBroadcastManager) Preconditions.checkNotNullFromProvides(mrtdCaptureModule.provideBroadcastManager(context));
    }

    @Override // javax.inject.Provider
    public LocalBroadcastManager get() {
        return provideBroadcastManager(this.module, this.contextProvider.get());
    }
}
