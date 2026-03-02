package com.facetec.sdk;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.facetec.sdk.FaceTecCancelButtonCustomization;
import com.google.logging.type.LogSeverity;

/* JADX INFO: renamed from: com.facetec.sdk.x */
/* JADX INFO: loaded from: classes3.dex */
final class C2232x {

    /* JADX INFO: renamed from: B */
    AnimatedVectorDrawableCompat f3600B;

    /* JADX INFO: renamed from: F */
    private boolean f3602F;

    /* JADX INFO: renamed from: Z */
    FragmentC2145ak f3606Z;

    /* JADX INFO: renamed from: V */
    private int f3605V = 6000;
    private int Code = 4000;

    /* JADX INFO: renamed from: I */
    private final Handler f3603I = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: D */
    private boolean f3601D = false;

    /* JADX INFO: renamed from: L */
    private boolean f3604L = false;

    C2232x(FragmentC2145ak fragmentC2145ak, boolean z) {
        this.f3606Z = fragmentC2145ak;
        new Handler();
        this.f3602F = z;
    }

    /* JADX INFO: renamed from: B */
    final void m2308B(boolean z) {
        m2307B();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new AnonymousClass4(this.f3606Z, z, handler));
    }

    /* JADX INFO: renamed from: com.facetec.sdk.x$4, reason: invalid class name */
    final class AnonymousClass4 extends AbstractRunnableC2150ap {
        final /* synthetic */ Handler Code;

        /* JADX INFO: renamed from: V */
        private /* synthetic */ boolean f3617V;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Fragment fragment, boolean z, Handler handler) {
            super(fragment);
            this.f3617V = z;
            this.Code = handler;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            int iM1700aD;
            int iM1702aF;
            Drawable drawable;
            if (C2232x.this.f3602F) {
                iM1700aD = C2156av.m1703aG();
                iM1702aF = C2156av.m1704aH();
            } else {
                iM1700aD = C2156av.m1700aD();
                iM1702aF = C2156av.m1702aF();
            }
            boolean z = this.f3617V;
            if (z && iM1702aF != 0) {
                C2232x c2232x = C2232x.this;
                c2232x.f3600B = FragmentC2145ak.m1567I(c2232x.f3606Z.getActivity(), iM1702aF);
            } else if (!z && iM1700aD != 0) {
                C2232x c2232x2 = C2232x.this;
                c2232x2.f3600B = FragmentC2145ak.m1567I(c2232x2.f3606Z.getActivity(), iM1700aD);
            }
            if (C2232x.this.f3600B != null) {
                C2232x.this.f3606Z.f2457c.setImageDrawable(C2232x.this.f3600B);
                C2232x.this.f3600B.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.facetec.sdk.x.4.2
                    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
                    public final void onAnimationEnd(Drawable drawable2) {
                        AnonymousClass4.this.Code.post(new Runnable() { // from class: com.facetec.sdk.x.4.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (C2232x.this.f3600B != null) {
                                    C2232x.this.f3600B.start();
                                }
                            }
                        });
                    }
                });
                if (C2232x.this.f3600B != null) {
                    C2232x.this.f3600B.start();
                    return;
                }
                return;
            }
            C2232x.this.f3606Z.f2457c.getLayoutParams().width = (int) (C2232x.this.f3606Z.f2457c.getLayoutParams().height * 0.875f);
            C2232x.this.f3606Z.f2457c.requestLayout();
            if (this.f3617V) {
                int iM1707aK = C2156av.m1707aK();
                if (iM1707aK == 0) {
                    iM1707aK = C2130R.drawable.facetec_internal_nfc;
                }
                drawable = ContextCompat.getDrawable(C2232x.this.f3606Z.getActivity(), iM1707aK);
            } else {
                int iM1706aJ = C2156av.m1706aJ();
                if (iM1706aJ == 0) {
                    iM1706aJ = C2130R.drawable.facetec_internal_nfc;
                }
                drawable = ContextCompat.getDrawable(C2232x.this.f3606Z.getActivity(), iM1706aJ);
            }
            if (drawable != null) {
                C2232x.this.f3606Z.f2457c.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: renamed from: B */
    final void m2307B() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f3600B;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.stop();
            this.f3600B.clearAnimationCallbacks();
            this.f3600B = null;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.x$1, reason: invalid class name */
    final class AnonymousClass1 extends AbstractRunnableC2150ap {

        /* JADX INFO: renamed from: B */
        private /* synthetic */ boolean f3607B;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Fragment fragment, boolean z) {
            super(fragment);
            this.f3607B = z;
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            C2232x.this.m2309I();
            if (this.f3607B) {
                C2232x.this.f3606Z.f2459e.animate().alpha(0.0f).setDuration(800L).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.1.5
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        C2232x.this.m2311V(C2156av.m1679V(EnumC2233y.STARTING, C2232x.this.f3602F));
                        C2232x.this.f3606Z.f2459e.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    }
                }).start();
                return;
            }
            C2232x.this.f3606Z.f2458d.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            C2232x.this.f3606Z.f2444C.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            C2232x.this.f3606Z.f2453V.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            C2232x.this.f3606Z.f2454Z.animate().alpha(0.0f).setDuration(800L).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.1.2
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    C2232x.this.f3606Z.f2458d.setVisibility(8);
                    C2232x.this.f3606Z.f2444C.setVisibility(8);
                    C2232x.this.f3606Z.f2453V.setVisibility(8);
                    C2232x.this.f3606Z.f2454Z.setVisibility(4);
                    C2232x.this.f3606Z.f2455a.setAlpha(0.0f);
                    C2232x.this.f3606Z.f2445D.setAlpha(0.0f);
                    C2232x.this.f3606Z.f2445D.setVisibility(0);
                    C2232x.this.f3606Z.f2455a.setVisibility(0);
                    C2232x.this.f3606Z.f2463i.setVisibility(0);
                    FaceTecSessionActivity faceTecSessionActivity = (FaceTecSessionActivity) C2232x.this.f3606Z.getActivity();
                    if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM && FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.DISABLED) {
                        C2232x.this.f3606Z.f2460f.setVisibility(0);
                    } else if (FaceTecSDK.f2235I.f2222d.f2205Z == FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
                        faceTecSessionActivity.f3339g.setVisibility(0);
                        faceTecSessionActivity.f3339g.setAlpha(0.0f);
                    }
                    if (faceTecSessionActivity != null) {
                        faceTecSessionActivity.f3353u.setVisibility(8);
                    }
                    if (!C2187ca.m1980I(C2232x.this.f3606Z.getActivity()) || C2187ca.m1978B(C2232x.this.f3606Z.getActivity())) {
                        C2232x.this.m2311V(C2156av.m1679V(EnumC2233y.STARTING, C2232x.this.f3602F));
                    } else {
                        C2232x.this.Code(true);
                        if (faceTecSessionActivity != null) {
                            faceTecSessionActivity.m2212s();
                        }
                        C2232x.this.m2311V(C2156av.m1679V(EnumC2233y.DISABLED, C2232x.this.f3602F));
                    }
                    C2232x.this.f3606Z.f2455a.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    C2232x.this.f3606Z.f2445D.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    C2232x.this.m2312V(true);
                    new Handler().postDelayed(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.1.2.2
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            C2232x.this.m2308B(false);
                        }
                    }, 100L);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.x$5, reason: invalid class name */
    final class AnonymousClass5 extends AbstractRunnableC2150ap {
        AnonymousClass5(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            C2232x.this.m2309I();
            C2232x.this.f3606Z.f2457c.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            C2232x.this.f3606Z.f2459e.animate().alpha(0.0f).setDuration(800L).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.5.1
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    C2232x.this.m2311V(C2156av.m1679V(EnumC2233y.WEAK_CONNECTION, C2232x.this.f3602F));
                    C2232x.this.f3606Z.f2457c.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    C2232x.this.f3606Z.f2459e.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    C2232x.this.m2312V(true);
                    new Handler().postDelayed(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.5.1.4
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            C2232x.this.m2308B(false);
                        }
                    }, 100L);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.x$2, reason: invalid class name */
    final class AnonymousClass2 extends AbstractRunnableC2150ap {
        AnonymousClass2(Fragment fragment) {
            super(fragment);
        }

        @Override // com.facetec.sdk.AbstractRunnableC2150ap
        public final void Code() {
            C2232x.this.Code(true);
            C2232x.this.m2312V(false);
            C2232x.this.f3606Z.f2457c.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
            C2232x.this.f3606Z.f2459e.animate().alpha(0.0f).setDuration(800L).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.2.4
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                final void Code() {
                    C2232x.this.m2311V(C2156av.m1679V(EnumC2233y.SCANNING, C2232x.this.f3602F));
                    C2232x.this.f3606Z.f2457c.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    C2232x.this.f3606Z.f2459e.animate().alpha(1.0f).setDuration(800L).setListener(null).start();
                    new Handler().postDelayed(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.2.4.3
                        @Override // com.facetec.sdk.AbstractRunnableC2150ap
                        public final void Code() {
                            C2232x.this.m2308B(true);
                        }
                    }, 100L);
                }
            }).start();
        }
    }

    /* JADX INFO: renamed from: Z */
    final void m2313Z() {
        if (this.f3606Z.getActivity() == null) {
            return;
        }
        this.f3606Z.getActivity().runOnUiThread(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.9
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                C2232x.this.Code(true);
                C2232x.this.m2312V(false);
                C2232x.this.f3606Z.f2455a.animate().alpha(0.0f).setDuration(800L).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.9.1
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        C2232x.this.m2307B();
                        C2232x.this.f3606Z.f2445D.setVisibility(8);
                        C2232x.this.f3606Z.f2444C.setVisibility(0);
                    }
                }).start();
            }
        });
    }

    /* JADX INFO: renamed from: V */
    final void m2312V(boolean z) {
        float f = z ? 1.0f : 0.0f;
        FaceTecSessionActivity faceTecSessionActivity = (FaceTecSessionActivity) this.f3606Z.getActivity();
        if (FaceTecSDK.f2235I.f2222d.f2205Z != FaceTecCancelButtonCustomization.ButtonLocation.CUSTOM) {
            this.f3606Z.f2460f.animate().alpha(f).setDuration(800L).setListener(null).start();
            this.f3606Z.f2460f.setEnabled(z);
        } else {
            faceTecSessionActivity.f3339g.animate().alpha(f).setDuration(800L).setListener(null).start();
            faceTecSessionActivity.f3339g.setEnabled(z);
        }
    }

    /* JADX INFO: renamed from: V */
    final void m2311V(final String str) {
        if (this.f3606Z.getActivity() == null) {
            return;
        }
        this.f3606Z.getActivity().runOnUiThread(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.7
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                C2232x.this.f3606Z.f2459e.setText(str);
            }
        });
    }

    final void Code(boolean z) {
        this.f3601D = z;
        if (z) {
            Code();
            m2304I(true);
            this.f3606Z.getActivity().runOnUiThread(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.6
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    C2232x.this.f3606Z.f2463i.animate().alpha(0.0f).setDuration(800L).setListener(null).start();
                }
            });
        }
    }

    /* JADX INFO: renamed from: I */
    private void m2304I(boolean z) {
        this.f3604L = z;
        if (z) {
            Code();
            this.f3606Z.getActivity().runOnUiThread(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.8
                @Override // com.facetec.sdk.AbstractRunnableC2150ap
                public final void Code() {
                    C2232x.this.f3606Z.f2463i.setEnabled(false, C2232x.this.f3606Z.f2463i.getAlpha() > 0.0f);
                }
            });
        }
    }

    private void Code() {
        Handler handler = this.f3603I;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: renamed from: V */
    final void m2310V() {
        int i = (this.f3606Z.f2463i.getAlpha() == 1.0f && this.f3606Z.f2463i.isEnabled()) ? 0 : this.Code;
        m2304I(false);
        this.f3603I.postDelayed(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.10
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            final void Code() {
                if (C2232x.this.f3604L || C2232x.this.f3606Z.f2463i.getAlpha() != 1.0f || C2232x.this.f3606Z.f2463i.isEnabled()) {
                    return;
                }
                C2232x.this.f3606Z.f2463i.setEnabled(true, C2232x.this.f3606Z.f2463i.getAlpha() > 0.0f);
            }
        }, i);
    }

    /* JADX INFO: renamed from: I */
    final void m2309I() {
        int i = this.f3606Z.f2463i.getAlpha() == 1.0f ? 0 : this.f3605V;
        Code();
        Code(false);
        m2304I(false);
        this.f3603I.postDelayed(new AbstractRunnableC2150ap(this.f3606Z) { // from class: com.facetec.sdk.x.3
            @Override // com.facetec.sdk.AbstractRunnableC2150ap
            public final void Code() {
                if (C2232x.this.f3601D) {
                    return;
                }
                C2232x.this.f3606Z.f2463i.animate().alpha(1.0f).setDuration(C2232x.this.f3606Z.f2463i.getAlpha() == 1.0f ? 0 : LogSeverity.EMERGENCY_VALUE).setListener(null).withEndAction(new AbstractRunnableC2150ap(C2232x.this.f3606Z) { // from class: com.facetec.sdk.x.3.1
                    @Override // com.facetec.sdk.AbstractRunnableC2150ap
                    final void Code() {
                        if (C2232x.this.f3604L) {
                            return;
                        }
                        C2232x.this.m2310V();
                    }
                });
            }
        }, i);
    }
}
