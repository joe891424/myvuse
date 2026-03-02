package com.reactnativenavigation.options.params;

import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.reactnativenavigation.NavigationApplication;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactPlatformColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"parsePlatformColor", "", "kotlin.jvm.PlatformType", "paths", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)Ljava/lang/Integer;", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactPlatformColorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer parsePlatformColor(ReadableMap readableMap) {
        return ColorPropConverter.getColor(readableMap, NavigationApplication.instance);
    }
}
