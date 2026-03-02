package p000a.p001a.p002a.p003a.p004a.p008e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.e.c */
/* JADX INFO: loaded from: classes.dex */
public class C0035c {

    /* JADX INFO: renamed from: a */
    public JSONObject f71a = new JSONObject();

    /* JADX INFO: renamed from: b */
    public C0045d f72b;

    /* JADX INFO: renamed from: c */
    public Context f73c;

    public C0035c(Context context) {
        this.f72b = new C0045d(context, "OTT_DEFAULT_USER");
        this.f73c = context;
    }

    /* JADX INFO: renamed from: a */
    public void m242a(String str, String str2) throws JSONException {
        if (C0048h.m305b(str2)) {
            return;
        }
        this.f71a.put(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public void m243a(JSONObject jSONObject, String str, String str2, String str3) {
        String str4;
        m242a("InteractionType", str);
        m242a("Country", str2);
        if (!C0048h.m305b(str3)) {
            JSONObject jSONObject2 = new JSONObject(str3);
            if (jSONObject2.has("InteractionType") || jSONObject2.has("Country")) {
                jSONObject2.remove("InteractionType");
                jSONObject2.remove("Country");
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.f71a.put(next, jSONObject2.get(next));
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "DsDataElementPayload", "Error on merging appendedCustomDSElements. Error msg = " + e.getMessage());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Context context = this.f73c;
        StringBuilder sbAppend = sb.append(context.getApplicationInfo().loadLabel(context.getPackageManager()).toString()).append("/");
        Context context2 = this.f73c;
        try {
            str4 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 1).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            OTLogger.m2743a(6, "DsDataElementPayload", "Error on getting Application versionName. Error msg = " + e2.getMessage());
            str4 = "";
        }
        m242a("UserAgent", sbAppend.append(str4).toString() + " " + System.getProperty("http.agent"));
        jSONObject.put("dsDataElements", this.f71a);
        OTLogger.m2743a(4, "DsDataElementPayload", "DS DataElement Object : " + jSONObject.getJSONObject("dsDataElements"));
    }
}
