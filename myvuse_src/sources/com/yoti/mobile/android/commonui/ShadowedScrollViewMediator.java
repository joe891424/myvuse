package com.yoti.mobile.android.commonui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowedScrollViewMediator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/commonui/ShadowedScrollViewMediator;", "", "scrollView", "Landroid/view/View;", "shadowView", "(Landroid/view/View;Landroid/view/View;)V", "attach", "", "showShadow", "commonUI_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ShadowedScrollViewMediator {
    private final View scrollView;
    private final View shadowView;

    public ShadowedScrollViewMediator(View scrollView, View shadowView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(shadowView, "shadowView");
        this.scrollView = scrollView;
        this.shadowView = shadowView;
    }

    public final void attach() {
        this.scrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.commonui.ShadowedScrollViewMediator$attach$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Intrinsics.checkParameterIsNotNull(view, "view");
                view.removeOnLayoutChangeListener(this);
                ShadowedScrollViewMediator shadowedScrollViewMediator = this.this$0;
                shadowedScrollViewMediator.showShadow(shadowedScrollViewMediator.scrollView, this.this$0.shadowView);
            }
        });
        this.scrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yoti.mobile.android.commonui.ShadowedScrollViewMediator$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ShadowedScrollViewMediator.m6788attach$lambda1(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: attach$lambda-1, reason: not valid java name */
    public static final void m6788attach$lambda1(ShadowedScrollViewMediator this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showShadow(this$0.scrollView, this$0.shadowView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShadow(View scrollView, View shadowView) {
        shadowView.setVisibility((scrollView.canScrollVertically(1) || scrollView.canScrollVertically(-1)) ? 0 : 8);
    }
}
