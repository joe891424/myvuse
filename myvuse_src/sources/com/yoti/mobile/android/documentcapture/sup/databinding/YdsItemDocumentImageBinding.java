package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yoti.mobile.android.common.p049ui.widgets.YotiBadge;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemDocumentImageBinding implements ViewBinding {
    public final FloatingActionButton buttonRotate;
    public final PhotoView ivPreview;
    public final YotiBadge pageIndicator;
    private final FrameLayout rootView;

    private YdsItemDocumentImageBinding(FrameLayout frameLayout, FloatingActionButton floatingActionButton, PhotoView photoView, YotiBadge yotiBadge) {
        this.rootView = frameLayout;
        this.buttonRotate = floatingActionButton;
        this.ivPreview = photoView;
        this.pageIndicator = yotiBadge;
    }

    public static YdsItemDocumentImageBinding bind(View view) {
        int i = C4653R.id.buttonRotate;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(i);
        if (floatingActionButton != null) {
            i = C4653R.id.iv_preview;
            PhotoView photoView = (PhotoView) view.findViewById(i);
            if (photoView != null) {
                i = C4653R.id.pageIndicator;
                YotiBadge yotiBadge = (YotiBadge) view.findViewById(i);
                if (yotiBadge != null) {
                    return new YdsItemDocumentImageBinding((FrameLayout) view, floatingActionButton, photoView, yotiBadge);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsItemDocumentImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemDocumentImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_item_document_image, viewGroup, false);
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
