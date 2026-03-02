package p000a.p001a.p002a.p003a.p014b.p021e;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.b.e.n */
/* JADX INFO: loaded from: classes.dex */
public class C0120n {

    /* JADX INFO: renamed from: a */
    public final int f769a;

    /* JADX INFO: renamed from: b */
    public JSONObject f770b;

    /* JADX INFO: renamed from: c */
    public Context f771c;

    public C0120n(Context context) {
        String string;
        this.f771c = context;
        try {
            string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OT_MOBILE_DATA", "");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting mobile data json, err: " + e.getMessage());
        }
        JSONObject jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : new JSONObject();
        this.f770b = jSONObject;
        this.f769a = 22;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m654a(org.json.JSONObject r2, int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r4 = r2.optString(r4)
            java.lang.String r5 = r2.optString(r5)
            r1 = 11
            if (r3 != r1) goto L1a
            boolean r3 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r5)
            if (r3 == 0) goto L18
            goto L20
        L18:
            r4 = r5
            goto L22
        L1a:
            boolean r3 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r4)
            if (r3 == 0) goto L22
        L20:
            java.lang.String r4 = ""
        L22:
            r0.f724c = r4
            a.a.a.a.b.e.i r3 = new a.a.a.a.b.e.i
            r3.<init>()
            boolean r4 = r2.has(r6)
            if (r4 == 0) goto L35
            java.lang.String r2 = r2.getString(r6)
            r3.f751b = r2
        L35:
            r0.f722a = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m654a(org.json.JSONObject, int, java.lang.String, java.lang.String, java.lang.String):a.a.a.a.b.e.b0");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m659c(org.json.JSONObject r5, int r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L18
            java.lang.String r1 = r5.getString(r1)
            java.lang.String r1 = p000a.p001a.p002a.p003a.p014b.p016b.C0074f.m395a(r1)
            r0.f723b = r1
        L18:
            java.lang.String r1 = "titleText"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L27
            java.lang.String r1 = r5.getString(r1)
            r0.f726e = r1
        L27:
            java.lang.String r1 = "titleTextColor"
            java.lang.String r1 = r5.optString(r1)
            java.lang.String r2 = "titleTextColorDark"
            java.lang.String r2 = r5.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r6 != r3) goto L44
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r6 == 0) goto L42
            goto L4a
        L42:
            r1 = r2
            goto L4b
        L44:
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r6 == 0) goto L4b
        L4a:
            r1 = r4
        L4b:
            r0.f724c = r1
            a.a.a.a.b.e.i r6 = new a.a.a.a.b.e.i
            r6.<init>()
            java.lang.String r1 = "titleFontSize"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L61
            java.lang.String r5 = r5.getString(r1)
            r6.f751b = r5
        L61:
            r0.f722a = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m659c(org.json.JSONObject, int):a.a.a.a.b.e.b0");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m660d(org.json.JSONObject r5, int r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r1 = "titleTextColor"
            java.lang.String r1 = r5.optString(r1)
            java.lang.String r2 = "titleTextColorDark"
            java.lang.String r2 = r5.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r6 != r3) goto L22
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r6 == 0) goto L20
            goto L28
        L20:
            r1 = r2
            goto L29
        L22:
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r6 == 0) goto L29
        L28:
            r1 = r4
        L29:
            r0.f724c = r1
            java.lang.String r6 = "titleShow"
            boolean r1 = r5.has(r6)
            if (r1 == 0) goto L3a
            java.lang.String r6 = r5.getString(r6)
            r0.f725d = r6
        L3a:
            a.a.a.a.b.e.i r6 = new a.a.a.a.b.e.i
            r6.<init>()
            java.lang.String r1 = "titleFontSize"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L4e
            java.lang.String r5 = r5.getString(r1)
            r6.f751b = r5
        L4e:
            r0.f722a = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m660d(org.json.JSONObject, int):a.a.a.a.b.e.b0");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0104a0 m661e(org.json.JSONObject r5, int r6) {
        /*
            a.a.a.a.b.e.a0 r0 = new a.a.a.a.b.e.a0
            r0.<init>()
            java.lang.String r1 = "textColor"
            boolean r2 = r5.has(r1)
            r3 = 11
            java.lang.String r4 = ""
            if (r2 == 0) goto L37
            java.lang.String r1 = r5.optString(r1)
            java.lang.String r2 = "textColorDark"
            java.lang.String r2 = r5.optString(r2)
            if (r6 != r3) goto L28
            boolean r1 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r1 == 0) goto L26
            goto L2e
        L26:
            r1 = r2
            goto L2f
        L28:
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r4
        L2f:
            r0.f713b = r1
            r0.f714c = r1
            r0.f715d = r1
            r0.f717f = r1
        L37:
            java.lang.String r1 = "backgroundColorDark"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L5e
            java.lang.String r2 = "backgroundColor"
            java.lang.String r2 = r5.optString(r2)
            java.lang.String r5 = r5.optString(r1)
            if (r6 != r3) goto L54
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r5)
            if (r6 == 0) goto L52
            goto L5c
        L52:
            r4 = r5
            goto L5c
        L54:
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r5 == 0) goto L5b
            goto L5c
        L5b:
            r4 = r2
        L5c:
            r0.f712a = r4
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m661e(org.json.JSONObject, int):a.a.a.a.b.e.a0");
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m663a() {
        return this.f770b.has("preferenceCenterData") ? this.f770b.getJSONObject("preferenceCenterData") : new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01fa  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0123q m664b() {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m664b():a.a.a.a.b.e.q");
    }

    public C0120n(Context context, int i) {
        String string;
        this.f771c = context;
        try {
            string = new C0045d(context, "OTT_DEFAULT_USER").m271a().getString("OT_MOBILE_DATA", "");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting mobile data json, err: " + e.getMessage());
        }
        JSONObject jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : new JSONObject();
        this.f770b = jSONObject;
        this.f769a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m652a(org.json.JSONObject r5, int r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r1 = "alwaysActiveLabelColor"
            java.lang.String r1 = r5.optString(r1)
            java.lang.String r2 = "alwaysActiveLabelColorDark"
            java.lang.String r2 = r5.optString(r2)
            r3 = 11
            java.lang.String r4 = ""
            if (r6 != r3) goto L20
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r6 == 0) goto L1e
            goto L26
        L1e:
            r1 = r2
            goto L27
        L20:
            boolean r6 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r6 == 0) goto L27
        L26:
            r1 = r4
        L27:
            r0.f724c = r1
            java.lang.String r6 = "alwaysActiveLabelText"
            boolean r1 = r5.has(r6)
            if (r1 == 0) goto L37
            java.lang.String r6 = r5.getString(r6)
            r0.f726e = r6
        L37:
            a.a.a.a.b.e.i r6 = new a.a.a.a.b.e.i
            r6.<init>()
            java.lang.String r1 = "alwaysActiveLabelFontSize"
            boolean r2 = r5.has(r1)
            if (r2 == 0) goto L4a
            java.lang.String r5 = r5.getString(r1)
            r6.f751b = r5
        L4a:
            r0.f722a = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m652a(org.json.JSONObject, int):a.a.a.a.b.e.b0");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m655a(org.json.JSONObject r3, org.json.JSONObject r4, int r5, java.lang.String r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r3.has(r1)
            if (r2 == 0) goto L18
            java.lang.String r1 = r3.getString(r1)
            java.lang.String r1 = p000a.p001a.p002a.p003a.p014b.p016b.C0074f.m395a(r1)
            r0.f723b = r1
        L18:
            boolean r1 = r4.has(r6)
            if (r1 == 0) goto L24
            java.lang.String r4 = r4.getString(r6)
            r0.f726e = r4
        L24:
            java.lang.String r4 = "titleTextColor"
            java.lang.String r4 = r3.optString(r4)
            java.lang.String r6 = "titleTextColorDark"
            java.lang.String r6 = r3.optString(r6)
            r1 = 11
            if (r5 != r1) goto L3f
            boolean r4 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r6)
            if (r4 == 0) goto L3d
            goto L45
        L3d:
            r4 = r6
            goto L47
        L3f:
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r4)
            if (r5 == 0) goto L47
        L45:
            java.lang.String r4 = ""
        L47:
            r0.f724c = r4
            a.a.a.a.b.e.i r4 = new a.a.a.a.b.e.i
            r4.<init>()
            java.lang.String r5 = "titleFontSize"
            boolean r6 = r3.has(r5)
            if (r6 == 0) goto L5d
            java.lang.String r3 = r3.getString(r5)
            r4.f751b = r3
        L5d:
            r0.f722a = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m655a(org.json.JSONObject, org.json.JSONObject, int, java.lang.String):a.a.a.a.b.e.b0");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0106b0 m653a(org.json.JSONObject r4, int r5, java.lang.String r6) {
        /*
            a.a.a.a.b.e.b0 r0 = new a.a.a.a.b.e.b0
            r0.<init>()
            java.lang.String r1 = "titleTextAlign"
            boolean r2 = r4.has(r1)
            if (r2 == 0) goto L18
            java.lang.String r1 = r4.getString(r1)
            java.lang.String r1 = p000a.p001a.p002a.p003a.p014b.p016b.C0074f.m395a(r1)
            r0.f723b = r1
        L18:
            r0.f726e = r6
            java.lang.String r6 = "textColor"
            java.lang.String r6 = r4.optString(r6)
            java.lang.String r1 = "textColorDark"
            java.lang.String r1 = r4.optString(r1)
            r2 = 11
            java.lang.String r3 = ""
            if (r5 != r2) goto L37
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r5 == 0) goto L35
            goto L3d
        L35:
            r6 = r1
            goto L3e
        L37:
            boolean r5 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r6)
            if (r5 == 0) goto L3e
        L3d:
            r6 = r3
        L3e:
            r0.f724c = r6
            a.a.a.a.b.e.i r5 = new a.a.a.a.b.e.i
            r5.<init>()
            java.lang.String r6 = "titleFontSize"
            boolean r1 = r4.has(r6)
            if (r1 == 0) goto L54
            java.lang.String r4 = r4.getString(r6)
            r5.f751b = r4
        L54:
            r0.f722a = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m653a(org.json.JSONObject, int, java.lang.String):a.a.a.a.b.e.b0");
    }

    /* JADX INFO: renamed from: a */
    public static C0117k m656a(JSONObject jSONObject, int i, boolean z) {
        C0117k c0117k = new C0117k();
        if (jSONObject.has("url")) {
            c0117k.f756b = jSONObject.getString("url");
        }
        if (jSONObject.has("show")) {
            c0117k.f758d = String.valueOf(jSONObject.getBoolean("show"));
        }
        c0117k.f755a = new C0111e().m627a(jSONObject, i, z, null);
        return c0117k;
    }

    /* JADX INFO: renamed from: a */
    public static C0118l m657a(JSONObject jSONObject) {
        C0118l c0118l = new C0118l();
        if (jSONObject.has("show")) {
            c0118l.f760a = jSONObject.getString("show");
        }
        if (jSONObject.has("url")) {
            c0118l.f761b = jSONObject.getString("url");
        }
        return c0118l;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0128  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0126t m662a(int r22) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m662a(int):a.a.a.a.b.e.t");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static p000a.p001a.p002a.p003a.p014b.p021e.C0109d m658b(org.json.JSONObject r6, int r7) {
        /*
            a.a.a.a.b.e.d r0 = new a.a.a.a.b.e.d
            r0.<init>()
            java.lang.String r1 = "show"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L14
            java.lang.String r1 = r6.getString(r1)
            r0.f743d = r1
        L14:
            java.lang.String r1 = "showText"
            boolean r2 = r6.has(r1)
            if (r2 == 0) goto L23
            java.lang.String r1 = r6.getString(r1)
            r0.f742c = r1
        L23:
            java.lang.String r1 = "textColor"
            java.lang.String r1 = r6.optString(r1)
            java.lang.String r2 = "textColorDark"
            java.lang.String r2 = r6.optString(r2)
            java.lang.String r3 = ""
            r4 = 11
            if (r7 != r4) goto L40
            boolean r1 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r1 == 0) goto L3e
            goto L46
        L3e:
            r1 = r2
            goto L47
        L40:
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r1)
            if (r2 == 0) goto L47
        L46:
            r1 = r3
        L47:
            r0.f740a = r1
            r0.f744e = r1
            a.a.a.a.b.e.c r1 = new a.a.a.a.b.e.c
            r1.<init>()
            java.lang.String r2 = "color"
            java.lang.String r2 = r6.optString(r2)
            java.lang.String r5 = "colorDark"
            java.lang.String r5 = r6.optString(r5)
            if (r7 != r4) goto L67
            boolean r7 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r5)
            if (r7 == 0) goto L65
            goto L6f
        L65:
            r3 = r5
            goto L6f
        L67:
            boolean r7 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r2)
            if (r7 == 0) goto L6e
            goto L6f
        L6e:
            r3 = r2
        L6f:
            r1.f729b = r3
            a.a.a.a.b.e.i r7 = new a.a.a.a.b.e.i
            r7.<init>()
            java.lang.String r2 = "fontSize"
            boolean r3 = r6.has(r2)
            if (r3 == 0) goto L84
            java.lang.String r2 = r6.getString(r2)
            r7.f751b = r2
        L84:
            r1.f728a = r7
            java.lang.String r7 = "borderRadius"
            boolean r2 = r6.has(r7)
            if (r2 == 0) goto L94
            java.lang.String r7 = r6.getString(r7)
            r1.f733f = r7
        L94:
            java.lang.String r7 = "showAsLink"
            boolean r2 = r6.has(r7)
            if (r2 == 0) goto La9
            boolean r7 = r6.getBoolean(r7)
            r7 = r7 ^ 1
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1.f735h = r7
        La9:
            java.lang.String r7 = "text"
            boolean r2 = r6.has(r7)
            if (r2 == 0) goto Lb8
            java.lang.String r6 = r6.getString(r7)
            r1.f734g = r6
        Lb8:
            r0.f745f = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m658b(org.json.JSONObject, int):a.a.a.a.b.e.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019a  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p000a.p001a.p002a.p003a.p014b.p021e.C0132z m665b(int r21) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p014b.p021e.C0120n.m665b(int):a.a.a.a.b.e.z");
    }
}
