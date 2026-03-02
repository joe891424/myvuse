package com.facetec.sdk;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

/* JADX INFO: loaded from: classes3.dex */
public final class GuidanceCenterContentFragment extends Fragment implements ViewTreeObserver.OnGlobalLayoutListener, TraceFieldInterface {

    /* JADX INFO: renamed from: B */
    protected TextView f2251B;

    /* JADX INFO: renamed from: C */
    protected TextView f2252C;
    protected LinearLayout Code;

    /* JADX INFO: renamed from: D */
    protected LinearLayout f2253D;

    /* JADX INFO: renamed from: F */
    protected TextView f2254F;

    /* JADX INFO: renamed from: I */
    protected TextView f2255I;

    /* JADX INFO: renamed from: L */
    protected TextView f2256L;

    /* JADX INFO: renamed from: S */
    protected C2133Z f2257S;

    /* JADX INFO: renamed from: V */
    protected TextView f2258V;

    /* JADX INFO: renamed from: Z */
    protected ImageView f2259Z;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    protected GradientDrawable f2260a;

    /* JADX INFO: renamed from: b */
    protected RelativeLayout f2261b;

    /* JADX INFO: renamed from: c */
    protected GradientDrawable f2262c;

    /* JADX INFO: renamed from: d */
    protected RelativeLayout f2263d;

    /* JADX INFO: renamed from: e */
    View f2264e;

    /* JADX INFO: renamed from: f */
    private ScreenType f2265f;

    /* JADX INFO: renamed from: g */
    private boolean f2266g = false;

    /* JADX INFO: renamed from: h */
    private TextView f2267h;

    /* JADX INFO: renamed from: i */
    private TextView f2268i;

    /* JADX INFO: renamed from: j */
    private RelativeLayout f2269j;

    protected enum ScreenType {
        GENERIC,
        READY_OVAL
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GuidanceCenterContentFragment#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "GuidanceCenterContentFragment#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_guidance_center_content_fragment, viewGroup, false);
        this.f2264e = viewInflate;
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(C2130R.id.feedbackIconsLayout);
        this.Code = (LinearLayout) view.findViewById(C2130R.id.zoomIconLayout);
        this.f2259Z = (ImageView) view.findViewById(C2130R.id.zoomDialogImage);
        TextView textView = (TextView) view.findViewById(C2130R.id.genericHeaderView);
        this.f2255I = textView;
        C2156av.m1693Z(textView);
        this.f2255I.setTypeface(C2170bj.f2829B);
        this.f2255I.setLineSpacing(0.0f, C2156av.Code);
        TextView textView2 = (TextView) view.findViewById(C2130R.id.feedbackIconsHeader);
        this.f2267h = textView2;
        C2156av.m1693Z(textView2);
        this.f2267h.setTypeface(C2170bj.f2829B);
        this.f2267h.setLineSpacing(0.0f, C2156av.Code);
        this.f2251B = (TextView) view.findViewById(C2130R.id.zoomDialogText1);
        this.f2268i = (TextView) view.findViewById(C2130R.id.zoomDialogText2);
        this.f2251B.setTypeface(C2170bj.f2830I);
        this.f2268i.setTypeface(C2170bj.f2830I);
        C2156av.m1693Z(this.f2251B);
        C2156av.m1693Z(this.f2268i);
        this.f2251B.setLineSpacing(0.0f, C2156av.Code);
        this.f2268i.setLineSpacing(0.0f, C2156av.Code);
        this.f2269j = (RelativeLayout) view.findViewById(C2130R.id.readyScreenContent);
        this.f2258V = (TextView) view.findViewById(C2130R.id.readyScreenHeader1);
        this.f2254F = (TextView) view.findViewById(C2130R.id.readyScreenHeader2);
        this.f2256L = (TextView) view.findViewById(C2130R.id.readyScreenSubtext1);
        this.f2252C = (TextView) view.findViewById(C2130R.id.readyScreenSubtext2);
        this.f2261b = (RelativeLayout) view.findViewById(C2130R.id.readyScreenHeaderOuterContainer);
        this.f2263d = (RelativeLayout) view.findViewById(C2130R.id.readyScreenSubtextOuterContainer);
        this.f2253D = (LinearLayout) view.findViewById(C2130R.id.readyScreenHeaderInnerContainer);
        this.f2257S = (C2133Z) view.findViewById(C2130R.id.readyScreenSubtextInnerContainer);
        this.f2258V.setTypeface(C2156av.m1781x());
        this.f2254F.setTypeface(C2156av.m1781x());
        this.f2256L.setTypeface(C2156av.m1780w());
        this.f2252C.setTypeface(C2156av.m1780w());
        this.f2258V.setTextColor(C2156av.m1635D(getActivity()));
        this.f2254F.setTextColor(C2156av.m1635D(getActivity()));
        this.f2256L.setTextColor(C2156av.m1632C(getActivity()));
        this.f2252C.setTextColor(C2156av.m1632C(getActivity()));
        this.f2258V.setLineSpacing(0.0f, C2156av.Code);
        this.f2254F.setLineSpacing(0.0f, C2156av.Code);
        this.f2256L.setLineSpacing(0.0f, C2156av.Code);
        this.f2252C.setLineSpacing(0.0f, C2156av.Code);
        float fM1644I = C2156av.m1644I() * C2156av.Code();
        this.f2258V.setTextSize(2, C2156av.f2644e * fM1644I);
        this.f2254F.setTextSize(2, C2156av.f2644e * fM1644I);
        this.f2256L.setTextSize(2, C2156av.f2640a * fM1644I);
        this.f2252C.setTextSize(2, C2156av.f2640a * fM1644I);
        this.f2255I.setTextSize(2, C2156av.f2643d * fM1644I);
        this.f2267h.setTextSize(2, C2156av.f2643d * fM1644I);
        this.f2251B.setTextSize(2, C2156av.f2641b * fM1644I);
        int iM1675V = C2156av.m1675V();
        view.setPadding(iM1675V, iM1675V, iM1675V, 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2261b.getLayoutParams();
        layoutParams.setMarginStart(iM1675V);
        layoutParams.setMarginEnd(iM1675V);
        this.f2261b.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2263d.getLayoutParams();
        layoutParams2.setMarginStart(iM1675V);
        layoutParams2.setMarginEnd(iM1675V);
        this.f2263d.setLayoutParams(layoutParams2);
        ScreenType screenType = (ScreenType) getArguments().get("screenType");
        this.f2265f = screenType;
        if (screenType == ScreenType.GENERIC) {
            C2157aw.Code(this.f2255I, getArguments().getInt("header"));
        } else {
            C2157aw.Code(this.f2267h, getArguments().getInt("header"));
        }
        if (this.f2265f == ScreenType.GENERIC) {
            C2157aw.Code(this.f2251B, getArguments().getInt("message"));
        } else if (this.f2265f == ScreenType.READY_OVAL) {
            this.f2269j.setVisibility(0);
            C2156av.m1655I(this.f2258V, C2156av.Code(true));
            C2156av.m1655I(this.f2254F, C2156av.m1650I(true));
            C2156av.m1655I(this.f2256L, C2156av.m1680V(true));
            C2156av.m1655I(this.f2252C, C2156av.m1690Z(true));
            GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(C2130R.drawable.facetec_ready_header_background).mutate();
            this.f2260a = gradientDrawable;
            gradientDrawable.setCornerRadius(C2188cb.m1993V(C2156av.m1770m()) * C2156av.Code());
            C2156av.m1625B(getActivity(), this.f2260a, C2156av.m1618A());
            GradientDrawable gradientDrawable2 = (GradientDrawable) getResources().getDrawable(C2130R.drawable.facetec_ready_subtext_background).mutate();
            this.f2262c = gradientDrawable2;
            gradientDrawable2.setCornerRadius(C2188cb.m1993V(C2156av.m1770m()) * C2156av.Code());
            C2156av.m1625B(getActivity(), this.f2262c, C2156av.m1618A());
            this.f2261b.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.Code.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams3).height = Math.round(C2188cb.m1993V(C2156av.f2638V) * fM1644I);
        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = iM1675V;
        this.Code.setLayoutParams(layoutParams3);
        ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) this.f2255I.getLayoutParams())).bottomMargin = iM1675V;
    }

    /* JADX INFO: renamed from: V */
    protected static GuidanceCenterContentFragment m1411V(int i, int i2, ScreenType screenType, float f, float f2) {
        GuidanceCenterContentFragment guidanceCenterContentFragment = new GuidanceCenterContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("header", i);
        bundle.putInt("message", i2);
        bundle.putSerializable("screenType", screenType);
        bundle.putFloat("topOval", f);
        bundle.putFloat("bottomOval", f2);
        guidanceCenterContentFragment.setArguments(bundle);
        return guidanceCenterContentFragment;
    }

    /* JADX INFO: renamed from: Z */
    protected final void m1412Z(int i) {
        String[] strArrSplit = C2157aw.m1784I(i).split("\n\n");
        if (strArrSplit.length == 2) {
            this.f2251B.setText(strArrSplit[0]);
            this.f2268i.setText(strArrSplit[1]);
            this.f2268i.setVisibility(0);
        } else {
            C2157aw.Code(this.f2251B, i);
            this.f2268i.setVisibility(8);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f2266g) {
            return;
        }
        this.f2266g = true;
        this.f2261b.post(new C2224n(this, this));
    }
}
