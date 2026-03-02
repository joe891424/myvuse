package com.yoti.mobile.android.facecapture.view.review;

import com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final class FaceCaptureReviewViewModel_Factory implements Factory<FaceCaptureReviewViewModel> {
    private final Provider<CaptureResultProcessor> captureProcessorProvider;

    public FaceCaptureReviewViewModel_Factory(Provider<CaptureResultProcessor> provider) {
        this.captureProcessorProvider = provider;
    }

    public static FaceCaptureReviewViewModel_Factory create(Provider<CaptureResultProcessor> provider) {
        return new FaceCaptureReviewViewModel_Factory(provider);
    }

    public static FaceCaptureReviewViewModel newInstance(CaptureResultProcessor captureResultProcessor) {
        return new FaceCaptureReviewViewModel(captureResultProcessor);
    }

    @Override // javax.inject.Provider
    public FaceCaptureReviewViewModel get() {
        return newInstance(this.captureProcessorProvider.get());
    }
}
