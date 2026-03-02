package com.reactnativenavigation.views.stack;

import android.content.Context;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.stack.topbar.TopBarController;
import com.reactnativenavigation.views.component.Component;
import com.reactnativenavigation.views.component.Renderable;
import com.reactnativenavigation.views.stack.topbar.ScrollDIsabledBehavior;

/* JADX INFO: loaded from: classes6.dex */
public class StackLayout extends CoordinatorLayout implements Component {
    private String stackId;

    public StackLayout(Context context, TopBarController topBarController, String str) {
        super(context);
        this.stackId = str;
        createLayout(topBarController);
    }

    private void createLayout(TopBarController topBarController) {
        View viewCreateView = topBarController.createView(getContext(), this);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, UiUtils.getTopBarHeight(getContext()));
        layoutParams.setBehavior(new ScrollDIsabledBehavior());
        addView(viewCreateView, layoutParams);
    }

    public String getStackId() {
        return this.stackId;
    }

    @Override // com.reactnativenavigation.views.component.Renderable
    public boolean isRendered() {
        return getChildCount() >= 2 && (getChildAt(1) instanceof Renderable) && ((Renderable) getChildAt(1)).isRendered();
    }
}
