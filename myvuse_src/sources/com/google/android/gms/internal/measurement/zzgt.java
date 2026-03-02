package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgt {
    private static zzgu zza(Context context, File file) {
        BufferedReader bufferedReader;
        SimpleArrayMap simpleArrayMap;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                simpleArrayMap = new SimpleArrayMap();
                map = new HashMap();
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                LogInstrumentation.m2734w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                zzgl zzglVar = new zzgl(simpleArrayMap);
                bufferedReader.close();
                return zzglVar;
            }
            String[] strArrSplit = line.split(" ", 3);
            if (strArrSplit.length != 3) {
                LogInstrumentation.m2728e("HermeticFileOverrides", "Invalid: " + line);
            } else {
                String strZza = zza(strArrSplit[0]);
                String strDecode = Uri.decode(zza(strArrSplit[1]));
                String strDecode2 = (String) map.get(strArrSplit[2]);
                if (strDecode2 == null) {
                    String strZza2 = zza(strArrSplit[2]);
                    strDecode2 = Uri.decode(strZza2);
                    if (strDecode2.length() < 1024 || strDecode2 == strZza2) {
                        map.put(strZza2, strDecode2);
                    }
                }
                SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(strZza);
                if (simpleArrayMap2 == null) {
                    simpleArrayMap2 = new SimpleArrayMap();
                    simpleArrayMap.put(strZza, simpleArrayMap2);
                }
                simpleArrayMap2.put(strDecode, strDecode2);
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
    public static class zza {
        private static volatile Optional<zzgu> zza;

        public static Optional<zzgu> zza(Context context) {
            Optional<zzgu> optionalZza;
            Optional<zzgu> optional = zza;
            if (optional == null) {
                synchronized (zza.class) {
                    optional = zza;
                    if (optional == null) {
                        new zzgt();
                        if (zzgx.zza(Build.TYPE, Build.TAGS)) {
                            if (zzgf.zza() && !context.isDeviceProtectedStorage()) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                            optionalZza = zzgt.zza(context);
                        } else {
                            optionalZza = Optional.absent();
                        }
                        zza = optionalZza;
                        optional = optionalZza;
                    }
                }
            }
            return optional;
        }

        private zza() {
        }
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.m2408of(file) : Optional.absent();
        } catch (RuntimeException e) {
            LogInstrumentation.m2729e("HermeticFileOverrides", "no data dir", e);
            return Optional.absent();
        }
    }

    static Optional<zzgu> zza(Context context) {
        Optional<zzgu> optionalAbsent;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> optionalZzb = zzb(context);
            if (optionalZzb.isPresent()) {
                optionalAbsent = Optional.m2408of(zza(context, optionalZzb.get()));
            } else {
                optionalAbsent = Optional.absent();
            }
            return optionalAbsent;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
