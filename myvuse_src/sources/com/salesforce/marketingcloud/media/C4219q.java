package com.salesforce.marketingcloud.media;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.salesforce.marketingcloud.C4170g;
import com.salesforce.marketingcloud.media.AbstractC4223u;
import com.salesforce.marketingcloud.media.C4217o;
import com.salesforce.marketingcloud.media.C4221s;
import com.salesforce.marketingcloud.util.C4388g;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.media.q */
/* JADX INFO: loaded from: classes6.dex */
public class C4219q extends AbstractC4223u {

    /* JADX INFO: renamed from: b */
    private static final String f5100b = C4170g.m3197a("NetworkRequestHandler");

    /* JADX INFO: renamed from: a */
    private final C4220r f5101a;

    public C4219q(C4220r c4220r) {
        this.f5101a = c4220r;
    }

    @Override // com.salesforce.marketingcloud.media.AbstractC4223u
    /* JADX INFO: renamed from: a */
    public boolean mo3539a(C4221s c4221s) {
        try {
            String lowerCase = c4221s.f5107a.getScheme().toLowerCase(Locale.ENGLISH);
            return "http".equalsIgnoreCase(lowerCase) || "https".equalsIgnoreCase(lowerCase);
        } catch (Exception e) {
            C4170g.m3207b(f5100b, e, "Unable to get scheme from request.", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.salesforce.marketingcloud.media.AbstractC4223u
    /* JADX INFO: renamed from: a */
    public void mo3538a(C4217o c4217o, C4221s c4221s, AbstractC4223u.a aVar) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        String string = c4221s.f5107a.toString();
        Bitmap bitmapM3577a = m3577a(string, c4221s);
        if (bitmapM3577a != null) {
            aVar.mo3560a(new AbstractC4223u.b(bitmapM3577a, C4217o.b.DISK));
            return;
        }
        C4170g.m3202a("IMAGE", "Starting network request for image", new Object[0]);
        HttpURLConnection.setFollowRedirects(true);
        ?? r1 = 0;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(string).openConnection())));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            httpsURLConnection.setRequestMethod("GET");
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (C4221s.b.m3600c(c4221s.f5110d)) {
                byte[] bArrM4317a = C4388g.m4317a(inputStream);
                C4388g.m4312a((Closeable) inputStream);
                this.f5101a.m3582a(string, new ByteArrayInputStream(bArrM4317a));
                inputStream = new ByteArrayInputStream(bArrM4317a);
            }
            Bitmap bitmapM3614a = AbstractC4223u.m3614a(inputStream, c4221s);
            C4388g.m4312a((Closeable) inputStream);
            C4217o.b bVar = C4217o.b.NETWORK;
            aVar.mo3560a(new AbstractC4223u.b(bitmapM3614a, bVar));
            httpsURLConnection.disconnect();
            r1 = bVar;
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection2 = httpsURLConnection;
            C4170g.m3207b("IMAGE", e, "Image network error for URL: %s", string);
            aVar.mo3561a(e);
            r1 = httpsURLConnection2;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
                r1 = httpsURLConnection2;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = httpsURLConnection;
            if (r1 != 0) {
                r1.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m3577a(String str, C4221s c4221s) throws IOException {
        InputStream inputStreamM3580a = this.f5101a.m3580a(str);
        Bitmap bitmapM3614a = null;
        if (inputStreamM3580a == null) {
            return null;
        }
        try {
            bitmapM3614a = AbstractC4223u.m3614a(inputStreamM3580a, c4221s);
            C4388g.m4312a((Closeable) inputStreamM3580a);
            return bitmapM3614a;
        } catch (Exception e) {
            C4170g.m3203a(f5100b, e, "Failed to decode cache into Bitmap.", new Object[0]);
            return bitmapM3614a;
        }
    }
}
