package com.yoti.mobile.android.yotisdkcore.stepTracker.data;

import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.stepTracker.data.remote.DeleteSessionTokenService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionTokenRepository_Factory implements Factory<SessionTokenRepository> {

    /* JADX INFO: renamed from: a */
    private final Provider<DeleteSessionTokenService> f7620a;

    /* JADX INFO: renamed from: b */
    private final Provider<RemoteExceptionToEntityMapper> f7621b;

    public SessionTokenRepository_Factory(Provider<DeleteSessionTokenService> provider, Provider<RemoteExceptionToEntityMapper> provider2) {
        this.f7620a = provider;
        this.f7621b = provider2;
    }

    public static SessionTokenRepository_Factory create(Provider<DeleteSessionTokenService> provider, Provider<RemoteExceptionToEntityMapper> provider2) {
        return new SessionTokenRepository_Factory(provider, provider2);
    }

    public static SessionTokenRepository newInstance(DeleteSessionTokenService deleteSessionTokenService, RemoteExceptionToEntityMapper remoteExceptionToEntityMapper) {
        return new SessionTokenRepository(deleteSessionTokenService, remoteExceptionToEntityMapper);
    }

    @Override // javax.inject.Provider
    public SessionTokenRepository get() {
        return newInstance(this.f7620a.get(), this.f7621b.get());
    }
}
