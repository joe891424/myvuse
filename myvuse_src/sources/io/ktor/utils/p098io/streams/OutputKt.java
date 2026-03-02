package io.ktor.utils.p098io.streams;

import io.ktor.utils.p098io.core.Output;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Output.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m5598d2 = {"asOutput", "Lio/ktor/utils/io/core/Output;", "Ljava/io/OutputStream;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class OutputKt {
    public static final Output asOutput(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        return new OutputStreamAdapter(ChunkBuffer.INSTANCE.getPool(), outputStream);
    }
}
