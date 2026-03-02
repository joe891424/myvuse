package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzho<MessageType extends zzho<MessageType, BuilderType>, BuilderType extends zzhq<MessageType, BuilderType>> implements zzkq {
    protected int zza = 0;

    int zzbv() {
        throw new UnsupportedOperationException();
    }

    int zza(zzli zzliVar) {
        int iZzbv = zzbv();
        if (iZzbv != -1) {
            return iZzbv;
        }
        int iZza = zzliVar.zza(this);
        zzc(iZza);
        return iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final zzhx zzbw() {
        try {
            zzig zzigVarZzc = zzhx.zzc(zzby());
            zza(zzigVarZzc.zzb());
            return zzigVarZzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjn.zza(iterable);
        if (iterable instanceof zzkb) {
            List<?> listZza = ((zzkb) iterable).zza();
            zzkb zzkbVar = (zzkb) list;
            int size = list.size();
            for (Object obj : listZza) {
                if (obj == null) {
                    String str = "Element at index " + (zzkbVar.size() - size) + " is null.";
                    for (int size2 = zzkbVar.size() - 1; size2 >= size; size2--) {
                        zzkbVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzhx) {
                    zzkbVar.zza((zzhx) obj);
                } else if (obj instanceof byte[]) {
                    zzkbVar.zza(zzhx.zza((byte[]) obj));
                } else {
                    zzkbVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzlc) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t : iterable) {
            if (t == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(t);
        }
    }

    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzbx() {
        try {
            byte[] bArr = new byte[zzby()];
            zzir zzirVarZzb = zzir.zzb(bArr);
            zza(zzirVarZzb);
            zzirVarZzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
