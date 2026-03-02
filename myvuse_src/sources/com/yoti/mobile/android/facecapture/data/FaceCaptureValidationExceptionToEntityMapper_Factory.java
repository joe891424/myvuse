package com.yoti.mobile.android.facecapture.data;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureValidationExceptionToEntityMapper_Factory implements Factory<FaceCaptureValidationExceptionToEntityMapper> {
    private final Provider<Gson> gsonProvider;

    public FaceCaptureValidationExceptionToEntityMapper_Factory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static FaceCaptureValidationExceptionToEntityMapper_Factory create(Provider<Gson> provider) {
        return new FaceCaptureValidationExceptionToEntityMapper_Factory(provider);
    }

    public static FaceCaptureValidationExceptionToEntityMapper newInstance(Gson gson) {
        return new FaceCaptureValidationExceptionToEntityMapper(gson);
    }

    @Override // javax.inject.Provider
    public FaceCaptureValidationExceptionToEntityMapper get() {
        return newInstance(this.gsonProvider.get());
    }
}
