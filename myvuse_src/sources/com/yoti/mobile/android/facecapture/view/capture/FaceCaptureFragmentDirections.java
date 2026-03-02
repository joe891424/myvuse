package com.yoti.mobile.android.facecapture.view.capture;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.FaceCaptureNavGraphDirections;
import com.yoti.mobile.android.facecapture.view.capture.model.CaptureConfig;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragmentDirections;", "", "()V", "ActionToCaptureReview", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureFragmentDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragmentDirections$ActionToCaptureReview;", "Landroidx/navigation/NavDirections;", "livenessCapture", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "(Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;)V", "getLivenessCapture", "()Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionToCaptureReview implements NavDirections {
        private final ILivenessCapture livenessCapture;

        public ActionToCaptureReview(ILivenessCapture livenessCapture) {
            Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
            this.livenessCapture = livenessCapture;
        }

        public static /* synthetic */ ActionToCaptureReview copy$default(ActionToCaptureReview actionToCaptureReview, ILivenessCapture iLivenessCapture, int i, Object obj) {
            if ((i & 1) != 0) {
                iLivenessCapture = actionToCaptureReview.livenessCapture;
            }
            return actionToCaptureReview.copy(iLivenessCapture);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ILivenessCapture getLivenessCapture() {
            return this.livenessCapture;
        }

        public final ActionToCaptureReview copy(ILivenessCapture livenessCapture) {
            Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
            return new ActionToCaptureReview(livenessCapture);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionToCaptureReview) && Intrinsics.areEqual(this.livenessCapture, ((ActionToCaptureReview) other).livenessCapture);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4832R.id.action_to_captureReview;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(ILivenessCapture.class)) {
                bundle.putParcelable("livenessCapture", this.livenessCapture);
            } else {
                if (!Serializable.class.isAssignableFrom(ILivenessCapture.class)) {
                    throw new UnsupportedOperationException(ILivenessCapture.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
                bundle.putSerializable("livenessCapture", (Serializable) this.livenessCapture);
            }
            return bundle;
        }

        public final ILivenessCapture getLivenessCapture() {
            return this.livenessCapture;
        }

        public int hashCode() {
            return this.livenessCapture.hashCode();
        }

        public String toString() {
            return "ActionToCaptureReview(livenessCapture=" + this.livenessCapture + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragmentDirections$Companion;", "", "()V", "actionGlobalToFaceCapture", "Landroidx/navigation/NavDirections;", "captureConfig", "Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "actionToCaptureReview", "livenessCapture", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
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

        public final NavDirections actionToCaptureReview(ILivenessCapture livenessCapture) {
            Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
            return new ActionToCaptureReview(livenessCapture);
        }
    }

    private FaceCaptureFragmentDirections() {
    }
}
