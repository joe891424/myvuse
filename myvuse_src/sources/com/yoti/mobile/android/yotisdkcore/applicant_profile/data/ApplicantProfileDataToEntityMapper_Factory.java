package com.yoti.mobile.android.yotisdkcore.applicant_profile.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileDataToEntityMapper_Factory implements Factory<ApplicantProfileDataToEntityMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.data.ApplicantProfileDataToEntityMapper_Factory$a */
    private static final class C4959a {

        /* JADX INFO: renamed from: a */
        private static final ApplicantProfileDataToEntityMapper_Factory f7564a = new ApplicantProfileDataToEntityMapper_Factory();
    }

    public static ApplicantProfileDataToEntityMapper_Factory create() {
        return C4959a.f7564a;
    }

    public static ApplicantProfileDataToEntityMapper newInstance() {
        return new ApplicantProfileDataToEntityMapper();
    }

    @Override // javax.inject.Provider
    public ApplicantProfileDataToEntityMapper get() {
        return newInstance();
    }
}
