package com.reactnativenavigation.options;

import android.content.Context;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.options.params.NullFraction;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.FontParser;
import com.reactnativenavigation.options.parsers.FractionParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SubtitleOptions {
    public Text text = new NullText();
    public ThemeColour color = new NullThemeColour();
    public Fraction fontSize = new NullFraction();
    public FontOptions font = new FontOptions();
    public Alignment alignment = Alignment.Default;

    public static SubtitleOptions parse(Context context, TypefaceLoader typefaceLoader, JSONObject jSONObject) {
        SubtitleOptions subtitleOptions = new SubtitleOptions();
        if (jSONObject == null) {
            return subtitleOptions;
        }
        subtitleOptions.text = TextParser.parse(jSONObject, "text");
        subtitleOptions.color = ThemeColour.parse(context, jSONObject.optJSONObject("color"));
        subtitleOptions.fontSize = FractionParser.parse(jSONObject, "fontSize");
        subtitleOptions.font = FontParser.parse(jSONObject);
        subtitleOptions.alignment = Alignment.fromString(TextParser.parse(jSONObject, "alignment").get(""));
        return subtitleOptions;
    }

    void mergeWith(SubtitleOptions subtitleOptions) {
        if (subtitleOptions.text.hasValue()) {
            this.text = subtitleOptions.text;
        }
        if (subtitleOptions.color.hasValue()) {
            this.color = subtitleOptions.color;
        }
        if (subtitleOptions.fontSize.hasValue()) {
            this.fontSize = subtitleOptions.fontSize;
        }
        this.font.mergeWith(subtitleOptions.font);
        if (subtitleOptions.alignment != Alignment.Default) {
            this.alignment = subtitleOptions.alignment;
        }
    }

    void mergeWithDefault(SubtitleOptions subtitleOptions) {
        if (!this.text.hasValue()) {
            this.text = subtitleOptions.text;
        }
        if (!this.color.hasValue()) {
            this.color = subtitleOptions.color;
        }
        if (!this.fontSize.hasValue()) {
            this.fontSize = subtitleOptions.fontSize;
        }
        this.font.mergeWithDefault(subtitleOptions.font);
        if (this.alignment == Alignment.Default) {
            this.alignment = subtitleOptions.alignment;
        }
    }
}
