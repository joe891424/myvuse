package com.reactnativenavigation.options.params;

import android.content.Context;
import com.reactnativenavigation.options.parsers.ColorParser;
import com.reactnativenavigation.utils.ContextKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ThemeColour.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lcom/reactnativenavigation/options/params/ThemeColour;", "", "color", "Lcom/reactnativenavigation/options/params/Colour;", "(Lcom/reactnativenavigation/options/params/Colour;)V", "lightColor", "darkColor", "(Lcom/reactnativenavigation/options/params/Colour;Lcom/reactnativenavigation/options/params/Colour;)V", "canApplyValue", "", "get", "", "defaultColor", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "hasTransparency", "hasValue", "selectedColor", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class ThemeColour {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Colour darkColor;
    private Colour lightColor;

    @JvmStatic
    /* JADX INFO: renamed from: of */
    public static final ThemeColour m2792of(int i) {
        return INSTANCE.m2794of(i);
    }

    @JvmStatic
    /* JADX INFO: renamed from: of */
    public static final ThemeColour m2793of(int i, int i2) {
        return INSTANCE.m2795of(i, i2);
    }

    @JvmStatic
    public static final ThemeColour parse(Context context, JSONObject jSONObject) {
        return INSTANCE.parse(context, jSONObject);
    }

    @JvmStatic
    public static final ThemeColour transparent() {
        return INSTANCE.transparent();
    }

    public ThemeColour(Colour lightColor, Colour darkColor) {
        Intrinsics.checkNotNullParameter(lightColor, "lightColor");
        Intrinsics.checkNotNullParameter(darkColor, "darkColor");
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThemeColour(Colour color) {
        this(color, color);
        Intrinsics.checkNotNullParameter(color, "color");
    }

    private final Colour selectedColor() {
        return ContextKt.isDarkMode() ? this.darkColor : this.lightColor;
    }

    public final Integer get(Integer defaultColor) {
        return selectedColor().get(defaultColor);
    }

    public final int get() {
        Integer num = selectedColor().get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        return num.intValue();
    }

    public boolean hasValue() {
        return selectedColor().hasValue();
    }

    public final boolean hasTransparency() {
        return selectedColor().hasTransparency();
    }

    public final boolean canApplyValue() {
        return selectedColor().canApplyValue();
    }

    /* JADX INFO: compiled from: ThemeColour.kt */
    @Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007¨\u0006\u000f"}, m5598d2 = {"Lcom/reactnativenavigation/options/params/ThemeColour$Companion;", "", "()V", "of", "Lcom/reactnativenavigation/options/params/ThemeColour;", "color", "", "light", "dark", "parse", "context", "Landroid/content/Context;", "json", "Lorg/json/JSONObject;", "transparent", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        /* JADX INFO: renamed from: of */
        public final ThemeColour m2794of(int color) {
            return new ThemeColour(new Colour(color), new Colour(color));
        }

        @JvmStatic
        /* JADX INFO: renamed from: of */
        public final ThemeColour m2795of(int light, int dark) {
            return new ThemeColour(new Colour(light), new Colour(dark));
        }

        @JvmStatic
        public final ThemeColour parse(Context context, JSONObject json) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (json != null) {
                return new ThemeColour(ColorParser.parse(context, json, "light"), ColorParser.parse(context, json, "dark"));
            }
            return new NullThemeColour();
        }

        @JvmStatic
        public final ThemeColour transparent() {
            return m2794of(0);
        }
    }
}
