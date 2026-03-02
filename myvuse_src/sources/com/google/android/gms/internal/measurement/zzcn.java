package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcn {
    private static zzcn zza = new zzcq();

    public static synchronized zzcn zza() {
        return zza;
    }

    public abstract URLConnection zza(URL url, String str) throws IOException;
}
