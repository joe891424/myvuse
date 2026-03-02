package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Options;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.error.ScopeNotCreatedException;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;
import org.koin.core.scope.ScopeDefinition$saveNewDefinition$beanDefinition$1;
import org.koin.ext.InstanceScopeExtKt;

/* JADX INFO: compiled from: Koin.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JA\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010 J6\u0010\u0017\u001a\u0002H\u0018\"\u0006\b\u0000\u0010\u0018\u0018\u0001\"\u0006\b\u0001\u0010!\u0018\u00012\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\u0086\b¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020$J\r\u0010%\u001a\u00020$H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020$H\u0000¢\u0006\u0002\b(J\u0006\u0010)\u001a\u00020$J\u0011\u0010*\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u0001H\u0086\bJ)\u0010*\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u00012\n\u0010-\u001a\u00060.j\u0002`/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001H\u0086\bJ&\u0010*\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/2\u0006\u00101\u001a\u0002022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0001JL\u00103\u001a\u00020$\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u00012\u0006\u00104\u001a\u0002H,2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0012\b\u0002\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a062\b\b\u0002\u00107\u001a\u000208H\u0086\b¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020.J\u0012\u0010<\u001a\u00020$2\n\u0010-\u001a\u00060.j\u0002`/JA\u0010=\u001a\u0002H,\"\u0004\b\u0000\u0010,2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010?J:\u0010=\u001a\u0002H,\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\u0087\b¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\b\u0012\u0004\u0012\u0002H,06\"\n\b\u0000\u0010,\u0018\u0001*\u00020\u0001H\u0086\bJ\u001d\u0010B\u001a\u00020+\"\u0006\b\u0000\u0010,\u0018\u00012\n\u0010-\u001a\u00060.j\u0002`/H\u0086\bJ\u001a\u0010B\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/2\u0006\u00101\u001a\u000202JC\u0010C\u001a\u0004\u0018\u0001H,\"\u0004\b\u0000\u0010,2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030\u001a2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001f¢\u0006\u0002\u0010?J<\u0010C\u001a\u0004\u0018\u0001H,\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\u0087\b¢\u0006\u0002\u0010@J\u0010\u0010D\u001a\u0004\u0018\u00010.2\u0006\u0010;\u001a\u00020.J\u0016\u0010D\u001a\u00020.2\u0006\u0010;\u001a\u00020.2\u0006\u0010E\u001a\u00020.J\u0012\u0010F\u001a\u00020+2\n\u0010-\u001a\u00060.j\u0002`/J\u0014\u0010G\u001a\u0004\u0018\u00010+2\n\u0010-\u001a\u00060.j\u0002`/J;\u0010H\u001a\b\u0012\u0004\u0012\u0002H,0I\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\u0087\bJ=\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H,0I\"\u0006\b\u0000\u0010,\u0018\u00012\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0004\u0018\u0001`\u001fH\u0087\bJ\u0014\u0010K\u001a\u00020$2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000b06J\u0016\u0010M\u001a\u00020$2\u0006\u0010;\u001a\u00020.2\u0006\u0010N\u001a\u00020.J\u0014\u0010O\u001a\u0002082\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000b06R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006P"}, m5598d2 = {"Lorg/koin/core/Koin;", "", "()V", "_logger", "Lorg/koin/core/logger/Logger;", "get_logger", "()Lorg/koin/core/logger/Logger;", "set_logger", "(Lorg/koin/core/logger/Logger;)V", "_modules", "Ljava/util/HashSet;", "Lorg/koin/core/module/Module;", "Lkotlin/collections/HashSet;", "get_modules", "()Ljava/util/HashSet;", "_propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "get_propertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "_scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "get_scopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "bind", ExifInterface.LATITUDE_SOUTH, "primaryType", "Lkotlin/reflect/KClass;", "secondaryType", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "P", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createContextIfNeeded", "createContextIfNeeded$koin_core", "createEagerInstances", "createEagerInstances$koin_core", "createRootScope", "createScope", "Lorg/koin/core/scope/Scope;", ExifInterface.GPS_DIRECTION_TRUE, "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "override", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", "key", "deleteScope", "get", "clazz", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "defaultValue", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "injectOrNull", "loadModules", "modules", "setProperty", "value", "unloadModules", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class Koin {
    private final ScopeRegistry _scopeRegistry = new ScopeRegistry(this);
    private final PropertyRegistry _propertyRegistry = new PropertyRegistry(this);
    private Logger _logger = new EmptyLogger();
    private final HashSet<Module> _modules = new HashSet<>();

    public final /* synthetic */ <T> T get() {
        return (T) get$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier) {
        return (T) get$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> T getOrNull() {
        return (T) getOrNull$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier) {
        return (T) getOrNull$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> Lazy<T> inject() {
        return inject$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier) {
        return inject$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull() {
        return injectOrNull$default(this, null, null, 3, null);
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier) {
        return injectOrNull$default(this, qualifier, null, 2, null);
    }

    public final ScopeRegistry get_scopeRegistry() {
        return this._scopeRegistry;
    }

    public final PropertyRegistry get_propertyRegistry() {
        return this._propertyRegistry;
    }

    public final Logger get_logger() {
        return this._logger;
    }

    public final void set_logger(Logger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "<set-?>");
        this._logger = logger;
    }

    public final HashSet<Module> get_modules() {
        return this._modules;
    }

    public static /* synthetic */ Lazy inject$default(Koin koin, final Qualifier qualifier, final Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        final Scope rootScope = koin.get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Function0<T>() { // from class: org.koin.core.Koin$inject$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Scope scope = rootScope;
                Qualifier qualifier2 = qualifier;
                Function0<DefinitionParameters> function02 = function0;
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function02);
            }
        });
    }

    public final /* synthetic */ <T> Lazy<T> inject(final Qualifier qualifier, final Function0<DefinitionParameters> parameters) {
        final Scope rootScope = get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<T>() { // from class: org.koin.core.Koin$inject$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Scope scope = rootScope;
                Qualifier qualifier2 = qualifier;
                Function0<DefinitionParameters> function0 = parameters;
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function0);
            }
        });
    }

    public static /* synthetic */ Lazy injectOrNull$default(Koin koin, final Qualifier qualifier, final Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        final Scope rootScope = koin.get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, new Function0<T>() { // from class: org.koin.core.Koin$injectOrNull$$inlined$injectOrNull$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Scope scope = rootScope;
                Qualifier qualifier2 = qualifier;
                Function0<DefinitionParameters> function02 = function0;
                Intrinsics.reifiedOperationMarker(4, "T?");
                return (T) scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function02);
            }
        });
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(final Qualifier qualifier, final Function0<DefinitionParameters> parameters) {
        final Scope rootScope = get_scopeRegistry().getRootScope();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<T>() { // from class: org.koin.core.Koin$injectOrNull$$inlined$injectOrNull$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Scope scope = rootScope;
                Qualifier qualifier2 = qualifier;
                Function0<DefinitionParameters> function0 = parameters;
                Intrinsics.reifiedOperationMarker(4, "T?");
                return (T) scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier2, function0);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), qualifier, (Function0<DefinitionParameters>) function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return (T) rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> clazz, Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return (T) this._scopeRegistry.getRootScope().get(clazz, qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return (T) this._scopeRegistry.getRootScope().getOrNull(clazz, qualifier, parameters);
    }

    public static /* synthetic */ void declare$default(Koin koin, Object instance, Qualifier qualifier, List secondaryTypes, boolean z, int i, Object obj) {
        Qualifier qualifier2;
        Object obj2 = null;
        if ((i & 2) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        if ((i & 4) != 0) {
            secondaryTypes = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List listListOf = CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Object.class));
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        List<? extends KClass<?>> listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) secondaryTypes);
        synchronized (rootScope) {
            try {
                ScopeDefinition scopeDefinition = rootScope.get_scopeDefinition();
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Iterator<T> it2 = scopeDefinition.getDefinitions().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    if (((BeanDefinition) next).m5644is(orCreateKotlinClass, qualifier2, scopeDefinition)) {
                        obj2 = next;
                        break;
                    }
                }
                BeanDefinition<?> beanDefinition = (BeanDefinition) obj2;
                if (beanDefinition != null) {
                    if (z) {
                        scopeDefinition.remove(beanDefinition);
                    } else {
                        throw new DefinitionOverrideException("Trying to override existing definition '" + beanDefinition + "' with new definition typed '" + orCreateKotlinClass + '\'');
                    }
                }
                BeanDefinition<?> beanDefinitionCreateSingle = Definitions.INSTANCE.createSingle(orCreateKotlinClass, qualifier2, new ScopeDefinition$saveNewDefinition$beanDefinition$1(instance), scopeDefinition, new Options(false, z), listPlus != null ? listPlus : CollectionsKt.emptyList());
                scopeDefinition.save(beanDefinitionCreateSingle, z);
                rootScope.get_instanceRegistry().saveDefinition(beanDefinitionCreateSingle, true);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean override) {
        T next;
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List listListOf = CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Object.class));
        Scope rootScope = get_scopeRegistry().getRootScope();
        List<? extends KClass<?>> listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) secondaryTypes);
        synchronized (rootScope) {
            try {
                ScopeDefinition scopeDefinition = rootScope.get_scopeDefinition();
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                Iterator<T> it2 = scopeDefinition.getDefinitions().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = (T) null;
                        break;
                    } else {
                        next = it2.next();
                        if (((BeanDefinition) next).m5644is(orCreateKotlinClass, qualifier, scopeDefinition)) {
                            break;
                        }
                    }
                }
                BeanDefinition<?> beanDefinition = next;
                if (beanDefinition != null) {
                    if (override) {
                        scopeDefinition.remove(beanDefinition);
                    } else {
                        throw new DefinitionOverrideException("Trying to override existing definition '" + beanDefinition + "' with new definition typed '" + orCreateKotlinClass + '\'');
                    }
                }
                Definitions definitions = Definitions.INSTANCE;
                ScopeDefinition$saveNewDefinition$beanDefinition$1 scopeDefinition$saveNewDefinition$beanDefinition$1 = new ScopeDefinition$saveNewDefinition$beanDefinition$1(instance);
                Options options = new Options(false, override);
                if (listPlus == null) {
                    listPlus = CollectionsKt.emptyList();
                }
                BeanDefinition<?> beanDefinitionCreateSingle = definitions.createSingle(orCreateKotlinClass, qualifier, scopeDefinition$saveNewDefinition$beanDefinition$1, scopeDefinition, options, listPlus);
                scopeDefinition.save(beanDefinitionCreateSingle, override);
                rootScope.get_instanceRegistry().saveDefinition(beanDefinitionCreateSingle, true);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(Koin koin, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public final /* synthetic */ <S, P> S bind(Function0<DefinitionParameters> parameters) {
        Scope rootScope = get_scopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return (S) rootScope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(Koin koin, KClass kClass, KClass kClass2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.bind(kClass, kClass2, function0);
    }

    public final <S> S bind(KClass<?> primaryType, KClass<?> secondaryType, Function0<DefinitionParameters> parameters) {
        Intrinsics.checkParameterIsNotNull(primaryType, "primaryType");
        Intrinsics.checkParameterIsNotNull(secondaryType, "secondaryType");
        return (S) this._scopeRegistry.getRootScope().bind(primaryType, secondaryType, parameters);
    }

    public final void createEagerInstances$koin_core() {
        createContextIfNeeded$koin_core();
        this._scopeRegistry.getRootScope().createEagerInstances$koin_core();
    }

    public final void createContextIfNeeded$koin_core() {
        if (this._scopeRegistry.get_rootScope() == null) {
            this._scopeRegistry.createRootScope$koin_core();
        }
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String scopeId, Qualifier qualifier, Object source) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        if (this._logger.isAt(Level.DEBUG)) {
            this._logger.debug("!- create scope - id:'" + scopeId + "' q:" + qualifier);
        }
        return this._scopeRegistry.createScope(scopeId, qualifier, source);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String scopeId, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        if (koin.get_logger().isAt(Level.DEBUG)) {
            koin.get_logger().debug("!- create scope - id:'" + scopeId + "' q:" + typeQualifier);
        }
        return koin.get_scopeRegistry().createScope(scopeId, typeQualifier, obj);
    }

    public final /* synthetic */ <T> Scope createScope(String scopeId, Object source) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        if (get_logger().isAt(Level.DEBUG)) {
            get_logger().debug("!- create scope - id:'" + scopeId + "' q:" + typeQualifier);
        }
        return get_scopeRegistry().createScope(scopeId, typeQualifier, source);
    }

    public final /* synthetic */ <T> Scope createScope() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        String scopeId = InstanceScopeExtKt.getScopeId(orCreateKotlinClass);
        TypeQualifier typeQualifier = new TypeQualifier(orCreateKotlinClass);
        if (get_logger().isAt(Level.DEBUG)) {
            get_logger().debug("!- create scope - id:'" + scopeId + "' q:" + typeQualifier);
        }
        return get_scopeRegistry().createScope(scopeId, typeQualifier, (Object) null);
    }

    public final Scope getOrCreateScope(String scopeId, Qualifier qualifier) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        Scope scopeOrNull = this._scopeRegistry.getScopeOrNull(scopeId);
        return scopeOrNull != null ? scopeOrNull : createScope$default(this, scopeId, qualifier, null, 4, null);
    }

    public final /* synthetic */ <T> Scope getOrCreateScope(String scopeId) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        Scope scopeOrNull = get_scopeRegistry().getScopeOrNull(scopeId);
        return scopeOrNull != null ? scopeOrNull : createScope$default(this, scopeId, typeQualifier, null, 4, null);
    }

    public final Scope getScope(String scopeId) throws ScopeNotCreatedException {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Scope scopeOrNull = this._scopeRegistry.getScopeOrNull(scopeId);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        throw new ScopeNotCreatedException("No scope found for id '" + scopeId + '\'');
    }

    public final Scope getScopeOrNull(String scopeId) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        return this._scopeRegistry.getScopeOrNull(scopeId);
    }

    public final void deleteScope(String scopeId) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        this._scopeRegistry.deleteScope(scopeId);
    }

    public final String getProperty(String key, String defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        String property = this._propertyRegistry.getProperty(key);
        return property != null ? property : defaultValue;
    }

    public final String getProperty(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this._propertyRegistry.getProperty(key);
    }

    public final void setProperty(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        this._propertyRegistry.saveProperty$koin_core(key, value);
    }

    public final void deleteProperty(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this._propertyRegistry.deleteProperty(key);
    }

    public final void close() {
        synchronized (this) {
            Iterator<T> it2 = this._modules.iterator();
            while (it2.hasNext()) {
                ((Module) it2.next()).setLoaded$koin_core(false);
            }
            this._modules.clear();
            this._scopeRegistry.close$koin_core();
            this._propertyRegistry.close();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void loadModules(List<Module> modules) {
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        synchronized (this) {
            this._modules.addAll(modules);
            this._scopeRegistry.loadModules$koin_core(modules);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean unloadModules(List<Module> modules) {
        boolean zRemoveAll;
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        synchronized (this) {
            this._scopeRegistry.unloadModules(modules);
            zRemoveAll = this._modules.removeAll(modules);
        }
        return zRemoveAll;
    }

    public final void createRootScope() {
        this._scopeRegistry.createRootScope$koin_core();
    }
}
