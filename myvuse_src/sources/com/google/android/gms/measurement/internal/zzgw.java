package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.measurement.internal.zzin;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgw extends zznb implements zzag {
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    final com.google.android.gms.internal.measurement.zzv zzb;
    private final Map<String, Map<String, String>> zzc;
    private final Map<String, Set<String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzg;
    private final Map<String, zzfj.zzd> zzh;
    private final Map<String, Map<String, Integer>> zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    final int zzb(String str, String str2) throws Throwable {
        Integer num;
        zzt();
        zzv(str);
        Map<String, Integer> map = this.zzi.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zznb
    protected final boolean zzc() {
        return false;
    }

    final long zza(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzfw.zza(str), e);
            return 0L;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzij, com.google.android.gms.measurement.internal.zzil
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzgw zzgwVar, String str) throws Throwable {
        zzgwVar.zzak();
        Preconditions.checkNotEmpty(str);
        if (!zzgwVar.zzl(str)) {
            return null;
        }
        if (zzgwVar.zzh.containsKey(str) && zzgwVar.zzh.get(str) != null) {
            zzgwVar.zza(str, zzgwVar.zzh.get(str));
        } else {
            zzgwVar.zzv(str);
        }
        return zzgwVar.zza.snapshot().get(str);
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

    final zziq zza(String str, zzin.zza zzaVar) throws Throwable {
        zzt();
        zzv(str);
        zzfj.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return zziq.UNINITIALIZED;
        }
        for (zzfj.zza.zzb zzbVar : zzaVarZzb.zzf()) {
            if (zza(zzbVar.zzc()) == zzaVar) {
                int i = zzhe.zzc[zzbVar.zzb().ordinal()];
                if (i == 1) {
                    return zziq.DENIED;
                }
                if (i == 2) {
                    return zziq.GRANTED;
                }
                return zziq.UNINITIALIZED;
            }
        }
        return zziq.UNINITIALIZED;
    }

    final zzin.zza zzb(String str, zzin.zza zzaVar) {
        zzt();
        zzv(str);
        zzfj.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return null;
        }
        for (zzfj.zza.zzc zzcVar : zzaVarZzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    private static zzin.zza zza(zzfj.zza.zze zzeVar) {
        int i = zzhe.zzb[zzeVar.ordinal()];
        if (i == 1) {
            return zzin.zza.AD_STORAGE;
        }
        if (i == 2) {
            return zzin.zza.ANALYTICS_STORAGE;
        }
        if (i == 3) {
            return zzin.zza.AD_USER_DATA;
        }
        if (i != 4) {
            return null;
        }
        return zzin.zza.AD_PERSONALIZATION;
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

    final zzfj.zza zzb(String str) throws Throwable {
        zzt();
        zzv(str);
        zzfj.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null || !zzdVarZzc.zzp()) {
            return null;
        }
        return zzdVarZzc.zzd();
    }

    protected final zzfj.zzd zzc(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzv(str);
        return this.zzh.get(str);
    }

    private final zzfj.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfj.zzd.zzg();
        }
        try {
            zzfj.zzd zzdVar = (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) ((zzfj.zzd.zza) zznp.zza(zzfj.zzd.zze(), bArr)).zzag());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzs() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzq() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzjt e) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzfw.zza(str), e);
            return zzfj.zzd.zzg();
        } catch (RuntimeException e2) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzfw.zza(str), e2);
            return zzfj.zzd.zzg();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzag
    public final String zza(String str, String str2) throws Throwable {
        zzt();
        zzv(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    protected final String zzd(String str) {
        zzt();
        return this.zzl.get(str);
    }

    protected final String zze(String str) {
        zzt();
        return this.zzk.get(str);
    }

    final String zzf(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzj.get(str);
    }

    private static Map<String, String> zza(zzfj.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (zzfj.zzg zzgVar : zzdVar.zzn()) {
                arrayMap.put(zzgVar.zzb(), zzgVar.zzc());
            }
        }
        return arrayMap;
    }

    final Set<String> zzg(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str);
    }

    final SortedSet<String> zzh(String str) {
        zzt();
        zzv(str);
        TreeSet treeSet = new TreeSet();
        zzfj.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return treeSet;
        }
        Iterator<zzfj.zza.zzf> it2 = zzaVarZzb.zzc().iterator();
        while (it2.hasNext()) {
            treeSet.add(it2.next().zzb());
        }
        return treeSet;
    }

    zzgw(zznc zzncVar) {
        super(zzncVar);
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zza = new zzgz(this, 20);
        this.zzb = new zzhc(this);
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

    protected final void zzi(String str) {
        zzt();
        this.zzk.put(str, null);
    }

    private final void zza(String str, zzfj.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            Iterator<zzfj.zzb> it2 = zzaVar.zze().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().zzb());
            }
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzfj.zzc.zza zzaVarZzca = zzaVar.zza(i).zzca();
                if (zzaVarZzca.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzaVarZzca.zzb();
                    String strZzb2 = zzir.zzb(zzaVarZzca.zzb());
                    if (!TextUtils.isEmpty(strZzb2)) {
                        zzaVarZzca = zzaVarZzca.zza(strZzb2);
                        zzaVar.zza(i, zzaVarZzca);
                    }
                    if (zzaVarZzca.zze() && zzaVarZzca.zzc()) {
                        arrayMap.put(strZzb, true);
                    }
                    if (zzaVarZzca.zzf() && zzaVarZzca.zzd()) {
                        arrayMap2.put(zzaVarZzca.zzb(), true);
                    }
                    if (zzaVarZzca.zzg()) {
                        if (zzaVarZzca.zza() < 2 || zzaVarZzca.zza() > 65535) {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzaVarZzca.zzb(), Integer.valueOf(zzaVarZzca.zza()));
                        } else {
                            arrayMap3.put(zzaVarZzca.zzb(), Integer.valueOf(zzaVarZzca.zza()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, hashSet);
        this.zze.put(str, arrayMap);
        this.zzg.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    private final void zzv(String str) throws Throwable {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        if (this.zzh.get(str) == null) {
            zzap zzapVarZzf = zzh().zzf(str);
            if (zzapVarZzf == null) {
                this.zzc.put(str, null);
                this.zze.put(str, null);
                this.zzd.put(str, null);
                this.zzg.put(str, null);
                this.zzh.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzi.put(str, null);
                return;
            }
            zzfj.zzd.zza zzaVarZzca = zza(str, zzapVarZzf.zza).zzca();
            zza(str, zzaVarZzca);
            this.zzc.put(str, zza((zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag())));
            this.zzh.put(str, (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag()));
            zza(str, (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag()));
            this.zzj.put(str, zzaVarZzca.zzc());
            this.zzk.put(str, zzapVarZzf.zzb);
            this.zzl.put(str, zzapVarZzf.zzc);
        }
    }

    private final void zza(final String str, zzfj.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzft.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgy
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzhb(this.zza, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgx
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzgw zzgwVar = this.zza;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgv
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzgw zzgwVar2 = zzgwVar;
                            String str3 = str2;
                            zzf zzfVarZze = zzgwVar2.zzh().zze(str3);
                            HashMap map = new HashMap();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            map.put("gmp_version", 95001L);
                            if (zzfVarZze != null) {
                                String strZzaf = zzfVarZze.zzaf();
                                if (strZzaf != null) {
                                    map.put(C4352k.a.f5663q, strZzaf);
                                }
                                map.put("app_version_int", Long.valueOf(zzfVarZze.zze()));
                                map.put("dynamite_version", Long.valueOf(zzfVarZze.zzo()));
                            }
                            return map;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzha
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(this.zza.zzb);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzft.zzb> it2 = zzcVar.zza().zzd().iterator();
            while (it2.hasNext()) {
                zzj().zzp().zza("EES program activity", it2.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    final void zzj(String str) {
        zzt();
        this.zzh.remove(str);
    }

    final boolean zzk(String str) {
        zzt();
        zzfj.zzd zzdVarZzc = zzc(str);
        if (zzdVarZzc == null) {
            return false;
        }
        return zzdVarZzc.zzo();
    }

    public final boolean zzl(String str) {
        zzfj.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzh.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzc(String str, zzin.zza zzaVar) throws Throwable {
        zzt();
        zzv(str);
        zzfj.zza zzaVarZzb = zzb(str);
        if (zzaVarZzb == null) {
            return false;
        }
        Iterator<zzfj.zza.zzb> it2 = zzaVarZzb.zzd().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            zzfj.zza.zzb next = it2.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzfj.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    final boolean zzn(String str) {
        zzt();
        zzv(str);
        zzfj.zza zzaVarZzb = zzb(str);
        return zzaVarZzb == null || !zzaVarZzb.zzh() || zzaVarZzb.zzg();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzg.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzd(String str, String str2) throws Throwable {
        Boolean bool;
        zzt();
        zzv(str);
        if (zzm(str) && zznt.zzg(str2)) {
            return true;
        }
        if (zzo(str) && zznt.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzo(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    protected final boolean zza(String str, byte[] bArr, String str2, String str3) {
        int iUpdate;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzfj.zzd.zza zzaVarZzca = zza(str, bArr).zzca();
        if (zzaVarZzca == null) {
            return false;
        }
        zza(str, zzaVarZzca);
        zza(str, (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag()));
        this.zzh.put(str, (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag()));
        this.zzj.put(str, zzaVarZzca.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzc.put(str, zza((zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag())));
        zzh().zza(str, new ArrayList(zzaVarZzca.zzd()));
        try {
            zzaVarZzca.zzb();
            bArr = ((zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag())).zzbx();
        } catch (RuntimeException e) {
            zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzfw.zza(str), e);
        }
        zzan zzanVarZzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzanVarZzh.zzt();
        zzanVarZzh.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = zzanVarZzh.m2388e_();
            String[] strArr = {str};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                iUpdate = sQLiteDatabaseM2388e_.update("apps", contentValues, "app_id = ?", strArr);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                iUpdate = SQLiteInstrumentation.update(sQLiteDatabaseM2388e_, "apps", contentValues, "app_id = ?", strArr);
            }
            if (iUpdate == 0) {
                zzanVarZzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzfw.zza(str));
            }
        } catch (SQLiteException e2) {
            zzanVarZzh.zzj().zzg().zza("Error storing remote config. appId", zzfw.zza(str), e2);
        }
        this.zzh.put(str, (zzfj.zzd) ((com.google.android.gms.internal.measurement.zzjk) zzaVarZzca.zzag()));
        return true;
    }

    final boolean zzp(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("app_instance_id");
    }

    final boolean zzq(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("device_model") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    final boolean zzr(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("enhanced_user_id");
    }

    final boolean zzs(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("google_signals");
    }

    final boolean zzt(String str) throws Throwable {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("os_version") || this.zzd.get(str).contains("device_info");
        }
        return false;
    }

    final boolean zzu(String str) throws Throwable {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("user_id");
    }
}
