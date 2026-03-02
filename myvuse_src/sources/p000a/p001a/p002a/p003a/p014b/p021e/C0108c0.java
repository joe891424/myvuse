package p000a.p001a.p002a.p003a.p014b.p021e;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0059b;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0060c;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0061d;
import p000a.p001a.p002a.p003a.p014b.DataModels.C0062e;

/* JADX INFO: renamed from: a.a.a.a.b.e.c0 */
/* JADX INFO: loaded from: classes.dex */
public class C0108c0 {
    /* JADX INFO: renamed from: a */
    public static void m615a(C0060c c0060c, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("customPreferences")) {
            ArrayList<C0059b> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("customPreferences");
            for (int i = 0; i < jSONArray.length(); i++) {
                C0059b c0059b = new C0059b();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("id")) {
                    c0059b.f142a = jSONObject2.optString("id");
                }
                if (jSONObject2.has("name")) {
                    c0059b.f143b = jSONObject2.optString("name");
                }
                if (jSONObject2.has("description")) {
                    c0059b.f144c = jSONObject2.optString("description");
                }
                if (jSONObject2.has("selectionType")) {
                    c0059b.f145d = jSONObject2.optString("selectionType");
                }
                if (jSONObject2.has("purposeId")) {
                    jSONObject2.optString("purposeId");
                }
                if (jSONObject2.has("customPreferenceOptions")) {
                    ArrayList<C0061d> arrayList2 = new ArrayList<>();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("customPreferenceOptions");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        C0061d c0061d = new C0061d();
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        if (jSONObject3.has("id")) {
                            c0061d.f159a = jSONObject3.optString("id");
                        }
                        if (jSONObject3.has(Constants.ScionAnalytics.PARAM_LABEL)) {
                            c0061d.f163e = jSONObject3.optString(Constants.ScionAnalytics.PARAM_LABEL);
                        }
                        if (jSONObject3.has("order")) {
                            c0061d.f164f = jSONObject3.optString("order");
                        }
                        if (jSONObject3.has("isDefault")) {
                            c0061d.f165g = jSONObject3.optString("isDefault");
                        }
                        if (jSONObject3.has("canDelete")) {
                            c0061d.f160b = jSONObject3.optString("canDelete");
                        }
                        if (jSONObject3.has("purposeOptionsId")) {
                            c0061d.f167i = jSONObject3.optString("purposeOptionsId");
                        }
                        if (jSONObject3.has("purposeId")) {
                            c0061d.f168j = jSONObject3.optString("purposeId");
                        }
                        if (jSONObject3.has("userConsentStatus")) {
                            c0061d.f166h = jSONObject3.optString("userConsentStatus");
                        }
                        if (jSONObject3.has("customPreferenceId")) {
                            c0061d.f169k = jSONObject3.optString("customPreferenceId");
                        }
                        arrayList2.add(c0061d);
                    }
                    c0059b.f147f = arrayList2;
                }
                arrayList.add(c0059b);
            }
            c0060c.f157j = arrayList;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m616b(C0060c c0060c, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("topics")) {
            ArrayList<C0062e> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("topics");
            for (int i = 0; i < jSONArray.length(); i++) {
                C0062e c0062e = new C0062e();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("name")) {
                    c0062e.f171a = jSONObject2.optString("name");
                }
                if (jSONObject2.has("options")) {
                    ArrayList<C0061d> arrayList2 = new ArrayList<>();
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("options");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        C0061d c0061d = new C0061d();
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
                        if (jSONObject3.has("id")) {
                            c0061d.f159a = jSONObject3.optString("id");
                        }
                        if (jSONObject3.has("name")) {
                            c0061d.f161c = jSONObject3.optString("name");
                        }
                        if (jSONObject3.has("integrationKey")) {
                            c0061d.f162d = jSONObject3.optString("integrationKey");
                        }
                        if (jSONObject3.has("customPreferenceId")) {
                            c0061d.f167i = jSONObject3.optString("customPreferenceId");
                        }
                        if (jSONObject3.has("purposeId")) {
                            c0061d.f168j = jSONObject3.optString("purposeId");
                        }
                        if (jSONObject3.has("userConsentStatus")) {
                            c0061d.f166h = jSONObject3.optString("userConsentStatus");
                        }
                        if (jSONObject3.has("purposeTopicId")) {
                            c0061d.f170l = jSONObject3.optString("purposeTopicId");
                        }
                        arrayList2.add(c0061d);
                    }
                    c0062e.f172b = arrayList2;
                }
                arrayList.add(c0062e);
            }
            c0060c.f156i = arrayList;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m617c(C0060c c0060c, JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            c0060c.f148a = jSONObject.optString("id");
        }
        if (jSONObject.has(Constants.ScionAnalytics.PARAM_LABEL)) {
            c0060c.f149b = jSONObject.optString(Constants.ScionAnalytics.PARAM_LABEL);
        }
        if (jSONObject.has("description")) {
            c0060c.f150c = jSONObject.optString("description");
        }
        if (jSONObject.has("status")) {
            c0060c.f151d = jSONObject.optString("status");
        }
        if (jSONObject.has("newVersionAvailable")) {
            c0060c.f152e = jSONObject.optString("newVersionAvailable");
        }
        if (jSONObject.has("type")) {
            c0060c.f153f = jSONObject.optString("type");
        }
        if (jSONObject.has("consentLifeSpan")) {
            c0060c.f154g = jSONObject.optString("consentLifeSpan");
        }
        if (jSONObject.has("version")) {
            c0060c.f155h = jSONObject.optString("version");
        }
        if (jSONObject.has("userConsentStatus")) {
            c0060c.f158k = jSONObject.optString("userConsentStatus");
        }
    }
}
