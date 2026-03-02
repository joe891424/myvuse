package com.salesforce.marketingcloud.analytics.piwama;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4124e implements InterfaceC4122c {

    /* JADX INFO: renamed from: a */
    private final Date f4447a;

    /* JADX INFO: renamed from: b */
    private final boolean f4448b;

    /* JADX INFO: renamed from: c */
    private final List<String> f4449c;

    public C4124e(Date timestamp, boolean z, List<String> objectIds) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(objectIds, "objectIds");
        this.f4447a = timestamp;
        this.f4448b = z;
        this.f4449c = objectIds;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: a */
    public String mo2954a() {
        return FirebaseAnalytics.Event.APP_OPEN;
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
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("open_from_push", this.f4448b);
        if (!this.f4449c.isEmpty()) {
            jSONObject2.put("message_ids", new JSONArray((Collection) this.f4449c));
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("details", jSONObject2);
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
        return this.f4447a;
    }
}
