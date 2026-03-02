package com.reactnativenavigation.viewcontrollers.stack;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.facebook.react.ReactRootView;
import com.reactnativenavigation.options.ButtonOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.react.Constants;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.CollectionUtils;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.BackButtonHelper;
import com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.views.component.Component;
import com.reactnativenavigation.views.stack.StackBehaviour;
import com.reactnativenavigation.views.stack.StackLayout;
import com.reactnativenavigation.views.stack.fab.Fab;
import com.reactnativenavigation.views.stack.fab.FabMenu;
import com.reactnativenavigation.views.stack.topbar.TopBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class StackController extends ParentController<StackLayout> {
    private final StackAnimator animator;
    private final BackButtonHelper backButtonHelper;
    private final EventEmitter eventEmitter;
    private final FabPresenter fabPresenter;
    private final StackPresenter presenter;
    private IdStack<ViewController<?>> stack;
    private final TopBarController topBarController;

    public StackController(Activity activity, List<ViewController<?>> list, ChildControllersRegistry childControllersRegistry, EventEmitter eventEmitter, TopBarController topBarController, StackAnimator stackAnimator, String str, Options options, BackButtonHelper backButtonHelper, StackPresenter stackPresenter, Presenter presenter, FabPresenter fabPresenter) {
        super(activity, childControllersRegistry, str, presenter, options);
        this.stack = new IdStack<>();
        this.eventEmitter = eventEmitter;
        this.topBarController = topBarController;
        this.animator = stackAnimator;
        this.backButtonHelper = backButtonHelper;
        this.presenter = stackPresenter;
        this.fabPresenter = fabPresenter;
        stackPresenter.setButtonOnClickListener(new ButtonController.OnClickListener() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda5
            @Override // com.reactnativenavigation.viewcontrollers.stack.topbar.button.ButtonController.OnClickListener
            public final void onPress(ButtonOptions buttonOptions) {
                this.f$0.onNavigationButtonPressed(buttonOptions);
            }
        });
        setChildren(list);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.presenter.onConfigurationChanged(resolveCurrentOptions());
        this.fabPresenter.onConfigurationChanged(resolveCurrentOptions());
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean isRendered() {
        if (isEmpty() || getCurrentChild().isDestroyed()) {
            return false;
        }
        ViewGroup view = getCurrentChild().getView();
        if (view instanceof Component) {
            return super.isRendered() && this.presenter.isRendered(view);
        }
        return super.isRendered();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(Options options) {
        super.setDefaultOptions(options);
        this.presenter.setDefaultOptions(options);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public ViewController<?> getCurrentChild() {
        return this.stack.peek();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onAttachToParent() {
        if (isEmpty() || getCurrentChild().isDestroyed() || isViewShown()) {
            return;
        }
        this.presenter.applyChildOptions(resolveCurrentOptions(), this, getCurrentChild());
    }

    @Override // com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void mergeOptions(Options options) {
        if (isViewShown()) {
            this.presenter.mergeOptions(options, this, getCurrentChild());
        }
        super.mergeOptions(options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void applyChildOptions(Options options, final ViewController<?> viewController) {
        super.applyChildOptions(options, viewController);
        this.presenter.applyChildOptions(resolveCurrentOptions(), this, viewController);
        this.fabPresenter.applyOptions(this.options.fabOptions, viewController, getView());
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda6
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$applyChildOptions$0(viewController, (ParentController) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$applyChildOptions$0(ViewController viewController, ParentController parentController) {
        parentController.applyChildOptions(this.options.copy().clearTopBarOptions().clearAnimationOptions().clearFabOptions().clearTopTabOptions().clearTopTabsOptions(), viewController);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void mergeChildOptions(final Options options, final ViewController<?> viewController) {
        super.mergeChildOptions(options, viewController);
        if (viewController.isViewShown() && peek() == viewController) {
            this.presenter.mergeChildOptions(options, resolveCurrentOptions(), this, viewController);
            if (options.fabOptions.hasValue()) {
                this.fabPresenter.mergeOptions(options.fabOptions, viewController, getView());
            }
        }
        performOnParentController(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ParentController parentController = (ParentController) obj;
                parentController.mergeChildOptions(options.copy().clearTopBarOptions().clearAnimationOptions().clearFabOptions().clearTopTabOptions().clearTopTabsOptions(), viewController);
            }
        });
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void onChildDestroyed(ViewController<?> viewController) {
        super.onChildDestroyed(viewController);
        this.presenter.onChildDestroyed(viewController);
    }

    public void push(final ViewController<?> viewController, final CommandListener commandListener) {
        if (findController(viewController.getId()) != null) {
            commandListener.onError("A stack can't contain two children with the same id: " + viewController.getId());
            return;
        }
        final ViewController<?> viewControllerPeek = this.stack.peek();
        if (size() > 0) {
            this.backButtonHelper.addToPushedChild(viewController);
        }
        viewController.setParentController(this);
        this.stack.push(viewController.getId(), viewController);
        if (isViewCreated()) {
            Options optionsResolveCurrentOptions = resolveCurrentOptions(this.presenter.getDefaultOptions());
            addChildToStack(viewController, optionsResolveCurrentOptions);
            if (viewControllerPeek != null) {
                if (optionsResolveCurrentOptions.animations.push.enabled.isTrueOrUndefined()) {
                    this.animator.push(viewController, viewControllerPeek, optionsResolveCurrentOptions, this.presenter.getAdditionalPushAnimations(this, viewController, optionsResolveCurrentOptions), new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$push$2(viewController, viewControllerPeek, commandListener);
                        }
                    });
                    return;
                } else {
                    lambda$push$2(viewController, viewControllerPeek, commandListener);
                    return;
                }
            }
            commandListener.onSuccess(viewController.getId());
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        super.destroy();
        this.animator.cancelAllAnimations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: onPushAnimationComplete, reason: merged with bridge method [inline-methods] */
    public void lambda$push$2(ViewController<?> viewController, ViewController<?> viewController2, CommandListener commandListener) {
        viewController.onViewDidAppear();
        if (!peek().equals(viewController2)) {
            ((StackLayout) getView()).removeView(viewController2.getView());
        }
        commandListener.onSuccess(viewController.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addChildToStack(ViewController<?> viewController, Options options) {
        viewController.setWaitForRender(options.animations.push.waitForRender);
        if (size() == 1) {
            this.presenter.applyInitialChildLayoutOptions(options);
        }
        ((StackLayout) getView()).addView(viewController.getView(), ((StackLayout) getView()).getChildCount() - 1, CoordinatorLayoutUtils.matchParentWithBehaviour(new StackBehaviour(this)));
    }

    public void setRoot(final List<ViewController<?>> list, final CommandListener commandListener) {
        if (!isViewCreated()) {
            setChildren(list);
            return;
        }
        this.animator.cancelPushAnimations();
        final ViewController<?> viewControllerPeek = this.stack.peek();
        final IdStack<ViewController<?>> idStack = this.stack;
        this.stack = new IdStack<>();
        final ViewController<?> viewController = (ViewController) CollectionUtils.requireLast(list);
        if (list.size() == 1) {
            this.backButtonHelper.clear(viewController);
        } else {
            this.backButtonHelper.addToPushedChild(viewController);
        }
        viewController.setParentController(this);
        this.stack.push(viewController.getId(), viewController);
        final Options optionsResolveCurrentOptions = resolveCurrentOptions(this.presenter.getDefaultOptions());
        addChildToStack(viewController, optionsResolveCurrentOptions);
        final CommandListenerAdapter commandListenerAdapter = new CommandListenerAdapter() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController.1
            @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
            public void onSuccess(String str) {
                if (viewController.isViewShown()) {
                    viewController.onViewDidAppear();
                }
                StackController.this.destroyStack(idStack);
                if (list.size() > 1) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        StackController.this.stack.set(((ViewController) list.get(i)).getId(), (ViewController) list.get(i), i);
                        ((ViewController) list.get(i)).setParentController(StackController.this);
                        if (i == 0) {
                            StackController.this.backButtonHelper.clear((ViewController) list.get(i));
                        } else {
                            StackController.this.backButtonHelper.addToPushedChild((ViewController) list.get(i));
                        }
                    }
                    StackController.this.startChildrenBellowTopChild();
                }
                commandListener.onSuccess(str);
            }
        };
        if (viewControllerPeek != null && optionsResolveCurrentOptions.animations.setStackRoot.enabled.isTrueOrUndefined()) {
            if (optionsResolveCurrentOptions.animations.setStackRoot.waitForRender.isTrue()) {
                viewController.getView().setAlpha(0.0f);
                viewController.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setRoot$4(viewController, viewControllerPeek, optionsResolveCurrentOptions, commandListenerAdapter);
                    }
                });
                return;
            } else {
                this.animator.setRoot(viewController, viewControllerPeek, optionsResolveCurrentOptions, this.presenter.getAdditionalSetRootAnimations(this, viewController, optionsResolveCurrentOptions), new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        commandListenerAdapter.onSuccess(viewController.getId());
                    }
                });
                return;
            }
        }
        commandListenerAdapter.onSuccess(viewController.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRoot$4(final ViewController viewController, ViewController viewController2, Options options, final CommandListener commandListener) {
        this.animator.setRoot(viewController, viewController2, options, this.presenter.getAdditionalSetRootAnimations(this, viewController, options), new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                commandListener.onSuccess(viewController.getId());
            }
        });
    }

    private void setChildren(List<ViewController<?>> list) {
        this.stack.clear();
        for (ViewController<?> viewController : list) {
            if (this.stack.containsId(viewController.getId())) {
                throw new IllegalArgumentException("A stack can't contain two children with the same id: " + viewController.getId());
            }
            viewController.setParentController(this);
            this.stack.push(viewController.getId(), viewController);
            if (size() > 1) {
                this.backButtonHelper.addToPushedChild(viewController);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyStack(IdStack<?> idStack) {
        this.animator.cancelAllAnimations();
        Iterator<String> it2 = idStack.iterator();
        while (it2.hasNext()) {
            ((ViewController) idStack.get(it2.next())).destroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pop(Options options, final CommandListener commandListener) {
        if (!canPop()) {
            commandListener.onError("Nothing to pop");
            return;
        }
        peek().mergeOptions(options);
        Options optionsResolveCurrentOptions = resolveCurrentOptions(this.presenter.getDefaultOptions());
        final ViewController<?> viewControllerPop = this.stack.pop();
        if (isViewCreated()) {
            final ViewController<?> viewControllerPeek = this.stack.peek();
            viewControllerPop.onViewWillDisappear();
            ViewGroup view = viewControllerPeek.getView();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(CoordinatorLayoutUtils.matchParentWithBehaviour(new StackBehaviour(this)));
            }
            if (view.getParent() == null) {
                ((StackLayout) getView()).addView(view, 0);
            }
            if (optionsResolveCurrentOptions.animations.pop.enabled.isTrueOrUndefined()) {
                this.animator.pop(viewControllerPeek, viewControllerPop, optionsResolveCurrentOptions, this.presenter.getAdditionalPopAnimations(resolveChildOptions(viewControllerPeek).withDefaultOptions(this.presenter.getDefaultOptions()), optionsResolveCurrentOptions), new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$pop$6(viewControllerPeek, viewControllerPop, commandListener);
                    }
                });
            } else {
                lambda$pop$6(viewControllerPeek, viewControllerPop, commandListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: finishPopping, reason: merged with bridge method [inline-methods] */
    public void lambda$pop$6(ViewController<?> viewController, ViewController<?> viewController2, CommandListener commandListener) {
        viewController.onViewDidAppear();
        viewController2.destroy();
        commandListener.onSuccess(viewController2.getId());
        this.eventEmitter.emitScreenPoppedEvent(viewController2.getId());
    }

    public void popTo(ViewController<?> viewController, Options options, CommandListener commandListener) {
        if (!this.stack.containsId(viewController.getId()) || peek().equals(viewController)) {
            commandListener.onError("Nothing to pop");
            return;
        }
        this.animator.cancelPushAnimations();
        for (int size = this.stack.size() - 2; size >= 0; size--) {
            String id = this.stack.get(size).getId();
            if (id.equals(viewController.getId())) {
                break;
            }
            ViewController<?> viewController2 = this.stack.get(id);
            this.stack.remove(viewController2.getId());
            viewController2.destroy();
        }
        pop(options, commandListener);
    }

    public void popToRoot(Options options, CommandListener commandListener) {
        if (!canPop()) {
            commandListener.onSuccess("");
            return;
        }
        this.animator.cancelPushAnimations();
        Iterator<String> it2 = this.stack.iterator();
        it2.next();
        while (this.stack.size() > 2) {
            ViewController<?> viewController = this.stack.get(it2.next());
            if (!this.stack.isTop(viewController.getId())) {
                this.stack.remove(it2, viewController.getId());
                viewController.destroy();
            }
        }
        pop(options, commandListener);
    }

    ViewController<?> peek() {
        return this.stack.peek();
    }

    public int size() {
        return this.stack.size();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public boolean isChildInTransition(ViewController<?> viewController) {
        return this.animator.isChildInTransition(viewController);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean handleBack(CommandListener commandListener) {
        if (!canPop()) {
            return false;
        }
        if (this.presenter.shouldPopOnHardwareButtonPress(peek())) {
            pop(Options.EMPTY, commandListener);
            return true;
        }
        sendOnNavigationButtonPressed(Constants.HARDWARE_BACK_BUTTON_ID);
        return true;
    }

    boolean canPop() {
        return this.stack.size() > 1;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public StackLayout createView() {
        StackLayout stackLayout = new StackLayout(getActivity(), this.topBarController, getId());
        this.presenter.bindView(this.topBarController, getBottomTabsController());
        addInitialChild(stackLayout);
        return stackLayout;
    }

    private void addInitialChild(StackLayout stackLayout) {
        if (isEmpty()) {
            return;
        }
        ViewController<?> viewControllerPeek = peek();
        ViewGroup view = viewControllerPeek.getView();
        setChildId(view);
        viewControllerPeek.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.startChildrenBellowTopChild();
            }
        });
        stackLayout.addView(view, 0, CoordinatorLayoutUtils.matchParentWithBehaviour(new StackBehaviour(this)));
        this.presenter.applyInitialChildLayoutOptions(resolveCurrentOptions());
    }

    private void setChildId(ViewGroup viewGroup) {
        if (viewGroup instanceof ReactRootView) {
            return;
        }
        viewGroup.setId(CompatUtils.generateViewId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startChildrenBellowTopChild() {
        ArrayList arrayList = new ArrayList(getChildControllers());
        for (int size = arrayList.size() - 2; size >= 0; size--) {
            ((ViewController) arrayList.get(size)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNavigationButtonPressed(ButtonOptions buttonOptions) {
        if (buttonOptions.isBackButton() && buttonOptions.shouldPopOnPress()) {
            pop(Options.EMPTY, new CommandListenerAdapter());
        } else {
            sendOnNavigationButtonPressed(buttonOptions.f4200id);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
        peek().sendOnNavigationButtonPressed(str);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public Collection<ViewController<?>> getChildControllers() {
        return this.stack.values();
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void setupTopTabsWithViewPager(ViewPager viewPager) {
        this.topBarController.initTopTabs(viewPager);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public void clearTopTabs() {
        this.topBarController.clearTopTabs();
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.views.BehaviourAdapter
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, final View view) {
        ObjectUtils.perform(findController(viewGroup), new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.stack.StackController$$ExternalSyntheticLambda0
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                this.f$0.lambda$onDependentViewChanged$7(view, (ViewController) obj);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDependentViewChanged$7(View view, ViewController viewController) {
        if (view instanceof TopBar) {
            this.presenter.applyTopInsets(this, viewController);
        }
        if ((view instanceof Fab) || (view instanceof FabMenu)) {
            CoordinatorLayoutUtils.updateBottomMargin(view, getBottomInset());
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public int getTopInset(ViewController<?> viewController) {
        return this.presenter.getTopInset(resolveChildOptions(viewController));
    }

    public TopBar getTopBar() {
        return this.topBarController.getView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackLayout getStackLayout() {
        return (StackLayout) getView();
    }

    public void setView(StackLayout stackLayout) {
        this.view = stackLayout;
    }
}
