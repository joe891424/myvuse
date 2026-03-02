package p000a.p001a.p002a.p003a.p004a.p007c;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: a.a.a.a.a.c.l */
/* JADX INFO: loaded from: classes.dex */
public class C0017l {

    /* JADX INFO: renamed from: a */
    public JSONObject f39a;

    /* JADX INFO: renamed from: b */
    public JSONObject f40b;

    public C0017l(JSONObject jSONObject) {
        new JSONObject();
        this.f39a = jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public void m104a(String str, boolean z) {
        String str2;
        if (this.f39a.has(str)) {
            try {
                JSONObject jSONObject = this.f39a.getJSONObject(str);
                if (-1 != jSONObject.optInt(OTVendorUtils.CONSENT_TYPE, -1)) {
                    jSONObject.put(OTVendorUtils.CONSENT_TYPE, z ? 1 : 0);
                    OTLogger.m2743a(4, "GeneralVendors", "Consent updated for Vendor: " + str + " as " + z);
                    return;
                }
                return;
            } catch (JSONException e) {
                str2 = "error while updating Vendor status:" + e;
            }
        } else {
            str2 = "Given Vendor ID " + str + " does not match with any existing vendors. Please check and pass the correct Vendor ID";
        }
        OTLogger.m2743a(6, "GeneralVendors", str2);
    }
}
