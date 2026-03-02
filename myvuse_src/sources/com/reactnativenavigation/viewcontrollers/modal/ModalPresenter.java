package com.reactnativenavigation.viewcontrollers.modal;

import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.ModalPresentationStyle;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.utils.ScreenAnimationListener;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;

/* JADX INFO: loaded from: classes6.dex */
public class ModalPresenter {
    private Options defaultOptions = new Options();
    private final ModalAnimator modalAnimator;
    private CoordinatorLayout modalsLayout;
    private ViewGroup rootLayout;

    ModalPresenter(ModalAnimator modalAnimator) {
        this.modalAnimator = modalAnimator;
    }

    void setRootLayout(ViewGroup viewGroup) {
        this.rootLayout = viewGroup;
    }

    void setModalsLayout(CoordinatorLayout coordinatorLayout) {
        this.modalsLayout = coordinatorLayout;
    }

    public void setDefaultOptions(Options options) {
        this.defaultOptions = options;
    }

    void showModal(final ViewController<?> viewController, final ViewController<?> viewController2, final CommandListener commandListener) {
        if (this.modalsLayout == null) {
            commandListener.onError("Can not show modal before activity is created");
            return;
        }
        final Options optionsResolveCurrentOptions = viewController.resolveCurrentOptions(this.defaultOptions);
        AnimationOptions enter = optionsResolveCurrentOptions.animations.showModal.getEnter();
        viewController.setWaitForRender(enter.waitForRender);
        this.modalsLayout.setVisibility(0);
        this.modalsLayout.addView(viewController.getView(), CoordinatorLayoutUtils.matchParentLP());
        if (enter.enabled.isTrueOrUndefined()) {
            if (enter.shouldWaitForRender().isTrue()) {
                viewController.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalPresenter$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$showModal$0(viewController, viewController2, optionsResolveCurrentOptions, commandListener);
                    }
                });
                return;
            } else {
                this.modalAnimator.show(viewController, viewController2, optionsResolveCurrentOptions.animations.showModal, createListener(viewController, viewController2, commandListener));
                return;
            }
        }
        if (enter.waitForRender.isTrue()) {
            viewController.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalPresenter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showModal$1(viewController, viewController2, commandListener);
                }
            });
        } else {
            lambda$showModal$1(viewController, viewController2, commandListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showModal$0(ViewController viewController, ViewController viewController2, Options options, CommandListener commandListener) {
        this.modalAnimator.show(viewController, viewController2, options.animations.showModal, createListener(viewController, viewController2, commandListener));
    }

    private ScreenAnimationListener createListener(final ViewController<?> viewController, final ViewController<?> viewController2, final CommandListener commandListener) {
        return new ScreenAnimationListener() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalPresenter.1
            @Override // com.reactnativenavigation.utils.ScreenAnimationListener
            public void onStart() {
                viewController.getView().setAlpha(1.0f);
            }

            @Override // com.reactnativenavigation.utils.ScreenAnimationListener
            public void onEnd() {
                ModalPresenter.this.lambda$showModal$1(viewController, viewController2, commandListener);
            }

            @Override // com.reactnativenavigation.utils.ScreenAnimationListener
            public void onCancel() {
                commandListener.onSuccess(viewController.getId());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onShowModalEnd, reason: merged with bridge method [inline-methods] */
    public void lambda$showModal$1(ViewController<?> viewController, ViewController<?> viewController2, CommandListener commandListener) {
        viewController.onViewDidAppear();
        if (viewController2 != null && viewController.resolveCurrentOptions(this.defaultOptions).modal.presentationStyle != ModalPresentationStyle.OverCurrentContext) {
            viewController2.detachView();
        }
        commandListener.onSuccess(viewController.getId());
    }

    void dismissModal(final ViewController<?> viewController, ViewController<?> viewController2, ViewController<?> viewController3, final CommandListener commandListener) {
        ViewGroup viewGroup = this.modalsLayout;
        if (viewGroup == null) {
            commandListener.onError("Can not dismiss modal before activity is created");
            return;
        }
        if (viewController2 != null) {
            if (viewController2 == viewController3) {
                viewGroup = this.rootLayout;
            }
            viewController2.attachView(viewGroup, 0);
            viewController2.onViewDidAppear();
        }
        Options optionsResolveCurrentOptions = viewController.resolveCurrentOptions(this.defaultOptions);
        if (optionsResolveCurrentOptions.animations.dismissModal.getExit().enabled.isTrueOrUndefined()) {
            this.modalAnimator.dismiss(viewController2, viewController, optionsResolveCurrentOptions.animations.dismissModal, new ScreenAnimationListener() { // from class: com.reactnativenavigation.viewcontrollers.modal.ModalPresenter.2
                @Override // com.reactnativenavigation.utils.ScreenAnimationListener
                public void onEnd() {
                    ModalPresenter.this.onDismissEnd(viewController, commandListener);
                }
            });
        } else {
            onDismissEnd(viewController, commandListener);
        }
    }

    boolean shouldDismissModal(ViewController<?> viewController) {
        return viewController.resolveCurrentOptions(this.defaultOptions).hardwareBack.dismissModalOnPress.get(true).booleanValue();
    }

    public Options resolveOptions(ViewController<?> viewController) {
        return viewController.resolveCurrentOptions(this.defaultOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDismissEnd(ViewController<?> viewController, CommandListener commandListener) {
        commandListener.onSuccess(viewController.getId());
        viewController.destroy();
        if (isEmpty()) {
            this.modalsLayout.setVisibility(8);
        }
    }

    private boolean isEmpty() {
        return this.modalsLayout.getChildCount() == 0;
    }
}
