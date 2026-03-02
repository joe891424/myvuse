package com.yoti.mobile.android.facecapture.view.review;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent;", "", "()V", "OnCaptureApproved", "OnCaptureRejected", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent$OnCaptureRejected;", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent$OnCaptureApproved;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class FaceCaptureReviewViewEvent {

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent$OnCaptureApproved;", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnCaptureApproved extends FaceCaptureReviewViewEvent {
        public static final OnCaptureApproved INSTANCE = new OnCaptureApproved();

        private OnCaptureApproved() {
            super(null);
        }
    }

    @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent$OnCaptureRejected;", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewViewEvent;", "()V", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class OnCaptureRejected extends FaceCaptureReviewViewEvent {
        public static final OnCaptureRejected INSTANCE = new OnCaptureRejected();

        private OnCaptureRejected() {
            super(null);
        }
    }

    private FaceCaptureReviewViewEvent() {
    }

    public /* synthetic */ FaceCaptureReviewViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
