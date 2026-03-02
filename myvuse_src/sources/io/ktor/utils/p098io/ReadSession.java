package io.ktor.utils.p098io;

import io.ktor.utils.p098io.core.IoBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ReadSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use read { } instead.")
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, m5598d2 = {"Lio/ktor/utils/io/ReadSession;", "", "availableForRead", "", "getAvailableForRead", "()I", "discard", RsaJsonWebKey.MODULUS_MEMBER_NAME, "request", "Lio/ktor/utils/io/core/IoBuffer;", "atLeast", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface ReadSession {
    int discard(int n);

    int getAvailableForRead();

    IoBuffer request(int atLeast);

    /* JADX INFO: compiled from: ReadSession.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ IoBuffer request$default(ReadSession readSession, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
            }
            if ((i2 & 1) != 0) {
                i = 1;
            }
            return readSession.request(i);
        }
    }
}
