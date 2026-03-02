package p000a.p001a.p002a.p003a.p004a.p007c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.firebase.messaging.Constants;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.Keys.OTBroadcastServiceKeys;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import com.onetrust.otpublishers.headless.Public.OTVendorListMode;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.c.z */
/* JADX INFO: loaded from: classes.dex */
public class C0031z {

    /* JADX INFO: renamed from: a */
    public C0045d f60a;

    /* JADX INFO: renamed from: b */
    public C0032d f61b = new C0032d();

    /* JADX INFO: renamed from: c */
    public Context f62c;

    /* JADX INFO: renamed from: d */
    public JSONObject f63d;

    /* JADX INFO: renamed from: e */
    public JSONObject f64e;

    /* JADX INFO: renamed from: f */
    public JSONObject f65f;

    public C0031z(Context context) {
        this.f62c = context;
        this.f60a = new C0045d(context, "OTT_DEFAULT_USER");
        m222a();
    }

    /* JADX INFO: renamed from: a */
    public static void m217a(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
        String strOptString;
        if (jSONObject2.has(str)) {
            jSONObject.put("userConsentStatus", jSONObject2.optJSONObject(str).optString("userConsentStatus"));
            strOptString = jSONObject2.optJSONObject(str).optString("transactionType");
        } else {
            strOptString = "OPT_OUT";
            jSONObject.put("userConsentStatus", "OPT_OUT");
        }
        jSONObject.put("transactionType", strOptString);
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m221a(JSONArray jSONArray, String str, JSONObject jSONObject, JSONArray jSONArray2, int i) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i).toString());
        OTLogger.m2743a(3, "UCPurposesDataHandler", "purposeObject :" + jSONObject2);
        String string = jSONObject.names().get(i).toString();
        JSONArray jSONArrayM235c = m235c(string);
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        for (int i2 = 0; i2 < jSONArrayM235c.length(); i2++) {
            JSONObject jSONObject4 = jSONArrayM235c.getJSONObject(i2);
            if (string.equals(jSONObject4.optString("purposeId"))) {
                jSONObject3.put("name", str);
                jSONArray4.put(jSONObject4);
                jSONObject3.put("options", jSONArray4);
            } else {
                JSONObject jSONObject5 = new JSONObject();
                JSONArray jSONArray5 = new JSONArray();
                jSONObject2.put("topics", jSONArray5);
                jSONObject3 = jSONObject5;
                jSONArray3 = jSONArray5;
            }
        }
        if (jSONObject3.length() > 0) {
            jSONArray3.put(jSONObject3);
        }
        jSONObject2.put("topics", jSONArray3);
        JSONArray jSONArrayM220a = m220a(string);
        JSONArray jSONArray6 = new JSONArray();
        JSONArray jSONArrayM230b = jSONArray2;
        for (int i3 = 0; i3 < jSONArrayM220a.length(); i3++) {
            JSONObject jSONObject6 = jSONArrayM220a.getJSONObject(i3);
            String strOptString = jSONObject6.optString("id");
            JSONArray jSONArray7 = new JSONArray();
            if (string.equals(jSONObject6.optString("purposeId"))) {
                if (!C0048h.m305b(strOptString)) {
                    strOptString = jSONObject6.optString("id");
                    jSONArrayM230b = m230b(strOptString);
                }
                if (jSONArrayM230b != null) {
                    for (int i4 = 0; i4 < jSONArrayM230b.length(); i4++) {
                        JSONObject jSONObject7 = jSONArrayM230b.getJSONObject(i4);
                        if (strOptString != null && strOptString.equals(jSONObject7.optString("customPreferenceId"))) {
                            jSONArray7.put(jSONObject7);
                            jSONObject6.put("customPreferenceOptions", jSONArray7);
                        }
                    }
                }
                jSONArray6.put(jSONObject6);
                jSONObject2.put("customPreferences", jSONArray6);
            } else {
                jSONArray6 = new JSONArray();
            }
        }
        jSONObject2.put("customPreferences", jSONArray6);
        jSONArray.put(jSONObject2);
        return jSONArrayM230b;
    }

    /* JADX INFO: renamed from: a */
    public final void m229a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        String strOptString = jSONObject.optString("id");
        jSONObject3.put("status", m237d(strOptString));
        if (jSONObject.has("topics")) {
            JSONArray jSONArray = jSONObject.getJSONObject("topics").getJSONArray("options");
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString2 = jSONArray.getJSONObject(i).optString("id", "");
                int iM218a = m218a(strOptString2, strOptString);
                if (iM218a == -1) {
                    iM218a = 0;
                }
                jSONObject4.put(strOptString2, iM218a);
            }
        }
        jSONObject3.put("topics", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        if (jSONObject.has("customPreferences")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("customPreferences");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject6 = jSONArray2.getJSONObject(i2);
                String string = jSONObject6.getString("id");
                JSONArray jSONArray3 = jSONObject6.getJSONArray("customPreferenceOptions");
                JSONObject jSONObject7 = new JSONObject();
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    String string2 = jSONArray3.getJSONObject(i3).getString("id");
                    int iM219a = m219a(string2, strOptString, string);
                    if (iM219a == -1) {
                        iM219a = 0;
                    }
                    jSONObject7.put(string2, iM219a);
                }
                jSONObject5.put(string, jSONObject7);
            }
        }
        jSONObject3.put("custom_preferences", jSONObject5);
        jSONObject2.put(strOptString, jSONObject3);
    }

    /* JADX INFO: renamed from: b */
    public JSONArray m230b(String str) {
        String string = this.f60a.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i).toString());
                if (str.equals(jSONObject2.optString("customPreferenceId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in fetching CP options data by purposeCPId  :" + e.getMessage());
        }
        OTLogger.m2743a(3, "UCPurposesDataHandler", "Options by Purpose and CustomPrefId :" + jSONArray);
        return jSONArray;
    }

    /* JADX INFO: renamed from: b */
    public final void m231b(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.has(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            if (jSONObject2.has("topics") && !C0032d.m240a(jSONObject2.getJSONObject("topics"))) {
                JSONArray jSONArrayNames = jSONObject2.getJSONObject("topics").names();
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String string = jSONArrayNames.getString(i);
                    m236c(string.trim() + str.trim(), string, false);
                }
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("custom_preferences");
            if (C0032d.m240a(jSONObject3)) {
                return;
            }
            for (int i2 = 0; i2 < jSONObject3.length(); i2++) {
                String string2 = jSONObject3.names().getString(i2);
                JSONObject jSONObject4 = jSONObject3.getJSONObject(string2);
                for (int i3 = 0; i3 < jSONObject4.length(); i3++) {
                    String string3 = jSONObject4.names().getString(i3);
                    m224a(string2, string3.trim() + str.trim() + string2.trim(), false, string3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public JSONArray m235c(String str) {
        String string = this.f60a.m271a().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i).toString());
                if (str.equals(jSONObject2.optString("purposeId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in fetching topics data by purpose :" + e.getMessage());
        }
        OTLogger.m2743a(3, "UCPurposesDataHandler", "Topics by PurposeId :" + jSONArray);
        return jSONArray;
    }

    /* JADX INFO: renamed from: d */
    public int m237d(String str) {
        int iM159a = C0026u.m159a(this.f63d, str);
        OTLogger.m2743a(4, "UCPurposesDataHandler", "UCP: Consent Status for Purpose id " + str + " : " + iM159a);
        return iM159a;
    }

    /* JADX INFO: renamed from: b */
    public final void m233b(JSONArray jSONArray, JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("topics")) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject("topics");
            if (jSONObject3.has("options")) {
                JSONArray jSONArray2 = jSONObject3.getJSONArray("options");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject4 = new JSONObject();
                    JSONObject jSONObject5 = jSONArray2.getJSONObject(i2);
                    this.f61b.m241a(jSONObject4, jSONObject5, "id");
                    this.f61b.m241a(jSONObject4, jSONObject5, "name");
                    this.f61b.m241a(jSONObject4, jSONObject5, "integrationKey");
                    jSONObject4.put("purposeId", strOptString);
                    jSONObject4.put("purposeTopicId", jSONObject5.optString("id") + strOptString);
                    m217a(jSONObject4, this.f65f, jSONObject5.optString("id") + strOptString);
                    jSONObject.put(jSONObject5.optString("id") + strOptString, jSONObject4);
                }
                this.f60a.m271a().edit().putString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", String.valueOf(jSONObject)).apply();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m236c(String str, String str2, boolean z) {
        try {
            if (this.f65f.has(str)) {
                JSONObject jSONObjectOptJSONObject = this.f65f.optJSONObject(str);
                C0026u.m184a(z, jSONObjectOptJSONObject, "OPT_IN", "OPT_OUT", str2, jSONObjectOptJSONObject.optString("id"));
                OTLogger.m2743a(3, "UCPurposesDataHandler", "Updated topic id: " + str2 + " with status: " + z);
            } else {
                OTLogger.m2743a(5, "UCPurposesDataHandler", "Invalid id passed to update topics");
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in updating consent for topics :" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m232b(String str, String str2, boolean z) {
        try {
            if (this.f65f.has(str)) {
                JSONObject jSONObjectOptJSONObject = this.f65f.optJSONObject(str);
                C0026u.m184a(z, jSONObjectOptJSONObject, "OPT_IN", "OPT_OUT", str2, jSONObjectOptJSONObject.optString("id"));
            }
            OTLogger.m2743a(3, "UCPurposesDataHandler", "Updated topic object : " + this.f65f.optJSONObject(str));
            C0026u.m170a(this.f60a, this.f63d, this.f65f, this.f64e);
            m234b(this.f65f);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in updating consent for topics :" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONArray m220a(String str) {
        String string = this.f60a.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", "");
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(string);
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(jSONObject.names().get(i).toString());
                if (str.equals(jSONObject2.optString("purposeId"))) {
                    jSONArray.put(jSONObject2);
                }
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in fetching CP data by purpose  :" + e.getMessage());
        }
        OTLogger.m2743a(3, "UCPurposesDataHandler", "Custom Prefs by PurposeId :" + jSONArray);
        return jSONArray;
    }

    /* JADX INFO: renamed from: b */
    public void m234b(JSONObject jSONObject) {
        SharedPreferences.Editor editorEdit;
        String strValueOf;
        String str;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null) {
                try {
                    jSONObjectOptJSONObject.put("transactionType", jSONObjectOptJSONObject.optString("userConsentStatus"));
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "UCPurposesDataHandler", "Error while updating previous selection to latest selection :" + e.getMessage());
                }
            }
        }
        if (jSONObject.equals(this.f63d)) {
            editorEdit = this.f60a.m271a().edit();
            strValueOf = String.valueOf(this.f63d);
            str = "OT_UC_PURPOSES_PURPOSE_SERVER_DATA";
        } else if (jSONObject.equals(this.f65f)) {
            editorEdit = this.f60a.m271a().edit();
            strValueOf = String.valueOf(this.f65f);
            str = "OT_UC_PURPOSES_TOPIC_SERVER_DATA";
        } else {
            if (!jSONObject.equals(this.f64e)) {
                return;
            }
            editorEdit = this.f60a.m271a().edit();
            strValueOf = String.valueOf(this.f64e);
            str = "OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA";
        }
        editorEdit.putString(str, strValueOf).apply();
    }

    /* JADX INFO: renamed from: a */
    public int m218a(String str, String str2) {
        int iM159a = C0026u.m159a(this.f65f, str.trim() + str2.trim());
        OTLogger.m2743a(4, "UCPurposesDataHandler", "UCP: Consent Status for Topic id " + str + " : " + iM159a);
        return iM159a;
    }

    /* JADX INFO: renamed from: a */
    public int m219a(String str, String str2, String str3) {
        int iM159a = C0026u.m159a(this.f64e, str.trim() + str2.trim() + str3.trim());
        OTLogger.m2743a(4, "UCPurposesDataHandler", "UCP: Consent Status for Custom Preference Options id " + str + " : " + iM159a);
        return iM159a;
    }

    /* JADX INFO: renamed from: a */
    public final void m222a() {
        String string = this.f60a.m271a().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", "{}");
        String string2 = this.f60a.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", "{}");
        String string3 = this.f60a.m271a().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", "{}");
        try {
            this.f63d = new JSONObject(string);
            this.f64e = new JSONObject(string2);
            this.f65f = new JSONObject(string3);
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in initializing user state object :" + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m226a(JSONArray jSONArray, JSONObject jSONObject, int i) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("customPreferences")) {
            JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferences");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                this.f61b.m241a(jSONObject3, jSONObject4, "id");
                this.f61b.m241a(jSONObject3, jSONObject4, "name");
                this.f61b.m241a(jSONObject3, jSONObject4, "description");
                this.f61b.m241a(jSONObject3, jSONObject4, "selectionType");
                jSONObject3.put("selectionType", "MULTI_CHOICE");
                this.f61b.m241a(jSONObject3, jSONObject4, "displayAs");
                this.f61b.m241a(jSONObject3, jSONObject4, "required");
                jSONObject3.put("purposeId", strOptString);
                jSONObject.put(jSONObject4.optString("id"), jSONObject3);
            }
            OTLogger.m2743a(3, "UCPurposesDataHandler", "customPrefObjectToSave :" + jSONObject);
            this.f60a.m271a().edit().putString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", String.valueOf(jSONObject)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m228a(JSONObject jSONObject, JSONArray jSONArray, int i, String str) throws JSONException {
        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
        String strOptString = jSONObject2.optString("id");
        if (jSONObject2.has("customPreferenceOptions")) {
            JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferenceOptions");
            OTLogger.m2743a(3, "UCPurposesDataHandler", "customPrefArraylength() optionsArray :" + jSONArray2.length());
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                String str2 = jSONObject4.optString("id") + str + strOptString;
                this.f61b.m241a(jSONObject3, jSONObject4, "id");
                this.f61b.m241a(jSONObject3, jSONObject4, Constants.ScionAnalytics.PARAM_LABEL);
                jSONObject3.put("customPreferenceId", strOptString);
                jSONObject3.put("purposeOptionsId", str2);
                jSONObject3.put("purposeId", str);
                m217a(jSONObject3, this.f64e, str2);
                jSONObject.put(str2, jSONObject3);
            }
            this.f60a.m271a().edit().putString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", String.valueOf(jSONObject)).apply();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m227a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayNames;
        String string;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject.has(OTVendorListMode.GENERAL)) {
            jSONObject2.put(OTVendorListMode.GENERAL, jSONObject.getJSONObject(OTVendorListMode.GENERAL));
        }
        if (jSONObject.has("description")) {
            jSONObject2.put("description", jSONObject.getJSONObject("description"));
        }
        if (jSONObject.has("title")) {
            jSONObject2.put("title", jSONObject.getJSONObject("title"));
        }
        if (jSONObject.has(OTUXParamsKeys.OT_UX_BUTTONS)) {
            jSONObject2.put(OTUXParamsKeys.OT_UX_BUTTONS, jSONObject.getJSONObject(OTUXParamsKeys.OT_UX_BUTTONS));
        }
        this.f60a.m271a().edit().putString("OT_UC_PURPOSES_UI_SERVER_DATA", String.valueOf(jSONObject2)).apply();
        OTLogger.m2743a(3, "UCPurposesDataHandler", "Saved server UCPurpose UI Data :" + this.f60a.m271a().getString("OT_UC_PURPOSES_UI_SERVER_DATA", ""));
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject4 = this.f63d;
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (i < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObject5 = new JSONObject();
                JSONObject jSONObject6 = jSONArrayOptJSONArray.getJSONObject(i);
                this.f61b.m241a(jSONObject5, jSONObject6, "id");
                this.f61b.m241a(jSONObject5, jSONObject6, "version");
                this.f61b.m241a(jSONObject5, jSONObject6, Constants.ScionAnalytics.PARAM_LABEL);
                this.f61b.m241a(jSONObject5, jSONObject6, "description");
                this.f61b.m241a(jSONObject5, jSONObject6, "status");
                this.f61b.m241a(jSONObject5, jSONObject6, "newVersionAvailable");
                this.f61b.m241a(jSONObject5, jSONObject6, "purposeType");
                this.f61b.m241a(jSONObject5, jSONObject6, "consentLifeSpan");
                this.f61b.m241a(jSONObject5, jSONObject6, "externalReference");
                this.f61b.m241a(jSONObject5, jSONObject6, "order");
                m217a(jSONObject5, this.f63d, jSONObject6.optString("id"));
                jSONObject5.put("defaultConsentStatus", "OPT_OUT");
                jSONObject4.put(jSONObject6.optString("id"), jSONObject5);
                i++;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
            }
            this.f60a.m271a().edit().putString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", String.valueOf(jSONObject4)).apply();
            OTLogger.m2743a(3, "UCPurposesDataHandler", "Saved UC Purpose Server Data :" + this.f60a.m271a().getString("OT_UC_PURPOSES_PURPOSE_SERVER_DATA", ""));
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject7 = new JSONObject();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                try {
                    m233b(jSONArrayOptJSONArray2, jSONObject7, i2);
                } catch (JSONException e) {
                    OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in saving topics data :" + e.getMessage());
                }
                OTLogger.m2743a(3, "UCPurposesDataHandler", "Saved server Topic Data :" + this.f60a.m271a().getString("OT_UC_PURPOSES_TOPIC_SERVER_DATA", ""));
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("purposes");
            JSONObject jSONObject8 = new JSONObject();
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    m226a(jSONArrayOptJSONArray3, jSONObject8, i3);
                }
                OTLogger.m2743a(3, "UCPurposesDataHandler", "Saved server Custom Pref Data :" + this.f60a.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_SERVER_DATA", ""));
            }
        } catch (JSONException e2) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in saving custom pref data :" + e2.getMessage());
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("purposes");
        JSONObject jSONObject9 = this.f64e;
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                try {
                    JSONObject jSONObject10 = jSONArrayOptJSONArray4.getJSONObject(i4);
                    String strOptString = jSONObject10.optString("id");
                    if (jSONObject10.has("customPreferences")) {
                        JSONArray jSONArray = jSONObject10.getJSONArray("customPreferences");
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            m228a(jSONObject9, jSONArray, i5, strOptString);
                        }
                    }
                } catch (JSONException e3) {
                    OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in saving CP options data :" + e3.getMessage());
                }
                OTLogger.m2743a(3, "UCPurposesDataHandler", "Saved server Custom Pref options Data :" + this.f60a.m271a().getString("OT_UC_PURPOSES_CUSTOM_PREF_OPTIONS_SERVER_DATA", ""));
            }
        }
        m222a();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("purposes");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                try {
                    m229a(jSONArrayOptJSONArray5.getJSONObject(i6), jSONObject3);
                } catch (JSONException e4) {
                    OTLogger.m2743a(6, "UCPurposesDataHandler", "UCP: error while creating broadcasting object:" + e4.toString());
                }
            }
        }
        this.f60a.m271a().edit().putString("OT_UCP_PURPOSE_RELATION_DATA", !(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3)).apply();
        Context context = this.f62c;
        if (C0032d.m240a(jSONObject3) || (jSONArrayNames = jSONObject3.names()) == null) {
            return;
        }
        for (int i7 = 0; i7 < jSONArrayNames.length(); i7++) {
            try {
                String string2 = jSONArrayNames.getString(i7);
                JSONObject jSONObject11 = jSONObject3.getJSONObject(string2);
                OTLogger.m2743a(4, "OTConsentChanges", "UCP: Sending " + string2 + " broadcast, value = " + jSONObject11);
                Intent intent = new Intent(string2);
                if (jSONObject11 instanceof JSONObject) {
                    string = JSONObjectInstrumentation.toString(jSONObject11);
                } else {
                    string = jSONObject11.toString();
                }
                intent.putExtra(OTBroadcastServiceKeys.UCP_EVENT_STATUS, string);
                intent.setPackage(context.getApplicationContext().getPackageName());
                context.sendBroadcast(intent);
            } catch (JSONException e5) {
                OTLogger.m2743a(6, "OTConsentChanges", "UCP: Failed to broadcast UCP consent changes," + e5.toString());
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m223a(String str, String str2, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (this.f64e.has(str2) && (jSONObjectOptJSONObject = this.f64e.optJSONObject(str2)) != null) {
                C0026u.m184a(z, jSONObjectOptJSONObject, "OPT_IN", "OPT_OUT", str, jSONObjectOptJSONObject.optString("customPreferenceId"));
            }
            OTLogger.m2743a(3, "UCPurposesDataHandler", "Updated CustomPref options object : " + this.f64e.optJSONObject(str2));
            C0026u.m170a(this.f60a, this.f63d, this.f65f, this.f64e);
            m234b(this.f64e);
            m222a();
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in updating consent for CP options :" + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[Catch: JSONException -> 0x0051, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0051, blocks: (B:3:0x0006, B:5:0x000e, B:7:0x0018, B:9:0x0026, B:10:0x004c), top: B:16:0x0006 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m224a(java.lang.String r11, java.lang.String r12, boolean r13, java.lang.String r14) {
        /*
            r10 = this;
            java.lang.String r0 = "Invalid id passed to update custom preference options"
            java.lang.String r1 = "UCPurposesDataHandler"
            java.lang.String r2 = "Updated Custom Preference options: "
            org.json.JSONObject r3 = r10.f64e     // Catch: org.json.JSONException -> L51
            boolean r3 = r3.has(r12)     // Catch: org.json.JSONException -> L51
            if (r3 == 0) goto L4c
            org.json.JSONObject r3 = r10.f64e     // Catch: org.json.JSONException -> L51
            org.json.JSONObject r5 = r3.optJSONObject(r12)     // Catch: org.json.JSONException -> L51
            java.lang.String r6 = "OPT_IN"
            java.lang.String r7 = "OPT_OUT"
            java.lang.String r12 = "customPreferenceId"
            java.lang.String r9 = r5.optString(r12)     // Catch: org.json.JSONException -> L51
            r4 = r13
            r8 = r11
            boolean r12 = p000a.p001a.p002a.p003a.p004a.p007c.C0026u.m184a(r4, r5, r6, r7, r8, r9)     // Catch: org.json.JSONException -> L51
            if (r12 == 0) goto L4c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L51
            r12.<init>(r2)     // Catch: org.json.JSONException -> L51
            java.lang.StringBuilder r12 = r12.append(r14)     // Catch: org.json.JSONException -> L51
            java.lang.String r14 = " of Custom Preference Id: "
            java.lang.StringBuilder r12 = r12.append(r14)     // Catch: org.json.JSONException -> L51
            java.lang.StringBuilder r11 = r12.append(r11)     // Catch: org.json.JSONException -> L51
            java.lang.String r12 = " with status: "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: org.json.JSONException -> L51
            java.lang.StringBuilder r11 = r11.append(r13)     // Catch: org.json.JSONException -> L51
            java.lang.String r11 = r11.toString()     // Catch: org.json.JSONException -> L51
            r12 = 3
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r12, r1, r11)     // Catch: org.json.JSONException -> L51
            goto L69
        L4c:
            r11 = 5
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r11, r1, r0)     // Catch: org.json.JSONException -> L51
            goto L69
        L51:
            r11 = move-exception
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Error in updating consent for CP options :"
            r12.<init>(r13)
            java.lang.String r11 = r11.getMessage()
            java.lang.StringBuilder r11 = r12.append(r11)
            java.lang.String r11 = r11.toString()
            r12 = 6
            com.onetrust.otpublishers.headless.Internal.Log.OTLogger.m2743a(r12, r1, r11)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p002a.p003a.p004a.p007c.C0031z.m224a(java.lang.String, java.lang.String, boolean, java.lang.String):void");
    }

    /* JADX INFO: renamed from: a */
    public void m225a(String str, boolean z) {
        try {
            if (C0026u.m185a(z, this.f63d.optJSONObject(str), "ACTIVE", "OPT_OUT", this.f63d, str)) {
                OTLogger.m2743a(3, "UCPurposesDataHandler", "Updated purpose id: " + str + " with status: " + z);
                if (z) {
                    return;
                }
                m231b(str, this.f60a.m271a().getString("OT_UCP_PURPOSE_RELATION_DATA", "{}"));
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "UCPurposesDataHandler", "Error in updating consent for purposes :" + e.getMessage());
        }
    }
}
