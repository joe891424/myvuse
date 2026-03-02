package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facetec.sdk.AbstractActivityC2220h;
import com.facetec.sdk.C2120C;
import com.facetec.sdk.C2138ad;
import com.facetec.sdk.C2160az;
import com.facetec.sdk.C2187ca;
import com.facetec.sdk.C2232x.AnonymousClass1;
import com.facetec.sdk.C2232x.AnonymousClass2;
import com.facetec.sdk.C2232x.AnonymousClass5;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.facetec.sdk.FaceTecSDK;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;
import com.facetec.sdk.FragmentC2145ak;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.logging.type.LogSeverity;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.g */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractActivityC2219g extends AbstractActivityC2220h implements ActivityCompat.OnRequestPermissionsResultCallback {

    /* JADX INFO: renamed from: A */
    ImageView f3241A;

    /* JADX INFO: renamed from: C */
    private volatile FragmentC2171bk f3242C;
    private Handler Code;

    /* JADX INFO: renamed from: E */
    RelativeLayout f3244E;

    /* JADX INFO: renamed from: F */
    float f3245F;

    /* JADX INFO: renamed from: H */
    LinearLayout f3247H;

    /* JADX INFO: renamed from: J */
    LinearLayout f3248J;

    /* JADX INFO: renamed from: K */
    String f3249K;

    /* JADX INFO: renamed from: L */
    RelativeLayout f3250L;

    /* JADX INFO: renamed from: M */
    RelativeLayout f3251M;

    /* JADX INFO: renamed from: N */
    RelativeLayout f3252N;

    /* JADX INFO: renamed from: O */
    RelativeLayout f3253O;

    /* JADX INFO: renamed from: P */
    FaceTecIDScanResult f3254P;

    /* JADX INFO: renamed from: Q */
    FaceTecSessionResult f3255Q;

    /* JADX INFO: renamed from: R */
    String f3256R;

    /* JADX INFO: renamed from: S */
    float f3257S;

    /* JADX INFO: renamed from: U */
    FaceTecIDScanRetryMode f3259U;

    /* JADX INFO: renamed from: Y */
    ImageView f3262Y;

    /* JADX INFO: renamed from: a */
    RelativeLayout f3263a;

    /* JADX INFO: renamed from: aB */
    private AbstractC2165be f3265aB;

    /* JADX INFO: renamed from: aG */
    private String f3270aG;

    /* JADX INFO: renamed from: aH */
    private C2187ca f3271aH;

    /* JADX INFO: renamed from: aI */
    private C2232x f3272aI;

    /* JADX INFO: renamed from: aJ */
    private C2129L f3273aJ;

    /* JADX INFO: renamed from: aM */
    private int f3276aM;

    /* JADX INFO: renamed from: aN */
    private LinearLayout f3277aN;

    /* JADX INFO: renamed from: aQ */
    private TextView f3280aQ;

    /* JADX INFO: renamed from: aR */
    private LinearLayout f3281aR;

    /* JADX INFO: renamed from: aS */
    private ImageView f3282aS;

    /* JADX INFO: renamed from: aT */
    private LinearLayout f3283aT;

    /* JADX INFO: renamed from: aU */
    private ImageView f3284aU;

    /* JADX INFO: renamed from: aV */
    private RelativeLayout f3285aV;

    /* JADX INFO: renamed from: aa */
    Bitmap f3290aa;

    /* JADX INFO: renamed from: ac */
    Integer f3292ac;

    /* JADX INFO: renamed from: ad */
    Integer f3293ad;

    /* JADX INFO: renamed from: ae */
    Integer f3294ae;

    /* JADX INFO: renamed from: af */
    View f3295af;

    /* JADX INFO: renamed from: ah */
    private volatile FragmentC2151aq f3297ah;

    /* JADX INFO: renamed from: ai */
    private volatile FragmentC2227q f3298ai;

    /* JADX INFO: renamed from: aj */
    private volatile FragmentC2231w f3299aj;

    /* JADX INFO: renamed from: ak */
    private volatile FragmentC2145ak f3300ak;

    /* JADX INFO: renamed from: al */
    private volatile byte[][] f3301al;

    /* JADX INFO: renamed from: an */
    private volatile byte[][] f3303an;

    /* JADX INFO: renamed from: ap */
    private volatile byte[] f3305ap;

    /* JADX INFO: renamed from: b */
    RelativeLayout f3316b;

    /* JADX INFO: renamed from: ba */
    private Handler f3317ba;

    /* JADX INFO: renamed from: bb */
    private Timer f3318bb;

    /* JADX INFO: renamed from: bf */
    private Timer f3322bf;

    /* JADX INFO: renamed from: bg */
    private boolean f3323bg;

    /* JADX INFO: renamed from: bh */
    private TimerTask f3324bh;

    /* JADX INFO: renamed from: bi */
    private ValueAnimator f3325bi;

    /* JADX INFO: renamed from: bk */
    private boolean f3327bk;

    /* JADX INFO: renamed from: bl */
    private boolean f3328bl;

    /* JADX INFO: renamed from: bm */
    private final Runnable f3329bm;

    /* JADX INFO: renamed from: bn */
    private TimerTask f3330bn;

    /* JADX INFO: renamed from: bo */
    private float f3331bo;

    /* JADX INFO: renamed from: bp */
    private final C2187ca.Code f3332bp;

    /* JADX INFO: renamed from: br */
    private C2138ad.Z f3333br;

    /* JADX INFO: renamed from: bt */
    private boolean f3334bt;

    /* JADX INFO: renamed from: c */
    RelativeLayout f3335c;

    /* JADX INFO: renamed from: d */
    RelativeLayout f3336d;

    /* JADX INFO: renamed from: e */
    RelativeLayout f3337e;

    /* JADX INFO: renamed from: f */
    RelativeLayout f3338f;

    /* JADX INFO: renamed from: g */
    ImageView f3339g;

    /* JADX INFO: renamed from: h */
    RelativeLayout f3340h;

    /* JADX INFO: renamed from: i */
    View f3341i;

    /* JADX INFO: renamed from: j */
    RelativeLayout f3342j;

    /* JADX INFO: renamed from: k */
    C2218e f3343k;

    /* JADX INFO: renamed from: l */
    RelativeLayout f3344l;

    /* JADX INFO: renamed from: m */
    RelativeLayout f3345m;

    /* JADX INFO: renamed from: n */
    RelativeLayout f3346n;

    /* JADX INFO: renamed from: o */
    TextView f3347o;

    /* JADX INFO: renamed from: p */
    C2162bb f3348p;

    /* JADX INFO: renamed from: q */
    ImageView f3349q;

    /* JADX INFO: renamed from: r */
    TextView f3350r;

    /* JADX INFO: renamed from: s */
    TextView f3351s;

    /* JADX INFO: renamed from: t */
    C2162bb f3352t;

    /* JADX INFO: renamed from: u */
    ImageView f3353u;

    /* JADX INFO: renamed from: v */
    RelativeLayout f3354v;

    /* JADX INFO: renamed from: w */
    LinearLayout f3355w;

    /* JADX INFO: renamed from: x */
    C2162bb f3356x;

    /* JADX INFO: renamed from: y */
    C2162bb f3357y;

    /* JADX INFO: renamed from: z */
    C2223m f3358z;

    /* JADX INFO: renamed from: aq */
    private volatile FaceTecSessionStatus f3306aq = null;

    /* JADX INFO: renamed from: ao */
    private volatile FaceTecSessionStatus f3304ao = FaceTecSessionStatus.SESSION_UNSUCCESSFUL;

    /* JADX INFO: renamed from: am */
    private boolean f3302am = false;

    /* JADX INFO: renamed from: av */
    private boolean f3311av = false;

    /* JADX INFO: renamed from: ar */
    private boolean f3307ar = false;

    /* JADX INFO: renamed from: as */
    private boolean f3308as = false;

    /* JADX INFO: renamed from: au */
    private boolean f3310au = false;

    /* JADX INFO: renamed from: at */
    private boolean f3309at = false;

    /* JADX INFO: renamed from: az */
    private boolean f3315az = false;

    /* JADX INFO: renamed from: ax */
    private boolean f3313ax = false;

    /* JADX INFO: renamed from: ay */
    private boolean f3314ay = false;

    /* JADX INFO: renamed from: aA */
    private boolean f3264aA = false;

    /* JADX INFO: renamed from: aw */
    private boolean f3312aw = false;

    /* JADX INFO: renamed from: aC */
    private boolean f3266aC = false;

    /* JADX INFO: renamed from: aD */
    private boolean f3267aD = false;

    /* JADX INFO: renamed from: aE */
    private boolean f3268aE = false;

    /* JADX INFO: renamed from: aF */
    private boolean f3269aF = false;

    /* JADX INFO: renamed from: D */
    String f3243D = "";

    /* JADX INFO: renamed from: aK */
    private boolean f3274aK = false;

    /* JADX INFO: renamed from: aL */
    private boolean f3275aL = false;

    /* JADX INFO: renamed from: aP */
    private int f3279aP = 0;

    /* JADX INFO: renamed from: aO */
    private boolean f3278aO = false;

    /* JADX INFO: renamed from: G */
    Z f3246G = Z.FRONT;

    /* JADX INFO: renamed from: aY */
    private boolean f3288aY = false;

    /* JADX INFO: renamed from: aX */
    private boolean f3287aX = false;

    /* JADX INFO: renamed from: aZ */
    private boolean f3289aZ = false;

    /* JADX INFO: renamed from: aW */
    private int f3286aW = 0;

    /* JADX INFO: renamed from: T */
    boolean f3258T = false;

    /* JADX INFO: renamed from: bc */
    private JSONObject f3319bc = null;

    /* JADX INFO: renamed from: X */
    boolean f3261X = false;

    /* JADX INFO: renamed from: be */
    private int f3321be = 0;

    /* JADX INFO: renamed from: bd */
    private boolean f3320bd = false;

    /* JADX INFO: renamed from: W */
    FragmentC2145ak.V f3260W = FragmentC2145ak.V.DEFAULT;

    /* JADX INFO: renamed from: ab */
    C f3291ab = C.NOT_STARTED;

    /* JADX INFO: renamed from: ag */
    boolean f3296ag = false;

    /* JADX INFO: renamed from: bj */
    private boolean f3326bj = false;

    /* JADX INFO: renamed from: com.facetec.sdk.g$C */
    enum C {
        NOT_STARTED,
        PRE_SESSION_STARTED,
        ZOOM_SESSION_STARTED
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$Z */
    enum Z {
        FRONT,
        BACK
    }

    AbstractActivityC2219g() {
        new Runnable() { // from class: com.facetec.sdk.g.11
            @Override // java.lang.Runnable
            public final void run() {
                if (C2127I.Code(AbstractActivityC2219g.this)) {
                    if (!C2221j.m2232F(AbstractActivityC2219g.this.getApplicationContext())) {
                        AbstractActivityC2219g.this.m2179B(FaceTecSessionStatus.NON_PRODUCTION_MODE_NETWORK_REQUIRED, (FaceTecIDScanStatus) null);
                    } else {
                        C2221j.m2245V();
                    }
                }
            }
        };
        this.f3329bm = new Runnable() { // from class: com.facetec.sdk.g.63
            @Override // java.lang.Runnable
            public final void run() {
                if (C2140af.m1495I() == EnumC2139ae.ZOOM_FAR) {
                    C2160az.m1802V(C2160az.V.FACE_CAPTURE_FRAME_YOUR_FACE_DELAYED);
                }
            }
        };
        this.f3331bo = 0.0f;
        this.f3327bk = false;
        this.f3328bl = false;
        this.f3330bn = new TimerTask() { // from class: com.facetec.sdk.g.32
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3265aB != null) {
                    AbstractActivityC2219g.this.f3265aB.Code(false);
                }
            }
        };
        this.f3333br = new AbstractC2228r() { // from class: com.facetec.sdk.g.37
            @Override // com.facetec.sdk.AbstractC2228r, com.facetec.sdk.C2138ad.Z
            public final void Code(EnumC2137ac enumC2137ac, EnumC2135aa enumC2135aa) {
                int i = AnonymousClass61.f3438V[enumC2137ac.ordinal()];
                if (i == 1) {
                    if (AnonymousClass61.Code[enumC2135aa.ordinal()] != 3) {
                        return;
                    }
                    AbstractActivityC2219g.this.f3265aB.Code(true);
                } else {
                    if (i == 2) {
                        AbstractActivityC2219g.this.m2192Z(true);
                        return;
                    }
                    if (i == 3 && AbstractActivityC2219g.this.f3261X && AbstractActivityC2219g.this.f3352t.getVisibility() != 0) {
                        AbstractActivityC2219g.this.f3258T = true;
                        AbstractActivityC2219g.this.f3352t.setAlpha(0.0f);
                        AbstractActivityC2219g.this.f3352t.setVisibility(0);
                        AbstractActivityC2219g.this.f3352t.animate().alpha(1.0f).setDuration(200L).setListener(null).start();
                    }
                }
            }
        };
        this.f3334bt = false;
        this.f3332bp = new C2187ca.Code() { // from class: com.facetec.sdk.g.57
            @Override // com.facetec.sdk.C2187ca.Code
            /* JADX INFO: renamed from: I */
            public final void mo1985I() {
                AbstractActivityC2219g.m2119K(AbstractActivityC2219g.this);
                AbstractActivityC2219g.this.m2148ac();
                AbstractActivityC2219g.this.m2181B(true);
            }

            @Override // com.facetec.sdk.C2187ca.Code
            public final void Code(EnumC2184bx enumC2184bx) {
                AbstractActivityC2219g.m2119K(AbstractActivityC2219g.this);
                AbstractActivityC2219g.this.m2148ac();
                EnumC2119B enumC2119B = EnumC2119B.NFC_ERROR;
                AbstractActivityC2219g.m2141Z(enumC2184bx);
                C2120C.m1362B();
                if (enumC2184bx == EnumC2184bx.ConnectionError) {
                    AbstractActivityC2219g.this.m2214u();
                } else {
                    AbstractActivityC2219g.this.m2181B(false);
                }
            }
        };
    }

    /* JADX INFO: renamed from: E */
    static /* synthetic */ boolean m2107E(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3313ax = true;
        return true;
    }

    /* JADX INFO: renamed from: K */
    static /* synthetic */ boolean m2119K(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3275aL = false;
        return false;
    }

    /* JADX INFO: renamed from: c */
    static /* synthetic */ boolean m2154c(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3327bk = false;
        return false;
    }

    /* JADX INFO: renamed from: d */
    static /* synthetic */ boolean m2155d(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3328bl = false;
        return false;
    }

    /* JADX INFO: renamed from: h */
    static /* synthetic */ boolean m2159h(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3326bj = true;
        return true;
    }

    /* JADX INFO: renamed from: t */
    static /* synthetic */ boolean m2171t(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3314ay = false;
        return false;
    }

    /* JADX INFO: renamed from: w */
    static /* synthetic */ boolean m2174w(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3307ar = false;
        return false;
    }

    /* JADX INFO: renamed from: y */
    static /* synthetic */ boolean m2176y(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.f3315az = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G */
    public synchronized boolean m2110G() {
        if (!this.f3311av) {
            if (!isFinishing()) {
                return false;
            }
        }
        return true;
    }

    @Override // android.app.Activity
    protected synchronized void onCreate(Bundle bundle) {
        int iM1648I;
        int iM1648I2;
        int identifier;
        int identifier2;
        int identifier3;
        int identifier4;
        super.onCreate(null);
        if (bundle != null) {
            setResult(0);
            finish();
            return;
        }
        C2157aw.m1785Z(this);
        C2156av.m1714aR();
        if (FaceTecSessionActivity.Code == null) {
            C2131S.m1431V("FaceTecSessionActivity must be launched with the constructor FaceTecSDK.createAndLaunchSession(...).");
            setResult(0);
            finish();
            return;
        }
        this.f3273aJ = new C2129L();
        C2138ad.m1433B();
        C2160az.m1801V(this);
        EnumC2119B enumC2119B = EnumC2119B.FULL_SESSION_START;
        C2120C.m1362B();
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        boolean z = (getApplicationInfo().flags & 2) != 0;
        boolean booleanExtra = getIntent().getBooleanExtra("ZoomSDK.disableSecureWindow", false);
        if (!z && !booleanExtra) {
            getWindow().addFlags(8192);
        }
        if (FaceTecCustomization.activityThemeId != 0) {
            setTheme(FaceTecCustomization.activityThemeId);
        }
        String stringExtra = getIntent().getStringExtra("zoom.serverSessionToken");
        this.f3243D = stringExtra;
        if (stringExtra == null) {
            this.f3243D = "";
        }
        setContentView(C2130R.layout.facetec_main_activity);
        this.f3276aM = C2130R.id.signupContainer;
        this.f3341i = findViewById(C2130R.id.zoomFrameShadowView);
        this.f3250L = (RelativeLayout) findViewById(C2130R.id.outerContainer);
        this.f3263a = (RelativeLayout) findViewById(C2130R.id.faceScanCameraContainer);
        this.f3336d = (RelativeLayout) findViewById(C2130R.id.faceScanCameraTransitionView);
        this.f3335c = (RelativeLayout) findViewById(C2130R.id.faceScanCameraLayout);
        this.f3337e = (RelativeLayout) findViewById(C2130R.id.signupContainer);
        this.f3316b = (RelativeLayout) findViewById(C2130R.id.borderCover);
        this.f3342j = (RelativeLayout) findViewById(C2130R.id.subZoomFrame);
        this.f3277aN = (LinearLayout) findViewById(C2130R.id.brandingLogoContainer);
        findViewById(C2130R.id.zoomSessionLayout);
        this.f3345m = (RelativeLayout) findViewById(C2130R.id.idScanTypeLayout);
        this.f3344l = (RelativeLayout) findViewById(C2130R.id.idScanCameraLayout);
        this.f3343k = (C2218e) findViewById(C2130R.id.idCaptureFrameView);
        this.f3347o = (TextView) findViewById(C2130R.id.idScanReviewInstructionsText);
        this.f3351s = (TextView) findViewById(C2130R.id.idScanCaptureInstructionsText);
        this.f3350r = (TextView) findViewById(C2130R.id.tapToFocusMessageText);
        this.f3349q = (ImageView) findViewById(C2130R.id.reviewImageView);
        this.f3352t = (C2162bb) findViewById(C2130R.id.takePictureButton);
        this.f3348p = (C2162bb) findViewById(C2130R.id.retakePictureButton);
        this.f3357y = (C2162bb) findViewById(C2130R.id.acceptPictureButton);
        this.f3354v = (RelativeLayout) findViewById(C2130R.id.shutterEffectContainer);
        this.f3355w = (LinearLayout) findViewById(C2130R.id.reviewButtonsContainer);
        this.f3241A = (ImageView) findViewById(C2130R.id.flashButton);
        this.f3338f = (RelativeLayout) findViewById(C2130R.id.idScanLayout);
        this.f3252N = (RelativeLayout) findViewById(C2130R.id.idScanCameraContainer);
        this.f3340h = (RelativeLayout) findViewById(C2130R.id.idScanInterfaceLayout);
        this.f3353u = (ImageView) findViewById(C2130R.id.idScanCancelButton);
        this.f3356x = (C2162bb) findViewById(C2130R.id.idScanContinueButton);
        this.f3280aQ = (TextView) findViewById(C2130R.id.idScanSelectionHeader);
        this.f3284aU = (ImageView) findViewById(C2130R.id.idScanSelectionBrandingImage);
        this.f3248J = (LinearLayout) findViewById(C2130R.id.idScanSelectionButtonLayout);
        this.f3253O = (RelativeLayout) findViewById(C2130R.id.idScanInterfaceButtonLayout);
        this.f3285aV = (RelativeLayout) findViewById(C2130R.id.idScanTypeLayoutBackground);
        this.f3251M = (RelativeLayout) findViewById(C2130R.id.idScanTypeLayoutContent);
        this.f3281aR = (LinearLayout) findViewById(C2130R.id.idScanSelectionBrandingImageLayout);
        this.f3346n = (RelativeLayout) findViewById(C2130R.id.idScanCameraTransitionView);
        this.f3283aT = (LinearLayout) findViewById(C2130R.id.idScanSelectionDocumentImageLayout);
        this.f3282aS = (ImageView) findViewById(C2130R.id.idScanSelectionDocumentImage);
        this.f3244E = (RelativeLayout) findViewById(C2130R.id.idScanInstructionsContainer);
        this.f3247H = (LinearLayout) findViewById(C2130R.id.idScanSelectionMainLayout);
        this.f3358z = (C2223m) findViewById(C2130R.id.idScanFocusAnimationView);
        try {
            try {
                FaceTecSDK.setCustomization(C2156av.m1649I(FaceTecSDK.f2235I));
                C2170bj.f2830I = FaceTecSDK.f2235I.f2215L.subtextFont;
                FaceTecCustomization faceTecCustomization = FaceTecSDK.f2235I;
                C2170bj.f2829B = FaceTecSDK.f2235I.f2215L.headerFont;
                C2221j.m2224B(this);
                C2140af.m1556t(FaceTecSDK.f2235I.f2219a);
                C2134a.m1432V();
                this.f3473Z = (RelativeLayout) findViewById(C2130R.id.backgroundCover);
                this.f3473Z.setAlpha(0.0f);
                if (FaceTecSDK.f2235I.f2212D.backgroundColor == 0) {
                    this.f3473Z.setBackgroundColor(getResources().getColor(C2130R.color.facetec_outline_shadow_dark));
                } else {
                    this.f3473Z.setBackgroundColor(FaceTecSDK.f2235I.f2212D.backgroundColor);
                }
                this.f3472V = findViewById(C2130R.id.backgroundColor);
                C2156av.Code(findViewById(C2130R.id.backgroundColor));
                this.f3471I = new Handler();
                int iM1677V = C2156av.m1677V(this);
                int iM1688Z = C2156av.m1688Z(this);
                if (FaceTecSDK.f2235I.f2211C.brandingImage != 0) {
                    iM1648I = FaceTecSDK.f2235I.f2211C.brandingImage;
                } else {
                    iM1648I = C2156av.m1648I(this, "facetec_your_app_logo", C2130R.drawable.facetec_internal_your_app_logo);
                }
                if (FaceTecSDK.f2235I.f2222d.customImage != 0) {
                    iM1648I2 = FaceTecSDK.f2235I.f2222d.customImage;
                } else {
                    iM1648I2 = C2156av.m1648I(this, "facetec_cancel", C2130R.drawable.facetec_internal_cancel);
                }
                boolean z2 = FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED && iM1648I2 == 0;
                if (FaceTecSessionActivity.Code != null && (iM1688Z == 0 || iM1648I == 0)) {
                    z2 = true;
                }
                if (iM1677V == 0) {
                    z2 = true;
                }
                if (z2) {
                    Code(FaceTecSessionStatus.MISSING_GUIDANCE_IMAGES, (FaceTecIDScanStatus) null);
                    return;
                }
                FaceTecSDK.f2235I.f2215L.retryScreenIdealImage = iM1677V;
                FaceTecSDK.f2235I.f2215L.cameraPermissionsScreenImage = iM1688Z;
                FaceTecSDK.f2235I.f2211C.brandingImage = iM1648I;
                FaceTecSDK.f2235I.f2222d.customImage = iM1648I2;
                if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM && FaceTecSDK.f2235I.f2222d.f2204I != null) {
                    ImageView imageView = (ImageView) findViewById(C2130R.id.customLocationBackButton);
                    this.f3339g = imageView;
                    imageView.setAlpha(0.0f);
                    this.f3339g.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.setMarginStart((int) C2188cb.m1993V(FaceTecSDK.f2235I.f2222d.f2204I.left));
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) C2188cb.m1993V(FaceTecSDK.f2235I.f2222d.f2204I.top);
                    ((ViewGroup.LayoutParams) layoutParams).width = (int) C2188cb.m1993V(FaceTecSDK.f2235I.f2222d.f2204I.right);
                    ((ViewGroup.LayoutParams) layoutParams).height = (int) C2188cb.m1993V(FaceTecSDK.f2235I.f2222d.f2204I.bottom);
                    this.f3339g.setLayoutParams(layoutParams);
                    if (FaceTecSDK.f2235I.f2222d.customImage != 0) {
                        this.f3339g.setImageDrawable(ContextCompat.getDrawable(this, C2156av.m1748az()));
                    }
                    this.f3339g.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.g.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AbstractActivityC2219g.this.f3339g.setAlpha(1.0f);
                            AbstractActivityC2219g.this.onBackPressed();
                            AbstractActivityC2219g.this.f3339g.setEnabled(false);
                        }
                    });
                    this.f3339g.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.g.3
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                AbstractActivityC2219g.this.f3339g.setAlpha(0.4f);
                            } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > AbstractActivityC2219g.this.f3339g.getWidth() + AbstractActivityC2219g.this.f3339g.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > AbstractActivityC2219g.this.f3339g.getHeight() + AbstractActivityC2219g.this.f3339g.getTop() + 10) {
                                AbstractActivityC2219g.this.f3339g.setAlpha(1.0f);
                            } else if (motionEvent.getAction() == 1) {
                                AbstractActivityC2219g.this.f3339g.performClick();
                            }
                            return true;
                        }
                    });
                }
                if (FaceTecSessionActivity.f2243C != null) {
                    if (FaceTecSDK.f2235I.f2214I.selectionScreenBrandingImage != 0) {
                        identifier = FaceTecSDK.f2235I.f2214I.selectionScreenBrandingImage;
                    } else if (getResources().getIdentifier("facetec_branding_logo_id_check", "drawable", getPackageName()) != 0) {
                        identifier = getResources().getIdentifier("facetec_branding_logo_id_check", "drawable", getPackageName());
                    } else {
                        identifier = getResources().getIdentifier("facetec_internal_branding_logo_id_check", "drawable", getPackageName());
                    }
                    if (FaceTecSDK.f2235I.f2214I.selectionScreenDocumentImage != 0) {
                        identifier2 = FaceTecSDK.f2235I.f2214I.selectionScreenDocumentImage;
                    } else if (getResources().getIdentifier("facetec_document", "drawable", getPackageName()) != 0) {
                        identifier2 = getResources().getIdentifier("facetec_document", "drawable", getPackageName());
                    } else {
                        identifier2 = getResources().getIdentifier("facetec_internal_document", "drawable", getPackageName());
                    }
                    if (FaceTecSDK.f2235I.f2214I.activeTorchButtonImage != 0) {
                        identifier3 = FaceTecSDK.f2235I.f2214I.activeTorchButtonImage;
                    } else if (getResources().getIdentifier("facetec_active_torch", "drawable", getPackageName()) != 0) {
                        identifier3 = getResources().getIdentifier("facetec_active_torch", "drawable", getPackageName());
                    } else {
                        identifier3 = getResources().getIdentifier("facetec_internal_active_torch", "drawable", getPackageName());
                    }
                    if (FaceTecSDK.f2235I.f2214I.inactiveTorchButtonImage != 0) {
                        identifier4 = FaceTecSDK.f2235I.f2214I.inactiveTorchButtonImage;
                    } else if (getResources().getIdentifier("facetec_inactive_torch", "drawable", getPackageName()) != 0) {
                        identifier4 = getResources().getIdentifier("facetec_inactive_torch", "drawable", getPackageName());
                    } else {
                        identifier4 = getResources().getIdentifier("facetec_internal_inactive_torch", "drawable", getPackageName());
                    }
                    if (identifier3 != 0 && identifier4 != 0) {
                        FaceTecSDK.f2235I.f2214I.selectionScreenDocumentImage = identifier2;
                        FaceTecSDK.f2235I.f2214I.selectionScreenBrandingImage = identifier;
                        FaceTecSDK.f2235I.f2214I.activeTorchButtonImage = identifier3;
                        FaceTecSDK.f2235I.f2214I.inactiveTorchButtonImage = identifier4;
                    } else {
                        Code(FaceTecSessionStatus.MISSING_GUIDANCE_IMAGES, (FaceTecIDScanStatus) null);
                        return;
                    }
                }
                FaceTecSDKStatus status = FaceTecSDK.getStatus(this);
                if (status != FaceTecSDKStatus.INITIALIZED) {
                    switch (AnonymousClass61.f3437I[status.ordinal()]) {
                        case 1:
                            EnumC2119B enumC2119B2 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.NON_PRODUCTION_MODE_KEY_INVALID;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.NON_PRODUCTION_MODE_KEY_INVALID, (FaceTecIDScanStatus) null);
                            return;
                        case 2:
                            EnumC2119B enumC2119B3 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus2 = FaceTecSessionStatus.NON_PRODUCTION_MODE_NETWORK_REQUIRED;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.NON_PRODUCTION_MODE_NETWORK_REQUIRED, (FaceTecIDScanStatus) null);
                            return;
                        case 3:
                            EnumC2119B enumC2119B4 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus3 = FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.GRACE_PERIOD_EXCEEDED, (FaceTecIDScanStatus) null);
                            return;
                        case 4:
                            EnumC2119B enumC2119B5 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus4 = FaceTecSessionStatus.LOCKED_OUT;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.LOCKED_OUT, (FaceTecIDScanStatus) null);
                            return;
                        case 5:
                            EnumC2119B enumC2119B6 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus5 = FaceTecSessionStatus.ENCRYPTION_KEY_INVALID;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.ENCRYPTION_KEY_INVALID, (FaceTecIDScanStatus) null);
                            return;
                        case 6:
                            EnumC2119B enumC2119B7 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus6 = FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED, (FaceTecIDScanStatus) null);
                            return;
                        case 7:
                            EnumC2119B enumC2119B8 = EnumC2119B.NON_FATAL_ERROR;
                            FaceTecSessionStatus faceTecSessionStatus7 = FaceTecSessionStatus.REVERSE_PORTRAIT_NOT_ALLOWED;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.REVERSE_PORTRAIT_NOT_ALLOWED, (FaceTecIDScanStatus) null);
                            return;
                        default:
                            C2131S.m1431V(new StringBuilder("Couldn't start session with status: ").append(status.name()).toString());
                            EnumC2119B enumC2119B9 = EnumC2119B.SEVERE_ERROR;
                            C2120C.m1362B();
                            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
                            return;
                    }
                }
                C2140af.m1534e(C2221j.m2230D(), C2221j.f3486Z);
                this.f3262Y = (ImageView) findViewById(C2130R.id.brandingLogoBottom);
                this.f3342j.setAlpha(0.0f);
                if (FaceTecSDK.f2235I.f2211C.brandingImage != 0 && FaceTecSDK.f2235I.f2211C.showBrandingImage) {
                    this.f3262Y.setImageDrawable(ContextCompat.getDrawable(this, FaceTecSDK.f2235I.f2211C.brandingImage));
                    this.f3262Y.setVisibility(0);
                    if ((getResources().getConfiguration().screenLayout & 15) >= 3) {
                        this.f3277aN.setWeightSum(1.0f);
                        this.f3262Y.setMaxHeight((int) C2188cb.m1993V(50));
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3262Y.getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) C2188cb.m1993V(C2156av.f2631B);
                        layoutParams2.gravity = 48;
                        this.f3262Y.setLayoutParams(layoutParams2);
                        this.f3262Y.requestLayout();
                        this.f3277aN.requestLayout();
                    }
                }
                View viewFindViewById = findViewById(C2130R.id.overlayBackgroundView);
                this.f3295af = viewFindViewById;
                viewFindViewById.setAlpha(0.0f);
                C2156av.m1629B(this.f3295af);
                if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode != FaceTecVocalGuidanceCustomization.VocalGuidanceMode.NO_VOCAL_GUIDANCE) {
                    this.f3295af.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.g.2
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 1) {
                                if (AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("PreEnroll") != null) {
                                    AbstractFragmentC2122F abstractFragmentC2122F = (AbstractFragmentC2122F) AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("PreEnroll");
                                    if (abstractFragmentC2122F.f2170Z == null || FragmentC2227q.f3541b) {
                                        return true;
                                    }
                                    if (abstractFragmentC2122F.f2170Z.isEnabled()) {
                                        C2160az.m1802V(C2160az.V.GET_READY_PRESS_BUTTON_TAPPING);
                                    } else {
                                        C2160az.m1802V(C2160az.V.FACE_CAPTURE_UNZOOMED_FRAME_YOUR_FACE_TAPPING);
                                    }
                                } else if (AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("RetryZoom") != null) {
                                    AbstractFragmentC2122F abstractFragmentC2122F2 = (AbstractFragmentC2122F) AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("RetryZoom");
                                    if (abstractFragmentC2122F2.f2170Z == null || FragmentC2151aq.f2574h) {
                                        return true;
                                    }
                                    if (abstractFragmentC2122F2.f2170Z.isEnabled()) {
                                        C2160az.m1802V(C2160az.V.GET_READY_PRESS_BUTTON_TAPPING);
                                    } else if (((FragmentC2151aq) abstractFragmentC2122F2).f2577e == 1) {
                                        C2160az.m1802V(C2160az.V.FACE_CAPTURE_UNZOOMED_FRAME_YOUR_FACE_TAPPING);
                                    }
                                } else if (AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("Zoom") != null) {
                                    if (AbstractActivityC2219g.this.f3291ab != C.ZOOM_SESSION_STARTED) {
                                        if (((FragmentC2171bk) AbstractActivityC2219g.this.getFragmentManager().findFragmentByTag("Zoom")).m1915B() == EnumC2143ai.FRAME_YOUR_FACE) {
                                            C2160az.m1802V(C2160az.V.FACE_CAPTURE_ZOOMED_PLEASE_FRAME_YOUR_FACE_TAPPING);
                                        }
                                    } else if (C2140af.m1495I() == EnumC2139ae.ZOOM_CLOSE) {
                                        if (C2140af.m1533e() == EnumC2136ab.MOVE_FACE_CLOSER) {
                                            C2160az.m1802V(C2160az.V.FACE_CAPTURE_ZOOMED_MOVE_CLOSER_TAPPING);
                                        } else if (C2140af.m1533e() != EnumC2136ab.HOLD_STEADY) {
                                            C2160az.m1802V(C2160az.V.FACE_CAPTURE_ZOOMED_PLEASE_FRAME_YOUR_FACE_TAPPING);
                                        }
                                    } else if (C2140af.m1495I() == EnumC2139ae.ZOOM_FAR && C2140af.m1533e() != EnumC2136ab.HOLD_STEADY) {
                                        C2160az.m1802V(C2160az.V.FACE_CAPTURE_UNZOOMED_FRAME_YOUR_FACE_TAPPING);
                                    }
                                }
                            }
                            return true;
                        }
                    });
                }
                this.f3470B = C2138ad.Code((Activity) this);
                C2226p.Code(this);
                AbstractC2165be.m1838B(this);
                C2156av.m1691Z();
                if (FaceTecSessionActivity.f2243C != null) {
                    m2152ag();
                }
                EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_START;
                AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.g.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2140af.m1518Z();
                        C2140af.m1558v(C2127I.m1414B());
                        C2140af.m1559w("fnkey_ZOOMSDK_LIGHTINGMODE", 1);
                    }
                });
                int iM1993V = (int) (C2188cb.m1993V(C2156av.m1639F()) * C2156av.Code());
                C2156av.m1631C();
                if (C2156av.Code() < 1.0f) {
                    float fM1841V = AbstractC2165be.m1841V(this);
                    int i = Resources.getSystem().getDisplayMetrics().widthPixels;
                    int i2 = (int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) * ((double) fM1841V));
                    float fCode = C2156av.Code();
                    float f = i;
                    this.f3245F = fCode * f;
                    this.f3257S = i2 * fCode;
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) this.f3245F, (int) this.f3257S);
                    float f2 = this.f3245F;
                    layoutParams3.setMargins(((int) (f - f2)) / 2, (iM1993V / 2) + 10, ((int) (f - f2)) / 2, 0);
                    this.f3250L.setLayoutParams(layoutParams3);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(((int) this.f3245F) + iM1993V, ((int) this.f3257S) + iM1993V);
                    float f3 = this.f3245F;
                    float f4 = iM1993V;
                    layoutParams4.setMargins(((int) (f - (f3 + f4))) / 2, 10, ((int) (f - (f3 + f4))) / 2, 0);
                    this.f3316b.setLayoutParams(layoutParams4);
                    ((RelativeLayout) this.f3341i.getParent()).setLayoutParams(layoutParams4);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) this.f3245F, (int) this.f3257S);
                    layoutParams5.setMargins(0, 0, 0, 0);
                    this.f3335c.setLayoutParams(layoutParams5);
                    this.f3252N.setLayoutParams(layoutParams5);
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams((int) this.f3245F, (int) this.f3257S);
                    layoutParams6.setMargins(0, 0, 0, 0);
                    this.f3337e.setLayoutParams(layoutParams6);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    float fM1993V = C2188cb.m1993V(C2156av.m1769l()) * fCode;
                    gradientDrawable.setCornerRadius(fM1993V);
                    int iM1647I = C2156av.m1647I(this, FaceTecSDK.f2235I.f2212D.borderColor);
                    gradientDrawable.setStroke(iM1993V, iM1647I);
                    this.f3250L.setBackground(gradientDrawable);
                    this.f3316b.setBackground(gradientDrawable);
                    this.f3250L.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                    this.f3250L.setClipToOutline(true);
                    if (FaceTecSDK.f2235I.f2212D.elevation > 0) {
                        GradientDrawable gradientDrawable2 = new GradientDrawable();
                        gradientDrawable2.setCornerRadius(fM1993V);
                        gradientDrawable2.setStroke(iM1993V, iM1647I);
                        gradientDrawable2.setColor(C2156av.m1647I(this, C2156av.m1643H()));
                        this.f3341i.setBackground(gradientDrawable2);
                        this.f3341i.setElevation(C2188cb.m1993V(FaceTecSDK.f2235I.f2212D.elevation));
                        this.f3341i.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                        this.f3341i.setClipToOutline(false);
                        this.f3341i.requestLayout();
                    }
                }
                C2156av.m1692Z(this.f3336d);
                if (m2221B() == AbstractActivityC2220h.I.GRANTED) {
                    m2126Q();
                }
                try {
                    AbstractC2165be.m1840I(this);
                } catch (C2167bg e) {
                    e.printStackTrace();
                }
                m2125P();
            } catch (C2167bg e2) {
                C2121D.Code(e2);
                e2.getMessage();
                EnumC2119B enumC2119B10 = EnumC2119B.CAMERA_ERROR;
                e2.getMessage();
                C2120C.m1362B();
                Code(FaceTecSessionStatus.CAMERA_INITIALIZATION_ISSUE, (FaceTecIDScanStatus) null);
            }
        } catch (C2181bu e3) {
            C2121D.Code(e3);
            e3.getMessage();
            EnumC2119B enumC2119B11 = EnumC2119B.SEVERE_ERROR;
            e3.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B12 = EnumC2119B.SEVERE_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity, android.view.Window.Callback
    public synchronized void onWindowFocusChanged(boolean z) {
        if (m2221B() != AbstractActivityC2220h.I.GRANTED) {
            return;
        }
        if (!z) {
            if (!m2222I() && !isFinishing()) {
                mo2188Z();
            }
        } else if (!m2110G()) {
            if (this.f3312aw) {
                m2132V(FaceTecIDScanNextStep.SELECTION_SCREEN);
                return;
            }
            if (this.f3266aC) {
                m2106E();
            } else if (this.f3267aD) {
                m2095A();
            } else if (this.f3268aE) {
                m2123N();
            }
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity
    protected synchronized void onPause() {
        super.onPause();
        if (m2221B() != AbstractActivityC2220h.I.GRANTED) {
            return;
        }
        m2213t();
        if (this.f3269aF) {
            this.f3274aK = true;
        }
        if (AbstractC2165be.Code) {
            return;
        }
        if (isFinishing()) {
            this.f3471I.postAtFrontOfQueue(new Runnable() { // from class: com.facetec.sdk.g.21
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.m2124O();
                }
            });
        } else if (!m2222I()) {
            mo2188Z();
        }
        m2121M();
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity
    protected synchronized void onStop() {
        super.onStop();
        if (m2221B() != AbstractActivityC2220h.I.GRANTED) {
            return;
        }
        m2148ac();
        this.f3323bg = true;
        if (!AbstractC2165be.Code && !this.f3312aw && !this.f3266aC && !this.f3315az) {
            m2134V(true);
            m2121M();
            AbstractC2165be abstractC2165be = this.f3265aB;
            if (abstractC2165be == null || abstractC2165be.getClass() != SurfaceHolderCallbackC2168bh.class) {
                m2124O();
            }
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity
    protected synchronized void onResume() {
        super.onResume();
        if (m2221B() != AbstractActivityC2220h.I.GRANTED) {
            return;
        }
        this.f3323bg = false;
        AbstractC2165be abstractC2165be = this.f3265aB;
        if (abstractC2165be != null && abstractC2165be.getClass() == SurfaceHolderCallbackC2168bh.class) {
            ((SurfaceHolderCallbackC2168bh) this.f3265aB).m1876I();
        }
        if (AbstractC2165be.Code && !this.f3261X && !this.f3269aF) {
            findViewById(this.f3348p.getId());
            m2218y();
        }
        if (this.f3274aK) {
            this.f3274aK = false;
            m2212s();
        }
        if (this.f3302am) {
            this.f3302am = false;
            if (this.f3289aZ) {
                m2140Y();
            } else {
                try {
                    this.f3470B = C2138ad.Code((Activity) this);
                    if (!this.f3312aw) {
                        m2126Q();
                        this.f3265aB.mo1833B();
                    }
                    if (!m2110G()) {
                        if (this.f3312aw) {
                            return;
                        }
                        if (this.f3266aC) {
                            return;
                        }
                        if (this.f3267aD) {
                            return;
                        }
                        if (this.f3268aE) {
                            return;
                        } else {
                            m2106E();
                        }
                    }
                } catch (Throwable th) {
                    C2121D.Code(th);
                    EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
                    th.getMessage();
                    C2120C.m1362B();
                    Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
                }
            }
            if (!this.f3269aF && AbstractC2165be.Code) {
                new Handler().postDelayed(new Runnable() { // from class: com.facetec.sdk.g.20
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.20.4
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (AbstractActivityC2219g.this.f3246G == null || AbstractActivityC2219g.this.f3347o == null) {
                                    return;
                                }
                                C2157aw.Code(AbstractActivityC2219g.this.f3347o, C2130R.string.FaceTec_idscan_review_id_front_instruction_message);
                            }
                        });
                    }
                }, 100L);
            }
            return;
        }
        if (!this.f3269aF) {
            new Handler().postDelayed(new Runnable() { // from class: com.facetec.sdk.g.20
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.20.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AbstractActivityC2219g.this.f3246G == null || AbstractActivityC2219g.this.f3347o == null) {
                                return;
                            }
                            C2157aw.Code(AbstractActivityC2219g.this.f3347o, C2130R.string.FaceTec_idscan_review_id_front_instruction_message);
                        }
                    });
                }
            }, 100L);
        }
        return;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E */
    public void m2106E() {
        m2121M();
        if (this.f3266aC) {
            if (C2179bs.m1943S(this)) {
                Code(FaceTecSessionStatus.LOCKED_OUT);
            }
            C2179bs.Code(this);
        }
        if (this.f3297ah == null || getFragmentManager().findFragmentByTag("RetryZoom") == null) {
            if (this.f3297ah == null) {
                this.f3297ah = FragmentC2151aq.m1603a();
            }
            if (this.f3266aC) {
                getFragmentManager().beginTransaction().add(this.f3276aM, this.f3297ah, "RetryZoom").commitAllowingStateLoss();
            } else {
                getFragmentManager().beginTransaction().replace(this.f3276aM, this.f3297ah, "RetryZoom").commitAllowingStateLoss();
            }
        } else {
            this.f3297ah.Code(this);
        }
        this.f3266aC = false;
        if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
            m2189Z(300, 0);
        }
        m2114I(1000);
    }

    /* JADX INFO: renamed from: V */
    private void m2132V(FaceTecIDScanNextStep faceTecIDScanNextStep) {
        Code(faceTecIDScanNextStep);
        this.f3312aw = false;
        if (this.f3300ak == null) {
            return;
        }
        runOnUiThread(new AnonymousClass31(this.f3300ak));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$31, reason: invalid class name */
    final class AnonymousClass31 extends AbstractRunnableC2150ap {
        AnonymousClass31(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            AbstractActivityC2219g.this.f3300ak.m1581Z(new AbstractRunnableC2150ap(AbstractActivityC2219g.this.f3300ak) { // from class: com.facetec.sdk.g.31.5
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    if (AbstractActivityC2219g.this.isFinishing()) {
                        return;
                    }
                    AbstractActivityC2219g.this.f3300ak.f2443B.animate().alpha(0.0f).setDuration(500L).setStartDelay(500L).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.31.5.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractActivityC2219g.this.m2114I(0);
                        }
                    }).start();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A */
    public void m2095A() {
        this.f3267aD = false;
        if (this.f3279aP >= 5) {
            m2179B(this.f3255Q.getStatus(), FaceTecIDScanStatus.UNSUCCESS);
            return;
        }
        m2138W();
        int i = this.f3300ak != null ? LogSeverity.EMERGENCY_VALUE : 0;
        if (this.f3300ak != null) {
            this.f3300ak.m1581Z(new AbstractRunnableC2150ap(this.f3300ak) { // from class: com.facetec.sdk.g.44
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    AbstractActivityC2219g.this.m2114I(200);
                }
            });
        }
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass51(), i);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$51, reason: invalid class name */
    final class AnonymousClass51 implements Runnable {
        AnonymousClass51() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AbstractActivityC2219g.this.f3259U == FaceTecIDScanRetryMode.BACK) {
                AbstractActivityC2219g.this.f3246G = Z.BACK;
                C2157aw.Code(AbstractActivityC2219g.this.f3351s, C2130R.string.FaceTec_idscan_capture_id_back_instruction_message);
            } else {
                AbstractActivityC2219g.this.f3246G = Z.FRONT;
                C2157aw.Code(AbstractActivityC2219g.this.f3351s, C2130R.string.FaceTec_idscan_capture_id_front_instruction_message);
            }
            AbstractActivityC2219g.this.f3346n.setAlpha(1.0f);
            AbstractActivityC2219g.this.f3338f.animate().alpha(1.0f).setDuration(500L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator()).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.51.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (AbstractActivityC2219g.this.f3265aB == null) {
                        return;
                    }
                    AbstractActivityC2219g.this.f3265aB.m1844B(new Runnable() { // from class: com.facetec.sdk.g.51.4.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AbstractActivityC2219g.this.f3346n == null) {
                                return;
                            }
                            AbstractActivityC2219g.this.f3346n.animate().alpha(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
                        }
                    });
                }
            }).start();
            if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
                AbstractActivityC2219g.this.m2189Z(500, 0);
            }
            AbstractActivityC2219g.this.f3345m.setVisibility(4);
            AbstractActivityC2219g.this.f3344l.setVisibility(0);
            AbstractActivityC2219g.this.f3340h.setVisibility(0);
            AbstractActivityC2219g.this.m2105D(false);
            if (AbstractActivityC2219g.this.f3265aB == null) {
                AbstractActivityC2219g.this.m2111H();
                return;
            }
            AbstractActivityC2219g.this.f3265aB.mo1833B();
            AbstractActivityC2219g.this.m2146aa();
            C2140af.m1547l(AbstractActivityC2219g.this.f3258T, false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facetec.sdk.g.51.2
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.f3352t.setEnabled(true, true);
                    AbstractActivityC2219g.this.f3241A.setEnabled(true);
                    AbstractActivityC2219g.this.f3353u.setEnabled(true);
                    AbstractActivityC2219g.this.f3261X = true;
                }
            }, 800L);
        }
    }

    /* JADX INFO: renamed from: z */
    private void m2177z() {
        C2121D.Code(new Throwable("FaceTec SDK has experienced an unexpected camera error."));
        EnumC2119B enumC2119B = EnumC2119B.CAMERA_ERROR;
        C2120C.m1362B();
        Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H */
    public void m2111H() {
        C2121D.Code(new Throwable("FaceTec SDK has experienced an unexpected camera error."));
        EnumC2119B enumC2119B = EnumC2119B.CAMERA_ERROR;
        C2120C.m1362B();
        Code(this.f3255Q.getStatus(), FaceTecIDScanStatus.CAMERA_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N */
    public void m2123N() {
        this.f3268aE = false;
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        this.f3299aj = FragmentC2231w.m2299V(this.f3319bc);
        fragmentTransactionBeginTransaction.setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).add(this.f3276aM, this.f3299aj, "OCRConfirmation").commitAllowingStateLoss();
        m2114I(1000);
    }

    /* JADX INFO: renamed from: K */
    private void m2118K() {
        if (FaceTecSessionActivity.f2243C == null || !this.f3289aZ) {
            return;
        }
        AbstractC2165be abstractC2165be = this.f3265aB;
        if (abstractC2165be != null) {
            abstractC2165be.mo1837Z(false);
            ImageView imageView = this.f3241A;
            if (imageView != null) {
                imageView.setImageResource(C2156av.m1741as());
            }
        }
        this.f3288aY = false;
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h, android.app.Activity
    protected synchronized void onDestroy() {
        super.onDestroy();
        m2150ae();
        m2147ab();
        C2160az.m1800I();
        FaceTecSDK.f2236Z = FaceTecSDK.EnumC2125B.NORMAL;
        if (this.f3291ab == C.PRE_SESSION_STARTED) {
            C2140af.m1535f(true);
        } else if (this.f3291ab == C.ZOOM_SESSION_STARTED) {
            C2140af.m1529b(true);
        }
        this.f3291ab = C.NOT_STARTED;
        m2118K();
        if (this.f3471I != null) {
            this.f3471I.removeCallbacksAndMessages(null);
        }
        if (this.f3325bi != null && m2130U() != this.f3331bo) {
            this.f3328bl = true;
            Code(m2130U(), this.f3331bo, 0);
            new Handler().postDelayed(new Runnable() { // from class: com.facetec.sdk.g.62
                @Override // java.lang.Runnable
                public final void run() {
                    if (AbstractActivityC2219g.this.f3325bi != null) {
                        AbstractActivityC2219g.this.f3325bi.cancel();
                        AbstractActivityC2219g.this.f3325bi.removeAllUpdateListeners();
                    }
                }
            }, 800L);
        }
        m2124O();
        m2121M();
        this.f3242C = null;
    }

    /* JADX INFO: renamed from: J */
    private boolean m2117J() {
        ImageView imageView;
        if ((this.f3300ak != null && getFragmentManager().findFragmentByTag("Results") != null && !this.f3275aL && !this.f3269aF) || (this.f3299aj != null && getFragmentManager().findFragmentByTag("OCRConfirmation") != null)) {
            return false;
        }
        if (this.f3339g != null && FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
            imageView = this.f3339g;
        } else if (this.f3297ah != null && getFragmentManager().findFragmentByTag("RetryZoom") != null) {
            imageView = this.f3297ah.f2169V;
        } else if (this.f3298ai != null && getFragmentManager().findFragmentByTag("PreEnroll") != null) {
            imageView = this.f3298ai.f2169V;
        } else if (this.f3300ak != null && getFragmentManager().findFragmentByTag("Results") != null && (this.f3275aL || this.f3269aF)) {
            imageView = this.f3300ak.f2460f;
        } else if (this.f3242C != null && getFragmentManager().findFragmentByTag("Zoom") != null) {
            imageView = this.f3242C.f2832B;
        } else {
            imageView = this.f3289aZ ? this.f3353u : null;
        }
        if (imageView != null) {
            return imageView.getVisibility() == 0 && imageView.getAlpha() > 0.0f && imageView.isEnabled();
        }
        EnumC2119B enumC2119B = EnumC2119B.DEFINITELY_BUG_IF_SEEN;
        C2120C.m1362B();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M */
    public void m2121M() {
        Handler handler = this.f3317ba;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3317ba = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O */
    public synchronized void m2124O() {
        m2150ae();
        AbstractC2165be abstractC2165be = this.f3265aB;
        if (abstractC2165be != null) {
            abstractC2165be.Code();
            this.f3265aB = null;
        }
    }

    /* JADX INFO: renamed from: g */
    final void m2200g() {
        if (FaceTecSDK.f2236Z == FaceTecSDK.EnumC2125B.LOW_LIGHT) {
            return;
        }
        FaceTecSDK.f2236Z = FaceTecSDK.EnumC2125B.LOW_LIGHT;
        C2140af.m1559w("fnkey_ZOOMSDK_LIGHTINGMODE", 0);
        C2140af.m1554r();
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.70
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.this.m2204k();
                AbstractActivityC2219g.this.m2208o();
            }
        });
    }

    /* JADX INFO: renamed from: o */
    final void m2208o() {
        if (this.f3294ae == null) {
            this.f3294ae = Integer.valueOf(C2156av.m1647I(this, FaceTecSDK.f2235I.f2211C.backgroundColor));
        }
        if (this.f3292ac == null) {
            this.f3292ac = Integer.valueOf(C2156av.m1647I(this, FaceTecSDK.f2235I.f2215L.backgroundColors));
        }
        if (this.f3293ad == null) {
            this.f3293ad = Integer.valueOf(C2156av.m1647I(this, FaceTecSDK.f2235I.f2212D.borderColor));
        }
        runOnUiThread(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$4, reason: invalid class name */
    final class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener, Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int iM1748az;
            if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM && FaceTecSDK.f2235I.f2222d.f2204I != null && (iM1748az = C2156av.m1748az()) != 0) {
                AbstractActivityC2219g.this.f3339g.setImageDrawable(ContextCompat.getDrawable(AbstractActivityC2219g.this, iM1748az));
            }
            int iM1740ar = C2156av.m1740ar();
            if (FaceTecSDK.f2235I.f2211C.showBrandingImage && iM1740ar != 0) {
                AbstractActivityC2219g.this.f3262Y.setImageDrawable(ContextCompat.getDrawable(AbstractActivityC2219g.this, iM1740ar));
            }
            AbstractActivityC2219g.this.f3336d.setBackground(C2156av.m1763h(AbstractActivityC2219g.this));
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), AbstractActivityC2219g.this.f3292ac, Integer.valueOf(C2156av.m1647I(AbstractActivityC2219g.this, C2156av.m1643H())));
            valueAnimatorOfObject.setDuration(1000L);
            valueAnimatorOfObject.addUpdateListener(this);
            valueAnimatorOfObject.start();
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), AbstractActivityC2219g.this.f3294ae, Integer.valueOf(C2156av.m1647I(AbstractActivityC2219g.this, C2156av.m1783z())));
            valueAnimatorOfObject2.setDuration(1000L);
            valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.g.4.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AbstractActivityC2219g.this.f3294ae = (Integer) valueAnimator.getAnimatedValue();
                    AbstractActivityC2219g.this.f3295af.setBackgroundColor(AbstractActivityC2219g.this.f3294ae.intValue());
                    AbstractActivityC2219g.this.f3295af.invalidate();
                }
            });
            valueAnimatorOfObject2.start();
            final GradientDrawable gradientDrawable = (GradientDrawable) AbstractActivityC2219g.this.f3250L.getBackground();
            final int iM1993V = (int) (C2188cb.m1993V(C2156av.m1639F()) * C2156av.Code());
            ValueAnimator valueAnimatorOfObject3 = ValueAnimator.ofObject(new ArgbEvaluator(), AbstractActivityC2219g.this.f3293ad, Integer.valueOf(C2156av.m1640F(AbstractActivityC2219g.this)));
            valueAnimatorOfObject3.setDuration(1000L);
            valueAnimatorOfObject3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.g.4.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AbstractActivityC2219g.this.f3293ad = (Integer) valueAnimator.getAnimatedValue();
                    gradientDrawable.setStroke(iM1993V, AbstractActivityC2219g.this.f3293ad.intValue());
                    AbstractActivityC2219g.this.f3250L.setBackground(gradientDrawable);
                    AbstractActivityC2219g.this.f3316b.setBackground(gradientDrawable);
                    AbstractActivityC2219g.this.f3341i.setBackground(gradientDrawable);
                    AbstractActivityC2219g.this.f3250L.invalidate();
                    AbstractActivityC2219g.this.f3316b.invalidate();
                    AbstractActivityC2219g.this.f3341i.invalidate();
                }
            });
            valueAnimatorOfObject3.start();
            if (AbstractActivityC2219g.this.f3298ai != null) {
                AbstractActivityC2219g.this.f3298ai.m1386D();
            }
            if (AbstractActivityC2219g.this.f3297ah != null) {
                AbstractActivityC2219g.this.f3297ah.m1386D();
            }
            if (FaceTecSessionActivity.f2243C != null) {
                AbstractActivityC2219g.this.m2152ag();
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AbstractActivityC2219g.this.f3292ac = (Integer) valueAnimator.getAnimatedValue();
            AbstractActivityC2219g.this.f3336d.setBackgroundColor(AbstractActivityC2219g.this.f3292ac.intValue());
            AbstractActivityC2219g.this.f3336d.invalidate();
        }
    }

    /* JADX INFO: renamed from: k */
    final void m2204k() {
        this.f3296ag = false;
        this.f3327bk = true;
        Code(m2130U(), 0.8f, 0);
    }

    /* JADX INFO: renamed from: l */
    final void m2205l() {
        this.f3296ag = false;
        this.f3327bk = true;
        Code(m2130U(), 0.5f, 0);
    }

    /* JADX INFO: renamed from: m */
    final void m2206m() {
        this.f3296ag = false;
        this.f3326bj = false;
        ValueAnimator valueAnimator = this.f3325bi;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3325bi.removeAllUpdateListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final float f, final float f2, int i) {
        int i2 = this.f3328bl ? 750 : ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        ValueAnimator valueAnimator = this.f3325bi;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f3325bi.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.f3325bi = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(i2);
        this.f3325bi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.g.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                WindowManager.LayoutParams attributes = AbstractActivityC2219g.this.getWindow().getAttributes();
                attributes.screenBrightness = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                AbstractActivityC2219g.this.getWindow().setAttributes(attributes);
            }
        });
        this.f3325bi.setInterpolator(new LinearInterpolator());
        this.f3325bi.setStartDelay(i);
        this.f3325bi.addListener(new AnimatorListenerAdapter() { // from class: com.facetec.sdk.g.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (AbstractActivityC2219g.this.f3327bk || AbstractActivityC2219g.this.f3328bl) {
                    AbstractActivityC2219g.m2154c(AbstractActivityC2219g.this);
                    AbstractActivityC2219g.m2155d(AbstractActivityC2219g.this);
                } else if (AbstractActivityC2219g.this.f3296ag && C2140af.m1495I() == EnumC2139ae.ZOOM_CLOSE && !AbstractActivityC2219g.this.f3326bj && f2 == 0.8f) {
                    AbstractActivityC2219g.m2159h(AbstractActivityC2219g.this);
                    AbstractActivityC2219g.this.Code(0.5f, 0.8f, 1000);
                } else if (AbstractActivityC2219g.this.f3296ag) {
                    AbstractActivityC2219g.this.Code(f2, f, 1000);
                }
            }
        });
        this.f3325bi.start();
    }

    /* JADX INFO: renamed from: U */
    private float m2130U() {
        float fM2127R;
        float f = getWindow().getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return f;
        }
        try {
            if (Settings.System.getInt(getContentResolver(), "screen_brightness_mode") == 1) {
                try {
                    fM2127R = Settings.System.getFloat(getContentResolver(), "screen_auto_brightness_adj");
                } catch (Settings.SettingNotFoundException unused) {
                    fM2127R = m2127R();
                }
            } else {
                fM2127R = m2127R();
            }
            return fM2127R;
        } catch (Settings.SettingNotFoundException unused2) {
            return 0.5f;
        }
    }

    /* JADX INFO: renamed from: R */
    private float m2127R() throws Settings.SettingNotFoundException {
        return Settings.System.getInt(getContentResolver(), "screen_brightness") / 255.0f;
    }

    /* JADX INFO: renamed from: P */
    private synchronized void m2125P() {
        AbstractActivityC2220h.I iB = m2221B();
        C2140af.m1530c();
        float fM2130U = m2130U();
        this.f3331bo = fM2130U;
        if (fM2130U > 0.70000005f) {
            this.f3327bk = true;
            Code(fM2130U, 0.6f, 0);
        }
        if (iB == AbstractActivityC2220h.I.GRANTED) {
            AbstractC2165be abstractC2165be = this.f3265aB;
            if (abstractC2165be == null) {
                m2177z();
                return;
            } else {
                abstractC2165be.m1844B(new Runnable() { // from class: com.facetec.sdk.g.10
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3336d.animate().alpha(0.0f).setDuration(300L).setListener(null).start();
                    }
                });
                this.f3265aB.mo1833B();
            }
        }
        this.f3298ai = FragmentC2227q.m2283Z(iB);
        getFragmentManager().beginTransaction().replace(this.f3276aM, this.f3298ai, "PreEnroll").commitAllowingStateLoss();
        this.f3336d.setAlpha(1.0f);
        this.f3263a.setVisibility(8);
        this.f3263a.setAlpha(0.0f);
        this.f3341i.setAlpha(0.0f);
        this.f3295af.setAlpha(0.0f);
        this.f3337e.setAlpha(0.0f);
        this.f3250L.setAlpha(0.0f);
        this.f3316b.setAlpha(0.0f);
        this.f3472V.setAlpha(0.0f);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facetec.sdk.g.6
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.m2110G()) {
                    return;
                }
                AbstractActivityC2219g.this.runOnUiThread(new AnonymousClass5());
            }

            /* JADX INFO: renamed from: com.facetec.sdk.g$6$5, reason: invalid class name */
            final class AnonymousClass5 implements Animator.AnimatorListener, Runnable {
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }

                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3472V, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3337e, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3316b, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3295af, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3342j, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3341i, "alpha", 1.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3250L, "alpha", 1.0f));
                    animatorSet.setDuration(800L);
                    animatorSet.addListener(this);
                    animatorSet.start();
                    if (AbstractActivityC2219g.this.f3339g != null) {
                        AbstractActivityC2219g.this.f3339g.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    if (AbstractActivityC2219g.this.m2221B() != AbstractActivityC2220h.I.GRANTED) {
                        return;
                    }
                    AbstractActivityC2219g.this.f3263a.setVisibility(0);
                    AbstractActivityC2219g.this.f3263a.setAlpha(1.0f);
                }
            }
        }, 400L);
    }

    /* JADX INFO: renamed from: T */
    private synchronized void m2129T() {
        if (m2110G()) {
            return;
        }
        if (this.f3265aB == null) {
            m2177z();
            return;
        }
        ImageView imageView = this.f3339g;
        if (imageView != null) {
            imageView.setEnabled(false);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facetec.sdk.g.13
                @Override // java.lang.Runnable
                public final void run() {
                    if (AbstractActivityC2219g.this.f3339g != null) {
                        AbstractActivityC2219g.this.f3339g.setEnabled(true);
                    }
                }
            }, 800L);
        }
        this.f3265aB.mo1833B();
        if (FaceTecSDK.f2236Z == FaceTecSDK.EnumC2125B.LOW_LIGHT && !this.f3296ag) {
            this.f3296ag = true;
            this.f3327bk = false;
            this.f3328bl = false;
            Code(0.8f, 1.0f, 0);
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        if (this.f3298ai != null || this.f3297ah != null) {
            fragmentTransactionBeginTransaction.replace(this.f3276aM, this.f3242C, "Zoom").commitAllowingStateLoss();
            this.f3298ai = null;
            this.f3297ah = null;
        } else {
            fragmentTransactionBeginTransaction.setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).replace(this.f3276aM, this.f3242C, "Zoom").commitAllowingStateLoss();
        }
        this.f3317ba = new Handler();
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
            this.f3317ba.postDelayed(this.f3329bm, 4500L);
        } else {
            if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.MINIMAL_VOCAL_GUIDANCE) {
                this.f3317ba.postDelayed(this.f3329bm, 15000L);
            }
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: Z */
    final synchronized void mo2188Z() {
        boolean z = this.f3289aZ;
        if (z) {
            m2118K();
            return;
        }
        if (this.f3302am) {
            return;
        }
        this.f3302am = true;
        if (this.f3311av) {
            return;
        }
        if (z) {
            EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
            FaceTecIDScanStatus faceTecIDScanStatus = FaceTecIDScanStatus.CONTEXT_SWITCH;
            C2120C.m1362B();
        } else {
            if (!m2110G()) {
                C2120C.Code code = C2120C.Code.SESSION_CONTEXT_SWITCH;
                m2116I(false);
            }
            EnumC2119B enumC2119B2 = EnumC2119B.NON_FATAL_ERROR;
            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.CONTEXT_SWITCH;
            C2120C.m1362B();
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: j */
    final void mo2203j() {
        m2179B(FaceTecSessionStatus.CAMERA_PERMISSION_DENIED, (FaceTecIDScanStatus) null);
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    final synchronized void Code() {
        C2178br.Code(this);
        C2120C.Code code = C2120C.Code.USER_WAS_SUCCESSFUL;
        this.f3301al = null;
        this.f3303an = null;
        this.f3305ap = null;
        try {
            C2179bs.m1942I(this);
            this.f3311av = true;
            this.f3307ar = true;
            if (FaceTecSessionActivity.Code != null) {
                this.f3300ak = FragmentC2145ak.m1568I(false, this.f3260W);
                if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
                    m2216w();
                }
                new Handler().postDelayed(new AbstractRunnableC2150ap(this.f3242C) { // from class: com.facetec.sdk.g.14
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        AbstractActivityC2219g.this.getFragmentManager().beginTransaction().replace(AbstractActivityC2219g.this.f3276aM, AbstractActivityC2219g.this.f3300ak, "Results").addToBackStack("zoom").commitAllowingStateLoss();
                    }
                }, 400L);
            }
            if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
                C2160az.m1802V(C2160az.V.UPLOADING);
            }
            F f = new F();
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            Void[] voidArr = new Void[0];
            if (f instanceof AsyncTask) {
                AsyncTaskInstrumentation.executeOnExecutor(f, executor, voidArr);
            } else {
                f.executeOnExecutor(executor, voidArr);
            }
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: C */
    final synchronized void mo2182C() {
        C2120C.Code code = C2120C.Code.USER_FAILED;
        this.f3301al = null;
        this.f3303an = null;
        this.f3305ap = null;
        try {
            m2116I(true);
            this.f3470B.m1471S();
            this.f3297ah = FragmentC2151aq.m1603a();
            new Handler().postDelayed(new AbstractRunnableC2150ap(this.f3242C) { // from class: com.facetec.sdk.g.15
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    AbstractActivityC2219g.this.m2106E();
                }
            }, 400L);
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: i */
    final synchronized void mo2202i() {
        m2134V(false);
        EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
        FaceTecIDScanStatus faceTecIDScanStatus = FaceTecIDScanStatus.LANDSCAPE_MODE_NOT_ALLOWED;
        C2120C.m1362B();
        if (this.f3289aZ) {
            Code(this.f3255Q.getStatus(), FaceTecIDScanStatus.LANDSCAPE_MODE_NOT_ALLOWED);
        } else {
            Code(FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED, (FaceTecIDScanStatus) null);
        }
    }

    private synchronized void Code(FaceTecSessionStatus faceTecSessionStatus) {
        Code(faceTecSessionStatus, (FaceTecIDScanStatus) null);
    }

    /* JADX INFO: renamed from: B */
    final synchronized void m2179B(FaceTecSessionStatus faceTecSessionStatus, FaceTecIDScanStatus faceTecIDScanStatus) {
        if (this.f3307ar) {
            return;
        }
        m2121M();
        if (FaceTecSessionActivity.Code != null && !this.f3315az) {
            FaceTecSessionResult faceTecSessionResult = new FaceTecSessionResult(faceTecSessionStatus, this.f3301al, this.f3303an, this.f3305ap);
            this.f3255Q = faceTecSessionResult;
            this.f3315az = true;
            if (faceTecSessionResult.getStatus() != null) {
                EnumC2119B enumC2119B = EnumC2119B.FACESCAN_CALLBACK_CALLED;
                this.f3255Q.getStatus();
                C2120C.m1362B();
            }
            FaceTecSessionActivity.Code.processSessionWhileFaceTecSDKWaits(this.f3255Q, new I(this));
        }
        if (FaceTecSessionActivity.f2243C != null && !this.f3313ax) {
            FaceTecIDScanResult faceTecIDScanResult = new FaceTecIDScanResult(faceTecIDScanStatus);
            this.f3254P = faceTecIDScanResult;
            this.f3313ax = true;
            if (faceTecIDScanResult.getStatus() != null) {
                EnumC2119B enumC2119B2 = EnumC2119B.ID_SCAN_CALLBACK_CALLED;
                this.f3254P.getStatus();
                C2120C.m1362B();
            }
            FaceTecSessionActivity.f2243C.processIDScanWhileFaceTecSDKWaits(this.f3254P, new V(this));
        }
        this.f3311av = true;
        if (!this.f3309at) {
            Intent intent = new Intent();
            try {
                m2134V(false);
                C2178br.m1934Z(faceTecSessionStatus, this);
                switch (AnonymousClass61.f3439Z[faceTecSessionStatus.ordinal()]) {
                    case 1:
                        EnumC2172bl enumC2172bl = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_SUCCESS;
                        break;
                    case 2:
                        EnumC2172bl enumC2172bl2 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_FAIL;
                        break;
                    case 3:
                        EnumC2172bl enumC2172bl3 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_FAIL;
                        break;
                    case 5:
                        EnumC2172bl enumC2172bl4 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_CANCEL;
                        break;
                    case 6:
                        EnumC2172bl enumC2172bl5 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_CANCEL;
                        break;
                    case 7:
                        EnumC2172bl enumC2172bl6 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_CANCEL;
                        break;
                    case 8:
                        EnumC2172bl enumC2172bl7 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_FAIL;
                        break;
                    case 9:
                        EnumC2172bl enumC2172bl8 = EnumC2172bl.ZOOM_EVENT_VERIFY_SESSION_FAIL;
                        break;
                }
                FaceTecSessionResult faceTecSessionResult2 = new FaceTecSessionResult(faceTecSessionStatus, this.f3301al, this.f3303an, this.f3305ap);
                faceTecSessionResult2.m1410B(C2138ad.f2350Z);
                intent.putExtra(FaceTecSDK.EXTRA_SESSION_RESULTS, faceTecSessionResult2);
                if (FaceTecSessionActivity.f2243C != null) {
                    m2124O();
                    intent.putExtra(FaceTecSDK.EXTRA_ID_SCAN_RESULTS, this.f3254P);
                }
                this.f3255Q = faceTecSessionResult2;
            } catch (Throwable th) {
                C2121D.Code(th);
            }
            FaceTecSessionActivity.Code = null;
            FaceTecSessionActivity.f2243C = null;
            setResult(-1, intent);
            finish();
            this.f3309at = true;
            try {
            } catch (Exception e) {
                C2121D.Code(e);
            }
            boolean z = AbstractC2165be.m1840I(this).booleanValue() && faceTecIDScanStatus == null;
            if (faceTecSessionStatus == FaceTecSessionStatus.SESSION_UNSUCCESSFUL) {
                int i = FaceTecSDK.f2235I.exitAnimationUnsuccessResourceID;
                if (FaceTecSDK.f2235I.exitAnimationUnsuccessResourceID == -1) {
                    i = z ? C2130R.anim.facetec_fade_out : 0;
                }
                overridePendingTransition(0, i);
                return;
            }
            if (faceTecSessionStatus == FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY) {
                int i2 = FaceTecSDK.f2235I.exitAnimationSuccessResourceID;
                if (FaceTecSDK.f2235I.exitAnimationSuccessResourceID == -1) {
                    i2 = z ? C2130R.anim.facetec_fade_out : 0;
                }
                overridePendingTransition(0, i2);
                return;
            }
            overridePendingTransition(0, 0);
        }
    }

    private void Code(int i) {
        if (isFinishing()) {
            return;
        }
        final FragmentC2151aq fragmentC2151aqM1603a = FragmentC2151aq.m1603a();
        this.f3471I.postDelayed(new Runnable() { // from class: com.facetec.sdk.g.12
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.isFinishing()) {
                    return;
                }
                AbstractActivityC2219g.this.getFragmentManager().beginTransaction().replace(AbstractActivityC2219g.this.f3276aM, fragmentC2151aqM1603a, "RetryZoom").commitAllowingStateLoss();
                AbstractActivityC2219g.this.f3297ah = fragmentC2151aqM1603a;
            }
        }, i);
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: S */
    final void mo2187S() {
        m2121M();
        if (FragmentC2171bk.f2831Z) {
            C2120C.Code code = C2120C.Code.PRE_SESSION_PHASE_2_TIMEOUT;
        } else {
            C2120C.Code code2 = C2120C.Code.PRE_SESSION_PHASE_1_TIMEOUT;
        }
        this.f3301al = null;
        this.f3303an = null;
        this.f3305ap = null;
        try {
            boolean z = C2140af.m1542i().length != 0;
            m2116I(false);
            this.f3470B.m1465D();
            new Handler(Looper.getMainLooper());
            this.f3297ah = (FragmentC2151aq) getFragmentManager().findFragmentByTag("RetryZoom");
            this.f3298ai = (FragmentC2227q) getFragmentManager().findFragmentByTag("PreEnroll");
            if (this.f3297ah != null) {
                if (this.f3297ah.m1609d() && (!this.f3297ah.m1609d() || z)) {
                    this.f3297ah.m1393V(false, 500, 0);
                    this.f3297ah.f2166I.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
                }
                this.f3297ah.Code(this);
                return;
            }
            if (this.f3298ai != null) {
                if (!z) {
                    this.f3298ai.Code(this);
                    return;
                } else {
                    this.f3298ai.m1393V(false, 500, 0);
                    this.f3298ai.f2166I.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
                }
            }
            Code(500);
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: D */
    final void mo2183D() {
        m2121M();
        C2120C.Code code = C2120C.Code.SESSION_TIMEOUT;
        this.f3301al = null;
        this.f3303an = null;
        this.f3305ap = null;
        try {
            m2116I(false);
            this.f3470B.m1471S();
            Code(400);
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
            FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: F */
    final void mo2184F() {
        this.f3308as = true;
        if (!C2221j.m2248Z() || this.f3310au) {
            return;
        }
        C2127I.m1418I(this);
        this.f3310au = true;
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: L */
    final void mo2186L() {
        EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
        FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR;
        C2120C.m1362B();
        Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: B */
    final void mo2180B(String str) {
        if (this.f3289aZ) {
            m2179B(this.f3255Q.getStatus(), FaceTecIDScanStatus.CAMERA_ERROR);
        } else {
            Code(FaceTecSessionStatus.CAMERA_INITIALIZATION_ISSUE, (FaceTecIDScanStatus) null);
        }
        if (str != null) {
            EnumC2119B enumC2119B = EnumC2119B.CAMERA_ERROR;
            C2120C.m1362B();
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: d */
    final void mo2197d() {
        this.f3242C = FragmentC2171bk.m1888I((String) null);
        this.f3308as = false;
        C2140af.m1502N();
        FragmentC2171bk.f2831Z = true;
        m2129T();
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: a */
    final synchronized void mo2194a() {
        C2120C.Code code = C2120C.Code.USER_CANCELLED;
        EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
        FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.USER_CANCELLED;
        C2120C.m1362B();
        Code(FaceTecSessionStatus.USER_CANCELLED, (FaceTecIDScanStatus) null);
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: e */
    final synchronized void mo2198e() {
        EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
        FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.USER_CANCELLED;
        C2120C.m1362B();
        if (this.f3470B == null) {
            return;
        }
        this.f3470B.m1465D();
        this.f3470B.m1467I(true);
        if (!this.f3470B.m1469I(this)) {
            int i = C2173bm.f2900L;
            mo2186L();
        }
        this.f3297ah.m1608b();
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: h */
    final synchronized void mo2201h() {
        if (this.f3289aZ) {
            m2179B(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, FaceTecIDScanStatus.SUCCESS);
        } else {
            m2179B(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, (FaceTecIDScanStatus) null);
        }
    }

    @Override // android.app.Activity
    public synchronized void onBackPressed() {
        if (m2110G()) {
            return;
        }
        if (m2117J()) {
            if (this.f3289aZ) {
                this.f3356x.setEnabled(false, true);
                this.f3357y.setEnabled(false, true);
                this.f3348p.setEnabled(false, true);
                this.f3352t.setEnabled(false, true);
                m2179B(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, FaceTecIDScanStatus.USER_CANCELED);
                return;
            }
            if (this.f3306aq != null) {
                m2179B(this.f3306aq, (FaceTecIDScanStatus) null);
                return;
            }
            if (m2222I()) {
                Code(false);
                m2179B(FaceTecSessionStatus.CAMERA_PERMISSION_DENIED, (FaceTecIDScanStatus) null);
            } else if (this.f3297ah != null && getFragmentManager().findFragmentByTag("RetryZoom") != null) {
                ((AbstractFragmentC2122F) getFragmentManager().findFragmentByTag("RetryZoom")).mo1384B();
            } else if (this.f3298ai != null && getFragmentManager().findFragmentByTag("PreEnroll") != null) {
                mo2199f();
            } else {
                mo2196c();
            }
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: c */
    final synchronized void mo2196c() {
        if (this.f3471I != null) {
            this.f3471I.removeCallbacks(null);
        }
        if (this.f3289aZ) {
            m2134V(false);
            final FaceTecIDScanStatus faceTecIDScanStatus = FaceTecIDScanStatus.USER_CANCELED;
            if (this.f3308as) {
                C2120C.Code code = C2120C.Code.USER_CANCELLED;
                AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.g.19
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g abstractActivityC2219g = AbstractActivityC2219g.this;
                        abstractActivityC2219g.Code(abstractActivityC2219g.f3255Q.getStatus(), faceTecIDScanStatus);
                    }
                });
                return;
            } else {
                Code(this.f3255Q.getStatus(), faceTecIDScanStatus);
                return;
            }
        }
        C2120C.Code code2 = C2120C.Code.USER_CANCELLED;
        m2116I(false);
        if (this.f3291ab == C.PRE_SESSION_STARTED) {
            this.f3470B.m1465D();
        } else if (this.f3291ab == C.ZOOM_SESSION_STARTED) {
            this.f3470B.m1467I(true);
        }
        try {
            Code(400);
        } catch (Throwable th) {
            C2121D.Code(th);
            EnumC2119B enumC2119B = EnumC2119B.SEVERE_ERROR;
            th.getMessage();
            C2120C.m1362B();
            Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
        }
    }

    /* JADX INFO: renamed from: n */
    final void m2207n() {
        m2134V(false);
        if (this.f3471I != null) {
            this.f3471I.removeCallbacks(null);
        }
        if (this.f3308as) {
            C2120C.Code code = C2120C.Code.USER_CANCELLED;
            AbstractAsyncTaskC2155au.m1615B(new Runnable() { // from class: com.facetec.sdk.g.17
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.Code(FaceTecSessionStatus.USER_CANCELLED_VIA_CLICKABLE_READY_SCREEN_SUBTEXT, (FaceTecIDScanStatus) null);
                }
            });
        } else {
            Code(FaceTecSessionStatus.USER_CANCELLED_VIA_CLICKABLE_READY_SCREEN_SUBTEXT, (FaceTecIDScanStatus) null);
        }
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: b */
    final void mo2195b() {
        C2140af.m1502N();
        FragmentC2171bk.f2831Z = true;
        m2129T();
    }

    @Override // com.facetec.sdk.AbstractActivityC2220h
    /* JADX INFO: renamed from: f */
    final void mo2199f() {
        C2120C.Code code = C2120C.Code.USER_CANCELLED;
        EnumC2119B enumC2119B = EnumC2119B.NON_FATAL_ERROR;
        FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.USER_CANCELLED;
        C2120C.m1362B();
        Code(FaceTecSessionStatus.USER_CANCELLED, (FaceTecIDScanStatus) null);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public synchronized void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Code(false);
        if (i == 0) {
            try {
                SharedPreferences.Editor editorEdit = C2221j.m2228C(this).edit();
                editorEdit.putBoolean("cameraPermissionsShown", true);
                editorEdit.apply();
                if (iArr.length == 1 && iArr[0] == 0) {
                    m2126Q();
                    if (this.f3265aB == null) {
                        m2177z();
                        return;
                    }
                    runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.16
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractActivityC2219g.this.f3263a.setVisibility(0);
                            AbstractActivityC2219g.this.f3263a.setAlpha(1.0f);
                        }
                    });
                    this.f3265aB.m1844B(new Runnable() { // from class: com.facetec.sdk.g.18
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractActivityC2219g.this.f3336d.animate().alpha(0.0f).setDuration(300L).setListener(null).start();
                        }
                    });
                    this.f3265aB.mo1833B();
                    this.f3298ai.m2290d();
                    return;
                }
                EnumC2119B enumC2119B = EnumC2119B.CAMERA_ERROR;
                FaceTecSessionStatus faceTecSessionStatus = FaceTecSessionStatus.CAMERA_PERMISSION_DENIED;
                C2120C.m1362B();
                Code(FaceTecSessionStatus.CAMERA_PERMISSION_DENIED, (FaceTecIDScanStatus) null);
            } catch (Exception e) {
                C2121D.Code(e);
                EnumC2119B enumC2119B2 = EnumC2119B.SEVERE_ERROR;
                e.getMessage();
                C2120C.m1362B();
                Code(FaceTecSessionStatus.UNKNOWN_INTERNAL_ERROR, (FaceTecIDScanStatus) null);
            }
        }
    }

    /* JADX INFO: renamed from: Q */
    private synchronized void m2126Q() throws C2167bg {
        this.f3242C = FragmentC2171bk.m1888I((String) null);
        if (this.f3265aB == null) {
            this.f3265aB = AbstractC2165be.m1843Z(this.f3263a, this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Code(FaceTecSessionStatus faceTecSessionStatus, FaceTecIDScanStatus faceTecIDScanStatus) {
        this.f3307ar = false;
        if (m2110G() && faceTecIDScanStatus != FaceTecIDScanStatus.SKIPPED) {
            this.f3315az = false;
        } else {
            if (this.f3289aZ) {
                m2179B(faceTecSessionStatus, faceTecIDScanStatus);
                return;
            }
            this.f3311av = true;
            this.f3307ar = false;
            m2179B(faceTecSessionStatus, faceTecIDScanStatus);
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$S */
    static class S implements Runnable {

        /* JADX INFO: renamed from: V */
        private WeakReference<AbstractActivityC2219g> f3465V;

        S(AbstractActivityC2219g abstractActivityC2219g) {
            this.f3465V = new WeakReference<>(abstractActivityC2219g);
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbstractActivityC2219g abstractActivityC2219g = this.f3465V.get();
            if (abstractActivityC2219g != null) {
                abstractActivityC2219g.m2134V(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V */
    public void m2134V(boolean z) {
        boolean z2;
        synchronized (this) {
            if (this.f3470B != null) {
                this.f3470B.m1470L();
                if (z) {
                    C2138ad.m1440I();
                    this.f3470B = null;
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
        }
        if (z2) {
            Thread thread = new Thread(new S(this));
            thread.setPriority(10);
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: B */
    public synchronized void m2097B(FaceTecIDScanNextStep faceTecIDScanNextStep) {
        if (FaceTecSessionActivity.f2243C == null) {
            m2179B(this.f3255Q.getStatus(), (FaceTecIDScanStatus) null);
            return;
        }
        if (faceTecIDScanNextStep == FaceTecIDScanNextStep.SKIP) {
            Code(this.f3255Q.getStatus(), FaceTecIDScanStatus.SKIPPED);
            return;
        }
        this.f3311av = false;
        if (this.f3470B != null && hasWindowFocus()) {
            m2132V(faceTecIDScanNextStep);
        }
    }

    /* JADX INFO: renamed from: Z */
    protected final void m2191Z(final String str) {
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.22
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3300ak != null) {
                    AbstractActivityC2219g.this.f3300ak.m1579V(str);
                }
            }
        });
    }

    protected final void Code(final float f) {
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.25
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3300ak != null) {
                    AbstractActivityC2219g.this.f3300ak.m1580Z(f);
                }
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    protected final void m2190Z(final FaceTecIDScanNextStep faceTecIDScanNextStep) {
        EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_FACESCAN_CALLBACK;
        C2120C.m1362B();
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
            C2160az.m1802V(C2160az.V.SUCCESS);
        } else if (!C2160az.Code) {
            SharedPreferences.Editor editorEdit = C2160az.f2679I.edit();
            editorEdit.putBoolean("facetecMoveCloserSoundHasBeenPlayed", true);
            editorEdit.apply();
        }
        if (FaceTecSessionActivity.f2243C != null) {
            this.f3312aw = true;
        }
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.24
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3300ak != null) {
                    AbstractActivityC2219g.this.f3300ak.m1575B(true, FaceTecCustomization.overrideResultScreenSuccessMessage, new Runnable() { // from class: com.facetec.sdk.g.24.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            AbstractActivityC2219g.this.m2097B(faceTecIDScanNextStep);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: renamed from: q */
    protected final void m2210q() {
        EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_FACESCAN_CALLBACK;
        C2120C.m1362B();
        this.f3311av = false;
        this.f3307ar = false;
        this.f3315az = false;
        if (this.f3470B != null) {
            this.f3470B.m1467I(true);
        }
        this.f3266aC = true;
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.23
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3300ak != null) {
                    AbstractActivityC2219g.this.f3300ak.m1575B(false, null, new Runnable() { // from class: com.facetec.sdk.g.23.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AbstractActivityC2219g.this.isFinishing() || !AbstractActivityC2219g.this.hasWindowFocus()) {
                                return;
                            }
                            AbstractActivityC2219g.this.m2106E();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    protected final boolean m2193Z(String str, FaceTecIDScanNextStep faceTecIDScanNextStep) {
        try {
            if (new JSONObject(C2140af.m1499K(str, false)).optBoolean(FirebaseAnalytics.Param.SUCCESS, false)) {
                m2190Z(faceTecIDScanNextStep);
                return true;
            }
            m2210q();
            return false;
        } catch (JSONException unused) {
            m2210q();
            return false;
        }
    }

    /* JADX INFO: renamed from: I */
    protected final boolean m2185I(String str) {
        boolean zOptBoolean;
        boolean zOptBoolean2;
        boolean zOptBoolean3;
        boolean zOptBoolean4;
        try {
            JSONObject jSONObject = new JSONObject(C2140af.m1499K(str, true));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                m2211r();
                return false;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("flags");
            if (jSONObjectOptJSONObject2 == null) {
                m2211r();
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject2.optInt("nextStep");
            boolean zOptBoolean5 = jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS);
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("resultsFlags");
            if (jSONObjectOptJSONObject3 != null) {
                zOptBoolean2 = jSONObjectOptJSONObject3.optBoolean("matchedHighlyEnough");
                zOptBoolean3 = jSONObjectOptJSONObject3.optBoolean("wasFullID");
                zOptBoolean4 = jSONObjectOptJSONObject3.optBoolean("idTypeNotSupported");
                zOptBoolean = jSONObjectOptJSONObject3.optBoolean("overzoomedDocument");
            } else {
                zOptBoolean = false;
                zOptBoolean2 = false;
                zOptBoolean3 = false;
                zOptBoolean4 = false;
            }
            boolean z = iOptInt <= 2;
            int i = this.f3286aW;
            boolean z2 = i == 1 || i == 2;
            this.f3286aW = iOptInt;
            C2218e c2218e = this.f3343k;
            if (c2218e != null && z) {
                if (zOptBoolean) {
                    c2218e.m2094Z();
                } else {
                    c2218e.m2093V();
                }
                m2151af();
            }
            EnumC2144aj enumC2144aj = EnumC2144aj.UNKNOWN;
            if (zOptBoolean5) {
                if (iOptInt == 1) {
                    enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE_BACK_NEXT;
                } else if (iOptInt == 3) {
                    if (this.f3269aF) {
                        if (this.f3320bd) {
                            enumC2144aj = EnumC2144aj.IDSCAN_SKIP_OR_ERROR_NFC;
                        } else {
                            enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_NFC;
                        }
                    } else if (z2) {
                        enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE;
                    } else {
                        enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE;
                    }
                } else if (iOptInt == 4) {
                    enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_USER_CONFIRMATION;
                } else if (iOptInt == 5) {
                    if (z2) {
                        enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE;
                    } else {
                        enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE;
                    }
                }
            } else if (zOptBoolean4) {
                enumC2144aj = EnumC2144aj.IDSCAN_RETRY_ID_TYPE_NOT_SUPPORTED;
            } else if (!zOptBoolean3) {
                enumC2144aj = EnumC2144aj.IDSCAN_RETRY_ID_NOT_FULLY_VISIBLE;
            } else if (!zOptBoolean2) {
                enumC2144aj = EnumC2144aj.IDSCAN_RETRY_FACE_DID_NOT_MATCH;
            } else {
                enumC2144aj = EnumC2144aj.IDSCAN_RETRY_OCR_RESULTS_NOT_GOOD_ENOUGH;
            }
            if (iOptInt == 3 && this.f3269aF) {
                if (this.f3320bd) {
                    enumC2144aj = EnumC2144aj.IDSCAN_SKIP_OR_ERROR_NFC;
                } else {
                    enumC2144aj = EnumC2144aj.IDSCAN_SUCCESS_NFC;
                }
            }
            this.f3256R = C2156av.m1689Z(enumC2144aj);
            if (iOptInt == 4) {
                EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_ID_SCAN_CALLBACK;
                C2120C.m1362B();
                this.f3279aP++;
                runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.28
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3252N.setVisibility(4);
                        if (AbstractActivityC2219g.this.f3300ak != null) {
                            AbstractActivityC2219g.this.f3300ak.m1575B(true, AbstractActivityC2219g.this.f3256R, new Runnable() { // from class: com.facetec.sdk.g.28.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AbstractActivityC2219g.this.m2179B(AbstractActivityC2219g.this.f3255Q.getStatus(), AbstractActivityC2219g.this.f3254P.getStatus());
                                }
                            });
                        }
                    }
                });
                return true;
            }
            if (iOptInt == 0) {
                this.f3246G = Z.FRONT;
                m2100B(false, FaceTecIDScanRetryMode.FRONT, this.f3256R);
            } else if (iOptInt == 1) {
                this.f3246G = Z.BACK;
                m2100B(true, FaceTecIDScanRetryMode.BACK, this.f3256R);
            } else if (iOptInt == 2) {
                this.f3246G = Z.BACK;
                m2100B(false, FaceTecIDScanRetryMode.BACK, this.f3256R);
            } else if (iOptInt == 3) {
                this.f3470B.m1466F();
                this.f3319bc = jSONObjectOptJSONObject;
                this.f3268aE = true;
                EnumC2119B enumC2119B2 = EnumC2119B.DEVELOPER_USED_ID_SCAN_CALLBACK;
                C2120C.m1362B();
                this.f3279aP++;
                runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.29
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3252N.setVisibility(4);
                        AbstractActivityC2219g.this.f3338f.setVisibility(8);
                        if (AbstractActivityC2219g.this.f3300ak != null) {
                            AbstractActivityC2219g.this.f3300ak.m1575B(true, AbstractActivityC2219g.this.f3256R, new Runnable() { // from class: com.facetec.sdk.g.29.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (AbstractActivityC2219g.this.isFinishing() || !AbstractActivityC2219g.this.hasWindowFocus()) {
                                        return;
                                    }
                                    AbstractActivityC2219g.this.m2123N();
                                }
                            });
                        }
                    }
                });
            } else if (iOptInt == 5) {
                if (jSONObjectOptJSONObject2.optBoolean("hasNFC") && !jSONObjectOptJSONObject2.optBoolean("isPassport")) {
                    this.f3278aO = true;
                }
                this.f3270aG = jSONObjectOptJSONObject.optString("mrzKey");
                m2124O();
                this.f3269aF = true;
                runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.65
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3252N.setVisibility(4);
                        AbstractActivityC2219g.this.f3263a.setVisibility(4);
                        if (AbstractActivityC2219g.this.f3300ak != null) {
                            AbstractActivityC2219g.this.f3300ak.m1575B(true, AbstractActivityC2219g.this.f3256R, new Runnable() { // from class: com.facetec.sdk.g.65.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AbstractActivityC2219g.this.m2135V(false, false);
                                }
                            });
                        }
                    }
                });
            } else {
                m2211r();
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            m2179B((FaceTecSessionStatus) null, (FaceTecIDScanStatus) null);
            return false;
        }
    }

    /* JADX INFO: renamed from: B */
    private void m2100B(final boolean z, FaceTecIDScanRetryMode faceTecIDScanRetryMode, final String str) {
        EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_ID_SCAN_CALLBACK;
        C2120C.m1362B();
        this.f3279aP++;
        this.f3267aD = true;
        this.f3313ax = false;
        this.f3258T = !z;
        this.f3259U = faceTecIDScanRetryMode;
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.26
            @Override // java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3300ak != null) {
                    AbstractActivityC2219g.this.f3300ak.m1575B(z, str, new Runnable() { // from class: com.facetec.sdk.g.26.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (AbstractActivityC2219g.this.isFinishing() || !AbstractActivityC2219g.this.hasWindowFocus() || AbstractActivityC2219g.this.f3300ak == null) {
                                return;
                            }
                            AbstractActivityC2219g.this.m2095A();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: renamed from: r */
    protected final void m2211r() {
        EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_ID_SCAN_CALLBACK;
        C2120C.m1362B();
        m2179B(this.f3255Q.getStatus(), this.f3254P.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I */
    public void m2114I(int i) {
        if (this.f3300ak == null || isFinishing()) {
            return;
        }
        if (i == 0) {
            m2139X();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(this.f3300ak) { // from class: com.facetec.sdk.g.27
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    AbstractActivityC2219g.this.m2139X();
                }
            }, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: X */
    public void m2139X() {
        if (isFinishing()) {
            return;
        }
        getFragmentManager().beginTransaction().remove(this.f3300ak).commitAllowingStateLoss();
        this.f3300ak = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Code(Activity activity) {
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$I */
    static class I implements FaceTecFaceScanResultCallback {

        /* JADX INFO: renamed from: B */
        private final WeakReference<AbstractActivityC2219g> f3462B;

        I(AbstractActivityC2219g abstractActivityC2219g) {
            this.f3462B = new WeakReference<>(abstractActivityC2219g);
        }

        private AbstractActivityC2219g Code(boolean z) {
            AbstractActivityC2219g abstractActivityC2219g = this.f3462B.get();
            if (z) {
                this.f3462B.clear();
            }
            return abstractActivityC2219g;
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void uploadMessageOverride(String str) {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(false);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                abstractActivityC2219gCode.m2191Z(str);
            }
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void uploadProgress(float f) {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(false);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                abstractActivityC2219gCode.Code(f);
            }
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void succeed() {
            succeed(FaceTecIDScanNextStep.SELECTION_SCREEN);
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void succeed(FaceTecIDScanNextStep faceTecIDScanNextStep) {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(true);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                abstractActivityC2219gCode.m2190Z(faceTecIDScanNextStep);
            }
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void retry() {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(true);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                abstractActivityC2219gCode.m2210q();
            }
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final void cancel() {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(true);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                EnumC2119B enumC2119B = EnumC2119B.DEVELOPER_USED_FACESCAN_CALLBACK;
                C2120C.m1362B();
                abstractActivityC2219gCode.m2179B(abstractActivityC2219gCode.f3255Q.getStatus(), (FaceTecIDScanStatus) null);
            }
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final boolean proceedToNextStep(String str) {
            return proceedToNextStep(str, FaceTecIDScanNextStep.SELECTION_SCREEN);
        }

        @Override // com.facetec.sdk.FaceTecFaceScanResultCallback
        public final boolean proceedToNextStep(String str, FaceTecIDScanNextStep faceTecIDScanNextStep) {
            AbstractActivityC2219g abstractActivityC2219gCode = Code(true);
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219gCode)) {
                return abstractActivityC2219gCode.m2193Z(str, faceTecIDScanNextStep);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$V */
    static class V implements FaceTecIDScanResultCallback {

        /* JADX INFO: renamed from: Z */
        private final WeakReference<AbstractActivityC2219g> f3466Z;

        V(AbstractActivityC2219g abstractActivityC2219g) {
            this.f3466Z = new WeakReference<>(abstractActivityC2219g);
        }

        @Override // com.facetec.sdk.FaceTecIDScanResultCallback
        public final boolean proceedToNextStep(String str) {
            AbstractActivityC2219g abstractActivityC2219g = this.f3466Z.get();
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219g)) {
                return abstractActivityC2219g.m2185I(str);
            }
            return false;
        }

        @Override // com.facetec.sdk.FaceTecIDScanResultCallback
        public final void uploadMessageOverride(String str) {
            AbstractActivityC2219g abstractActivityC2219g = this.f3466Z.get();
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219g)) {
                abstractActivityC2219g.m2191Z(str);
            }
        }

        @Override // com.facetec.sdk.FaceTecIDScanResultCallback
        public final void uploadProgress(float f) {
            AbstractActivityC2219g abstractActivityC2219g = this.f3466Z.get();
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219g)) {
                abstractActivityC2219g.Code(f);
            }
        }

        @Override // com.facetec.sdk.FaceTecIDScanResultCallback
        public final void cancel() {
            AbstractActivityC2219g abstractActivityC2219g = this.f3466Z.get();
            if (AbstractActivityC2219g.Code((Activity) abstractActivityC2219g)) {
                this.f3466Z.clear();
                abstractActivityC2219g.m2211r();
            }
        }
    }

    /* JADX INFO: renamed from: I */
    private void m2116I(boolean z) {
        if (this.f3314ay) {
            return;
        }
        this.f3314ay = true;
        L l = new L(z);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (l instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(l, executor, voidArr);
        } else {
            l.executeOnExecutor(executor, voidArr);
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$L */
    class L extends AbstractAsyncTaskC2155au {

        /* JADX INFO: renamed from: I */
        private final boolean f3463I;

        L(boolean z) {
            super(null);
            AbstractActivityC2219g.this.m2121M();
            this.f3463I = z;
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: B */
        final void mo1563B() {
            if (C2221j.Code()) {
                AbstractActivityC2219g.this.f3301al = C2140af.m1540h();
                AbstractActivityC2219g.this.f3303an = C2140af.m1542i();
                if (AbstractActivityC2219g.this.f3303an.length > 0) {
                    AbstractActivityC2219g.this.f3290aa = BitmapFactoryInstrumentation.decodeByteArray(AbstractActivityC2219g.this.f3303an[0], 0, AbstractActivityC2219g.this.f3303an[0].length);
                }
            }
            try {
                if (this.f3463I) {
                    new FaceTecSessionResult(FaceTecSessionStatus.SESSION_UNSUCCESSFUL, AbstractActivityC2219g.this.f3301al, AbstractActivityC2219g.this.f3303an, C2140af.m1551o());
                    C2129L unused = AbstractActivityC2219g.this.f3273aJ;
                    String str = C2221j.f3486Z;
                }
            } catch (Exception unused2) {
            }
            C2129L unused3 = AbstractActivityC2219g.this.f3273aJ;
            if (AbstractActivityC2219g.this.f3242C != null) {
                AbstractActivityC2219g.this.f3242C.m1916V();
            }
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: Z */
        protected final void mo1564Z() {
            AbstractActivityC2219g.m2171t(AbstractActivityC2219g.this);
            AbstractActivityC2219g.m2170s(AbstractActivityC2219g.this);
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$F */
    class F extends AbstractAsyncTaskC2155au {
        F() {
            super(null);
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: B */
        final void mo1563B() {
            try {
                AbstractActivityC2219g.this.f3305ap = C2140af.m1551o();
            } catch (Exception e) {
                C2188cb.m1995V(e.getMessage());
            }
            if (C2221j.Code() && AbstractActivityC2219g.this.f3308as) {
                AbstractActivityC2219g.this.f3301al = C2140af.m1540h();
                AbstractActivityC2219g.this.f3303an = C2140af.m1542i();
                if (AbstractActivityC2219g.this.f3303an.length > 0) {
                    AbstractActivityC2219g.this.f3290aa = BitmapFactoryInstrumentation.decodeByteArray(AbstractActivityC2219g.this.f3303an[0], 0, AbstractActivityC2219g.this.f3303an[0].length);
                }
            }
            C2129L unused = AbstractActivityC2219g.this.f3273aJ;
            if (AbstractActivityC2219g.this.f3242C != null) {
                AbstractActivityC2219g.this.f3242C.m1916V();
            }
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: Z */
        protected final void mo1564Z() {
            AbstractActivityC2219g.m2174w(AbstractActivityC2219g.this);
            FaceTecSessionResult faceTecSessionResult = new FaceTecSessionResult(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, AbstractActivityC2219g.this.f3301al, AbstractActivityC2219g.this.f3303an, AbstractActivityC2219g.this.f3305ap);
            faceTecSessionResult.m1410B(C2138ad.f2350Z);
            if (FaceTecSessionActivity.Code != null) {
                AbstractActivityC2219g.m2176y(AbstractActivityC2219g.this);
                AbstractActivityC2219g.this.f3255Q = faceTecSessionResult;
                if (AbstractActivityC2219g.this.f3255Q.getStatus() != null) {
                    EnumC2119B enumC2119B = EnumC2119B.FACESCAN_CALLBACK_CALLED;
                    AbstractActivityC2219g.this.f3255Q.getStatus();
                    C2120C.m1362B();
                }
                FaceTecSessionActivity.Code.processSessionWhileFaceTecSDKWaits(faceTecSessionResult, new I(AbstractActivityC2219g.this));
                return;
            }
            AbstractActivityC2219g.this.m2179B(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, (FaceTecIDScanStatus) null);
        }
    }

    /* JADX INFO: renamed from: W */
    private void m2138W() {
        m2147ab();
        Handler handler = new Handler();
        this.Code = handler;
        handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.g.30
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.m2172u(AbstractActivityC2219g.this);
            }
        }, 600000L);
    }

    /* JADX INFO: renamed from: ab */
    private void m2147ab() {
        Handler handler = this.Code;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.Code = null;
        }
    }

    /* JADX INFO: renamed from: Y */
    private void m2140Y() {
        AbstractC2165be.f2777F = this.f3252N.getWidth();
        AbstractC2165be.f2776C = this.f3252N.getHeight();
        AbstractC2165be abstractC2165be = this.f3265aB;
        final View viewMo1836Z = abstractC2165be != null ? abstractC2165be.mo1836Z() : null;
        C2156av.m1652I(this.f3336d);
        this.f3336d.animate().alpha(1.0f).setDuration(300L).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.33
            @Override // java.lang.Runnable
            public final void run() {
                View view = viewMo1836Z;
                if (view != null) {
                    view.setVisibility(4);
                }
                AbstractActivityC2219g.this.f3335c.setVisibility(4);
            }
        }).start();
        m2124O();
        try {
            this.f3265aB = AbstractC2165be.m1843Z(this.f3252N, this, true);
        } catch (C2167bg e) {
            C2121D.Code(e);
            e.getMessage();
            EnumC2119B enumC2119B = EnumC2119B.CAMERA_ERROR;
            e.getMessage();
            C2120C.m1362B();
            Code(this.f3255Q.getStatus(), FaceTecIDScanStatus.CAMERA_ERROR);
        }
        this.f3252N.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.g.34
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!AbstractActivityC2219g.this.f3264aA || motionEvent.getAction() != 0 || !AbstractActivityC2219g.this.f3343k.Code().contains(motionEvent.getX(), motionEvent.getY())) {
                    return true;
                }
                try {
                    if (AbstractActivityC2219g.this.f3265aB == null) {
                        return true;
                    }
                    AbstractActivityC2219g.this.m2146aa();
                    AbstractActivityC2219g.this.f3265aB.mo1834V(motionEvent, AbstractActivityC2219g.this.f3252N);
                    AbstractActivityC2219g.this.f3358z.m2269I(motionEvent.getX(), motionEvent.getY(), null);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: aa */
    public void m2146aa() {
        m2150ae();
        this.f3330bn = new TimerTask() { // from class: com.facetec.sdk.g.35
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (AbstractActivityC2219g.this.f3265aB != null) {
                    AbstractActivityC2219g.this.f3265aB.Code(false);
                }
            }
        };
        Timer timer = new Timer();
        this.f3318bb = timer;
        timer.scheduleAtFixedRate(this.f3330bn, 6000L, 6000L);
    }

    /* JADX INFO: renamed from: ae */
    private void m2150ae() {
        Timer timer = this.f3318bb;
        if (timer != null) {
            timer.cancel();
            this.f3318bb = null;
        }
        TimerTask timerTask = this.f3330bn;
        if (timerTask != null) {
            timerTask.cancel();
            this.f3330bn = null;
        }
    }

    /* JADX INFO: renamed from: s */
    final void m2212s() {
        m2213t();
        this.f3324bh = new TimerTask() { // from class: com.facetec.sdk.g.40
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                if (C2187ca.m1978B(AbstractActivityC2219g.this)) {
                    AbstractActivityC2219g.this.m2135V(false, true);
                    AbstractActivityC2219g.this.m2213t();
                }
            }
        };
        Timer timer = new Timer();
        this.f3322bf = timer;
        timer.scheduleAtFixedRate(this.f3324bh, 250L, 500L);
    }

    /* JADX INFO: renamed from: t */
    final void m2213t() {
        Timer timer = this.f3322bf;
        if (timer != null) {
            timer.cancel();
            this.f3322bf = null;
        }
        TimerTask timerTask = this.f3324bh;
        if (timerTask != null) {
            timerTask.cancel();
            this.f3324bh = null;
        }
    }

    private void Code(FaceTecIDScanNextStep faceTecIDScanNextStep) {
        if (this.f3470B == null) {
            return;
        }
        if (this.f3242C != null) {
            if (getFragmentManager().findFragmentByTag("Zoom") != null) {
                getFragmentManager().beginTransaction().remove(this.f3242C).commitAllowingStateLoss();
            }
            this.f3242C = null;
        }
        this.f3255Q = new FaceTecSessionResult(this.f3255Q.getStatus(), this.f3301al, this.f3303an, this.f3305ap);
        if (this.f3291ab == C.ZOOM_SESSION_STARTED) {
            this.f3470B.m1467I(true);
        }
        this.f3289aZ = true;
        this.f3249K = UUID.randomUUID().toString();
        this.f3470B.m1464B(this.f3333br);
        m2140Y();
        Handler handler = new Handler(Looper.getMainLooper());
        this.Code = handler;
        handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.g.38
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.m2172u(AbstractActivityC2219g.this);
            }
        }, 600000L);
        m2103C(faceTecIDScanNextStep == FaceTecIDScanNextStep.SELECTION_SCREEN);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$36, reason: invalid class name */
    final class AnonymousClass36 implements Runnable {

        /* JADX INFO: renamed from: B */
        private /* synthetic */ boolean f3392B;

        AnonymousClass36(boolean z) {
            this.f3392B = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            AbstractActivityC2219g.this.m2105D(false);
            AbstractActivityC2219g.this.f3353u.setAlpha(0.0f);
            AbstractActivityC2219g.this.f3344l.setVisibility(0);
            AbstractActivityC2219g.this.f3345m.setVisibility(0);
            AbstractActivityC2219g.this.f3338f.setVisibility(0);
            if (this.f3392B) {
                float fM1993V = C2188cb.m1993V(20) * C2156av.m1644I() * C2156av.Code();
                AbstractActivityC2219g.this.f3247H.setTranslationY(-fM1993V);
                AbstractActivityC2219g.this.f3248J.setTranslationY(fM1993V);
                AbstractActivityC2219g.this.f3247H.animate().alpha(1.0f).translationY(0.0f).setDuration(500L).setStartDelay(1300L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
                AbstractActivityC2219g.this.f3248J.animate().alpha(1.0f).translationY(0.0f).setDuration(500L).setStartDelay(1300L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
                i = 1300;
            } else {
                AbstractActivityC2219g.this.f3346n.setAlpha(1.0f);
                AbstractActivityC2219g.this.f3251M.setVisibility(8);
                AbstractActivityC2219g.this.f3345m.animate().alpha(0.0f).setDuration(500L).setStartDelay(800L).setInterpolator(new DecelerateInterpolator()).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.36.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (AbstractActivityC2219g.this.f3265aB == null) {
                            return;
                        }
                        AbstractActivityC2219g.this.f3265aB.m1844B(new Runnable() { // from class: com.facetec.sdk.g.36.5.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (AbstractActivityC2219g.this.f3346n == null) {
                                    return;
                                }
                                AbstractActivityC2219g.this.f3346n.animate().alpha(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
                            }
                        });
                    }
                }).start();
                AbstractActivityC2219g.this.m2151af();
                i = LogSeverity.EMERGENCY_VALUE;
            }
            if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
                AbstractActivityC2219g.this.m2189Z(500, i);
            } else if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
                AbstractActivityC2219g.this.f3353u.animate().alpha(1.0f).setDuration(500L).setStartDelay(i).setInterpolator(new DecelerateInterpolator()).setListener(null).start();
            }
            AbstractActivityC2219g.this.f3338f.animate().alpha(1.0f).setDuration(500L).setStartDelay(800L).setInterpolator(new DecelerateInterpolator()).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.36.3
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.m2109G(AbstractActivityC2219g.this);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: C */
    private void m2103C(boolean z) {
        runOnUiThread(new AnonymousClass36(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: af */
    public void m2151af() {
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.39
            @Override // java.lang.Runnable
            public final void run() {
                C2157aw.Code(AbstractActivityC2219g.this.f3351s, C2130R.string.FaceTec_idscan_capture_id_front_instruction_message);
                AbstractActivityC2219g.this.f3241A.setImageResource(C2156av.m1741as());
                AbstractActivityC2219g.this.f3340h.setVisibility(0);
                AbstractActivityC2219g.this.f3351s.setVisibility(0);
                int iM1675V = C2156av.m1675V();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AbstractActivityC2219g.this.f3244E.getLayoutParams();
                float f = iM1675V;
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) ((AbstractActivityC2219g.this.f3343k.Code().top - AbstractActivityC2219g.this.f3244E.getHeight()) - f);
                AbstractActivityC2219g.this.f3244E.setLayoutParams(layoutParams);
                RelativeLayout relativeLayout = (RelativeLayout) AbstractActivityC2219g.this.findViewById(C2130R.id.focusMessageContainer);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) (AbstractActivityC2219g.this.f3343k.Code().bottom + f);
                relativeLayout.setLayoutParams(layoutParams2);
                RelativeLayout relativeLayout2 = (RelativeLayout) AbstractActivityC2219g.this.findViewById(C2130R.id.idScanCroppedFrame);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
                ((ViewGroup.LayoutParams) layoutParams3).height = (int) (((double) relativeLayout2.getWidth()) / 1.59d);
                relativeLayout2.setLayoutParams(layoutParams3);
            }
        });
    }

    /* JADX INFO: renamed from: p */
    final void m2209p() {
        if (this.f3470B == null) {
            return;
        }
        this.f3356x.setEnabled(false, true);
        m2151af();
        m2138W();
        m2146aa();
        this.f3261X = true;
        this.f3470B.Code(C2187ca.m1980I(this));
        this.f3321be = 0;
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.41
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.this.f3345m.animate().alpha(0.0f).setDuration(300L).setListener(null).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.41.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3345m.setVisibility(8);
                    }
                }).start();
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    final void m2192Z(final boolean z) {
        m2150ae();
        m2138W();
        this.f3261X = false;
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.42
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.this.f3357y.setEnabled(false, true);
                AbstractActivityC2219g.this.f3348p.setEnabled(false, true);
                AbstractActivityC2219g.this.f3352t.setEnabled(false, true);
                AbstractActivityC2219g.this.f3352t.setVisibility(4);
                AbstractActivityC2219g.this.f3354v.setVisibility(0);
                new Handler().postDelayed(new Runnable() { // from class: com.facetec.sdk.g.42.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3354v.setVisibility(4);
                        if (z) {
                            return;
                        }
                        AbstractActivityC2219g.this.f3350r.animate().alpha(0.0f).setDuration(100L);
                    }
                }, 100L);
            }
        });
        AbstractC2165be abstractC2165be = this.f3265aB;
        if (abstractC2165be == null) {
            m2111H();
            return;
        }
        if (this.f3288aY) {
            abstractC2165be.mo1837Z(false);
        }
        if (!z) {
            this.f3265aB.mo1835V(true);
            C2140af.m1550n();
        }
        this.f3264aA = false;
        if (z) {
            m2217x();
        } else {
            m2105D(true);
            runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.43
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.f3357y.setEnabled(true, true);
                    AbstractActivityC2219g.this.f3348p.setEnabled(true, true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: D */
    public void m2105D(final boolean z) {
        this.f3264aA = !z;
        C2157aw.Code(this.f3347o, C2130R.string.FaceTec_idscan_review_id_front_instruction_message);
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.45
            @Override // java.lang.Runnable
            public final void run() {
                int i;
                int i2 = 0;
                if (z) {
                    i = 4;
                } else {
                    AbstractActivityC2219g.this.f3350r.animate().alpha(1.0f).setDuration(100L);
                    i = 0;
                    i2 = 4;
                }
                AbstractActivityC2219g.this.f3355w.setVisibility(i2);
                AbstractActivityC2219g.this.f3349q.setVisibility(i2);
                AbstractActivityC2219g.this.f3347o.setVisibility(i2);
                AbstractActivityC2219g.this.f3241A.setVisibility(i);
                if (AbstractActivityC2219g.this.f3258T) {
                    AbstractActivityC2219g.this.f3352t.setVisibility(i);
                } else {
                    AbstractActivityC2219g.this.f3352t.setVisibility(4);
                }
                AbstractActivityC2219g.this.f3351s.setVisibility(i);
            }
        });
    }

    public void onFlashButtonPressed(final View view) {
        if (this.f3265aB == null) {
            m2111H();
            return;
        }
        view.setEnabled(false);
        this.f3352t.setEnabled(false, true);
        view.postDelayed(new Runnable() { // from class: com.facetec.sdk.g.46
            @Override // java.lang.Runnable
            public final void run() {
                view.setEnabled(true);
                AbstractActivityC2219g.this.f3352t.setEnabled(true, true);
            }
        }, 1000L);
        boolean z = this.f3288aY;
        this.f3288aY = !z;
        if (!z) {
            this.f3241A.setImageResource(C2156av.m1743au());
        } else {
            this.f3241A.setImageResource(C2156av.m1741as());
        }
        this.f3265aB.mo1837Z(this.f3288aY);
    }

    /* JADX INFO: renamed from: y */
    final void m2218y() {
        if (this.f3265aB == null) {
            m2111H();
            return;
        }
        C2140af.m1547l(true, true);
        this.f3261X = true;
        m2146aa();
        this.f3265aB.mo1833B();
        if (this.f3288aY) {
            this.f3265aB.mo1837Z(true);
        }
        m2138W();
        m2105D(false);
        this.f3348p.setEnabled(false, true);
        this.f3357y.setEnabled(false, true);
        this.f3352t.setEnabled(true, true);
        this.f3352t.setVisibility(0);
        if (this.f3246G == Z.FRONT) {
            C2157aw.Code(this.f3351s, C2130R.string.FaceTec_idscan_capture_id_front_instruction_message);
        } else if (this.f3246G == Z.BACK) {
            C2157aw.Code(this.f3351s, C2130R.string.FaceTec_idscan_capture_id_back_instruction_message);
        }
    }

    /* JADX INFO: renamed from: x */
    final void m2217x() {
        if (this.f3265aB == null) {
            m2111H();
            return;
        }
        this.f3357y.setEnabled(false, true);
        this.f3348p.setEnabled(false, true);
        this.f3353u.setEnabled(false);
        this.f3288aY = false;
        this.f3241A.setImageResource(C2156av.m1741as());
        this.f3241A.setEnabled(false);
        m2147ab();
        m2149ad();
        this.f3343k.m2092I(new Runnable() { // from class: com.facetec.sdk.g.50
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.this.f3338f.animate().alpha(0.0f).setDuration(500L).setStartDelay(0L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.50.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractActivityC2219g.this.f3343k.m2091I();
                        AbstractActivityC2219g abstractActivityC2219g = AbstractActivityC2219g.this;
                        abstractActivityC2219g.f3253O.setAlpha(1.0f);
                        abstractActivityC2219g.f3244E.setAlpha(1.0f);
                        abstractActivityC2219g.f3350r.setAlpha(1.0f);
                        abstractActivityC2219g.f3241A.setAlpha(1.0f);
                        abstractActivityC2219g.f3353u.setAlpha(1.0f);
                        abstractActivityC2219g.f3253O.setTranslationY(0.0f);
                        abstractActivityC2219g.f3244E.setTranslationY(0.0f);
                        AbstractActivityC2219g.this.m2114I(0);
                        if (AbstractActivityC2219g.this.f3246G == Z.FRONT) {
                            AbstractActivityC2219g.this.f3260W = FragmentC2145ak.V.FRONT_SIDE;
                        } else {
                            AbstractActivityC2219g.this.f3260W = FragmentC2145ak.V.BACK_SIDE;
                        }
                        AbstractActivityC2219g.this.f3300ak = FragmentC2145ak.m1568I(true, AbstractActivityC2219g.this.f3260W);
                        AbstractActivityC2219g.this.getFragmentManager().beginTransaction().setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).add(AbstractActivityC2219g.this.f3276aM, AbstractActivityC2219g.this.f3300ak, "Results").commitAllowingStateLoss();
                        if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
                            AbstractActivityC2219g.this.m2216w();
                        }
                        Code code = new Code(AbstractActivityC2219g.this, null);
                        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
                        Void[] voidArr = new Void[0];
                        if (code instanceof AsyncTask) {
                            AsyncTaskInstrumentation.executeOnExecutor(code, executor, voidArr);
                        } else {
                            code.executeOnExecutor(executor, voidArr);
                        }
                    }
                });
            }
        });
    }

    final void Code(JSONObject jSONObject) {
        m2114I(0);
        FragmentC2145ak.V v = FragmentC2145ak.V.USER_CONFIRMED_INFO;
        this.f3260W = v;
        this.f3300ak = FragmentC2145ak.m1568I(true, v);
        getFragmentManager().beginTransaction().setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).add(this.f3276aM, this.f3300ak, "Results").commitAllowingStateLoss();
        Code code = new Code(this, jSONObject);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void[] voidArr = new Void[0];
        if (code instanceof AsyncTask) {
            AsyncTaskInstrumentation.executeOnExecutor(code, executor, voidArr);
        } else {
            code.executeOnExecutor(executor, voidArr);
        }
    }

    /* JADX INFO: renamed from: ad */
    private void m2149ad() {
        this.f3348p.setEnabled(false, true);
        this.f3357y.setEnabled(false, true);
        this.f3352t.setEnabled(false, true);
        runOnUiThread(new Runnable() { // from class: com.facetec.sdk.g.49
            @Override // java.lang.Runnable
            public final void run() {
                float fM1993V = C2188cb.m1993V(20) * C2156av.m1644I() * C2156av.Code();
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3253O, (Property<RelativeLayout, Float>) View.TRANSLATION_Y, fM1993V), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3244E, (Property<RelativeLayout, Float>) View.TRANSLATION_Y, -fM1993V));
                animatorSet.setDuration(500L);
                animatorSet.start();
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3253O, (Property<RelativeLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3244E, (Property<RelativeLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3350r, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3241A, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(AbstractActivityC2219g.this.f3353u, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                animatorSet2.setDuration(500L);
                animatorSet2.start();
                if (AbstractActivityC2219g.this.f3339g != null) {
                    AbstractActivityC2219g.this.f3339g.animate().alpha(0.0f).setDuration(500L).start();
                }
            }
        });
    }

    /* JADX INFO: renamed from: Z */
    final void m2189Z(int i, int i2) {
        ImageView imageView = this.f3339g;
        if (imageView != null) {
            imageView.animate().alpha(1.0f).setDuration(i).setStartDelay(i2).withEndAction(new Runnable() { // from class: com.facetec.sdk.g.47
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.f3339g.setEnabled(true);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: w */
    final void m2216w() {
        ImageView imageView = this.f3339g;
        if (imageView != null) {
            imageView.setEnabled(false);
            this.f3339g.animate().alpha(0.0f).setDuration(300L).setStartDelay(0L).start();
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$Code */
    class Code extends AbstractAsyncTaskC2155au {

        /* JADX INFO: renamed from: B */
        private boolean f3455B;

        /* JADX INFO: renamed from: F */
        private boolean f3456F;

        /* JADX INFO: renamed from: I */
        private JSONObject f3457I;

        /* JADX INFO: renamed from: V */
        private boolean f3459V;

        /* JADX INFO: renamed from: Z */
        private String f3460Z;

        Code(AbstractActivityC2219g abstractActivityC2219g, JSONObject jSONObject) {
            this(jSONObject, false, false, false);
        }

        protected Code(JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            super(null);
            this.f3460Z = UUID.randomUUID().toString();
            AbstractActivityC2219g.this.f3254P = new FaceTecIDScanResult(FaceTecIDScanStatus.SUCCESS);
            this.f3457I = jSONObject;
            this.f3455B = z;
            this.f3459V = z2;
            this.f3456F = z3;
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: B */
        final void mo1563B() {
            String string;
            byte[] bArrM1546k;
            AbstractActivityC2219g.this.f3254P.m1400B(this.f3460Z);
            byte[][] bArrM1536f = C2140af.m1536f();
            byte[][] bArrM1538g = C2140af.m1538g();
            AbstractActivityC2219g.this.f3254P.m1401B(bArrM1536f);
            AbstractActivityC2219g.this.f3254P.m1402V(bArrM1538g);
            if (this.f3455B) {
                bArrM1546k = C2140af.m1552p(this.f3460Z, AbstractActivityC2219g.this.f3249K, this.f3459V, this.f3456F);
            } else {
                JSONObject jSONObject = this.f3457I;
                if (jSONObject == null) {
                    string = "";
                } else {
                    string = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
                }
                bArrM1546k = C2140af.m1546k(this.f3460Z, AbstractActivityC2219g.this.f3249K, string);
            }
            AbstractActivityC2219g.this.f3254P.m1403Z(bArrM1546k);
        }

        @Override // com.facetec.sdk.AbstractAsyncTaskC2155au
        /* JADX INFO: renamed from: Z */
        protected final void mo1564Z() {
            AbstractActivityC2219g.m2107E(AbstractActivityC2219g.this);
            if (AbstractActivityC2219g.this.f3254P.getStatus() != null) {
                EnumC2119B enumC2119B = EnumC2119B.ID_SCAN_CALLBACK_CALLED;
                AbstractActivityC2219g.this.f3254P.getStatus();
                C2120C.m1362B();
            }
            FaceTecSessionActivity.f2243C.processIDScanWhileFaceTecSDKWaits(AbstractActivityC2219g.this.f3254P, new V(AbstractActivityC2219g.this));
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$B */
    class B extends Code {
        B(AbstractActivityC2219g abstractActivityC2219g, boolean z, boolean z2) {
            super(null, true, z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ag */
    public void m2152ag() {
        boolean z;
        int iRound;
        int iRound2;
        int iRound3;
        this.f3280aQ.setTypeface(FaceTecSDK.f2235I.f2214I.headerFont);
        this.f3347o.setTypeface(FaceTecSDK.f2235I.f2214I.subtextFont);
        this.f3351s.setTypeface(FaceTecSDK.f2235I.f2214I.subtextFont);
        this.f3350r.setTypeface(FaceTecSDK.f2235I.f2214I.captureScreenFocusMessageFont);
        this.f3280aQ.setLineSpacing(0.0f, C2156av.Code);
        C2157aw.Code(this.f3280aQ, C2130R.string.FaceTec_idscan_type_selection_header);
        C2157aw.Code(this.f3356x, C2130R.string.FaceTec_action_continue);
        float fM1644I = C2156av.m1644I() * C2156av.Code();
        int iRound4 = Math.round(C2188cb.m1993V(C2156av.f2638V) * fM1644I);
        int iM1746ax = C2156av.m1746ax();
        boolean z2 = true;
        if (FaceTecSDK.f2235I.f2214I.showSelectionScreenBrandingImage && iM1746ax != 0) {
            iRound = C2156av.m1717aU() ? Math.round((C2188cb.m1993V(C2156av.f2639Z) * fM1644I) + (C2156av.m1675V() / 2.0f)) : 0;
            this.f3284aU.setImageDrawable(ContextCompat.getDrawable(this, iM1746ax));
            this.f3284aU.setVisibility(0);
            z = true;
        } else {
            this.f3284aU.setVisibility(8);
            iRound4 = 0;
            z = false;
            iRound = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3281aR.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams).height = iRound4;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iRound;
        this.f3281aR.setLayoutParams(layoutParams);
        int iM1745aw = C2156av.m1745aw();
        if (!z && FaceTecSDK.f2235I.f2214I.showSelectionScreenDocumentImage && iM1745aw != 0) {
            iRound2 = Math.round(C2188cb.m1993V(C2156av.f2638V) * fM1644I);
            iRound3 = Math.round(C2156av.m1675V());
            this.f3282aS.setImageDrawable(ContextCompat.getDrawable(this, iM1745aw));
            this.f3282aS.setVisibility(0);
        } else {
            this.f3282aS.setVisibility(8);
            iRound2 = 0;
            iRound3 = 0;
            z2 = false;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3283aT.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams2).height = iRound2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = z2 ? iRound3 : 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = iRound3;
        this.f3283aT.setLayoutParams(layoutParams2);
        Drawable drawable = ContextCompat.getDrawable(this, C2130R.drawable.facetec_idscan_capture_instructions_background);
        C2156av.m1626B(this, this.f3351s, drawable, C2156av.m1744av());
        C2156av.m1627B(this, this.f3351s, drawable, C2156av.m1647I(this, C2156av.m1742at()), (int) (C2188cb.m1993V(C2156av.m1766j()) * C2156av.Code()), (int) (C2188cb.m1993V(C2156av.m1771n()) * C2156av.Code()));
        this.f3351s.setBackground(drawable);
        Drawable drawable2 = ContextCompat.getDrawable(this, C2130R.drawable.facetec_idscan_review_instructions_background);
        C2156av.m1626B(this, this.f3347o, drawable2, C2156av.m1739aq());
        C2156av.m1627B(this, this.f3347o, drawable2, C2156av.m1647I(this, C2156av.m1737ao()), (int) (C2188cb.m1993V(C2156av.m1760g()) * C2156av.Code()), (int) (C2188cb.m1993V(C2156av.m1768k()) * C2156av.Code()));
        this.f3347o.setBackground(drawable2);
        C2156av.m1630B(this.f3280aQ);
        C2156av.m1672S(this.f3351s);
        C2156av.m1683V(this.f3347o);
        C2156av.m1637D(this.f3350r);
        C2157aw.Code(this.f3350r, C2130R.string.FaceTec_idscan_capture_tap_to_focus_message);
        C2156av.m1671S(this.f3285aV);
        this.f3346n.setBackgroundColor(C2156av.m1646I(this));
        this.f3352t.setupButtonForIdentityCheck();
        this.f3348p.setupButtonForIdentityCheck();
        this.f3357y.setupButtonForIdentityCheck();
        this.f3356x.setupButtonForIdentityCheck();
        C2157aw.Code(this.f3352t, C2130R.string.FaceTec_action_take_photo);
        C2157aw.Code(this.f3348p, C2130R.string.FaceTec_action_retake_photo);
        C2157aw.Code(this.f3357y, C2130R.string.FaceTec_action_accept_photo);
        if (C2156av.m1717aU()) {
            this.f3353u.setImageDrawable(ContextCompat.getDrawable(this, C2156av.m1748az()));
            this.f3353u.setOnClickListener(new View.OnClickListener() { // from class: com.facetec.sdk.g.48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbstractActivityC2219g.this.f3353u.setAlpha(1.0f);
                    AbstractActivityC2219g.this.f3353u.setEnabled(false);
                    AbstractActivityC2219g.this.f3357y.setEnabled(false, true);
                    AbstractActivityC2219g.this.f3348p.setEnabled(false, true);
                    AbstractActivityC2219g.this.f3352t.setEnabled(false, true);
                    AbstractActivityC2219g.this.m2179B(FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY, FaceTecIDScanStatus.USER_CANCELED);
                }
            });
            this.f3353u.setOnTouchListener(new View.OnTouchListener() { // from class: com.facetec.sdk.g.55
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        AbstractActivityC2219g.this.f3353u.setAlpha(0.4f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getX() < 0.0f || motionEvent.getX() > AbstractActivityC2219g.this.f3353u.getWidth() + AbstractActivityC2219g.this.f3353u.getLeft() + 10 || motionEvent.getY() < 0.0f || motionEvent.getY() > AbstractActivityC2219g.this.f3353u.getHeight() + AbstractActivityC2219g.this.f3353u.getTop() + 10) {
                        AbstractActivityC2219g.this.f3353u.setAlpha(1.0f);
                    } else if (motionEvent.getAction() == 1) {
                        AbstractActivityC2219g.this.f3353u.performClick();
                    }
                    return true;
                }
            });
        }
        int i = AnonymousClass61.f3434B[FaceTecSDK.f2235I.f2222d.f2205Z.ordinal()];
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3353u.getLayoutParams();
            layoutParams3.removeRule(20);
            layoutParams3.addRule(21);
            this.f3353u.setLayoutParams(layoutParams3);
        } else if (i == 3 || i == 4) {
            this.f3353u.setVisibility(8);
        }
        this.f3353u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.facetec.sdk.g.52
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AbstractActivityC2219g.m2096A(AbstractActivityC2219g.this);
            }
        });
    }

    private static void Code(C2162bb c2162bb, final Runnable runnable) {
        c2162bb.setOnClickListenerRunnable(new Runnable() { // from class: com.facetec.sdk.g.59
            @Override // java.lang.Runnable
            public final void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V */
    public void m2135V(boolean z, boolean z2) {
        if (this.f3334bt || this.f3275aL) {
            return;
        }
        if (this.f3272aI == null) {
            this.f3272aI = new C2232x(this.f3300ak, this.f3278aO);
        }
        if (this.f3271aH == null) {
            this.f3271aH = C2187ca.m1982Z(this);
        }
        C2187ca c2187ca = this.f3271aH;
        if (c2187ca == null) {
            m2181B(false);
            return;
        }
        if (this.f3323bg) {
            return;
        }
        try {
            if (!c2187ca.Code(getClass(), this.f3270aG) || z) {
                return;
            }
            C2232x c2232x = this.f3272aI;
            if (c2232x.f3606Z.getActivity() != null) {
                c2232x.f3606Z.getActivity().runOnUiThread(c2232x.new AnonymousClass1(c2232x.f3606Z, z2));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ac */
    public void m2148ac() {
        C2187ca c2187ca = this.f3271aH;
        if (c2187ca != null) {
            if (!this.f3323bg) {
                try {
                    c2187ca.m1983V();
                } catch (Exception unused) {
                }
            }
            this.f3271aH = null;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C2187ca c2187ca = this.f3271aH;
        if (c2187ca != null) {
            this.f3275aL = true;
            if (c2187ca.m1984V(intent, this.f3332bp)) {
                C2232x c2232x = this.f3272aI;
                if (c2232x.f3606Z.getActivity() != null) {
                    c2232x.f3606Z.getActivity().runOnUiThread(c2232x.new AnonymousClass2(c2232x.f3606Z));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$61, reason: invalid class name */
    static /* synthetic */ class AnonymousClass61 {

        /* JADX INFO: renamed from: B */
        static final /* synthetic */ int[] f3434B;

        /* JADX INFO: renamed from: C */
        private static /* synthetic */ int[] f3435C;
        static final /* synthetic */ int[] Code;

        /* JADX INFO: renamed from: F */
        static final /* synthetic */ int[] f3436F;

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f3437I;

        /* JADX INFO: renamed from: V */
        static final /* synthetic */ int[] f3438V;

        /* JADX INFO: renamed from: Z */
        static final /* synthetic */ int[] f3439Z;

        static {
            int[] iArr = new int[EnumC2184bx.values().length];
            f3436F = iArr;
            try {
                iArr[EnumC2184bx.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3436F[EnumC2184bx.InvalidMrzKey.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3436F[EnumC2184bx.ResponseError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3436F[EnumC2184bx.ConnectionError.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[FaceTecCancelButtonCustomization.ButtonLocation.values().length];
            f3434B = iArr2;
            try {
                iArr2[FaceTecCancelButtonCustomization.ButtonLocation.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3434B[FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3434B[FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3434B[FaceTecCancelButtonCustomization.ButtonLocation.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[EnumC2137ac.values().length];
            f3438V = iArr3;
            try {
                iArr3[EnumC2137ac.KEEP_SCANNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3438V[EnumC2137ac.END_SCAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3438V[EnumC2137ac.PRESENT_USER_HELP_BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[EnumC2135aa.values().length];
            Code = iArr4;
            try {
                iArr4[EnumC2135aa.ID_IMAGE_HOLD_STEADY.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                Code[EnumC2135aa.ID_IMAGE_FACE_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                Code[EnumC2135aa.ID_IMAGE_BLURRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr5 = new int[FaceTecSessionStatus.values().length];
            f3439Z = iArr5;
            try {
                iArr5[FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3439Z[FaceTecSessionStatus.TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3439Z[FaceTecSessionStatus.CONTEXT_SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3439Z[FaceTecSessionStatus.NON_PRODUCTION_MODE_KEY_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f3439Z[FaceTecSessionStatus.USER_CANCELLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f3439Z[FaceTecSessionStatus.SESSION_UNSUCCESSFUL.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f3439Z[FaceTecSessionStatus.CAMERA_PERMISSION_DENIED.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f3439Z[FaceTecSessionStatus.LANDSCAPE_MODE_NOT_ALLOWED.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f3439Z[FaceTecSessionStatus.REVERSE_PORTRAIT_NOT_ALLOWED.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr6 = new int[FaceTecExitAnimationStyle.values().length];
            f3435C = iArr6;
            try {
                iArr6[FaceTecExitAnimationStyle.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f3435C[FaceTecExitAnimationStyle.RIPPLE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f3435C[FaceTecExitAnimationStyle.RIPPLE_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f3435C[FaceTecExitAnimationStyle.CIRCLE_FADE.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr7 = new int[FaceTecSDKStatus.values().length];
            f3437I = iArr7;
            try {
                iArr7[FaceTecSDKStatus.INVALID_DEVICE_KEY_IDENTIFIER.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f3437I[FaceTecSDKStatus.NETWORK_ISSUES.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f3437I[FaceTecSDKStatus.GRACE_PERIOD_EXCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f3437I[FaceTecSDKStatus.DEVICE_LOCKED_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f3437I[FaceTecSDKStatus.ENCRYPTION_KEY_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f3437I[FaceTecSDKStatus.DEVICE_IN_LANDSCAPE_MODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f3437I[FaceTecSDKStatus.DEVICE_IN_REVERSE_PORTRAIT_MODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused34) {
            }
        }
    }

    /* JADX INFO: renamed from: v */
    final void m2215v() {
        this.f3272aI.m2313Z();
        this.f3334bt = true;
        this.f3320bd = true;
        new Handler().postDelayed(new AnonymousClass56(this.f3300ak, C2156av.m1679V(EnumC2233y.SKIPPED, this.f3278aO)), 800L);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$56, reason: invalid class name */
    final class AnonymousClass56 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: I */
        private /* synthetic */ String f3426I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass56(Fragment fragment, String str) {
            super(fragment);
            this.f3426I = str;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            AbstractActivityC2219g.this.f3300ak.m1576I(false, true, this.f3426I, new Runnable() { // from class: com.facetec.sdk.g.56.1
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.f3300ak.f2444C.animate().alpha(0.0f).setDuration(800L).setStartDelay(0L).setListener(null).withEndAction(new AbstractRunnableC2150ap(AbstractActivityC2219g.this.f3300ak) { // from class: com.facetec.sdk.g.56.1.1
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        final void Code() {
                            AbstractActivityC2219g.this.getFragmentManager().beginTransaction().remove(AbstractActivityC2219g.this.f3300ak).commitAllowingStateLoss();
                            AbstractActivityC2219g.this.f3300ak = null;
                            AbstractActivityC2219g.this.f3260W = FragmentC2145ak.V.NFC;
                            AbstractActivityC2219g.this.f3300ak = FragmentC2145ak.m1568I(true, AbstractActivityC2219g.this.f3260W);
                            AbstractActivityC2219g.this.getFragmentManager().beginTransaction().add(AbstractActivityC2219g.this.f3276aM, AbstractActivityC2219g.this.f3300ak, "Results").commitAllowingStateLoss();
                            B b = new B(AbstractActivityC2219g.this, false, true);
                            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
                            Void[] voidArr = new Void[0];
                            if (b instanceof AsyncTask) {
                                AsyncTaskInstrumentation.executeOnExecutor(b, executor, voidArr);
                            } else {
                                b.executeOnExecutor(executor, voidArr);
                            }
                        }
                    }).start();
                }
            });
        }
    }

    /* JADX INFO: renamed from: B */
    final void m2181B(boolean z) {
        String strM1679V;
        this.f3272aI.m2313Z();
        this.f3334bt = true;
        if (z) {
            strM1679V = C2156av.m1679V(EnumC2233y.FINISHED_WITH_SUCCESS, this.f3278aO);
        } else {
            strM1679V = C2156av.m1679V(EnumC2233y.FINISHED_WITH_ERROR, this.f3278aO);
        }
        new Handler().postDelayed(new AnonymousClass64(this.f3300ak, z, strM1679V), 800L);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.g$64, reason: invalid class name */
    final class AnonymousClass64 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: V */
        final /* synthetic */ boolean f3442V;

        /* JADX INFO: renamed from: Z */
        private /* synthetic */ String f3443Z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass64(Fragment fragment, boolean z, String str) {
            super(fragment);
            this.f3442V = z;
            this.f3443Z = str;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2145ak fragmentC2145ak = AbstractActivityC2219g.this.f3300ak;
            boolean z = this.f3442V;
            fragmentC2145ak.m1576I(z, z, this.f3443Z, new Runnable() { // from class: com.facetec.sdk.g.64.2
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2219g.this.f3300ak.f2444C.animate().alpha(0.0f).setDuration(800L).setStartDelay(0L).setListener(null).withEndAction(new AbstractRunnableC2150ap(AbstractActivityC2219g.this.f3300ak) { // from class: com.facetec.sdk.g.64.2.1
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        final void Code() {
                            AbstractActivityC2219g.this.getFragmentManager().beginTransaction().remove(AbstractActivityC2219g.this.f3300ak).commitAllowingStateLoss();
                            AbstractActivityC2219g.this.f3300ak = null;
                            AbstractActivityC2219g.this.f3260W = FragmentC2145ak.V.NFC;
                            AbstractActivityC2219g.this.f3300ak = FragmentC2145ak.m1568I(true, AbstractActivityC2219g.this.f3260W);
                            AbstractActivityC2219g.this.getFragmentManager().beginTransaction().add(AbstractActivityC2219g.this.f3276aM, AbstractActivityC2219g.this.f3300ak, "Results").commitAllowingStateLoss();
                            B b = new B(AbstractActivityC2219g.this, AnonymousClass64.this.f3442V, false);
                            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
                            Void[] voidArr = new Void[0];
                            if (b instanceof AsyncTask) {
                                AsyncTaskInstrumentation.executeOnExecutor(b, executor, voidArr);
                            } else {
                                b.executeOnExecutor(executor, voidArr);
                            }
                        }
                    }).start();
                }
            });
        }
    }

    /* JADX INFO: renamed from: u */
    final void m2214u() {
        this.f3321be++;
        if (this.f3300ak != null && this.f3321be > 5) {
            m2181B(false);
            return;
        }
        m2135V(true, false);
        C2232x c2232x = this.f3272aI;
        if (c2232x.f3606Z.getActivity() != null) {
            c2232x.f3606Z.getActivity().runOnUiThread(c2232x.new AnonymousClass5(c2232x.f3606Z));
        }
    }

    /* JADX INFO: renamed from: s */
    static /* synthetic */ void m2170s(AbstractActivityC2219g abstractActivityC2219g) {
        FaceTecSessionActivity faceTecSessionActivity;
        abstractActivityC2219g.f3297ah = (FragmentC2151aq) abstractActivityC2219g.getFragmentManager().findFragmentByTag("RetryZoom");
        if (abstractActivityC2219g.f3297ah == null || abstractActivityC2219g.f3297ah.f2575b == null) {
            return;
        }
        FragmentC2153as fragmentC2153as = abstractActivityC2219g.f3297ah.f2575b;
        if (fragmentC2153as.f2613b != null || (faceTecSessionActivity = (FaceTecSessionActivity) fragmentC2153as.getActivity()) == null) {
            return;
        }
        fragmentC2153as.f2613b = faceTecSessionActivity.f3290aa;
        fragmentC2153as.f2603B.setAlpha(0.0f);
        fragmentC2153as.m1614B();
        fragmentC2153as.f2603B.animate().alpha(1.0f).setDuration(400L).setListener(null);
    }

    /* JADX INFO: renamed from: u */
    static /* synthetic */ void m2172u(AbstractActivityC2219g abstractActivityC2219g) {
        abstractActivityC2219g.m2179B(abstractActivityC2219g.f3255Q.getStatus(), FaceTecIDScanStatus.TIMED_OUT);
    }

    /* JADX INFO: renamed from: G */
    static /* synthetic */ void m2109G(AbstractActivityC2219g abstractActivityC2219g) {
        Code(abstractActivityC2219g.f3352t, new Runnable() { // from class: com.facetec.sdk.g.54
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g.this.m2192Z(false);
            }
        });
        Code(abstractActivityC2219g.f3348p, new Runnable() { // from class: com.facetec.sdk.g.53
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g abstractActivityC2219g2 = AbstractActivityC2219g.this;
                abstractActivityC2219g2.findViewById(abstractActivityC2219g2.f3348p.getId());
                abstractActivityC2219g2.m2218y();
            }
        });
        Code(abstractActivityC2219g.f3357y, new Runnable() { // from class: com.facetec.sdk.g.58
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g abstractActivityC2219g2 = AbstractActivityC2219g.this;
                abstractActivityC2219g2.findViewById(abstractActivityC2219g2.f3357y.getId());
                abstractActivityC2219g2.m2217x();
            }
        });
        Code(abstractActivityC2219g.f3356x, new Runnable() { // from class: com.facetec.sdk.g.60
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2219g abstractActivityC2219g2 = AbstractActivityC2219g.this;
                abstractActivityC2219g2.findViewById(abstractActivityC2219g2.f3356x.getId());
                abstractActivityC2219g2.m2209p();
            }
        });
    }

    /* JADX INFO: renamed from: A */
    static /* synthetic */ void m2096A(AbstractActivityC2219g abstractActivityC2219g) {
        if (abstractActivityC2219g.f3287aX) {
            return;
        }
        abstractActivityC2219g.f3287aX = true;
        float fM1644I = C2156av.m1644I();
        float fCode = C2156av.Code();
        int iM1993V = (int) (C2188cb.m1993V(C2156av.f2639Z) * fM1644I * fCode);
        int iM1993V2 = (int) (C2188cb.m1993V(C2156av.f2635I) * fM1644I * fCode);
        int iM1675V = C2156av.m1675V();
        float f = iM1675V;
        float f2 = f / 2.0f;
        int iRound = Math.round(f2);
        int iRound2 = Math.round(f2);
        int i = (int) (C2156av.f2646g * fM1644I * fCode);
        int iM1619B = C2156av.m1619B();
        int i2 = (int) (C2156av.f2645f * fM1644I * fCode);
        int i3 = (int) (C2156av.f2648i * fM1644I * fCode);
        int iRound3 = Math.round(f2);
        int iRound4 = Math.round((C2188cb.m1993V(C2156av.m1769l()) * fCode) / 2.0f);
        abstractActivityC2219g.f3344l.setPadding(iRound4, iRound4, iRound4, iRound4);
        abstractActivityC2219g.f3349q.setPadding(iRound4, iRound4, iRound4, iRound4);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractActivityC2219g.f3248J.getLayoutParams();
        layoutParams.setMargins(iM1675V, 0, iM1675V, iM1675V);
        abstractActivityC2219g.f3248J.setLayoutParams(layoutParams);
        abstractActivityC2219g.f3248J.requestLayout();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) abstractActivityC2219g.f3253O.getLayoutParams();
        layoutParams2.setMargins(iM1675V, 0, iM1675V, iM1675V);
        ((ViewGroup.LayoutParams) layoutParams2).height = iM1993V2;
        abstractActivityC2219g.f3253O.setLayoutParams(layoutParams2);
        abstractActivityC2219g.f3253O.requestLayout();
        abstractActivityC2219g.f3356x.setLayoutParams(new LinearLayout.LayoutParams(-1, iM1993V2));
        abstractActivityC2219g.f3356x.requestLayout();
        new LinearLayout.LayoutParams(-1, iM1993V2).setMargins(0, 0, 0, iM1675V);
        float fCode2 = (Resources.getSystem().getDisplayMetrics().widthPixels * C2156av.Code()) - (iM1675V << 1);
        int i4 = (int) fCode2;
        abstractActivityC2219g.f3248J.getLayoutParams().width = i4;
        abstractActivityC2219g.f3248J.requestLayout();
        abstractActivityC2219g.f3352t.getLayoutParams().width = i4;
        abstractActivityC2219g.f3352t.requestLayout();
        float fMin = Math.min(Math.max(iM1993V2, fCode2 / 2.0f), (fCode2 - f) / 2.0f);
        abstractActivityC2219g.findViewById(C2130R.id.reviewButtonSeparator).getLayoutParams().width = (int) ((abstractActivityC2219g.f3338f.getWidth() - (fMin * 2.0f)) / 3.0f);
        int i5 = (int) fMin;
        abstractActivityC2219g.f3357y.getLayoutParams().width = i5;
        abstractActivityC2219g.f3348p.getLayoutParams().width = i5;
        ((LinearLayout.LayoutParams) abstractActivityC2219g.f3357y.getLayoutParams()).weight = 0.0f;
        ((LinearLayout.LayoutParams) abstractActivityC2219g.f3348p.getLayoutParams()).weight = 0.0f;
        abstractActivityC2219g.f3357y.requestLayout();
        abstractActivityC2219g.f3348p.requestLayout();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) abstractActivityC2219g.f3353u.getLayoutParams();
        layoutParams3.setMargins(iRound, iRound, 0, iRound);
        layoutParams3.setMarginStart(iRound);
        layoutParams3.setMarginEnd(iRound);
        abstractActivityC2219g.f3353u.setLayoutParams(layoutParams3);
        abstractActivityC2219g.f3353u.setPadding(iRound, iRound, iRound, iRound);
        abstractActivityC2219g.f3353u.getLayoutParams().height = iM1993V;
        abstractActivityC2219g.f3353u.getLayoutParams().width = iM1993V;
        abstractActivityC2219g.f3353u.requestLayout();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) abstractActivityC2219g.f3241A.getLayoutParams();
        ((ViewGroup.LayoutParams) layoutParams4).width = -2;
        ((ViewGroup.LayoutParams) layoutParams4).height = -2;
        layoutParams4.setMargins(0, iRound, iRound, iRound);
        layoutParams4.setMarginStart(iRound);
        layoutParams4.setMarginEnd(iRound);
        abstractActivityC2219g.f3241A.setLayoutParams(layoutParams4);
        abstractActivityC2219g.f3241A.setPadding(iRound2, iRound2, iRound2, iRound2);
        abstractActivityC2219g.f3241A.getLayoutParams().height = iM1993V;
        abstractActivityC2219g.f3241A.getLayoutParams().width = iM1993V;
        abstractActivityC2219g.f3241A.requestLayout();
        if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.TOP_RIGHT) {
            ((RelativeLayout.LayoutParams) abstractActivityC2219g.f3241A.getLayoutParams()).addRule(20);
        } else {
            ((RelativeLayout.LayoutParams) abstractActivityC2219g.f3241A.getLayoutParams()).addRule(21);
        }
        float f3 = i;
        abstractActivityC2219g.f3356x.setTextSize(2, f3);
        abstractActivityC2219g.f3357y.setTextSize(2, f3);
        abstractActivityC2219g.f3348p.setTextSize(2, f3);
        abstractActivityC2219g.f3352t.setTextSize(2, f3);
        abstractActivityC2219g.f3280aQ.setTextSize(2, iM1619B);
        float f4 = i2;
        abstractActivityC2219g.f3351s.setTextSize(2, f4);
        abstractActivityC2219g.f3347o.setTextSize(2, f4);
        abstractActivityC2219g.f3351s.setPadding(iRound3, iRound3, iRound3, iRound3);
        abstractActivityC2219g.f3347o.setPadding(iRound3, iRound3, iRound3, iRound3);
        abstractActivityC2219g.f3350r.setTextSize(2, i3);
        int iM1675V2 = C2156av.m1675V();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) abstractActivityC2219g.f3280aQ.getLayoutParams();
        layoutParams5.setMarginStart(iM1675V2);
        layoutParams5.setMarginEnd(iM1675V2);
        abstractActivityC2219g.f3280aQ.setLayoutParams(layoutParams5);
        abstractActivityC2219g.f3280aQ.requestLayout();
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ String m2141Z(EnumC2184bx enumC2184bx) {
        int i = AnonymousClass61.f3436F[enumC2184bx.ordinal()];
        if (i == 1) {
            return "Unknown";
        }
        if (i == 2) {
            return "InvalidMrzKey";
        }
        if (i == 3) {
            return "ResponseError";
        }
        if (i == 4) {
            return "ConnectionError";
        }
        return "";
    }
}
