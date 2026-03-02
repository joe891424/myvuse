package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.measurement.internal.zzin;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzax {
    public static final zzax zza = new zzax(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzin.zza, zziq> zzf;

    public final int zza() {
        return this.zzb;
    }

    public final int hashCode() {
        Boolean bool = this.zzd;
        int i = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it2 = this.zzf.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String strZzb = zzin.zzb((zziq) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zzin.zza) entry.getKey()).zze, strZzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public static zzax zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzax(null, i);
        }
        EnumMap enumMap = new EnumMap(zzin.zza.class);
        for (zzin.zza zzaVar : zzip.DMA.zza()) {
            enumMap.put(zzaVar, zzin.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzax((EnumMap<zzin.zza, zziq>) enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    static zzax zza(zziq zziqVar, int i) {
        EnumMap enumMap = new EnumMap(zzin.zza.class);
        enumMap.put(zzin.zza.AD_USER_DATA, zziqVar);
        return new zzax((EnumMap<zzin.zza, zziq>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzax zza(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzin.zza.class);
        zzin.zza[] zzaVarArrZza = zzip.DMA.zza();
        int length = zzaVarArrZza.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            enumMap.put(zzaVarArrZza[i3], zzin.zza(strArrSplit[i2].charAt(0)));
            i3++;
            i2++;
        }
        return new zzax((EnumMap<zzin.zza, zziq>) enumMap, i, (Boolean) null, (String) null);
    }

    public final zziq zzc() {
        zziq zziqVar = this.zzf.get(zzin.zza.AD_USER_DATA);
        return zziqVar == null ? zziq.UNINITIALIZED : zziqVar;
    }

    public static Boolean zza(Bundle bundle) {
        zziq zziqVarZza;
        if (bundle == null || (zziqVarZza = zzin.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i = zzaw.zza[zziqVarZza.ordinal()];
        if (i != 3) {
            return i != 4 ? null : true;
        }
        return false;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzin.zza zzaVar : zzip.DMA.zza()) {
            sb.append(":");
            sb.append(zzin.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("source=").append(zzin.zza(this.zzb));
        for (zzin.zza zzaVar : zzip.DMA.zza()) {
            sbAppend.append(",");
            sbAppend.append(zzaVar.zze);
            sbAppend.append("=");
            zziq zziqVar = this.zzf.get(zzaVar);
            if (zziqVar == null) {
                sbAppend.append("uninitialized");
            } else {
                int i = zzaw.zza[zziqVar.ordinal()];
                if (i == 1) {
                    sbAppend.append("uninitialized");
                } else if (i == 2) {
                    sbAppend.append(Constants.COLLATION_DEFAULT);
                } else if (i == 3) {
                    sbAppend.append("denied");
                } else if (i == 4) {
                    sbAppend.append("granted");
                }
            }
        }
        if (this.zzd != null) {
            sbAppend.append(",isDmaRegion=").append(this.zzd);
        }
        if (this.zze != null) {
            sbAppend.append(",cpsDisplayStr=").append(this.zze);
        }
        return sbAppend.toString();
    }

    zzax(Boolean bool, int i) {
        this(bool, i, (Boolean) null, (String) null);
    }

    zzax(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap<zzin.zza, zziq> enumMap = new EnumMap<>(zzin.zza.class);
        this.zzf = enumMap;
        enumMap.put(zzin.zza.AD_USER_DATA, zzin.zza(bool));
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    private zzax(EnumMap<zzin.zza, zziq> enumMap, int i, Boolean bool, String str) {
        EnumMap<zzin.zza, zziq> enumMap2 = new EnumMap<>(zzin.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        if (this.zzc.equalsIgnoreCase(zzaxVar.zzc) && Objects.equals(this.zzd, zzaxVar.zzd)) {
            return Objects.equals(this.zze, zzaxVar.zze);
        }
        return false;
    }

    public final boolean zzg() {
        Iterator<zziq> it2 = this.zzf.values().iterator();
        while (it2.hasNext()) {
            if (it2.next() != zziq.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
