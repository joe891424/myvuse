package com.yoti.mobile.android.yotisdkcore.core;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionStatusProvider_Factory implements Factory<SessionStatusProvider> {
    private final Provider<SessionStatus> sessionStatusProvider;

    public SessionStatusProvider_Factory(Provider<SessionStatus> provider) {
        this.sessionStatusProvider = provider;
    }

    public static SessionStatusProvider_Factory create(Provider<SessionStatus> provider) {
        return new SessionStatusProvider_Factory(provider);
    }

    public static SessionStatusProvider newInstance(SessionStatus sessionStatus) {
        return new SessionStatusProvider(sessionStatus);
    }

    @Override // javax.inject.Provider
    public SessionStatusProvider get() {
        return newInstance(this.sessionStatusProvider.get());
    }
}
