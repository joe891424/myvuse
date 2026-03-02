package p000a.p001a.p002a.p003a.p014b.p017d.p020c;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p014b.p017d.p019b.C0089e;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: renamed from: a.a.a.a.b.d.c.j */
/* JADX INFO: loaded from: classes.dex */
public class C0099j implements Callback<String> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewOnKeyListenerC0100k f634a;

    public C0099j(ViewOnKeyListenerC0100k viewOnKeyListenerC0100k) {
        this.f634a = viewOnKeyListenerC0100k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m580a(Response response) {
        try {
            if (response.body() != null) {
                JSONObject jSONObjectM585a = this.f634a.m585a(C0089e.m509a(), new JSONObject((String) response.body()));
                ViewOnKeyListenerC0100k viewOnKeyListenerC0100k = this.f634a;
                viewOnKeyListenerC0100k.f661w.f301a = jSONObjectM585a;
                viewOnKeyListenerC0100k.f638D = 1;
            }
        } catch (Exception e) {
            OTLogger.m2743a(6, "TV Vendor", "Error while fetching IAB Vendor Disclosure details:  " + e.getMessage());
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<String> call, Throwable th) {
        OTLogger.m2743a(6, "TV Vendor", "IAB Vendor Disclosure API Failed :  " + th.getMessage());
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<String> call, final Response<String> response) {
        OTLogger.m2743a(4, "TV Vendor", "IAB Vendor Disclosure API Success");
        new Thread(new Runnable() { // from class: a.a.a.a.b.d.c.j$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m580a(response);
            }
        }).start();
    }
}
