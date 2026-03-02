package com.reactnativenavigation.views.bottomtabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes6.dex */
public class BottomTabsLayout extends CoordinatorLayout {
    private BottomTabsContainer bottomTabsContainer;

    public BottomTabsLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        BottomTabsContainer bottomTabsContainer = this.bottomTabsContainer;
        if (bottomTabsContainer != null && view != bottomTabsContainer) {
            super.addView(view, getChildCount() - 1, layoutParams);
        } else {
            super.addView(view, 0, layoutParams);
        }
    }

    public void addBottomTabsContainer(BottomTabsContainer bottomTabsContainer) {
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        addView(bottomTabsContainer, layoutParams);
        this.bottomTabsContainer = bottomTabsContainer;
    }
}
