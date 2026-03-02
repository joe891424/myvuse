package kotlin.collections;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u0014\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0018\u001a'\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, m5598d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewProps.LEFT, ViewProps.RIGHT, "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m7689partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM7309getw2LRezQ = UByteArray.m7309getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM7309getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m7309getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m7309getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM7309getw2LRezQ2 = UByteArray.m7309getw2LRezQ(bArr, i);
                UByteArray.m7314setVurrAj0(bArr, i, UByteArray.m7309getw2LRezQ(bArr, i2));
                UByteArray.m7314setVurrAj0(bArr, i2, bM7309getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m7693quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM7689partition4UcCI2c = m7689partition4UcCI2c(bArr, i, i2);
        int i3 = iM7689partition4UcCI2c - 1;
        if (i < i3) {
            m7693quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM7689partition4UcCI2c < i2) {
            m7693quickSort4UcCI2c(bArr, iM7689partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m7690partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM7572getMh2AYeg = UShortArray.m7572getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM7572getMh2AYeg = UShortArray.m7572getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM7572getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM7572getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m7572getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM7572getMh2AYeg2 = UShortArray.m7572getMh2AYeg(sArr, i);
                UShortArray.m7577set01HTLdE(sArr, i, UShortArray.m7572getMh2AYeg(sArr, i2));
                UShortArray.m7577set01HTLdE(sArr, i2, sM7572getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m7694quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM7690partitionAa5vz7o = m7690partitionAa5vz7o(sArr, i, i2);
        int i3 = iM7690partitionAa5vz7o - 1;
        if (i < i3) {
            m7694quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM7690partitionAa5vz7o < i2) {
            m7694quickSortAa5vz7o(sArr, iM7690partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m7691partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM7388getpVg5ArA = UIntArray.m7388getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m7388getpVg5ArA(iArr, i), iM7388getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m7388getpVg5ArA(iArr, i2), iM7388getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM7388getpVg5ArA2 = UIntArray.m7388getpVg5ArA(iArr, i);
                UIntArray.m7393setVXSXFK8(iArr, i, UIntArray.m7388getpVg5ArA(iArr, i2));
                UIntArray.m7393setVXSXFK8(iArr, i2, iM7388getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m7695quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM7691partitionoBK06Vg = m7691partitionoBK06Vg(iArr, i, i2);
        int i3 = iM7691partitionoBK06Vg - 1;
        if (i < i3) {
            m7695quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM7691partitionoBK06Vg < i2) {
            m7695quickSortoBK06Vg(iArr, iM7691partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m7688partitionnroSd4(long[] jArr, int i, int i2) {
        long jM7467getsVKNKU = ULongArray.m7467getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m7467getsVKNKU(jArr, i), jM7467getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m7467getsVKNKU(jArr, i2), jM7467getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM7467getsVKNKU2 = ULongArray.m7467getsVKNKU(jArr, i);
                ULongArray.m7472setk8EXiF4(jArr, i, ULongArray.m7467getsVKNKU(jArr, i2));
                ULongArray.m7472setk8EXiF4(jArr, i2, jM7467getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m7692quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM7688partitionnroSd4 = m7688partitionnroSd4(jArr, i, i2);
        int i3 = iM7688partitionnroSd4 - 1;
        if (i < i3) {
            m7692quickSortnroSd4(jArr, i, i3);
        }
        if (iM7688partitionnroSd4 < i2) {
            m7692quickSortnroSd4(jArr, iM7688partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m7697sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7693quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m7698sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7694quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m7699sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7695quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m7696sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m7692quickSortnroSd4(array, i, i2 - 1);
    }
}
