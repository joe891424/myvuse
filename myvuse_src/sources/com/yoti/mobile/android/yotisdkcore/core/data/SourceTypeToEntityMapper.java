package com.yoti.mobile.android.yotisdkcore.core.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.SourceType;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/SourceTypeToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/SourceType;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "()V", "map", "from", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SourceTypeToEntityMapper implements Mapper<SourceType, SourceTypeEntity> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SourceType.values().length];
            iArr[SourceType.END_USER.ordinal()] = 1;
            iArr[SourceType.RELYING_BUSINESS.ordinal()] = 2;
            iArr[SourceType.IBV.ordinal()] = 3;
            iArr[SourceType.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public SourceTypeToEntityMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SourceTypeEntity map(SourceType from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int i = WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
        if (i == 1) {
            return SourceTypeEntity.END_USER;
        }
        if (i == 2) {
            return SourceTypeEntity.RELYING_BUSINESS;
        }
        if (i == 3) {
            return SourceTypeEntity.IBV;
        }
        if (i == 4) {
            return SourceTypeEntity.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
