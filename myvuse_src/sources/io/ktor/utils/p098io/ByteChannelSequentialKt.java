package io.ktor.utils.p098io;

import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.internal.SequentialCopyToKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: ByteChannelSequential.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a'\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"EXPECTED_CAPACITY", "", "copyTo", "Lio/ktor/utils/io/ByteChannelSequentialBase;", C4352k.a.f5652f, "limit", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinTo", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteChannelSequentialKt {
    private static final long EXPECTED_CAPACITY = 4088;

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is going to become internal. Use ByteReadChannel receiver instead.")
    public static final Object joinTo(ByteChannelSequentialBase byteChannelSequentialBase, ByteChannelSequentialBase byteChannelSequentialBase2, boolean z, Continuation<? super Unit> continuation) {
        Object objJoinToImpl = SequentialCopyToKt.joinToImpl(byteChannelSequentialBase, byteChannelSequentialBase2, z, continuation);
        return objJoinToImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinToImpl : Unit.INSTANCE;
    }

    public static /* synthetic */ Object copyTo$default(ByteChannelSequentialBase byteChannelSequentialBase, ByteChannelSequentialBase byteChannelSequentialBase2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteChannelSequentialBase, byteChannelSequentialBase2, j, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This is going to become internal. Use ByteReadChannel receiver instead.")
    public static final Object copyTo(ByteChannelSequentialBase byteChannelSequentialBase, ByteChannelSequentialBase byteChannelSequentialBase2, long j, Continuation<? super Long> continuation) {
        return SequentialCopyToKt.copyToSequentialImpl(byteChannelSequentialBase, byteChannelSequentialBase2, j, continuation);
    }
}
