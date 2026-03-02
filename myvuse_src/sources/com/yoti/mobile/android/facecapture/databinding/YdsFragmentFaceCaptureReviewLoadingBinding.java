package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentFaceCaptureReviewLoadingBinding implements ViewBinding {
    public final View buttonReviewCaptureNegativeLoading;
    public final View buttonReviewCapturePositiveLoading;
    public final HorizontalScrollingGradient loadingAnimation;
    public final YotiAppbar loadingAppBar;
    private final ConstraintLayout rootView;
    public final TextView textViewCaptureReviewTitleLoading;
    public final View viewCaptureReviewLoading;

    private YdsFragmentFaceCaptureReviewLoadingBinding(ConstraintLayout constraintLayout, View view, View view2, HorizontalScrollingGradient horizontalScrollingGradient, YotiAppbar yotiAppbar, TextView textView, View view3) {
        this.rootView = constraintLayout;
        this.buttonReviewCaptureNegativeLoading = view;
        this.buttonReviewCapturePositiveLoading = view2;
        this.loadingAnimation = horizontalScrollingGradient;
        this.loadingAppBar = yotiAppbar;
        this.textViewCaptureReviewTitleLoading = textView;
        this.viewCaptureReviewLoading = view3;
    }

    public static YdsFragmentFaceCaptureReviewLoadingBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        int i = C4832R.id.buttonReviewCaptureNegativeLoading;
        View viewFindViewById3 = view.findViewById(i);
        if (viewFindViewById3 != null && (viewFindViewById = view.findViewById((i = C4832R.id.buttonReviewCapturePositiveLoading))) != null) {
            i = C4832R.id.loadingAnimation;
            HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
            if (horizontalScrollingGradient != null) {
                i = C4832R.id.loadingAppBar;
                YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
                if (yotiAppbar != null) {
                    i = C4832R.id.textViewCaptureReviewTitleLoading;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null && (viewFindViewById2 = view.findViewById((i = C4832R.id.viewCaptureReviewLoading))) != null) {
                        return new YdsFragmentFaceCaptureReviewLoadingBinding((ConstraintLayout) view, viewFindViewById3, viewFindViewById, horizontalScrollingGradient, yotiAppbar, textView, viewFindViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentFaceCaptureReviewLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentFaceCaptureReviewLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_fragment_face_capture_review_loading, viewGroup, false);
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
