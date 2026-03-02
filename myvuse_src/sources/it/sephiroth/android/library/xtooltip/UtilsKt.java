package it.sephiroth.android.library.xtooltip;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0080\b\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0080\b\u001a&\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0080\b¨\u0006\u0010"}, m5598d2 = {"addOnAttachStateChangeListener", "Landroid/view/View;", "func", "Lkotlin/Function1;", "Lit/sephiroth/android/library/xtooltip/AttachStateChangeListener;", "", "Lkotlin/ExtensionFunctionType;", "rectContainsWithTolerance", "", "Landroid/graphics/Rect;", "childRect", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "", "setListener", "Landroid/view/ViewPropertyAnimator;", "Lit/sephiroth/android/library/xtooltip/AnimationListener;", "xtooltip_release"}, m5599k = 2, m5600mv = {1, 1, 13})
public final class UtilsKt {
    public static final boolean rectContainsWithTolerance(Rect receiver$0, Rect childRect, int i) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(childRect, "childRect");
        return receiver$0.contains(childRect.left + i, childRect.top + i, childRect.right - i, childRect.bottom - i);
    }

    public static final View addOnAttachStateChangeListener(View receiver$0, Function1<? super AttachStateChangeListener, Unit> func) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(func, "func");
        AttachStateChangeListener attachStateChangeListener = new AttachStateChangeListener();
        func.invoke(attachStateChangeListener);
        receiver$0.addOnAttachStateChangeListener(attachStateChangeListener);
        return receiver$0;
    }

    public static final ViewPropertyAnimator setListener(ViewPropertyAnimator receiver$0, Function1<? super AnimationListener, Unit> func) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(func, "func");
        AnimationListener animationListener = new AnimationListener();
        func.invoke(animationListener);
        receiver$0.setListener(animationListener);
        return receiver$0;
    }
}
