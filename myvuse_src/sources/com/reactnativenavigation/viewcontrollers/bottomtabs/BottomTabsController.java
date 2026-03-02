package com.reactnativenavigation.viewcontrollers.bottomtabs;

import android.animation.Animator;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.reactnativenavigation.options.BottomTabOptions;
import com.reactnativenavigation.options.HwBackBottomTabsBehaviour;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.viewcontrollers.bottomtabs.attacher.BottomTabsAttacher;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.stack.StackController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.bottomtabs.BottomTabs;
import com.reactnativenavigation.views.bottomtabs.BottomTabsContainer;
import com.reactnativenavigation.views.bottomtabs.BottomTabsLayout;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabsController extends ParentController<BottomTabsLayout> implements AHBottomNavigation.OnTabSelectedListener, TabSelector {
    private BottomTabs bottomTabs;
    private BottomTabsContainer bottomTabsContainer;
    private final EventEmitter eventEmitter;
    private final ImageLoader imageLoader;
    private final BottomTabsPresenter presenter;
    private final Deque<Integer> selectionStack;
    private final BottomTabPresenter tabPresenter;
    private final List<ViewController<?>> tabs;
    private final BottomTabsAttacher tabsAttacher;

    public BottomTabsAnimator getAnimator() {
        return this.presenter.getAnimator();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.presenter.onConfigurationChanged(resolveCurrentOptions());
        this.tabPresenter.onConfigurationChanged(resolveCurrentOptions());
    }

    public BottomTabsController(Activity activity, List<ViewController<?>> list, ChildControllersRegistry childControllersRegistry, EventEmitter eventEmitter, ImageLoader imageLoader, String str, Options options, Presenter presenter, BottomTabsAttacher bottomTabsAttacher, BottomTabsPresenter bottomTabsPresenter, BottomTabPresenter bottomTabPresenter) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.tabs = list;
        this.eventEmitter = eventEmitter;
        this.imageLoader = imageLoader;
        this.tabsAttacher = bottomTabsAttacher;
        this.presenter = bottomTabsPresenter;
        this.tabPresenter = bottomTabPresenter;
        CollectionUtils.forEach((List) list, new CollectionUtils.Apply() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.CollectionUtils.Apply
            /* JADX INFO: renamed from: on */
            public final void mo2796on(Object obj) {
                this.f$0.lambda$new$0((ViewController) obj);
            }
        });
        this.selectionStack = new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ViewController viewController) {
        viewController.setParentController(this);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(Options options) {
        super.setDefaultOptions(options);
        this.presenter.setDefaultOptions(options);
        this.tabPresenter.setDefaultOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public BottomTabsLayout createView() {
        BottomTabsLayout bottomTabsLayout = new BottomTabsLayout(getActivity());
        BottomTabsContainer bottomTabsContainerCreateBottomTabsContainer = createBottomTabsContainer();
        this.bottomTabsContainer = bottomTabsContainerCreateBottomTabsContainer;
        this.bottomTabs = bottomTabsContainerCreateBottomTabsContainer.getBottomTabs();
        Options optionsResolveCurrentOptions = resolveCurrentOptions();
        this.tabsAttacher.init(bottomTabsLayout, optionsResolveCurrentOptions);
        this.presenter.bindView(this.bottomTabsContainer, this);
        this.tabPresenter.bindView(this.bottomTabs);
        this.bottomTabs.setOnTabSelectedListener(this);
        bottomTabsLayout.addBottomTabsContainer(this.bottomTabsContainer);
        this.bottomTabs.addItems(createTabs());
        setInitialTab(optionsResolveCurrentOptions);
        this.tabsAttacher.attach();
        return bottomTabsLayout;
    }

    private void setInitialTab(Options options) {
        int iIntValue;
        if (options.bottomTabsOptions.currentTabId.hasValue()) {
            iIntValue = this.presenter.findTabIndexByTabId(options.bottomTabsOptions.currentTabId.get());
        } else {
            iIntValue = options.bottomTabsOptions.currentTabIndex.hasValue() ? options.bottomTabsOptions.currentTabIndex.get().intValue() : 0;
        }
        this.bottomTabs.setCurrentItem(iIntValue, false);
    }

    protected BottomTabsContainer createBottomTabsContainer() {
        return new BottomTabsContainer(getActivity(), createBottomTabs());
    }

    protected BottomTabs createBottomTabs() {
        return new BottomTabs(getActivity());
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyOptions(Options options) {
        super.applyOptions(options);
        this.bottomTabs.disableItemsCreation();
        this.presenter.applyOptions(options);
        this.tabPresenter.applyOptions();
        this.bottomTabs.enableItemsCreation();
        this.options.bottomTabsOptions.clearOneTimeOptions();
        this.initialOptions.bottomTabsOptions.clearOneTimeOptions();
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void mergeOptions(Options options) {
        this.presenter.mergeOptions(options, this);
        this.tabPresenter.mergeOptions(options);
        super.mergeOptions(options);
        this.options.bottomTabsOptions.clearOneTimeOptions();
        this.initialOptions.bottomTabsOptions.clearOneTimeOptions();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void applyChildOptions(Options options, final ViewController<?> viewController) {
        super.applyChildOptions(options, viewController);
        this.presenter.applyChildOptions(resolveCurrentOptions(), viewController);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$applyChildOptions$1(viewController, (ParentController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyChildOptions$1(ViewController viewController, ParentController parentController) {
        parentController.applyChildOptions(this.options.copy().clearBottomTabsOptions().clearBottomTabOptions(), viewController);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void mergeChildOptions(final Options options, final ViewController<?> viewController) {
        super.mergeChildOptions(options, viewController);
        this.presenter.mergeChildOptions(options, viewController);
        this.tabPresenter.lambda$mergeOptions$1(options, viewController);
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ParentController parentController = (ParentController) obj;
                parentController.mergeChildOptions(options.copy().clearBottomTabsOptions(), viewController);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean handleBack(CommandListener commandListener) {
        boolean z = !this.tabs.isEmpty() && this.tabs.get(this.bottomTabs.getCurrentItem()).handleBack(commandListener);
        Options optionsResolveCurrentOptions = resolveCurrentOptions();
        if (!z) {
            if (optionsResolveCurrentOptions.hardwareBack.getBottomTabOnPress() instanceof HwBackBottomTabsBehaviour.PrevSelection) {
                if (!this.selectionStack.isEmpty()) {
                    selectTab(this.selectionStack.poll().intValue(), false);
                    return true;
                }
            } else {
                if (!(optionsResolveCurrentOptions.hardwareBack.getBottomTabOnPress() instanceof HwBackBottomTabsBehaviour.JumpToFirst) || getSelectedIndex() == 0) {
                    return false;
                }
                selectTab(0, false);
                return true;
            }
        }
        return z;
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
        getCurrentChild().sendOnNavigationButtonPressed(str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public ViewController<?> getCurrentChild() {
        List<ViewController<?>> list = this.tabs;
        BottomTabs bottomTabs = this.bottomTabs;
        return list.get(bottomTabs == null ? 0 : bottomTabs.getCurrentItem());
    }

    @Override // com.aurelhubert.ahbottomnavigation.AHBottomNavigation.OnTabSelectedListener
    public boolean onTabSelected(int i, boolean z) {
        ViewController<?> viewController = this.tabs.get(i);
        BottomTabOptions bottomTabOptions = viewController.resolveCurrentOptions().bottomTabOptions;
        this.eventEmitter.emitBottomTabPressed(i);
        if (bottomTabOptions.selectTabOnPress.get(true).booleanValue()) {
            this.eventEmitter.emitBottomTabSelected(this.bottomTabs.getCurrentItem(), i);
            if (!z) {
                selectTab(i);
            }
        }
        if (bottomTabOptions.popToRoot.get(false).booleanValue() && z && (viewController instanceof StackController)) {
            ((StackController) viewController).popToRoot(Options.EMPTY, new CommandListenerAdapter());
        }
        return false;
    }

    private List<AHBottomNavigationItem> createTabs() {
        if (this.tabs.size() > 5) {
            throw new RuntimeException("Too many tabs!");
        }
        return CollectionUtils.map(this.tabs, new CollectionUtils.Mapper() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.CollectionUtils.Mapper
            public final Object map(Object obj) {
                return this.f$0.lambda$createTabs$3((ViewController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AHBottomNavigationItem lambda$createTabs$3(ViewController viewController) {
        BottomTabOptions bottomTabOptions = viewController.resolveCurrentOptions().bottomTabOptions;
        return new AHBottomNavigationItem(bottomTabOptions.text.get(""), this.imageLoader.loadIcon(getActivity(), bottomTabOptions.icon.get(null)), this.imageLoader.loadIcon(getActivity(), bottomTabOptions.selectedIcon.get(null)), bottomTabOptions.testId.get(""));
    }

    public int getSelectedIndex() {
        return this.bottomTabs.getCurrentItem();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.views.BehaviourAdapter
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        ObjectUtils.perform(findController(viewGroup), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((ViewController) obj).applyBottomInset();
            }
        });
        return super.onMeasureChild(coordinatorLayout, viewGroup, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getBottomInset$4(ParentController parentController) {
        return Integer.valueOf(parentController.getBottomInset(this));
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public int getBottomInset(ViewController<?> viewController) {
        return this.presenter.getBottomInset(resolveChildOptions(viewController)) + ((Integer) ObjectUtils.perform(getParentController(), 0, new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.bottomtabs.BottomTabsController$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.FuncR1
            public final Object run(Object obj) {
                return this.f$0.lambda$getBottomInset$4((ParentController) obj);
            }
        })).intValue();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void applyBottomInset() {
        this.presenter.applyBottomInset(getBottomInset());
        super.applyBottomInset();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public Collection<ViewController<?>> getChildControllers() {
        return this.tabs;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        this.tabsAttacher.destroy();
        super.destroy();
    }

    @Override // com.reactnativenavigation.viewcontrollers.bottomtabs.TabSelector
    public void selectTab(int i) {
        selectTab(i, resolveCurrentOptions().hardwareBack.getBottomTabOnPress() instanceof HwBackBottomTabsBehaviour.PrevSelection);
    }

    private void selectTab(int i, boolean z) {
        saveTabSelection(i, z);
        this.tabsAttacher.onTabSelected(this.tabs.get(i));
        getCurrentView().setVisibility(4);
        this.bottomTabs.setCurrentItem(i, false);
        getCurrentView().setVisibility(0);
        getCurrentChild().onViewWillAppear();
        getCurrentChild().onViewDidAppear();
    }

    private void saveTabSelection(int i, boolean z) {
        if (z) {
            if (!this.selectionStack.isEmpty() && this.selectionStack.peek().intValue() == i && this.bottomTabs.getCurrentItem() == i) {
                return;
            }
            this.selectionStack.offerFirst(Integer.valueOf(this.bottomTabs.getCurrentItem()));
        }
    }

    private ViewGroup getCurrentView() {
        return this.tabs.get(this.bottomTabs.getCurrentItem()).getView();
    }

    public Animator getPushAnimation(Options options) {
        return this.presenter.getPushAnimation(options);
    }

    public Animator getSetStackRootAnimation(Options options) {
        return this.presenter.getSetStackRootAnimation(options);
    }

    public Animator getPopAnimation(Options options, Options options2) {
        return this.presenter.getPopAnimation(options, options2);
    }

    public BottomTabs getBottomTabs() {
        return this.bottomTabs;
    }

    public BottomTabsContainer getBottomTabsContainer() {
        return this.bottomTabsContainer;
    }

    public void setBottomTabsContainer(BottomTabsContainer bottomTabsContainer) {
        this.bottomTabsContainer = bottomTabsContainer;
    }

    public void setBottomTabs(BottomTabs bottomTabs) {
        this.bottomTabs = bottomTabs;
    }
}
