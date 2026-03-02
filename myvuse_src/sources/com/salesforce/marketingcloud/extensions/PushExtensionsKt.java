package com.salesforce.marketingcloud.extensions;

import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.config.C4143a;
import com.salesforce.marketingcloud.config.C4144b;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001a\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b*\u00020\u0007H\u0007\u001a\u0018\u0010\f\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\r"}, m5598d2 = {"Lorg/json/JSONObject;", "", "name", "getStringOrNull", "", "getIntOrNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "Lorg/json/JSONArray;", "", "toMap", "", "Lcom/salesforce/marketingcloud/config/b;", "toJSONArray", "sdk_release"}, m5599k = 2, m5600mv = {1, 9, 0})
public final class PushExtensionsKt {

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.extensions.PushExtensionsKt$a */
    static final class C4167a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a */
        public static final C4167a f4784a = new C4167a();

        C4167a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "Could not add event to active events map.";
        }
    }

    public static final Integer getIntOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str != null) {
            try {
                return Integer.valueOf(jSONObject.getInt(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static final String getStringOrNull(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (str != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static final JSONArray toJSONArray(Map<String, C4144b> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, C4144b> entry : map.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C4143a.f4654i, entry.getKey());
            String strM3101f = entry.getValue().m3101f();
            if (strM3101f != null) {
                jSONObject.put("path", strM3101f);
            }
            jSONObject.put(C4143a.f4656k, entry.getValue().m3100e());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static final Map<String, String> toMap(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    Object obj = jSONArray.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj;
                    String stringOrNull = getStringOrNull(jSONObject, C4143a.f4653h);
                    if (stringOrNull != null) {
                        String lowerCase = stringOrNull.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        linkedHashMap.put(lowerCase, getStringOrNull(jSONObject, C4143a.f4650e));
                    }
                } catch (Exception e) {
                    C4170g.f4785a.m3226e("~!toMap", e, C4167a.f4784a);
                }
            }
        }
        return linkedHashMap;
    }
}
