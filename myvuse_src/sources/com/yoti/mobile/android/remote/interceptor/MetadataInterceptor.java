package com.yoti.mobile.android.remote.interceptor;

import com.yoti.mobile.android.remote.model.DeviceMetadata;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: MetadataInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/interceptor/MetadataInterceptor;", "Lcom/yoti/mobile/android/remote/interceptor/TypedInterceptor;", "metadataFactory", "Lcom/yoti/mobile/android/remote/model/DeviceMetadata$Factory;", "(Lcom/yoti/mobile/android/remote/model/DeviceMetadata$Factory;)V", "type", "Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "getType", "()Lcom/yoti/mobile/android/remote/interceptor/InterceptorType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MetadataInterceptor implements TypedInterceptor {
    private final DeviceMetadata.Factory metadataFactory;

    @Inject
    public MetadataInterceptor(DeviceMetadata.Factory metadataFactory) {
        Intrinsics.checkNotNullParameter(metadataFactory, "metadataFactory");
        this.metadataFactory = metadataFactory;
    }

    @Override // com.yoti.mobile.android.remote.interceptor.TypedInterceptor
    public InterceptorType getType() {
        return InterceptorType.HEADER;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed((Request) BuildersKt__BuildersKt.runBlocking$default(null, new MetadataInterceptor$intercept$updatedRequest$1(chain, this, null), 1, null));
    }
}
