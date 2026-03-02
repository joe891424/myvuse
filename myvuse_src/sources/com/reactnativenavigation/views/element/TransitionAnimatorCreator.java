package com.reactnativenavigation.views.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewGroupManager;
import com.reactnativenavigation.C3967R;
import com.reactnativenavigation.options.AnimationOptions;
import com.reactnativenavigation.utils.ViewExtensionsKt;
import com.reactnativenavigation.utils.ViewTags;
import com.reactnativenavigation.utils.ViewUtils;
import com.reactnativenavigation.viewcontrollers.parent.ParentController;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransitionAnimatorCreator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\bH\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010%\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010+\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001b0-2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m5598d2 = {"Lcom/reactnativenavigation/views/element/TransitionAnimatorCreator;", "", "transitionSetCreator", "Lcom/reactnativenavigation/views/element/TransitionSetCreator;", "(Lcom/reactnativenavigation/views/element/TransitionSetCreator;)V", "addToOverlay", "", "vc", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "element", "Landroid/view/View;", "lp", "Landroid/widget/FrameLayout$LayoutParams;", "create", "Landroid/animation/AnimatorSet;", "animation", "Lcom/reactnativenavigation/options/LayoutAnimation;", "fadeAnimation", "Lcom/reactnativenavigation/options/AnimationOptions;", "fromScreen", "toScreen", "(Lcom/reactnativenavigation/options/LayoutAnimation;Lcom/reactnativenavigation/options/AnimationOptions;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnimator", "transitions", "Lcom/reactnativenavigation/views/element/TransitionSet;", "createElementTransitionAnimators", "", "Landroid/animation/Animator;", "Lcom/reactnativenavigation/views/element/ElementTransition;", "createSharedElementAnimator", "transition", "Lcom/reactnativenavigation/views/element/SharedElementTransition;", "createSharedElementTransitionAnimators", "getZIndex", "", "view", "recordIndices", "removeFromOverlay", "reparent", "Lcom/reactnativenavigation/views/element/Transition;", "reparentViews", "restoreViewsToOriginalState", "returnToOriginalParent", "setAnimatorsDuration", "animators", "", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public class TransitionAnimatorCreator {
    private final TransitionSetCreator transitionSetCreator;

    /* JADX INFO: renamed from: com.reactnativenavigation.views.element.TransitionAnimatorCreator$create$1 */
    /* JADX INFO: compiled from: TransitionAnimatorCreator.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 9, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.reactnativenavigation.views.element.TransitionAnimatorCreator", m5608f = "TransitionAnimatorCreator.kt", m5609i = {0, 0}, m5610l = {26}, m5611m = "create", m5612n = {"this", "fadeAnimation"}, m5613s = {"L$0", "L$1"})
    static final class C40131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C40131(Continuation<? super C40131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransitionAnimatorCreator.this.create(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionAnimatorCreator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TransitionAnimatorCreator(TransitionSetCreator transitionSetCreator) {
        Intrinsics.checkNotNullParameter(transitionSetCreator, "transitionSetCreator");
        this.transitionSetCreator = transitionSetCreator;
    }

    public /* synthetic */ TransitionAnimatorCreator(TransitionSetCreator transitionSetCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new TransitionSetCreator() : transitionSetCreator);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(com.reactnativenavigation.options.LayoutAnimation r5, com.reactnativenavigation.options.AnimationOptions r6, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r7, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController<?> r8, kotlin.coroutines.Continuation<? super android.animation.AnimatorSet> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.reactnativenavigation.views.element.TransitionAnimatorCreator.C40131
            if (r0 == 0) goto L14
            r0 = r9
            com.reactnativenavigation.views.element.TransitionAnimatorCreator$create$1 r0 = (com.reactnativenavigation.views.element.TransitionAnimatorCreator.C40131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.reactnativenavigation.views.element.TransitionAnimatorCreator$create$1 r0 = new com.reactnativenavigation.views.element.TransitionAnimatorCreator$create$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$1
            r6 = r5
            com.reactnativenavigation.options.AnimationOptions r6 = (com.reactnativenavigation.options.AnimationOptions) r6
            java.lang.Object r5 = r0.L$0
            com.reactnativenavigation.views.element.TransitionAnimatorCreator r5 = (com.reactnativenavigation.views.element.TransitionAnimatorCreator) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4e
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.reactnativenavigation.views.element.TransitionSetCreator r9 = r4.transitionSetCreator
            r0.L$0 = r4
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r9 = r9.create(r5, r7, r8, r0)
            if (r9 != r1) goto L4d
            return r1
        L4d:
            r5 = r4
        L4e:
            com.reactnativenavigation.views.element.TransitionSet r9 = (com.reactnativenavigation.views.element.TransitionSet) r9
            android.animation.AnimatorSet r5 = r5.createAnimator(r6, r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativenavigation.views.element.TransitionAnimatorCreator.create(com.reactnativenavigation.options.LayoutAnimation, com.reactnativenavigation.options.AnimationOptions, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AnimatorSet createAnimator(AnimationOptions fadeAnimation, final TransitionSet transitions) {
        recordIndices(transitions);
        reparentViews(transitions);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(createSharedElementTransitionAnimators(transitions.getValidSharedElementTransitions()));
        arrayList.addAll(createElementTransitionAnimators(transitions.getValidElementTransitions()));
        ArrayList arrayList2 = arrayList;
        setAnimatorsDuration(arrayList2, fadeAnimation);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList2);
        AnimatorSet animatorSet2 = animatorSet;
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$createAnimator$lambda$4$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                Iterator<T> it2 = transitions.getValidSharedElementTransitions().iterator();
                while (it2.hasNext()) {
                    ((SharedElementTransition) it2.next()).getView().setVisibility(0);
                }
            }
        });
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$createAnimator$lambda$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.this$0.restoreViewsToOriginalState(transitions);
            }
        });
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$createAnimator$lambda$4$$inlined$doOnCancel$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                this.this$0.restoreViewsToOriginalState(transitions);
            }
        });
        return animatorSet;
    }

    private final void recordIndices(TransitionSet transitions) {
        transitions.forEach(new Function1<Transition, Unit>() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator.recordIndices.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                invoke2(transition);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Transition it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                it2.getView().setTag(C3967R.id.original_index_in_parent, Integer.valueOf(ViewUtils.getIndexInParent(it2.getView())));
            }
        });
    }

    private final void setAnimatorsDuration(Collection<? extends Animator> animators, AnimationOptions fadeAnimation) {
        for (Animator animator : animators) {
            if (animator instanceof AnimatorSet) {
                ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
                Intrinsics.checkNotNullExpressionValue(childAnimations, "getChildAnimations(...)");
                setAnimatorsDuration(childAnimations, fadeAnimation);
            } else if (((int) animator.getDuration()) <= 0) {
                animator.setDuration(fadeAnimation.getDuration());
            }
        }
    }

    private final void reparentViews(TransitionSet transitions) {
        Iterator it2 = CollectionsKt.sortedWith(transitions.getTransitions(), new Comparator() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$reparentViews$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.getZIndex(((Transition) t).getView())), Integer.valueOf(this.this$0.getZIndex(((Transition) t2).getView())));
            }
        }).iterator();
        while (it2.hasNext()) {
            reparent((Transition) it2.next());
        }
        Iterator<T> it3 = transitions.getValidSharedElementTransitions().iterator();
        while (it3.hasNext()) {
            ((SharedElementTransition) it3.next()).getView().setVisibility(4);
        }
    }

    private final List<AnimatorSet> createSharedElementTransitionAnimators(List<SharedElementTransition> transitions) {
        ArrayList arrayList = new ArrayList();
        Iterator<SharedElementTransition> it2 = transitions.iterator();
        while (it2.hasNext()) {
            arrayList.add(createSharedElementAnimator(it2.next()));
        }
        return arrayList;
    }

    private final AnimatorSet createSharedElementAnimator(final SharedElementTransition transition) {
        AnimatorSet animatorSetCreateAnimators = transition.createAnimators();
        animatorSetCreateAnimators.addListener(new AnimatorListenerAdapter() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$createSharedElementAnimator$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                transition.getFrom().setAlpha(0.0f);
            }
        });
        return animatorSetCreateAnimators;
    }

    private final List<Animator> createElementTransitionAnimators(List<ElementTransition> transitions) {
        ArrayList arrayList = new ArrayList();
        Iterator<ElementTransition> it2 = transitions.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().createAnimators());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreViewsToOriginalState(TransitionSet transitions) {
        ArrayList<Transition> arrayList = new ArrayList();
        arrayList.addAll(transitions.getValidSharedElementTransitions());
        arrayList.addAll(transitions.getValidElementTransitions());
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$restoreViewsToOriginalState$lambda$12$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(this.this$0.getZIndex(((Transition) t).getView())), Integer.valueOf(this.this$0.getZIndex(((Transition) t2).getView())));
                }
            });
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.reactnativenavigation.views.element.TransitionAnimatorCreator$restoreViewsToOriginalState$lambda$12$$inlined$sortBy$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Object tag = ((Transition) t).getView().getTag(C3967R.id.original_index_in_parent);
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    Object tag2 = ((Transition) t2).getView().getTag(C3967R.id.original_index_in_parent);
                    Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.Int");
                    return ComparisonsKt.compareValues((Integer) tag, (Integer) tag2);
                }
            });
        }
        for (Transition transition : arrayList) {
            removeFromOverlay(transition.getViewController(), transition.getView());
            returnToOriginalParent(transition.getView());
        }
        Iterator<T> it2 = transitions.getValidSharedElementTransitions().iterator();
        while (it2.hasNext()) {
            ((SharedElementTransition) it2.next()).getFrom().setAlpha(1.0f);
        }
    }

    private final void reparent(Transition transition) {
        Point locationOnScreen = ViewUtils.getLocationOnScreen(transition.getView());
        ViewParent parent = transition.getView().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        transition.getView().setTag(C3967R.id.original_parent, viewGroup);
        transition.getView().setTag(C3967R.id.original_layout_params, transition.getView().getLayoutParams());
        transition.getView().setTag(C3967R.id.original_top, Integer.valueOf(transition.getView().getTop()));
        transition.getView().setTag(C3967R.id.original_bottom, Integer.valueOf(transition.getView().getBottom()));
        transition.getView().setTag(C3967R.id.original_right, Integer.valueOf(transition.getView().getRight()));
        transition.getView().setTag(C3967R.id.original_left, Integer.valueOf(transition.getView().getLeft()));
        transition.getView().setTag(C3967R.id.original_pivot_x, Float.valueOf(transition.getView().getPivotX()));
        transition.getView().setTag(C3967R.id.original_pivot_y, Float.valueOf(transition.getView().getPivotY()));
        transition.getView().setTag(C3967R.id.original_z_index, Integer.valueOf(getZIndex(transition.getView())));
        viewGroup.removeView(transition.getView());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(transition.getView().getLayoutParams());
        layoutParams.topMargin = locationOnScreen.y;
        layoutParams.leftMargin = locationOnScreen.x;
        layoutParams.gravity = 0;
        layoutParams.width = transition.getView().getWidth();
        layoutParams.height = transition.getView().getHeight();
        addToOverlay(transition.getViewController(), transition.getView(), layoutParams);
    }

    private final void returnToOriginalParent(View element) {
        ViewExtensionsKt.removeFromParent(element);
        Object obj = ViewTags.get(element, C3967R.id.original_top);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        element.setTop(((Number) obj).intValue());
        Object obj2 = ViewTags.get(element, C3967R.id.original_bottom);
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        element.setBottom(((Number) obj2).intValue());
        Object obj3 = ViewTags.get(element, C3967R.id.original_right);
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        element.setRight(((Number) obj3).intValue());
        Object obj4 = ViewTags.get(element, C3967R.id.original_left);
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        element.setLeft(((Number) obj4).intValue());
        Object obj5 = ViewTags.get(element, C3967R.id.original_pivot_x);
        Intrinsics.checkNotNullExpressionValue(obj5, "get(...)");
        element.setPivotX(((Number) obj5).floatValue());
        Object obj6 = ViewTags.get(element, C3967R.id.original_pivot_y);
        Intrinsics.checkNotNullExpressionValue(obj6, "get(...)");
        element.setPivotY(((Number) obj6).floatValue());
        Object obj7 = ViewTags.get(element, C3967R.id.original_parent);
        Intrinsics.checkNotNullExpressionValue(obj7, "get(...)");
        Object obj8 = ViewTags.get(element, C3967R.id.original_layout_params);
        Intrinsics.checkNotNullExpressionValue(obj8, "get(...)");
        Object obj9 = ViewTags.get(element, C3967R.id.original_index_in_parent);
        Intrinsics.checkNotNullExpressionValue(obj9, "get(...)");
        ((ViewGroup) obj7).addView(element, ((Number) obj9).intValue(), (ViewGroup.LayoutParams) obj8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getZIndex(View view) {
        int viewZIndex = ViewGroupManager.getViewZIndex(view);
        if (viewZIndex == null && (viewZIndex = (Integer) ViewTags.get(view, C3967R.id.original_z_index)) == null) {
            viewZIndex = 0;
        }
        return viewZIndex.intValue();
    }

    private final void addToOverlay(ViewController<?> vc, View element, FrameLayout.LayoutParams lp) {
        ParentController parentController = vc.getParentController();
        if (parentController != null) {
            vc = parentController;
        }
        vc.addOverlay(element, lp);
    }

    private final void removeFromOverlay(ViewController<?> vc, View element) {
        ParentController parentController = vc.getParentController();
        if (parentController != null) {
            vc = parentController;
        }
        vc.removeOverlay(element);
    }
}
