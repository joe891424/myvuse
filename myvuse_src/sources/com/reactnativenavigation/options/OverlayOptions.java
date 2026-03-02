package com.reactnativenavigation.options;

import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.parsers.BoolParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class OverlayOptions {
    public Bool interceptTouchOutside = new NullBool();

    public static OverlayOptions parse(JSONObject jSONObject) {
        OverlayOptions overlayOptions = new OverlayOptions();
        if (jSONObject == null) {
            return overlayOptions;
        }
        overlayOptions.interceptTouchOutside = BoolParser.parse(jSONObject, "interceptTouchOutside");
        return overlayOptions;
    }
}
