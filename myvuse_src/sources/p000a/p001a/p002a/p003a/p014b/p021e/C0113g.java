package p000a.p001a.p002a.p003a.p014b.p021e;

import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.e.g */
/* JADX INFO: loaded from: classes.dex */
public class C0113g {
    /* JADX INFO: renamed from: a */
    public String m643a(int i, String str, String str2) {
        return i == 11 ? C0048h.m305b(str2) ? "" : str2 : C0048h.m305b(str) ? "" : str;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m644a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2.has(str2)) {
            return jSONObject2.getJSONObject(str2);
        }
        return null;
    }
}
