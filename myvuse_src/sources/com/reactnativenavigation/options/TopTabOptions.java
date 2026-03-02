package com.reactnativenavigation.options;

import android.graphics.Typeface;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabOptions {
    public Typeface fontFamily;
    public int tabIndex;
    public Text title = new NullText();

    public static TopTabOptions parse(TypefaceLoader typefaceLoader, JSONObject jSONObject) {
        TopTabOptions topTabOptions = new TopTabOptions();
        if (jSONObject == null) {
            return topTabOptions;
        }
        topTabOptions.title = TextParser.parse(jSONObject, "title");
        topTabOptions.fontFamily = typefaceLoader.getTypeFace(jSONObject.optString("titleFontFamily"), null, null);
        return topTabOptions;
    }

    void mergeWith(TopTabOptions topTabOptions) {
        if (topTabOptions.title.hasValue()) {
            this.title = topTabOptions.title;
        }
        Typeface typeface = topTabOptions.fontFamily;
        if (typeface != null) {
            this.fontFamily = typeface;
        }
        int i = topTabOptions.tabIndex;
        if (i >= 0) {
            this.tabIndex = i;
        }
    }

    void mergeWithDefault(TopTabOptions topTabOptions) {
        if (this.fontFamily == null) {
            this.fontFamily = topTabOptions.fontFamily;
        }
    }
}
