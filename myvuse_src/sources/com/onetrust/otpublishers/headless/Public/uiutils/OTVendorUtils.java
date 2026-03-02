package com.onetrust.otpublishers.headless.Public.uiutils;

import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.p007c.C0017l;
import p000a.p001a.p002a.p003a.p004a.p007c.C0022q;

/* JADX INFO: loaded from: classes6.dex */
public class OTVendorUtils {
    public static final String CONSENT_TYPE = "consent";
    public static final String LEGITIMATE_CONSENT_TYPE = "legIntStatus";

    /* JADX INFO: renamed from: a */
    public ItemListener f4121a;

    /* JADX INFO: renamed from: b */
    public JSONObject f4122b;

    /* JADX INFO: renamed from: c */
    public JSONObject f4123c;

    /* JADX INFO: renamed from: d */
    public JSONObject f4124d;

    /* JADX INFO: renamed from: e */
    public JSONObject f4125e;

    /* JADX INFO: renamed from: f */
    public JSONObject f4126f;

    /* JADX INFO: renamed from: g */
    public JSONObject f4127g;
    public C0017l generalVendorStatus;

    /* JADX INFO: renamed from: h */
    public JSONObject f4128h;

    /* JADX INFO: renamed from: i */
    public JSONObject f4129i;

    public interface ItemListener {
        void onItemClick(String str, boolean z);
    }

    public OTVendorUtils(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.f4122b = new JSONObject();
        this.f4124d = new JSONObject();
        if (jSONObject != null) {
            this.f4122b = jSONObject;
        }
        if (jSONObject2 != null) {
            this.f4124d = jSONObject2;
        }
        if (jSONObject3 != null) {
            this.f4126f = jSONObject3;
            this.generalVendorStatus = new C0017l(jSONObject3);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2778a(JSONObject jSONObject, String str, String str2, String str3, JSONObject jSONObject2, JSONArray jSONArray) throws JSONException {
        if (jSONObject2.getJSONArray(str2).length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).equals(str)) {
                    jSONObject.put(str3, jSONObject2);
                }
            }
        }
    }

    public static JSONObject getVendorsListObject(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? jSONObject.getJSONObject(str) : new JSONObject();
    }

    /* JADX INFO: renamed from: a */
    public final JSONObject m2781a(String str) {
        if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            return this.f4127g;
        }
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            return this.f4128h;
        }
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            return this.f4129i;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m2783a(String str, String str2, boolean z) {
        try {
            JSONObject vendorListWithUserSelection = getVendorListWithUserSelection(str);
            if (vendorListWithUserSelection.has(str2) && z) {
                if (vendorListWithUserSelection.getJSONObject(str2).getInt(LEGITIMATE_CONSENT_TYPE) <= -1) {
                    return false;
                }
            } else if (!vendorListWithUserSelection.has(str2) || z || vendorListWithUserSelection.getJSONObject(str2).getInt(CONSENT_TYPE) <= -1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            OTLogger.m2743a(6, "VendorArray", "unable to get vendor status " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final JSONObject m2784b(String str) {
        JSONObject jSONObjectM2781a = m2781a(str);
        return jSONObjectM2781a == null ? OTVendorListMode.GOOGLE.equalsIgnoreCase(str) ? this.f4124d : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f4122b : OTVendorListMode.GENERAL.equalsIgnoreCase(str) ? this.f4126f : jSONObjectM2781a : jSONObjectM2781a;
    }

    public void clearValues(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.f4122b = jSONObject;
        this.f4123c = null;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        this.f4124d = jSONObject2;
        this.f4125e = null;
        if (this.f4126f == null) {
            this.f4126f = new JSONObject();
            this.generalVendorStatus.f39a = new JSONObject();
        } else {
            this.f4126f = jSONObject3;
            this.generalVendorStatus.f39a = jSONObject3;
        }
        this.generalVendorStatus.f40b = null;
    }

    public JSONObject getVendorListWithUserSelection(String str) {
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            JSONObject jSONObject = this.f4125e;
            return jSONObject == null ? this.f4124d : jSONObject;
        }
        if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            JSONObject jSONObject2 = this.f4123c;
            return jSONObject2 == null ? this.f4122b : jSONObject2;
        }
        C0017l c0017l = this.generalVendorStatus;
        JSONObject jSONObject3 = c0017l.f40b;
        return jSONObject3 == null ? c0017l.f39a : jSONObject3;
    }

    public JSONObject getVendorListWithUserSelectionWithoutFallback(String str) {
        return OTVendorListMode.GOOGLE.equalsIgnoreCase(str) ? this.f4125e : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f4123c : this.generalVendorStatus.f40b;
    }

    public JSONObject getVendorsByPurpose(Map<String, String> map, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strM123b = C0022q.m123b(entry.getKey());
            String value = entry.getValue();
            value.hashCode();
            value.hashCode();
            switch (value) {
                case "IAB2_PURPOSE":
                    str = "purposes";
                    break;
                case "IAB2_SPL_FEATURE":
                    str = "specialFeatures";
                    break;
                case "IAB2_STACK":
                    str = "stacks";
                    break;
                case "IAB2_SPL_PURPOSE":
                    str = "specialPurposes";
                    break;
                case "IAB2_FEATURE":
                    str = "features";
                    break;
                default:
                    str = null;
                    break;
            }
            try {
                m2780a(jSONObject, jSONObject2, strM123b, str);
            } catch (Exception e) {
                OTLogger.m2743a(6, "VendorArray", "Vendors purpose list data error " + e.getMessage());
            }
        }
        return jSONObject2;
    }

    public JSONObject getVendorsListObject(String str) {
        return OTVendorListMode.GOOGLE.equalsIgnoreCase(str) ? this.f4124d : OTVendorListMode.IAB.equalsIgnoreCase(str) ? this.f4122b : this.f4126f;
    }

    public boolean isAllVendorEnabled(JSONObject jSONObject) {
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return false;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            try {
                String string = jSONArrayNames.getString(i);
                if ("0".equalsIgnoreCase(jSONObject.getJSONObject(string).getString(CONSENT_TYPE))) {
                    OTLogger.m2743a(4, "VendorArray", "consent status 0 for vendorID = " + string);
                    return false;
                }
                continue;
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "Vendor list data error " + e.getMessage());
            }
        }
        return true;
    }

    public void refreshList(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str) && (jSONObject2 = this.f4125e) != null) {
            this.f4124d = jSONObject2;
        } else if (!OTVendorListMode.IAB.equalsIgnoreCase(str) || (jSONObject = this.f4123c) == null) {
            this.f4126f = this.generalVendorStatus.f40b;
        } else {
            this.f4122b = jSONObject;
        }
    }

    public void saveVendorConsentStatus(SharedPreferences sharedPreferences, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            sharedPreferences.edit().putString("OT_IAB_ACTIVE_VENDORLIST", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
        }
        if (jSONObject2 != null) {
            sharedPreferences.edit().putString("OT_GOOGLE_ACTIVE_VENDOR_LIST", !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)).apply();
        }
        C0017l c0017l = this.generalVendorStatus;
        c0017l.getClass();
        OTLogger.m2743a(4, "GeneralVendors", "General Vendors saved as " + c0017l.f39a);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        JSONObject jSONObject3 = c0017l.f39a;
        editorEdit.putString("OT_GENERAL_VENDORS", !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3)).apply();
    }

    public void setFilteredList(String str, JSONObject jSONObject, boolean z) {
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            this.f4128h = jSONObject;
        } else if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            this.f4127g = jSONObject;
        } else if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            this.f4129i = jSONObject;
        }
        if (z) {
            updateSelectAllButtonStatus(str);
        }
    }

    public void setSelectAllButtonListener(ItemListener itemListener) {
        this.f4121a = itemListener;
    }

    public void setVendorsListObject(String str, JSONObject jSONObject, boolean z) {
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            this.f4124d = jSONObject;
        } else if (OTVendorListMode.IAB.equalsIgnoreCase(str)) {
            this.f4122b = jSONObject;
        } else {
            this.f4126f = jSONObject;
        }
        if (z) {
            updateSelectAllButtonStatus(str);
        }
    }

    public void updateAllVendorState(boolean z, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayNames;
        if (jSONObject2 == null || (jSONArrayNames = jSONObject2.names()) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            try {
                String string = jSONArrayNames.getString(i);
                if (jSONObject.has(string)) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject(string);
                    updateVendorsConsent(z, str, jSONObject3);
                    jSONObject.put(string, jSONObject3);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "VendorArray", "error in reading string from JSONObject, error = " + e.getMessage());
            }
        }
    }

    public void updateAllVendorsConsentLocal(String str, boolean z) {
        JSONObject jSONObjectM2784b;
        JSONObject jSONObject;
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            jSONObjectM2784b = m2784b(str);
            jSONObject = this.f4124d;
        } else {
            boolean zEqualsIgnoreCase = OTVendorListMode.IAB.equalsIgnoreCase(str);
            jSONObjectM2784b = m2784b(str);
            if (!zEqualsIgnoreCase) {
                updateAllVendorState(z, CONSENT_TYPE, this.generalVendorStatus.f39a, jSONObjectM2784b);
                return;
            }
            jSONObject = this.f4122b;
        }
        updateAllVendorState(z, CONSENT_TYPE, jSONObject, jSONObjectM2784b);
    }

    public void updateSelectAllButtonStatus(String str) {
        JSONObject jSONObjectM2781a = m2781a(str);
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            if (jSONObjectM2781a == null) {
                jSONObjectM2781a = this.f4126f;
            }
        } else if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            if (jSONObjectM2781a == null) {
                jSONObjectM2781a = this.f4124d;
            }
        } else if (jSONObjectM2781a == null) {
            jSONObjectM2781a = this.f4122b;
        }
        ItemListener itemListener = this.f4121a;
        if (itemListener != null) {
            itemListener.onItemClick(str, isAllVendorEnabled(jSONObjectM2781a));
        }
    }

    public void updateVendorConsentStatus(String str, String str2, boolean z) {
        try {
            if (m2783a(str, str2, false)) {
                OTLogger.m2743a(4, "VendorArray", "Vendor (" + str2 + ") consent updated to " + z + ".");
                m2782a(str, CONSENT_TYPE, str2, z);
            } else {
                OTLogger.m2743a(6, "VendorArray", "Not updated consent for Vendor (" + str2 + "), Consent not configured for this vendor Id.");
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VendorArray", "JSON exception on category status map put call. Error msg = " + e.getMessage());
        }
    }

    public void updateVendorLegitInterest(String str, String str2, boolean z) {
        try {
            if (m2783a(str, str2, true)) {
                m2782a(str, LEGITIMATE_CONSENT_TYPE, str2, z);
                OTLogger.m2743a(4, "VendorArray", "Vendor (" + str2 + ")  legit interest updated to " + z + ".");
            } else {
                OTLogger.m2743a(6, "VendorArray", "Not updated LI for Vendor (" + str2 + "), LI not configured for this vendor Id.");
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "VendorArray", "JSON exception on category status map put call. Error msg = " + e.getMessage());
        }
    }

    public void updateVendorsConsent(boolean z, String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt(str) > -1) {
            jSONObject.putOpt(str, z ? "1" : "0");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2780a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(next);
            if (((String) Objects.requireNonNull(str2)).equals("purposes")) {
                m2778a(jSONObject2, str, str2, next, jSONObject3, jSONObject3.getJSONArray("purposes"));
                if (jSONObject3.getJSONArray("legIntPurposes").length() > 0 && jSONObject3.getInt(LEGITIMATE_CONSENT_TYPE) >= 0) {
                    for (int i = 0; i < jSONObject3.getJSONArray("legIntPurposes").length(); i++) {
                        if (jSONObject3.getJSONArray("legIntPurposes").getString(i).equals(str)) {
                            jSONObject2.put(next, jSONObject3);
                        }
                    }
                }
            } else {
                m2778a(jSONObject2, str, str2, next, jSONObject3, jSONObject3.getJSONArray(str2));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2782a(String str, String str2, String str3, boolean z) throws JSONException {
        JSONObject jSONObject;
        JSONObject vendorsListObject = getVendorsListObject(str);
        if (vendorsListObject.has(str3)) {
            JSONObject jSONObject2 = vendorsListObject.getJSONObject(str3);
            jSONObject2.putOpt(str2, z ? "1" : "0");
            vendorsListObject.put(str3, jSONObject2);
        } else {
            OTLogger.m2743a(5, "VendorArray", "update state called for non rendered vendorId.");
        }
        if (OTVendorListMode.GENERAL.equalsIgnoreCase(str)) {
            if (getVendorListWithUserSelectionWithoutFallback(str) == null) {
                C0017l c0017l = this.generalVendorStatus;
                new JSONObject();
                c0017l.f40b = c0017l.f39a;
            }
            this.generalVendorStatus.m104a(str3, z);
            return;
        }
        if (OTVendorListMode.GOOGLE.equalsIgnoreCase(str)) {
            if (getVendorListWithUserSelectionWithoutFallback(str) == null) {
                this.f4125e = this.f4124d;
            }
            jSONObject = this.f4125e;
        } else {
            if (!OTVendorListMode.IAB.equalsIgnoreCase(str)) {
                return;
            }
            if (getVendorListWithUserSelectionWithoutFallback(str) == null) {
                this.f4123c = this.f4122b;
            }
            jSONObject = this.f4123c;
        }
        m2779a(jSONObject, str2, str3, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m2779a(JSONObject jSONObject, String str, String str2, boolean z) throws JSONException {
        if (!jSONObject.has(str2)) {
            OTLogger.m2743a(5, "VendorArray", "update state called for non rendered vendorId.");
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
        jSONObject2.putOpt(str, z ? "1" : "0");
        jSONObject.put(str2, jSONObject2);
    }
}
