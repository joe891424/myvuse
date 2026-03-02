package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsReviewScreenBinding implements ViewBinding {
    public final YotiButton buttonDocumentReviewApprove;
    public final YotiButton buttonDocumentReviewCancel;
    public final YotiButton buttonDocumentReviewGuidelines;
    public final CardView card;
    public final ConstraintLayout contentContainer;
    public final NestedScrollView contentScrollContainer;
    public final FrameLayout imageContainer;
    public final ImageView imageViewDocumentReview;
    private final ConstraintLayout rootView;
    public final TextView textViewDocumentReviewConsent;
    public final TextView textViewDocumentReviewMessage;
    public final TextView textViewDocumentReviewTitle;

    private YdsReviewScreenBinding(ConstraintLayout constraintLayout, YotiButton yotiButton, YotiButton yotiButton2, YotiButton yotiButton3, CardView cardView, ConstraintLayout constraintLayout2, NestedScrollView nestedScrollView, FrameLayout frameLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonDocumentReviewApprove = yotiButton;
        this.buttonDocumentReviewCancel = yotiButton2;
        this.buttonDocumentReviewGuidelines = yotiButton3;
        this.card = cardView;
        this.contentContainer = constraintLayout2;
        this.contentScrollContainer = nestedScrollView;
        this.imageContainer = frameLayout;
        this.imageViewDocumentReview = imageView;
        this.textViewDocumentReviewConsent = textView;
        this.textViewDocumentReviewMessage = textView2;
        this.textViewDocumentReviewTitle = textView3;
    }

    public static YdsReviewScreenBinding bind(View view) {
        int i = C4608R.id.buttonDocumentReviewApprove;
        YotiButton yotiButton = (YotiButton) view.findViewById(i);
        if (yotiButton != null) {
            i = C4608R.id.buttonDocumentReviewCancel;
            YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
            if (yotiButton2 != null) {
                i = C4608R.id.buttonDocumentReviewGuidelines;
                YotiButton yotiButton3 = (YotiButton) view.findViewById(i);
                if (yotiButton3 != null) {
                    i = C4608R.id.card;
                    CardView cardView = (CardView) view.findViewById(i);
                    if (cardView != null) {
                        i = C4608R.id.contentContainer;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                        if (constraintLayout != null) {
                            i = C4608R.id.contentScrollContainer;
                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(i);
                            if (nestedScrollView != null) {
                                i = C4608R.id.imageContainer;
                                FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                                if (frameLayout != null) {
                                    i = C4608R.id.imageViewDocumentReview;
                                    ImageView imageView = (ImageView) view.findViewById(i);
                                    if (imageView != null) {
                                        i = C4608R.id.textViewDocumentReviewConsent;
                                        TextView textView = (TextView) view.findViewById(i);
                                        if (textView != null) {
                                            i = C4608R.id.textViewDocumentReviewMessage;
                                            TextView textView2 = (TextView) view.findViewById(i);
                                            if (textView2 != null) {
                                                i = C4608R.id.textViewDocumentReviewTitle;
                                                TextView textView3 = (TextView) view.findViewById(i);
                                                if (textView3 != null) {
                                                    return new YdsReviewScreenBinding((ConstraintLayout) view, yotiButton, yotiButton2, yotiButton3, cardView, constraintLayout, nestedScrollView, frameLayout, imageView, textView, textView2, textView3);
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

    public static YdsReviewScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsReviewScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_review_screen, viewGroup, false);
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
