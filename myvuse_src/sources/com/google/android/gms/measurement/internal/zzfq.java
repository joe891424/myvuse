package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.measurement.internal.zzin;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfq extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private long zze;
    private long zzf;
    private List<String> zzg;
    private String zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private long zzm;
    private String zzn;

    final int zzaa() {
        zzu();
        return this.zzi;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return true;
    }

    final int zzab() {
        zzu();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
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

    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final com.google.android.gms.measurement.internal.zzn zza(java.lang.String r49) {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfq.zza(java.lang.String):com.google.android.gms.measurement.internal.zzn");
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

    final String zzac() {
        zzu();
        return this.zzk;
    }

    final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() {
        if (zzpu.zza() && zze().zza(zzbh.zzbn)) {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    final List<String> zzaf() {
        return this.zzg;
    }

    zzfq(zzhj zzhjVar, long j) {
        super(zzhjVar);
        this.zzm = 0L;
        this.zzn = null;
        this.zzf = j;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({"appId", "appStore", AnalyticsAttribute.APP_NAME_ATTRIBUTE, "gmpAppId", "gaAppId"})
    protected final void zzx() {
        String str;
        String packageName = zza().getPackageName();
        PackageManager packageManager = zza().getPackageManager();
        String str2 = "";
        String installerPackageName = "unknown";
        String str3 = "Unknown";
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            zzj().zzg().zza("PackageManager is null, app identity information might be inaccurate. appId", zzfw.zza(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                zzj().zzg().zza("Error retrieving app installer package name. appId", zzfw.zza(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(zza().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    String string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = string;
                        zzj().zzg().zza("Error retrieving package info. appId, appName", zzfw.zza(packageName), str3);
                        str3 = str;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = "Unknown";
            }
        }
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = 0L;
        Object[] objArr = !TextUtils.isEmpty(this.zzu.zzu()) && "am".equals(this.zzu.zzv());
        int iZzc = this.zzu.zzc();
        switch (iZzc) {
            case 0:
                zzj().zzp().zza("App measurement collection enabled");
                break;
            case 1:
                zzj().zzn().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                zzj().zzp().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                zzj().zzn().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                zzj().zzn().zza("App measurement disabled via the manifest");
                break;
            case 5:
                zzj().zzp().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                zzj().zzv().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                zzj().zzn().zza("App measurement disabled via the global data collection setting");
                break;
            case 8:
                zzj().zzn().zza("App measurement disabled due to denied storage consent");
                break;
            default:
                zzj().zzn().zza("App measurement disabled");
                zzj().zzm().zza("Invalid scion state in identity");
                break;
        }
        boolean z = iZzc == 0;
        this.zzj = "";
        this.zzk = "";
        if (objArr != false) {
            this.zzk = this.zzu.zzu();
        }
        try {
            String strZza = new zzhd(zza(), this.zzu.zzx()).zza("google_app_id");
            if (!TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzj = str2;
            if (!TextUtils.isEmpty(strZza)) {
                this.zzk = new zzhd(zza(), this.zzu.zzx()).zza("admob_app_id");
            }
            if (z) {
                zzj().zzp().zza("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzj) ? this.zzk : this.zzj);
            }
        } catch (IllegalStateException e) {
            zzj().zzg().zza("Fetching Google App Id failed with exception. appId", zzfw.zza(packageName), e);
        }
        this.zzg = null;
        List<String> listZzh = zze().zzh("analytics.safelisted_events");
        if (listZzh != null) {
            if (listZzh.isEmpty()) {
                zzj().zzv().zza("Safelisted event list is empty. Ignoring");
            } else {
                Iterator<String> it2 = listZzh.iterator();
                while (it2.hasNext()) {
                    if (!zzq().zzb("safelisted event", it2.next())) {
                    }
                }
                this.zzg = listZzh;
            }
        } else {
            this.zzg = listZzh;
        }
        if (packageManager != null) {
            this.zzi = InstantApps.isInstantApp(zza()) ? 1 : 0;
        } else {
            this.zzi = 0;
        }
    }

    final void zzag() {
        String str;
        zzt();
        if (!zzk().zzn().zza(zzin.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.zzl = str;
        this.zzm = zzb().currentTimeMillis();
    }

    final boolean zzb(String str) {
        String str2 = this.zzn;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzn = str;
        return z;
    }
}
