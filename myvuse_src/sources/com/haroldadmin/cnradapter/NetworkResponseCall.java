package com.haroldadmin.cnradapter;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

/* JADX INFO: compiled from: NetworkResponseCall.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004H\u0016J\"\u0010\u0010\u001a\u00020\u000e2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0012H\u0016J\u001a\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponseCall;", ExifInterface.LATITUDE_SOUTH, "", ExifInterface.LONGITUDE_EAST, "Lretrofit2/Call;", "Lcom/haroldadmin/cnradapter/NetworkResponse;", "backingCall", "errorConverter", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "successBodyType", "Ljava/lang/reflect/Type;", "(Lretrofit2/Call;Lretrofit2/Converter;Ljava/lang/reflect/Type;)V", "cancel", "", "clone", "enqueue", "callback", "Lretrofit2/Callback;", "execute", "Lretrofit2/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "kotlin.jvm.PlatformType", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class NetworkResponseCall<S, E> implements Call<NetworkResponse<? extends S, ? extends E>> {
    private final Call<S> backingCall;
    private final Converter<ResponseBody, E> errorConverter;
    private final Type successBodyType;

    public NetworkResponseCall(Call<S> backingCall, Converter<ResponseBody, E> errorConverter, Type successBodyType) {
        Intrinsics.checkParameterIsNotNull(backingCall, "backingCall");
        Intrinsics.checkParameterIsNotNull(errorConverter, "errorConverter");
        Intrinsics.checkParameterIsNotNull(successBodyType, "successBodyType");
        this.backingCall = backingCall;
        this.errorConverter = errorConverter;
        this.successBodyType = successBodyType;
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<NetworkResponse<S, E>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        synchronized (this) {
            this.backingCall.enqueue(new Callback<S>() { // from class: com.haroldadmin.cnradapter.NetworkResponseCall$enqueue$$inlined$synchronized$lambda$1
                @Override // retrofit2.Callback
                public void onResponse(Call<S> call, Response<S> response) {
                    Intrinsics.checkParameterIsNotNull(call, "call");
                    Intrinsics.checkParameterIsNotNull(response, "response");
                    callback.onResponse(this.this$0, Response.success(ResponseHandler.INSTANCE.handle(response, this.this$0.successBodyType, this.this$0.errorConverter)));
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<S> call, Throwable throwable) {
                    Intrinsics.checkParameterIsNotNull(call, "call");
                    Intrinsics.checkParameterIsNotNull(throwable, "throwable");
                    callback.onResponse(this.this$0, Response.success(ErrorExtractionKt.extractNetworkResponse(throwable, this.this$0.errorConverter)));
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        boolean zIsExecuted;
        synchronized (this) {
            zIsExecuted = this.backingCall.isExecuted();
        }
        return zIsExecuted;
    }

    @Override // retrofit2.Call
    public Call<NetworkResponse<S, E>> clone() {
        Call<S> callClone = this.backingCall.clone();
        Intrinsics.checkExpressionValueIsNotNull(callClone, "backingCall.clone()");
        return new NetworkResponseCall(callClone, this.errorConverter, this.successBodyType);
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean zIsCanceled;
        synchronized (this) {
            zIsCanceled = this.backingCall.isCanceled();
        }
        return zIsCanceled;
    }

    @Override // retrofit2.Call
    public void cancel() {
        synchronized (this) {
            this.backingCall.cancel();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // retrofit2.Call
    public Response<NetworkResponse<S, E>> execute() {
        throw new UnsupportedOperationException("Network Response call does not support synchronous execution");
    }

    @Override // retrofit2.Call
    public Request request() {
        Request request = this.backingCall.request();
        Intrinsics.checkExpressionValueIsNotNull(request, "backingCall.request()");
        return request;
    }

    @Override // retrofit2.Call
    public Timeout timeout() {
        return this.backingCall.timeout();
    }
}
