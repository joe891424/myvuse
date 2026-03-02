package p000a.p001a.p002a.p003a.p014b.p021e;

import android.content.Context;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: a.a.a.a.b.e.a */
/* JADX INFO: loaded from: classes.dex */
public class C0103a {

    /* JADX INFO: renamed from: a */
    public Context f711a;

    public C0103a(Context context) {
        this.f711a = context;
    }

    /* JADX INFO: renamed from: a */
    public C0107c m613a(JSONObject jSONObject, String str) {
        C0107c c0107c = new C0107c();
        try {
            if (jSONObject.has(str)) {
                c0107c.f734g = jSONObject.getString(str);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "OneTrust", "Error in parsing button property :" + e.getMessage());
        }
        return c0107c;
    }
}
