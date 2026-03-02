package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhq;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhq<MessageType extends zzho<MessageType, BuilderType>, BuilderType extends zzhq<MessageType, BuilderType>> implements zzkt {
    @Override // 
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType zzb(zzil zzilVar, zzix zzixVar) throws IOException;

    @Override // 
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzjt {
        try {
            zzil zzilVarZza = zzil.zza(bArr, 0, i2, false);
            zzb(zzilVarZza, zzix.zza);
            zzilVarZza.zzc(0);
            return this;
        } catch (zzjt e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzix zzixVar) throws zzjt {
        try {
            zzil zzilVarZza = zzil.zza(bArr, 0, i2, false);
            zzb(zzilVarZza, zzixVar);
            zzilVarZza.zzc(0);
            return this;
        } catch (zzjt e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzkt zza(byte[] bArr) throws zzjt {
        return zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzkt
    public final /* synthetic */ zzkt zza(byte[] bArr, zzix zzixVar) throws zzjt {
        return zza(bArr, 0, bArr.length, zzixVar);
    }

    private final String zza(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }
}
