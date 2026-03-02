package p000a.p001a.p002a.p003a.p004a.p009f;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.fragment.ViewOnClickListenerC0168n;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: renamed from: a.a.a.a.a.f.c */
/* JADX INFO: loaded from: classes.dex */
public class C0039c implements Callback<String> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ JSONObject[] f87a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewOnClickListenerC0168n.a f88b;

    public C0039c(C0038b c0038b, JSONObject[] jSONObjectArr, ViewOnClickListenerC0168n.a aVar) {
        this.f87a = jSONObjectArr;
        this.f88b = aVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<String> call, Throwable th) {
        OTLogger.m2743a(6, "NetworkRequestHandler", "IAB Vendor Disclosure API Failed :  " + th.getMessage());
        this.f88b.mo948a(new JSONObject());
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<String> call, Response<String> response) {
        this.f87a[0] = new JSONObject();
        OTLogger.m2743a(4, "NetworkRequestHandler", "IAB Vendor Disclosure API Success : " + response.body());
        try {
            if (response.body() != null) {
                this.f87a[0] = new JSONObject(response.body());
                this.f88b.mo948a(this.f87a[0]);
            }
        } catch (JSONException e) {
            OTLogger.m2743a(6, "NetworkRequestHandler", "Error while fetching IAB Vendor Disclosure details:  " + e.getMessage());
            this.f88b.mo948a(new JSONObject());
        }
    }
}
