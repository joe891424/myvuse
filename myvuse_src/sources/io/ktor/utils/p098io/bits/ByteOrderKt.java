package io.ktor.utils.p098io.bits;

import io.ktor.utils.p098io.core.ExperimentalIoApi;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: ByteOrder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010\u001c\u001a\u00020 *\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0016\u0010\u001c\u001a\u00020#*\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001f\u0010\u000e\u001a\u00020\u0002*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u001f\u0010\u0016\u001a\u00020\b*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u001f\u0010\u0019\u001a\u00020\u0002*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m5598d2 = {"highByte", "", "", "getHighByte$annotations", "(S)V", "getHighByte", "(S)B", "highInt", "", "", "getHighInt$annotations", "(J)V", "getHighInt", "(J)I", "highShort", "getHighShort$annotations", "(I)V", "getHighShort", "(I)S", "lowByte", "getLowByte$annotations", "getLowByte", "lowInt", "getLowInt$annotations", "getLowInt", "lowShort", "getLowShort$annotations", "getLowShort", "reverseByteOrder", "Lkotlin/UInt;", "reverseByteOrder-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "reverseByteOrder-VKZWuLQ", "(J)J", "Lkotlin/UShort;", "reverseByteOrder-xj2QHRw", "(S)S", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteOrderKt {
    public static final byte getHighByte(short s) {
        return (byte) (s >>> 8);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getHighByte$annotations(short s) {
    }

    public static final int getHighInt(long j) {
        return (int) (j >>> 32);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getHighInt$annotations(long j) {
    }

    public static final short getHighShort(int i) {
        return (short) (i >>> 16);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getHighShort$annotations(int i) {
    }

    public static final byte getLowByte(short s) {
        return (byte) (s & 255);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getLowByte$annotations(short s) {
    }

    public static final int getLowInt(long j) {
        return (int) (j & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getLowInt$annotations(long j) {
    }

    public static final short getLowShort(int i) {
        return (short) (i & 65535);
    }

    @ExperimentalIoApi
    public static /* synthetic */ void getLowShort$annotations(int i) {
    }

    /* JADX INFO: renamed from: reverseByteOrder-xj2QHRw, reason: not valid java name */
    public static final short m6949reverseByteOrderxj2QHRw(short s) {
        return UShort.m7514constructorimpl(Short.reverseBytes(s));
    }

    /* JADX INFO: renamed from: reverseByteOrder-WZ4Q5Ns, reason: not valid java name */
    public static final int m6948reverseByteOrderWZ4Q5Ns(int i) {
        return UInt.m7328constructorimpl(Integer.reverseBytes(i));
    }

    /* JADX INFO: renamed from: reverseByteOrder-VKZWuLQ, reason: not valid java name */
    public static final long m6947reverseByteOrderVKZWuLQ(long j) {
        return ULong.m7407constructorimpl(Long.reverseBytes(j));
    }
}
