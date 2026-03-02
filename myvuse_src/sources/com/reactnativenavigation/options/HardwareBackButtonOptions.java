package com.reactnativenavigation.options;

import com.reactnativenavigation.options.HwBackBottomTabsBehaviour;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.options.parsers.BoolParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: HardwareBackButtonOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0000J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/reactnativenavigation/options/HardwareBackButtonOptions;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "bottomTabOnPress", "Lcom/reactnativenavigation/options/HwBackBottomTabsBehaviour;", "getBottomTabOnPress", "()Lcom/reactnativenavigation/options/HwBackBottomTabsBehaviour;", "setBottomTabOnPress", "(Lcom/reactnativenavigation/options/HwBackBottomTabsBehaviour;)V", "dismissModalOnPress", "Lcom/reactnativenavigation/options/params/Bool;", "popStackOnPress", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "parse", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class HardwareBackButtonOptions {
    private HwBackBottomTabsBehaviour bottomTabOnPress;
    public Bool dismissModalOnPress;
    public Bool popStackOnPress;

    /* JADX WARN: Multi-variable type inference failed */
    public HardwareBackButtonOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HardwareBackButtonOptions(JSONObject jSONObject) {
        this.dismissModalOnPress = new NullBool();
        this.popStackOnPress = new NullBool();
        this.bottomTabOnPress = HwBackBottomTabsBehaviour.Undefined.INSTANCE;
        parse(jSONObject);
    }

    public /* synthetic */ HardwareBackButtonOptions(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }

    public final HwBackBottomTabsBehaviour getBottomTabOnPress() {
        return this.bottomTabOnPress;
    }

    public final void setBottomTabOnPress(HwBackBottomTabsBehaviour hwBackBottomTabsBehaviour) {
        Intrinsics.checkNotNullParameter(hwBackBottomTabsBehaviour, "<set-?>");
        this.bottomTabOnPress = hwBackBottomTabsBehaviour;
    }

    public final void mergeWith(HardwareBackButtonOptions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.dismissModalOnPress.hasValue()) {
            this.dismissModalOnPress = other.dismissModalOnPress;
        }
        if (other.popStackOnPress.hasValue()) {
            this.popStackOnPress = other.popStackOnPress;
        }
        if (other.bottomTabOnPress.hasValue()) {
            this.bottomTabOnPress = other.bottomTabOnPress;
        }
    }

    public final void mergeWithDefault(HardwareBackButtonOptions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (!this.dismissModalOnPress.hasValue()) {
            this.dismissModalOnPress = defaultOptions.dismissModalOnPress;
        }
        if (!this.popStackOnPress.hasValue()) {
            this.popStackOnPress = defaultOptions.popStackOnPress;
        }
        if (this.bottomTabOnPress.hasValue()) {
            return;
        }
        this.bottomTabOnPress = defaultOptions.bottomTabOnPress;
    }

    private final void parse(JSONObject json) {
        if (json == null) {
            return;
        }
        Bool bool = BoolParser.parse(json, "dismissModalOnPress");
        Intrinsics.checkNotNullExpressionValue(bool, "parse(...)");
        this.dismissModalOnPress = bool;
        Bool bool2 = BoolParser.parse(json, "popStackOnPress");
        Intrinsics.checkNotNullExpressionValue(bool2, "parse(...)");
        this.popStackOnPress = bool2;
        this.bottomTabOnPress = HwBackBottomTabsBehaviour.INSTANCE.fromString(json.optString("bottomTabsOnPress"));
    }
}
