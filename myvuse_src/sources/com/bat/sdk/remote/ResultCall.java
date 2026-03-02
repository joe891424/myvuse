package com.bat.sdk.remote;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: ResultCall.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/remote/ResultCall;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/Call;", "Lkotlin/Result;", "delegate", "<init>", "(Lretrofit2/Call;)V", "getDelegate", "()Lretrofit2/Call;", "enqueue", "", "callback", "Lretrofit2/Callback;", "isExecuted", "", "execute", "Lretrofit2/Response;", "cancel", "isCanceled", "clone", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class ResultCall<T> implements Call<Result<? extends T>> {
    private final Call<T> delegate;

    public ResultCall(Call<T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final Call<T> getDelegate() {
        return this.delegate;
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<Result<T>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.enqueue(new Callback<T>() { // from class: com.bat.sdk.remote.ResultCall.enqueue.1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    Callback<Result<T>> callback2 = callback;
                    ResultCall<T> resultCall = this;
                    int iCode = response.code();
                    Result.Companion companion = Result.INSTANCE;
                    T tBody = response.body();
                    Intrinsics.checkNotNull(tBody);
                    callback2.onResponse(resultCall, Response.success(iCode, Result.m7232boximpl(Result.m7233constructorimpl(tBody))));
                    return;
                }
                Callback<Result<T>> callback3 = callback;
                ResultCall<T> resultCall2 = this;
                Result.Companion companion2 = Result.INSTANCE;
                callback3.onResponse(resultCall2, Response.success(Result.m7232boximpl(Result.m7233constructorimpl(ResultKt.createFailure(new HttpException(response))))));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Callback<Result<T>> callback2 = callback;
                ResultCall<T> resultCall = this;
                Result.Companion companion = Result.INSTANCE;
                callback2.onResponse(resultCall, Response.success(Result.m7232boximpl(Result.m7233constructorimpl(ResultKt.createFailure(new RuntimeException(t.getMessage(), t))))));
            }
        });
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        return this.delegate.isExecuted();
    }

    @Override // retrofit2.Call
    public Response<Result<T>> execute() {
        Result.Companion companion = Result.INSTANCE;
        T tBody = this.delegate.execute().body();
        Intrinsics.checkNotNull(tBody);
        Response<Result<T>> responseSuccess = Response.success(Result.m7232boximpl(Result.m7233constructorimpl(tBody)));
        Intrinsics.checkNotNullExpressionValue(responseSuccess, "success(...)");
        return responseSuccess;
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.delegate.cancel();
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    @Override // retrofit2.Call
    public Call<Result<T>> clone() {
        Call<T> callClone = this.delegate.clone();
        Intrinsics.checkNotNullExpressionValue(callClone, "clone(...)");
        return new ResultCall(callClone);
    }

    @Override // retrofit2.Call
    public Request request() {
        Request request = this.delegate.request();
        Intrinsics.checkNotNullExpressionValue(request, "request(...)");
        return request;
    }

    @Override // retrofit2.Call
    public Timeout timeout() {
        Timeout timeout = this.delegate.timeout();
        Intrinsics.checkNotNullExpressionValue(timeout, "timeout(...)");
        return timeout;
    }
}
