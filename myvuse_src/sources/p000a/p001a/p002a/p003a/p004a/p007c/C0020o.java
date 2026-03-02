package p000a.p001a.p002a.p003a.p004a.p007c;

import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: renamed from: a.a.a.a.a.c.o */
/* JADX INFO: loaded from: classes.dex */
public class C0020o implements Callback<String> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0021p f42a;

    public C0020o(C0021p c0021p) {
        this.f42a = c0021p;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<String> call, Throwable th) {
        OTLogger.m2743a(6, "GoogleVendorHelper", "Google Vendor list Api Failed :  " + th.getMessage());
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<String> call, Response<String> response) {
        OTLogger.m2743a(4, "GoogleVendorHelper", "Google Vendor list Api Success : " + response.body());
        C0021p c0021p = this.f42a;
        long jReceivedResponseAtMillis = response.raw().receivedResponseAtMillis();
        long jSentRequestAtMillis = response.raw().sentRequestAtMillis();
        c0021p.getClass();
        OTLogger.m2743a(2, "GoogleVendorHelper", "Google vendor api response time : " + jReceivedResponseAtMillis + "," + jSentRequestAtMillis);
        long j = jReceivedResponseAtMillis - jSentRequestAtMillis;
        OTLogger.m2743a(3, "OneTrust", String.format("%s %d.%d s", "Time taken for Google Vendor data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j)), Long.valueOf(j % 1000)));
        C0021p c0021p2 = this.f42a;
        c0021p2.m116a(c0021p2.f43a, response.body());
    }
}
