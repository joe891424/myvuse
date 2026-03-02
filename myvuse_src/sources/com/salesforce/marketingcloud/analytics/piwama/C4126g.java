package com.salesforce.marketingcloud.analytics.piwama;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.analytics.PiOrder;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.g */
/* JADX INFO: loaded from: classes6.dex */
public final class C4126g implements InterfaceC4122c {

    /* JADX INFO: renamed from: a */
    private final PiOrder f4452a;

    /* JADX INFO: renamed from: b */
    private final Date f4453b;

    public C4126g(PiOrder piOrder, Date timestamp) {
        Intrinsics.checkNotNullParameter(piOrder, "piOrder");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.f4452a = piOrder;
        this.f4453b = timestamp;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: a */
    public String mo2954a() {
        return "";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: b */
    public int mo2955b() {
        return C4103b.f4372q;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: c */
    public JSONObject mo2956c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m2960a(jSONObject);
        PiOrder piOrder = this.f4452a;
        jSONObject.put(FirebaseAnalytics.Param.SHIPPING, piOrder.shipping());
        jSONObject.put("order_number", piOrder.orderNumber());
        jSONObject.put(FirebaseAnalytics.Param.DISCOUNT, piOrder.discount());
        jSONObject.put("cart", piOrder.cart().m6556toJson());
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: d */
    public String mo2957d() {
        return "track_conversion";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: e */
    public Date mo2958e() {
        return this.f4453b;
    }
}
