package com.yoti.mobile.android.yotisdkcore.stepTracker.view;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsUnexpectedError;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.ResourceConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.liveness.domain.LivenessResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.stepTracker.view.ResourceConfigEntityToViewDataMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.yotisdkcore.stepTracker.view.i, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/SessionConfigurationEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionConfigurationEntity;", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/StepTrackerViewData;", "documentResourceMapper", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentResourceConfigEntityToViewDataMapper;", "livenessResourceMapper", "Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/LivenessResourceConfigEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/DocumentResourceConfigEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/stepTracker/view/LivenessResourceConfigEntityToViewDataMapper;)V", "map", "from", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionConfigurationEntityToViewDataMapper implements Mapper<SessionConfigurationEntity, StepTrackerViewData> {

    /* JADX INFO: renamed from: a */
    private final DocumentResourceConfigEntityToViewDataMapper f7818a;

    /* JADX INFO: renamed from: b */
    private final LivenessResourceConfigEntityToViewDataMapper f7819b;

    @Inject
    public SessionConfigurationEntityToViewDataMapper(DocumentResourceConfigEntityToViewDataMapper documentResourceMapper, LivenessResourceConfigEntityToViewDataMapper livenessResourceMapper) {
        Intrinsics.checkNotNullParameter(documentResourceMapper, "documentResourceMapper");
        Intrinsics.checkNotNullParameter(livenessResourceMapper, "livenessResourceMapper");
        this.f7818a = documentResourceMapper;
        this.f7819b = livenessResourceMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public StepTrackerViewData map(SessionConfigurationEntity from) {
        Mapper mapper;
        ResourceConfigEntityToViewDataMapper.a aVar;
        Intrinsics.checkNotNullParameter(from, "from");
        List<ResourceConfigurationEntity> steps = from.getSteps();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(steps, 10));
        for (ResourceConfigurationEntity resourceConfigurationEntity : steps) {
            if (resourceConfigurationEntity instanceof DocumentResourceConfigEntity) {
                mapper = this.f7818a;
                aVar = new ResourceConfigEntityToViewDataMapper.a(from, resourceConfigurationEntity);
            } else {
                if (!(resourceConfigurationEntity instanceof LivenessResourceConfigEntity)) {
                    throw new YotiDocsUnexpectedError(new IllegalStateException("Unknown resource configuration received"));
                }
                mapper = this.f7819b;
                aVar = new ResourceConfigEntityToViewDataMapper.a(from, resourceConfigurationEntity);
            }
            arrayList.add(mapper.map(aVar));
        }
        return new StepTrackerViewData(arrayList);
    }
}
