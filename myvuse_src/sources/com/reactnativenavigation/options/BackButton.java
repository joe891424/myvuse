package com.reactnativenavigation.options;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.params.Param;
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.react.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BackButton extends ButtonOptions {
    public static final String DEFAULT_ACCESSIBILITY_LABEL = "Navigate Up";
    private boolean hasValue;
    public Bool visible = new NullBool();

    @Override // com.reactnativenavigation.options.ButtonOptions
    public boolean isBackButton() {
        return true;
    }

    public static BackButton parse(Context context, JSONObject jSONObject) {
        BackButton backButton = new BackButton();
        if (jSONObject != null) {
            if (!(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).equals("{}")) {
                backButton.hasValue = true;
                backButton.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
                backButton.accessibilityLabel = TextParser.parse(jSONObject, ViewProps.ACCESSIBILITY_LABEL, DEFAULT_ACCESSIBILITY_LABEL);
                if (jSONObject.has("icon")) {
                    backButton.icon = TextParser.parse(jSONObject.optJSONObject("icon"), "uri");
                }
                backButton.f4200id = jSONObject.optString("id", Constants.BACK_BUTTON_ID);
                backButton.enabled = BoolParser.parse(jSONObject, ViewProps.ENABLED);
                backButton.disableIconTint = BoolParser.parse(jSONObject, "disableIconTint");
                backButton.color = ThemeColour.parse(context, jSONObject.optJSONObject("color"));
                backButton.disabledColor = ThemeColour.parse(context, jSONObject.optJSONObject("disabledColor"));
                backButton.testId = TextParser.parse(jSONObject, ViewProps.TEST_ID);
                backButton.popStackOnPress = BoolParser.parse(jSONObject, "popStackOnPress");
            }
        }
        return backButton;
    }

    public BackButton() {
        this.f4200id = Constants.BACK_BUTTON_ID;
        this.accessibilityLabel = new Text(DEFAULT_ACCESSIBILITY_LABEL);
    }

    public boolean hasValue() {
        return this.hasValue;
    }

    public void mergeWith(BackButton backButton) {
        if (!Constants.BACK_BUTTON_ID.equals(backButton.f4200id)) {
            this.f4200id = backButton.f4200id;
        }
        if (backButton.accessibilityLabel.hasValue() && !backButton.accessibilityLabel.equals((Param) new Text(DEFAULT_ACCESSIBILITY_LABEL))) {
            this.accessibilityLabel = backButton.accessibilityLabel;
        }
        if (backButton.icon.hasValue()) {
            this.icon = backButton.icon;
        }
        if (backButton.visible.hasValue()) {
            this.visible = backButton.visible;
        }
        if (backButton.color.hasValue()) {
            this.color = backButton.color;
        }
        if (backButton.disabledColor.hasValue()) {
            this.disabledColor = backButton.disabledColor;
        }
        if (backButton.disableIconTint.hasValue()) {
            this.disableIconTint = backButton.disableIconTint;
        }
        if (backButton.enabled.hasValue()) {
            this.enabled = backButton.enabled;
        }
        if (backButton.testId.hasValue()) {
            this.testId = backButton.testId;
        }
        if (backButton.popStackOnPress.hasValue()) {
            this.popStackOnPress = backButton.popStackOnPress;
        }
    }

    void mergeWithDefault(BackButton backButton) {
        if (Constants.BACK_BUTTON_ID.equals(this.f4200id)) {
            this.f4200id = backButton.f4200id;
        }
        if (!this.accessibilityLabel.hasValue() || this.accessibilityLabel.equals((Param) new Text(DEFAULT_ACCESSIBILITY_LABEL))) {
            this.accessibilityLabel = backButton.accessibilityLabel;
        }
        if (!this.icon.hasValue()) {
            this.icon = backButton.icon;
        }
        if (!this.visible.hasValue()) {
            this.visible = backButton.visible;
        }
        if (!this.color.hasValue()) {
            this.color = backButton.color;
        }
        if (!this.disabledColor.hasValue()) {
            this.disabledColor = backButton.disabledColor;
        }
        if (!this.disableIconTint.hasValue()) {
            this.disableIconTint = backButton.disableIconTint;
        }
        if (!this.enabled.hasValue()) {
            this.enabled = backButton.enabled;
        }
        if (!this.testId.hasValue()) {
            this.testId = backButton.testId;
        }
        if (this.popStackOnPress.hasValue()) {
            return;
        }
        this.popStackOnPress = backButton.popStackOnPress;
    }

    public void setVisible() {
        this.visible = new Bool(true);
        this.hasValue = true;
    }

    public void setHidden() {
        this.visible = new Bool(false);
        this.hasValue = true;
    }
}
