package com.yoti.mobile.android.remote.interceptor;

import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import com.yoti.mobile.android.remote.model.DeviceMetadata;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;

/* JADX INFO: compiled from: MetadataInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Lokhttp3/Request;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.remote.interceptor.MetadataInterceptor$intercept$updatedRequest$1", m5608f = "MetadataInterceptor.kt", m5609i = {}, m5610l = {22}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class MetadataInterceptor$intercept$updatedRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Request>, Object> {
    final /* synthetic */ Interceptor.Chain $chain;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MetadataInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MetadataInterceptor$intercept$updatedRequest$1(Interceptor.Chain chain, MetadataInterceptor metadataInterceptor, Continuation<? super MetadataInterceptor$intercept$updatedRequest$1> continuation) {
        super(2, continuation);
        this.$chain = chain;
        this.this$0 = metadataInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MetadataInterceptor$intercept$updatedRequest$1(this.$chain, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Request> continuation) {
        return ((MetadataInterceptor$intercept$updatedRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Request.Builder builderNewBuilder;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            builderNewBuilder = this.$chain.request().newBuilder();
            this.L$0 = builderNewBuilder;
            this.L$1 = RemoteDefsKt.HEADER_DEVICE_METADATA_KEY;
            this.label = 1;
            obj = this.this$0.metadataFactory.create(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = RemoteDefsKt.HEADER_DEVICE_METADATA_KEY;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.L$1;
            builderNewBuilder = (Request.Builder) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Request.Builder builderAddHeader = builderNewBuilder.addHeader(str, ((DeviceMetadata) obj).toBase64());
        return !(builderAddHeader instanceof Request.Builder) ? builderAddHeader.build() : OkHttp3Instrumentation.build(builderAddHeader);
    }
}
