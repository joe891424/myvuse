package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentAutomationDocumentScanOverlayBinding implements ViewBinding {
    public final ImageButton manualCaptureBtn;
    private final ConstraintLayout rootView;
    public final TextView scanTextSubTitle;
    public final TextView scanTextTitle;

    private YdsFragmentAutomationDocumentScanOverlayBinding(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.manualCaptureBtn = imageButton;
        this.scanTextSubTitle = textView;
        this.scanTextTitle = textView2;
    }

    public static YdsFragmentAutomationDocumentScanOverlayBinding bind(View view) {
        int i = C4608R.id.manualCaptureBtn;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C4608R.id.scanTextSubTitle;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4608R.id.scanTextTitle;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new YdsFragmentAutomationDocumentScanOverlayBinding((ConstraintLayout) view, imageButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentAutomationDocumentScanOverlayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentAutomationDocumentScanOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_automation_document_scan_overlay, viewGroup, false);
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
