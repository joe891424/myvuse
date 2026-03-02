package com.facetec.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import com.facetec.sdk.FaceTecVocalGuidanceCustomization;

/* JADX INFO: renamed from: com.facetec.sdk.az */
/* JADX INFO: loaded from: classes3.dex */
final class C2160az {

    /* JADX INFO: renamed from: B */
    private static MediaPlayer f2676B;

    /* JADX INFO: renamed from: C */
    private static MediaPlayer f2677C;
    static boolean Code;

    /* JADX INFO: renamed from: D */
    private static MediaPlayer f2678D;

    /* JADX INFO: renamed from: I */
    static SharedPreferences f2679I;

    /* JADX INFO: renamed from: L */
    private static MediaPlayer f2680L;

    /* JADX INFO: renamed from: V */
    private static MediaPlayer f2681V;

    /* JADX INFO: renamed from: Z */
    private static MediaPlayer f2682Z;

    /* JADX INFO: renamed from: com.facetec.sdk.az$V */
    enum V {
        GET_READY_PRESS_BUTTON_TAPPING,
        GET_READY_FRAME_YOUR_FACE_TAPPING,
        GET_READY_PRESS_BUTTON_DELAYED,
        GET_READY_FRAME_YOUR_FACE_AUTOMATIC,
        RETRY_PRESS_BUTTON_TAPPING,
        FACE_CAPTURE_UNZOOMED_FRAME_YOUR_FACE_TAPPING,
        FACE_CAPTURE_FRAME_YOUR_FACE_DELAYED,
        FACE_CAPTURE_ZOOMED_MOVE_CLOSER_TAPPING,
        FACE_CAPTURE_ZOOMED_PLEASE_FRAME_YOUR_FACE_TAPPING,
        FACE_CAPTURE_MOVE_CLOSER_AUTOMATIC,
        FACE_CAPTURE_MOVE_CLOSER_DELAYED,
        SUCCESS,
        UPLOADING,
        RETRY
    }

    C2160az() {
    }

    /* JADX INFO: renamed from: B */
    private static boolean m1799B() {
        return f2681V == null || f2682Z == null || f2676B == null || f2678D == null || f2680L == null || f2677C == null;
    }

    /* JADX INFO: renamed from: Z */
    private static boolean m1803Z() {
        return f2681V.isPlaying() || f2682Z.isPlaying() || f2676B.isPlaying() || f2678D.isPlaying() || f2680L.isPlaying() || f2677C.isPlaying();
    }

    /* JADX INFO: renamed from: V */
    static void m1802V(V v) {
        if (AbstractC2165be.Code || m1799B() || m1803Z() || FaceTecSDK.f2235I.vocalGuidanceCustomization.mode == FaceTecVocalGuidanceCustomization.VocalGuidanceMode.NO_VOCAL_GUIDANCE) {
            return;
        }
        switch (AnonymousClass1.Code[v.ordinal()]) {
            case 1:
            case 2:
            case 3:
                f2677C.start();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                f2681V.start();
                break;
            case 9:
            case 10:
            case 11:
                f2682Z.start();
                break;
            case 12:
                f2680L.start();
                break;
            case 13:
                f2678D.start();
                break;
            case 14:
                f2676B.start();
                break;
        }
        C2120C.m1363I();
    }

    /* JADX INFO: renamed from: com.facetec.sdk.az$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[V.values().length];
            Code = iArr;
            try {
                iArr[V.GET_READY_PRESS_BUTTON_TAPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[V.GET_READY_PRESS_BUTTON_DELAYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[V.RETRY_PRESS_BUTTON_TAPPING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[V.GET_READY_FRAME_YOUR_FACE_TAPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[V.GET_READY_FRAME_YOUR_FACE_AUTOMATIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[V.FACE_CAPTURE_UNZOOMED_FRAME_YOUR_FACE_TAPPING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Code[V.FACE_CAPTURE_FRAME_YOUR_FACE_DELAYED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Code[V.FACE_CAPTURE_ZOOMED_PLEASE_FRAME_YOUR_FACE_TAPPING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Code[V.FACE_CAPTURE_ZOOMED_MOVE_CLOSER_TAPPING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Code[V.FACE_CAPTURE_MOVE_CLOSER_AUTOMATIC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                Code[V.FACE_CAPTURE_MOVE_CLOSER_DELAYED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                Code[V.SUCCESS.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                Code[V.UPLOADING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                Code[V.RETRY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    static void m1801V(Context context) {
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseFrameYourFaceInTheOvalSoundFile == -1) {
            f2681V = MediaPlayer.create(context, C2130R.raw.facetec_internal_please_frame_your_face_sound_file);
        } else {
            f2681V = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseFrameYourFaceInTheOvalSoundFile);
        }
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseMoveCloserSoundFile == -1) {
            f2682Z = MediaPlayer.create(context, C2130R.raw.facetec_internal_please_move_closer_sound_file);
        } else {
            f2682Z = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseMoveCloserSoundFile);
        }
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseRetrySoundFile == -1) {
            f2676B = MediaPlayer.create(context, C2130R.raw.facetec_internal_please_retry_sound_file);
        } else {
            f2676B = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.pleaseRetrySoundFile);
        }
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.uploadingSoundFile == -1) {
            f2678D = MediaPlayer.create(context, C2130R.raw.facetec_internal_uploading_sound_file);
        } else {
            f2678D = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.uploadingSoundFile);
        }
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.facescanSuccessfulSoundFile == -1) {
            f2680L = MediaPlayer.create(context, C2130R.raw.facetec_internal_facescan_successful_sound_file);
        } else {
            f2680L = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.facescanSuccessfulSoundFile);
        }
        if (FaceTecSDK.f2235I.vocalGuidanceCustomization.pleasePressTheButtonToStartSoundFile == -1) {
            f2677C = MediaPlayer.create(context, C2130R.raw.facetec_internal_please_press_button_sound_file);
        } else {
            f2677C = MediaPlayer.create(context, FaceTecSDK.f2235I.vocalGuidanceCustomization.pleasePressTheButtonToStartSoundFile);
        }
        SharedPreferences sharedPreferencesM2228C = C2221j.m2228C(context);
        f2679I = sharedPreferencesM2228C;
        Code = sharedPreferencesM2228C.getBoolean("facetecMoveCloserSoundHasBeenPlayed", false);
    }

    /* JADX INFO: renamed from: I */
    static void m1800I() {
        MediaPlayer mediaPlayer = f2681V;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            f2681V = null;
        }
        MediaPlayer mediaPlayer2 = f2682Z;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            f2682Z = null;
        }
        MediaPlayer mediaPlayer3 = f2676B;
        if (mediaPlayer3 != null) {
            mediaPlayer3.release();
            f2676B = null;
        }
        MediaPlayer mediaPlayer4 = f2677C;
        if (mediaPlayer4 != null) {
            mediaPlayer4.release();
            f2677C = null;
        }
        MediaPlayer mediaPlayer5 = f2678D;
        if (mediaPlayer5 != null) {
            mediaPlayer5.release();
            f2678D = null;
        }
        MediaPlayer mediaPlayer6 = f2680L;
        if (mediaPlayer6 != null) {
            mediaPlayer6.release();
            f2680L = null;
        }
        if (f2679I != null) {
            f2680L = null;
        }
    }
}
