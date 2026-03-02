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
import com.reactnativenavigation.options.params.Text;
import com.reactnativenavigation.options.params.ThemeColour;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.FractionParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.options.parsers.TextParser;
import com.reactnativenavigation.options.parsers.TypefaceLoader;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TopBarOptions {
    public TitleOptions title = new TitleOptions();
    public SubtitleOptions subtitle = new SubtitleOptions();
    public TopBarButtons buttons = new TopBarButtons();
    public Text testId = new NullText();
    public TopBarBackgroundOptions background = new TopBarBackgroundOptions();
    public Bool visible = new NullBool();
    public Bool animate = new NullBool();
    public Bool hideOnScroll = new NullBool();
    public Bool drawBehind = new NullBool();
    public Number height = new NullNumber();
    public Fraction elevation = new NullFraction();
    public Number topMargin = new NullNumber();
    public Fraction borderHeight = new NullFraction();
    public ThemeColour borderColor = new NullThemeColour();
    public Bool animateLeftButtons = new NullBool();
    public Bool animateRightButtons = new NullBool();
    public ThemeColour rightButtonColor = new NullThemeColour();
    public ThemeColour leftButtonColor = new NullThemeColour();
    public ThemeColour rightButtonDisabledColor = new NullThemeColour();
    public ThemeColour leftButtonDisabledColor = new NullThemeColour();
    public ThemeColour rightButtonBackgroundColor = new NullThemeColour();
    public ThemeColour leftButtonBackgroundColor = new NullThemeColour();

    public static TopBarOptions parse(Context context, TypefaceLoader typefaceLoader, JSONObject jSONObject) {
        TopBarOptions topBarOptions = new TopBarOptions();
        if (jSONObject == null) {
            return topBarOptions;
        }
        topBarOptions.title = TitleOptions.parse(context, typefaceLoader, jSONObject.optJSONObject("title"));
        topBarOptions.subtitle = SubtitleOptions.parse(context, typefaceLoader, jSONObject.optJSONObject(NotificationMessage.NOTIF_KEY_SUB_TITLE));
        topBarOptions.background = TopBarBackgroundOptions.parse(context, jSONObject.optJSONObject("background"));
        topBarOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        topBarOptions.animate = BoolParser.parse(jSONObject, "animate");
        topBarOptions.hideOnScroll = BoolParser.parse(jSONObject, "hideOnScroll");
        topBarOptions.drawBehind = BoolParser.parse(jSONObject, "drawBehind");
        topBarOptions.testId = TextParser.parse(jSONObject, ViewProps.TEST_ID);
        topBarOptions.height = NumberParser.parse(jSONObject, "height");
        topBarOptions.borderColor = ThemeColour.parse(context, jSONObject.optJSONObject("borderColor"));
        topBarOptions.borderHeight = FractionParser.parse(jSONObject, "borderHeight");
        topBarOptions.elevation = FractionParser.parse(jSONObject, "elevation");
        topBarOptions.topMargin = NumberParser.parse(jSONObject, "topMargin");
        topBarOptions.animateLeftButtons = BoolParser.parse(jSONObject, "animateLeftButtons");
        topBarOptions.animateRightButtons = BoolParser.parse(jSONObject, "animateRightButtons");
        topBarOptions.buttons = TopBarButtons.parse(context, jSONObject);
        topBarOptions.rightButtonColor = ThemeColour.parse(context, jSONObject.optJSONObject("rightButtonColor"));
        topBarOptions.leftButtonColor = ThemeColour.parse(context, jSONObject.optJSONObject("leftButtonColor"));
        topBarOptions.leftButtonDisabledColor = ThemeColour.parse(context, jSONObject.optJSONObject("leftButtonDisabledColor"));
        topBarOptions.rightButtonDisabledColor = ThemeColour.parse(context, jSONObject.optJSONObject("rightButtonDisabledColor"));
        topBarOptions.leftButtonBackgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("leftButtonBackgroundColor"));
        topBarOptions.rightButtonBackgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("rightButtonBackgroundColor"));
        topBarOptions.validate();
        return topBarOptions;
    }

    public TopBarOptions copy() {
        TopBarOptions topBarOptions = new TopBarOptions();
        topBarOptions.mergeWith(this);
        return topBarOptions;
    }

    void mergeWith(TopBarOptions topBarOptions) {
        this.title.mergeWith(topBarOptions.title);
        this.subtitle.mergeWith(topBarOptions.subtitle);
        this.background.mergeWith(topBarOptions.background);
        this.buttons.mergeWith(topBarOptions.buttons);
        if (topBarOptions.rightButtonColor.hasValue()) {
            this.rightButtonColor = topBarOptions.rightButtonColor;
        }
        if (topBarOptions.leftButtonColor.hasValue()) {
            this.leftButtonColor = topBarOptions.leftButtonColor;
        }
        if (topBarOptions.rightButtonDisabledColor.hasValue()) {
            this.rightButtonDisabledColor = topBarOptions.rightButtonDisabledColor;
        }
        if (topBarOptions.leftButtonDisabledColor.hasValue()) {
            this.leftButtonDisabledColor = topBarOptions.leftButtonDisabledColor;
        }
        if (topBarOptions.rightButtonBackgroundColor.hasValue()) {
            this.rightButtonBackgroundColor = topBarOptions.rightButtonBackgroundColor;
        }
        if (topBarOptions.leftButtonBackgroundColor.hasValue()) {
            this.rightButtonBackgroundColor = topBarOptions.rightButtonBackgroundColor;
        }
        if (topBarOptions.testId.hasValue()) {
            this.testId = topBarOptions.testId;
        }
        if (topBarOptions.visible.hasValue()) {
            this.visible = topBarOptions.visible;
        }
        if (topBarOptions.animate.hasValue()) {
            this.animate = topBarOptions.animate;
        }
        if (topBarOptions.hideOnScroll.hasValue()) {
            this.hideOnScroll = topBarOptions.hideOnScroll;
        }
        if (topBarOptions.drawBehind.hasValue()) {
            this.drawBehind = topBarOptions.drawBehind;
        }
        if (topBarOptions.height.hasValue()) {
            this.height = topBarOptions.height;
        }
        if (topBarOptions.borderHeight.hasValue()) {
            this.borderHeight = topBarOptions.borderHeight;
        }
        if (topBarOptions.borderColor.hasValue()) {
            this.borderColor = topBarOptions.borderColor;
        }
        if (topBarOptions.elevation.hasValue()) {
            this.elevation = topBarOptions.elevation;
        }
        if (topBarOptions.topMargin.hasValue()) {
            this.topMargin = topBarOptions.topMargin;
        }
        if (topBarOptions.animateLeftButtons.hasValue()) {
            this.animateLeftButtons = topBarOptions.animateLeftButtons;
        }
        if (topBarOptions.animateRightButtons.hasValue()) {
            this.animateRightButtons = topBarOptions.animateRightButtons;
        }
        validate();
    }

    public TopBarOptions mergeWithDefault(TopBarOptions topBarOptions) {
        this.title.mergeWithDefault(topBarOptions.title);
        this.subtitle.mergeWithDefault(topBarOptions.subtitle);
        this.background.mergeWithDefault(topBarOptions.background);
        this.buttons.mergeWithDefault(topBarOptions.buttons);
        if (!this.rightButtonColor.hasValue()) {
            this.rightButtonColor = topBarOptions.rightButtonColor;
        }
        if (!this.leftButtonColor.hasValue()) {
            this.leftButtonColor = topBarOptions.leftButtonColor;
        }
        if (!this.rightButtonDisabledColor.hasValue()) {
            this.rightButtonDisabledColor = topBarOptions.rightButtonDisabledColor;
        }
        if (!this.leftButtonDisabledColor.hasValue()) {
            this.leftButtonDisabledColor = topBarOptions.leftButtonDisabledColor;
        }
        if (!this.rightButtonBackgroundColor.hasValue()) {
            this.rightButtonBackgroundColor = topBarOptions.rightButtonBackgroundColor;
        }
        if (!this.leftButtonBackgroundColor.hasValue()) {
            this.rightButtonBackgroundColor = topBarOptions.rightButtonBackgroundColor;
        }
        if (!this.visible.hasValue()) {
            this.visible = topBarOptions.visible;
        }
        if (!this.animate.hasValue()) {
            this.animate = topBarOptions.animate;
        }
        if (!this.hideOnScroll.hasValue()) {
            this.hideOnScroll = topBarOptions.hideOnScroll;
        }
        if (!this.drawBehind.hasValue()) {
            this.drawBehind = topBarOptions.drawBehind;
        }
        if (!this.testId.hasValue()) {
            this.testId = topBarOptions.testId;
        }
        if (!this.height.hasValue()) {
            this.height = topBarOptions.height;
        }
        if (!this.borderHeight.hasValue()) {
            this.borderHeight = topBarOptions.borderHeight;
        }
        if (!this.borderColor.hasValue()) {
            this.borderColor = topBarOptions.borderColor;
        }
        if (!this.elevation.hasValue()) {
            this.elevation = topBarOptions.elevation;
        }
        if (!this.topMargin.hasValue()) {
            this.topMargin = topBarOptions.topMargin;
        }
        if (!this.animateLeftButtons.hasValue()) {
            this.animateLeftButtons = topBarOptions.animateLeftButtons;
        }
        if (!this.animateRightButtons.hasValue()) {
            this.animateRightButtons = topBarOptions.animateRightButtons;
        }
        validate();
        return this;
    }

    public void validate() {
        if (this.title.component.hasValue()) {
            if (this.title.text.hasValue() || this.subtitle.text.hasValue()) {
                this.title.text = new NullText();
                this.subtitle.text = new NullText();
            }
        }
    }

    public boolean isHiddenOrDrawBehind() {
        return this.drawBehind.isTrue() || this.visible.isFalse();
    }
}
