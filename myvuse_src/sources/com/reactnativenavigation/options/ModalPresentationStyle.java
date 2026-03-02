package com.reactnativenavigation.options;

import com.google.firebase.ktx.BuildConfig;

/* JADX INFO: loaded from: classes6.dex */
public enum ModalPresentationStyle {
    Unspecified(BuildConfig.VERSION_NAME),
    None("none"),
    OverCurrentContext("overCurrentContext");

    public String name;

    ModalPresentationStyle(String str) {
        this.name = str;
    }

    public static ModalPresentationStyle fromString(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return None;
        }
        if (str.equals("overCurrentContext")) {
            return OverCurrentContext;
        }
        return Unspecified;
    }
}
