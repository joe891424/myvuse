package com.yoti.mobile.android.liveness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.liveness.C4871R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentLivenessEducationalBinding implements ViewBinding {
    public final YotiAppbarTransparent appBar;
    public final YotiButton buttonLivenessEducationalMoreAbout;
    public final YotiButton buttonStartScan;
    public final YotiButton guidelines;
    public final ImageView imageEye;
    public final ImageView imageSunlight;
    public final ImageView imageView;
    public final FrameLayout mediaContainer;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;
    public final TextView textViewLivenessEducationGuidelineEyeLevel;
    public final TextView textViewLivenessEducationGuidelineGoodLighting;
    public final TextView textViewLivenessEducationGuidelineTitle;
    public final TextView textViewLivenessEducationalMessage;
    public final TextView textViewLivenessEducationalTitle;
    public final CardView videoCardView;
    public final VideoView videoView;

    private YdsFragmentLivenessEducationalBinding(ConstraintLayout constraintLayout, YotiAppbarTransparent yotiAppbarTransparent, YotiButton yotiButton, YotiButton yotiButton2, YotiButton yotiButton3, ImageView imageView, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout, ScrollView scrollView, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CardView cardView, VideoView videoView) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbarTransparent;
        this.buttonLivenessEducationalMoreAbout = yotiButton;
        this.buttonStartScan = yotiButton2;
        this.guidelines = yotiButton3;
        this.imageEye = imageView;
        this.imageSunlight = imageView2;
        this.imageView = imageView3;
        this.mediaContainer = frameLayout;
        this.scrollView = scrollView;
        this.shadow = view;
        this.textViewLivenessEducationGuidelineEyeLevel = textView;
        this.textViewLivenessEducationGuidelineGoodLighting = textView2;
        this.textViewLivenessEducationGuidelineTitle = textView3;
        this.textViewLivenessEducationalMessage = textView4;
        this.textViewLivenessEducationalTitle = textView5;
        this.videoCardView = cardView;
        this.videoView = videoView;
    }

    public static YdsFragmentLivenessEducationalBinding bind(View view) {
        View viewFindViewById;
        int i = C4871R.id.appBar;
        YotiAppbarTransparent yotiAppbarTransparent = (YotiAppbarTransparent) view.findViewById(i);
        if (yotiAppbarTransparent != null) {
            i = C4871R.id.buttonLivenessEducationalMoreAbout;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4871R.id.buttonStartScan;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4871R.id.guidelines;
                    YotiButton yotiButton3 = (YotiButton) view.findViewById(i);
                    if (yotiButton3 != null) {
                        i = C4871R.id.imageEye;
                        ImageView imageView = (ImageView) view.findViewById(i);
                        if (imageView != null) {
                            i = C4871R.id.imageSunlight;
                            ImageView imageView2 = (ImageView) view.findViewById(i);
                            if (imageView2 != null) {
                                i = C4871R.id.imageView;
                                ImageView imageView3 = (ImageView) view.findViewById(i);
                                if (imageView3 != null) {
                                    i = C4871R.id.mediaContainer;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(i);
                                    if (frameLayout != null) {
                                        i = C4871R.id.scrollView;
                                        ScrollView scrollView = (ScrollView) view.findViewById(i);
                                        if (scrollView != null && (viewFindViewById = view.findViewById((i = C4871R.id.shadow))) != null) {
                                            i = C4871R.id.textViewLivenessEducationGuidelineEyeLevel;
                                            TextView textView = (TextView) view.findViewById(i);
                                            if (textView != null) {
                                                i = C4871R.id.textViewLivenessEducationGuidelineGoodLighting;
                                                TextView textView2 = (TextView) view.findViewById(i);
                                                if (textView2 != null) {
                                                    i = C4871R.id.textViewLivenessEducationGuidelineTitle;
                                                    TextView textView3 = (TextView) view.findViewById(i);
                                                    if (textView3 != null) {
                                                        i = C4871R.id.textViewLivenessEducationalMessage;
                                                        TextView textView4 = (TextView) view.findViewById(i);
                                                        if (textView4 != null) {
                                                            i = C4871R.id.textViewLivenessEducationalTitle;
                                                            TextView textView5 = (TextView) view.findViewById(i);
                                                            if (textView5 != null) {
                                                                i = C4871R.id.videoCardView;
                                                                CardView cardView = (CardView) view.findViewById(i);
                                                                if (cardView != null) {
                                                                    i = C4871R.id.videoView;
                                                                    VideoView videoView = (VideoView) view.findViewById(i);
                                                                    if (videoView != null) {
                                                                        return new YdsFragmentLivenessEducationalBinding((ConstraintLayout) view, yotiAppbarTransparent, yotiButton, yotiButton2, yotiButton3, imageView, imageView2, imageView3, frameLayout, scrollView, viewFindViewById, textView, textView2, textView3, textView4, textView5, cardView, videoView);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentLivenessEducationalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentLivenessEducationalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4871R.layout.yds_fragment_liveness_educational, viewGroup, false);
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
