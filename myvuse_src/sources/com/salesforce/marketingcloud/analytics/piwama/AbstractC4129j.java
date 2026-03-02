package com.salesforce.marketingcloud.analytics.piwama;

import android.os.Build;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import com.salesforce.marketingcloud.storage.C4374j;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.j */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractC4129j {

    /* JADX INFO: renamed from: c */
    static final String f4477c = "api_key";

    /* JADX INFO: renamed from: d */
    static final String f4478d = "app_id";

    /* JADX INFO: renamed from: e */
    static final String f4479e = "app_name";

    /* JADX INFO: renamed from: f */
    static final String f4480f = "user_info";

    /* JADX INFO: renamed from: g */
    static final String f4481g = "payload";

    /* JADX INFO: renamed from: h */
    static final String f4482h = "849f26e2-2df6-11e4-ab12-14109fdc48df";

    /* JADX INFO: renamed from: i */
    private static final Map<String, String> f4483i = Collections.unmodifiableMap(new a());

    /* JADX INFO: renamed from: j */
    private static final String f4484j = "device";

    /* JADX INFO: renamed from: k */
    private static final String f4485k = "details";

    /* JADX INFO: renamed from: l */
    private static final String f4486l = "manufacturer";

    /* JADX INFO: renamed from: m */
    private static final String f4487m = "device_id";

    /* JADX INFO: renamed from: n */
    private static final String f4488n = "push_enabled";

    /* JADX INFO: renamed from: o */
    private static final String f4489o = "location";

    /* JADX INFO: renamed from: p */
    private static final String f4490p = "latitude";

    /* JADX INFO: renamed from: q */
    private static final String f4491q = "longitude";

    /* JADX INFO: renamed from: r */
    private static final String f4492r = "platform";

    /* JADX INFO: renamed from: s */
    private static final String f4493s = "platform_version";

    /* JADX INFO: renamed from: t */
    private static final String f4494t = "device_type";

    /* JADX INFO: renamed from: u */
    private static final String f4495u = "email";

    /* JADX INFO: renamed from: a */
    final C4374j f4496a;

    /* JADX INFO: renamed from: b */
    final MarketingCloudConfig f4497b;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.j$a */
    class a extends ArrayMap {
        a() {
            put("Content-Type", "application/json; charset=utf-8");
            put(HttpHeaders.CONNECTION, "close");
        }
    }

    AbstractC4129j(MarketingCloudConfig marketingCloudConfig, C4374j c4374j) {
        this.f4497b = marketingCloudConfig;
        this.f4496a = c4374j;
    }

    /* JADX INFO: renamed from: a */
    String m2978a(JSONObject jSONObject, List<C4103b> list) {
        String string;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(f4481g);
        String str = "{}";
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArray = new JSONArray();
            for (C4103b c4103b : list) {
                try {
                    if (c4103b.m2898e() != null) {
                        jSONArray.put(new JSONObject(c4103b.m2898e()));
                    }
                } catch (Exception e) {
                    C4170g.m3207b(C4128i.f4464m, e, "Failed to add the PI AnalyticItem Event to the event list.", new Object[0]);
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    jSONObjectOptJSONObject.put("events", jSONArray);
                    if (jSONObject instanceof JSONObject) {
                        string = JSONObjectInstrumentation.toString(jSONObject);
                    } else {
                        string = jSONObject.toString();
                    }
                    str = string;
                } catch (Exception e2) {
                    C4170g.m3207b(C4128i.f4464m, e2, "Failed to add the PI AnalyticItem Events to the payload.", new Object[0]);
                }
                jSONObjectOptJSONObject.remove("events");
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: a */
    abstract JSONObject mo2952a(JSONObject jSONObject);

    /* JADX INFO: renamed from: b */
    abstract Object[] mo2953b();

    /* JADX INFO: renamed from: a */
    JSONObject m2982a(RegistrationManager registrationManager, PushMessageManager pushMessageManager, RegionMessageManager regionMessageManager, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", registrationManager.getDeviceId());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("email", str);
            }
            jSONObject.put(f4485k, m2981a(pushMessageManager));
            JSONObject jSONObjectM2980a = m2980a(regionMessageManager);
            if (jSONObjectM2980a != null) {
                jSONObject.put("location", jSONObjectM2980a);
            }
            jSONObject.put(f4484j, m2979a());
        } catch (JSONException e) {
            C4170g.m3207b(C4128i.f4464m, e, "Could not create User Info object.", new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    JSONObject m2981a(PushMessageManager pushMessageManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("push_enabled", pushMessageManager.isPushEnabled());
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    JSONObject m2979a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f4486l, Build.MANUFACTURER);
        jSONObject.put("platform", "Android");
        jSONObject.put("platform_version", Build.VERSION.RELEASE);
        jSONObject.put(f4494t, Build.MODEL);
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    JSONObject m2980a(RegionMessageManager regionMessageManager) throws JSONException {
        LatLon latLonMo4112f;
        if ((!regionMessageManager.isGeofenceMessagingEnabled() && !regionMessageManager.isProximityMessagingEnabled()) || (latLonMo4112f = this.f4496a.m4241r().mo4112f(this.f4496a.mo4218b())) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", latLonMo4112f.latitude());
        jSONObject.put("longitude", latLonMo4112f.longitude());
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    C4173b m2977a(RegistrationManager registrationManager, PushMessageManager pushMessageManager, RegionMessageManager regionMessageManager, List<C4103b> list) {
        return EnumC4172a.f4817i.m3254a(this.f4497b, this.f4496a.mo4220c(), mo2953b(), m2978a(mo2952a(m2982a(registrationManager, pushMessageManager, regionMessageManager, list.get(0).m2899f())), list), f4483i);
    }
}
