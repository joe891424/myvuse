package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.facetec.sdk.FaceTecSessionResult;
import com.yoti.mobile.android.commons.util.FileManager;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.liveness.zoom.view.capture.model.LivenessFaceTecCaptureViewData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002:\u000256B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0012J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0012J\u0012\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020%H\u0014J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020!H\u0016J\u0010\u00104\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158R@RX\u0092\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001d¨\u00067"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "faceTecResultProcessor", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;", "errorToFailureMapper", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToFailureMapper;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/liveness/zoom/view/capture/IFaceTecResultProcessor;Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToFailureMapper;Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecErrorToSessionStatusTypeMapper;)V", "_navigationEvent", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState;", "createLivenessCaptureFilesDisposable", "Lio/reactivex/disposables/Disposable;", "value", "", "isCaptureInProgress", "()Z", "setCaptureInProgress", "(Z)V", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "resourceId", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "viewState", "getViewState", "cleanupCapture", "", "context", "Landroid/content/Context;", "handleFaceTecLivenessCaptureError", "faceTecError", "", "handleFaceTecLivenessSaveSuccess", "livenessResultFiles", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/FaceTecFiles;", "handleFaceTecResult", "faceTecSessionResult", "Lcom/facetec/sdk/FaceTecSessionResult;", "onCleared", "setSavedStateHandle", "handle", "startLivenessCapture", "LivenessCaptureNavigationEvent", "LivenessCaptureViewState", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessFaceTecCaptureViewModel extends ViewModel implements SavedStateHandleHolder {
    private final SingleLiveDataEvent<LivenessCaptureNavigationEvent> _navigationEvent;
    private final MutableLiveData<LivenessCaptureViewState> _viewState;
    private Disposable createLivenessCaptureFilesDisposable;
    private final FaceTecErrorToFailureMapper errorToFailureMapper;
    private final FaceTecErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final IFaceTecResultProcessor faceTecResultProcessor;
    private final LiveData<LivenessCaptureNavigationEvent> navigationEvent;
    private String resourceId;
    private SavedStateHandle savedStateHandle;
    private final SessionStatus sessionStatus;
    private final LiveData<LivenessCaptureViewState> viewState;

    @Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;", "", "()V", "NavigateToCaptureFailure", "NavigateToUpload", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent$NavigateToCaptureFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent$NavigateToUpload;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class LivenessCaptureNavigationEvent {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent$NavigateToCaptureFailure;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToCaptureFailure extends LivenessCaptureNavigationEvent {
            private final YdsFailure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToCaptureFailure(YdsFailure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ NavigateToCaptureFailure copy$default(NavigateToCaptureFailure navigateToCaptureFailure, YdsFailure ydsFailure, int i, Object obj) {
                if ((i & 1) != 0) {
                    ydsFailure = navigateToCaptureFailure.failure;
                }
                return navigateToCaptureFailure.copy(ydsFailure);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final YdsFailure getFailure() {
                return this.failure;
            }

            public final NavigateToCaptureFailure copy(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new NavigateToCaptureFailure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToCaptureFailure) && Intrinsics.areEqual(this.failure, ((NavigateToCaptureFailure) other).failure);
            }

            public final YdsFailure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "NavigateToCaptureFailure(failure=" + this.failure + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;", "data", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/model/LivenessFaceTecCaptureViewData;", "(Lcom/yoti/mobile/android/liveness/zoom/view/capture/model/LivenessFaceTecCaptureViewData;)V", "getData", "()Lcom/yoti/mobile/android/liveness/zoom/view/capture/model/LivenessFaceTecCaptureViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToUpload extends LivenessCaptureNavigationEvent {
            private final LivenessFaceTecCaptureViewData data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToUpload(LivenessFaceTecCaptureViewData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ NavigateToUpload copy$default(NavigateToUpload navigateToUpload, LivenessFaceTecCaptureViewData livenessFaceTecCaptureViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    livenessFaceTecCaptureViewData = navigateToUpload.data;
                }
                return navigateToUpload.copy(livenessFaceTecCaptureViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final LivenessFaceTecCaptureViewData getData() {
                return this.data;
            }

            public final NavigateToUpload copy(LivenessFaceTecCaptureViewData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new NavigateToUpload(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToUpload) && Intrinsics.areEqual(this.data, ((NavigateToUpload) other).data);
            }

            public final LivenessFaceTecCaptureViewData getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "NavigateToUpload(data=" + this.data + ')';
            }
        }

        private LivenessCaptureNavigationEvent() {
        }

        public /* synthetic */ LivenessCaptureNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState;", "", "()V", "LivenessCaptureInProgress", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState$LivenessCaptureInProgress;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class LivenessCaptureViewState {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState$LivenessCaptureInProgress;", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState;", "()V", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class LivenessCaptureInProgress extends LivenessCaptureViewState {
            public static final LivenessCaptureInProgress INSTANCE = new LivenessCaptureInProgress();

            private LivenessCaptureInProgress() {
                super(null);
            }
        }

        private LivenessCaptureViewState() {
        }

        public /* synthetic */ LivenessCaptureViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LivenessFaceTecCaptureViewModel(SessionStatus sessionStatus, IFaceTecResultProcessor faceTecResultProcessor, FaceTecErrorToFailureMapper errorToFailureMapper, FaceTecErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(faceTecResultProcessor, "faceTecResultProcessor");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.sessionStatus = sessionStatus;
        this.faceTecResultProcessor = faceTecResultProcessor;
        this.errorToFailureMapper = errorToFailureMapper;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        MutableLiveData<LivenessCaptureViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveDataEvent<LivenessCaptureNavigationEvent> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._navigationEvent = singleLiveDataEvent;
        this.navigationEvent = singleLiveDataEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFaceTecLivenessCaptureError(Throwable faceTecError) {
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map(faceTecError));
        this._navigationEvent.setValue(new LivenessCaptureNavigationEvent.NavigateToCaptureFailure(this.errorToFailureMapper.map(faceTecError)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFaceTecLivenessSaveSuccess(FaceTecFiles livenessResultFiles) {
        String str = this.resourceId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceId");
            str = null;
        }
        this._navigationEvent.setValue(new LivenessCaptureNavigationEvent.NavigateToUpload(new LivenessFaceTecCaptureViewData(str, livenessResultFiles.getFrames(), livenessResultFiles.getFaceMap())));
    }

    private boolean isCaptureInProgress() {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        Boolean bool = (Boolean) savedStateHandle.get(LivenessFaceTecCaptureViewModelKt.KEY_IS_CAPTURE_IN_PROGRESS);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private void setCaptureInProgress(boolean z) {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set(LivenessFaceTecCaptureViewModelKt.KEY_IS_CAPTURE_IN_PROGRESS, Boolean.valueOf(z));
    }

    public void cleanupCapture(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FileManager.deleteDir(context.getDir(FaceTecConstantsKt.TEMP_FILES_PATH, 0));
    }

    public LiveData<LivenessCaptureNavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public LiveData<LivenessCaptureViewState> getViewState() {
        return this.viewState;
    }

    public void handleFaceTecResult(FaceTecSessionResult faceTecSessionResult) {
        setCaptureInProgress(false);
        Disposable disposable = this.createLivenessCaptureFilesDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.createLivenessCaptureFilesDisposable = this.faceTecResultProcessor.processFaceTecResult(faceTecSessionResult).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.handleFaceTecLivenessSaveSuccess((FaceTecFiles) obj);
            }
        }, new Consumer() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.handleFaceTecLivenessCaptureError((Throwable) obj);
            }
        });
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        Disposable disposable = this.createLivenessCaptureFilesDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
    }

    public void startLivenessCapture(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        if (isCaptureInProgress()) {
            return;
        }
        this._viewState.setValue(LivenessCaptureViewState.LivenessCaptureInProgress.INSTANCE);
        setCaptureInProgress(true);
    }
}
