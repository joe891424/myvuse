package com.reactnativenavigation.viewcontrollers.navigator;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.CompatUtils;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.viewcontrollers.child.ChildControllersRegistry;
import com.reactnativenavigation.viewcontrollers.modal.ModalStack;
import com.reactnativenavigation.viewcontrollers.overlay.OverlayManager;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.stack.StackController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.Presenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.RootPresenter;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.RootOverlay;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Navigator extends ParentController<ViewGroup> {
    private ViewGroup contentLayout;
    private Options defaultOptions;
    private final ModalStack modalStack;
    private final CoordinatorLayout modalsLayout;
    private final OverlayManager overlayManager;
    private final CoordinatorLayout overlaysLayout;
    private ViewController<?> previousRoot;
    private ViewController<?> root;
    private final CoordinatorLayout rootLayout;
    private final RootPresenter rootPresenter;

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void sendOnNavigationButtonPressed(String str) {
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void setDefaultOptions(Options options) {
        super.setDefaultOptions(options);
        this.defaultOptions = options;
        this.modalStack.setDefaultOptions(options);
    }

    public Options getDefaultOptions() {
        return this.defaultOptions;
    }

    CoordinatorLayout getRootLayout() {
        return this.rootLayout;
    }

    public void setEventEmitter(EventEmitter eventEmitter) {
        this.modalStack.setEventEmitter(eventEmitter);
    }

    public void setContentLayout(ViewGroup viewGroup) {
        this.contentLayout = viewGroup;
        viewGroup.addView(this.rootLayout);
        this.modalsLayout.setVisibility(8);
        viewGroup.addView(this.modalsLayout);
        this.overlaysLayout.setVisibility(8);
        viewGroup.addView(this.overlaysLayout);
    }

    public Navigator(Activity activity, ChildControllersRegistry childControllersRegistry, ModalStack modalStack, OverlayManager overlayManager, RootPresenter rootPresenter) {
        super(activity, childControllersRegistry, "navigator" + CompatUtils.generateViewId(), new Presenter(activity, new Options()), new Options());
        this.defaultOptions = new Options();
        this.modalStack = modalStack;
        this.overlayManager = overlayManager;
        this.rootPresenter = rootPresenter;
        this.rootLayout = new CoordinatorLayout(getActivity());
        this.modalsLayout = new CoordinatorLayout(getActivity());
        this.overlaysLayout = new CoordinatorLayout(getActivity());
    }

    public void bindViews() {
        this.modalStack.setModalsLayout(this.modalsLayout);
        this.modalStack.setRootLayout(this.rootLayout);
        this.rootPresenter.setRootContainer(this.rootLayout);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ViewGroup createView() {
        return this.rootLayout;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public Collection<ViewController<?>> getChildControllers() {
        ViewController<?> viewController = this.root;
        return viewController == null ? Collections.emptyList() : Collections.singletonList(viewController);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public boolean handleBack(CommandListener commandListener) {
        if (this.modalStack.isEmpty() && this.root == null) {
            return false;
        }
        return this.modalStack.isEmpty() ? this.root.handleBack(commandListener) : this.modalStack.handleBack(commandListener, this.root);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController
    public ViewController<?> getCurrentChild() {
        return this.root;
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void destroy() {
        destroyViews();
        super.destroy();
    }

    public void destroyViews() {
        this.modalStack.destroy();
        this.overlayManager.destroy(this.overlaysLayout);
        destroyRoot();
    }

    private void destroyRoot() {
        ViewController<?> viewController = this.root;
        if (viewController != null) {
            viewController.destroy();
        }
        this.root = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyPreviousRoot() {
        ViewController<?> viewController = this.previousRoot;
        if (viewController != null) {
            viewController.destroy();
        }
        this.previousRoot = null;
    }

    public void setRoot(ViewController<?> viewController, CommandListener commandListener, ReactInstanceManager reactInstanceManager) {
        this.previousRoot = this.root;
        this.modalStack.destroy();
        final boolean zIsRootNotCreated = isRootNotCreated();
        if (isRootNotCreated()) {
            getView();
        }
        ViewController<?> viewController2 = this.previousRoot;
        this.root = viewController;
        viewController.setOverlay(new RootOverlay(getActivity(), this.contentLayout));
        this.root.setParentController(this);
        this.rootPresenter.setRoot(viewController, viewController2, this.defaultOptions, new CommandListenerAdapter(commandListener) { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator.1
            @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
            public void onSuccess(String str) {
                Navigator.this.root.onViewDidAppear();
                if (zIsRootNotCreated) {
                    Navigator.this.contentLayout.removeViewAt(0);
                }
                Navigator.this.destroyPreviousRoot();
                super.onSuccess(str);
            }
        }, reactInstanceManager);
    }

    public void mergeOptions(String str, Options options) {
        ViewController<?> viewControllerFindController = findController(str);
        if (viewControllerFindController != null) {
            viewControllerFindController.mergeOptions(options);
        }
    }

    public void push(String str, final ViewController<?> viewController, final CommandListener commandListener) {
        applyOnStack(str, commandListener, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator$$ExternalSyntheticLambda4
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((StackController) obj).push(viewController, commandListener);
            }
        });
    }

    public void setStackRoot(String str, final List<ViewController<?>> list, final CommandListener commandListener) {
        applyOnStack(str, commandListener, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator$$ExternalSyntheticLambda2
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((StackController) obj).setRoot(list, commandListener);
            }
        });
    }

    public void pop(String str, final Options options, final CommandListener commandListener) {
        applyOnStack(str, commandListener, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator$$ExternalSyntheticLambda3
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((StackController) obj).pop(options, commandListener);
            }
        });
    }

    public void popToRoot(String str, final Options options, final CommandListener commandListener) {
        applyOnStack(str, commandListener, new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator$$ExternalSyntheticLambda1
            @Override // com.reactnativenavigation.utils.Functions.Func1
            public final void run(Object obj) {
                ((StackController) obj).popToRoot(options, commandListener);
            }
        });
    }

    public void popTo(String str, final Options options, final CommandListener commandListener) {
        final ViewController<?> viewControllerFindController = findController(str);
        if (viewControllerFindController != null) {
            viewControllerFindController.performOnParentStack(new Functions.Func1() { // from class: com.reactnativenavigation.viewcontrollers.navigator.Navigator$$ExternalSyntheticLambda0
                @Override // com.reactnativenavigation.utils.Functions.Func1
                public final void run(Object obj) {
                    ((StackController) obj).popTo(viewControllerFindController, options, commandListener);
                }
            });
        } else {
            commandListener.onError("Failed to execute stack command. Stack by " + str + " not found.");
        }
    }

    public void showModal(ViewController<?> viewController, CommandListener commandListener) {
        this.modalStack.showModal(viewController, this.root, commandListener);
    }

    public void dismissModal(String str, CommandListener commandListener) {
        if (isRootNotCreated() && this.modalStack.size() == 1) {
            commandListener.onError("Can not dismiss modal if root is not set and only one modal is displayed.");
        } else {
            this.modalStack.dismissModal(str, this.root, commandListener);
        }
    }

    public void dismissAllModals(Options options, CommandListener commandListener) {
        this.modalStack.dismissAllModals(this.root, options, commandListener);
    }

    public void showOverlay(ViewController<?> viewController, CommandListener commandListener) {
        this.overlayManager.show(this.overlaysLayout, viewController, commandListener);
    }

    public void dismissOverlay(String str, CommandListener commandListener) {
        this.overlayManager.dismiss(this.overlaysLayout, str, commandListener);
    }

    public void dismissAllOverlays(CommandListener commandListener) {
        this.overlayManager.dismissAll(this.overlaysLayout, commandListener);
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public ViewController<?> findController(String str) {
        ViewController<?> viewControllerFindController = super.findController(str);
        if (viewControllerFindController == null) {
            viewControllerFindController = this.modalStack.findControllerById(str);
        }
        return viewControllerFindController == null ? this.overlayManager.findControllerById(str) : viewControllerFindController;
    }

    private void applyOnStack(String str, CommandListener commandListener, Functions.Func1<StackController> func1) {
        ViewController<?> viewControllerFindController = findController(str);
        if (viewControllerFindController != null) {
            if (viewControllerFindController instanceof StackController) {
                func1.run((StackController) viewControllerFindController);
                return;
            } else {
                viewControllerFindController.performOnParentStack(func1);
                return;
            }
        }
        commandListener.onError("Failed to execute stack command. Stack " + str + " not found.");
    }

    @Override // com.reactnativenavigation.viewcontrollers.parent.ParentController, com.reactnativenavigation.viewcontrollers.child.ChildController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController
    public void onConfigurationChanged(Configuration configuration) {
        this.modalStack.onConfigurationChanged(configuration);
        this.overlayManager.onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    private boolean isRootNotCreated() {
        return this.view == 0;
    }

    CoordinatorLayout getModalsLayout() {
        return this.modalsLayout;
    }

    CoordinatorLayout getOverlaysLayout() {
        return this.overlaysLayout;
    }

    public void onHostPause() {
        this.overlayManager.onHostPause();
        if (!this.modalStack.isEmpty()) {
            this.modalStack.onHostPause();
            if (this.modalStack.peekDisplayedOverCurrentContext()) {
                onViewDisappear();
                return;
            }
            return;
        }
        onViewDisappear();
    }

    public void onHostResume() {
        this.overlayManager.onHostResume();
        if (!this.modalStack.isEmpty()) {
            this.modalStack.onHostResume();
            if (this.modalStack.peekDisplayedOverCurrentContext()) {
                onViewDidAppear();
                return;
            }
            return;
        }
        onViewDidAppear();
    }
}
