package com.reactnativenavigation.options.parsers;

import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Text;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class IconParser {
    public static Text parse(@Nullable JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return new NullText();
        }
        try {
            if (!(jSONObject.get(str) instanceof String)) {
                jSONObject = jSONObject.optJSONObject(str);
                str = "uri";
            }
            return TextParser.parse(jSONObject, str);
        } catch (JSONException e) {
            e.printStackTrace();
            return new NullText();
        }
    }
}
