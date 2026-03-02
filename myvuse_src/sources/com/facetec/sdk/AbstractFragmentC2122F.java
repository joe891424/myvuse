package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facetec.sdk.AbstractActivityC2219g;
import com.facetec.sdk.AbstractActivityC2220h;
import com.facetec.sdk.C2138ad;
import com.facetec.sdk.C2183bw;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecSDK;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;

/* JADX INFO: renamed from: com.facetec.sdk.F */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractFragmentC2122F extends Fragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: B */
    protected C2176bp f2162B;

    /* JADX INFO: renamed from: C */
    protected ViewGroup f2163C;
    protected ImageView Code;

    /* JADX INFO: renamed from: F */
    protected ViewGroup f2165F;

    /* JADX INFO: renamed from: I */
    protected RelativeLayout f2166I;

    /* JADX INFO: renamed from: L */
    protected View f2167L;

    /* JADX INFO: renamed from: V */
    protected ImageView f2169V;

    /* JADX INFO: renamed from: Z */
    protected C2162bb f2170Z;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: b */
    private TextView f2172b;

    /* JADX INFO: renamed from: c */
    protected Animator f2173c;

    /* JADX INFO: renamed from: d */
    private TextView f2174d;

    /* JADX INFO: renamed from: e */
    private TextView f2175e;

    /* JADX INFO: renamed from: f */
    private TextView f2176f;

    /* JADX INFO: renamed from: g */
    private Animator f2177g;

    /* JADX INFO: renamed from: h */
    private View f2178h;

    /* JADX INFO: renamed from: i */
    private TextView f2179i;

    /* JADX INFO: renamed from: j */
    private TextView f2180j;

    /* JADX INFO: renamed from: l */
    private C2138ad.B f2182l;

    /* JADX INFO: renamed from: m */
    private Runnable f2183m;

    /* JADX INFO: renamed from: n */
    private Handler f2184n;

    /* JADX INFO: renamed from: o */
    private AnimatorSet f2185o;

    /* JADX INFO: renamed from: r */
    private C2183bw f2187r;

    /* JADX INFO: renamed from: s */
    private Handler f2188s;

    /* JADX INFO: renamed from: D */
    protected boolean f2164D = false;

    /* JADX INFO: renamed from: S */
    protected boolean f2168S = false;

    /* JADX INFO: renamed from: k */
    private boolean f2181k = false;

    /* JADX INFO: renamed from: p */
    private Handler f2186p = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a */
    protected AbstractRunnableC2150ap f2171a = null;

    /* JADX INFO: renamed from: t */
    private final C2183bw.V f2189t = new C2183bw.V() { // from class: com.facetec.sdk.F.5
        @Override // com.facetec.sdk.C2183bw.V
        /* JADX INFO: renamed from: V */
        public final void mo1398V() {
            AbstractActivityC2219g abstractActivityC2219gM1387F = AbstractFragmentC2122F.this.m1387F();
            if (abstractActivityC2219gM1387F != null) {
                abstractActivityC2219gM1387F.m2200g();
            }
        }
    };

    /* JADX INFO: renamed from: B */
    protected abstract void mo1384B();

    protected abstract void Code();

    /* JADX INFO: renamed from: I */
    protected abstract void mo1388I();

    /* JADX INFO: renamed from: L */
    protected abstract boolean mo1389L();

    /* JADX INFO: renamed from: V */
    protected abstract void mo1391V();

    /* JADX INFO: renamed from: Z */
    protected abstract void mo1394Z();

    @Override // com.newrelic.agent.android.api.p044v2.TraceFieldInterface
    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
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

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m1381c(AbstractFragmentC2122F abstractFragmentC2122F) {
        abstractFragmentC2122F.f2181k = true;
        return true;
    }

    /* JADX INFO: renamed from: C */
    final AbstractActivityC2220h m1385C() {
        return (AbstractActivityC2220h) getActivity();
    }

    /* JADX INFO: renamed from: F */
    final AbstractActivityC2219g m1387F() {
        return (AbstractActivityC2219g) getActivity();
    }

    /* JADX INFO: renamed from: S */
    protected final C2138ad m1390S() {
        AbstractActivityC2219g abstractActivityC2219gM1387F = m1387F();
        if (abstractActivityC2219gM1387F != null) {
            return abstractActivityC2219gM1387F.f3470B;
        }
        return null;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("F");
        try {
            TraceMachine.enterMethod(this._nr_trace, "F#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "F#onCreate", null);
        }
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @Override // android.app.Fragment
    public void onPause() {
        Runnable runnable;
        super.onPause();
        this.f2178h.removeCallbacks(null);
        AnimatorSet animatorSet = this.f2185o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Handler handler = this.f2184n;
        if (handler == null || (runnable = this.f2183m) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // android.app.Fragment
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        Animator animator;
        Animator animator2;
        return (!z || (animator2 = this.f2177g) == null) ? (z || (animator = this.f2173c) == null) ? super.onCreateAnimator(i, z, i2) : animator : animator2;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "F#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "F#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_guidance_fragment, viewGroup, false);
        this.f2178h = viewInflate;
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentC2171bk.f2831Z = false;
        this.f2167L = view.findViewById(C2130R.id.centerContentView);
        this.f2162B = (C2176bp) view.findViewById(C2130R.id.zoomDialogBackground);
        this.f2163C = (ViewGroup) view.findViewById(C2130R.id.bottomLayout);
        this.f2165F = (ViewGroup) view.findViewById(C2130R.id.zoomDialogForeground);
        this.f2169V = (ImageView) view.findViewById(C2130R.id.backButton);
        this.f2172b = (TextView) view.findViewById(C2130R.id.zoomDialogIconSubtext);
        view.findViewById(C2130R.id.zoomDialogImage);
        this.f2174d = (TextView) view.findViewById(C2130R.id.zoomDialogHeader);
        this.f2175e = (TextView) view.findViewById(C2130R.id.zoomDialogText1);
        this.f2176f = (TextView) view.findViewById(C2130R.id.zoomDialogText2);
        this.f2179i = (TextView) view.findViewById(C2130R.id.zoomDialogText3);
        this.f2180j = (TextView) view.findViewById(C2130R.id.zoomDialogText4);
        this.f2170Z = (C2162bb) view.findViewById(C2130R.id.zoomDialogActionButton);
        this.f2166I = (RelativeLayout) view.findViewById(C2130R.id.guidanceTransitionView);
        AbstractActivityC2219g abstractActivityC2219gM1387F = m1387F();
        if (m1390S() != null && abstractActivityC2219gM1387F != null && abstractActivityC2219gM1387F.m2221B() == AbstractActivityC2220h.I.GRANTED) {
            Code(abstractActivityC2219gM1387F);
        }
        this.Code = abstractActivityC2219gM1387F.f3339g;
        mo1397e();
    }

    final void Code(boolean z) {
        ImageView imageView = this.Code;
        if (imageView == null) {
            return;
        }
        imageView.setEnabled(z);
    }

    /* JADX INFO: renamed from: V */
    final void m1393V(boolean z, int i, int i2) {
        ImageView imageView = this.Code;
        if (imageView == null) {
            imageView = this.f2169V;
        }
        float f = z ? 1.0f : 0.0f;
        if (i == 0 && i2 == 0) {
            imageView.setAlpha(f);
        } else {
            imageView.animate().alpha(f).setDuration(i).setStartDelay(i2).setListener(null).start();
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.F$B */
    class B implements C2138ad.B {
        private B() {
        }

        /* synthetic */ B(AbstractFragmentC2122F abstractFragmentC2122F, byte b) {
            this();
        }

        @Override // com.facetec.sdk.C2138ad.B
        /* JADX INFO: renamed from: V */
        public final void mo1399V(EnumC2147am enumC2147am, EnumC2142ah enumC2142ah, EnumC2143ai enumC2143ai, EnumC2141ag enumC2141ag) {
            final AbstractActivityC2219g abstractActivityC2219gM1387F;
            if (AbstractFragmentC2122F.this.f2164D || (abstractActivityC2219gM1387F = AbstractFragmentC2122F.this.m1387F()) == null) {
                return;
            }
            if (enumC2147am == EnumC2147am.TIMEOUT_GO_TO_RETRY) {
                if (abstractActivityC2219gM1387F.f3470B != null && C2138ad.m1436C() && AbstractFragmentC2122F.this.mo1389L()) {
                    AbstractFragmentC2122F.Code(AbstractFragmentC2122F.this);
                    AbstractFragmentC2122F.this.m1379a().Code();
                    return;
                } else {
                    AbstractFragmentC2122F.m1378Z(AbstractFragmentC2122F.this, enumC2141ag);
                    AbstractFragmentC2122F.Code(AbstractFragmentC2122F.this);
                    abstractActivityC2219gM1387F.mo2187S();
                    return;
                }
            }
            if (enumC2147am == EnumC2147am.DETECTING_LIGHT_MODE) {
                AbstractFragmentC2122F.m1378Z(AbstractFragmentC2122F.this, enumC2141ag);
                int i = AnonymousClass1.f2192Z[enumC2142ah.ordinal()];
                if (i != 2) {
                    if (i == 3) {
                        abstractActivityC2219gM1387F.m2200g();
                    }
                } else if (FaceTecSDK.f2236Z != FaceTecSDK.EnumC2125B.BRIGHT_LIGHT) {
                    FaceTecSDK.f2236Z = FaceTecSDK.EnumC2125B.BRIGHT_LIGHT;
                    C2140af.m1554r();
                    abstractActivityC2219gM1387F.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.5
                        AnonymousClass5() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractActivityC2219g.this.m2205l();
                            AbstractActivityC2219g.this.m2208o();
                        }
                    });
                }
                if (enumC2141ag != EnumC2141ag.ENABLE) {
                    AbstractFragmentC2122F.this.m1382d();
                    return;
                }
                boolean zMo1389L = AbstractFragmentC2122F.this.mo1389L();
                boolean z = AbstractFragmentC2122F.this.f2168S;
                boolean zIsEnabled = AbstractFragmentC2122F.this.f2170Z.isEnabled();
                boolean z2 = AbstractFragmentC2122F.this.f2171a != null;
                if (zMo1389L && z && zIsEnabled && !z2) {
                    AbstractFragmentC2122F.m1377Z(AbstractFragmentC2122F.this);
                    return;
                }
                return;
            }
            AbstractFragmentC2122F.Code(AbstractFragmentC2122F.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public AbstractRunnableC2150ap m1379a() {
        return new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.F.8
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                AbstractFragmentC2122F.this.m1382d();
                boolean zMo1389L = AbstractFragmentC2122F.this.mo1389L();
                boolean z = AbstractFragmentC2122F.this.f2168S;
                boolean zIsEnabled = AbstractFragmentC2122F.this.f2170Z.isEnabled();
                if (zMo1389L && z && zIsEnabled) {
                    AbstractFragmentC2122F.m1368B(AbstractFragmentC2122F.this);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m1382d() {
        this.f2186p.removeCallbacksAndMessages(null);
        this.f2171a = null;
    }

    /* JADX INFO: renamed from: b */
    private void m1380b() {
        this.f2184n = new Handler();
        Runnable runnable = new Runnable() { // from class: com.facetec.sdk.F.10
            @Override // java.lang.Runnable
            public final void run() {
                if (!AbstractFragmentC2122F.this.f2170Z.f2709L && !AbstractFragmentC2122F.this.f2164D && AbstractFragmentC2122F.this.f2170Z.isEnabled()) {
                    AbstractFragmentC2122F.this.f2170Z.setEnabled(true, false);
                }
                AbstractFragmentC2122F.this.f2184n.postDelayed(this, 5000L);
            }
        };
        this.f2183m = runnable;
        this.f2184n.post(runnable);
    }

    protected final void Code(final Context context) {
        AbstractActivityC2219g abstractActivityC2219gM1387F = m1387F();
        if (abstractActivityC2219gM1387F != null) {
            abstractActivityC2219gM1387F.f3291ab = AbstractActivityC2219g.C.PRE_SESSION_STARTED;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.f2188s = handler;
        handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.F.9
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                C2138ad c2138adM1390S = AbstractFragmentC2122F.this.m1390S();
                if (c2138adM1390S != null) {
                    AbstractFragmentC2122F.this.f2182l = new B(AbstractFragmentC2122F.this, (byte) 0);
                    c2138adM1390S.Code(AbstractFragmentC2122F.this.f2182l);
                    if (c2138adM1390S.m1469I(context) || AbstractFragmentC2122F.this.m1387F() == null) {
                        return;
                    }
                    AbstractActivityC2219g abstractActivityC2219gM1387F2 = AbstractFragmentC2122F.this.m1387F();
                    int i = C2173bm.f2898F;
                    abstractActivityC2219gM1387F2.mo2186L();
                }
            }
        }, 20L);
        m1380b();
        if (FaceTecSDK.f2236Z == FaceTecSDK.EnumC2125B.NORMAL) {
            if (m1390S() != null) {
                m1383h();
            }
            this.f2188s.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.F.7
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    C2138ad c2138adM1390S = AbstractFragmentC2122F.this.m1390S();
                    if (AbstractFragmentC2122F.this.f2187r == null || c2138adM1390S == null) {
                        return;
                    }
                    AbstractFragmentC2122F.this.f2187r.m1974B(AbstractFragmentC2122F.this.f2189t, c2138adM1390S);
                }
            }, 185L);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m1383h() {
        if (m1387F() == null) {
            return;
        }
        AbstractAsyncTaskC2155au.m1616Z(new Runnable() { // from class: com.facetec.sdk.F.6
            @Override // java.lang.Runnable
            public final void run() {
                AbstractFragmentC2122F.this.f2187r = new C2183bw(AbstractFragmentC2122F.this.m1387F());
            }
        });
    }

    /* JADX INFO: renamed from: D */
    final void m1386D() {
        if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
            ImageView imageView = this.f2169V;
            if (imageView == null) {
                m1387F();
                EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
                C2120C.m1362B();
            } else {
                imageView.setImageResource(C2156av.m1748az());
            }
        }
        C2162bb c2162bb = this.f2170Z;
        if (c2162bb.f2705C != FaceTecSDK.f2236Z) {
            c2162bb.f2705C = FaceTecSDK.f2236Z;
            c2162bb.f2707F = 1000;
            c2162bb.m1812I(true);
        }
        mo1394Z();
    }

    /* JADX INFO: renamed from: Z */
    public void mo1395Z(boolean z) {
        this.f2164D = z;
    }

    /* JADX INFO: renamed from: e */
    void mo1397e() {
        this.f2169V.setEnabled(false);
        Code(false);
        if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
            this.f2169V.setImageResource(C2156av.m1748az());
        }
        int i = AnonymousClass1.f2191I[FaceTecSDK.f2235I.f2222d.f2205Z.ordinal()];
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2169V.getLayoutParams();
            layoutParams.removeRule(20);
            layoutParams.addRule(21);
            this.f2169V.setLayoutParams(layoutParams);
        } else if (i == 3 || i == 4) {
            this.f2169V.setVisibility(8);
        }
        final float fM1644I = C2156av.m1644I() * C2156av.Code();
        C2156av.m1692Z(this.f2166I);
        this.f2172b.setTypeface(C2170bj.f2830I);
        this.f2172b.setTextSize(2, C2156av.f2641b * fM1644I);
        C2156av.m1693Z(this.f2172b);
        this.f2172b.setLineSpacing(0.0f, C2156av.Code);
        this.f2174d.setTypeface(C2170bj.f2829B);
        C2156av.m1693Z(this.f2174d);
        this.f2174d.setTypeface(C2170bj.f2829B);
        this.f2174d.setTextSize(2, C2156av.f2643d * fM1644I);
        this.f2174d.setLineSpacing(0.0f, C2156av.Code);
        this.f2175e.setTypeface(C2170bj.f2830I);
        this.f2176f.setTypeface(C2170bj.f2830I);
        this.f2179i.setTypeface(C2170bj.f2830I);
        this.f2180j.setTypeface(C2170bj.f2830I);
        this.f2175e.setTextSize(2, C2156av.f2641b * fM1644I);
        this.f2176f.setTextSize(2, C2156av.f2641b * fM1644I);
        this.f2179i.setTextSize(2, C2156av.f2641b * fM1644I);
        this.f2180j.setTextSize(2, C2156av.f2641b * fM1644I);
        this.f2175e.setLineSpacing(0.0f, C2156av.Code);
        this.f2176f.setLineSpacing(0.0f, C2156av.Code);
        this.f2179i.setLineSpacing(0.0f, C2156av.Code);
        this.f2180j.setLineSpacing(0.0f, C2156av.Code);
        C2156av.m1693Z(this.f2175e);
        C2156av.m1693Z(this.f2176f);
        C2156av.m1693Z(this.f2179i);
        C2156av.m1693Z(this.f2180j);
        this.f2170Z.setEnabled(false);
        this.f2170Z.setupButton();
        this.f2170Z.setAlpha(0.0f);
        this.f2167L.setAlpha(0.0f);
        m1393V(false, 0, 0);
        this.f2170Z.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.facetec.sdk.F.15
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (AbstractFragmentC2122F.this.f2181k) {
                    return;
                }
                AbstractFragmentC2122F.m1381c(AbstractFragmentC2122F.this);
                int iM1993V = (int) (C2188cb.m1993V(C2156av.f2635I) * fM1644I);
                int iM1993V2 = (int) (C2188cb.m1993V(C2156av.f2639Z) * fM1644I);
                int iM1675V = C2156av.m1675V();
                float f = iM1675V / 2.0f;
                int iRound = Math.round(f);
                int iRound2 = Math.round(f);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) AbstractFragmentC2122F.this.f2163C.getLayoutParams();
                layoutParams2.setMargins(0, 0, 0, iM1675V);
                AbstractFragmentC2122F.this.f2163C.setLayoutParams(layoutParams2);
                AbstractFragmentC2122F.this.f2170Z.setLayoutParams(new LinearLayout.LayoutParams((int) ((Resources.getSystem().getDisplayMetrics().widthPixels * C2156av.Code()) - (iM1675V << 1)), iM1993V));
                AbstractFragmentC2122F.this.f2170Z.requestLayout();
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) AbstractFragmentC2122F.this.f2169V.getLayoutParams();
                layoutParams3.setMargins(iRound, iRound, 0, 0);
                layoutParams3.setMarginStart(iRound);
                layoutParams3.setMarginEnd(iRound);
                AbstractFragmentC2122F.this.f2169V.setLayoutParams(layoutParams3);
                AbstractFragmentC2122F.this.f2169V.setPadding(iRound2, iRound2, iRound2, iRound2);
                AbstractFragmentC2122F.this.f2169V.getLayoutParams().height = iM1993V2;
                AbstractFragmentC2122F.this.f2169V.getLayoutParams().width = iM1993V2;
                AbstractFragmentC2122F.this.f2169V.requestLayout();
                AbstractFragmentC2122F.this.f2167L.animate().alpha(1.0f).setDuration(300L).setListener(null).start();
            }
        });
        C2188cb.m1988B(getActivity());
        this.f2169V.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.F.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractFragmentC2122F.this.f2169V.setAlpha(1.0f);
                AbstractFragmentC2122F.this.f2169V.setEnabled(false);
                AbstractFragmentC2122F.this.Code(false);
                AbstractFragmentC2122F.this.f2170Z.setEnabled(false, true);
                AbstractFragmentC2122F.this.mo1391V();
            }
        });
        this.f2169V.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.F.12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractFragmentC2122F.this.f2169V.setAlpha(0.4f);
                } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > AbstractFragmentC2122F.this.f2169V.getWidth() + AbstractFragmentC2122F.this.f2169V.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > AbstractFragmentC2122F.this.f2169V.getHeight() + AbstractFragmentC2122F.this.f2169V.getTop() + 10) {
                    AbstractFragmentC2122F.this.f2169V.setAlpha(1.0f);
                } else if (motionEvent.getAction() == 1) {
                    AbstractFragmentC2122F.this.f2169V.performClick();
                }
                return true;
            }
        });
        this.f2170Z.setOnClickListenerRunnable(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.F.2
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                AbstractFragmentC2122F.m1368B(AbstractFragmentC2122F.this);
            }
        });
        this.f2178h.post(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.F.3
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                if (AbstractFragmentC2122F.this.getActivity() != null) {
                    AbstractFragmentC2122F.this.Code(true);
                    AbstractFragmentC2122F.this.f2169V.setEnabled(true);
                    AbstractFragmentC2122F.this.f2170Z.setEnabled(true);
                    AbstractFragmentC2122F.this.mo1388I();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.facetec.sdk.F$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f2190B;

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2191I;

        /* JADX INFO: renamed from: Z */
        static final /* synthetic */ int[] f2192Z;

        static {
            int[] iArr = new int[FaceTecCancelButtonCustomization.ButtonLocation.values().length];
            f2191I = iArr;
            try {
                iArr[FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2191I[FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2191I[FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2191I[FaceTecCancelButtonCustomization.ButtonLocation.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EnumC2142ah.values().length];
            f2192Z = iArr2;
            try {
                iArr2[EnumC2142ah.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2192Z[EnumC2142ah.DARK_AS_POSSIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2192Z[EnumC2142ah.BRIGHT_AS_POSSIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EnumC2141ag.values().length];
            f2190B = iArr3;
            try {
                iArr3[EnumC2141ag.ENABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2190B[EnumC2141ag.DISABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    protected final void m1392V(final Runnable runnable, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f2185o = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f2165F, (Property<ViewGroup, Float>) View.ALPHA, 1.0f, 0.0f));
        this.f2185o.setDuration(i);
        this.f2185o.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.F.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                runnable.run();
            }
        });
        this.f2185o.start();
    }

    /* JADX INFO: renamed from: c */
    protected void mo1396c() {
        Code();
    }

    static /* synthetic */ void Code(AbstractFragmentC2122F abstractFragmentC2122F) {
        C2183bw c2183bw = abstractFragmentC2122F.f2187r;
        if (c2183bw != null) {
            c2183bw.m1975Z();
            abstractFragmentC2122F.f2187r = null;
        }
        C2138ad c2138adM1390S = abstractFragmentC2122F.m1390S();
        if (c2138adM1390S != null) {
            c2138adM1390S.m1463B(abstractFragmentC2122F.f2182l);
            abstractFragmentC2122F.f2182l = null;
        }
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m1378Z(AbstractFragmentC2122F abstractFragmentC2122F, EnumC2141ag enumC2141ag) {
        if (abstractFragmentC2122F.mo1389L()) {
            int i = AnonymousClass1.f2190B[enumC2141ag.ordinal()];
            if (i == 1) {
                if (abstractFragmentC2122F.f2170Z.isEnabled()) {
                    return;
                }
                abstractFragmentC2122F.f2170Z.setEnabled(true, true);
            } else if (i == 2 && abstractFragmentC2122F.f2170Z.isEnabled() && !abstractFragmentC2122F.f2168S) {
                abstractFragmentC2122F.f2170Z.setEnabled(false, true);
            }
        }
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m1377Z(AbstractFragmentC2122F abstractFragmentC2122F) {
        abstractFragmentC2122F.m1382d();
        AbstractRunnableC2150ap abstractRunnableC2150apM1379a = abstractFragmentC2122F.m1379a();
        abstractFragmentC2122F.f2171a = abstractRunnableC2150apM1379a;
        abstractFragmentC2122F.f2186p.postDelayed(abstractRunnableC2150apM1379a, FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
    }

    /* JADX INFO: renamed from: B */
    static /* synthetic */ void m1368B(AbstractFragmentC2122F abstractFragmentC2122F) {
        abstractFragmentC2122F.f2164D = true;
        abstractFragmentC2122F.f2169V.setEnabled(false);
        abstractFragmentC2122F.Code(false);
        abstractFragmentC2122F.f2170Z.setEnabled(false, true);
        abstractFragmentC2122F.f2173c = ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f).setDuration(1000L);
        abstractFragmentC2122F.mo1396c();
    }
}
