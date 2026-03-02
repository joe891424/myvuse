package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesUploadErrorToViewDataMapperFactory implements Factory<Mapper<Throwable, YdsFailure>> {
    private final UploadModule module;

    public UploadModule_ProvidesUploadErrorToViewDataMapperFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesUploadErrorToViewDataMapperFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesUploadErrorToViewDataMapperFactory(uploadModule);
    }

    public static Mapper<Throwable, YdsFailure> providesUploadErrorToViewDataMapper(UploadModule uploadModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(uploadModule.providesUploadErrorToViewDataMapper());
    }

    @Override // javax.inject.Provider
    public Mapper<Throwable, YdsFailure> get() {
        return providesUploadErrorToViewDataMapper(this.module);
    }
}
