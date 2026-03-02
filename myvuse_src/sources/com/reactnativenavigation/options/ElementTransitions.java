package com.reactnativenavigation.options;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ElementTransitions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0000R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/options/ElementTransitions;", "", "()V", "transitions", "Ljava/util/ArrayList;", "Lcom/reactnativenavigation/options/ElementTransitionOptions;", "Lkotlin/collections/ArrayList;", "getTransitions", "()Ljava/util/ArrayList;", "setTransitions", "(Ljava/util/ArrayList;)V", "hasValue", "", "mergeWith", "", "other", "mergeWithDefault", "defaultOptions", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ElementTransitions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ArrayList<ElementTransitionOptions> transitions = new ArrayList<>();

    public final ArrayList<ElementTransitionOptions> getTransitions() {
        return this.transitions;
    }

    public final void setTransitions(ArrayList<ElementTransitionOptions> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.transitions = arrayList;
    }

    /* JADX INFO: compiled from: ElementTransitions.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/ElementTransitions$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/ElementTransitions;", "json", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ElementTransitions parse(JSONObject json) throws JSONException {
            Intrinsics.checkNotNullParameter(json, "json");
            ElementTransitions elementTransitions = new ElementTransitions();
            JSONArray jSONArrayOptJSONArray = json.optJSONArray("elementTransitions");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    ArrayList<ElementTransitionOptions> transitions = elementTransitions.getTransitions();
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                    transitions.add(new ElementTransitionOptions(jSONObject));
                }
            }
            return elementTransitions;
        }
    }

    public final void mergeWith(ElementTransitions other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other.hasValue()) {
            this.transitions = other.transitions;
        }
    }

    public final void mergeWithDefault(ElementTransitions defaultOptions) {
        Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        if (hasValue()) {
            return;
        }
        this.transitions = defaultOptions.transitions;
    }

    public final boolean hasValue() {
        return !this.transitions.isEmpty();
    }
}
