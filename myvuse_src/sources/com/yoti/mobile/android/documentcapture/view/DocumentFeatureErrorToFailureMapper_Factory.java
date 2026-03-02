package com.yoti.mobile.android.documentcapture.view;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentFeatureErrorToFailureMapper_Factory implements Factory<DocumentFeatureErrorToFailureMapper> {
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;

    public DocumentFeatureErrorToFailureMapper_Factory(Provider<ExceptionToFailureMapper> provider) {
        this.exceptionToFailureMapperProvider = provider;
    }

    public static DocumentFeatureErrorToFailureMapper_Factory create(Provider<ExceptionToFailureMapper> provider) {
        return new DocumentFeatureErrorToFailureMapper_Factory(provider);
    }

    public static DocumentFeatureErrorToFailureMapper newInstance(ExceptionToFailureMapper exceptionToFailureMapper) {
        return new DocumentFeatureErrorToFailureMapper(exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public DocumentFeatureErrorToFailureMapper get() {
        return newInstance(this.exceptionToFailureMapperProvider.get());
    }
}
