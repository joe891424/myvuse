package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzic implements zzid {
    @Override // java.util.Iterator
    public /* synthetic */ Byte next() {
        return Byte.valueOf(zza());
    }

    zzic() {
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
