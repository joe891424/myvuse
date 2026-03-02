package com.yoti.mobile.android.documentcapture.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/CoordinateEntity;", "", EllipticCurveJsonWebKey.X_MEMBER_NAME, "", EllipticCurveJsonWebKey.Y_MEMBER_NAME, "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class CoordinateEntity {
    private final float x;
    private final float y;

    public CoordinateEntity(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static /* synthetic */ CoordinateEntity copy$default(CoordinateEntity coordinateEntity, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = coordinateEntity.x;
        }
        if ((i & 2) != 0) {
            f2 = coordinateEntity.y;
        }
        return coordinateEntity.copy(f, f2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final CoordinateEntity copy(float x, float y) {
        return new CoordinateEntity(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoordinateEntity)) {
            return false;
        }
        CoordinateEntity coordinateEntity = (CoordinateEntity) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(coordinateEntity.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(coordinateEntity.y));
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "CoordinateEntity(x=" + this.x + ", y=" + this.y + ')';
    }
}
