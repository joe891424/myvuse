package com.yoti.mobile.android.scan;

import android.view.animation.Animation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.android.scan.f */
/* JADX INFO: loaded from: classes4.dex */
public final class AnimationAnimationListenerC4940f implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ ScannerViewFragment f7425a;

    AnimationAnimationListenerC4940f(ScannerViewFragment scannerViewFragment) {
        this.f7425a = scannerViewFragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
        ScannerViewFragment.access$getFocusContainerView$p(this.f7425a).setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Intrinsics.checkParameterIsNotNull(animation, "animation");
    }
}
