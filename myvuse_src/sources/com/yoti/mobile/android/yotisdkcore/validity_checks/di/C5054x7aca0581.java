package com.yoti.mobile.android.yotisdkcore.validity_checks.di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.validity_checks.data.remote.DocumentSchemeValidityChecksApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.validity_checks.di.DocumentSchemeValidityChecksModule_ProvidesDocumentSchemeValidityCheckApiServiceFactory */
/* JADX INFO: loaded from: classes4.dex */
public final class C5054x7aca0581 implements Factory<DocumentSchemeValidityChecksApiService> {

    /* JADX INFO: renamed from: a */
    private final DocumentSchemeValidityChecksModule f7894a;

    /* JADX INFO: renamed from: b */
    private final Provider<ApiServiceFactory> f7895b;

    /* JADX INFO: renamed from: c */
    private final Provider<OkHttpClient> f7896c;

    /* JADX INFO: renamed from: d */
    private final Provider<CallAdapter.Factory> f7897d;

    public C5054x7aca0581(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<CallAdapter.Factory> provider3) {
        this.f7895b = provider;
        this.f7896c = provider2;
        this.f7897d = provider3;
    }

    public static C5054x7aca0581 create(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<CallAdapter.Factory> provider3) {
        return new C5054x7aca0581(documentSchemeValidityChecksModule, provider, provider2, provider3);
    }

    public static DocumentSchemeValidityChecksApiService providesDocumentSchemeValidityCheckApiService(DocumentSchemeValidityChecksModule documentSchemeValidityChecksModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, CallAdapter.Factory factory) {
        return (DocumentSchemeValidityChecksApiService) Preconditions.checkNotNullFromProvides(documentSchemeValidityChecksModule.m5360a(apiServiceFactory, okHttpClient, factory));
    }

    @Override // javax.inject.Provider
    public DocumentSchemeValidityChecksApiService get() {
        return providesDocumentSchemeValidityCheckApiService(this.f7894a, this.f7895b.get(), this.f7896c.get(), this.f7897d.get());
    }
}
