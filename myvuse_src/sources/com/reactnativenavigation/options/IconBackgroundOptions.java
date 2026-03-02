package com.reactnativenavigation.options;

import android.content.Context;
import com.reactnativenavigation.options.params.DensityPixel;
import com.reactnativenavigation.options.params.NullDensityPixel;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Param;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.DensityPixelParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class IconBackgroundOptions {
    public ThemeColour color = new NullThemeColour();
    public ThemeColour disabledColor = new NullThemeColour();
    public DensityPixel width = new NullDensityPixel();
    public DensityPixel height = new NullDensityPixel();
    public DensityPixel cornerRadius = new NullDensityPixel();

    public static IconBackgroundOptions parse(Context context, JSONObject jSONObject) {
        IconBackgroundOptions iconBackgroundOptions = new IconBackgroundOptions();
        if (jSONObject == null) {
            return iconBackgroundOptions;
        }
        iconBackgroundOptions.color = ThemeColour.parse(context, jSONObject.optJSONObject("color"));
        iconBackgroundOptions.disabledColor = ThemeColour.parse(context, jSONObject.optJSONObject("disabledColor"));
        iconBackgroundOptions.width = DensityPixelParser.parse(jSONObject, "width");
        iconBackgroundOptions.height = DensityPixelParser.parse(jSONObject, "height");
        iconBackgroundOptions.cornerRadius = DensityPixelParser.parse(jSONObject, "cornerRadius");
        return iconBackgroundOptions;
    }

    public boolean equals(IconBackgroundOptions iconBackgroundOptions) {
        return this.color.equals(iconBackgroundOptions.color) && this.disabledColor.equals(iconBackgroundOptions.disabledColor) && this.width.equals((Param) iconBackgroundOptions.width) && this.height.equals((Param) iconBackgroundOptions.height) && this.cornerRadius.equals((Param) iconBackgroundOptions.cornerRadius);
    }

    public IconBackgroundOptions copy() {
        IconBackgroundOptions iconBackgroundOptions = new IconBackgroundOptions();
        iconBackgroundOptions.mergeWith(this);
        return iconBackgroundOptions;
    }

    public boolean hasValue() {
        return this.color.hasValue();
    }

    public void mergeWith(IconBackgroundOptions iconBackgroundOptions) {
        if (iconBackgroundOptions.color.hasValue()) {
            this.color = iconBackgroundOptions.color;
        }
        if (iconBackgroundOptions.disabledColor.hasValue()) {
            this.disabledColor = iconBackgroundOptions.disabledColor;
        }
        if (iconBackgroundOptions.width.hasValue()) {
            this.width = iconBackgroundOptions.width;
        }
        if (iconBackgroundOptions.height.hasValue()) {
            this.height = iconBackgroundOptions.height;
        }
        if (iconBackgroundOptions.cornerRadius.hasValue()) {
            this.cornerRadius = iconBackgroundOptions.cornerRadius;
        }
    }

    public void mergeWithDefault(IconBackgroundOptions iconBackgroundOptions) {
        if (!this.color.hasValue()) {
            this.color = iconBackgroundOptions.color;
        }
        if (!this.disabledColor.hasValue()) {
            this.disabledColor = iconBackgroundOptions.disabledColor;
        }
        if (!this.width.hasValue()) {
            this.width = iconBackgroundOptions.width;
        }
        if (!this.height.hasValue()) {
            this.height = iconBackgroundOptions.height;
        }
        if (this.cornerRadius.hasValue()) {
            return;
        }
        this.cornerRadius = iconBackgroundOptions.cornerRadius;
    }
}
