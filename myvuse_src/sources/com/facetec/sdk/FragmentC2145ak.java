package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Constants;

/* JADX INFO: renamed from: com.facetec.sdk.ak */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2145ak extends Fragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: N */
    private static /* synthetic */ boolean f2439N = true;

    /* JADX INFO: renamed from: s */
    private static final Handler f2440s = new Handler();

    /* JADX INFO: renamed from: u */
    private static final Handler f2441u = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: B */
    protected View f2443B;

    /* JADX INFO: renamed from: C */
    protected RelativeLayout f2444C;
    protected ProgressBar Code;

    /* JADX INFO: renamed from: D */
    protected RelativeLayout f2445D;

    /* JADX INFO: renamed from: F */
    protected RelativeLayout f2447F;

    /* JADX INFO: renamed from: I */
    protected TextView f2450I;

    /* JADX INFO: renamed from: L */
    protected ImageView f2451L;

    /* JADX INFO: renamed from: S */
    protected ImageView f2452S;

    /* JADX INFO: renamed from: V */
    protected TextView f2453V;

    /* JADX INFO: renamed from: Z */
    protected ImageView f2454Z;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    protected RelativeLayout f2455a;

    /* JADX INFO: renamed from: b */
    protected ObjectAnimator f2456b;

    /* JADX INFO: renamed from: c */
    protected ImageView f2457c;

    /* JADX INFO: renamed from: d */
    protected LinearLayout f2458d;

    /* JADX INFO: renamed from: e */
    protected TextView f2459e;

    /* JADX INFO: renamed from: f */
    protected ImageView f2460f;

    /* JADX INFO: renamed from: i */
    protected C2162bb f2463i;

    /* JADX INFO: renamed from: k */
    AnimatedVectorDrawableCompat f2465k;

    /* JADX INFO: renamed from: l */
    Animatable2Compat.AnimationCallback f2466l;

    /* JADX INFO: renamed from: m */
    AnimatedVectorDrawableCompat f2467m;

    /* JADX INFO: renamed from: p */
    private TextView f2470p;

    /* JADX INFO: renamed from: q */
    private ImageView f2471q;

    /* JADX INFO: renamed from: r */
    private FrameLayout f2472r;

    /* JADX INFO: renamed from: t */
    private LayerDrawable f2473t;

    /* JADX INFO: renamed from: w */
    private boolean f2475w = false;

    /* JADX INFO: renamed from: h */
    protected boolean f2462h = false;

    /* JADX INFO: renamed from: v */
    private boolean f2474v = false;

    /* JADX INFO: renamed from: x */
    private boolean f2476x = false;

    /* JADX INFO: renamed from: g */
    protected boolean f2461g = false;

    /* JADX INFO: renamed from: j */
    protected long f2464j = -1;

    /* JADX INFO: renamed from: o */
    protected Z f2469o = Z.UPLOAD_STARTED;

    /* JADX INFO: renamed from: n */
    protected V f2468n = V.DEFAULT;

    /* JADX INFO: renamed from: y */
    private final AbstractRunnableC2150ap f2477y = new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.1
        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            AbstractActivityC2220h abstractActivityC2220h = (AbstractActivityC2220h) FragmentC2145ak.this.getActivity();
            if (abstractActivityC2220h != null) {
                abstractActivityC2220h.mo2201h();
            }
        }
    };

    /* JADX INFO: renamed from: z */
    private final AbstractRunnableC2150ap f2478z = new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.2
        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2145ak.f2441u == null || FragmentC2145ak.this.f2461g) {
                return;
            }
            FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
            FragmentC2145ak.this.f2469o = Z.UPLOAD_STARTED;
            FragmentC2145ak.m1571V(FragmentC2145ak.this, false);
            FragmentC2145ak.f2441u.postDelayed(FragmentC2145ak.this.f2446E, FragmentC2145ak.this.f2462h ? 8000L : 6000L);
        }
    };

    /* JADX INFO: renamed from: E */
    private final AbstractRunnableC2150ap f2446E = new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.10
        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2145ak.f2441u == null || FragmentC2145ak.this.f2461g) {
                return;
            }
            FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
            FragmentC2145ak.this.f2469o = Z.STILL_UPLOADING;
            FragmentC2145ak.m1571V(FragmentC2145ak.this, true);
        }
    };

    /* JADX INFO: renamed from: G */
    private final AbstractRunnableC2150ap f2448G = new AnonymousClass9(this);

    /* JADX INFO: renamed from: A */
    private final AbstractRunnableC2150ap f2442A = new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.7
        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2145ak.f2441u == null) {
                return;
            }
            FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
            if (FragmentC2145ak.this.f2461g) {
                return;
            }
            FragmentC2145ak.this.f2469o = Z.UPLOAD_COMPLETE_AWAITING_PROCESSING;
            FragmentC2145ak.m1571V(FragmentC2145ak.this, true);
            FragmentC2145ak.f2441u.postDelayed(FragmentC2145ak.this.f2449H, 1000L);
        }
    };

    /* JADX INFO: renamed from: H */
    private final AbstractRunnableC2150ap f2449H = new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.6
        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2145ak.f2441u == null) {
                return;
            }
            FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
            FragmentC2145ak.this.f2461g = true;
        }
    };

    /* JADX INFO: renamed from: com.facetec.sdk.ak$V */
    enum V {
        DEFAULT,
        FRONT_SIDE,
        BACK_SIDE,
        USER_CONFIRMED_INFO,
        NFC
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$Z */
    enum Z {
        UPLOAD_STARTED,
        STILL_UPLOADING,
        UPLOAD_COMPLETE_AWAITING_RESPONSE,
        UPLOAD_COMPLETE_AWAITING_PROCESSING
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

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ boolean m1574Z(FragmentC2145ak fragmentC2145ak) {
        fragmentC2145ak.f2475w = true;
        return true;
    }

    /* JADX INFO: renamed from: I */
    static FragmentC2145ak m1568I(boolean z, V v) {
        FragmentC2145ak fragmentC2145ak = new FragmentC2145ak();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isIDScan", z);
        bundle.putSerializable("uploadType", v);
        fragmentC2145ak.setArguments(bundle);
        return fragmentC2145ak;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        TraceMachine.startTracing("ak");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ak#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ak#onCreate", null);
        }
        super.onCreate(bundle);
        f2440s.postDelayed(this.f2477y, 600000L);
        TraceMachine.exitMethod();
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ak#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "ak#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_results_fragment, viewGroup, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f2462h = getArguments().getBoolean("isIDScan");
        this.f2468n = (V) getArguments().get("uploadType");
        this.f2469o = Z.UPLOAD_STARTED;
        this.f2454Z = (ImageView) view.findViewById(C2130R.id.activityIndicatorImageView);
        this.Code = (ProgressBar) view.findViewById(C2130R.id.uploadProgressBar);
        this.f2453V = (TextView) view.findViewById(C2130R.id.progressTextView);
        this.f2450I = (TextView) view.findViewById(C2130R.id.resultTextView);
        this.f2443B = view.findViewById(C2130R.id.zoomResultBackground);
        this.f2445D = (RelativeLayout) view.findViewById(C2130R.id.progressBarLayout);
        this.f2444C = (RelativeLayout) view.findViewById(C2130R.id.zoomResultLayout);
        this.f2447F = (RelativeLayout) view.findViewById(C2130R.id.zoomResultContainer);
        this.f2452S = (ImageView) view.findViewById(C2130R.id.resultAnimationBackground);
        this.f2451L = (ImageView) view.findViewById(C2130R.id.resultAnimationForeground);
        this.f2472r = (FrameLayout) view.findViewById(C2130R.id.resultFrame);
        this.f2458d = (LinearLayout) view.findViewById(C2130R.id.devModeTagLayout);
        this.f2470p = (TextView) view.findViewById(C2130R.id.devModeTagTextView);
        this.f2471q = (ImageView) view.findViewById(C2130R.id.devModeTagImageView);
        this.f2457c = (ImageView) view.findViewById(C2130R.id.nfcIcon);
        this.f2459e = (TextView) view.findViewById(C2130R.id.nfcStatus);
        this.f2455a = (RelativeLayout) view.findViewById(C2130R.id.nfcLayout);
        ImageView imageView = (ImageView) view.findViewById(C2130R.id.nfcBackButton);
        this.f2460f = imageView;
        imageView.setEnabled(true);
        if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
            this.f2460f.setImageDrawable(ContextCompat.getDrawable(getActivity(), C2156av.m1748az()));
        }
        int i = AnonymousClass17.f2501V[FaceTecSDK.f2235I.f2222d.f2205Z.ordinal()];
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2460f.getLayoutParams();
            layoutParams.removeRule(20);
            layoutParams.addRule(21);
            this.f2460f.setLayoutParams(layoutParams);
        } else if (i == 3 || i == 4) {
            this.f2460f.setVisibility(8);
        }
        this.f2460f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.facetec.sdk.ak.25
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (FragmentC2145ak.this.f2475w) {
                    return;
                }
                FragmentC2145ak.m1574Z(FragmentC2145ak.this);
                float fM1644I = C2156av.m1644I();
                float fCode = C2156av.Code();
                int iM1675V = C2156av.m1675V();
                int iM1993V = (int) (C2188cb.m1993V(C2156av.f2639Z) * fCode * fM1644I);
                float f = iM1675V / 2.0f;
                int iRound = Math.round(f);
                int iRound2 = Math.round(f);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) FragmentC2145ak.this.f2460f.getLayoutParams();
                layoutParams2.setMargins(iRound, iRound, 0, 0);
                layoutParams2.setMarginStart(iRound);
                layoutParams2.setMarginEnd(iRound);
                FragmentC2145ak.this.f2460f.setLayoutParams(layoutParams2);
                FragmentC2145ak.this.f2460f.setPadding(iRound2, iRound2, iRound2, iRound2);
                FragmentC2145ak.this.f2460f.getLayoutParams().height = iM1993V;
                FragmentC2145ak.this.f2460f.getLayoutParams().width = iM1993V;
                FragmentC2145ak.this.f2460f.requestLayout();
            }
        });
        this.f2460f.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.ak.21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ((FaceTecSessionActivity) FragmentC2145ak.this.getActivity()).mo2196c();
            }
        });
        this.f2460f.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.ak.24
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    FragmentC2145ak.this.f2460f.setAlpha(0.4f);
                } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > FragmentC2145ak.this.f2460f.getWidth() + FragmentC2145ak.this.f2460f.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > FragmentC2145ak.this.f2460f.getHeight() + FragmentC2145ak.this.f2460f.getTop() + 10) {
                    FragmentC2145ak.this.f2460f.setAlpha(1.0f);
                } else if (motionEvent.getAction() == 1) {
                    FragmentC2145ak.this.f2460f.setAlpha(1.0f);
                    FragmentC2145ak.this.f2460f.performClick();
                }
                return true;
            }
        });
        if (C2127I.Code(getActivity()) && FaceTecSDK.f2235I.Code && !getActivity().getPackageName().contains("com.facetec.zoomlogin") && !getActivity().getPackageName().contains("om.facetec.photoidmatchtester")) {
            float fM1644I = C2156av.m1644I() * C2156av.Code();
            this.f2470p.setTypeface(FaceTecSDK.f2235I.f2213F.messageFont);
            this.f2470p.setTextSize(2, 14.0f * fM1644I);
            C2156av.Code(this.f2470p);
            this.f2471q.setColorFilter(C2156av.m1779v(), PorterDuff.Mode.SRC_IN);
            this.f2471q.getLayoutParams().height = (int) (C2188cb.m1993V(18) * fM1644I);
            this.f2471q.getLayoutParams().width = (int) (C2188cb.m1993V(18) * fM1644I);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2458d.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = C2156av.m1675V();
            ((ViewGroup.LayoutParams) layoutParams2).height = (int) (C2188cb.m1993V(26) * fM1644I);
            this.f2458d.setLayoutParams(layoutParams2);
            this.f2458d.requestLayout();
            this.f2458d.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.ak.22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FragmentC2145ak.this.f2458d.setEnabled(false);
                    FragmentC2145ak.this.f2458d.setClickable(false);
                    FragmentC2145ak.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://dev.facetec.com/removing-development-mode-watermark")));
                }
            });
            this.f2458d.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.ak.27
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        FragmentC2145ak.this.f2458d.setAlpha(0.4f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > FragmentC2145ak.this.f2458d.getWidth() + FragmentC2145ak.this.f2458d.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > FragmentC2145ak.this.f2458d.getHeight() + 10) {
                        FragmentC2145ak.this.f2458d.setAlpha(1.0f);
                    } else if (motionEvent.getAction() == 1) {
                        FragmentC2145ak.this.f2458d.performClick();
                    }
                    return true;
                }
            });
            this.f2458d.setVisibility(0);
        }
        C2156av.m1652I(this.f2443B);
        if (!this.f2462h) {
            this.f2443B.getBackground().setAlpha(C2156av.m1699aC());
        }
        float fM1644I2 = C2156av.m1644I() * C2156av.Code();
        float fM1716aT = C2156av.m1716aT();
        int iM1675V = C2156av.m1675V();
        int iRound = Math.round(C2188cb.m1993V(C2156av.f2633D) * fM1716aT * fM1644I2);
        int iRound2 = Math.round(C2188cb.m1993V(C2156av.f2632C) * fM1644I2);
        int iRound3 = Math.round(C2188cb.m1993V(C2156av.f2636L) * fM1644I2);
        int iRound4 = Math.round(C2188cb.m1993V(6) * fM1644I2);
        int iRound5 = Math.round(C2188cb.m1993V(C2156av.f2635I) * fM1644I2);
        C2162bb c2162bb = (C2162bb) view.findViewById(C2130R.id.nfcSkipButton);
        this.f2463i = c2162bb;
        c2162bb.setupButtonForIdentityCheck();
        this.f2463i.setText(C2157aw.m1784I(C2130R.string.FaceTec_action_skip_nfc));
        this.f2463i.setEnabled(false);
        this.f2463i.setOnClickListenerRunnable(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.15
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FaceTecSessionActivity faceTecSessionActivity = (FaceTecSessionActivity) FragmentC2145ak.this.getActivity();
                if (faceTecSessionActivity != null) {
                    faceTecSessionActivity.m2215v();
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2463i.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams3).height = iRound5;
        layoutParams3.setMargins(iM1675V, 0, iM1675V, iM1675V);
        this.f2463i.setLayoutParams(layoutParams3);
        this.f2447F.setTranslationY(iRound3);
        this.f2472r.getLayoutParams().height = iRound;
        this.f2472r.getLayoutParams().width = iRound;
        this.f2452S.setColorFilter(C2156av.m1695a(getActivity()), PorterDuff.Mode.SRC_IN);
        this.f2451L.setColorFilter(C2156av.m1755d(getActivity()), PorterDuff.Mode.SRC_IN);
        this.f2457c.getLayoutParams().height = iRound2;
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(C2130R.drawable.facetec_progress_bar);
        this.f2473t = layerDrawable;
        layerDrawable.mutate();
        Drawable drawable = this.f2473t.getDrawable(0);
        LayerDrawable layerDrawable2 = (LayerDrawable) ((ScaleDrawable) this.f2473t.getDrawable(1)).getDrawable();
        Drawable drawableFindDrawableByLayerId = layerDrawable2.findDrawableByLayerId(C2130R.id.progressFill);
        Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(C2130R.id.progressGlow);
        float f = iRound4 / 2.0f;
        ((GradientDrawable) drawable).setCornerRadius(f);
        ((GradientDrawable) drawableFindDrawableByLayerId).setCornerRadius(f);
        ((GradientDrawable) drawableFindDrawableByLayerId2).setCornerRadius(f);
        C2156av.m1682V(this.Code, drawable);
        C2156av.Code(this.Code, drawableFindDrawableByLayerId, drawableFindDrawableByLayerId2);
        this.Code.setProgressDrawable(this.f2473t);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.Code.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams4).height = iRound4;
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = iM1675V;
        this.Code.setLayoutParams(layoutParams4);
        this.Code.setVisibility(0);
        C2156av.Code(this.f2453V);
        C2156av.Code(this.f2450I);
        C2156av.Code(this.f2459e);
        this.f2453V.setTypeface(FaceTecSDK.f2235I.f2213F.messageFont);
        this.f2450I.setTypeface(FaceTecSDK.f2235I.f2213F.messageFont);
        this.f2459e.setTypeface(FaceTecSDK.f2235I.f2213F.messageFont);
        if (this.f2462h) {
            C2157aw.Code(this.f2453V, C2130R.string.FaceTec_result_idscan_upload_message);
            if (this.f2468n == V.NFC) {
                C2157aw.Code(this.f2453V, C2130R.string.FaceTec_result_nfc_upload_message);
            } else {
                C2157aw.Code(this.f2453V, C2130R.string.FaceTec_result_idscan_upload_message);
            }
        } else {
            C2157aw.Code(this.f2453V, C2130R.string.FaceTec_result_facescan_upload_message);
        }
        this.f2453V.setTextSize(2, C2156av.f2647h * fM1644I2);
        this.f2459e.setTextSize(2, C2156av.f2647h * fM1644I2);
        this.f2450I.setTextSize(2, C2156av.f2647h * fM1644I2);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f2453V.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = iM1675V;
        this.f2453V.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f2450I.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = iM1675V;
        this.f2450I.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f2459e.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = iM1675V;
        ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = iM1675V;
        this.f2459e.setLayoutParams(layoutParams7);
        ViewGroup.LayoutParams layoutParams8 = this.f2454Z.getLayoutParams();
        layoutParams8.height = iRound;
        layoutParams8.width = iRound;
        this.f2454Z.setLayoutParams(layoutParams8);
        int iM1747ay = C2156av.m1747ay();
        int iM1709aM = C2156av.m1709aM();
        if (iM1709aM != 0) {
            this.f2467m = m1567I(getActivity(), iM1709aM);
        }
        if (this.f2467m != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new AnonymousClass14(this, handler));
            this.f2454Z.setVisibility(0);
        } else if (iM1747ay != 0) {
            this.f2454Z.setImageResource(iM1747ay);
            this.f2454Z.clearAnimation();
            this.f2454Z.setVisibility(0);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(FaceTecSDK.f2235I.f2213F.customActivityIndicatorRotationInterval);
            rotateAnimation.setRepeatCount(-1);
            this.f2454Z.startAnimation(rotateAnimation);
        } else {
            new Handler(Looper.getMainLooper()).post(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.11
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2145ak fragmentC2145ak = FragmentC2145ak.this;
                    fragmentC2145ak.f2465k = FragmentC2145ak.m1567I(fragmentC2145ak.getActivity(), C2130R.drawable.facetec_animated_activity_indicator_vector_drawable);
                    FragmentC2145ak.this.f2454Z.setColorFilter(C2156av.m1642G(), PorterDuff.Mode.SRC_IN);
                    FragmentC2145ak.this.f2454Z.setImageDrawable(FragmentC2145ak.this.f2465k);
                    FragmentC2145ak.this.f2465k.start();
                    FragmentC2145ak.this.f2454Z.setVisibility(0);
                }
            });
        }
        boolean z = this.f2462h && FaceTecCustomization.f2208f != null;
        this.f2474v = z;
        if (z) {
            f2441u.post(this.f2478z);
        }
        if (FaceTecSDK.f2235I.f2213F.showUploadProgressBar) {
            this.Code.setVisibility(0);
            getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.18
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2145ak fragmentC2145ak = FragmentC2145ak.this;
                    fragmentC2145ak.f2456b = ObjectAnimator.ofInt(fragmentC2145ak.Code, "progress", FragmentC2145ak.this.Code.getProgress(), 3000);
                    FragmentC2145ak.this.f2456b.setDuration(3000L);
                    FragmentC2145ak.this.f2456b.start();
                }
            });
        } else {
            this.Code.setVisibility(4);
        }
        getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.23
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FragmentC2145ak.this.f2447F.animate().alpha(1.0f).setDuration(800L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
            }
        });
    }

    /* JADX INFO: renamed from: V */
    final void m1579V(final String str) {
        if (this.f2453V == null || this.f2474v) {
            return;
        }
        m1570I(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.4
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                if (FragmentC2145ak.this.f2461g) {
                    return;
                }
                if (FragmentC2145ak.this.Code == null || FragmentC2145ak.this.Code.getProgress() / FragmentC2145ak.this.Code.getMax() < 0.9d) {
                    FragmentC2145ak.this.f2453V.setText(str);
                    FragmentC2145ak.this.f2464j = System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
                }
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    final void m1580Z(float f) {
        if (this.Code == null) {
            return;
        }
        float progress = r0.getProgress() / this.Code.getMax();
        if (f > 1.0f || progress >= f) {
            return;
        }
        if (f == 1.0f && !this.f2476x) {
            this.f2476x = true;
            if (this.f2474v) {
                f2441u.post(this.f2448G);
            }
        }
        float f2 = (f * 10000.0f) - 1000.0f;
        if (f2 > this.Code.getProgress()) {
            ObjectAnimator objectAnimator = this.f2456b;
            if (objectAnimator != null) {
                objectAnimator.end();
                this.f2456b = null;
            }
            this.Code.setProgress(Math.round(f2), true);
        }
        Handler handler = f2440s;
        handler.removeCallbacks(this.f2477y);
        handler.postDelayed(this.f2477y, 600000L);
    }

    /* JADX INFO: renamed from: Z */
    private long m1573Z() {
        if (this.f2464j != -1) {
            long jNanoTime = (System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE) - this.f2464j;
            if (jNanoTime < 1000) {
                return 1000 - jNanoTime;
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I */
    public void m1570I(final AbstractRunnableC2150ap abstractRunnableC2150ap) {
        Handler handler = f2441u;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.5
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                AbstractRunnableC2150ap abstractRunnableC2150ap2 = abstractRunnableC2150ap;
                if (abstractRunnableC2150ap2 != null) {
                    abstractRunnableC2150ap2.Code();
                }
            }
        }, m1573Z());
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$9, reason: invalid class name */
    final class AnonymousClass9 extends AbstractRunnableC2150ap {
        AnonymousClass9(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2145ak.f2441u == null || FragmentC2145ak.this.f2461g) {
                return;
            }
            FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
            FragmentC2145ak.this.m1578V(new AnonymousClass4(FragmentC2145ak.this));
        }

        /* JADX INFO: renamed from: com.facetec.sdk.ak$9$4, reason: invalid class name */
        final class AnonymousClass4 extends AbstractRunnableC2150ap {
            AnonymousClass4(Fragment fragment) {
                super(fragment);
            }

            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                if (FragmentC2145ak.f2441u == null || FragmentC2145ak.this.f2461g) {
                    return;
                }
                FragmentC2145ak.f2441u.removeCallbacksAndMessages(null);
                FragmentC2145ak.f2441u.postDelayed(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.9.4.3
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        FragmentC2145ak.this.f2469o = Z.UPLOAD_COMPLETE_AWAITING_RESPONSE;
                        FragmentC2145ak.this.m1570I(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.9.4.3.5
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            final void Code() {
                                if (FragmentC2145ak.f2441u == null || FragmentC2145ak.this.f2461g) {
                                    return;
                                }
                                FragmentC2145ak.m1571V(FragmentC2145ak.this, true);
                                FragmentC2145ak.this.Code((AbstractRunnableC2150ap) null);
                                FragmentC2145ak.f2441u.postDelayed(FragmentC2145ak.this.f2442A, 3000L);
                            }
                        });
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: renamed from: V */
    final String m1577V(Z z, V v) {
        if (!this.f2462h) {
            return C2157aw.m1784I(C2130R.string.FaceTec_result_facescan_upload_message);
        }
        if (FaceTecCustomization.f2208f == null) {
            return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_upload_message);
        }
        EnumC2163bc enumC2163bc = EnumC2163bc.UNKNOWN;
        int i = AnonymousClass17.Code[v.ordinal()];
        if (i == 2) {
            int i2 = AnonymousClass17.f2500B[z.ordinal()];
            if (i2 == 1) {
                enumC2163bc = EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_STARTED;
            } else if (i2 == 2) {
                enumC2163bc = EnumC2163bc.IDSCAN_FRONT_SIDE_STILL_UPLOADING;
            } else if (i2 == 3) {
                enumC2163bc = EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE;
            } else if (i2 == 4) {
                enumC2163bc = EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING;
            }
        } else if (i == 3) {
            int i3 = AnonymousClass17.f2500B[z.ordinal()];
            if (i3 == 1) {
                enumC2163bc = EnumC2163bc.NFC_UPLOAD_STARTED;
            } else if (i3 == 2) {
                enumC2163bc = EnumC2163bc.NFC_STILL_UPLOADING;
            } else if (i3 == 3) {
                enumC2163bc = EnumC2163bc.NFC_UPLOAD_COMPLETE_AWAITING_RESPONSE;
            } else if (i3 == 4) {
                enumC2163bc = EnumC2163bc.NFC_UPLOAD_COMPLETE_AWAITING_PROCESSING;
            }
        } else if (i == 4) {
            int i4 = AnonymousClass17.f2500B[z.ordinal()];
            if (i4 == 1) {
                enumC2163bc = EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_STARTED;
            } else if (i4 == 2) {
                enumC2163bc = EnumC2163bc.IDSCAN_BACK_SIDE_STILL_UPLOADING;
            } else if (i4 == 3) {
                enumC2163bc = EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE;
            } else if (i4 == 4) {
                enumC2163bc = EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING;
            }
        } else if (i == 5) {
            int i5 = AnonymousClass17.f2500B[z.ordinal()];
            if (i5 == 1) {
                enumC2163bc = EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_STARTED;
            } else if (i5 == 2) {
                enumC2163bc = EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_STILL_UPLOADING;
            } else if (i5 == 3) {
                enumC2163bc = EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_RESPONSE;
            } else if (i5 == 4) {
                enumC2163bc = EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_PROCESSING;
            }
        }
        String strM1623B = C2156av.m1623B(enumC2163bc);
        if (strM1623B != null) {
            return strM1623B;
        }
        if (z == Z.UPLOAD_COMPLETE_AWAITING_PROCESSING) {
            return m1577V(Z.UPLOAD_COMPLETE_AWAITING_RESPONSE, v);
        }
        if (z == Z.UPLOAD_COMPLETE_AWAITING_RESPONSE || z == Z.STILL_UPLOADING) {
            return m1577V(Z.UPLOAD_STARTED, v);
        }
        if (this.f2462h) {
            if (v == V.NFC) {
                return C2157aw.m1784I(C2130R.string.FaceTec_result_nfc_upload_message);
            }
            return C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_upload_message);
        }
        return C2157aw.m1784I(C2130R.string.FaceTec_result_facescan_upload_message);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$17, reason: invalid class name */
    static /* synthetic */ class AnonymousClass17 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f2500B;
        static final /* synthetic */ int[] Code;

        /* JADX INFO: renamed from: V */
        static final /* synthetic */ int[] f2501V;

        static {
            int[] iArr = new int[V.values().length];
            Code = iArr;
            try {
                iArr[V.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[V.FRONT_SIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[V.NFC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[V.BACK_SIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[V.USER_CONFIRMED_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Z.values().length];
            f2500B = iArr2;
            try {
                iArr2[Z.UPLOAD_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2500B[Z.STILL_UPLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2500B[Z.UPLOAD_COMPLETE_AWAITING_RESPONSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2500B[Z.UPLOAD_COMPLETE_AWAITING_PROCESSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[FaceTecCancelButtonCustomization.ButtonLocation.values().length];
            f2501V = iArr3;
            try {
                iArr3[FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2501V[FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2501V[FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2501V[FaceTecCancelButtonCustomization.ButtonLocation.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    final void m1578V(final AbstractRunnableC2150ap abstractRunnableC2150ap) {
        ProgressBar progressBar = this.Code;
        if (progressBar == null || progressBar.getProgress() == this.Code.getMax() || !FaceTecSDK.f2235I.f2213F.showUploadProgressBar) {
            abstractRunnableC2150ap.Code();
        } else {
            getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.8
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    if (FragmentC2145ak.this.f2456b != null) {
                        FragmentC2145ak.this.f2456b.end();
                        FragmentC2145ak.this.f2456b = null;
                    }
                    ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(FragmentC2145ak.this.Code, "progress", FragmentC2145ak.this.Code.getProgress(), FragmentC2145ak.this.Code.getMax());
                    objectAnimatorOfInt.setDuration(500L);
                    objectAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.ak.8.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            if (abstractRunnableC2150ap != null) {
                                abstractRunnableC2150ap.Code();
                            }
                        }
                    });
                    objectAnimatorOfInt.start();
                }
            });
        }
    }

    final void Code(final AbstractRunnableC2150ap abstractRunnableC2150ap) {
        if (this.Code != null && FaceTecSDK.f2235I.f2213F.showUploadProgressBar) {
            getActivity().runOnUiThread(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.ak.12
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2145ak.this.Code.animate().alpha(0.0f).setDuration(500L).setListener(null).withEndAction(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.12.2
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        final void Code() {
                            if (abstractRunnableC2150ap != null) {
                                abstractRunnableC2150ap.Code();
                            }
                        }
                    }).start();
                }
            });
        } else if (abstractRunnableC2150ap != null) {
            abstractRunnableC2150ap.Code();
        }
    }

    /* JADX INFO: renamed from: B */
    final void m1575B(boolean z, String str, Runnable runnable) {
        m1576I(z, false, str, runnable);
    }

    /* JADX INFO: renamed from: I */
    final void m1576I(boolean z, boolean z2, String str, Runnable runnable) {
        f2440s.removeCallbacks(this.f2477y);
        f2441u.removeCallbacksAndMessages(null);
        if (getActivity() == null) {
            return;
        }
        if (!this.f2462h) {
            if (str == null) {
                str = C2157aw.m1784I(C2130R.string.FaceTec_result_success_message);
            }
            this.f2450I.setText(str);
        } else if (z) {
            if (str == null) {
                str = C2157aw.m1784I(C2130R.string.FaceTec_result_success_message);
            }
            this.f2450I.setText(str);
        } else {
            if (str == null) {
                str = C2157aw.m1784I(C2130R.string.FaceTec_result_idscan_unsuccess_message);
            }
            this.f2450I.setText(str);
        }
        this.f2461g = true;
        m1570I(new AnonymousClass13(this, z, runnable, z2));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$13, reason: invalid class name */
    final class AnonymousClass13 extends AbstractRunnableC2150ap {
        final /* synthetic */ boolean Code;

        /* JADX INFO: renamed from: I */
        final /* synthetic */ Runnable f2485I;

        /* JADX INFO: renamed from: Z */
        final /* synthetic */ boolean f2487Z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass13(Fragment fragment, boolean z, Runnable runnable, boolean z2) {
            super(fragment);
            this.Code = z;
            this.f2485I = runnable;
            this.f2487Z = z2;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        final void Code() {
            FragmentC2145ak.this.m1578V(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.13.1
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    if (AnonymousClass13.this.Code) {
                        FragmentC2145ak.this.Code(true, new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.13.1.5
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            public final void Code() {
                                AnonymousClass13.this.f2485I.run();
                            }
                        });
                        return;
                    }
                    if (AnonymousClass13.this.f2487Z) {
                        FragmentC2145ak fragmentC2145ak = FragmentC2145ak.this;
                        AbstractRunnableC2150ap abstractRunnableC2150ap = new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.13.1.3
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            final void Code() {
                                AnonymousClass13.this.f2485I.run();
                            }
                        };
                        if (fragmentC2145ak.getActivity() != null) {
                            int iM1705aI = C2156av.m1705aI();
                            int iM1711aO = C2156av.m1711aO();
                            if (iM1711aO == 0) {
                                iM1711aO = C2130R.drawable.facetec_internal_warning;
                            }
                            fragmentC2145ak.getActivity().runOnUiThread(fragmentC2145ak.new AnonymousClass19(fragmentC2145ak, iM1705aI != 0, iM1705aI, iM1711aO, abstractRunnableC2150ap));
                            return;
                        }
                        return;
                    }
                    if (FragmentC2145ak.this.f2462h) {
                        FragmentC2145ak.this.Code(false, new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.13.1.2
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            public final void Code() {
                                AnonymousClass13.this.f2485I.run();
                            }
                        });
                    } else {
                        FragmentC2145ak.this.m1581Z(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.13.1.4
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            public final void Code() {
                                AnonymousClass13.this.f2485I.run();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$14, reason: invalid class name */
    final class AnonymousClass14 extends AbstractRunnableC2150ap {
        final /* synthetic */ Handler Code;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass14(Fragment fragment, Handler handler) {
            super(fragment);
            this.Code = handler;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2145ak.this.f2454Z.setImageDrawable(FragmentC2145ak.this.f2467m);
            FragmentC2145ak.this.f2466l = new Animatable2Compat.AnimationCallback() { // from class: com.facetec.sdk.ak.14.1
                @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
                public final void onAnimationEnd(Drawable drawable) {
                    AnonymousClass14.this.Code.post(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.14.1.1
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            if (FragmentC2145ak.this.f2467m == null) {
                                return;
                            }
                            FragmentC2145ak.this.f2467m.start();
                        }
                    });
                }
            };
            FragmentC2145ak.this.f2467m.registerAnimationCallback(FragmentC2145ak.this.f2466l);
            FragmentC2145ak.this.f2467m.start();
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$19, reason: invalid class name */
    final class AnonymousClass19 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: B */
        private /* synthetic */ boolean f2503B;

        /* JADX INFO: renamed from: I */
        final /* synthetic */ AbstractRunnableC2150ap f2504I;

        /* JADX INFO: renamed from: V */
        private /* synthetic */ int f2505V;

        /* JADX INFO: renamed from: Z */
        private /* synthetic */ int f2506Z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass19(Fragment fragment, boolean z, int i, int i2, AbstractRunnableC2150ap abstractRunnableC2150ap) {
            super(fragment);
            this.f2503B = z;
            this.f2505V = i;
            this.f2506Z = i2;
            this.f2504I = abstractRunnableC2150ap;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2145ak.this.f2444C.setVisibility(0);
            FragmentC2145ak.this.f2452S.setImageDrawable(null);
            FragmentC2145ak.this.f2452S.clearColorFilter();
            FragmentC2145ak.this.f2452S.invalidate();
            FragmentC2145ak.this.f2451L.clearColorFilter();
            FragmentC2145ak.this.f2451L.invalidate();
            if (this.f2503B) {
                FragmentC2145ak.this.f2451L.setImageDrawable(FragmentC2145ak.m1567I(FragmentC2145ak.this.getActivity(), this.f2505V));
                ((AnimatedVectorDrawableCompat) FragmentC2145ak.this.f2451L.getDrawable()).start();
            } else {
                FragmentC2145ak.this.f2451L.setImageDrawable(ContextCompat.getDrawable(FragmentC2145ak.this.getActivity(), this.f2506Z));
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(FragmentC2145ak.this.f2445D, "alpha", FragmentC2145ak.this.f2445D.getAlpha(), 0.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(FragmentC2145ak.this.f2444C, "alpha", FragmentC2145ak.this.f2444C.getAlpha(), 1.0f);
            objectAnimatorOfFloat2.setDuration(800L);
            objectAnimatorOfFloat.setDuration(800L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.ak.19.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    FragmentC2145ak.this.f2450I.animate().alpha(1.0f).setDuration(1500L).setStartDelay(0L).setListener(null).start();
                    new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.19.2.5
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            AnonymousClass19.this.f2504I.Code();
                        }
                    }, 2500L);
                }
            });
            objectAnimatorOfFloat2.start();
            objectAnimatorOfFloat.start();
        }
    }

    final void Code(boolean z, AbstractRunnableC2150ap abstractRunnableC2150ap) {
        if (getActivity() == null) {
            return;
        }
        int iM1697aA = z ? C2156av.m1697aA() : C2156av.m1698aB();
        boolean z2 = iM1697aA != 0;
        int iM1708aL = z ? C2156av.m1708aL() : C2156av.m1712aP();
        boolean z3 = iM1708aL != 0;
        int iM1710aN = z ? C2156av.m1710aN() : C2156av.m1713aQ();
        if (z2 || z3) {
            this.f2452S.setImageDrawable(null);
            this.f2452S.clearColorFilter();
            this.f2452S.invalidate();
        }
        getActivity().runOnUiThread(new AnonymousClass20(this, z3, iM1708aL, z2, iM1697aA, z, false, iM1710aN, abstractRunnableC2150ap));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$20, reason: invalid class name */
    final class AnonymousClass20 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: B */
        private /* synthetic */ boolean f2509B;

        /* JADX INFO: renamed from: C */
        private /* synthetic */ int f2510C;
        private /* synthetic */ int Code;

        /* JADX INFO: renamed from: D */
        private /* synthetic */ boolean f2511D;

        /* JADX INFO: renamed from: F */
        private /* synthetic */ int f2512F;

        /* JADX INFO: renamed from: L */
        private /* synthetic */ boolean f2514L;

        /* JADX INFO: renamed from: V */
        final /* synthetic */ AbstractRunnableC2150ap f2515V;

        /* JADX INFO: renamed from: Z */
        private /* synthetic */ boolean f2516Z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass20(Fragment fragment, boolean z, int i, boolean z2, int i2, boolean z3, boolean z4, int i3, AbstractRunnableC2150ap abstractRunnableC2150ap) {
            super(fragment);
            this.f2509B = z;
            this.Code = i;
            this.f2516Z = z2;
            this.f2512F = i2;
            this.f2514L = z3;
            this.f2511D = z4;
            this.f2510C = i3;
            this.f2515V = abstractRunnableC2150ap;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2145ak.this.f2444C.setVisibility(0);
            if (this.f2509B) {
                FragmentC2145ak.this.f2451L.clearColorFilter();
                FragmentC2145ak.this.f2451L.invalidate();
                FragmentC2145ak.this.f2451L.setImageDrawable(FragmentC2145ak.m1567I(FragmentC2145ak.this.getActivity(), this.Code));
                ((AnimatedVectorDrawableCompat) FragmentC2145ak.this.f2451L.getDrawable()).start();
            } else {
                if (this.f2516Z) {
                    FragmentC2145ak.this.f2452S.setImageResource(this.f2512F);
                    FragmentC2145ak.this.f2452S.animate().alpha(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(0L).setStartDelay(0L).setListener(null).start();
                    FragmentC2145ak.this.f2452S.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(1000L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
                } else {
                    FragmentC2145ak.this.f2452S.setImageDrawable(FragmentC2145ak.m1567I(FragmentC2145ak.this.getActivity(), C2130R.drawable.facetec_animated_result_background));
                    ((AnimatedVectorDrawableCompat) FragmentC2145ak.this.f2452S.getDrawable()).start();
                }
                FragmentC2145ak.this.f2451L.setImageDrawable(FragmentC2145ak.m1567I(FragmentC2145ak.this.getActivity(), this.f2514L ? C2130R.drawable.facetec_animated_success_foreground : C2130R.drawable.facetec_animated_unsuccess_foreground));
                ((AnimatedVectorDrawableCompat) FragmentC2145ak.this.f2451L.getDrawable()).start();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(FragmentC2145ak.this.f2445D, "alpha", FragmentC2145ak.this.f2445D.getAlpha(), 0.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(FragmentC2145ak.this.f2444C, "alpha", FragmentC2145ak.this.f2444C.getAlpha(), 1.0f);
            objectAnimatorOfFloat2.setDuration(800L);
            objectAnimatorOfFloat.setDuration(800L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.ak.20.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    if (FragmentC2145ak.this.f2467m != null && FragmentC2145ak.this.f2466l != null) {
                        FragmentC2145ak.this.f2467m.unregisterAnimationCallback(FragmentC2145ak.this.f2466l);
                        FragmentC2145ak.this.f2467m.stop();
                        FragmentC2145ak.this.f2467m = null;
                        FragmentC2145ak.this.f2466l = null;
                    }
                    if (FragmentC2145ak.this.f2465k != null) {
                        FragmentC2145ak.this.f2465k.stop();
                        FragmentC2145ak.this.f2465k = null;
                    }
                    FragmentC2145ak.this.f2450I.animate().alpha(1.0f).setDuration(1500L).setStartDelay(0L).setListener(null).start();
                    new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.20.3.5
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            AnonymousClass20.this.f2515V.Code();
                        }
                    }, 2500L);
                }
            });
            objectAnimatorOfFloat2.start();
            objectAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: renamed from: Z */
    final void m1581Z(AbstractRunnableC2150ap abstractRunnableC2150ap) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new AnonymousClass16(this, abstractRunnableC2150ap));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.ak$16, reason: invalid class name */
    final class AnonymousClass16 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: I */
        final /* synthetic */ AbstractRunnableC2150ap f2496I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(Fragment fragment, AbstractRunnableC2150ap abstractRunnableC2150ap) {
            super(fragment);
            this.f2496I = abstractRunnableC2150ap;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2145ak.this.f2458d.animate().alpha(0.0f).setDuration(800L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(FragmentC2145ak.this.f2447F, "alpha", FragmentC2145ak.this.f2447F.getAlpha(), 0.0f);
            objectAnimatorOfFloat.setDuration(800L);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.ak.16.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    new Handler(Looper.getMainLooper()).post(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.16.1.2
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            if (FragmentC2145ak.this.f2447F != null) {
                                FragmentC2145ak.this.f2447F.setVisibility(8);
                            }
                            if (AnonymousClass16.this.f2496I != null) {
                                AnonymousClass16.this.f2496I.Code();
                            }
                        }
                    });
                }
            });
            objectAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: renamed from: I */
    static AnimatedVectorDrawableCompat m1567I(Activity activity, int i) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(activity, i);
        if (f2439N || animatedVectorDrawableCompatCreate != null) {
            return (AnimatedVectorDrawableCompat) animatedVectorDrawableCompatCreate.mutate();
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: V */
    static /* synthetic */ void m1571V(FragmentC2145ak fragmentC2145ak, final boolean z) {
        f2441u.removeCallbacksAndMessages(null);
        fragmentC2145ak.m1570I(new AbstractRunnableC2150ap(fragmentC2145ak) { // from class: com.facetec.sdk.ak.3
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                if (FragmentC2145ak.this.f2453V != null) {
                    FragmentC2145ak fragmentC2145ak2 = FragmentC2145ak.this;
                    String strM1577V = fragmentC2145ak2.m1577V(fragmentC2145ak2.f2469o, FragmentC2145ak.this.f2468n);
                    if (strM1577V.equals(FragmentC2145ak.this.f2453V.getText().toString())) {
                        return;
                    }
                    if (!z) {
                        FragmentC2145ak.this.f2453V.setText(strM1577V);
                        FragmentC2145ak.this.f2464j = System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
                    } else {
                        FragmentC2145ak.this.f2464j = (System.nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE) + 1000;
                        FragmentC2145ak.this.f2453V.animate().alpha(0.0f).setDuration(500L).setListener(null).withEndAction(new AbstractRunnableC2150ap(FragmentC2145ak.this) { // from class: com.facetec.sdk.ak.3.4
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            final void Code() {
                                FragmentC2145ak.this.f2453V.setText(FragmentC2145ak.this.m1577V(FragmentC2145ak.this.f2469o, FragmentC2145ak.this.f2468n));
                                FragmentC2145ak.this.f2453V.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
                            }
                        }).start();
                    }
                }
            }
        });
    }
}
