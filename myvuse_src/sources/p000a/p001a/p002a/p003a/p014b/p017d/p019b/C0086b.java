package p000a.p001a.p002a.p003a.p014b.p017d.p019b;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0026u;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;

/* JADX INFO: renamed from: a.a.a.a.b.d.b.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0086b {

    /* JADX INFO: renamed from: w */
    public static C0086b f345w;

    /* JADX INFO: renamed from: a */
    public JSONObject f346a;

    /* JADX INFO: renamed from: o */
    public boolean f360o;

    /* JADX INFO: renamed from: s */
    public boolean f364s;

    /* JADX INFO: renamed from: t */
    public boolean f365t;

    /* JADX INFO: renamed from: b */
    public String f347b = "On";

    /* JADX INFO: renamed from: c */
    public String f348c = "Off";

    /* JADX INFO: renamed from: d */
    public String f349d = "SUB-CATEGORIES";

    /* JADX INFO: renamed from: e */
    public String f350e = "";

    /* JADX INFO: renamed from: f */
    public String f351f = "";

    /* JADX INFO: renamed from: g */
    public String f352g = "";

    /* JADX INFO: renamed from: h */
    public String f353h = "";

    /* JADX INFO: renamed from: i */
    public String f354i = "";

    /* JADX INFO: renamed from: j */
    public String f355j = "";

    /* JADX INFO: renamed from: k */
    public String f356k = "";

    /* JADX INFO: renamed from: l */
    public String f357l = "";

    /* JADX INFO: renamed from: m */
    public String f358m = "";

    /* JADX INFO: renamed from: n */
    public String f359n = "";

    /* JADX INFO: renamed from: p */
    public String f361p = "";

    /* JADX INFO: renamed from: q */
    public String f362q = "";

    /* JADX INFO: renamed from: r */
    public boolean f363r = true;

    /* JADX INFO: renamed from: u */
    public C0107c f366u = new C0107c();

    /* JADX INFO: renamed from: v */
    public C0107c f367v = new C0107c();

    /* JADX INFO: renamed from: a */
    public static synchronized C0086b m475a() {
        if (f345w == null) {
            f345w = new C0086b();
        }
        return f345w;
    }

    /* JADX INFO: renamed from: a */
    public void m477a(Context context) {
        String str;
        String str2;
        String str3;
        boolean z;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObject = this.f346a;
            if (jSONObject != null) {
                str = OTVendorListMode.GENERAL;
                str2 = "vendorListData";
                str3 = "menu";
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                str = OTVendorListMode.GENERAL;
                str2 = "vendorListData";
                str3 = "menu";
                if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z = true;
                } else {
                    z = false;
                    sharedPreferencesC0047f = null;
                }
                new C0045d(context, "OTT_DEFAULT_USER");
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    new SharedPreferencesC0047f(context, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                }
                String string = (z ? sharedPreferencesC0047f : sharedPreferences).getString("OT_OTT_DATA", null);
                jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : null;
            }
            this.f346a = jSONObject;
            if (C0032d.m240a(jSONObject)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = this.f346a.optJSONObject("preferenceCenterData");
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has("purposeList") && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("purposeList")) != null) {
                this.f347b = jSONObjectOptJSONObject.optString("ActiveText");
                this.f348c = jSONObjectOptJSONObject.optString("InactiveText");
                this.f349d = jSONObjectOptJSONObject.optString("SubCategoryHeaderText");
                this.f360o = jSONObjectOptJSONObject.optBoolean("InteractionChoiceIsConsentShow");
                OTLogger.m2743a(3, "OTTDataParser", "isInteractionChoiceIsConsent: " + this.f360o);
                this.f361p = jSONObjectOptJSONObject.optString("InteractionChoiceText");
            }
            JSONObject jSONObject2 = this.f346a.getJSONObject("bannerData");
            m478a(jSONObject2, true);
            if (jSONObject2.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS);
                if (jSONObject3.has(OTUXParamsKeys.OT_UX_SHOW_PREFERENCES)) {
                    this.f367v = m476a(jSONObject3.getJSONObject(OTUXParamsKeys.OT_UX_SHOW_PREFERENCES));
                }
                if (jSONObject3.has(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST)) {
                    this.f366u = m476a(jSONObject3.getJSONObject(OTUXParamsKeys.OT_UX_LINK_VENDOR_LIST));
                }
            }
            JSONObject jSONObject4 = this.f346a.getJSONObject("preferenceCenterData");
            m478a(jSONObject4, false);
            String str4 = str3;
            if (jSONObject4.has(str4)) {
                JSONObject jSONObject5 = jSONObject4.getJSONObject(str4);
                this.f354i = jSONObject5.optString("color");
                this.f355j = jSONObject5.optString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
                this.f356k = jSONObject5.optString("focusColor");
                this.f357l = jSONObject5.optString("focusTextColor");
                this.f358m = jSONObject5.optString("activeColor");
                this.f359n = jSONObject5.optString("activeTextColor");
            }
            JSONObject jSONObject6 = this.f346a;
            String str5 = str2;
            if (jSONObject6.has(str5)) {
                JSONObject jSONObject7 = jSONObject6.getJSONObject(str5);
                String str6 = str;
                if (jSONObject7.has(str6)) {
                    JSONObject jSONObject8 = jSONObject7.getJSONObject(str6);
                    if (jSONObject8.has("showFilterIcon")) {
                        this.f363r = jSONObject8.getBoolean("showFilterIcon");
                    }
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error while parsing OTT data, error: " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m478a(JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject.has(OTVendorListMode.GENERAL)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(OTVendorListMode.GENERAL);
            if (!z) {
                this.f352g = jSONObject2.optString("buttonFocusColor");
                this.f353h = jSONObject2.optString("buttonFocusTextColor");
                this.f365t = jSONObject2.optBoolean("buttonBorderShow");
            } else {
                this.f350e = jSONObject2.optString("buttonFocusColor");
                this.f351f = jSONObject2.optString("buttonFocusTextColor");
                this.f362q = jSONObject2.optString("layout", ViewProps.RIGHT);
                this.f364s = jSONObject2.optBoolean("buttonBorderShow");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0107c m476a(JSONObject jSONObject) {
        C0107c c0107c = new C0107c();
        if (jSONObject.has("color")) {
            c0107c.f729b = jSONObject.getString("color");
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_TEXT_COLOR)) {
            c0107c.f730c = jSONObject.getString(OTUXParamsKeys.OT_UX_TEXT_COLOR);
        }
        return c0107c;
    }
}
