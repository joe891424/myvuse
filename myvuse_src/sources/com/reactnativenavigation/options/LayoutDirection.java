package com.reactnativenavigation.options;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public enum LayoutDirection {
    RTL(1),
    LTR(0),
    LOCALE(3),
    DEFAULT(0);

    private final int direction;

    LayoutDirection(int i) {
        this.direction = i;
    }

    public static LayoutDirection fromString(String str) {
        str.hashCode();
        switch (str) {
            case "locale":
                return LOCALE;
            case "ltr":
                return LTR;
            case "rtl":
                return RTL;
            default:
                return DEFAULT;
        }
    }

    public boolean hasValue() {
        return this != DEFAULT;
    }

    public int get() {
        return this.direction;
    }

    public int inverse() {
        return (isRtl() ? LTR : RTL).direction;
    }

    public boolean isRtl() {
        int i = this.direction;
        if (i != 1) {
            return i == 3 && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
        return true;
    }
}
