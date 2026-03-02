package p000a.p001a.p002a.p003a.p014b.p025i;

import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;

/* JADX INFO: renamed from: a.a.a.a.b.i.a */
/* JADX INFO: loaded from: classes.dex */
public class C0169a {

    /* JADX INFO: renamed from: a */
    public int f1472a;

    public C0169a(int i) {
        this.f1472a = i;
    }

    /* JADX INFO: renamed from: a */
    public int m949a(String str) {
        if (C0048h.m305b(str)) {
            return 2;
        }
        return Integer.parseInt(str);
    }

    /* JADX INFO: renamed from: a */
    public String m950a(String str, String str2, String str3, String str4) {
        return !C0048h.m305b(str) ? str : !C0048h.m305b(str2) ? str2 : this.f1472a == 11 ? str4 : str3;
    }

    /* JADX INFO: renamed from: a */
    public String m951a(String str, String str2, JSONObject jSONObject) {
        return (str == null || C0048h.m305b(str)) ? jSONObject != null ? jSONObject.optString(str2) : "#E8E8E8" : str;
    }
}
