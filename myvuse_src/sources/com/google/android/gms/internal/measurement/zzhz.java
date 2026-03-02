package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhz implements Comparator<zzhx> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzhx zzhxVar, zzhx zzhxVar2) {
        zzhx zzhxVar3 = zzhxVar;
        zzhx zzhxVar4 = zzhxVar2;
        zzid zzidVar = (zzid) zzhxVar3.iterator();
        zzid zzidVar2 = (zzid) zzhxVar4.iterator();
        while (zzidVar.hasNext() && zzidVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzhx.zza(zzidVar.zza())).compareTo(Integer.valueOf(zzhx.zza(zzidVar2.zza())));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzhxVar3.zzb()).compareTo(Integer.valueOf(zzhxVar4.zzb()));
    }

    zzhz() {
    }
}
