package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzgd {
    String zza(ContentResolver contentResolver, String str) throws zzgg;

    <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzge<T> zzgeVar) throws zzgg;
}
