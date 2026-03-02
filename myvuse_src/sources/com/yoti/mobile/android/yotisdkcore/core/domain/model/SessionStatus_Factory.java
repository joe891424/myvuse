package com.yoti.mobile.android.yotisdkcore.core.domain.model;

import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionStatus_Factory implements Factory<SessionStatus> {
    private final Provider<ISessionStatusRepository> repositoryProvider;

    public SessionStatus_Factory(Provider<ISessionStatusRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static SessionStatus_Factory create(Provider<ISessionStatusRepository> provider) {
        return new SessionStatus_Factory(provider);
    }

    public static SessionStatus newInstance(ISessionStatusRepository iSessionStatusRepository) {
        return new SessionStatus(iSessionStatusRepository);
    }

    @Override // javax.inject.Provider
    public SessionStatus get() {
        return newInstance(this.repositoryProvider.get());
    }
}
