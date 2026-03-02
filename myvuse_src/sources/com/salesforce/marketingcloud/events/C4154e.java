package com.salesforce.marketingcloud.events;

import com.salesforce.marketingcloud.internal.C4190m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.events.e */
/* JADX INFO: loaded from: classes6.dex */
public final class C4154e {

    /* JADX INFO: renamed from: a */
    private final String f4740a;

    /* JADX INFO: renamed from: b */
    private final String f4741b;

    /* JADX INFO: renamed from: c */
    private final String f4742c;

    public C4154e(String id, String str, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f4740a = id;
        this.f4741b = str;
        this.f4742c = type;
    }

    /* JADX INFO: renamed from: a */
    public final String m3146a() {
        return this.f4740a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3147b() {
        return this.f4741b;
    }

    /* JADX INFO: renamed from: c */
    public final String m3148c() {
        return this.f4742c;
    }

    /* JADX INFO: renamed from: d */
    public final String m3149d() {
        return this.f4741b;
    }

    /* JADX INFO: renamed from: e */
    public final String m3150e() {
        return this.f4740a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4154e)) {
            return false;
        }
        C4154e c4154e = (C4154e) obj;
        return Intrinsics.areEqual(this.f4740a, c4154e.f4740a) && Intrinsics.areEqual(this.f4741b, c4154e.f4741b) && Intrinsics.areEqual(this.f4742c, c4154e.f4742c);
    }

    /* JADX INFO: renamed from: f */
    public final String m3151f() {
        return this.f4742c;
    }

    /* JADX INFO: renamed from: g */
    public final JSONObject m3152g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f4740a);
        String str = this.f4741b;
        if (str != null) {
            jSONObject.put("activityInstanceId", str);
        }
        jSONObject.put("type", this.f4742c);
        return jSONObject;
    }

    public int hashCode() {
        int iHashCode = this.f4740a.hashCode() * 31;
        String str = this.f4741b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f4742c.hashCode();
    }

    public String toString() {
        return "Outcome(id=" + this.f4740a + ", activityInstanceId=" + this.f4741b + ", type=" + this.f4742c + ")";
    }

    public /* synthetic */ C4154e(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3);
    }

    /* JADX INFO: renamed from: a */
    public final C4154e m3145a(String id, String str, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new C4154e(id, str, type);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C4154e(JSONObject json) throws JSONException {
        Intrinsics.checkNotNullParameter(json, "json");
        String string = json.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String strOptString = json.optString("activityInstanceId");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        String string2 = json.getString("type");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this(string, strM3408b, string2);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ C4154e m3144a(C4154e c4154e, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c4154e.f4740a;
        }
        if ((i & 2) != 0) {
            str2 = c4154e.f4741b;
        }
        if ((i & 4) != 0) {
            str3 = c4154e.f4742c;
        }
        return c4154e.m3145a(str, str2, str3);
    }
}
