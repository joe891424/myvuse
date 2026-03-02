package com.salesforce.marketingcloud.analytics.etanalytics;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.alarms.AbstractC4092a;
import com.salesforce.marketingcloud.alarms.C4093b;
import com.salesforce.marketingcloud.analytics.AnalyticsManager;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.analytics.C4104c;
import com.salesforce.marketingcloud.analytics.C4105d;
import com.salesforce.marketingcloud.http.C4173b;
import com.salesforce.marketingcloud.http.C4174c;
import com.salesforce.marketingcloud.http.C4175d;
import com.salesforce.marketingcloud.http.EnumC4172a;
import com.salesforce.marketingcloud.internal.AbstractRunnableC4184g;
import com.salesforce.marketingcloud.internal.C4189l;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.salesforce.marketingcloud.util.C4391j;
import com.salesforce.marketingcloud.util.C4393l;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.c */
/* JADX INFO: loaded from: classes6.dex */
public class C4109c implements C4174c.c, C4093b.b {

    /* JADX INFO: renamed from: d */
    final MarketingCloudConfig f4412d;

    /* JADX INFO: renamed from: e */
    final String f4413e;

    /* JADX INFO: renamed from: f */
    final C4374j f4414f;

    /* JADX INFO: renamed from: g */
    final C4174c f4415g;

    /* JADX INFO: renamed from: h */
    final C4093b f4416h;

    /* JADX INFO: renamed from: i */
    private final C4189l f4417i;

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.etanalytics.c$a */
    class a extends AbstractRunnableC4184g {
        a(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.salesforce.marketingcloud.internal.AbstractRunnableC4184g
        /* JADX INFO: renamed from: a */
        protected void mo2882a() {
            List<C4103b> listMo3988c = C4109c.this.f4414f.m4236m().mo3988c(C4109c.this.f4414f.mo4218b());
            if (listMo3988c.isEmpty()) {
                C4109c.this.f4416h.m2868d(AbstractC4092a.a.f4318c);
                return;
            }
            EnumC4172a enumC4172a = EnumC4172a.f4816h;
            C4109c c4109c = C4109c.this;
            MarketingCloudConfig marketingCloudConfig = c4109c.f4412d;
            InterfaceC4340c interfaceC4340cMo4220c = c4109c.f4414f.mo4220c();
            C4109c c4109c2 = C4109c.this;
            JSONArray jSONArrayM2930a = c4109c2.m2930a(c4109c2.f4412d.applicationId(), C4109c.this.f4413e, listMo3988c);
            C4173b c4173bM3250a = enumC4172a.m3250a(marketingCloudConfig, interfaceC4340cMo4220c, !(jSONArrayM2930a instanceof JSONArray) ? jSONArrayM2930a.toString() : JSONArrayInstrumentation.toString(jSONArrayM2930a));
            c4173bM3250a.m3264a(C4104c.m2905a(listMo3988c));
            C4109c.this.f4415g.m3298a(c4173bM3250a);
        }
    }

    public C4109c(MarketingCloudConfig marketingCloudConfig, String str, C4374j c4374j, C4174c c4174c, C4093b c4093b, C4189l c4189l) {
        this.f4412d = (MarketingCloudConfig) C4391j.m4326a(marketingCloudConfig, "Config is null");
        this.f4413e = (String) C4391j.m4326a(str, "DeviceId is null");
        this.f4414f = (C4374j) C4391j.m4326a(c4374j, "MCStorage is null");
        this.f4415g = (C4174c) C4391j.m4326a(c4174c, "RequestManager is null");
        this.f4416h = (C4093b) C4391j.m4326a(c4093b, "AlarmScheduler is null");
        this.f4417i = c4189l;
        c4174c.m3297a(EnumC4172a.f4816h, this);
        c4093b.m2861a(this, AbstractC4092a.a.f4318c);
    }

    /* JADX INFO: renamed from: a */
    JSONArray m2930a(String str, String str2, List<C4103b> list) {
        JSONArray jSONArray = new JSONArray();
        for (C4103b c4103b : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("etAppId", str);
                jSONObject.put("deviceId", str2);
                jSONObject.put("eventDate", C4393l.m4336a(c4103b.m2891b()));
                jSONObject.put("value", c4103b.m2900g());
                jSONObject.put("analyticTypes", new JSONArray((Collection) Collections.singletonList(Integer.valueOf(c4103b.m2888a()))));
                jSONObject.put("objectIds", new JSONArray((Collection) c4103b.m2902i()));
                String strM2894c = c4103b.m2894c();
                if (!TextUtils.isEmpty(strM2894c)) {
                    JSONObject jSONObject2 = new JSONObject(strM2894c);
                    String strOptString = jSONObject2.optString("requestId");
                    if (!TextUtils.isEmpty(strOptString)) {
                        jSONObject.put("requestId", strOptString);
                    }
                    JSONObject jSONObject3 = jSONObject2.optJSONObject("propertyBag") != null ? jSONObject2.getJSONObject("propertyBag") : new JSONObject();
                    jSONObject3.put("platform", "Android");
                    jSONObject.put("propertyBag", jSONObject3);
                }
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                C4170g.m3207b(AnalyticsManager.TAG, e, "Failed to update EtAnalyticItem or convert it to JSON for transmission.", new Object[0]);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: renamed from: b */
    public void m2933b() {
        this.f4415g.m3296a(EnumC4172a.f4816h);
        C4093b c4093b = this.f4416h;
        AbstractC4092a.a aVar = AbstractC4092a.a.f4318c;
        c4093b.m2868d(aVar);
        this.f4416h.m2869e(aVar);
    }

    @Override // com.salesforce.marketingcloud.alarms.C4093b.b
    /* JADX INFO: renamed from: a */
    public void mo2870a(AbstractC4092a.a aVar) {
        if (aVar == AbstractC4092a.a.f4318c) {
            m2931a();
        }
    }

    @Override // com.salesforce.marketingcloud.http.C4174c.c
    /* JADX INFO: renamed from: a */
    public void mo2932a(C4173b c4173b, C4175d c4175d) {
        if (!c4175d.m3307g()) {
            C4170g.m3210c(AnalyticsManager.TAG, "Request failed: %d - %s", Integer.valueOf(c4175d.m3302b()), c4175d.m3305e());
            this.f4416h.m2865b(AbstractC4092a.a.f4318c);
        } else {
            this.f4416h.m2866c(AbstractC4092a.a.f4318c);
            if (c4173b.m3279q() != null) {
                this.f4417i.m3399b().execute(new C4105d(this.f4414f.m4236m(), C4104c.m2906a(c4173b.m3279q())));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2931a() {
        this.f4417i.m3399b().execute(new a("send_analytics", new Object[0]));
    }
}
