package com.yoti.mobile.android.liveness.data;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class LivenessExceptionToEntityMapper_Factory implements Factory<LivenessExceptionToEntityMapper> {
    private final Provider<Gson> gsonProvider;

    public LivenessExceptionToEntityMapper_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static LivenessExceptionToEntityMapper_Factory create(Provider<Gson> provider) {
        return new LivenessExceptionToEntityMapper_Factory(provider);
    }

    public static LivenessExceptionToEntityMapper newInstance(Gson gson) {
        return new LivenessExceptionToEntityMapper(gson);
    }

    @Override // javax.inject.Provider
    public LivenessExceptionToEntityMapper get() {
        return newInstance(this.gsonProvider.get());
    }
}
