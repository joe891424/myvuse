package com.yoti.mobile.android.liveness.view.upload;

import com.yoti.mobile.android.liveness.domain.UploadLivenessCaptureInteractor;
import com.yoti.mobile.android.liveness.domain.model.ILivenessCaptureEntity;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.Status;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailureType;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadState;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\u0002\b\b¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0012H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0012J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadViewModel;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadViewModel;", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "uploadLivenessCaptureInteractor", "Lcom/yoti/mobile/android/liveness/domain/UploadLivenessCaptureInteractor;", "livenessViewDataToEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessCaptureEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorToSessionStatusMapper;", "errorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/liveness/domain/UploadLivenessCaptureInteractor;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorToSessionStatusMapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;)V", "executeUpload", "", "capture", "onCleared", "setInconsistencyError", "upload", "viewData", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessUploadViewModel extends UploadViewModel<ILivenessCapture> {
    private final Mapper<ILivenessCapture, ILivenessCaptureEntity> livenessViewDataToEntityMapper;
    private final UploadLivenessCaptureInteractor uploadLivenessCaptureInteractor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LivenessUploadViewModel(UploadLivenessCaptureInteractor uploadLivenessCaptureInteractor, Mapper<ILivenessCapture, ILivenessCaptureEntity> livenessViewDataToEntityMapper, SessionStatus sessionStatus, LivenessUploadErrorToSessionStatusMapper errorToSessionStatusTypeMapper, Mapper<Throwable, YdsFailure> errorToFailureMapper) {
        super(sessionStatus, errorToSessionStatusTypeMapper, errorToFailureMapper);
        Intrinsics.checkNotNullParameter(uploadLivenessCaptureInteractor, "uploadLivenessCaptureInteractor");
        Intrinsics.checkNotNullParameter(livenessViewDataToEntityMapper, "livenessViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        this.uploadLivenessCaptureInteractor = uploadLivenessCaptureInteractor;
        this.livenessViewDataToEntityMapper = livenessViewDataToEntityMapper;
    }

    private void setInconsistencyError() {
        get_uploadStatus().setValue(new Status.Error(new YdsFailure(YdsFailureType.InconsistencyError.INSTANCE, false, null, 6, null)));
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.uploadLivenessCaptureInteractor.clear();
        super.onCleared();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel
    public void executeUpload(ILivenessCapture capture) {
        Intrinsics.checkNotNullParameter(capture, "capture");
        this.uploadLivenessCaptureInteractor.clear();
        this.uploadLivenessCaptureInteractor.execute(this.livenessViewDataToEntityMapper.map(capture), new UploadViewModel.UploadObserver());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadViewModel, com.yoti.mobile.android.yotisdkcore.core.view.upload.ViewDataUploader
    public void upload(ILivenessCapture viewData) {
        Intrinsics.checkNotNullParameter(viewData, "viewData");
        UploadState uploadState = getUploadState();
        if (Intrinsics.areEqual(uploadState, UploadState.Finished.INSTANCE)) {
            setUploadAsSuccess();
        } else if (Intrinsics.areEqual(uploadState, UploadState.NotFinished.INSTANCE)) {
            setInconsistencyError();
        } else if (Intrinsics.areEqual(uploadState, UploadState.Unknown.INSTANCE)) {
            super.upload(viewData);
        }
    }
}
