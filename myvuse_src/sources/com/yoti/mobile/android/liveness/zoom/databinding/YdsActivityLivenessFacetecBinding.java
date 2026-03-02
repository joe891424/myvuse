package com.yoti.mobile.android.liveness.zoom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.liveness.zoom.C4888R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsActivityLivenessFacetecBinding implements ViewBinding {
    public final FragmentContainerView livenessNavigationFragment;
    private final ConstraintLayout rootView;

    private YdsActivityLivenessFacetecBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.livenessNavigationFragment = fragmentContainerView;
    }

    public static YdsActivityLivenessFacetecBinding bind(View view) {
        int i = C4888R.id.livenessNavigationFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
        if (fragmentContainerView != null) {
            return new YdsActivityLivenessFacetecBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityLivenessFacetecBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityLivenessFacetecBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4888R.layout.yds_activity_liveness_facetec, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
