package com.google.android.gms.internal.common;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzad extends zzaa {
    public zzad() {
        super(4);
    }

    public final zzad zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzad zzc(Iterator it2) {
        while (it2.hasNext()) {
            super.zza(it2.next());
        }
        return this;
    }

    zzad(int i) {
        super(4);
    }
}
