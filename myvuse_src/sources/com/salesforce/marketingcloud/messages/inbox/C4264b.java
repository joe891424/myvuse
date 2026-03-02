package com.salesforce.marketingcloud.messages.inbox;

import com.salesforce.marketingcloud.internal.C4190m;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.messages.inbox.b */
/* JADX INFO: loaded from: classes6.dex */
public final class C4264b {
    /* JADX INFO: renamed from: a */
    public static final InboxMessage.Media m3800a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String strOptString = jSONObject.optString("androidUrl");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strM3408b = C4190m.m3408b(strOptString);
        String strOptString2 = jSONObject.optString("alt");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strM3408b2 = C4190m.m3408b(strOptString2);
        if (strM3408b == null && strM3408b2 == null) {
            return null;
        }
        if (strM3408b == null) {
            strM3408b = "";
        }
        return new InboxMessage.Media(strM3408b, strM3408b2);
    }

    /* JADX INFO: renamed from: a */
    public static final JSONObject m3801a(InboxMessage.Media media) throws JSONException {
        Intrinsics.checkNotNullParameter(media, "<this>");
        JSONObject jSONObject = new JSONObject();
        if (media.getUrl() != null) {
            jSONObject.put("androidUrl", media.getUrl());
        }
        if (media.getAltText() != null) {
            jSONObject.put("alt", media.getAltText());
        }
        return jSONObject;
    }
}
