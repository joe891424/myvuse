package com.salesforce.marketingcloud.analytics.piwama;

import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4121b implements InterfaceC4122c {

    /* JADX INFO: renamed from: a */
    private final Date f4445a;

    public C4121b(Date timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.f4445a = timestamp;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: a */
    public String mo2954a() {
        return "app_close";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: b */
    public int mo2955b() {
        return 0;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: c */
    public JSONObject mo2956c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m2960a(jSONObject);
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: d */
    public String mo2957d() {
        return "track_event";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: e */
    public Date mo2958e() {
        return this.f4445a;
    }
}
