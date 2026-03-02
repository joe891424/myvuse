package io.ktor.utils.p098io.internal;

import io.ktor.utils.p098io.LookAheadSuspendSession;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteBufferChannelInternals.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m5598d2 = {"Lio/ktor/utils/io/internal/TerminatedLookAhead;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "()V", "awaitAtLeast", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", "request", "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class TerminatedLookAhead implements LookAheadSuspendSession {
    public static final TerminatedLookAhead INSTANCE = new TerminatedLookAhead();

    @Override // io.ktor.utils.p098io.LookAheadSession
    public ByteBuffer request(int skip, int atLeast) {
        return null;
    }

    private TerminatedLookAhead() {
    }

    @Override // io.ktor.utils.p098io.LookAheadSession
    /* JADX INFO: renamed from: consumed */
    public void mo7224consumed(int n) {
        if (n > 0) {
            throw new IllegalStateException("Unable to mark " + n + " bytes consumed for already terminated channel");
        }
    }

    @Override // io.ktor.utils.p098io.LookAheadSuspendSession
    public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be negative: ", Boxing.boxInt(i)).toString());
        }
        if (!(i <= 4088)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("atLeast parameter shouldn't be larger than max buffer size of 4088: ", Boxing.boxInt(i)).toString());
        }
        return Boxing.boxBoolean(false);
    }
}
