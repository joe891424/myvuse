package com.yoti.mobile.android.liveness.databinding;

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
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentLivenessEducationalGuidelineBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonLivenessGuidelinesGotIt;
    public final TextView livenessGuidelinesDescriptionFirst;
    public final TextView livenessGuidelinesDescriptionSecond;
    public final ImageView livenessGuidelinesImageRowFirstEnd;
    public final ImageView livenessGuidelinesImageRowFirstStart;
    public final ImageView livenessGuidelinesImageRowSecondEnd;
    public final ImageView livenessGuidelinesImageRowSecondStart;
    public final TextView livenessGuidelinesTitle;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;

    private YdsFragmentLivenessEducationalGuidelineBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ScrollView scrollView, View view) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonLivenessGuidelinesGotIt = yotiButton;
        this.livenessGuidelinesDescriptionFirst = textView;
        this.livenessGuidelinesDescriptionSecond = textView2;
        this.livenessGuidelinesImageRowFirstEnd = imageView;
        this.livenessGuidelinesImageRowFirstStart = imageView2;
        this.livenessGuidelinesImageRowSecondEnd = imageView3;
        this.livenessGuidelinesImageRowSecondStart = imageView4;
        this.livenessGuidelinesTitle = textView3;
        this.scrollView = scrollView;
        this.shadow = view;
    }

    public static YdsFragmentLivenessEducationalGuidelineBinding bind(View view) {
        View viewFindViewById;
        int i = C4871R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4871R.id.buttonLivenessGuidelinesGotIt;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4871R.id.livenessGuidelinesDescriptionFirst;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4871R.id.livenessGuidelinesDescriptionSecond;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C4871R.id.livenessGuidelinesImageRowFirstEnd;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = C4871R.id.livenessGuidelinesImageRowFirstStart;
                            ImageView imageView2 = (ImageView) view.findViewById(i);
                            if (imageView2 != null) {
                                i = C4871R.id.livenessGuidelinesImageRowSecondEnd;
                                ImageView imageView3 = (ImageView) view.findViewById(i);
                                if (imageView3 != null) {
                                    i = C4871R.id.livenessGuidelinesImageRowSecondStart;
                                    ImageView imageView4 = (ImageView) view.findViewById(i);
                                    if (imageView4 != null) {
                                        i = C4871R.id.livenessGuidelinesTitle;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4871R.id.scrollView;
                                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                                            if (scrollView != null && (viewFindViewById = view.findViewById((i = C4871R.id.shadow))) != null) {
                                                return new YdsFragmentLivenessEducationalGuidelineBinding((ConstraintLayout) view, yotiAppbar, yotiButton, textView, textView2, imageView, imageView2, imageView3, imageView4, textView3, scrollView, viewFindViewById);
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

    public static YdsFragmentLivenessEducationalGuidelineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentLivenessEducationalGuidelineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_fragment_liveness_educational_guideline, viewGroup, false);
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
