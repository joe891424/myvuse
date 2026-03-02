package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.button.YotiOptionButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsDoNotHaveDocumentCellBinding implements ViewBinding {
    public final YotiOptionButton buttonDoNotHaveDocuments;
    private final LinearLayout rootView;

    private YdsDoNotHaveDocumentCellBinding(LinearLayout linearLayout, YotiOptionButton yotiOptionButton) {
        this.rootView = linearLayout;
        this.buttonDoNotHaveDocuments = yotiOptionButton;
    }

    public static YdsDoNotHaveDocumentCellBinding bind(View view) {
        int i = C4597R.id.buttonDoNotHaveDocuments;
        YotiOptionButton yotiOptionButton = (YotiOptionButton) view.findViewById(i);
        if (yotiOptionButton != null) {
            return new YdsDoNotHaveDocumentCellBinding((LinearLayout) view, yotiOptionButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsDoNotHaveDocumentCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsDoNotHaveDocumentCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_do_not_have_document_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
