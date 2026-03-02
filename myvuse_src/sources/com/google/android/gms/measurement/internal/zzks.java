package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzks extends zzg {
    protected zzkt zza;
    private volatile zzkt zzb;
    private volatile zzkt zzc;
    private final Map<Activity, zzkt> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzkt zzg;
    private zzkt zzh;
    private boolean zzi;
    private final Object zzj;

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

    private final zzkt zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzkt zzktVar = this.zzd.get(activity);
        if (zzktVar == null) {
            zzkt zzktVar2 = new zzkt(null, zza(activity.getClass(), "Activity"), zzq().zzm());
            this.zzd.put(activity, zzktVar2);
            zzktVar = zzktVar2;
        }
        return this.zzg != null ? this.zzg : zzktVar;
    }

    public final zzkt zzaa() {
        return this.zzb;
    }

    public final zzkt zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzkt zzktVar = this.zza;
        return zzktVar != null ? zzktVar : this.zzh;
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

    private final String zza(Class<?> cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] strArrSplit = canonicalName.split("\\.");
        if (strArrSplit.length > 0) {
            str2 = strArrSplit[strArrSplit.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    static /* synthetic */ void zza(zzks zzksVar, Bundle bundle, zzkt zzktVar, zzkt zzktVar2, long j) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzksVar.zza(zzktVar, zzktVar2, j, true, zzksVar.zzq().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    public zzks(zzhj zzhjVar) {
        super(zzhjVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zza(Activity activity, zzkt zzktVar, boolean z) {
        zzkt zzktVar2;
        zzkt zzktVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzktVar.zzb == null) {
            zzktVar2 = new zzkt(zzktVar.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzktVar.zzc, zzktVar.zze, zzktVar.zzf);
        } else {
            zzktVar2 = zzktVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzktVar2;
        zzl().zzb(new zzku(this, zzktVar2, zzktVar3, zzb().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzkt zzktVar, zzkt zzktVar2, long j, boolean z, Bundle bundle) {
        String str;
        zzt();
        boolean z2 = false;
        boolean z3 = (zzktVar2 != null && zzktVar2.zzc == zzktVar.zzc && Objects.equals(zzktVar2.zzb, zzktVar.zzb) && Objects.equals(zzktVar2.zza, zzktVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zznt.zza(zzktVar, bundle2, true);
            if (zzktVar2 != null) {
                if (zzktVar2.zza != null) {
                    bundle2.putString("_pn", zzktVar2.zza);
                }
                if (zzktVar2.zzb != null) {
                    bundle2.putString("_pc", zzktVar2.zzb);
                }
                bundle2.putLong("_pi", zzktVar2.zzc);
            }
            if (z2) {
                long jZza = zzp().zzb.zza(j);
                if (jZza > 0) {
                    zzq().zza(bundle2, jZza);
                }
            }
            if (!zze().zzv()) {
                bundle2.putLong("_mst", 1L);
            }
            if (zzktVar.zze) {
                str = "app";
            } else {
                str = "auto";
            }
            zzm().zza(str, "_vs", (!zzktVar.zze || zzktVar.zzf == 0) ? zzb().currentTimeMillis() : zzktVar.zzf, bundle2);
        }
        if (z2) {
            zza(this.zza, true, j);
        }
        this.zza = zzktVar;
        if (zzktVar.zze) {
            this.zzh = zzktVar;
        }
        zzo().zza(zzktVar);
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

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzkt(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzv()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzv()) {
            this.zzb = null;
            zzl().zzb(new zzkw(this, jElapsedRealtime));
        } else {
            zzkt zzktVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzkz(this, zzktVarZzd, jElapsedRealtime));
        }
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzv()) {
                    this.zzg = null;
                    zzl().zzb(new zzky(this));
                }
            }
        }
        if (!zze().zzv()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzkx(this));
        } else {
            zza(activity, zzd(activity), false);
            zza zzaVarZzc = zzc();
            zzaVarZzc.zzl().zzb(new zze(zzaVarZzc, zzaVarZzc.zzb().elapsedRealtime()));
        }
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzkt zzktVar;
        if (!zze().zzv() || bundle == null || (zzktVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzktVar.zzc);
        bundle2.putString("name", zzktVar.zza);
        bundle2.putString("referrer_name", zzktVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzkt zzktVar, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzktVar != null && zzktVar.zzd, z, j) || zzktVar == null) {
            return;
        }
        zzktVar.zzd = false;
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zze().zzv()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzkt zzktVar = this.zzb;
        if (zzktVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass(), "Activity");
        }
        boolean zEquals = Objects.equals(zzktVar.zzb, str2);
        boolean zEquals2 = Objects.equals(zzktVar.zza, str);
        if (zEquals && zEquals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzkt zzktVar2 = new zzkt(str, str2, zzq().zzm());
        this.zzd.put(activity, zzktVar2);
        zza(activity, zzktVar2, true);
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String strZza = null;
            if (bundle != null) {
                String string = bundle.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    strZza = string2;
                }
            } else {
                str = null;
            }
            if (strZza == null) {
                Activity activity = this.zze;
                if (activity != null) {
                    strZza = zza(activity.getClass(), "Activity");
                } else {
                    strZza = "Activity";
                }
            }
            String str2 = strZza;
            zzkt zzktVar = this.zzb;
            if (this.zzf && zzktVar != null) {
                this.zzf = false;
                boolean zEquals = Objects.equals(zzktVar.zzb, str2);
                boolean zEquals2 = Objects.equals(zzktVar.zza, str);
                if (zEquals && zEquals2) {
                    zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzp().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
            zzkt zzktVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzkt zzktVar3 = new zzkt(str, str2, zzq().zzm(), true, j);
            this.zzb = zzktVar3;
            this.zzc = zzktVar2;
            this.zzg = zzktVar3;
            zzl().zzb(new zzkv(this, bundle, zzktVar3, zzktVar2, zzb().elapsedRealtime()));
        }
    }
}
