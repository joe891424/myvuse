package com.yoti.mobile.android.yotisdkcore.core.data;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DataExceptionToEntityMapper_Factory implements Factory<DataExceptionToEntityMapper> {
    private final Provider<Gson> gsonProvider;

    public DataExceptionToEntityMapper_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static DataExceptionToEntityMapper_Factory create(Provider<Gson> provider) {
        return new DataExceptionToEntityMapper_Factory(provider);
    }

    public static DataExceptionToEntityMapper newInstance(Gson gson) {
        return new DataExceptionToEntityMapper(gson);
    }

    @Override // javax.inject.Provider
    public DataExceptionToEntityMapper get() {
        return newInstance(this.gsonProvider.get());
    }
}
