package com.yoti.mobile.android.liveness.view.educational;

import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadValidationFailure;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewDataFactory;", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadValidationFailure;", "()V", "create", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData;", "failureType", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessGuidelinesViewDataFactory implements LivenessGuidelinesViewData.Factory<LivenessUploadValidationFailure> {
    @Inject
    public LivenessGuidelinesViewDataFactory() {
    }

    @Override // com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData.Factory
    public LivenessGuidelinesViewData create(LivenessUploadValidationFailure failureType) {
        return DefaultLivenessGuidelinesViewData.INSTANCE;
    }
}
