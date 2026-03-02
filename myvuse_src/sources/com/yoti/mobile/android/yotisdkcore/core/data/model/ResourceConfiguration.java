package com.yoti.mobile.android.yotisdkcore.core.data.model;

import com.google.gson.annotations.SerializedName;
import com.yoti.mobile.android.yotisdkcore.applicant_profile.data.model.ApplicantProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0004defgBñ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0015HÂ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000bHÂ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÂ\u0003J\u0013\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000bHÂ\u0003J\u0017\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÂ\u0003J\t\u0010T\u001a\u00020\u001fHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\tHÂ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÂ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000eHÂ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bHÂ\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bHÂ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J÷\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001J\u0013\u0010_\u001a\u00020\u001f2\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020bHÖ\u0001J\t\u0010c\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8F¢\u0006\u0006\u001a\u0004\b2\u0010%R\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010:R\u0011\u0010>\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\bE\u0010%R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8F¢\u0006\u0006\u001a\u0004\bG\u0010%R\u0011\u0010H\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001d\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006h"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "", "requirementId", "", "_type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;", "_subType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceSubType;", "_state", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;", "_supportedCountries", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$Country;", "_captureMethodType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$CaptureMethodType;", "_tasks", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Task;", "_ibvClientAssessments", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/IbvClientAssessment;", "presetIssuingCountry", "_objective", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjective;", "_documentTypes", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "_countryCodes", "_allowedSources", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/AllowedSource;", "_validationAndGuidanceConfiguration", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ValidationAndGuidance;", "ignoreNfcScanConfiguration", "", "applicantProfile", "Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceSubType;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$CaptureMethodType;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjective;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ZLcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;)V", "allowedSources", "getAllowedSources", "()Ljava/util/List;", "getApplicantProfile", "()Lcom/yoti/mobile/android/yotisdkcore/applicant_profile/data/model/ApplicantProfile;", "biometricConsent", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;", "getBiometricConsent", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;", "setBiometricConsent", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;)V", "captureMethodType", "getCaptureMethodType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$CaptureMethodType;", "ibvClientAssessments", "getIbvClientAssessments", "getIgnoreNfcScanConfiguration", "()Z", "objectiveType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjectiveType;", "getObjectiveType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CaptureObjectiveType;", "getPresetIssuingCountry", "()Ljava/lang/String;", "setPresetIssuingCountry", "(Ljava/lang/String;)V", "getRequirementId", "state", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/StateType;", "subType", "getSubType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceSubType;", "supportedCountries", "getSupportedCountries", "tasks", "getTasks", "type", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;", "validationAndGuidanceConfiguration", "getValidationAndGuidanceConfiguration", "()Ljava/util/Map;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "CaptureMethodType", "Country", "ResourceSubType", "ResourceType", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ResourceConfiguration {

    @SerializedName("allowed_sources")
    private final List<AllowedSource> _allowedSources;

    @SerializedName("allowed_capture_methods")
    private final CaptureMethodType _captureMethodType;

    @SerializedName("country_codes")
    private final List<String> _countryCodes;

    @SerializedName("document_types")
    private final List<DocumentType> _documentTypes;

    @SerializedName("ibv_client_assessments")
    private final List<IbvClientAssessment> _ibvClientAssessments;

    @SerializedName("objective")
    private final CaptureObjective _objective;

    @SerializedName("state")
    private final StateType _state;

    @SerializedName("liveness_type")
    private final ResourceSubType _subType;

    @SerializedName("supported_countries")
    private final List<Country> _supportedCountries;

    @SerializedName("requested_tasks")
    private final List<Task> _tasks;

    @SerializedName("type")
    private final ResourceType _type;

    @SerializedName("validation_and_guidance_resources")
    private final Map<DocumentType, ValidationAndGuidance> _validationAndGuidanceConfiguration;

    @SerializedName("applicant_profile")
    private final ApplicantProfile applicantProfile;
    public BiometricConsent biometricConsent;

    @SerializedName("ignore_nfc_scan_configuration")
    private final boolean ignoreNfcScanConfiguration;

    @SerializedName("preset_issuing_country")
    private String presetIssuingCountry;

    @SerializedName("id")
    private final String requirementId;

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$CaptureMethodType;", "", "(Ljava/lang/String;I)V", "CAMERA_AND_UPLOAD", "CAMERA", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum CaptureMethodType {
        CAMERA_AND_UPLOAD,
        CAMERA,
        UNKNOWN
    }

    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$Country;", "", "iso3Code", "", "supportedDocuments", "", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/Document;", "(Ljava/lang/String;Ljava/util/List;)V", "getIso3Code", "()Ljava/lang/String;", "getSupportedDocuments", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final /* data */ class Country {

        @SerializedName("code")
        private final String iso3Code;

        @SerializedName("supported_documents")
        private final List<Document> supportedDocuments;

        public Country(String iso3Code, List<Document> supportedDocuments) {
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(supportedDocuments, "supportedDocuments");
            this.iso3Code = iso3Code;
            this.supportedDocuments = supportedDocuments;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Country copy$default(Country country, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = country.iso3Code;
            }
            if ((i & 2) != 0) {
                list = country.supportedDocuments;
            }
            return country.copy(str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final List<Document> component2() {
            return this.supportedDocuments;
        }

        public final Country copy(String iso3Code, List<Document> supportedDocuments) {
            Intrinsics.checkNotNullParameter(iso3Code, "iso3Code");
            Intrinsics.checkNotNullParameter(supportedDocuments, "supportedDocuments");
            return new Country(iso3Code, supportedDocuments);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Country)) {
                return false;
            }
            Country country = (Country) other;
            return Intrinsics.areEqual(this.iso3Code, country.iso3Code) && Intrinsics.areEqual(this.supportedDocuments, country.supportedDocuments);
        }

        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final List<Document> getSupportedDocuments() {
            return this.supportedDocuments;
        }

        public int hashCode() {
            return (this.iso3Code.hashCode() * 31) + this.supportedDocuments.hashCode();
        }

        public String toString() {
            return "Country(iso3Code=" + this.iso3Code + ", supportedDocuments=" + this.supportedDocuments + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceSubType;", "", "(Ljava/lang/String;I)V", "ZOOM", "STATIC", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum ResourceSubType {
        ZOOM,
        STATIC,
        UNKNOWN
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;", "", "isDocumentResource", "", "(Ljava/lang/String;IZ)V", "()Z", "ID_DOCUMENT", "SUPPLEMENTARY_DOCUMENT", "LIVENESS", "FACE_CAPTURE", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public enum ResourceType {
        ID_DOCUMENT(true),
        SUPPLEMENTARY_DOCUMENT(true),
        LIVENESS(false, 1, null),
        FACE_CAPTURE(false, 1, null),
        UNKNOWN(false, 1, null);

        private final boolean isDocumentResource;

        ResourceType(boolean z) {
            this.isDocumentResource = z;
        }

        /* synthetic */ ResourceType(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        /* JADX INFO: renamed from: isDocumentResource, reason: from getter */
        public final boolean getIsDocumentResource() {
            return this.isDocumentResource;
        }
    }

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceType.values().length];
            iArr[ResourceType.ID_DOCUMENT.ordinal()] = 1;
            iArr[ResourceType.SUPPLEMENTARY_DOCUMENT.ordinal()] = 2;
            iArr[ResourceType.LIVENESS.ordinal()] = 3;
            iArr[ResourceType.FACE_CAPTURE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceConfiguration(String requirementId, ResourceType resourceType, ResourceSubType resourceSubType, StateType stateType, List<Country> list, CaptureMethodType captureMethodType, List<Task> list2, List<IbvClientAssessment> list3, String str, CaptureObjective captureObjective, List<? extends DocumentType> list4, List<String> list5, List<AllowedSource> list6, Map<DocumentType, ValidationAndGuidance> map, boolean z, ApplicantProfile applicantProfile) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        this.requirementId = requirementId;
        this._type = resourceType;
        this._subType = resourceSubType;
        this._state = stateType;
        this._supportedCountries = list;
        this._captureMethodType = captureMethodType;
        this._tasks = list2;
        this._ibvClientAssessments = list3;
        this.presetIssuingCountry = str;
        this._objective = captureObjective;
        this._documentTypes = list4;
        this._countryCodes = list5;
        this._allowedSources = list6;
        this._validationAndGuidanceConfiguration = map;
        this.ignoreNfcScanConfiguration = z;
        this.applicantProfile = applicantProfile;
    }

    public /* synthetic */ ResourceConfiguration(String str, ResourceType resourceType, ResourceSubType resourceSubType, StateType stateType, List list, CaptureMethodType captureMethodType, List list2, List list3, String str2, CaptureObjective captureObjective, List list4, List list5, List list6, Map map, boolean z, ApplicantProfile applicantProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ResourceType.UNKNOWN : resourceType, (i & 4) != 0 ? ResourceSubType.UNKNOWN : resourceSubType, (i & 8) != 0 ? StateType.UNKNOWN : stateType, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? CaptureMethodType.UNKNOWN : captureMethodType, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? CollectionsKt.emptyList() : list3, (i & 256) != 0 ? null : str2, (i & 512) != 0 ? new CaptureObjective(CaptureObjectiveType.UNKNOWN) : captureObjective, (i & 1024) != 0 ? CollectionsKt.emptyList() : list4, (i & 2048) != 0 ? CollectionsKt.emptyList() : list5, (i & 4096) != 0 ? null : list6, (i & 8192) != 0 ? MapsKt.emptyMap() : map, (i & 16384) != 0 ? false : z, (i & 32768) == 0 ? applicantProfile : null);
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final CaptureObjective get_objective() {
        return this._objective;
    }

    private final List<DocumentType> component11() {
        return this._documentTypes;
    }

    private final List<String> component12() {
        return this._countryCodes;
    }

    private final List<AllowedSource> component13() {
        return this._allowedSources;
    }

    private final Map<DocumentType, ValidationAndGuidance> component14() {
        return this._validationAndGuidanceConfiguration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final ResourceType get_type() {
        return this._type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final ResourceSubType get_subType() {
        return this._subType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final StateType get_state() {
        return this._state;
    }

    private final List<Country> component5() {
        return this._supportedCountries;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final CaptureMethodType get_captureMethodType() {
        return this._captureMethodType;
    }

    private final List<Task> component7() {
        return this._tasks;
    }

    private final List<IbvClientAssessment> component8() {
        return this._ibvClientAssessments;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequirementId() {
        return this.requirementId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIgnoreNfcScanConfiguration() {
        return this.ignoreNfcScanConfiguration;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final ApplicantProfile getApplicantProfile() {
        return this.applicantProfile;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPresetIssuingCountry() {
        return this.presetIssuingCountry;
    }

    public final ResourceConfiguration copy(String requirementId, ResourceType _type, ResourceSubType _subType, StateType _state, List<Country> _supportedCountries, CaptureMethodType _captureMethodType, List<Task> _tasks, List<IbvClientAssessment> _ibvClientAssessments, String presetIssuingCountry, CaptureObjective _objective, List<? extends DocumentType> _documentTypes, List<String> _countryCodes, List<AllowedSource> _allowedSources, Map<DocumentType, ValidationAndGuidance> _validationAndGuidanceConfiguration, boolean ignoreNfcScanConfiguration, ApplicantProfile applicantProfile) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        return new ResourceConfiguration(requirementId, _type, _subType, _state, _supportedCountries, _captureMethodType, _tasks, _ibvClientAssessments, presetIssuingCountry, _objective, _documentTypes, _countryCodes, _allowedSources, _validationAndGuidanceConfiguration, ignoreNfcScanConfiguration, applicantProfile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResourceConfiguration)) {
            return false;
        }
        ResourceConfiguration resourceConfiguration = (ResourceConfiguration) other;
        return Intrinsics.areEqual(this.requirementId, resourceConfiguration.requirementId) && this._type == resourceConfiguration._type && this._subType == resourceConfiguration._subType && this._state == resourceConfiguration._state && Intrinsics.areEqual(this._supportedCountries, resourceConfiguration._supportedCountries) && this._captureMethodType == resourceConfiguration._captureMethodType && Intrinsics.areEqual(this._tasks, resourceConfiguration._tasks) && Intrinsics.areEqual(this._ibvClientAssessments, resourceConfiguration._ibvClientAssessments) && Intrinsics.areEqual(this.presetIssuingCountry, resourceConfiguration.presetIssuingCountry) && Intrinsics.areEqual(this._objective, resourceConfiguration._objective) && Intrinsics.areEqual(this._documentTypes, resourceConfiguration._documentTypes) && Intrinsics.areEqual(this._countryCodes, resourceConfiguration._countryCodes) && Intrinsics.areEqual(this._allowedSources, resourceConfiguration._allowedSources) && Intrinsics.areEqual(this._validationAndGuidanceConfiguration, resourceConfiguration._validationAndGuidanceConfiguration) && this.ignoreNfcScanConfiguration == resourceConfiguration.ignoreNfcScanConfiguration && Intrinsics.areEqual(this.applicantProfile, resourceConfiguration.applicantProfile);
    }

    public final List<AllowedSource> getAllowedSources() {
        List<AllowedSource> list = this._allowedSources;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AllowedSource allowedSource : list) {
            if (allowedSource == null) {
                allowedSource = new AllowedSource(SourceType.UNKNOWN);
            }
            arrayList.add(allowedSource);
        }
        return arrayList;
    }

    public final ApplicantProfile getApplicantProfile() {
        return this.applicantProfile;
    }

    public final BiometricConsent getBiometricConsent() {
        BiometricConsent biometricConsent = this.biometricConsent;
        if (biometricConsent != null) {
            return biometricConsent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("biometricConsent");
        return null;
    }

    public final CaptureMethodType getCaptureMethodType() {
        CaptureMethodType captureMethodType = this._captureMethodType;
        return captureMethodType == null ? CaptureMethodType.UNKNOWN : captureMethodType;
    }

    public final List<IbvClientAssessment> getIbvClientAssessments() {
        List<IbvClientAssessment> list = this._ibvClientAssessments;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final boolean getIgnoreNfcScanConfiguration() {
        return this.ignoreNfcScanConfiguration;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        if (r0 != 4) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType getObjectiveType() {
        /*
            r3 = this;
            com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration$ResourceType r0 = r3._type
            if (r0 != 0) goto L6
            r0 = -1
            goto Le
        L6:
            int[] r1 = com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
        Le:
            r1 = 1
            if (r0 == r1) goto L3a
            r1 = 2
            if (r0 == r1) goto L1b
            r1 = 3
            if (r0 == r1) goto L3a
            r1 = 4
            if (r0 == r1) goto L3a
            goto L37
        L1b:
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjective r0 = r3._objective
            r1 = 0
            if (r0 == 0) goto L25
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r0 = r0.getType()
            goto L26
        L25:
            r0 = r1
        L26:
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r2 = com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType.UK_DBS
            if (r0 != r2) goto L2d
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r1 = com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType.PROOF_OF_IDENTITY
            goto L35
        L2d:
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjective r0 = r3._objective
            if (r0 == 0) goto L35
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r1 = r0.getType()
        L35:
            if (r1 != 0) goto L3c
        L37:
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r1 = com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType.UNKNOWN
            goto L3c
        L3a:
            com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType r1 = com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType.PROOF_OF_IDENTITY
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration.getObjectiveType():com.yoti.mobile.android.yotisdkcore.core.data.model.CaptureObjectiveType");
    }

    public final String getPresetIssuingCountry() {
        return this.presetIssuingCountry;
    }

    public final String getRequirementId() {
        return this.requirementId;
    }

    public final StateType getState() {
        StateType stateType = this._state;
        return stateType == null ? StateType.UNKNOWN : stateType;
    }

    public final ResourceSubType getSubType() {
        ResourceSubType resourceSubType = this._subType;
        return resourceSubType == null ? ResourceSubType.UNKNOWN : resourceSubType;
    }

    public final List<Country> getSupportedCountries() {
        List listEmptyList;
        List<Country> list = this._supportedCountries;
        ArrayList arrayList = null;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            return list;
        }
        List<String> list2 = this._countryCodes;
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str : list2) {
                List<DocumentType> list3 = this._documentTypes;
                if (list3 != null) {
                    listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        listEmptyList.add(new Document((DocumentType) it2.next(), null, 2, null));
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                arrayList2.add(new Country(str, listEmptyList));
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final List<Task> getTasks() {
        List<Task> list = this._tasks;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final ResourceType getType() {
        ResourceType resourceType = this._type;
        return resourceType == null ? ResourceType.UNKNOWN : resourceType;
    }

    public final Map<DocumentType, ValidationAndGuidance> getValidationAndGuidanceConfiguration() {
        Map<DocumentType, ValidationAndGuidance> map = this._validationAndGuidanceConfiguration;
        return map == null ? MapsKt.emptyMap() : map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v56 */
    public int hashCode() {
        int iHashCode = this.requirementId.hashCode() * 31;
        ResourceType resourceType = this._type;
        int iHashCode2 = (iHashCode + (resourceType == null ? 0 : resourceType.hashCode())) * 31;
        ResourceSubType resourceSubType = this._subType;
        int iHashCode3 = (iHashCode2 + (resourceSubType == null ? 0 : resourceSubType.hashCode())) * 31;
        StateType stateType = this._state;
        int iHashCode4 = (iHashCode3 + (stateType == null ? 0 : stateType.hashCode())) * 31;
        List<Country> list = this._supportedCountries;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        CaptureMethodType captureMethodType = this._captureMethodType;
        int iHashCode6 = (iHashCode5 + (captureMethodType == null ? 0 : captureMethodType.hashCode())) * 31;
        List<Task> list2 = this._tasks;
        int iHashCode7 = (iHashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<IbvClientAssessment> list3 = this._ibvClientAssessments;
        int iHashCode8 = (iHashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.presetIssuingCountry;
        int iHashCode9 = (iHashCode8 + (str == null ? 0 : str.hashCode())) * 31;
        CaptureObjective captureObjective = this._objective;
        int iHashCode10 = (iHashCode9 + (captureObjective == null ? 0 : captureObjective.hashCode())) * 31;
        List<DocumentType> list4 = this._documentTypes;
        int iHashCode11 = (iHashCode10 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this._countryCodes;
        int iHashCode12 = (iHashCode11 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<AllowedSource> list6 = this._allowedSources;
        int iHashCode13 = (iHashCode12 + (list6 == null ? 0 : list6.hashCode())) * 31;
        Map<DocumentType, ValidationAndGuidance> map = this._validationAndGuidanceConfiguration;
        int iHashCode14 = (iHashCode13 + (map == null ? 0 : map.hashCode())) * 31;
        boolean z = this.ignoreNfcScanConfiguration;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode14 + r1) * 31;
        ApplicantProfile applicantProfile = this.applicantProfile;
        return i + (applicantProfile != null ? applicantProfile.hashCode() : 0);
    }

    public final void setBiometricConsent(BiometricConsent biometricConsent) {
        Intrinsics.checkNotNullParameter(biometricConsent, "<set-?>");
        this.biometricConsent = biometricConsent;
    }

    public final void setPresetIssuingCountry(String str) {
        this.presetIssuingCountry = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResourceConfiguration(requirementId=");
        sb.append(this.requirementId).append(", _type=").append(this._type).append(", _subType=").append(this._subType).append(", _state=").append(this._state).append(", _supportedCountries=").append(this._supportedCountries).append(", _captureMethodType=").append(this._captureMethodType).append(", _tasks=").append(this._tasks).append(", _ibvClientAssessments=").append(this._ibvClientAssessments).append(", presetIssuingCountry=").append(this.presetIssuingCountry).append(", _objective=").append(this._objective).append(", _documentTypes=").append(this._documentTypes).append(", _countryCodes=");
        sb.append(this._countryCodes).append(", _allowedSources=").append(this._allowedSources).append(", _validationAndGuidanceConfiguration=").append(this._validationAndGuidanceConfiguration).append(", ignoreNfcScanConfiguration=").append(this.ignoreNfcScanConfiguration).append(", applicantProfile=").append(this.applicantProfile).append(')');
        return sb.toString();
    }
}
