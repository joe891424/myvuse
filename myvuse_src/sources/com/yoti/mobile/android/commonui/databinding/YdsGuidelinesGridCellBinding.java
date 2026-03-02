package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsGuidelinesGridCellBinding implements ViewBinding {
    public final TextView guidelinesItemHeader;
    public final ImageView guidelinesItemImage;
    public final TextView guidelinesItemText;
    private final ConstraintLayout rootView;

    private YdsGuidelinesGridCellBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.guidelinesItemHeader = textView;
        this.guidelinesItemImage = imageView;
        this.guidelinesItemText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static YdsGuidelinesGridCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsGuidelinesGridCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_guidelines_grid_cell, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsGuidelinesGridCellBinding bind(View view) {
        int i = C4590R.id.guidelinesItemHeader;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4590R.id.guidelinesItemImage;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C4590R.id.guidelinesItemText;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new YdsGuidelinesGridCellBinding((ConstraintLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
