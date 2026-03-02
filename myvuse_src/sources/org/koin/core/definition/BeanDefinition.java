package org.koin.core.definition;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: BeanDefinition.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u008e\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012'\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0002\u0010\u0019J\u001e\u0010,\u001a\u00020-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010/\u001a\u0006\u0012\u0002\b\u00030\u0006J\t\u00100\u001a\u00020\u0004HÆ\u0003J\r\u00101\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J*\u00103\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\u0013\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018HÆ\u0003J \u0001\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2)\b\u0002\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0012\b\u0002\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018HÆ\u0001J\u0013\u0010:\u001a\u00020-2\b\u0010;\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0012\u0010<\u001a\u00020-2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u0006J\b\u0010>\u001a\u00020?H\u0016J$\u0010@\u001a\u00020-2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010A\u001a\u00020BH\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR2\u0010\t\u001a#\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\nj\b\u0012\u0004\u0012\u00028\u0000`\r¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006C"}, m5598d2 = {"Lorg/koin/core/definition/BeanDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "", "scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "primaryType", "Lkotlin/reflect/KClass;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "kind", "Lorg/koin/core/definition/Kind;", "secondaryTypes", "", "options", "Lorg/koin/core/definition/Options;", "properties", "Lorg/koin/core/definition/Properties;", "callbacks", "Lorg/koin/core/definition/Callbacks;", "(Lorg/koin/core/scope/ScopeDefinition;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function2;Lorg/koin/core/definition/Kind;Ljava/util/List;Lorg/koin/core/definition/Options;Lorg/koin/core/definition/Properties;Lorg/koin/core/definition/Callbacks;)V", "getCallbacks", "()Lorg/koin/core/definition/Callbacks;", "getDefinition", "()Lkotlin/jvm/functions/Function2;", "getKind", "()Lorg/koin/core/definition/Kind;", "getOptions", "()Lorg/koin/core/definition/Options;", "getPrimaryType", "()Lkotlin/reflect/KClass;", "getProperties", "()Lorg/koin/core/definition/Properties;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getScopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "getSecondaryTypes", "()Ljava/util/List;", "canBind", "", "primary", "secondary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hasType", "clazz", "hashCode", "", "is", "toString", "", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final /* data */ class BeanDefinition<T> {
    private final Callbacks<T> callbacks;
    private final Function2<Scope, DefinitionParameters, T> definition;
    private final Kind kind;
    private final Options options;
    private final KClass<?> primaryType;
    private final Properties properties;
    private final Qualifier qualifier;
    private final ScopeDefinition scopeDefinition;
    private final List<KClass<?>> secondaryTypes;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ScopeDefinition getScopeDefinition() {
        return this.scopeDefinition;
    }

    public final KClass<?> component2() {
        return this.primaryType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    public final Function2<Scope, DefinitionParameters, T> component4() {
        return this.definition;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Kind getKind() {
        return this.kind;
    }

    public final List<KClass<?>> component6() {
        return this.secondaryTypes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Options getOptions() {
        return this.options;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Properties getProperties() {
        return this.properties;
    }

    public final Callbacks<T> component9() {
        return this.callbacks;
    }

    public final BeanDefinition<T> copy(ScopeDefinition scopeDefinition, KClass<?> primaryType, Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, Kind kind, List<? extends KClass<?>> secondaryTypes, Options options, Properties properties, Callbacks<T> callbacks) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(primaryType, "primaryType");
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(kind, "kind");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        Intrinsics.checkParameterIsNotNull(callbacks, "callbacks");
        return new BeanDefinition<>(scopeDefinition, primaryType, qualifier, definition, kind, secondaryTypes, options, properties, callbacks);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeanDefinition(ScopeDefinition scopeDefinition, KClass<?> primaryType, Qualifier qualifier, Function2<? super Scope, ? super DefinitionParameters, ? extends T> definition, Kind kind, List<? extends KClass<?>> secondaryTypes, Options options, Properties properties, Callbacks<T> callbacks) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Intrinsics.checkParameterIsNotNull(primaryType, "primaryType");
        Intrinsics.checkParameterIsNotNull(definition, "definition");
        Intrinsics.checkParameterIsNotNull(kind, "kind");
        Intrinsics.checkParameterIsNotNull(secondaryTypes, "secondaryTypes");
        Intrinsics.checkParameterIsNotNull(options, "options");
        Intrinsics.checkParameterIsNotNull(properties, "properties");
        Intrinsics.checkParameterIsNotNull(callbacks, "callbacks");
        this.scopeDefinition = scopeDefinition;
        this.primaryType = primaryType;
        this.qualifier = qualifier;
        this.definition = definition;
        this.kind = kind;
        this.secondaryTypes = secondaryTypes;
        this.options = options;
        this.properties = properties;
        this.callbacks = callbacks;
    }

    public final ScopeDefinition getScopeDefinition() {
        return this.scopeDefinition;
    }

    public final KClass<?> getPrimaryType() {
        return this.primaryType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BeanDefinition(ScopeDefinition scopeDefinition, KClass kClass, Qualifier qualifier, Function2 function2, Kind kind, List list, Options options, Properties properties, Callbacks callbacks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Qualifier qualifier2;
        if ((i & 4) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        this(scopeDefinition, kClass, qualifier2, function2, kind, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? new Options(false, false, 3, null) : options, (i & 128) != 0 ? new Properties(null, 1, null) : properties, (i & 256) != 0 ? new Callbacks(null, 1, null) : callbacks);
    }

    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    public final Function2<Scope, DefinitionParameters, T> getDefinition() {
        return this.definition;
    }

    public final Kind getKind() {
        return this.kind;
    }

    public final List<KClass<?>> getSecondaryTypes() {
        return this.secondaryTypes;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final Properties getProperties() {
        return this.properties;
    }

    public final Callbacks<T> getCallbacks() {
        return this.callbacks;
    }

    public String toString() {
        String str;
        String string = this.kind.toString();
        String str2 = "'" + KClassExtKt.getFullName(this.primaryType) + '\'';
        if (this.qualifier == null || (str = ",qualifier:" + this.qualifier) == null) {
            str = "";
        }
        return "[" + string + ':' + str2 + str + (this.scopeDefinition.getIsRoot() ? "" : ",scope:" + this.scopeDefinition.getQualifier()) + (this.secondaryTypes.isEmpty() ? "" : ",binds:" + CollectionsKt.joinToString$default(this.secondaryTypes, ",", null, null, 0, null, new Function1<KClass<?>, String>() { // from class: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(KClass<?> it2) {
                Intrinsics.checkParameterIsNotNull(it2, "it");
                return KClassExtKt.getFullName(it2);
            }
        }, 30, null)) + ']';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null) {
            BeanDefinition beanDefinition = (BeanDefinition) other;
            return Intrinsics.areEqual(this.primaryType, beanDefinition.primaryType) && Intrinsics.areEqual(this.qualifier, beanDefinition.qualifier) && Intrinsics.areEqual(this.scopeDefinition, beanDefinition.scopeDefinition);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public final boolean hasType(KClass<?> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return Intrinsics.areEqual(this.primaryType, clazz) || this.secondaryTypes.contains(clazz);
    }

    /* JADX INFO: renamed from: is */
    public final boolean m5644is(KClass<?> clazz, Qualifier qualifier, ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        return hasType(clazz) && Intrinsics.areEqual(this.qualifier, qualifier) && Intrinsics.areEqual(this.scopeDefinition, scopeDefinition);
    }

    public final boolean canBind(KClass<?> primary, KClass<?> secondary) {
        Intrinsics.checkParameterIsNotNull(primary, "primary");
        Intrinsics.checkParameterIsNotNull(secondary, "secondary");
        return Intrinsics.areEqual(this.primaryType, primary) && this.secondaryTypes.contains(secondary);
    }

    public int hashCode() {
        Qualifier qualifier = this.qualifier;
        return ((((qualifier != null ? qualifier.hashCode() : 0) * 31) + this.primaryType.hashCode()) * 31) + this.scopeDefinition.hashCode();
    }
}
