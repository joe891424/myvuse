package com.yoti.mobile.android.facecapture.view.review;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.FaceCaptureNavGraphDirections;
import com.yoti.mobile.android.facecapture.view.capture.model.CaptureConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentDirections;", "", "()V", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureReviewFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentDirections$Companion;", "", "()V", "actionGlobalToFaceCapture", "Landroidx/navigation/NavDirections;", "captureConfig", "Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "actionToLivenessUpload", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToFaceCapture(CaptureConfig captureConfig) {
            Intrinsics.checkNotNullParameter(captureConfig, "captureConfig");
            return FaceCaptureNavGraphDirections.INSTANCE.actionGlobalToFaceCapture(captureConfig);
        }

        public final NavDirections actionToLivenessUpload() {
            return new ActionOnlyNavDirections(C4832R.id.action_to_livenessUpload);
        }
    }

    private FaceCaptureReviewFragmentDirections() {
    }
}
