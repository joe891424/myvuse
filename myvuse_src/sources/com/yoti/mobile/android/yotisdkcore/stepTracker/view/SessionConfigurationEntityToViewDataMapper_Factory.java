package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionConfigurationEntityToViewDataMapper_Factory implements Factory<SessionConfigurationEntityToViewDataMapper> {

    /* JADX INFO: renamed from: a */
    private final Provider<DocumentResourceConfigEntityToViewDataMapper> f7768a;

    /* JADX INFO: renamed from: b */
    private final Provider<LivenessResourceConfigEntityToViewDataMapper> f7769b;

    public SessionConfigurationEntityToViewDataMapper_Factory(Provider<DocumentResourceConfigEntityToViewDataMapper> provider, Provider<LivenessResourceConfigEntityToViewDataMapper> provider2) {
        this.f7768a = provider;
        this.f7769b = provider2;
    }

    public static SessionConfigurationEntityToViewDataMapper_Factory create(Provider<DocumentResourceConfigEntityToViewDataMapper> provider, Provider<LivenessResourceConfigEntityToViewDataMapper> provider2) {
        return new SessionConfigurationEntityToViewDataMapper_Factory(provider, provider2);
    }

    public static SessionConfigurationEntityToViewDataMapper newInstance(DocumentResourceConfigEntityToViewDataMapper documentResourceConfigEntityToViewDataMapper, LivenessResourceConfigEntityToViewDataMapper livenessResourceConfigEntityToViewDataMapper) {
        return new SessionConfigurationEntityToViewDataMapper(documentResourceConfigEntityToViewDataMapper, livenessResourceConfigEntityToViewDataMapper);
    }

    @Override // javax.inject.Provider
    public SessionConfigurationEntityToViewDataMapper get() {
        return newInstance(this.f7768a.get(), this.f7769b.get());
    }
}
