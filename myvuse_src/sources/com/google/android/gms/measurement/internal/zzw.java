package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfn;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzw {
    private zzfn.zze zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzs zzd;

    final zzfn.zze zza(String str, zzfn.zze zzeVar) {
        String strZzg = zzeVar.zzg();
        List<zzfn.zzg> listZzh = zzeVar.zzh();
        this.zzd.mo2390g_();
        Long l = (Long) zznp.zzb(zzeVar, "_eid");
        boolean z = l != null;
        if (z && strZzg.equals("_ep")) {
            Preconditions.checkNotNull(l);
            this.zzd.mo2390g_();
            strZzg = (String) zznp.zzb(zzeVar, "_en");
            if (TextUtils.isEmpty(strZzg)) {
                this.zzd.zzj().zzm().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzfn.zze, Long> pairZza = this.zzd.zzh().zza(str, l);
                if (pairZza == null || pairZza.first == null) {
                    this.zzd.zzj().zzm().zza("Extra parameter without existing main event. eventName, eventId", strZzg, l);
                    return null;
                }
                this.zza = (zzfn.zze) pairZza.first;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzd.mo2390g_();
                this.zzb = (Long) zznp.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzan zzanVarZzh = this.zzd.zzh();
                zzanVarZzh.zzt();
                zzanVarZzh.zzj().zzp().zza("Clearing complex main event info. appId", str);
                try {
                    SQLiteDatabase sQLiteDatabaseM2388e_ = zzanVarZzh.m2388e_();
                    String[] strArr = {str};
                    if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                        SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                        SQLiteInstrumentation.execSQL(sQLiteDatabaseM2388e_, "delete from main_event_params where app_id=?", strArr);
                    } else {
                        sQLiteDatabaseM2388e_.execSQL("delete from main_event_params where app_id=?", strArr);
                    }
                } catch (SQLiteException e) {
                    zzanVarZzh.zzj().zzg().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzh().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzfn.zzg zzgVar : this.zza.zzh()) {
                this.zzd.mo2390g_();
                if (zznp.zza(zzeVar, zzgVar.zzg()) == null) {
                    arrayList.add(zzgVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzm().zza("No unique parameters in main event. eventName", strZzg);
            } else {
                arrayList.addAll(listZzh);
                listZzh = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzeVar;
            this.zzd.mo2390g_();
            Object objZzb = zznp.zzb(zzeVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzj().zzm().zza("Complex event with zero extra param count. eventName", strZzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l), this.zzc, zzeVar);
            }
        }
        return (zzfn.zze) ((com.google.android.gms.internal.measurement.zzjk) zzeVar.zzca().zza(strZzg).zzd().zza(listZzh).zzag());
    }

    private zzw(zzs zzsVar) {
        this.zzd = zzsVar;
    }
}
