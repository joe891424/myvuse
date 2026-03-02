package com.yoti.mobile.android.yotisdkcore.feature.liveness.data;

import com.yoti.mobile.android.yotidocs.common.error.YotiSdkIncompatibleError;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.BiometricConsent;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.StateTypeEntity;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J.\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0014¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/data/LivenessResourceConfigurationToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationToEntityMapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity;", "()V", "mapBiometricConsent", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$BiometricConsentEntity;", "biometricConsent", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/BiometricConsent;", "mapLivenessSubtype", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/LivenessResourceConfigEntity$LivenessTypeEntity;", "livenessSubtype", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceSubType;", "mapLivenessType", "livenessType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration$ResourceType;", "mapResource", "requirementId", "", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "resourceConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "allowedSources", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessResourceConfigurationToEntityMapper extends ResourceConfigurationToEntityMapper<LivenessResourceConfigEntity> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResourceConfiguration.ResourceSubType.values().length];
            iArr[ResourceConfiguration.ResourceSubType.ZOOM.ordinal()] = 1;
            iArr[ResourceConfiguration.ResourceSubType.STATIC.ordinal()] = 2;
            iArr[ResourceConfiguration.ResourceSubType.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BiometricConsent.values().length];
            iArr2[BiometricConsent.REQUIRED.ordinal()] = 1;
            iArr2[BiometricConsent.NOT_REQUIRED.ordinal()] = 2;
            iArr2[BiometricConsent.CAPTURED.ordinal()] = 3;
            iArr2[BiometricConsent.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public LivenessResourceConfigurationToEntityMapper() {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final LivenessResourceConfigEntity.BiometricConsentEntity mapBiometricConsent(BiometricConsent biometricConsent) {
        int i = WhenMappings.$EnumSwitchMapping$1[biometricConsent.ordinal()];
        if (i == 1) {
            return LivenessResourceConfigEntity.BiometricConsentEntity.REQUIRED;
        }
        if (i == 2) {
            return LivenessResourceConfigEntity.BiometricConsentEntity.NOT_REQUIRED;
        }
        if (i == 3) {
            return LivenessResourceConfigEntity.BiometricConsentEntity.CAPTURED;
        }
        if (i == 4) {
            return LivenessResourceConfigEntity.BiometricConsentEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final LivenessResourceConfigEntity.LivenessTypeEntity mapLivenessSubtype(ResourceConfiguration.ResourceSubType livenessSubtype) throws YotiSdkIncompatibleError {
        int i = WhenMappings.$EnumSwitchMapping$0[livenessSubtype.ordinal()];
        if (i == 1) {
            return LivenessResourceConfigEntity.LivenessTypeEntity.ZOOM;
        }
        if (i == 2) {
            return LivenessResourceConfigEntity.LivenessTypeEntity.STATIC;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new YotiSdkIncompatibleError(new IllegalStateException("Incompatible resource subType"));
    }

    private final LivenessResourceConfigEntity.LivenessTypeEntity mapLivenessType(ResourceConfiguration.ResourceType livenessType, ResourceConfiguration.ResourceSubType livenessSubtype) {
        return livenessType == ResourceConfiguration.ResourceType.FACE_CAPTURE ? LivenessResourceConfigEntity.LivenessTypeEntity.FACE_CAPTURE : mapLivenessSubtype(livenessSubtype);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper
    public /* bridge */ /* synthetic */ ResourceConfigurationEntity mapResource(String str, StateTypeEntity stateTypeEntity, ResourceConfiguration resourceConfiguration, List list) {
        return mapResource(str, stateTypeEntity, resourceConfiguration, (List<? extends SourceTypeEntity>) list);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationToEntityMapper
    protected LivenessResourceConfigEntity mapResource(String requirementId, StateTypeEntity state, ResourceConfiguration resourceConfiguration, List<? extends SourceTypeEntity> allowedSources) {
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(resourceConfiguration, "resourceConfiguration");
        Intrinsics.checkNotNullParameter(allowedSources, "allowedSources");
        return new LivenessResourceConfigEntity(requirementId, state, null, null, allowedSources, mapLivenessType(resourceConfiguration.getType(), resourceConfiguration.getSubType()), mapBiometricConsent(resourceConfiguration.getBiometricConsent()), 12, null);
    }
}
