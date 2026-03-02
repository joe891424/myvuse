package com.reactnativenavigation.viewcontrollers.bottomtabs;

import com.reactnativenavigation.views.animations.BaseViewAnimator;
import com.reactnativenavigation.views.bottomtabs.BottomTabs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BottomTabsAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/reactnativenavigation/viewcontrollers/bottomtabs/BottomTabsAnimator;", "Lcom/reactnativenavigation/views/animations/BaseViewAnimator;", "Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;", "view", "(Lcom/reactnativenavigation/views/bottomtabs/BottomTabs;)V", "onHideAnimationEnd", "", "onShowAnimationEnd", "react-native-navigation_reactNative71Release"}, m5599k = 1, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class BottomTabsAnimator extends BaseViewAnimator<BottomTabs> {
    /* JADX WARN: Multi-variable type inference failed */
    public BottomTabsAnimator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BottomTabsAnimator(BottomTabs bottomTabs) {
        super(BaseViewAnimator.HideDirection.Down, bottomTabs, null, 4, null);
    }

    public /* synthetic */ BottomTabsAnimator(BottomTabs bottomTabs, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bottomTabs);
    }

    @Override // com.reactnativenavigation.views.animations.BaseViewAnimator
    public void onShowAnimationEnd() {
        getView().restoreBottomNavigation(false);
    }

    @Override // com.reactnativenavigation.views.animations.BaseViewAnimator
    public void onHideAnimationEnd() {
        getView().hideBottomNavigation(false);
    }
}
