package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemMoreAboutLogoBinding implements ViewBinding {
    public final ImageView logo;
    private final LinearLayout rootView;

    private YdsItemMoreAboutLogoBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.logo = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static YdsItemMoreAboutLogoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemMoreAboutLogoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_item_more_about_logo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsItemMoreAboutLogoBinding bind(View view) {
        int i = C4590R.id.logo;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            return new YdsItemMoreAboutLogoBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
