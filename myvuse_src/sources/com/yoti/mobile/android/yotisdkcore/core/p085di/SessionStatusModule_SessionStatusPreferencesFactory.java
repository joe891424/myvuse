package com.yoti.mobile.android.yotisdkcore.core.p085di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionStatusModule_SessionStatusPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> applicationContextProvider;
    private final SessionStatusModule module;

    public SessionStatusModule_SessionStatusPreferencesFactory(SessionStatusModule sessionStatusModule, Provider<Context> provider) {
        this.module = sessionStatusModule;
        this.applicationContextProvider = provider;
    }

    public static SessionStatusModule_SessionStatusPreferencesFactory create(SessionStatusModule sessionStatusModule, Provider<Context> provider) {
        return new SessionStatusModule_SessionStatusPreferencesFactory(sessionStatusModule, provider);
    }

    public static SharedPreferences sessionStatusPreferences(SessionStatusModule sessionStatusModule, Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(sessionStatusModule.sessionStatusPreferences(context));
    }

    @Override // javax.inject.Provider
    public SharedPreferences get() {
        return sessionStatusPreferences(this.module, this.applicationContextProvider.get());
    }
}
