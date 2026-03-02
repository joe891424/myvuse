package com.yoti.mobile.android.remote.interceptor;

import kotlin.Metadata;

/* JADX INFO: compiled from: TypedInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "", "order", "", "(Ljava/lang/String;II)V", "getOrder", "()I", "URL", "SKIP", "BODY", "HEADER", "SIGNING", "CONST", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public enum InterceptorType {
    URL(1),
    SKIP(2),
    BODY(3),
    HEADER(4),
    SIGNING(5),
    CONST(6);

    private final int order;

    InterceptorType(int i) {
        this.order = i;
    }

    public final int getOrder() {
        return this.order;
    }
}
