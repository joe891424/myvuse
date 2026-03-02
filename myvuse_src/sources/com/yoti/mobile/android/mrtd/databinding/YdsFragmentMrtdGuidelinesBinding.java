package com.yoti.mobile.android.mrtd.databinding;

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
import com.yoti.mobile.android.mrtd.C4900R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentMrtdGuidelinesBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonNfcGuidelinesPrimary;
    public final ImageView imageNfcNotOnTop;
    public final ImageView imageNfcOnTop;
    public final ImageView imageNfcRightPlace;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final TextView textViewNfcGuidelinesMessage;
    public final TextView textViewNfcGuidelinesTitle;
    public final TextView textViewNfcOnTop;
    public final TextView textViewNfcRightPlace;

    private YdsFragmentMrtdGuidelinesBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ScrollView scrollView, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonNfcGuidelinesPrimary = yotiButton;
        this.imageNfcNotOnTop = imageView;
        this.imageNfcOnTop = imageView2;
        this.imageNfcRightPlace = imageView3;
        this.scrollView = scrollView;
        this.shadow = view;
        this.textViewNfcGuidelinesMessage = textView;
        this.textViewNfcGuidelinesTitle = textView2;
        this.textViewNfcOnTop = textView3;
        this.textViewNfcRightPlace = textView4;
    }

    public static YdsFragmentMrtdGuidelinesBinding bind(View view) {
        View viewFindViewById;
        int i = C4900R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4900R.id.buttonNfcGuidelinesPrimary;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4900R.id.image_nfc_not_on_top;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4900R.id.image_nfc_on_top;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C4900R.id.image_nfc_right_place;
                        ImageView imageView3 = (ImageView) view.findViewById(i);
                        if (imageView3 != null) {
                            i = C4900R.id.scrollView;
                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                            if (scrollView != null && (viewFindViewById = view.findViewById((i = C4900R.id.shadow))) != null) {
                                i = C4900R.id.textViewNfcGuidelinesMessage;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C4900R.id.textViewNfcGuidelinesTitle;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C4900R.id.textViewNfcOnTop;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4900R.id.textViewNfcRightPlace;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                return new YdsFragmentMrtdGuidelinesBinding((ConstraintLayout) view, yotiAppbar, yotiButton, imageView, imageView2, imageView3, scrollView, viewFindViewById, textView, textView2, textView3, textView4);
                                            }
                                        }
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

    public static YdsFragmentMrtdGuidelinesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentMrtdGuidelinesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4900R.layout.yds_fragment_mrtd_guidelines, viewGroup, false);
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
