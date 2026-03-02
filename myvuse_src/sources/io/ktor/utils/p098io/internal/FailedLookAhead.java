package io.ktor.utils.p098io.internal;

import com.newrelic.agent.android.agentdata.HexAttribute;
import io.ktor.utils.p098io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteBufferChannelInternals.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m5598d2 = {"Lio/ktor/utils/io/internal/FailedLookAhead;", "Lio/ktor/utils/io/LookAheadSuspendSession;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "awaitAtLeast", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", "request", "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class FailedLookAhead implements LookAheadSuspendSession {
    private final Throwable cause;

    public FailedLookAhead(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.cause = cause;
    }

    public final Throwable getCause() {
        return this.cause;
    }

    @Override // io.ktor.utils.p098io.LookAheadSession
    /* JADX INFO: renamed from: consumed, reason: merged with bridge method [inline-methods] */
    public Void mo7224consumed(int n) throws Throwable {
        throw this.cause;
    }

    @Override // io.ktor.utils.p098io.LookAheadSession
    public ByteBuffer request(int skip, int atLeast) throws Throwable {
        throw this.cause;
    }

    @Override // io.ktor.utils.p098io.LookAheadSuspendSession
    public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) throws Throwable {
        throw getCause();
    }
}
