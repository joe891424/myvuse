package com.yoti.mobile.android.facecapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.facecapture.C4832R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentFaceCaptureReviewSuccessBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonReviewCaptureNegative;
    public final YotiButton buttonReviewCapturePositive;
    public final CardView cardViewCaptureReview;
    public final ImageView imageViewCaptureReview;
    private final ConstraintLayout rootView;
    public final TextView textViewCaptureReviewTitle;

    private YdsFragmentFaceCaptureReviewSuccessBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, YotiButton yotiButton2, CardView cardView, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonReviewCaptureNegative = yotiButton;
        this.buttonReviewCapturePositive = yotiButton2;
        this.cardViewCaptureReview = cardView;
        this.imageViewCaptureReview = imageView;
        this.textViewCaptureReviewTitle = textView;
    }

    public static YdsFragmentFaceCaptureReviewSuccessBinding bind(View view) {
        int i = C4832R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4832R.id.buttonReviewCaptureNegative;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4832R.id.buttonReviewCapturePositive;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4832R.id.cardViewCaptureReview;
                    CardView cardView = (CardView) view.findViewById(i);
                    if (cardView != null) {
                        i = C4832R.id.imageViewCaptureReview;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = C4832R.id.textViewCaptureReviewTitle;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                return new YdsFragmentFaceCaptureReviewSuccessBinding((ConstraintLayout) view, yotiAppbar, yotiButton, yotiButton2, cardView, imageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentFaceCaptureReviewSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentFaceCaptureReviewSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4832R.layout.yds_fragment_face_capture_review_success, viewGroup, false);
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
