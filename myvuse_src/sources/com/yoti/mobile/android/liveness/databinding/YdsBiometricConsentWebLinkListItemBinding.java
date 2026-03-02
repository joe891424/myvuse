package com.yoti.mobile.android.liveness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsBiometricConsentWebLinkListItemBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView webLinkLabel;

    private YdsBiometricConsentWebLinkListItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.webLinkLabel = textView2;
    }

    public static YdsBiometricConsentWebLinkListItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new YdsBiometricConsentWebLinkListItemBinding(textView, textView);
    }

    public static YdsBiometricConsentWebLinkListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsBiometricConsentWebLinkListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_biometric_consent_web_link_list_item, viewGroup, false);
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
