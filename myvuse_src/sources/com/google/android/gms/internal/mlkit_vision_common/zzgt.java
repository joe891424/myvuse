package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@16.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgt {
    private final Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;

    public zzgt(Context context) {
        TransportRuntime.initialize(context);
        final TransportFactory transportFactoryNewFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
        this.zza = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzgp
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("json"), zzgs.zza);
            }
        });
        this.zzb = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzgq
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("proto"), zzgr.zza);
            }
        });
    }

    public final void zza(zzgj zzgjVar) {
        this.zza.get().send(Event.ofTelemetry(zzgjVar.zza()));
    }
}
