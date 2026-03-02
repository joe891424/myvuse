package com.yoti.mobile.android.yotisdkcore.applicant_profile.p080di;

import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.IApplicantProfileDataSource;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.remote.ApplicantProfileRemoteDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileModule_ProvidesApplicantProfileDataSourceFactory implements Factory<IApplicantProfileDataSource> {
    private final Provider<ApplicantProfileRemoteDataSource> actualProvider;
    private final ApplicantProfileModule module;

    public ApplicantProfileModule_ProvidesApplicantProfileDataSourceFactory(ApplicantProfileModule applicantProfileModule, Provider<ApplicantProfileRemoteDataSource> provider) {
        this.module = applicantProfileModule;
        this.actualProvider = provider;
    }

    public static ApplicantProfileModule_ProvidesApplicantProfileDataSourceFactory create(ApplicantProfileModule applicantProfileModule, Provider<ApplicantProfileRemoteDataSource> provider) {
        return new ApplicantProfileModule_ProvidesApplicantProfileDataSourceFactory(applicantProfileModule, provider);
    }

    public static IApplicantProfileDataSource providesApplicantProfileDataSource(ApplicantProfileModule applicantProfileModule, ApplicantProfileRemoteDataSource applicantProfileRemoteDataSource) {
        return (IApplicantProfileDataSource) Preconditions.checkNotNullFromProvides(applicantProfileModule.providesApplicantProfileDataSource(applicantProfileRemoteDataSource));
    }

    @Override // javax.inject.Provider
    public IApplicantProfileDataSource get() {
        return providesApplicantProfileDataSource(this.module, this.actualProvider.get());
    }
}
