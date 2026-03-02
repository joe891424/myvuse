package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkIncompatibleError;
import com.yoti.mobile.android.yotidocs.common.extension.LocaleExtensionKt;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.domain.model.ApplicantProfileEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.CaptureObjectiveTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.FeatureTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.StateTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.TaskEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\f[\\]^_`abcdefB¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0\tHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0\tHÂ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003J\t\u0010Q\u001a\u00020\u0010HÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jµ\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010U\u001a\u0002022\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020YHÖ\u0001J\t\u0010Z\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b1\u00103R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00109R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006g"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "requirementId", "", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "objective", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "tasks", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskEntity;", "_countries", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CountryEntity;", "allowedSources", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "type", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "captureMethodType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CaptureMethodTypeEntity;", "presetIso3Code", "systemIso3Code", "validationAndGuidanceConfiguration", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;", "ibvClientAssessments", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "applicantProfileEntity", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CaptureMethodTypeEntity;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;)V", "getAllowedSources", "()Ljava/util/List;", "getApplicantProfileEntity", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/domain/model/ApplicantProfileEntity;", "getCaptureMethodType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CaptureMethodTypeEntity;", "countries", "getCountries", "country", "getCountry", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CountryEntity;", "document", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentEntity;", "getDocument", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentEntity;", "documentSchemeAssessment", "getDocumentSchemeAssessment", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "getIbvClientAssessments", "isValidationAndGuidanceEnabled", "", "()Z", "getObjective", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "preselectedCountry", "getPreselectedCountry", "getPresetIso3Code", "()Ljava/lang/String;", "getRequirementId", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "subType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureSubTypeEntity;", "getSubType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureSubTypeEntity;", "getSystemIso3Code", "getTasks", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "getValidationAndGuidanceConfiguration", "()Ljava/util/Map;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "AssessmentSchemeEntity", "AssessmentStateEntity", "AssessmentTypeEntity", "CaptureMethodTypeEntity", "CountryEntity", "DocumentCaptureSubTypeEntity", "DocumentCaptureTypeEntity", "DocumentEntity", "DocumentRequirementEntity", "DocumentTypeEntity", "IbvClientAssessmentEntity", "ValidationAndGuidanceEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentResourceConfigEntity extends ResourceConfigurationEntity {
    private final List<CountryEntity> _countries;
    private final List<SourceTypeEntity> allowedSources;
    private final ApplicantProfileEntity applicantProfileEntity;
    private final CaptureMethodTypeEntity captureMethodType;
    private final List<CountryEntity> countries;
    private final CountryEntity country;
    private final DocumentEntity document;
    private final IbvClientAssessmentEntity documentSchemeAssessment;
    private final List<IbvClientAssessmentEntity> ibvClientAssessments;
    private final boolean isValidationAndGuidanceEnabled;
    private final CaptureObjectiveTypeEntity objective;
    private final CountryEntity preselectedCountry;
    private final String presetIso3Code;
    private final String requirementId;
    private final StateTypeEntity state;
    private final DocumentCaptureSubTypeEntity subType;
    private final String systemIso3Code;
    private final List<TaskEntity> tasks;
    private final DocumentCaptureTypeEntity type;
    private final Map<DocumentTypeEntity, ValidationAndGuidanceEntity> validationAndGuidanceConfiguration;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "", "(Ljava/lang/String;I)V", "UK_DBS", "UK_GDS", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum AssessmentSchemeEntity {
        UK_DBS,
        UK_GDS,
        UNKNOWN
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "", "(Ljava/lang/String;I)V", "COMPLETE", "REQUIRED", "APPROVED", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum AssessmentStateEntity {
        COMPLETE,
        REQUIRED,
        APPROVED,
        UNKNOWN
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentTypeEntity;", "", "(Ljava/lang/String;I)V", "IBV_VISUAL_REVIEW_CHECK", "DOCUMENT_SCHEME_VALIDITY_CHECK", "PROFILE_DOCUMENT_MATCH_CHECK", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum AssessmentTypeEntity {
        IBV_VISUAL_REVIEW_CHECK,
        DOCUMENT_SCHEME_VALIDITY_CHECK,
        PROFILE_DOCUMENT_MATCH_CHECK,
        UNKNOWN
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CaptureMethodTypeEntity;", "", "(Ljava/lang/String;I)V", "CAMERA_AND_UPLOAD", "CAMERA", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum CaptureMethodTypeEntity {
        CAMERA_AND_UPLOAD,
        CAMERA
    }

    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$CountryEntity;", "", "iso3Code", "", "documents", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentEntity;", "(Ljava/lang/String;Ljava/util/List;)V", "getIso3Code", "()Ljava/lang/String;", "supportedDocuments", "getSupportedDocuments", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class CountryEntity {
        private final List<DocumentEntity> documents;
        private final String iso3Code;
        private final List<DocumentEntity> supportedDocuments;

        public CountryEntity(String iso3Code, List<DocumentEntity> documents) {
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(documents, "documents");
            this.iso3Code = iso3Code;
            this.documents = documents;
            ArrayList arrayList = new ArrayList();
            for (Object obj : documents) {
                if (((DocumentEntity) obj).getDocumentType().isSupported()) {
                    arrayList.add(obj);
                }
            }
            this.supportedDocuments = arrayList;
        }

        public /* synthetic */ CountryEntity(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        private final List<DocumentEntity> component2() {
            return this.documents;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CountryEntity copy$default(CountryEntity countryEntity, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = countryEntity.iso3Code;
            }
            if ((i & 2) != 0) {
                list = countryEntity.documents;
            }
            return countryEntity.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final CountryEntity copy(String iso3Code, List<DocumentEntity> documents) {
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(documents, "documents");
            return new CountryEntity(iso3Code, documents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CountryEntity)) {
                return false;
            }
            CountryEntity countryEntity = (CountryEntity) other;
            return Intrinsics.areEqual(this.iso3Code, countryEntity.iso3Code) && Intrinsics.areEqual(this.documents, countryEntity.documents);
        }

        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final List<DocumentEntity> getSupportedDocuments() {
            return this.supportedDocuments;
        }

        public int hashCode() {
            return (this.iso3Code.hashCode() * 31) + this.documents.hashCode();
        }

        public String toString() {
            return "CountryEntity(iso3Code=" + this.iso3Code + ", documents=" + this.documents + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureSubTypeEntity;", "", "(Ljava/lang/String;I)V", "FIXED_DOCUMENT", "SELECTABLE_DOCUMENT", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum DocumentCaptureSubTypeEntity {
        FIXED_DOCUMENT,
        SELECTABLE_DOCUMENT
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "", "feature", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "(Ljava/lang/String;ILcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;)V", "getFeature", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "ID_DOCUMENT", "SUPPLEMENTARY_DOCUMENT", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum DocumentCaptureTypeEntity {
        ID_DOCUMENT(FeatureTypeEntity.ID_DOCUMENT),
        SUPPLEMENTARY_DOCUMENT(FeatureTypeEntity.SUPPLEMENTARY_DOCUMENT);

        private final FeatureTypeEntity feature;

        DocumentCaptureTypeEntity(FeatureTypeEntity featureTypeEntity) {
            this.feature = featureTypeEntity;
        }

        public final FeatureTypeEntity getFeature() {
            return this.feature;
        }
    }

    @Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentEntity;", "", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "documentRequirements", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;Ljava/util/Set;)V", "getDocumentRequirements", "()Ljava/util/Set;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class DocumentEntity {
        private final Set<DocumentRequirementEntity> documentRequirements;
        private final DocumentTypeEntity documentType;

        /* JADX WARN: Multi-variable type inference failed */
        public DocumentEntity(DocumentTypeEntity documentType, Set<? extends DocumentRequirementEntity> documentRequirements) {
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            Intrinsics.checkNotNullParameter(documentRequirements, "documentRequirements");
            this.documentType = documentType;
            this.documentRequirements = documentRequirements;
        }

        public /* synthetic */ DocumentEntity(DocumentTypeEntity documentTypeEntity, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(documentTypeEntity, (i & 2) != 0 ? SetsKt.emptySet() : set);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DocumentEntity copy$default(DocumentEntity documentEntity, DocumentTypeEntity documentTypeEntity, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                documentTypeEntity = documentEntity.documentType;
            }
            if ((i & 2) != 0) {
                set = documentEntity.documentRequirements;
            }
            return documentEntity.copy(documentTypeEntity, set);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DocumentTypeEntity getDocumentType() {
            return this.documentType;
        }

        public final Set<DocumentRequirementEntity> component2() {
            return this.documentRequirements;
        }

        public final DocumentEntity copy(DocumentTypeEntity documentType, Set<? extends DocumentRequirementEntity> documentRequirements) {
            Intrinsics.checkNotNullParameter(documentType, "documentType");
            Intrinsics.checkNotNullParameter(documentRequirements, "documentRequirements");
            return new DocumentEntity(documentType, documentRequirements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DocumentEntity)) {
                return false;
            }
            DocumentEntity documentEntity = (DocumentEntity) other;
            return this.documentType == documentEntity.documentType && Intrinsics.areEqual(this.documentRequirements, documentEntity.documentRequirements);
        }

        public final Set<DocumentRequirementEntity> getDocumentRequirements() {
            return this.documentRequirements;
        }

        public final DocumentTypeEntity getDocumentType() {
            return this.documentType;
        }

        public int hashCode() {
            return (this.documentType.hashCode() * 31) + this.documentRequirements.hashCode();
        }

        public String toString() {
            return "DocumentEntity(documentType=" + this.documentType + ", documentRequirements=" + this.documentRequirements + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity;", "", "()V", "DateFromEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity$DateFromEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentRequirementEntity {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity$DateFromEntity;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentRequirementEntity;", "date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getDate", "()Ljava/util/Date;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class DateFromEntity extends DocumentRequirementEntity {
            private final Date date;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DateFromEntity(Date date) {
                super(null);
                Intrinsics.checkNotNullParameter(date, "date");
                this.date = date;
            }

            public static /* synthetic */ DateFromEntity copy$default(DateFromEntity dateFromEntity, Date date, int i, Object obj) {
                if ((i & 1) != 0) {
                    date = dateFromEntity.date;
                }
                return dateFromEntity.copy(date);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Date getDate() {
                return this.date;
            }

            public final DateFromEntity copy(Date date) {
                Intrinsics.checkNotNullParameter(date, "date");
                return new DateFromEntity(date);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DateFromEntity) && Intrinsics.areEqual(this.date, ((DateFromEntity) other).date);
            }

            public final Date getDate() {
                return this.date;
            }

            public int hashCode() {
                return this.date.hashCode();
            }

            public String toString() {
                return "DateFromEntity(date=" + this.date + ')';
            }
        }

        private DocumentRequirementEntity() {
        }

        public /* synthetic */ DocumentRequirementEntity(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PASSPORT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b,\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "", "documentCaptureType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "(Ljava/lang/String;ILcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;)V", "getDocumentCaptureType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentCaptureTypeEntity;", "isSupported", "", "PASSPORT", "DRIVING_LICENCE", "NATIONAL_ID", "STATE_ID", "MYKAD", "AADHAAR", "PAN", "SSS_ID_CARD", "POSTAL_ID", "RESIDENCE_PERMIT", "PROFESSIONAL_ID", "VOTER_ID", "HEALTH_CARD_QUEBEC", "NEXUS_CARD", "PHILSYS_ID", "UMID", "YOUNG_SCOT_CARD", "INDIAN_STATUS_CARD", "CITIZEN_CARD", "POST_OFFICE_PASS_CARD", "HEALTH_CARD", "UTILITY_BILL", "COUNCIL_TAX_BILL", "PHONE_BILL", "BANK_STATEMENT", "MILITARY_CARD", "SUPPLEMENTARY_PASS_CARD", "FIREARMS_LICENCE", "BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH", "BIRTH_CERTIFICATE", "ADOPTION_CERTIFICATE", "PAPER_DRIVING_LICENCE", "MARRIAGE_CERTIFICATE", "ACCOUNT_OPENING_LETTER", "BENEFIT_STATEMENT", "MORTGAGE_STATEMENT", "FINANCIAL_STATEMENT", "EMPLOYEE_TAX_FORM", "EMPLOYMENT_SPONSORSHIP_LETTER", "IMMIGRATION_DOCUMENT", "EDUCATION_LETTER", "DVLA_FORM", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentTypeEntity {
        private static final /* synthetic */ DocumentTypeEntity[] $VALUES;
        public static final DocumentTypeEntity AADHAAR;
        public static final DocumentTypeEntity ACCOUNT_OPENING_LETTER;
        public static final DocumentTypeEntity ADOPTION_CERTIFICATE;
        public static final DocumentTypeEntity BANK_STATEMENT;
        public static final DocumentTypeEntity BENEFIT_STATEMENT;
        public static final DocumentTypeEntity BIRTH_CERTIFICATE;
        public static final DocumentTypeEntity BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH;
        public static final DocumentTypeEntity CITIZEN_CARD;
        public static final DocumentTypeEntity COUNCIL_TAX_BILL;
        public static final DocumentTypeEntity DRIVING_LICENCE;
        public static final DocumentTypeEntity DVLA_FORM;
        public static final DocumentTypeEntity EDUCATION_LETTER;
        public static final DocumentTypeEntity EMPLOYEE_TAX_FORM;
        public static final DocumentTypeEntity EMPLOYMENT_SPONSORSHIP_LETTER;
        public static final DocumentTypeEntity FINANCIAL_STATEMENT;
        public static final DocumentTypeEntity FIREARMS_LICENCE;
        public static final DocumentTypeEntity HEALTH_CARD;
        public static final DocumentTypeEntity HEALTH_CARD_QUEBEC;
        public static final DocumentTypeEntity IMMIGRATION_DOCUMENT;
        public static final DocumentTypeEntity INDIAN_STATUS_CARD;
        public static final DocumentTypeEntity MARRIAGE_CERTIFICATE;
        public static final DocumentTypeEntity MILITARY_CARD;
        public static final DocumentTypeEntity MORTGAGE_STATEMENT;
        public static final DocumentTypeEntity MYKAD;
        public static final DocumentTypeEntity NATIONAL_ID;
        public static final DocumentTypeEntity NEXUS_CARD;
        public static final DocumentTypeEntity PAN;
        public static final DocumentTypeEntity PAPER_DRIVING_LICENCE;
        public static final DocumentTypeEntity PASSPORT;
        public static final DocumentTypeEntity PHILSYS_ID;
        public static final DocumentTypeEntity PHONE_BILL;
        public static final DocumentTypeEntity POSTAL_ID;
        public static final DocumentTypeEntity POST_OFFICE_PASS_CARD;
        public static final DocumentTypeEntity PROFESSIONAL_ID;
        public static final DocumentTypeEntity RESIDENCE_PERMIT;
        public static final DocumentTypeEntity SSS_ID_CARD;
        public static final DocumentTypeEntity STATE_ID;
        public static final DocumentTypeEntity SUPPLEMENTARY_PASS_CARD;
        public static final DocumentTypeEntity UMID;
        public static final DocumentTypeEntity UNKNOWN;
        public static final DocumentTypeEntity UTILITY_BILL;
        public static final DocumentTypeEntity VOTER_ID;
        public static final DocumentTypeEntity YOUNG_SCOT_CARD;
        private final DocumentCaptureTypeEntity documentCaptureType;

        private static final /* synthetic */ DocumentTypeEntity[] $values() {
            return new DocumentTypeEntity[]{PASSPORT, DRIVING_LICENCE, NATIONAL_ID, STATE_ID, MYKAD, AADHAAR, PAN, SSS_ID_CARD, POSTAL_ID, RESIDENCE_PERMIT, PROFESSIONAL_ID, VOTER_ID, HEALTH_CARD_QUEBEC, NEXUS_CARD, PHILSYS_ID, UMID, YOUNG_SCOT_CARD, INDIAN_STATUS_CARD, CITIZEN_CARD, POST_OFFICE_PASS_CARD, HEALTH_CARD, UTILITY_BILL, COUNCIL_TAX_BILL, PHONE_BILL, BANK_STATEMENT, MILITARY_CARD, SUPPLEMENTARY_PASS_CARD, FIREARMS_LICENCE, BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH, BIRTH_CERTIFICATE, ADOPTION_CERTIFICATE, PAPER_DRIVING_LICENCE, MARRIAGE_CERTIFICATE, ACCOUNT_OPENING_LETTER, BENEFIT_STATEMENT, MORTGAGE_STATEMENT, FINANCIAL_STATEMENT, EMPLOYEE_TAX_FORM, EMPLOYMENT_SPONSORSHIP_LETTER, IMMIGRATION_DOCUMENT, EDUCATION_LETTER, DVLA_FORM, UNKNOWN};
        }

        static {
            DocumentCaptureTypeEntity documentCaptureTypeEntity = DocumentCaptureTypeEntity.ID_DOCUMENT;
            PASSPORT = new DocumentTypeEntity("PASSPORT", 0, documentCaptureTypeEntity);
            DRIVING_LICENCE = new DocumentTypeEntity("DRIVING_LICENCE", 1, documentCaptureTypeEntity);
            NATIONAL_ID = new DocumentTypeEntity("NATIONAL_ID", 2, documentCaptureTypeEntity);
            STATE_ID = new DocumentTypeEntity("STATE_ID", 3, documentCaptureTypeEntity);
            MYKAD = new DocumentTypeEntity("MYKAD", 4, documentCaptureTypeEntity);
            AADHAAR = new DocumentTypeEntity("AADHAAR", 5, documentCaptureTypeEntity);
            PAN = new DocumentTypeEntity("PAN", 6, documentCaptureTypeEntity);
            SSS_ID_CARD = new DocumentTypeEntity("SSS_ID_CARD", 7, documentCaptureTypeEntity);
            POSTAL_ID = new DocumentTypeEntity("POSTAL_ID", 8, documentCaptureTypeEntity);
            RESIDENCE_PERMIT = new DocumentTypeEntity("RESIDENCE_PERMIT", 9, documentCaptureTypeEntity);
            PROFESSIONAL_ID = new DocumentTypeEntity("PROFESSIONAL_ID", 10, documentCaptureTypeEntity);
            VOTER_ID = new DocumentTypeEntity("VOTER_ID", 11, documentCaptureTypeEntity);
            HEALTH_CARD_QUEBEC = new DocumentTypeEntity("HEALTH_CARD_QUEBEC", 12, documentCaptureTypeEntity);
            NEXUS_CARD = new DocumentTypeEntity("NEXUS_CARD", 13, documentCaptureTypeEntity);
            PHILSYS_ID = new DocumentTypeEntity("PHILSYS_ID", 14, documentCaptureTypeEntity);
            UMID = new DocumentTypeEntity("UMID", 15, documentCaptureTypeEntity);
            YOUNG_SCOT_CARD = new DocumentTypeEntity("YOUNG_SCOT_CARD", 16, documentCaptureTypeEntity);
            INDIAN_STATUS_CARD = new DocumentTypeEntity("INDIAN_STATUS_CARD", 17, documentCaptureTypeEntity);
            CITIZEN_CARD = new DocumentTypeEntity("CITIZEN_CARD", 18, documentCaptureTypeEntity);
            POST_OFFICE_PASS_CARD = new DocumentTypeEntity("POST_OFFICE_PASS_CARD", 19, documentCaptureTypeEntity);
            HEALTH_CARD = new DocumentTypeEntity("HEALTH_CARD", 20, documentCaptureTypeEntity);
            DocumentCaptureTypeEntity documentCaptureTypeEntity2 = DocumentCaptureTypeEntity.SUPPLEMENTARY_DOCUMENT;
            UTILITY_BILL = new DocumentTypeEntity("UTILITY_BILL", 21, documentCaptureTypeEntity2);
            COUNCIL_TAX_BILL = new DocumentTypeEntity("COUNCIL_TAX_BILL", 22, documentCaptureTypeEntity2);
            PHONE_BILL = new DocumentTypeEntity("PHONE_BILL", 23, documentCaptureTypeEntity2);
            BANK_STATEMENT = new DocumentTypeEntity("BANK_STATEMENT", 24, documentCaptureTypeEntity2);
            MILITARY_CARD = new DocumentTypeEntity("MILITARY_CARD", 25, documentCaptureTypeEntity2);
            SUPPLEMENTARY_PASS_CARD = new DocumentTypeEntity("SUPPLEMENTARY_PASS_CARD", 26, documentCaptureTypeEntity2);
            FIREARMS_LICENCE = new DocumentTypeEntity("FIREARMS_LICENCE", 27, documentCaptureTypeEntity2);
            BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH = new DocumentTypeEntity("BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH", 28, documentCaptureTypeEntity2);
            BIRTH_CERTIFICATE = new DocumentTypeEntity("BIRTH_CERTIFICATE", 29, documentCaptureTypeEntity2);
            ADOPTION_CERTIFICATE = new DocumentTypeEntity("ADOPTION_CERTIFICATE", 30, documentCaptureTypeEntity2);
            PAPER_DRIVING_LICENCE = new DocumentTypeEntity("PAPER_DRIVING_LICENCE", 31, documentCaptureTypeEntity2);
            MARRIAGE_CERTIFICATE = new DocumentTypeEntity("MARRIAGE_CERTIFICATE", 32, documentCaptureTypeEntity2);
            ACCOUNT_OPENING_LETTER = new DocumentTypeEntity("ACCOUNT_OPENING_LETTER", 33, documentCaptureTypeEntity2);
            BENEFIT_STATEMENT = new DocumentTypeEntity("BENEFIT_STATEMENT", 34, documentCaptureTypeEntity2);
            MORTGAGE_STATEMENT = new DocumentTypeEntity("MORTGAGE_STATEMENT", 35, documentCaptureTypeEntity2);
            FINANCIAL_STATEMENT = new DocumentTypeEntity("FINANCIAL_STATEMENT", 36, documentCaptureTypeEntity2);
            EMPLOYEE_TAX_FORM = new DocumentTypeEntity("EMPLOYEE_TAX_FORM", 37, documentCaptureTypeEntity2);
            EMPLOYMENT_SPONSORSHIP_LETTER = new DocumentTypeEntity("EMPLOYMENT_SPONSORSHIP_LETTER", 38, documentCaptureTypeEntity2);
            IMMIGRATION_DOCUMENT = new DocumentTypeEntity("IMMIGRATION_DOCUMENT", 39, documentCaptureTypeEntity2);
            EDUCATION_LETTER = new DocumentTypeEntity("EDUCATION_LETTER", 40, documentCaptureTypeEntity2);
            DVLA_FORM = new DocumentTypeEntity("DVLA_FORM", 41, documentCaptureTypeEntity2);
            UNKNOWN = new DocumentTypeEntity("UNKNOWN", 42, null);
            $VALUES = $values();
        }

        private DocumentTypeEntity(String str, int i, DocumentCaptureTypeEntity documentCaptureTypeEntity) {
            this.documentCaptureType = documentCaptureTypeEntity;
        }

        public static DocumentTypeEntity valueOf(String str) {
            return (DocumentTypeEntity) Enum.valueOf(DocumentTypeEntity.class, str);
        }

        public static DocumentTypeEntity[] values() {
            return (DocumentTypeEntity[]) $VALUES.clone();
        }

        public final DocumentCaptureTypeEntity getDocumentCaptureType() {
            return this.documentCaptureType;
        }

        public final boolean isSupported() {
            return this != UNKNOWN;
        }
    }

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "", "type", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentTypeEntity;", "scheme", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "state", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;)V", "getScheme", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentSchemeEntity;", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentStateEntity;", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$AssessmentTypeEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class IbvClientAssessmentEntity {
        private final AssessmentSchemeEntity scheme;
        private final AssessmentStateEntity state;
        private final AssessmentTypeEntity type;

        public IbvClientAssessmentEntity(AssessmentTypeEntity type, AssessmentSchemeEntity scheme, AssessmentStateEntity state) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Intrinsics.checkNotNullParameter(state, "state");
            this.type = type;
            this.scheme = scheme;
            this.state = state;
        }

        public static /* synthetic */ IbvClientAssessmentEntity copy$default(IbvClientAssessmentEntity ibvClientAssessmentEntity, AssessmentTypeEntity assessmentTypeEntity, AssessmentSchemeEntity assessmentSchemeEntity, AssessmentStateEntity assessmentStateEntity, int i, Object obj) {
            if ((i & 1) != 0) {
                assessmentTypeEntity = ibvClientAssessmentEntity.type;
            }
            if ((i & 2) != 0) {
                assessmentSchemeEntity = ibvClientAssessmentEntity.scheme;
            }
            if ((i & 4) != 0) {
                assessmentStateEntity = ibvClientAssessmentEntity.state;
            }
            return ibvClientAssessmentEntity.copy(assessmentTypeEntity, assessmentSchemeEntity, assessmentStateEntity);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AssessmentTypeEntity getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AssessmentSchemeEntity getScheme() {
            return this.scheme;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final AssessmentStateEntity getState() {
            return this.state;
        }

        public final IbvClientAssessmentEntity copy(AssessmentTypeEntity type, AssessmentSchemeEntity scheme, AssessmentStateEntity state) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Intrinsics.checkNotNullParameter(state, "state");
            return new IbvClientAssessmentEntity(type, scheme, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IbvClientAssessmentEntity)) {
                return false;
            }
            IbvClientAssessmentEntity ibvClientAssessmentEntity = (IbvClientAssessmentEntity) other;
            return this.type == ibvClientAssessmentEntity.type && this.scheme == ibvClientAssessmentEntity.scheme && this.state == ibvClientAssessmentEntity.state;
        }

        public final AssessmentSchemeEntity getScheme() {
            return this.scheme;
        }

        public final AssessmentStateEntity getState() {
            return this.state;
        }

        public final AssessmentTypeEntity getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.scheme.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IbvClientAssessmentEntity(type=" + this.type + ", scheme=" + this.scheme + ", state=" + this.state + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity;", "", "validationConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity;", "guidanceConfiguration", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity;)V", "getGuidanceConfiguration", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity;", "getValidationConfiguration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CompoundTextEntity", "DynamicValueTypeEntity", "EducationalConfigurationEntity", "EducationalItemEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class ValidationAndGuidanceEntity {
        private final EducationalConfigurationEntity guidanceConfiguration;
        private final EducationalConfigurationEntity validationConfiguration;

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "", "stringResId", "", "dynamicValues", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$DynamicValueTypeEntity;", "colorAttrRes", "(ILjava/util/List;Ljava/lang/Integer;)V", "getColorAttrRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDynamicValues", "()Ljava/util/List;", "getStringResId", "()I", "component1", "component2", "component3", "copy", "(ILjava/util/List;Ljava/lang/Integer;)Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "equals", "", "other", "hashCode", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class CompoundTextEntity {
            private final Integer colorAttrRes;
            private final List<DynamicValueTypeEntity> dynamicValues;
            private final int stringResId;

            /* JADX WARN: Multi-variable type inference failed */
            public CompoundTextEntity(int i, List<? extends DynamicValueTypeEntity> dynamicValues, Integer num) {
                Intrinsics.checkNotNullParameter(dynamicValues, "dynamicValues");
                this.stringResId = i;
                this.dynamicValues = dynamicValues;
                this.colorAttrRes = num;
            }

            public /* synthetic */ CompoundTextEntity(int i, List list, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : num);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CompoundTextEntity copy$default(CompoundTextEntity compoundTextEntity, int i, List list, Integer num, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = compoundTextEntity.stringResId;
                }
                if ((i2 & 2) != 0) {
                    list = compoundTextEntity.dynamicValues;
                }
                if ((i2 & 4) != 0) {
                    num = compoundTextEntity.colorAttrRes;
                }
                return compoundTextEntity.copy(i, list, num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            public final List<DynamicValueTypeEntity> component2() {
                return this.dynamicValues;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getColorAttrRes() {
                return this.colorAttrRes;
            }

            public final CompoundTextEntity copy(int stringResId, List<? extends DynamicValueTypeEntity> dynamicValues, Integer colorAttrRes) {
                Intrinsics.checkNotNullParameter(dynamicValues, "dynamicValues");
                return new CompoundTextEntity(stringResId, dynamicValues, colorAttrRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CompoundTextEntity)) {
                    return false;
                }
                CompoundTextEntity compoundTextEntity = (CompoundTextEntity) other;
                return this.stringResId == compoundTextEntity.stringResId && Intrinsics.areEqual(this.dynamicValues, compoundTextEntity.dynamicValues) && Intrinsics.areEqual(this.colorAttrRes, compoundTextEntity.colorAttrRes);
            }

            public final Integer getColorAttrRes() {
                return this.colorAttrRes;
            }

            public final List<DynamicValueTypeEntity> getDynamicValues() {
                return this.dynamicValues;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            public int hashCode() {
                int iHashCode = ((Integer.hashCode(this.stringResId) * 31) + this.dynamicValues.hashCode()) * 31;
                Integer num = this.colorAttrRes;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            public String toString() {
                return "CompoundTextEntity(stringResId=" + this.stringResId + ", dynamicValues=" + this.dynamicValues + ", colorAttrRes=" + this.colorAttrRes + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$DynamicValueTypeEntity;", "", "(Ljava/lang/String;I)V", "DOCUMENT_NAME", "COUNTRY_NAME", "APPLICANT_FULL_NAME", "APPLICANT_ADDRESS", "APPLICANT_DATE_OF_BIRTH", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public enum DynamicValueTypeEntity {
            DOCUMENT_NAME,
            COUNTRY_NAME,
            APPLICANT_FULL_NAME,
            APPLICANT_ADDRESS,
            APPLICANT_DATE_OF_BIRTH
        }

        @Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity;", "", "title", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalItemEntity;", "layoutType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity$LayoutTypeEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity$LayoutTypeEntity;)V", "getItems", "()Ljava/util/List;", "getLayoutType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity$LayoutTypeEntity;", "getTitle", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "LayoutTypeEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class EducationalConfigurationEntity {
            private final List<EducationalItemEntity> items;
            private final LayoutTypeEntity layoutType;
            private final CompoundTextEntity title;

            @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalConfigurationEntity$LayoutTypeEntity;", "", "(Ljava/lang/String;I)V", "GRID", "LIST", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public enum LayoutTypeEntity {
                GRID,
                LIST
            }

            public EducationalConfigurationEntity(CompoundTextEntity title, List<EducationalItemEntity> items, LayoutTypeEntity layoutType) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                Intrinsics.checkNotNullParameter(layoutType, "layoutType");
                this.title = title;
                this.items = items;
                this.layoutType = layoutType;
            }

            public /* synthetic */ EducationalConfigurationEntity(CompoundTextEntity compoundTextEntity, List list, LayoutTypeEntity layoutTypeEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(compoundTextEntity, list, (i & 4) != 0 ? LayoutTypeEntity.LIST : layoutTypeEntity);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EducationalConfigurationEntity copy$default(EducationalConfigurationEntity educationalConfigurationEntity, CompoundTextEntity compoundTextEntity, List list, LayoutTypeEntity layoutTypeEntity, int i, Object obj) {
                if ((i & 1) != 0) {
                    compoundTextEntity = educationalConfigurationEntity.title;
                }
                if ((i & 2) != 0) {
                    list = educationalConfigurationEntity.items;
                }
                if ((i & 4) != 0) {
                    layoutTypeEntity = educationalConfigurationEntity.layoutType;
                }
                return educationalConfigurationEntity.copy(compoundTextEntity, list, layoutTypeEntity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CompoundTextEntity getTitle() {
                return this.title;
            }

            public final List<EducationalItemEntity> component2() {
                return this.items;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final LayoutTypeEntity getLayoutType() {
                return this.layoutType;
            }

            public final EducationalConfigurationEntity copy(CompoundTextEntity title, List<EducationalItemEntity> items, LayoutTypeEntity layoutType) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(items, "items");
                Intrinsics.checkNotNullParameter(layoutType, "layoutType");
                return new EducationalConfigurationEntity(title, items, layoutType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EducationalConfigurationEntity)) {
                    return false;
                }
                EducationalConfigurationEntity educationalConfigurationEntity = (EducationalConfigurationEntity) other;
                return Intrinsics.areEqual(this.title, educationalConfigurationEntity.title) && Intrinsics.areEqual(this.items, educationalConfigurationEntity.items) && this.layoutType == educationalConfigurationEntity.layoutType;
            }

            public final List<EducationalItemEntity> getItems() {
                return this.items;
            }

            public final LayoutTypeEntity getLayoutType() {
                return this.layoutType;
            }

            public final CompoundTextEntity getTitle() {
                return this.title;
            }

            public int hashCode() {
                return (((this.title.hashCode() * 31) + this.items.hashCode()) * 31) + this.layoutType.hashCode();
            }

            public String toString() {
                return "EducationalConfigurationEntity(title=" + this.title + ", items=" + this.items + ", layoutType=" + this.layoutType + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$EducationalItemEntity;", "", "iconResId", "", "titleResId", "text", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "textSecondary", "(IILcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;)V", "getIconResId", "()I", "getText", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$ValidationAndGuidanceEntity$CompoundTextEntity;", "getTextSecondary", "getTitleResId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class EducationalItemEntity {
            private final int iconResId;
            private final CompoundTextEntity text;
            private final CompoundTextEntity textSecondary;
            private final int titleResId;

            public EducationalItemEntity(int i, int i2, CompoundTextEntity compoundTextEntity, CompoundTextEntity compoundTextEntity2) {
                this.iconResId = i;
                this.titleResId = i2;
                this.text = compoundTextEntity;
                this.textSecondary = compoundTextEntity2;
            }

            public /* synthetic */ EducationalItemEntity(int i, int i2, CompoundTextEntity compoundTextEntity, CompoundTextEntity compoundTextEntity2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, i2, (i3 & 4) != 0 ? null : compoundTextEntity, (i3 & 8) != 0 ? null : compoundTextEntity2);
            }

            public static /* synthetic */ EducationalItemEntity copy$default(EducationalItemEntity educationalItemEntity, int i, int i2, CompoundTextEntity compoundTextEntity, CompoundTextEntity compoundTextEntity2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = educationalItemEntity.iconResId;
                }
                if ((i3 & 2) != 0) {
                    i2 = educationalItemEntity.titleResId;
                }
                if ((i3 & 4) != 0) {
                    compoundTextEntity = educationalItemEntity.text;
                }
                if ((i3 & 8) != 0) {
                    compoundTextEntity2 = educationalItemEntity.textSecondary;
                }
                return educationalItemEntity.copy(i, i2, compoundTextEntity, compoundTextEntity2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getIconResId() {
                return this.iconResId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getTitleResId() {
                return this.titleResId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final CompoundTextEntity getText() {
                return this.text;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final CompoundTextEntity getTextSecondary() {
                return this.textSecondary;
            }

            public final EducationalItemEntity copy(int iconResId, int titleResId, CompoundTextEntity text, CompoundTextEntity textSecondary) {
                return new EducationalItemEntity(iconResId, titleResId, text, textSecondary);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EducationalItemEntity)) {
                    return false;
                }
                EducationalItemEntity educationalItemEntity = (EducationalItemEntity) other;
                return this.iconResId == educationalItemEntity.iconResId && this.titleResId == educationalItemEntity.titleResId && Intrinsics.areEqual(this.text, educationalItemEntity.text) && Intrinsics.areEqual(this.textSecondary, educationalItemEntity.textSecondary);
            }

            public final int getIconResId() {
                return this.iconResId;
            }

            public final CompoundTextEntity getText() {
                return this.text;
            }

            public final CompoundTextEntity getTextSecondary() {
                return this.textSecondary;
            }

            public final int getTitleResId() {
                return this.titleResId;
            }

            public int hashCode() {
                int iHashCode = ((Integer.hashCode(this.iconResId) * 31) + Integer.hashCode(this.titleResId)) * 31;
                CompoundTextEntity compoundTextEntity = this.text;
                int iHashCode2 = (iHashCode + (compoundTextEntity == null ? 0 : compoundTextEntity.hashCode())) * 31;
                CompoundTextEntity compoundTextEntity2 = this.textSecondary;
                return iHashCode2 + (compoundTextEntity2 != null ? compoundTextEntity2.hashCode() : 0);
            }

            public String toString() {
                return "EducationalItemEntity(iconResId=" + this.iconResId + ", titleResId=" + this.titleResId + ", text=" + this.text + ", textSecondary=" + this.textSecondary + ')';
            }
        }

        public ValidationAndGuidanceEntity(EducationalConfigurationEntity validationConfiguration, EducationalConfigurationEntity guidanceConfiguration) {
            Intrinsics.checkNotNullParameter(validationConfiguration, "validationConfiguration");
            Intrinsics.checkNotNullParameter(guidanceConfiguration, "guidanceConfiguration");
            this.validationConfiguration = validationConfiguration;
            this.guidanceConfiguration = guidanceConfiguration;
        }

        public static /* synthetic */ ValidationAndGuidanceEntity copy$default(ValidationAndGuidanceEntity validationAndGuidanceEntity, EducationalConfigurationEntity educationalConfigurationEntity, EducationalConfigurationEntity educationalConfigurationEntity2, int i, Object obj) {
            if ((i & 1) != 0) {
                educationalConfigurationEntity = validationAndGuidanceEntity.validationConfiguration;
            }
            if ((i & 2) != 0) {
                educationalConfigurationEntity2 = validationAndGuidanceEntity.guidanceConfiguration;
            }
            return validationAndGuidanceEntity.copy(educationalConfigurationEntity, educationalConfigurationEntity2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EducationalConfigurationEntity getValidationConfiguration() {
            return this.validationConfiguration;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EducationalConfigurationEntity getGuidanceConfiguration() {
            return this.guidanceConfiguration;
        }

        public final ValidationAndGuidanceEntity copy(EducationalConfigurationEntity validationConfiguration, EducationalConfigurationEntity guidanceConfiguration) {
            Intrinsics.checkNotNullParameter(validationConfiguration, "validationConfiguration");
            Intrinsics.checkNotNullParameter(guidanceConfiguration, "guidanceConfiguration");
            return new ValidationAndGuidanceEntity(validationConfiguration, guidanceConfiguration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationAndGuidanceEntity)) {
                return false;
            }
            ValidationAndGuidanceEntity validationAndGuidanceEntity = (ValidationAndGuidanceEntity) other;
            return Intrinsics.areEqual(this.validationConfiguration, validationAndGuidanceEntity.validationConfiguration) && Intrinsics.areEqual(this.guidanceConfiguration, validationAndGuidanceEntity.guidanceConfiguration);
        }

        public final EducationalConfigurationEntity getGuidanceConfiguration() {
            return this.guidanceConfiguration;
        }

        public final EducationalConfigurationEntity getValidationConfiguration() {
            return this.validationConfiguration;
        }

        public int hashCode() {
            return (this.validationConfiguration.hashCode() * 31) + this.guidanceConfiguration.hashCode();
        }

        public String toString() {
            return "ValidationAndGuidanceEntity(validationConfiguration=" + this.validationConfiguration + ", guidanceConfiguration=" + this.guidanceConfiguration + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v0, types: [java.lang.Object, java.util.List<? extends com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity>, java.util.List<com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Set, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public DocumentResourceConfigEntity(String requirementId, StateTypeEntity state, CaptureObjectiveTypeEntity objective, List<TaskEntity> tasks, List<CountryEntity> _countries, List<? extends SourceTypeEntity> allowedSources, DocumentCaptureTypeEntity type, CaptureMethodTypeEntity captureMethodType, String str, String str2, Map<DocumentTypeEntity, ValidationAndGuidanceEntity> validationAndGuidanceConfiguration, List<IbvClientAssessmentEntity> ibvClientAssessments, ApplicantProfileEntity applicantProfileEntity) throws YotiSdkIncompatibleError {
        ?? r3;
        Object next;
        Object next2;
        Object next3;
        List<DocumentEntity> supportedDocuments;
        Object next4;
        Object next5;
        Object next6;
        super(type.getFeature(), type == DocumentCaptureTypeEntity.ID_DOCUMENT);
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(_countries, "_countries");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(captureMethodType, "captureMethodType");
        Intrinsics.checkNotNullParameter(validationAndGuidanceConfiguration, "validationAndGuidanceConfiguration");
        Intrinsics.checkNotNullParameter(ibvClientAssessments, "ibvClientAssessments");
        this.requirementId = requirementId;
        this.state = state;
        this.objective = objective;
        this.tasks = tasks;
        this._countries = _countries;
        this.allowedSources = allowedSources;
        this.type = type;
        this.captureMethodType = captureMethodType;
        this.presetIso3Code = str;
        this.systemIso3Code = str2;
        this.validationAndGuidanceConfiguration = validationAndGuidanceConfiguration;
        this.ibvClientAssessments = ibvClientAssessments;
        this.applicantProfileEntity = applicantProfileEntity;
        Iterator it2 = _countries.iterator();
        while (true) {
            r3 = 0;
            r3 = 0;
            if (it2.hasNext()) {
                next = it2.next();
                if (!((CountryEntity) next).getSupportedDocuments().isEmpty()) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        if (next == null) {
            throw new YotiSdkIncompatibleError(new IllegalStateException("There are no compatible documents in the requirement"));
        }
        List<CountryEntity> list = this._countries;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                List<DocumentEntity> supportedDocuments2 = ((CountryEntity) it3.next()).getSupportedDocuments();
                if (!(supportedDocuments2 instanceof Collection) || !supportedDocuments2.isEmpty()) {
                    Iterator it4 = supportedDocuments2.iterator();
                    while (it4.hasNext()) {
                        if (((DocumentEntity) it4.next()).getDocumentType().getDocumentCaptureType() != this.type) {
                            throw new IllegalStateException(("Incompatible documents detected for type " + this.type).toString());
                        }
                    }
                }
            }
        }
        List<CountryEntity> list2 = this._countries;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (!((CountryEntity) obj).getSupportedDocuments().isEmpty()) {
                arrayList.add(obj);
            }
        }
        this.countries = arrayList;
        this.country = (CountryEntity) CollectionsKt.singleOrNull((List) arrayList);
        DocumentEntity documentEntity = (DocumentEntity) CollectionsKt.first((List) ((CountryEntity) CollectionsKt.first((List) arrayList)).getSupportedDocuments());
        Iterator it5 = arrayList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it5.next();
            Iterator it6 = ((CountryEntity) next2).getSupportedDocuments().iterator();
            while (true) {
                if (it6.hasNext()) {
                    next6 = it6.next();
                    if (((DocumentEntity) next6).getDocumentType() != documentEntity.getDocumentType()) {
                        break;
                    }
                } else {
                    next6 = null;
                    break;
                }
            }
            if (next6 != null) {
                break;
            }
        }
        this.document = ((CountryEntity) next2) != null ? new DocumentEntity(DocumentTypeEntity.UNKNOWN, r3, 2, r3) : documentEntity;
        Iterator it7 = this.ibvClientAssessments.iterator();
        while (true) {
            if (it7.hasNext()) {
                next3 = it7.next();
                if (((IbvClientAssessmentEntity) next3).getType() == AssessmentTypeEntity.DOCUMENT_SCHEME_VALIDITY_CHECK) {
                    break;
                }
            } else {
                next3 = null;
                break;
            }
        }
        this.documentSchemeAssessment = (IbvClientAssessmentEntity) next3;
        CountryEntity countryEntity = this.country;
        if (countryEntity == null) {
            Iterator it8 = this.countries.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    next4 = null;
                    break;
                }
                next4 = it8.next();
                CountryEntity countryEntity2 = (CountryEntity) next4;
                if (Intrinsics.areEqual(countryEntity2.getIso3Code(), this.presetIso3Code) && !countryEntity2.getSupportedDocuments().isEmpty()) {
                    break;
                }
            }
            countryEntity = (CountryEntity) next4;
            if (countryEntity == null) {
                Iterator it9 = this.countries.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it9.next();
                    CountryEntity countryEntity3 = (CountryEntity) next5;
                    if (Intrinsics.areEqual(countryEntity3.getIso3Code(), this.systemIso3Code) && !countryEntity3.getSupportedDocuments().isEmpty()) {
                        break;
                    }
                }
                countryEntity = (CountryEntity) next5;
            }
        }
        this.preselectedCountry = countryEntity;
        CountryEntity countryEntity4 = this.country;
        if (countryEntity4 != null && (supportedDocuments = countryEntity4.getSupportedDocuments()) != null) {
            r3 = (DocumentEntity) CollectionsKt.singleOrNull((List) supportedDocuments);
        }
        DocumentCaptureSubTypeEntity documentCaptureSubTypeEntity = r3 != 0 ? DocumentCaptureSubTypeEntity.FIXED_DOCUMENT : DocumentCaptureSubTypeEntity.SELECTABLE_DOCUMENT;
        this.subType = documentCaptureSubTypeEntity;
        this.isValidationAndGuidanceEnabled = documentCaptureSubTypeEntity == DocumentCaptureSubTypeEntity.FIXED_DOCUMENT && this.validationAndGuidanceConfiguration.get(this.document.getDocumentType()) != null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DocumentResourceConfigEntity(String str, StateTypeEntity stateTypeEntity, CaptureObjectiveTypeEntity captureObjectiveTypeEntity, List list, List list2, List list3, DocumentCaptureTypeEntity documentCaptureTypeEntity, CaptureMethodTypeEntity captureMethodTypeEntity, String str2, String str3, Map map, List list4, ApplicantProfileEntity applicantProfileEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String iSO3Country;
        String str4 = (i & 256) != 0 ? null : str2;
        if ((i & 512) != 0) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            Locale localeValidate = LocaleExtensionKt.validate(locale);
            iSO3Country = localeValidate != null ? localeValidate.getISO3Country() : null;
        } else {
            iSO3Country = str3;
        }
        this(str, stateTypeEntity, captureObjectiveTypeEntity, list, list2, list3, documentCaptureTypeEntity, captureMethodTypeEntity, str4, iSO3Country, (i & 1024) != 0 ? MapsKt.emptyMap() : map, (i & 2048) != 0 ? CollectionsKt.emptyList() : list4, (i & 4096) != 0 ? null : applicantProfileEntity);
    }

    private final List<CountryEntity> component5() {
        return this._countries;
    }

    public final String component1() {
        return getRequirementId();
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSystemIso3Code() {
        return this.systemIso3Code;
    }

    public final Map<DocumentTypeEntity, ValidationAndGuidanceEntity> component11() {
        return this.validationAndGuidanceConfiguration;
    }

    public final List<IbvClientAssessmentEntity> component12() {
        return this.ibvClientAssessments;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final ApplicantProfileEntity getApplicantProfileEntity() {
        return this.applicantProfileEntity;
    }

    public final StateTypeEntity component2() {
        return getState();
    }

    public final CaptureObjectiveTypeEntity component3() {
        return getObjective();
    }

    public final List<TaskEntity> component4() {
        return getTasks();
    }

    public final List<SourceTypeEntity> component6() {
        return getAllowedSources();
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DocumentCaptureTypeEntity getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CaptureMethodTypeEntity getCaptureMethodType() {
        return this.captureMethodType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPresetIso3Code() {
        return this.presetIso3Code;
    }

    public final DocumentResourceConfigEntity copy(String requirementId, StateTypeEntity state, CaptureObjectiveTypeEntity objective, List<TaskEntity> tasks, List<CountryEntity> _countries, List<? extends SourceTypeEntity> allowedSources, DocumentCaptureTypeEntity type, CaptureMethodTypeEntity captureMethodType, String presetIso3Code, String systemIso3Code, Map<DocumentTypeEntity, ValidationAndGuidanceEntity> validationAndGuidanceConfiguration, List<IbvClientAssessmentEntity> ibvClientAssessments, ApplicantProfileEntity applicantProfileEntity) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(_countries, "_countries");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(captureMethodType, "captureMethodType");
        Intrinsics.checkNotNullParameter(validationAndGuidanceConfiguration, "validationAndGuidanceConfiguration");
        Intrinsics.checkNotNullParameter(ibvClientAssessments, "ibvClientAssessments");
        return new DocumentResourceConfigEntity(requirementId, state, objective, tasks, _countries, allowedSources, type, captureMethodType, presetIso3Code, systemIso3Code, validationAndGuidanceConfiguration, ibvClientAssessments, applicantProfileEntity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentResourceConfigEntity)) {
            return false;
        }
        DocumentResourceConfigEntity documentResourceConfigEntity = (DocumentResourceConfigEntity) other;
        return Intrinsics.areEqual(getRequirementId(), documentResourceConfigEntity.getRequirementId()) && getState() == documentResourceConfigEntity.getState() && getObjective() == documentResourceConfigEntity.getObjective() && Intrinsics.areEqual(getTasks(), documentResourceConfigEntity.getTasks()) && Intrinsics.areEqual(this._countries, documentResourceConfigEntity._countries) && Intrinsics.areEqual(getAllowedSources(), documentResourceConfigEntity.getAllowedSources()) && this.type == documentResourceConfigEntity.type && this.captureMethodType == documentResourceConfigEntity.captureMethodType && Intrinsics.areEqual(this.presetIso3Code, documentResourceConfigEntity.presetIso3Code) && Intrinsics.areEqual(this.systemIso3Code, documentResourceConfigEntity.systemIso3Code) && Intrinsics.areEqual(this.validationAndGuidanceConfiguration, documentResourceConfigEntity.validationAndGuidanceConfiguration) && Intrinsics.areEqual(this.ibvClientAssessments, documentResourceConfigEntity.ibvClientAssessments) && Intrinsics.areEqual(this.applicantProfileEntity, documentResourceConfigEntity.applicantProfileEntity);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public List<SourceTypeEntity> getAllowedSources() {
        return this.allowedSources;
    }

    public final ApplicantProfileEntity getApplicantProfileEntity() {
        return this.applicantProfileEntity;
    }

    public final CaptureMethodTypeEntity getCaptureMethodType() {
        return this.captureMethodType;
    }

    public final List<CountryEntity> getCountries() {
        return this.countries;
    }

    public final CountryEntity getCountry() {
        return this.country;
    }

    public final DocumentEntity getDocument() {
        return this.document;
    }

    public final IbvClientAssessmentEntity getDocumentSchemeAssessment() {
        return this.documentSchemeAssessment;
    }

    public final List<IbvClientAssessmentEntity> getIbvClientAssessments() {
        return this.ibvClientAssessments;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public CaptureObjectiveTypeEntity getObjective() {
        return this.objective;
    }

    public final CountryEntity getPreselectedCountry() {
        return this.preselectedCountry;
    }

    public final String getPresetIso3Code() {
        return this.presetIso3Code;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public String getRequirementId() {
        return this.requirementId;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public StateTypeEntity getState() {
        return this.state;
    }

    public final DocumentCaptureSubTypeEntity getSubType() {
        return this.subType;
    }

    public final String getSystemIso3Code() {
        return this.systemIso3Code;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public List<TaskEntity> getTasks() {
        return this.tasks;
    }

    public final DocumentCaptureTypeEntity getType() {
        return this.type;
    }

    public final Map<DocumentTypeEntity, ValidationAndGuidanceEntity> getValidationAndGuidanceConfiguration() {
        return this.validationAndGuidanceConfiguration;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((getRequirementId().hashCode() * 31) + getState().hashCode()) * 31) + getObjective().hashCode()) * 31) + getTasks().hashCode()) * 31) + this._countries.hashCode()) * 31) + getAllowedSources().hashCode()) * 31) + this.type.hashCode()) * 31) + this.captureMethodType.hashCode()) * 31;
        String str = this.presetIso3Code;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.systemIso3Code;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.validationAndGuidanceConfiguration.hashCode()) * 31) + this.ibvClientAssessments.hashCode()) * 31;
        ApplicantProfileEntity applicantProfileEntity = this.applicantProfileEntity;
        return iHashCode3 + (applicantProfileEntity != null ? applicantProfileEntity.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isValidationAndGuidanceEnabled, reason: from getter */
    public final boolean getIsValidationAndGuidanceEnabled() {
        return this.isValidationAndGuidanceEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DocumentResourceConfigEntity(requirementId=");
        sb.append(getRequirementId()).append(", state=").append(getState()).append(", objective=").append(getObjective()).append(", tasks=").append(getTasks()).append(", _countries=").append(this._countries).append(", allowedSources=").append(getAllowedSources()).append(", type=").append(this.type).append(", captureMethodType=").append(this.captureMethodType).append(", presetIso3Code=").append(this.presetIso3Code).append(", systemIso3Code=").append(this.systemIso3Code).append(", validationAndGuidanceConfiguration=").append(this.validationAndGuidanceConfiguration).append(", ibvClientAssessments=");
        sb.append(this.ibvClientAssessments).append(", applicantProfileEntity=").append(this.applicantProfileEntity).append(')');
        return sb.toString();
    }
}
