package com.yoti.mobile.android.facecapture.data.remote;

import com.yoti.mobile.android.facecapture.data.remote.model.FaceCaptureResourceResponse;
import com.yoti.mobile.android.facecapture.domain.model.FaceCaptureResourceEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/data/remote/FaceCaptureResourceResponseToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/facecapture/data/remote/model/FaceCaptureResourceResponse;", "Lcom/yoti/mobile/android/facecapture/domain/model/FaceCaptureResourceEntity;", "()V", "map", "from", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureResourceResponseToEntityMapper implements Mapper<FaceCaptureResourceResponse, FaceCaptureResourceEntity> {
    @Inject
    public FaceCaptureResourceResponseToEntityMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public FaceCaptureResourceEntity map(FaceCaptureResourceResponse from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new FaceCaptureResourceEntity(from.getResourceId(), from.getFrames());
    }
}
