package com.yoti.mobile.android.remote.interceptor;

import com.yoti.mobile.android.remote.model.Session;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class SessionIdInterceptor_Factory implements Factory<SessionIdInterceptor> {
    private final Provider<Session> sessionProvider;

    public SessionIdInterceptor_Factory(Provider<Session> provider) {
        this.sessionProvider = provider;
    }

    @Override // javax.inject.Provider
    public SessionIdInterceptor get() {
        return newInstance(this.sessionProvider.get());
    }

    public static SessionIdInterceptor_Factory create(Provider<Session> provider) {
        return new SessionIdInterceptor_Factory(provider);
    }

    public static SessionIdInterceptor newInstance(Session session) {
        return new SessionIdInterceptor(session);
    }
}
