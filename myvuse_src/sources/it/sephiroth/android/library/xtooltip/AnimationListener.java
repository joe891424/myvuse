package it.sephiroth.android.library.xtooltip;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\r\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J)\u0010\u000f\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J)\u0010\u0010\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J)\u0010\u0011\u001a\u00020\t2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/AnimationListener;", "Landroid/animation/Animator$AnimatorListener;", "()V", "_onAnimationCancel", "Lkotlin/Function1;", "Landroid/animation/Animator;", "Lkotlin/ParameterName;", "name", "animation", "", "_onAnimationEnd", "_onAnimationRepeat", "_onAnimationStart", "onAnimationCancel", "func", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class AnimationListener implements Animator.AnimatorListener {
    private Function1<? super Animator, Unit> _onAnimationCancel;
    private Function1<? super Animator, Unit> _onAnimationEnd;
    private Function1<? super Animator, Unit> _onAnimationRepeat;
    private Function1<? super Animator, Unit> _onAnimationStart;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        Function1<? super Animator, Unit> function1 = this._onAnimationRepeat;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        Function1<? super Animator, Unit> function1 = this._onAnimationCancel;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        Function1<? super Animator, Unit> function1 = this._onAnimationEnd;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        Function1<? super Animator, Unit> function1 = this._onAnimationStart;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    public final void onAnimationRepeat(Function1<? super Animator, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onAnimationRepeat = func;
    }

    public final void onAnimationCancel(Function1<? super Animator, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onAnimationCancel = func;
    }

    public final void onAnimationEnd(Function1<? super Animator, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onAnimationEnd = func;
    }

    public final void onAnimationStart(Function1<? super Animator, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onAnimationStart = func;
    }
}
