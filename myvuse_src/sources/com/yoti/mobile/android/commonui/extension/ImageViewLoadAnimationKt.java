package com.yoti.mobile.android.commonui.extension;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewLoadAnimation.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m5598d2 = {"IMAGE_FADE_IN_DURATION", "", "showBitmapSoftly", "", "Landroid/widget/ImageView;", "bitmap", "Landroid/graphics/Bitmap;", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ImageViewLoadAnimationKt {
    public static final long IMAGE_FADE_IN_DURATION = 150;

    public static final void showBitmapSoftly(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        imageView.setImageBitmap(bitmap);
        imageView.animate().alpha(1.0f).setDuration(150L).start();
    }
}
