package com.yoti.mobile.android.common.p049ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class YotiRadioGroup extends LinearLayout {

    /* JADX INFO: renamed from: a */
    private int f6254a;

    /* JADX INFO: renamed from: b */
    private OnCheckedChangeListener f6255b;

    /* JADX INFO: renamed from: c */
    private ViewGroupOnHierarchyChangeListenerC4534b f6256c;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(YotiRadioGroup yotiRadioGroup, int i);
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.common.ui.widgets.YotiRadioGroup$b */
    private class ViewGroupOnHierarchyChangeListenerC4534b implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a */
        private ViewGroup.OnHierarchyChangeListener f6257a;

        private ViewGroupOnHierarchyChangeListenerC4534b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == YotiRadioGroup.this && (view2 instanceof YotiRadioButton) && view2.getId() == -1) {
                view2.setId(View.generateViewId());
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f6257a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f6257a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public YotiRadioGroup(Context context) {
        super(context);
        this.f6254a = -1;
        setOrientation(1);
        m4580c();
    }

    public YotiRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6254a = -1;
        setOrientation(1);
        m4580c();
    }

    /* JADX INFO: renamed from: a */
    private void m4576a() {
        if (m4579b()) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof YotiRadioButton) {
                    ((YotiRadioButton) childAt).bindForAccessibility(i + 1, getChildCount());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4577a(int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof YotiRadioButton) {
            ((YotiRadioButton) viewFindViewById).setChecked(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m4578a(boolean z) {
        if (z) {
            m4576a();
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m4579b() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: renamed from: c */
    private void m4580c() {
        ViewGroupOnHierarchyChangeListenerC4534b viewGroupOnHierarchyChangeListenerC4534b = new ViewGroupOnHierarchyChangeListenerC4534b();
        this.f6256c = viewGroupOnHierarchyChangeListenerC4534b;
        super.setOnHierarchyChangeListener(viewGroupOnHierarchyChangeListenerC4534b);
        m4581d();
    }

    /* JADX INFO: renamed from: d */
    private void m4581d() {
        ((AccessibilityManager) getContext().getSystemService("accessibility")).addTouchExplorationStateChangeListener(new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.yoti.mobile.android.common.ui.widgets.YotiRadioGroup$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                this.f$0.m4578a(z);
            }
        });
    }

    private void setCheckedId(int i) {
        this.f6254a = i;
        OnCheckedChangeListener onCheckedChangeListener = this.f6255b;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, i);
        }
    }

    public void check(int i) {
        if (i == -1 || i != this.f6254a) {
            int i2 = this.f6254a;
            if (i2 != -1) {
                m4577a(i2, false);
            }
            if (i != -1) {
                m4577a(i, true);
            }
            setCheckedId(i);
        }
    }

    public void clearCheck() {
        check(-1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return YotiRadioGroup.class.getName();
    }

    public int getCheckedRadioButtonId() {
        return this.f6254a;
    }

    public int getCheckedRadioButtonIndex() {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i).getId() == getCheckedRadioButtonId()) {
                return i;
            }
        }
        return -1;
    }

    public void onChildCheckedChanged(YotiRadioButton yotiRadioButton, boolean z) {
        if (z) {
            check(yotiRadioButton.getId());
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f6254a;
        if (i != -1) {
            m4577a(i, true);
            setCheckedId(this.f6254a);
        }
        m4576a();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f6255b = onCheckedChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f6256c.f6257a = onHierarchyChangeListener;
    }
}
