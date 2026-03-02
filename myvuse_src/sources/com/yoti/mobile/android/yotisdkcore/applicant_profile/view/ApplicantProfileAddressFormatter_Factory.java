package com.yoti.mobile.android.yotisdkcore.applicant_profile.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileAddressFormatter_Factory implements Factory<ApplicantProfileAddressFormatter> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileAddressFormatter_Factory$a */
    private static final class C4963a {

        /* JADX INFO: renamed from: a */
        private static final ApplicantProfileAddressFormatter_Factory f7570a = new ApplicantProfileAddressFormatter_Factory();
    }

    public static ApplicantProfileAddressFormatter_Factory create() {
        return C4963a.f7570a;
    }

    public static ApplicantProfileAddressFormatter newInstance() {
        return new ApplicantProfileAddressFormatter();
    }

    @Override // javax.inject.Provider
    public ApplicantProfileAddressFormatter get() {
        return newInstance();
    }
}
