package com.reactnativenavigation.options;

import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.options.params.NullFraction;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.ThemeColour;
import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0000J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0019"}, m5598d2 = {"Lcom/reactnativenavigation/options/ShadowOptions;", "", "color", "Lcom/reactnativenavigation/options/params/ThemeColour;", RadialGradientManager.PROP_RADIUS, "Lcom/reactnativenavigation/options/params/Fraction;", ViewProps.OPACITY, "(Lcom/reactnativenavigation/options/params/ThemeColour;Lcom/reactnativenavigation/options/params/Fraction;Lcom/reactnativenavigation/options/params/Fraction;)V", "getColor", "()Lcom/reactnativenavigation/options/params/ThemeColour;", "setColor", "(Lcom/reactnativenavigation/options/params/ThemeColour;)V", "getOpacity", "()Lcom/reactnativenavigation/options/params/Fraction;", "setOpacity", "(Lcom/reactnativenavigation/options/params/Fraction;)V", "getRadius", "setRadius", "copy", "hasValue", "", "mergeWith", "other", "mergeWithDefaults", "defaultOptions", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ShadowOptions {
    private ThemeColour color;
    private Fraction opacity;
    private Fraction radius;

    public ShadowOptions() {
        this(null, null, null, 7, null);
    }

    public ShadowOptions(ThemeColour color, Fraction radius, Fraction opacity) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(radius, "radius");
        Intrinsics.checkNotNullParameter(opacity, "opacity");
        this.color = color;
        this.radius = radius;
        this.opacity = opacity;
    }

    public /* synthetic */ ShadowOptions(NullThemeColour nullThemeColour, NullFraction nullFraction, NullFraction nullFraction2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new NullThemeColour() : nullThemeColour, (i & 2) != 0 ? new NullFraction() : nullFraction, (i & 4) != 0 ? new NullFraction() : nullFraction2);
    }

    public final ThemeColour getColor() {
        return this.color;
    }

    public final Fraction getOpacity() {
        return this.opacity;
    }

    public final Fraction getRadius() {
        return this.radius;
    }

    public final void setColor(ThemeColour themeColour) {
        Intrinsics.checkNotNullParameter(themeColour, "<set-?>");
        this.color = themeColour;
    }

    public final void setOpacity(Fraction fraction) {
        Intrinsics.checkNotNullParameter(fraction, "<set-?>");
        this.opacity = fraction;
    }

    public final void setRadius(Fraction fraction) {
        Intrinsics.checkNotNullParameter(fraction, "<set-?>");
        this.radius = fraction;
    }

    public final ShadowOptions copy() {
        return new ShadowOptions(this.color, this.radius, this.opacity);
    }

    public final ShadowOptions mergeWith(ShadowOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.color.hasValue()) {
            this.color = other.color;
        }
        if (other.opacity.hasValue()) {
            this.opacity = other.opacity;
        }
        if (other.radius.hasValue()) {
            this.radius = other.radius;
        }
        return this;
    }

    public static /* synthetic */ ShadowOptions mergeWithDefaults$default(ShadowOptions shadowOptions, ShadowOptions shadowOptions2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeWithDefaults");
        }
        if ((i & 1) != 0) {
            shadowOptions2 = NullShadowOptions.INSTANCE;
        }
        return shadowOptions.mergeWithDefaults(shadowOptions2);
    }

    public final ShadowOptions mergeWithDefaults(ShadowOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (!this.color.hasValue()) {
            this.color = defaultOptions.color;
        }
        if (!this.opacity.hasValue()) {
            this.opacity = defaultOptions.opacity;
        }
        if (!this.radius.hasValue()) {
            this.radius = defaultOptions.radius;
        }
        return this;
    }

    public boolean hasValue() {
        return this.color.hasValue() || this.radius.hasValue() || this.opacity.hasValue();
    }
}
