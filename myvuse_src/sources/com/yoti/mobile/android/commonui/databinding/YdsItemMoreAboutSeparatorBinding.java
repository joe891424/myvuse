package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemMoreAboutSeparatorBinding implements ViewBinding {
    private final View rootView;

    private YdsItemMoreAboutSeparatorBinding(View view) {
        this.rootView = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static YdsItemMoreAboutSeparatorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemMoreAboutSeparatorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_item_more_about_separator, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsItemMoreAboutSeparatorBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new YdsItemMoreAboutSeparatorBinding(view);
    }
}
