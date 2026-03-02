package com.facetec.sdk;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class FaceTecSDK {
    public static final String EXTRA_ID_SCAN_RESULTS = "facetecsdk.signup.idScanResult";
    public static final String EXTRA_SESSION_RESULTS = "facetecsdk.signup.sessionResult";
    public static final int REQUEST_CODE_SESSION = 1002;
    private static final boolean isMinimalLibrary = C2221j.m2226B();

    /* JADX INFO: renamed from: I */
    static FaceTecCustomization f2235I = new FaceTecCustomization();

    /* JADX INFO: renamed from: B */
    static FaceTecCustomization f2234B = null;
    static FaceTecCustomization Code = null;

    /* JADX INFO: renamed from: Z */
    static EnumC2125B f2236Z = EnumC2125B.NORMAL;

    /* JADX INFO: renamed from: com.facetec.sdk.FaceTecSDK$B */
    enum EnumC2125B {
        NORMAL,
        LOW_LIGHT,
        BRIGHT_LIGHT
    }

    public static abstract class InitializeCallback {
        public abstract void onCompletion(boolean z);
    }

    public enum CameraPermissionStatus {
        GRANTED("Authorized"),
        NOT_YET_REQUESTED("Not Yet Requested"),
        DENIED("Denied");


        /* JADX INFO: renamed from: Z */
        private final String f2240Z;

        CameraPermissionStatus(String str) {
            this.f2240Z = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f2240Z;
        }
    }

    /* JADX INFO: renamed from: Z */
    static boolean m1408Z() {
        return f2236Z == EnumC2125B.LOW_LIGHT && f2234B != null;
    }

    /* JADX INFO: renamed from: I */
    static boolean m1405I() {
        return f2236Z == EnumC2125B.BRIGHT_LIGHT && Code != null;
    }

    private FaceTecSDK() {
    }

    public static void initializeInDevelopmentMode(Context context, String str, String str2, InitializeCallback initializeCallback) {
        C2221j.m2246V(context, str, str2, initializeCallback);
    }

    public static void initializeInProductionMode(Context context, String str, String str2, String str3, InitializeCallback initializeCallback) {
        C2221j.Code(context);
        C2221j.m2225B(context, str, str2, str3, initializeCallback);
    }

    public static void setLowLightCustomization(FaceTecCustomization faceTecCustomization) {
        f2234B = faceTecCustomization;
    }

    public static void setDynamicDimmingCustomization(FaceTecCustomization faceTecCustomization) {
        Code = faceTecCustomization;
    }

    public static void setCustomization(FaceTecCustomization faceTecCustomization) {
        if (faceTecCustomization != null) {
            for (int i = 0; i < C2185by.f3002V.length(); i++) {
                try {
                    JSONObject jSONObject = C2185by.f3002V.getJSONObject(i);
                    String string = jSONObject.getString("overrideKey");
                    EnumC2177bq enumC2177bq = (EnumC2177bq) jSONObject.get("type");
                    if (faceTecCustomization.f2219a.get(string) != null && faceTecCustomization.f2219a.get(string).equals(jSONObject.getString("overrideValue"))) {
                        int i2 = C21245.Code[enumC2177bq.ordinal()];
                        if (i2 == 1) {
                            faceTecCustomization.f2218Z = true;
                        } else if (i2 == 2) {
                            faceTecCustomization.Code = false;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!m1407V(faceTecCustomization.f2215L.buttonBorderWidth)) {
                faceTecCustomization.f2215L.buttonBorderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2214I.buttonBorderWidth)) {
                faceTecCustomization.f2214I.buttonBorderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2212D.borderWidth)) {
                faceTecCustomization.f2212D.borderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2214I.captureScreenTextBackgroundBorderWidth)) {
                faceTecCustomization.f2214I.captureScreenTextBackgroundBorderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2214I.reviewScreenTextBackgroundBorderWidth)) {
                faceTecCustomization.f2214I.reviewScreenTextBackgroundBorderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2215L.retryScreenImageBorderWidth)) {
                faceTecCustomization.f2215L.retryScreenImageBorderWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2217V.mainHeaderDividerLineWidth)) {
                faceTecCustomization.f2217V.mainHeaderDividerLineWidth = -1;
            }
            if (!m1407V(faceTecCustomization.f2217V.inputFieldBorderWidth)) {
                faceTecCustomization.f2217V.inputFieldBorderWidth = -1;
            }
            if (!m1409Z(faceTecCustomization.f2212D.cornerRadius)) {
                faceTecCustomization.f2212D.cornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2216S.cornerRadius)) {
                faceTecCustomization.f2216S.cornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2215L.buttonCornerRadius)) {
                faceTecCustomization.f2215L.buttonCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2214I.buttonCornerRadius)) {
                faceTecCustomization.f2214I.buttonCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2214I.captureScreenTextBackgroundCornerRadius)) {
                faceTecCustomization.f2214I.captureScreenTextBackgroundCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2214I.reviewScreenTextBackgroundCornerRadius)) {
                faceTecCustomization.f2214I.reviewScreenTextBackgroundCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2215L.readyScreenTextBackgroundCornerRadius)) {
                faceTecCustomization.f2215L.readyScreenTextBackgroundCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2215L.retryScreenImageCornerRadius)) {
                faceTecCustomization.f2215L.retryScreenImageCornerRadius = -1;
            }
            if (!m1404B(faceTecCustomization.f2217V.inputFieldCornerRadius)) {
                faceTecCustomization.f2217V.inputFieldCornerRadius = -1;
            }
            if (!Code(faceTecCustomization.f2221c.strokeWidth)) {
                faceTecCustomization.f2221c.strokeWidth = -1;
            }
            if (!Code(faceTecCustomization.f2221c.progressStrokeWidth)) {
                faceTecCustomization.f2221c.progressStrokeWidth = -1;
            }
            if (!m1406I(faceTecCustomization.f2221c.progressRadialOffset)) {
                faceTecCustomization.f2221c.progressRadialOffset = -1;
            }
            if (faceTecCustomization.f2215L.retryScreenHeaderAttributedString != null && !faceTecCustomization.f2215L.retryScreenHeaderAttributedString.isEmpty()) {
                C2156av.m1720aX();
            }
            if (faceTecCustomization.f2215L.retryScreenSubtextAttributedString != null && !faceTecCustomization.f2215L.retryScreenSubtextAttributedString.isEmpty()) {
                C2156av.m1722aZ();
            }
            if (faceTecCustomization.f2215L.readyScreenHeaderAttributedString != null && !faceTecCustomization.f2215L.readyScreenHeaderAttributedString.isEmpty()) {
                C2156av.m1715aS();
            }
            if (faceTecCustomization.f2215L.readyScreenSubtextAttributedString != null && !faceTecCustomization.f2215L.readyScreenSubtextAttributedString.isEmpty()) {
                C2156av.m1718aV();
            }
            f2235I = faceTecCustomization;
        }
    }

    /* JADX INFO: renamed from: com.facetec.sdk.FaceTecSDK$5 */
    static /* synthetic */ class C21245 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[EnumC2177bq.values().length];
            Code = iArr;
            try {
                iArr[EnumC2177bq.CLICKABLE_READY_SCREEN_SUBTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[EnumC2177bq.DEV_MODE_TAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: V */
    private static boolean m1407V(int i) {
        boolean z = (i >= 0 && i <= 20) || i == -1;
        if (!z) {
            C2131S.m1431V("An error occurred while setting FaceTecCustomization due to a border width value set outside allowed range. Reverting border width value to default.");
        }
        return z;
    }

    /* JADX INFO: renamed from: Z */
    private static boolean m1409Z(int i) {
        boolean z = true;
        int i2 = C2156av.f2631B << 1;
        if ((i < 0 || i > i2) && i != -1) {
            z = false;
        }
        if (!z) {
            C2131S.m1431V("An error occurred while setting FaceTecCustomization due to a corner radius value set outside allowed range. Reverting corner radius value to default.");
        }
        return z;
    }

    /* JADX INFO: renamed from: B */
    private static boolean m1404B(int i) {
        boolean z = (i >= 0 && i <= 40) || i == -1;
        if (!z) {
            C2131S.m1431V("An error occurred while setting FaceTecCustomization due to a corner radius value set outside allowed range. Reverting corner radius value to default.");
        }
        return z;
    }

    private static boolean Code(int i) {
        boolean z = (i >= 2 && i <= 20) || i == -1;
        if (!z) {
            C2131S.m1431V("An error occurred while setting FaceTecCustomization due to a stroke width value set outside allowed range. Reverting stroke width value to default.");
        }
        return z;
    }

    /* JADX INFO: renamed from: I */
    private static boolean m1406I(int i) {
        boolean z = (i >= 2 && i <= 20) || i == -1;
        if (!z) {
            C2131S.m1431V("An error occurred while setting FaceTecCustomization due to a radial offset value set outside allowed range. Reverting radial offset value to default.");
        }
        return z;
    }

    public static FaceTecSDKStatus getStatus(Context context) {
        return C2221j.m2244V(context);
    }

    public static Long getLockoutEndTime(Context context) {
        return C2221j.m2233I(context);
    }

    public static boolean isLockedOut(Context context) {
        return C2221j.m2249Z(context);
    }

    public static void unload() {
        C2221j.m2236I();
    }

    public static CameraPermissionStatus getCameraPermissionStatus(Context context) {
        return C2221j.m2229D(context);
    }

    public static void setAuditTrailType(FaceTecAuditTrailType faceTecAuditTrailType) {
        C2221j.m2237I(faceTecAuditTrailType);
    }

    public static String version() {
        return "9.4.12";
    }

    public static String createFaceTecAPIUserAgentString(String str) {
        return C2221j.m2235I(str);
    }

    public static void setDynamicStrings(Map<Integer, String> map) {
        C2157aw.m1786Z(map);
    }

    public static void configureOCRLocalization(JSONObject jSONObject) {
        C2221j.f3478B = jSONObject;
    }
}
