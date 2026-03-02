package com.reactnativenavigation.viewcontrollers.viewcontroller;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.options.params.Bool;
import com.reactnativenavigation.options.params.NullBool;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.utils.StringUtils;
import com.reactnativenavigation.utils.UiThread;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.stack.StackController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ViewControllerOverlay;
import com.reactnativenavigation.views.BehaviourAdapter;
import com.reactnativenavigation.views.component.Component;
import com.reactnativenavigation.views.component.Renderable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ViewController<T extends ViewGroup> implements ViewTreeObserver.OnGlobalLayoutListener, ViewGroup.OnHierarchyChangeListener, BehaviourAdapter {
    private final Activity activity;
    private boolean appearEventPosted;

    /* JADX INFO: renamed from: id */
    private final String f4207id;
    public Options initialOptions;
    private boolean isDestroyed;
    private boolean isShown;
    public Options options;
    private ViewControllerOverlay overlay;
    private ParentController<? extends ViewGroup> parentController;
    protected T view;
    private final YellowBoxDelegate yellowBoxDelegate;
    private final List<Runnable> onAppearedListeners = new ArrayList();
    private boolean isFirstLayout = true;
    private Bool waitForRender = new NullBool();
    private ViewVisibilityListener viewVisibilityListener = new ViewVisibilityListenerAdapter();

    public interface ViewVisibilityListener {
        boolean onViewAppeared(View view);

        boolean onViewDisappear(View view);
    }

    public void applyBottomInset() {
    }

    public void applyOptions(Options options) {
    }

    public void applyTopInset() {
    }

    public abstract T createView();

    public abstract String getCurrentComponentName();

    public ScrollEventListener getScrollEventListener() {
        return null;
    }

    public int getTopInset() {
        return 0;
    }

    public boolean handleBack(CommandListener commandListener) {
        return false;
    }

    public void onAttachToParent() {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, View view) {
        return false;
    }

    public void onViewDidAppear() {
    }

    public void onViewWillDisappear() {
    }

    public abstract void sendOnNavigationButtonPressed(String str);

    public void setDefaultOptions(Options options) {
    }

    public void start() {
    }

    public void setOverlay(ViewControllerOverlay viewControllerOverlay) {
        this.overlay = viewControllerOverlay;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public ViewController(Activity activity, String str, YellowBoxDelegate yellowBoxDelegate, Options options, ViewControllerOverlay viewControllerOverlay) {
        this.activity = activity;
        this.f4207id = str;
        this.yellowBoxDelegate = yellowBoxDelegate;
        this.initialOptions = options;
        this.overlay = viewControllerOverlay;
        this.options = options.copy();
    }

    public void setWaitForRender(Bool bool) {
        this.waitForRender = bool;
    }

    public void addOnAppearedListener(Runnable runnable) {
        if (this.isShown) {
            runnable.run();
        } else {
            this.onAppearedListeners.add(runnable);
        }
    }

    public void removeOnAppearedListener(Runnable runnable) {
        this.onAppearedListeners.remove(runnable);
    }

    public void setViewVisibilityListener(ViewVisibilityListener viewVisibilityListener) {
        this.viewVisibilityListener = viewVisibilityListener;
    }

    public void ensureViewIsCreated() {
        getView();
    }

    protected boolean isViewCreated() {
        return this.view != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOverlay$0(View view, ViewGroup.LayoutParams layoutParams, ViewGroup viewGroup) {
        this.overlay.add(viewGroup, view, layoutParams);
    }

    public void addOverlay(final View view, final ViewGroup.LayoutParams layoutParams) {
        ObjectUtils.perform(this.view, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$addOverlay$0(view, layoutParams, (ViewGroup) obj);
            }
        });
    }

    public void removeOverlay(View view) {
        this.overlay.remove(view);
    }

    public Options resolveCurrentOptions() {
        return this.options;
    }

    public Options resolveCurrentOptions(Options options) {
        return this.options.copy().withDefaultOptions(options);
    }

    public void mergeOptions(Options options) {
        this.initialOptions = this.initialOptions.mergeWith(options);
        this.options = this.options.mergeWith(options);
        if (getParentController() != null) {
            this.options.clearOneTimeOptions();
            this.initialOptions.clearOneTimeOptions();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewController<?> getTopMostParent() {
        ParentController<? extends ViewGroup> parentController = this.parentController;
        return parentController != null ? parentController.getTopMostParent() : this;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void performOnView(Functions.Func1<View> func1) {
        T t = this.view;
        if (t != null) {
            func1.run(t);
        }
    }

    public void performOnParentController(Functions.Func1<ParentController> func1) {
        ParentController<? extends ViewGroup> parentController = this.parentController;
        if (parentController != null) {
            func1.run(parentController);
        }
    }

    public ParentController getParentController() {
        return this.parentController;
    }

    public ParentController requireParentController() {
        return this.parentController;
    }

    public void setParentController(ParentController parentController) {
        this.parentController = parentController;
    }

    public void performOnParentStack(final Functions.Func1<StackController> func1) {
        ParentController<? extends ViewGroup> parentController = this.parentController;
        if (parentController instanceof StackController) {
            func1.run((StackController) parentController);
        } else if (this instanceof StackController) {
            func1.run((StackController) this);
        } else {
            performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda5
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ((ParentController) obj).performOnParentStack(func1);
                }
            });
        }
    }

    public T getView() {
        if (this.view == null) {
            if (this.isDestroyed) {
                throw new RuntimeException("Tried to create view after it has already been destroyed");
            }
            T t = (T) createView();
            this.view = t;
            t.setOnHierarchyChangeListener(this);
            this.view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        return this.view;
    }

    public void detachView() {
        T t = this.view;
        if (t == null || t.getParent() == null) {
            return;
        }
        ((ViewManager) this.view.getParent()).removeView(this.view);
    }

    public void attachView(ViewGroup viewGroup, int i) {
        T t = this.view;
        if (t != null && t.getParent() == null) {
            viewGroup.addView(this.view, i);
        }
    }

    public String getId() {
        return this.f4207id;
    }

    boolean isSameId(String str) {
        return StringUtils.isEqual(this.f4207id, str);
    }

    public ViewController findController(String str) {
        if (isSameId(str)) {
            return this;
        }
        return null;
    }

    public ViewController findController(View view) {
        if (this.view == view) {
            return this;
        }
        return null;
    }

    public boolean containsComponent(Component component) {
        return getView().equals(component);
    }

    public void onViewWillAppear() {
        this.isShown = true;
        applyOptions(this.options);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$onViewWillAppear$2((ParentController) obj);
            }
        });
        if (this.onAppearedListeners.isEmpty() || this.appearEventPosted) {
            return;
        }
        this.appearEventPosted = true;
        UiThread.post(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onViewWillAppear$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewWillAppear$2(ParentController parentController) {
        parentController.clearOptions();
        if (getView() instanceof Component) {
            parentController.applyChildOptions(this.options, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewWillAppear$3() {
        CollectionUtils.forEach((List) this.onAppearedListeners, (CollectionUtils.Apply) new ViewController$$ExternalSyntheticLambda4());
        this.onAppearedListeners.clear();
    }

    public void onViewDisappear() {
        this.isShown = false;
    }

    public void destroy() {
        if (this.isShown) {
            this.isShown = false;
            onViewDisappear();
        }
        this.yellowBoxDelegate.destroy();
        T t = this.view;
        if (t instanceof Destroyable) {
            ((Destroyable) t).destroy();
        }
        T t2 = this.view;
        if (t2 != null) {
            t2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.view.setOnHierarchyChangeListener(null);
            if (this.view.getParent() instanceof ViewGroup) {
                ((ViewManager) this.view.getParent()).removeView(this.view);
            }
            setParentController(null);
            this.view = null;
            this.isDestroyed = true;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.isFirstLayout) {
            onAttachToParent();
            this.isFirstLayout = false;
        }
        if (!this.isShown && isViewShown()) {
            if (this.viewVisibilityListener.onViewAppeared(this.view)) {
                return;
            }
            this.isShown = true;
            onViewWillAppear();
            return;
        }
        if (!this.isShown || isViewShown() || this.viewVisibilityListener.onViewDisappear(this.view)) {
            return;
        }
        this.isShown = false;
        onViewDisappear();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if ((view instanceof ViewGroup) && (view2 instanceof ViewGroup)) {
            ((ViewGroup) view2).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController.1
                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewRemoved(View view3, View view4) {
                }

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewAdded(View view3, View view4) {
                    ViewController.this.yellowBoxDelegate.onChildViewAdded(view3, view4);
                }
            });
        }
    }

    protected void runOnPreDraw(Functions.Func1<T> func1) {
        if (this.isDestroyed) {
            return;
        }
        UiUtils.runOnPreDrawOnce(getView(), func1);
    }

    public boolean isViewShown() {
        T t;
        return !this.isDestroyed && (t = this.view) != null && t.isShown() && isRendered();
    }

    public boolean isRendered() {
        if (this.view != null) {
            if (!this.waitForRender.isFalseOrUndefined()) {
                T t = this.view;
                if (!(t instanceof Renderable) || ((Renderable) t).isRendered()) {
                }
            }
            return true;
        }
        return false;
    }

    public void applyOnController(ViewController viewController, Functions.Func1<ViewController> func1) {
        if (viewController != null) {
            func1.run(viewController);
        }
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        ObjectUtils.perform(findController(viewGroup), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).applyTopInset();
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getBottomInset$4(ParentController parentController) {
        return Integer.valueOf(parentController.getBottomInset(this));
    }

    public int getBottomInset() {
        return ((Integer) ObjectUtils.perform(this.parentController, 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return this.f$0.lambda$getBottomInset$4((ParentController) obj);
            }
        })).intValue();
    }
}
