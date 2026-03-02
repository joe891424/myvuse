package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsDocumentScanFragmentBinding implements ViewBinding {
    public final YotiAppbarTransparent appBar;
    public final FrameLayout frameLayoutScanContainer;
    private final ConstraintLayout rootView;

    private YdsDocumentScanFragmentBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbarTransparent;
        this.frameLayoutScanContainer = frameLayout;
    }

    public static YdsDocumentScanFragmentBinding bind(View view) {
        int i = C4608R.id.appBar;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null) {
            i = C4608R.id.frameLayoutScanContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
            if (frameLayout != null) {
                return new YdsDocumentScanFragmentBinding((ConstraintLayout) view, yotiAppbarTransparent, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsDocumentScanFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsDocumentScanFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_document_scan_fragment, viewGroup, false);
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
