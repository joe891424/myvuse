package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemIdDocumentImageBinding implements ViewBinding {
    public final ImageView documentImage;
    private final ImageView rootView;

    private YdsItemIdDocumentImageBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.documentImage = imageView2;
    }

    public static YdsItemIdDocumentImageBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new YdsItemIdDocumentImageBinding(imageView, imageView);
    }

    public static YdsItemIdDocumentImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemIdDocumentImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_item_id_document_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }
}
