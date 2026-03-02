package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzas {
    private static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        String str2 = "SELECT * FROM " + str + " LIMIT 0";
        Cursor cursorRawQuery = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery(str2, null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, str2, null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    static void zza(zzfw zzfwVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzfwVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzfwVar, sQLiteDatabase, str)) {
            if (sQLiteDatabase instanceof SQLiteDatabase) {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
            } else {
                sQLiteDatabase.execSQL(str2);
            }
        }
        try {
            if (zzfwVar == null) {
                throw new IllegalArgumentException("Monitor must not be null");
            }
            Set<String> setZza = zza(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setZza.remove(str4)) {
                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!setZza.remove(strArr[i])) {
                        String str5 = strArr[i + 1];
                        if (sQLiteDatabase instanceof SQLiteDatabase) {
                            SQLiteInstrumentation.execSQL(sQLiteDatabase, str5);
                        } else {
                            sQLiteDatabase.execSQL(str5);
                        }
                    }
                }
            }
            if (setZza.isEmpty()) {
                return;
            }
            zzfwVar.zzu().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", setZza));
        } catch (SQLiteException e) {
            zzfwVar.zzg().zza("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    static void zza(zzfw zzfwVar, SQLiteDatabase sQLiteDatabase) {
        if (zzfwVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(com.google.android.gms.internal.measurement.zzcf.zza().zza(sQLiteDatabase.getPath()));
        if (!file.setReadable(false, false)) {
            zzfwVar.zzu().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzfwVar.zzu().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzfwVar.zzu().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzfwVar.zzu().zza("Failed to turn on database write permission for owner");
    }

    private static boolean zza(zzfw zzfwVar, SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery;
        if (zzfwVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {"name"};
                String[] strArr2 = {str};
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", strArr, "name=?", strArr2, null, null, null);
                } else {
                    cursorQuery = SQLiteInstrumentation.query(sQLiteDatabase, "SQLITE_MASTER", strArr, "name=?", strArr2, null, null, null);
                }
                cursor = cursorQuery;
                boolean zMoveToFirst = cursor.moveToFirst();
                if (cursor != null) {
                    cursor.close();
                }
                return zMoveToFirst;
            } catch (SQLiteException e) {
                zzfwVar.zzu().zza("Error querying for table", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
