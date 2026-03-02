package com.yoti.mobile.android.liveness.zoom;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/LivenessFacetecNavGraphDirections;", "", "()V", "ActionGlobalToLivenessFacetecCapture", "Companion", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFacetecNavGraphDirections {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/LivenessFacetecNavGraphDirections$ActionGlobalToLivenessFacetecCapture;", "Landroidx/navigation/NavDirections;", "resourceId", "", "(Ljava/lang/String;)V", "getResourceId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private static final /* data */ class ActionGlobalToLivenessFacetecCapture implements NavDirections {
        private final String resourceId;

        public ActionGlobalToLivenessFacetecCapture(String resourceId) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            this.resourceId = resourceId;
        }

        public static /* synthetic */ ActionGlobalToLivenessFacetecCapture copy$default(ActionGlobalToLivenessFacetecCapture actionGlobalToLivenessFacetecCapture, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actionGlobalToLivenessFacetecCapture.resourceId;
            }
            return actionGlobalToLivenessFacetecCapture.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getResourceId() {
            return this.resourceId;
        }

        public final ActionGlobalToLivenessFacetecCapture copy(String resourceId) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            return new ActionGlobalToLivenessFacetecCapture(resourceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ActionGlobalToLivenessFacetecCapture) && Intrinsics.areEqual(this.resourceId, ((ActionGlobalToLivenessFacetecCapture) other).resourceId);
        }

        @Override // androidx.navigation.NavDirections
        public int getActionId() {
            return C4888R.id.action_global_to_liveness_facetec_capture;
        }

        @Override // androidx.navigation.NavDirections
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("resourceId", this.resourceId);
            return bundle;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public int hashCode() {
            return this.resourceId.hashCode();
        }

        public String toString() {
            return "ActionGlobalToLivenessFacetecCapture(resourceId=" + this.resourceId + ')';
        }
    }

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/LivenessFacetecNavGraphDirections$Companion;", "", "()V", "actionGlobalToLivenessFacetecCapture", "Landroidx/navigation/NavDirections;", "resourceId", "", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavDirections actionGlobalToLivenessFacetecCapture(String resourceId) {
            Intrinsics.checkNotNullParameter(resourceId, "resourceId");
            return new ActionGlobalToLivenessFacetecCapture(resourceId);
        }
    }

    private LivenessFacetecNavGraphDirections() {
    }
}
