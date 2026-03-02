package com.yoti.mobile.android.documentcapture.data;

import com.yoti.mobile.android.documentcapture.data.remote.model.AssessmentResult;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.AssessmentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/AssessmentEntityToAssessmentResultMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$IbvClientAssessmentEntity;", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/AssessmentResult;", "assessmentTypeEntityToDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/AssessmentTypeEntityToDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/AssessmentTypeEntityToDataMapper;)V", "map", "from", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AssessmentEntityToAssessmentResultMapper implements Mapper<DocumentResourceConfigEntity.IbvClientAssessmentEntity, AssessmentResult> {
    private final AssessmentTypeEntityToDataMapper assessmentTypeEntityToDataMapper;

    @Inject
    public AssessmentEntityToAssessmentResultMapper(AssessmentTypeEntityToDataMapper assessmentTypeEntityToDataMapper) {
        Intrinsics.checkNotNullParameter(assessmentTypeEntityToDataMapper, "assessmentTypeEntityToDataMapper");
        this.assessmentTypeEntityToDataMapper = assessmentTypeEntityToDataMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public AssessmentResult map(DocumentResourceConfigEntity.IbvClientAssessmentEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new AssessmentResult(this.assessmentTypeEntityToDataMapper.map(from.getType()), from.getState() == DocumentResourceConfigEntity.AssessmentStateEntity.APPROVED ? AssessmentResult.ResultType.PASS : AssessmentResult.ResultType.FAIL);
    }
}
