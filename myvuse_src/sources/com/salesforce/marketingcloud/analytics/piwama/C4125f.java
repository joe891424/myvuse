package com.salesforce.marketingcloud.analytics.piwama;

import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.analytics.PiCart;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.f */
/* JADX INFO: loaded from: classes6.dex */
public final class C4125f implements InterfaceC4122c {

    /* JADX INFO: renamed from: a */
    private final PiCart f4450a;

    /* JADX INFO: renamed from: b */
    private final Date f4451b;

    public C4125f(PiCart piCart, Date timestamp) {
        Intrinsics.checkNotNullParameter(piCart, "piCart");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.f4450a = piCart;
        this.f4451b = timestamp;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: a */
    public String mo2954a() {
        return "";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: b */
    public int mo2955b() {
        return C4103b.f4373r;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: c */
    public JSONObject mo2956c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        m2960a(jSONObject);
        if (this.f4450a.cartItems().isEmpty()) {
            jSONObject.put("clear_cart", true);
        } else {
            jSONObject.put("cart", this.f4450a.m6556toJson());
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: d */
    public String mo2957d() {
        return "track_cart";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: e */
    public Date mo2958e() {
        return this.f4451b;
    }
}
