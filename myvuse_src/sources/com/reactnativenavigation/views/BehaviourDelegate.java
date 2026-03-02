package com.reactnativenavigation.views;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes6.dex */
public class BehaviourDelegate extends CoordinatorLayout.Behavior<ViewGroup> {
    private BehaviourAdapter delegate;

    public BehaviourDelegate(BehaviourAdapter behaviourAdapter) {
        this.delegate = behaviourAdapter;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, View view) {
        return this.delegate.onDependentViewChanged(coordinatorLayout, viewGroup, view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        return this.delegate.onMeasureChild(coordinatorLayout, viewGroup, i, i2, i3, i4);
    }
}
