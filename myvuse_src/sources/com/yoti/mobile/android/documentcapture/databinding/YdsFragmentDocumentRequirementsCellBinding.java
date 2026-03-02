package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentRequirementsCellBinding implements ViewBinding {
    public final ImageView imageViewRequirementsItem;
    private final ConstraintLayout rootView;
    public final TextView textViewRequirementsItemHeader;
    public final TextView textViewRequirementsItemText;
    public final TextView textViewRequirementsItemTextSecondary;

    private YdsFragmentDocumentRequirementsCellBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.imageViewRequirementsItem = imageView;
        this.textViewRequirementsItemHeader = textView;
        this.textViewRequirementsItemText = textView2;
        this.textViewRequirementsItemTextSecondary = textView3;
    }

    public static YdsFragmentDocumentRequirementsCellBinding bind(View view) {
        int i = C4597R.id.imageViewRequirementsItem;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4597R.id.textViewRequirementsItemHeader;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4597R.id.textViewRequirementsItemText;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = C4597R.id.textViewRequirementsItemTextSecondary;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        return new YdsFragmentDocumentRequirementsCellBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentRequirementsCellBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentRequirementsCellBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_fragment_document_requirements_cell, viewGroup, false);
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
