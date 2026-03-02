package com.reactnativenavigation.utils;

/* JADX INFO: loaded from: classes6.dex */
public class StringUtils {
    public static boolean isEqual(String str, String str2) {
        if (str == null || str2 == null) {
            return str == str2;
        }
        return str.equals(str2);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
