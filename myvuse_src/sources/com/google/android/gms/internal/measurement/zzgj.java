package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgj extends ContentObserver {
    private final /* synthetic */ zzgh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgj(zzgh zzghVar, Handler handler) {
        super(null);
        this.zza = zzghVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzd();
    }
}
