package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzin;
import java.util.EnumMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaj {
    private final EnumMap<zzin.zza, zzai> zza;

    public final zzai zza(zzin.zza zzaVar) {
        zzai zzaiVar = this.zza.get(zzaVar);
        return zzaiVar == null ? zzai.UNSET : zzaiVar;
    }

    public static zzaj zza(String str) {
        EnumMap enumMap = new EnumMap(zzin.zza.class);
        if (str.length() >= zzin.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzin.zza[] zzaVarArrValues = zzin.zza.values();
                int length = zzaVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(zzaVarArrValues[i], zzai.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzaj(enumMap);
            }
        }
        return new zzaj();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (zzin.zza zzaVar : zzin.zza.values()) {
            zzai zzaiVar = this.zza.get(zzaVar);
            if (zzaiVar == null) {
                zzaiVar = zzai.UNSET;
            }
            sb.append(zzaiVar.zzl);
        }
        return sb.toString();
    }

    zzaj() {
        this.zza = new EnumMap<>(zzin.zza.class);
    }

    private zzaj(EnumMap<zzin.zza, zzai> enumMap) {
        EnumMap<zzin.zza, zzai> enumMap2 = new EnumMap<>(zzin.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.measurement.internal.zzin.zza r3, int r4) {
        /*
            r2 = this;
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.INITIALIZATION
            goto L20
        L18:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.MANIFEST
            goto L20
        L1b:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.API
            goto L20
        L1e:
            com.google.android.gms.measurement.internal.zzai r0 = com.google.android.gms.measurement.internal.zzai.TCF
        L20:
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zzai> r4 = r2.zza
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaj.zza(com.google.android.gms.measurement.internal.zzin$zza, int):void");
    }

    public final void zza(zzin.zza zzaVar, zzai zzaiVar) {
        this.zza.put(zzaVar, zzaiVar);
    }
}
