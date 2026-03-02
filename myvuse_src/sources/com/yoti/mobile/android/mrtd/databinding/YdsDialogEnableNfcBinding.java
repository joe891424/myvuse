package com.yoti.mobile.android.mrtd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.mrtd.C4900R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsDialogEnableNfcBinding implements ViewBinding {
    public final TextView dialogTitle;
    public final Button dismissButton;
    public final ImageView iconView;
    private final ConstraintLayout rootView;
    public final Button startSettingsButton;

    private YdsDialogEnableNfcBinding(ConstraintLayout constraintLayout, TextView textView, Button button, ImageView imageView, Button button2) {
        this.rootView = constraintLayout;
        this.dialogTitle = textView;
        this.dismissButton = button;
        this.iconView = imageView;
        this.startSettingsButton = button2;
    }

    public static YdsDialogEnableNfcBinding bind(View view) {
        int i = C4900R.id.dialogTitle;
        TextView textView = (TextView) view.findViewById(i);
        if (textView != null) {
            i = C4900R.id.dismissButton;
            Button button = (Button) view.findViewById(i);
            if (button != null) {
                i = C4900R.id.iconView;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4900R.id.startSettingsButton;
                    Button button2 = (Button) view.findViewById(i);
                    if (button2 != null) {
                        return new YdsDialogEnableNfcBinding((ConstraintLayout) view, textView, button, imageView, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsDialogEnableNfcBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsDialogEnableNfcBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4900R.layout.yds_dialog_enable_nfc, viewGroup, false);
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
