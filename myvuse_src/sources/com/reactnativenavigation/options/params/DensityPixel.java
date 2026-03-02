package com.reactnativenavigation.options.params;

import android.content.res.Resources;
import com.reactnativenavigation.utils.UiUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DensityPixel extends Param<Integer> {
    public DensityPixel(int i) {
        super(Integer.valueOf((int) UiUtils.dpToPx(Resources.getSystem().getDisplayMetrics(), i)));
    }
}
