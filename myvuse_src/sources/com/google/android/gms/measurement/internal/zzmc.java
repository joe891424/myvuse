package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzmc extends zznb {
    public final zzgm zza;
    public final zzgm zzb;
    public final zzgm zzc;
    public final zzgm zzd;
    public final zzgm zze;
    private final Map<String, zzmf> zzg;

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zznb
    protected final boolean zzc() {
        return false;
    }

    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzmf zzmfVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzt();
        long jElapsedRealtime = zzb().elapsedRealtime();
        zzmf zzmfVar2 = this.zzg.get(str);
        if (zzmfVar2 != null && jElapsedRealtime < zzmfVar2.zzc) {
            return new Pair<>(zzmfVar2.zza, Boolean.valueOf(zzmfVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long jZzd = zze().zzd(str) + jElapsedRealtime;
        try {
            try {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            } catch (PackageManager.NameNotFoundException unused) {
                if (zzmfVar2 != null && jElapsedRealtime < zzmfVar2.zzc + zze().zzc(str, zzbh.zzb)) {
                    return new Pair<>(zzmfVar2.zza, Boolean.valueOf(zzmfVar2.zzb));
                }
                advertisingIdInfo = null;
            }
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            zzmfVar = new zzmf("", false, jZzd);
        }
        if (advertisingIdInfo == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", false);
        }
        String id = advertisingIdInfo.getId();
        zzmfVar = id != null ? new zzmf(id, advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd) : new zzmf("", advertisingIdInfo.isLimitAdTrackingEnabled(), jZzd);
        this.zzg.put(str, zzmfVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zzmfVar.zza, Boolean.valueOf(zzmfVar.zzb));
    }

    final Pair<String, Boolean> zza(String str, zzin zzinVar) {
        if (zzinVar.zzi()) {
            return zza(str);
        }
        return new Pair<>("", false);
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
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

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
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

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzgw zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ zzhg zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzmc zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final /* bridge */ /* synthetic */ zzna zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    /* JADX INFO: renamed from: g_ */
    public final /* bridge */ /* synthetic */ zznp mo2390g_() {
        return super.mo2390g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    @Pure
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Deprecated
    final String zza(String str, boolean z) {
        String str2;
        zzt();
        if (!z) {
            str2 = "00000000-0000-0000-0000-000000000000";
        } else {
            str2 = (String) zza(str).first;
        }
        MessageDigest messageDigestZzu = zznt.zzu();
        if (messageDigestZzu == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzu.digest(str2.getBytes())));
    }

    zzmc(zznc zzncVar) {
        super(zzncVar);
        this.zzg = new HashMap();
        zzgl zzglVarZzk = zzk();
        Objects.requireNonNull(zzglVarZzk);
        this.zza = new zzgm(zzglVarZzk, "last_delete_stale", 0L);
        zzgl zzglVarZzk2 = zzk();
        Objects.requireNonNull(zzglVarZzk2);
        this.zzb = new zzgm(zzglVarZzk2, "backoff", 0L);
        zzgl zzglVarZzk3 = zzk();
        Objects.requireNonNull(zzglVarZzk3);
        this.zzc = new zzgm(zzglVarZzk3, "last_upload", 0L);
        zzgl zzglVarZzk4 = zzk();
        Objects.requireNonNull(zzglVarZzk4);
        this.zzd = new zzgm(zzglVarZzk4, "last_upload_attempt", 0L);
        zzgl zzglVarZzk5 = zzk();
        Objects.requireNonNull(zzglVarZzk5);
        this.zze = new zzgm(zzglVarZzk5, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzij
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }
}
