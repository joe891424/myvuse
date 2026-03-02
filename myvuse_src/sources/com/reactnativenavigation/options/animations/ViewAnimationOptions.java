package com.reactnativenavigation.options.animations;

import com.reactnativenavigation.options.AnimationOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ViewAnimationOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0000J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/reactnativenavigation/options/animations/ViewAnimationOptions;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "enter", "Lcom/reactnativenavigation/options/AnimationOptions;", "exit", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "parse", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ViewAnimationOptions {
    public AnimationOptions enter;
    public AnimationOptions exit;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewAnimationOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewAnimationOptions(JSONObject jSONObject) {
        int i = 1;
        this.enter = new AnimationOptions(null, i, 0 == true ? 1 : 0);
        this.exit = new AnimationOptions(0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        if (jSONObject != null) {
            parse(jSONObject);
        }
    }

    public /* synthetic */ ViewAnimationOptions(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }

    public final void mergeWith(ViewAnimationOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.enter.mergeWith(other.enter);
        this.exit.mergeWith(other.exit);
    }

    public final void mergeWithDefault(ViewAnimationOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        this.enter.mergeWithDefault(defaultOptions.enter);
        this.exit.mergeWithDefault(defaultOptions.exit);
    }

    private final void parse(JSONObject json) {
        if (json != null) {
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("enter");
            if (jSONObjectOptJSONObject != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                this.enter = new AnimationOptions(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("exit");
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
                this.exit = new AnimationOptions(jSONObjectOptJSONObject2);
            }
        }
    }
}
