package com.yoti.mobile.android.liveness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.BulletTextLayout;
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsBiometricConsentBulletedParagraphListItemBinding implements ViewBinding {
    public final BulletTextLayout bulletedParagraphText;
    private final BulletTextLayout rootView;

    private YdsBiometricConsentBulletedParagraphListItemBinding(BulletTextLayout bulletTextLayout, BulletTextLayout bulletTextLayout2) {
        this.rootView = bulletTextLayout;
        this.bulletedParagraphText = bulletTextLayout2;
    }

    public static YdsBiometricConsentBulletedParagraphListItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        BulletTextLayout bulletTextLayout = (BulletTextLayout) view;
        return new YdsBiometricConsentBulletedParagraphListItemBinding(bulletTextLayout, bulletTextLayout);
    }

    public static YdsBiometricConsentBulletedParagraphListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsBiometricConsentBulletedParagraphListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_biometric_consent_bulleted_paragraph_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public BulletTextLayout getRoot() {
        return this.rootView;
    }
}
