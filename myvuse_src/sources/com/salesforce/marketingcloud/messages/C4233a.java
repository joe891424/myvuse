package com.salesforce.marketingcloud.messages;

import com.salesforce.marketingcloud.location.LatLon;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.a */
/* JADX INFO: loaded from: classes6.dex */
public final class C4233a {
    /* JADX INFO: renamed from: a */
    public static final LatLon m3635a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONObject jSONObject2 = jSONObject.getJSONObject("refreshCenter");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(...)");
        return new LatLon(jSONObject2);
    }

    /* JADX INFO: renamed from: b */
    public static final int m3636b(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return jSONObject.getInt("refreshRadius");
    }
}
