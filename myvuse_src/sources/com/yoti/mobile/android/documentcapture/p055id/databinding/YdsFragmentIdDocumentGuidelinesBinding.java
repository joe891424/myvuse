package com.yoti.mobile.android.documentcapture.p055id.databinding;

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
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentIdDocumentGuidelinesBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonDocumentReviewGuidelinesGotIt;
    public final ImageView imageViewDocumentReviewGuidelinesClear;
    public final ImageView imageViewDocumentReviewGuidelinesFits;
    public final ImageView imageViewDocumentReviewGuidelinesNotCovered;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final TextView textViewDocumentReviewGuidelinesClear;
    public final TextView textViewDocumentReviewGuidelinesFits;
    public final TextView textViewDocumentReviewGuidelinesMessage;
    public final TextView textViewDocumentReviewGuidelinesNotCovered;
    public final TextView textViewDocumentReviewGuidelinesTitle;

    private YdsFragmentIdDocumentGuidelinesBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ScrollView scrollView, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonDocumentReviewGuidelinesGotIt = yotiButton;
        this.imageViewDocumentReviewGuidelinesClear = imageView;
        this.imageViewDocumentReviewGuidelinesFits = imageView2;
        this.imageViewDocumentReviewGuidelinesNotCovered = imageView3;
        this.scrollView = scrollView;
        this.shadow = view;
        this.textViewDocumentReviewGuidelinesClear = textView;
        this.textViewDocumentReviewGuidelinesFits = textView2;
        this.textViewDocumentReviewGuidelinesMessage = textView3;
        this.textViewDocumentReviewGuidelinesNotCovered = textView4;
        this.textViewDocumentReviewGuidelinesTitle = textView5;
    }

    public static YdsFragmentIdDocumentGuidelinesBinding bind(View view) {
        View viewFindViewById;
        int i = C4608R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4608R.id.buttonDocumentReviewGuidelinesGotIt;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4608R.id.imageViewDocumentReviewGuidelinesClear;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C4608R.id.imageViewDocumentReviewGuidelinesFits;
                    ImageView imageView2 = (ImageView) view.findViewById(i);
                    if (imageView2 != null) {
                        i = C4608R.id.imageViewDocumentReviewGuidelinesNotCovered;
                        ImageView imageView3 = (ImageView) view.findViewById(i);
                        if (imageView3 != null) {
                            i = C4608R.id.scrollView;
                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                            if (scrollView != null && (viewFindViewById = view.findViewById((i = C4608R.id.shadow))) != null) {
                                i = C4608R.id.textViewDocumentReviewGuidelinesClear;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = C4608R.id.textViewDocumentReviewGuidelinesFits;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = C4608R.id.textViewDocumentReviewGuidelinesMessage;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4608R.id.textViewDocumentReviewGuidelinesNotCovered;
                                            TextView textView4 = (TextView) view.findViewById(i);
                                            if (textView4 != null) {
                                                i = C4608R.id.textViewDocumentReviewGuidelinesTitle;
                                                TextView textView5 = (TextView) view.findViewById(i);
                                                if (textView5 != null) {
                                                    return new YdsFragmentIdDocumentGuidelinesBinding((ConstraintLayout) view, yotiAppbar, yotiButton, imageView, imageView2, imageView3, scrollView, viewFindViewById, textView, textView2, textView3, textView4, textView5);
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

    public static YdsFragmentIdDocumentGuidelinesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentIdDocumentGuidelinesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_id_document_guidelines, viewGroup, false);
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
