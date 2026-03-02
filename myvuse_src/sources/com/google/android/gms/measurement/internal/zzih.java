package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpd;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzih implements Callable<List<zzmu>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzhn zzc;

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzmu> call() throws Exception {
        int iDelete;
        this.zzc.zza.zzr();
        zznc zzncVar = this.zzc.zza;
        zzn zznVar = this.zza;
        Bundle bundle = this.zzb;
        zzncVar.zzl().zzt();
        if (!zzpd.zza() || !zzncVar.zze().zze(zznVar.zza, zzbh.zzcb) || zznVar.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzncVar.zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    char c = 0;
                    int i = 0;
                    while (i < intArray.length) {
                        zzan zzanVarZzf = zzncVar.zzf();
                        String str = zznVar.zza;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzanVarZzf.zzt();
                        zzanVarZzf.zzak();
                        try {
                            SQLiteDatabase sQLiteDatabaseM2388e_ = zzanVarZzf.m2388e_();
                            String[] strArr = new String[3];
                            strArr[c] = str;
                            strArr[1] = String.valueOf(i2);
                            strArr[2] = String.valueOf(j);
                            if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                                iDelete = SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "trigger_uris", "app_id=? and source=? and timestamp_millis<=?", strArr);
                            } else {
                                iDelete = sQLiteDatabaseM2388e_.delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", strArr);
                            }
                            zzanVarZzf.zzj().zzp().zza("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzanVarZzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzfw.zza(str), e);
                        }
                        i++;
                        c = 0;
                    }
                }
            }
        }
        return zzncVar.zzf().zzj(zznVar.zza);
    }

    zzih(zzhn zzhnVar, zzn zznVar, Bundle bundle) {
        this.zza = zznVar;
        this.zzb = bundle;
        this.zzc = zzhnVar;
    }
}
