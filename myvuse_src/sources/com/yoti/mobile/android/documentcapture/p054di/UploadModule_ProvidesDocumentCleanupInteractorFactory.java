package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesDocumentCleanupInteractorFactory implements Factory<IDocumentCleanupInteractor> {
    private final UploadModule module;

    public UploadModule_ProvidesDocumentCleanupInteractorFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesDocumentCleanupInteractorFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesDocumentCleanupInteractorFactory(uploadModule);
    }

    public static IDocumentCleanupInteractor providesDocumentCleanupInteractor(UploadModule uploadModule) {
        return uploadModule.providesDocumentCleanupInteractor();
    }

    @Override // javax.inject.Provider
    public IDocumentCleanupInteractor get() {
        return providesDocumentCleanupInteractor(this.module);
    }
}
