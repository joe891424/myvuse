package com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileRemoteDataSource_Factory implements Factory<ApplicantProfileRemoteDataSource> {
    private final Provider<ApplicantProfileApiService> apiServiceProvider;

    public ApplicantProfileRemoteDataSource_Factory(Provider<ApplicantProfileApiService> provider) {
        this.apiServiceProvider = provider;
    }

    public static ApplicantProfileRemoteDataSource_Factory create(Provider<ApplicantProfileApiService> provider) {
        return new ApplicantProfileRemoteDataSource_Factory(provider);
    }

    public static ApplicantProfileRemoteDataSource newInstance(ApplicantProfileApiService applicantProfileApiService) {
        return new ApplicantProfileRemoteDataSource(applicantProfileApiService);
    }

    @Override // javax.inject.Provider
    public ApplicantProfileRemoteDataSource get() {
        return newInstance(this.apiServiceProvider.get());
    }
}
