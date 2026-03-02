package io.ktor.utils.p098io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ByteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0007\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, m5598d2 = {"ByteChannel", "Lio/ktor/utils/io/ByteChannel;", "autoFlush", "", "exceptionMapper", "Lkotlin/Function1;", "", "ByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "content", "Ljava/nio/ByteBuffer;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteChannelKt {
    public static final ByteReadChannel ByteReadChannel(ByteBuffer content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new ByteBufferChannel(content);
    }

    public static final ByteChannel ByteChannel(boolean z) {
        return new ByteBufferChannel(z, null, 0, 6, null);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(content, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(byteBufferWrap);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z, function1);
    }

    @ExperimentalIoApi
    public static final ByteChannel ByteChannel(boolean z, Function1<? super Throwable, ? extends Throwable> exceptionMapper) {
        Intrinsics.checkNotNullParameter(exceptionMapper, "exceptionMapper");
        return new ByteBufferChannel(exceptionMapper, z) { // from class: io.ktor.utils.io.ByteChannelKt.ByteChannel.1
            final /* synthetic */ boolean $autoFlush;
            final /* synthetic */ Function1<Throwable, Throwable> $exceptionMapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(z, null, 0, 6, null);
                this.$autoFlush = z;
            }

            @Override // io.ktor.utils.p098io.ByteBufferChannel, io.ktor.utils.p098io.ByteWriteChannel
            public boolean close(Throwable cause) {
                return super.close(this.$exceptionMapper.invoke(cause));
            }
        };
    }
}
