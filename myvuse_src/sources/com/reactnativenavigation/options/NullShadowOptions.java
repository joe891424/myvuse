package com.reactnativenavigation.options;

import kotlin.Metadata;

/* JADX INFO: compiled from: ShadowOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m5598d2 = {"Lcom/reactnativenavigation/options/NullShadowOptions;", "Lcom/reactnativenavigation/options/ShadowOptions;", "()V", "hasValue", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NullShadowOptions extends ShadowOptions {
    public static final NullShadowOptions INSTANCE = new NullShadowOptions();

    @Override // com.reactnativenavigation.options.ShadowOptions
    public boolean hasValue() {
        return false;
    }

    private NullShadowOptions() {
        super(null, null, null, 7, null);
    }
}
