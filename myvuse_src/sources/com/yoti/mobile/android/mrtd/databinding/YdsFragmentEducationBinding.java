package com.yoti.mobile.android.mrtd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.mrtd.C4900R;

/* JADX INFO: loaded from: classes4.dex */
public final class YdsFragmentEducationBinding implements ViewBinding {
    public final YotiAppbar appBar;
    public final CardView card;
    public final TextView nfcEducationDescription;
    public final TextView nfcEducationTitle;
    public final VideoView nfcEducationVideo;
    public final YotiButton nfcStartButton;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final View shadow;

    private YdsFragmentEducationBinding(ConstraintLayout constraintLayout, YotiAppbar yotiAppbar, CardView cardView, TextView textView, TextView textView2, VideoView videoView, YotiButton yotiButton, ScrollView scrollView, View view) {
        this.rootView = constraintLayout;
        this.appBar = yotiAppbar;
        this.card = cardView;
        this.nfcEducationDescription = textView;
        this.nfcEducationTitle = textView2;
        this.nfcEducationVideo = videoView;
        this.nfcStartButton = yotiButton;
        this.scrollView = scrollView;
        this.shadow = view;
    }

    public static YdsFragmentEducationBinding bind(View view) {
        View viewFindViewById;
        int i = C4900R.id.appBar;
        YotiAppbar yotiAppbar = (YotiAppbar) view.findViewById(i);
        if (yotiAppbar != null) {
            i = C4900R.id.card;
            CardView cardView = (CardView) view.findViewById(i);
            if (cardView != null) {
                i = C4900R.id.nfcEducationDescription;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C4900R.id.nfcEducationTitle;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C4900R.id.nfcEducationVideo;
                        VideoView videoView = (VideoView) view.findViewById(i);
                        if (videoView != null) {
                            i = C4900R.id.nfcStartButton;
                            YotiButton yotiButton = (YotiButton) view.findViewById(i);
                            if (yotiButton != null) {
                                i = C4900R.id.scrollView;
                                ScrollView scrollView = (ScrollView) view.findViewById(i);
                                if (scrollView != null && (viewFindViewById = view.findViewById((i = C4900R.id.shadow))) != null) {
                                    return new YdsFragmentEducationBinding((ConstraintLayout) view, yotiAppbar, cardView, textView, textView2, videoView, yotiButton, scrollView, viewFindViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static YdsFragmentEducationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YdsFragmentEducationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4900R.layout.yds_fragment_education, viewGroup, false);
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
