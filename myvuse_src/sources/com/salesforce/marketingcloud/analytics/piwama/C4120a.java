package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.storage.C4374j;
import com.salesforce.marketingcloud.storage.InterfaceC4340c;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.a */
/* JADX INFO: loaded from: classes6.dex */
class C4120a extends AbstractC4129j {

    /* JADX INFO: renamed from: v */
    private static final Object[] f4444v = {""};

    C4120a(MarketingCloudConfig marketingCloudConfig, C4374j c4374j) {
        super(marketingCloudConfig, c4374j);
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.AbstractC4129j
    /* JADX INFO: renamed from: a */
    JSONObject mo2952a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("api_key", "849f26e2-2df6-11e4-ab12-14109fdc48df");
            jSONObject2.put("app_id", this.f4497b.applicationId());
            String strMo3931b = this.f4496a.mo4220c().mo3931b(InterfaceC4340c.f5565g, null);
            if (!TextUtils.isEmpty(strMo3931b)) {
                jSONObject2.put("user_id", strMo3931b);
            }
            String strMo3931b2 = this.f4496a.mo4220c().mo3931b(InterfaceC4340c.f5564f, null);
            if (!TextUtils.isEmpty(strMo3931b2)) {
                jSONObject2.put(RemoteDefsKt.PATH_SESSION_ID_KEY, strMo3931b2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", this.f4497b.getAppPackageName());
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
        return f4444v;
    }
}
