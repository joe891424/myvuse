package com.yoti.mobile.android.yotidocs.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/ImageDimensions;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class ImageDimensions {

    /* JADX INFO: renamed from: a */
    private final int f7459a;

    /* JADX INFO: renamed from: b */
    private final int f7460b;

    public ImageDimensions(int i, int i2) {
        this.f7459a = i;
        this.f7460b = i2;
    }

    public static /* synthetic */ ImageDimensions copy$default(ImageDimensions imageDimensions, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageDimensions.f7459a;
        }
        if ((i3 & 2) != 0) {
            i2 = imageDimensions.f7460b;
        }
        return imageDimensions.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getF7459a() {
        return this.f7459a;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getF7460b() {
        return this.f7460b;
    }

    public final ImageDimensions copy(int width, int height) {
        return new ImageDimensions(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageDimensions)) {
            return false;
        }
        ImageDimensions imageDimensions = (ImageDimensions) other;
        return this.f7459a == imageDimensions.f7459a && this.f7460b == imageDimensions.f7460b;
    }

    public final int getHeight() {
        return this.f7460b;
    }

    public final int getWidth() {
        return this.f7459a;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f7459a) * 31) + Integer.hashCode(this.f7460b);
    }

    public String toString() {
        return "ImageDimensions(width=" + this.f7459a + ", height=" + this.f7460b + ')';
    }
}
