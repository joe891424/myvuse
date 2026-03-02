package com.reactnativenavigation.viewcontrollers.sidemenu;

import android.app.Activity;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.SideMenuRootOptions;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.sidemenu.SideMenu;
import com.reactnativenavigation.views.sidemenu.SideMenuRoot;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class SideMenuController extends ParentController<SideMenuRoot> implements DrawerLayout.DrawerListener {
    private ViewController<?> center;
    private ViewController<?> left;
    private SideMenuPresenter presenter;
    private float prevLeftSlideOffset;
    private float prevRightSlideOffset;
    private ViewController<?> right;

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public SideMenuController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, Options options, SideMenuPresenter sideMenuPresenter, Presenter presenter) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.prevLeftSlideOffset = 0.0f;
        this.prevRightSlideOffset = 0.0f;
        this.presenter = sideMenuPresenter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public ViewController<?> getCurrentChild() {
        if (!isDestroyed()) {
            if (((SideMenuRoot) getView()).isDrawerOpen(3)) {
                return this.left;
            }
            if (((SideMenuRoot) getView()).isDrawerOpen(5)) {
                return this.right;
            }
        }
        return this.center;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public SideMenuRoot createView() {
        SideMenu sideMenu = new SideMenu(getActivity());
        this.presenter.bindView(sideMenu);
        sideMenu.addDrawerListener(this);
        SideMenuRoot sideMenuRoot = new SideMenuRoot(getActivity());
        sideMenuRoot.addSideMenu(sideMenu, this);
        return sideMenuRoot;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
        this.center.sendOnNavigationButtonPressed(str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public Collection<ViewController<?>> getChildControllers() {
        ArrayList arrayList = new ArrayList();
        ViewController<?> viewController = this.center;
        if (viewController != null) {
            arrayList.add(viewController);
        }
        ViewController<?> viewController2 = this.left;
        if (viewController2 != null) {
            arrayList.add(viewController2);
        }
        ViewController<?> viewController3 = this.right;
        if (viewController3 != null) {
            arrayList.add(viewController3);
        }
        return arrayList;
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyOptions(Options options) {
        super.applyOptions(options);
        this.presenter.applyOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void applyChildOptions(Options options, final ViewController<?> viewController) {
        super.applyChildOptions(options, viewController);
        this.presenter.applyChildOptions(resolveCurrentOptions());
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$applyChildOptions$0(viewController, (ParentController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyChildOptions$0(ViewController viewController, ParentController parentController) {
        parentController.applyChildOptions(this.options, viewController);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void mergeChildOptions(final Options options, final ViewController<?> viewController) {
        super.mergeChildOptions(options, viewController);
        this.presenter.mergeOptions(options.sideMenuRootOptions);
        mergeLockMode(this.initialOptions, options.sideMenuRootOptions);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ParentController) obj).mergeChildOptions(options, viewController);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        super.onViewWillAppear();
        ViewController<?> viewController = this.left;
        if (viewController != null) {
            viewController.performOnView(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda2
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ((View) obj).requestLayout();
                }
            });
        }
        ViewController<?> viewController2 = this.right;
        if (viewController2 != null) {
            viewController2.performOnView(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda3
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ((View) obj).requestLayout();
                }
            });
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void mergeOptions(Options options) {
        super.mergeOptions(options);
        this.presenter.mergeOptions(options.sideMenuRootOptions);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public Options resolveCurrentOptions() {
        Options optionsResolveCurrentOptions = super.resolveCurrentOptions();
        return (isDrawerOpen(3) || isDrawerOpen(5)) ? optionsResolveCurrentOptions.mergeWith(this.center.resolveCurrentOptions()) : optionsResolveCurrentOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isDrawerOpen(int i) {
        return !isDestroyed() && ((SideMenuRoot) getView()).isDrawerOpen(i);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        getMatchingView(view).mergeOptions(getOptionsWithVisibility(isLeftMenu(view), true));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        getMatchingView(view).mergeOptions(getOptionsWithVisibility(isLeftMenu(view), false));
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        int sideMenuGravity = getSideMenuGravity(view);
        if (sideMenuGravity == 3) {
            dispatchSideMenuVisibilityEvents(this.left, this.prevLeftSlideOffset, f);
            this.prevLeftSlideOffset = f;
        } else if (sideMenuGravity == 5) {
            dispatchSideMenuVisibilityEvents(this.right, this.prevRightSlideOffset, f);
            this.prevRightSlideOffset = f;
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean handleBack(CommandListener commandListener) {
        return this.presenter.handleBack() || this.center.handleBack(commandListener) || super.handleBack(commandListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ViewController<?> findController(View view) {
        return ((SideMenuRoot) getView()).isSideMenu(view) ? this : super.findController(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCenterController(ViewController<?> viewController) {
        this.center = viewController;
        ((SideMenuRoot) getView()).setCenter(this.center);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLeftController(ViewController<?> viewController) {
        this.left = viewController;
        ((SideMenuRoot) getView()).setLeft(this.left, this.options);
        this.presenter.bindLeft(this.left);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRightController(ViewController<?> viewController) {
        this.right = viewController;
        ((SideMenuRoot) getView()).setRight(this.right, this.options);
        this.presenter.bindRight(this.right);
    }

    private ViewController<?> getMatchingView(View view) {
        return isLeftMenu(view) ? this.left : this.right;
    }

    private boolean isLeftMenu(View view) {
        ViewController<?> viewController = this.left;
        return viewController != null && view.equals(viewController.getView());
    }

    private int getSideMenuGravity(View view) {
        return ((DrawerLayout.LayoutParams) view.getLayoutParams()).gravity;
    }

    private Options getOptionsWithVisibility(boolean z, boolean z2) {
        Options options = new Options();
        if (z) {
            options.sideMenuRootOptions.left.visible = new Bool(Boolean.valueOf(z2));
        } else {
            options.sideMenuRootOptions.right.visible = new Bool(Boolean.valueOf(z2));
        }
        return options;
    }

    private void dispatchSideMenuVisibilityEvents(ViewController<?> viewController, float f, float f2) {
        if (f < 1.0f && f2 == 1.0f) {
            viewController.onViewDidAppear();
            return;
        }
        if (f == 0.0f && f2 > 0.0f) {
            viewController.onViewWillAppear();
        } else {
            if (f <= 0.0f || f2 != 0.0f) {
                return;
            }
            viewController.onViewDisappear();
        }
    }

    private void mergeLockMode(final Options options, SideMenuRootOptions sideMenuRootOptions) {
        ObjectUtils.perform(sideMenuRootOptions.left.enabled.get(null), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                options.sideMenuRootOptions.left.enabled = new Bool((Boolean) obj);
            }
        });
        ObjectUtils.perform(sideMenuRootOptions.right.enabled.get(null), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.sidemenu.SideMenuController$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                options.sideMenuRootOptions.right.enabled = new Bool((Boolean) obj);
            }
        });
    }

    SideMenu getSideMenu() {
        return this.presenter.getSideMenu();
    }
}
