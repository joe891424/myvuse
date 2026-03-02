package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.Fraction;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.NullFraction;
import com.reactnativenavigation.options.params.NullNumber;
import com.reactnativenavigation.options.params.NullText;
import com.reactnativenavigation.options.params.NullThemeColour;
import com.reactnativenavigation.options.params.Number;
import com.reactnativenavigation.options.params.Param;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.FontParser;
import com.reactnativenavigation.options.parsers.FractionParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.utils.IdFactory;
import com.reactnativenavigation.utils.ObjectUtils;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class ButtonOptions {
    public String instanceId = "btn" + CompatUtils.generateViewId();

    /* JADX INFO: renamed from: id */
    public String f4200id = "btn" + CompatUtils.generateViewId();
    public Text accessibilityLabel = new NullText();
    public Text text = new NullText();
    public Bool allCaps = new NullBool();
    public Bool enabled = new NullBool();
    public Bool disableIconTint = new NullBool();
    public Bool popStackOnPress = new NullBool();
    public Number showAsAction = new NullNumber();
    public ThemeColour color = new NullThemeColour();
    public ThemeColour disabledColor = new NullThemeColour();
    public Fraction fontSize = new NullFraction();
    public FontOptions font = new FontOptions();
    public Text icon = new NullText();
    public Text testId = new NullText();
    public ComponentOptions component = new ComponentOptions();
    public IconBackgroundOptions iconBackground = new IconBackgroundOptions();

    public boolean isBackButton() {
        return false;
    }

    public boolean equals(ButtonOptions buttonOptions) {
        return Objects.equals(this.f4200id, buttonOptions.f4200id) && this.accessibilityLabel.equals((Param) buttonOptions.accessibilityLabel) && this.text.equals((Param) buttonOptions.text) && this.allCaps.equals((Param) buttonOptions.allCaps) && this.enabled.equals((Param) buttonOptions.enabled) && this.disableIconTint.equals((Param) buttonOptions.disableIconTint) && this.showAsAction.equals((Param) buttonOptions.showAsAction) && this.color.equals(buttonOptions.color) && this.disabledColor.equals(buttonOptions.disabledColor) && this.fontSize.equals((Param) buttonOptions.fontSize) && this.font.equals(buttonOptions.font) && this.icon.equals((Param) buttonOptions.icon) && this.testId.equals((Param) buttonOptions.testId) && this.component.equals(buttonOptions.component) && this.popStackOnPress.equals((Param) buttonOptions.popStackOnPress);
    }

    private static ButtonOptions parseJson(Context context, JSONObject jSONObject) {
        ButtonOptions buttonOptions = new ButtonOptions();
        buttonOptions.f4200id = (String) ObjectUtils.take(jSONObject.optString("id"), "btn" + CompatUtils.generateViewId());
        buttonOptions.accessibilityLabel = TextParser.parse(jSONObject, ViewProps.ACCESSIBILITY_LABEL);
        buttonOptions.text = TextParser.parse(jSONObject, "text");
        buttonOptions.allCaps = BoolParser.parse(jSONObject, "allCaps");
        buttonOptions.enabled = BoolParser.parse(jSONObject, ViewProps.ENABLED);
        buttonOptions.disableIconTint = BoolParser.parse(jSONObject, "disableIconTint");
        buttonOptions.popStackOnPress = BoolParser.parse(jSONObject, "popStackOnPress");
        buttonOptions.showAsAction = parseShowAsAction(jSONObject);
        buttonOptions.color = ThemeColour.parse(context, jSONObject.optJSONObject("color"));
        buttonOptions.disabledColor = ThemeColour.parse(context, jSONObject.optJSONObject("disabledColor"));
        buttonOptions.fontSize = FractionParser.parse(jSONObject, "fontSize");
        buttonOptions.font = FontParser.parse(jSONObject);
        buttonOptions.testId = TextParser.parse(jSONObject, ViewProps.TEST_ID);
        buttonOptions.component = ComponentOptions.parse(jSONObject.optJSONObject("component"));
        buttonOptions.iconBackground = IconBackgroundOptions.parse(context, jSONObject.optJSONObject("iconBackground"));
        if (jSONObject.has("icon")) {
            buttonOptions.icon = TextParser.parse(jSONObject.optJSONObject("icon"), "uri");
        }
        return buttonOptions;
    }

    public static ArrayList<ButtonOptions> parse(Context context, JSONObject jSONObject, String str) {
        ArrayList<ButtonOptions> arrayList = new ArrayList<>();
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null) {
            arrayList.addAll(parseJsonArray(context, jSONArrayOptJSONArray));
        } else {
            arrayList.add(parseJson(context, jSONObject.optJSONObject(str)));
        }
        return arrayList;
    }

    private static ArrayList<ButtonOptions> parseJsonArray(Context context, JSONArray jSONArray) {
        ArrayList<ButtonOptions> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(parseJson(context, jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    public ButtonOptions copy() {
        ButtonOptions buttonOptions = new ButtonOptions();
        buttonOptions.mergeWith(this);
        return buttonOptions;
    }

    public boolean hasComponent() {
        return this.component.hasValue();
    }

    public boolean hasIcon() {
        return this.icon.hasValue();
    }

    public boolean shouldPopOnPress() {
        return this.popStackOnPress.get(true).booleanValue();
    }

    public int getIntId() {
        return IdFactory.INSTANCE.get(this.component.componentId.get(this.f4200id));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.reactnativenavigation.options.params.Number parseShowAsAction(org.json.JSONObject r4) {
        /*
            java.lang.String r0 = "showAsAction"
            com.reactnativenavigation.options.params.Text r4 = com.reactnativenavigation.options.parsers.TextParser.parse(r4, r0)
            boolean r0 = r4.hasValue()
            r1 = 1
            if (r0 != 0) goto L13
            com.reactnativenavigation.options.params.Number r4 = new com.reactnativenavigation.options.params.Number
            r4.<init>(r1)
            return r4
        L13:
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            int r0 = r4.hashCode()
            r2 = 0
            r3 = 2
            switch(r0) {
                case -1414557169: goto L41;
                case -1192154216: goto L37;
                case -940730605: goto L2d;
                case 104712844: goto L23;
                default: goto L22;
            }
        L22:
            goto L4b
        L23:
            java.lang.String r0 = "never"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L4b
            r4 = r1
            goto L4c
        L2d:
            java.lang.String r0 = "withText"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L4b
            r4 = r3
            goto L4c
        L37:
            java.lang.String r0 = "ifRoom"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L4b
            r4 = 3
            goto L4c
        L41:
            java.lang.String r0 = "always"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L4b
            r4 = r2
            goto L4c
        L4b:
            r4 = -1
        L4c:
            if (r4 == 0) goto L65
            if (r4 == r1) goto L5f
            if (r4 == r3) goto L58
            com.reactnativenavigation.options.params.Number r4 = new com.reactnativenavigation.options.params.Number
            r4.<init>(r1)
            return r4
        L58:
            com.reactnativenavigation.options.params.Number r4 = new com.reactnativenavigation.options.params.Number
            r0 = 4
            r4.<init>(r0)
            return r4
        L5f:
            com.reactnativenavigation.options.params.Number r4 = new com.reactnativenavigation.options.params.Number
            r4.<init>(r2)
            return r4
        L65:
            com.reactnativenavigation.options.params.Number r4 = new com.reactnativenavigation.options.params.Number
            r4.<init>(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.options.ButtonOptions.parseShowAsAction(org.json.JSONObject):com.reactnativenavigation.options.params.Number");
    }

    public void mergeWith(ButtonOptions buttonOptions) {
        if (buttonOptions.text.hasValue()) {
            this.text = buttonOptions.text;
        }
        if (buttonOptions.allCaps.hasValue()) {
            this.allCaps = buttonOptions.allCaps;
        }
        if (buttonOptions.accessibilityLabel.hasValue()) {
            this.accessibilityLabel = buttonOptions.accessibilityLabel;
        }
        if (buttonOptions.enabled.hasValue()) {
            this.enabled = buttonOptions.enabled;
        }
        if (buttonOptions.disableIconTint.hasValue()) {
            this.disableIconTint = buttonOptions.disableIconTint;
        }
        if (buttonOptions.color.hasValue()) {
            this.color = buttonOptions.color;
        }
        if (buttonOptions.disabledColor.hasValue()) {
            this.disabledColor = buttonOptions.disabledColor;
        }
        if (buttonOptions.fontSize.hasValue()) {
            this.fontSize = buttonOptions.fontSize;
        }
        this.font.mergeWith(buttonOptions.font);
        if (buttonOptions.testId.hasValue()) {
            this.testId = buttonOptions.testId;
        }
        if (buttonOptions.component.hasValue()) {
            this.component = buttonOptions.component;
        }
        if (buttonOptions.showAsAction.hasValue()) {
            this.showAsAction = buttonOptions.showAsAction;
        }
        if (buttonOptions.icon.hasValue()) {
            this.icon = buttonOptions.icon;
        }
        String str = buttonOptions.f4200id;
        if (str != null) {
            this.f4200id = str;
        }
        String str2 = buttonOptions.instanceId;
        if (str2 != null) {
            this.instanceId = str2;
        }
        if (buttonOptions.iconBackground.hasValue()) {
            this.iconBackground = buttonOptions.iconBackground;
        }
        if (buttonOptions.popStackOnPress.hasValue()) {
            this.popStackOnPress = buttonOptions.popStackOnPress;
        }
    }

    public void mergeWithDefault(ButtonOptions buttonOptions) {
        if (!this.text.hasValue()) {
            this.text = buttonOptions.text;
        }
        if (!this.allCaps.hasValue()) {
            this.allCaps = buttonOptions.allCaps;
        }
        if (!this.accessibilityLabel.hasValue()) {
            this.accessibilityLabel = buttonOptions.accessibilityLabel;
        }
        if (!this.enabled.hasValue()) {
            this.enabled = buttonOptions.enabled;
        }
        if (!this.disableIconTint.hasValue()) {
            this.disableIconTint = buttonOptions.disableIconTint;
        }
        if (!this.color.hasValue()) {
            this.color = buttonOptions.color;
        }
        if (!this.disabledColor.hasValue()) {
            this.disabledColor = buttonOptions.disabledColor;
        }
        if (!this.fontSize.hasValue()) {
            this.fontSize = buttonOptions.fontSize;
        }
        this.font.mergeWithDefault(buttonOptions.font);
        if (!this.testId.hasValue()) {
            this.testId = buttonOptions.testId;
        }
        if (!this.component.hasValue()) {
            this.component = buttonOptions.component;
        }
        if (!this.showAsAction.hasValue()) {
            this.showAsAction = buttonOptions.showAsAction;
        }
        if (!this.icon.hasValue()) {
            this.icon = buttonOptions.icon;
        }
        if (!this.iconBackground.hasValue()) {
            this.iconBackground = buttonOptions.iconBackground;
        }
        if (this.popStackOnPress.hasValue()) {
            return;
        }
        this.popStackOnPress = buttonOptions.popStackOnPress;
    }
}
