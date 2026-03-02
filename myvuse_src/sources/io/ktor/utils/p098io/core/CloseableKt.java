package io.ktor.utils.p098io.core;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.JsonWebKey;

/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u0004\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, m5598d2 = {JsonWebKey.USE_PARAMETER, "R", "C", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-io"}, m5599k = 2, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class CloseableKt {
    public static final <C extends Closeable, R> R use(C c, Function1<? super C, ? extends R> block) throws IOException {
        Intrinsics.checkNotNullParameter(c, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R rInvoke = block.invoke(c);
            InlineMarker.finallyStart(1);
            c.close();
            InlineMarker.finallyEnd(1);
            return rInvoke;
        } finally {
        }
    }
}
