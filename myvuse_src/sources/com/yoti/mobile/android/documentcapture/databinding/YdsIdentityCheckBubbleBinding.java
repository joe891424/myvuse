package com.yoti.mobile.android.documentcapture.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.C4597R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsIdentityCheckBubbleBinding implements ViewBinding {
    public final YotiButton buttonMoreAboutIdentityCheck;
    private final LinearLayout rootView;
    public final TextView textViewIdentityCheck;
    public final TextView textViewIdentityCheckTitle;

    private YdsIdentityCheckBubbleBinding(LinearLayout linearLayout, YotiButton yotiButton, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.buttonMoreAboutIdentityCheck = yotiButton;
        this.textViewIdentityCheck = textView;
        this.textViewIdentityCheckTitle = textView2;
    }

    public static YdsIdentityCheckBubbleBinding bind(View view) {
        int i = C4597R.id.buttonMoreAboutIdentityCheck;
        YotiButton yotiButton = (YotiButton) view.findViewById(i);
        if (yotiButton != null) {
            i = C4597R.id.textViewIdentityCheck;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = C4597R.id.textViewIdentityCheckTitle;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    return new YdsIdentityCheckBubbleBinding((LinearLayout) view, yotiButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsIdentityCheckBubbleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsIdentityCheckBubbleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4597R.layout.yds_identity_check_bubble, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
