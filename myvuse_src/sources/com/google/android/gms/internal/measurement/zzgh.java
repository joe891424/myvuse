package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgh implements zzgo {
    private static final Map<Uri, zzgh> zza = new ArrayMap();
    private static final String[] zzb = {"key", "value"};
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private final ContentObserver zzf;
    private final Object zzg;
    private volatile Map<String, String> zzh;
    private final List<zzgm> zzi;

    public static zzgh zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgh zzghVar;
        synchronized (zzgh.class) {
            Map<Uri, zzgh> map = zza;
            zzghVar = map.get(uri);
            if (zzghVar == null) {
                try {
                    zzgh zzghVar2 = new zzgh(contentResolver, uri, runnable);
                    try {
                        map.put(uri, zzghVar2);
                    } catch (SecurityException unused) {
                    }
                    zzghVar = zzghVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzghVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzh;
        if (mapZze == null) {
            synchronized (this.zzg) {
                mapZze = this.zzh;
                if (mapZze == null) {
                    mapZze = zze();
                    this.zzh = mapZze;
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    final /* synthetic */ Map zzb() {
        Map map;
        Cursor cursorQuery = this.zzc.query(this.zzd, zzb, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzgn.zza(new zzgq() { // from class: com.google.android.gms.internal.measurement.zzgk
                    @Override // com.google.android.gms.internal.measurement.zzgq
                    public final Object zza() {
                        return this.zza.zzb();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                LogInstrumentation.m2728e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private zzgh(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzgj zzgjVar = new zzgj(this, null);
        this.zzf = zzgjVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzgjVar);
    }

    static synchronized void zzc() {
        for (zzgh zzghVar : zza.values()) {
            zzghVar.zzc.unregisterContentObserver(zzghVar.zzf);
        }
        zza.clear();
    }

    public final void zzd() {
        synchronized (this.zzg) {
            this.zzh = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator<zzgm> it2 = this.zzi.iterator();
            while (it2.hasNext()) {
                it2.next().zza();
            }
        }
    }
}
