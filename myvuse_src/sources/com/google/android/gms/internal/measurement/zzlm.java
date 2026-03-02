package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlm<FieldDescriptorType> extends zzln<FieldDescriptorType, Object> {
    zzlm(int i) {
        super(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final void zza() {
        if (!zze()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry<FieldDescriptorType, Object> entryZzb = zzb(i);
                if (((zzjc) entryZzb.getKey()).zze()) {
                    entryZzb.setValue(Collections.unmodifiableList((List) entryZzb.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : zzc()) {
                if (((zzjc) entry.getKey()).zze()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
