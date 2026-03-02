package com.yoti.mobile.android.documentcapture.sup.data.remote;

import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.remote.MultiPartBodyFactory;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class SupDocumentUploadService_Factory implements Factory<SupDocumentUploadService> {
    private final Provider<SupDocumentCaptureApiService> apiServiceProvider;
    private final Provider<MimeTypeProvider> mimeTypeProvider;
    private final Provider<MultiPartBodyFactory> multiPartBodyFactoryProvider;

    public SupDocumentUploadService_Factory(Provider<SupDocumentCaptureApiService> provider, Provider<MultiPartBodyFactory> provider2, Provider<MimeTypeProvider> provider3) {
        this.apiServiceProvider = provider;
        this.multiPartBodyFactoryProvider = provider2;
        this.mimeTypeProvider = provider3;
    }

    public static SupDocumentUploadService_Factory create(Provider<SupDocumentCaptureApiService> provider, Provider<MultiPartBodyFactory> provider2, Provider<MimeTypeProvider> provider3) {
        return new SupDocumentUploadService_Factory(provider, provider2, provider3);
    }

    public static SupDocumentUploadService newInstance(SupDocumentCaptureApiService supDocumentCaptureApiService, MultiPartBodyFactory multiPartBodyFactory, MimeTypeProvider mimeTypeProvider) {
        return new SupDocumentUploadService(supDocumentCaptureApiService, multiPartBodyFactory, mimeTypeProvider);
    }

    @Override // javax.inject.Provider
    public SupDocumentUploadService get() {
        return newInstance(this.apiServiceProvider.get(), this.multiPartBodyFactoryProvider.get(), this.mimeTypeProvider.get());
    }
}
