package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class StatusBarOptions {
    public ThemeColour backgroundColor = new NullThemeColour();
    public TextColorScheme textColorScheme = TextColorScheme.None;
    public Bool visible = new NullBool();
    public Bool drawBehind = new NullBool();
    public Bool translucent = new NullBool();

    public enum TextColorScheme {
        Light("light"),
        Dark("dark"),
        None("none");

        private String scheme;

        TextColorScheme(String str) {
            this.scheme = str;
        }

        public static TextColorScheme fromString(String str) {
            if (str == null) {
                return None;
            }
            str.hashCode();
            if (str.equals("dark")) {
                return Dark;
            }
            if (str.equals("light")) {
                return Light;
            }
            return None;
        }

        public boolean hasValue() {
            return !this.scheme.equals(None.scheme);
        }
    }

    public static StatusBarOptions parse(Context context, JSONObject jSONObject) {
        StatusBarOptions statusBarOptions = new StatusBarOptions();
        if (jSONObject == null) {
            return statusBarOptions;
        }
        statusBarOptions.backgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("backgroundColor"));
        statusBarOptions.textColorScheme = TextColorScheme.fromString(jSONObject.optString("style"));
        statusBarOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        statusBarOptions.drawBehind = BoolParser.parse(jSONObject, "drawBehind");
        statusBarOptions.translucent = BoolParser.parse(jSONObject, "translucent");
        return statusBarOptions;
    }

    public void mergeWith(StatusBarOptions statusBarOptions) {
        if (statusBarOptions.backgroundColor.hasValue()) {
            this.backgroundColor = statusBarOptions.backgroundColor;
        }
        if (statusBarOptions.textColorScheme.hasValue()) {
            this.textColorScheme = statusBarOptions.textColorScheme;
        }
        if (statusBarOptions.visible.hasValue()) {
            this.visible = statusBarOptions.visible;
        }
        if (statusBarOptions.drawBehind.hasValue()) {
            this.drawBehind = statusBarOptions.drawBehind;
        }
        if (statusBarOptions.translucent.hasValue()) {
            this.translucent = statusBarOptions.translucent;
        }
    }

    public void mergeWithDefault(StatusBarOptions statusBarOptions) {
        if (!this.backgroundColor.hasValue()) {
            this.backgroundColor = statusBarOptions.backgroundColor;
        }
        if (!this.textColorScheme.hasValue()) {
            this.textColorScheme = statusBarOptions.textColorScheme;
        }
        if (!this.visible.hasValue()) {
            this.visible = statusBarOptions.visible;
        }
        if (!this.drawBehind.hasValue()) {
            this.drawBehind = statusBarOptions.drawBehind;
        }
        if (this.translucent.hasValue()) {
            return;
        }
        this.translucent = statusBarOptions.translucent;
    }

    public boolean isHiddenOrDrawBehind() {
        return this.drawBehind.isTrue() || this.visible.isFalse();
    }

    public boolean hasTransparency() {
        return this.translucent.isTrue() || this.visible.isFalse() || this.backgroundColor.hasTransparency();
    }
}
