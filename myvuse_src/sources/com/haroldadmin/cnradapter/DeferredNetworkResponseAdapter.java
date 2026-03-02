package com.haroldadmin.cnradapter;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/* JADX INFO: compiled from: DeferredNetworkResponseAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00060\u00050\u0004B!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/DeferredNetworkResponseAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/Deferred;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "successBodyType", "Ljava/lang/reflect/Type;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "(Ljava/lang/reflect/Type;Lretrofit2/Converter;)V", "adapt", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "responseType", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class DeferredNetworkResponseAdapter<T, U> implements CallAdapter<T, Deferred<? extends NetworkResponse<? extends T, ? extends U>>> {
    private final Converter<ResponseBody, U> errorConverter;
    private final Type successBodyType;

    public DeferredNetworkResponseAdapter(Type successBodyType, Converter<ResponseBody, U> errorConverter) {
        Intrinsics.checkParameterIsNotNull(successBodyType, "successBodyType");
        Intrinsics.checkParameterIsNotNull(errorConverter, "errorConverter");
        this.successBodyType = successBodyType;
        this.errorConverter = errorConverter;
    }

    @Override // retrofit2.CallAdapter
    /* JADX INFO: renamed from: responseType, reason: from getter */
    public Type getSuccessBodyType() {
        return this.successBodyType;
    }

    @Override // retrofit2.CallAdapter
    public Deferred<NetworkResponse<T, U>> adapt(final Call<T> call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        completableDeferredCompletableDeferred$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.haroldadmin.cnradapter.DeferredNetworkResponseAdapter.adapt.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (completableDeferredCompletableDeferred$default.isCancelled()) {
                    call.cancel();
                }
            }
        });
        call.enqueue(new Callback<T>() { // from class: com.haroldadmin.cnradapter.DeferredNetworkResponseAdapter.adapt.2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable throwable) {
                Intrinsics.checkParameterIsNotNull(call2, "call");
                Intrinsics.checkParameterIsNotNull(throwable, "throwable");
                try {
                    completableDeferredCompletableDeferred$default.complete(ErrorExtractionKt.extractNetworkResponse(throwable, DeferredNetworkResponseAdapter.this.errorConverter));
                } catch (Throwable th) {
                    completableDeferredCompletableDeferred$default.completeExceptionally(th);
                }
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkParameterIsNotNull(call2, "call");
                Intrinsics.checkParameterIsNotNull(response, "response");
                completableDeferredCompletableDeferred$default.complete(ResponseHandler.INSTANCE.handle(response, DeferredNetworkResponseAdapter.this.successBodyType, DeferredNetworkResponseAdapter.this.errorConverter));
            }
        });
        return completableDeferredCompletableDeferred$default;
    }
}
