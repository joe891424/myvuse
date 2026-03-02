package com.yoti.mobile.android.documentcapture.data;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.AssessmentTypeEntityToDataMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class AssessmentEntityToAssessmentResultMapper_Factory implements Factory<AssessmentEntityToAssessmentResultMapper> {
    private final Provider<AssessmentTypeEntityToDataMapper> assessmentTypeEntityToDataMapperProvider;

    public AssessmentEntityToAssessmentResultMapper_Factory(Provider<AssessmentTypeEntityToDataMapper> provider) {
        this.assessmentTypeEntityToDataMapperProvider = provider;
    }

    public static AssessmentEntityToAssessmentResultMapper_Factory create(Provider<AssessmentTypeEntityToDataMapper> provider) {
        return new AssessmentEntityToAssessmentResultMapper_Factory(provider);
    }

    public static AssessmentEntityToAssessmentResultMapper newInstance(AssessmentTypeEntityToDataMapper assessmentTypeEntityToDataMapper) {
        return new AssessmentEntityToAssessmentResultMapper(assessmentTypeEntityToDataMapper);
    }

    @Override // javax.inject.Provider
    public AssessmentEntityToAssessmentResultMapper get() {
        return newInstance(this.assessmentTypeEntityToDataMapperProvider.get());
    }
}
