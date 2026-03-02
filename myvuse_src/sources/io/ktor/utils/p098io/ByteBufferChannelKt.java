package io.ktor.utils.p098io;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, m5598d2 = {"BYTE_BUFFER_CAPACITY", "", "DEFAULT_CLOSE_MESSAGE", "", "rethrowClosed", "", HexAttribute.HEX_ATTR_CAUSE, "", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteBufferChannelKt {
    private static final int BYTE_BUFFER_CAPACITY = 4088;
    public static final String DEFAULT_CLOSE_MESSAGE = "Byte channel was closed";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void rethrowClosed(Throwable th) throws Throwable {
        Throwable thTryCopyException = ExceptionUtilsJvmKt.tryCopyException(th, th);
        if (thTryCopyException == null) {
            throw th;
        }
        throw thTryCopyException;
    }
}
