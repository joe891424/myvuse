package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzlb extends zzg {
    private final zzlw zza;
    private zzfp zzb;
    private volatile Boolean zzc;
    private final zzav zzd;
    private final zzmv zze;
    private final List<Runnable> zzf;
    private final zzav zzg;

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    private final zzn zzc(boolean z) {
        return zzg().zza(z ? zzj().zzx() : null);
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    protected final zzal zzaa() {
        zzt();
        zzu();
        zzfp zzfpVar = this.zzb;
        if (zzfpVar == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzn zznVarZzc = zzc(false);
        Preconditions.checkNotNull(zznVarZzc);
        try {
            zzal zzalVarZza = zzfpVar.zza(zznVarZzc);
            zzaq();
            return zzalVarZza;
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to get consents; remote exception", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfq zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzft zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzfv zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzhg zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziz zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzks zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzlb zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzml zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    final Boolean zzab() {
        return this.zzc;
    }

    static /* synthetic */ void zzd(zzlb zzlbVar) {
        zzlbVar.zzt();
        if (zzlbVar.zzak()) {
            zzlbVar.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzlbVar.zzae();
        }
    }

    static /* synthetic */ void zza(zzlb zzlbVar, ComponentName componentName) {
        zzlbVar.zzt();
        if (zzlbVar.zzb != null) {
            zzlbVar.zzb = null;
            zzlbVar.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzlbVar.zzt();
            zzlbVar.zzad();
        }
    }

    protected zzlb(zzhj zzhjVar) {
        super(zzhjVar);
        this.zzf = new ArrayList();
        this.zze = new zzmv(zzhjVar.zzb());
        this.zza = new zzlw(this);
        this.zzd = new zzlc(this, zzhjVar);
        this.zzg = new zzlp(this, zzhjVar);
    }

    protected final void zzac() {
        zzt();
        zzu();
        zzn zznVarZzc = zzc(true);
        zzh().zzab();
        zza(new zzlk(this, zznVarZzc));
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    final void zzad() {
        zzt();
        zzu();
        if (zzak()) {
            return;
        }
        if (zzao()) {
            this.zza.zza();
            return;
        }
        if (zze().zzx()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    public final void zzae() {
        zzt();
        zzu();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzap() {
        zzt();
        zzj().zzp().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it2 = this.zzf.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().run();
            } catch (RuntimeException e) {
                zzj().zzg().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar) {
        zzt();
        zzu();
        zza(new zzll(this, zzc(false), zzddVar));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza(new zzli(this, atomicReference, zzc(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar, String str, String str2) {
        zzt();
        zzu();
        zza(new zzlu(this, str, str2, zzc(false), zzddVar));
    }

    protected final void zza(AtomicReference<List<zzac>> atomicReference, String str, String str2, String str3) {
        zzt();
        zzu();
        zza(new zzlv(this, atomicReference, str, str2, str3, zzc(false)));
    }

    protected final void zza(AtomicReference<List<zzmu>> atomicReference, Bundle bundle) {
        zzt();
        zzu();
        zza(new zzlh(this, atomicReference, zzc(false), bundle));
    }

    protected final void zza(AtomicReference<List<zzno>> atomicReference, boolean z) {
        zzt();
        zzu();
        zza(new zzle(this, atomicReference, zzc(false), z));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar, String str, String str2, boolean z) {
        zzt();
        zzu();
        zza(new zzlf(this, str, str2, zzc(false), z, zzddVar));
    }

    protected final void zza(AtomicReference<List<zzno>> atomicReference, String str, String str2, String str3, boolean z) {
        zzt();
        zzu();
        zza(new zzlx(this, atomicReference, str, str2, str3, zzc(false), z));
    }

    final /* synthetic */ void zzaf() {
        zzfp zzfpVar = this.zzb;
        if (zzfpVar == null) {
            zzj().zzg().zza("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzn zznVarZzc = zzc(false);
            Preconditions.checkNotNull(zznVarZzc);
            zzfpVar.zzf(zznVarZzc);
            zzaq();
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to send Dma consent settings to the service", e);
        }
    }

    final /* synthetic */ void zzag() {
        zzfp zzfpVar = this.zzb;
        if (zzfpVar == null) {
            zzj().zzg().zza("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzn zznVarZzc = zzc(false);
            Preconditions.checkNotNull(zznVarZzc);
            zzfpVar.zzh(zznVarZzc);
            zzaq();
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to send storage consent settings to the service", e);
        }
    }

    protected final void zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotNull(zzbfVar);
        zzt();
        zzu();
        zza(new zzlt(this, true, zzc(true), zzh().zza(zzbfVar), zzbfVar, str));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdd zzddVar, zzbf zzbfVar, String str) {
        zzt();
        zzu();
        if (zzq().zza(12451000) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzddVar, new byte[0]);
        } else {
            zza(new zzlo(this, zzbfVar, str, zzddVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaq() {
        zzt();
        this.zze.zzb();
        this.zzd.zza(zzbh.zzaj.zza(null).longValue());
    }

    protected final void zzah() {
        zzt();
        zzu();
        zzn zznVarZzc = zzc(false);
        zzh().zzaa();
        zza(new zzlj(this, zznVarZzc));
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzak()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzad();
        }
    }

    final void zza(zzfp zzfpVar, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) throws Throwable {
        int size;
        zzt();
        zzu();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> listZza = zzh().zza(100);
            if (listZza != null) {
                arrayList.addAll(listZza);
                size = listZza.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbf) {
                    try {
                        zzfpVar.zza((zzbf) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e) {
                        zzj().zzg().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzno) {
                    try {
                        zzfpVar.zza((zzno) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e2) {
                        zzj().zzg().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzfpVar.zza((zzac) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e3) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    protected final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzu();
        zza(new zzls(this, true, zzc(true), zzh().zza(zzacVar), new zzac(zzacVar), zzacVar));
    }

    protected final void zza(boolean z) {
        zzt();
        zzu();
        if ((!com.google.android.gms.internal.measurement.zznh.zza() || !zze().zza(zzbh.zzdb)) && z) {
            zzh().zzaa();
        }
        if (zzam()) {
            zza(new zzlq(this, zzc(false)));
        }
    }

    protected final void zza(zzkt zzktVar) {
        zzt();
        zzu();
        zza(new zzln(this, zzktVar));
    }

    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza(new zzlm(this, zzc(false), bundle));
    }

    protected final void zzai() {
        zzt();
        zzu();
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzld
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaf();
            }
        });
    }

    protected final void zzaj() {
        zzt();
        zzu();
        zza(new zzlr(this, zzc(true)));
    }

    protected final void zza(zzfp zzfpVar) {
        zzt();
        Preconditions.checkNotNull(zzfpVar);
        this.zzb = zzfpVar;
        zzaq();
        zzap();
    }

    protected final void zzb(boolean z) {
        zzt();
        zzu();
        if ((!com.google.android.gms.internal.measurement.zznh.zza() || !zze().zza(zzbh.zzdb)) && z) {
            zzh().zzaa();
        }
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzla
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzag();
            }
        });
    }

    protected final void zza(zzno zznoVar) {
        zzt();
        zzu();
        zza(new zzlg(this, zzc(true), zzh().zza(zznoVar), zznoVar));
    }

    public final boolean zzak() {
        zzt();
        zzu();
        return this.zzb != null;
    }

    final boolean zzal() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= 200900;
    }

    final boolean zzam() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= zzbh.zzbp.zza(null).intValue();
    }

    final boolean zzan() {
        zzt();
        zzu();
        return !zzao() || zzq().zzg() >= 241200;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean zzao() {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlb.zzao():boolean");
    }
}
