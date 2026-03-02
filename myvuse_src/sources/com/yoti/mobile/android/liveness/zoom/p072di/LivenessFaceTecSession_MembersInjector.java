package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessFaceTecSession_MembersInjector implements MembersInjector<LivenessFaceTecSession> {
    private final Provider<LivenessCoreSession> coreSessionProvider;

    public LivenessFaceTecSession_MembersInjector(Provider<LivenessCoreSession> provider) {
        this.coreSessionProvider = provider;
    }

    public static MembersInjector<LivenessFaceTecSession> create(Provider<LivenessCoreSession> provider) {
        return new LivenessFaceTecSession_MembersInjector(provider);
    }

    public static void injectCoreSession(LivenessFaceTecSession livenessFaceTecSession, LivenessCoreSession livenessCoreSession) {
        livenessFaceTecSession.coreSession = livenessCoreSession;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LivenessFaceTecSession livenessFaceTecSession) {
        injectCoreSession(livenessFaceTecSession, this.coreSessionProvider.get());
    }
}
