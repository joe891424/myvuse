package io.ktor.utils.p098io;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.utils.p098io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChannelLittleEndian.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\n\u001a\u00020\t*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\r\u001a\u00020\f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0013\u001a\u00020\u0012*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u0002H\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a<\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u00022\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0081\bø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0015*\u00020\u001d2\u0006\u0010\u001b\u001a\u0002H\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00150\u0017¢\u0006\u0002\b\u0018H\u0082\b¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a%\u0010(\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+\u001a%\u0010,\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a%\u00100\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u001d\u00102\u001a\u00020 *\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u00103\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00064"}, m5598d2 = {"readDouble", "", "Lio/ktor/utils/io/ByteReadChannel;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readDoubleLittleEndian", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFloat", "", "readFloatLittleEndian", "readInt", "", "readIntLittleEndian", "readLong", "", "readLongLittleEndian", "readShort", "", "readShortLittleEndian", "reverseIfNeeded", ExifInterface.GPS_DIRECTION_TRUE, "reverseBlock", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lio/ktor/utils/io/core/ByteOrder;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toLittleEndian", "value", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeDouble", "", "(Lio/ktor/utils/io/ByteWriteChannel;DLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeDoubleLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFloatLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeIntLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLongLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShortLittleEndian", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ChannelLittleEndianKt {

    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ByteOrder.values().length];
            iArr[ByteOrder.LITTLE_ENDIAN.ordinal()] = 1;
            iArr[ByteOrder.BIG_ENDIAN.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {0}, m5610l = {23}, m5611m = "readDouble", m5612n = {"byteOrder"}, m5613s = {"L$0"})
    static final class C53121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53121(Continuation<? super C53121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readDouble(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {}, m5610l = {43}, m5611m = "readDoubleLittleEndian", m5612n = {}, m5613s = {})
    static final class C53131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53131(Continuation<? super C53131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readDoubleLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {0}, m5610l = {19}, m5611m = "readFloat", m5612n = {"byteOrder"}, m5613s = {"L$0"})
    static final class C53141 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53141(Continuation<? super C53141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readFloat(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {}, m5610l = {39}, m5611m = "readFloatLittleEndian", m5612n = {}, m5613s = {})
    static final class C53151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53151(Continuation<? super C53151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readFloatLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readInt$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {0}, m5610l = {11}, m5611m = "readInt", m5612n = {"byteOrder"}, m5613s = {"L$0"})
    static final class C53161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53161(Continuation<? super C53161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readInt(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {}, m5610l = {31}, m5611m = "readIntLittleEndian", m5612n = {}, m5613s = {})
    static final class C53171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53171(Continuation<? super C53171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readIntLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readLong$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {0}, m5610l = {15}, m5611m = "readLong", m5612n = {"byteOrder"}, m5613s = {"L$0"})
    static final class C53181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53181(Continuation<? super C53181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readLong(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {}, m5610l = {35}, m5611m = "readLongLittleEndian", m5612n = {}, m5613s = {})
    static final class C53191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53191(Continuation<? super C53191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readLongLittleEndian(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readShort$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {0}, m5610l = {7}, m5611m = "readShort", m5612n = {"byteOrder"}, m5613s = {"L$0"})
    static final class C53201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53201(Continuation<? super C53201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readShort(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1 */
    /* JADX INFO: compiled from: ChannelLittleEndian.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ChannelLittleEndianKt", m5608f = "ChannelLittleEndian.kt", m5609i = {}, m5610l = {27}, m5611m = "readShortLittleEndian", m5612n = {}, m5613s = {})
    static final class C53211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C53211(Continuation<? super C53211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelLittleEndianKt.readShortLittleEndian(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readShort(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Short> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53201
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readShort$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readShort$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readShort$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.p098io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readShort(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 2
            if (r4 != r5) goto L51
            goto L60
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            short r4 = r6.shortValue()
            short r4 = (short) r4
            short r4 = java.lang.Short.reverseBytes(r4)
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r4)
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readShort(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readShort$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? obj : Short.valueOf(Short.reverseBytes(((Number) obj).shortValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readInt(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53161
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readInt$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readInt$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readInt$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.p098io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readInt(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 2
            if (r4 != r5) goto L51
            goto L5f
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            int r4 = r6.intValue()
            int r4 = java.lang.Integer.reverseBytes(r4)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
        L5f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readInt(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readInt$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? obj : Integer.valueOf(Integer.reverseBytes(((Number) obj).intValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readLong(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Long> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53181
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readLong$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readLong$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readLong$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.p098io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readLong(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 2
            if (r4 != r5) goto L51
            goto L5f
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            long r4 = java.lang.Long.reverseBytes(r4)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
        L5f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readLong(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readLong$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? obj : Long.valueOf(Long.reverseBytes(((Number) obj).longValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFloat(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53141
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readFloat$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.p098io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readFloat(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 2
            if (r4 != r5) goto L51
            goto L67
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            float r4 = r6.floatValue()
            int r4 = java.lang.Float.floatToRawIntBits(r4)
            int r4 = java.lang.Integer.reverseBytes(r4)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
        L67:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readFloat(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readFloat$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? obj : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readDouble(io.ktor.utils.p098io.ByteReadChannel r4, io.ktor.utils.p098io.core.ByteOrder r5, kotlin.coroutines.Continuation<? super java.lang.Double> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53121
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53121) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readDouble$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.core.ByteOrder r5 = (io.ktor.utils.p098io.core.ByteOrder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.readDouble(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            int[] r4 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r4 = r4[r5]
            r5 = 2
            if (r4 != r5) goto L51
            goto L67
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            double r4 = r6.doubleValue()
            long r4 = java.lang.Double.doubleToRawLongBits(r4)
            long r4 = java.lang.Long.reverseBytes(r4)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            java.lang.Double r6 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
        L67:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readDouble(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.core.ByteOrder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readDouble$$forInline(ByteReadChannel byteReadChannel, ByteOrder byteOrder, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? obj : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readShortLittleEndian(io.ktor.utils.p098io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Short> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53211
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readShortLittleEndian$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.p098io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.readShort(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.ByteOrder r4 = r4.getReadByteOrder()
            int[] r0 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            if (r4 != r3) goto L53
            goto L62
        L53:
            java.lang.Number r5 = (java.lang.Number) r5
            short r4 = r5.shortValue()
            short r4 = (short) r4
            short r4 = java.lang.Short.reverseBytes(r4)
            java.lang.Short r5 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r4)
        L62:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readShortLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readShortLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Short> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readShort(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? obj : Short.valueOf(Short.reverseBytes(((Number) obj).shortValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readIntLittleEndian(io.ktor.utils.p098io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53171
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readIntLittleEndian$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.p098io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.readInt(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.ByteOrder r4 = r4.getReadByteOrder()
            int[] r0 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            if (r4 != r3) goto L53
            goto L61
        L53:
            java.lang.Number r5 = (java.lang.Number) r5
            int r4 = r5.intValue()
            int r4 = java.lang.Integer.reverseBytes(r4)
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
        L61:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readIntLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readIntLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readInt(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? obj : Integer.valueOf(Integer.reverseBytes(((Number) obj).intValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readLongLittleEndian(io.ktor.utils.p098io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Long> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53191
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readLongLittleEndian$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.p098io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.readLong(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.ByteOrder r4 = r4.getReadByteOrder()
            int[] r0 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            if (r4 != r3) goto L53
            goto L61
        L53:
            java.lang.Number r5 = (java.lang.Number) r5
            long r4 = r5.longValue()
            long r4 = java.lang.Long.reverseBytes(r4)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
        L61:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readLongLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readLongLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Long> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readLong(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? obj : Long.valueOf(Long.reverseBytes(((Number) obj).longValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readFloatLittleEndian(io.ktor.utils.p098io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Float> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53151
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readFloatLittleEndian$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.p098io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.readFloat(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.ByteOrder r4 = r4.getReadByteOrder()
            int[] r0 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            if (r4 != r3) goto L53
            goto L69
        L53:
            java.lang.Number r5 = (java.lang.Number) r5
            float r4 = r5.floatValue()
            int r4 = java.lang.Float.floatToRawIntBits(r4)
            int r4 = java.lang.Integer.reverseBytes(r4)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
        L69:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readFloatLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readFloatLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Float> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readFloat(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? obj : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) obj).floatValue()))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readDoubleLittleEndian(io.ktor.utils.p098io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Double> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.p098io.ChannelLittleEndianKt.C53131
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1 r0 = (io.ktor.utils.p098io.ChannelLittleEndianKt.C53131) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1 r0 = new io.ktor.utils.io.ChannelLittleEndianKt$readDoubleLittleEndian$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.p098io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.readDouble(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.ByteOrder r4 = r4.getReadByteOrder()
            int[] r0 = io.ktor.utils.io.ChannelLittleEndianKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r0[r4]
            if (r4 != r3) goto L53
            goto L69
        L53:
            java.lang.Number r5 = (java.lang.Number) r5
            double r4 = r5.doubleValue()
            long r4 = java.lang.Double.doubleToRawLongBits(r4)
            long r4 = java.lang.Long.reverseBytes(r4)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            java.lang.Double r5 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
        L69:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ChannelLittleEndianKt.readDoubleLittleEndian(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object readDoubleLittleEndian$$forInline(ByteReadChannel byteReadChannel, Continuation<? super Double> continuation) {
        InlineMarker.mark(0);
        Object obj = byteReadChannel.readDouble(continuation);
        InlineMarker.mark(1);
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? obj : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) obj).doubleValue()))));
    }

    public static final <T> T toLittleEndian(ByteReadChannel byteReadChannel, T t, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return WhenMappings.$EnumSwitchMapping$0[byteReadChannel.getReadByteOrder().ordinal()] == 1 ? t : reverseBlock.invoke(t);
    }

    private static final <T> T toLittleEndian(ByteWriteChannel byteWriteChannel, T t, Function1<? super T, ? extends T> function1) {
        return WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] == 1 ? t : function1.invoke(t);
    }

    public static final <T> T reverseIfNeeded(T t, ByteOrder byteOrder, Function1<? super T, ? extends T> reverseBlock) {
        Intrinsics.checkNotNullParameter(byteOrder, "byteOrder");
        Intrinsics.checkNotNullParameter(reverseBlock, "reverseBlock");
        return WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] == 2 ? t : reverseBlock.invoke(t);
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 2) {
            s = Short.reverseBytes(s);
        }
        Object objWriteShort = byteWriteChannel.writeShort(s, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 2) {
            i = Integer.reverseBytes(i);
        }
        Object objWriteInt = byteWriteChannel.writeInt(i, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 2) {
            j = Long.reverseBytes(j);
        }
        Object objWriteLong = byteWriteChannel.writeLong(j, continuation);
        return objWriteLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteLong : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 2) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        Object objWriteFloat = byteWriteChannel.writeFloat(f, continuation);
        return objWriteFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFloat : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteOrder.ordinal()] != 2) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        Object objWriteDouble = byteWriteChannel.writeDouble(d, continuation);
        return objWriteDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDouble : Unit.INSTANCE;
    }

    public static final Object writeShortLittleEndian(ByteWriteChannel byteWriteChannel, short s, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] != 1) {
            s = Short.reverseBytes(s);
        }
        Object objWriteShort = byteWriteChannel.writeShort(s, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeIntLittleEndian(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] != 1) {
            i = Integer.reverseBytes(i);
        }
        Object objWriteInt = byteWriteChannel.writeInt(i, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeLongLittleEndian(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] != 1) {
            j = Long.reverseBytes(j);
        }
        Object objWriteLong = byteWriteChannel.writeLong(j, continuation);
        return objWriteLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteLong : Unit.INSTANCE;
    }

    public static final Object writeFloatLittleEndian(ByteWriteChannel byteWriteChannel, float f, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] != 1) {
            f = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
        }
        Object objWriteFloat = byteWriteChannel.writeFloat(f, continuation);
        return objWriteFloat == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFloat : Unit.INSTANCE;
    }

    public static final Object writeDoubleLittleEndian(ByteWriteChannel byteWriteChannel, double d, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[byteWriteChannel.getWriteByteOrder().ordinal()] != 1) {
            d = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
        }
        Object objWriteDouble = byteWriteChannel.writeDouble(d, continuation);
        return objWriteDouble == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteDouble : Unit.INSTANCE;
    }
}
