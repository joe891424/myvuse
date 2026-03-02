package com.salesforce.marketingcloud.sfmcsdk.components.http;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5598d2 = {"UTF_8", "Ljava/nio/charset/Charset;", "getUTF_8", "()Ljava/nio/charset/Charset;", "sfmcsdk_release"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class RequestKt {
    private static final Charset UTF_8;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "<clinit>");
        UTF_8 = charsetForName;
    }

    public static final Charset getUTF_8() {
        return UTF_8;
    }
}
