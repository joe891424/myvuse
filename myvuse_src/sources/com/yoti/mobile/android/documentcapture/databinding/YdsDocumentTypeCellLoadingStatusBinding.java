package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsDocumentTypeCellLoadingStatusBinding implements ViewBinding {
    public final View btnDocument;
    private final View rootView;

    private YdsDocumentTypeCellLoadingStatusBinding(View view, View view2) {
        this.rootView = view;
        this.btnDocument = view2;
    }

    public static YdsDocumentTypeCellLoadingStatusBinding bind(View view) {
        if (view != null) {
            return new YdsDocumentTypeCellLoadingStatusBinding(view, view);
        }
        throw new NullPointerException("rootView");
    }

    public static YdsDocumentTypeCellLoadingStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static YdsDocumentTypeCellLoadingStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_document_type_cell_loading_status, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
