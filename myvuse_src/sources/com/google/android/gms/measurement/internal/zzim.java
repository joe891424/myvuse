package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzim extends zzij {
    private boolean zza;

    zzim(zzhj zzhjVar) {
        super(zzhjVar);
        this.zzu.zzaa();
    }

    protected void zzaa() {
    }

    protected abstract boolean zzo();

    protected final void zzac() {
        if (!zzaf()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzo()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzu.zzz();
        this.zza = true;
    }

    final boolean zzaf() {
        return this.zza;
    }
}
