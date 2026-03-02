package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentSupDocumentReviewBinding implements ViewBinding {
    public final YdsFragmentSupDocumentReviewLoadingStateBinding loadingDataView;
    private final ConstraintLayout rootView;
    public final YdsFragmentSupDocumentReviewSuccessStateBinding successDataView;

    private YdsFragmentSupDocumentReviewBinding(ConstraintLayout constraintLayout, YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBinding, YdsFragmentSupDocumentReviewSuccessStateBinding ydsFragmentSupDocumentReviewSuccessStateBinding) {
        this.rootView = constraintLayout;
        this.loadingDataView = ydsFragmentSupDocumentReviewLoadingStateBinding;
        this.successDataView = ydsFragmentSupDocumentReviewSuccessStateBinding;
    }

    public static YdsFragmentSupDocumentReviewBinding bind(View view) {
        int i = C4653R.id.loadingDataView;
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById != null) {
            YdsFragmentSupDocumentReviewLoadingStateBinding ydsFragmentSupDocumentReviewLoadingStateBindingBind = YdsFragmentSupDocumentReviewLoadingStateBinding.bind(viewFindViewById);
            int i2 = C4653R.id.successDataView;
            View viewFindViewById2 = view.findViewById(i2);
            if (viewFindViewById2 != null) {
                return new YdsFragmentSupDocumentReviewBinding((ConstraintLayout) view, ydsFragmentSupDocumentReviewLoadingStateBindingBind, YdsFragmentSupDocumentReviewSuccessStateBinding.bind(viewFindViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentSupDocumentReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentSupDocumentReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_fragment_sup_document_review, viewGroup, false);
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
