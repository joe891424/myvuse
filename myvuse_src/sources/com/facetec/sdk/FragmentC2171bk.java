package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facetec.sdk.AbstractActivityC2219g;
import com.facetec.sdk.C2138ad;
import com.facetec.sdk.C2160az;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facetec.sdk.bk */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2171bk extends Fragment implements TraceFieldInterface {

    /* JADX INFO: renamed from: Z */
    public static boolean f2831Z = false;

    /* JADX INFO: renamed from: B */
    public ImageView f2832B;

    /* JADX INFO: renamed from: C */
    private LinearLayout f2833C;

    /* JADX INFO: renamed from: F */
    private ImageView f2835F;

    /* JADX INFO: renamed from: S */
    private TextView f2838S;

    /* JADX INFO: renamed from: V */
    C2182bv f2839V;
    public Trace _nr_trace;

    /* JADX INFO: renamed from: a */
    private FrameLayout f2840a;

    /* JADX INFO: renamed from: b */
    private TextView f2841b;

    /* JADX INFO: renamed from: c */
    private View f2842c;

    /* JADX INFO: renamed from: d */
    private C2146al f2843d;

    /* JADX INFO: renamed from: e */
    private Z f2844e;

    /* JADX INFO: renamed from: f */
    private Handler f2845f;

    /* JADX INFO: renamed from: i */
    private Handler f2848i;

    /* JADX INFO: renamed from: j */
    private Handler f2849j;

    /* JADX INFO: renamed from: o */
    private Semaphore f2854o;

    /* JADX INFO: renamed from: p */
    private EnumC2143ai f2855p;

    /* JADX INFO: renamed from: s */
    private Handler f2858s;

    /* JADX INFO: renamed from: D */
    private int f2834D = 30;

    /* JADX INFO: renamed from: L */
    private boolean f2837L = false;

    /* JADX INFO: renamed from: h */
    private boolean f2847h = false;

    /* JADX INFO: renamed from: g */
    private boolean f2846g = false;

    /* JADX INFO: renamed from: n */
    private boolean f2853n = false;

    /* JADX INFO: renamed from: m */
    private boolean f2852m = false;

    /* JADX INFO: renamed from: l */
    private boolean f2851l = false;
    EnumC2139ae Code = null;

    /* JADX INFO: renamed from: I */
    boolean f2836I = false;

    /* JADX INFO: renamed from: k */
    private final int f2850k = (int) C2188cb.m1993V(12);

    /* JADX INFO: renamed from: q */
    private boolean f2856q = false;

    /* JADX INFO: renamed from: t */
    private final Runnable f2859t = new Runnable() { // from class: com.facetec.sdk.bk.11
        @Override // java.lang.Runnable
        public final void run() {
            if (C2140af.m1495I() == EnumC2139ae.ZOOM_CLOSE) {
                FragmentC2171bk.this.Code();
                C2160az.m1802V(C2160az.V.FACE_CAPTURE_MOVE_CLOSER_DELAYED);
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private final C2138ad.B f2857r = new AbstractC2148an() { // from class: com.facetec.sdk.bk.2
        @Override // com.facetec.sdk.AbstractC2148an, com.facetec.sdk.C2138ad.B
        /* JADX INFO: renamed from: V */
        public final void mo1399V(EnumC2147am enumC2147am, EnumC2142ah enumC2142ah, EnumC2143ai enumC2143ai, EnumC2141ag enumC2141ag) {
            if (enumC2147am == EnumC2147am.TIMEOUT_GO_TO_RETRY) {
                C2138ad c2138adM1897Z = FragmentC2171bk.this.m1897Z();
                if (c2138adM1897Z != null) {
                    c2138adM1897Z.m1465D();
                    c2138adM1897Z.m1463B(FragmentC2171bk.this.f2857r);
                }
                AbstractActivityC2220h abstractActivityC2220hCode = FragmentC2171bk.this.Code();
                if (abstractActivityC2220hCode != null) {
                    abstractActivityC2220hCode.mo2187S();
                    return;
                }
                return;
            }
            if (FragmentC2171bk.this.f2847h && enumC2147am != EnumC2147am.DETECTING_LIGHT_MODE) {
                if (enumC2147am != EnumC2147am.DETECTING_FACE_FEEDBACK) {
                    C2138ad c2138adM1897Z2 = FragmentC2171bk.this.m1897Z();
                    if (c2138adM1897Z2 != null) {
                        c2138adM1897Z2.m1465D();
                        c2138adM1897Z2.m1463B(FragmentC2171bk.this.f2857r);
                    }
                    FragmentC2171bk.this.Code(FragmentC2171bk.this.Code());
                    return;
                }
                if (!FragmentC2171bk.this.isAdded() || FragmentC2171bk.this.f2837L) {
                    return;
                }
                FragmentC2171bk.this.f2855p = enumC2143ai;
                FragmentC2171bk.this.m1899Z(enumC2143ai);
            }
        }
    };

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

    /* JADX INFO: renamed from: I */
    static /* synthetic */ boolean m1891I(FragmentC2171bk fragmentC2171bk) {
        fragmentC2171bk.f2851l = true;
        return true;
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ boolean m1904d(FragmentC2171bk fragmentC2171bk) {
        fragmentC2171bk.f2847h = true;
        return true;
    }

    /* JADX INFO: renamed from: h */
    static /* synthetic */ boolean m1908h(FragmentC2171bk fragmentC2171bk) {
        fragmentC2171bk.f2846g = true;
        return true;
    }

    /* JADX INFO: renamed from: o */
    static /* synthetic */ boolean m1914o(FragmentC2171bk fragmentC2171bk) {
        fragmentC2171bk.f2852m = false;
        return false;
    }

    /* JADX INFO: renamed from: I */
    static FragmentC2171bk m1888I(String str) {
        FragmentC2171bk fragmentC2171bk = new FragmentC2171bk();
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsAttribute.APP_EXIT_REASON_ATTRIBUTE, str);
        fragmentC2171bk.setArguments(bundle);
        return fragmentC2171bk;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        TraceMachine.startTracing("bk");
        try {
            TraceMachine.enterMethod(this._nr_trace, "bk#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "bk#onCreate", null);
        }
        super.onCreate(bundle);
        this.f2846g = false;
        this.f2853n = false;
        this.f2852m = false;
        this.f2854o = new Semaphore(1);
        TraceMachine.exitMethod();
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "bk#onCreateView", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "bk#onCreateView", null);
        }
        View viewInflate = layoutInflater.inflate(C2130R.layout.facetec_facescan_fragment, viewGroup, false);
        TraceMachine.exitMethod();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final AbstractActivityC2220h abstractActivityC2220hCode = Code();
        C2138ad c2138adM1897Z = m1897Z();
        if (c2138adM1897Z == null) {
            return;
        }
        C2120C.f2147V = C2173bm.f2903Z;
        Z z = new Z(this, (byte) 0);
        this.f2844e = z;
        c2138adM1897Z.Code(z);
        EnumC2147am enumC2147amM1476c = c2138adM1897Z.m1476c();
        EnumC2143ai enumC2143aiM1477e = c2138adM1897Z.m1477e();
        if (enumC2147amM1476c != EnumC2147am.READY_TO_START_ZOOM_SESSION) {
            c2138adM1897Z.Code(this.f2857r);
        }
        this.f2833C = (LinearLayout) view.findViewById(C2130R.id.zoomLogoContainer);
        this.f2835F = (ImageView) view.findViewById(C2130R.id.securityWatermark);
        this.f2838S = (TextView) view.findViewById(C2130R.id.zoomLogoText);
        String packageName = abstractActivityC2220hCode.getPackageName();
        int i = AnonymousClass4.f2865I[FaceTecSDK.f2235I.securityWatermarkImage.ordinal()];
        if (i == 1) {
            this.f2835F.setImageDrawable(ContextCompat.getDrawable(getActivity(), C2130R.drawable.facetec_internal_zoom_watermark));
        } else if (i == 2) {
            this.f2835F.setImageDrawable(ContextCompat.getDrawable(getActivity(), C2130R.drawable.facetec_internal_facetec_watermark));
        }
        float fM1644I = C2156av.m1644I();
        this.f2835F.setLayoutParams(new LinearLayout.LayoutParams(-2, (int) (Resources.getSystem().getDisplayMetrics().heightPixels * C2156av.Code() * 0.15f * fM1644I)));
        this.f2834D = 12;
        this.f2838S.setVisibility(0);
        this.f2838S.setTextSize(C2156av.Code() * 8.0f * fM1644I);
        if (packageName.contains("com.facetec.zoomlogin")) {
            this.f2838S.setText("v9.4.12");
        } else {
            this.f2838S.setText("v9.4.12".concat(String.valueOf(Build.CPU_ABI.equals("arm64-v8a") ? " 64-bit" : "")));
        }
        this.f2833C.setPadding(0, 0, 0, this.f2834D);
        this.f2839V = (C2182bv) view.findViewById(C2130R.id.zoomOval);
        this.f2842c = view.findViewById(C2130R.id.instructionsBackground);
        this.f2832B = (ImageView) view.findViewById(C2130R.id.zoomBackButton);
        this.f2841b = (TextView) view.findViewById(C2130R.id.authReasonText);
        C2146al c2146al = (C2146al) view.findViewById(C2130R.id.zoomProgressBar);
        this.f2843d = c2146al;
        c2146al.m1591B(enumC2147amM1476c, enumC2143aiM1477e);
        C2146al c2146al2 = this.f2843d;
        if (c2146al2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2146al2.getLayoutParams();
            C2156av.m1634D();
            layoutParams.addRule(13, -1);
            layoutParams.setMargins(0, 0, 0, 0);
            c2146al2.requestLayout();
        }
        this.f2841b.setTypeface(C2170bj.f2830I);
        C2156av.m1693Z(this.f2841b);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C2130R.id.transitionView);
        this.f2840a = frameLayout;
        C2156av.Code(frameLayout);
        this.f2848i = new Handler(Looper.getMainLooper());
        this.f2849j = new Handler();
        if (enumC2147amM1476c == EnumC2147am.READY_TO_START_ZOOM_SESSION) {
            Code(abstractActivityC2220hCode);
        }
        this.f2832B.setEnabled(true);
        if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
            this.f2832B.setImageDrawable(ContextCompat.getDrawable(abstractActivityC2220hCode, C2156av.m1748az()));
        }
        int i2 = AnonymousClass4.Code[FaceTecSDK.f2235I.f2222d.f2205Z.ordinal()];
        if (i2 == 2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2832B.getLayoutParams();
            layoutParams2.removeRule(20);
            layoutParams2.addRule(21);
            this.f2832B.setLayoutParams(layoutParams2);
        } else if (i2 == 3 || i2 == 4) {
            this.f2832B.setVisibility(8);
        }
        this.f2832B.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.facetec.sdk.bk.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (FragmentC2171bk.this.f2851l) {
                    return;
                }
                FragmentC2171bk.m1891I(FragmentC2171bk.this);
                float fM1644I2 = C2156av.m1644I();
                float fCode = C2156av.Code();
                int iM1675V = C2156av.m1675V();
                int iM1993V = (int) (C2188cb.m1993V(C2156av.f2639Z) * fCode * fM1644I2);
                float f = iM1675V / 2.0f;
                int iRound = Math.round(f);
                int iRound2 = Math.round(f);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) FragmentC2171bk.this.f2832B.getLayoutParams();
                layoutParams3.setMargins(iRound, iRound, 0, 0);
                layoutParams3.setMarginStart(iRound);
                layoutParams3.setMarginEnd(iRound);
                FragmentC2171bk.this.f2832B.setLayoutParams(layoutParams3);
                FragmentC2171bk.this.f2832B.setPadding(iRound2, iRound2, iRound2, iRound2);
                FragmentC2171bk.this.f2832B.getLayoutParams().height = iM1993V;
                FragmentC2171bk.this.f2832B.getLayoutParams().width = iM1993V;
                FragmentC2171bk.this.f2832B.requestLayout();
            }
        });
        this.f2832B.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.bk.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (FragmentC2171bk.this.f2846g) {
                    EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_ZOOM_SESSION_FAIL;
                }
                abstractActivityC2220hCode.mo2196c();
            }
        });
        this.f2832B.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.bk.3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    FragmentC2171bk.this.f2832B.setAlpha(0.4f);
                } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > FragmentC2171bk.this.f2832B.getWidth() + FragmentC2171bk.this.f2832B.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > FragmentC2171bk.this.f2832B.getHeight() + FragmentC2171bk.this.f2832B.getTop() + 10) {
                    FragmentC2171bk.this.f2832B.setAlpha(1.0f);
                } else if (motionEvent.getAction() == 1) {
                    FragmentC2171bk.this.f2832B.setAlpha(1.0f);
                    FragmentC2171bk.this.f2832B.setEnabled(false);
                    if (FragmentC2171bk.this.Code() == null) {
                        return false;
                    }
                    FragmentC2171bk.this.f2832B.performClick();
                }
                return true;
            }
        });
        AbstractActivityC2220h abstractActivityC2220hCode2 = Code();
        if (abstractActivityC2220hCode2 != null) {
            abstractActivityC2220hCode2.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.bk.7
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentC2171bk.this.f2832B.setImageResource(C2156av.m1748az());
                    FragmentC2171bk.this.f2839V.m1961S();
                }
            });
        }
        this.f2847h = false;
        this.f2839V.setVisibility(0);
        this.f2839V.setAlpha(1.0f);
        this.f2840a.setAlpha(0.0f);
        this.f2832B.setAlpha(0.0f);
        new Handler().postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.bk.8
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FragmentC2171bk.this.f2839V.setVisibility(0);
                C2146al c2146al3 = FragmentC2171bk.this.f2843d;
                c2146al3.postDelayed(new Runnable() { // from class: com.facetec.sdk.al.3

                    /* JADX INFO: renamed from: Z */
                    private /* synthetic */ int f2557Z = 500;

                    AnonymousClass3() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        float y = C2146al.this.getY();
                        C2146al.this.setVisibility(0);
                        C2146al.this.setAlpha(0.0f);
                        C2146al.this.setY(y - (r1.f2544B.getHeight() / 2));
                        C2146al.this.animate().setDuration(this.f2557Z).alpha(1.0f).y(y).setListener(null).start();
                    }
                }, 50L);
                FragmentC2171bk.this.f2839V.animate().alpha(1.0f).setDuration(200L).setListener(null).start();
                FragmentC2171bk.this.f2840a.animate().alpha(0.0f).setDuration(300L).setListener(null).start();
                if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT || FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT) {
                    FragmentC2171bk.this.f2832B.setVisibility(0);
                    FragmentC2171bk.this.f2832B.animate().alpha(1.0f).setDuration(500L).setStartDelay(50L).setListener(null).start();
                }
                AbstractActivityC2220h abstractActivityC2220hCode3 = FragmentC2171bk.this.Code();
                if (abstractActivityC2220hCode3 == null) {
                    return;
                }
                abstractActivityC2220hCode3.f3472V.animate().alpha(0.0f).setDuration(500L).setStartDelay(0L).setListener(null).start();
                FragmentC2171bk.this.f2848i.postDelayed(new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.8.1
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        if (FragmentC2171bk.this.f2837L) {
                            return;
                        }
                        FragmentC2171bk.this.f2833C.setAlpha(0.0f);
                        FragmentC2171bk.this.f2833C.setVisibility(0);
                        FragmentC2171bk.this.f2838S.setAlpha(0.0f);
                        FragmentC2171bk.this.f2856q = false;
                        FragmentC2171bk.this.f2839V.m1963V(false);
                        int iM1956C = FragmentC2171bk.this.f2839V.m1956C() - (FragmentC2171bk.this.f2850k << 1);
                        if ((FragmentC2171bk.this.f2839V.m1957D() - FragmentC2171bk.this.f2833C.getHeight()) - (FragmentC2171bk.this.f2850k << 1) >= iM1956C && C2221j.m2231F() < 1.4d) {
                            FragmentC2171bk.this.f2833C.setY(iM1956C);
                        }
                        FragmentC2171bk.this.f2833C.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
                    }
                }, 500L);
                FragmentC2171bk.this.f2848i.postDelayed(new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.8.4
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        FragmentC2171bk.m1904d(FragmentC2171bk.this);
                    }
                }, 1150L);
            }
        }, 0L);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bk$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] Code;

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2865I;

        static {
            int[] iArr = new int[FaceTecCancelButtonCustomization.ButtonLocation.values().length];
            Code = iArr;
            try {
                iArr[FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[FaceTecCancelButtonCustomization.ButtonLocation.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[FaceTecSecurityWatermarkImage.values().length];
            f2865I = iArr2;
            try {
                iArr2[FaceTecSecurityWatermarkImage.FACETEC_ZOOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2865I[FaceTecSecurityWatermarkImage.FACETEC.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // android.app.Fragment
    public final Animator onCreateAnimator(int i, boolean z, int i2) {
        if (!z) {
            return ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f).setDuration(400L);
        }
        return super.onCreateAnimator(i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbstractActivityC2220h Code() {
        return (AbstractActivityC2220h) getActivity();
    }

    /* JADX INFO: renamed from: B */
    final EnumC2143ai m1915B() {
        return this.f2855p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z */
    public C2138ad m1897Z() {
        AbstractActivityC2220h abstractActivityC2220hCode = Code();
        if (abstractActivityC2220hCode != null) {
            return abstractActivityC2220hCode.f3470B;
        }
        return null;
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Context context) {
        C2120C.f2147V = C2173bm.f2899I;
        this.f2837L = false;
        final AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) getActivity();
        if (abstractActivityC2219g != null) {
            abstractActivityC2219g.f3291ab = AbstractActivityC2219g.C.ZOOM_SESSION_STARTED;
        }
        this.f2848i.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.bk.9
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                AbstractActivityC2220h abstractActivityC2220hCode;
                C2138ad c2138adM1897Z = FragmentC2171bk.this.m1897Z();
                if (c2138adM1897Z == null || c2138adM1897Z.m1475Z(context, abstractActivityC2219g.f3243D) || (abstractActivityC2220hCode = FragmentC2171bk.this.Code()) == null) {
                    return;
                }
                int i = C2173bm.f2897D;
                abstractActivityC2220hCode.mo2186L();
            }
        }, 20L);
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f2837L = true;
        Handler handler = this.f2848i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.f2849j;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        Handler handler3 = this.f2845f;
        if (handler3 != null) {
            handler3.removeCallbacksAndMessages(null);
        }
        C2146al c2146al = this.f2843d;
        if (c2146al != null) {
            c2146al.m1593Z();
        }
        m1889I();
        Handler handler4 = this.f2858s;
        if (handler4 != null) {
            handler4.removeCallbacksAndMessages(null);
            this.f2858s = null;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.bk$Z */
    class Z implements C2138ad.I {
        private Z() {
        }

        /* synthetic */ Z(FragmentC2171bk fragmentC2171bk, byte b) {
            this();
        }

        @Override // com.facetec.sdk.C2138ad.I
        public final void Code(EnumC2139ae enumC2139ae, EnumC2136ab enumC2136ab) {
            AbstractActivityC2220h abstractActivityC2220hCode = FragmentC2171bk.this.Code();
            if (!FragmentC2171bk.this.isAdded() || abstractActivityC2220hCode == null) {
                return;
            }
            if (FragmentC2171bk.this.f2839V.m1958F() && enumC2136ab == EnumC2136ab.HOLD_STEADY && !FragmentC2171bk.this.f2856q) {
                FragmentC2171bk.this.f2838S.animate().alpha(1.0f).setDuration(500L).setStartDelay(0L).setListener(null).start();
                FragmentC2171bk.this.f2856q = true;
            }
            if (!FragmentC2171bk.this.f2846g && enumC2136ab != EnumC2136ab.FACE_NOT_FOUND) {
                FragmentC2171bk.m1908h(FragmentC2171bk.this);
                if (!FragmentC2171bk.this.f2853n) {
                    FragmentC2171bk.this.f2853n = true;
                    C2179bs.Code(abstractActivityC2220hCode);
                }
                abstractActivityC2220hCode.mo2184F();
            }
            if (!FragmentC2171bk.this.isAdded() || FragmentC2171bk.this.f2837L) {
                return;
            }
            if (FragmentC2171bk.this.Code != enumC2139ae) {
                if (FragmentC2171bk.this.Code != null) {
                    FragmentC2171bk.this.m1886F();
                }
                FragmentC2171bk.this.Code = enumC2139ae;
                FragmentC2171bk.this.f2836I = false;
            }
            if (enumC2139ae == EnumC2139ae.ZOOM_CLOSE) {
                FragmentC2171bk.m1910j(FragmentC2171bk.this);
            }
            FragmentC2171bk.this.m1895V(enumC2139ae, enumC2136ab);
        }

        @Override // com.facetec.sdk.C2138ad.I
        /* JADX INFO: renamed from: I */
        public final void mo1479I() {
            AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) FragmentC2171bk.this.getActivity();
            if (abstractActivityC2219g != null) {
                abstractActivityC2219g.m2206m();
            }
            final AbstractActivityC2220h abstractActivityC2220hCode = FragmentC2171bk.this.Code();
            if (!FragmentC2171bk.this.isAdded() || abstractActivityC2220hCode == null) {
                return;
            }
            FragmentC2171bk.this.m1889I();
            C2179bs.m1945V(abstractActivityC2220hCode);
            if (FragmentC2171bk.this.f2846g) {
                EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_ZOOM_SESSION_FAIL;
            }
            FragmentC2171bk.m1890I(FragmentC2171bk.this, new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.1
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2171bk.this.f2848i.post(new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.1.1
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            abstractActivityC2220hCode.mo2183D();
                        }
                    });
                }
            }, false);
        }

        @Override // com.facetec.sdk.C2138ad.I
        /* JADX INFO: renamed from: Z */
        public final void mo1480Z() {
            AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) FragmentC2171bk.this.getActivity();
            if (abstractActivityC2219g != null) {
                abstractActivityC2219g.m2206m();
            }
            final AbstractActivityC2220h abstractActivityC2220hCode = FragmentC2171bk.this.Code();
            if (!FragmentC2171bk.this.isAdded() || abstractActivityC2220hCode == null) {
                return;
            }
            FragmentC2171bk.this.m1889I();
            if (FragmentC2171bk.this.f2853n) {
                C2179bs.m1935B(abstractActivityC2220hCode);
                FragmentC2171bk.this.f2853n = false;
            }
            if (FragmentC2171bk.this.f2852m) {
                try {
                    FragmentC2171bk.m1914o(FragmentC2171bk.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_ZOOM_SESSION_SUCCESS;
            FragmentC2171bk.m1890I(FragmentC2171bk.this, new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.4
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2171bk.this.f2848i.post(new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.4.2
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            abstractActivityC2220hCode.Code();
                        }
                    });
                }
            }, true);
        }

        @Override // com.facetec.sdk.C2138ad.I
        /* JADX INFO: renamed from: B */
        public final void mo1478B() {
            AbstractActivityC2219g abstractActivityC2219g = (AbstractActivityC2219g) FragmentC2171bk.this.getActivity();
            if (abstractActivityC2219g != null) {
                abstractActivityC2219g.m2206m();
            }
            final AbstractActivityC2220h abstractActivityC2220hCode = FragmentC2171bk.this.Code();
            if (!FragmentC2171bk.this.isAdded() || abstractActivityC2220hCode == null) {
                return;
            }
            FragmentC2171bk.this.m1889I();
            C2179bs.m1945V(abstractActivityC2220hCode);
            if (FragmentC2171bk.this.f2846g) {
                EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_ZOOM_SESSION_FAIL;
            }
            FragmentC2171bk.m1890I(FragmentC2171bk.this, new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.5
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2171bk.this.f2848i.post(new AbstractRunnableC2150ap(FragmentC2171bk.this) { // from class: com.facetec.sdk.bk.Z.5.2
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            abstractActivityC2220hCode.mo2182C();
                        }
                    });
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I */
    public void m1889I() {
        C2138ad c2138adM1897Z = m1897Z();
        if (c2138adM1897Z != null) {
            c2138adM1897Z.m1473Z(this.f2844e);
            this.f2844e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F */
    public void m1886F() {
        if (this.f2836I || !this.f2846g) {
            return;
        }
        this.f2839V.m1962V();
        this.f2836I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V */
    public synchronized void m1895V(EnumC2139ae enumC2139ae, EnumC2136ab enumC2136ab) {
        if (enumC2139ae == EnumC2139ae.ZOOM_FAR) {
            m1884D();
        }
        if (enumC2136ab == EnumC2136ab.HOLD_STEADY) {
            this.f2839V.m1962V();
            this.f2836I = true;
        }
        this.f2843d.m1590B(enumC2136ab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z */
    public synchronized void m1899Z(EnumC2143ai enumC2143ai) {
        m1884D();
        this.f2843d.m1594Z(enumC2143ai);
    }

    /* JADX INFO: renamed from: D */
    private void m1884D() {
        if (this.f2839V.m1958F()) {
            this.f2839V.m1964b();
        }
    }

    /* JADX INFO: renamed from: V */
    final void m1916V() {
        Semaphore semaphore = this.f2854o;
        if (semaphore != null) {
            try {
                if (semaphore.tryAcquire(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS, TimeUnit.MILLISECONDS)) {
                    this.f2854o.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: j */
    static /* synthetic */ void m1910j(FragmentC2171bk fragmentC2171bk) {
        C2120C.f2147V = C2173bm.f2902V;
        if (fragmentC2171bk.f2839V.m1958F()) {
            return;
        }
        fragmentC2171bk.f2839V.m1966e();
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
            fragmentC2171bk.Code();
            C2160az.m1802V(C2160az.V.FACE_CAPTURE_MOVE_CLOSER_AUTOMATIC);
            Handler handler = new Handler();
            fragmentC2171bk.f2858s = handler;
            handler.postDelayed(fragmentC2171bk.f2859t, 4500L);
        }
        if (FaceTecSDK.f2235I.f2216S.enablePulsatingText) {
            Handler handler2 = new Handler();
            fragmentC2171bk.f2845f = handler2;
            handler2.postDelayed(new AbstractRunnableC2150ap(fragmentC2171bk) { // from class: com.facetec.sdk.bk.10
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2171bk.this.f2843d.m1592I();
                }
            }, 3000L);
        }
    }

    /* JADX INFO: renamed from: I */
    static /* synthetic */ void m1890I(FragmentC2171bk fragmentC2171bk, Runnable runnable, boolean z) {
        fragmentC2171bk.m1886F();
        int i = z ? 400 : 300;
        fragmentC2171bk.f2839V.m1965d();
        fragmentC2171bk.f2839V.m1959I(new AbstractRunnableC2150ap(fragmentC2171bk) { // from class: com.facetec.sdk.bk.6
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FragmentC2171bk.this.f2854o.release();
            }
        }, z);
        try {
            fragmentC2171bk.f2854o.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentC2171bk.f2832B.setVisibility(4);
        fragmentC2171bk.f2842c.setVisibility(4);
        fragmentC2171bk.f2841b.setVisibility(4);
        C2156av.m1652I(fragmentC2171bk.f2840a);
        fragmentC2171bk.f2840a.animate().alpha(1.0f).setDuration(i + 100).setStartDelay(0L).setListener(null).start();
        AnimatorSet duration = new AnimatorSet().setDuration(i);
        duration.playTogether(ObjectAnimator.ofFloat(fragmentC2171bk.f2833C, (Property<LinearLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(fragmentC2171bk.f2843d, (Property<C2146al, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(fragmentC2171bk.f2832B, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(fragmentC2171bk.f2843d, (Property<C2146al, Float>) View.TRANSLATION_Y, (-fragmentC2171bk.f2843d.getHeight()) / 2));
        duration.start();
        runnable.run();
    }
}
