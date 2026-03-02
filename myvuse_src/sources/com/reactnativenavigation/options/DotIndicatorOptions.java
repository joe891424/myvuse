package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DotIndicatorOptions {
    public ThemeColour color = new NullThemeColour();
    public Number size = new NullNumber();
    public Bool visible = new NullBool();
    public Bool animate = new NullBool();

    public static DotIndicatorOptions parse(Context context, JSONObject jSONObject) {
        DotIndicatorOptions dotIndicatorOptions = new DotIndicatorOptions();
        if (jSONObject == null) {
            return dotIndicatorOptions;
        }
        dotIndicatorOptions.color = ThemeColour.parse(context, jSONObject.optJSONObject("color"));
        dotIndicatorOptions.size = NumberParser.parse(jSONObject, "size");
        dotIndicatorOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        dotIndicatorOptions.animate = BoolParser.parse(jSONObject, "animate");
        return dotIndicatorOptions;
    }

    public boolean hasValue() {
        return this.visible.hasValue();
    }
}
