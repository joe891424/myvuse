package com.salesforce.marketingcloud.analytics.piwama;

import com.salesforce.marketingcloud.internal.C4190m;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.analytics.piwama.c */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC4122c {
    /* JADX INFO: renamed from: a */
    String mo2954a();

    /* JADX INFO: renamed from: a */
    default void m2960a(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        jSONObject.put("analyticType", mo2955b());
        jSONObject.put("api_endpoint", mo2957d());
        if (mo2954a().length() > 0) {
            jSONObject.put("event_name", mo2954a());
        }
        jSONObject.put("timestamp", C4190m.m3403a(mo2958e()));
    }

    /* JADX INFO: renamed from: b */
    int mo2955b();

    /* JADX INFO: renamed from: c */
    JSONObject mo2956c();

    /* JADX INFO: renamed from: d */
    String mo2957d();

    /* JADX INFO: renamed from: e */
    Date mo2958e();

    /* JADX INFO: renamed from: a */
    default String m2959a(String str, String fieldName, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        String string = StringsKt.trim((CharSequence) str).toString();
        int length = string.length();
        if (length == 0) {
            throw new IllegalArgumentException("PiEvent must contain a " + fieldName + ".");
        }
        if (length <= 1024) {
            return string;
        }
        String strSubstring = string.substring(0, 1024);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.trim((CharSequence) strSubstring).toString();
    }
}
