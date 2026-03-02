package io.ktor.utils.p098io;

import io.ktor.utils.p098io.ByteReadChannel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ByteChannelCtor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m5598d2 = {"Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "attachJob", "", "job", "Lkotlinx/coroutines/Job;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface ByteChannel extends ByteReadChannel, ByteWriteChannel {
    void attachJob(Job job);

    /* JADX INFO: compiled from: ByteChannelCtor.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility.")
        public static /* synthetic */ Object consumeEachBufferRange(ByteChannel byteChannel, Function2 function2, Continuation continuation) throws Throwable {
            Object objConsumeEachBufferRange = ByteReadChannel.DefaultImpls.consumeEachBufferRange(byteChannel, function2, continuation);
            return objConsumeEachBufferRange == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objConsumeEachBufferRange : Unit.INSTANCE;
        }
    }
}
