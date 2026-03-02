package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentSupDocumentReviewLoadingStateBinding implements ViewBinding {
    public final View imagePreviewLoading;
    public final HorizontalScrollingGradient loadingAnimation;
    public final HorizontalScrollingGradient loadingAnimationPoweredBy;
    public final YotiAppbar loadingAppBar;
    public final View loadingButtonLeft;
    public final View loadingButtonRight;
    public final View loadingPoweredBy;
    public final TextView loadingTitle;
    private final ConstraintLayout rootView;

    private YdsFragmentSupDocumentReviewLoadingStateBinding(ConstraintLayout constraintLayout, View view, HorizontalScrollingGradient horizontalScrollingGradient, HorizontalScrollingGradient horizontalScrollingGradient2, YotiAppbar yotiAppbar, View view2, View view3, View view4, TextView textView) {
        this.rootView = constraintLayout;
        this.imagePreviewLoading = view;
        this.loadingAnimation = horizontalScrollingGradient;
        this.loadingAnimationPoweredBy = horizontalScrollingGradient2;
        this.loadingAppBar = yotiAppbar;
        this.loadingButtonLeft = view2;
        this.loadingButtonRight = view3;
        this.loadingPoweredBy = view4;
        this.loadingTitle = textView;
    }

    public static YdsFragmentSupDocumentReviewLoadingStateBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        int i = C4653R.id.imagePreviewLoading;
        View viewFindViewById4 = view.findViewById(i);
        if (viewFindViewById4 != null) {
            i = C4653R.id.loadingAnimation;
            HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
            if (horizontalScrollingGradient != null) {
                i = C4653R.id.loadingAnimationPoweredBy;
                HorizontalScrollingGradient horizontalScrollingGradient2 = (HorizontalScrollingGradient) view.findViewById(i);
                if (horizontalScrollingGradient2 != null) {
                    i = C4653R.id.loadingAppBar;
                    YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
                    if (yotiAppbar != null && (viewFindViewById = view.findViewById((i = C4653R.id.loadingButtonLeft))) != null && (viewFindViewById2 = view.findViewById((i = C4653R.id.loadingButtonRight))) != null && (viewFindViewById3 = view.findViewById((i = C4653R.id.loadingPoweredBy))) != null) {
                        i = C4653R.id.loadingTitle;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            return new YdsFragmentSupDocumentReviewLoadingStateBinding((ConstraintLayout) view, viewFindViewById4, horizontalScrollingGradient, horizontalScrollingGradient2, yotiAppbar, viewFindViewById, viewFindViewById2, viewFindViewById3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentSupDocumentReviewLoadingStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentSupDocumentReviewLoadingStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_fragment_sup_document_review_loading_state, viewGroup, false);
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
