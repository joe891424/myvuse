package com.reactnativenavigation.viewcontrollers.modal;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.options.ModalPresentationStyle;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.react.CommandListenerAdapter;
import com.reactnativenavigation.react.Constants;
import com.reactnativenavigation.react.events.EventEmitter;
import com.reactnativenavigation.utils.Functions;
import com.reactnativenavigation.utils.ObjectUtils;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.overlay.ModalOverlay;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ModalStack {
    private EventEmitter eventEmitter;
    private final List<ViewController<?>> modals = new ArrayList();
    private final ModalOverlay overlay;
    private final ModalPresenter presenter;

    public void setEventEmitter(EventEmitter eventEmitter) {
        this.eventEmitter = eventEmitter;
    }

    public ModalStack(Context context) {
        this.presenter = new ModalPresenter(new ModalAnimator(context));
        this.overlay = new ModalOverlay(context);
    }

    ModalStack(Context context, ModalPresenter modalPresenter) {
        this.presenter = modalPresenter;
        this.overlay = new ModalOverlay(context);
    }

    public void setModalsLayout(CoordinatorLayout coordinatorLayout) {
        this.presenter.setModalsLayout(coordinatorLayout);
        this.overlay.setModalsLayout(coordinatorLayout);
    }

    public void setRootLayout(ViewGroup viewGroup) {
        this.presenter.setRootLayout(viewGroup);
    }

    public void setDefaultOptions(Options options) {
        this.presenter.setDefaultOptions(options);
    }

    public void showModal(ViewController<?> viewController, ViewController<?> viewController2, CommandListener commandListener) {
        if (!isEmpty()) {
            viewController2 = peek();
        }
        this.modals.add(viewController);
        viewController.setOverlay(this.overlay);
        this.presenter.showModal(viewController, viewController2, commandListener);
    }

    public boolean dismissModal(String str, ViewController<?> viewController, CommandListener commandListener) {
        final ViewController<?> viewControllerFindModalByComponentId = findModalByComponentId(str);
        if (viewControllerFindModalByComponentId != null) {
            boolean zIsTop = isTop(viewControllerFindModalByComponentId);
            this.modals.remove(viewControllerFindModalByComponentId);
            ViewController<?> viewController2 = isEmpty() ? viewController : zIsTop ? get(size() - 1) : null;
            if (zIsTop && viewController2 == null) {
                commandListener.onError("Could not dismiss modal");
                return false;
            }
            this.presenter.dismissModal(viewControllerFindModalByComponentId, viewController2, viewController, new CommandListenerAdapter(commandListener) { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalStack.1
                @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
                public void onSuccess(String str2) {
                    ModalStack.this.eventEmitter.emitModalDismissed(viewControllerFindModalByComponentId.getId(), viewControllerFindModalByComponentId.getCurrentComponentName(), 1);
                    super.onSuccess(viewControllerFindModalByComponentId.getId());
                }
            });
            return true;
        }
        commandListener.onError("Nothing to dismiss");
        return false;
    }

    public void dismissAllModals(ViewController<?> viewController, Options options, CommandListener commandListener) {
        if (this.modals.isEmpty()) {
            commandListener.onSuccess((String) ObjectUtils.perform(viewController, "", new Functions.FuncR1() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalStack$$ExternalSyntheticLambda0
                @Override // com.reactnativenavigation.utils.Functions.FuncR1
                public final Object run(Object obj) {
                    return ((ViewController) obj).getId();
                }
            }));
            return;
        }
        final String id = peek().getId();
        final String currentComponentName = peek().getCurrentComponentName();
        final int size = size();
        peek().mergeOptions(options);
        while (!this.modals.isEmpty()) {
            if (this.modals.size() == 1) {
                dismissModal(this.modals.get(0).getId(), viewController, new CommandListenerAdapter(commandListener) { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalStack.2
                    @Override // com.reactnativenavigation.react.CommandListenerAdapter, com.reactnativenavigation.react.CommandListener
                    public void onSuccess(String str) {
                        ModalStack.this.eventEmitter.emitModalDismissed(id, currentComponentName, size);
                        super.onSuccess(str);
                    }
                });
            } else {
                this.modals.get(0).destroy();
                this.modals.remove(0);
            }
        }
    }

    public boolean handleBack(CommandListener commandListener, ViewController<?> viewController) {
        if (isEmpty()) {
            return false;
        }
        if (peek().handleBack(commandListener)) {
            return true;
        }
        if (this.presenter.shouldDismissModal(peek())) {
            return dismissModal(peek().getId(), viewController, commandListener);
        }
        peek().sendOnNavigationButtonPressed(Constants.HARDWARE_BACK_BUTTON_ID);
        return true;
    }

    ViewController<?> peek() {
        if (this.modals.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.modals.get(r0.size() - 1);
    }

    public ViewController<?> get(int i) {
        return this.modals.get(i);
    }

    public boolean isEmpty() {
        return this.modals.isEmpty();
    }

    public int size() {
        return this.modals.size();
    }

    private boolean isTop(ViewController<?> viewController) {
        return !isEmpty() && peek().equals(viewController);
    }

    private ViewController<?> findModalByComponentId(String str) {
        for (ViewController<?> viewController : this.modals) {
            if (viewController.findController(str) != null) {
                return viewController;
            }
        }
        return null;
    }

    public ViewController<?> findControllerById(String str) {
        Iterator<ViewController<?>> it2 = this.modals.iterator();
        while (it2.hasNext()) {
            ViewController<?> viewControllerFindController = it2.next().findController(str);
            if (viewControllerFindController != null) {
                return viewControllerFindController;
            }
        }
        return null;
    }

    public void destroy() {
        Iterator<ViewController<?>> it2 = this.modals.iterator();
        while (it2.hasNext()) {
            it2.next().destroy();
        }
        this.modals.clear();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Iterator<ViewController<?>> it2 = this.modals.iterator();
        while (it2.hasNext()) {
            it2.next().onConfigurationChanged(configuration);
        }
    }

    public void onHostPause() {
        if (isEmpty()) {
            return;
        }
        peek().onViewDisappear();
    }

    public void onHostResume() {
        if (isEmpty()) {
            return;
        }
        peek().onViewDidAppear();
    }

    public boolean peekDisplayedOverCurrentContext() {
        return !isEmpty() && this.presenter.resolveOptions(peek()).modal.presentationStyle == ModalPresentationStyle.OverCurrentContext;
    }
}
