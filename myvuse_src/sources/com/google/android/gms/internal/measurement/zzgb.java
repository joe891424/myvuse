package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgb implements zzgd {
    @Override // com.google.android.gms.internal.measurement.zzgd
    public final String zza(ContentResolver contentResolver, String str) throws zzgg {
        Cursor cursorQuery = contentResolver.query(zzfv.zza, null, null, new String[]{str}, null);
        try {
            if (cursorQuery == null) {
                throw new zzgg("Failed to connect to GservicesProvider");
            }
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(1);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgd
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzge<T> zzgeVar) throws zzgg {
        Cursor cursorQuery = contentResolver.query(zzfv.zzb, null, null, strArr, null);
        try {
            if (cursorQuery == null) {
                throw new zzgg("Failed to connect to GservicesProvider");
            }
            T t = (T) zzgeVar.zza(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                t.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return t;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
