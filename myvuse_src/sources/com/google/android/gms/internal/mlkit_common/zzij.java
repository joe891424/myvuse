package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzij {
    private final Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;

    public zzij(Context context) {
        TransportRuntime.initialize(context);
        final TransportFactory transportFactoryNewFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
        this.zza = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_common.zzif
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("json"), zzii.zza);
            }
        });
        this.zzb = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_common.zzig
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("proto"), zzih.zza);
            }
        });
    }

    public final void zza(zzhx zzhxVar) {
        this.zza.get().send(Event.ofTelemetry(zzhxVar.zza()));
    }
}
