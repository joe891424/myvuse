package com.yoti.mobile.android.liveness.p071di;

import com.yoti.mobile.android.liveness.domain.ILivenessCaptureRepository;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/di/ILivenessUploadDependenciesProvider;", "", "captureToEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "getCaptureToEntityMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "livenessCaptureRepository", "Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "getLivenessCaptureRepository", "()Lcom/yoti/mobile/android/liveness/domain/ILivenessCaptureRepository;", "uploadErrorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getUploadErrorToFailureMapper", "uploadNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "getUploadNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ILivenessUploadDependenciesProvider {
    Mapper<ILivenessCapture, ILivenessCaptureEntity> getCaptureToEntityMapper();

    ILivenessCaptureRepository<ILivenessCaptureEntity> getLivenessCaptureRepository();

    Mapper<Throwable, YdsFailure> getUploadErrorToFailureMapper();

    ILivenessUploadNavigatorProvider getUploadNavigatorProvider();
}
