package com.bat.sdk.remote;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: ResultCallAdapterFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m5598d2 = {"Lcom/bat/sdk/remote/ResultCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "<init>", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class ResultCallAdapterFactory extends CallAdapter.Factory {
    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(returnType), Call.class) || !(returnType instanceof ParameterizedType)) {
            return null;
        }
        final Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
        if ((parameterUpperBound instanceof ParameterizedType) && Intrinsics.areEqual(((ParameterizedType) parameterUpperBound).getRawType(), Result.class)) {
            return new CallAdapter<Object, Call<Result<?>>>() { // from class: com.bat.sdk.remote.ResultCallAdapterFactory.get.1
                @Override // retrofit2.CallAdapter
                public Type responseType() {
                    Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    Intrinsics.checkNotNullExpressionValue(parameterUpperBound2, "access$getParameterUpperBound$s572770538(...)");
                    return parameterUpperBound2;
                }

                @Override // retrofit2.CallAdapter
                public Call<Result<?>> adapt(Call<Object> call) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    return new ResultCall(call);
                }
            };
        }
        return null;
    }
}
