package com.facebook.react.views.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ReactViewManagerWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m5598d2 = {"Lcom/facebook/react/views/view/ReactViewReturnTypeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", RsaJsonWebKey.EXPONENT_MEMBER_NAME, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "ReactAndroid_release"}, m5599k = 1, m5600mv = {1, 8, 0}, m5602xi = 48)
public final class ReactViewReturnTypeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactViewReturnTypeException(String message, Throwable e) {
        super(message, e);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
