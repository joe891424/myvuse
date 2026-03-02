package io.ktor.utils.p098io;

import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: LookAheadSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use read { } instead.")
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, m5598d2 = {"Lio/ktor/utils/io/LookAheadSession;", "", "consumed", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "request", "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface LookAheadSession {
    /* JADX INFO: renamed from: consumed */
    void mo7224consumed(int n);

    ByteBuffer request(int skip, int atLeast);
}
