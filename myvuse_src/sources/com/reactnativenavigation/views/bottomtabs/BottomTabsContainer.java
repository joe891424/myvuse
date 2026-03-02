package com.reactnativenavigation.views.bottomtabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.utils.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BottomTabsContainer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, m5598d2 = {"Lcom/reactnativenavigation/views/bottomtabs/BottomTabsContainer;", "Lcom/reactnativenavigation/views/bottomtabs/ShadowLayout;", "context", "Landroid/content/Context;", "bottomTabs", "Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;", "(Landroid/content/Context;Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;)V", "getBottomTabs", "()Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;", "value", "", "shadowRadius", "getShadowRadius", "()F", "setShadowRadius", "(F)V", "Lcom/reactnativenavigation/views/bottomtabs/TopOutlineView;", "topOutLineView", "getTopOutLineView", "()Lcom/reactnativenavigation/views/bottomtabs/TopOutlineView;", "setTopOutLineView", "(Lcom/reactnativenavigation/views/bottomtabs/TopOutlineView;)V", "clearShadow", "", "clearTopOutline", "hideTopOutLine", "revealTopOutline", "setElevation", "elevation", "Lcom/reactnativenavigation/options/params/Fraction;", "setShadowOpacity", ViewProps.OPACITY, "setTopOutLineColor", "color", "", "setTopOutlineWidth", "width", "showShadow", "showTopLine", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BottomTabsContainer extends ShadowLayout {
    private final BottomTabs bottomTabs;
    private TopOutlineView topOutLineView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomTabsContainer(Context context, BottomTabs bottomTabs) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bottomTabs, "bottomTabs");
        this.bottomTabs = bottomTabs;
        this.topOutLineView = new TopOutlineView(context);
        setShadowed(false);
        setId(View.generateViewId());
        setShadowAngle(270.0f);
        setShadowDistance(15.0f);
        setShadowColor(-16777216);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(this.topOutLineView, new FrameLayout.LayoutParams(-1, 1));
        linearLayout.addView(bottomTabs, -1, -2);
        setClipChildren(false);
        setClipToPadding(false);
        setTopOutLineColor(BottomTabsContainerKt.DEFAULT_TOP_OUTLINE_COLOR);
        this.topOutLineView.setVisibility(8);
        addView(linearLayout, -1, -2);
    }

    public final BottomTabs getBottomTabs() {
        return this.bottomTabs;
    }

    public final TopOutlineView getTopOutLineView() {
        return this.topOutLineView;
    }

    public final void setTopOutLineView(TopOutlineView value) {
        Intrinsics.checkNotNullParameter(value, "value");
        removeView(this.topOutLineView);
        addView(value, new FrameLayout.LayoutParams(-1, -2));
        this.topOutLineView = value;
    }

    @Override // com.reactnativenavigation.views.bottomtabs.ShadowLayout
    public float getShadowRadius() {
        return super.getShadowRadius();
    }

    @Override // com.reactnativenavigation.views.bottomtabs.ShadowLayout
    public void setShadowRadius(float f) {
        super.setShadowRadius(10 + f);
    }

    public final void setTopOutlineWidth(int width) {
        TopOutlineView topOutlineView = this.topOutLineView;
        ViewGroup.LayoutParams layoutParams = topOutlineView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.height = width;
        topOutlineView.setLayoutParams(layoutParams2);
    }

    public final void setTopOutLineColor(int color) {
        this.topOutLineView.setBackgroundColor(color);
    }

    public final void setShadowOpacity(float opacity) {
        setShadowColor(ColorUtils.setAlphaComponent(getShadowColor(), MathKt.roundToInt(opacity * 255)));
    }

    public final void showShadow() {
        setShadowed(true);
    }

    public final void clearShadow() {
        setShadowed(false);
    }

    public final void showTopLine() {
        this.topOutLineView.setVisibility(0);
    }

    public final void clearTopOutline() {
        this.topOutLineView.setVisibility(8);
    }

    public final void revealTopOutline() {
        this.topOutLineView.setAlpha(1.0f);
    }

    public final void hideTopOutLine() {
        this.topOutLineView.setAlpha(0.0f);
    }

    public final void setElevation(Fraction elevation) {
        Intrinsics.checkNotNullParameter(elevation, "elevation");
        setElevation(UiUtils.dpToPx(getContext(), (float) elevation.get().doubleValue()));
    }
}
