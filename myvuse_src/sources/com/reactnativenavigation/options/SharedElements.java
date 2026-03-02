package com.reactnativenavigation.options;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SharedElements.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/options/SharedElements;", "", "()V", "transitions", "", "Lcom/reactnativenavigation/options/SharedElementTransitionOptions;", "add", "", "transition", "get", "", "hasValue", "", "mergeWith", "other", "mergeWithDefault", "defaultOptions", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class SharedElements {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<SharedElementTransitionOptions> transitions = new ArrayList();

    @JvmStatic
    public static final SharedElements parse(JSONObject jSONObject) {
        return INSTANCE.parse(jSONObject);
    }

    public final List<SharedElementTransitionOptions> get() {
        return this.transitions;
    }

    public final boolean hasValue() {
        return !this.transitions.isEmpty();
    }

    public final void mergeWith(SharedElements other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.hasValue()) {
            this.transitions = other.transitions;
        }
    }

    public final void mergeWithDefault(SharedElements defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (hasValue()) {
            return;
        }
        this.transitions = defaultOptions.transitions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void add(SharedElementTransitionOptions transition) {
        this.transitions.add(transition);
    }

    /* JADX INFO: compiled from: SharedElements.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/SharedElements$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/SharedElements;", "json", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SharedElements parse(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            SharedElements sharedElements = new SharedElements();
            JSONArray jSONArrayOptJSONArray = json.optJSONArray("sharedElementTransitions");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    sharedElements.add(SharedElementTransitionOptions.INSTANCE.parse(jSONArrayOptJSONArray.getJSONObject(i)));
                }
            }
            return sharedElements;
        }
    }
}
