package com.yoti.mobile.android.facecapture.view.review;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.yoti.mobile.android.liveness.view.capture.model.ILivenessCapture;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentArgs;", "Landroidx/navigation/NavArgs;", "livenessCapture", "Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "(Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;)V", "getLivenessCapture", "()Lcom/yoti/mobile/android/liveness/view/capture/model/ILivenessCapture;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FaceCaptureReviewFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ILivenessCapture livenessCapture;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/facecapture/view/review/FaceCaptureReviewFragmentArgs;", "bundle", "Landroid/os/Bundle;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FaceCaptureReviewFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(FaceCaptureReviewFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("livenessCapture")) {
                throw new IllegalArgumentException("Required argument \"livenessCapture\" is missing and does not have an android:defaultValue");
            }
            if (!Parcelable.class.isAssignableFrom(ILivenessCapture.class) && !Serializable.class.isAssignableFrom(ILivenessCapture.class)) {
                throw new UnsupportedOperationException(ILivenessCapture.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            ILivenessCapture iLivenessCapture = (ILivenessCapture) bundle.get("livenessCapture");
            if (iLivenessCapture != null) {
                return new FaceCaptureReviewFragmentArgs(iLivenessCapture);
            }
            throw new IllegalArgumentException("Argument \"livenessCapture\" is marked as non-null but was passed a null value.");
        }
    }

    public FaceCaptureReviewFragmentArgs(ILivenessCapture livenessCapture) {
        Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
        this.livenessCapture = livenessCapture;
    }

    public static /* synthetic */ FaceCaptureReviewFragmentArgs copy$default(FaceCaptureReviewFragmentArgs faceCaptureReviewFragmentArgs, ILivenessCapture iLivenessCapture, int i, Object obj) {
        if ((i & 1) != 0) {
            iLivenessCapture = faceCaptureReviewFragmentArgs.livenessCapture;
        }
        return faceCaptureReviewFragmentArgs.copy(iLivenessCapture);
    }

    @JvmStatic
    public static final FaceCaptureReviewFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ILivenessCapture getLivenessCapture() {
        return this.livenessCapture;
    }

    public final FaceCaptureReviewFragmentArgs copy(ILivenessCapture livenessCapture) {
        Intrinsics.checkNotNullParameter(livenessCapture, "livenessCapture");
        return new FaceCaptureReviewFragmentArgs(livenessCapture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FaceCaptureReviewFragmentArgs) && Intrinsics.areEqual(this.livenessCapture, ((FaceCaptureReviewFragmentArgs) other).livenessCapture);
    }

    public final ILivenessCapture getLivenessCapture() {
        return this.livenessCapture;
    }

    public int hashCode() {
        return this.livenessCapture.hashCode();
    }

    public final Bundle toBundle() {
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

    public String toString() {
        return "FaceCaptureReviewFragmentArgs(livenessCapture=" + this.livenessCapture + ')';
    }
}
