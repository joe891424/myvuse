package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhc implements com.google.android.gms.internal.measurement.zzv {
    private final /* synthetic */ zzgw zza;

    zzhc(zzgw zzgwVar) {
        this.zza = zzgwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z, boolean z2) {
        int i = zzhe.zza[zzsVar.ordinal()];
        zzfy zzfyVarZzn = i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp() : z ? this.zza.zzj().zzw() : !z2 ? this.zza.zzj().zzv() : this.zza.zzj().zzu() : z ? this.zza.zzj().zzm() : !z2 ? this.zza.zzj().zzh() : this.zza.zzj().zzg() : this.zza.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzfyVarZzn.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzfyVarZzn.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzfyVarZzn.zza(str);
        } else {
            zzfyVarZzn.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
