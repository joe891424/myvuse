package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.android.gms.common.Scopes;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p008e.C0036d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p014b.p025i.C0173e;

/* JADX INFO: renamed from: a.a.a.a.a.c.b */
/* JADX INFO: loaded from: classes.dex */
public class C0006b {

    /* JADX INFO: renamed from: a */
    public Context f9a;

    /* JADX INFO: renamed from: b */
    public final C0045d f10b;

    /* JADX INFO: renamed from: c */
    public final C0046e f11c;

    /* JADX INFO: renamed from: d */
    public final C0036d f12d;

    /* JADX INFO: renamed from: f */
    public JSONArray f14f;

    /* JADX INFO: renamed from: g */
    public JSONArray f15g;

    /* JADX INFO: renamed from: h */
    public boolean f16h;

    /* JADX INFO: renamed from: i */
    public C0009d f17i = new C0009d();

    /* JADX INFO: renamed from: e */
    public boolean f13e = false;

    public C0006b(Context context) {
        this.f9a = context;
        this.f10b = new C0045d(context, "OTT_DEFAULT_USER");
        this.f11c = new C0046e(context);
        this.f12d = new C0036d(context);
    }

    /* JADX INFO: renamed from: a */
    public static int m8a(String str) {
        if ("OPT_OUT".equalsIgnoreCase(str) || "PENDING".equalsIgnoreCase(str) || RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_EXPIRED.equalsIgnoreCase(str) || "WITHDRAWN".equalsIgnoreCase(str)) {
            return 0;
        }
        return "ACTIVE".equalsIgnoreCase(str) ? 1 : -1;
    }

    /* JADX INFO: renamed from: a */
    public static void m9a(String str, JSONObject jSONObject) throws JSONException {
        boolean zEquals = str.equals("purposeLegitimateInterests");
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        JSONArray jSONArrayNames = jSONObject2.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONObject2.length(); i++) {
                jSONObject2.put(jSONArrayNames.getString(i), zEquals ? 1 : 0);
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m11a(JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, int i, JSONObject jSONObject2, JSONArray jSONArray3) throws JSONException {
        String strOptString;
        if (C0048h.m305b(jSONArray2.getJSONObject(i).optString("PurposeId"))) {
            strOptString = "OT_PURPOSE_ID_" + i;
        } else {
            jSONObject2.put("Id", jSONArray2.getJSONObject(i).optString("PurposeId"));
            jSONObject2.put("TransactionType", oTPublishersHeadlessSDK.getConsentStatusForGroupId(jSONArray2.getJSONObject(i).optString("CustomGroupId"), jSONArray2.getJSONObject(i).getString("Status")) == 0 ? "NOTGIVEN" : "CONFIRMED");
            jSONArray.put(jSONObject2);
            strOptString = jSONArray2.getJSONObject(i).optString("PurposeId");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("Id", jSONArray2.getJSONObject(i).optString("PurposeId"));
            jSONObject3.put("TransactionType", jSONArray2.getJSONObject(i).getString("Status").equals("inactive") ? "NOTGIVEN" : "CONFIRMED");
            jSONArray3.put(jSONObject3);
        }
        jSONObject.put(strOptString, jSONArray2.getJSONObject(i).optString("CustomGroupId", ""));
    }

    /* JADX INFO: renamed from: a */
    public static void m12a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject2.has("IsIabEnabled") && jSONObject2.has("IabType")) {
            jSONObject.put("IsIabEnabled", jSONObject2.getBoolean("IsIabEnabled"));
            jSONObject.put("IabType", jSONObject2.getString("IabType"));
            if (!jSONObject2.getBoolean("IsIabEnabled") || "".equals(jSONObject2.getString("IabType"))) {
                return;
            }
            m19b(jSONObject, jSONObject2, "BannerDPDTitle");
            if (!jSONObject2.has("BannerDPDDescription") || jSONObject2.isNull("BannerDPDDescription")) {
                return;
            }
            jSONObject.put("BannerDPDDescription", jSONObject2.get("BannerDPDDescription").toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m14a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str) throws JSONException {
        jSONObject.put(str.toLowerCase(Locale.ENGLISH), -1);
        if (jSONObject3.getString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            jSONObject2.put(str, jSONObject3.getString("Status"));
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m15a(SharedPreferences sharedPreferences, JSONObject jSONObject, boolean z, String str) {
        if (jSONObject.has(str) || z) {
            return z;
        }
        sharedPreferences.edit().putBoolean("OT_HAS_GROUP_CONFIG_CHANGED", true).apply();
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static void m18b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        m19b(jSONObject, jSONObject2, "PcTextColor");
        m19b(jSONObject, jSONObject2, "PcButtonColor");
        m19b(jSONObject, jSONObject2, "PcButtonColor");
        m19b(jSONObject, jSONObject2, "PcButtonTextColor");
        m19b(jSONObject, jSONObject2, "PcBackgroundColor");
        m19b(jSONObject, jSONObject2, "PcMenuColor");
        m19b(jSONObject, jSONObject2, "PcMenuHighLightColor");
        m19b(jSONObject, jSONObject2, "PcLinksTextColor");
        m19b(jSONObject, jSONObject2, "OptanonLogo");
        m13a(jSONObject, jSONObject2, "ShowCookieList");
        m13a(jSONObject, jSONObject2, "PCShowCookieHost");
        m13a(jSONObject, jSONObject2, "PCShowCookieDuration");
        m13a(jSONObject, jSONObject2, "PCShowCookieType");
        m13a(jSONObject, jSONObject2, "PCShowCookieCategory");
        m19b(jSONObject, jSONObject2, "BConsentText");
        m19b(jSONObject, jSONObject2, "BLegitInterestText");
        if (jSONObject2.has("PCShowCookieDescription") && !jSONObject2.isNull("PCShowCookieDescription")) {
            jSONObject.put("PCShowCookieDescription", jSONObject2.get("PCShowCookieDescription").toString());
        }
        m19b(jSONObject, jSONObject2, "AllowHostOptOut");
        m19b(jSONObject, jSONObject2, "IabLegalTextUrl");
        jSONObject.put("BConsentPurposesText", jSONObject2.optString("BConsentPurposesText", ""));
        jSONObject.put("BLegitimateInterestPurposesText", jSONObject2.optString("BLegitimateInterestPurposesText", ""));
        jSONObject.put("BSpecialFeaturesText", jSONObject2.optString("BSpecialFeaturesText", ""));
        jSONObject.put("BSpecialPurposesText", jSONObject2.optString("BSpecialPurposesText", ""));
        jSONObject.put("BFeaturesText", jSONObject2.optString("BFeaturesText", ""));
    }

    /* JADX INFO: renamed from: b */
    public static void m19b(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.getString(str));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTData", "Error in appending pc data key. key = " + str + "Error message : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m20c(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        m19b(jSONObject, jSONObject2, "MainText");
        m19b(jSONObject, jSONObject2, "MainInfoText");
        m19b(jSONObject, jSONObject2, "AboutText");
        m19b(jSONObject, jSONObject2, "AboutLink");
        m19b(jSONObject, jSONObject2, "AlwaysActiveText");
        m19b(jSONObject, jSONObject2, "VendorLevelOptOut");
        m19b(jSONObject, jSONObject2, "PreferenceCenterPosition");
        m19b(jSONObject, jSONObject2, "PreferenceCenterConfirmText");
        m19b(jSONObject, jSONObject2, "VendorListText");
        m19b(jSONObject, jSONObject2, "PCGrpDescLinkPosition");
        m19b(jSONObject, jSONObject2, "ThirdPartyCookieListText");
        m19b(jSONObject, jSONObject2, "PreferenceCenterManagePreferencesText");
        m13a(jSONObject, jSONObject2, "ShowPreferenceCenterCloseButton");
        m19b(jSONObject, jSONObject2, "CloseText");
        m19b(jSONObject, jSONObject2, "AddLinksToCookiepedia");
        m19b(jSONObject, jSONObject2, "CookieListEnabled");
        m19b(jSONObject, jSONObject2, "Center");
        m19b(jSONObject, jSONObject2, "Panel");
        m19b(jSONObject, jSONObject2, "Popup");
        m19b(jSONObject, jSONObject2, "List");
        m19b(jSONObject, jSONObject2, "Tab");
        m19b(jSONObject, jSONObject2, "PCFirstPartyCookieListText");
        m19b(jSONObject, jSONObject2, "PCViewCookiesText");
        m19b(jSONObject, jSONObject2, "PCenterBackText");
        m19b(jSONObject, jSONObject2, "PCenterVendorsListText");
        m19b(jSONObject, jSONObject2, "PCIABVendorsText");
        m19b(jSONObject, jSONObject2, "PCenterViewPrivacyPolicyText");
        m19b(jSONObject, jSONObject2, "PCenterClearFiltersText");
        m19b(jSONObject, jSONObject2, "PCenterApplyFiltersText");
        m19b(jSONObject, jSONObject2, "PCenterAllowAllConsentText");
        m19b(jSONObject, jSONObject2, "PCenterRejectAllButtonText");
        m13a(jSONObject, jSONObject2, "PCenterShowRejectAllButton");
        m19b(jSONObject, jSONObject2, "ConfirmText");
        m19b(jSONObject, jSONObject2, "PCenterCookiesListText");
        m19b(jSONObject, jSONObject2, "PCenterCancelFiltersText");
        m13a(jSONObject, jSONObject2, "PCenterEnableAccordion");
        m13a(jSONObject, jSONObject2, "IsIabEnabled");
        m19b(jSONObject, jSONObject2, "PCGrpDescType");
        m19b(jSONObject, jSONObject2, "PCVendorFullLegalText");
        m19b(jSONObject, jSONObject2, "IabType");
        m19b(jSONObject, jSONObject2, "PCenterVendorListDescText");
        m19b(jSONObject, jSONObject2, "PCPrivacyLinkActionAriaLabel");
        m19b(jSONObject, jSONObject2, "PCLogoScreenReader");
        m19b(jSONObject, jSONObject2, "PCDSIDCopyAriaLabel");
        m19b(jSONObject, jSONObject2, "CloseText");
        m19b(jSONObject, jSONObject2, "PCenterVendorListSearch");
        m19b(jSONObject, jSONObject2, "PCenterCookieListSearch");
        m19b(jSONObject, jSONObject2, "PCenterVendorListFilterAria");
        m19b(jSONObject, jSONObject2, "PCenterCookieListFilterAria");
        m19b(jSONObject, jSONObject2, "PCVendorListFilterUnselectedAriaLabel");
        m19b(jSONObject, jSONObject2, "PCVendorListFilterSelectedAriaLabel");
        jSONObject.put("PCenterViewPrivacyPolicyText", jSONObject2.optString("PCenterViewPrivacyPolicyText", ""));
        jSONObject.put("PCenterVendorListLifespan", jSONObject2.optString("PCenterVendorListLifespan", ""));
        jSONObject.put("PCenterVendorListDisclosure", jSONObject2.optString("PCenterVendorListDisclosure", ""));
        jSONObject.put("PCenterVendorListNonCookieUsage", jSONObject2.optString("PCenterVendorListNonCookieUsage", ""));
        jSONObject.put("PCenterVendorListLifespanDay", jSONObject2.optString("PCenterVendorListLifespanDay", ""));
        jSONObject.put("PCenterVendorListLifespanDays", jSONObject2.optString("PCenterVendorListLifespanDays", ""));
        jSONObject.put("PCenterVendorListLifespanMonth", jSONObject2.optString("PCenterVendorListLifespanMonth", ""));
        jSONObject.put("PCenterVendorListLifespanMonths", jSONObject2.optString("PCenterVendorListLifespanMonths", ""));
        jSONObject.put("PCenterVendorListStorageIdentifier", jSONObject2.optString("PCenterVendorListStorageIdentifier", ""));
        jSONObject.put("PCenterVendorListStorageType", jSONObject2.optString("PCenterVendorListStorageType", ""));
        jSONObject.put("PCenterVendorListStorageDomain", jSONObject2.optString("PCenterVendorListStorageDomain", ""));
        jSONObject.put("PCenterVendorListStoragePurposes", jSONObject2.optString("PCenterVendorListStoragePurposes", ""));
        jSONObject.put("useGoogleVendors", jSONObject2.optString("useGoogleVendors", ""));
        jSONObject.put("PCVLSDomainsUsed", jSONObject2.optString("PCVLSDomainsUsed", ""));
        jSONObject.put("PCVLSUse", jSONObject2.optString("PCVLSUse", ""));
    }

    /* JADX INFO: renamed from: a */
    public final void m28a(JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject3, boolean z, JSONObject jSONObject4) throws JSONException {
        if (jSONObject3.has("CustomGroupId")) {
            String string = jSONObject3.getString("CustomGroupId");
            if (C0048h.m305b(string)) {
                return;
            }
            m14a(jSONObject, jSONObject4, jSONObject3, string);
            if (jSONObject3.has("SubGroups")) {
                JSONArray jSONArray3 = jSONObject3.getJSONArray("SubGroups");
                for (int i = 0; i < jSONArray3.length(); i++) {
                    JSONObject jSONObject5 = jSONArray3.getJSONObject(i);
                    if (jSONObject5.has("CustomGroupId")) {
                        m14a(jSONObject, jSONObject4, jSONObject5, jSONObject5.getString("CustomGroupId"));
                    }
                }
            }
            if (z && jSONObject3.optString("Parent").isEmpty() && jSONObject3.getJSONArray("FirstPartyCookies").length() == 0 && !C0048h.m305b(jSONObject3.optString("PurposeId"))) {
                JSONObject jSONObject6 = new JSONObject();
                String strOptString = jSONObject3.optString("PurposeId");
                String str = jSONObject3.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) ? "NO_CHOICE" : new OTPublishersHeadlessSDK(this.f9a).getConsentStatusForGroupId(jSONObject3.optString("CustomGroupId"), jSONObject3.optString("Status")) == 0 ? "NOTGIVEN" : "CONFIRMED";
                if (C0048h.m305b(strOptString)) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject7 = jSONArray.getJSONObject(i2);
                    if (jSONObject7.has("Id") && strOptString.equalsIgnoreCase(jSONObject7.getString("Id"))) {
                        return;
                    }
                }
                if (C0009d.m55a(jSONObject3, this.f16h)) {
                    jSONObject6.put("Id", strOptString);
                    jSONObject6.put("TransactionType", str);
                    if (!jSONObject3.optString("Status").contains(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
                        jSONObject2.put(jSONObject3.optString("PurposeId"), string);
                    }
                    jSONArray.put(jSONObject6);
                    jSONArray2.put(jSONObject6);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m29a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONArray jSONArray) throws JSONException {
        jSONObject.getJSONObject("consentPayload").put("purposes", jSONArray);
        jSONObject2.getJSONObject("consentPayload").put("purposes", jSONArray);
        this.f10b.m271a().edit().putString("OTT_CONSENT_LOG_DATA", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        this.f10b.m271a().edit().putString("OT_CL_DEFAULT_PAYLOAD", !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
        this.f10b.m271a().edit().putString("OTT_INTERNAL_PURPOSE_GROUP_MAP", !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3)).apply();
    }

    /* JADX INFO: renamed from: a */
    public boolean m34a(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(Scopes.PROFILE)) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(Scopes.PROFILE);
        if (!jSONObject2.has(BaseJavaModule.METHOD_TYPE_SYNC)) {
            return false;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject(BaseJavaModule.METHOD_TYPE_SYNC);
        if (jSONObject3.has("shouldShowBannerAsConsentExpired")) {
            return jSONObject3.getBoolean("shouldShowBannerAsConsentExpired");
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final void m37b(JSONArray jSONArray, boolean z, JSONObject jSONObject) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            m26a(jSONArray, jSONObject, i);
        }
        if (z) {
            return;
        }
        this.f10b.m271a().edit().putString("OTT_CONSENT_STATUS", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        String string = this.f10b.m271a().getString("OT_IAB_DEFAULT_AVL", "");
        if (C0048h.m305b(string)) {
            return;
        }
        this.f10b.m271a().edit().putString("OT_IAB_ACTIVE_VENDORLIST", string).apply();
    }

    /* JADX INFO: renamed from: c */
    public void m39c(JSONObject jSONObject) throws JSONException {
        String str;
        C0031z c0031z;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        String str2;
        JSONObject jSONObject3;
        Iterator<String> it2;
        JSONArray jSONArray2;
        C0006b c0006b = this;
        String str3 = "UCPurposesDataHandler";
        String strOptString = "";
        String string = c0006b.f10b.m271a().getString("OT_UC_PURPOSES_UI_SERVER_DATA", "");
        JSONObject jSONObject4 = new JSONObject(c0006b.f10b.m271a().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", ""));
        JSONObject jSONObject5 = new JSONObject(c0006b.f10b.m271a().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", ""));
        JSONObject jSONObject6 = new JSONObject(c0006b.f10b.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", ""));
        JSONObject jSONObject7 = new JSONObject(string);
        if (jSONObject7.has(OTVendorListMode.GENERAL)) {
            JSONObject jSONObject8 = jSONObject7.getJSONObject(OTVendorListMode.GENERAL);
            if (jSONObject8.has("show")) {
                strOptString = jSONObject8.optString("show");
            }
        }
        if (!C0026u.m181a(strOptString, false)) {
            OTLogger.m2743a(3, "OTData", "UCP is not enabled from Admin UI for this app id!");
            return;
        }
        JSONArray jSONArray3 = new JSONArray();
        if (jSONObject.has(Scopes.PROFILE)) {
            JSONObject jSONObject9 = jSONObject.getJSONObject(Scopes.PROFILE);
            if (jSONObject9.has(BaseJavaModule.METHOD_TYPE_SYNC)) {
                JSONObject jSONObject10 = jSONObject9.getJSONObject(BaseJavaModule.METHOD_TYPE_SYNC);
                if (jSONObject10.has("ucpreferences")) {
                    jSONArray3 = jSONObject10.getJSONArray("ucpreferences");
                }
            }
        }
        int i = 0;
        while (i < jSONArray3.length()) {
            JSONObject jSONObject11 = jSONArray3.getJSONObject(i);
            String string2 = jSONObject11.getString("id");
            String string3 = jSONObject11.getString("status");
            JSONArray jSONArray4 = jSONObject11.getJSONArray("topics");
            JSONObject jSONObject12 = jSONObject11.getJSONObject("customPreferences");
            if (jSONObject4.has(string2)) {
                C0031z c0031z2 = new C0031z(c0006b.f9a);
                try {
                    c0031z = c0031z2;
                    jSONObject2 = jSONObject12;
                    jSONArray = jSONArray4;
                    try {
                        C0026u.m185a(string3.equals("ACTIVE"), c0031z2.f63d.optJSONObject(string2), "ACTIVE", "OPT_OUT", c0031z2.f63d, string2);
                        str2 = string2;
                        try {
                            OTLogger.m2743a(3, str3, "Updated purpose object : " + c0031z.f63d.optJSONObject(str2));
                            C0026u.m170a(c0031z.f60a, c0031z.f63d, c0031z.f65f, c0031z.f64e);
                            c0031z.m234b(c0031z.f63d);
                        } catch (JSONException e) {
                            e = e;
                            OTLogger.m2743a(6, str3, "Error in updating consent for purposes :" + e.getMessage());
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        str2 = string2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    c0031z = c0031z2;
                    jSONObject2 = jSONObject12;
                    jSONArray = jSONArray4;
                    str2 = string2;
                }
                JSONArray jSONArrayM235c = c0031z.m235c(str2);
                for (int i2 = 0; i2 < jSONArrayM235c.length(); i2++) {
                    JSONObject jSONObject13 = jSONArrayM235c.getJSONObject(i2);
                    c0031z.m232b(jSONObject13.optString("purposeTopicId"), jSONObject13.optString("id"), false);
                }
                if (jSONArray.length() > 0) {
                    int i3 = 0;
                    while (i3 < jSONArray.length()) {
                        JSONArray jSONArray5 = jSONArray;
                        String strOptString2 = jSONArray5.optString(i3);
                        String str4 = strOptString2 + str2;
                        JSONArray jSONArrayM235c2 = c0031z.m235c(str2);
                        String str5 = str3;
                        for (int i4 = 0; i4 < jSONArrayM235c2.length(); i4++) {
                            if (jSONArrayM235c2.getJSONObject(i4).getString("purposeTopicId").equals(str4) && jSONObject5.has(str4)) {
                                c0031z.m232b(str4, strOptString2, true);
                            }
                        }
                        i3++;
                        jSONArray = jSONArray5;
                        str3 = str5;
                    }
                }
                str = str3;
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayM230b = c0031z.m230b(next);
                        for (int i5 = 0; i5 < jSONArrayM230b.length(); i5++) {
                            JSONObject jSONObject14 = jSONArrayM230b.getJSONObject(i5);
                            c0031z.m223a(jSONObject14.optString("customPreferenceId"), jSONObject14.optString("purposeOptionsId"), false);
                        }
                        JSONArray jSONArrayM220a = c0031z.m220a(str2);
                        int i6 = 0;
                        while (i6 < jSONArrayM220a.length()) {
                            if (jSONArrayM220a.getJSONObject(i6).getString("id").equals(next) && str2.equals(jSONArrayM220a.getJSONObject(i6).getString("purposeId"))) {
                                JSONObject jSONObject15 = jSONObject2;
                                JSONArray jSONArray6 = new JSONArray(jSONObject15.getString(next));
                                it2 = itKeys;
                                if (jSONArray6.length() > 0) {
                                    int i7 = 0;
                                    while (i7 < jSONArray6.length()) {
                                        String strOptString3 = jSONArray6.optString(i7);
                                        JSONArray jSONArray7 = jSONArrayM220a;
                                        JSONArray jSONArrayM230b2 = c0031z.m230b(next);
                                        JSONObject jSONObject16 = jSONObject15;
                                        JSONArray jSONArray8 = jSONArray3;
                                        int i8 = 0;
                                        while (i8 < jSONArrayM230b2.length()) {
                                            String str6 = strOptString3 + str2 + next;
                                            String str7 = strOptString3;
                                            if (jSONArrayM230b2.getJSONObject(i8).getString("purposeOptionsId").equals(str6) && jSONObject6.has(str6)) {
                                                c0031z.m223a(next, str6, true);
                                            }
                                            i8++;
                                            strOptString3 = str7;
                                        }
                                        i7++;
                                        jSONArrayM220a = jSONArray7;
                                        jSONObject15 = jSONObject16;
                                        jSONArray3 = jSONArray8;
                                    }
                                }
                                jSONArray2 = jSONArrayM220a;
                                jSONObject3 = jSONObject15;
                            } else {
                                jSONObject3 = jSONObject2;
                                it2 = itKeys;
                                jSONArray2 = jSONArrayM220a;
                            }
                            i6++;
                            itKeys = it2;
                            jSONArrayM220a = jSONArray2;
                            jSONObject2 = jSONObject3;
                            jSONArray3 = jSONArray3;
                        }
                    }
                }
            } else {
                str = str3;
            }
            i++;
            c0006b = this;
            str3 = str;
            jSONArray3 = jSONArray3;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m36b() {
        String string;
        String string2 = this.f10b.m271a().getString("OTT_CONSENT_STATUS", "");
        String string3 = this.f10b.m271a().getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        String string4 = this.f10b.m271a().getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        try {
            JSONObject jSONObject = new JSONObject();
            if (!C0048h.m305b(string2)) {
                jSONObject = new JSONObject(string2);
            }
            if (!C0048h.m305b(string3)) {
                JSONArray jSONArrayNames = new JSONObject(string3).names();
                if (!C0032d.m239a(jSONArrayNames)) {
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        jSONObject.put(jSONArrayNames.getString(i), 1);
                    }
                }
            }
            new C0010e(this.f9a).m62a(jSONObject);
            if (C0048h.m305b(string4)) {
                return;
            }
            Context context = this.f9a;
            JSONObject jSONObject2 = new JSONObject(string4);
            if (C0032d.m240a(jSONObject2)) {
                return;
            }
            try {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    int i2 = jSONObject2.getInt(next);
                    if (2 == i2) {
                        i2 = 1;
                    }
                    OTLogger.m2743a(4, "OTConsentChanges", "Sending " + next + " broadcast, value = " + i2);
                    Intent intent = new Intent(next);
                    intent.putExtra(OTBroadcastServiceKeys.EVENT_STATUS, i2);
                    intent.setPackage(context.getApplicationContext().getPackageName());
                    context.sendBroadcast(intent);
                }
            } catch (JSONException e) {
                StringBuilder sbAppend = new StringBuilder().append("error in broadcasting SDK status. err = ").append(e.getMessage()).append(" changedConsents = ");
                if (jSONObject2 instanceof JSONObject) {
                    string = JSONObjectInstrumentation.toString(jSONObject2);
                } else {
                    string = jSONObject2.toString();
                }
                OTLogger.m2743a(6, "OTConsentChanges", sbAppend.append(string).toString());
            }
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OTData", "error while broadcasting default consent values : " + e2.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m25a(JSONArray jSONArray, JSONArray jSONArray2, String str) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray3 = jSONArray.getJSONObject(i).getJSONArray("FirstPartyCookies");
            String strOptString = jSONArray.getJSONObject(i).optString("CustomGroupId", "");
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (strOptString.equals(str)) {
                m10a(jSONArray2, jSONArray3);
                if (!jSONObject.has("SubGroups") || jSONObject.optBoolean("ShowSubgroup")) {
                    return;
                }
                for (int i2 = 0; i2 < jSONObject.getJSONArray("SubGroups").length(); i2++) {
                    m10a(jSONArray2, jSONObject.getJSONArray("SubGroups").getJSONObject(i2).getJSONArray("FirstPartyCookies"));
                }
                return;
            }
            if (jSONObject.has("SubGroups") && !C0032d.m239a(jSONObject.getJSONArray("SubGroups"))) {
                for (int i3 = 0; i3 < jSONObject.getJSONArray("SubGroups").length(); i3++) {
                    JSONObject jSONObject2 = jSONObject.getJSONArray("SubGroups").getJSONObject(i3);
                    if (str.equalsIgnoreCase(jSONObject2.optString("CustomGroupId", ""))) {
                        m10a(jSONArray2, jSONObject2.getJSONArray("FirstPartyCookies"));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m10a(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Name", jSONArray2.getJSONObject(i).getString("Name"));
            jSONObject.put("SdkId", jSONArray2.getJSONObject(i).getString("SdkId"));
            jSONObject.put("Description", jSONArray2.getJSONObject(i).getString("Description"));
            jSONArray.put(jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m38b(org.json.JSONObject r7) {
        /*
            r6 = this;
            java.lang.String r0 = "general"
            java.lang.String r1 = "googleAd"
            java.lang.String r2 = "enableConsent"
            java.lang.String r3 = "prompts"
            r4 = 0
            boolean r5 = r7.has(r3)     // Catch: org.json.JSONException -> L2d
            if (r5 == 0) goto L47
            org.json.JSONObject r7 = r7.getJSONObject(r3)     // Catch: org.json.JSONException -> L2d
            boolean r3 = r7.has(r1)     // Catch: org.json.JSONException -> L2d
            if (r3 == 0) goto L28
            org.json.JSONObject r7 = r7.getJSONObject(r1)     // Catch: org.json.JSONException -> L2d
            boolean r1 = r7.has(r0)     // Catch: org.json.JSONException -> L2d
            if (r1 == 0) goto L28
            org.json.JSONObject r7 = r7.getJSONObject(r0)     // Catch: org.json.JSONException -> L2d
            goto L29
        L28:
            r7 = r4
        L29:
            if (r7 == 0) goto L47
            r4 = r7
            goto L47
        L2d:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error in  parse GoogleAddGeneralData , message = "
            r0.<init>(r1)
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r0 = 4
            java.lang.String r1 = "AppDataParser"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r1, r7)
        L47:
            if (r4 == 0) goto L82
            boolean r7 = r4.has(r2)     // Catch: org.json.JSONException -> L68
            if (r7 == 0) goto L82
            boolean r7 = r4.getBoolean(r2)     // Catch: org.json.JSONException -> L68
            if (r7 == 0) goto L82
            android.content.Context r7 = r6.f9a     // Catch: org.json.JSONException -> L68
            boolean r7 = p000a.p001a.p002a.p003a.p004a.C0048h.m310e(r7)     // Catch: org.json.JSONException -> L68
            if (r7 == 0) goto L82
            a.a.a.a.a.c.n r7 = new a.a.a.a.a.c.n     // Catch: org.json.JSONException -> L68
            r7.<init>()     // Catch: org.json.JSONException -> L68
            android.content.Context r0 = r6.f9a     // Catch: org.json.JSONException -> L68
            r7.m111b(r0, r4)     // Catch: org.json.JSONException -> L68
            goto L82
        L68:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error on checking google add consent logging state. Error = "
            r0.<init>(r1)
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r0 = 6
            java.lang.String r1 = "GoogleAdInfo"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r0, r1, r7)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0006b.m38b(org.json.JSONObject):void");
    }

    /* JADX INFO: renamed from: a */
    public static void m13a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (jSONObject2.has(str)) {
            try {
                jSONObject.put(str, jSONObject2.getBoolean(str));
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTData", "Error in appending pc boolean data. key = " + str + "Error message : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m27a(JSONArray jSONArray, boolean z, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(this.f10b.m271a().getString("OTT_CONSENT_STATUS", "{}"));
            if (!z) {
                m22a();
                jSONObject = jSONObject2;
            }
            if (jSONArray.length() > 0) {
                m37b(jSONArray, z, jSONObject);
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "OTData", "error while clearing IAB values on re-consent, err : " + e.getMessage());
        }
        C0021p c0021p = new C0021p(this.f9a);
        OTLogger.m2743a(3, "GoogleVendorHelper", "Resetting user consent on Google vendor list.");
        C0045d c0045d = new C0045d(c0021p.f43a, "OTT_DEFAULT_USER");
        String string = c0045d.m271a().getString("OT_GOOGLE_GVL_COMPLETE_OBJECT", null);
        JSONObject jSONObject3 = new JSONObject();
        if (C0048h.m305b(string)) {
            return;
        }
        try {
            jSONObject3 = new JSONObject(string);
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "GoogleVendorHelper", "Error on parsing google vendors on clearUserConsent, error = " + e2.getMessage());
        }
        c0021p.m115a(c0021p.f43a, c0045d, new JSONObject(), jSONObject3);
    }

    /* JADX INFO: renamed from: a */
    public void m22a() {
        String string;
        String string2 = this.f10b.m271a().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        if (C0048h.m305b(string2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            if (jSONObject.has("purposes")) {
                m9a("purposes", jSONObject);
            }
            if (jSONObject.has("purposeLegitimateInterests")) {
                m9a("purposeLegitimateInterests", jSONObject);
            }
            if (jSONObject.has("special_feature_opt_ins")) {
                m9a("special_feature_opt_ins", jSONObject);
            }
            SharedPreferences.Editor editorEdit = this.f10b.m271a().edit();
            if (jSONObject instanceof JSONObject) {
                string = JSONObjectInstrumentation.toString(jSONObject);
            } else {
                string = jSONObject.toString();
            }
            editorEdit.putString("OTT_IAB_CONSENTABLE_PURPOSES", string).apply();
            OTLogger.m2743a(3, "OTData", "iab related values cleared on auto re-consent");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTData", "Error when setting IAB default values on auto reconsent," + e.toString());
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:4|(3:6|(1:11)(1:10)|12)(1:13)|14|(1:19)(1:18)|20|(2:22|(47:24|(5:433|27|(7:29|30|439|31|(1:33)(1:34)|35|444)(2:39|443)|43|25)|441|44|(4:47|(1:452)(5:448|53|(1:55)(1:56)|57|453)|449|45)|446|58|(1:60)(1:61)|62|(1:64)(1:65)|66|(1:68)(1:69)|70|(1:72)(1:73)|74|(1:76)(1:77)|78|(1:80)(1:81)|82|(8:85|(2:87|(1:92)(5:91|159|160|(4:162|(1:167)(1:166)|168|(2:177|457)(2:176|456))(2:178|455)|179))(1:93)|94|(1:159)(3:96|(1:98)(5:99|SW:100|SW:114|119|(3:121|(2:123|(2:149|(2:154|(1:156))(1:153))(8:127|(1:129)(1:130)|131|(1:133)(1:134)|135|(1:143)(3:138|(1:140)(1:141)|142)|144|(1:148)))(1:157)|158))|159)|160|(0)(0)|179|83)|454|180|(1:182)(1:183)|(1:185)|186|(3:188|(1:190)(1:191)|192)|193|(1:195)(1:196)|197|(1:199)(1:200)|201|(1:203)(1:204)|205|209|(2:211|(10:213|(1:215)(1:216)|217|(1:219)(1:220)|221|(4:224|(7:230|(4:233|(2:235|463)(2:236|(2:242|462)(2:241|464))|243|231)|461|244|(1:246)(1:247)|248|460)(2:249|459)|250|222)|458|251|(1:253)(1:254)|255)(1:256))(0)|257|(2:259|(20:261|(2:264|262)|465|265|(1:267)(1:268)|269|(1:271)(1:272)|273|(9:276|(2:278|(2:280|(7:282|(1:284)|299|301|(4:304|(1:470)(2:308|468)|309|302)|467|310)(1:285))(1:286))(1:287)|288|(2:295|(1:299))(1:300)|301|(1:302)|467|310|274)|466|311|(1:315)|316|(6:318|(1:320)(1:321)|322|(2:324|(6:326|(2:328|(1:332))|333|(1:335)|336|(1:338)))|339|(14:341|(1:343)(1:344)|345|(1:347)(1:348)|349|(4:352|(2:354|(2:356|(2:358|472)(1:475))(1:474))(1:473)|359|350)|471|360|(2:362|(2:364|(1:366)))|367|(3:369|(2:372|370)|476)|373|431|374)(0))|437|378|(1:380)|384|(1:386)(1:387)|388)(1:389))(0)|390|(1:392)(5:393|429|394|(7:396|(1:398)(1:399)|(1:401)|402|(1:404)(1:405)|(1:407)|408)|409)|413|435|414|(1:418)|422|(1:424)(1:425)|426|477)(1:206))(1:207)|208|209|(0)(0)|257|(0)(0)|390|(0)(0)|413|435|414|(2:416|418)|422|(0)(0)|426|477) */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x0dc7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0dc8, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(6, "AppDataParser", "error while formatting groups with err = " + r0.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x09d1  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0b71  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0c76  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0c8b  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0ca9  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0def  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0df4  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m35a(org.json.JSONObject r45, boolean r46) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 3618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0006b.m35a(org.json.JSONObject, boolean):boolean");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m33a(String str, OTCallback oTCallback, OTResponse oTResponse, boolean z) {
        boolean zM35a = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("domain")) {
                String strOptString = jSONObject.getJSONObject("domain").getJSONObject("ruleDetails").optString("type", "");
                C0009d c0009d = this.f17i;
                C0045d c0045d = this.f10b;
                c0009d.getClass();
                c0045d.m271a().edit().putString("OT_TEMPLATE_TYPE", strOptString).apply();
            }
            if (jSONObject.has("culture")) {
                zM35a = m35a(jSONObject, z);
                JSONObject jSONObject2 = jSONObject.getJSONObject("culture");
                if (jSONObject2.has("MobileData")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("MobileData");
                    if (this.f17i.m60b(this.f10b) && !jSONObject3.optJSONObject("ccpaData").optBoolean("computeCCPA")) {
                        new C0011f(this.f9a).m65a("1---");
                    }
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTData", "error in formatting ott data with err = " + e.getMessage());
        }
        return zM35a;
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m21a(List<String> list, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    C0173e.m989a(jSONArray, jSONArray2, i, new JSONObject());
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "OTSDKListFilter", "Error on parsing Categories list. Error msg = " + e.getMessage());
                }
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                if (jSONArray2.getJSONObject(i2).has("CustomGroupId")) {
                    arrayList.add(jSONArray2.getJSONObject(i2).getString("CustomGroupId"));
                }
            }
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "OTData", "error while computing all categories e:" + e2.toString());
        }
        if (list.isEmpty()) {
            list = arrayList;
        }
        JSONArray jSONArray3 = new JSONArray();
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                m25a(jSONArray, jSONArray3, list.get(i3).trim());
            } catch (JSONException e3) {
                OTLogger.m2743a(6, "OTData", "Error on parsing SDK list. Error msg = " + e3.getMessage());
            }
        }
        OTLogger.m2743a(3, "ContentValues", "getSDKList Final: " + jSONArray3);
        return jSONArray3;
    }

    /* JADX INFO: renamed from: a */
    public boolean m31a(SharedPreferences sharedPreferences, JSONObject jSONObject, boolean z, JSONObject jSONObject2, String str) {
        if (str == null) {
            return z;
        }
        String strOptString = jSONObject2.optString(str.toLowerCase(Locale.ROOT));
        OTLogger.m2743a(3, "OTData", "hasGrpConfigChanged: group type - " + strOptString + "group -" + str);
        return (C0048h.m305b(strOptString) || "BRANCH".equalsIgnoreCase(strOptString) || strOptString.equalsIgnoreCase("IAB2_STACK")) ? z : m15a(sharedPreferences, jSONObject, z, str);
    }

    /* JADX INFO: renamed from: a */
    public void m26a(JSONArray jSONArray, JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
        boolean zEquals = jSONObject2.getString("Status").equals("inactive");
        int i2 = !zEquals ? 1 : 0;
        String strOptString = jSONObject2.optString("Parent");
        if (jSONObject2.getBoolean("IsIabPurpose") && jSONObject2.getBoolean("ShowInPopup") && C0009d.m55a(jSONObject2, this.f16h)) {
            jSONObject.put(jSONObject2.optString("CustomGroupId"), i2);
            boolean zM277b = this.f11c.m277b(strOptString);
            if (C0048h.m305b(strOptString) || !zEquals || zM277b || strOptString.startsWith("IABV2") || strOptString.startsWith("ISFV2")) {
                return;
            }
            jSONObject.put(strOptString, i2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(45:0|2|(45:4|(1:6)(1:7)|(1:9)|10|(3:19|20|(0)(2:24|(0)(1:28)))(4:14|(0)(1:18)|20|(1:22))|31|387|32|(11:34|(9:365|36|37|371|38|(2:385|40)(1:44)|45|(7:47|(1:49)(1:51)|52|363|53|(1:55)(1:56)|57)(1:58)|59)(1:65)|66|(1:71)(1:70)|72|73|373|74|(3:76|(1:78)(1:79)|80)|(3:84|(1:86)(1:87)|88)|89)(1:95)|96|100|(1:102)|103|359|104|(1:106)|107|108|(2:397|110)|114|118|(1:120)(1:121)|122|(3:393|124|(1:126))|130|391|131|132|401|133|(2:135|(7:137|(3:139|349|140)(1:141)|142|143|(3:357|145|(3:147|(1:149)|150))|151|(6:153|(4:155|156|356|157)(1:159)|(2:353|161)|377|165|(2:167|(5:169|170|171|(1:173)|174)))(0))(1:186))(0)|193|(1:197)|198|399|199|200|351|201|202|203|204|355|205|(20:207|(1:209)(1:210)|211|248|(3:395|250|(1:252))|256|(2:379|258)|262|(3:362|264|(2:266|(3:268|(1:270)(1:271)|272)(1:273))(1:276))(0)|277|(3:381|279|(1:281))|285|(6:287|(1:289)(1:290)|291|(1:293)(3:294|(0)(1:297)|(3:367|299|(1:301)))|296|(0))(1:305)|306|(1:308)(1:309)|310|(3:389|312|(6:314|(2:316|317)(1:318)|(1:320)|361|321|(6:383|323|328|(3:330|(1:332)(1:333)|334)(1:337)|338|(1:340)(1:341))(5:327|328|(0)(0)|338|(0)(0))))|345|(1:347)|348)(27:212|213|375|214|(2:216|217)(3:218|(3:221|369|219)|403)|222|(1:226)|243|(1:245)(1:246)|247|248|(0)|256|(0)|262|(0)(0)|277|(0)|285|(0)(0)|306|(0)(0)|310|(0)|345|(0)|348))(1:29)|30|31|387|32|(0)(0)|96|100|(0)|103|359|104|(0)|107|108|(0)|114|118|(0)(0)|122|(0)|130|391|131|132|401|133|(0)(0)|193|(2:195|197)|198|399|199|200|351|201|202|203|204|355|205|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x043f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0440, code lost:
    
        com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r6, r5, "Error on parsing preference center data. Error msg = " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x060c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x060d, code lost:
    
        r23 = "OT_ENABLE_MULTI_PROFILE";
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0612, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0613, code lost:
    
        r23 = "OT_ENABLE_MULTI_PROFILE";
        r6 = r18;
        r11 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x06fb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x06fc, code lost:
    
        r43 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0703, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0704, code lost:
    
        r43 = r8;
        r23 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0708, code lost:
    
        r17 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x070b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x070c, code lost:
    
        r43 = r8;
        r23 = r10;
        r17 = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
        r35 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0714, code lost:
    
        r12 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02d5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02d6, code lost:
    
        r41 = "culture";
        r18 = "";
        r37 = "Error on parsing reject all flag. Error = ";
        r44 = "Groups";
        r39 = r23;
        r38 = r24;
        r40 = r26;
        r43 = r27;
        r42 = r28;
        r22 = r12;
        r17 = "Mobile data, override theme = ";
        r16 = "DomainData";
        r15 = "OT_ACTIVE_PROFILE_ID";
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0401 A[Catch: JSONException -> 0x043f, TRY_LEAVE, TryCatch #6 {JSONException -> 0x043f, blocks: (B:104:0x0321, B:106:0x0401, B:108:0x040a, B:114:0x042f, B:113:0x0419, B:110:0x0410), top: B:359:0x0321, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04b8 A[Catch: JSONException -> 0x060c, TryCatch #28 {JSONException -> 0x060c, blocks: (B:133:0x04b2, B:135:0x04b8, B:137:0x04c4), top: B:401:0x04b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0689 A[Catch: JSONException -> 0x06fb, TryCatch #3 {JSONException -> 0x06fb, blocks: (B:205:0x0683, B:207:0x0689, B:209:0x068d, B:210:0x0692, B:212:0x06a0), top: B:355:0x0683 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x06a0 A[Catch: JSONException -> 0x06fb, TRY_LEAVE, TryCatch #3 {JSONException -> 0x06fb, blocks: (B:205:0x0683, B:207:0x0689, B:209:0x068d, B:210:0x0692, B:212:0x06a0), top: B:355:0x0683 }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x092e  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x09ce A[Catch: Exception -> 0x09e0, TryCatch #7 {Exception -> 0x09e0, blocks: (B:321:0x0995, B:323:0x09a1, B:328:0x09c8, B:330:0x09ce, B:332:0x09d2, B:333:0x09d7, B:327:0x09c3, B:326:0x09a8), top: B:361:0x0995, outer: #22, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x09fc  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0a03  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0a04 A[Catch: JSONException -> 0x0a1e, TRY_LEAVE, TryCatch #22 {JSONException -> 0x0a1e, blocks: (B:312:0x0938, B:314:0x0943, B:316:0x0985, B:338:0x09fd, B:341:0x0a04, B:336:0x09e1, B:321:0x0995, B:323:0x09a1, B:328:0x09c8, B:330:0x09ce, B:332:0x09d2, B:333:0x09d7, B:327:0x09c3, B:326:0x09a8), top: B:389:0x0938, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0a86  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0131 A[Catch: Exception -> 0x02d5, TRY_LEAVE, TryCatch #21 {Exception -> 0x02d5, blocks: (B:32:0x0124, B:34:0x0131), top: B:387:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x07c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x08de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0782 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0818 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0938 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0484 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0747 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0410 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ba  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m32a(java.lang.String r46, com.onetrust.otpublishers.headless.Public.OTCallback r47, com.onetrust.otpublishers.headless.Public.Response.OTResponse r48, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK r49, boolean r50) {
        /*
            Method dump skipped, instruction units count: 2707
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0006b.m32a(java.lang.String, com.onetrust.otpublishers.headless.Public.OTCallback, com.onetrust.otpublishers.headless.Public.Response.OTResponse, com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK, boolean):boolean");
    }

    /* JADX INFO: renamed from: a */
    public void m30a(boolean z) {
        OTLogger.m2743a(3, "ContentValues", "saveSyncNotificationShowFlag: " + z);
        this.f10b.m271a().edit().putInt("OT_SHOW_SYNC_NOTIFICATION", z ? 12 : 10).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a A[Catch: Exception -> 0x01a1, TryCatch #2 {Exception -> 0x01a1, blocks: (B:36:0x00fe, B:39:0x010a, B:41:0x011d, B:42:0x0128, B:44:0x013a, B:45:0x013f, B:46:0x018b, B:48:0x0191), top: B:66:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01eb  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m23a(java.lang.String r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0006b.m23a(java.lang.String, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m17a(JSONObject jSONObject, String str, String str2, boolean z) throws JSONException {
        int iM8a = m8a(str2);
        if (!jSONObject.has(str) || iM8a == -1 || iM8a == jSONObject.getInt(str)) {
            return z;
        }
        OTLogger.m2743a(4, "OTData", "Parent status setting to " + iM8a + ", groupID = " + str);
        jSONObject.put(str, iM8a);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m16a(JSONObject jSONObject, String str, String str2, String str3, boolean z) throws JSONException {
        int iM8a = m8a(str2);
        if (iM8a == -1 || iM8a == jSONObject.getInt(str3)) {
            return z;
        }
        OTLogger.m2743a(4, "OTData", "Status setting to " + iM8a + ", groupID = " + str3 + ", purpose id = " + str);
        jSONObject.put(str3, iM8a);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public final void m24a(JSONArray jSONArray, JSONArray jSONArray2, int i) throws JSONException {
        JSONObject jSONObject = jSONArray2.getJSONObject(i);
        if (!jSONObject.has("SubGroups")) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
            if (jSONObject2.getString("Type").equals("COOKIE") && jSONObject2.getString("Parent").isEmpty()) {
                if (jSONObject2.getJSONArray("FirstPartyCookies").length() <= 0) {
                    return;
                }
            } else if (!jSONObject2.getBoolean("IsIabPurpose") || !jSONObject2.getString("Parent").isEmpty() || !jSONObject2.getBoolean("ShowInPopup") || !C0009d.m55a(jSONObject2, this.f16h)) {
                return;
            }
            jSONArray.put(jSONObject2);
            return;
        }
        if (jSONObject.getBoolean("ShowInPopup")) {
            jSONArray.put(jSONObject);
        }
    }
}
