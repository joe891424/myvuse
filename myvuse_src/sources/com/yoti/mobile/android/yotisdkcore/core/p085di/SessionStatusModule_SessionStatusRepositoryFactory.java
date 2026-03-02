package com.yoti.mobile.android.yotisdkcore.core.p085di;

import com.yoti.mobile.android.yotisdkcore.core.data.SessionStatusRepository;
import com.yoti.mobile.android.yotisdkcore.core.domain.ISessionStatusRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionStatusModule_SessionStatusRepositoryFactory implements Factory<ISessionStatusRepository> {
    private final SessionStatusModule module;
    private final Provider<SessionStatusRepository> repositoryProvider;

    public SessionStatusModule_SessionStatusRepositoryFactory(SessionStatusModule sessionStatusModule, Provider<SessionStatusRepository> provider) {
        this.module = sessionStatusModule;
        this.repositoryProvider = provider;
    }

    public static SessionStatusModule_SessionStatusRepositoryFactory create(SessionStatusModule sessionStatusModule, Provider<SessionStatusRepository> provider) {
        return new SessionStatusModule_SessionStatusRepositoryFactory(sessionStatusModule, provider);
    }

    public static ISessionStatusRepository sessionStatusRepository(SessionStatusModule sessionStatusModule, SessionStatusRepository sessionStatusRepository) {
        return (ISessionStatusRepository) Preconditions.checkNotNullFromProvides(sessionStatusModule.sessionStatusRepository(sessionStatusRepository));
    }

    @Override // javax.inject.Provider
    public ISessionStatusRepository get() {
        return sessionStatusRepository(this.module, this.repositoryProvider.get());
    }
}
