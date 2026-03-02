package com.yoti.mobile.android.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.C4590R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentGenericMessageBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonAction;
    public final YotiButton buttonActionSecondary;
    public final ImageView imageViewHead;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final TextView textViewContent;
    public final TextView textViewTitle;

    private YdsFragmentGenericMessageBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, YotiButton yotiButton2, ImageView imageView, ScrollView scrollView, View view, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonAction = yotiButton;
        this.buttonActionSecondary = yotiButton2;
        this.imageViewHead = imageView;
        this.scrollView = scrollView;
        this.shadow = view;
        this.textViewContent = textView;
        this.textViewTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static YdsFragmentGenericMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentGenericMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4590R.layout.yds_fragment_generic_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YdsFragmentGenericMessageBinding bind(View view) {
        View viewFindViewById;
        int i = C4590R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4590R.id.buttonAction;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4590R.id.buttonActionSecondary;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4590R.id.imageViewHead;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        i = C4590R.id.scrollView;
                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                        if (scrollView != null && (viewFindViewById = view.findViewById((i = C4590R.id.shadow))) != null) {
                            i = C4590R.id.textViewContent;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C4590R.id.textViewTitle;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    return new YdsFragmentGenericMessageBinding((ConstraintLayout) view, yotiAppbar, yotiButton, yotiButton2, imageView, scrollView, viewFindViewById, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
