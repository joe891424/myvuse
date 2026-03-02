package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.button.YotiOptionButton;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentVerifyYourDetailsBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiOptionButton buttonEPassport;
    public final YotiOptionButton buttonTraditionalPassport;
    public final TextView header;
    private final ConstraintLayout rootView;
    public final TextView subHeader;

    private YdsFragmentVerifyYourDetailsBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiOptionButton yotiOptionButton, YotiOptionButton yotiOptionButton2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonEPassport = yotiOptionButton;
        this.buttonTraditionalPassport = yotiOptionButton2;
        this.header = textView;
        this.subHeader = textView2;
    }

    public static YdsFragmentVerifyYourDetailsBinding bind(View view) {
        int i = C4608R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4608R.id.buttonEPassport;
            YotiOptionButton yotiOptionButton = (YotiOptionButton) view.findViewById(i);
            if (yotiOptionButton != null) {
                i = C4608R.id.buttonTraditionalPassport;
                YotiOptionButton yotiOptionButton2 = (YotiOptionButton) view.findViewById(i);
                if (yotiOptionButton2 != null) {
                    i = C4608R.id.header;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C4608R.id.subHeader;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new YdsFragmentVerifyYourDetailsBinding((ConstraintLayout) view, yotiAppbar, yotiOptionButton, yotiOptionButton2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentVerifyYourDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentVerifyYourDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_verify_your_details, viewGroup, false);
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
