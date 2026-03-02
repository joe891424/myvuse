package io.ktor.utils.p098io;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ByteWriteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lio/ktor/utils/io/ClosedWriteChannelException;", "Ljava/util/concurrent/CancellationException;", "Lio/ktor/utils/io/CancellationException;", "message", "", "(Ljava/lang/String;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ClosedWriteChannelException extends CancellationException {
    public ClosedWriteChannelException(String str) {
        super(str);
    }
}
