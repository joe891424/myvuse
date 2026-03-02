package com.facetec.sdk;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.facetec.sdk.C2188cb;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.as */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2153as extends Fragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: B */
    ImageView f2603B;

    /* JADX INFO: renamed from: C */
    TextView f2604C;
    ImageView Code;

    /* JADX INFO: renamed from: D */
    TextView f2605D;

    /* JADX INFO: renamed from: F */
    LinearLayout f2606F;

    /* JADX INFO: renamed from: I */
    LinearLayout f2607I;

    /* JADX INFO: renamed from: L */
    TextView f2608L;

    /* JADX INFO: renamed from: S */
    TextView f2609S;

    /* JADX INFO: renamed from: V */
    ImageView f2610V;

    /* JADX INFO: renamed from: Z */
    ImageView f2611Z;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    TextView f2612a;

    /* JADX INFO: renamed from: b */
    Bitmap f2613b;

    /* JADX INFO: renamed from: c */
    C2158ax f2614c;

    /* JADX INFO: renamed from: d */
    TextView f2615d;

    /* JADX INFO: renamed from: e */
    GradientDrawable f2616e;

    /* JADX INFO: renamed from: f */
    private FrameLayout f2617f;

    /* JADX INFO: renamed from: g */
    private ImageView f2618g;

    /* JADX INFO: renamed from: h */
    private LinearLayout f2619h;

    /* JADX INFO: renamed from: i */
    private LinearLayout f2620i;

    /* JADX INFO: renamed from: j */
    private LinearLayout f2621j;

    /* JADX INFO: renamed from: k */
    private RoundedBitmapDrawable f2622k;

    /* JADX INFO: renamed from: l */
    private FrameLayout f2623l;

    /* JADX INFO: renamed from: m */
    private TextView f2624m;

    /* JADX INFO: renamed from: o */
    private boolean f2625o = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m1613Z(FragmentC2153as fragmentC2153as) {
        fragmentC2153as.f2625o = true;
        return true;
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "as#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "as#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_retry_screen_center_content_fragment, viewGroup, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f2620i = (LinearLayout) view.findViewById(C2130R.id.contentLayout);
        this.f2608L = (TextView) view.findViewById(C2130R.id.headerTextView);
        this.f2604C = (TextView) view.findViewById(C2130R.id.subheaderTextView);
        this.f2605D = (TextView) view.findViewById(C2130R.id.instructionMessage1TextView);
        this.f2609S = (TextView) view.findViewById(C2130R.id.instructionMessage2TextView);
        this.f2615d = (TextView) view.findViewById(C2130R.id.yourZoomSubimageTextView);
        this.f2612a = (TextView) view.findViewById(C2130R.id.idealZoomSubimageTextView);
        this.f2603B = (ImageView) view.findViewById(C2130R.id.yourZoomImage);
        this.f2618g = (ImageView) view.findViewById(C2130R.id.idealZoomImage);
        this.Code = (ImageView) view.findViewById(C2130R.id.idealZoomImageBorder);
        this.f2611Z = (ImageView) view.findViewById(C2130R.id.yourZoomImageBorder);
        this.f2610V = (ImageView) view.findViewById(C2130R.id.idealOval);
        this.f2614c = (C2158ax) view.findViewById(C2130R.id.idealImageSlideshowView);
        this.f2624m = (TextView) view.findViewById(C2130R.id.cancelButtonSpacer);
        this.f2617f = (FrameLayout) view.findViewById(C2130R.id.yourZoomImageContainer);
        this.f2623l = (FrameLayout) view.findViewById(C2130R.id.idealZoomImageContainer);
        this.f2607I = (LinearLayout) view.findViewById(C2130R.id.idealZoomLayout);
        this.f2606F = (LinearLayout) view.findViewById(C2130R.id.yourZoomLayout);
        this.f2619h = (LinearLayout) view.findViewById(C2130R.id.sideBySideLayout);
        this.f2621j = (LinearLayout) view.findViewById(C2130R.id.headerAndSubheaderLayout);
        if (C2156av.m1701aE().length != 0) {
            this.f2618g.setVisibility(4);
        }
        C2156av.m1655I(this.f2608L, C2156av.m1624B(true));
        C2156av.m1655I(this.f2604C, C2156av.m1661L(true));
        String strM1670S = C2156av.m1670S(true);
        String strM1641F = C2156av.m1641F(true);
        int i = AnonymousClass2.f2626I[C2140af.m1531d().ordinal()];
        if (i != 2) {
            if (i == 3) {
                this.f2609S.setVisibility(8);
            } else if (i == 4) {
                strM1670S = C2156av.m1636D(true);
                this.f2609S.setVisibility(8);
            }
            strM1641F = "";
        } else {
            this.f2605D.setVisibility(8);
            strM1670S = "";
        }
        this.f2605D.setText(strM1670S);
        this.f2609S.setText(strM1641F);
        this.f2615d.setText(C2156av.m1696a(true));
        this.f2612a.setText(C2156av.m1633C(true));
        this.f2608L.setTypeface(C2156av.m1778u());
        this.f2604C.setTypeface(C2156av.m1780w());
        this.f2605D.setTypeface(C2156av.m1782y());
        this.f2609S.setTypeface(C2156av.m1782y());
        this.f2615d.setTypeface(C2156av.m1782y());
        this.f2612a.setTypeface(C2156av.m1782y());
        this.f2608L.setLineSpacing(0.0f, C2156av.Code);
        this.f2604C.setLineSpacing(0.0f, C2156av.Code);
        this.f2605D.setLineSpacing(0.0f, C2156av.Code);
        this.f2609S.setLineSpacing(0.0f, C2156av.Code);
        this.f2608L.setTextColor(C2156av.m1659L(getActivity()));
        this.f2604C.setTextColor(C2156av.m1669S(getActivity()));
        this.f2605D.setTextColor(C2156av.m1669S(getActivity()));
        this.f2609S.setTextColor(C2156av.m1669S(getActivity()));
        this.f2615d.setTextColor(C2156av.m1669S(getActivity()));
        this.f2612a.setTextColor(C2156av.m1669S(getActivity()));
        float fM1644I = C2156av.m1644I() * C2156av.Code();
        float f = C2156av.f2649j * fM1644I;
        this.f2608L.setTextSize(2, C2156av.f2642c * fM1644I);
        this.f2604C.setTextSize(2, f);
        this.f2605D.setTextSize(2, f);
        this.f2609S.setTextSize(2, f);
        this.f2615d.setTextSize(2, f);
        this.f2612a.setTextSize(2, f);
        this.f2613b = null;
        this.f2622k = null;
        FaceTecSessionActivity faceTecSessionActivity = (FaceTecSessionActivity) getActivity();
        if (faceTecSessionActivity == null) {
            return;
        }
        if (faceTecSessionActivity.f3290aa != null) {
            this.f2613b = faceTecSessionActivity.f3290aa;
        }
        Bitmap bitmapDecodeResource = BitmapFactoryInstrumentation.decodeResource(getResources(), C2156av.m1677V(getActivity()));
        m1614B();
        this.f2618g.setImageDrawable(RoundedBitmapDrawableFactory.create(getResources(), bitmapDecodeResource));
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f2616e = gradientDrawable;
        gradientDrawable.setCornerRadius(C2188cb.m1993V((int) (C2156av.m1772o() * C2156av.Code())));
        this.f2616e.setStroke((int) C2188cb.m1993V(Math.max(C2156av.m1668S() == 0 ? 0 : 1, (int) (C2156av.m1668S() * C2156av.Code()))), C2156av.m1761g(getActivity()));
        this.f2616e.setColor(0);
        RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(getResources(), bitmapDecodeResource);
        roundedBitmapDrawableCreate.setAlpha(0);
        this.Code.setImageDrawable(roundedBitmapDrawableCreate);
        this.Code.setBackground(this.f2616e);
        this.f2611Z.setImageDrawable(roundedBitmapDrawableCreate);
        this.f2611Z.setBackground(this.f2616e);
        this.f2603B.setBackground(this.f2616e);
        this.f2618g.setBackground(this.f2616e);
        this.f2603B.setClipToOutline(true);
        this.f2618g.setClipToOutline(true);
        this.f2603B.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        this.f2618g.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        this.f2610V.setColorFilter(C2156av.m1759f(getActivity()), PorterDuff.Mode.SRC_IN);
        float fM1644I2 = C2156av.m1644I() * C2156av.Code();
        int iM1675V = C2156av.m1675V();
        int iRound = Math.round(iM1675V / 2.0f);
        int iRound2 = (int) Math.round(((double) faceTecSessionActivity.f3257S) * 0.45d);
        if (this.f2613b != null) {
            float height = r7.getHeight() / this.f2613b.getWidth();
            if (C2221j.m2231F() >= height) {
                iRound2 = Math.round((Math.round(Math.round(faceTecSessionActivity.f3245F) - (r2 * 3.0f)) / 2.0f) * height);
            }
        }
        ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) this.f2608L.getLayoutParams())).bottomMargin = Math.round(C2188cb.m1993V(5) * fM1644I2);
        int iRound3 = Math.round(C2188cb.m1993V(5) * fM1644I2);
        ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) this.f2612a.getLayoutParams())).topMargin = iRound3;
        ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) this.f2615d.getLayoutParams())).topMargin = iRound3;
        ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) this.f2619h.getLayoutParams())).topMargin = Math.round(C2188cb.m1993V(5) * fM1644I2);
        this.f2623l.getLayoutParams().height = iRound2;
        this.f2617f.getLayoutParams().height = iRound2;
        ((LinearLayout.LayoutParams) this.f2606F.getLayoutParams()).setMarginEnd(iRound);
        ((LinearLayout.LayoutParams) this.f2607I.getLayoutParams()).setMarginStart(iRound);
        view.setPadding(iM1675V, iM1675V, iM1675V, 0);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.as$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2626I;

        static {
            int[] iArr = new int[EnumC2152ar.values().length];
            f2626I = iArr;
            try {
                iArr[EnumC2152ar.LIGHTING_AND_NEUTRAL_EXPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2626I[EnumC2152ar.LIGHTING_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2626I[EnumC2152ar.NEUTRAL_EXPRESSION_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2626I[EnumC2152ar.BLURRY_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: B */
    final void m1614B() {
        int identifier;
        if (this.f2613b != null) {
            float height = r0.getHeight() / this.f2613b.getWidth();
            if (height <= 1.776f) {
                float height2 = this.f2613b.getHeight() / 1.776f;
                if (this.f2613b.getWidth() - height2 > 0.0f) {
                    this.f2613b = Bitmap.createBitmap(this.f2613b, (int) ((r1.getWidth() - height2) / 2.0f), 0, (int) height2, this.f2613b.getHeight());
                }
            } else if (height > 1.776f) {
                float width = this.f2613b.getWidth() * 1.776f;
                if (this.f2613b.getHeight() - width > 0.0f) {
                    this.f2613b = Bitmap.createBitmap(this.f2613b, 0, (int) ((r1.getHeight() - width) / 2.0f), this.f2613b.getWidth(), (int) width);
                }
            }
            int width2 = (int) (((double) this.f2613b.getWidth()) * 0.75d);
            int height3 = (int) (((double) this.f2613b.getHeight()) * 0.75d);
            Bitmap bitmap = this.f2613b;
            this.f2613b = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - width2) / 2, (this.f2613b.getHeight() - height3) / 2, width2, height3);
            this.f2622k = RoundedBitmapDrawableFactory.create(getResources(), this.f2613b);
        }
        if (m1610B(EnumC2177bq.YOUR_ZOOM_IMAGE_OVERRIDE) && (identifier = getResources().getIdentifier("zoom_your_zoom_image_override", "drawable", getActivity().getPackageName())) != 0) {
            this.f2613b = BitmapFactoryInstrumentation.decodeResource(getResources(), identifier);
            this.f2622k = RoundedBitmapDrawableFactory.create(getResources(), this.f2613b);
        }
        this.f2603B.setImageDrawable(this.f2622k);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        new Handler().postDelayed(new AnonymousClass4(this), 100L);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.as$4, reason: invalid class name */
    final class AnonymousClass4 extends AbstractRunnableC2150ap implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass4(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2153as.m1611I(FragmentC2153as.this);
            FragmentC2153as.this.f2608L.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (FragmentC2153as.this.f2625o) {
                return;
            }
            FragmentC2153as.m1613Z(FragmentC2153as.this);
            FragmentC2153as.m1611I(FragmentC2153as.this);
        }
    }

    /* JADX INFO: renamed from: B */
    private static boolean m1610B(EnumC2177bq enumC2177bq) {
        for (int i = 0; i < C2185by.f3002V.length(); i++) {
            try {
                JSONObject jSONObject = C2185by.f3002V.getJSONObject(i);
                String string = jSONObject.getString("overrideKey");
                EnumC2177bq enumC2177bq2 = (EnumC2177bq) jSONObject.get("type");
                if (FaceTecSDK.f2235I.f2219a.get(string) != null && FaceTecSDK.f2235I.f2219a.get(string).equals(jSONObject.getString("overrideValue")) && enumC2177bq2 == enumC2177bq) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1611I(FragmentC2153as fragmentC2153as) {
        float fCode = C2156av.Code() * C2156av.m1644I();
        int iRound = Math.round(C2156av.m1675V() * C2156av.Code());
        double measuredHeight = fragmentC2153as.f2620i.getMeasuredHeight();
        int iRound2 = (int) Math.round(0.06d * measuredHeight);
        if (C2221j.m2231F() < 1.4d && Resources.getSystem().getDisplayMetrics().heightPixels < 900) {
            iRound2 = (int) Math.round(measuredHeight * 0.07d);
        }
        int iRound3 = (int) Math.round(((double) iRound2) * 0.85d);
        int iRound4 = (int) Math.round(((double) iRound3) * 0.85d);
        int height = fragmentC2153as.f2618g.getHeight() + iRound4 + ((ViewGroup.MarginLayoutParams) ((LinearLayout.LayoutParams) fragmentC2153as.f2612a.getLayoutParams())).topMargin;
        fragmentC2153as.f2621j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) fragmentC2153as.f2619h.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams).height = height;
        layoutParams.weight = 0.0f;
        fragmentC2153as.f2619h.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) fragmentC2153as.f2608L.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams2).height = iRound2;
        layoutParams2.weight = 0.0f;
        fragmentC2153as.f2608L.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) fragmentC2153as.f2604C.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams3).height = iRound3;
        layoutParams3.weight = 0.0f;
        fragmentC2153as.f2604C.setLayoutParams(layoutParams3);
        fragmentC2153as.f2605D.setLayoutParams(layoutParams3);
        fragmentC2153as.f2609S.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) fragmentC2153as.f2612a.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams4).height = iRound4;
        fragmentC2153as.f2612a.setLayoutParams(layoutParams4);
        fragmentC2153as.f2615d.setLayoutParams(layoutParams4);
        int width = fragmentC2153as.f2608L.getWidth();
        if (C2156av.m1717aU()) {
            int iRound5 = Math.round(C2188cb.m1993V(C2156av.f2639Z) * fCode);
            int[] iArr = new int[2];
            fragmentC2153as.f2624m.getLocationInWindow(iArr);
            int iRound6 = (int) (((long) (iArr[1] + iRound5)) - Math.round(((double) iRound) / 2.0d));
            int[] iArr2 = new int[2];
            fragmentC2153as.f2608L.getLocationInWindow(iArr2);
            if (iArr2[1] < iRound6) {
                width -= iRound5 << 1;
            }
        }
        C2188cb.V v = new C2188cb.V(width, iRound2);
        C2188cb.V v2 = new C2188cb.V(fragmentC2153as.f2604C.getWidth(), iRound3);
        C2188cb.V v3 = new C2188cb.V(fragmentC2153as.f2605D.getWidth(), iRound3);
        C2188cb.V v4 = new C2188cb.V(fragmentC2153as.f2609S.getWidth(), iRound3);
        C2188cb.V v5 = new C2188cb.V(fragmentC2153as.f2612a.getWidth(), iRound4);
        C2188cb.V v6 = new C2188cb.V(fragmentC2153as.f2615d.getWidth(), iRound4);
        int iRound7 = Math.round(C2188cb.m1986B(8));
        int iRound8 = Math.round(C2188cb.m1986B(40));
        int iRound9 = Math.round(C2188cb.m1986B(5));
        int iRound10 = Math.round(C2188cb.m1986B(36));
        int iM1990I = C2188cb.m1990I(fragmentC2153as.f2608L, v, iRound7, iRound8);
        int iM1990I2 = C2188cb.m1990I(fragmentC2153as.f2604C, v2, iRound9, iRound10);
        int iM1990I3 = C2188cb.m1990I(fragmentC2153as.f2605D, v3, iRound9, iRound10);
        int iM1990I4 = C2188cb.m1990I(fragmentC2153as.f2609S, v4, iRound9, iRound10);
        int iM1990I5 = C2188cb.m1990I(fragmentC2153as.f2612a, v5, iRound9, iRound10);
        int iM1990I6 = C2188cb.m1990I(fragmentC2153as.f2615d, v6, iRound9, iRound10);
        int iRound11 = (int) Math.round(((double) iM1990I) * 0.85d);
        if (iM1990I2 >= iRound11) {
            iM1990I2 = iRound11;
        }
        if (fragmentC2153as.f2605D.getText().toString().isEmpty() || iM1990I3 >= iM1990I2) {
            iM1990I3 = iM1990I2;
        }
        if (fragmentC2153as.f2609S.getText().toString().isEmpty() || iM1990I4 >= iM1990I3) {
            iM1990I4 = iM1990I3;
        }
        int iRound12 = (int) Math.round(((double) iM1990I4) * 0.85d);
        if (iM1990I5 >= iM1990I4) {
            iM1990I5 = iRound12;
        }
        if (iM1990I6 >= iM1990I4) {
            iM1990I6 = iM1990I5;
        }
        fragmentC2153as.f2608L.setTextSize(0, iM1990I);
        float f = iM1990I4;
        fragmentC2153as.f2604C.setTextSize(0, f);
        fragmentC2153as.f2605D.setTextSize(0, f);
        fragmentC2153as.f2609S.setTextSize(0, f);
        float f2 = iM1990I6;
        fragmentC2153as.f2612a.setTextSize(0, f2);
        fragmentC2153as.f2615d.setTextSize(0, f2);
    }
}
