package com.facetec.sdk;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facetec.sdk.C2160az;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;
import com.facetec.sdk.GuidanceCenterContentFragment;

/* JADX INFO: renamed from: com.facetec.sdk.aq */
/* JADX INFO: loaded from: classes3.dex */
public final class FragmentC2151aq extends AbstractFragmentC2122F {

    /* JADX INFO: renamed from: h */
    static boolean f2574h = false;

    /* JADX INFO: renamed from: b */
    FragmentC2153as f2575b;

    /* JADX INFO: renamed from: d */
    GuidanceCenterContentFragment f2576d;

    /* JADX INFO: renamed from: e */
    int f2577e = 0;

    /* JADX INFO: renamed from: f */
    private Handler f2578f;

    /* JADX INFO: renamed from: i */
    private Handler f2579i;

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

    /* JADX INFO: renamed from: a */
    static FragmentC2151aq m1603a() {
        FragmentC2151aq fragmentC2151aq = new FragmentC2151aq();
        fragmentC2151aq.setArguments(new Bundle());
        f2574h = false;
        return fragmentC2151aq;
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Handler handler = new Handler();
        this.f2578f = handler;
        handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.1
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                AbstractActivityC2220h abstractActivityC2220hC = FragmentC2151aq.this.m1385C();
                if (abstractActivityC2220hC != null) {
                    abstractActivityC2220hC.mo2198e();
                }
            }
        }, 600000L);
        if (C2140af.m1542i().length != 0) {
            C2120C.f2147V = C2173bm.Code;
            this.f2575b = new FragmentC2153as();
            getFragmentManager().beginTransaction().setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).add(C2130R.id.centerContentFrameLayout, this.f2575b).commitAllowingStateLoss();
        } else {
            C2120C.f2147V = C2173bm.f2895B;
            this.f2577e = 1;
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F, android.app.Fragment
    public final void onPause() {
        super.onPause();
        m1604f();
        m1605g();
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: I */
    protected final void mo1388I() {
        if (m1385C() != null && FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
            C2160az.m1802V(C2160az.V.RETRY);
        }
        FragmentC2153as fragmentC2153as = this.f2575b;
        if (fragmentC2153as != null) {
            fragmentC2153as.f2608L.setAlpha(0.0f);
            this.f2575b.f2604C.setAlpha(0.0f);
            this.f2575b.f2606F.setAlpha(0.0f);
            this.f2575b.f2607I.setAlpha(0.0f);
            this.f2575b.f2605D.setAlpha(0.0f);
            this.f2575b.f2609S.setAlpha(0.0f);
            this.f2170Z.setVisibility(4);
            this.f2170Z.setAlpha(0.0f);
        }
        this.f2167L.setVisibility(8);
        this.f2170Z.setEnabled(false);
        this.f2169V.setEnabled(false);
        Code(false);
        this.f2162B.Code(C2156av.m1699aC(), 0, 0);
        if (this.f2578f == null) {
            Handler handler = new Handler();
            this.f2578f = handler;
            handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.5
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    AbstractActivityC2220h abstractActivityC2220hC = FragmentC2151aq.this.m1385C();
                    if (abstractActivityC2220hC != null) {
                        abstractActivityC2220hC.mo2198e();
                    }
                }
            }, 600000L);
        }
        new Handler(Looper.getMainLooper()).post(new AnonymousClass3(this));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.aq$3, reason: invalid class name */
    final class AnonymousClass3 extends AbstractRunnableC2150ap {
        AnonymousClass3(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            FragmentC2151aq.this.f2576d = GuidanceCenterContentFragment.m1411V(C2130R.string.FaceTec_instructions_header_ready_1, C2130R.string.FaceTec_instructions_message_ready_2, GuidanceCenterContentFragment.ScreenType.READY_OVAL, FragmentC2151aq.this.f2162B.m1960L().top, FragmentC2151aq.this.f2162B.m1960L().bottom);
            if (FragmentC2151aq.this.f2577e == 1) {
                FragmentC2151aq.this.getFragmentManager().beginTransaction().setCustomAnimations(C2130R.animator.facetec_no_delay_fade_in, 0).replace(C2130R.id.centerContentFrameLayout, FragmentC2151aq.this.f2576d).commitAllowingStateLoss();
                C2157aw.Code(FragmentC2151aq.this.f2170Z, C2130R.string.FaceTec_action_im_ready);
                FragmentC2151aq.this.f2162B.f2912B.setAlpha(255);
                FragmentC2151aq.this.f2162B.m1924I();
                new Handler().postDelayed(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.5
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        FragmentC2151aq.this.f2162B.Code();
                    }
                }, 500L);
                FragmentC2151aq.this.f2170Z.setAlpha(0.0f);
                FragmentC2151aq.this.f2170Z.setVisibility(0);
                FragmentC2151aq.this.f2170Z.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).withEndAction(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.4
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.4.1
                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                            final void Code() {
                                if (FragmentC2151aq.this.m1387F() != null) {
                                    FragmentC2151aq.this.f2169V.setEnabled(true);
                                    FragmentC2151aq.this.Code(true);
                                }
                            }
                        }, 300L);
                    }
                }).start();
                FragmentC2151aq.this.m1393V(true, 500, 300);
                FragmentC2151aq.this.m1607j();
                return;
            }
            if (FragmentC2151aq.this.f2575b == null) {
                return;
            }
            C2157aw.Code(FragmentC2151aq.this.f2170Z, C2130R.string.FaceTec_action_try_again);
            FragmentC2151aq.this.m1387F();
            FragmentC2151aq.this.f2575b.f2604C.animate().alpha(1.0f).setDuration(500L).setListener(null).start();
            FragmentC2151aq.this.f2575b.f2608L.animate().alpha(1.0f).setDuration(500L).setListener(null).withEndAction(new AnonymousClass1(FragmentC2151aq.this)).start();
        }

        /* JADX INFO: renamed from: com.facetec.sdk.aq$3$1, reason: invalid class name */
        final class AnonymousClass1 extends AbstractRunnableC2150ap {
            AnonymousClass1(Fragment fragment) {
                super(fragment);
            }

            /* JADX INFO: renamed from: com.facetec.sdk.aq$3$1$2, reason: invalid class name */
            final class AnonymousClass2 extends AbstractRunnableC2150ap {
                AnonymousClass2(Fragment fragment) {
                    super(fragment);
                }

                /* JADX INFO: renamed from: com.facetec.sdk.aq$3$1$2$3, reason: invalid class name and collision with other inner class name */
                final class C59523 extends AbstractRunnableC2150ap {
                    C59523(Fragment fragment) {
                        super(fragment);
                    }

                    /* JADX INFO: renamed from: com.facetec.sdk.aq$3$1$2$3$5, reason: invalid class name */
                    final class AnonymousClass5 extends AbstractRunnableC2150ap {
                        AnonymousClass5(Fragment fragment) {
                            super(fragment);
                        }

                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        final void Code() {
                            FragmentC2151aq.this.f2170Z.setAlpha(0.0f);
                            FragmentC2151aq.this.f2170Z.setVisibility(0);
                            FragmentC2151aq.this.f2170Z.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).withEndAction(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.1.2.3.5.3
                                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                                final void Code() {
                                    if (C2156av.m1701aE().length != 0) {
                                        new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.1.2.3.5.3.1
                                            @Override // com.facetec.sdk.AbstractRunnableC2150ap
                                            public final void Code() {
                                                FragmentC2151aq.this.f2575b.f2614c.m1795Z();
                                            }
                                        }, 10L);
                                    }
                                    new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.3.1.2.3.5.3.3
                                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                                        final void Code() {
                                            if (FragmentC2151aq.this.m1387F() != null) {
                                                FragmentC2151aq.this.f2170Z.setEnabled(true, true);
                                                FragmentC2151aq.this.f2169V.setEnabled(true);
                                                FragmentC2151aq.this.Code(true);
                                            }
                                        }
                                    }, 300L);
                                }
                            }).start();
                            FragmentC2151aq.this.m1393V(true, 500, 300);
                        }
                    }

                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        FragmentC2151aq.this.f2575b.f2609S.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).start();
                        FragmentC2151aq.this.f2575b.f2605D.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).withEndAction(new AnonymousClass5(FragmentC2151aq.this)).start();
                    }
                }

                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    FragmentC2151aq.this.f2575b.f2607I.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).withEndAction(new C59523(FragmentC2151aq.this)).start();
                }
            }

            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                FragmentC2151aq.this.f2575b.f2606F.animate().alpha(1.0f).setDuration(500L).setStartDelay(300L).setListener(null).withEndAction(new AnonymousClass2(FragmentC2151aq.this)).start();
            }
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: V */
    protected final void mo1391V() {
        if (this.f2577e == 0) {
            m1606h();
            C2140af.m1501M();
            this.f2577e++;
        } else {
            AbstractActivityC2220h abstractActivityC2220hC = m1385C();
            if (abstractActivityC2220hC != null) {
                abstractActivityC2220hC.mo2194a();
            }
            m1604f();
            m1605g();
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: L */
    protected final boolean mo1389L() {
        return this.f2577e == 1;
    }

    /* JADX INFO: renamed from: h */
    private void m1606h() {
        m1607j();
        m1393V(false, 500, 0);
        this.f2170Z.animate().alpha(0.0f).setDuration(500L).setStartDelay(0L).setListener(null).start();
        new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.4
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                C2157aw.Code(FragmentC2151aq.this.f2170Z, C2130R.string.FaceTec_action_im_ready);
                FragmentC2151aq.this.f2170Z.animate().alpha(1.0f).setDuration(500L).setStartDelay(0L).setListener(null).start();
                FragmentC2151aq.this.m1393V(true, 500, 0);
                new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(FragmentC2151aq.this) { // from class: com.facetec.sdk.aq.4.3
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    public final void Code() {
                        FragmentC2151aq.this.f2169V.setEnabled(true);
                        FragmentC2151aq.this.Code(true);
                    }
                }, 500L);
            }
        }, 800L);
        C2120C.f2147V = C2173bm.f2895B;
        m1602Z(this.f2576d);
        this.f2162B.m1923B();
        m1385C();
        EnumC2119B enumC2119B = EnumC2119B.GET_READY_IM_READY_SHOWN_AND_READY_RETRY;
        C2120C.m1362B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public void m1607j() {
        Handler handler = new Handler();
        this.f2579i = handler;
        handler.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.2
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                FragmentC2151aq.this.f2168S = true;
                if (FragmentC2151aq.this.f2170Z.isEnabled()) {
                    return;
                }
                FragmentC2151aq.this.f2170Z.setEnabled(true, true);
            }
        }, 7000L);
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    protected final void Code() {
        m1605g();
        if (this.f2577e == 0) {
            m1606h();
            C2140af.m1501M();
            if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE) {
                m1385C();
                C2160az.m1802V(C2160az.V.GET_READY_FRAME_YOUR_FACE_AUTOMATIC);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.6
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    FragmentC2151aq.this.mo1395Z(false);
                }
            }, 1300L);
        } else {
            f2574h = true;
            m1604f();
            m1392V(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.10
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    AbstractActivityC2220h abstractActivityC2220hC = FragmentC2151aq.this.m1385C();
                    if (abstractActivityC2220hC != null) {
                        abstractActivityC2220hC.mo2197d();
                        EnumC2119B enumC2119B = EnumC2119B.GET_READY_IM_READY_PRESSED_RETY;
                        C2120C.m1362B();
                    }
                    FragmentC2151aq.this.mo1395Z(false);
                }
            }, 1000);
        }
        this.f2577e++;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m1609d() {
        return this.f2577e == 1;
    }

    /* JADX INFO: renamed from: b */
    public final void m1608b() {
        if (this.f2578f == null) {
            this.f2578f = new Handler();
        }
        this.f2578f.postDelayed(new AbstractRunnableC2150ap(this) { // from class: com.facetec.sdk.aq.9
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                AbstractActivityC2220h abstractActivityC2220hC = FragmentC2151aq.this.m1385C();
                if (abstractActivityC2220hC != null) {
                    abstractActivityC2220hC.mo2198e();
                }
            }
        }, 600000L);
    }

    /* JADX INFO: renamed from: f */
    private void m1604f() {
        Handler handler = this.f2578f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f2578f = null;
        }
    }

    /* JADX INFO: renamed from: g */
    private void m1605g() {
        FragmentC2153as fragmentC2153as = this.f2575b;
        if (fragmentC2153as == null || fragmentC2153as.f2614c == null) {
            return;
        }
        this.f2575b.f2614c.m1794B();
    }

    /* JADX INFO: renamed from: Z */
    private void m1602Z(GuidanceCenterContentFragment guidanceCenterContentFragment) {
        getFragmentManager().beginTransaction().setCustomAnimations(C2130R.anim.facetec_slide_in_left, C2130R.anim.facetec_slide_out_left).replace(C2130R.id.centerContentFrameLayout, guidanceCenterContentFragment, "centerContentFrameLayout").commitAllowingStateLoss();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.aq$7, reason: invalid class name */
    final class AnonymousClass7 extends AbstractRunnableC2150ap implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass7(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            if (FragmentC2151aq.this.f2575b != null) {
                ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2151aq.this.f2575b.f2608L.getCurrentTextColor()), Integer.valueOf(C2156av.m1659L(FragmentC2151aq.this.getActivity())));
                valueAnimatorOfObject.setDuration(1000L);
                valueAnimatorOfObject.addUpdateListener(this);
                valueAnimatorOfObject.start();
                ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2151aq.this.f2575b.f2604C.getCurrentTextColor()), Integer.valueOf(C2156av.m1669S(FragmentC2151aq.this.getActivity())));
                valueAnimatorOfObject2.setDuration(1000L);
                valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.aq.7.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (FragmentC2151aq.this.f2575b == null || !FragmentC2151aq.this.isAdded()) {
                            return;
                        }
                        FragmentC2151aq.this.f2575b.f2604C.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2151aq.this.f2575b.f2605D.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2151aq.this.f2575b.f2609S.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2151aq.this.f2575b.f2612a.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2151aq.this.f2575b.f2615d.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                valueAnimatorOfObject2.start();
                ValueAnimator valueAnimatorOfObject3 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(C2156av.m1647I(FragmentC2151aq.this.getActivity(), FaceTecSDK.f2235I.f2215L.retryScreenImageBorderColor)), Integer.valueOf(C2156av.m1761g(FragmentC2151aq.this.getActivity())));
                valueAnimatorOfObject3.setDuration(1000L);
                valueAnimatorOfObject3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.aq.7.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (FragmentC2151aq.this.f2575b == null || !FragmentC2151aq.this.isAdded()) {
                            return;
                        }
                        FragmentC2151aq.this.f2575b.f2616e.setStroke(C2156av.m1668S(), ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        FragmentC2151aq.this.f2575b.f2611Z.setBackground(FragmentC2151aq.this.f2575b.f2616e);
                        FragmentC2151aq.this.f2575b.Code.setBackground(FragmentC2151aq.this.f2575b.f2616e);
                    }
                });
                valueAnimatorOfObject3.start();
                ValueAnimator valueAnimatorOfObject4 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(C2156av.m1647I(FragmentC2151aq.this.getActivity(), FaceTecSDK.f2235I.f2215L.retryScreenOvalStrokeColor)), Integer.valueOf(C2156av.m1759f(FragmentC2151aq.this.getActivity())));
                valueAnimatorOfObject4.setDuration(1000L);
                valueAnimatorOfObject4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.aq.7.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (FragmentC2151aq.this.f2575b == null || !FragmentC2151aq.this.isAdded()) {
                            return;
                        }
                        FragmentC2151aq.this.f2575b.f2610V.setColorFilter(((Integer) valueAnimator.getAnimatedValue()).intValue(), PorterDuff.Mode.SRC_IN);
                    }
                });
                valueAnimatorOfObject4.start();
                return;
            }
            if (FragmentC2151aq.this.f2576d == null || FragmentC2151aq.this.f2576d.f2258V == null || FragmentC2151aq.this.f2576d.f2254F == null || FragmentC2151aq.this.f2576d.f2256L == null || FragmentC2151aq.this.f2576d.f2252C == null) {
                return;
            }
            ValueAnimator valueAnimatorOfObject5 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2151aq.this.f2576d.f2258V.getCurrentTextColor()), Integer.valueOf(C2156av.m1635D(FragmentC2151aq.this.getActivity())));
            valueAnimatorOfObject5.setDuration(1000L);
            valueAnimatorOfObject5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.aq.7.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (FragmentC2151aq.this.f2576d == null || !FragmentC2151aq.this.isAdded()) {
                        return;
                    }
                    FragmentC2151aq.this.f2576d.f2258V.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    FragmentC2151aq.this.f2576d.f2254F.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfObject5.start();
            ValueAnimator valueAnimatorOfObject6 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(FragmentC2151aq.this.f2576d.f2256L.getCurrentTextColor()), Integer.valueOf(C2156av.m1632C(FragmentC2151aq.this.getActivity())));
            valueAnimatorOfObject6.setDuration(1000L);
            valueAnimatorOfObject6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facetec.sdk.aq.7.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (FragmentC2151aq.this.f2576d == null || !FragmentC2151aq.this.isAdded()) {
                        return;
                    }
                    FragmentC2151aq.this.f2576d.f2256L.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    FragmentC2151aq.this.f2576d.f2252C.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            valueAnimatorOfObject6.start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (FragmentC2151aq.this.f2575b == null || !FragmentC2151aq.this.isAdded()) {
                return;
            }
            FragmentC2151aq.this.f2575b.f2608L.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: Z */
    protected final void mo1394Z() {
        new Handler(Looper.getMainLooper()).post(new AnonymousClass7(this));
        this.f2162B.m1925Z();
    }

    @Override // com.facetec.sdk.AbstractFragmentC2122F
    /* JADX INFO: renamed from: B */
    protected final void mo1384B() {
        if (!(this.Code == null ? this.f2169V : this.Code).isEnabled() || f2574h) {
            return;
        }
        mo1391V();
    }
}
