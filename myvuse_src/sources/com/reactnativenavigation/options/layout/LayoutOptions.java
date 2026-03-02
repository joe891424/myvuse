package com.reactnativenavigation.options.layout;

import android.content.Context;
import com.brentvatne.react.ReactVideoView;
import com.reactnativenavigation.options.LayoutDirection;
import com.reactnativenavigation.options.OrientationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: LayoutOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m5598d2 = {"Lcom/reactnativenavigation/options/layout/LayoutOptions;", "", "()V", "adjustResize", "Lcom/reactnativenavigation/options/params/Bool;", "backgroundColor", "Lcom/reactnativenavigation/options/params/ThemeColour;", "componentBackgroundColor", "direction", "Lcom/reactnativenavigation/options/LayoutDirection;", "insets", "Lcom/reactnativenavigation/options/layout/LayoutInsets;", "getInsets", "()Lcom/reactnativenavigation/options/layout/LayoutInsets;", "setInsets", "(Lcom/reactnativenavigation/options/layout/LayoutInsets;)V", ReactVideoView.EVENT_PROP_ORIENTATION, "Lcom/reactnativenavigation/options/OrientationOptions;", "topMargin", "Lcom/reactnativenavigation/options/params/Number;", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class LayoutOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public ThemeColour backgroundColor = new NullThemeColour();
    public ThemeColour componentBackgroundColor = new NullThemeColour();
    public Number topMargin = new NullNumber();
    public Bool adjustResize = new NullBool();
    public OrientationOptions orientation = new OrientationOptions();
    public LayoutDirection direction = LayoutDirection.DEFAULT;
    private LayoutInsets insets = new LayoutInsets(null, null, null, null, 15, null);

    @JvmStatic
    public static final LayoutOptions parse(Context context, JSONObject jSONObject) {
        return INSTANCE.parse(context, jSONObject);
    }

    public final LayoutInsets getInsets() {
        return this.insets;
    }

    public final void setInsets(LayoutInsets layoutInsets) {
        Intrinsics.checkNotNullParameter(layoutInsets, "<set-?>");
        this.insets = layoutInsets;
    }

    public final void mergeWith(LayoutOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.backgroundColor.hasValue()) {
            this.backgroundColor = other.backgroundColor;
        }
        if (other.componentBackgroundColor.hasValue()) {
            this.componentBackgroundColor = other.componentBackgroundColor;
        }
        if (other.topMargin.hasValue()) {
            this.topMargin = other.topMargin;
        }
        if (other.orientation.hasValue()) {
            this.orientation = other.orientation;
        }
        if (other.direction.hasValue()) {
            this.direction = other.direction;
        }
        if (other.adjustResize.hasValue()) {
            this.adjustResize = other.adjustResize;
        }
        this.insets.merge(other.insets, null);
    }

    public final void mergeWithDefault(LayoutOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (!this.backgroundColor.hasValue()) {
            this.backgroundColor = defaultOptions.backgroundColor;
        }
        if (!this.componentBackgroundColor.hasValue()) {
            this.componentBackgroundColor = defaultOptions.componentBackgroundColor;
        }
        if (!this.topMargin.hasValue()) {
            this.topMargin = defaultOptions.topMargin;
        }
        if (!this.orientation.hasValue()) {
            this.orientation = defaultOptions.orientation;
        }
        if (!this.direction.hasValue()) {
            this.direction = defaultOptions.direction;
        }
        if (!this.adjustResize.hasValue()) {
            this.adjustResize = defaultOptions.adjustResize;
        }
        this.insets.merge(null, defaultOptions.insets);
    }

    /* JADX INFO: compiled from: LayoutOptions.kt */
    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, m5598d2 = {"Lcom/reactnativenavigation/options/layout/LayoutOptions$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/layout/LayoutOptions;", "context", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LayoutOptions parse(Context context, JSONObject json) {
            LayoutOptions layoutOptions = new LayoutOptions();
            if (json == null) {
                return layoutOptions;
            }
            ThemeColour.Companion companion = ThemeColour.INSTANCE;
            Intrinsics.checkNotNull(context);
            layoutOptions.backgroundColor = companion.parse(context, json.optJSONObject("backgroundColor"));
            layoutOptions.componentBackgroundColor = ThemeColour.INSTANCE.parse(context, json.optJSONObject("componentBackgroundColor"));
            Number number = NumberParser.parse(json, "topMargin");
            Intrinsics.checkNotNullExpressionValue(number, "parse(...)");
            layoutOptions.topMargin = number;
            layoutOptions.setInsets(LayoutInsets.INSTANCE.parse(json.optJSONObject("insets")));
            OrientationOptions orientationOptions = OrientationOptions.parse(json);
            Intrinsics.checkNotNullExpressionValue(orientationOptions, "parse(...)");
            layoutOptions.orientation = orientationOptions;
            LayoutDirection layoutDirectionFromString = LayoutDirection.fromString(json.optString("direction", ""));
            Intrinsics.checkNotNullExpressionValue(layoutDirectionFromString, "fromString(...)");
            layoutOptions.direction = layoutDirectionFromString;
            Bool bool = BoolParser.parse(json, "adjustResize");
            Intrinsics.checkNotNullExpressionValue(bool, "parse(...)");
            layoutOptions.adjustResize = bool;
            return layoutOptions;
        }
    }
}
