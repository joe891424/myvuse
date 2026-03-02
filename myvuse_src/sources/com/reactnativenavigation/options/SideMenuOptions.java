package com.reactnativenavigation.options;

import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenuOptions {
    public Bool visible = new NullBool();
    public Bool animate = new NullBool();
    public Bool enabled = new NullBool();
    public Number height = new NullNumber();
    public Number width = new NullNumber();

    public static SideMenuOptions parse(JSONObject jSONObject) {
        SideMenuOptions sideMenuOptions = new SideMenuOptions();
        if (jSONObject == null) {
            return sideMenuOptions;
        }
        sideMenuOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        sideMenuOptions.animate = BoolParser.parse(jSONObject, "animate");
        sideMenuOptions.enabled = BoolParser.parse(jSONObject, ViewProps.ENABLED);
        sideMenuOptions.height = NumberParser.parse(jSONObject, "height");
        sideMenuOptions.width = NumberParser.parse(jSONObject, "width");
        return sideMenuOptions;
    }

    public void mergeWith(SideMenuOptions sideMenuOptions) {
        if (sideMenuOptions.visible.hasValue()) {
            this.visible = sideMenuOptions.visible;
        }
        if (sideMenuOptions.animate.hasValue()) {
            this.animate = sideMenuOptions.animate;
        }
        if (sideMenuOptions.enabled.hasValue()) {
            this.enabled = sideMenuOptions.enabled;
        }
        if (sideMenuOptions.height.hasValue()) {
            this.height = sideMenuOptions.height;
        }
        if (sideMenuOptions.width.hasValue()) {
            this.width = sideMenuOptions.width;
        }
    }

    public void mergeWithDefault(SideMenuOptions sideMenuOptions) {
        if (!this.visible.hasValue()) {
            this.visible = sideMenuOptions.visible;
        }
        if (!this.animate.hasValue()) {
            this.animate = sideMenuOptions.animate;
        }
        if (!this.enabled.hasValue()) {
            this.enabled = sideMenuOptions.enabled;
        }
        if (!this.height.hasValue()) {
            this.height = sideMenuOptions.height;
        }
        if (this.width.hasValue()) {
            return;
        }
        this.width = sideMenuOptions.width;
    }
}
