package com.yoti.mobile.android.remote.interceptor;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypedInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/SigningInterceptorException;", "Ljava/io/IOException;", HexAttribute.HEX_ATTR_CAUSE, "", "(Ljava/lang/Throwable;)V", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SigningInterceptorException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SigningInterceptorException(Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
