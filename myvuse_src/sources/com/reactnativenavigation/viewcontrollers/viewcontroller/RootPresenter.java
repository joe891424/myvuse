package com.reactnativenavigation.viewcontrollers.viewcontroller;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.ReactInstanceManager;
import com.reactnativenavigation.hierarchy.root.RootAnimator;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.options.Options;
import com.reactnativenavigation.react.CommandListener;
import com.reactnativenavigation.utils.CoordinatorLayoutUtils;
import com.reactnativenavigation.views.BehaviourDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class RootPresenter {
    private final RootAnimator animator;
    private final LayoutDirectionApplier layoutDirectionApplier;
    private CoordinatorLayout rootLayout;

    public void setRootContainer(CoordinatorLayout coordinatorLayout) {
        this.rootLayout = coordinatorLayout;
    }

    public RootPresenter() {
        this(new RootAnimator(), new LayoutDirectionApplier());
    }

    public RootPresenter(RootAnimator rootAnimator, LayoutDirectionApplier layoutDirectionApplier) {
        this.animator = rootAnimator;
        this.layoutDirectionApplier = layoutDirectionApplier;
    }

    public void setRoot(final ViewController viewController, final ViewController<?> viewController2, Options options, final CommandListener commandListener, ReactInstanceManager reactInstanceManager) {
        this.layoutDirectionApplier.apply(viewController, options, reactInstanceManager);
        this.rootLayout.addView(viewController.getView(), CoordinatorLayoutUtils.matchParentWithBehaviour(new BehaviourDelegate(viewController)));
        final Options optionsResolveCurrentOptions = viewController.resolveCurrentOptions(options);
        AnimationOptions enter = optionsResolveCurrentOptions.animations.setRoot.getEnter();
        viewController.setWaitForRender(enter.waitForRender);
        if (enter.waitForRender.isTrue()) {
            viewController.getView().setAlpha(0.0f);
            viewController.addOnAppearedListener(new Runnable() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.RootPresenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setRoot$0(viewController, commandListener, viewController2, optionsResolveCurrentOptions);
                }
            });
        } else {
            animateSetRootAndReportSuccess(viewController, viewController2, commandListener, optionsResolveCurrentOptions);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRoot$0(ViewController viewController, CommandListener commandListener, ViewController viewController2, Options options) {
        if (viewController.isDestroyed()) {
            commandListener.onError("Could not set root - Waited for the view to become visible but it was destroyed");
        } else {
            viewController.getView().setAlpha(1.0f);
            animateSetRootAndReportSuccess(viewController, viewController2, commandListener, options);
        }
    }

    private void animateSetRootAndReportSuccess(final ViewController viewController, ViewController viewController2, final CommandListener commandListener, Options options) {
        AnimationOptions exit = options.animations.setRoot.getExit();
        AnimationOptions enter = options.animations.setRoot.getEnter();
        if ((enter.enabled.isTrueOrUndefined() && enter.hasAnimation()) || (viewController2 != null && exit.enabled.isTrueOrUndefined() && exit.hasAnimation())) {
            this.animator.setRoot(viewController, viewController2, options.animations.setRoot, new Function0() { // from class: com.reactnativenavigation.viewcontrollers.viewcontroller.RootPresenter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RootPresenter.lambda$animateSetRootAndReportSuccess$1(commandListener, viewController);
                }
            });
        } else {
            commandListener.onSuccess(viewController.getId());
        }
    }

    static /* synthetic */ Unit lambda$animateSetRootAndReportSuccess$1(CommandListener commandListener, ViewController viewController) {
        commandListener.onSuccess(viewController.getId());
        return Unit.INSTANCE;
    }
}
