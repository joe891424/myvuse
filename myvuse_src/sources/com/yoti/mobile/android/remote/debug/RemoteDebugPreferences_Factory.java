package com.yoti.mobile.android.remote.debug;

import com.yoti.mobile.android.yotidocs.common.debug.DebugPreferencesFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteDebugPreferences_Factory implements Factory<RemoteDebugPreferences> {
    private final Provider<DebugPreferencesFactory> debugPreferencesFactoryProvider;

    public RemoteDebugPreferences_Factory(Provider<DebugPreferencesFactory> provider) {
        this.debugPreferencesFactoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public RemoteDebugPreferences get() {
        return newInstance(this.debugPreferencesFactoryProvider.get());
    }

    public static RemoteDebugPreferences_Factory create(Provider<DebugPreferencesFactory> provider) {
        return new RemoteDebugPreferences_Factory(provider);
    }

    public static RemoteDebugPreferences newInstance(DebugPreferencesFactory debugPreferencesFactory) {
        return new RemoteDebugPreferences(debugPreferencesFactory);
    }
}
