package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesDocumentRepositoryFactory implements Factory<IDocumentRepository<IDocumentEntity>> {
    private final UploadModule module;

    public UploadModule_ProvidesDocumentRepositoryFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesDocumentRepositoryFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesDocumentRepositoryFactory(uploadModule);
    }

    public static IDocumentRepository<IDocumentEntity> providesDocumentRepository(UploadModule uploadModule) {
        return (IDocumentRepository) Preconditions.checkNotNullFromProvides(uploadModule.providesDocumentRepository());
    }

    @Override // javax.inject.Provider
    public IDocumentRepository<IDocumentEntity> get() {
        return providesDocumentRepository(this.module);
    }
}
