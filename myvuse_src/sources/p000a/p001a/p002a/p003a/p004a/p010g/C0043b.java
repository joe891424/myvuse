package p000a.p001a.p002a.p003a.p004a.p010g;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.a.g.b */
/* JADX INFO: loaded from: classes.dex */
public class C0043b {

    /* JADX INFO: renamed from: a */
    public C0045d f90a;

    public C0043b(C0045d c0045d) {
        this.f90a = c0045d;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m268a() {
        String string = this.f90a.m271a().getString("OT_GENERAL_VENDORS", "");
        if (!C0048h.m305b(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                OTLogger.m2743a(3, "GeneralVendors", "Something went wrong while parsing savedGeneral Vendors: " + e);
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: b */
    public boolean m269b() {
        return this.f90a.m271a().getBoolean("OT_GENERAL_VENDORS_CONFIGURED", false);
    }

    /* JADX INFO: renamed from: c */
    public boolean m270c() {
        return this.f90a.m271a().getBoolean("OT_GENERAL_VENDORS_TOGGLE_CONFIGURED", false);
    }
}
