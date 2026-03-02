package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: classes3.dex */
public interface CloseableStaticBitmap extends CloseableBitmap {
    CloseableReference<Bitmap> cloneUnderlyingBitmapReference();

    CloseableReference<Bitmap> convertToBitmapReference();

    int getExifOrientation();

    int getRotationAngle();

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1341of(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        return m1342of(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1343of(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        return m1344of(closeableReference, qualityInfo, i, 0);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1342of(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        if (BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
            return new BaseCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
        }
        return new DefaultCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1344of(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        if (BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
            return new BaseCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
        }
        return new DefaultCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
    }
}
