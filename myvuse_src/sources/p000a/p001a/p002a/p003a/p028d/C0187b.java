package p000a.p001a.p002a.p003a.p028d;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0042a;

/* JADX INFO: renamed from: a.a.a.a.d.b */
/* JADX INFO: loaded from: classes.dex */
public class C0187b {

    /* JADX INFO: renamed from: d */
    public static final Integer f1664d = 10;

    /* JADX INFO: renamed from: e */
    public static final Integer f1665e = 30;

    /* JADX INFO: renamed from: a */
    public Context f1666a;

    /* JADX INFO: renamed from: b */
    public Map<String, Integer> f1667b = new HashMap();

    /* JADX INFO: renamed from: c */
    public C0042a f1668c;

    public C0187b(Context context) {
        this.f1668c = new C0042a(context);
        this.f1666a = context;
        m1033b();
    }

    /* JADX INFO: renamed from: a */
    public void m1029a() {
        if (this.f1667b.isEmpty()) {
            m1033b();
        }
        if (this.f1667b.keySet().isEmpty()) {
            return;
        }
        for (String str : this.f1667b.keySet()) {
            if (!C0048h.m305b(str)) {
                this.f1668c.m263a(str);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1031a(JSONObject jSONObject) throws JSONException {
        for (String str : this.f1667b.keySet()) {
            if (!C0048h.m305b(str)) {
                Integer num = this.f1667b.get(str);
                if (f1664d.equals(num) && this.f1668c.f89a.contains(str)) {
                    jSONObject.put(str, this.f1668c.m266b(str));
                }
                if (f1665e.equals(num) && this.f1668c.f89a.contains(str)) {
                    jSONObject.put(str, this.f1668c.m267c(str));
                }
                this.f1668c.m263a(str);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1033b() {
        Map<String, Integer> map = this.f1667b;
        Integer num = f1665e;
        map.put(OTGppKeys.IAB_GPP_HDR_GPP_STRING, num);
        Map<String, Integer> map2 = this.f1667b;
        Integer num2 = f1664d;
        map2.put(OTGppKeys.IAB_GPP_HDR_VERSION, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_HDR_SECTIONS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_GPP_SID, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_TCFEU2_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USP1_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_US_NAT_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_CALIFORNIA_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USVA_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USCO_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USCT_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USUT_STRING, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_CMPSDKID, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_CMPSDKVERSION, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_POLICYVERSION, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_GDPRAPPLIES, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERCC, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PURPOSEONETREATMENT, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_USENONSTANDARDSTACKS, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_VENDORCONSENTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_VENDORLEGITIMATEINTERESTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PURPOSECONSENTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PURPOSELEGITIMATEINTERESTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_SPECIALFEATURESOPTINS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERRESTRICTIONS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERCONSENT, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERLEGITIMATEINTERESTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESCONSENTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_1, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_2, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_3, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_4, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_5, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_6, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_7, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_8, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_9, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_PUBLISHER_RESTRICTION_10, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USP1_VERSION, num2);
        this.f1667b.put(OTGppKeys.IAB_GPP_USP1_NOTICE, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USP1_OPT_OUT, num);
        this.f1667b.put(OTGppKeys.IAB_GPP_USP1_LSPA_COVERED, num);
    }

    /* JADX INFO: renamed from: a */
    public final void m1032a(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            C0042a c0042a = this.f1668c;
            c0042a.f89a.edit().putString(str, jSONObject.optString(str)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1030a(String str, String str2, String str3) {
        OTLogger.m2743a(3, "GppDataStorage", "Saving Gpp data to default Shared Preferences");
        OTLogger.m2743a(3, "OneTrust", "Gpp string: " + str);
        this.f1668c.f89a.edit().putString(OTGppKeys.IAB_GPP_HDR_GPP_STRING, str).apply();
        OTLogger.m2743a(3, "GppDataStorage", "Gpp version: 1");
        this.f1668c.f89a.edit().putInt(OTGppKeys.IAB_GPP_HDR_VERSION, 1).apply();
        OTLogger.m2743a(3, "GppDataStorage", "Gpp Section Ids: " + str2);
        this.f1668c.f89a.edit().putString(OTGppKeys.IAB_GPP_HDR_SECTIONS, str2).apply();
        OTLogger.m2743a(3, "GppDataStorage", "Gpp current region section id: " + str3);
        this.f1668c.f89a.edit().putString(OTGppKeys.IAB_GPP_GPP_SID, str3).apply();
    }
}
