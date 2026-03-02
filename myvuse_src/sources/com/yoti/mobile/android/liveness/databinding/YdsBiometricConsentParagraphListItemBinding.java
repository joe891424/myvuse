package com.yoti.mobile.android.liveness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsBiometricConsentParagraphListItemBinding implements ViewBinding {
    public final TextView paragraphText;
    private final TextView rootView;

    private YdsBiometricConsentParagraphListItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.paragraphText = textView2;
    }

    public static YdsBiometricConsentParagraphListItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new YdsBiometricConsentParagraphListItemBinding(textView, textView);
    }

    public static YdsBiometricConsentParagraphListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsBiometricConsentParagraphListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_biometric_consent_paragraph_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
