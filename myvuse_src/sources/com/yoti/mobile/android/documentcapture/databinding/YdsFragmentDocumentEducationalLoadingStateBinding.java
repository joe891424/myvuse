package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.HorizontalScrollingGradient;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentEducationalLoadingStateBinding implements ViewBinding {
    public final CardView cardVideoContainerLoading;
    public final HorizontalScrollingGradient loadingShimmerView;
    public final View moreAboutVerificationLoading;
    private final ConstraintLayout rootView;
    public final TextView viewMessageLoading;
    public final TextView viewTitleLoading;

    private YdsFragmentDocumentEducationalLoadingStateBinding(ConstraintLayout constraintLayout, CardView cardView, HorizontalScrollingGradient horizontalScrollingGradient, View view, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cardVideoContainerLoading = cardView;
        this.loadingShimmerView = horizontalScrollingGradient;
        this.moreAboutVerificationLoading = view;
        this.viewMessageLoading = textView;
        this.viewTitleLoading = textView2;
    }

    public static YdsFragmentDocumentEducationalLoadingStateBinding bind(View view) {
        View viewFindViewById;
        int i = C4597R.id.cardVideoContainerLoading;
        CardView cardView = (CardView) view.findViewById(i);
        if (cardView != null) {
            i = C4597R.id.loadingShimmerView;
            HorizontalScrollingGradient horizontalScrollingGradient = (HorizontalScrollingGradient) view.findViewById(i);
            if (horizontalScrollingGradient != null && (viewFindViewById = view.findViewById((i = C4597R.id.moreAboutVerificationLoading))) != null) {
                i = C4597R.id.viewMessageLoading;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4597R.id.viewTitleLoading;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new YdsFragmentDocumentEducationalLoadingStateBinding((ConstraintLayout) view, cardView, horizontalScrollingGradient, viewFindViewById, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentEducationalLoadingStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentEducationalLoadingStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_educational_loading_state, viewGroup, false);
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
