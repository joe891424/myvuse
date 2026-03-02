package com.reactnativenavigation.utils;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BorderRadiusOutlineProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/utils/BorderRadiusOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "image", "Landroid/widget/ImageView;", "initialRadius", "", "(Landroid/widget/ImageView;F)V", "<set-?>", RadialGradientManager.PROP_RADIUS, "getRadius", "()F", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "updateRadius", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BorderRadiusOutlineProvider extends ViewOutlineProvider {
    private final ImageView image;
    private float radius;

    public BorderRadiusOutlineProvider(ImageView image, float f) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.radius = f;
    }

    public final float getRadius() {
        return this.radius;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Rect clipBounds = this.image.getClipBounds();
        int iWidth = clipBounds != null ? clipBounds.width() : this.image.getWidth();
        Rect clipBounds2 = this.image.getClipBounds();
        outline.setRoundRect(0, 0, iWidth, clipBounds2 != null ? clipBounds2.height() : this.image.getHeight(), this.radius);
    }

    public final void updateRadius(float radius) {
        this.radius = radius;
        this.image.invalidateOutline();
    }
}
