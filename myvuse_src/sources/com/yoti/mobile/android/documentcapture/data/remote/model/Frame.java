package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/Frame;", "", "bottomLeft", "Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;", "bottomRight", "topLeft", "topRight", "(Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;)V", "getBottomLeft", "()Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;", "getBottomRight", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Frame {

    @SerializedName("bottom_left")
    private final Coordinate bottomLeft;

    @SerializedName("bottom_right")
    private final Coordinate bottomRight;

    @SerializedName("top_left")
    private final Coordinate topLeft;

    @SerializedName("top_right")
    private final Coordinate topRight;

    public Frame() {
        this(null, null, null, null, 15, null);
    }

    public Frame(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4) {
        this.bottomLeft = coordinate;
        this.bottomRight = coordinate2;
        this.topLeft = coordinate3;
        this.topRight = coordinate4;
    }

    public static /* synthetic */ Frame copy$default(Frame frame, Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4, int i, Object obj) {
        if ((i & 1) != 0) {
            coordinate = frame.bottomLeft;
        }
        if ((i & 2) != 0) {
            coordinate2 = frame.bottomRight;
        }
        if ((i & 4) != 0) {
            coordinate3 = frame.topLeft;
        }
        if ((i & 8) != 0) {
            coordinate4 = frame.topRight;
        }
        return frame.copy(coordinate, coordinate2, coordinate3, coordinate4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Coordinate getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Coordinate getBottomRight() {
        return this.bottomRight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Coordinate getTopLeft() {
        return this.topLeft;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Coordinate getTopRight() {
        return this.topRight;
    }

    public final Frame copy(Coordinate bottomLeft, Coordinate bottomRight, Coordinate topLeft, Coordinate topRight) {
        return new Frame(bottomLeft, bottomRight, topLeft, topRight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Frame)) {
            return false;
        }
        Frame frame = (Frame) other;
        return Intrinsics.areEqual(this.bottomLeft, frame.bottomLeft) && Intrinsics.areEqual(this.bottomRight, frame.bottomRight) && Intrinsics.areEqual(this.topLeft, frame.topLeft) && Intrinsics.areEqual(this.topRight, frame.topRight);
    }

    public final Coordinate getBottomLeft() {
        return this.bottomLeft;
    }

    public final Coordinate getBottomRight() {
        return this.bottomRight;
    }

    public final Coordinate getTopLeft() {
        return this.topLeft;
    }

    public final Coordinate getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        Coordinate coordinate = this.bottomLeft;
        int iHashCode = (coordinate == null ? 0 : coordinate.hashCode()) * 31;
        Coordinate coordinate2 = this.bottomRight;
        int iHashCode2 = (iHashCode + (coordinate2 == null ? 0 : coordinate2.hashCode())) * 31;
        Coordinate coordinate3 = this.topLeft;
        int iHashCode3 = (iHashCode2 + (coordinate3 == null ? 0 : coordinate3.hashCode())) * 31;
        Coordinate coordinate4 = this.topRight;
        return iHashCode3 + (coordinate4 != null ? coordinate4.hashCode() : 0);
    }

    public String toString() {
        return "Frame(bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ", topLeft=" + this.topLeft + ", topRight=" + this.topRight + ')';
    }

    public /* synthetic */ Frame(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : coordinate, (i & 2) != 0 ? null : coordinate2, (i & 4) != 0 ? null : coordinate3, (i & 8) != 0 ? null : coordinate4);
    }
}
