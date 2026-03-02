package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentFaceCaptureReviewBinding implements ViewBinding {
    public final YdsFragmentFaceCaptureReviewLoadingBinding layoutCaptureReviewLoading;
    public final YdsFragmentFaceCaptureReviewSuccessBinding layoutCaptureReviewSuccess;
    private final ConstraintLayout rootView;

    private YdsFragmentFaceCaptureReviewBinding(ConstraintLayout constraintLayout, YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBinding, YdsFragmentFaceCaptureReviewSuccessBinding ydsFragmentFaceCaptureReviewSuccessBinding) {
        this.rootView = constraintLayout;
        this.layoutCaptureReviewLoading = ydsFragmentFaceCaptureReviewLoadingBinding;
        this.layoutCaptureReviewSuccess = ydsFragmentFaceCaptureReviewSuccessBinding;
    }

    public static YdsFragmentFaceCaptureReviewBinding bind(View view) {
        int i = C4832R.id.layoutCaptureReviewLoading;
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById != null) {
            YdsFragmentFaceCaptureReviewLoadingBinding ydsFragmentFaceCaptureReviewLoadingBindingBind = YdsFragmentFaceCaptureReviewLoadingBinding.bind(viewFindViewById);
            int i2 = C4832R.id.layoutCaptureReviewSuccess;
            View viewFindViewById2 = view.findViewById(i2);
            if (viewFindViewById2 != null) {
                return new YdsFragmentFaceCaptureReviewBinding((ConstraintLayout) view, ydsFragmentFaceCaptureReviewLoadingBindingBind, YdsFragmentFaceCaptureReviewSuccessBinding.bind(viewFindViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentFaceCaptureReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentFaceCaptureReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_fragment_face_capture_review, viewGroup, false);
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
