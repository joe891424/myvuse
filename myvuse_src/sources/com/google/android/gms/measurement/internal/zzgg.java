package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
class zzgg extends BroadcastReceiver {
    private final zznc zza;
    private boolean zzb;
    private boolean zzc;

    zzgg(zznc zzncVar) {
        Preconditions.checkNotNull(zzncVar);
        this.zza = zzncVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.zza.zzs();
        String action = intent.getAction();
        this.zza.zzj().zzp().zza("NetworkBroadcastReceiver received action", action);
        if (BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION.equals(action)) {
            boolean zZzu = this.zza.zzh().zzu();
            if (this.zzc != zZzu) {
                this.zzc = zZzu;
                this.zza.zzl().zzb(new zzgj(this, zZzu));
                return;
            }
            return;
        }
        this.zza.zzj().zzu().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zza.zzs();
        this.zza.zzl().zzt();
        if (this.zzb) {
            return;
        }
        this.zza.zza().registerReceiver(this, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
        this.zzc = this.zza.zzh().zzu();
        this.zza.zzj().zzp().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }

    public final void zzb() {
        this.zza.zzs();
        this.zza.zzl().zzt();
        this.zza.zzl().zzt();
        if (this.zzb) {
            this.zza.zzj().zzp().zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                this.zza.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zza.zzj().zzg().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
