package com.yoti.mobile.android.liveness.zoom.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.liveness.zoom.C4888R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentLivenessFacetecCaptureBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private YdsFragmentLivenessFacetecCaptureBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public static YdsFragmentLivenessFacetecCaptureBinding bind(View view) {
        if (view != null) {
            return new YdsFragmentLivenessFacetecCaptureBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static YdsFragmentLivenessFacetecCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentLivenessFacetecCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4888R.layout.yds_fragment_liveness_facetec_capture, viewGroup, false);
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
