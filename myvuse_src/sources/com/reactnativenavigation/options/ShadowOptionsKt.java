package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.FractionParser;
import com.surajit.rnrg.RadialGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ShadowOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, m5598d2 = {"parseShadowOptions", "Lcom/reactnativenavigation/options/ShadowOptions;", "context", "Landroid/content/Context;", "shadowJson", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ShadowOptionsKt {
    public static final ShadowOptions parseShadowOptions(Context context, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (jSONObject != null) {
            ThemeColour themeColour = ThemeColour.INSTANCE.parse(context, jSONObject.optJSONObject("color"));
            Fraction fraction = FractionParser.parse(jSONObject, RadialGradientManager.PROP_RADIUS);
            Intrinsics.checkNotNullExpressionValue(fraction, "parse(...)");
            Fraction fraction2 = FractionParser.parse(jSONObject, ViewProps.OPACITY);
            Intrinsics.checkNotNullExpressionValue(fraction2, "parse(...)");
            return new ShadowOptions(themeColour, fraction, fraction2);
        }
        return NullShadowOptions.INSTANCE;
    }
}
