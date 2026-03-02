package com.yoti.mobile.android.documentcapture.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/FrameEntity;", "", "bottomLeft", "Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;", "bottomRight", "topLeft", "topRight", "(Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;)V", "getBottomLeft", "()Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;", "getBottomRight", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class FrameEntity {
    private final CoordinateEntity bottomLeft;
    private final CoordinateEntity bottomRight;
    private final CoordinateEntity topLeft;
    private final CoordinateEntity topRight;

    public FrameEntity(CoordinateEntity bottomLeft, CoordinateEntity bottomRight, CoordinateEntity topLeft, CoordinateEntity topRight) {
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
        this.topRight = topRight;
    }

    public static /* synthetic */ FrameEntity copy$default(FrameEntity frameEntity, CoordinateEntity coordinateEntity, CoordinateEntity coordinateEntity2, CoordinateEntity coordinateEntity3, CoordinateEntity coordinateEntity4, int i, Object obj) {
        if ((i & 1) != 0) {
            coordinateEntity = frameEntity.bottomLeft;
        }
        if ((i & 2) != 0) {
            coordinateEntity2 = frameEntity.bottomRight;
        }
        if ((i & 4) != 0) {
            coordinateEntity3 = frameEntity.topLeft;
        }
        if ((i & 8) != 0) {
            coordinateEntity4 = frameEntity.topRight;
        }
        return frameEntity.copy(coordinateEntity, coordinateEntity2, coordinateEntity3, coordinateEntity4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CoordinateEntity getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CoordinateEntity getBottomRight() {
        return this.bottomRight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CoordinateEntity getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CoordinateEntity getTopRight() {
        return this.topRight;
    }

    public final FrameEntity copy(CoordinateEntity bottomLeft, CoordinateEntity bottomRight, CoordinateEntity topLeft, CoordinateEntity topRight) {
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        return new FrameEntity(bottomLeft, bottomRight, topLeft, topRight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameEntity)) {
            return false;
        }
        FrameEntity frameEntity = (FrameEntity) other;
        return Intrinsics.areEqual(this.bottomLeft, frameEntity.bottomLeft) && Intrinsics.areEqual(this.bottomRight, frameEntity.bottomRight) && Intrinsics.areEqual(this.topLeft, frameEntity.topLeft) && Intrinsics.areEqual(this.topRight, frameEntity.topRight);
    }

    public final CoordinateEntity getBottomLeft() {
        return this.bottomLeft;
    }

    public final CoordinateEntity getBottomRight() {
        return this.bottomRight;
    }

    public final CoordinateEntity getTopLeft() {
        return this.topLeft;
    }

    public final CoordinateEntity getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        return (((((this.bottomLeft.hashCode() * 31) + this.bottomRight.hashCode()) * 31) + this.topLeft.hashCode()) * 31) + this.topRight.hashCode();
    }

    public String toString() {
        return "FrameEntity(bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ", topLeft=" + this.topLeft + ", topRight=" + this.topRight + ')';
    }
}
