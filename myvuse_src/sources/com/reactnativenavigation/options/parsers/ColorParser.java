package com.reactnativenavigation.options.parsers;

import android.content.Context;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.WritableMap;
import com.reactnativenavigation.options.params.Colour;
import com.reactnativenavigation.options.params.DontApplyColour;
import com.reactnativenavigation.options.params.NullColor;
import com.reactnativenavigation.options.params.ReactPlatformColor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ColorParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/reactnativenavigation/options/parsers/ColorParser;", "", "()V", "KEY_RESOURCE_PATHS", "", "VAL_NO_COLOR", "parse", "Lcom/reactnativenavigation/options/params/Colour;", "context", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "colorName", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ColorParser {
    public static final ColorParser INSTANCE = new ColorParser();
    private static final String KEY_RESOURCE_PATHS = "resource_paths";
    private static final String VAL_NO_COLOR = "NoColor";

    private ColorParser() {
    }

    @JvmStatic
    public static final Colour parse(Context context, JSONObject json, String colorName) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.has(KEY_RESOURCE_PATHS)) {
            WritableMap writableMapConvert = JSONParser.convert(json);
            Intrinsics.checkNotNullExpressionValue(writableMapConvert, "convert(...)");
            return new ReactPlatformColor(writableMapConvert);
        }
        Object objOpt = json.opt(colorName);
        if (objOpt == null ? true : Intrinsics.areEqual(objOpt, VAL_NO_COLOR)) {
            return new DontApplyColour();
        }
        if (objOpt instanceof Integer) {
            return new Colour(json.optInt(colorName));
        }
        if (objOpt instanceof JSONObject) {
            Integer color = ColorPropConverter.getColor(objOpt, context);
            if (color != null) {
                return new Colour(color.intValue());
            }
            return new NullColor();
        }
        return new NullColor();
    }
}
