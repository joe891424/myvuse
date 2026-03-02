package com.reactnativenavigation.viewcontrollers.stack.topbar.button;

import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;

/* JADX INFO: loaded from: classes6.dex */
public class BackButtonHelper {
    public void clear(ViewController<?> viewController) {
        if (viewController.options.topBar.buttons.back.hasValue()) {
            return;
        }
        viewController.options.topBar.buttons.back.visible = new Bool(false);
    }

    public void addToPushedChild(ViewController<?> viewController) {
        if (viewController.options.topBar.buttons.left != null || viewController.options.topBar.buttons.back.visible.isFalse()) {
            return;
        }
        Options options = new Options();
        options.topBar.buttons.back.setVisible();
        viewController.mergeOptions(options);
    }
}
