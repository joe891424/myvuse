package com.yoti.mobile.android.remote.interceptor;

import kotlin.Metadata;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: TypedInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "Lokhttp3/Interceptor;", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface TypedInterceptor extends Interceptor {
    InterceptorType getType();
}
