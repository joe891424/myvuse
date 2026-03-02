package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.remote.model.Session;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.CaptureCameraProperties;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.UiSessionProperties;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessResourceConfigEntityToViewDataMapper_Factory implements Factory<LivenessResourceConfigEntityToViewDataMapper> {

    /* JADX INFO: renamed from: a */
    private final Provider<Session> f7765a;

    /* JADX INFO: renamed from: b */
    private final Provider<CaptureCameraProperties> f7766b;

    /* JADX INFO: renamed from: c */
    private final Provider<UiSessionProperties> f7767c;

    public LivenessResourceConfigEntityToViewDataMapper_Factory(Provider<Session> provider, Provider<CaptureCameraProperties> provider2, Provider<UiSessionProperties> provider3) {
        this.f7765a = provider;
        this.f7766b = provider2;
        this.f7767c = provider3;
    }

    public static LivenessResourceConfigEntityToViewDataMapper_Factory create(Provider<Session> provider, Provider<CaptureCameraProperties> provider2, Provider<UiSessionProperties> provider3) {
        return new LivenessResourceConfigEntityToViewDataMapper_Factory(provider, provider2, provider3);
    }

    public static LivenessResourceConfigEntityToViewDataMapper newInstance(Session session, CaptureCameraProperties captureCameraProperties, UiSessionProperties uiSessionProperties) {
        return new LivenessResourceConfigEntityToViewDataMapper(session, captureCameraProperties, uiSessionProperties);
    }

    @Override // javax.inject.Provider
    public LivenessResourceConfigEntityToViewDataMapper get() {
        return newInstance(this.f7765a.get(), this.f7766b.get(), this.f7767c.get());
    }
}
