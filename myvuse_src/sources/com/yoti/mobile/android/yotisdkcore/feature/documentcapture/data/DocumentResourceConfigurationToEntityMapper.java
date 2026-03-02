package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkIncompatibleError;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.ApplicantProfileDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile;
import com.yoti.mobile.android.yotisdkcore.core.data.ObjectiveTypeDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.TaskToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentScheme;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentState;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AssessmentType;
import com.yoti.mobile.android.yotisdkcore.core.data.model.Document;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentRequirements;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import com.yoti.mobile.android.yotisdkcore.core.data.model.IbvClientAssessment;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.model.Task;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ValidationAndGuidance;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.CaptureObjectiveTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.StateTypeEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u001e\u001a\u00020,H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0!2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000!H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J.\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0!H\u0014J(\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0B2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G0BH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentResourceConfigurationToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "documentTypeDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;", "objectiveTypeDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ObjectiveTypeDataToEntityMapper;", "taskToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/TaskToEntityMapper;", "applicantProfileDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/ApplicantProfileDataToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/ObjectiveTypeDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/TaskToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/ApplicantProfileDataToEntityMapper;)V", "mapAssessmentScheme", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "scheme", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentScheme;", "mapAssessmentState", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentState;", "mapAssessmentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentTypeEntity;", "type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AssessmentType;", "mapCaptureMethodTypeToEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CaptureMethodTypeEntity;", "captureMethodType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$CaptureMethodType;", "mapCompoundTextResource", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "from", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$CompoundText;", "mapCountries", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CountryEntity;", "countries", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$Country;", "mapDocumentCaptureTypeToEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "documentCaptureType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;", "mapDocumentRequirements", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentRequirements;", "mapEducationalItems", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalItemEntity;", FirebaseAnalytics.Param.ITEMS, "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalItem;", "mapIbvClientAssessment", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "assessments", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvClientAssessment;", "mapLayoutType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity$LayoutTypeEntity;", "layoutType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance$EducationalConfiguration$LayoutType;", "mapResource", "requirementId", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "resourceConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "allowedSources", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "mapValidationAndGuidanceConfigurations", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;", "validationAndGuidanceConfigurations", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentResourceConfigurationToEntityMapper extends ResourceConfigurationToEntityMapper<DocumentResourceConfigEntity> {
    private final ApplicantProfileDataToEntityMapper applicantProfileDataToEntityMapper;
    private final DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper;
    private final ObjectiveTypeDataToEntityMapper objectiveTypeDataToEntityMapper;
    private final TaskToEntityMapper taskToEntityMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ValidationAndGuidance.EducationalConfiguration.LayoutType.values().length];
            iArr[ValidationAndGuidance.EducationalConfiguration.LayoutType.GRID.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ValidationAndGuidance.DynamicValueType.values().length];
            iArr2[ValidationAndGuidance.DynamicValueType.DOCUMENT_NAME.ordinal()] = 1;
            iArr2[ValidationAndGuidance.DynamicValueType.COUNTRY_NAME.ordinal()] = 2;
            iArr2[ValidationAndGuidance.DynamicValueType.APPLICANT_FULL_NAME.ordinal()] = 3;
            iArr2[ValidationAndGuidance.DynamicValueType.APPLICANT_ADDRESS.ordinal()] = 4;
            iArr2[ValidationAndGuidance.DynamicValueType.APPLICANT_DATE_OF_BIRTH.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AssessmentType.values().length];
            iArr3[AssessmentType.IBV_VISUAL_REVIEW_CHECK.ordinal()] = 1;
            iArr3[AssessmentType.DOCUMENT_SCHEME_VALIDITY_CHECK.ordinal()] = 2;
            iArr3[AssessmentType.PROFILE_DOCUMENT_MATCH.ordinal()] = 3;
            iArr3[AssessmentType.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[AssessmentScheme.values().length];
            iArr4[AssessmentScheme.UK_DBS.ordinal()] = 1;
            iArr4[AssessmentScheme.UK_GDS.ordinal()] = 2;
            iArr4[AssessmentScheme.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[AssessmentState.values().length];
            iArr5[AssessmentState.COMPLETE.ordinal()] = 1;
            iArr5[AssessmentState.REQUIRED.ordinal()] = 2;
            iArr5[AssessmentState.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ResourceConfiguration.ResourceType.values().length];
            iArr6[ResourceConfiguration.ResourceType.ID_DOCUMENT.ordinal()] = 1;
            iArr6[ResourceConfiguration.ResourceType.SUPPLEMENTARY_DOCUMENT.ordinal()] = 2;
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ResourceConfiguration.CaptureMethodType.values().length];
            iArr7[ResourceConfiguration.CaptureMethodType.CAMERA.ordinal()] = 1;
            iArr7[ResourceConfiguration.CaptureMethodType.CAMERA_AND_UPLOAD.ordinal()] = 2;
            iArr7[ResourceConfiguration.CaptureMethodType.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public DocumentResourceConfigurationToEntityMapper(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper, ObjectiveTypeDataToEntityMapper objectiveTypeDataToEntityMapper, TaskToEntityMapper taskToEntityMapper, ApplicantProfileDataToEntityMapper applicantProfileDataToEntityMapper) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(documentTypeDataToEntityMapper, "documentTypeDataToEntityMapper");
        Intrinsics.checkNotNullParameter(objectiveTypeDataToEntityMapper, "objectiveTypeDataToEntityMapper");
        Intrinsics.checkNotNullParameter(taskToEntityMapper, "taskToEntityMapper");
        Intrinsics.checkNotNullParameter(applicantProfileDataToEntityMapper, "applicantProfileDataToEntityMapper");
        this.documentTypeDataToEntityMapper = documentTypeDataToEntityMapper;
        this.objectiveTypeDataToEntityMapper = objectiveTypeDataToEntityMapper;
        this.taskToEntityMapper = taskToEntityMapper;
        this.applicantProfileDataToEntityMapper = applicantProfileDataToEntityMapper;
    }

    private final DocumentResourceConfigEntity.AssessmentSchemeEntity mapAssessmentScheme(AssessmentScheme scheme) {
        int i = WhenMappings.$EnumSwitchMapping$3[scheme.ordinal()];
        if (i == 1) {
            return DocumentResourceConfigEntity.AssessmentSchemeEntity.UK_DBS;
        }
        if (i == 2) {
            return DocumentResourceConfigEntity.AssessmentSchemeEntity.UK_GDS;
        }
        if (i == 3) {
            return DocumentResourceConfigEntity.AssessmentSchemeEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final DocumentResourceConfigEntity.AssessmentStateEntity mapAssessmentState(AssessmentState state) {
        int i = WhenMappings.$EnumSwitchMapping$4[state.ordinal()];
        if (i == 1) {
            return DocumentResourceConfigEntity.AssessmentStateEntity.COMPLETE;
        }
        if (i == 2) {
            return DocumentResourceConfigEntity.AssessmentStateEntity.REQUIRED;
        }
        if (i == 3) {
            return DocumentResourceConfigEntity.AssessmentStateEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final DocumentResourceConfigEntity.AssessmentTypeEntity mapAssessmentType(AssessmentType type) {
        int i = WhenMappings.$EnumSwitchMapping$2[type.ordinal()];
        if (i == 1) {
            return DocumentResourceConfigEntity.AssessmentTypeEntity.IBV_VISUAL_REVIEW_CHECK;
        }
        if (i == 2) {
            return DocumentResourceConfigEntity.AssessmentTypeEntity.DOCUMENT_SCHEME_VALIDITY_CHECK;
        }
        if (i == 3) {
            return DocumentResourceConfigEntity.AssessmentTypeEntity.PROFILE_DOCUMENT_MATCH_CHECK;
        }
        if (i == 4) {
            return DocumentResourceConfigEntity.AssessmentTypeEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity mapCompoundTextResource(ValidationAndGuidance.CompoundText from) {
        DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity dynamicValueTypeEntity;
        int stringRes = from.getStringRes();
        List<ValidationAndGuidance.DynamicValueType> dynamicValues = from.getDynamicValues();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dynamicValues, 10));
        Iterator<T> it2 = dynamicValues.iterator();
        while (it2.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$1[((ValidationAndGuidance.DynamicValueType) it2.next()).ordinal()];
            if (i == 1) {
                dynamicValueTypeEntity = DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.DOCUMENT_NAME;
            } else if (i == 2) {
                dynamicValueTypeEntity = DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.COUNTRY_NAME;
            } else if (i == 3) {
                dynamicValueTypeEntity = DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_FULL_NAME;
            } else if (i == 4) {
                dynamicValueTypeEntity = DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_ADDRESS;
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                dynamicValueTypeEntity = DocumentResourceConfigEntity.ValidationAndGuidanceEntity.DynamicValueTypeEntity.APPLICANT_DATE_OF_BIRTH;
            }
            arrayList.add(dynamicValueTypeEntity);
        }
        return new DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity(stringRes, arrayList, from.getColorAttrRes());
    }

    private final List<DocumentResourceConfigEntity.CountryEntity> mapCountries(List<ResourceConfiguration.Country> countries) {
        Set<DocumentResourceConfigEntity.DocumentRequirementEntity> setEmptySet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(countries, 10));
        for (ResourceConfiguration.Country country : countries) {
            String iso3Code = country.getIso3Code();
            List<Document> supportedDocuments = country.getSupportedDocuments();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supportedDocuments, 10));
            for (Document document : supportedDocuments) {
                DocumentResourceConfigEntity.DocumentTypeEntity map = this.documentTypeDataToEntityMapper.map(document.getType());
                DocumentRequirements requirements = document.getRequirements();
                if (requirements == null || (setEmptySet = mapDocumentRequirements(requirements)) == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                arrayList2.add(new DocumentResourceConfigEntity.DocumentEntity(map, setEmptySet));
            }
            arrayList.add(new DocumentResourceConfigEntity.CountryEntity(iso3Code, arrayList2));
        }
        return arrayList;
    }

    private final Set<DocumentResourceConfigEntity.DocumentRequirementEntity> mapDocumentRequirements(DocumentRequirements from) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Date dateFrom = from.getDateFrom();
        if (dateFrom != null) {
            linkedHashSet.add(new DocumentResourceConfigEntity.DocumentRequirementEntity.DateFromEntity(dateFrom));
        }
        return linkedHashSet;
    }

    private final List<DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity> mapEducationalItems(List<ValidationAndGuidance.EducationalItem> items) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (ValidationAndGuidance.EducationalItem educationalItem : items) {
            int icon = educationalItem.getIcon();
            int title = educationalItem.getTitle();
            ValidationAndGuidance.CompoundText text = educationalItem.getText();
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity compoundTextEntityMapCompoundTextResource = null;
            DocumentResourceConfigEntity.ValidationAndGuidanceEntity.CompoundTextEntity compoundTextEntityMapCompoundTextResource2 = text != null ? mapCompoundTextResource(text) : null;
            ValidationAndGuidance.CompoundText textSecondary = educationalItem.getTextSecondary();
            if (textSecondary != null) {
                compoundTextEntityMapCompoundTextResource = mapCompoundTextResource(textSecondary);
            }
            arrayList.add(new DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalItemEntity(icon, title, compoundTextEntityMapCompoundTextResource2, compoundTextEntityMapCompoundTextResource));
        }
        return arrayList;
    }

    private final DocumentResourceConfigEntity.IbvClientAssessmentEntity mapIbvClientAssessment(IbvClientAssessment assessments) {
        return new DocumentResourceConfigEntity.IbvClientAssessmentEntity(mapAssessmentType(assessments.getType()), mapAssessmentScheme(assessments.getScheme()), mapAssessmentState(assessments.getState()));
    }

    private final DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity.LayoutTypeEntity mapLayoutType(ValidationAndGuidance.EducationalConfiguration.LayoutType layoutType) {
        return WhenMappings.$EnumSwitchMapping$0[layoutType.ordinal()] == 1 ? DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity.LayoutTypeEntity.GRID : DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity.LayoutTypeEntity.LIST;
    }

    private final Map<DocumentResourceConfigEntity.DocumentTypeEntity, DocumentResourceConfigEntity.ValidationAndGuidanceEntity> mapValidationAndGuidanceConfigurations(Map<DocumentType, ValidationAndGuidance> validationAndGuidanceConfigurations) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<DocumentType, ValidationAndGuidance> entry : validationAndGuidanceConfigurations.entrySet()) {
            DocumentType key = entry.getKey();
            ValidationAndGuidance value = entry.getValue();
            linkedHashMap.put(this.documentTypeDataToEntityMapper.map(key), new DocumentResourceConfigEntity.ValidationAndGuidanceEntity(new DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity(mapCompoundTextResource(value.getValidationConfiguration().getTitle()), mapEducationalItems(value.getValidationConfiguration().getItems()), null, 4, null), new DocumentResourceConfigEntity.ValidationAndGuidanceEntity.EducationalConfigurationEntity(mapCompoundTextResource(value.getGuidanceConfiguration().getTitle()), mapEducationalItems(value.getGuidanceConfiguration().getItems()), mapLayoutType(value.getGuidanceConfiguration().getLayoutType()))));
        }
        return linkedHashMap;
    }

    public final DocumentResourceConfigEntity.CaptureMethodTypeEntity mapCaptureMethodTypeToEntity(ResourceConfiguration.CaptureMethodType captureMethodType) {
        Intrinsics.checkNotNullParameter(captureMethodType, "captureMethodType");
        int i = WhenMappings.$EnumSwitchMapping$6[captureMethodType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return DocumentResourceConfigEntity.CaptureMethodTypeEntity.CAMERA_AND_UPLOAD;
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return DocumentResourceConfigEntity.CaptureMethodTypeEntity.CAMERA;
    }

    public final DocumentResourceConfigEntity.DocumentCaptureTypeEntity mapDocumentCaptureTypeToEntity(ResourceConfiguration.ResourceType documentCaptureType) throws YotiSdkIncompatibleError {
        Intrinsics.checkNotNullParameter(documentCaptureType, "documentCaptureType");
        int i = WhenMappings.$EnumSwitchMapping$5[documentCaptureType.ordinal()];
        if (i == 1) {
            return DocumentResourceConfigEntity.DocumentCaptureTypeEntity.ID_DOCUMENT;
        }
        if (i == 2) {
            return DocumentResourceConfigEntity.DocumentCaptureTypeEntity.SUPPLEMENTARY_DOCUMENT;
        }
        throw new YotiSdkIncompatibleError(new IllegalArgumentException("Incompatible resource type"));
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper
    public /* bridge */ /* synthetic */ ResourceConfigurationEntity mapResource(String str, StateTypeEntity stateTypeEntity, ResourceConfiguration resourceConfiguration, List list) {
        return mapResource(str, stateTypeEntity, resourceConfiguration, (List<? extends SourceTypeEntity>) list);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper
    protected DocumentResourceConfigEntity mapResource(String requirementId, StateTypeEntity state, ResourceConfiguration resourceConfiguration, List<? extends SourceTypeEntity> allowedSources) throws YotiSdkIncompatibleError {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(resourceConfiguration, "resourceConfiguration");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        List<DocumentResourceConfigEntity.CountryEntity> listMapCountries = mapCountries(resourceConfiguration.getSupportedCountries());
        DocumentResourceConfigEntity.DocumentCaptureTypeEntity documentCaptureTypeEntityMapDocumentCaptureTypeToEntity = mapDocumentCaptureTypeToEntity(resourceConfiguration.getType());
        DocumentResourceConfigEntity.CaptureMethodTypeEntity captureMethodTypeEntityMapCaptureMethodTypeToEntity = mapCaptureMethodTypeToEntity(resourceConfiguration.getCaptureMethodType());
        List<Task> tasks = resourceConfiguration.getTasks();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(tasks, 10));
        Iterator<T> it2 = tasks.iterator();
        while (it2.hasNext()) {
            arrayList.add(this.taskToEntityMapper.map((Task) it2.next()));
        }
        String presetIssuingCountry = resourceConfiguration.getPresetIssuingCountry();
        CaptureObjectiveTypeEntity map = this.objectiveTypeDataToEntityMapper.map(resourceConfiguration.getObjectiveType());
        Map<DocumentResourceConfigEntity.DocumentTypeEntity, DocumentResourceConfigEntity.ValidationAndGuidanceEntity> mapMapValidationAndGuidanceConfigurations = mapValidationAndGuidanceConfigurations(resourceConfiguration.getValidationAndGuidanceConfiguration());
        List<IbvClientAssessment> ibvClientAssessments = resourceConfiguration.getIbvClientAssessments();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ibvClientAssessments, 10));
        Iterator<T> it3 = ibvClientAssessments.iterator();
        while (it3.hasNext()) {
            arrayList2.add(mapIbvClientAssessment((IbvClientAssessment) it3.next()));
        }
        ApplicantProfile applicantProfile = resourceConfiguration.getApplicantProfile();
        return new DocumentResourceConfigEntity(requirementId, state, map, arrayList, listMapCountries, allowedSources, documentCaptureTypeEntityMapDocumentCaptureTypeToEntity, captureMethodTypeEntityMapCaptureMethodTypeToEntity, presetIssuingCountry, null, mapMapValidationAndGuidanceConfigurations, arrayList2, applicantProfile != null ? this.applicantProfileDataToEntityMapper.map(applicantProfile) : null, 512, null);
    }
}
