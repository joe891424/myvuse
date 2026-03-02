package com.reactnativenavigation.viewcontrollers.stack.topbar;

import com.reactnativenavigation.views.animations.BaseViewAnimator;
import com.reactnativenavigation.views.stack.topbar.TopBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TopBarAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/stack/topbar/TopBarAnimator;", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator;", "Lcom/reactnativenavigation/views/stack/topbar/TopBar;", "view", "(Lcom/reactnativenavigation/views/stack/topbar/TopBar;)V", "hideOnScroll", "", "translationStart", "", "translationEndDy", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class TopBarAnimator extends BaseViewAnimator<TopBar> {
    /* JADX WARN: Multi-variable type inference failed */
    public TopBarAnimator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void hideOnScroll(float translationStart, float translationEndDy) {
    }

    public TopBarAnimator(TopBar topBar) {
        super(BaseViewAnimator.HideDirection.f4208Up, topBar, null, 4, null);
    }

    public /* synthetic */ TopBarAnimator(TopBar topBar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : topBar);
    }
}
