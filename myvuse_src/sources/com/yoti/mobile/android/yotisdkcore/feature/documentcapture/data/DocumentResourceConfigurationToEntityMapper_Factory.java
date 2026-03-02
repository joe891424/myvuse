package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.ApplicantProfileDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ObjectiveTypeDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentResourceConfigurationToEntityMapper_Factory implements Factory<DocumentResourceConfigurationToEntityMapper> {
    private final Provider<ApplicantProfileDataToEntityMapper> applicantProfileDataToEntityMapperProvider;
    private final Provider<DocumentTypeDataToEntityMapper> documentTypeDataToEntityMapperProvider;
    private final Provider<ObjectiveTypeDataToEntityMapper> objectiveTypeDataToEntityMapperProvider;
    private final Provider<TaskToEntityMapper> taskToEntityMapperProvider;

    public DocumentResourceConfigurationToEntityMapper_Factory(Provider<DocumentTypeDataToEntityMapper> provider, Provider<ObjectiveTypeDataToEntityMapper> provider2, Provider<TaskToEntityMapper> provider3, Provider<ApplicantProfileDataToEntityMapper> provider4) {
        this.documentTypeDataToEntityMapperProvider = provider;
        this.objectiveTypeDataToEntityMapperProvider = provider2;
        this.taskToEntityMapperProvider = provider3;
        this.applicantProfileDataToEntityMapperProvider = provider4;
    }

    public static DocumentResourceConfigurationToEntityMapper_Factory create(Provider<DocumentTypeDataToEntityMapper> provider, Provider<ObjectiveTypeDataToEntityMapper> provider2, Provider<TaskToEntityMapper> provider3, Provider<ApplicantProfileDataToEntityMapper> provider4) {
        return new DocumentResourceConfigurationToEntityMapper_Factory(provider, provider2, provider3, provider4);
    }

    public static DocumentResourceConfigurationToEntityMapper newInstance(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper, ObjectiveTypeDataToEntityMapper objectiveTypeDataToEntityMapper, TaskToEntityMapper taskToEntityMapper, ApplicantProfileDataToEntityMapper applicantProfileDataToEntityMapper) {
        return new DocumentResourceConfigurationToEntityMapper(documentTypeDataToEntityMapper, objectiveTypeDataToEntityMapper, taskToEntityMapper, applicantProfileDataToEntityMapper);
    }

    @Override // javax.inject.Provider
    public DocumentResourceConfigurationToEntityMapper get() {
        return newInstance(this.documentTypeDataToEntityMapperProvider.get(), this.objectiveTypeDataToEntityMapperProvider.get(), this.taskToEntityMapperProvider.get(), this.applicantProfileDataToEntityMapperProvider.get());
    }
}
