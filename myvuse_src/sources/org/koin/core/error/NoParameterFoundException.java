package org.koin.core.error;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoParameterFoundException.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lorg/koin/core/error/NoParameterFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "", "(Ljava/lang/String;)V", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class NoParameterFoundException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoParameterFoundException(String msg) {
        super(msg);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
    }
}
