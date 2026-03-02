package com.yoti.mobile.android.mrtd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.yoti.mobile.android.mrtd.C4900R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsDialogNfcReadBinding implements ViewBinding {
    public final Button cancelReadButton;
    public final TextView descriptionView;
    public final View dragIndicator;
    public final LottieAnimationView readAnimation;
    private final ConstraintLayout rootView;
    public final TextView titleView;

    private YdsDialogNfcReadBinding(ConstraintLayout constraintLayout, Button button, TextView textView, View view, LottieAnimationView lottieAnimationView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cancelReadButton = button;
        this.descriptionView = textView;
        this.dragIndicator = view;
        this.readAnimation = lottieAnimationView;
        this.titleView = textView2;
    }

    public static YdsDialogNfcReadBinding bind(View view) {
        View viewFindViewById;
        int i = C4900R.id.cancelReadButton;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C4900R.id.descriptionView;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null && (viewFindViewById = view.findViewById((i = C4900R.id.drag_indicator))) != null) {
                i = C4900R.id.readAnimation;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(i);
                if (lottieAnimationView != null) {
                    i = C4900R.id.titleView;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        return new YdsDialogNfcReadBinding((ConstraintLayout) view, button, textView, viewFindViewById, lottieAnimationView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsDialogNfcReadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsDialogNfcReadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4900R.layout.yds_dialog_nfc_read, viewGroup, false);
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
