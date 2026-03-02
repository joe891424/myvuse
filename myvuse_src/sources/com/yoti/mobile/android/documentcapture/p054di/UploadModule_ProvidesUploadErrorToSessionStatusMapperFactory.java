package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesUploadErrorToSessionStatusMapperFactory implements Factory<ErrorToSessionStatusTypeMapper> {
    private final UploadModule module;

    public UploadModule_ProvidesUploadErrorToSessionStatusMapperFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesUploadErrorToSessionStatusMapperFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesUploadErrorToSessionStatusMapperFactory(uploadModule);
    }

    public static ErrorToSessionStatusTypeMapper providesUploadErrorToSessionStatusMapper(UploadModule uploadModule) {
        return (ErrorToSessionStatusTypeMapper) Preconditions.checkNotNullFromProvides(uploadModule.providesUploadErrorToSessionStatusMapper());
    }

    @Override // javax.inject.Provider
    public ErrorToSessionStatusTypeMapper get() {
        return providesUploadErrorToSessionStatusMapper(this.module);
    }
}
