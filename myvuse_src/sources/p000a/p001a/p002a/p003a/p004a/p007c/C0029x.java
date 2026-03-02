package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTGppKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTIABTCFKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;
import p000a.p001a.p002a.p003a.p004a.p010g.SharedPreferencesC0047f;
import p000a.p001a.p002a.p003a.p028d.C0187b;

/* JADX INFO: renamed from: a.a.a.a.a.c.x */
/* JADX INFO: loaded from: classes.dex */
public class C0029x {

    /* JADX INFO: renamed from: a */
    public static C0029x f55a;

    /* JADX INFO: renamed from: b */
    public static ArrayList<String> f56b;

    /* JADX INFO: renamed from: a */
    public static synchronized C0029x m196a() {
        if (f55a == null) {
            f55a = new C0029x();
            f56b = new ArrayList<>(Arrays.asList("IABTCF_CmpSdkID.int", "IABTCF_CmpSdkVersion.int", "IABTCF_PolicyVersion.int", "IABTCF_gdprApplies.int", "IABTCF_PublisherCC.string", "IABTCF_PurposeOneTreatment.int", "IABTCF_UseNonStandardStacks.int", "IABTCF_TCString.string", "IABTCF_VendorConsents.string", "IABTCF_VendorLegitimateInterests.string", "IABTCF_PurposeConsents.string", "IABTCF_PurposeLegitimateInterests.string", "IABTCF_SpecialFeaturesOptIns.string", "IABTCF_PublisherConsent.string", "IABTCF_PublisherLegitimateInterests.string", "IABTCF_PublisherCustomPurposesConsents.string", "IABTCF_PublisherCustomPurposesLegitimateInterests.string", "IABTCF_PublisherRestrictions1.string", "IABTCF_PublisherRestrictions2.string", "IABTCF_PublisherRestrictions3.string", "IABTCF_PublisherRestrictions4.string", "IABTCF_PublisherRestrictions5.string", "IABTCF_PublisherRestrictions6.string", "IABTCF_PublisherRestrictions7.string", "IABTCF_PublisherRestrictions8.string", "IABTCF_PublisherRestrictions9.string", "IABTCF_PublisherRestrictions10.string"));
        }
        return f55a;
    }

    /* JADX INFO: renamed from: a */
    public static String m197a(Integer num, Integer num2) {
        String binaryString = Integer.toBinaryString(num.intValue());
        StringBuilder sb = new StringBuilder();
        for (int iIntValue = num2.intValue() - binaryString.length(); iIntValue > 0; iIntValue--) {
            sb.append('0');
        }
        sb.append(binaryString);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m198a(String str) {
        int length = str.length() % 8;
        if (length > 0) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 8 - length; i > 0; i--) {
                sb.append('0');
            }
            str = sb.toString();
        }
        int length2 = str.length() / 8;
        byte[] bArr = new byte[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = i2 * 8;
            bArr[i2] = Integer.valueOf(Integer.parseInt(str.substring(i3, i3 + 8), 2)).byteValue();
        }
        return new String(Base64.encode(bArr, 2)).replace(Marker.ANY_NON_NULL_MARKER, "-").replace("/", "_").replace("=", "");
    }

    /* JADX INFO: renamed from: a */
    public static void m202a(SharedPreferences.Editor editor) {
        editor.remove("IABTCF_PublisherRestrictions1");
        editor.remove("IABTCF_PublisherRestrictions2");
        editor.remove("IABTCF_PublisherRestrictions3");
        editor.remove("IABTCF_PublisherRestrictions4");
        editor.remove("IABTCF_PublisherRestrictions5");
        editor.remove("IABTCF_PublisherRestrictions6");
        editor.remove("IABTCF_PublisherRestrictions7");
        editor.remove("IABTCF_PublisherRestrictions8");
        editor.remove("IABTCF_PublisherRestrictions9");
        editor.remove("IABTCF_PublisherRestrictions10");
        editor.apply();
    }

    /* JADX INFO: renamed from: a */
    public static void m203a(JSONObject jSONObject, SharedPreferences.Editor editor, String str, String str2, String str3, String str4, String str5) {
        editor.putInt(OTIABTCFKeys.IABTCF_GDPRAPPLIES, jSONObject.getInt("gdprApplies"));
        editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKID, jSONObject.getInt("CmpId"));
        editor.putInt(OTIABTCFKeys.IABTCF_CMPSDKVERSION, jSONObject.getInt("CmpVersion"));
        editor.putInt(OTIABTCFKeys.IABTCF_POLICYVERSION, jSONObject.getInt("TcfPolicyVersion"));
        editor.putInt(OTIABTCFKeys.IABTCF_USENONSTANDARDSTACKS, jSONObject.getInt("UseNonStandardStacks"));
        editor.putString(OTIABTCFKeys.IABTCF_SPECIALFEATURESOPTINS, str);
        editor.putString(OTIABTCFKeys.IABTCF_PURPOSECONSENTS, str2);
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCONSENT, str2);
        editor.putString(OTIABTCFKeys.IABTCF_PURPOSELEGITIMATEINTERESTS, str3);
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERLEGITIMATEINTERESTS, str3);
        editor.putInt(OTIABTCFKeys.IABTCF_PURPOSEONETREATMENT, jSONObject.getInt("PurposeOneTreatment"));
        editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCC, jSONObject.getString("PublisherCC"));
        editor.putString(OTIABTCFKeys.IABTCF_VENDORCONSENTS, str4);
        editor.putString(OTIABTCFKeys.IABTCF_VENDORLEGITIMATEINTERESTS, str5);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m204a(JSONArray jSONArray, Integer num) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TCF2Encoder", "error while getting Array Integer : " + e.getMessage());
            }
            if (jSONArray.getInt(i) == num.intValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static String m205b(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(Arrays.asList(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"));
        for (int i = 0; i < upperCase.length(); i++) {
            sb.append(m197a(Integer.valueOf(arrayList.indexOf(String.valueOf(upperCase.charAt(i)))), (Integer) 6));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public static String m206b(JSONArray jSONArray, Integer num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < num.intValue()) {
            i++;
            sb.append(m204a(jSONArray, Integer.valueOf(i)) ? "1" : "0");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public static String m207b(JSONObject jSONObject, SharedPreferences.Editor editor, boolean z, boolean z2) throws JSONException {
        String str;
        String str2;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m197a((Integer) 3, (Integer) 3));
        jSONArray.put(m206b(jSONObject.getJSONArray("PurposesConsent"), 24));
        jSONArray.put(m206b(jSONObject.getJSONArray("PurposesLITransparency"), 24));
        int i = jSONObject.getInt("NumCustomPurposes");
        jSONArray.put(m197a(Integer.valueOf(i), (Integer) 6));
        if (z) {
            str2 = OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESCONSENTS;
            str = OTGppKeys.IAB_GPP_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS;
        } else {
            str = OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS;
            str2 = OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS;
        }
        if (i > 0) {
            jSONArray.put(m206b(jSONObject.getJSONArray("CustomPurposesConsent"), Integer.valueOf(i)));
            editor.putString(str2, jSONArray.getString(jSONArray.length() - 1));
            if (z && z2) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, jSONArray.getString(jSONArray.length() - 1));
            }
            jSONArray.put(m206b(jSONObject.getJSONArray("CustomPurposesLITransparency"), Integer.valueOf(i)));
            editor.putString(str, jSONArray.getString(jSONArray.length() - 1));
            if (z && z2) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, jSONArray.getString(jSONArray.length() - 1));
            }
        } else {
            editor.putString(str2, "");
            editor.putString(str, "");
            if (z && z2) {
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESCONSENTS, "");
                editor.putString(OTIABTCFKeys.IABTCF_PUBLISHERCUSTOMPURPOSESLEGITIMATEINTERESTS, "");
            }
        }
        return m198a((!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray)).replace(",", "").replace("\"", "").replace("[", "").replace("]", ""));
    }

    /* JADX INFO: renamed from: a */
    public String m208a(JSONObject jSONObject, Context context) throws Throwable {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = null;
        try {
            SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
                if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
                    sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
                    z = true;
                } else {
                    sharedPreferencesC0047f = null;
                    z = false;
                }
                new C0187b(context);
                if (z) {
                    sharedPreferences = sharedPreferencesC0047f;
                }
                boolean z2 = sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false);
                boolean zContains = defaultSharedPreferences.contains(OTIABTCFKeys.IABTCF_TCSTRING);
                String str = m200a(jSONObject, editorEdit, z2, zContains) + "." + m207b(jSONObject, editorEdit, z2, zContains);
                editorEdit.putString(z2 ? OTGppKeys.IAB_GPP_TCFEU2_STRING : OTIABTCFKeys.IABTCF_TCSTRING, str);
                if (z2 && zContains) {
                    editorEdit.putString(OTIABTCFKeys.IABTCF_TCSTRING, str);
                }
                editorEdit.apply();
                return str;
            } catch (Throwable th) {
                th = th;
                editor = editorEdit;
                if (editor != null) {
                    editor.apply();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x029a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0342 A[Catch: Exception -> 0x03db, JSONException -> 0x03eb, TryCatch #9 {JSONException -> 0x03eb, Exception -> 0x03db, blocks: (B:53:0x0338, B:55:0x0342, B:57:0x0352, B:58:0x035a, B:59:0x0361, B:61:0x0367, B:63:0x037b, B:65:0x0381, B:71:0x0390), top: B:117:0x0338 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x049f A[ADDED_TO_REGION] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m200a(org.json.JSONObject r34, android.content.SharedPreferences.Editor r35, boolean r36, boolean r37) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0029x.m200a(org.json.JSONObject, android.content.SharedPreferences$Editor, boolean, boolean):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public static String m199a(Date date, Integer num) {
        String binaryString = Long.toBinaryString(Long.valueOf(date.getTime() / 100).longValue());
        StringBuilder sb = new StringBuilder();
        for (int iIntValue = num.intValue() - binaryString.length(); iIntValue > 0; iIntValue--) {
            sb.append('0');
        }
        sb.append(binaryString);
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m209a(Context context) {
        SharedPreferencesC0047f sharedPreferencesC0047f;
        boolean z;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        JSONObject jSONObject = new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.onetrust.otpublishers.headless.preferenceOTT_DEFAULT_USER", 0);
        if (C0026u.m181a(new C0045d(context, "OTT_DEFAULT_USER", false).m271a().getString("OT_ENABLE_MULTI_PROFILE", Boolean.FALSE.toString()), false)) {
            sharedPreferencesC0047f = new SharedPreferencesC0047f(context, sharedPreferences, sharedPreferences.getString("OT_ACTIVE_PROFILE_ID", ""));
            z = true;
        } else {
            sharedPreferencesC0047f = null;
            z = false;
        }
        new C0187b(context);
        if (z) {
            sharedPreferences = sharedPreferencesC0047f;
        }
        try {
        } catch (JSONException e) {
            OTLogger.m2743a(6, "TCF2Encoder", "error while getting all string : " + e.getMessage());
        }
        if (sharedPreferences.getBoolean("OT_GPP_IS_ENABLED", false)) {
            return m201a(context, defaultSharedPreferences);
        }
        for (String str : f56b) {
            if (str.endsWith(".int")) {
                String strReplace = str.replace(".int", "");
                jSONObject.put(strReplace, defaultSharedPreferences.getInt(strReplace, -1));
            } else if (str.endsWith(".string")) {
                String strReplace2 = str.replace(".string", "");
                jSONObject.put(strReplace2, defaultSharedPreferences.getString(strReplace2, ""));
            }
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public static int m195a(JSONArray jSONArray) {
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                if (jSONArray.getInt(i2) > i) {
                    i = jSONArray.getInt(i2);
                }
            } catch (JSONException e) {
                OTLogger.m2743a(6, "TCF2Encoder", "error while getting max int : " + e.getMessage());
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static JSONObject m201a(Context context, SharedPreferences sharedPreferences) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, Integer> map = new C0187b(context).f1667b;
        if (map.keySet().isEmpty()) {
            return jSONObject;
        }
        for (String str : map.keySet()) {
            if (!C0048h.m305b(str)) {
                Integer num = map.get(str);
                if (Objects.equals(num, C0187b.f1664d)) {
                    jSONObject.put(str, sharedPreferences.getInt(str, -1));
                } else if (Objects.equals(num, C0187b.f1665e)) {
                    jSONObject.put(str, sharedPreferences.getString(str, ""));
                }
            }
        }
        return jSONObject;
    }
}
