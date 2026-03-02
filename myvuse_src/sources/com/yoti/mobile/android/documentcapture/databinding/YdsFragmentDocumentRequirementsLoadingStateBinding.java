package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentRequirementsLoadingStateBinding implements ViewBinding {
    public final YotiAppbarTransparent appBarLoading;
    public final View buttonPrimaryActionLoading;
    public final View buttonSecondaryActionLoading;
    public final Guideline guideline;
    public final HorizontalScrollingGradient loadingShimmerView;
    private final ConstraintLayout rootView;
    public final View viewListLoading;
    public final TextView viewTitleLoading;

    private YdsFragmentDocumentRequirementsLoadingStateBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, View view, View view2, Guideline guideline, HorizontalScrollingGradient horizontalScrollingGradient, View view3, TextView textView) {
        this.rootView = constraintLayout;
        this.appBarLoading = yotiAppbarTransparent;
        this.buttonPrimaryActionLoading = view;
        this.buttonSecondaryActionLoading = view2;
        this.guideline = guideline;
        this.loadingShimmerView = horizontalScrollingGradient;
        this.viewListLoading = view3;
        this.viewTitleLoading = textView;
    }

    public static YdsFragmentDocumentRequirementsLoadingStateBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        int i = C4597R.id.appBarLoading;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null && (viewFindViewById = view.findViewById((i = C4597R.id.buttonPrimaryActionLoading))) != null && (viewFindViewById2 = view.findViewById((i = C4597R.id.buttonSecondaryActionLoading))) != null) {
            i = C4597R.id.guideline;
            Guideline guideline = (Guideline) view.findViewById(i);
            if (guideline != null) {
                i = C4597R.id.loadingShimmerView;
                HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
                if (horizontalScrollingGradient != null && (viewFindViewById3 = view.findViewById((i = C4597R.id.viewListLoading))) != null) {
                    i = C4597R.id.viewTitleLoading;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        return new YdsFragmentDocumentRequirementsLoadingStateBinding((ConstraintLayout) view, yotiAppbarTransparent, viewFindViewById, viewFindViewById2, guideline, horizontalScrollingGradient, viewFindViewById3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentRequirementsLoadingStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentRequirementsLoadingStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_requirements_loading_state, viewGroup, false);
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
