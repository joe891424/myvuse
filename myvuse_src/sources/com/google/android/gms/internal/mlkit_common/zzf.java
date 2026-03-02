package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzf {
    public static final zzf zza;
    public static final zzf zzb;
    private final boolean zzc;
    private final boolean zzd = false;
    private final zzaj<zzp> zze;

    static {
        zzd zzdVar = null;
        zze zzeVar = new zze(zzdVar);
        zzeVar.zzb();
        zza = zzeVar.zzc();
        zze zzeVar2 = new zze(zzdVar);
        zzeVar2.zza();
        zzb = zzeVar2.zzc();
    }

    /* synthetic */ zzf(boolean z, boolean z2, zzaj zzajVar, zzd zzdVar) {
        this.zzc = z;
        this.zze = zzajVar;
    }

    static /* synthetic */ boolean zzb(zzf zzfVar) {
        boolean z = zzfVar.zzd;
        return false;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:117)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:178)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    static /* synthetic */ int zzc(zzf zzfVar, Context context, zzo zzoVar) {
        zzaj<zzp> zzajVar = zzfVar.zze;
        int size = zzajVar.size();
        int i = 0;
        while (i < size) {
            zzp zzpVar = zzajVar.get(i);
            boolean z = zzfVar.zzc;
            int iZza = zzpVar.zza();
            int i2 = iZza - 1;
            if (iZza == 0) {
                throw null;
            }
            i++;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == 1) {
                return 2;
            }
        }
        return 3;
    }
}
