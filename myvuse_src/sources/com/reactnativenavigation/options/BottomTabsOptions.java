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
import com.reactnativenavigation.options.params.TitleDisplayMode;
import com.reactnativenavigation.options.parsers.BoolParser;
import com.reactnativenavigation.options.parsers.FractionParser;
import com.reactnativenavigation.options.parsers.NumberParser;
import com.reactnativenavigation.options.parsers.TextParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabsOptions {
    public ThemeColour backgroundColor = new NullThemeColour();
    public Bool hideOnScroll = new NullBool();
    public Bool visible = new NullBool();
    public Bool drawBehind = new NullBool();
    public Bool animate = new NullBool();
    public Bool animateTabSelection = new NullBool();
    public Bool preferLargeIcons = new NullBool();
    public Number currentTabIndex = new NullNumber();
    public Fraction elevation = new NullFraction();
    public Text currentTabId = new NullText();
    public Text testId = new NullText();
    public TitleDisplayMode titleDisplayMode = TitleDisplayMode.UNDEFINED;
    public TabsAttachMode tabsAttachMode = TabsAttachMode.UNDEFINED;
    public ThemeColour borderColor = new NullThemeColour();
    public Fraction borderWidth = new NullFraction();
    public ShadowOptions shadowOptions = NullShadowOptions.INSTANCE;

    public static BottomTabsOptions parse(Context context, JSONObject jSONObject) {
        BottomTabsOptions bottomTabsOptions = new BottomTabsOptions();
        if (jSONObject == null) {
            return bottomTabsOptions;
        }
        bottomTabsOptions.backgroundColor = ThemeColour.parse(context, jSONObject.optJSONObject("backgroundColor"));
        bottomTabsOptions.currentTabId = TextParser.parse(jSONObject, "currentTabId");
        bottomTabsOptions.currentTabIndex = NumberParser.parse(jSONObject, "currentTabIndex");
        bottomTabsOptions.hideOnScroll = BoolParser.parse(jSONObject, "hideOnScroll");
        bottomTabsOptions.visible = BoolParser.parse(jSONObject, ViewProps.VISIBLE);
        bottomTabsOptions.drawBehind = BoolParser.parse(jSONObject, "drawBehind");
        bottomTabsOptions.preferLargeIcons = BoolParser.parse(jSONObject, "preferLargeIcons");
        bottomTabsOptions.animate = BoolParser.parse(jSONObject, "animate");
        bottomTabsOptions.animateTabSelection = BoolParser.parse(jSONObject, "animateTabSelection");
        bottomTabsOptions.elevation = FractionParser.parse(jSONObject, "elevation");
        bottomTabsOptions.testId = TextParser.parse(jSONObject, ViewProps.TEST_ID);
        bottomTabsOptions.titleDisplayMode = TitleDisplayMode.fromString(jSONObject.optString("titleDisplayMode"));
        bottomTabsOptions.tabsAttachMode = TabsAttachMode.fromString(jSONObject.optString("tabsAttachMode"));
        bottomTabsOptions.borderColor = ThemeColour.parse(context, jSONObject.optJSONObject("borderColor"));
        bottomTabsOptions.borderWidth = FractionParser.parse(jSONObject, "borderWidth");
        bottomTabsOptions.shadowOptions = ShadowOptionsKt.parseShadowOptions(context, jSONObject.optJSONObject("shadow"));
        return bottomTabsOptions;
    }

    void mergeWith(BottomTabsOptions bottomTabsOptions) {
        if (bottomTabsOptions.currentTabId.hasValue()) {
            this.currentTabId = bottomTabsOptions.currentTabId;
        }
        if (bottomTabsOptions.currentTabIndex.hasValue()) {
            this.currentTabIndex = bottomTabsOptions.currentTabIndex;
        }
        if (bottomTabsOptions.hideOnScroll.hasValue()) {
            this.hideOnScroll = bottomTabsOptions.hideOnScroll;
        }
        if (bottomTabsOptions.visible.hasValue()) {
            this.visible = bottomTabsOptions.visible;
        }
        if (bottomTabsOptions.drawBehind.hasValue()) {
            this.drawBehind = bottomTabsOptions.drawBehind;
        }
        if (bottomTabsOptions.animate.hasValue()) {
            this.animate = bottomTabsOptions.animate;
        }
        if (bottomTabsOptions.animateTabSelection.hasValue()) {
            this.animateTabSelection = bottomTabsOptions.animateTabSelection;
        }
        if (bottomTabsOptions.preferLargeIcons.hasValue()) {
            this.preferLargeIcons = bottomTabsOptions.preferLargeIcons;
        }
        if (bottomTabsOptions.elevation.hasValue()) {
            this.elevation = bottomTabsOptions.elevation;
        }
        if (bottomTabsOptions.testId.hasValue()) {
            this.testId = bottomTabsOptions.testId;
        }
        if (bottomTabsOptions.titleDisplayMode.hasValue()) {
            this.titleDisplayMode = bottomTabsOptions.titleDisplayMode;
        }
        if (bottomTabsOptions.tabsAttachMode.hasValue()) {
            this.tabsAttachMode = bottomTabsOptions.tabsAttachMode;
        }
        if (bottomTabsOptions.borderWidth.hasValue()) {
            this.borderWidth = bottomTabsOptions.borderWidth;
        }
        if (bottomTabsOptions.shadowOptions.hasValue()) {
            this.shadowOptions = this.shadowOptions.copy().mergeWith(bottomTabsOptions.shadowOptions);
        }
        if (bottomTabsOptions.borderColor.hasValue()) {
            this.borderColor = bottomTabsOptions.borderColor;
        }
        if (bottomTabsOptions.backgroundColor.hasValue()) {
            this.backgroundColor = bottomTabsOptions.backgroundColor;
        }
    }

    void mergeWithDefault(BottomTabsOptions bottomTabsOptions) {
        if (!this.borderColor.hasValue()) {
            this.borderColor = bottomTabsOptions.borderColor;
        }
        if (!this.backgroundColor.hasValue()) {
            this.backgroundColor = bottomTabsOptions.backgroundColor;
        }
        if (!this.currentTabId.hasValue()) {
            this.currentTabId = bottomTabsOptions.currentTabId;
        }
        if (!this.currentTabIndex.hasValue()) {
            this.currentTabIndex = bottomTabsOptions.currentTabIndex;
        }
        if (!this.hideOnScroll.hasValue()) {
            this.hideOnScroll = bottomTabsOptions.hideOnScroll;
        }
        if (!this.visible.hasValue()) {
            this.visible = bottomTabsOptions.visible;
        }
        if (!this.drawBehind.hasValue()) {
            this.drawBehind = bottomTabsOptions.drawBehind;
        }
        if (!this.animate.hasValue()) {
            this.animate = bottomTabsOptions.animate;
        }
        if (!this.animateTabSelection.hasValue()) {
            this.animateTabSelection = bottomTabsOptions.animateTabSelection;
        }
        if (!this.preferLargeIcons.hasValue()) {
            this.preferLargeIcons = bottomTabsOptions.preferLargeIcons;
        }
        if (!this.elevation.hasValue()) {
            this.elevation = bottomTabsOptions.elevation;
        }
        if (!this.titleDisplayMode.hasValue()) {
            this.titleDisplayMode = bottomTabsOptions.titleDisplayMode;
        }
        if (!this.tabsAttachMode.hasValue()) {
            this.tabsAttachMode = bottomTabsOptions.tabsAttachMode;
        }
        if (!this.borderWidth.hasValue()) {
            this.borderWidth = bottomTabsOptions.borderWidth;
        }
        if (this.shadowOptions.hasValue()) {
            return;
        }
        this.shadowOptions = this.shadowOptions.copy().mergeWithDefaults(bottomTabsOptions.shadowOptions);
    }

    public boolean isHiddenOrDrawBehind() {
        return this.visible.isFalse() || this.drawBehind.isTrue();
    }

    public void clearOneTimeOptions() {
        this.currentTabId = new NullText();
        this.currentTabIndex = new NullNumber();
    }
}
