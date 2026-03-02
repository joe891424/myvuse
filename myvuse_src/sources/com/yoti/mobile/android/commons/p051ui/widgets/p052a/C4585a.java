package com.yoti.mobile.android.commons.p051ui.widgets.p052a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commons.p051ui.widgets.C4584R;

/* JADX INFO: renamed from: com.yoti.mobile.android.commons.ui.widgets.a.a */
/* JADX INFO: loaded from: classes5.dex */
public final class C4585a implements ViewBinding {

    /* JADX INFO: renamed from: a */
    private final ConstraintLayout f6582a;

    /* JADX INFO: renamed from: b */
    public final YotiButton f6583b;

    /* JADX INFO: renamed from: c */
    public final YotiButton f6584c;

    /* JADX INFO: renamed from: d */
    public final YotiButton f6585d;

    /* JADX INFO: renamed from: e */
    public final YotiButton f6586e;

    /* JADX INFO: renamed from: f */
    public final TextView f6587f;

    /* JADX INFO: renamed from: g */
    public final TextView f6588g;

    /* JADX INFO: renamed from: h */
    public final ImageView f6589h;

    /* JADX INFO: renamed from: i */
    public final ImageView f6590i;

    private C4585a(ConstraintLayout constraintLayout, Barrier barrier, YotiButton yotiButton, YotiButton yotiButton2, YotiButton yotiButton3, YotiButton yotiButton4, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        this.f6582a = constraintLayout;
        this.f6583b = yotiButton;
        this.f6584c = yotiButton2;
        this.f6585d = yotiButton3;
        this.f6586e = yotiButton4;
        this.f6587f = textView;
        this.f6588g = textView2;
        this.f6589h = imageView;
        this.f6590i = imageView2;
    }

    /* JADX INFO: renamed from: a */
    public static C4585a m4686a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C4584R.layout.view_education_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return m4687a(viewInflate);
    }

    /* JADX INFO: renamed from: a */
    public static C4585a m4687a(View view) {
        int i = C4584R.id.buttonBarrier;
        Barrier barrier = (Barrier) view.findViewById(i);
        if (barrier != null) {
            i = C4584R.id.cardButtonMedium;
            YotiButton yotiButton = (YotiButton) view.findViewById(i);
            if (yotiButton != null) {
                i = C4584R.id.cardButtonSmall;
                YotiButton yotiButton2 = (YotiButton) view.findViewById(i);
                if (yotiButton2 != null) {
                    i = C4584R.id.cardLinkMedium;
                    YotiButton yotiButton3 = (YotiButton) view.findViewById(i);
                    if (yotiButton3 != null) {
                        i = C4584R.id.cardLinkSmall;
                        YotiButton yotiButton4 = (YotiButton) view.findViewById(i);
                        if (yotiButton4 != null) {
                            i = C4584R.id.cardText;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C4584R.id.cardTitle;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C4584R.id.centerCardIcon;
                                    ImageView imageView = (ImageView) view.findViewById(i);
                                    if (imageView != null) {
                                        i = C4584R.id.startCardIcon;
                                        ImageView imageView2 = (ImageView) view.findViewById(i);
                                        if (imageView2 != null) {
                                            return new C4585a((ConstraintLayout) view, barrier, yotiButton, yotiButton2, yotiButton3, yotiButton4, textView, textView2, imageView, imageView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f6582a;
    }
}
