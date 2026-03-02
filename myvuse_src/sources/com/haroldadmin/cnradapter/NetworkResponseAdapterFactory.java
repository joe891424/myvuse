package com.haroldadmin.cnradapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: NetworkResponseAdapterFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000e*\u00020\u000fH\u0002¨\u0006\u0010"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/NetworkResponseAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "getBodyTypes", "Lkotlin/Pair;", "Ljava/lang/reflect/ParameterizedType;", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class NetworkResponseAdapterFactory extends CallAdapter.Factory {
    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        if (returnType instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(parameterUpperBound), NetworkResponse.class)) {
                return null;
            }
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException((parameterUpperBound + " must be parameterized. Raw types are not supported").toString());
            }
            Pair<Type, Type> bodyTypes = getBodyTypes((ParameterizedType) parameterUpperBound);
            Type typeComponent1 = bodyTypes.component1();
            Converter errorBodyConverter = retrofit.nextResponseBodyConverter(null, bodyTypes.component2(), annotations);
            Class rawType = CallAdapter.Factory.getRawType(returnType);
            if (Intrinsics.areEqual(rawType, Deferred.class)) {
                Intrinsics.checkExpressionValueIsNotNull(errorBodyConverter, "errorBodyConverter");
                return new DeferredNetworkResponseAdapter(typeComponent1, errorBodyConverter);
            }
            if (!Intrinsics.areEqual(rawType, Call.class)) {
                return null;
            }
            Intrinsics.checkExpressionValueIsNotNull(errorBodyConverter, "errorBodyConverter");
            return new NetworkResponseAdapter(typeComponent1, errorBodyConverter);
        }
        throw new IllegalStateException((returnType + " must be parameterized. Raw types are not supported").toString());
    }

    private final Pair<Type, Type> getBodyTypes(ParameterizedType parameterizedType) {
        return TuplesKt.m5605to(CallAdapter.Factory.getParameterUpperBound(0, parameterizedType), CallAdapter.Factory.getParameterUpperBound(1, parameterizedType));
    }
}
