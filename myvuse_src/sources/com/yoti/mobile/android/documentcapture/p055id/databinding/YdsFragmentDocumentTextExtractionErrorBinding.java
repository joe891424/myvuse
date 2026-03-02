package com.yoti.mobile.android.documentcapture.p055id.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;

/* JADX INFO: loaded from: classes5.dex */
public final class YdsFragmentDocumentTextExtractionErrorBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final YotiButton buttonPrimary;
    public final CardView card;
    public final ConstraintLayout contentContainer;
    public final TextView contentText;
    public final TextView countryName;
    public final ViewPager2 documentImagePager;
    public final TabLayout documentImageTabLayout;
    public final TextView documentName;
    public final LinearLayout documentTypeBubble;
    public final FrameLayout imageContainer;
    public final RecyclerView instructionsList;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final TextView title;

    private YdsFragmentDocumentTextExtractionErrorBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, YotiButton yotiButton, CardView cardView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ViewPager2 viewPager2, TabLayout tabLayout, TextView textView3, LinearLayout linearLayout, FrameLayout frameLayout, RecyclerView recyclerView, ScrollView scrollView, View view, TextView textView4) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.buttonPrimary = yotiButton;
        this.card = cardView;
        this.contentContainer = constraintLayout2;
        this.contentText = textView;
        this.countryName = textView2;
        this.documentImagePager = viewPager2;
        this.documentImageTabLayout = tabLayout;
        this.documentName = textView3;
        this.documentTypeBubble = linearLayout;
        this.imageContainer = frameLayout;
        this.instructionsList = recyclerView;
        this.scrollView = scrollView;
        this.shadow = view;
        this.title = textView4;
    }

    public static YdsFragmentDocumentTextExtractionErrorBinding bind(View view) {
        View viewFindViewById;
        int i = C4608R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4608R.id.buttonPrimary;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4608R.id.card;
                CardView cardView = (CardView) view.findViewById(i);
                if (cardView != null) {
                    i = C4608R.id.contentContainer;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout != null) {
                        i = C4608R.id.contentText;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            i = C4608R.id.countryName;
                            TextView textView2 = (TextView) view.findViewById(i);
                            if (textView2 != null) {
                                i = C4608R.id.documentImagePager;
                                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(i);
                                if (viewPager2 != null) {
                                    i = C4608R.id.documentImageTabLayout;
                                    TabLayout tabLayout = (TabLayout) view.findViewById(i);
                                    if (tabLayout != null) {
                                        i = C4608R.id.documentName;
                                        TextView textView3 = (TextView) view.findViewById(i);
                                        if (textView3 != null) {
                                            i = C4608R.id.documentTypeBubble;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                            if (linearLayout != null) {
                                                i = C4608R.id.imageContainer;
                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                                                if (frameLayout != null) {
                                                    i = C4608R.id.instructionsList;
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                                                    if (recyclerView != null) {
                                                        i = C4608R.id.scrollView;
                                                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                                                        if (scrollView != null && (viewFindViewById = view.findViewById((i = C4608R.id.shadow))) != null) {
                                                            i = C4608R.id.title;
                                                            TextView textView4 = (TextView) view.findViewById(i);
                                                            if (textView4 != null) {
                                                                return new YdsFragmentDocumentTextExtractionErrorBinding((ConstraintLayout) view, yotiAppbar, yotiButton, cardView, constraintLayout, textView, textView2, viewPager2, tabLayout, textView3, linearLayout, frameLayout, recyclerView, scrollView, viewFindViewById, textView4);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentDocumentTextExtractionErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentDocumentTextExtractionErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4608R.layout.yds_fragment_document_text_extraction_error, viewGroup, false);
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
