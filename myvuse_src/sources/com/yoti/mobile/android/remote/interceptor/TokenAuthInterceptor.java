package com.yoti.mobile.android.remote.interceptor;

import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import com.yoti.mobile.android.remote.model.TokenAuthenticationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: TokenAuthInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/TokenAuthInterceptor;", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "authenticationData", "Lcom/yoti/mobile/android/remote/model/TokenAuthenticationData;", "(Lcom/yoti/mobile/android/remote/model/TokenAuthenticationData;)V", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TokenAuthInterceptor implements TypedInterceptor {
    private final TokenAuthenticationData authenticationData;

    public TokenAuthInterceptor(TokenAuthenticationData authenticationData) {
        Intrinsics.checkNotNullParameter(authenticationData, "authenticationData");
        this.authenticationData = authenticationData;
    }

    @Override // com.yoti.mobile.android.remote.interceptor.TypedInterceptor
    public InterceptorType getType() {
        return InterceptorType.HEADER;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderAddHeader = chain.request().newBuilder().addHeader(RemoteDefsKt.HEADER_SESSION_TOKEN_KEY, this.authenticationData.getToken());
        return chain.proceed(!(builderAddHeader instanceof Request.Builder) ? builderAddHeader.build() : OkHttp3Instrumentation.build(builderAddHeader));
    }
}
