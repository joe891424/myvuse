package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentSelectionLoadingStateBinding implements ViewBinding {
    public final LinearLayout documentListLoading;
    public final HorizontalScrollingGradient loadingShimmerView;
    private final ConstraintLayout rootView;
    public final TextView textViewHeaderLoading;
    public final View viewChangeCountryLinkLoading;
    public final View viewFindOutHowLinkLoading;
    public final View viewIssuingCountryLoading;
    public final View viewIssuingCountryTitleLoading;

    private YdsFragmentDocumentSelectionLoadingStateBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, HorizontalScrollingGradient horizontalScrollingGradient, TextView textView, View view, View view2, View view3, View view4) {
        this.rootView = constraintLayout;
        this.documentListLoading = linearLayout;
        this.loadingShimmerView = horizontalScrollingGradient;
        this.textViewHeaderLoading = textView;
        this.viewChangeCountryLinkLoading = view;
        this.viewFindOutHowLinkLoading = view2;
        this.viewIssuingCountryLoading = view3;
        this.viewIssuingCountryTitleLoading = view4;
    }

    public static YdsFragmentDocumentSelectionLoadingStateBinding bind(View view) {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        View viewFindViewById4;
        int i = C4597R.id.documentListLoading;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = C4597R.id.loadingShimmerView;
            HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
            if (horizontalScrollingGradient != null) {
                i = C4597R.id.textViewHeaderLoading;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null && (viewFindViewById = view.findViewById((i = C4597R.id.viewChangeCountryLinkLoading))) != null && (viewFindViewById2 = view.findViewById((i = C4597R.id.viewFindOutHowLinkLoading))) != null && (viewFindViewById3 = view.findViewById((i = C4597R.id.viewIssuingCountryLoading))) != null && (viewFindViewById4 = view.findViewById((i = C4597R.id.viewIssuingCountryTitleLoading))) != null) {
                    return new YdsFragmentDocumentSelectionLoadingStateBinding((ConstraintLayout) view, linearLayout, horizontalScrollingGradient, textView, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentSelectionLoadingStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentSelectionLoadingStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_selection_loading_state, viewGroup, false);
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
