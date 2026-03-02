package com.yoti.mobile.android.remote.interceptor;

import com.yoti.mobile.android.remote.ApiServiceFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: TypedLoggingInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/TypedLoggingInterceptor;", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "apiServiceFactory", "Lcom/yoti/mobile/android/remote/ApiServiceFactory;", "(Lcom/yoti/mobile/android/remote/ApiServiceFactory;)V", "wrappedLoggingInterceptor", "Lokhttp3/Interceptor;", "(Lokhttp3/Interceptor;)V", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TypedLoggingInterceptor implements TypedInterceptor {
    private final Interceptor wrappedLoggingInterceptor;

    public TypedLoggingInterceptor(Interceptor wrappedLoggingInterceptor) {
        Intrinsics.checkNotNullParameter(wrappedLoggingInterceptor, "wrappedLoggingInterceptor");
        this.wrappedLoggingInterceptor = wrappedLoggingInterceptor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Inject
    public TypedLoggingInterceptor(ApiServiceFactory apiServiceFactory) {
        this(apiServiceFactory.makeLoggingInterceptor());
        Intrinsics.checkNotNullParameter(apiServiceFactory, "apiServiceFactory");
    }

    @Override // com.yoti.mobile.android.remote.interceptor.TypedInterceptor
    public InterceptorType getType() {
        return InterceptorType.CONST;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return this.wrappedLoggingInterceptor.intercept(chain);
    }
}
