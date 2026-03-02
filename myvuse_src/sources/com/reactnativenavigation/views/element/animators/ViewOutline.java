package com.reactnativenavigation.views.element.animators;

import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewOutline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/animators/ViewOutline;", "", "width", "", "height", RadialGradientManager.PROP_RADIUS, "(FFF)V", "getHeight", "()F", "getRadius", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final /* data */ class ViewOutline {
    private final float height;
    private final float radius;
    private final float width;

    public static /* synthetic */ ViewOutline copy$default(ViewOutline viewOutline, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = viewOutline.width;
        }
        if ((i & 2) != 0) {
            f2 = viewOutline.height;
        }
        if ((i & 4) != 0) {
            f3 = viewOutline.radius;
        }
        return viewOutline.copy(f, f2, f3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    public final ViewOutline copy(float width, float height, float radius) {
        return new ViewOutline(width, height, radius);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewOutline)) {
            return false;
        }
        ViewOutline viewOutline = (ViewOutline) other;
        return Float.compare(this.width, viewOutline.width) == 0 && Float.compare(this.height, viewOutline.height) == 0 && Float.compare(this.radius, viewOutline.radius) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.width) * 31) + Float.hashCode(this.height)) * 31) + Float.hashCode(this.radius);
    }

    public String toString() {
        return "ViewOutline(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ")";
    }

    public ViewOutline(float f, float f2, float f3) {
        this.width = f;
        this.height = f2;
        this.radius = f3;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getWidth() {
        return this.width;
    }
}
