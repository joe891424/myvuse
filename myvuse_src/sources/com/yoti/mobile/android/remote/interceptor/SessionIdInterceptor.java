package com.yoti.mobile.android.remote.interceptor;

import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.yoti.mobile.android.remote.model.Session;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: SessionIdInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/SessionIdInterceptor;", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "session", "Lcom/yoti/mobile/android/remote/model/Session;", "(Lcom/yoti/mobile/android/remote/model/Session;)V", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SessionIdInterceptor implements TypedInterceptor {
    private final Session session;

    @Inject
    public SessionIdInterceptor(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.session = session;
    }

    @Override // com.yoti.mobile.android.remote.interceptor.TypedInterceptor
    public InterceptorType getType() {
        return InterceptorType.URL;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl.Builder builderNewBuilder = request.url().newBuilder();
        int i = 0;
        for (Object obj : request.url().pathSegments()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (StringsKt.equals((String) obj, SessionIdInterceptorKt.TEMPLATE_SESSION_ID, true)) {
                builderNewBuilder.setPathSegment(i, this.session.getId());
            }
            i = i2;
        }
        Request.Builder builderUrl = request.newBuilder().url(builderNewBuilder.build());
        return chain.proceed(!(builderUrl instanceof Request.Builder) ? builderUrl.build() : OkHttp3Instrumentation.build(builderUrl));
    }
}
