package com.reactnativenavigation.viewcontrollers.sidemenu;

import android.content.res.Resources;
import android.util.TypedValue;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.SideMenuRootOptions;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.sidemenu.SideMenu;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenuPresenter {
    private ViewController<?> left;
    private ViewController<?> right;
    private SideMenu sideMenu;

    public void bindView(SideMenu sideMenu) {
        this.sideMenu = sideMenu;
    }

    public void bindLeft(ViewController<?> viewController) {
        this.left = viewController;
    }

    public void bindRight(ViewController<?> viewController) {
        this.right = viewController;
    }

    public boolean handleBack() {
        if (this.sideMenu.isDrawerOpen(3)) {
            this.sideMenu.closeDrawer(3);
            return true;
        }
        if (!this.sideMenu.isDrawerOpen(5)) {
            return false;
        }
        this.sideMenu.closeDrawer(5);
        return true;
    }

    public void applyOptions(Options options) {
        applyLockMode(options.sideMenuRootOptions);
    }

    public void mergeOptions(SideMenuRootOptions sideMenuRootOptions) {
        mergeLockMode(sideMenuRootOptions);
        mergeVisibility(sideMenuRootOptions);
    }

    public void applyChildOptions(Options options) {
        applyLockMode(options.sideMenuRootOptions);
        mergeVisibility(options.sideMenuRootOptions);
        applyLeftWidth(options.sideMenuRootOptions);
        applyRightWidth(options.sideMenuRootOptions);
    }

    private void applyLockMode(SideMenuRootOptions sideMenuRootOptions) {
        this.sideMenu.setDrawerLockMode(!sideMenuRootOptions.left.enabled.isTrueOrUndefined() ? 1 : 0, 3);
        this.sideMenu.setDrawerLockMode(!sideMenuRootOptions.right.enabled.isTrueOrUndefined() ? 1 : 0, 5);
    }

    private void mergeVisibility(SideMenuRootOptions sideMenuRootOptions) {
        if (sideMenuRootOptions.left.visible.isTrue()) {
            this.sideMenu.openDrawer(3, sideMenuRootOptions.left.animate.get(true).booleanValue());
        } else if (sideMenuRootOptions.left.visible.isFalse()) {
            this.sideMenu.closeDrawer(3, sideMenuRootOptions.left.animate.get(true).booleanValue());
        }
        if (sideMenuRootOptions.right.visible.isTrue()) {
            this.sideMenu.openDrawer(5, sideMenuRootOptions.right.animate.get(true).booleanValue());
        } else if (sideMenuRootOptions.right.visible.isFalse()) {
            this.sideMenu.closeDrawer(5, sideMenuRootOptions.right.animate.get(true).booleanValue());
        }
        sideMenuRootOptions.left.visible.consume();
        sideMenuRootOptions.right.visible.consume();
    }

    private void mergeLockMode(SideMenuRootOptions sideMenuRootOptions) {
        if (sideMenuRootOptions.left.enabled.isFalse()) {
            this.sideMenu.setDrawerLockMode(1, 3);
        } else if (sideMenuRootOptions.left.enabled.isTrue()) {
            this.sideMenu.setDrawerLockMode(0, 3);
        }
        if (sideMenuRootOptions.right.enabled.isFalse()) {
            this.sideMenu.setDrawerLockMode(1, 5);
        } else if (sideMenuRootOptions.right.enabled.isTrue()) {
            this.sideMenu.setDrawerLockMode(0, 5);
        }
    }

    private void applyLeftWidth(SideMenuRootOptions sideMenuRootOptions) {
        if (this.left == null || !sideMenuRootOptions.left.width.hasValue()) {
            return;
        }
        this.left.getView().getLayoutParams().width = (int) TypedValue.applyDimension(1, sideMenuRootOptions.left.width.get().intValue(), Resources.getSystem().getDisplayMetrics());
        this.left.getView().requestLayout();
    }

    private void applyRightWidth(SideMenuRootOptions sideMenuRootOptions) {
        if (this.right == null || !sideMenuRootOptions.right.width.hasValue()) {
            return;
        }
        this.right.getView().getLayoutParams().width = (int) TypedValue.applyDimension(1, sideMenuRootOptions.right.width.get().intValue(), Resources.getSystem().getDisplayMetrics());
        this.right.getView().requestLayout();
    }

    public SideMenu getSideMenu() {
        return this.sideMenu;
    }
}
