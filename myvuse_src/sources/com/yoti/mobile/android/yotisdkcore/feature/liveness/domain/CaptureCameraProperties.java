package com.yoti.mobile.android.yotisdkcore.feature.liveness.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/liveness/domain/CaptureCameraProperties;", "", "useBackCamera", "", "isAutomaticCapture", "(ZZ)V", "()Z", "getUseBackCamera", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CaptureCameraProperties {
    private final boolean isAutomaticCapture;
    private final boolean useBackCamera;

    public CaptureCameraProperties(boolean z, boolean z2) {
        this.useBackCamera = z;
        this.isAutomaticCapture = z2;
    }

    public /* synthetic */ CaptureCameraProperties(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2);
    }

    public static /* synthetic */ CaptureCameraProperties copy$default(CaptureCameraProperties captureCameraProperties, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = captureCameraProperties.useBackCamera;
        }
        if ((i & 2) != 0) {
            z2 = captureCameraProperties.isAutomaticCapture;
        }
        return captureCameraProperties.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUseBackCamera() {
        return this.useBackCamera;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAutomaticCapture() {
        return this.isAutomaticCapture;
    }

    public final CaptureCameraProperties copy(boolean useBackCamera, boolean isAutomaticCapture) {
        return new CaptureCameraProperties(useBackCamera, isAutomaticCapture);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureCameraProperties)) {
            return false;
        }
        CaptureCameraProperties captureCameraProperties = (CaptureCameraProperties) other;
        return this.useBackCamera == captureCameraProperties.useBackCamera && this.isAutomaticCapture == captureCameraProperties.isAutomaticCapture;
    }

    public final boolean getUseBackCamera() {
        return this.useBackCamera;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z = this.useBackCamera;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isAutomaticCapture;
        return i + (z2 ? 1 : z2);
    }

    public final boolean isAutomaticCapture() {
        return this.isAutomaticCapture;
    }

    public String toString() {
        return "CaptureCameraProperties(useBackCamera=" + this.useBackCamera + ", isAutomaticCapture=" + this.isAutomaticCapture + ')';
    }
}
