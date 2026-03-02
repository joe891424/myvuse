package it.sephiroth.android.library.xtooltip;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\f\u001a\u00020\n28\u0010\r\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J\u0012\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J@\u0010\u000f\u001a\u00020\n28\u0010\r\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016RB\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lit/sephiroth/android/library/xtooltip/AttachStateChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "_onViewAttachedToWindow", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "_onViewDetachedFromWindow", "onViewAttachedToWindow", "func", "v", "onViewDetachedFromWindow", "xtooltip_release"}, m5599k = 1, m5600mv = {1, 1, 13})
public final class AttachStateChangeListener implements View.OnAttachStateChangeListener {
    private Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> _onViewAttachedToWindow;
    private Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> _onViewDetachedFromWindow;

    public final void onViewDetachedFromWindow(Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onViewDetachedFromWindow = func;
    }

    public final void onViewAttachedToWindow(Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "func");
        this._onViewAttachedToWindow = func;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2 = this._onViewDetachedFromWindow;
        if (function2 != null) {
            function2.invoke(v, this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2 = this._onViewAttachedToWindow;
        if (function2 != null) {
            function2.invoke(v, this);
        }
    }
}
