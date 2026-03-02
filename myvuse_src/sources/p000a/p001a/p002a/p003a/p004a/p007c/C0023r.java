package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;

/* JADX INFO: renamed from: a.a.a.a.a.c.r */
/* JADX INFO: loaded from: classes.dex */
public class C0023r {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f45a;

    /* JADX INFO: renamed from: b */
    public final Context f46b;

    /* JADX INFO: renamed from: c */
    public final C0046e f47c;

    /* JADX INFO: renamed from: d */
    public final C0045d f48d;

    public C0023r(Context context) {
        this.f46b = context;
        this.f47c = new C0046e(context);
        this.f48d = new C0045d(context, "OTT_DEFAULT_USER");
        this.f45a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /* JADX INFO: renamed from: a */
    public static int m143a(String str, int i, int i2) {
        if (str == null || C0048h.m305b(str) || i <= 0 || i > i2) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(str.charAt(i - 1)));
    }

    /* JADX INFO: renamed from: a */
    public static void m144a(String str, JSONObject jSONObject, int i, int i2, int i3) throws JSONException {
        while (i <= i3) {
            jSONObject.put(String.valueOf(i), m143a(str, i, i2));
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m145a(JSONObject jSONObject, SharedPreferences.Editor editor, String str, String str2) {
        if (jSONObject.has(str)) {
            editor.putString(str2, jSONObject.getString(str));
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m146a(String str, int i, JSONObject jSONObject, int i2, String str2) throws JSONException {
        int iM143a;
        int iOptInt = jSONObject.optInt(str2, -1);
        if (iOptInt < 0 || (iM143a = m143a(str, i2, i)) == iOptInt) {
            return false;
        }
        jSONObject.put(str2, iM143a);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[Catch: Exception -> 0x0057, TryCatch #1 {Exception -> 0x0057, blocks: (B:3:0x000f, B:5:0x001f, B:10:0x0040, B:12:0x0046, B:14:0x004a, B:15:0x004f, B:9:0x003b, B:8:0x0026), top: B:28:0x000f, inners: #0 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m147a() {
        /*
            r6 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "OneTrust"
            java.lang.String r2 = "error while returning culture domain data, err: "
            android.content.Context r3 = r6.f46b
            a.a.a.a.a.g.d r4 = new a.a.a.a.a.g.d
            java.lang.String r5 = "OTT_DEFAULT_USER"
            r4.<init>(r3, r5)
            android.content.SharedPreferences r3 = r4.m271a()     // Catch: java.lang.Exception -> L57
            java.lang.String r4 = "OTT_CULTURE_DOMAIN_DATA"
            java.lang.String r3 = r3.getString(r4, r0)     // Catch: java.lang.Exception -> L57
            boolean r4 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r3)     // Catch: java.lang.Exception -> L57
            if (r4 != 0) goto L3b
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L25 java.lang.Exception -> L57
            r4.<init>(r3)     // Catch: org.json.JSONException -> L25 java.lang.Exception -> L57
            goto L40
        L25:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L57
            r4.<init>(r2)     // Catch: java.lang.Exception -> L57
            java.lang.String r2 = r3.getMessage()     // Catch: java.lang.Exception -> L57
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch: java.lang.Exception -> L57
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L57
            r3 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r1, r2)     // Catch: java.lang.Exception -> L57
        L3b:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L57
            r4.<init>()     // Catch: java.lang.Exception -> L57
        L40:
            int r2 = r4.length()     // Catch: java.lang.Exception -> L57
            if (r2 <= 0) goto L6f
            boolean r2 = r4 instanceof org.json.JSONObject     // Catch: java.lang.Exception -> L57
            if (r2 != 0) goto L4f
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Exception -> L57
            goto L6f
        L4f:
            r2 = r4
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch: java.lang.Exception -> L57
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch: java.lang.Exception -> L57
            goto L6f
        L57:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "empty data as SDK not yet initialized "
            r3.<init>(r4)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r3 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r3, r1, r2)
        L6f:
            boolean r1 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r0)
            if (r1 == 0) goto L76
            return
        L76:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r0)
            a.a.a.a.a.e.d r0 = new a.a.a.a.a.e.d
            android.content.Context r2 = r6.f46b
            r0.<init>(r2)
            boolean r0 = r0.m246a(r1)
            if (r0 == 0) goto L9e
            a.a.a.a.a.c.b r0 = new a.a.a.a.a.c.b
            android.content.Context r2 = r6.f46b
            r0.<init>(r2)
            java.lang.String r2 = "Groups"
            org.json.JSONArray r1 = r1.getJSONArray(r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r3 = 0
            r0.m27a(r1, r3, r2)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0023r.m147a():void");
    }

    /* JADX INFO: renamed from: b */
    public final JSONObject m151b() throws JSONException {
        String string;
        JSONObject jSONObject = new JSONObject();
        C0046e c0046e = this.f47c;
        c0046e.getClass();
        try {
            string = c0046e.f97a.m271a().getString("OT_PROFILE_DATA", "");
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "error while getting profile data json, err: " + e.getMessage());
        }
        JSONObject jSONObject2 = !C0048h.m305b(string) ? new JSONObject(string) : new JSONObject();
        if (!jSONObject2.has(RemoteConfigComponent.FETCH_FILE_NAME)) {
            return jSONObject;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject(RemoteConfigComponent.FETCH_FILE_NAME);
        return jSONObject3.has("syncGroups") ? jSONObject3.getJSONObject("syncGroups") : jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(49:12|(1:14)(1:15)|(1:17)|18|(2:154|19)|(1:21)(1:25)|26|(2:28|(1:30)(1:31))(0)|32|(1:34)(1:35)|36|(1:38)|39|(1:41)|42|(1:44)|45|(1:47)|48|(1:50)|51|(1:53)|54|(1:56)|57|(1:77)(9:61|(1:63)(1:64)|65|(1:67)(1:68)|69|(1:71)|72|(1:74)(1:75)|76)|78|(1:80)|81|(1:83)(1:84)|85|(4:87|(1:89)(1:90)|91|(1:93)(1:94))(1:95)|96|(18:98|(1:100)(1:101)|102|(1:104)|(1:108)(1:109)|110|(8:112|(3:114|(2:117|115)|156)(1:118)|119|(1:121)|122|(1:124)|125|(2:127|(1:129)))(1:130)|131|152|132|(1:134)|135|(1:137)|138|141|(4:143|(1:145)(1:146)|(1:148)|149)|150|151)(1:105)|106|(0)(0)|110|(0)(0)|131|152|132|(0)|135|(0)|138|141|(0)|150|151) */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03e1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03e2, code lost:
    
        r4 = r25;
        com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(6, r4, "Error on saving tcstring created and updated date. Error msg = " + r0.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c0 A[Catch: JSONException -> 0x03e1, TryCatch #0 {JSONException -> 0x03e1, blocks: (B:132:0x03b8, B:134:0x03c0, B:135:0x03cb, B:137:0x03d3), top: B:152:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03d3 A[Catch: JSONException -> 0x03e1, TRY_LEAVE, TryCatch #0 {JSONException -> 0x03e1, blocks: (B:132:0x03b8, B:134:0x03c0, B:135:0x03cb, B:137:0x03d3), top: B:152:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m152c() throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0023r.m152c():void");
    }

    /* JADX INFO: renamed from: a */
    public boolean m150a(String str) {
        if ("IAB2".equalsIgnoreCase(str) && this.f47c.f97a.m271a().getInt("OTT_DATA_SUBJECT_IDENTIFIER_TYPE", 1) == 2) {
            return C0048h.m303a(this.f47c.f97a.m271a().getString("OTT_PROFILE_SYNC_PROFILE_STRING", null), false);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m148a(String str, String str2) throws JSONException {
        int length = !C0048h.m305b(str) ? str.length() : -1;
        int length2 = C0048h.m305b(str2) ? -1 : str2.length();
        JSONObject jSONObjectM291m = this.f47c.m291m();
        if (jSONObjectM291m == null) {
            OTLogger.m2743a(4, "IABTCStringParser", "Empty vendor array, not updating the vendor status. Vendor status will be updated once vendor details fetched.");
            return;
        }
        Iterator<String> itKeys = jSONObjectM291m.keys();
        boolean z = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObject = jSONObjectM291m.getJSONObject(next);
            int i = jSONObject.getInt("id");
            boolean zM146a = m146a(str, length, jSONObject, i, OTVendorUtils.CONSENT_TYPE);
            boolean zM146a2 = m146a(str2, length2, jSONObject, i, OTVendorUtils.LEGITIMATE_CONSENT_TYPE);
            if (zM146a || zM146a2) {
                jSONObjectM291m.put(next, jSONObject);
                z = true;
            }
        }
        if (z) {
            this.f48d.m271a().edit().putString("OT_IAB_ACTIVE_VENDORLIST", !(jSONObjectM291m instanceof JSONObject) ? jSONObjectM291m.toString() : JSONObjectInstrumentation.toString(jSONObjectM291m)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m149a(String str, String str2, String str3) throws JSONException {
        int length = -1;
        int length2 = (str == null || C0048h.m305b(str)) ? -1 : str.length();
        int length3 = (str2 == null || C0048h.m305b(str2)) ? -1 : str2.length();
        if (str3 != null && !C0048h.m305b(str3)) {
            length = str3.length();
        }
        String string = this.f47c.f97a.m271a().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        JSONObject jSONObject = !C0048h.m305b(string) ? new JSONObject(string) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        m144a(str, jSONObject2, 1, length2, 10);
        m144a(str2, jSONObject3, 2, length3, 10);
        m144a(str3, jSONObject4, 1, length, 2);
        jSONObject.put("purposes", jSONObject2);
        jSONObject.put("purposeLegitimateInterests", jSONObject3);
        jSONObject.put("special_feature_opt_ins", jSONObject4);
        this.f48d.m271a().edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
    }
}
