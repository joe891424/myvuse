package com.reactnativenavigation.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.reactnativenavigation.views.element.animators.ViewOutline;
import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OutlineProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m5598d2 = {"Lcom/reactnativenavigation/utils/OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "view", "Landroid/view/View;", "outline", "Lcom/reactnativenavigation/views/element/animators/ViewOutline;", "(Landroid/view/View;Lcom/reactnativenavigation/views/element/animators/ViewOutline;)V", RadialGradientManager.PROP_RADIUS, "", "getRadius", "()F", "getOutline", "", "Landroid/graphics/Outline;", "update", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class OutlineProvider extends ViewOutlineProvider {
    private ViewOutline outline;
    private final View view;

    public OutlineProvider(View view, ViewOutline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        this.view = view;
        this.outline = outline;
    }

    public final float getRadius() {
        return this.outline.getRadius();
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        outline.setRoundRect(0, 0, MathKt.roundToInt(this.outline.getWidth()), MathKt.roundToInt(this.outline.getHeight()), this.outline.getRadius());
    }

    public final void update(ViewOutline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        this.outline = outline;
        this.view.invalidateOutline();
    }
}
