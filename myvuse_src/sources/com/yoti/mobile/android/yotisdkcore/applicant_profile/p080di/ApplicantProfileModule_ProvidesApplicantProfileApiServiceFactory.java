package com.yoti.mobile.android.yotisdkcore.applicant_profile.p080di;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileModule_ProvidesApplicantProfileApiServiceFactory implements Factory<ApplicantProfileApiService> {
    private final Provider<ApiServiceFactory> apiServiceFactoryProvider;
    private final Provider<CallAdapter.Factory> callAdapterFactoryProvider;
    private final ApplicantProfileModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApplicantProfileModule_ProvidesApplicantProfileApiServiceFactory(ApplicantProfileModule applicantProfileModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<CallAdapter.Factory> provider3) {
        this.module = applicantProfileModule;
        this.apiServiceFactoryProvider = provider;
        this.okHttpClientProvider = provider2;
        this.callAdapterFactoryProvider = provider3;
    }

    public static ApplicantProfileModule_ProvidesApplicantProfileApiServiceFactory create(ApplicantProfileModule applicantProfileModule, Provider<ApiServiceFactory> provider, Provider<OkHttpClient> provider2, Provider<CallAdapter.Factory> provider3) {
        return new ApplicantProfileModule_ProvidesApplicantProfileApiServiceFactory(applicantProfileModule, provider, provider2, provider3);
    }

    public static ApplicantProfileApiService providesApplicantProfileApiService(ApplicantProfileModule applicantProfileModule, ApiServiceFactory apiServiceFactory, OkHttpClient okHttpClient, CallAdapter.Factory factory) {
        return (ApplicantProfileApiService) Preconditions.checkNotNullFromProvides(applicantProfileModule.providesApplicantProfileApiService(apiServiceFactory, okHttpClient, factory));
    }

    @Override // javax.inject.Provider
    public ApplicantProfileApiService get() {
        return providesApplicantProfileApiService(this.module, this.apiServiceFactoryProvider.get(), this.okHttpClientProvider.get(), this.callAdapterFactoryProvider.get());
    }
}
