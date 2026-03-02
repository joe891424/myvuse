package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentRequirementsBinding implements ViewBinding {
    public final YdsFragmentDocumentRequirementsLoadingStateBinding loadingView;
    private final FrameLayout rootView;
    public final YdsFragmentDocumentRequirementsSuccessStateBinding successView;

    private YdsFragmentDocumentRequirementsBinding(FrameLayout frameLayout, YdsFragmentDocumentRequirementsLoadingStateBinding ydsFragmentDocumentRequirementsLoadingStateBinding, YdsFragmentDocumentRequirementsSuccessStateBinding ydsFragmentDocumentRequirementsSuccessStateBinding) {
        this.rootView = frameLayout;
        this.loadingView = ydsFragmentDocumentRequirementsLoadingStateBinding;
        this.successView = ydsFragmentDocumentRequirementsSuccessStateBinding;
    }

    public static YdsFragmentDocumentRequirementsBinding bind(View view) {
        int i = C4597R.id.loadingView;
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById != null) {
            YdsFragmentDocumentRequirementsLoadingStateBinding ydsFragmentDocumentRequirementsLoadingStateBindingBind = YdsFragmentDocumentRequirementsLoadingStateBinding.bind(viewFindViewById);
            int i2 = C4597R.id.successView;
            View viewFindViewById2 = view.findViewById(i2);
            if (viewFindViewById2 != null) {
                return new YdsFragmentDocumentRequirementsBinding((FrameLayout) view, ydsFragmentDocumentRequirementsLoadingStateBindingBind, YdsFragmentDocumentRequirementsSuccessStateBinding.bind(viewFindViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentRequirementsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentRequirementsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_requirements, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
