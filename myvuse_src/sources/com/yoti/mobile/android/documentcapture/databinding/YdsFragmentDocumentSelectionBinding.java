package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentSelectionBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YdsFragmentDocumentSelectionLoadingStateBinding loadingView;
    private final ConstraintLayout rootView;
    public final YdsFragmentDocumentSelectionSuccessStateBinding successView;

    private YdsFragmentDocumentSelectionBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YdsFragmentDocumentSelectionLoadingStateBinding ydsFragmentDocumentSelectionLoadingStateBinding, YdsFragmentDocumentSelectionSuccessStateBinding ydsFragmentDocumentSelectionSuccessStateBinding) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.loadingView = ydsFragmentDocumentSelectionLoadingStateBinding;
        this.successView = ydsFragmentDocumentSelectionSuccessStateBinding;
    }

    public static YdsFragmentDocumentSelectionBinding bind(View view) {
        int i;
        View viewFindViewById;
        int i2 = C4597R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i2);
        if (yotiAppbar == null || (viewFindViewById = view.findViewById((i2 = C4597R.id.loadingView))) == null) {
            i = i2;
        } else {
            YdsFragmentDocumentSelectionLoadingStateBinding ydsFragmentDocumentSelectionLoadingStateBindingBind = YdsFragmentDocumentSelectionLoadingStateBinding.bind(viewFindViewById);
            i = C4597R.id.successView;
            View viewFindViewById2 = view.findViewById(i);
            if (viewFindViewById2 != null) {
                return new YdsFragmentDocumentSelectionBinding((ConstraintLayout) view, yotiAppbar, ydsFragmentDocumentSelectionLoadingStateBindingBind, YdsFragmentDocumentSelectionSuccessStateBinding.bind(viewFindViewById2));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentSelectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_selection, viewGroup, false);
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
