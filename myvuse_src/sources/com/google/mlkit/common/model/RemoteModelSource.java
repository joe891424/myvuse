package com.google.mlkit.common.model;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_common.zzt;
import com.google.android.gms.internal.mlkit_common.zzu;

/* JADX INFO: compiled from: com.google.mlkit:common@@17.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteModelSource {
    private final String zza;

    protected RemoteModelSource(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return Objects.equal(this.zza, ((RemoteModelSource) obj).zza);
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public String toString() {
        zzt zztVarZzb = zzu.zzb("RemoteModelSource");
        zztVarZzb.zza("firebaseModelName", this.zza);
        return zztVarZzb.toString();
    }

    public final String zza() {
        return this.zza;
    }
}
