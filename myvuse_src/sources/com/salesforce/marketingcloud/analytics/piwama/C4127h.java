package com.salesforce.marketingcloud.analytics.piwama;

import android.text.TextUtils;
import com.salesforce.marketingcloud.analytics.C4103b;
import com.salesforce.marketingcloud.internal.C4190m;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.h */
/* JADX INFO: loaded from: classes6.dex */
public final class C4127h implements InterfaceC4122c {

    /* JADX INFO: renamed from: a */
    private final Date f4454a;

    /* JADX INFO: renamed from: b */
    private final String f4455b;

    /* JADX INFO: renamed from: c */
    private final String f4456c;

    /* JADX INFO: renamed from: d */
    private final String f4457d;

    /* JADX INFO: renamed from: e */
    private final String f4458e;

    public C4127h(String url, String str, String str2, String str3, Date timestamp) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.f4454a = timestamp;
        this.f4455b = m2959a(url, "url", true);
        this.f4456c = str != null ? m2959a(str, "title", false) : null;
        this.f4457d = str2 != null ? m2959a(str2, "item", false) : null;
        this.f4458e = str3 != null ? m2959a(str3, "search", false) : null;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: a */
    public String mo2954a() {
        return "";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: b */
    public int mo2955b() {
        return C4103b.f4374s;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: c */
    public JSONObject mo2956c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_endpoint", mo2957d());
        jSONObject.put("timestamp", C4190m.m3403a(mo2958e()));
        jSONObject.put("url", this.f4455b);
        if (!TextUtils.isEmpty(this.f4456c)) {
            jSONObject.put("title", this.f4456c);
        }
        if (!TextUtils.isEmpty(this.f4457d)) {
            jSONObject.put("item", this.f4457d);
        }
        if (!TextUtils.isEmpty(this.f4458e)) {
            jSONObject.put("search", this.f4458e);
        }
        return jSONObject;
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: d */
    public String mo2957d() {
        return "track_view";
    }

    @Override // com.salesforce.marketingcloud.analytics.piwama.InterfaceC4122c
    /* JADX INFO: renamed from: e */
    public Date mo2958e() {
        return this.f4454a;
    }

    /* JADX INFO: renamed from: f */
    public final String m2961f() {
        return this.f4457d;
    }

    /* JADX INFO: renamed from: g */
    public final String m2962g() {
        return this.f4458e;
    }

    /* JADX INFO: renamed from: h */
    public final String m2963h() {
        return this.f4456c;
    }

    /* JADX INFO: renamed from: i */
    public final String m2964i() {
        return this.f4455b;
    }
}
