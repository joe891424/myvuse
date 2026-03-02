package com.yoti.mobile.android.yotisdkcore.applicant_profile.view;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicantProfileDateOfBirthFormatter_Factory implements Factory<ApplicantProfileDateOfBirthFormatter> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.applicant_profile.view.ApplicantProfileDateOfBirthFormatter_Factory$a */
    private static final class C4964a {

        /* JADX INFO: renamed from: a */
        private static final ApplicantProfileDateOfBirthFormatter_Factory f7571a = new ApplicantProfileDateOfBirthFormatter_Factory();
    }

    public static ApplicantProfileDateOfBirthFormatter_Factory create() {
        return C4964a.f7571a;
    }

    public static ApplicantProfileDateOfBirthFormatter newInstance() {
        return new ApplicantProfileDateOfBirthFormatter();
    }

    @Override // javax.inject.Provider
    public ApplicantProfileDateOfBirthFormatter get() {
        return newInstance();
    }
}
