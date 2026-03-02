package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragmentArgs;", "Landroidx/navigation/NavArgs;", "resourceId", "", "(Ljava/lang/String;)V", "getResourceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toString", "Companion", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class LivenessFaceTecCaptureFragmentArgs implements NavArgs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String resourceId;

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragmentArgs;", "bundle", "Landroid/os/Bundle;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LivenessFaceTecCaptureFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(LivenessFaceTecCaptureFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("resourceId")) {
                throw new IllegalArgumentException("Required argument \"resourceId\" is missing and does not have an android:defaultValue");
            }
            String string = bundle.getString("resourceId");
            if (string != null) {
                return new LivenessFaceTecCaptureFragmentArgs(string);
            }
            throw new IllegalArgumentException("Argument \"resourceId\" is marked as non-null but was passed a null value.");
        }
    }

    public LivenessFaceTecCaptureFragmentArgs(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
    }

    public static /* synthetic */ LivenessFaceTecCaptureFragmentArgs copy$default(LivenessFaceTecCaptureFragmentArgs livenessFaceTecCaptureFragmentArgs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livenessFaceTecCaptureFragmentArgs.resourceId;
        }
        return livenessFaceTecCaptureFragmentArgs.copy(str);
    }

    @JvmStatic
    public static final LivenessFaceTecCaptureFragmentArgs fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    public final LivenessFaceTecCaptureFragmentArgs copy(String resourceId) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new LivenessFaceTecCaptureFragmentArgs(resourceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LivenessFaceTecCaptureFragmentArgs) && Intrinsics.areEqual(this.resourceId, ((LivenessFaceTecCaptureFragmentArgs) other).resourceId);
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        return this.resourceId.hashCode();
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("resourceId", this.resourceId);
        return bundle;
    }

    public String toString() {
        return "LivenessFaceTecCaptureFragmentArgs(resourceId=" + this.resourceId + ')';
    }
}
