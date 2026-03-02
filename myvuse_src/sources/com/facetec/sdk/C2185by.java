package com.facetec.sdk;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facetec.sdk.by */
/* JADX INFO: loaded from: classes3.dex */
final class C2185by {

    /* JADX INFO: renamed from: V */
    static JSONArray f3002V = new JSONArray();

    C2185by() {
    }

    static {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", EnumC2177bq.YOUR_ZOOM_IMAGE_OVERRIDE);
            jSONObject.put("overrideKey", "ac_ryzi");
            jSONObject.put("overrideValue", "cd0681bd-4522-4177-a3c7-1fa93e14734b");
            jSONObject.put("minValue", (Object) null);
            jSONObject.put("maxValue", (Object) null);
            f3002V.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", EnumC2177bq.CLICKABLE_READY_SCREEN_SUBTEXT);
            jSONObject2.put("overrideKey", "ac_crs");
            jSONObject2.put("overrideValue", "6880e254-93ce-11ea-bb37-0242ac130002");
            jSONObject2.put("minValue", (Object) null);
            jSONObject2.put("maxValue", (Object) null);
            f3002V.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", EnumC2177bq.UNCONSTRAINED_GUIDANCE_STRING_LENGTHS);
            jSONObject3.put("overrideKey", "ac_ugsl");
            jSONObject3.put("overrideValue", "235dbd17-7bff-44de-a5ce-e59595d04799");
            jSONObject3.put("minValue", (Object) null);
            jSONObject3.put("maxValue", (Object) null);
            f3002V.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", EnumC2177bq.DEV_MODE_TAG);
            jSONObject4.put("overrideKey", "ac_dmt");
            jSONObject4.put("overrideValue", "44a72141-b436-44f4-b49d-4541445833ce");
            jSONObject4.put("minValue", (Object) null);
            jSONObject4.put("maxValue", (Object) null);
            f3002V.put(jSONObject4);
        } catch (Exception unused) {
        }
    }
}
