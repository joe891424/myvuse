package com.yoti.mobile.android.documentcapture.p055id.data.remote;

import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import com.yoti.mobile.android.yotisdkcore.core.data.remote.SdkCoreApiService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class DocumentUploadService_Factory implements Factory<DocumentUploadService> {
    private final Provider<DocumentCaptureApiService> apiServiceProvider;
    private final Provider<Boolean> isSessionFeedbackEnabledProvider;
    private final Provider<MultiPartBodyFactory> multipartBodyFactoryProvider;
    private final Provider<String> requirementIdProvider;
    private final Provider<SdkCoreApiService> sdkCoreApiServiceProvider;

    public DocumentUploadService_Factory(Provider<MultiPartBodyFactory> provider, Provider<DocumentCaptureApiService> provider2, Provider<SdkCoreApiService> provider3, Provider<String> provider4, Provider<Boolean> provider5) {
        this.multipartBodyFactoryProvider = provider;
        this.apiServiceProvider = provider2;
        this.sdkCoreApiServiceProvider = provider3;
        this.requirementIdProvider = provider4;
        this.isSessionFeedbackEnabledProvider = provider5;
    }

    public static DocumentUploadService_Factory create(Provider<MultiPartBodyFactory> provider, Provider<DocumentCaptureApiService> provider2, Provider<SdkCoreApiService> provider3, Provider<String> provider4, Provider<Boolean> provider5) {
        return new DocumentUploadService_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DocumentUploadService newInstance(MultiPartBodyFactory multiPartBodyFactory, DocumentCaptureApiService documentCaptureApiService, SdkCoreApiService sdkCoreApiService, String str, boolean z) {
        return new DocumentUploadService(multiPartBodyFactory, documentCaptureApiService, sdkCoreApiService, str, z);
    }

    @Override // javax.inject.Provider
    public DocumentUploadService get() {
        return newInstance(this.multipartBodyFactoryProvider.get(), this.apiServiceProvider.get(), this.sdkCoreApiServiceProvider.get(), this.requirementIdProvider.get(), this.isSessionFeedbackEnabledProvider.get().booleanValue());
    }
}
