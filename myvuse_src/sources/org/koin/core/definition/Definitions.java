package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

/* JADX INFO: compiled from: Definitions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jr\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0086\bJk\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00142\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072#\u0010\b\u001a\u001f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\tj\u0006\u0012\u0002\b\u0003`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013Jr\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013H\u0086\bJ^\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\bJ^\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072)\b\b\u0010\b\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u00050\tj\b\u0012\u0004\u0012\u0002H\u0005`\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\b¨\u0006\u0019"}, m5598d2 = {"Lorg/koin/core/definition/Definitions;", "", "()V", "createFactory", "Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "options", "Lorg/koin/core/definition/Options;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "createSingle", "clazz", "saveFactory", "saveSingle", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class Definitions {
    public static final Definitions INSTANCE = new Definitions();

    private Definitions() {
    }

    public static /* synthetic */ BeanDefinition saveSingle$default(Definitions definitions, Qualifier qualifier, Function2 definition, ScopeDefinition scopeDefinition, Options options, int i, Object obj) throws DefinitionOverrideException {
        Qualifier qualifier2;
        if ((i & 1) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, Kind.Single, listEmptyList, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
        ScopeDefinition.save$default(scopeDefinition, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public static /* synthetic */ BeanDefinition createSingle$default(Definitions definitions, Qualifier qualifier, Function2 definition, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        Qualifier qualifier2;
        if ((i & 1) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        List secondaryTypes = (i & 16) != 0 ? CollectionsKt.emptyList() : list;
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, Kind.Single, secondaryTypes, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    public final /* synthetic */ <T> BeanDefinition<T> createSingle(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition<>(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, Kind.Single, secondaryTypes, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeanDefinition createSingle$default(Definitions definitions, KClass kClass, Qualifier qualifier, Function2 function2, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 32) != 0) {
            list = CollectionsKt.emptyList();
        }
        return definitions.createSingle(kClass, qualifier2, function2, scopeDefinition, options, list);
    }

    public final BeanDefinition<?> createSingle(KClass<?> clazz, Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ?> definition, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        return new BeanDefinition<>(scopeDefinition, clazz, qualifier, definition, Kind.Single, secondaryTypes, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    public static /* synthetic */ BeanDefinition createFactory$default(Definitions definitions, Qualifier qualifier, Function2 definition, ScopeDefinition scopeDefinition, Options options, List list, int i, Object obj) {
        Qualifier qualifier2;
        if ((i & 1) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        List secondaryTypes = (i & 16) != 0 ? CollectionsKt.emptyList() : list;
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, Kind.Factory, secondaryTypes, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    public final /* synthetic */ <T> BeanDefinition<T> createFactory(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, ScopeDefinition scopeDefinition, Options options, List<? extends KClass<?>> secondaryTypes) {
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new BeanDefinition<>(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, Kind.Factory, secondaryTypes, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
    }

    public static /* synthetic */ BeanDefinition saveFactory$default(Definitions definitions, Qualifier qualifier, Function2 definition, ScopeDefinition scopeDefinition, Options options, int i, Object obj) throws DefinitionOverrideException {
        Qualifier qualifier2;
        if ((i & 1) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, definition, Kind.Factory, listEmptyList, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
        ScopeDefinition.save$default(scopeDefinition, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> saveSingle(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, ScopeDefinition scopeDefinition, Options options) throws DefinitionOverrideException {
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition<T> beanDefinition = new BeanDefinition<>(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, Kind.Single, listEmptyList, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
        ScopeDefinition.save$default(scopeDefinition, beanDefinition, false, 2, null);
        return beanDefinition;
    }

    public final /* synthetic */ <T> BeanDefinition<T> saveFactory(Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, ScopeDefinition scopeDefinition, Options options) throws DefinitionOverrideException {
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(options, "options");
        List listEmptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition<T> beanDefinition = new BeanDefinition<>(scopeDefinition, Reflection.getOrCreateKotlinClass(Object.class), qualifier, definition, Kind.Factory, listEmptyList, options, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null);
        ScopeDefinition.save$default(scopeDefinition, beanDefinition, false, 2, null);
        return beanDefinition;
    }
}
