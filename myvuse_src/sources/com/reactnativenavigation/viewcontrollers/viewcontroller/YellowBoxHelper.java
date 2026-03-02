package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes6.dex */
public class YellowBoxHelper {
    boolean isYellowBox(View view, View view2) {
        return (view instanceof ViewGroup) && (view2 instanceof ViewGroup) && ((ViewGroup) view).indexOfChild(view2) >= 1;
    }
}
