package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.facetec.sdk.AbstractActivityC2220h;
import com.facetec.sdk.C2160az;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;
import com.facetec.sdk.GuidanceCenterContentFragment;

/* JADX INFO: renamed from: com.facetec.sdk.q */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2227q extends AbstractFragmentC2122F {

    /* JADX INFO: renamed from: b */
    static boolean f3541b = false;

    /* JADX INFO: renamed from: d */
    GuidanceCenterContentFragment f3542d;

    /* JADX INFO: renamed from: e */
    private AbstractActivityC2220h.I f3543e;

    /* JADX INFO: renamed from: f */
    private Handler f3544f;

    /* JADX INFO: renamed from: g */
    private Handler f3545g;

    /* JADX INFO: renamed from: i */
    private GuidanceCenterContentFragment f3547i;

    /* JADX INFO: renamed from: j */
    private Handler f3548j;

    /* JADX INFO: renamed from: h */
    private int f3546h = 0;

    /* JADX INFO: renamed from: k */
    private final Runnable f3549k = new Runnable() { // from class: com.facetec.sdk.q.2
        @Override // java.lang.Runnable
        public final void run() {
            FragmentC2227q.this.m1385C();
            C2160az.m1802V(C2160az.V.GET_READY_PRESS_BUTTON_DELAYED);
        }
    };

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: B */
    protected final void mo1384B() {
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: L */
    protected final boolean mo1389L() {
        return true;
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: Z */
    public final /* bridge */ /* synthetic */ void mo1395Z(boolean z) {
        super.mo1395Z(z);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final /* bridge */ /* synthetic */ Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final /* bridge */ /* synthetic */ void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* JADX INFO: renamed from: Z */
    static FragmentC2227q m2283Z(AbstractActivityC2220h.I i) {
        FragmentC2227q fragmentC2227q = new FragmentC2227q();
        Bundle bundle = new Bundle();
        bundle.putInt("PERMISSIONS_STATUS", i.ordinal());
        fragmentC2227q.setArguments(bundle);
        f3541b = false;
        return fragmentC2227q;
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3543e = AbstractActivityC2220h.I.values()[getArguments().getInt("PERMISSIONS_STATUS")];
        m2288h();
        GuidanceCenterContentFragment guidanceCenterContentFragment = new GuidanceCenterContentFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("screenType", GuidanceCenterContentFragment.ScreenType.GENERIC);
        guidanceCenterContentFragment.setArguments(bundle2);
        this.f3547i = guidanceCenterContentFragment;
        int i = C2130R.string.FaceTec_instructions_header_ready_1;
        int i2 = C2130R.string.FaceTec_instructions_message_ready_2;
        GuidanceCenterContentFragment.ScreenType screenType = GuidanceCenterContentFragment.ScreenType.READY_OVAL;
        GuidanceCenterContentFragment guidanceCenterContentFragment2 = new GuidanceCenterContentFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("header", i);
        bundle3.putInt("message", i2);
        bundle3.putSerializable("screenType", screenType);
        guidanceCenterContentFragment2.setArguments(bundle3);
        this.f3542d = guidanceCenterContentFragment2;
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: e */
    final void mo1397e() {
        super.mo1397e();
        this.f2165F.setVisibility(4);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: I */
    protected final void mo1388I() {
        C2120C.f2147V = C2173bm.f2895B;
        this.f2167L.setVisibility(8);
        m2282V(this.f3547i);
        if (this.f3548j == null) {
            this.f3548j = new Handler();
        }
        this.f3548j.post(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.3
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FragmentC2227q.m2284Z(FragmentC2227q.this);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m2287b() {
        Handler handler = this.f3545g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3545g = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2286a() {
        Handler handler = this.f3548j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3548j = null;
        }
    }

    /* JADX INFO: renamed from: h */
    private void m2288h() {
        if (this.f3548j == null) {
            this.f3548j = new Handler();
        }
        this.f3548j.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.1
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                FragmentC2227q.Code(FragmentC2227q.this);
            }
        }, 600000L);
    }

    /* JADX INFO: renamed from: B */
    private void m2281B(boolean z) {
        this.f2162B.Code(C2156av.m1699aC(), 1000, 500);
        if (z) {
            this.f2166I.animate().alpha(1.0f).setDuration(500L).setListener(null).withEndAction(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.10
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    if (FragmentC2227q.this.f3542d == null || !FragmentC2227q.this.isAdded()) {
                        return;
                    }
                    FragmentC2227q fragmentC2227q = FragmentC2227q.this;
                    fragmentC2227q.m2282V(fragmentC2227q.f3542d);
                    FragmentC2227q.this.f2162B.m1924I();
                    C2157aw.Code(FragmentC2227q.this.f2170Z, C2130R.string.FaceTec_action_im_ready);
                    FragmentC2227q.this.f2166I.animate().alpha(0.0f).setDuration(500L).setListener(null).start();
                }
            }).start();
            this.f3546h++;
        } else {
            C2157aw.Code(this.f2170Z, C2130R.string.FaceTec_action_im_ready);
        }
        this.f2169V.setEnabled(true);
        Code(true);
        this.f2170Z.setEnabled(false, true);
        Handler handler = new Handler();
        this.f3544f = handler;
        handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.9
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                FragmentC2227q.this.f2168S = true;
                if (FragmentC2227q.this.f2170Z.isEnabled()) {
                    return;
                }
                FragmentC2227q.this.f2170Z.setEnabled(true, true);
            }
        }, 7000L);
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
            m1385C();
            C2160az.m1802V(C2160az.V.GET_READY_FRAME_YOUR_FACE_AUTOMATIC);
            Handler handler2 = new Handler();
            this.f3545g = handler2;
            handler2.postDelayed(this.f3549k, 4500L);
        }
    }

    /* JADX INFO: renamed from: d */
    final void m2290d() {
        m2288h();
        this.f3543e = AbstractActivityC2220h.I.GRANTED;
        Code(getActivity());
        C2156av.m1653I(this.f2170Z, FaceTecSDK.f2235I.f2215L.buttonTextNormalColor);
        this.f3546h = 2;
        m2281B(true);
    }

    /* JADX INFO: renamed from: i */
    private boolean m2289i() {
        return this.f3543e != AbstractActivityC2220h.I.GRANTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V */
    public void m2282V(GuidanceCenterContentFragment guidanceCenterContentFragment) {
        getFragmentManager().beginTransaction().setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).replace(C2130R.id.centerContentFrameLayout, guidanceCenterContentFragment).commitAllowingStateLoss();
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final void onPause() {
        super.onPause();
        m2286a();
        m2287b();
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f3547i = null;
        this.f3542d = null;
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: V */
    protected final void mo1391V() {
        m2286a();
        m2287b();
        this.f2173c = null;
        AbstractActivityC2220h abstractActivityC2220hC = m1385C();
        if (abstractActivityC2220hC == null) {
            return;
        }
        if (m2289i()) {
            abstractActivityC2220hC.mo2203j();
        } else {
            abstractActivityC2220hC.mo2199f();
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    protected final void Code() {
        AbstractActivityC2220h abstractActivityC2220hC = m1385C();
        if (abstractActivityC2220hC == null) {
            return;
        }
        if (m2289i()) {
            abstractActivityC2220hC.m2223V();
        } else {
            this.f2170Z.setEnabled(false, true);
            this.f2170Z.setVisibility(4);
            f3541b = true;
            m2286a();
            m2287b();
            m1392V(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.7
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    AbstractActivityC2220h abstractActivityC2220hC2 = FragmentC2227q.this.m1385C();
                    if (abstractActivityC2220hC2 != null) {
                        abstractActivityC2220hC2.mo2195b();
                        EnumC2119B enumC2119B = EnumC2119B.GET_READY_IM_READY_PRESSED;
                        C2120C.m1362B();
                    }
                }
            }, 300);
        }
        mo1395Z(false);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: c */
    protected final void mo1396c() {
        AbstractActivityC2220h abstractActivityC2220hC = m1385C();
        if (abstractActivityC2220hC == null) {
            return;
        }
        if (m2289i()) {
            if (this.f3543e == AbstractActivityC2220h.I.NOT_GRANTED) {
                m2286a();
                abstractActivityC2220hC.m2223V();
            } else {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", abstractActivityC2220hC.getPackageName(), null));
                abstractActivityC2220hC.startActivity(intent);
                abstractActivityC2220hC.mo2203j();
            }
        } else {
            if (this.f3546h >= 2) {
                super.mo1396c();
            } else {
                Handler handler = new Handler();
                int i = this.f3546h;
                if (i == 0) {
                    this.f3546h = i + 1;
                }
                if (this.f3546h == 1) {
                    getFragmentManager().beginTransaction().setCustomAnimations(C2130R.anim.facetec_slide_in_left, C2130R.anim.facetec_slide_out_left).replace(C2130R.id.centerContentFrameLayout, this.f3542d, "centerContentFrameLayout").commitAllowingStateLoss();
                    this.f2162B.m1923B();
                    handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.8
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            C2157aw.Code(FragmentC2227q.this.f2170Z, C2130R.string.FaceTec_action_im_ready);
                        }
                    }, 900L);
                }
                handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.q.6
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        FragmentC2227q.this.f2169V.setEnabled(true);
                        FragmentC2227q.this.Code(true);
                        FragmentC2227q.this.f2170Z.setEnabled(true, true);
                    }
                }, 900L);
            }
            this.f3546h++;
        }
        mo1395Z(false);
    }

    /* JADX INFO: renamed from: com.facetec.sdk.q$5, reason: invalid class name */
    final class AnonymousClass5 extends AbstractRunnableC2150ap implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass5(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2227q.this.f2162B.m1925Z();
            if (FragmentC2227q.this.f3542d == null || FragmentC2227q.this.f3542d.f2258V == null || FragmentC2227q.this.f3542d.f2254F == null || FragmentC2227q.this.f3542d.f2256L == null || FragmentC2227q.this.f3542d.f2252C == null) {
                return;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2227q.this.f3542d.f2258V.getCurrentTextColor()), Integer.valueOf(C2156av.m1635D(FragmentC2227q.this.getActivity())));
            valueAnimatorOfObject.setDuration(1000L);
            valueAnimatorOfObject.addUpdateListener(this);
            valueAnimatorOfObject.start();
            ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2227q.this.f3542d.f2258V.getCurrentTextColor()), Integer.valueOf(C2156av.m1632C(FragmentC2227q.this.getActivity())));
            valueAnimatorOfObject2.setDuration(1000L);
            valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.q.5.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (FragmentC2227q.this.f3542d == null || !FragmentC2227q.this.isAdded() || FragmentC2227q.this.f3542d.f2256L == null || FragmentC2227q.this.f3542d.f2252C == null) {
                        return;
                    }
                    FragmentC2227q.this.f3542d.f2256L.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    FragmentC2227q.this.f3542d.f2252C.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfObject2.start();
            if (FragmentC2227q.this.f3542d.f2253D.getBackground() == null && FragmentC2227q.this.f3542d.f2257S.getBackground() == null) {
                return;
            }
            ValueAnimator valueAnimatorOfObject3 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(C2156av.m1647I(FragmentC2227q.this.getActivity(), FaceTecSDK.f2235I.f2215L.readyScreenTextBackgroundColor)), Integer.valueOf(C2156av.m1647I(FragmentC2227q.this.getActivity(), C2156av.m1618A())));
            valueAnimatorOfObject3.setDuration(1000L);
            valueAnimatorOfObject3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.q.5.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (FragmentC2227q.this.f3542d == null || !FragmentC2227q.this.isAdded()) {
                        return;
                    }
                    if (FragmentC2227q.this.f3542d.f2253D != null && FragmentC2227q.this.f3542d.f2253D.getBackground() != null) {
                        C2156av.m1625B(FragmentC2227q.this.getActivity(), FragmentC2227q.this.f3542d.f2260a, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2227q.this.f3542d.f2253D.setBackground(FragmentC2227q.this.f3542d.f2260a);
                    }
                    if (FragmentC2227q.this.f3542d.f2257S == null || FragmentC2227q.this.f3542d.f2257S.getBackground() == null) {
                        return;
                    }
                    C2156av.m1625B(FragmentC2227q.this.getActivity(), FragmentC2227q.this.f3542d.f2262c, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    FragmentC2227q.this.f3542d.f2257S.setBackground(FragmentC2227q.this.f3542d.f2262c);
                }
            });
            valueAnimatorOfObject3.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (FragmentC2227q.this.f3542d == null || !FragmentC2227q.this.isAdded() || FragmentC2227q.this.f3542d.f2258V == null || FragmentC2227q.this.f3542d.f2254F == null) {
                return;
            }
            FragmentC2227q.this.f3542d.f2258V.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            FragmentC2227q.this.f3542d.f2254F.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: Z */
    protected final void mo1394Z() {
        new Handler().post(new AnonymousClass5(this));
    }

    /* JADX INFO: renamed from: Z */
    static /* synthetic */ void m2284Z(FragmentC2227q fragmentC2227q) {
        fragmentC2227q.f3542d = GuidanceCenterContentFragment.m1411V(C2130R.string.FaceTec_instructions_header_ready_1, C2130R.string.FaceTec_instructions_message_ready_2, GuidanceCenterContentFragment.ScreenType.READY_OVAL, fragmentC2227q.f2162B.m1960L().top, fragmentC2227q.f2162B.m1960L().bottom);
        fragmentC2227q.f3547i.f2255I.setVisibility(0);
        fragmentC2227q.f3547i.f2251B.setVisibility(0);
        fragmentC2227q.f2170Z.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
        fragmentC2227q.m1393V(true, 500, 0);
        if (fragmentC2227q.m2289i()) {
            fragmentC2227q.f2170Z.setEnabled(true);
            if (C2156av.m1688Z(fragmentC2227q.getActivity()) != 0) {
                fragmentC2227q.f3547i.f2259Z.setImageDrawable(ContextCompat.getDrawable(fragmentC2227q.getActivity(), C2156av.m1688Z(fragmentC2227q.getActivity())));
                fragmentC2227q.f3547i.f2259Z.setVisibility(0);
            } else {
                fragmentC2227q.f3547i.f2259Z.setVisibility(8);
            }
            fragmentC2227q.f3547i.Code.setVisibility(0);
            C2157aw.Code(fragmentC2227q.f3547i.f2255I, C2130R.string.FaceTec_camera_permission_header);
            fragmentC2227q.f3547i.m1412Z(C2130R.string.FaceTec_camera_permission_message_enroll);
            if (fragmentC2227q.f3543e == AbstractActivityC2220h.I.NOT_GRANTED) {
                C2157aw.Code(fragmentC2227q.f2170Z, C2130R.string.FaceTec_camera_permission_enable_camera);
            } else {
                C2157aw.Code(fragmentC2227q.f2170Z, C2130R.string.FaceTec_camera_permission_launch_settings);
            }
        } else {
            fragmentC2227q.f2170Z.setEnabled(false);
            fragmentC2227q.m2282V(fragmentC2227q.f3542d);
            fragmentC2227q.f2162B.f2912B.setAlpha(255);
            fragmentC2227q.f2162B.m1924I();
            new Handler().postDelayed(new AbstractRunnableC2150ap(fragmentC2227q) { // from class: com.facetec.sdk.q.4
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    if (FragmentC2227q.this.f2162B != null) {
                        FragmentC2227q.this.f2162B.Code();
                    }
                }
            }, 1000L);
            fragmentC2227q.f3546h = 2;
            fragmentC2227q.m2281B(false);
        }
        fragmentC2227q.f2165F.setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(fragmentC2227q.f2165F, (Property<ViewGroup, Float>) View.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(objectAnimatorOfFloat);
        animatorSet.start();
        fragmentC2227q.m1385C();
        EnumC2119B enumC2119B = EnumC2119B.GET_READY_IM_READY_SHOWN_AND_READY;
        C2120C.m1362B();
    }

    static /* synthetic */ void Code(FragmentC2227q fragmentC2227q) {
        fragmentC2227q.f2170Z.setEnabled(false, true);
        fragmentC2227q.f2169V.setEnabled(false);
        fragmentC2227q.Code(false);
        AbstractActivityC2220h abstractActivityC2220hC = fragmentC2227q.m1385C();
        if (abstractActivityC2220hC != null) {
            abstractActivityC2220hC.mo2183D();
        }
    }
}
