package com.facetec.sdk;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecCustomization {
    public static int activityThemeId;

    /* JADX INFO: renamed from: f */
    static HashMap<EnumC2163bc, String> f2208f;

    /* JADX INFO: renamed from: g */
    static HashMap<EnumC2144aj, String> f2209g;
    public static String overrideResultScreenSuccessMessage;

    /* JADX INFO: renamed from: B */
    boolean f2210B;

    /* JADX INFO: renamed from: C */
    FaceTecOverlayCustomization f2211C;
    boolean Code;

    /* JADX INFO: renamed from: D */
    FaceTecFrameCustomization f2212D;

    /* JADX INFO: renamed from: F */
    FaceTecResultScreenCustomization f2213F;

    /* JADX INFO: renamed from: I */
    FaceTecIDScanCustomization f2214I;

    /* JADX INFO: renamed from: L */
    FaceTecGuidanceCustomization f2215L;

    /* JADX INFO: renamed from: S */
    FaceTecFeedbackCustomization f2216S;

    /* JADX INFO: renamed from: V */
    FaceTecOCRConfirmationCustomization f2217V;

    /* JADX INFO: renamed from: Z */
    boolean f2218Z;

    /* JADX INFO: renamed from: a */
    Map<String, String> f2219a;

    /* JADX INFO: renamed from: b */
    FaceTecExitAnimationStyle f2220b;

    /* JADX INFO: renamed from: c */
    FaceTecOvalCustomization f2221c;

    /* JADX INFO: renamed from: d */
    FaceTecCancelButtonCustomization f2222d;

    /* JADX INFO: renamed from: e */
    FaceTecExitAnimationStyle f2223e;
    public int exitAnimationSuccessResourceID;
    public int exitAnimationUnsuccessResourceID;

    /* JADX INFO: renamed from: j */
    private FaceTecSessionTimerCustomization f2224j;
    public FaceTecSecurityWatermarkImage securityWatermarkImage;
    public FaceTecVocalGuidanceCustomization vocalGuidanceCustomization;

    public static void setIDScanResultScreenMessageOverrides(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        HashMap<EnumC2144aj, String> map = new HashMap<>();
        f2209g = map;
        map.put(EnumC2144aj.IDSCAN_RETRY_FACE_DID_NOT_MATCH, str6);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_ID_NOT_FULLY_VISIBLE, str7);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_OCR_RESULTS_NOT_GOOD_ENOUGH, str8);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_ID_TYPE_NOT_SUPPORTED, str9);
        f2209g.put(EnumC2144aj.IDSCAN_SKIP_OR_ERROR_NFC, str10);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE, str);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE_BACK_NEXT, str2);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE, str3);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_USER_CONFIRMATION, str4);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_NFC, str5);
    }

    @Deprecated
    public static void setIDScanResultScreenMessageOverrides(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        C2131S.m1431V(String.format("FaceTec SDK Deprecated Method Warning:  The %s function with these arguments is deprecated, please use the updated overload in order to customize all available strings.", "setIDScanResultScreenMessageOverrides"));
        HashMap<EnumC2144aj, String> map = new HashMap<>();
        f2209g = map;
        map.put(EnumC2144aj.IDSCAN_RETRY_FACE_DID_NOT_MATCH, str6);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_ID_NOT_FULLY_VISIBLE, str7);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_OCR_RESULTS_NOT_GOOD_ENOUGH, str8);
        f2209g.put(EnumC2144aj.IDSCAN_SKIP_OR_ERROR_NFC, str9);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE, str);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE_BACK_NEXT, str2);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE, str3);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_USER_CONFIRMATION, str4);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_NFC, str5);
    }

    @Deprecated
    public static void setIDScanResultScreenMessageOverrides(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C2131S.m1431V(String.format("FaceTec SDK Deprecated Method Warning:  The %s function with these arguments is deprecated, please use the updated overload in order to customize all available strings.", "setIDScanResultScreenMessageOverrides"));
        HashMap<EnumC2144aj, String> map = new HashMap<>();
        f2209g = map;
        map.put(EnumC2144aj.IDSCAN_RETRY_FACE_DID_NOT_MATCH, str5);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_ID_NOT_FULLY_VISIBLE, str6);
        f2209g.put(EnumC2144aj.IDSCAN_RETRY_OCR_RESULTS_NOT_GOOD_ENOUGH, str7);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE, str);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_FRONT_SIDE_BACK_NEXT, str2);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_BACK_SIDE, str3);
        f2209g.put(EnumC2144aj.IDSCAN_SUCCESS_USER_CONFIRMATION, str4);
    }

    public static void setIDScanUploadMessageOverrides(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        HashMap<EnumC2163bc, String> map = new HashMap<>();
        f2208f = map;
        map.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_STARTED, str);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_STILL_UPLOADING, str2);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE, str3);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING, str4);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_STARTED, str5);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_STILL_UPLOADING, str6);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE, str7);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING, str8);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_STARTED, str9);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_STILL_UPLOADING, str10);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_RESPONSE, str11);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_PROCESSING, str12);
        f2208f.put(EnumC2163bc.NFC_UPLOAD_STARTED, str13);
        f2208f.put(EnumC2163bc.NFC_STILL_UPLOADING, str14);
        f2208f.put(EnumC2163bc.NFC_UPLOAD_COMPLETE_AWAITING_RESPONSE, str15);
        f2208f.put(EnumC2163bc.NFC_UPLOAD_COMPLETE_AWAITING_PROCESSING, str16);
    }

    @Deprecated
    public static void setIDScanUploadMessageOverrides(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        C2131S.m1431V(String.format("FaceTec SDK Deprecated Method Warning:  The %s function with these arguments is deprecated, please use the updated overload in order to customize all available strings.", "setIDScanUploadMessageOverrides"));
        HashMap<EnumC2163bc, String> map = new HashMap<>();
        f2208f = map;
        map.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_STARTED, str);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_STILL_UPLOADING, str2);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE, str3);
        f2208f.put(EnumC2163bc.IDSCAN_FRONT_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING, str4);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_STARTED, str5);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_STILL_UPLOADING, str6);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_RESPONSE, str7);
        f2208f.put(EnumC2163bc.IDSCAN_BACK_SIDE_UPLOAD_COMPLETE_AWAITING_PROCESSING, str8);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_STARTED, str9);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_STILL_UPLOADING, str10);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_RESPONSE, str11);
        f2208f.put(EnumC2163bc.IDSCAN_USER_CONFIRMED_INFO_UPLOAD_COMPLETE_AWAITING_PROCESSING, str12);
    }

    public FaceTecCustomization(Map<String, String> map) {
        this.Code = true;
        this.f2218Z = false;
        this.f2210B = false;
        this.f2212D = new FaceTecFrameCustomization();
        this.f2216S = new FaceTecFeedbackCustomization();
        this.f2221c = new FaceTecOvalCustomization();
        this.f2222d = new FaceTecCancelButtonCustomization();
        this.f2215L = new FaceTecGuidanceCustomization();
        this.f2213F = new FaceTecResultScreenCustomization();
        this.f2211C = new FaceTecOverlayCustomization();
        this.f2214I = new FaceTecIDScanCustomization();
        this.f2217V = new FaceTecOCRConfirmationCustomization();
        this.f2224j = new FaceTecSessionTimerCustomization();
        this.f2223e = FaceTecExitAnimationStyle.RIPPLE_OUT;
        this.f2220b = FaceTecExitAnimationStyle.NONE;
        this.exitAnimationUnsuccessResourceID = -1;
        this.exitAnimationSuccessResourceID = -1;
        this.f2219a = map;
        this.securityWatermarkImage = FaceTecSecurityWatermarkImage.FACETEC_ZOOM;
        this.vocalGuidanceCustomization = new FaceTecVocalGuidanceCustomization();
    }

    public FaceTecCustomization() {
        this(new HashMap());
    }

    public final void setExitAnimationSuccessCustom(FaceTecExitAnimationStyle faceTecExitAnimationStyle) {
        if (faceTecExitAnimationStyle == null) {
            faceTecExitAnimationStyle = FaceTecExitAnimationStyle.CIRCLE_FADE;
        }
        this.f2223e = faceTecExitAnimationStyle;
        FaceTecExitAnimationStyle faceTecExitAnimationStyle2 = FaceTecExitAnimationStyle.CIRCLE_FADE;
    }

    public final FaceTecExitAnimationStyle getExitAnimationSuccessCustom() {
        return this.f2223e;
    }

    public final void setExitAnimationUnsuccessCustom(FaceTecExitAnimationStyle faceTecExitAnimationStyle) {
        if (faceTecExitAnimationStyle == null) {
            faceTecExitAnimationStyle = FaceTecExitAnimationStyle.CIRCLE_FADE;
        }
        this.f2220b = faceTecExitAnimationStyle;
        FaceTecExitAnimationStyle faceTecExitAnimationStyle2 = FaceTecExitAnimationStyle.CIRCLE_FADE;
    }

    public final FaceTecExitAnimationStyle getExitAnimationUnsuccessCustom() {
        return this.f2220b;
    }

    public final void setFrameCustomization(FaceTecFrameCustomization faceTecFrameCustomization) {
        if (faceTecFrameCustomization == null) {
            faceTecFrameCustomization = new FaceTecFrameCustomization();
        }
        this.f2212D = faceTecFrameCustomization;
    }

    public final FaceTecFrameCustomization getFrameCustomization() {
        return this.f2212D;
    }

    public final void setFeedbackCustomization(FaceTecFeedbackCustomization faceTecFeedbackCustomization) {
        if (faceTecFeedbackCustomization == null) {
            faceTecFeedbackCustomization = new FaceTecFeedbackCustomization();
        }
        this.f2216S = faceTecFeedbackCustomization;
    }

    public final FaceTecFeedbackCustomization getFeedbackCustomization() {
        return this.f2216S;
    }

    public final void setOvalCustomization(FaceTecOvalCustomization faceTecOvalCustomization) {
        if (faceTecOvalCustomization == null) {
            faceTecOvalCustomization = new FaceTecOvalCustomization();
        }
        this.f2221c = faceTecOvalCustomization;
    }

    public final FaceTecOvalCustomization getOvalCustomization() {
        return this.f2221c;
    }

    public final void setCancelButtonCustomization(FaceTecCancelButtonCustomization faceTecCancelButtonCustomization) {
        if (faceTecCancelButtonCustomization == null) {
            faceTecCancelButtonCustomization = new FaceTecCancelButtonCustomization();
        }
        this.f2222d = faceTecCancelButtonCustomization;
    }

    public final FaceTecCancelButtonCustomization getCancelButtonCustomization() {
        return this.f2222d;
    }

    public final FaceTecGuidanceCustomization getGuidanceCustomization() {
        return this.f2215L;
    }

    public final void setGuidanceCustomization(FaceTecGuidanceCustomization faceTecGuidanceCustomization) {
        if (faceTecGuidanceCustomization == null) {
            faceTecGuidanceCustomization = new FaceTecGuidanceCustomization();
        }
        this.f2215L = faceTecGuidanceCustomization;
    }

    public final FaceTecResultScreenCustomization getResultScreenCustomization() {
        return this.f2213F;
    }

    public final void setResultScreenCustomization(FaceTecResultScreenCustomization faceTecResultScreenCustomization) {
        if (faceTecResultScreenCustomization == null) {
            faceTecResultScreenCustomization = new FaceTecResultScreenCustomization();
        }
        this.f2213F = faceTecResultScreenCustomization;
    }

    public final FaceTecOverlayCustomization getOverlayCustomization() {
        return this.f2211C;
    }

    public final void setOverlayCustomization(FaceTecOverlayCustomization faceTecOverlayCustomization) {
        if (faceTecOverlayCustomization == null) {
            faceTecOverlayCustomization = new FaceTecOverlayCustomization();
        }
        this.f2211C = faceTecOverlayCustomization;
    }

    public final FaceTecIDScanCustomization getIdScanCustomization() {
        return this.f2214I;
    }

    public final void setIdScanCustomization(FaceTecIDScanCustomization faceTecIDScanCustomization) {
        if (faceTecIDScanCustomization == null) {
            faceTecIDScanCustomization = new FaceTecIDScanCustomization();
        }
        this.f2214I = faceTecIDScanCustomization;
    }

    public final FaceTecOCRConfirmationCustomization getOcrConfirmationCustomization() {
        return this.f2217V;
    }

    public final void setOcrConfirmationCustomization(FaceTecOCRConfirmationCustomization faceTecOCRConfirmationCustomization) {
        if (faceTecOCRConfirmationCustomization == null) {
            faceTecOCRConfirmationCustomization = new FaceTecOCRConfirmationCustomization();
        }
        this.f2217V = faceTecOCRConfirmationCustomization;
    }

    public final FaceTecSessionTimerCustomization getSessionTimerCustomization() {
        return this.f2224j;
    }

    public final void setSessionTimerCustomization(FaceTecSessionTimerCustomization faceTecSessionTimerCustomization) {
        if (faceTecSessionTimerCustomization == null) {
            faceTecSessionTimerCustomization = new FaceTecSessionTimerCustomization();
        }
        this.f2224j = faceTecSessionTimerCustomization;
    }
}
