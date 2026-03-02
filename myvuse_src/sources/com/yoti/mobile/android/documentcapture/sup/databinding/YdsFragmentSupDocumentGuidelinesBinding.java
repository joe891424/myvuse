package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.BulletTextLayout;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentSupDocumentGuidelinesBinding implements ViewBinding {
    public final YotiAppbarTransparent appBar;
    public final YotiButton gotItButton;
    public final ImageView ivSection1;
    public final ImageView ivSection2;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final BulletTextLayout textViewDocumentGuidelinesFormatRequirement;
    public final TextView textViewDocumentGuidelinesSecondDesc;
    public final TextView tvMessage;
    public final TextView tvSection1;
    public final TextView tvSection2;
    public final TextView tvTile;

    private YdsFragmentSupDocumentGuidelinesBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, YotiButton yotiButton, ImageView imageView, ImageView imageView2, ScrollView scrollView, View view, BulletTextLayout bulletTextLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbarTransparent;
        this.gotItButton = yotiButton;
        this.ivSection1 = imageView;
        this.ivSection2 = imageView2;
        this.scrollView = scrollView;
        this.shadow = view;
        this.textViewDocumentGuidelinesFormatRequirement = bulletTextLayout;
        this.textViewDocumentGuidelinesSecondDesc = textView;
        this.tvMessage = textView2;
        this.tvSection1 = textView3;
        this.tvSection2 = textView4;
        this.tvTile = textView5;
    }

    public static YdsFragmentSupDocumentGuidelinesBinding bind(View view) {
        View viewFindViewById;
        int i = C4653R.id.appBar;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null) {
            i = C4653R.id.gotItButton;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4653R.id.iv_section_1;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4653R.id.iv_section_2;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C4653R.id.scrollView;
                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                        if (scrollView != null && (viewFindViewById = view.findViewById((i = C4653R.id.shadow))) != null) {
                            i = C4653R.id.textViewDocumentGuidelinesFormatRequirement;
                            BulletTextLayout bulletTextLayout = (BulletTextLayout) view.findViewById(i);
                            if (bulletTextLayout != null) {
                                i = C4653R.id.textViewDocumentGuidelinesSecondDesc;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C4653R.id.tv_message;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C4653R.id.tv_section_1;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4653R.id.tv_section_2;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                i = C4653R.id.tv_tile;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    return new YdsFragmentSupDocumentGuidelinesBinding((ConstraintLayout) view, yotiAppbarTransparent, yotiButton, imageView, imageView2, scrollView, viewFindViewById, bulletTextLayout, textView, textView2, textView3, textView4, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentSupDocumentGuidelinesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentSupDocumentGuidelinesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_fragment_sup_document_guidelines, viewGroup, false);
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
