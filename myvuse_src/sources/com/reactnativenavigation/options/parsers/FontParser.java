package com.reactnativenavigation.options.parsers;

import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.options.FontOptions;
import com.reactnativenavigation.options.params.Text;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: FontParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m5598d2 = {"Lcom/reactnativenavigation/options/parsers/FontParser;", "", "()V", "Companion", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class FontParser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final FontOptions parse(JSONObject jSONObject) {
        return INSTANCE.parse(jSONObject);
    }

    /* JADX INFO: compiled from: FontParser.kt */
    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lcom/reactnativenavigation/options/parsers/FontParser$Companion;", "", "()V", "parse", "Lcom/reactnativenavigation/options/FontOptions;", "title", "Lorg/json/JSONObject;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FontOptions parse(JSONObject title) {
            Intrinsics.checkNotNullParameter(title, "title");
            FontOptions fontOptions = new FontOptions();
            Text text = TextParser.parse(title, ViewProps.FONT_FAMILY);
            Intrinsics.checkNotNullExpressionValue(text, "parse(...)");
            fontOptions.setFontFamily(text);
            Text text2 = TextParser.parse(title, ViewProps.FONT_STYLE);
            Intrinsics.checkNotNullExpressionValue(text2, "parse(...)");
            fontOptions.setFontStyle(text2);
            Text text3 = TextParser.parse(title, ViewProps.FONT_WEIGHT);
            Intrinsics.checkNotNullExpressionValue(text3, "parse(...)");
            fontOptions.setFontWeight(text3);
            return fontOptions;
        }
    }
}
