package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.Number;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class NumberParser {
    public static Number parse(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? new Number(jSONObject.optInt(str)) : new NullNumber();
    }
}
