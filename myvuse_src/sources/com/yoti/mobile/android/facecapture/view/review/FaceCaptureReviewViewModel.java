package com.yoti.mobile.android.facecapture.view.review;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor;
import com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewEvent;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewModel;", "Landroidx/lifecycle/ViewModel;", "captureProcessor", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureResultProcessor;", "(Lcom/yoti/mobile/android/facecapture/view/capture/CaptureResultProcessor;)V", "_navigationEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "_viewState", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewState;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "viewState", "getViewState", "handleViewEvent", "", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureReviewViewModel extends ViewModel {
    private final MutableLiveData<SingleEvent<CaptureNavigationEvent>> _navigationEvent;
    private final MutableLiveData<FaceCaptureReviewViewState> _viewState;
    private final CaptureResultProcessor captureProcessor;
    private final LiveData<SingleEvent<CaptureNavigationEvent>> navigationEvent;
    private final LiveData<FaceCaptureReviewViewState> viewState;

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewViewModel$1", m5608f = "FaceCaptureReviewViewModel.kt", m5609i = {}, m5610l = {36}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48701(Continuation<? super C48701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceCaptureReviewViewModel.this.new C48701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FaceCaptureReviewViewModel.this._viewState.setValue(FaceCaptureReviewViewState.LoadingCapture.INSTANCE);
                CaptureResultProcessor captureResultProcessor = FaceCaptureReviewViewModel.this.captureProcessor;
                this.label = 1;
                obj = captureResultProcessor.readFaceCapture(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            byte[] bArr = (byte[]) obj;
            if (bArr.length == 0) {
                C4588L.logError$default("FaceCaptureReviewViewModel", "Error while reading face capture, ByteArray is empty.", null, 4, null);
                FaceCaptureReviewViewModel.this._viewState.setValue(FaceCaptureReviewViewState.CaptureReviewError.INSTANCE);
            } else {
                FaceCaptureReviewViewModel.this._viewState.setValue(new FaceCaptureReviewViewState.DisplayCaptureReview(bArr));
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public FaceCaptureReviewViewModel(CaptureResultProcessor captureProcessor) {
        Intrinsics.checkNotNullParameter(captureProcessor, "captureProcessor");
        this.captureProcessor = captureProcessor;
        MutableLiveData<FaceCaptureReviewViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        MutableLiveData<SingleEvent<CaptureNavigationEvent>> mutableLiveData2 = new MutableLiveData<>();
        this._navigationEvent = mutableLiveData2;
        this.navigationEvent = mutableLiveData2;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C48701(null), 3, null);
    }

    public final LiveData<SingleEvent<CaptureNavigationEvent>> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final LiveData<FaceCaptureReviewViewState> getViewState() {
        return this.viewState;
    }

    public final void handleViewEvent(FaceCaptureReviewViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FaceCaptureReviewViewEvent.OnCaptureRejected.INSTANCE)) {
            this._navigationEvent.setValue(new SingleEvent<>(CaptureNavigationEvent.NavigateToFaceCapture.INSTANCE));
        } else if (Intrinsics.areEqual(event, FaceCaptureReviewViewEvent.OnCaptureApproved.INSTANCE)) {
            this._navigationEvent.setValue(new SingleEvent<>(CaptureNavigationEvent.NavigateToUpload.INSTANCE));
        }
    }
}
