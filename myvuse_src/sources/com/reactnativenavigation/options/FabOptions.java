package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.TextParser;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class FabOptions {

    /* JADX INFO: renamed from: id */
    public Text f4201id = new NullText();
    public ThemeColour backgroundColor = new NullThemeColour();
    public ThemeColour clickColor = new NullThemeColour();
    public ThemeColour rippleColor = new NullThemeColour();
    public Text icon = new NullText();
    public ThemeColour iconColor = new NullThemeColour();
    public Bool visible = new NullBool();
    public ArrayList<FabOptions> actionsArray = new ArrayList<>();
    public Text alignHorizontally = new NullText();
    public Text alignVertically = new NullText();
    public Bool hideOnScroll = new NullBool();
    public Text size = new NullText();

    public static FabOptions parse(Context context, JSONObject jSONObject) {
        FabOptions fabOptions = new FabOptions();
        if (jSONObject == null) {
            return fabOptions;
        }
        fabOptions.f4201id = TextParser.parse(jSONObject, "id");
        fabOptions.backgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("backgroundColor"));
        fabOptions.clickColor = ThemeColour.parse(context, jSONObject.optJSONObject("clickColor"));
        fabOptions.rippleColor = ThemeColour.parse(context, jSONObject.optJSONObject("rippleColor"));
        fabOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        if (jSONObject.has("icon")) {
            fabOptions.icon = TextParser.parse(jSONObject.optJSONObject("icon"), "uri");
        }
        fabOptions.iconColor = ThemeColour.parse(context, jSONObject.optJSONObject(OTUXParamsKeys.OT_UX_ICON_COLOR));
        if (jSONObject.has("actions")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("actions");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                fabOptions.actionsArray.add(parse(context, jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
        fabOptions.alignHorizontally = TextParser.parse(jSONObject, "alignHorizontally");
        fabOptions.alignVertically = TextParser.parse(jSONObject, "alignVertically");
        fabOptions.hideOnScroll = BoolParser.parse(jSONObject, "hideOnScroll");
        fabOptions.size = TextParser.parse(jSONObject, "size");
        return fabOptions;
    }

    void mergeWith(FabOptions fabOptions) {
        if (fabOptions.f4201id.hasValue()) {
            this.f4201id = fabOptions.f4201id;
        }
        if (fabOptions.backgroundColor.hasValue()) {
            this.backgroundColor = fabOptions.backgroundColor;
        }
        if (fabOptions.clickColor.hasValue()) {
            this.clickColor = fabOptions.clickColor;
        }
        if (fabOptions.iconColor.hasValue()) {
            this.iconColor = fabOptions.iconColor;
        }
        if (fabOptions.rippleColor.hasValue()) {
            this.rippleColor = fabOptions.rippleColor;
        }
        if (fabOptions.visible.hasValue()) {
            this.visible = fabOptions.visible;
        }
        if (fabOptions.icon.hasValue()) {
            this.icon = fabOptions.icon;
        }
        if (fabOptions.actionsArray.size() > 0) {
            this.actionsArray = fabOptions.actionsArray;
        }
        if (fabOptions.alignVertically.hasValue()) {
            this.alignVertically = fabOptions.alignVertically;
        }
        if (fabOptions.alignHorizontally.hasValue()) {
            this.alignHorizontally = fabOptions.alignHorizontally;
        }
        if (fabOptions.hideOnScroll.hasValue()) {
            this.hideOnScroll = fabOptions.hideOnScroll;
        }
        if (fabOptions.size.hasValue()) {
            this.size = fabOptions.size;
        }
    }

    void mergeWithDefault(FabOptions fabOptions) {
        if (!this.f4201id.hasValue()) {
            this.f4201id = fabOptions.f4201id;
        }
        if (!this.iconColor.hasValue()) {
            this.iconColor = fabOptions.iconColor;
        }
        if (!this.rippleColor.hasValue()) {
            this.rippleColor = fabOptions.rippleColor;
        }
        if (!this.clickColor.hasValue()) {
            this.clickColor = fabOptions.clickColor;
        }
        if (!this.backgroundColor.hasValue()) {
            this.backgroundColor = fabOptions.backgroundColor;
        }
        if (!this.visible.hasValue()) {
            this.visible = fabOptions.visible;
        }
        if (!this.icon.hasValue()) {
            this.icon = fabOptions.icon;
        }
        if (this.actionsArray.size() == 0) {
            this.actionsArray = fabOptions.actionsArray;
        }
        if (!this.alignHorizontally.hasValue()) {
            this.alignHorizontally = fabOptions.alignHorizontally;
        }
        if (!this.alignVertically.hasValue()) {
            this.alignVertically = fabOptions.alignVertically;
        }
        if (!this.hideOnScroll.hasValue()) {
            this.hideOnScroll = fabOptions.hideOnScroll;
        }
        if (this.size.hasValue()) {
            return;
        }
        this.size = fabOptions.size;
    }

    public boolean hasValue() {
        return this.f4201id.hasValue() || this.icon.hasValue();
    }
}
