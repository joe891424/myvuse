package com.yoti.mobile.android.remote.exception;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class RemoteExceptionToEntityMapper_Factory implements Factory<RemoteExceptionToEntityMapper> {
    private final Provider<Gson> gsonProvider;

    public RemoteExceptionToEntityMapper_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    @Override // javax.inject.Provider
    public RemoteExceptionToEntityMapper get() {
        return newInstance(this.gsonProvider.get());
    }

    public static RemoteExceptionToEntityMapper_Factory create(Provider<Gson> provider) {
        return new RemoteExceptionToEntityMapper_Factory(provider);
    }

    public static RemoteExceptionToEntityMapper newInstance(Gson gson) {
        return new RemoteExceptionToEntityMapper(gson);
    }
}
