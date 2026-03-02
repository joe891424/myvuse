package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: KoinComponent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00032\u0016\b\n\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001a>\u0010\t\u001a\u0002H\n\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\n\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0086\b¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\n0\u000f\"\u0006\b\u0000\u0010\n\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\n\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0086\b¨\u0006\u0010"}, m5598d2 = {"bind", ExifInterface.LATITUDE_SOUTH, "P", "Lorg/koin/core/KoinComponent;", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lorg/koin/core/KoinComponent;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "(Lorg/koin/core/KoinComponent;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "inject", "Lkotlin/Lazy;", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class KoinComponentKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(KoinComponent get, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Scope rootScope = get.getKoin().get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), qualifier, (Function0<DefinitionParameters>) function0);
    }

    public static final /* synthetic */ <T> T get(KoinComponent get, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Scope rootScope = get.getKoin().get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public static /* synthetic */ Lazy inject$default(KoinComponent inject, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkParameterIsNotNull(inject, "$this$inject");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new C59161(inject, qualifier, function0));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.KoinComponentKt$inject$1 */
    /* JADX INFO: compiled from: KoinComponent.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m5598d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 1, 16})
    public static final class C59161<T> extends Lambda implements Function0<T> {
        final /* synthetic */ Function0 $parameters;
        final /* synthetic */ Qualifier $qualifier;
        final /* synthetic */ KoinComponent $this_inject;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59161(KoinComponent koinComponent, Qualifier qualifier, Function0 function0) {
            super(0);
            this.$this_inject = koinComponent;
            this.$qualifier = qualifier;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            Koin koin = this.$this_inject.getKoin();
            Qualifier qualifier = this.$qualifier;
            Function0<DefinitionParameters> function0 = this.$parameters;
            Scope rootScope = koin.get_scopeRegistry().getRootScope();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
        }
    }

    public static final /* synthetic */ <T> Lazy<T> inject(KoinComponent inject, Qualifier qualifier, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(inject, "$this$inject");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new C59161(inject, qualifier, function0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(KoinComponent bind, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.checkParameterIsNotNull(bind, "$this$bind");
        Scope rootScope = bind.getKoin().get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public static final /* synthetic */ <S, P> S bind(KoinComponent bind, Function0<DefinitionParameters> function0) {
        Intrinsics.checkParameterIsNotNull(bind, "$this$bind");
        Scope rootScope = bind.getKoin().get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return (S) rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }
}
