package com.google.android.gms.internal.measurement;

import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcq extends zzcn {
    @Override // com.google.android.gms.internal.measurement.zzcn
    public final URLConnection zza(URL url, String str) throws IOException {
        return URLConnectionInstrumentation.openConnection(url.openConnection());
    }

    private zzcq() {
    }
}
