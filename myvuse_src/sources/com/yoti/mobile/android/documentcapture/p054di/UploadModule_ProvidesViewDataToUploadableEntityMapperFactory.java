package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesViewDataToUploadableEntityMapperFactory implements Factory<SuspendMapper<IDocumentViewData, IDocumentEntity>> {
    private final UploadModule module;

    public UploadModule_ProvidesViewDataToUploadableEntityMapperFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesViewDataToUploadableEntityMapperFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesViewDataToUploadableEntityMapperFactory(uploadModule);
    }

    public static SuspendMapper<IDocumentViewData, IDocumentEntity> providesViewDataToUploadableEntityMapper(UploadModule uploadModule) {
        return (SuspendMapper) Preconditions.checkNotNullFromProvides(uploadModule.providesViewDataToUploadableEntityMapper());
    }

    @Override // javax.inject.Provider
    public SuspendMapper<IDocumentViewData, IDocumentEntity> get() {
        return providesViewDataToUploadableEntityMapper(this.module);
    }
}
