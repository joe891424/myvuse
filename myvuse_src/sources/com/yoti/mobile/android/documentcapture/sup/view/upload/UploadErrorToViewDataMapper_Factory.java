package com.yoti.mobile.android.documentcapture.sup.view.upload;

import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadErrorToViewDataMapper_Factory implements Factory<UploadErrorToViewDataMapper> {
    private final Provider<ExceptionToFailureMapper> exceptionToFailureMapperProvider;

    public UploadErrorToViewDataMapper_Factory(Provider<ExceptionToFailureMapper> provider) {
        this.exceptionToFailureMapperProvider = provider;
    }

    public static UploadErrorToViewDataMapper_Factory create(Provider<ExceptionToFailureMapper> provider) {
        return new UploadErrorToViewDataMapper_Factory(provider);
    }

    public static UploadErrorToViewDataMapper newInstance(ExceptionToFailureMapper exceptionToFailureMapper) {
        return new UploadErrorToViewDataMapper(exceptionToFailureMapper);
    }

    @Override // javax.inject.Provider
    public UploadErrorToViewDataMapper get() {
        return newInstance(this.exceptionToFailureMapperProvider.get());
    }
}
