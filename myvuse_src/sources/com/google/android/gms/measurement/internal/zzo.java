package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzpd;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends BroadcastReceiver {
    private final zzhj zza;

    public zzo(zzhj zzhjVar) {
        this.zza = zzhjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        action.hashCode();
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzhj zzhjVar = this.zza;
            if (zzpd.zza() && zzhjVar.zzf().zzf(null, zzbh.zzcc)) {
                zzhjVar.zzj().zzp().zza("App receiver notified triggers are available");
                zzhjVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhj zzhjVar2 = zzhjVar;
                        if (!zzhjVar2.zzt().zzw()) {
                            zzhjVar2.zzj().zzu().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        final zziz zzizVarZzp = zzhjVar2.zzp();
                        Objects.requireNonNull(zzizVarZzp);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzr
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzizVarZzp.zzao();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzj().zzu().zza("App receiver called with unknown action");
    }
}
