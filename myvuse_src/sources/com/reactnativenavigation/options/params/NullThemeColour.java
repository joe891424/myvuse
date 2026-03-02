package com.reactnativenavigation.options.params;

import kotlin.Metadata;

/* JADX INFO: compiled from: ThemeColour.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m5598d2 = {"Lcom/reactnativenavigation/options/params/NullThemeColour;", "Lcom/reactnativenavigation/options/params/ThemeColour;", "()V", "hasValue", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class NullThemeColour extends ThemeColour {
    @Override // com.reactnativenavigation.options.params.ThemeColour
    public boolean hasValue() {
        return false;
    }

    public NullThemeColour() {
        super(new NullColor(), new NullColor());
    }
}
