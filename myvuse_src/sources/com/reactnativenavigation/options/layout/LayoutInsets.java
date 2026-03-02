package com.reactnativenavigation.options.layout;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.reactnativenavigation.utils.PrimitiveExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: compiled from: LayoutInsets.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001a"}, m5598d2 = {"Lcom/reactnativenavigation/options/layout/LayoutInsets;", "", ViewProps.TOP, "", ViewProps.LEFT, ViewProps.BOTTOM, ViewProps.RIGHT, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBottom", "()Ljava/lang/Integer;", "setBottom", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "hasValue", "", "merge", "", "toMerge", RemoteConfigComponent.DEFAULTS_FILE_NAME, "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class LayoutInsets {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Integer bottom;
    private Integer left;
    private Integer right;
    private Integer top;

    public LayoutInsets() {
        this(null, null, null, null, 15, null);
    }

    public LayoutInsets(Integer num, Integer num2, Integer num3, Integer num4) {
        this.top = num;
        this.left = num2;
        this.bottom = num3;
        this.right = num4;
    }

    public /* synthetic */ LayoutInsets(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    public final Integer getTop() {
        return this.top;
    }

    public final void setTop(Integer num) {
        this.top = num;
    }

    public final Integer getLeft() {
        return this.left;
    }

    public final void setLeft(Integer num) {
        this.left = num;
    }

    public final Integer getBottom() {
        return this.bottom;
    }

    public final void setBottom(Integer num) {
        this.bottom = num;
    }

    public final Integer getRight() {
        return this.right;
    }

    public final void setRight(Integer num) {
        this.right = num;
    }

    public final void merge(LayoutInsets toMerge, LayoutInsets defaults) {
        if (toMerge != null) {
            Integer num = toMerge.top;
            if (num != null) {
                this.top = Integer.valueOf(num.intValue());
            }
            Integer num2 = toMerge.bottom;
            if (num2 != null) {
                this.bottom = Integer.valueOf(num2.intValue());
            }
            Integer num3 = toMerge.left;
            if (num3 != null) {
                this.left = Integer.valueOf(num3.intValue());
            }
            Integer num4 = toMerge.right;
            if (num4 != null) {
                this.right = Integer.valueOf(num4.intValue());
            }
        }
        if (defaults != null) {
            Integer num5 = this.top;
            if (num5 == null) {
                num5 = defaults.top;
            }
            this.top = num5;
            Integer num6 = this.left;
            if (num6 == null) {
                num6 = defaults.left;
            }
            this.left = num6;
            Integer num7 = this.right;
            if (num7 == null) {
                num7 = defaults.right;
            }
            this.right = num7;
            Integer num8 = this.bottom;
            if (num8 == null) {
                num8 = defaults.bottom;
            }
            this.bottom = num8;
        }
    }

    /* JADX INFO: compiled from: LayoutInsets.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/layout/LayoutInsets$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/layout/LayoutInsets;", "jsonObject", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LayoutInsets parse(JSONObject jsonObject) {
            return new LayoutInsets(jsonObject != null ? Integer.valueOf(PrimitiveExtKt.getDp(jsonObject.optInt(ViewProps.TOP))) : null, jsonObject != null ? Integer.valueOf(PrimitiveExtKt.getDp(jsonObject.optInt(ViewProps.LEFT))) : null, jsonObject != null ? Integer.valueOf(PrimitiveExtKt.getDp(jsonObject.optInt(ViewProps.BOTTOM))) : null, jsonObject != null ? Integer.valueOf(PrimitiveExtKt.getDp(jsonObject.optInt(ViewProps.RIGHT))) : null);
        }
    }

    public final boolean hasValue() {
        return (this.top == null && this.bottom == null && this.left == null && this.right == null) ? false : true;
    }
}
