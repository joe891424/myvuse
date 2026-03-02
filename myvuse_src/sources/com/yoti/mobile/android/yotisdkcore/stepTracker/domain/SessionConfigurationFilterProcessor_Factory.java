package com.yoti.mobile.android.yotisdkcore.stepTracker.domain;

import com.yoti.mobile.android.yotisdkcore.stepTracker.domain.SessionConfigurationFilterProcessor;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationFilterProcessor_Factory implements Factory<SessionConfigurationFilterProcessor> {

    /* JADX INFO: renamed from: a */
    private final Provider<SessionConfigurationFilterProcessor.a> f7683a;

    public SessionConfigurationFilterProcessor_Factory(Provider<SessionConfigurationFilterProcessor.a> provider) {
        this.f7683a = provider;
    }

    public static SessionConfigurationFilterProcessor_Factory create(Provider<SessionConfigurationFilterProcessor.a> provider) {
        return new SessionConfigurationFilterProcessor_Factory(provider);
    }

    public static SessionConfigurationFilterProcessor newInstance(SessionConfigurationFilterProcessor.a aVar) {
        return new SessionConfigurationFilterProcessor(aVar);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationFilterProcessor get() {
        return newInstance(this.f7683a.get());
    }
}
