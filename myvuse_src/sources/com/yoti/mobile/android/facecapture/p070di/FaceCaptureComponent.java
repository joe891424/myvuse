package com.yoti.mobile.android.facecapture.p070di;

import com.yoti.mobile.android.facecapture.p070di.module.FaceCaptureModule;
import com.yoti.mobile.android.facecapture.view.FaceCaptureActivity;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragment;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {FaceCaptureModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\nH&¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/di/FaceCaptureComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "session", "Lcom/yoti/mobile/android/facecapture/di/FaceCaptureSession;", "activity", "Lcom/yoti/mobile/android/facecapture/view/FaceCaptureActivity;", "captureFragment", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragment;", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragment;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface FaceCaptureComponent extends FeatureComponent {
    void inject(FaceCaptureSession session);

    void inject(FaceCaptureActivity activity);

    void inject(FaceCaptureFragment captureFragment);

    void inject(FaceCaptureReviewFragment captureFragment);
}
