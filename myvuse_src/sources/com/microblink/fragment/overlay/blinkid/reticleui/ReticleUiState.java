package com.microblink.fragment.overlay.blinkid.reticleui;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.widget.ImageView;
import com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator;
import com.microblink.fragment.overlay.blinkid.reticleui.ReticleView;
import com.microblink.library.C3714R;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SENSING' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ReticleUiState {
    public static final ReticleUiState AFTER_CARD_FLIP;
    public static final ReticleUiState CAMERA_TOO_CLOSE;
    public static final ReticleUiState CAMERA_TOO_HIGH;
    public static final ReticleUiState DOCUMENT_NOT_FULLY_VISIBLE;
    public static final ReticleUiState DOCUMENT_NOT_IN_HAND;
    public static final ReticleUiState DOCUMENT_TOO_CLOSE_TO_EDGE;
    public static final ReticleUiState ERROR_DIALOG;
    public static final ReticleUiState FLIP_CARD;
    private static final /* synthetic */ ReticleUiState[] IlIllIlIIl;
    public static final ReticleUiState PROCESSING;
    public static final ReticleUiState SENSING;
    public static final ReticleUiState SUCCESS;
    public static final ReticleUiState TILT_CARD_DOWN;
    public static final ReticleUiState TILT_CARD_LEFT;
    public static final ReticleUiState TILT_CARD_NEUTRAL;
    public static final ReticleUiState TILT_CARD_RIGHT;
    public static final ReticleUiState TILT_CARD_UP;
    public static final ReticleUiState TILT_SUCCESS;
    public final CardAnimator cardAnimator;
    public final boolean isDetectionError;
    public final boolean isProcessingError;
    final StatusMessageMode llIIlIlIIl;
    public final long minDurationMs;
    public final ReticleView.Type reticleType;
    public final boolean shouldShowProgress;
    public final boolean shouldShowPulse;

    static {
        ReticleView.Type type = ReticleView.Type.DEFAULT;
        StatusMessageMode statusMessageMode = StatusMessageMode.DELAYED;
        CardAnimator cardAnimator = CardAnimator.EMPTY;
        ReticleUiState reticleUiState = new ReticleUiState("SENSING", 0, type, true, false, false, false, statusMessageMode, cardAnimator, 0L);
        SENSING = reticleUiState;
        StatusMessageMode statusMessageMode2 = StatusMessageMode.IMMEDIATE;
        ReticleUiState reticleUiState2 = new ReticleUiState("PROCESSING", 1, type, false, true, false, false, statusMessageMode2, cardAnimator, 400L);
        PROCESSING = reticleUiState2;
        ReticleView.Type type2 = ReticleView.Type.SUCCESS;
        ReticleUiState reticleUiState3 = new ReticleUiState("SUCCESS", 2, type2, false, false, false, false, statusMessageMode2, cardAnimator, 750L);
        SUCCESS = reticleUiState3;
        ReticleView.Type type3 = ReticleView.Type.HIDDEN;
        ReticleUiState reticleUiState4 = new ReticleUiState("FLIP_CARD", 3, type3, false, false, false, false, statusMessageMode2, new CardFlipAnimator(), FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
        FLIP_CARD = reticleUiState4;
        ReticleUiState reticleUiState5 = new ReticleUiState("AFTER_CARD_FLIP", 4, type, true, false, false, false, statusMessageMode2, cardAnimator, 0L);
        AFTER_CARD_FLIP = reticleUiState5;
        ReticleUiState reticleUiState6 = new ReticleUiState("ERROR_DIALOG", 5, type3, false, false, false, false, statusMessageMode2, cardAnimator, 0L);
        ERROR_DIALOG = reticleUiState6;
        ReticleView.Type type4 = ReticleView.Type.ERROR;
        ReticleUiState reticleUiState7 = new ReticleUiState("CAMERA_TOO_HIGH", 6, type4, false, false, true, false, statusMessageMode2, cardAnimator, 1000L);
        CAMERA_TOO_HIGH = reticleUiState7;
        ReticleUiState reticleUiState8 = new ReticleUiState("CAMERA_TOO_CLOSE", 7, type4, false, false, true, false, statusMessageMode2, cardAnimator, 1000L);
        CAMERA_TOO_CLOSE = reticleUiState8;
        ReticleUiState reticleUiState9 = new ReticleUiState("DOCUMENT_TOO_CLOSE_TO_EDGE", 8, type4, false, false, true, false, statusMessageMode2, cardAnimator, 1000L);
        DOCUMENT_TOO_CLOSE_TO_EDGE = reticleUiState9;
        ReticleUiState reticleUiState10 = new ReticleUiState("DOCUMENT_NOT_FULLY_VISIBLE", 9, type4, false, false, false, true, statusMessageMode2, cardAnimator, 1000L);
        DOCUMENT_NOT_FULLY_VISIBLE = reticleUiState10;
        final CardTiltAnimator.TiltDirection tiltDirection = CardTiltAnimator.TiltDirection.NEUTRAL;
        ReticleUiState reticleUiState11 = new ReticleUiState("TILT_CARD_NEUTRAL", 10, type3, false, false, false, false, statusMessageMode2, new CardAnimator(tiltDirection) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator
            private TiltDirection IlIllIlIIl;
            private AnimatorSet llIIlIlIIl;

            /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator$1 */
            /* JADX INFO: compiled from: line */
            static /* synthetic */ class C36781 {
                static final /* synthetic */ int[] llIIlIlIIl;

                static {
                    int[] iArr = new int[TiltDirection.values().length];
                    llIIlIlIIl = iArr;
                    try {
                        iArr[TiltDirection.NEUTRAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.LEFT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.RIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.UP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.DOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            /* JADX INFO: compiled from: line */
            public enum TiltDirection {
                NEUTRAL,
                LEFT,
                RIGHT,
                UP,
                DOWN
            }

            {
                this.IlIllIlIIl = tiltDirection;
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void cancel() {
                AnimatorSet animatorSet = this.llIIlIlIIl;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.llIIlIlIIl.end();
                    this.llIIlIlIIl.cancel();
                }
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
                Context context = imageView.getContext();
                int i = 0;
                imageView.setVisibility(0);
                imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
                int i2 = C36781.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
                if (i2 == 1) {
                    i = C3714R.animator.mb_card_tilt_neutral;
                } else if (i2 == 2) {
                    i = C3714R.animator.mb_card_tilt_left;
                } else if (i2 == 3) {
                    i = C3714R.animator.mb_card_tilt_right;
                } else if (i2 == 4) {
                    i = C3714R.animator.mb_card_tilt_up;
                } else if (i2 == 5) {
                    i = C3714R.animator.mb_card_tilt_down;
                }
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, i);
                this.llIIlIlIIl = animatorSet;
                animatorSet.setTarget(imageView);
                imageView.setRotationX(0.0f);
                imageView.setRotationY(0.0f);
                this.llIIlIlIIl.start();
            }
        }, 1000L);
        TILT_CARD_NEUTRAL = reticleUiState11;
        final CardTiltAnimator.TiltDirection tiltDirection2 = CardTiltAnimator.TiltDirection.LEFT;
        ReticleUiState reticleUiState12 = new ReticleUiState("TILT_CARD_LEFT", 11, type3, false, false, false, false, statusMessageMode2, new CardAnimator(tiltDirection2) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator
            private TiltDirection IlIllIlIIl;
            private AnimatorSet llIIlIlIIl;

            /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator$1 */
            /* JADX INFO: compiled from: line */
            static /* synthetic */ class C36781 {
                static final /* synthetic */ int[] llIIlIlIIl;

                static {
                    int[] iArr = new int[TiltDirection.values().length];
                    llIIlIlIIl = iArr;
                    try {
                        iArr[TiltDirection.NEUTRAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.LEFT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.RIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.UP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.DOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            /* JADX INFO: compiled from: line */
            public enum TiltDirection {
                NEUTRAL,
                LEFT,
                RIGHT,
                UP,
                DOWN
            }

            {
                this.IlIllIlIIl = tiltDirection2;
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void cancel() {
                AnimatorSet animatorSet = this.llIIlIlIIl;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.llIIlIlIIl.end();
                    this.llIIlIlIIl.cancel();
                }
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
                Context context = imageView.getContext();
                int i = 0;
                imageView.setVisibility(0);
                imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
                int i2 = C36781.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
                if (i2 == 1) {
                    i = C3714R.animator.mb_card_tilt_neutral;
                } else if (i2 == 2) {
                    i = C3714R.animator.mb_card_tilt_left;
                } else if (i2 == 3) {
                    i = C3714R.animator.mb_card_tilt_right;
                } else if (i2 == 4) {
                    i = C3714R.animator.mb_card_tilt_up;
                } else if (i2 == 5) {
                    i = C3714R.animator.mb_card_tilt_down;
                }
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, i);
                this.llIIlIlIIl = animatorSet;
                animatorSet.setTarget(imageView);
                imageView.setRotationX(0.0f);
                imageView.setRotationY(0.0f);
                this.llIIlIlIIl.start();
            }
        }, 1000L);
        TILT_CARD_LEFT = reticleUiState12;
        final CardTiltAnimator.TiltDirection tiltDirection3 = CardTiltAnimator.TiltDirection.RIGHT;
        ReticleUiState reticleUiState13 = new ReticleUiState("TILT_CARD_RIGHT", 12, type3, false, false, false, false, statusMessageMode2, new CardAnimator(tiltDirection3) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator
            private TiltDirection IlIllIlIIl;
            private AnimatorSet llIIlIlIIl;

            /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator$1 */
            /* JADX INFO: compiled from: line */
            static /* synthetic */ class C36781 {
                static final /* synthetic */ int[] llIIlIlIIl;

                static {
                    int[] iArr = new int[TiltDirection.values().length];
                    llIIlIlIIl = iArr;
                    try {
                        iArr[TiltDirection.NEUTRAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.LEFT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.RIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.UP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.DOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            /* JADX INFO: compiled from: line */
            public enum TiltDirection {
                NEUTRAL,
                LEFT,
                RIGHT,
                UP,
                DOWN
            }

            {
                this.IlIllIlIIl = tiltDirection3;
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void cancel() {
                AnimatorSet animatorSet = this.llIIlIlIIl;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.llIIlIlIIl.end();
                    this.llIIlIlIIl.cancel();
                }
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
                Context context = imageView.getContext();
                int i = 0;
                imageView.setVisibility(0);
                imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
                int i2 = C36781.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
                if (i2 == 1) {
                    i = C3714R.animator.mb_card_tilt_neutral;
                } else if (i2 == 2) {
                    i = C3714R.animator.mb_card_tilt_left;
                } else if (i2 == 3) {
                    i = C3714R.animator.mb_card_tilt_right;
                } else if (i2 == 4) {
                    i = C3714R.animator.mb_card_tilt_up;
                } else if (i2 == 5) {
                    i = C3714R.animator.mb_card_tilt_down;
                }
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, i);
                this.llIIlIlIIl = animatorSet;
                animatorSet.setTarget(imageView);
                imageView.setRotationX(0.0f);
                imageView.setRotationY(0.0f);
                this.llIIlIlIIl.start();
            }
        }, 1000L);
        TILT_CARD_RIGHT = reticleUiState13;
        final CardTiltAnimator.TiltDirection tiltDirection4 = CardTiltAnimator.TiltDirection.UP;
        ReticleUiState reticleUiState14 = new ReticleUiState("TILT_CARD_UP", 13, type3, false, false, false, false, statusMessageMode2, new CardAnimator(tiltDirection4) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator
            private TiltDirection IlIllIlIIl;
            private AnimatorSet llIIlIlIIl;

            /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator$1 */
            /* JADX INFO: compiled from: line */
            static /* synthetic */ class C36781 {
                static final /* synthetic */ int[] llIIlIlIIl;

                static {
                    int[] iArr = new int[TiltDirection.values().length];
                    llIIlIlIIl = iArr;
                    try {
                        iArr[TiltDirection.NEUTRAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.LEFT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.RIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.UP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.DOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            /* JADX INFO: compiled from: line */
            public enum TiltDirection {
                NEUTRAL,
                LEFT,
                RIGHT,
                UP,
                DOWN
            }

            {
                this.IlIllIlIIl = tiltDirection4;
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void cancel() {
                AnimatorSet animatorSet = this.llIIlIlIIl;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.llIIlIlIIl.end();
                    this.llIIlIlIIl.cancel();
                }
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
                Context context = imageView.getContext();
                int i = 0;
                imageView.setVisibility(0);
                imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
                int i2 = C36781.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
                if (i2 == 1) {
                    i = C3714R.animator.mb_card_tilt_neutral;
                } else if (i2 == 2) {
                    i = C3714R.animator.mb_card_tilt_left;
                } else if (i2 == 3) {
                    i = C3714R.animator.mb_card_tilt_right;
                } else if (i2 == 4) {
                    i = C3714R.animator.mb_card_tilt_up;
                } else if (i2 == 5) {
                    i = C3714R.animator.mb_card_tilt_down;
                }
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, i);
                this.llIIlIlIIl = animatorSet;
                animatorSet.setTarget(imageView);
                imageView.setRotationX(0.0f);
                imageView.setRotationY(0.0f);
                this.llIIlIlIIl.start();
            }
        }, 1000L);
        TILT_CARD_UP = reticleUiState14;
        final CardTiltAnimator.TiltDirection tiltDirection5 = CardTiltAnimator.TiltDirection.DOWN;
        ReticleUiState reticleUiState15 = new ReticleUiState("TILT_CARD_DOWN", 14, type3, false, false, false, false, statusMessageMode2, new CardAnimator(tiltDirection5) { // from class: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator
            private TiltDirection IlIllIlIIl;
            private AnimatorSet llIIlIlIIl;

            /* JADX INFO: renamed from: com.microblink.fragment.overlay.blinkid.reticleui.CardTiltAnimator$1 */
            /* JADX INFO: compiled from: line */
            static /* synthetic */ class C36781 {
                static final /* synthetic */ int[] llIIlIlIIl;

                static {
                    int[] iArr = new int[TiltDirection.values().length];
                    llIIlIlIIl = iArr;
                    try {
                        iArr[TiltDirection.NEUTRAL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.LEFT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.RIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.UP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        llIIlIlIIl[TiltDirection.DOWN.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                }
            }

            /* JADX INFO: compiled from: line */
            public enum TiltDirection {
                NEUTRAL,
                LEFT,
                RIGHT,
                UP,
                DOWN
            }

            {
                this.IlIllIlIIl = tiltDirection5;
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void cancel() {
                AnimatorSet animatorSet = this.llIIlIlIIl;
                if (animatorSet != null) {
                    animatorSet.removeAllListeners();
                    this.llIIlIlIIl.end();
                    this.llIIlIlIIl.cancel();
                }
            }

            @Override // com.microblink.fragment.overlay.blinkid.reticleui.CardAnimator
            public void start(ImageView imageView, ReticleOverlayResources reticleOverlayResources) {
                Context context = imageView.getContext();
                int i = 0;
                imageView.setVisibility(0);
                imageView.setImageDrawable(reticleOverlayResources.lllIIIlIlI);
                int i2 = C36781.llIIlIlIIl[this.IlIllIlIIl.ordinal()];
                if (i2 == 1) {
                    i = C3714R.animator.mb_card_tilt_neutral;
                } else if (i2 == 2) {
                    i = C3714R.animator.mb_card_tilt_left;
                } else if (i2 == 3) {
                    i = C3714R.animator.mb_card_tilt_right;
                } else if (i2 == 4) {
                    i = C3714R.animator.mb_card_tilt_up;
                } else if (i2 == 5) {
                    i = C3714R.animator.mb_card_tilt_down;
                }
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(context, i);
                this.llIIlIlIIl = animatorSet;
                animatorSet.setTarget(imageView);
                imageView.setRotationX(0.0f);
                imageView.setRotationY(0.0f);
                this.llIIlIlIIl.start();
            }
        }, 1000L);
        TILT_CARD_DOWN = reticleUiState15;
        ReticleUiState reticleUiState16 = new ReticleUiState("TILT_SUCCESS", 15, type2, false, false, false, false, statusMessageMode2, cardAnimator, 750L);
        TILT_SUCCESS = reticleUiState16;
        ReticleUiState reticleUiState17 = new ReticleUiState("DOCUMENT_NOT_IN_HAND", 16, type4, false, false, true, false, statusMessageMode2, cardAnimator, 1000L);
        DOCUMENT_NOT_IN_HAND = reticleUiState17;
        IlIllIlIIl = new ReticleUiState[]{reticleUiState, reticleUiState2, reticleUiState3, reticleUiState4, reticleUiState5, reticleUiState6, reticleUiState7, reticleUiState8, reticleUiState9, reticleUiState10, reticleUiState11, reticleUiState12, reticleUiState13, reticleUiState14, reticleUiState15, reticleUiState16, reticleUiState17};
    }

    private ReticleUiState(String str, int i, ReticleView.Type type, boolean z, boolean z2, boolean z3, boolean z4, StatusMessageMode statusMessageMode, CardAnimator cardAnimator, long j) {
        this.reticleType = type;
        this.shouldShowPulse = z;
        this.shouldShowProgress = z2;
        this.isDetectionError = z3;
        this.isProcessingError = z4;
        this.llIIlIlIIl = statusMessageMode;
        this.cardAnimator = cardAnimator;
        this.minDurationMs = j;
    }

    public static ReticleUiState valueOf(String str) {
        return (ReticleUiState) Enum.valueOf(ReticleUiState.class, str);
    }

    public static ReticleUiState[] values() {
        return (ReticleUiState[]) IlIllIlIIl.clone();
    }
}
