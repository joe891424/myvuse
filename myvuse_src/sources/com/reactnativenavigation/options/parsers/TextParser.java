package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.utils.ObjectUtils;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TextParser {
    public static Text parse(@Nullable JSONObject jSONObject, String str, String str2) {
        return (Text) ObjectUtils.take(parse(jSONObject, str), new Text(str2));
    }

    public static Text parse(@Nullable JSONObject jSONObject, String str) {
        return (jSONObject == null || !jSONObject.has(str)) ? new NullText() : new Text(jSONObject.optString(str));
    }
}
