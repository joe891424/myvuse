package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.view.View;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;

/* JADX INFO: loaded from: classes6.dex */
public class ViewVisibilityListenerAdapter implements ViewController.ViewVisibilityListener {
    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController.ViewVisibilityListener
    public boolean onViewAppeared(View view) {
        return false;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController.ViewVisibilityListener
    public boolean onViewDisappear(View view) {
        return false;
    }
}
