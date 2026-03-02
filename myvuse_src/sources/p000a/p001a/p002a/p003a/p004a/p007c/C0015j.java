package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import com.onetrust.otpublishers.headless.Public.uiutils.OTVendorUtils;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p008e.C0036d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.C0046e;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.a.c.j */
/* JADX INFO: loaded from: classes.dex */
public class C0015j {

    /* JADX INFO: renamed from: a */
    public Context f28a;

    /* JADX INFO: renamed from: b */
    public JSONObject f29b = new JSONObject();

    /* JADX INFO: renamed from: c */
    public JSONObject f30c = new JSONObject();

    /* JADX INFO: renamed from: d */
    public SharedPreferences f31d;

    /* JADX INFO: renamed from: e */
    public C0046e f32e;

    /* JADX INFO: renamed from: f */
    public String f33f;

    /* JADX INFO: renamed from: g */
    public C0028w f34g;

    public C0015j(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        this.f28a = context;
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
        }
        this.f31d = z ? sharedPreferencesC0047f : sharedPreferences;
        this.f32e = new C0046e(context);
        this.f34g = new C0028w(context);
    }

    /* JADX INFO: renamed from: a */
    public boolean m94a(JSONObject jSONObject, String str) {
        return !(str.startsWith("IAB") || str.startsWith("ISF")) || jSONObject.has(C0022q.m123b(str));
    }

    /* JADX INFO: renamed from: a */
    public final boolean m95a(boolean z, boolean z2, boolean z3, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has("purposes")) {
            jSONObject2 = jSONObject.getJSONObject("purposes");
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            OTLogger.m2743a(6, "CustomGroupDetails", "No categories found to update");
            return z3;
        }
        int i = 0;
        while (true) {
            boolean z4 = true;
            if (i >= jSONArray.length()) {
                return true;
            }
            String string = jSONArray.getString(i);
            if (m94a(jSONObject2, string)) {
                if (!z2) {
                    z4 = z;
                } else if (this.f32e.m272a(string) != 1) {
                    z4 = false;
                }
                m99b(string, z4);
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: b */
    public int m96b(String str) {
        try {
            return this.f29b.has(str) ? this.f29b.getInt(str) : this.f32e.m272a(str);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "Error while getting updated value of Purpose Consent " + e.getMessage());
            return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m97b() {
        if (this.f31d.getBoolean("OT_HAS_GROUP_CONFIG_CHANGED", false)) {
            this.f31d.edit().putBoolean("OT_HAS_GROUP_CONFIG_CHANGED", false).apply();
        }
    }

    /* JADX INFO: renamed from: c */
    public int m100c(String str) {
        try {
            if (this.f30c.has(str)) {
                return this.f30c.getInt(str);
            }
            return new C0022q(this.f28a).m125a(C0022q.m123b(str), "purposeLegitimateInterests", "active", new C0045d(this.f28a, "OTT_DEFAULT_USER"), false);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "Error while getting updated value of Purpose Legit Interest " + e.getMessage());
            return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m98b(boolean z, boolean z2) throws Throwable {
        String string = this.f31d.getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        this.f31d.getString("OTT_ALWAYS_ACTIVE_GROUPS", "");
        String string2 = this.f31d.getString("OT_INTERNAL_SDK_STATUS_MAP", "");
        if (!this.f31d.contains("OT_GROUP_ID_OBJECT")) {
            C0026u.m178a(this.f32e.m289k(), this.f31d);
        }
        String string3 = this.f31d.getString("OT_GROUP_ID_OBJECT", "");
        try {
            JSONObject jSONObject = new JSONObject();
            if (!C0048h.m305b(string3)) {
                jSONObject = new JSONObject(string3);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!C0048h.m305b(string)) {
                jSONObject2 = new JSONObject(string);
            }
            JSONObject jSONObject3 = jSONObject2;
            boolean zM95a = m95a(z, z2, false, jSONObject.names(), jSONObject3);
            boolean z3 = !"LIActiveIfLegalBasis".equalsIgnoreCase(new C0045d(this.f28a, "OTT_DEFAULT_USER").m271a().getString("OT_SDK_REJECT_ALL_TYPE", "ObjectToLI"));
            m90a(z, z2, z3);
            C0016k.m102a(z, z2, this.f32e);
            m89a(z, z2, jSONObject3, z3);
            if (zM95a && !C0048h.m305b(string2) && string2 != null) {
                JSONObject jSONObject4 = new JSONObject(string2);
                Iterator<String> itKeys = jSONObject4.keys();
                boolean z4 = false;
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (jSONObject4.getInt(next) == 1) {
                        z4 = true;
                    } else if (jSONObject4.getInt(next) == 0) {
                        z4 = false;
                    }
                    if (z2) {
                        m101c(next, z4);
                    } else {
                        m101c(next, z);
                    }
                }
                this.f34g.m194c(string2);
            }
            m88a(z2, true);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "error while fetching all categories" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: c */
    public void m101c(String str, boolean z) {
        C0028w c0028w = this.f34g;
        try {
            JSONObject jSONObject = new JSONObject(c0028w.f51a.getString("OT_INTERNAL_SDK_STATUS_MAP", ""));
            if (!jSONObject.has(str) || 2 == jSONObject.getInt(str)) {
                return;
            }
            c0028w.f53c.put(str, z ? 1 : 0);
            OTLogger.m2743a(4, "SdkListHelper", "Updated SDK status for  - " + str + " To " + c0028w.f53c.get(str));
        } catch (JSONException e) {
            OTLogger.m2743a(6, "SdkListHelper", "Error while updating sdk status " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public String m84a(String str) {
        JSONObject jSONObject = new JSONObject(this.f32e.f97a.m271a().getString("DOMAIN_PARENT_ID_MAP", ""));
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final String m83a() throws JSONException {
        String string = this.f32e.f97a.m271a().getString("OTT_PARENT_CHILD_GROUPS", "");
        String string2 = this.f31d.getString("OTT_CONSENT_STATUS", "");
        String string3 = this.f32e.f97a.m271a().getString("OTT_IAB_CONSENTABLE_PURPOSES", "");
        JSONObject jSONObject = new JSONObject();
        if (!C0048h.m305b(string3)) {
            jSONObject = new JSONObject(string3).getJSONObject("purposes");
        }
        JSONObject jSONObject2 = new JSONObject(string);
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArray = jSONObject2.getJSONArray(next);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string4 = jSONArray.getString(i);
                if (this.f32e.m275a(string4, string2) && m94a(jSONObject, string4)) {
                    jSONArray2.put(string4);
                }
            }
            jSONObject3.put(next, jSONArray2);
        }
        return !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3);
    }

    /* JADX INFO: renamed from: a */
    public final void m90a(boolean z, boolean z2, boolean z3) {
        String string;
        if (!this.f32e.m293o() || z2) {
            return;
        }
        if (z || z3) {
            SharedPreferences sharedPreferences = this.f31d;
            JSONObject jSONObjectM273a = this.f32e.m273a();
            if (jSONObjectM273a != null) {
                try {
                    C0021p.m112a(new JSONObject(), jSONObjectM273a, z ? "1" : "0");
                    if (jSONObjectM273a instanceof JSONObject) {
                        JSONObject jSONObject = jSONObjectM273a;
                        string = JSONObjectInstrumentation.toString(jSONObjectM273a);
                    } else {
                        string = jSONObjectM273a.toString();
                    }
                    sharedPreferences.edit().putString("OT_GOOGLE_ACTIVE_VENDOR_LIST", string).apply();
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "GoogleVendorHelper", "Error in updating google vendor status. Error message : " + e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m99b(String str, boolean z) {
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        String str2;
        Context context = this.f28a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        JSONObject jSONObject = null;
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z2 = true;
        } else {
            z2 = false;
            sharedPreferencesC0047f = null;
        }
        if (z2) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        String string = sharedPreferences.getString("OTT_CONSENT_STATUS", "");
        if (string != null && !C0048h.m305b(string)) {
            Locale locale = Locale.ENGLISH;
            String lowerCase = str.toLowerCase(locale);
            try {
                JSONObject jSONObject2 = new JSONObject(string.toLowerCase(locale));
                try {
                    if (jSONObject2.has(lowerCase)) {
                        return m93a(str, z);
                    }
                } catch (JSONException unused) {
                    jSONObject = jSONObject2;
                    str2 = "error in json parsing for customGroup Value = " + jSONObject;
                    OTLogger.m2743a(4, "OTSPUtils", str2);
                }
            } catch (JSONException unused2) {
            }
            OTLogger.m2743a(4, "CustomGroupDetails", "Group ID doesn't exist/not allowed to update status for " + str + " groupId.");
            return false;
        }
        str2 = "customGroup Value not set.";
        OTLogger.m2743a(4, "OTSPUtils", str2);
        OTLogger.m2743a(4, "CustomGroupDetails", "Group ID doesn't exist/not allowed to update status for " + str + " groupId.");
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m89a(boolean z, boolean z2, JSONObject jSONObject, boolean z3) throws Throwable {
        String str;
        boolean z4;
        boolean z5;
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z6;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        boolean z7;
        SharedPreferencesC0047f sharedPreferencesC0047f3;
        String str2;
        if (jSONObject.length() > 0) {
            JSONArray jSONArrayNames = jSONObject.getJSONObject("purposes").names();
            JSONArray jSONArrayNames2 = jSONObject.getJSONObject("special_feature_opt_ins").names();
            JSONArray jSONArrayNames3 = jSONObject.getJSONObject("stacks").names();
            String str3 = "purposeLegitimateInterests";
            JSONArray jSONArrayNames4 = jSONObject.getJSONObject("purposeLegitimateInterests").names();
            Context context = this.f28a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            Boolean bool = Boolean.FALSE;
            if (C0026u.m181a(sharedPreferences2.getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
                sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z6 = true;
            } else {
                z6 = false;
                sharedPreferencesC0047f2 = null;
            }
            if (z6) {
                sharedPreferences = sharedPreferencesC0047f2;
            }
            String string = sharedPreferences.getString("OT_IAB_ACTIVE_VENDORLIST", "");
            OTLogger.m2743a(3, "IABHelper", !C0048h.m305b(string) ? "Saved IAB Active Vendor List : " + string : "Vendor List is empty");
            JSONObject jSONObject2 = C0048h.m305b(string) ? new JSONObject() : new JSONObject(string);
            if (z2) {
                str = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
            } else {
                Context context2 = this.f28a;
                SharedPreferences sharedPreferences3 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                str = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
                if (C0026u.m181a(context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0).getString("OT_ENABLE_MULTI_PROFILE", bool.toString()), false)) {
                    sharedPreferencesC0047f3 = new SharedPreferencesC0047f(context2, sharedPreferences3, sharedPreferences3.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z7 = true;
                } else {
                    z7 = false;
                    sharedPreferencesC0047f3 = null;
                }
                if (z7) {
                    sharedPreferences3 = sharedPreferencesC0047f3;
                }
                if (sharedPreferences3.getBoolean("IS_IAB2_TEMPLATE", false)) {
                    if (jSONArrayNames != null && jSONArrayNames.length() > 0) {
                        for (int i = 0; i < jSONArrayNames.length(); i++) {
                            jSONObject.getJSONObject("purposes").put(jSONArrayNames.getString(i), z ? 1 : 0);
                        }
                    }
                    if (jSONArrayNames2 != null && jSONArrayNames2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArrayNames2.length(); i2++) {
                            jSONObject.getJSONObject("special_feature_opt_ins").put(jSONArrayNames2.getString(i2), z ? 1 : 0);
                        }
                    }
                    if (jSONArrayNames3 != null && jSONArrayNames3.length() > 0) {
                        for (int i3 = 0; i3 < jSONArrayNames3.length(); i3++) {
                            jSONObject.getJSONObject("stacks").put(jSONArrayNames3.getString(i3), z ? 1 : 0);
                        }
                    }
                    OTLogger.m2743a(3, "RejectAllFlow", "Is interaction type reject all = " + (!z) + " , reject all type isRejectObjectToLI = " + z3);
                    if (z || z3) {
                        if (jSONArrayNames4 != null && jSONArrayNames4.length() > 0) {
                            int i4 = 0;
                            while (i4 < jSONArrayNames4.length()) {
                                JSONArray jSONArray = jSONArrayNames4;
                                if ("1".equals(jSONArray.getString(i4))) {
                                    str2 = str3;
                                } else {
                                    str2 = str3;
                                    jSONObject.getJSONObject(str2).put(jSONArray.getString(i4), z ? 1 : 0);
                                }
                                i4++;
                                jSONArrayNames4 = jSONArray;
                                str3 = str2;
                            }
                        }
                        for (int i5 = 0; i5 < jSONObject2.length(); i5++) {
                            JSONArray jSONArrayNames5 = jSONObject2.names();
                            if (jSONArrayNames5 != null) {
                                if (jSONObject2.getJSONObject(jSONArrayNames5.get(i5).toString()).getInt(OTVendorUtils.CONSENT_TYPE) >= 0) {
                                    jSONObject2.getJSONObject(jSONArrayNames5.get(i5).toString()).put(OTVendorUtils.CONSENT_TYPE, z ? 1 : 0);
                                }
                                if (jSONObject2.getJSONObject(jSONArrayNames5.get(i5).toString()).getInt(OTVendorUtils.LEGITIMATE_CONSENT_TYPE) >= 0) {
                                    jSONObject2.getJSONObject(jSONArrayNames5.get(i5).toString()).put(OTVendorUtils.LEGITIMATE_CONSENT_TYPE, z ? 1 : 0);
                                }
                            }
                        }
                    }
                }
            }
            z4 = true;
            m86a(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), jSONObject2, true);
        } else {
            str = "com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER";
            z4 = true;
        }
        Context context3 = this.f28a;
        String str4 = str;
        SharedPreferences sharedPreferences4 = context3.getSharedPreferences(str4, 0);
        if (C0026u.m181a(context3.getSharedPreferences(str4, 0).getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            z5 = z4;
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context3, sharedPreferences4, sharedPreferences4.getString("OT_ACTIVE_PROFILE_ID", ""));
        } else {
            z5 = false;
            sharedPreferencesC0047f = null;
        }
        if (z5) {
            sharedPreferences4 = sharedPreferencesC0047f;
        }
        if (sharedPreferences4.getBoolean("IS_IAB2_TEMPLATE", false)) {
            return;
        }
        m87a(false);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m91a(C0036d c0036d) {
        try {
            return c0036d.m246a(this.f32e.m280d());
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "error while getting old consent " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03be A[Catch: JSONException -> 0x040a, TryCatch #10 {JSONException -> 0x040a, blocks: (B:140:0x03ac, B:156:0x03ec, B:158:0x03f6, B:160:0x0402, B:159:0x03fb, B:143:0x03be, B:145:0x03c4, B:147:0x03ca, B:150:0x03d5, B:152:0x03db, B:154:0x03e5, B:155:0x03e9), top: B:226:0x03ac }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03f6 A[Catch: JSONException -> 0x040a, TryCatch #10 {JSONException -> 0x040a, blocks: (B:140:0x03ac, B:156:0x03ec, B:158:0x03f6, B:160:0x0402, B:159:0x03fb, B:143:0x03be, B:145:0x03c4, B:147:0x03ca, B:150:0x03d5, B:152:0x03db, B:154:0x03e5, B:155:0x03e9), top: B:226:0x03ac }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03fb A[Catch: JSONException -> 0x040a, TryCatch #10 {JSONException -> 0x040a, blocks: (B:140:0x03ac, B:156:0x03ec, B:158:0x03f6, B:160:0x0402, B:159:0x03fb, B:143:0x03be, B:145:0x03c4, B:147:0x03ca, B:150:0x03d5, B:152:0x03db, B:154:0x03e5, B:155:0x03e9), top: B:226:0x03ac }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04d2 A[Catch: JSONException -> 0x04f0, TryCatch #13 {JSONException -> 0x04f0, blocks: (B:171:0x04c5, B:173:0x04d2, B:175:0x04d8, B:177:0x04e2, B:179:0x04e8), top: B:232:0x04c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0522 A[Catch: Exception -> 0x0551, TRY_LEAVE, TryCatch #5 {Exception -> 0x0551, blocks: (B:185:0x050e, B:188:0x051e, B:189:0x0522, B:191:0x052c), top: B:216:0x050e }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0232  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m88a(boolean r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 1440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0015j.m88a(boolean, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    public final void m86a(String str, JSONObject jSONObject, boolean z) throws Throwable {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z2;
        SharedPreferencesC0047f sharedPreferencesC0047f2;
        boolean z3;
        JSONObject jSONObject2 = null;
        if (z) {
            OTLogger.m2743a(4, "CustomGroupDetails", "updated IAB user choices" + str);
            this.f31d.edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", str).apply();
            if (jSONObject != null) {
                this.f31d.edit().putString("OT_IAB_ACTIVE_VENDORLIST", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).apply();
            }
            StringBuilder sb = new StringBuilder("is IAB enabled : ");
            Context context = this.f28a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                z2 = true;
            } else {
                sharedPreferencesC0047f = null;
                z2 = false;
            }
            if (z2) {
                sharedPreferences = sharedPreferencesC0047f;
            }
            OTLogger.m2743a(4, "CustomGroupDetails", sb.append(sharedPreferences.getBoolean("IS_IAB2_TEMPLATE", false)).toString());
            Context context2 = this.f28a;
            SharedPreferences sharedPreferences2 = context2.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
            if (C0026u.m181a(new C0045d(context2, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                sharedPreferencesC0047f2 = new SharedPreferencesC0047f(context2, sharedPreferences2, sharedPreferences2.getString("OT_ACTIVE_PROFILE_ID", ""));
                z3 = true;
            } else {
                sharedPreferencesC0047f2 = null;
                z3 = false;
            }
            if (z3) {
                sharedPreferences2 = sharedPreferencesC0047f2;
            }
            if (sharedPreferences2.getBoolean("IS_IAB2_TEMPLATE", false)) {
                Context context3 = this.f28a;
                new C0022q(context3).m132a(context3);
            }
        } else {
            OTLogger.m2743a(4, "CustomGroupDetails", "updated IAB user choices " + str);
            this.f31d.edit().putString("OTT_IAB_CONSENTABLE_PURPOSES", str).apply();
            this.f30c = new JSONObject();
            Context context4 = this.f28a;
            new C0022q(context4).m132a(context4);
        }
        Context context5 = this.f28a;
        C0046e c0046e = this.f32e;
        if (c0046e.m293o()) {
            JSONObject jSONObjectM273a = c0046e.m273a();
            try {
                String string = c0046e.f97a.m271a().getString("OT_GOOGLE_VENDOR_DATA", null);
                if (!C0048h.m305b(string)) {
                    jSONObject2 = new JSONObject(string);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "OneTrust", "error while getting culture data json on getGoogleVendorsData, err: " + e.getMessage());
            }
            try {
                if (jSONObjectM273a == null) {
                    OTLogger.m2743a(5, "GoogleVendorHelper", "Google additional string not generated: Google vendor data is null");
                    return;
                }
                String string2 = "" + ((jSONObject2 == null || !jSONObject2.has("vendorListVersion")) ? "1" : jSONObject2.getString("vendorListVersion")) + "~";
                JSONArray jSONArrayNames = jSONObjectM273a.names();
                if (jSONArrayNames != null) {
                    StringBuilder sb2 = new StringBuilder(string2);
                    boolean z4 = true;
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        String string3 = jSONArrayNames.getString(i);
                        if ("1".equalsIgnoreCase(jSONObjectM273a.getJSONObject(string3).getString(OTVendorUtils.CONSENT_TYPE))) {
                            if (!z4) {
                                sb2.append(".");
                            }
                            sb2.append(string3);
                            z4 = false;
                        }
                    }
                    string2 = sb2.toString();
                }
                PreferenceManager.getDefaultSharedPreferences(context5).edit().putString(OTIABTCFKeys.IABTCF_ADD_TL_CONSENT, string2).apply();
                OTLogger.m2743a(4, "GoogleVendorHelper", "Google consent string, IABTCF_AddtlConsent = " + string2);
            } catch (JSONException e2) {
                OTLogger.m2743a(6, "GoogleVendorHelper", "Error on parsing google vendor status.Error message = " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m85a(C0022q c0022q, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        for (int i = 0; i < jSONObject2.length(); i++) {
            String string = jSONObject2.names().getString(i);
            if (c0022q.m142e(string)) {
                jSONObject.getJSONObject(c0022q.m138c(string)).put(C0022q.m123b(string), jSONObject2.getInt(string));
            }
        }
        OTLogger.m2743a(3, "CustomGroupDetails", "IAB purposes updated : " + jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m92a(java.lang.String r12, org.json.JSONObject r13, org.json.JSONObject r14) throws org.json.JSONException {
        /*
            r11 = this;
            a.a.a.a.a.c.f r0 = new a.a.a.a.a.c.f
            android.content.Context r1 = r11.f28a
            r0.<init>(r1)
            java.lang.String r1 = r0.m64a()
            boolean r2 = p000a.p001a.p002a.p003a.p004a.C0048h.m305b(r12)
            if (r2 == 0) goto L17
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            goto L1d
        L17:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r12)
            r12 = r2
        L1d:
            java.util.Iterator r2 = r13.keys()
            r3 = 0
            r4 = r3
        L23:
            boolean r5 = r2.hasNext()
            java.lang.String r6 = "FIRST_TIME_CONSENT_LOG"
            if (r5 == 0) goto L5f
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            int r7 = r13.getInt(r5)
            boolean r8 = r12.has(r5)
            r9 = 1
            if (r8 == 0) goto L4a
            int r8 = r12.getInt(r5)
            android.content.SharedPreferences r10 = r11.f31d
            boolean r6 = r10.getBoolean(r6, r9)
            if (r6 != 0) goto L4a
            if (r8 == r7) goto L51
        L4a:
            r12.put(r5, r7)
            r14.put(r5, r7)
            r4 = r9
        L51:
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L23
            if (r7 != r9) goto L5a
            goto L5b
        L5a:
            r9 = r3
        L5b:
            r0.m68a(r9, r3)
            goto L23
        L5f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "consent values saved as  "
            r13.<init>(r14)
            java.lang.StringBuilder r13 = r13.append(r12)
            java.lang.String r13 = r13.toString()
            r14 = 4
            java.lang.String r0 = "CustomGroupDetails"
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r14, r0, r13)
            android.content.SharedPreferences r13 = r11.f31d
            android.content.SharedPreferences$Editor r13 = r13.edit()
            android.content.SharedPreferences$Editor r13 = r13.putBoolean(r6, r3)
            r13.apply()
            android.content.SharedPreferences r13 = r11.f31d
            android.content.SharedPreferences$Editor r13 = r13.edit()
            boolean r14 = r12 instanceof org.json.JSONObject
            if (r14 != 0) goto L90
            java.lang.String r12 = r12.toString()
            goto L97
        L90:
            r14 = r12
            org.json.JSONObject r14 = (org.json.JSONObject) r14
            java.lang.String r12 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r12)
        L97:
            java.lang.String r14 = "OTT_CONSENT_STATUS"
            android.content.SharedPreferences$Editor r12 = r13.putString(r14, r12)
            r12.apply()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0015j.m92a(java.lang.String, org.json.JSONObject, org.json.JSONObject):boolean");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m93a(String str, boolean z) {
        try {
            if (!this.f32e.m277b(str)) {
                this.f29b.put(str, z ? 1 : 0);
                OTLogger.m2743a(3, "CustomGroupDetails", "Consent updated for group : " + str + " with value : " + z);
                return true;
            }
            OTLogger.m2743a(4, "CustomGroupDetails", "Consent not updated for Always Active group : " + str);
            return false;
        } catch (JSONException e) {
            OTLogger.m2743a(6, "CustomGroupDetails", "error in updating consent status. err = " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m87a(boolean z) {
        Context context = this.f28a;
        C0045d c0045d = new C0045d(context, "OTT_DEFAULT_USER");
        new C0187b(context);
        PreferenceManager.getDefaultSharedPreferences(this.f28a).edit().putInt(c0045d.m271a().getBoolean("OT_GPP_IS_ENABLED", false) ? OTGppKeys.IAB_GPP_GDPRAPPLIES : OTIABTCFKeys.IABTCF_GDPRAPPLIES, z ? 1 : 0).apply();
        OTLogger.m2743a(4, "CustomGroupDetails", "Setting gdprApplies value to 0.");
    }
}
