package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsActivityFaceCaptureTestBinding implements ViewBinding {
    public final FragmentContainerView livenessNavigationFragment;
    private final ConstraintLayout rootView;

    private YdsActivityFaceCaptureTestBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.livenessNavigationFragment = fragmentContainerView;
    }

    public static YdsActivityFaceCaptureTestBinding bind(View view) {
        int i = C4832R.id.livenessNavigationFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
        if (fragmentContainerView != null) {
            return new YdsActivityFaceCaptureTestBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityFaceCaptureTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityFaceCaptureTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_activity_face_capture_test, viewGroup, false);
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
