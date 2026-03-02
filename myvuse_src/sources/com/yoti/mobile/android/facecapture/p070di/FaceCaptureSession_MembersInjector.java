package com.yoti.mobile.android.facecapture.p070di;

import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureSession_MembersInjector implements MembersInjector<FaceCaptureSession> {
    private final Provider<LivenessCoreSession> coreSessionProvider;

    public FaceCaptureSession_MembersInjector(Provider<LivenessCoreSession> provider) {
        this.coreSessionProvider = provider;
    }

    public static MembersInjector<FaceCaptureSession> create(Provider<LivenessCoreSession> provider) {
        return new FaceCaptureSession_MembersInjector(provider);
    }

    public static void injectCoreSession(FaceCaptureSession faceCaptureSession, LivenessCoreSession livenessCoreSession) {
        faceCaptureSession.coreSession = livenessCoreSession;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FaceCaptureSession faceCaptureSession) {
        injectCoreSession(faceCaptureSession, this.coreSessionProvider.get());
    }
}
