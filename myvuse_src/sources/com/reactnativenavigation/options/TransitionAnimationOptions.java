package com.reactnativenavigation.options;

import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.params.Bool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransitionAnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001eH\u0007R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, m5598d2 = {"Lcom/reactnativenavigation/options/TransitionAnimationOptions;", "Lcom/reactnativenavigation/options/LayoutAnimation;", "enter", "Lcom/reactnativenavigation/options/AnimationOptions;", "exit", "sharedElements", "Lcom/reactnativenavigation/options/SharedElements;", "elementTransitions", "Lcom/reactnativenavigation/options/ElementTransitions;", "(Lcom/reactnativenavigation/options/AnimationOptions;Lcom/reactnativenavigation/options/AnimationOptions;Lcom/reactnativenavigation/options/SharedElements;Lcom/reactnativenavigation/options/ElementTransitions;)V", "getElementTransitions", "()Lcom/reactnativenavigation/options/ElementTransitions;", "setElementTransitions", "(Lcom/reactnativenavigation/options/ElementTransitions;)V", "getEnter", "()Lcom/reactnativenavigation/options/AnimationOptions;", "getExit", "getSharedElements", "()Lcom/reactnativenavigation/options/SharedElements;", "setSharedElements", "(Lcom/reactnativenavigation/options/SharedElements;)V", "hasElementTransitions", "", "hasValue", "mergeWith", "", "other", "mergeWithDefault", "setWaitForRender", "waitForRender", "Lcom/reactnativenavigation/options/params/Bool;", "toggle", ViewProps.ENABLED, "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class TransitionAnimationOptions implements LayoutAnimation {
    private ElementTransitions elementTransitions;
    private final AnimationOptions enter;
    private final AnimationOptions exit;
    private SharedElements sharedElements;

    public TransitionAnimationOptions() {
        this(null, null, null, null, 15, null);
    }

    public TransitionAnimationOptions(AnimationOptions enter, AnimationOptions exit, SharedElements sharedElements, ElementTransitions elementTransitions) {
        Intrinsics.checkNotNullParameter(enter, "enter");
        Intrinsics.checkNotNullParameter(exit, "exit");
        Intrinsics.checkNotNullParameter(sharedElements, "sharedElements");
        Intrinsics.checkNotNullParameter(elementTransitions, "elementTransitions");
        this.enter = enter;
        this.exit = exit;
        this.sharedElements = sharedElements;
        this.elementTransitions = elementTransitions;
    }

    public /* synthetic */ TransitionAnimationOptions(AnimationOptions animationOptions, AnimationOptions animationOptions2, SharedElements sharedElements, ElementTransitions elementTransitions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AnimationOptions(null, 1, null) : animationOptions, (i & 2) != 0 ? new AnimationOptions(null, 1, null) : animationOptions2, (i & 4) != 0 ? new SharedElements() : sharedElements, (i & 8) != 0 ? new ElementTransitions() : elementTransitions);
    }

    public final AnimationOptions getEnter() {
        return this.enter;
    }

    public final AnimationOptions getExit() {
        return this.exit;
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

    public boolean hasValue() {
        return this.enter.hasValue() || this.exit.hasValue() || getSharedElements().hasValue() || getElementTransitions().hasValue();
    }

    public void mergeWith(TransitionAnimationOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.enter.mergeWith(other.enter);
        this.exit.mergeWith(other.exit);
        getSharedElements().mergeWith(other.getSharedElements());
        getElementTransitions().mergeWith(other.getElementTransitions());
    }

    public void mergeWithDefault(TransitionAnimationOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!this.enter.hasValue()) {
            this.enter.mergeWithDefault(other.enter);
        }
        if (!this.exit.hasValue()) {
            this.exit.mergeWithDefault(other.exit);
        }
        if (!getSharedElements().hasValue()) {
            getSharedElements().mergeWithDefault(other.getSharedElements());
        }
        if (getElementTransitions().hasValue()) {
            return;
        }
        getElementTransitions().mergeWithDefault(other.getElementTransitions());
    }

    public boolean hasElementTransitions() {
        return getSharedElements().hasValue() || getElementTransitions().hasValue();
    }

    public final void setWaitForRender(Bool waitForRender) {
        Intrinsics.checkNotNullParameter(waitForRender, "waitForRender");
        this.enter.waitForRender = waitForRender;
        this.exit.waitForRender = waitForRender;
    }

    public final void toggle(Bool enabled) {
        Intrinsics.checkNotNullParameter(enabled, "enabled");
        this.enter.enabled = enabled;
        this.exit.enabled = enabled;
    }
}
