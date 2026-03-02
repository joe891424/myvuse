package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.k */
/* JADX INFO: loaded from: classes6.dex */
class C4130k extends AbstractC4129j {
    C4130k(MarketingCloudConfig marketingCloudConfig, C4374j c4374j) {
        super(marketingCloudConfig, c4374j);
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.AbstractC4129j
    /* JADX INFO: renamed from: a */
    JSONObject mo2952a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", this.f4497b.getAppPackageName());
            jSONObject3.put("app_id", this.f4497b.applicationId());
            String strMo3931b = this.f4496a.mo4220c().mo3931b(InterfaceC4340c.f5565g, null);
            if (!TextUtils.isEmpty(strMo3931b)) {
                jSONObject.put("user_id", strMo3931b);
            }
            jSONObject3.put("user_info", jSONObject);
            jSONObject2.put("payload", jSONObject3);
            return jSONObject2;
        } catch (JSONException e) {
            C4170g.m3207b(C4128i.f4464m, e, "Failed to construct PiWama payload JSON Object.", new Object[0]);
            return new JSONObject();
        }
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.AbstractC4129j
    /* JADX INFO: renamed from: b */
    Object[] mo2953b() {
        return new Object[]{"?session_id=" + this.f4496a.mo4220c().mo3931b(InterfaceC4340c.f5564f, "")};
    }
}
