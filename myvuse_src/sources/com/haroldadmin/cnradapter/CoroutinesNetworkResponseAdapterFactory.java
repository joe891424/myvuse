package com.haroldadmin.cnradapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: CoroutinesNetworkResponseAdapterFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "This class should not be used anymore. Replace with NetworkResponseAdapterFactory", replaceWith = @ReplaceWith(expression = "NetworkResponseAdapterFactory", imports = {"com.haroldadmin.cnradapter.NetworkResponseAdapterFactory"}))
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\f¨\u0006\u000e"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/CoroutinesNetworkResponseAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "Companion", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class CoroutinesNetworkResponseAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final CoroutinesNetworkResponseAdapterFactory create() {
        return INSTANCE.create();
    }

    private CoroutinesNetworkResponseAdapterFactory() {
    }

    /* JADX INFO: compiled from: CoroutinesNetworkResponseAdapterFactory.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\b\u0005¨\u0006\u0006"}, m5598d2 = {"Lcom/haroldadmin/cnradapter/CoroutinesNetworkResponseAdapterFactory$Companion;", "", "()V", "invoke", "Lcom/haroldadmin/cnradapter/CoroutinesNetworkResponseAdapterFactory;", "create", "coroutines-network-response-adapter"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CoroutinesNetworkResponseAdapterFactory create() {
            throw new UnsupportedOperationException("Use NetworkResponseAdapterFactory instead of this class");
        }
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(returnType, "returnType");
        Intrinsics.checkParameterIsNotNull(annotations, "annotations");
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        if (!Intrinsics.areEqual(Deferred.class, CallAdapter.Factory.getRawType(returnType))) {
            return null;
        }
        if (returnType instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(parameterUpperBound), NetworkResponse.class)) {
                return null;
            }
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("NetworkResponse must be parameterized as NetworkResponse<SuccessBody, ErrorBody>".toString());
            }
            ParameterizedType parameterizedType = (ParameterizedType) parameterUpperBound;
            Type successBodyType = CallAdapter.Factory.getParameterUpperBound(0, parameterizedType);
            Converter errorBodyConverter = retrofit.nextResponseBodyConverter(null, CallAdapter.Factory.getParameterUpperBound(1, parameterizedType), annotations);
            Intrinsics.checkExpressionValueIsNotNull(successBodyType, "successBodyType");
            Intrinsics.checkExpressionValueIsNotNull(errorBodyConverter, "errorBodyConverter");
            return new CoroutinesNetworkResponseAdapter(successBodyType, errorBodyConverter);
        }
        throw new IllegalStateException("Deferred return must be parameterized as Deferred<Foo> or Deferred<out Foo>".toString());
    }
}
