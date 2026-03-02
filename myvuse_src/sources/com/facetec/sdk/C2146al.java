package com.facetec.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.facetec.sdk.C2160az;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;

/* JADX INFO: renamed from: com.facetec.sdk.al */
/* JADX INFO: loaded from: classes3.dex */
class C2146al extends LinearLayout {

    /* JADX INFO: renamed from: B */
    private View f2544B;

    /* JADX INFO: renamed from: C */
    private Animator f2545C;
    private TextView Code;

    /* JADX INFO: renamed from: D */
    private Animator f2546D;

    /* JADX INFO: renamed from: F */
    private int f2547F;

    /* JADX INFO: renamed from: I */
    private EnumC2143ai f2548I;

    /* JADX INFO: renamed from: L */
    private boolean f2549L;

    /* JADX INFO: renamed from: S */
    private Animation f2550S;

    /* JADX INFO: renamed from: V */
    private EnumC2136ab f2551V;

    /* JADX INFO: renamed from: c */
    private Handler f2552c;

    /* JADX INFO: renamed from: d */
    private final AnimatorListenerAdapter f2553d;

    /* JADX INFO: renamed from: S */
    static /* synthetic */ boolean m1586S(C2146al c2146al) {
        c2146al.f2549L = false;
        return false;
    }

    public C2146al(Context context) {
        super(context);
        this.f2551V = EnumC2136ab.FACE_NOT_FOUND;
        this.f2548I = EnumC2143ai.FRAME_YOUR_FACE;
        this.f2547F = 0;
        this.f2549L = false;
        this.f2553d = new AnimatorListenerAdapter() { // from class: com.facetec.sdk.al.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C2157aw.Code(C2146al.this.Code, C2146al.this.f2547F);
                if (C2146al.this.f2550S != null) {
                    C2146al.this.f2550S.cancel();
                    C2146al.this.f2550S = null;
                    C2146al.this.Code.setScaleX(1.0f);
                    C2146al.this.Code.setScaleY(1.0f);
                }
                C2146al.this.f2546D.start();
            }
        };
    }

    public C2146al(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2551V = EnumC2136ab.FACE_NOT_FOUND;
        this.f2548I = EnumC2143ai.FRAME_YOUR_FACE;
        this.f2547F = 0;
        this.f2549L = false;
        this.f2553d = new AnimatorListenerAdapter() { // from class: com.facetec.sdk.al.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C2157aw.Code(C2146al.this.Code, C2146al.this.f2547F);
                if (C2146al.this.f2550S != null) {
                    C2146al.this.f2550S.cancel();
                    C2146al.this.f2550S = null;
                    C2146al.this.Code.setScaleX(1.0f);
                    C2146al.this.Code.setScaleY(1.0f);
                }
                C2146al.this.f2546D.start();
            }
        };
    }

    public C2146al(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2551V = EnumC2136ab.FACE_NOT_FOUND;
        this.f2548I = EnumC2143ai.FRAME_YOUR_FACE;
        this.f2547F = 0;
        this.f2549L = false;
        this.f2553d = new AnimatorListenerAdapter() { // from class: com.facetec.sdk.al.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                C2157aw.Code(C2146al.this.Code, C2146al.this.f2547F);
                if (C2146al.this.f2550S != null) {
                    C2146al.this.f2550S.cancel();
                    C2146al.this.f2550S = null;
                    C2146al.this.Code.setScaleX(1.0f);
                    C2146al.this.Code.setScaleY(1.0f);
                }
                C2146al.this.f2546D.start();
            }
        };
    }

    /* JADX INFO: renamed from: B */
    final void m1591B(EnumC2147am enumC2147am, EnumC2143ai enumC2143ai) {
        setVisibility(4);
        TextView textView = (TextView) findViewById(C2130R.id.zoomFeedbackText);
        this.Code = textView;
        TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, 1);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this.Code, 5, 50, 1, 2);
        if (enumC2147am == EnumC2147am.READY_TO_START_ZOOM_SESSION) {
            C2157aw.Code(this.Code, C2130R.string.FaceTec_feedback_hold_steady);
            this.f2551V = EnumC2136ab.HOLD_STEADY;
        } else {
            switch (AnonymousClass1.f2554I[enumC2143ai.ordinal()]) {
                case 1:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_frame_your_face);
                    this.f2548I = EnumC2143ai.FRAME_YOUR_FACE;
                    break;
                case 2:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_frame_your_face);
                    this.f2548I = EnumC2143ai.FRAME_YOUR_FACE;
                    break;
                case 3:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_remove_dark_glasses);
                    this.f2548I = EnumC2143ai.WEARING_SUNGLASSES;
                    break;
                case 4:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_position_face_straight_in_oval);
                    this.f2548I = EnumC2143ai.BAD_POSE;
                    break;
                case 5:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_conditions_too_bright);
                    this.f2548I = EnumC2143ai.TOO_BRIGHT;
                    break;
                case 6:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_brighten_your_environment);
                    this.f2548I = EnumC2143ai.TOO_DARK;
                    break;
                case 7:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_neutral_expression);
                    this.f2548I = EnumC2143ai.MAKING_FACE;
                    break;
                case 8:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_eyes_straight_ahead);
                    this.f2548I = EnumC2143ai.EYES_LOOKING_AWAY;
                    break;
                case 9:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_hold_steady_3);
                    this.f2548I = EnumC2143ai.HOLD_STEADY_3;
                    break;
                case 10:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_hold_steady_2);
                    this.f2548I = EnumC2143ai.HOLD_STEADY_1;
                    break;
                case 11:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_presession_hold_steady_1);
                    this.f2548I = EnumC2143ai.HOLD_STEADY_1;
                    break;
                case 12:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_feedback_move_phone_closer);
                    this.f2548I = EnumC2143ai.MOVE_CLOSER;
                    break;
                case 13:
                    C2157aw.Code(this.Code, C2130R.string.FaceTec_feedback_move_phone_away);
                    this.f2548I = EnumC2143ai.MOVE_AWAY;
                    break;
            }
        }
        this.Code.setTypeface(FaceTecSDK.f2235I.f2216S.textFont);
        C2156av.m1654I(this.Code);
        GradientDrawable gradientDrawableM1767j = C2156av.m1767j(getContext());
        View viewFindViewById = findViewById(C2130R.id.zoomFeedbackContainer);
        this.f2544B = viewFindViewById;
        viewFindViewById.setBackground(gradientDrawableM1767j);
        int i = C2156av.f2637S;
        setPadding(i, i, i, (int) (((double) i) * 1.5d));
        this.f2544B.setElevation(C2188cb.m1993V(FaceTecSDK.f2235I.f2216S.elevation));
        this.f2544B.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        this.f2544B.setClipToOutline(false);
        this.f2544B.requestLayout();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.Code, (Property<TextView, Float>) View.ALPHA, 0.0f);
        this.f2545C = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(400L);
        this.f2545C.addListener(this.f2553d);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.Code, (Property<TextView, Float>) View.ALPHA, 1.0f);
        this.f2546D = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setDuration(400L);
        float fM1993V = C2188cb.m1993V(C2156av.m1660L().height) * C2156av.Code();
        float fM1993V2 = C2188cb.m1993V(C2156av.m1660L().width) * C2156av.Code();
        this.Code.getLayoutParams().height = (int) fM1993V;
        this.Code.getLayoutParams().width = (int) fM1993V2;
        int iRound = Math.round(C2188cb.m1993V(10) * C2156av.Code() * C2156av.m1644I());
        this.Code.setPadding(iRound, Math.round(iRound * 1.1f), iRound, iRound);
        this.Code.requestLayout();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.al$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: I */
        static final /* synthetic */ int[] f2554I;

        static {
            int[] iArr = new int[EnumC2143ai.values().length];
            f2554I = iArr;
            try {
                iArr[EnumC2143ai.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2554I[EnumC2143ai.FRAME_YOUR_FACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2554I[EnumC2143ai.WEARING_SUNGLASSES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2554I[EnumC2143ai.BAD_POSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2554I[EnumC2143ai.TOO_BRIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2554I[EnumC2143ai.TOO_DARK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2554I[EnumC2143ai.MAKING_FACE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2554I[EnumC2143ai.EYES_LOOKING_AWAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2554I[EnumC2143ai.HOLD_STEADY_3.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2554I[EnumC2143ai.HOLD_STEADY_2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2554I[EnumC2143ai.HOLD_STEADY_1.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2554I[EnumC2143ai.MOVE_CLOSER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2554I[EnumC2143ai.MOVE_AWAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m1592I() {
        if (this.f2547F == C2130R.string.FaceTec_feedback_move_phone_closer) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.15f, 1.0f, 1.15f, 1, 0.5f, 1, 0.5f);
            this.f2550S = scaleAnimation;
            scaleAnimation.setDuration(800L);
            this.f2550S.setRepeatMode(2);
            this.f2550S.setRepeatCount(-1);
            this.Code.startAnimation(this.f2550S);
            if (FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.FULL_VOCAL_GUIDANCE || FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.NO_VOCAL_GUIDANCE) {
                return;
            }
            Handler handler = new Handler();
            this.f2552c = handler;
            handler.postDelayed(new Runnable() { // from class: com.facetec.sdk.al.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (C2160az.Code || C2146al.this.f2547F != C2130R.string.FaceTec_feedback_move_phone_closer) {
                        return;
                    }
                    C2146al.this.getContext();
                    C2160az.m1802V(C2160az.V.FACE_CAPTURE_MOVE_CLOSER_DELAYED);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: renamed from: Z */
    final void m1593Z() {
        Handler handler = this.f2552c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f2552c = null;
        }
    }

    /* JADX INFO: renamed from: Z */
    public final void m1594Z(EnumC2143ai enumC2143ai) {
        if (enumC2143ai == this.f2548I || this.f2549L) {
            return;
        }
        this.f2548I = enumC2143ai;
        if (enumC2143ai == EnumC2143ai.FRAME_YOUR_FACE) {
            m1583B(C2130R.string.FaceTec_presession_frame_your_face);
            return;
        }
        if (enumC2143ai == EnumC2143ai.WEARING_SUNGLASSES) {
            m1583B(C2130R.string.FaceTec_presession_remove_dark_glasses);
            return;
        }
        if (enumC2143ai == EnumC2143ai.BAD_POSE) {
            m1583B(C2130R.string.FaceTec_presession_position_face_straight_in_oval);
            return;
        }
        if (enumC2143ai == EnumC2143ai.TOO_BRIGHT) {
            m1583B(C2130R.string.FaceTec_presession_conditions_too_bright);
            return;
        }
        if (enumC2143ai == EnumC2143ai.TOO_DARK) {
            m1583B(C2130R.string.FaceTec_presession_brighten_your_environment);
            return;
        }
        if (enumC2143ai == EnumC2143ai.MAKING_FACE) {
            m1583B(C2130R.string.FaceTec_presession_neutral_expression);
            return;
        }
        if (enumC2143ai == EnumC2143ai.EYES_LOOKING_AWAY) {
            m1583B(C2130R.string.FaceTec_presession_eyes_straight_ahead);
            return;
        }
        if (enumC2143ai == EnumC2143ai.HOLD_STEADY_3) {
            m1583B(C2130R.string.FaceTec_presession_hold_steady_3);
            return;
        }
        if (enumC2143ai == EnumC2143ai.HOLD_STEADY_2) {
            m1583B(C2130R.string.FaceTec_presession_hold_steady_2);
            return;
        }
        if (enumC2143ai == EnumC2143ai.HOLD_STEADY_1) {
            m1583B(C2130R.string.FaceTec_presession_hold_steady_1);
        } else if (enumC2143ai == EnumC2143ai.MOVE_CLOSER) {
            m1583B(C2130R.string.FaceTec_feedback_move_phone_closer);
        } else if (enumC2143ai == EnumC2143ai.MOVE_AWAY) {
            m1583B(C2130R.string.FaceTec_feedback_move_phone_away);
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m1590B(EnumC2136ab enumC2136ab) {
        if (enumC2136ab == this.f2551V || this.f2549L) {
            return;
        }
        this.f2551V = enumC2136ab;
        if (enumC2136ab == EnumC2136ab.HOLD_STEADY) {
            m1588V(C2130R.string.FaceTec_feedback_hold_steady);
            return;
        }
        if (enumC2136ab == EnumC2136ab.MOVE_FACE_CLOSER) {
            m1588V(C2130R.string.FaceTec_feedback_move_phone_closer);
            return;
        }
        if (enumC2136ab == EnumC2136ab.MOVE_FACE_FURTHER_AWAY) {
            m1588V(C2130R.string.FaceTec_feedback_move_phone_away);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_CENTERED_TOO_FAR_TOP) {
            m1588V(C2130R.string.FaceTec_feedback_center_face);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_CENTERED_TOO_FAR_BOTTOM) {
            m1588V(C2130R.string.FaceTec_feedback_center_face);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_CENTERED_TOO_FAR_LEFT) {
            m1588V(C2130R.string.FaceTec_feedback_center_face);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_CENTERED_TOO_FAR_RIGHT) {
            m1588V(C2130R.string.FaceTec_feedback_center_face);
            return;
        }
        if (enumC2136ab == EnumC2136ab.MOVE_FACE_AWAY_A_LITTLE) {
            m1588V(C2130R.string.FaceTec_feedback_move_phone_away);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_ROTATED_TOO_FAR_LEFT) {
            m1588V(C2130R.string.FaceTec_feedback_face_not_upright);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_ROTATED_TOO_FAR_RIGHT) {
            m1588V(C2130R.string.FaceTec_feedback_face_not_upright);
            return;
        }
        if (enumC2136ab == EnumC2136ab.FACE_NOT_FOUND) {
            m1588V(C2130R.string.FaceTec_feedback_face_not_found);
            return;
        }
        if (enumC2136ab == EnumC2136ab.MOVE_PHONE_TO_EYE_LEVEL) {
            m1588V(C2130R.string.FaceTec_feedback_move_phone_to_eye_level);
        } else if (enumC2136ab == EnumC2136ab.FACE_NOT_LOOKING_STRAIGHT_AHEAD) {
            m1588V(C2130R.string.FaceTec_feedback_face_not_looking_straight_ahead);
        } else if (enumC2136ab == EnumC2136ab.USE_EVEN_LIGHTING) {
            m1588V(C2130R.string.FaceTec_feedback_use_even_lighting);
        }
    }

    /* JADX INFO: renamed from: V */
    private void m1588V(int i) {
        if (this.f2549L || i == this.f2547F) {
            return;
        }
        this.f2547F = i;
        this.f2549L = true;
        this.f2545C.start();
        postDelayed(new Runnable() { // from class: com.facetec.sdk.al.2
            @Override // java.lang.Runnable
            public final void run() {
                C2146al.m1586S(C2146al.this);
            }
        }, 800L);
    }

    /* JADX INFO: renamed from: B */
    private void m1583B(int i) {
        if (this.f2549L || i == this.f2547F) {
            return;
        }
        this.f2547F = i;
        this.f2549L = false;
        C2157aw.Code(this.Code, i);
    }
}
