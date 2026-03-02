package io.ktor.utils.p098io.core.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UTF8.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lio/ktor/utils/io/core/internal/MalformedUTF8InputException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class MalformedUTF8InputException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MalformedUTF8InputException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
