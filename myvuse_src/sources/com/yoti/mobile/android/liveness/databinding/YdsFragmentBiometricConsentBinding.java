package com.yoti.mobile.android.liveness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentBiometricConsentBinding implements ViewBinding {
    public final YotiAppbarTransparent appBar;
    public final RecyclerView bulletList;
    public final YotiButton buttonAction;
    public final CheckBox confirmConsentCheck;
    public final TextView confirmConsentText;
    public final ImageView imageViewHead;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final View shadow;
    public final TextView title;

    private YdsFragmentBiometricConsentBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, RecyclerView recyclerView, YotiButton yotiButton, CheckBox checkBox, TextView textView, ImageView imageView, NestedScrollView nestedScrollView, View view, TextView textView2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbarTransparent;
        this.bulletList = recyclerView;
        this.buttonAction = yotiButton;
        this.confirmConsentCheck = checkBox;
        this.confirmConsentText = textView;
        this.imageViewHead = imageView;
        this.scrollView = nestedScrollView;
        this.shadow = view;
        this.title = textView2;
    }

    public static YdsFragmentBiometricConsentBinding bind(View view) {
        View viewFindViewById;
        int i = C4871R.id.appBar;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null) {
            i = C4871R.id.bulletList;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
            if (recyclerView != null) {
                i = C4871R.id.buttonAction;
                YotiButton yotiButton = (YotiButton) view.findViewById(i);
                if (yotiButton != null) {
                    i = C4871R.id.confirmConsentCheck;
                    CheckBox checkBox = (CheckBox) view.findViewById(i);
                    if (checkBox != null) {
                        i = C4871R.id.confirmConsentText;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C4871R.id.imageViewHead;
                            ImageView imageView = (ImageView) view.findViewById(i);
                            if (imageView != null) {
                                i = C4871R.id.scrollView;
                                NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(i);
                                if (nestedScrollView != null && (viewFindViewById = view.findViewById((i = C4871R.id.shadow))) != null) {
                                    i = C4871R.id.title;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        return new YdsFragmentBiometricConsentBinding((ConstraintLayout) view, yotiAppbarTransparent, recyclerView, yotiButton, checkBox, textView, imageView, nestedScrollView, viewFindViewById, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentBiometricConsentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentBiometricConsentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_fragment_biometric_consent, viewGroup, false);
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
