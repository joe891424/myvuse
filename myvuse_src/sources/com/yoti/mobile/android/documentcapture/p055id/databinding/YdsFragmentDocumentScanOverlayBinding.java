package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.OverlayScanView;
import com.yoti.mobile.android.documentscan.ui.helpers.scan.DocumentScanOverlayView;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentScanOverlayBinding implements ViewBinding {
    public final ImageView logo;
    public final ImageButton manualCaptureBtn;
    private final OverlayScanView rootView;
    public final DocumentScanOverlayView scanOverlay;
    public final TextView scanTextSubTitle;
    public final TextView scanTextTitle;
    public final View scanTextsFrame;

    private YdsFragmentDocumentScanOverlayBinding(OverlayScanView overlayScanView, ImageView imageView, ImageButton imageButton, DocumentScanOverlayView documentScanOverlayView, TextView textView, TextView textView2, View view) {
        this.rootView = overlayScanView;
        this.logo = imageView;
        this.manualCaptureBtn = imageButton;
        this.scanOverlay = documentScanOverlayView;
        this.scanTextSubTitle = textView;
        this.scanTextTitle = textView2;
        this.scanTextsFrame = view;
    }

    public static YdsFragmentDocumentScanOverlayBinding bind(View view) {
        View viewFindViewById;
        int i = C4608R.id.logo;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4608R.id.manualCaptureBtn;
            ImageButton imageButton = (ImageButton) view.findViewById(i);
            if (imageButton != null) {
                i = C4608R.id.scanOverlay;
                DocumentScanOverlayView documentScanOverlayView = (DocumentScanOverlayView) view.findViewById(i);
                if (documentScanOverlayView != null) {
                    i = C4608R.id.scanTextSubTitle;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C4608R.id.scanTextTitle;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null && (viewFindViewById = view.findViewById((i = C4608R.id.scanTextsFrame))) != null) {
                            return new YdsFragmentDocumentScanOverlayBinding((OverlayScanView) view, imageView, imageButton, documentScanOverlayView, textView, textView2, viewFindViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentScanOverlayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentScanOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_document_scan_overlay, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public OverlayScanView getRoot() {
        return this.rootView;
    }
}
