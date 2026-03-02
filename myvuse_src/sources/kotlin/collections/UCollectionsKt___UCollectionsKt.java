package kotlin.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _UCollections.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, m5598d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, m5599k = 5, m5600mv = {1, 9, 0}, m5602xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, m5603xs = "kotlin/collections/UCollectionsKt")
public class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM7303constructorimpl = UByteArray.m7303constructorimpl(collection.size());
        Iterator<UByte> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UByteArray.m7314setVurrAj0(bArrM7303constructorimpl, i, it2.next().getData());
            i++;
        }
        return bArrM7303constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM7382constructorimpl = UIntArray.m7382constructorimpl(collection.size());
        Iterator<UInt> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UIntArray.m7393setVXSXFK8(iArrM7382constructorimpl, i, it2.next().getData());
            i++;
        }
        return iArrM7382constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM7461constructorimpl = ULongArray.m7461constructorimpl(collection.size());
        Iterator<ULong> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            ULongArray.m7472setk8EXiF4(jArrM7461constructorimpl, i, it2.next().getData());
            i++;
        }
        return jArrM7461constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM7566constructorimpl = UShortArray.m7566constructorimpl(collection.size());
        Iterator<UShort> it2 = collection.iterator();
        int i = 0;
        while (it2.hasNext()) {
            UShortArray.m7577set01HTLdE(sArrM7566constructorimpl, i, it2.next().getData());
            i++;
        }
        return sArrM7566constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it2 = iterable.iterator();
        int iM7328constructorimpl = 0;
        while (it2.hasNext()) {
            iM7328constructorimpl = UInt.m7328constructorimpl(iM7328constructorimpl + it2.next().getData());
        }
        return iM7328constructorimpl;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it2 = iterable.iterator();
        long jM7407constructorimpl = 0;
        while (it2.hasNext()) {
            jM7407constructorimpl = ULong.m7407constructorimpl(jM7407constructorimpl + it2.next().getData());
        }
        return jM7407constructorimpl;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it2 = iterable.iterator();
        int iM7328constructorimpl = 0;
        while (it2.hasNext()) {
            iM7328constructorimpl = UInt.m7328constructorimpl(iM7328constructorimpl + UInt.m7328constructorimpl(it2.next().getData() & 255));
        }
        return iM7328constructorimpl;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it2 = iterable.iterator();
        int iM7328constructorimpl = 0;
        while (it2.hasNext()) {
            iM7328constructorimpl = UInt.m7328constructorimpl(iM7328constructorimpl + UInt.m7328constructorimpl(it2.next().getData() & UShort.MAX_VALUE));
        }
        return iM7328constructorimpl;
    }
}
