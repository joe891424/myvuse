package com.reactnativenavigation.utils;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public class ViewTags {
    public static <T> T get(View view, int i) {
        return (T) get(view, i, null);
    }

    public static <T> T get(View view, int i, T t) {
        return view.getTag(i) == null ? t : (T) view.getTag(i);
    }
}
