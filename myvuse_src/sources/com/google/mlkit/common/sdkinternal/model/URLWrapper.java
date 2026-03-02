package com.google.mlkit.common.sdkinternal.model;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class URLWrapper {
    private final URL zza;

    public URLWrapper(String str) throws MalformedURLException {
        this.zza = new URL(str);
    }

    public URLConnection openConnection() throws IOException {
        return (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(this.zza.openConnection()));
    }
}
