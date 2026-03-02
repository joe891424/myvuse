package com.reactnativenavigation.views.stack;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.reactnativenavigation.views.BehaviourAdapter;
import com.reactnativenavigation.views.BehaviourDelegate;
import com.reactnativenavigation.views.stack.fab.Fab;
import com.reactnativenavigation.views.stack.fab.FabMenu;
import com.reactnativenavigation.views.stack.topbar.TopBar;

/* JADX INFO: loaded from: classes6.dex */
public class StackBehaviour extends BehaviourDelegate {
    public StackBehaviour(BehaviourAdapter behaviourAdapter) {
        super(behaviourAdapter);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, View view) {
        return (view instanceof TopBar) || (view instanceof Fab) || (view instanceof FabMenu);
    }
}
