package com.reactnativenavigation.viewcontrollers.component;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes6.dex */
public class ComponentPresenterBase {
    public void applyTopInsets(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null || marginLayoutParams.topMargin == i) {
            return;
        }
        marginLayoutParams.topMargin = i;
        view.requestLayout();
    }

    public void applyBottomInset(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null || marginLayoutParams.bottomMargin == i) {
            return;
        }
        marginLayoutParams.bottomMargin = i;
        view.requestLayout();
    }
}
