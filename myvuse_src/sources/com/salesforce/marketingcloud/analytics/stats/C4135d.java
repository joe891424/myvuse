package com.salesforce.marketingcloud.analytics.stats;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.stats.d */
/* JADX INFO: loaded from: classes6.dex */
public class C4135d {

    /* JADX INFO: renamed from: a */
    final JSONObject f4542a;

    private C4135d(String str) throws JSONException {
        this.f4542a = new JSONObject(str);
    }

    /* JADX INFO: renamed from: b */
    static C4135d m3007b(String str, String str2, Date date, String str3, String str4) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3015f(str3);
        c4135d.m3009b(str4);
        return c4135d;
    }

    /* JADX INFO: renamed from: c */
    private void m3011c(String str) throws JSONException {
        this.f4542a.put("buttonId", str);
    }

    /* JADX INFO: renamed from: d */
    private void m3013d(String str) throws JSONException {
        if (str == null) {
            return;
        }
        this.f4542a.put(C4143a.f4650e, str);
    }

    /* JADX INFO: renamed from: e */
    private void m3014e(String str) throws JSONException {
        this.f4542a.put("id", str);
    }

    /* JADX INFO: renamed from: f */
    private void m3015f(String str) throws JSONException {
        this.f4542a.put("messageId", str);
    }

    /* JADX INFO: renamed from: g */
    private void m3016g(String str) throws JSONException {
        this.f4542a.put("name", str);
    }

    /* JADX INFO: renamed from: h */
    private void m3017h(String str) throws JSONException {
        this.f4542a.put("outcomeType", str);
    }

    /* JADX INFO: renamed from: i */
    private void m3018i(String str) throws JSONException {
        this.f4542a.put("triggerId", str);
    }

    /* JADX INFO: renamed from: a */
    public String m3019a() {
        JSONObject jSONObject = this.f4542a;
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    private C4135d(String str, String str2, Date date) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f4542a = jSONObject;
        jSONObject.put("applicationId", str);
        jSONObject.put("deviceId", str2);
        jSONObject.put("eventDateUtc", C4393l.m4336a(date));
    }

    /* JADX INFO: renamed from: a */
    static C4135d m2997a(String str, String str2, Date date, String str3, String str4) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3015f(str3);
        c4135d.m3009b(str4);
        return c4135d;
    }

    /* JADX INFO: renamed from: b */
    private void m3009b(String str) throws JSONException {
        if (str != null) {
            this.f4542a.put("activityInstanceId", str);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3012c(JSONObject jSONObject) throws JSONException {
        this.f4542a.put("metaData", jSONObject);
    }

    /* JADX INFO: renamed from: a */
    public static C4135d m2996a(String str) throws JSONException {
        return new C4135d(str);
    }

    /* JADX INFO: renamed from: b */
    private void m3010b(JSONObject jSONObject) throws JSONException {
        this.f4542a.put("information", jSONObject);
    }

    /* JADX INFO: renamed from: a */
    static C4135d m2998a(String str, String str2, Date date, String str3, String str4, long j, int i, String str5) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3015f(str3);
        c4135d.m3009b(str4);
        c4135d.m3020a(j);
        c4135d.m3004a(i);
        c4135d.m3011c(str5);
        return c4135d;
    }

    /* JADX INFO: renamed from: b */
    private void m3008b() throws JSONException {
        this.f4542a.put("platform", "Android");
    }

    /* JADX INFO: renamed from: a */
    static C4135d m3001a(String str, String str2, Date date, String str3, String str4, JSONObject jSONObject) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3010b(jSONObject);
        c4135d.m3008b();
        if (str3 != null) {
            c4135d.m3015f(str3);
        }
        if (str4 != null) {
            c4135d.m3009b(str4);
        }
        return c4135d;
    }

    /* JADX INFO: renamed from: b */
    void m3021b(int i) throws JSONException {
        this.f4542a.put("timeInApp", i);
    }

    /* JADX INFO: renamed from: a */
    private void m3006a(JSONObject jSONObject) throws JSONException {
        this.f4542a.put(C4352k.a.f5654h, jSONObject);
    }

    /* JADX INFO: renamed from: a */
    private void m3004a(int i) throws JSONException {
        this.f4542a.put("dismissReason", i);
    }

    /* JADX INFO: renamed from: a */
    void m3020a(long j) throws JSONException {
        this.f4542a.put("duration", j);
    }

    /* JADX INFO: renamed from: a */
    private void m3005a(List<String> list) throws JSONException {
        this.f4542a.put("reasons", new JSONArray((Collection) list));
    }

    /* JADX INFO: renamed from: a */
    static C4135d m3003a(String str, String str2, Date date, JSONObject jSONObject) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3010b(jSONObject);
        c4135d.m3008b();
        return c4135d;
    }

    /* JADX INFO: renamed from: a */
    static C4135d m3002a(String str, String str2, Date date, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, String str5) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3014e(str4);
        c4135d.m3016g(str3);
        c4135d.m3006a(jSONObject);
        c4135d.m3012c(jSONObject2);
        c4135d.m3013d(str5);
        return c4135d;
    }

    /* JADX INFO: renamed from: a */
    static C4135d m2999a(String str, String str2, Date date, String str3, String str4, String str5, String str6) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3015f(str3);
        c4135d.m3009b(str4);
        c4135d.m3018i(str5);
        c4135d.m3017h(str6);
        return c4135d;
    }

    /* JADX INFO: renamed from: a */
    static C4135d m3000a(String str, String str2, Date date, String str3, String str4, List<String> list) throws JSONException {
        C4135d c4135d = new C4135d(str, str2, date);
        c4135d.m3015f(str3);
        c4135d.m3009b(str4);
        c4135d.m3005a(list);
        c4135d.m3008b();
        return c4135d;
    }
}
