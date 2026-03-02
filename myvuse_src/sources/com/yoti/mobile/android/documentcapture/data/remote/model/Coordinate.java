package com.yoti.mobile.android.documentcapture.data.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/data/remote/model/Coordinate;", "", EllipticCurveJsonWebKey.X_MEMBER_NAME, "", EllipticCurveJsonWebKey.Y_MEMBER_NAME, "(II)V", "getX", "()I", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class Coordinate {

    @SerializedName(EllipticCurveJsonWebKey.X_MEMBER_NAME)
    private final int x;

    @SerializedName(EllipticCurveJsonWebKey.Y_MEMBER_NAME)
    private final int y;

    public Coordinate(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public static /* synthetic */ Coordinate copy$default(Coordinate coordinate, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = coordinate.x;
        }
        if ((i3 & 2) != 0) {
            i2 = coordinate.y;
        }
        return coordinate.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public final Coordinate copy(int x, int y) {
        return new Coordinate(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) other;
        return this.x == coordinate.x && this.y == coordinate.y;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return (Integer.hashCode(this.x) * 31) + Integer.hashCode(this.y);
    }

    public String toString() {
        return "Coordinate(x=" + this.x + ", y=" + this.y + ')';
    }
}
