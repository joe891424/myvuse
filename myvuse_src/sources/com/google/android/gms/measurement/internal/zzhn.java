package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.firebase.messaging.Constants;
import com.newrelic.agent.android.util.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhn extends zzfo {
    private final zznc zza;
    private Boolean zzb;
    private String zzc;

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final zzal zza(zzn zznVar) {
        zzb(zznVar, false);
        Preconditions.checkNotEmpty(zznVar.zza);
        try {
            return (zzal) this.zza.zzl().zzb(new zzie(this, zznVar)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzfw.zza(zznVar.zza), e);
            return new zzal(null);
        }
    }

    final zzbf zzb(zzbf zzbfVar, zzn zznVar) {
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbfVar.zza) && zzbfVar.zzb != null && zzbfVar.zzb.zza() != 0) {
            String strZzd = zzbfVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(strZzd) || "referrer API".equals(strZzd)) {
                this.zza.zzj().zzn().zza("Event has been filtered ", zzbfVar.toString());
                return new zzbf("_cmpx", zzbfVar.zzb, zzbfVar.zzc, zzbfVar.zzd);
            }
        }
        return zzbfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final String zzb(zzn zznVar) {
        zzb(zznVar, false);
        return this.zza.zzb(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzmu> zza(zzn zznVar, Bundle bundle) {
        zzb(zznVar, false);
        Preconditions.checkNotNull(zznVar.zza);
        try {
            return (List) this.zza.zzl().zza(new zzih(this, zznVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzfw.zza(zznVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(zzn zznVar, boolean z) {
        zzb(zznVar, false);
        String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzik(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzfw.zza(zznVar.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzac> zza(String str, String str2, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zzia(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzac> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zzhz(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(String str, String str2, boolean z, zzn zznVar) {
        zzb(zznVar, false);
        String str3 = zznVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzhy(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzfw.zza(zznVar.zza), e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final List<zzno> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zznq> list = (List) this.zza.zzl().zza(new zzhx(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznq zznqVar : list) {
                if (z || !zznt.zzg(zznqVar.zzc)) {
                    arrayList.add(new zzno(zznqVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzfw.zza(str), e);
            return Collections.emptyList();
        }
    }

    public zzhn(zznc zzncVar) {
        this(zzncVar, null);
    }

    private zzhn(zznc zzncVar, String str) {
        Preconditions.checkNotNull(zzncVar);
        this.zza = zzncVar;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzc(zzn zznVar) {
        zzb(zznVar, false);
        zzb(new zzhu(this, zznVar));
    }

    private final void zzb(zzn zznVar, boolean z) {
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        this.zza.zzq().zza(zznVar.zzb, zznVar.zzp);
    }

    private final void zza(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzj().zzg().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    this.zzb = Boolean.valueOf("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid()));
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzfw.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    final void zzc(zzbf zzbfVar, zzn zznVar) {
        boolean zZza;
        if (!this.zza.zzi().zzl(zznVar.zza)) {
            zzd(zzbfVar, zznVar);
            return;
        }
        this.zza.zzj().zzp().zza("EES config found for", zznVar.zza);
        zzgw zzgwVarZzi = this.zza.zzi();
        String str = zznVar.zza;
        com.google.android.gms.internal.measurement.zzb zzbVar = TextUtils.isEmpty(str) ? null : zzgwVarZzi.zza.get(str);
        if (zzbVar == null) {
            this.zza.zzj().zzp().zza("EES not loaded for", zznVar.zza);
            zzd(zzbfVar, zznVar);
            return;
        }
        try {
            Map<String, Object> mapZza = this.zza.zzp().zza(zzbfVar.zzb.zzb(), true);
            String strZza = zzir.zza(zzbfVar.zza);
            if (strZza == null) {
                strZza = zzbfVar.zza;
            }
            zZza = zzbVar.zza(new com.google.android.gms.internal.measurement.zzad(strZza, zzbfVar.zzd, mapZza));
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zznVar.zzb, zzbfVar.zza);
            zZza = false;
        }
        if (!zZza) {
            this.zza.zzj().zzp().zza("EES was not applied to event", zzbfVar.zza);
            zzd(zzbfVar, zznVar);
            return;
        }
        if (zzbVar.zzd()) {
            this.zza.zzj().zzp().zza("EES edited event", zzbfVar.zza);
            zzd(this.zza.zzp().zza(zzbVar.zza().zzb()), zznVar);
        } else {
            zzd(zzbfVar, zznVar);
        }
        if (zzbVar.zzc()) {
            for (com.google.android.gms.internal.measurement.zzad zzadVar : zzbVar.zza().zzc()) {
                this.zza.zzj().zzp().zza("EES logging created event", zzadVar.zzb());
                zzd(this.zza.zzp().zza(zzadVar), zznVar);
            }
        }
    }

    final /* synthetic */ void zza(String str, Bundle bundle) {
        this.zza.zzf().zza(str, bundle);
    }

    final /* synthetic */ void zzi(zzn zznVar) {
        this.zza.zzr();
        this.zza.zze(zznVar);
    }

    final /* synthetic */ void zzj(zzn zznVar) {
        this.zza.zzr();
        this.zza.zzf(zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzbf zzbfVar, zzn zznVar) {
        Preconditions.checkNotNull(zzbfVar);
        zzb(zznVar, false);
        zzb(new zzid(this, zzbfVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzbf zzbfVar, String str, String str2) {
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zzb(new zzig(this, zzbfVar, str));
    }

    private final void zzd(zzbf zzbfVar, zzn zznVar) {
        this.zza.zzr();
        this.zza.zza(zzbfVar, zznVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzd(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        zza(zznVar.zza, false);
        zzb(new zzic(this, zznVar));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzc(runnable);
        }
    }

    private final void zzb(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzac zzacVar, zzn zznVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        zzb(zznVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zznVar.zza;
        zzb(new zzhw(this, zzacVar2, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zza);
        zza(zzacVar.zza, true);
        zzb(new zzhv(this, new zzac(zzacVar)));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zze(zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new zzib(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(long j, String str, String str2, String str3) {
        zzb(new zzht(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(final Bundle bundle, zzn zznVar) {
        zzb(zznVar, false);
        final String str = zznVar.zza;
        Preconditions.checkNotNull(str);
        zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(str, bundle);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzf(final zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzi(zznVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzg(zzn zznVar) {
        zzb(zznVar, false);
        zzb(new zzhr(this, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zzh(final zzn zznVar) {
        Preconditions.checkNotEmpty(zznVar.zza);
        Preconditions.checkNotNull(zznVar.zzt);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(zznVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final void zza(zzno zznoVar, zzn zznVar) {
        Preconditions.checkNotNull(zznoVar);
        zzb(zznVar, false);
        zzb(new zzii(this, zznoVar, zznVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzfp
    public final byte[] zza(zzbf zzbfVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbfVar);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzbfVar.zza));
        long jNanoTime = this.zza.zzb().nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzif(this, zzbfVar, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzfw.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzbfVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / Constants.Network.MAX_PAYLOAD_SIZE) - jNanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzfw.zza(str), this.zza.zzg().zza(zzbfVar.zza), e);
            return null;
        }
    }
}
