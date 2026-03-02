package com.reactnativenavigation.options.params;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactPlatformColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/reactnativenavigation/options/params/ReactPlatformColor;", "Lcom/reactnativenavigation/options/params/Colour;", "paths", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "get", "", "()Ljava/lang/Integer;", "defaultValue", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ReactPlatformColor extends Colour {
    private final ReadableMap paths;

    /* JADX WARN: Illegal instructions before constructor call */
    public ReactPlatformColor(ReadableMap paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        Integer platformColor = ReactPlatformColorKt.parsePlatformColor(paths);
        Intrinsics.checkNotNullExpressionValue(platformColor, "access$parsePlatformColor(...)");
        super(platformColor.intValue());
        this.paths = paths;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.reactnativenavigation.options.params.Param
    public Integer get() {
        Integer platformColor = ReactPlatformColorKt.parsePlatformColor(this.paths);
        Intrinsics.checkNotNullExpressionValue(platformColor, "access$parsePlatformColor(...)");
        return platformColor;
    }

    @Override // com.reactnativenavigation.options.params.Param
    public Integer get(Integer defaultValue) {
        try {
            return ReactPlatformColorKt.parsePlatformColor(this.paths);
        } catch (Exception unused) {
            return defaultValue;
        }
    }
}
