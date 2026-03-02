package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.params.DensityPixel;
import com.reactnativenavigation.options.params.NullDensityPixel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DensityPixelParser {
    public static DensityPixel parse(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? new DensityPixel(jSONObject.optInt(str)) : new NullDensityPixel();
    }
}
