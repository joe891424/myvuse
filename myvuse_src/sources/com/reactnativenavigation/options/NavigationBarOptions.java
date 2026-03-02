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
public class NavigationBarOptions {
    public ThemeColour backgroundColor = new NullThemeColour();
    public Bool isVisible = new NullBool();

    public static NavigationBarOptions parse(Context context, JSONObject jSONObject) {
        NavigationBarOptions navigationBarOptions = new NavigationBarOptions();
        if (jSONObject == null) {
            return navigationBarOptions;
        }
        navigationBarOptions.backgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("backgroundColor"));
        navigationBarOptions.isVisible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        return navigationBarOptions;
    }

    public void mergeWith(NavigationBarOptions navigationBarOptions) {
        if (navigationBarOptions.isVisible.hasValue()) {
            this.isVisible = navigationBarOptions.isVisible;
        }
        if (navigationBarOptions.backgroundColor.hasValue()) {
            this.backgroundColor = navigationBarOptions.backgroundColor;
        }
    }

    public void mergeWithDefault(NavigationBarOptions navigationBarOptions) {
        if (!this.isVisible.hasValue()) {
            this.isVisible = navigationBarOptions.isVisible;
        }
        if (this.backgroundColor.hasValue()) {
            return;
        }
        this.backgroundColor = navigationBarOptions.backgroundColor;
    }
}
