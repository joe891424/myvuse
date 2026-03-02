package com.reactnativenavigation.viewcontrollers.parent;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController;
import com.reactnativenavigation.viewcontrollers.child.ChildController;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.component.Component;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ParentController<T extends ViewGroup> extends ChildController<T> {
    public void clearTopTabs() {
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public abstract T createView();

    public abstract Collection<? extends ViewController<?>> getChildControllers();

    public abstract ViewController<?> getCurrentChild();

    public void mergeChildOptions(Options options, ViewController<?> viewController) {
    }

    public void onChildDestroyed(ViewController<?> viewController) {
    }

    public void setupTopTabsWithViewPager(ViewPager viewPager) {
    }

    public ParentController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, Presenter presenter, Options options) {
        super(activity, childControllersRegistry, str, presenter, options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setWaitForRender(final Bool bool) {
        super.setWaitForRender(bool);
        applyOnController(getCurrentChild(), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).setWaitForRender(bool);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(final Options options) {
        super.setDefaultOptions(options);
        CollectionUtils.forEach(getChildControllers(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                ((ViewController) obj).setDefaultOptions(options);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDidAppear() {
        super.onViewDidAppear();
        ViewController<?> currentChild = getCurrentChild();
        if (currentChild != null) {
            currentChild.onViewDidAppear();
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        super.onViewDisappear();
        ViewController<?> currentChild = getCurrentChild();
        if (currentChild != null) {
            currentChild.onViewDisappear();
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public Options resolveCurrentOptions() {
        return CollectionUtils.isNullOrEmpty(getChildControllers()) ? this.initialOptions : getCurrentChild().resolveCurrentOptions().copy().withDefaultOptions(this.initialOptions);
    }

    public Options resolveChildOptions(ViewController<?> viewController) {
        if (viewController == this) {
            return resolveCurrentOptions();
        }
        return viewController.resolveCurrentOptions().copy().withDefaultOptions(this.initialOptions);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public Options resolveCurrentOptions(Options options) {
        return resolveCurrentOptions().withDefaultOptions(options);
    }

    public boolean isCurrentChild(ViewController<?> viewController) {
        return getCurrentChild() == viewController;
    }

    protected BottomTabsController getBottomTabsController() {
        if (this instanceof BottomTabsController) {
            return (BottomTabsController) this;
        }
        return (BottomTabsController) ObjectUtils.perform(getParentController(), null, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return ((ParentController) obj).getBottomTabsController();
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ViewController<?> findController(String str) {
        ViewController<?> viewControllerFindController = super.findController(str);
        if (viewControllerFindController != null) {
            return viewControllerFindController;
        }
        Iterator<? extends ViewController<?>> it2 = getChildControllers().iterator();
        while (it2.hasNext()) {
            ViewController<?> viewControllerFindController2 = it2.next().findController(str);
            if (viewControllerFindController2 != null) {
                return viewControllerFindController2;
            }
        }
        return null;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ViewController<?> findController(View view) {
        ViewController<?> viewControllerFindController = super.findController(view);
        if (viewControllerFindController != null) {
            return viewControllerFindController;
        }
        Iterator<? extends ViewController<?>> it2 = getChildControllers().iterator();
        while (it2.hasNext()) {
            ViewController<?> viewControllerFindController2 = it2.next().findController(view);
            if (viewControllerFindController2 != null) {
                return viewControllerFindController2;
            }
        }
        return null;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean containsComponent(Component component) {
        if (super.containsComponent(component)) {
            return true;
        }
        Iterator<? extends ViewController<?>> it2 = getChildControllers().iterator();
        while (it2.hasNext()) {
            if (it2.next().containsComponent(component)) {
                return true;
            }
        }
        return false;
    }

    public void applyChildOptions(Options options, ViewController<?> viewController) {
        this.options = this.initialOptions.mergeWith(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        super.destroy();
        CollectionUtils.forEach(getChildControllers(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                ((ViewController) obj).destroy();
            }
        });
    }

    public void clearOptions() {
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ParentController) obj).clearOptions();
            }
        });
        this.options = this.initialOptions.copy().clearOneTimeOptions();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isRendered() {
        return getCurrentChild() != null && getCurrentChild().isRendered();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyTopInset() {
        CollectionUtils.forEach(getChildControllers(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                ((ViewController) obj).applyTopInset();
            }
        });
    }

    public int getTopInset(final ViewController<?> viewController) {
        return ((Integer) ObjectUtils.perform(getParentController(), 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return Integer.valueOf(((ParentController) obj).getTopInset(viewController));
            }
        })).intValue();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyBottomInset() {
        CollectionUtils.forEach(getChildControllers(), new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda7
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                ((ViewController) obj).applyBottomInset();
            }
        });
    }

    public int getBottomInset(final ViewController<?> viewController) {
        return ((Integer) ObjectUtils.perform(getParentController(), 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.parent.ParentController$$ExternalSyntheticLambda8
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return Integer.valueOf(((ParentController) obj).getBottomInset(viewController));
            }
        })).intValue();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public String getCurrentComponentName() {
        return getCurrentChild().getCurrentComponentName();
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (ViewController<?> viewController : getChildControllers()) {
            if (viewController.isViewShown()) {
                viewController.onConfigurationChanged(configuration);
            }
        }
    }
}
