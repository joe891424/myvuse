package com.google.android.gms.internal.measurement;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzmo {
    public static final zzmo zza;
    public static final zzmo zzb;
    public static final zzmo zzc;
    public static final zzmo zzd;
    public static final zzmo zze;
    public static final zzmo zzf;
    public static final zzmo zzg;
    public static final zzmo zzh;
    public static final zzmo zzi;
    public static final zzmo zzj;
    public static final zzmo zzk;
    public static final zzmo zzl;
    public static final zzmo zzm;
    public static final zzmo zzn;
    public static final zzmo zzo;
    public static final zzmo zzp;
    public static final zzmo zzq;
    public static final zzmo zzr;
    private static final /* synthetic */ zzmo[] zzs;
    private final zzmy zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzmy zzb() {
        return this.zzt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        zzmo zzmoVar = new zzmo("DOUBLE", 0, zzmy.DOUBLE, 1);
        zza = zzmoVar;
        zzmo zzmoVar2 = new zzmo("FLOAT", 1, zzmy.FLOAT, 5);
        zzb = zzmoVar2;
        zzmo zzmoVar3 = new zzmo("INT64", 2, zzmy.LONG, 0);
        zzc = zzmoVar3;
        zzmo zzmoVar4 = new zzmo("UINT64", 3, zzmy.LONG, 0);
        zzd = zzmoVar4;
        zzmo zzmoVar5 = new zzmo("INT32", 4, zzmy.INT, 0);
        zze = zzmoVar5;
        zzmo zzmoVar6 = new zzmo("FIXED64", 5, zzmy.LONG, 1);
        zzf = zzmoVar6;
        zzmo zzmoVar7 = new zzmo("FIXED32", 6, zzmy.INT, 5);
        zzg = zzmoVar7;
        zzmo zzmoVar8 = new zzmo("BOOL", 7, zzmy.BOOLEAN, 0);
        zzh = zzmoVar8;
        int i = 2;
        zzmn zzmnVar = new zzmn("STRING", zzmy.STRING);
        zzi = zzmnVar;
        zzmp zzmpVar = new zzmp("GROUP", zzmy.MESSAGE);
        zzj = zzmpVar;
        zzmr zzmrVar = new zzmr("MESSAGE", zzmy.MESSAGE);
        zzk = zzmrVar;
        zzmt zzmtVar = new zzmt("BYTES", zzmy.BYTE_STRING);
        zzl = zzmtVar;
        zzmo zzmoVar9 = new zzmo("UINT32", 12, zzmy.INT, 0);
        zzm = zzmoVar9;
        zzmo zzmoVar10 = new zzmo("ENUM", 13, zzmy.ENUM, 0);
        zzn = zzmoVar10;
        zzmo zzmoVar11 = new zzmo("SFIXED32", 14, zzmy.INT, 5);
        zzo = zzmoVar11;
        zzmo zzmoVar12 = new zzmo("SFIXED64", 15, zzmy.LONG, 1);
        zzp = zzmoVar12;
        zzmo zzmoVar13 = new zzmo("SINT32", 16, zzmy.INT, 0);
        zzq = zzmoVar13;
        zzmo zzmoVar14 = new zzmo("SINT64", 17, zzmy.LONG, 0);
        zzr = zzmoVar14;
        zzs = new zzmo[]{zzmoVar, zzmoVar2, zzmoVar3, zzmoVar4, zzmoVar5, zzmoVar6, zzmoVar7, zzmoVar8, zzmnVar, zzmpVar, zzmrVar, zzmtVar, zzmoVar9, zzmoVar10, zzmoVar11, zzmoVar12, zzmoVar13, zzmoVar14};
    }

    private zzmo(String str, int i, zzmy zzmyVar, int i2) {
        this.zzt = zzmyVar;
        this.zzu = i2;
    }

    public static zzmo[] values() {
        return (zzmo[]) zzs.clone();
    }
}
