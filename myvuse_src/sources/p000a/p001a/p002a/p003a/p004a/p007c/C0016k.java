package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p014b.p021e.C0120n;

/* JADX INFO: renamed from: a.a.a.a.a.c.k */
/* JADX INFO: loaded from: classes.dex */
public class C0016k {

    /* JADX INFO: renamed from: a */
    public String f35a;

    /* JADX INFO: renamed from: b */
    public String f36b;

    /* JADX INFO: renamed from: c */
    public String f37c;

    /* JADX INFO: renamed from: d */
    public Context f38d;

    public C0016k(Context context) {
        this.f38d = context;
    }

    /* JADX INFO: renamed from: a */
    public C0016k m103a() {
        try {
            JSONObject jSONObjectM663a = new C0120n(this.f38d).m663a();
            if (jSONObjectM663a.has("generalVendors")) {
                JSONObject jSONObject = jSONObjectM663a.getJSONObject("generalVendors");
                if (jSONObject.has(OTVendorListMode.GENERAL)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(OTVendorListMode.GENERAL);
                    this.f35a = jSONObject2.optString("text");
                    this.f37c = jSONObject2.optString("vendorListPrivacyPolicyText");
                    this.f36b = jSONObject2.optString("vendorListLabelText");
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "GeneralVendors", "Error while parsing General Vendor labels:" + e);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static void m102a(boolean z, boolean z2, C0046e c0046e) throws JSONException {
        String str;
        StringBuilder sbAppend;
        boolean zM269b = c0046e.f98b.m269b();
        boolean zM270c = c0046e.f98b.m270c();
        if (zM269b && zM270c) {
            JSONObject jSONObjectM268a = c0046e.f98b.m268a();
            new JSONObject();
            JSONArray jSONArrayNames = jSONObjectM268a.names();
            if (C0032d.m239a(jSONArrayNames)) {
                jSONObjectM268a = null;
            } else {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String string = jSONArrayNames.getString(i);
                    if (jSONObjectM268a.has(string)) {
                        try {
                            JSONObject jSONObject = jSONObjectM268a.getJSONObject(string);
                            if (-1 != jSONObject.optInt(OTVendorUtils.CONSENT_TYPE, -1)) {
                                jSONObject.put(OTVendorUtils.CONSENT_TYPE, z ? 1 : 0);
                                OTLogger.m2743a(4, "GeneralVendors", "Consent updated for Vendor: " + string + " as " + z);
                            }
                        } catch (JSONException e) {
                            sbAppend = new StringBuilder("error while updating Vendor status:").append(e);
                            OTLogger.m2743a(6, "GeneralVendors", sbAppend.toString());
                        }
                    } else {
                        sbAppend = new StringBuilder("Given Vendor ID ").append(string).append(" does not match with any existing vendors. Please check and pass the correct Vendor ID");
                    }
                    OTLogger.m2743a(6, "GeneralVendors", sbAppend.toString());
                }
            }
            if (z2) {
                OTLogger.m2743a(4, "GeneralVendors", "General Vendors saved as :" + jSONObjectM268a);
                return;
            } else {
                if (jSONObjectM268a == null) {
                    return;
                }
                c0046e.f98b.f90a.m271a().edit().putString("OT_GENERAL_VENDORS", !(jSONObjectM268a instanceof JSONObject) ? jSONObjectM268a.toString() : JSONObjectInstrumentation.toString(jSONObjectM268a)).apply();
                str = "General Vendors saved as :" + jSONObjectM268a;
            }
        } else {
            if (zM270c) {
                OTLogger.m2743a(3, "GeneralVendors", "General Vendors consent not saved : No Vendors configured");
                return;
            }
            str = "General Vendors consent not saved : Vendor Opt-out disabled from admin settings";
        }
        OTLogger.m2743a(4, "GeneralVendors", str);
    }
}
