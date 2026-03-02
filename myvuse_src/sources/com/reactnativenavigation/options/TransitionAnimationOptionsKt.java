package com.reactnativenavigation.options;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: TransitionAnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, m5598d2 = {"parseTransitionAnimationOptions", "Lcom/reactnativenavigation/options/TransitionAnimationOptions;", "jsonObject", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TransitionAnimationOptionsKt {
    public static final TransitionAnimationOptions parseTransitionAnimationOptions(JSONObject jSONObject) {
        if (jSONObject != null) {
            TransitionAnimationOptions transitionAnimationOptions = new TransitionAnimationOptions(new AnimationOptions(jSONObject.optJSONObject("enter")), new AnimationOptions(jSONObject.optJSONObject("exit")), null, null, 12, null);
            if (jSONObject.has("sharedElementTransitions")) {
                transitionAnimationOptions.setSharedElements(SharedElements.INSTANCE.parse(jSONObject));
            }
            if (!jSONObject.has("elementTransitions")) {
                return transitionAnimationOptions;
            }
            transitionAnimationOptions.setElementTransitions(ElementTransitions.INSTANCE.parse(jSONObject));
            return transitionAnimationOptions;
        }
        return new TransitionAnimationOptions(null, null, null, null, 15, null);
    }
}
