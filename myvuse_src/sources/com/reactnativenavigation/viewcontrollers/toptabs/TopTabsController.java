package com.reactnativenavigation.viewcontrollers.toptabs;

import android.app.Activity;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewVisibilityListenerAdapter;
import com.reactnativenavigation.views.toptabs.TopTabsLayoutCreator;
import com.reactnativenavigation.views.toptabs.TopTabsViewPager;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TopTabsController extends ParentController<TopTabsViewPager> {
    private List<ViewController<?>> tabs;
    private TopTabsLayoutCreator viewCreator;

    public TopTabsController(Activity activity, ChildControllersRegistry childControllersRegistry, String str, List<ViewController<?>> list, TopTabsLayoutCreator topTabsLayoutCreator, Options options, Presenter presenter) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.viewCreator = topTabsLayoutCreator;
        this.tabs = list;
        for (ViewController<?> viewController : list) {
            viewController.setParentController(this);
            viewController.setViewVisibilityListener(new ViewVisibilityListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewVisibilityListenerAdapter, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController.ViewVisibilityListener
                public boolean onViewAppeared(View view) {
                    return ((TopTabsViewPager) TopTabsController.this.getView()).isCurrentView(view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public ViewController<?> getCurrentChild() {
        return this.tabs.get(((TopTabsViewPager) getView()).getCurrentItem());
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public TopTabsViewPager createView() {
        this.view = this.viewCreator.create();
        return (TopTabsViewPager) this.view;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public Collection<? extends ViewController<?>> getChildControllers() {
        return this.tabs;
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillAppear() {
        super.onViewWillAppear();
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$onViewWillAppear$0((ParentController) obj);
            }
        });
        performOnCurrentTab(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).onViewWillAppear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onViewWillAppear$0(ParentController parentController) {
        parentController.setupTopTabsWithViewPager((ViewPager) getView());
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewWillDisappear() {
        super.onViewWillDisappear();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onViewDisappear() {
        super.onViewDisappear();
        performOnCurrentTab(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).onViewDisappear();
            }
        });
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ParentController) obj).clearTopTabs();
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(final String str) {
        performOnCurrentTab(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).sendOnNavigationButtonPressed(str);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyOptions(Options options) {
        super.applyOptions(options);
        ((TopTabsViewPager) getView()).applyOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void applyChildOptions(Options options, final ViewController<?> viewController) {
        super.applyChildOptions(options, viewController);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$applyChildOptions$2(viewController, (ParentController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyChildOptions$2(ViewController viewController, ParentController parentController) {
        parentController.applyChildOptions(this.options.copy(), viewController);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void mergeChildOptions(final Options options, final ViewController<?> viewController) {
        super.mergeChildOptions(options, viewController);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.toptabs.TopTabsController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ParentController parentController = (ParentController) obj;
                parentController.applyChildOptions(options.copy(), viewController);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void switchToTab(int i) {
        ((TopTabsViewPager) getView()).switchToTab(i);
        getCurrentChild().onViewDidAppear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void performOnCurrentTab(Functions.Func1<ViewController<?>> func1) {
        func1.run(this.tabs.get(((TopTabsViewPager) getView()).getCurrentItem()));
    }
}
