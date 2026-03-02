package com.yoti.mobile.android.liveness.view.upload;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorNavigationEvent;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadErrorViewEvent;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0092\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "factory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;)V", "_navigationEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorNavigationEvent;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "handleViewEvent", "", "viewEvent", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadErrorViewEvent;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class LivenessUploadErrorViewModel extends ViewModel {
    private final MutableLiveData<SingleEvent<LivenessUploadErrorNavigationEvent>> _navigationEvent;
    private final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory;
    private final LiveData<SingleEvent<LivenessUploadErrorNavigationEvent>> navigationEvent;

    @Inject
    public LivenessUploadErrorViewModel(LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factory = factory;
        MutableLiveData<SingleEvent<LivenessUploadErrorNavigationEvent>> mutableLiveData = new MutableLiveData<>();
        this._navigationEvent = mutableLiveData;
        this.navigationEvent = mutableLiveData;
    }

    public LiveData<SingleEvent<LivenessUploadErrorNavigationEvent>> getNavigationEvent() {
        return this.navigationEvent;
    }

    public void handleViewEvent(LivenessUploadErrorViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (Intrinsics.areEqual(viewEvent, LivenessUploadErrorViewEvent.ScanAgain.INSTANCE)) {
            this._navigationEvent.setValue(new SingleEvent<>(LivenessUploadErrorNavigationEvent.NavigateBackToLivenessEducational.INSTANCE));
        } else if (viewEvent instanceof LivenessUploadErrorViewEvent.SeeGuidelines) {
            this._navigationEvent.setValue(new SingleEvent<>(new LivenessUploadErrorNavigationEvent.NavigateToGuidelines(this.factory.create(((LivenessUploadErrorViewEvent.SeeGuidelines) viewEvent).getFailureType()))));
        } else if (Intrinsics.areEqual(viewEvent, LivenessUploadErrorViewEvent.NavigateBack.INSTANCE)) {
            this._navigationEvent.setValue(new SingleEvent<>(LivenessUploadErrorNavigationEvent.CancelFlow.INSTANCE));
        }
    }
}
