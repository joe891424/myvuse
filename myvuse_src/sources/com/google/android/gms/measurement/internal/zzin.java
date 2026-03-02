package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.hermes.intl.Constants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzin {
    public static final zzin zza = new zzin(null, null, 100);
    private final EnumMap<zza, zziq> zzb;
    private final int zzc;

    public static boolean zza(int i, int i2) {
        if (i == -20 && i2 == -30) {
            return true;
        }
        return (i == -30 && i2 == -20) || i == i2 || i < i2;
    }

    static char zza(zziq zziqVar) {
        if (zziqVar == null) {
            return '-';
        }
        int iOrdinal = zziqVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int iHashCode = this.zzc * 17;
        Iterator<zziq> it2 = this.zzb.values().iterator();
        while (it2.hasNext()) {
            iHashCode = (iHashCode * 31) + it2.next().hashCode();
        }
        return iHashCode;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it2 = this.zzb.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String strZzb = zzb((zziq) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zza) entry.getKey()).zze, strZzb);
            }
        }
        return bundle;
    }

    static zziq zza(String str) {
        if (str == null) {
            return zziq.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zziq.GRANTED;
        }
        if (str.equals("denied")) {
            return zziq.DENIED;
        }
        return zziq.UNINITIALIZED;
    }

    public final zziq zzc() {
        zziq zziqVar = this.zzb.get(zza.AD_STORAGE);
        return zziqVar == null ? zziq.UNINITIALIZED : zziqVar;
    }

    public final zziq zzd() {
        zziq zziqVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zziqVar == null ? zziq.UNINITIALIZED : zziqVar;
    }

    static zziq zza(char c) {
        if (c == '+') {
            return zziq.DEFAULT;
        }
        if (c == '0') {
            return zziq.DENIED;
        }
        if (c == '1') {
            return zziq.GRANTED;
        }
        return zziq.UNINITIALIZED;
    }

    static zziq zza(Boolean bool) {
        if (bool == null) {
            return zziq.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zziq.GRANTED;
        }
        return zziq.DENIED;
    }

    public static zzin zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzin(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzip.STORAGE.zzd) {
            enumMap.put(zzaVar, zza(bundle.getString(zzaVar.zze)));
        }
        return new zzin(enumMap, i);
    }

    public static zzin zza(zziq zziqVar, zziq zziqVar2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put(zza.AD_STORAGE, zziqVar);
        enumMap.put(zza.ANALYTICS_STORAGE, zziqVar2);
        return new zzin(enumMap, -10);
    }

    public static zzin zzb(String str) {
        return zza(str, 100);
    }

    public static zzin zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzip.STORAGE.zza();
        for (int i2 = 0; i2 < zzaVarArrZza.length; i2++) {
            zza zzaVar = zzaVarArrZza[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put(zzaVar, zza(str.charAt(i3)));
            } else {
                enumMap.put(zzaVar, zziq.UNINITIALIZED);
            }
        }
        return new zzin(enumMap, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzin zza(com.google.android.gms.measurement.internal.zzin r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzin$zza> r1 = com.google.android.gms.measurement.internal.zzin.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzip r1 = com.google.android.gms.measurement.internal.zzip.STORAGE
            com.google.android.gms.measurement.internal.zzin$zza[] r1 = com.google.android.gms.measurement.internal.zzip.zza(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L54
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zziq> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zziq r5 = (com.google.android.gms.measurement.internal.zziq) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zziq> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zziq r6 = (com.google.android.gms.measurement.internal.zziq) r6
            if (r5 != 0) goto L26
            goto L37
        L26:
            if (r6 != 0) goto L29
            goto L4c
        L29:
            com.google.android.gms.measurement.internal.zziq r7 = com.google.android.gms.measurement.internal.zziq.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L37
        L2e:
            com.google.android.gms.measurement.internal.zziq r7 = com.google.android.gms.measurement.internal.zziq.UNINITIALIZED
            if (r6 != r7) goto L33
            goto L4c
        L33:
            com.google.android.gms.measurement.internal.zziq r7 = com.google.android.gms.measurement.internal.zziq.DEFAULT
            if (r5 != r7) goto L39
        L37:
            r5 = r6
            goto L4c
        L39:
            com.google.android.gms.measurement.internal.zziq r7 = com.google.android.gms.measurement.internal.zziq.DEFAULT
            if (r6 != r7) goto L3e
            goto L4c
        L3e:
            com.google.android.gms.measurement.internal.zziq r7 = com.google.android.gms.measurement.internal.zziq.DENIED
            if (r5 == r7) goto L4a
            com.google.android.gms.measurement.internal.zziq r5 = com.google.android.gms.measurement.internal.zziq.DENIED
            if (r6 != r5) goto L47
            goto L4a
        L47:
            com.google.android.gms.measurement.internal.zziq r5 = com.google.android.gms.measurement.internal.zziq.GRANTED
            goto L4c
        L4a:
            com.google.android.gms.measurement.internal.zziq r5 = com.google.android.gms.measurement.internal.zziq.DENIED
        L4c:
            if (r5 == 0) goto L51
            r0.put(r4, r5)
        L51:
            int r3 = r3 + 1
            goto Lf
        L54:
            com.google.android.gms.measurement.internal.zzin r9 = new com.google.android.gms.measurement.internal.zzin
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zza(com.google.android.gms.measurement.internal.zzin):com.google.android.gms.measurement.internal.zzin");
    }

    public final zzin zzb(zzin zzinVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzip.STORAGE.zzd) {
            zziq zziqVar = this.zzb.get(zzaVar);
            if (zziqVar == zziq.UNINITIALIZED) {
                zziqVar = zzinVar.zzb.get(zzaVar);
            }
            if (zziqVar != null) {
                enumMap.put(zzaVar, zziqVar);
            }
        }
        return new zzin(enumMap, this.zzc);
    }

    public final Boolean zze() {
        zziq zziqVar = this.zzb.get(zza.AD_STORAGE);
        if (zziqVar == null) {
            return null;
        }
        int iOrdinal = zziqVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return true;
    }

    public final Boolean zzf() {
        zziq zziqVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        if (zziqVar == null) {
            return null;
        }
        int iOrdinal = zziqVar.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                return null;
            }
        }
        return true;
    }

    static String zza(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i == 90) {
            return "REMOTE_CONFIG";
        }
        if (i == 100) {
            return "UNKNOWN";
        }
        return "OTHER";
    }

    static String zzb(zziq zziqVar) {
        int iOrdinal = zziqVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzip.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string != null) {
                    if (string.equals("granted")) {
                        bool = Boolean.TRUE;
                    } else if (string.equals("denied")) {
                        bool = Boolean.FALSE;
                    }
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zzg() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzip r1 = com.google.android.gms.measurement.internal.zzip.STORAGE
            com.google.android.gms.measurement.internal.zzin$zza[] r1 = r1.zza()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzin$zza, com.google.android.gms.measurement.internal.zziq> r5 = r7.zzb
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zziq r4 = (com.google.android.gms.measurement.internal.zziq) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zzg():java.lang.String");
    }

    public final String zzh() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzip.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("source=").append(zza(this.zzc));
        for (zza zzaVar : zzip.STORAGE.zzd) {
            sbAppend.append(",");
            sbAppend.append(zzaVar.zze);
            sbAppend.append("=");
            zziq zziqVar = this.zzb.get(zzaVar);
            if (zziqVar == null) {
                sbAppend.append("uninitialized");
            } else {
                int iOrdinal = zziqVar.ordinal();
                if (iOrdinal == 0) {
                    sbAppend.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sbAppend.append(Constants.COLLATION_DEFAULT);
                } else if (iOrdinal == 2) {
                    sbAppend.append("denied");
                } else if (iOrdinal == 3) {
                    sbAppend.append("granted");
                }
            }
        }
        return sbAppend.toString();
    }

    private zzin(EnumMap<zza, zziq> enumMap, int i) {
        EnumMap<zza, zziq> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzin(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zziq> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put(zza.AD_STORAGE, zza(bool));
        enumMap.put(zza.ANALYTICS_STORAGE, zza(bool2));
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzin)) {
            return false;
        }
        zzin zzinVar = (zzin) obj;
        for (zza zzaVar : zzip.STORAGE.zzd) {
            if (this.zzb.get(zzaVar) != zzinVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzinVar.zzc;
    }

    public final boolean zza(zzin zzinVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zzinVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzi() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zziq.DENIED;
    }

    public final boolean zzj() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzk() {
        Iterator<zziq> it2 = this.zzb.values().iterator();
        while (it2.hasNext()) {
            if (it2.next() != zziq.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzin zzinVar) {
        return zzb(zzinVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final boolean zzb(zzin zzinVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            zziq zziqVar = this.zzb.get(zzaVar);
            zziq zziqVar2 = zzinVar.zzb.get(zzaVar);
            if (zziqVar == zziq.DENIED && zziqVar2 != zziq.DENIED) {
                return true;
            }
        }
        return false;
    }
}
