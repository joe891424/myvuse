package com.google.android.gms.internal.mlkit_common;

import com.google.android.datatransport.Transformer;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzih implements Transformer {
    static final Transformer zza = new zzih();

    private zzih() {
    }

    @Override // com.google.android.datatransport.Transformer
    public final Object apply(Object obj) {
        return (byte[]) obj;
    }
}
