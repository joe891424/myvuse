package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadModule_ProvidesUploadNavigatorProviderFactory implements Factory<IUploadNavigatorProvider<IDocumentViewData>> {
    private final UploadModule module;

    public UploadModule_ProvidesUploadNavigatorProviderFactory(UploadModule uploadModule) {
        this.module = uploadModule;
    }

    public static UploadModule_ProvidesUploadNavigatorProviderFactory create(UploadModule uploadModule) {
        return new UploadModule_ProvidesUploadNavigatorProviderFactory(uploadModule);
    }

    public static IUploadNavigatorProvider<IDocumentViewData> providesUploadNavigatorProvider(UploadModule uploadModule) {
        return (IUploadNavigatorProvider) Preconditions.checkNotNullFromProvides(uploadModule.providesUploadNavigatorProvider());
    }

    @Override // javax.inject.Provider
    public IUploadNavigatorProvider<IDocumentViewData> get() {
        return providesUploadNavigatorProvider(this.module);
    }
}
