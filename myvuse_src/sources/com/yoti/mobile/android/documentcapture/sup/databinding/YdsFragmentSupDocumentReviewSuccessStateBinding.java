package com.yoti.mobile.android.documentcapture.sup.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.sup.C4653R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentSupDocumentReviewSuccessStateBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonDocumentReviewApprove;
    public final YotiButton buttonDocumentReviewCancel;
    public final FrameLayout documentImageLayout;
    public final ImageView icPoweredBy;
    public final IndefinitePagerIndicator indicatorLayout;
    public final TextView nonIdDocumentReviewHeader;
    public final ViewPager2 previewImagePager;
    private final ConstraintLayout rootView;

    private YdsFragmentSupDocumentReviewSuccessStateBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, YotiButton yotiButton2, FrameLayout frameLayout, ImageView imageView, IndefinitePagerIndicator indefinitePagerIndicator, TextView textView, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonDocumentReviewApprove = yotiButton;
        this.buttonDocumentReviewCancel = yotiButton2;
        this.documentImageLayout = frameLayout;
        this.icPoweredBy = imageView;
        this.indicatorLayout = indefinitePagerIndicator;
        this.nonIdDocumentReviewHeader = textView;
        this.previewImagePager = viewPager2;
    }

    public static YdsFragmentSupDocumentReviewSuccessStateBinding bind(View view) {
        int i = C4653R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4653R.id.buttonDocumentReviewApprove;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4653R.id.buttonDocumentReviewCancel;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4653R.id.document_image_layout;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                    if (frameLayout != null) {
                        i = C4653R.id.ic_powered_by;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = C4653R.id.indicatorLayout;
                            IndefinitePagerIndicator indefinitePagerIndicator = (IndefinitePagerIndicator) view.findViewById(i);
                            if (indefinitePagerIndicator != null) {
                                i = C4653R.id.non_id_document_review_header;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C4653R.id.previewImagePager;
                                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
                                    if (viewPager2 != null) {
                                        return new YdsFragmentSupDocumentReviewSuccessStateBinding((ConstraintLayout) view, yotiAppbar, yotiButton, yotiButton2, frameLayout, imageView, indefinitePagerIndicator, textView, viewPager2);
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

    public static YdsFragmentSupDocumentReviewSuccessStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentSupDocumentReviewSuccessStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4653R.layout.yds_fragment_sup_document_review_success_state, viewGroup, false);
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
