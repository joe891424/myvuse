package com.haroldadmin.cnradapter;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.haroldadmin.cnradapter.NetworkResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: CoroutinesNetworkResponseAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "This class should not be used anymore. Pick DeferredNetworkResponseAdapter or NetworkResponseAdapter based on your needs", replaceWith = @ReplaceWith(expression = "DeferredNetworkResponseAdapter", imports = {"com.haroldadmin.cnradapter.DeferredNetworkResponseAdapter"}))
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00060\u00050\u0004B!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/CoroutinesNetworkResponseAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "U", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/Deferred;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "successBodyType", "Ljava/lang/reflect/Type;", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "(Ljava/lang/reflect/Type;Lretrofit2/Converter;)V", "adapt", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "responseType", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class CoroutinesNetworkResponseAdapter<T, U> implements CallAdapter<T, Deferred<? extends NetworkResponse<? extends T, ? extends U>>> {
    private final Converter<ResponseBody, U> errorConverter;
    private final Type successBodyType;

    public CoroutinesNetworkResponseAdapter(Type successBodyType, Converter<ResponseBody, U> errorConverter) {
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
        completableDeferredCompletableDeferred$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.haroldadmin.cnradapter.CoroutinesNetworkResponseAdapter.adapt.1
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
        call.enqueue(new Callback<T>() { // from class: com.haroldadmin.cnradapter.CoroutinesNetworkResponseAdapter.adapt.2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable throwable) {
                Intrinsics.checkParameterIsNotNull(call2, "call");
                Intrinsics.checkParameterIsNotNull(throwable, "throwable");
                if (throwable instanceof IOException) {
                    completableDeferredCompletableDeferred$default.complete(new NetworkResponse.NetworkError((IOException) throwable));
                    return;
                }
                if (throwable instanceof HttpException) {
                    HttpException httpException = (HttpException) throwable;
                    Response<?> response = httpException.response();
                    Object objConvert = null;
                    ResponseBody responseBodyErrorBody = response != null ? response.errorBody() : null;
                    Response<?> response2 = httpException.response();
                    int iCode = response2 != null ? response2.code() : ErrorExtractionKt.UNKNOWN_ERROR_RESPONSE_CODE;
                    Response<?> response3 = httpException.response();
                    Headers headers = response3 != null ? response3.headers() : null;
                    if (responseBodyErrorBody != null && responseBodyErrorBody.getContentLength() != 0) {
                        try {
                            objConvert = CoroutinesNetworkResponseAdapter.this.errorConverter.convert(responseBodyErrorBody);
                        } catch (Exception unused) {
                            completableDeferredCompletableDeferred$default.complete(new NetworkResponse.ServerError(null, iCode, headers));
                            return;
                        }
                    }
                    completableDeferredCompletableDeferred$default.complete(new NetworkResponse.ServerError(objConvert, iCode, headers));
                    return;
                }
                completableDeferredCompletableDeferred$default.completeExceptionally(throwable);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                Intrinsics.checkParameterIsNotNull(call2, "call");
                Intrinsics.checkParameterIsNotNull(response, "response");
                Headers headers = response.headers();
                int iCode = response.code();
                T tBody = response.body();
                if (tBody != null) {
                    completableDeferredCompletableDeferred$default.complete(new NetworkResponse.Success(tBody, headers, iCode));
                } else {
                    completableDeferredCompletableDeferred$default.complete(new NetworkResponse.ServerError(null, iCode, headers));
                }
            }
        });
        return completableDeferredCompletableDeferred$default;
    }
}
