package com.reactnativenavigation.views.element.finder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ViewController;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExistingViewFinder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012H\u0002J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012H\u0002J\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0016"}, m5598d2 = {"Lcom/reactnativenavigation/views/element/finder/ExistingViewFinder;", "Lcom/reactnativenavigation/views/element/finder/ViewFinder;", "()V", "checkIfFastImageIsMeasured", "", "view", "Landroid/widget/ImageView;", "find", "Landroid/view/View;", "root", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;", "nativeId", "", "(Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ViewController;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasMeasuredDrawable", "resume", "", "cont", "Lkotlin/coroutines/Continuation;", "resumeOnImageLoad", "isImageScaledToFit", "Landroid/graphics/drawable/Drawable;", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class ExistingViewFinder implements ViewFinder {
    @Override // com.reactnativenavigation.views.element.finder.ViewFinder
    public Object find(ViewController<?> viewController, String str, Continuation<? super View> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        View viewFindView = ReactFindViewUtil.findView(viewController.getView(), str);
        if (viewFindView == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m7233constructorimpl(null));
        } else if (viewFindView instanceof ImageView) {
            ImageView imageView = (ImageView) viewFindView;
            if (hasMeasuredDrawable(imageView)) {
                resume(imageView, safeContinuation2);
            } else {
                resumeOnImageLoad(imageView, safeContinuation2);
            }
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m7233constructorimpl(viewFindView));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void resume(final ImageView view, final Continuation<? super View> cont) {
        if (view.getDrawable() instanceof RootDrawable) {
            view.post(new Runnable() { // from class: com.reactnativenavigation.views.element.finder.ExistingViewFinder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExistingViewFinder.resume$lambda$1(cont, view);
                }
            });
        } else {
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m7233constructorimpl(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resume$lambda$1(Continuation cont, ImageView view) {
        Intrinsics.checkNotNullParameter(cont, "$cont");
        Intrinsics.checkNotNullParameter(view, "$view");
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m7233constructorimpl(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeOnImageLoad(final ImageView view, final Continuation<? super View> cont) {
        final ImageView imageView = view;
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(imageView, new Runnable() { // from class: com.reactnativenavigation.views.element.finder.ExistingViewFinder$resumeOnImageLoad$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                if (!this.hasMeasuredDrawable(view)) {
                    this.resumeOnImageLoad(view, cont);
                    return;
                }
                ImageView imageView2 = view;
                final Continuation continuation = cont;
                final ImageView imageView3 = view;
                imageView2.post(new Runnable() { // from class: com.reactnativenavigation.views.element.finder.ExistingViewFinder$resumeOnImageLoad$1$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Continuation<View> continuation2 = continuation;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m7233constructorimpl(imageView3));
                    }
                });
            }
        }), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasMeasuredDrawable(ImageView view) {
        if (view.getDrawable() instanceof RootDrawable) {
            return true;
        }
        return checkIfFastImageIsMeasured(view);
    }

    private final boolean checkIfFastImageIsMeasured(ImageView view) {
        Drawable drawable = view.getDrawable();
        return (drawable == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1 || !isImageScaledToFit(drawable, view)) ? false : true;
    }

    private final boolean isImageScaledToFit(Drawable drawable, ImageView imageView) {
        return Math.min(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight())) >= 1.0f;
    }
}
