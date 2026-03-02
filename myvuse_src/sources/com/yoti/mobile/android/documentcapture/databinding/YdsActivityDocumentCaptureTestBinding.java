package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsActivityDocumentCaptureTestBinding implements ViewBinding {
    public final FragmentContainerView documentNavigationFragment;
    private final ConstraintLayout rootView;

    private YdsActivityDocumentCaptureTestBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.documentNavigationFragment = fragmentContainerView;
    }

    public static YdsActivityDocumentCaptureTestBinding bind(View view) {
        int i = C4597R.id.documentNavigationFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
        if (fragmentContainerView != null) {
            return new YdsActivityDocumentCaptureTestBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityDocumentCaptureTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityDocumentCaptureTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_activity_document_capture_test, viewGroup, false);
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
