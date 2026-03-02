package com.yoti.mobile.android.yotisdkcore.core.data;

import androidx.exifinterface.media.ExifInterface;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.AllowedSource;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SourceTypeEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.StateTypeEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\fJ3\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H$¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationToEntityMapper;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;", "sourceTypeToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/SourceTypeToEntityMapper;", "stateTypeToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/StateTypeToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/SourceTypeToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/core/data/StateTypeToEntityMapper;)V", "map", "from", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;)Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "mapResource", "requirementId", "", "state", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;", "resourceConfiguration", "allowedSources", "", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SourceTypeEntity;", "(Ljava/lang/String;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/StateTypeEntity;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/ResourceConfiguration;Ljava/util/List;)Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/ResourceConfigurationEntity;", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class ResourceConfigurationToEntityMapper<T extends ResourceConfigurationEntity> implements Mapper<ResourceConfiguration, T> {
    private final SourceTypeToEntityMapper sourceTypeToEntityMapper;
    private final StateTypeToEntityMapper stateTypeToEntityMapper;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceConfigurationToEntityMapper() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ResourceConfigurationToEntityMapper(SourceTypeToEntityMapper sourceTypeToEntityMapper, StateTypeToEntityMapper stateTypeToEntityMapper) {
        Intrinsics.checkNotNullParameter(sourceTypeToEntityMapper, "sourceTypeToEntityMapper");
        Intrinsics.checkNotNullParameter(stateTypeToEntityMapper, "stateTypeToEntityMapper");
        this.sourceTypeToEntityMapper = sourceTypeToEntityMapper;
        this.stateTypeToEntityMapper = stateTypeToEntityMapper;
    }

    public /* synthetic */ ResourceConfigurationToEntityMapper(SourceTypeToEntityMapper sourceTypeToEntityMapper, StateTypeToEntityMapper stateTypeToEntityMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SourceTypeToEntityMapper() : sourceTypeToEntityMapper, (i & 2) != 0 ? new StateTypeToEntityMapper() : stateTypeToEntityMapper);
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public T map(ResourceConfiguration from) {
        Intrinsics.checkNotNullParameter(from, "from");
        String requirementId = from.getRequirementId();
        StateTypeEntity map = this.stateTypeToEntityMapper.map(from.getState());
        List<AllowedSource> allowedSources = from.getAllowedSources();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allowedSources, 10));
        Iterator<T> it2 = allowedSources.iterator();
        while (it2.hasNext()) {
            arrayList.add(this.sourceTypeToEntityMapper.map(((AllowedSource) it2.next()).getSourceType()));
        }
        return (T) mapResource(requirementId, map, from, arrayList);
    }

    protected abstract T mapResource(String requirementId, StateTypeEntity state, ResourceConfiguration resourceConfiguration, List<? extends SourceTypeEntity> allowedSources);
}
