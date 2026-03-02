package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemTextExtractionErrorInstructionBinding implements ViewBinding {
    public final ImageView errorInstructionImage;
    public final TextView errorInstructionText;
    private final ConstraintLayout rootView;

    private YdsItemTextExtractionErrorInstructionBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.errorInstructionImage = imageView;
        this.errorInstructionText = textView;
    }

    public static YdsItemTextExtractionErrorInstructionBinding bind(View view) {
        int i = C4608R.id.error_instruction_image;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C4608R.id.error_instruction_text;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new YdsItemTextExtractionErrorInstructionBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsItemTextExtractionErrorInstructionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemTextExtractionErrorInstructionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_item_text_extraction_error_instruction, viewGroup, false);
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
