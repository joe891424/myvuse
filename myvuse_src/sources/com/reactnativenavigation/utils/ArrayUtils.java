package com.reactnativenavigation.utils;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayUtils {
    public static boolean contains(Object[] objArr, Object obj) {
        if (isNullOrEmpty(objArr)) {
            return false;
        }
        for (Object obj2 : objArr) {
            if (obj2 == obj) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
