package com.yoti.mobile.android.liveness.zoom.p072di;

import com.yoti.mobile.android.liveness.zoom.p072di.module.LivenessFaceTecModule;
import com.yoti.mobile.android.liveness.zoom.view.LivenessFaceTecActivity;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment;
import com.yoti.mobile.android.liveness.zoom.view.capture.ScanFaceErrorFragment;
import com.yoti.mobile.android.yotisdkcore.feature.FeatureComponent;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Component(modules = {LivenessFaceTecModule.class})
@Singleton
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecComponent;", "Lcom/yoti/mobile/android/yotisdkcore/feature/FeatureComponent;", "inject", "", "faceTecSession", "Lcom/yoti/mobile/android/liveness/zoom/di/LivenessFaceTecSession;", "livenessFaceTecActivity", "Lcom/yoti/mobile/android/liveness/zoom/view/LivenessFaceTecActivity;", "captureFragment", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragment;", "scanFaceErrorFragment", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/ScanFaceErrorFragment;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface LivenessFaceTecComponent extends FeatureComponent {
    void inject(LivenessFaceTecSession faceTecSession);

    void inject(LivenessFaceTecActivity livenessFaceTecActivity);

    void inject(LivenessFaceTecCaptureFragment captureFragment);

    void inject(ScanFaceErrorFragment scanFaceErrorFragment);
}
