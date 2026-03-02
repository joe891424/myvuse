package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentGuidelinesBottomSheetBinding implements ViewBinding {
    public final FragmentContainerView documentGuidelinesFragment;
    private final FragmentContainerView rootView;

    private YdsFragmentDocumentGuidelinesBottomSheetBinding(FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2) {
        this.rootView = fragmentContainerView;
        this.documentGuidelinesFragment = fragmentContainerView2;
    }

    public static YdsFragmentDocumentGuidelinesBottomSheetBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view;
        return new YdsFragmentDocumentGuidelinesBottomSheetBinding(fragmentContainerView, fragmentContainerView);
    }

    public static YdsFragmentDocumentGuidelinesBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentGuidelinesBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_guidelines_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FragmentContainerView getRoot() {
        return this.rootView;
    }
}
