package com.reactnativenavigation.utils;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class CompatUtils {
    private static final AtomicInteger viewId = new AtomicInteger(1);

    public static int generateViewId() {
        return View.generateViewId();
    }
}
