package com.reactnativenavigation.options;

import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.animations.ViewAnimationOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.parsers.BoolParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: StackAnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0000J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0000J\u0012\u0010 \u001a\u00020\u001c2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m5598d2 = {"Lcom/reactnativenavigation/options/StackAnimationOptions;", "Lcom/reactnativenavigation/options/LayoutAnimation;", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "bottomTabs", "Lcom/reactnativenavigation/options/animations/ViewAnimationOptions;", "content", "elementTransitions", "Lcom/reactnativenavigation/options/ElementTransitions;", "getElementTransitions", "()Lcom/reactnativenavigation/options/ElementTransitions;", "setElementTransitions", "(Lcom/reactnativenavigation/options/ElementTransitions;)V", ViewProps.ENABLED, "Lcom/reactnativenavigation/options/params/Bool;", "sharedElements", "Lcom/reactnativenavigation/options/SharedElements;", "getSharedElements", "()Lcom/reactnativenavigation/options/SharedElements;", "setSharedElements", "(Lcom/reactnativenavigation/options/SharedElements;)V", "topBar", "waitForRender", "hasEnterValue", "", "hasExitValue", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "parse", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class StackAnimationOptions implements LayoutAnimation {
    public ViewAnimationOptions bottomTabs;
    public ViewAnimationOptions content;
    private ElementTransitions elementTransitions;
    public Bool enabled;
    private SharedElements sharedElements;
    public ViewAnimationOptions topBar;
    public Bool waitForRender;

    /* JADX WARN: Multi-variable type inference failed */
    public StackAnimationOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackAnimationOptions(JSONObject jSONObject) {
        this.enabled = new NullBool();
        this.waitForRender = new NullBool();
        int i = 1;
        this.content = new ViewAnimationOptions(null, i, 0 == true ? 1 : 0);
        this.bottomTabs = new ViewAnimationOptions(0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.topBar = new ViewAnimationOptions(0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        this.sharedElements = new SharedElements();
        this.elementTransitions = new ElementTransitions();
        parse(jSONObject);
    }

    public /* synthetic */ StackAnimationOptions(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }

    @Override // com.reactnativenavigation.options.LayoutAnimation
    public SharedElements getSharedElements() {
        return this.sharedElements;
    }

    public void setSharedElements(SharedElements sharedElements) {
        Intrinsics.checkNotNullParameter(sharedElements, "<set-?>");
        this.sharedElements = sharedElements;
    }

    @Override // com.reactnativenavigation.options.LayoutAnimation
    public ElementTransitions getElementTransitions() {
        return this.elementTransitions;
    }

    public void setElementTransitions(ElementTransitions elementTransitions) {
        Intrinsics.checkNotNullParameter(elementTransitions, "<set-?>");
        this.elementTransitions = elementTransitions;
    }

    public final void mergeWith(StackAnimationOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.topBar.mergeWith(other.topBar);
        this.content.mergeWith(other.content);
        this.bottomTabs.mergeWith(other.bottomTabs);
        getSharedElements().mergeWith(other.getSharedElements());
        getElementTransitions().mergeWith(other.getElementTransitions());
        if (other.enabled.hasValue()) {
            this.enabled = other.enabled;
        }
        if (other.waitForRender.hasValue()) {
            this.waitForRender = other.waitForRender;
        }
    }

    public final void mergeWithDefault(StackAnimationOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        this.content.mergeWithDefault(defaultOptions.content);
        this.bottomTabs.mergeWithDefault(defaultOptions.bottomTabs);
        this.topBar.mergeWithDefault(defaultOptions.topBar);
        getSharedElements().mergeWithDefault(defaultOptions.getSharedElements());
        getElementTransitions().mergeWithDefault(defaultOptions.getElementTransitions());
        if (!this.enabled.hasValue()) {
            this.enabled = defaultOptions.enabled;
        }
        if (this.waitForRender.hasValue()) {
            return;
        }
        this.waitForRender = defaultOptions.waitForRender;
    }

    public final boolean hasEnterValue() {
        return this.topBar.enter.hasValue() || this.content.enter.hasValue() || this.bottomTabs.enter.hasValue() || this.waitForRender.hasValue();
    }

    public final boolean hasExitValue() {
        return this.topBar.exit.hasValue() || this.content.exit.hasValue() || this.bottomTabs.exit.hasValue() || this.waitForRender.hasValue();
    }

    private final void parse(JSONObject json) {
        if (json == null) {
            return;
        }
        this.content = new ViewAnimationOptions(json.optJSONObject("content"));
        this.bottomTabs = new ViewAnimationOptions(json.optJSONObject("bottomTabs"));
        this.topBar = new ViewAnimationOptions(json.optJSONObject("topBar"));
        Bool first = BoolParser.parseFirst(json, ViewProps.ENABLED, "enable");
        Intrinsics.checkNotNullExpressionValue(first, "parseFirst(...)");
        this.enabled = first;
        Bool bool = BoolParser.parse(json, "waitForRender");
        Intrinsics.checkNotNullExpressionValue(bool, "parse(...)");
        this.waitForRender = bool;
        setSharedElements(SharedElements.INSTANCE.parse(json));
        setElementTransitions(ElementTransitions.INSTANCE.parse(json));
    }
}
