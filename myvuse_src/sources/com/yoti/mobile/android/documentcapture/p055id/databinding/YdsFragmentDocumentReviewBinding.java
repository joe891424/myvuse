package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentReviewBinding implements ViewBinding {
    public final View dragIndicator;
    public final YdsFragmentIdDocumentGuidelinesBinding guidelines;
    public final YdsReviewScreenBinding review;
    public final ConstraintLayout reviewDocumentContainer;
    public final ViewSwitcher reviewGuidelineFlipper;
    private final ConstraintLayout rootView;

    private YdsFragmentDocumentReviewBinding(ConstraintLayout constraintLayout, View view, YdsFragmentIdDocumentGuidelinesBinding ydsFragmentIdDocumentGuidelinesBinding, YdsReviewScreenBinding ydsReviewScreenBinding, ConstraintLayout constraintLayout2, ViewSwitcher viewSwitcher) {
        this.rootView = constraintLayout;
        this.dragIndicator = view;
        this.guidelines = ydsFragmentIdDocumentGuidelinesBinding;
        this.review = ydsReviewScreenBinding;
        this.reviewDocumentContainer = constraintLayout2;
        this.reviewGuidelineFlipper = viewSwitcher;
    }

    public static YdsFragmentDocumentReviewBinding bind(View view) {
        View viewFindViewById;
        int i = C4608R.id.drag_indicator;
        View viewFindViewById2 = view.findViewById(i);
        if (viewFindViewById2 != null && (viewFindViewById = view.findViewById((i = C4608R.id.guidelines))) != null) {
            YdsFragmentIdDocumentGuidelinesBinding ydsFragmentIdDocumentGuidelinesBindingBind = YdsFragmentIdDocumentGuidelinesBinding.bind(viewFindViewById);
            i = C4608R.id.review;
            View viewFindViewById3 = view.findViewById(i);
            if (viewFindViewById3 != null) {
                YdsReviewScreenBinding ydsReviewScreenBindingBind = YdsReviewScreenBinding.bind(viewFindViewById3);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C4608R.id.reviewGuidelineFlipper;
                ViewSwitcher viewSwitcher = (ViewSwitcher) view.findViewById(i);
                if (viewSwitcher != null) {
                    return new YdsFragmentDocumentReviewBinding(constraintLayout, viewFindViewById2, ydsFragmentIdDocumentGuidelinesBindingBind, ydsReviewScreenBindingBind, constraintLayout, viewSwitcher);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_document_review, viewGroup, false);
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
