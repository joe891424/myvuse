package com.reactnativenavigation.viewcontrollers.stack.topbar;

import android.view.ViewGroup;
import com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener;
import com.reactnativenavigation.views.animations.BaseViewAnimator;
import com.reactnativenavigation.views.stack.topbar.TopBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBarCollapseBehavior.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarCollapseBehavior;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ScrollEventListener$OnScrollListener;", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ScrollEventListener$OnDragListener;", "topBar", "Lcom/reactnativenavigation/views/stack/topbar/TopBar;", "(Lcom/reactnativenavigation/views/stack/topbar/TopBar;)V", "animator", "Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarAnimator;", "scrollEventListener", "Lcom/reactnativenavigation/viewcontrollers/viewcontroller/ScrollEventListener;", "disableCollapse", "", "enableCollapse", "onHide", "onScrollDown", "nextTranslation", "", "onScrollUp", "onShow", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TopBarCollapseBehavior implements ScrollEventListener.OnScrollListener, ScrollEventListener.OnDragListener {
    private final TopBarAnimator animator;
    private ScrollEventListener scrollEventListener;
    private final TopBar topBar;

    public TopBarCollapseBehavior(TopBar topBar) {
        Intrinsics.checkNotNullParameter(topBar, "topBar");
        this.topBar = topBar;
        this.animator = new TopBarAnimator(topBar);
    }

    public final void enableCollapse(ScrollEventListener scrollEventListener) {
        this.scrollEventListener = scrollEventListener;
        Intrinsics.checkNotNull(scrollEventListener);
        scrollEventListener.register(this.topBar, this, this);
    }

    public final void disableCollapse() {
        ScrollEventListener scrollEventListener = this.scrollEventListener;
        if (scrollEventListener != null) {
            Intrinsics.checkNotNull(scrollEventListener);
            scrollEventListener.unregister();
            this.topBar.setVisibility(0);
            this.topBar.setTranslationY(0.0f);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnScrollListener
    public void onScrollUp(float nextTranslation) {
        int measuredHeight = this.topBar.getMeasuredHeight();
        float f = -measuredHeight;
        if (nextTranslation < f && this.topBar.getVisibility() == 0) {
            this.topBar.setVisibility(8);
            this.topBar.setTranslationY(-measuredHeight);
        } else {
            if (nextTranslation <= f || nextTranslation > 0.0f) {
                return;
            }
            this.topBar.setTranslationY(nextTranslation);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnScrollListener
    public void onScrollDown(float nextTranslation) {
        int measuredHeight = this.topBar.getMeasuredHeight();
        if (this.topBar.getVisibility() == 8 && nextTranslation > (-measuredHeight)) {
            this.topBar.setVisibility(0);
            this.topBar.setTranslationY(nextTranslation);
        } else {
            if (nextTranslation > 0.0f || nextTranslation < (-measuredHeight)) {
                return;
            }
            this.topBar.setTranslationY(nextTranslation);
        }
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnDragListener
    public void onShow() {
        BaseViewAnimator.show$default(this.animator, null, this.topBar.getTranslationY(), 1, null);
    }

    @Override // com.reactnativenavigation.viewcontrollers.viewcontroller.ScrollEventListener.OnDragListener
    public void onHide() {
        TopBarAnimator topBarAnimator = this.animator;
        float translationY = this.topBar.getTranslationY();
        Intrinsics.checkNotNull(this.topBar.getLayoutParams(), "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        topBarAnimator.hideOnScroll(translationY, ((ViewGroup.MarginLayoutParams) r2).topMargin);
    }
}
