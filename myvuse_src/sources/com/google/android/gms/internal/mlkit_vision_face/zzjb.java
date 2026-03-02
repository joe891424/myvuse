package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.2 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjb {
    private final Provider<Transport<byte[]>> zza;
    private final Provider<Transport<byte[]>> zzb;

    public zzjb(Context context) {
        TransportRuntime.initialize(context);
        final TransportFactory transportFactoryNewFactory = TransportRuntime.getInstance().newFactory(CCTDestination.INSTANCE);
        this.zza = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzix
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("json"), zzja.zza);
            }
        });
        this.zzb = new Lazy(new Provider(transportFactoryNewFactory) { // from class: com.google.android.gms.internal.mlkit_vision_face.zziy
            private final TransportFactory zza;

            {
                this.zza = transportFactoryNewFactory;
            }

            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return this.zza.getTransport("FIREBASE_ML_SDK", byte[].class, Encoding.m2320of("proto"), zziz.zza);
            }
        });
    }

    public final void zza(zziq zziqVar) {
        this.zza.get().send(Event.ofTelemetry(zziqVar.zza()));
    }
}
