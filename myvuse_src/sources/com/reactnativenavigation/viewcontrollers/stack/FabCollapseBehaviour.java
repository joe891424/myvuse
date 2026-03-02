package com.reactnativenavigation.viewcontrollers.stack;

import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;

/* JADX INFO: loaded from: classes6.dex */
public class FabCollapseBehaviour implements ScrollEventListener.OnScrollListener, ScrollEventListener.OnDragListener {
    private FabAnimator fabAnimator;
    private ScrollEventListener scrollEventListener;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnScrollListener
    public void onScrollDown(float f) {
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnScrollListener
    public void onScrollUp(float f) {
    }

    public FabCollapseBehaviour(FabAnimator fabAnimator) {
        this.fabAnimator = fabAnimator;
    }

    public void enableCollapse(ScrollEventListener scrollEventListener) {
        this.scrollEventListener = scrollEventListener;
        scrollEventListener.register(null, this, this);
    }

    public void disableCollapse() {
        ScrollEventListener scrollEventListener = this.scrollEventListener;
        if (scrollEventListener != null) {
            scrollEventListener.unregister();
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnDragListener
    public void onShow() {
        this.fabAnimator.show();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnDragListener
    public void onHide() {
        this.fabAnimator.hide();
    }
}
