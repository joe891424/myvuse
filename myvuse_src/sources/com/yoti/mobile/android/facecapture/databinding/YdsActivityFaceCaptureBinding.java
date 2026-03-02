package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsActivityFaceCaptureBinding implements ViewBinding {
    public final FragmentContainerView faceCaptureNavigationFragment;
    private final ConstraintLayout rootView;

    private YdsActivityFaceCaptureBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.faceCaptureNavigationFragment = fragmentContainerView;
    }

    public static YdsActivityFaceCaptureBinding bind(View view) {
        int i = C4832R.id.faceCaptureNavigationFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
        if (fragmentContainerView != null) {
            return new YdsActivityFaceCaptureBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityFaceCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityFaceCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_activity_face_capture, viewGroup, false);
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
