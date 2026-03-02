package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.button.YotiOptionButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsDocumentTypeCellBinding implements ViewBinding {
    public final YotiOptionButton buttonDocument;
    private final YotiOptionButton rootView;

    private YdsDocumentTypeCellBinding(YotiOptionButton yotiOptionButton, YotiOptionButton yotiOptionButton2) {
        this.rootView = yotiOptionButton;
        this.buttonDocument = yotiOptionButton2;
    }

    public static YdsDocumentTypeCellBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        YotiOptionButton yotiOptionButton = (YotiOptionButton) view;
        return new YdsDocumentTypeCellBinding(yotiOptionButton, yotiOptionButton);
    }

    public static YdsDocumentTypeCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsDocumentTypeCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_document_type_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public YotiOptionButton getRoot() {
        return this.rootView;
    }
}
