package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes6.dex */
public interface IReactView extends Destroyable {
    ViewGroup asView();

    void dispatchTouchEventToJs(MotionEvent motionEvent);

    ScrollEventListener getScrollEventListener();

    boolean isReady();

    boolean isRendered();

    void sendOnNavigationButtonPressed(String str);
}
