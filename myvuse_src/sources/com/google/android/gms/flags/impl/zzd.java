package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.LogInstrumentation;

/* JADX INFO: loaded from: classes3.dex */
public final class zzd extends zza<Integer> {
    public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) com.google.android.gms.internal.flags.zze.zza(new zze(sharedPreferences, str, num));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            LogInstrumentation.m2734w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return num;
        }
    }
}
