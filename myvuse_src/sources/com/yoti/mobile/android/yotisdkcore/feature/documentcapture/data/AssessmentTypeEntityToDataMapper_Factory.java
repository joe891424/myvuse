package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes4.dex */
public final class AssessmentTypeEntityToDataMapper_Factory implements Factory<AssessmentTypeEntityToDataMapper> {

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.AssessmentTypeEntityToDataMapper_Factory$a */
    private static final class C4990a {

        /* JADX INFO: renamed from: a */
        private static final AssessmentTypeEntityToDataMapper_Factory f7615a = new AssessmentTypeEntityToDataMapper_Factory();
    }

    public static AssessmentTypeEntityToDataMapper_Factory create() {
        return C4990a.f7615a;
    }

    public static AssessmentTypeEntityToDataMapper newInstance() {
        return new AssessmentTypeEntityToDataMapper();
    }

    @Override // javax.inject.Provider
    public AssessmentTypeEntityToDataMapper get() {
        return newInstance();
    }
}
