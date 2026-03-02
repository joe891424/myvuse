package p000a.p001a.p002a.p003a.p004a.p011i;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.perf.util.Constants;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p004a.C0048h;
import p000a.p001a.p002a.p003a.p004a.p010g.C0045d;

/* JADX INFO: renamed from: a.a.a.a.a.i.e */
/* JADX INFO: loaded from: classes.dex */
public class C0053e {

    /* JADX INFO: renamed from: a */
    public final C0045d f112a;

    public C0053e(Context context) {
        this.f112a = new C0045d(context, "OTT_DEFAULT_USER", false);
    }

    /* JADX INFO: renamed from: a */
    public void m351a(String str) throws JSONException {
        if (C0048h.m305b(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("culture")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("culture");
            if (jSONObject2.has("MobileData")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("MobileData");
                if (jSONObject3.has("multiProfileConsent")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("multiProfileConsent");
                    boolean zOptBoolean = jSONObject4.optBoolean(Constants.ENABLE_DISABLE, false);
                    boolean zOptBoolean2 = jSONObject4.optBoolean("downloadDataAfterSwitch", false);
                    int iOptInt = jSONObject4.optInt("maxProfilesLimit", 6);
                    OTLogger.m2743a(3, "MultiprofileConsent", "Multiprofile consent isEnabled = " + zOptBoolean + ", downloadAfterSwitch = " + zOptBoolean2 + " , maximumProfileLimit = " + iOptInt);
                    SharedPreferences.Editor editorEdit = this.f112a.m271a().edit();
                    editorEdit.putBoolean("OT_MULTI_PROFILE_CONSENT_ENABLED", zOptBoolean);
                    editorEdit.putBoolean("OT_MULTI_PROFILE_DOWNLOAD_DATA_AFTER_SWITCH", zOptBoolean2);
                    editorEdit.putInt("OT_MULTI_PROFILE_MAXIMUM_PROFILES_LIMIT", iOptInt);
                    editorEdit.apply();
                }
            }
        }
    }
}
