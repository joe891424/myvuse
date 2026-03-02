package io.ktor.utils.p098io;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: LookAheadSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use read { } instead.")
@Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, m5598d2 = {"Lio/ktor/utils/io/LookAheadSuspendSession;", "Lio/ktor/utils/io/LookAheadSession;", "awaitAtLeast", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface LookAheadSuspendSession extends LookAheadSession {
    Object awaitAtLeast(int i, Continuation<? super Boolean> continuation);
}
