package com.yoti.mobile.android.remote.p075di;

import com.yoti.mobile.android.remote.model.Session;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteModule_ProvidesSessionFactory implements Factory<Session> {
    private final RemoteModule module;

    public RemoteModule_ProvidesSessionFactory(RemoteModule remoteModule) {
        this.module = remoteModule;
    }

    @Override // javax.inject.Provider
    public Session get() {
        return providesSession(this.module);
    }

    public static RemoteModule_ProvidesSessionFactory create(RemoteModule remoteModule) {
        return new RemoteModule_ProvidesSessionFactory(remoteModule);
    }

    public static Session providesSession(RemoteModule remoteModule) {
        return (Session) Preconditions.checkNotNullFromProvides(remoteModule.getSession());
    }
}
