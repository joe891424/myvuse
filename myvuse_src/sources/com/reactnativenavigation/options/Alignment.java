package com.reactnativenavigation.options;

import com.surajit.rnrg.RadialGradientManager;

/* JADX INFO: loaded from: classes6.dex */
public enum Alignment {
    Center,
    Fill,
    Default;

    public static Alignment fromString(String str) {
        str.hashCode();
        if (str.equals(RadialGradientManager.PROP_CENTER)) {
            return Center;
        }
        if (str.equals("fill")) {
            return Fill;
        }
        return Default;
    }
}
