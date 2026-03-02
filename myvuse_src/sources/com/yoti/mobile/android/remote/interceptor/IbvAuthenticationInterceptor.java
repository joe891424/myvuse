package com.yoti.mobile.android.remote.interceptor;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.yoti.mobile.android.remote.authentication.NetworkRequestMapper;
import com.yoti.mobile.android.remote.authentication.TokenProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: IbvAuthenticationInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/IbvAuthenticationInterceptor;", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "tokenProvider", "Lcom/yoti/mobile/android/remote/authentication/TokenProvider;", "networkRequestMapper", "Lcom/yoti/mobile/android/remote/authentication/NetworkRequestMapper;", "(Lcom/yoti/mobile/android/remote/authentication/TokenProvider;Lcom/yoti/mobile/android/remote/authentication/NetworkRequestMapper;)V", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IbvAuthenticationInterceptor implements TypedInterceptor {
    private final NetworkRequestMapper networkRequestMapper;
    private final TokenProvider tokenProvider;

    public IbvAuthenticationInterceptor(TokenProvider tokenProvider, NetworkRequestMapper networkRequestMapper) {
        Intrinsics.checkNotNullParameter(tokenProvider, "tokenProvider");
        Intrinsics.checkNotNullParameter(networkRequestMapper, "networkRequestMapper");
        this.tokenProvider = tokenProvider;
        this.networkRequestMapper = networkRequestMapper;
    }

    @Override // com.yoti.mobile.android.remote.interceptor.TypedInterceptor
    public InterceptorType getType() {
        return InterceptorType.SIGNING;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws SigningInterceptorException {
        Object objM7233constructorimpl;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7233constructorimpl = Result.m7233constructorimpl(this.tokenProvider.generateToken(this.networkRequestMapper.map(request)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
        if (thM7236exceptionOrNullimpl != null) {
            throw new SigningInterceptorException(thM7236exceptionOrNullimpl);
        }
        Request.Builder builderAddHeader = chain.request().newBuilder().addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + ((String) objM7233constructorimpl));
        return chain.proceed(!(builderAddHeader instanceof Request.Builder) ? builderAddHeader.build() : OkHttp3Instrumentation.build(builderAddHeader));
    }
}
