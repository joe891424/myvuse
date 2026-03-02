package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.brentvatne.react.ReactVideoView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzan extends zznb {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {C4352k.a.f5663q, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzat zzl;
    private final zzmv zzm;

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            String[] strArr = {str, str2};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                return sQLiteDatabaseM2388e_.delete("conditional_properties", "app_id=? and name=?", strArr);
            }
            SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
            return SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "conditional_properties", "app_id=? and name=?", strArr);
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfw.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zznb
    protected final boolean zzc() {
        return false;
    }

    public final long zza(String str) {
        int iDelete;
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            String[] strArr = {str, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zze().zzb(str, zzbh.zzp))))};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                iDelete = sQLiteDatabaseM2388e_.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", strArr);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                iDelete = SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", strArr);
            }
            return iDelete;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfw.zza(str), e);
            return 0L;
        }
    }

    /* JADX INFO: renamed from: b_ */
    public final long m2385b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorRawQuery = sQLiteDatabaseM2388e_.rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabaseM2388e_, "select rowid from raw_events order by rowid desc limit 1;", null);
                }
                if (!cursorRawQuery.moveToFirst()) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long zza(zzfn.zzj zzjVar) throws IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzy());
        byte[] bArrZzbx = zzjVar.zzbx();
        long jZza = mo2390g_().zza(bArrZzbx);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjVar.zzy());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put(ReactVideoView.EVENT_PROP_METADATA, bArrZzbx);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                sQLiteDatabaseM2388e_.insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "raw_events_metadata", null, contentValues, 4);
            }
            return jZza;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfw.zza(zzjVar.zzy()), e);
            throw e;
        }
    }

    protected final long zzb(String str, String str2) {
        long jZza;
        int iUpdate;
        long jInsertWithOnConflict;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        sQLiteDatabaseM2388e_.beginTransaction();
        long j = 0;
        try {
            try {
                jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
            } finally {
                sQLiteDatabaseM2388e_.endTransaction();
            }
        } catch (SQLiteException e) {
            e = e;
        }
        if (jZza == -1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", (Integer) 0);
            contentValues.put("previous_install_count", (Integer) 0);
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("app2", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "app2", null, contentValues, 5);
            }
            if (jInsertWithOnConflict == -1) {
                zzj().zzg().zza("Failed to insert column (got -1). appId", zzfw.zza(str), str2);
                return -1L;
            }
            jZza = 0;
            zzj().zzg().zza("Error inserting column. appId", zzfw.zza(str), str2, e);
            sQLiteDatabaseM2388e_.endTransaction();
            return j;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + jZza));
            String[] strArr = {str};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                iUpdate = sQLiteDatabaseM2388e_.update("app2", contentValues2, "app_id = ?", strArr);
            } else {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabaseM2388e_;
                iUpdate = SQLiteInstrumentation.update(sQLiteDatabaseM2388e_, "app2", contentValues2, "app_id = ?", strArr);
            }
            if (iUpdate == 0) {
                zzj().zzg().zza("Failed to update column (got 0). appId", zzfw.zza(str), str2);
                return -1L;
            }
            sQLiteDatabaseM2388e_.setTransactionSuccessful();
            return jZza;
        } catch (SQLiteException e2) {
            e = e2;
            j = jZza;
        }
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    /* JADX INFO: renamed from: c_ */
    public final long m2386c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX INFO: renamed from: d_ */
    public final long m2387d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabaseM2388e_, str, strArr);
                } else {
                    cursorRawQuery = sQLiteDatabaseM2388e_.rawQuery(str, strArr);
                }
                Cursor cursor2 = cursorRawQuery;
                if (cursor2.moveToFirst()) {
                    long j = cursor2.getLong(0);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[FINALLY_INSNS] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zza(java.lang.String r4, java.lang.String[] r5, long r6) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r0 = r3.m2388e_()
            r1 = 0
            boolean r2 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r2 != 0) goto Le
            android.database.Cursor r5 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            goto L15
        Le:
            r2 = r0
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r4, r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
        L15:
            r1 = r5
            boolean r5 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r5 == 0) goto L27
            r5 = 0
            long r4 = r1.getLong(r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r1 == 0) goto L26
            r1.close()
        L26:
            return r4
        L27:
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            return r6
        L2d:
            r4 = move-exception
            goto L3e
        L2f:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzfw r6 = r3.zzj()     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzg()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r7 = "Database error"
            r6.zza(r7, r4, r5)     // Catch: java.lang.Throwable -> L2d
            throw r5     // Catch: java.lang.Throwable -> L2d
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[], long):long");
    }

    /* JADX INFO: renamed from: e_ */
    final SQLiteDatabase m2388e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0095: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x0095 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzd(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.zzt()
            r6.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.m2388e_()     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            boolean r5 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            if (r5 != 0) goto L1c
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            goto L23
        L1c:
            r5 = r1
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r1, r2, r3)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
        L23:
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            if (r2 != 0) goto L3c
            com.google.android.gms.measurement.internal.zzfw r7 = r6.zzj()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzp()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            java.lang.String r2 = "Default event parameters not found"
            r7.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            return r0
        L3c:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzfn$zze$zza r3 = com.google.android.gms.internal.measurement.zzfn.zze.zze()     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzkt r2 = com.google.android.gms.measurement.internal.zznp.zza(r3, r2)     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzfn$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zze.zza) r2     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzkq r2 = r2.zzag()     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.internal.measurement.zzfn$zze r2 = (com.google.android.gms.internal.measurement.zzfn.zze) r2     // Catch: java.io.IOException -> L63 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            r6.mo2390g_()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            java.util.List r7 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            android.os.Bundle r7 = com.google.android.gms.measurement.internal.zznp.zza(r7)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            if (r1 == 0) goto L62
            r1.close()
        L62:
            return r7
        L63:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r6.zzj()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza(r7)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            r3.zza(r4, r7, r2)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L94
            if (r1 == 0) goto L7a
            r1.close()
        L7a:
            return r0
        L7b:
            r7 = move-exception
            goto L81
        L7d:
            r7 = move-exception
            goto L96
        L7f:
            r7 = move-exception
            r1 = r0
        L81:
            com.google.android.gms.measurement.internal.zzfw r2 = r6.zzj()     // Catch: java.lang.Throwable -> L94
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch: java.lang.Throwable -> L94
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r7)     // Catch: java.lang.Throwable -> L94
            if (r1 == 0) goto L93
            r1.close()
        L93:
            return r0
        L94:
            r7 = move-exception
            r0 = r1
        L96:
            if (r0 == 0) goto L9b
            r0.close()
        L9b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x009d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x009d */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfn.zze, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.m2388e_()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            boolean r5 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            if (r5 != 0) goto L23
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            goto L2a
        L23:
            r5 = r1
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r1, r2, r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteException -> L87
        L2a:
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            if (r2 != 0) goto L43
            com.google.android.gms.measurement.internal.zzfw r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.measurement.internal.zzfy r8 = r8.zzp()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzfn$zze$zza r4 = com.google.android.gms.internal.measurement.zzfn.zze.zze()     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzkt r2 = com.google.android.gms.measurement.internal.zznp.zza(r4, r2)     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzfn$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfn.zze.zza) r2     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzkq r2 = r2.zzag()     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzjk r2 = (com.google.android.gms.internal.measurement.zzjk) r2     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzfn$zze r2 = (com.google.android.gms.internal.measurement.zzfn.zze) r2     // Catch: java.io.IOException -> L6b android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            if (r1 == 0) goto L6a
            r1.close()
        L6a:
            return r8
        L6b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfw r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfw.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L83 java.lang.Throwable -> L9c
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r0
        L83:
            r8 = move-exception
            goto L89
        L85:
            r8 = move-exception
            goto L9e
        L87:
            r8 = move-exception
            r1 = r0
        L89:
            com.google.android.gms.measurement.internal.zzfw r9 = r7.zzj()     // Catch: java.lang.Throwable -> L9c
            com.google.android.gms.measurement.internal.zzfy r9 = r9.zzg()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L9b
            r1.close()
        L9b:
            return r0
        L9c:
            r8 = move-exception
            r0 = r1
        L9e:
            if (r0 == 0) goto La3
            r0.close()
        La3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x045e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:135:0x045d */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzf zze(java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 1125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzac zzc(java.lang.String r33, java.lang.String r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzap zzf(java.lang.String r15) throws java.lang.Throwable {
        /*
            r14 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            r14.zzt()
            r14.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r14.m2388e_()     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            java.lang.String r2 = "apps"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            java.lang.String r4 = "remote_config"
            r9 = 0
            r3[r9] = r4     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            java.lang.String r4 = "config_last_modified_time"
            r10 = 1
            r3[r10] = r4     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            java.lang.String r4 = "e_tag"
            r11 = 2
            r3[r11] = r4     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            r5[r9] = r15     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            boolean r6 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            r7 = 0
            r8 = 0
            r12 = 0
            if (r6 != 0) goto L37
            r6 = r7
            r7 = r8
            r8 = r12
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            goto L41
        L37:
            r6 = r1
            android.database.sqlite.SQLiteDatabase r6 = (android.database.sqlite.SQLiteDatabase) r6     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
            r6 = r7
            r7 = r8
            r8 = r12
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8b android.database.sqlite.SQLiteException -> L8d
        L41:
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            if (r2 != 0) goto L4d
            if (r1 == 0) goto L4c
            r1.close()
        L4c:
            return r0
        L4d:
            byte[] r2 = r1.getBlob(r9)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            java.lang.String r3 = r1.getString(r10)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            java.lang.String r4 = r1.getString(r11)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            boolean r5 = r1.moveToNext()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            if (r5 == 0) goto L70
            com.google.android.gms.measurement.internal.zzfw r5 = r14.zzj()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzg()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfw.zza(r15)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            r5.zza(r6, r7)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
        L70:
            if (r2 != 0) goto L78
            if (r1 == 0) goto L77
            r1.close()
        L77:
            return r0
        L78:
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            r5.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L86
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r5
        L83:
            r15 = move-exception
            r0 = r1
            goto La8
        L86:
            r2 = move-exception
            r13 = r2
            r2 = r1
            r1 = r13
            goto L8f
        L8b:
            r15 = move-exception
            goto La8
        L8d:
            r1 = move-exception
            r2 = r0
        L8f:
            com.google.android.gms.measurement.internal.zzfw r3 = r14.zzj()     // Catch: java.lang.Throwable -> La6
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> La6
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzfw.zza(r15)     // Catch: java.lang.Throwable -> La6
            r3.zza(r4, r15, r1)     // Catch: java.lang.Throwable -> La6
            if (r2 == 0) goto La5
            r2.close()
        La5:
            return r0
        La6:
            r15 = move-exception
            r0 = r2
        La8:
            if (r0 == 0) goto Lad
            r0.close()
        Lad:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzap");
    }

    public final zzao zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return zza(j, str, 1L, false, false, z3, false, z5, z6);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzao zza(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzao");
    }

    public final zzax zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzax.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzbb zzd(String str, String str2) {
        return zzc("events", str, str2);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x017c: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:69:0x017c */
    private final zzbb zzc(String str, String str2, String str3) throws Throwable {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorQuery;
        Cursor cursor3;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count"));
        Cursor cursor4 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                String[] strArr2 = {str2, str3};
                if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, str, strArr, "app_id=? and name=?", strArr2, null, null, null);
                } else {
                    cursorQuery = sQLiteDatabaseM2388e_.query(str, strArr, "app_id=? and name=?", strArr2, null, null, null);
                }
                cursor = cursorQuery;
                try {
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    long j = cursor.getLong(0);
                    long j2 = cursor.getLong(1);
                    long j3 = cursor.getLong(2);
                    long j4 = 0;
                    long j5 = cursor.isNull(3) ? 0L : cursor.getLong(3);
                    Long lValueOf = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                    Long lValueOf2 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                    Long lValueOf3 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                    if (cursor.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursor.getLong(7) == 1);
                        } catch (SQLiteException e) {
                            e = e;
                        }
                    }
                    if (!cursor.isNull(8)) {
                        j4 = cursor.getLong(8);
                    }
                    cursor3 = cursor;
                    try {
                        zzbb zzbbVar = new zzbb(str2, str3, j, j2, j4, j3, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor3.moveToNext()) {
                            zzj().zzg().zza("Got multiple records for event aggregates, expected one. appId", zzfw.zza(str2));
                        }
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        return zzbbVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = cursor3;
                    } catch (Throwable th) {
                        th = th;
                        cursor4 = cursor3;
                        if (cursor4 != null) {
                            cursor4.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor4 = cursor2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
        zzj().zzg().zza("Error querying events. appId", zzfw.zza(str2), zzi().zza(str3), e);
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public final zzin zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzin.zzb(zza("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zzin zzi(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        zzin zzinVar = (zzin) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaq() { // from class: com.google.android.gms.measurement.internal.zzam
            @Override // com.google.android.gms.measurement.internal.zzaq
            public final Object zza(Cursor cursor) {
                return zzin.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zzinVar == null ? zzin.zza : zzinVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zznq zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.m2388e_()     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            r14[r1] = r19     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            r14[r2] = r8     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            boolean r0 = r10 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            r15 = 0
            r16 = 0
            r17 = 0
            if (r0 != 0) goto L3d
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            goto L44
        L3d:
            r0 = r10
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r10, r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9c
        L44:
            r10 = r0
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L94
            if (r0 != 0) goto L51
            if (r10 == 0) goto L50
            r10.close()
        L50:
            return r9
        L51:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L90 android.database.sqlite.SQLiteException -> L94
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            if (r7 != 0) goto L63
            if (r10 == 0) goto L62
            r10.close()
        L62:
            return r9
        L63:
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zznq r0 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            if (r1 == 0) goto L88
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L8e java.lang.Throwable -> Lbf
        L88:
            if (r10 == 0) goto L8d
            r10.close()
        L8d:
            return r0
        L8e:
            r0 = move-exception
            goto La0
        L90:
            r0 = move-exception
            r11 = r18
            goto Lc0
        L94:
            r0 = move-exception
            r11 = r18
            goto La0
        L98:
            r0 = move-exception
            r11 = r18
            goto Lc1
        L9c:
            r0 = move-exception
            r11 = r18
            r10 = r9
        La0:
            com.google.android.gms.measurement.internal.zzfw r1 = r18.zzj()     // Catch: java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfw.zza(r19)     // Catch: java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zzfv r4 = r18.zzi()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lbf
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lbf
            if (r10 == 0) goto Lbe
            r10.close()
        Lbe:
            return r9
        Lbf:
            r0 = move-exception
        Lc0:
            r9 = r10
        Lc1:
            if (r9 == 0) goto Lc6
            r9.close()
        Lc6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznq");
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T> T zza(java.lang.String r5, java.lang.String[] r6, com.google.android.gms.measurement.internal.zzaq<T> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.m2388e_()     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            if (r2 != 0) goto Le
            android.database.Cursor r5 = r1.rawQuery(r5, r6)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            goto L15
        Le:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r1, r5, r6)     // Catch: java.lang.Throwable -> L41 android.database.sqlite.SQLiteException -> L43
        L15:
            boolean r6 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3c
            if (r6 != 0) goto L2e
            com.google.android.gms.measurement.internal.zzfw r6 = r4.zzj()     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3c
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3c
            java.lang.String r7 = "No data found"
            r6.zza(r7)     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3c
            if (r5 == 0) goto L2d
            r5.close()
        L2d:
            return r0
        L2e:
            java.lang.Object r6 = r7.zza(r5)     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3c
            if (r5 == 0) goto L37
            r5.close()
        L37:
            return r6
        L38:
            r6 = move-exception
            r0 = r5
            r5 = r6
            goto L5a
        L3c:
            r6 = move-exception
            r3 = r6
            r6 = r5
            r5 = r3
            goto L45
        L41:
            r5 = move-exception
            goto L5a
        L43:
            r5 = move-exception
            r6 = r0
        L45:
            com.google.android.gms.measurement.internal.zzfw r7 = r4.zzj()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzg()     // Catch: java.lang.Throwable -> L58
            java.lang.String r1 = "Error querying database."
            r7.zza(r1, r5)     // Catch: java.lang.Throwable -> L58
            if (r6 == 0) goto L57
            r6.close()
        L57:
            return r0
        L58:
            r5 = move-exception
            r0 = r6
        L5a:
            if (r0 == 0) goto L5f
            r0.close()
        L5f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzaq):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzt()
            r5.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.m2388e_()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            r7 = 0
            r3[r7] = r6     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            boolean r6 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            if (r6 != 0) goto L20
            android.database.Cursor r6 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            goto L27
        L20:
            r6 = r1
            android.database.sqlite.SQLiteDatabase r6 = (android.database.sqlite.SQLiteDatabase) r6     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            android.database.Cursor r6 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r1, r2, r3)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
        L27:
            boolean r1 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4e
            if (r1 != 0) goto L40
            com.google.android.gms.measurement.internal.zzfw r7 = r5.zzj()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4e
            com.google.android.gms.measurement.internal.zzfy r7 = r7.zzp()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4e
            java.lang.String r1 = "No expired configs for apps with pending events"
            r7.zza(r1)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4e
            if (r6 == 0) goto L3f
            r6.close()
        L3f:
            return r0
        L40:
            java.lang.String r7 = r6.getString(r7)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4e
            if (r6 == 0) goto L49
            r6.close()
        L49:
            return r7
        L4a:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto L6c
        L4e:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto L57
        L53:
            r6 = move-exception
            goto L6c
        L55:
            r6 = move-exception
            r7 = r0
        L57:
            com.google.android.gms.measurement.internal.zzfw r1 = r5.zzj()     // Catch: java.lang.Throwable -> L6a
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L6a
            if (r7 == 0) goto L69
            r7.close()
        L69:
            return r0
        L6a:
            r6 = move-exception
            r0 = r7
        L6c:
            if (r0 == 0) goto L71
            r0.close()
        L71:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(long):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX INFO: renamed from: f_ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m2389f_() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.m2388e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            boolean r3 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3a
            if (r3 != 0) goto L10
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3a
            goto L17
        L10:
            r3 = r0
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3a
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r2, r1)     // Catch: java.lang.Throwable -> L38 android.database.sqlite.SQLiteException -> L3a
        L17:
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L33
            if (r2 == 0) goto L28
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L33
            if (r0 == 0) goto L27
            r0.close()
        L27:
            return r1
        L28:
            if (r0 == 0) goto L2d
            r0.close()
        L2d:
            return r1
        L2e:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L51
        L33:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L3c
        L38:
            r0 = move-exception
            goto L51
        L3a:
            r0 = move-exception
            r2 = r1
        L3c:
            com.google.android.gms.measurement.internal.zzfw r3 = r6.zzj()     // Catch: java.lang.Throwable -> L4f
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r0)     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L4e
            r2.close()
        L4e:
            return r1
        L4f:
            r0 = move-exception
            r1 = r2
        L51:
            if (r1 == 0) goto L56
            r1.close()
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.m2389f_():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[FINALLY_INSNS] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String zza(java.lang.String r4, java.lang.String[] r5, java.lang.String r6) {
        /*
            r3 = this;
            android.database.sqlite.SQLiteDatabase r0 = r3.m2388e_()
            r1 = 0
            boolean r2 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r2 != 0) goto Le
            android.database.Cursor r5 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            goto L15
        Le:
            r2 = r0
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r4, r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
        L15:
            r1 = r5
            boolean r5 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r5 == 0) goto L27
            r5 = 0
            java.lang.String r4 = r1.getString(r5)     // Catch: java.lang.Throwable -> L2d android.database.sqlite.SQLiteException -> L2f
            if (r1 == 0) goto L26
            r1.close()
        L26:
            return r4
        L27:
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            return r6
        L2d:
            r4 = move-exception
            goto L3e
        L2f:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzfw r6 = r3.zzj()     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzg()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r0 = "Database error"
            r6.zza(r0, r4, r5)     // Catch: java.lang.Throwable -> L2d
            throw r5     // Catch: java.lang.Throwable -> L2d
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[], java.lang.String):java.lang.String");
    }

    public final List<Pair<zzfn.zzj, Long>> zza(String str, int i, int i2) {
        Cursor cursorQuery;
        byte[] bArrZzc;
        long jZzc;
        long jZzc2;
        zzt();
        zzak();
        int i3 = 1;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                String[] strArr = {"rowid", "data", "retry_count"};
                String[] strArr2 = {str};
                String strValueOf = String.valueOf(i);
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabaseM2388e_.query("queue", strArr, "app_id=?", strArr2, null, null, "rowid", strValueOf);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, "queue", strArr, "app_id=?", strArr2, null, null, "rowid", strValueOf);
                }
                Cursor cursor2 = cursorQuery;
                if (!cursor2.moveToFirst()) {
                    List<Pair<zzfn.zzj, Long>> listEmptyList = Collections.emptyList();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                while (true) {
                    long j = cursor2.getLong(0);
                    try {
                        bArrZzc = mo2390g_().zzc(cursor2.getBlob(i3));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to unzip queued bundle. appId", zzfw.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzc.length + length > i2) {
                        break;
                    }
                    try {
                        zzfn.zzj.zza zzaVar = (zzfn.zzj.zza) zznp.zza(zzfn.zzj.zzv(), bArrZzc);
                        if (!arrayList.isEmpty()) {
                            zzfn.zzj zzjVar = (zzfn.zzj) ((Pair) arrayList.get(0)).first;
                            zzfn.zzj zzjVar2 = (zzfn.zzj) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzag());
                            if (!zzjVar.zzad().equals(zzjVar2.zzad()) || !zzjVar.zzac().equals(zzjVar2.zzac()) || zzjVar.zzat() != zzjVar2.zzat() || !zzjVar.zzae().equals(zzjVar2.zzae())) {
                                break;
                            }
                            Iterator<zzfn.zzn> it2 = zzjVar.zzar().iterator();
                            while (true) {
                                jZzc = -1;
                                if (!it2.hasNext()) {
                                    jZzc2 = -1;
                                    break;
                                }
                                zzfn.zzn next = it2.next();
                                if ("_npa".equals(next.zzg())) {
                                    jZzc2 = next.zzc();
                                    break;
                                }
                            }
                            Iterator<zzfn.zzn> it3 = zzjVar2.zzar().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                zzfn.zzn next2 = it3.next();
                                if ("_npa".equals(next2.zzg())) {
                                    jZzc = next2.zzc();
                                    break;
                                }
                            }
                            if (jZzc2 != jZzc) {
                                break;
                            }
                        }
                        if (!cursor2.isNull(2)) {
                            zzaVar.zzi(cursor2.getInt(2));
                        }
                        length += bArrZzc.length;
                        arrayList.add(Pair.create((zzfn.zzj) ((com.google.android.gms.internal.measurement.zzjk) zzaVar.zzag()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzj().zzg().zza("Failed to merge queued bundle. appId", zzfw.zza(str), e2);
                    }
                    if (!cursor2.moveToNext() || length > i2) {
                        break;
                    }
                    i3 = 1;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzj().zzg().zza("Error querying bundles. appId", zzfw.zza(str), e3);
                List<Pair<zzfn.zzj, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzac> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + "*");
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a5, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzac> zza(java.lang.String r41, java.lang.String[] r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzmu> zzj(java.lang.String r16) {
        /*
            r15 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r16)
            r15.zzt()
            r15.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r15.m2388e_()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r3 = "trigger_uris"
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r5 = "trigger_uri"
            r11 = 0
            r4[r11] = r5     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r5 = "timestamp_millis"
            r12 = 1
            r4[r12] = r5     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r5 = "source"
            r13 = 2
            r4[r13] = r5     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r6[r11] = r16     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r9 = "rowid"
            boolean r7 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r8 = 0
            r10 = 0
            r14 = 0
            if (r7 != 0) goto L3e
            r7 = r8
            r8 = r10
            r10 = r14
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            goto L48
        L3e:
            r7 = r2
            android.database.sqlite.SQLiteDatabase r7 = (android.database.sqlite.SQLiteDatabase) r7     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r7 = r8
            r8 = r10
            r10 = r14
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
        L48:
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            if (r2 != 0) goto L54
            if (r1 == 0) goto L53
            r1.close()
        L53:
            return r0
        L54:
            java.lang.String r2 = r1.getString(r11)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            if (r2 != 0) goto L5c
            java.lang.String r2 = ""
        L5c:
            long r3 = r1.getLong(r12)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            int r5 = r1.getInt(r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            com.google.android.gms.measurement.internal.zzmu r6 = new com.google.android.gms.measurement.internal.zzmu     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r6.<init>(r2, r3, r5)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r0.add(r6)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            if (r2 != 0) goto L54
            if (r1 == 0) goto L77
            r1.close()
        L77:
            return r0
        L78:
            r0 = move-exception
            goto L96
        L7a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r2 = r15.zzj()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()     // Catch: java.lang.Throwable -> L78
            java.lang.String r3 = "Error querying trigger uris. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza(r16)     // Catch: java.lang.Throwable -> L78
            r2.zza(r3, r4, r0)     // Catch: java.lang.Throwable -> L78
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L95
            r1.close()
        L95:
            return r0
        L96:
            if (r1 == 0) goto L9b
            r1.close()
        L9b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzj(java.lang.String):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzk(java.lang.String r23) throws java.lang.Throwable {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzt()
            r22.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.m2388e_()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            r6[r11] = r23     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            boolean r7 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            r8 = 0
            r15 = 0
            if (r7 != 0) goto L43
            r7 = r8
            r8 = r15
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            goto L4c
        L43:
            r7 = r2
            android.database.sqlite.SQLiteDatabase r7 = (android.database.sqlite.SQLiteDatabase) r7     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            r7 = r8
            r8 = r15
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
        L4c:
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            if (r2 != 0) goto L58
            if (r1 == 0) goto L57
            r1.close()
        L57:
            return r0
        L58:
            java.lang.String r18 = r1.getString(r11)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            java.lang.String r2 = r1.getString(r12)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            if (r2 != 0) goto L64
            java.lang.String r2 = ""
        L64:
            r17 = r2
            long r19 = r1.getLong(r13)     // Catch: java.lang.Throwable -> L9d android.database.sqlite.SQLiteException -> La1
            r2 = r22
            java.lang.Object r21 = r2.zza(r1, r14)     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            if (r21 != 0) goto L84
            com.google.android.gms.measurement.internal.zzfw r3 = r22.zzj()     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza(r23)     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            goto L8f
        L84:
            com.google.android.gms.measurement.internal.zznq r3 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            r15 = r3
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
        L8f:
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9b java.lang.Throwable -> Lbf
            if (r3 != 0) goto L58
            if (r1 == 0) goto L9a
            r1.close()
        L9a:
            return r0
        L9b:
            r0 = move-exception
            goto La4
        L9d:
            r0 = move-exception
            r2 = r22
            goto Lc0
        La1:
            r0 = move-exception
            r2 = r22
        La4:
            com.google.android.gms.measurement.internal.zzfw r3 = r22.zzj()     // Catch: java.lang.Throwable -> Lbf
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzg()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza(r23)     // Catch: java.lang.Throwable -> Lbf
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Lbf
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lbf
            if (r1 == 0) goto Lbe
            r1.close()
        Lbe:
            return r0
        Lbf:
            r0 = move-exception
        Lc0:
            if (r1 == 0) goto Lc5
            r1.close()
        Lc5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzk(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b1, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    final Map<Integer, zzfn.zzl> zzl(String str) {
        Cursor cursorQuery;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"audience_id", "current_results"};
                String[] strArr2 = {str};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabaseM2388e_.query("audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, "audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                }
                Cursor cursor2 = cursorQuery;
                if (!cursor2.moveToFirst()) {
                    Map<Integer, zzfn.zzl> mapEmptyMap = Collections.emptyMap();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return mapEmptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i = cursor2.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i), (zzfn.zzl) ((com.google.android.gms.internal.measurement.zzjk) ((zzfn.zzl.zza) zznp.zza(zzfn.zzl.zze(), cursor2.getBlob(1))).zzag()));
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfw.zza(str), Integer.valueOf(i), e);
                    }
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filter results. appId", zzfw.zza(str), e2);
                Map<Integer, zzfn.zzl> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzff.zzb>> zzm(String str) {
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"audience_id", "data"};
                String[] strArr2 = {str};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabaseM2388e_.query("event_filters", strArr, "app_id=?", strArr2, null, null, null);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, "event_filters", strArr, "app_id=?", strArr2, null, null, null);
                }
                Cursor cursor2 = cursorQuery;
                if (!cursor2.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznp.zza(zzff.zzb.zzc(), cursor2.getBlob(1))).zzag());
                        if (zzbVar.zzk()) {
                            int i = cursor2.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
                Map<Integer, List<zzff.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzff.zzb>> zzf(String str, String str2) {
        Cursor cursorQuery;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"audience_id", "data"};
                String[] strArr2 = {str, str2};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabaseM2388e_.query("event_filters", strArr, "app_id=? AND event_name=?", strArr2, null, null, null);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, "event_filters", strArr, "app_id=? AND event_name=?", strArr2, null, null, null);
                }
                Cursor cursor2 = cursorQuery;
                if (!cursor2.moveToFirst()) {
                    Map<Integer, List<zzff.zzb>> mapEmptyMap = Collections.emptyMap();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zzb zzbVar = (zzff.zzb) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zzb.zza) zznp.zza(zzff.zzb.zzc(), cursor2.getBlob(1))).zzag());
                        int i = cursor2.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzfw.zza(str), e);
                    }
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
                Map<Integer, List<zzff.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzff.zze>> zzg(String str, String str2) {
        Cursor cursorQuery;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"audience_id", "data"};
                String[] strArr2 = {str, str2};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabaseM2388e_.query("property_filters", strArr, "app_id=? AND property_name=?", strArr2, null, null, null);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabaseM2388e_, "property_filters", strArr, "app_id=? AND property_name=?", strArr2, null, null, null);
                }
                Cursor cursor2 = cursorQuery;
                if (!cursor2.moveToFirst()) {
                    Map<Integer, List<zzff.zze>> mapEmptyMap = Collections.emptyMap();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzff.zze zzeVar = (zzff.zze) ((com.google.android.gms.internal.measurement.zzjk) ((zzff.zze.zza) zznp.zza(zzff.zze.zzc(), cursor2.getBlob(1))).zzag());
                        int i = cursor2.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e) {
                        zzj().zzg().zza("Failed to merge filter", zzfw.zza(str), e);
                    }
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e2);
                Map<Integer, List<zzff.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<Integer>> zzn(String str) {
        Cursor cursorRawQuery;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {str, str};
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    cursorRawQuery = sQLiteDatabaseM2388e_.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", strArr);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    cursorRawQuery = SQLiteInstrumentation.rawQuery(sQLiteDatabaseM2388e_, "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", strArr);
                }
                Cursor cursor2 = cursorRawQuery;
                if (!cursor2.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return mapEmptyMap;
                }
                do {
                    int i = cursor2.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursor2.getInt(1)));
                } while (cursor2.moveToNext());
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayMap;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzfw.zza(str), e);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    zzan(zznc zzncVar) {
        super(zzncVar);
        this.zzm = new zzmv(zzb());
        this.zzl = new zzat(this, zza(), "google_app_measurement.db");
    }

    public final void zzp() {
        zzak();
        m2388e_().beginTransaction();
    }

    private final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            String[] strArr = {str2};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                sQLiteDatabaseM2388e_.delete(str, "app_id=?", strArr);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, str, "app_id=?", strArr);
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting snapshot. appId", zzfw.zza(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzo(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "events_snapshot"
            r12.zzi(r0, r13)
            java.lang.String r1 = "name"
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.m2388e_()     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            java.lang.String r4 = "events"
            r11 = 0
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            java.lang.Object[] r1 = r1.toArray(r5)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            r5 = r1
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            java.lang.String r6 = "app_id=?"
            r1 = 1
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            r7[r11] = r13     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            boolean r1 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            r8 = 0
            r9 = 0
            r10 = 0
            if (r1 != 0) goto L2f
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            goto L36
        L2f:
            r1 = r3
            android.database.sqlite.SQLiteDatabase r1 = (android.database.sqlite.SQLiteDatabase) r1     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
        L36:
            r2 = r1
            boolean r1 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r1 != 0) goto L43
            if (r2 == 0) goto L42
            r2.close()
        L42:
            return
        L43:
            java.lang.String r1 = r2.getString(r11)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r1 == 0) goto L52
            com.google.android.gms.measurement.internal.zzbb r1 = r12.zzd(r13, r1)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r1 == 0) goto L52
            r12.zza(r0, r1)     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
        L52:
            boolean r1 = r2.moveToNext()     // Catch: java.lang.Throwable -> L5e android.database.sqlite.SQLiteException -> L60
            if (r1 != 0) goto L43
            if (r2 == 0) goto L77
            r2.close()
            return
        L5e:
            r13 = move-exception
            goto L78
        L60:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfw r1 = r12.zzj()     // Catch: java.lang.Throwable -> L5e
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r3 = "Error creating snapshot. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzfw.zza(r13)     // Catch: java.lang.Throwable -> L5e
            r1.zza(r3, r13, r0)     // Catch: java.lang.Throwable -> L5e
            if (r2 == 0) goto L77
            r2.close()
        L77:
            return
        L78:
            if (r2 == 0) goto L7d
            r2.close()
        L7d:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzo(java.lang.String):void");
    }

    public final void zzu() {
        zzak();
        m2388e_().endTransaction();
    }

    final void zza(List<Long> list) {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzan()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                String str2 = "UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)";
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    sQLiteDatabaseM2388e_.execSQL(str2);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    SQLiteInstrumentation.execSQL(sQLiteDatabaseM2388e_, str2);
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzv() {
        zzt();
        zzak();
        if (zzan()) {
            long jZza = zzn().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbh.zzy.zza(null).longValue()) {
                zzn().zza.zza(jElapsedRealtime);
                zzt();
                zzak();
                if (zzan()) {
                    SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                    String[] strArr = {String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzae.zzm())};
                    int iDelete = !(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) ? sQLiteDatabaseM2388e_.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", strArr) : SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", strArr);
                    if (iDelete > 0) {
                        zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            String[] strArr = {str, str2};
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                sQLiteDatabaseM2388e_.delete("user_attributes", "app_id=? and name=?", strArr);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "user_attributes", "app_id=? and name=?", strArr);
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfw.zza(str), zzi().zzc(str2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzp(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzp(java.lang.String):void");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    final void zza(String str, List<zzff.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzff.zza.C5970zza c5970zzaZzca = list.get(i).zzca();
            if (c5970zzaZzca.zza() != 0) {
                for (int i2 = 0; i2 < c5970zzaZzca.zza(); i2++) {
                    zzff.zzb.zza zzaVarZzca = c5970zzaZzca.zza(i2).zzca();
                    zzff.zzb.zza zzaVar = (zzff.zzb.zza) ((zzjk.zza) zzaVarZzca.clone());
                    String strZzb = zzir.zzb(zzaVarZzca.zzb());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzca.zza(); i3++) {
                        zzff.zzc zzcVarZza = zzaVarZzca.zza(i3);
                        String strZza = zzit.zza(zzcVarZza.zze());
                        if (strZza != null) {
                            zzaVar.zza(i3, (zzff.zzc) ((com.google.android.gms.internal.measurement.zzjk) zzcVarZza.zzca().zza(strZza).zzag()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        c5970zzaZzca = c5970zzaZzca.zza(i2, zzaVar);
                        list.set(i, (zzff.zza) ((com.google.android.gms.internal.measurement.zzjk) c5970zzaZzca.zzag()));
                    }
                }
            }
            if (c5970zzaZzca.zzb() != 0) {
                for (int i4 = 0; i4 < c5970zzaZzca.zzb(); i4++) {
                    zzff.zze zzeVarZzb = c5970zzaZzca.zzb(i4);
                    String strZza2 = zzis.zza(zzeVarZzb.zze());
                    if (strZza2 != null) {
                        c5970zzaZzca = c5970zzaZzca.zza(i4, zzeVarZzb.zzca().zza(strZza2));
                        list.set(i, (zzff.zza) ((com.google.android.gms.internal.measurement.zzjk) c5970zzaZzca.zzag()));
                    }
                }
            }
        }
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        sQLiteDatabaseM2388e_.beginTransaction();
        try {
            zzak();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseM2388e_2 = m2388e_();
            String[] strArr = {str};
            if (sQLiteDatabaseM2388e_2 instanceof SQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_2;
                SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_2, "property_filters", "app_id=?", strArr);
            } else {
                sQLiteDatabaseM2388e_2.delete("property_filters", "app_id=?", strArr);
            }
            String[] strArr2 = {str};
            if (sQLiteDatabaseM2388e_2 instanceof SQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabaseM2388e_2;
                SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_2, "event_filters", "app_id=?", strArr2);
            } else {
                sQLiteDatabaseM2388e_2.delete("event_filters", "app_id=?", strArr2);
            }
            for (zzff.zza zzaVar2 : list) {
                zzak();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzfw.zza(str));
                } else {
                    int iZza = zzaVar2.zza();
                    Iterator<zzff.zzb> it2 = zzaVar2.zze().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator<zzff.zze> it3 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfw.zza(str), Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator<zzff.zzb> it4 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            if (!zza(str, iZza, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzff.zze> it5 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it5.hasNext()) {
                                                if (!zza(str, iZza, it5.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseM2388e_3 = m2388e_();
                                        String[] strArr3 = {str, String.valueOf(iZza)};
                                        if (sQLiteDatabaseM2388e_3 instanceof SQLiteDatabase) {
                                            SQLiteDatabase sQLiteDatabase3 = sQLiteDatabaseM2388e_3;
                                            SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_3, "property_filters", "app_id=? and audience_id=?", strArr3);
                                        } else {
                                            sQLiteDatabaseM2388e_3.delete("property_filters", "app_id=? and audience_id=?", strArr3);
                                        }
                                        String[] strArr4 = {str, String.valueOf(iZza)};
                                        if (sQLiteDatabaseM2388e_3 instanceof SQLiteDatabase) {
                                            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabaseM2388e_3;
                                            SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_3, "event_filters", "app_id=? and audience_id=?", strArr4);
                                        } else {
                                            sQLiteDatabaseM2388e_3.delete("event_filters", "app_id=? and audience_id=?", strArr4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzff.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseM2388e_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseM2388e_.endTransaction();
        }
    }

    public final void zzw() {
        zzak();
        m2388e_().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(com.google.android.gms.measurement.internal.zzf r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzf, boolean, boolean):void");
    }

    public final void zza(String str, zzax zzaxVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaxVar);
        zzt();
        zzak();
        if (zze().zza(zzbh.zzck) && zzi(str) == zzin.zza) {
            zzb(str, zzin.zza);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzaxVar.zzf());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zza(zzbb zzbbVar) {
        zza("events", zzbbVar);
    }

    private final void zza(String str, zzbb zzbbVar) {
        long jInsertWithOnConflict;
        Preconditions.checkNotNull(zzbbVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbbVar.zza);
        contentValues.put("name", zzbbVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbbVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbbVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbbVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbbVar.zzg));
        contentValues.put("last_bundled_day", zzbbVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbbVar.zzi);
        contentValues.put("last_sampling_rate", zzbbVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbbVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzbbVar.zzk == null || !zzbbVar.zzk.booleanValue()) ? null : 1L);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, str, null, contentValues, 5);
            } else {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict(str, null, contentValues, 5);
            }
            if (jInsertWithOnConflict == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfw.zza(zzbbVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfw.zza(zzbbVar.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        int iUpdate;
        long jInsertWithOnConflict;
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfw.zza(str2));
                return;
            }
            String str3 = str2 + " = ?";
            String[] strArr = {asString};
            if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                iUpdate = SQLiteInstrumentation.update(sQLiteDatabaseM2388e_, str, contentValues, str3, strArr);
            } else {
                iUpdate = sQLiteDatabaseM2388e_.update(str, contentValues, str3, strArr);
            }
            if (iUpdate == 0) {
                if (sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) {
                    SQLiteDatabase sQLiteDatabase2 = sQLiteDatabaseM2388e_;
                    jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, str, null, contentValues, 5);
                } else {
                    jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict(str, null, contentValues, 5);
                }
                if (jInsertWithOnConflict == -1) {
                    zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfw.zza(str), zzfw.zza(str2));
                }
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfw.zza(str), zzfw.zza(str2), e);
        }
    }

    public final void zza(String str, zzin zzinVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzak();
        zzb(str, zzi(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzinVar.zzh());
        zza("consent_settings", "app_id", contentValues);
    }

    public final void zzb(String str, zzin zzinVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzinVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzinVar.zzh());
        contentValues.put("consent_source", Integer.valueOf(zzinVar.zza()));
        zza("consent_settings", "app_id", contentValues);
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zze().zzb(str, zzbh.zzaf)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList) + ")") + " order by rowid desc limit -1 offset ?)";
            String[] strArr = {str, Integer.toString(iMax)};
            return (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase) ? sQLiteDatabaseM2388e_.delete("audience_filter_values", str2, strArr) : SQLiteInstrumentation.delete(sQLiteDatabaseM2388e_, "audience_filter_values", str2, strArr)) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzfn.zzj zzjVar, boolean z) {
        long jInsert;
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzy());
        Preconditions.checkState(zzjVar.zzbg());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzjVar.zzm() < jCurrentTimeMillis - zzae.zzm() || zzjVar.zzm() > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfw.zza(zzjVar.zzy()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzjVar.zzm()));
        }
        try {
            byte[] bArrZzb = mo2390g_().zzb(zzjVar.zzbx());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzjVar.zzy());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzjVar.zzm()));
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzjVar.zzbn()) {
                contentValues.put("retry_count", Integer.valueOf(zzjVar.zzg()));
            }
            try {
                SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
                if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                    jInsert = sQLiteDatabaseM2388e_.insert("queue", null, contentValues);
                } else {
                    SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                    jInsert = SQLiteInstrumentation.insert(sQLiteDatabaseM2388e_, "queue", null, contentValues);
                }
                if (jInsert != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfw.zza(zzjVar.zzy()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfw.zza(zzjVar.zzy()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfw.zza(zzjVar.zzy()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zzb zzbVar) {
        long jInsertWithOnConflict;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbx = zzbVar.zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzbx);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("event_filters", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "event_filters", null, contentValues, 5);
            }
            if (jInsertWithOnConflict != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfw.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzff.zze zzeVar) {
        long jInsertWithOnConflict;
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfw.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbx = zzeVar.zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbx);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("property_filters", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "property_filters", null, contentValues, 5);
            }
            if (jInsertWithOnConflict != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzay zzayVar, long j, boolean z) {
        long jInsert;
        zzt();
        zzak();
        Preconditions.checkNotNull(zzayVar);
        Preconditions.checkNotEmpty(zzayVar.zza);
        byte[] bArrZzbx = mo2390g_().zza(zzayVar).zzbx();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzayVar.zza);
        contentValues.put("name", zzayVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzayVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbx);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsert = sQLiteDatabaseM2388e_.insert("raw_events", null, contentValues);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsert = SQLiteInstrumentation.insert(sQLiteDatabaseM2388e_, "raw_events", null, contentValues);
            }
            if (jInsert != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfw.zza(zzayVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfw.zza(zzayVar.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmu zzmuVar) {
        long jInsert;
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmuVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzmuVar.zzb < jCurrentTimeMillis - zzae.zzm() || zzmuVar.zzb > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfw.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzmuVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmuVar.zza);
        contentValues.put("source", Integer.valueOf(zzmuVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmuVar.zzb));
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsert = sQLiteDatabaseM2388e_.insert("trigger_uris", null, contentValues);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsert = SQLiteInstrumentation.insert(sQLiteDatabaseM2388e_, "trigger_uris", null, contentValues);
            }
            if (jInsert != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfw.zza(str), e);
            return false;
        }
    }

    private final boolean zzan() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzfn.zze zzeVar) {
        long jInsertWithOnConflict;
        zzt();
        zzak();
        Preconditions.checkNotNull(zzeVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbx = zzeVar.zzbx();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbx);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("main_event_params", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "main_event_params", null, contentValues, 5);
            }
            if (jInsertWithOnConflict != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzac zzacVar) {
        long jInsertWithOnConflict;
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzak();
        String str = zzacVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzacVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzacVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzacVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzacVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzacVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zznt.zza((Parcelable) zzacVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzacVar.zzd));
        zzq();
        contentValues.put("triggered_event", zznt.zza((Parcelable) zzacVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzacVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzacVar.zzj));
        zzq();
        contentValues.put("expired_event", zznt.zza((Parcelable) zzacVar.zzk));
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("conditional_properties", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "conditional_properties", null, contentValues, 5);
            }
            if (jInsertWithOnConflict == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfw.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfw.zza(str), e);
        }
        return true;
    }

    final boolean zza(String str, Bundle bundle) {
        long jInsertWithOnConflict;
        zzt();
        zzak();
        byte[] bArrZzbx = mo2390g_().zza(new zzay(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbx();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbx);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("default_event_params", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "default_event_params", null, contentValues, 5);
            }
            if (jInsertWithOnConflict != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfw.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfw.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zznq zznqVar) {
        long jInsertWithOnConflict;
        Preconditions.checkNotNull(zznqVar);
        zzt();
        zzak();
        if (zze(zznqVar.zza, zznqVar.zzc) == null) {
            if (zznt.zzh(zznqVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznqVar.zza}) >= zze().zza(zznqVar.zza, zzbh.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zznqVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznqVar.zza, zznqVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznqVar.zza);
        contentValues.put("origin", zznqVar.zzb);
        contentValues.put("name", zznqVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznqVar.zzd));
        zza(contentValues, "value", zznqVar.zze);
        try {
            SQLiteDatabase sQLiteDatabaseM2388e_ = m2388e_();
            if (!(sQLiteDatabaseM2388e_ instanceof SQLiteDatabase)) {
                jInsertWithOnConflict = sQLiteDatabaseM2388e_.insertWithOnConflict("user_attributes", null, contentValues, 5);
            } else {
                SQLiteDatabase sQLiteDatabase = sQLiteDatabaseM2388e_;
                jInsertWithOnConflict = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabaseM2388e_, "user_attributes", null, contentValues, 5);
            }
            if (jInsertWithOnConflict == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfw.zza(zznqVar.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfw.zza(zznqVar.zza), e);
        }
        return true;
    }
}
