package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsItemMoreAboutDescBinding implements ViewBinding {
    public final TextView description;
    private final TextView rootView;

    private YdsItemMoreAboutDescBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.description = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static YdsItemMoreAboutDescBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsItemMoreAboutDescBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_item_more_about_desc, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsItemMoreAboutDescBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new YdsItemMoreAboutDescBinding(textView, textView);
    }
}
