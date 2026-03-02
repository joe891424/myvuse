package com.reactnativenavigation.options;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: FadeAnimation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/reactnativenavigation/options/FadeAnimation;", "Lcom/reactnativenavigation/options/StackAnimationOptions;", "()V", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class FadeAnimation extends StackAnimationOptions {
    public static final FadeAnimation INSTANCE;

    private FadeAnimation() {
        super(null, 1, null);
    }

    static {
        FadeAnimation fadeAnimation = new FadeAnimation();
        INSTANCE = fadeAnimation;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("from", 0);
        jSONObject.put(TypedValues.TransitionType.S_TO, 1);
        jSONObject.put("duration", 300);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("alpha", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("from", 1);
        jSONObject3.put(TypedValues.TransitionType.S_TO, 0);
        jSONObject3.put("duration", 300);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("alpha", jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("enter", jSONObject2);
        jSONObject5.put("exit", jSONObject4);
        JSONObject jSONObject6 = new JSONObject();
        jSONObject6.put("content", jSONObject5);
        fadeAnimation.mergeWith(new StackAnimationOptions(jSONObject6));
    }
}
