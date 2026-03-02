package com.reactnativenavigation.views.element;

import android.animation.Animator;
import android.view.View;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import kotlin.Metadata;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/Transition;", "", "()V", "topInset", "", "getTopInset", "()I", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewController", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "getViewController", "()Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "setViewController", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;)V", "createAnimators", "Landroid/animation/Animator;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public abstract class Transition {
    public abstract Animator createAnimators();

    public abstract int getTopInset();

    public abstract View getView();

    public abstract ViewController<?> getViewController();

    public abstract void setViewController(ViewController<?> viewController);
}
