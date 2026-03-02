package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiSdkIncompatibleError;
import com.yoti.mobile.android.yotisdkcore.core.data.model.CheckType;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.CheckTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentResourceConfigurationToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.data.LivenessResourceConfigurationToEntityMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/SessionConfigurationDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SessionConfiguration;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "documentResourceMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentResourceConfigurationToEntityMapper;", "livenessResourceMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/data/LivenessResourceConfigurationToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentResourceConfigurationToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/data/LivenessResourceConfigurationToEntityMapper;)V", "map", "from", "mapCheckType", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/CheckTypeEntity;", "type", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/CheckType;", "mapRequirement", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "resourceConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "mapResources", "", "resourceConfigurations", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationDataToEntityMapper implements Mapper<SessionConfiguration, SessionConfigurationEntity> {
    private final DocumentResourceConfigurationToEntityMapper documentResourceMapper;
    private final LivenessResourceConfigurationToEntityMapper livenessResourceMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResourceConfiguration.ResourceType.values().length];
            iArr[ResourceConfiguration.ResourceType.ID_DOCUMENT.ordinal()] = 1;
            iArr[ResourceConfiguration.ResourceType.SUPPLEMENTARY_DOCUMENT.ordinal()] = 2;
            iArr[ResourceConfiguration.ResourceType.LIVENESS.ordinal()] = 3;
            iArr[ResourceConfiguration.ResourceType.FACE_CAPTURE.ordinal()] = 4;
            iArr[ResourceConfiguration.ResourceType.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CheckType.values().length];
            iArr2[CheckType.ID_DOCUMENT_AUTHENTICITY.ordinal()] = 1;
            iArr2[CheckType.ID_DOCUMENT_COMPARISON.ordinal()] = 2;
            iArr2[CheckType.ID_DOCUMENT_FACE_MATCH.ordinal()] = 3;
            iArr2[CheckType.ID_DOCUMENT_TEXT_DATA_CHECK.ordinal()] = 4;
            iArr2[CheckType.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_CHECK.ordinal()] = 5;
            iArr2[CheckType.THIRD_PARTY_IDENTITY.ordinal()] = 6;
            iArr2[CheckType.LIVENESS.ordinal()] = 7;
            iArr2[CheckType.IBV_VISUAL_REVIEW_CHECK.ordinal()] = 8;
            iArr2[CheckType.DOCUMENT_SCHEME_VALIDITY_CHECK.ordinal()] = 9;
            iArr2[CheckType.PROFILE_DOCUMENT_MATCH.ordinal()] = 10;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public SessionConfigurationDataToEntityMapper(DocumentResourceConfigurationToEntityMapper documentResourceMapper, LivenessResourceConfigurationToEntityMapper livenessResourceMapper) {
        Intrinsics.checkNotNullParameter(documentResourceMapper, "documentResourceMapper");
        Intrinsics.checkNotNullParameter(livenessResourceMapper, "livenessResourceMapper");
        this.documentResourceMapper = documentResourceMapper;
        this.livenessResourceMapper = livenessResourceMapper;
    }

    private final CheckTypeEntity mapCheckType(CheckType type) {
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$1[type.ordinal()]) {
            case 1:
                return CheckTypeEntity.ID_DOCUMENT_AUTHENTICITY;
            case 2:
                return CheckTypeEntity.ID_DOCUMENT_COMPARISON;
            case 3:
                return CheckTypeEntity.ID_DOCUMENT_FACE_MATCH;
            case 4:
                return CheckTypeEntity.ID_DOCUMENT_TEXT_DATA_CHECK;
            case 5:
                return CheckTypeEntity.SUPPLEMENTARY_DOCUMENT_TEXT_DATA_CHECK;
            case 6:
                return CheckTypeEntity.THIRD_PARTY_IDENTITY;
            case 7:
                return CheckTypeEntity.LIVENESS;
            case 8:
                return CheckTypeEntity.IBV_VISUAL_REVIEW_CHECK;
            case 9:
                return CheckTypeEntity.DOCUMENT_SCHEME_VALIDITY_CHECK;
            case 10:
                return CheckTypeEntity.PROFILE_DOCUMENT_MATCH_CHECK;
            default:
                return CheckTypeEntity.UNKNOWN;
        }
    }

    private final ResourceConfigurationEntity mapRequirement(ResourceConfiguration resourceConfiguration) throws YotiSdkIncompatibleError {
        Mapper mapper;
        int i = WhenMappings.$EnumSwitchMapping$0[resourceConfiguration.getType().ordinal()];
        if (i == 1 || i == 2) {
            mapper = this.documentResourceMapper;
        } else {
            if (i != 3 && i != 4) {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new YotiSdkIncompatibleError(new IllegalStateException("Incompatible resource type"));
            }
            mapper = this.livenessResourceMapper;
        }
        return mapper.map(resourceConfiguration);
    }

    private final List<ResourceConfigurationEntity> mapResources(List<ResourceConfiguration> resourceConfigurations) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(resourceConfigurations, 10));
        Iterator<T> it2 = resourceConfigurations.iterator();
        while (it2.hasNext()) {
            arrayList.add(mapRequirement((ResourceConfiguration) it2.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity map(com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration r9) {
        /*
            r8 = this;
            java.lang.String r0 = "from"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r2 = r9.getSessionTokenTtl()
            java.lang.String r3 = r9.getSessionId()
            java.util.List r0 = r9.getResourcesConfiguration()
            java.util.List r4 = r8.mapResources(r0)
            java.util.List r0 = r9.getRequestedChecks()
            if (r0 == 0) goto L40
            java.util.ArrayList r1 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r5)
            r1.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L2a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L3e
            java.lang.Object r5 = r0.next()
            com.yoti.mobile.android.yotisdkcore.core.data.model.CheckType r5 = (com.yoti.mobile.android.yotisdkcore.core.data.model.CheckType) r5
            com.yoti.mobile.android.yotisdkcore.core.domain.model.CheckTypeEntity r5 = r8.mapCheckType(r5)
            r1.add(r5)
            goto L2a
        L3e:
            r5 = r1
            goto L45
        L40:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r0
        L45:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity$UiSessionConfigurationEntity r6 = new com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity$UiSessionConfigurationEntity
            com.yoti.mobile.android.yotisdkcore.core.data.model.Configuration r0 = r9.getSdkConfiguration()
            if (r0 == 0) goto L55
            boolean r0 = r0.getHideLogo()
            r1 = 1
            if (r0 != r1) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            com.yoti.mobile.android.yotisdkcore.core.data.model.Configuration r0 = r9.getSdkConfiguration()
            r7 = 0
            if (r0 == 0) goto L62
            java.lang.String r0 = r0.getPrivacyPolicyUrl()
            goto L63
        L62:
            r0 = r7
        L63:
            r6.<init>(r1, r0)
            com.yoti.mobile.android.yotisdkcore.core.data.model.IbvOptions r9 = r9.getIbvOptions()
            if (r9 == 0) goto L7c
            com.yoti.mobile.android.yotisdkcore.core.data.model.UserPrice r9 = r9.getUserPrice()
            if (r9 == 0) goto L7c
            com.yoti.mobile.android.yotisdkcore.core.domain.model.UserPriceEntity r0 = new com.yoti.mobile.android.yotisdkcore.core.domain.model.UserPriceEntity
            java.lang.String r9 = r9.getAmount()
            r0.<init>(r9)
            r7 = r0
        L7c:
            com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity r9 = new com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.yotisdkcore.core.data.SessionConfigurationDataToEntityMapper.map(com.yoti.mobile.android.yotisdkcore.core.data.model.SessionConfiguration):com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity");
    }
}
