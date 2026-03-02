package com.reactnativenavigation.options;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnimationsOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/reactnativenavigation/options/AnimationsOptions;", "", "()V", "dismissModal", "Lcom/reactnativenavigation/options/TransitionAnimationOptions;", "pop", "Lcom/reactnativenavigation/options/StackAnimationOptions;", "push", "setRoot", "setStackRoot", "showModal", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class AnimationsOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public StackAnimationOptions push = new StackAnimationOptions(null, 1, null);
    public StackAnimationOptions pop = new StackAnimationOptions(null, 1, null);
    public StackAnimationOptions setStackRoot = new StackAnimationOptions(null, 1, null);
    public TransitionAnimationOptions setRoot = new TransitionAnimationOptions(null, null, null, null, 15, null);
    public TransitionAnimationOptions showModal = new TransitionAnimationOptions(null, null, null, null, 15, null);
    public TransitionAnimationOptions dismissModal = new TransitionAnimationOptions(null, null, null, null, 15, null);

    @JvmStatic
    public static final AnimationsOptions parse(JSONObject jSONObject) {
        return INSTANCE.parse(jSONObject);
    }

    public final void mergeWith(AnimationsOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.push.mergeWith(other.push);
        this.pop.mergeWith(other.pop);
        this.setRoot.mergeWith(other.setRoot);
        this.setStackRoot.mergeWith(other.setStackRoot);
        this.showModal.mergeWith(other.showModal);
        this.dismissModal.mergeWith(other.dismissModal);
    }

    public final void mergeWithDefault(AnimationsOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        this.push.mergeWithDefault(defaultOptions.push);
        this.pop.mergeWithDefault(defaultOptions.pop);
        this.setStackRoot.mergeWithDefault(defaultOptions.setStackRoot);
        this.setRoot.mergeWithDefault(defaultOptions.setRoot);
        this.showModal.mergeWithDefault(defaultOptions.showModal);
        this.dismissModal.mergeWithDefault(defaultOptions.dismissModal);
    }

    /* JADX INFO: compiled from: AnimationsOptions.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/AnimationsOptions$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/AnimationsOptions;", "json", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AnimationsOptions parse(JSONObject json) {
            AnimationsOptions animationsOptions = new AnimationsOptions();
            if (json == null) {
                return animationsOptions;
            }
            animationsOptions.push = new StackAnimationOptions(json.optJSONObject("push"));
            animationsOptions.pop = new StackAnimationOptions(json.optJSONObject("pop"));
            animationsOptions.setStackRoot = new StackAnimationOptions(json.optJSONObject("setStackRoot"));
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("setRoot");
            if (jSONObjectOptJSONObject != null) {
                animationsOptions.setRoot = TransitionAnimationOptionsKt.parseTransitionAnimationOptions(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("showModal");
            if (jSONObjectOptJSONObject2 != null) {
                animationsOptions.showModal = TransitionAnimationOptionsKt.parseTransitionAnimationOptions(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = json.optJSONObject("dismissModal");
            if (jSONObjectOptJSONObject3 != null) {
                animationsOptions.dismissModal = TransitionAnimationOptionsKt.parseTransitionAnimationOptions(jSONObjectOptJSONObject3);
            }
            return animationsOptions;
        }
    }
}
