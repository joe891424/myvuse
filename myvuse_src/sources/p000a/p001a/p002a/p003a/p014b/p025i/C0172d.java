package p000a.p001a.p002a.p003a.p014b.p025i;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0032d;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p007c.C0016k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0106b0;
import p000a.p001a.p002a.p003a.p014b.p021e.C0117k;
import p000a.p001a.p002a.p003a.p014b.p021e.C0124r;
import p000a.p001a.p002a.p003a.p014b.p021e.C0125s;

/* JADX INFO: renamed from: a.a.a.a.b.i.d */
/* JADX INFO: loaded from: classes.dex */
public class C0172d {

    /* JADX INFO: renamed from: a */
    public JSONObject f1512a = new JSONObject();

    /* JADX INFO: renamed from: b */
    public String f1513b;

    /* JADX INFO: renamed from: c */
    public boolean f1514c;

    /* JADX INFO: renamed from: d */
    public String f1515d;

    /* JADX INFO: renamed from: e */
    public boolean f1516e;

    /* JADX INFO: renamed from: f */
    public boolean f1517f;

    /* JADX INFO: renamed from: g */
    public boolean f1518g;

    /* JADX INFO: renamed from: h */
    public String f1519h;

    /* JADX INFO: renamed from: i */
    public String f1520i;

    /* JADX INFO: renamed from: j */
    public C0125s f1521j;

    /* JADX INFO: renamed from: k */
    public C0124r f1522k;

    /* JADX INFO: renamed from: l */
    public OTPublishersHeadlessSDK f1523l;

    /* JADX INFO: renamed from: m */
    public Context f1524m;

    /* JADX INFO: renamed from: a */
    public static boolean m979a(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean zM239a = C0032d.m239a(jSONObject.optJSONArray("GeneralVendorsIds"));
        if (!jSONObject.has("SubGroups") && !zM239a) {
            return true;
        }
        if (!jSONObject.has("SubGroups") || jSONObject.getBoolean("IsIabPurpose")) {
            z = false;
        } else {
            JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
            z = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.getBoolean("IsIabPurpose")) {
                    return false;
                }
                if (!C0032d.m239a(jSONObject2.optJSONArray("GeneralVendorsIds"))) {
                    z = true;
                }
            }
        }
        return !zM239a || z;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m980b(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ShowSDKListLink") && !jSONObject.getBoolean("ShowSDKListLink")) {
            return false;
        }
        if (!jSONObject.getBoolean("IsIabPurpose") && jSONObject.getJSONArray("FirstPartyCookies").length() > 0) {
            return true;
        }
        if (jSONObject.has("SubGroups")) {
            JSONArray jSONArray = jSONObject.getJSONArray("SubGroups");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (!jSONArray.getJSONObject(i).getBoolean("IsIabPurpose")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public Bundle m981a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        try {
            if (!this.f1512a.getBoolean("IsIabPurpose") && !C0032d.m239a(this.f1512a.getJSONArray("GeneralVendorsIds"))) {
                map.put(this.f1515d, this.f1513b);
            }
            if (this.f1512a.has("SubGroups")) {
                JSONArray jSONArray = this.f1512a.getJSONArray("SubGroups");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!jSONObject.getBoolean("IsIabPurpose")) {
                        map.put(jSONObject.getString("CustomGroupId"), jSONObject.getString("Type"));
                    }
                }
            }
            bundle.putBoolean("IS_FILTERED_VENDOR_LIST", true);
            bundle.putString("PURPOSE_MAP", map.toString());
        } catch (JSONException e) {
            OTLogger.m2743a(6, "PC Detail", "General vendor: error while setting filtered groups " + e.getMessage());
        }
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m982a() {
        return this.f1512a;
    }

    /* JADX INFO: renamed from: b */
    public Bundle m983b(Map<String, String> map) {
        Bundle bundle = new Bundle();
        try {
            if (!this.f1514c && this.f1512a.getBoolean("IsIabPurpose")) {
                map.put(this.f1515d, this.f1513b);
            }
            if (this.f1512a.has("SubGroups")) {
                JSONArray jSONArray = this.f1512a.getJSONArray("SubGroups");
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject.getBoolean("IsIabPurpose")) {
                        map.put(jSONObject.getString("CustomGroupId"), jSONObject.getString("Type"));
                    }
                }
            }
            bundle.putBoolean("IS_FILTERED_VENDOR_LIST", true);
            bundle.putString("PURPOSE_MAP", map.toString());
        } catch (JSONException e) {
            OTLogger.m2743a(6, "PC Detail", "error in parsing vendorlist link on setCategoriesForVendorList: " + e.getMessage());
        }
        return bundle;
    }

    /* JADX INFO: renamed from: b */
    public String m984b() {
        return this.f1520i;
    }

    /* JADX INFO: renamed from: c */
    public C0125s m985c() {
        return this.f1521j;
    }

    /* JADX INFO: renamed from: d */
    public boolean m986d() {
        return this.f1518g;
    }

    /* JADX INFO: renamed from: e */
    public boolean m987e() {
        return this.f1517f;
    }

    /* JADX INFO: renamed from: f */
    public boolean m988f() {
        return this.f1516e;
    }

    /* JADX INFO: renamed from: a */
    public static void m977a(C0117k c0117k, String str, JSONObject jSONObject, String str2) {
        if (C0048h.m305b(c0117k.f755a.f724c)) {
            C0106b0 c0106b0 = c0117k.f755a;
            String strOptString = jSONObject.optString(str2);
            if (!C0048h.m305b(c0106b0.f724c)) {
                strOptString = c0106b0.f724c;
            }
            c0106b0.f724c = strOptString;
        }
        if (C0048h.m305b(c0117k.f755a.f726e)) {
            c0117k.f755a.f726e = str;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m976a(C0106b0 c0106b0, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String strOptString = jSONObject.optString("GroupNameMobile");
        if (C0048h.m305b(strOptString)) {
            strOptString = jSONObject.optString("GroupName");
        }
        c0106b0.f726e = strOptString;
        if (C0048h.m305b(c0106b0.f724c)) {
            c0106b0.f724c = jSONObject2.optString(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m978a(JSONObject jSONObject, TextView textView, TextView textView2, String str, C0016k c0016k) {
        if (!jSONObject.getBoolean("IsIabPurpose") && m979a(jSONObject)) {
            if (ViewProps.TOP.equalsIgnoreCase(str)) {
                textView2.setVisibility(0);
                textView = textView2;
            } else {
                textView.setVisibility(0);
            }
            textView.setText(c0016k.f36b);
        }
    }
}
