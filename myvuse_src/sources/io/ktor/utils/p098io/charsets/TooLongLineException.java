package io.ktor.utils.p098io.charsets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lio/ktor/utils/io/charsets/TooLongLineException;", "Lio/ktor/utils/io/charsets/MalformedInputException;", "message", "", "(Ljava/lang/String;)V", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class TooLongLineException extends MalformedInputException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooLongLineException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
