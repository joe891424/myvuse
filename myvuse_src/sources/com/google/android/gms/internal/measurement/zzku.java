package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import com.facebook.soloader.Elf64_Ehdr;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@22.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzku<T> implements zzli<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmh.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkq zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzky zzn;
    private final zzka zzo;
    private final zzmc<?, ?> zzp;
    private final zziz<?> zzq;
    private final zzkn zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzmh.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzmh.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzmo zzmoVar, Class<?> cls, zzhw zzhwVar) throws IOException {
        switch (zzkx.zza[zzmoVar.ordinal()]) {
            case 1:
                int iZzd = zzht.zzd(bArr, i, zzhwVar);
                zzhwVar.zzc = Boolean.valueOf(zzhwVar.zzb != 0);
                return iZzd;
            case 2:
                return zzht.zza(bArr, i, zzhwVar);
            case 3:
                zzhwVar.zzc = Double.valueOf(zzht.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhwVar.zzc = Integer.valueOf(zzht.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhwVar.zzc = Long.valueOf(zzht.zzd(bArr, i));
                return i + 8;
            case 8:
                zzhwVar.zzc = Float.valueOf(zzht.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzht.zzc(bArr, i, zzhwVar);
                zzhwVar.zzc = Integer.valueOf(zzhwVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzht.zzd(bArr, i, zzhwVar);
                zzhwVar.zzc = Long.valueOf(zzhwVar.zzb);
                return iZzd2;
            case 14:
                return zzht.zza(zzle.zza().zza((Class) cls), bArr, i, i2, zzhwVar);
            case 15:
                int iZzc2 = zzht.zzc(bArr, i, zzhwVar);
                zzhwVar.zzc = Integer.valueOf(zzil.zza(zzhwVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzht.zzd(bArr, i, zzhwVar);
                zzhwVar.zzc = Long.valueOf(zzil.zza(zzhwVar.zzb));
                return iZzd3;
            case 17:
                return zzht.zzb(bArr, i, zzhwVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v243 */
    /* JADX WARN: Type inference failed for: r0v245 */
    /* JADX WARN: Type inference failed for: r0v246 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.android.gms.internal.measurement.zzln, com.google.android.gms.internal.measurement.zzln<T extends com.google.android.gms.internal.measurement.zzjc<T>, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v61 */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.zzli
    public final int zza(T t) {
        int i;
        ?? r16;
        ?? r5;
        ?? r15;
        int iZza;
        int iZza2;
        int iZzd;
        int iZzd2;
        int iZzf;
        int iZzg;
        Unsafe unsafe = zzb;
        ?? r9 = 0;
        int i2 = 1048575;
        ?? r1 = 0;
        int i3 = 0;
        int iZzd3 = 0;
        int i4 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzc = zzc(i3);
            int i5 = (267386880 & iZzc) >>> 20;
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            ?? r12 = r1;
            if (i5 <= 17) {
                if (i8 != i4) {
                    r12 = i8 == i2 ? r9 : unsafe.getInt(t, i8);
                    i4 = i8;
                }
                i = i4;
                r16 = r12;
                r5 = 1 << (i7 >>> 20);
            } else {
                i = i4;
                r16 = r1 == true ? 1 : 0;
                r5 = r9;
            }
            long j = iZzc & i2;
            if (i5 >= zzjf.DOUBLE_LIST_PACKED.zza()) {
                zzjf.SINT64_LIST_PACKED.zza();
            }
            ?? r17 = r5;
            switch (i5) {
                case 0:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zza(i6, 0.0d);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 1:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zza(i6, 0.0f);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 2:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zzb(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 3:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zze(i6, unsafe.getLong(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 4:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zzc(i6, unsafe.getInt(t, j));
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 5:
                    r15 = r9;
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza = zzir.zza(i6, 0L);
                        r15 = r15;
                        iZzd3 += iZza;
                    }
                    break;
                case 6:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        r15 = 0;
                        iZza = zzir.zzb(i6, 0);
                        iZzd3 += iZza;
                    }
                    r15 = 0;
                    break;
                case 7:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zza(i6, true);
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 8:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzhx) {
                            iZza2 = zzir.zza(i6, (zzhx) object);
                        } else {
                            iZza2 = zzir.zza(i6, (String) object);
                        }
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 9:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzlk.zza(i6, unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 10:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zza(i6, (zzhx) unsafe.getObject(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 11:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zzf(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 12:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zza(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 13:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZzd3 += zzir.zzd(i6, 0);
                    }
                    r15 = 0;
                    break;
                case 14:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zzc(i6, 0L);
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 15:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zze(i6, unsafe.getInt(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 16:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zzd(i6, unsafe.getLong(t, j));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 17:
                    if (zza(t, i3, i, r16 == true ? 1 : 0, r17 == true ? 1 : 0)) {
                        iZza2 = zzir.zza(i6, (zzkq) unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZza2;
                    }
                    r15 = 0;
                    break;
                case 18:
                    iZzd = zzlk.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 19:
                    iZzd = zzlk.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 20:
                    iZzd = zzlk.zzf(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 21:
                    iZzd = zzlk.zzj(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 22:
                    iZzd = zzlk.zze(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 23:
                    iZzd = zzlk.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 24:
                    iZzd = zzlk.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 25:
                    iZzd = zzlk.zza(i6, (List<?>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 26:
                    iZzd = zzlk.zzb(i6, (List) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 27:
                    iZzd = zzlk.zzb(i6, (List<?>) unsafe.getObject(t, j), zze(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 28:
                    iZzd = zzlk.zza(i6, (List<zzhx>) unsafe.getObject(t, j));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 29:
                    iZzd = zzlk.zzi(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 30:
                    iZzd = zzlk.zzb(i6, (List<Integer>) unsafe.getObject(t, j), (boolean) r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 31:
                    iZzd = zzlk.zzc(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 32:
                    iZzd = zzlk.zzd(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 33:
                    iZzd = zzlk.zzg(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 34:
                    iZzd = zzlk.zzh(i6, (List) unsafe.getObject(t, j), r9);
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 35:
                    iZzd2 = zzlk.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 36:
                    iZzd2 = zzlk.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 37:
                    iZzd2 = zzlk.zzf((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 38:
                    iZzd2 = zzlk.zzj((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 39:
                    iZzd2 = zzlk.zze((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 40:
                    iZzd2 = zzlk.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 41:
                    iZzd2 = zzlk.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 42:
                    iZzd2 = zzlk.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 43:
                    iZzd2 = zzlk.zzi((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 44:
                    iZzd2 = zzlk.zzb((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 45:
                    iZzd2 = zzlk.zzc((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 46:
                    iZzd2 = zzlk.zzd((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 47:
                    iZzd2 = zzlk.zzg((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case 48:
                    iZzd2 = zzlk.zzh((List) unsafe.getObject(t, j));
                    if (iZzd2 > 0) {
                        iZzf = zzir.zzf(i6);
                        iZzg = zzir.zzg(iZzd2);
                        iZzd3 += iZzf + iZzg + iZzd2;
                    }
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iZzd = zzlk.zza(i6, (List<zzkq>) unsafe.getObject(t, j), zze(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case 50:
                    iZzd = this.zzr.zza(i6, unsafe.getObject(t, j), zzf(i3));
                    iZzd3 += iZzd;
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, 0.0d);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 52:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, 0.0f);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzb(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 54:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zze(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzc(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 56:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, 0L);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 57:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzb(i6, (int) r9);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, true);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 59:
                    if (zzc(t, i6, i3)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzhx) {
                            iZzd = zzir.zza(i6, (zzhx) object2);
                        } else {
                            iZzd = zzir.zza(i6, (String) object2);
                        }
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 60:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzlk.zza(i6, unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, (zzhx) unsafe.getObject(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzf(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 64:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzd(i6, (int) r9);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 65:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzc(i6, 0L);
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zze(i6, zzc(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zzd(i6, zzd(t, j));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                case 68:
                    if (zzc(t, i6, i3)) {
                        iZzd = zzir.zza(i6, (zzkq) unsafe.getObject(t, j), zze(i3));
                        iZzd3 += iZzd;
                    }
                    r15 = r9;
                    break;
                default:
                    r15 = r9;
                    break;
            }
            i3 += 3;
            i4 = i;
            r9 = r15;
            r1 = r16;
            i2 = 1048575;
        }
        ?? r152 = r9;
        zzmc<?, ?> zzmcVar = this.zzp;
        int iZza3 = iZzd3 + zzmcVar.zza(zzmcVar.zzd(t));
        if (!this.zzh) {
            return iZza3;
        }
        zzja zzjaVarZza = this.zzq.zza(t);
        ?? r92 = r152;
        ?? Zza = r152;
        while (r92 < zzjaVarZza.zza.zzb()) {
            Map.Entry entryZzb = zzjaVarZza.zza.zzb(r92);
            r92++;
            Zza += zzja.zza((zzjc<?>) entryZzb.getKey(), entryZzb.getValue());
        }
        ?? Zza2 = Zza;
        for (Map.Entry entry : zzjaVarZza.zza.zzc()) {
            Zza2 += zzja.zza((zzjc<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + Zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjn.zza(Double.doubleToLongBits(zzmh.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzmh.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzmh.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzmh.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzmh.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzmh.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjn.zza(zzmh.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzmh.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i2 * 53;
                    iZza = zzmh.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzmh.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                    }
                    break;
                case 52:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 54:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 56:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 57:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case Elf64_Ehdr.e_shentsize /* 58 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zze(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 59:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzmh.zze(t, j)).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case 60:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmh.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmh.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 64:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case 65:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjn.zza(zzd(t, j));
                        i2 = i + iZza;
                    }
                    break;
                case 68:
                    if (zzc(t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzmh.zze(t, j).hashCode();
                        i2 = i + iZza;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzmh.zze(t, j)).intValue();
    }

    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zza(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.measurement.zzhw r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzhw):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzmh.zze(t, j)).longValue();
    }

    private final zzjp zzd(int i) {
        return (zzjp) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.measurement.zzku<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzko r34, com.google.android.gms.internal.measurement.zzky r35, com.google.android.gms.internal.measurement.zzka r36, com.google.android.gms.internal.measurement.zzmc<?, ?> r37, com.google.android.gms.internal.measurement.zziz<?> r38, com.google.android.gms.internal.measurement.zzkn r39) {
        /*
            Method dump skipped, instruction units count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzko, com.google.android.gms.internal.measurement.zzky, com.google.android.gms.internal.measurement.zzka, com.google.android.gms.internal.measurement.zzmc, com.google.android.gms.internal.measurement.zziz, com.google.android.gms.internal.measurement.zzkn):com.google.android.gms.internal.measurement.zzku");
    }

    private final zzli zze(int i) {
        int i2 = (i / 3) << 1;
        zzli zzliVar = (zzli) this.zzd[i2];
        if (zzliVar != null) {
            return zzliVar;
        }
        zzli<T> zzliVarZza = zzle.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzliVarZza;
        return zzliVarZza;
    }

    private static zzmf zze(Object obj) {
        zzjk zzjkVar = (zzjk) obj;
        zzmf zzmfVar = zzjkVar.zzb;
        if (zzmfVar != zzmf.zzc()) {
            return zzmfVar;
        }
        zzmf zzmfVarZzd = zzmf.zzd();
        zzjkVar.zzb = zzmfVarZzd;
        return zzmfVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmc<UT, UB> zzmcVar, Object obj2) {
        zzjp zzjpVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzmh.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzjpVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzjpVarZzd, ub, zzmcVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjp zzjpVar, UB ub, zzmc<UT, UB> zzmcVar, Object obj) {
        zzkl<?, ?> zzklVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!zzjpVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmcVar.zzc(obj);
                }
                zzig zzigVarZzc = zzhx.zzc(zzki.zza(zzklVarZza, next.getKey(), next.getValue()));
                try {
                    zzki.zza(zzigVarZzc.zzb(), zzklVarZza, next.getKey(), next.getValue());
                    zzmcVar.zza(ub, i2, zzigVarZzc.zza());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzli zzliVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((Object) t, i)) {
            return zzliVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzliVarZze.zza();
        if (object != null) {
            zzliVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzli zzliVarZze = zze(i2);
        if (!zzc(t, i, i2)) {
            return zzliVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzliVarZze.zza();
        if (object != null) {
            zzliVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzku(int[] iArr, Object[] objArr, int i, int i2, zzkq zzkqVar, zzlf zzlfVar, boolean z, int[] iArr2, int i3, int i4, zzky zzkyVar, zzka zzkaVar, zzmc<?, ?> zzmcVar, zziz<?> zzizVar, zzkn zzknVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzkqVar instanceof zzjk;
        this.zzh = zzizVar != null && zzizVar.zza(zzkqVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzkyVar;
        this.zzo = zzkaVar;
        this.zzp = zzmcVar;
        this.zzq = zzizVar;
        this.zzg = zzkqVar;
        this.zzr = zzknVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzc(T r8) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zzc(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza(t, j, zzmh.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zzc((Object) t2, i)) {
                        zzmh.zzc(t, j, zzmh.zzh(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza(t, j, zzmh.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza(t, j, zzmh.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zzc((Object) t2, i)) {
                        zzmh.zza((Object) t, j, zzmh.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzlk.zza(this.zzr, t, t2, j);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case 54:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case Elf64_Ehdr.e_shentsize /* 58 */:
                case 59:
                    if (zzc(t2, i2, i)) {
                        zzmh.zza(t, j, zzmh.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case Elf64_Ehdr.e_shstrndx /* 62 */:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (zzc(t2, i2, i)) {
                        zzmh.zza(t, j, zzmh.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzlk.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzlk.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0620 A[Catch: all -> 0x0295, TryCatch #2 {all -> 0x0295, blocks: (B:153:0x05f4, B:163:0x061b, B:165:0x0620, B:166:0x0625, B:49:0x00c9, B:50:0x00db, B:51:0x00ed, B:52:0x00ff, B:53:0x0110, B:54:0x0121, B:56:0x012b, B:59:0x0132, B:60:0x0139, B:61:0x0146, B:62:0x0157, B:63:0x0164, B:64:0x0175, B:66:0x0180, B:67:0x0191, B:68:0x01a2, B:69:0x01b3, B:70:0x01c4, B:71:0x01d5, B:72:0x01e6, B:73:0x01f7, B:74:0x0209, B:76:0x0219, B:80:0x023a, B:77:0x0223, B:79:0x022b, B:81:0x024b, B:82:0x025d, B:83:0x026b, B:84:0x0279, B:85:0x0287), top: B:189:0x05f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0657 A[LOOP:3: B:181:0x0653->B:183:0x0657, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x062b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzlj] */
    @Override // com.google.android.gms.internal.measurement.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzlj r19, com.google.android.gms.internal.measurement.zzix r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlj, com.google.android.gms.internal.measurement.zzix):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final void zza(T t, byte[] bArr, int i, int i2, zzhw zzhwVar) throws IOException {
        zza(t, bArr, i, i2, 0, zzhwVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((Object) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzli zzliVarZze = zze(i);
            if (!zzc((Object) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzliVarZze.zza();
                    zzliVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((Object) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzliVarZze.zza();
                zzliVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzliVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzli zzliVarZze = zze(i);
            if (!zzc(t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzliVarZze.zza();
                    zzliVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb(t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzliVarZze.zza();
                zzliVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzliVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzlj zzljVar) throws IOException {
        if (zzg(i)) {
            zzmh.zza(obj, i & 1048575, zzljVar.zzr());
        } else if (this.zzi) {
            zzmh.zza(obj, i & 1048575, zzljVar.zzq());
        } else {
            zzmh.zza(obj, i & 1048575, zzljVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzmh.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzmh.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzmh.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((Object) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zzmx zzmxVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzmxVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzmx zzmxVar) throws IOException {
        if (obj instanceof String) {
            zzmxVar.zza(i, (String) obj);
        } else {
            zzmxVar.zza(i, (zzhx) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:176:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zzmx r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzmx):void");
    }

    private static <UT, UB> void zza(zzmc<UT, UB> zzmcVar, T t, zzmx zzmxVar) throws IOException {
        zzmcVar.zzb(zzmcVar.zzd(t), zzmxVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((Object) t, i) == zzc((Object) t2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzmh.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzmh.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmh.zzb(t, j2)) != 0;
            case 2:
                return zzmh.zzd(t, j2) != 0;
            case 3:
                return zzmh.zzd(t, j2) != 0;
            case 4:
                return zzmh.zzc(t, j2) != 0;
            case 5:
                return zzmh.zzd(t, j2) != 0;
            case 6:
                return zzmh.zzc(t, j2) != 0;
            case 7:
                return zzmh.zzh(t, j2);
            case 8:
                Object objZze = zzmh.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzhx) {
                    return !zzhx.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmh.zze(t, j2) != null;
            case 10:
                return !zzhx.zza.equals(zzmh.zze(t, j2));
            case 11:
                return zzmh.zzc(t, j2) != 0;
            case 12:
                return zzmh.zzc(t, j2) != 0;
            case 13:
                return zzmh.zzc(t, j2) != 0;
            case 14:
                return zzmh.zzd(t, j2) != 0;
            case 15:
                return zzmh.zzc(t, j2) != 0;
            case 16:
                return zzmh.zzd(t, j2) != 0;
            case 17:
                return zzmh.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzli] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzli] */
    @Override // com.google.android.gms.internal.measurement.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzd(T r18) {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzku.zzd(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzli zzliVar) {
        return zzliVar.zzd(zzmh.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjk) {
            return ((zzjk) obj).zzcj();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzmh.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzmh.zze(t, j)).booleanValue();
    }
}
