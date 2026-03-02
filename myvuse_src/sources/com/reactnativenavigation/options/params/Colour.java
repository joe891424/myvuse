package com.reactnativenavigation.options.params;

import android.graphics.Color;

/* JADX INFO: loaded from: classes6.dex */
public class Colour extends Param<Integer> {
    public Colour(int i) {
        super(Integer.valueOf(i));
    }

    public String toString() {
        return String.format("#%06X", Integer.valueOf(get().intValue() & 16777215));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean hasTransparency() {
        return hasValue() && Color.alpha(((Integer) this.value).intValue()) < 1;
    }
}
