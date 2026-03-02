package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsActivityIdDocumentCaptureBinding implements ViewBinding {
    public final FragmentContainerView idDocumentNavigationFragment;
    private final ConstraintLayout rootView;

    private YdsActivityIdDocumentCaptureBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.idDocumentNavigationFragment = fragmentContainerView;
    }

    public static YdsActivityIdDocumentCaptureBinding bind(View view) {
        int i = C4608R.id.idDocumentNavigationFragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(i);
        if (fragmentContainerView != null) {
            return new YdsActivityIdDocumentCaptureBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsActivityIdDocumentCaptureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsActivityIdDocumentCaptureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_activity_id_document_capture, viewGroup, false);
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
