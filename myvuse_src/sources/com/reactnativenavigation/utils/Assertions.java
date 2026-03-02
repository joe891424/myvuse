package com.reactnativenavigation.utils;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class Assertions {
    public static void assertNotNull(@Nullable Object obj) {
        if (obj == null) {
            throw new AssertionError();
        }
    }
}
