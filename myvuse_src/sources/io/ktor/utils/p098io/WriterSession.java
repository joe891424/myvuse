package io.ktor.utils.p098io;

import io.ktor.utils.p098io.core.IoBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: WriterSession.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "Use writeMemory instead.")
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, m5598d2 = {"Lio/ktor/utils/io/WriterSession;", "", "flush", "", "request", "Lio/ktor/utils/io/core/IoBuffer;", "min", "", "written", RsaJsonWebKey.MODULUS_MEMBER_NAME, "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public interface WriterSession {
    void flush();

    IoBuffer request(int min);

    void written(int n);
}
