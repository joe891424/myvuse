package com.reactnativenavigation.viewcontrollers.stack;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativenavigation.C3967R;
import com.reactnativenavigation.options.FabOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.stack.fab.Fab;
import com.reactnativenavigation.views.stack.fab.FabMenu;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class FabPresenter {
    private static final int DURATION = 200;
    private Fab fab;
    private FabMenu fabMenu;
    private ViewGroup viewGroup;

    public void applyOptions(final FabOptions fabOptions, final ViewController<?> viewController, ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        if (fabOptions.f4201id.hasValue()) {
            FabMenu fabMenu = this.fabMenu;
            if (fabMenu != null && fabMenu.getFabId().equals(fabOptions.f4201id.get())) {
                this.fabMenu.bringToFront();
                applyFabMenuOptions(viewController, this.fabMenu, fabOptions);
                setParams(viewController, this.fabMenu, fabOptions);
                return;
            }
            Fab fab = this.fab;
            if (fab != null && fab.getFabId().equals(fabOptions.f4201id.get())) {
                this.fab.bringToFront();
                setParams(viewController, this.fab, fabOptions);
                applyFabOptions(viewController, this.fab, fabOptions);
                this.fab.setOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        viewController.sendOnNavigationButtonPressed(fabOptions.f4201id.get());
                    }
                });
                return;
            }
            createFab(viewController, fabOptions);
            return;
        }
        removeFab();
        removeFabMenu();
    }

    public void mergeOptions(final FabOptions fabOptions, final ViewController<?> viewController, ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
        if (fabOptions.f4201id.hasValue()) {
            FabMenu fabMenu = this.fabMenu;
            if (fabMenu != null && fabMenu.getFabId().equals(fabOptions.f4201id.get())) {
                mergeParams(this.fabMenu, fabOptions);
                this.fabMenu.bringToFront();
                mergeFabMenuOptions(viewController, this.fabMenu, fabOptions);
                return;
            }
            Fab fab = this.fab;
            if (fab != null && fab.getFabId().equals(fabOptions.f4201id.get())) {
                mergeParams(this.fab, fabOptions);
                this.fab.bringToFront();
                mergeFabOptions(viewController, this.fab, fabOptions);
                this.fab.setOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        viewController.sendOnNavigationButtonPressed(fabOptions.f4201id.get());
                    }
                });
                return;
            }
            createFab(viewController, fabOptions);
        }
    }

    private void createFab(final ViewController<?> viewController, final FabOptions fabOptions) {
        ViewExtensionsKt.removeFromParent(this.fabMenu);
        ViewExtensionsKt.removeFromParent(this.fab);
        if (fabOptions.actionsArray.size() > 0) {
            FabMenu fabMenu = new FabMenu(this.viewGroup.getContext(), fabOptions.f4201id.get());
            this.fabMenu = fabMenu;
            setParams(viewController, fabMenu, fabOptions);
            applyFabMenuOptions(viewController, this.fabMenu, fabOptions);
            this.viewGroup.addView(this.fabMenu);
            return;
        }
        Fab fab = new Fab(this.viewGroup.getContext(), fabOptions.f4201id.get());
        this.fab = fab;
        setParams(viewController, fab, fabOptions);
        applyFabOptions(viewController, this.fab, fabOptions);
        this.viewGroup.addView(this.fab);
        this.fab.setOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                viewController.sendOnNavigationButtonPressed(fabOptions.f4201id.get());
            }
        });
        UiUtils.doOnLayout(this.fab, new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createFab$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createFab$3() {
        this.fab.setPivotX(r0.getWidth() / 2.0f);
        this.fab.setPivotY(r0.getHeight() / 2.0f);
    }

    private void removeFabMenu() {
        FabMenu fabMenu = this.fabMenu;
        if (fabMenu != null) {
            fabMenu.hideMenuButton(true);
            this.viewGroup.removeView(this.fabMenu);
            this.fabMenu = null;
        }
    }

    private void removeFab() {
        if (this.fab != null) {
            animateHide(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$removeFab$4();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeFab$4() {
        this.viewGroup.removeView(this.fab);
        this.fab = null;
    }

    public void animateHide(final Runnable runnable) {
        this.fab.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                runnable.run();
            }
        });
    }

    private void setParams(ViewController<?> viewController, View view, FabOptions fabOptions) {
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = (int) this.viewGroup.getContext().getResources().getDimension(C3967R.dimen.margin);
        layoutParams.leftMargin = (int) this.viewGroup.getContext().getResources().getDimension(C3967R.dimen.margin);
        layoutParams.bottomMargin = viewController.getBottomInset() + ((int) this.viewGroup.getContext().getResources().getDimension(C3967R.dimen.margin));
        view.setTag(C3967R.id.fab_bottom_margin, Integer.valueOf((int) this.viewGroup.getContext().getResources().getDimension(C3967R.dimen.margin)));
        layoutParams.gravity = 80;
        if (fabOptions.alignHorizontally.hasValue()) {
            if (ViewProps.RIGHT.equals(fabOptions.alignHorizontally.get())) {
                layoutParams.gravity |= 5;
            }
            if (ViewProps.LEFT.equals(fabOptions.alignHorizontally.get())) {
                layoutParams.gravity |= 3;
            }
        } else {
            layoutParams.gravity |= 5;
        }
        view.setLayoutParams(layoutParams);
    }

    private void mergeParams(View view, FabOptions fabOptions) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) ObjectUtils.perform(view, new CoordinatorLayout.LayoutParams(-2, -2), new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((View) obj).getLayoutParams();
            }
        });
        view.setTag(C3967R.id.fab_bottom_margin, Integer.valueOf(layoutParams.leftMargin));
        layoutParams.gravity = 80;
        if (fabOptions.alignHorizontally.hasValue()) {
            if (ViewProps.RIGHT.equals(fabOptions.alignHorizontally.get())) {
                layoutParams.gravity |= 5;
            }
            if (ViewProps.LEFT.equals(fabOptions.alignHorizontally.get())) {
                layoutParams.gravity |= 5;
            }
        } else {
            layoutParams.gravity |= 5;
        }
        view.setLayoutParams(layoutParams);
    }

    private void applyFabOptions(ViewController<?> viewController, Fab fab, FabOptions fabOptions) {
        if (fabOptions.visible.isTrueOrUndefined()) {
            fab.setScaleX(0.6f);
            fab.setScaleY(0.6f);
            fab.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        }
        if (fabOptions.visible.isFalse()) {
            fab.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).start();
        }
        if (fabOptions.backgroundColor.hasValue()) {
            fab.setColorNormal(fabOptions.backgroundColor.get());
        }
        if (fabOptions.clickColor.hasValue()) {
            fab.setColorPressed(fabOptions.clickColor.get());
        }
        if (fabOptions.rippleColor.hasValue()) {
            fab.setColorRipple(fabOptions.rippleColor.get());
        }
        if (fabOptions.icon.hasValue()) {
            fab.applyIcon(fabOptions.icon.get(), fabOptions.iconColor);
        }
        if (fabOptions.size.hasValue()) {
            fab.setButtonSize("mini".equals(fabOptions.size.get()) ? 1 : 0);
        }
        if (fabOptions.hideOnScroll.isTrue()) {
            fab.enableCollapse(viewController.getScrollEventListener());
        }
        if (fabOptions.hideOnScroll.isFalseOrUndefined()) {
            fab.disableCollapse();
        }
    }

    private void mergeFabOptions(ViewController<?> viewController, Fab fab, FabOptions fabOptions) {
        if (fabOptions.visible.isTrue()) {
            fab.show(true);
        }
        if (fabOptions.visible.isFalse()) {
            fab.hide(true);
        }
        if (fabOptions.backgroundColor.hasValue()) {
            fab.setColorNormal(fabOptions.backgroundColor.get());
        }
        if (fabOptions.clickColor.hasValue()) {
            fab.setColorPressed(fabOptions.clickColor.get());
        }
        if (fabOptions.rippleColor.hasValue()) {
            fab.setColorRipple(fabOptions.rippleColor.get());
        }
        if (fabOptions.icon.hasValue()) {
            fab.applyIcon(fabOptions.icon.get(), fabOptions.iconColor);
        }
        if (fabOptions.size.hasValue()) {
            fab.setButtonSize("mini".equals(fabOptions.size.get()) ? 1 : 0);
        }
        if (fabOptions.hideOnScroll.isTrue()) {
            fab.enableCollapse(viewController.getScrollEventListener());
        }
        if (fabOptions.hideOnScroll.isFalse()) {
            fab.disableCollapse();
        }
    }

    private void applyFabMenuOptions(final ViewController<?> viewController, FabMenu fabMenu, final FabOptions fabOptions) {
        if (fabOptions.visible.isTrueOrUndefined()) {
            fabMenu.showMenuButton(true);
        }
        if (fabOptions.visible.isFalse()) {
            fabMenu.hideMenuButton(true);
        }
        if (fabOptions.backgroundColor.hasValue()) {
            fabMenu.setMenuButtonColorNormal(fabOptions.backgroundColor.get());
        }
        if (fabOptions.clickColor.hasValue()) {
            fabMenu.setMenuButtonColorPressed(fabOptions.clickColor.get());
        }
        if (fabOptions.rippleColor.hasValue()) {
            fabMenu.setMenuButtonColorRipple(fabOptions.rippleColor.get());
        }
        Iterator<Fab> it2 = fabMenu.getActions().iterator();
        while (it2.hasNext()) {
            fabMenu.removeMenuButton(it2.next());
        }
        fabMenu.getActions().clear();
        for (FabOptions fabOptions2 : fabOptions.actionsArray) {
            Fab fab = new Fab(this.viewGroup.getContext(), fabOptions2.f4201id.get());
            applyFabOptions(viewController, fab, fabOptions2);
            fab.setOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    viewController.sendOnNavigationButtonPressed(fabOptions.f4201id.get());
                }
            });
            fabMenu.getActions().add(fab);
            fabMenu.addMenuButton(fab);
        }
        if (fabOptions.hideOnScroll.isTrue()) {
            fabMenu.enableCollapse(viewController.getScrollEventListener());
        }
        if (fabOptions.hideOnScroll.isFalseOrUndefined()) {
            fabMenu.disableCollapse();
        }
    }

    private void mergeFabMenuOptions(final ViewController<?> viewController, FabMenu fabMenu, final FabOptions fabOptions) {
        if (fabOptions.visible.isTrue()) {
            fabMenu.showMenuButton(true);
        }
        if (fabOptions.visible.isFalse()) {
            fabMenu.hideMenuButton(true);
        }
        if (fabOptions.backgroundColor.hasValue()) {
            fabMenu.setMenuButtonColorNormal(fabOptions.backgroundColor.get());
        }
        if (fabOptions.clickColor.hasValue()) {
            fabMenu.setMenuButtonColorPressed(fabOptions.clickColor.get());
        }
        if (fabOptions.rippleColor.hasValue()) {
            fabMenu.setMenuButtonColorRipple(fabOptions.rippleColor.get());
        }
        if (fabOptions.actionsArray.size() > 0) {
            Iterator<Fab> it2 = fabMenu.getActions().iterator();
            while (it2.hasNext()) {
                fabMenu.removeMenuButton(it2.next());
            }
            fabMenu.getActions().clear();
            for (FabOptions fabOptions2 : fabOptions.actionsArray) {
                Fab fab = new Fab(this.viewGroup.getContext(), fabOptions2.f4201id.get());
                applyFabOptions(viewController, fab, fabOptions2);
                fab.setOnClickListener(new View.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.FabPresenter$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        viewController.sendOnNavigationButtonPressed(fabOptions.f4201id.get());
                    }
                });
                fabMenu.getActions().add(fab);
                fabMenu.addMenuButton(fab);
            }
        }
        if (fabOptions.hideOnScroll.isTrue()) {
            fabMenu.enableCollapse(viewController.getScrollEventListener());
        }
        if (fabOptions.hideOnScroll.isFalse()) {
            fabMenu.disableCollapse();
        }
    }

    public void onConfigurationChanged(Options options) {
        FabOptions fabOptions = options.fabOptions;
        if (this.fab != null) {
            if (fabOptions.backgroundColor.hasValue()) {
                this.fab.setColorNormal(fabOptions.backgroundColor.get());
            }
            if (fabOptions.clickColor.hasValue()) {
                this.fab.setColorPressed(fabOptions.clickColor.get());
            }
            if (fabOptions.rippleColor.hasValue()) {
                this.fab.setColorRipple(fabOptions.rippleColor.get());
            }
            if (fabOptions.icon.hasValue()) {
                this.fab.applyIcon(fabOptions.icon.get(), fabOptions.iconColor);
            }
        }
        if (this.fabMenu != null) {
            if (fabOptions.backgroundColor.hasValue()) {
                this.fabMenu.setMenuButtonColorNormal(fabOptions.backgroundColor.get());
            }
            if (fabOptions.clickColor.hasValue()) {
                this.fabMenu.setMenuButtonColorPressed(fabOptions.clickColor.get());
            }
            if (fabOptions.rippleColor.hasValue()) {
                this.fabMenu.setMenuButtonColorRipple(fabOptions.rippleColor.get());
            }
        }
    }
}
