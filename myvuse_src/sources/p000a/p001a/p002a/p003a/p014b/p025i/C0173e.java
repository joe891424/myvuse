package p000a.p001a.p002a.p003a.p014b.p025i;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0107c;
import p000a.p001a.p002a.p003a.p014b.p021e.C0128v;
import p000a.p001a.p002a.p003a.p014b.p021e.C0130x;

/* JADX INFO: renamed from: a.a.a.a.b.i.e */
/* JADX INFO: loaded from: classes.dex */
public class C0173e {

    /* JADX INFO: renamed from: a */
    public C0128v f1525a;

    /* JADX INFO: renamed from: b */
    public JSONObject f1526b;

    /* JADX INFO: renamed from: a */
    public static void m989a(JSONArray jSONArray, JSONArray jSONArray2, int i, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
        if (!jSONObject2.has("ShowSDKListLink") || jSONObject2.getBoolean("ShowSDKListLink")) {
            if ((jSONObject2.getString("Type").equals("COOKIE") && jSONObject2.getJSONArray("FirstPartyCookies").length() > 0) || !jSONObject2.optBoolean("ShowSubgroup", false)) {
                String strOptString = jSONObject2.optString("GroupNameMobile");
                if (C0048h.m305b(strOptString)) {
                    strOptString = jSONObject2.optString("GroupName");
                }
                jSONObject.put("GroupName", strOptString);
                jSONObject.put("CustomGroupId", jSONObject2.getString("CustomGroupId"));
                jSONArray2.put(jSONObject);
            }
            if (jSONObject2.has("SubGroups") && jSONObject2.optBoolean("ShowSubgroup", false)) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("SubGroups");
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONArray3.getJSONObject(i2).getString("Type").equals("COOKIE") && jSONArray3.getJSONObject(i2).getJSONArray("FirstPartyCookies").length() > 0) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i2);
                        String strOptString2 = jSONObject4.optString("GroupNameMobile");
                        if (C0048h.m305b(strOptString2)) {
                            strOptString2 = jSONObject4.optString("GroupName");
                        }
                        jSONObject3.put("GroupName", strOptString2);
                        jSONObject3.put("CustomGroupId", jSONArray3.getJSONObject(i2).getString("CustomGroupId"));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public C0128v m990a() {
        return this.f1525a;
    }

    /* JADX INFO: renamed from: b */
    public JSONArray m993b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                m989a(jSONArray, jSONArray2, i, new JSONObject());
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTSDKListFilter", "Error on parsing Categories list. Error msg = " + e.getMessage());
            }
        }
        return jSONArray2;
    }

    /* JADX INFO: renamed from: a */
    public List<String> m991a(JSONArray jSONArray) {
        JSONArray jSONArrayM993b = m993b(jSONArray);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayM993b.length(); i++) {
            try {
                JSONObject jSONObject = jSONArrayM993b.getJSONObject(i);
                if (jSONObject.has("CustomGroupId")) {
                    arrayList.add(jSONObject.getString("CustomGroupId"));
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OTSDKListFilter", "Error on parsing Categories list to get category string list. Error msg = " + e.getMessage());
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public void m992a(Context context, int i, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        try {
            this.f1526b = oTPublishersHeadlessSDK.getPreferenceCenterData();
            C0128v c0128vM674b = new C0130x(context).m674b(i);
            this.f1525a = c0128vM674b;
            String str = c0128vM674b.f857a;
            String strOptString = this.f1526b.optString("PcBackgroundColor");
            String str2 = "#FFFFFF";
            if (C0048h.m305b(str)) {
                str = !C0048h.m305b(strOptString) ? strOptString : i == 11 ? "#2F2F2F" : "#FFFFFF";
            }
            c0128vM674b.f857a = str;
            C0128v c0128v = this.f1525a;
            String str3 = c0128v.f866j;
            String strOptString2 = this.f1526b.optString("PcButtonColor");
            if (C0048h.m305b(str3)) {
                str3 = !C0048h.m305b(strOptString2) ? strOptString2 : i == 11 ? "#80BE5A" : "#6CC04A";
            }
            c0128v.f866j = str3;
            C0106b0 c0106b0 = this.f1525a.f868l;
            String str4 = c0106b0.f724c;
            String strOptString3 = this.f1526b.optString("PcTextColor");
            if (!C0048h.m305b(str4)) {
                str2 = str4;
            } else if (!C0048h.m305b(strOptString3)) {
                str2 = strOptString3;
            } else if (i != 11) {
                str2 = "#696969";
            }
            c0106b0.f724c = str2;
            C0107c c0107c = this.f1525a.f869m;
            c0107c.f734g = this.f1526b.optString("PCenterApplyFiltersText");
            if (C0048h.m305b(c0107c.mo378b())) {
                c0107c.f730c = this.f1526b.optString("PcButtonTextColor");
            }
            if (C0048h.m305b(c0107c.f729b)) {
                c0107c.f729b = this.f1526b.optString("PcButtonColor");
            }
            C0106b0 c0106b02 = this.f1525a.f867k;
            if (C0048h.m305b(c0106b02.f726e)) {
                c0106b02.f726e = this.f1526b.optString("PCenterCancelFiltersText");
            }
            if (C0048h.m305b(c0106b02.f724c)) {
                c0106b02.f724c = this.f1526b.optString("PcTextColor");
            }
            C0106b0 c0106b03 = this.f1525a.f868l;
            if (C0048h.m305b(c0106b03.f724c)) {
                c0106b03.f724c = this.f1526b.optString("PcTextColor");
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OTSDKListFilter", "failed to initialize SDK list filter data, e: " + e);
        }
    }
}
