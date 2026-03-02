package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p055id.data.IdDocumentRepository;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToViewDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class IdDocumentUploadDependenciesProvider_Factory implements Factory<IdDocumentUploadDependenciesProvider> {
    private final Provider<IdDocumentRepository> docRepositoryProvider;
    private final Provider<IdDocumentScanResultViewDataToEntityMapper> documentViewDataToEntityMapperProvider;
    private final Provider<IdDocumentUploadNavigatorProvider> navigatorProvider;
    private final Provider<UploadErrorToViewDataMapper> uploadErrorToFailureMapperProvider;
    private final Provider<UploadErrorToSessionStatusTypeMapper> uploadErrorToSessionStatusTypeMapperProvider;

    public IdDocumentUploadDependenciesProvider_Factory(Provider<IdDocumentUploadNavigatorProvider> provider, Provider<IdDocumentRepository> provider2, Provider<IdDocumentScanResultViewDataToEntityMapper> provider3, Provider<UploadErrorToViewDataMapper> provider4, Provider<UploadErrorToSessionStatusTypeMapper> provider5) {
        this.navigatorProvider = provider;
        this.docRepositoryProvider = provider2;
        this.documentViewDataToEntityMapperProvider = provider3;
        this.uploadErrorToFailureMapperProvider = provider4;
        this.uploadErrorToSessionStatusTypeMapperProvider = provider5;
    }

    public static IdDocumentUploadDependenciesProvider_Factory create(Provider<IdDocumentUploadNavigatorProvider> provider, Provider<IdDocumentRepository> provider2, Provider<IdDocumentScanResultViewDataToEntityMapper> provider3, Provider<UploadErrorToViewDataMapper> provider4, Provider<UploadErrorToSessionStatusTypeMapper> provider5) {
        return new IdDocumentUploadDependenciesProvider_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static IdDocumentUploadDependenciesProvider newInstance(IdDocumentUploadNavigatorProvider idDocumentUploadNavigatorProvider, IdDocumentRepository idDocumentRepository, IdDocumentScanResultViewDataToEntityMapper idDocumentScanResultViewDataToEntityMapper, UploadErrorToViewDataMapper uploadErrorToViewDataMapper, UploadErrorToSessionStatusTypeMapper uploadErrorToSessionStatusTypeMapper) {
        return new IdDocumentUploadDependenciesProvider(idDocumentUploadNavigatorProvider, idDocumentRepository, idDocumentScanResultViewDataToEntityMapper, uploadErrorToViewDataMapper, uploadErrorToSessionStatusTypeMapper);
    }

    @Override // javax.inject.Provider
    public IdDocumentUploadDependenciesProvider get() {
        return newInstance(this.navigatorProvider.get(), this.docRepositoryProvider.get(), this.documentViewDataToEntityMapperProvider.get(), this.uploadErrorToFailureMapperProvider.get(), this.uploadErrorToSessionStatusTypeMapperProvider.get());
    }
}
