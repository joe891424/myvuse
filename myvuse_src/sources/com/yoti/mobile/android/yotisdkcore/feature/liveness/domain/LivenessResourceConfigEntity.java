package com.yoti.mobile.android.yotisdkcore.feature.liveness.domain;

import com.yoti.mobile.android.yotisdkcore.core.domain.model.CaptureObjectiveTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.FeatureTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.StateTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.TaskEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002./BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\tHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "requirementId", "", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "objective", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "tasks", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/TaskEntity;", "allowedSources", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "type", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "biometricConsent", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$BiometricConsentEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;Ljava/util/List;Ljava/util/List;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$BiometricConsentEntity;)V", "getAllowedSources", "()Ljava/util/List;", "getBiometricConsent", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$BiometricConsentEntity;", "getObjective", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CaptureObjectiveTypeEntity;", "getRequirementId", "()Ljava/lang/String;", "getState", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "getTasks", "getType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "BiometricConsentEntity", "LivenessTypeEntity", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessResourceConfigEntity extends ResourceConfigurationEntity {
    private final List<SourceTypeEntity> allowedSources;
    private final BiometricConsentEntity biometricConsent;
    private final CaptureObjectiveTypeEntity objective;
    private final String requirementId;
    private final StateTypeEntity state;
    private final List<TaskEntity> tasks;
    private final LivenessTypeEntity type;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NOT_REQUIRED' uses external variables
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
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$BiometricConsentEntity;", "", "isBiometricConsentNeeded", "", "biometricPolicyUsUrl", "", "(Ljava/lang/String;IZLjava/lang/String;)V", "getBiometricPolicyUsUrl", "()Ljava/lang/String;", "()Z", "REQUIRED", "NOT_REQUIRED", "CAPTURED", "UNKNOWN", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class BiometricConsentEntity {
        public static final BiometricConsentEntity NOT_REQUIRED;
        public static final BiometricConsentEntity UNKNOWN;
        private final String biometricPolicyUsUrl;
        private final boolean isBiometricConsentNeeded;
        public static final BiometricConsentEntity REQUIRED = new BiometricConsentEntity("REQUIRED", 0, true, null, 2, null);
        public static final BiometricConsentEntity CAPTURED = new BiometricConsentEntity("CAPTURED", 2, true, null, 2, null);
        private static final /* synthetic */ BiometricConsentEntity[] $VALUES = $values();

        private static final /* synthetic */ BiometricConsentEntity[] $values() {
            return new BiometricConsentEntity[]{REQUIRED, NOT_REQUIRED, CAPTURED, UNKNOWN};
        }

        static {
            int i = 3;
            DefaultConstructorMarker defaultConstructorMarker = null;
            boolean z = false;
            String str = null;
            NOT_REQUIRED = new BiometricConsentEntity("NOT_REQUIRED", 1, z, str, i, defaultConstructorMarker);
            UNKNOWN = new BiometricConsentEntity("UNKNOWN", 3, z, str, i, defaultConstructorMarker);
        }

        private BiometricConsentEntity(String str, int i, boolean z, String str2) {
            this.isBiometricConsentNeeded = z;
            this.biometricPolicyUsUrl = str2;
        }

        /* synthetic */ BiometricConsentEntity(String str, int i, boolean z, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "https://www.yoti.com/terms/biometrics-policy-us/" : str2);
        }

        public static BiometricConsentEntity valueOf(String str) {
            return (BiometricConsentEntity) Enum.valueOf(BiometricConsentEntity.class, str);
        }

        public static BiometricConsentEntity[] values() {
            return (BiometricConsentEntity[]) $VALUES.clone();
        }

        public final String getBiometricPolicyUsUrl() {
            return this.biometricPolicyUsUrl;
        }

        /* JADX INFO: renamed from: isBiometricConsentNeeded, reason: from getter */
        public final boolean getIsBiometricConsentNeeded() {
            return this.isBiometricConsentNeeded;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'STATIC' uses external variables
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
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "", "feature", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "(Ljava/lang/String;ILcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;)V", "getFeature", "()Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/FeatureTypeEntity;", "ZOOM", "STATIC", "FACE_CAPTURE", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class LivenessTypeEntity {
        private static final /* synthetic */ LivenessTypeEntity[] $VALUES;
        public static final LivenessTypeEntity FACE_CAPTURE;
        public static final LivenessTypeEntity STATIC;
        public static final LivenessTypeEntity ZOOM = new LivenessTypeEntity("ZOOM", 0, FeatureTypeEntity.ZOOM_LIVENESS);
        private final FeatureTypeEntity feature;

        private static final /* synthetic */ LivenessTypeEntity[] $values() {
            return new LivenessTypeEntity[]{ZOOM, STATIC, FACE_CAPTURE};
        }

        static {
            FeatureTypeEntity featureTypeEntity = FeatureTypeEntity.FACE_CAPTURE;
            STATIC = new LivenessTypeEntity("STATIC", 1, featureTypeEntity);
            FACE_CAPTURE = new LivenessTypeEntity("FACE_CAPTURE", 2, featureTypeEntity);
            $VALUES = $values();
        }

        private LivenessTypeEntity(String str, int i, FeatureTypeEntity featureTypeEntity) {
            this.feature = featureTypeEntity;
        }

        public static LivenessTypeEntity valueOf(String str) {
            return (LivenessTypeEntity) Enum.valueOf(LivenessTypeEntity.class, str);
        }

        public static LivenessTypeEntity[] values() {
            return (LivenessTypeEntity[]) $VALUES.clone();
        }

        public final FeatureTypeEntity getFeature() {
            return this.feature;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LivenessResourceConfigEntity(String requirementId, StateTypeEntity state, CaptureObjectiveTypeEntity objective, List<TaskEntity> tasks, List<? extends SourceTypeEntity> allowedSources, LivenessTypeEntity type, BiometricConsentEntity biometricConsent) {
        super(type.getFeature(), false, 2, null);
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(biometricConsent, "biometricConsent");
        this.requirementId = requirementId;
        this.state = state;
        this.objective = objective;
        this.tasks = tasks;
        this.allowedSources = allowedSources;
        this.type = type;
        this.biometricConsent = biometricConsent;
    }

    public /* synthetic */ LivenessResourceConfigEntity(String str, StateTypeEntity stateTypeEntity, CaptureObjectiveTypeEntity captureObjectiveTypeEntity, List list, List list2, LivenessTypeEntity livenessTypeEntity, BiometricConsentEntity biometricConsentEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, stateTypeEntity, (i & 4) != 0 ? CaptureObjectiveTypeEntity.PROOF_OF_IDENTITY : captureObjectiveTypeEntity, (i & 8) != 0 ? CollectionsKt.emptyList() : list, list2, livenessTypeEntity, biometricConsentEntity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivenessResourceConfigEntity copy$default(LivenessResourceConfigEntity livenessResourceConfigEntity, String str, StateTypeEntity stateTypeEntity, CaptureObjectiveTypeEntity captureObjectiveTypeEntity, List list, List list2, LivenessTypeEntity livenessTypeEntity, BiometricConsentEntity biometricConsentEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessResourceConfigEntity.getRequirementId();
        }
        if ((i & 2) != 0) {
            stateTypeEntity = livenessResourceConfigEntity.getState();
        }
        StateTypeEntity stateTypeEntity2 = stateTypeEntity;
        if ((i & 4) != 0) {
            captureObjectiveTypeEntity = livenessResourceConfigEntity.getObjective();
        }
        CaptureObjectiveTypeEntity captureObjectiveTypeEntity2 = captureObjectiveTypeEntity;
        if ((i & 8) != 0) {
            list = livenessResourceConfigEntity.getTasks();
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = livenessResourceConfigEntity.getAllowedSources();
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            livenessTypeEntity = livenessResourceConfigEntity.type;
        }
        LivenessTypeEntity livenessTypeEntity2 = livenessTypeEntity;
        if ((i & 64) != 0) {
            biometricConsentEntity = livenessResourceConfigEntity.biometricConsent;
        }
        return livenessResourceConfigEntity.copy(str, stateTypeEntity2, captureObjectiveTypeEntity2, list3, list4, livenessTypeEntity2, biometricConsentEntity);
    }

    public final String component1() {
        return getRequirementId();
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

    public final List<SourceTypeEntity> component5() {
        return getAllowedSources();
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final LivenessTypeEntity getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final BiometricConsentEntity getBiometricConsent() {
        return this.biometricConsent;
    }

    public final LivenessResourceConfigEntity copy(String requirementId, StateTypeEntity state, CaptureObjectiveTypeEntity objective, List<TaskEntity> tasks, List<? extends SourceTypeEntity> allowedSources, LivenessTypeEntity type, BiometricConsentEntity biometricConsent) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(objective, "objective");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(biometricConsent, "biometricConsent");
        return new LivenessResourceConfigEntity(requirementId, state, objective, tasks, allowedSources, type, biometricConsent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LivenessResourceConfigEntity)) {
            return false;
        }
        LivenessResourceConfigEntity livenessResourceConfigEntity = (LivenessResourceConfigEntity) other;
        return Intrinsics.areEqual(getRequirementId(), livenessResourceConfigEntity.getRequirementId()) && getState() == livenessResourceConfigEntity.getState() && getObjective() == livenessResourceConfigEntity.getObjective() && Intrinsics.areEqual(getTasks(), livenessResourceConfigEntity.getTasks()) && Intrinsics.areEqual(getAllowedSources(), livenessResourceConfigEntity.getAllowedSources()) && this.type == livenessResourceConfigEntity.type && this.biometricConsent == livenessResourceConfigEntity.biometricConsent;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public List<SourceTypeEntity> getAllowedSources() {
        return this.allowedSources;
    }

    public final BiometricConsentEntity getBiometricConsent() {
        return this.biometricConsent;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public CaptureObjectiveTypeEntity getObjective() {
        return this.objective;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public String getRequirementId() {
        return this.requirementId;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public StateTypeEntity getState() {
        return this.state;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity
    public List<TaskEntity> getTasks() {
        return this.tasks;
    }

    public final LivenessTypeEntity getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((getRequirementId().hashCode() * 31) + getState().hashCode()) * 31) + getObjective().hashCode()) * 31) + getTasks().hashCode()) * 31) + getAllowedSources().hashCode()) * 31) + this.type.hashCode()) * 31) + this.biometricConsent.hashCode();
    }

    public String toString() {
        return "LivenessResourceConfigEntity(requirementId=" + getRequirementId() + ", state=" + getState() + ", objective=" + getObjective() + ", tasks=" + getTasks() + ", allowedSources=" + getAllowedSources() + ", type=" + this.type + ", biometricConsent=" + this.biometricConsent + ')';
    }
}
