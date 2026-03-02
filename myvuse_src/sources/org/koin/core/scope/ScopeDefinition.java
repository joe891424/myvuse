package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Options;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.QualifierKt;
import org.koin.core.qualifier.StringQualifier;

/* JADX INFO: compiled from: ScopeDefinition.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b`\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\bJ\u001c\u0010\u001a\u001a\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\b2\b\b\u0002\u0010\u001b\u001a\u00020\u0005JX\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\b\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u0002H\u001d2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020\u0005H\u0086\b¢\u0006\u0002\u0010#J\r\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0002\b%J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0000R&\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, m5598d2 = {"Lorg/koin/core/scope/ScopeDefinition;", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "isRoot", "", "_definitions", "Ljava/util/HashSet;", "Lorg/koin/core/definition/BeanDefinition;", "Lkotlin/collections/HashSet;", "(Lorg/koin/core/qualifier/Qualifier;ZLjava/util/HashSet;)V", "definitions", "", "getDefinitions", "()Ljava/util/Set;", "()Z", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "copy", "equals", "other", "hashCode", "", "remove", "", "beanDefinition", "save", "forceOverride", "saveNewDefinition", ExifInterface.GPS_DIRECTION_TRUE, "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "override", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)Lorg/koin/core/definition/BeanDefinition;", "size", "size$koin_core", "unloadDefinitions", "scopeDefinition", "Companion", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class ScopeDefinition {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ROOT_SCOPE_ID = "-Root-";
    private static final StringQualifier ROOT_SCOPE_QUALIFIER = QualifierKt.m5645_q(ROOT_SCOPE_ID);
    private final HashSet<BeanDefinition<?>> _definitions;
    private final boolean isRoot;
    private final Qualifier qualifier;

    public ScopeDefinition(Qualifier qualifier, boolean z, HashSet<BeanDefinition<?>> _definitions) {
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        Intrinsics.checkParameterIsNotNull(_definitions, "_definitions");
        this.qualifier = qualifier;
        this.isRoot = z;
        this._definitions = _definitions;
    }

    public /* synthetic */ ScopeDefinition(Qualifier qualifier, boolean z, HashSet hashSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(qualifier, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new HashSet() : hashSet);
    }

    public final Qualifier getQualifier() {
        return this.qualifier;
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    public final Set<BeanDefinition<?>> getDefinitions() {
        return this._definitions;
    }

    public static /* synthetic */ void save$default(ScopeDefinition scopeDefinition, BeanDefinition beanDefinition, boolean z, int i, Object obj) throws DefinitionOverrideException {
        if ((i & 2) != 0) {
            z = false;
        }
        scopeDefinition.save(beanDefinition, z);
    }

    public final void save(BeanDefinition<?> beanDefinition, boolean forceOverride) throws DefinitionOverrideException {
        Object next;
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
        if (getDefinitions().contains(beanDefinition)) {
            if (beanDefinition.getOptions().getOverride() || forceOverride) {
                this._definitions.remove(beanDefinition);
            } else {
                Iterator<T> it2 = getDefinitions().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (Intrinsics.areEqual((BeanDefinition) next, beanDefinition)) {
                            break;
                        }
                    }
                }
                throw new DefinitionOverrideException("Definition '" + beanDefinition + "' try to override existing definition. Please use override option or check for definition '" + ((BeanDefinition) next) + '\'');
            }
        }
        this._definitions.add(beanDefinition);
    }

    public final void remove(BeanDefinition<?> beanDefinition) {
        Intrinsics.checkParameterIsNotNull(beanDefinition, "beanDefinition");
        this._definitions.remove(beanDefinition);
    }

    public final int size$koin_core() {
        return getDefinitions().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeanDefinition saveNewDefinition$default(ScopeDefinition scopeDefinition, Object instance, Qualifier qualifier, List list, boolean z, int i, Object obj) throws DefinitionOverrideException {
        Qualifier qualifier2;
        Object obj2 = null;
        if ((i & 2) != 0) {
            qualifier2 = null;
        } else {
            qualifier2 = qualifier;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(instance, "instance");
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
        BeanDefinition<?> beanDefinitionCreateSingle = Definitions.INSTANCE.createSingle(orCreateKotlinClass, qualifier2, new ScopeDefinition$saveNewDefinition$beanDefinition$1(instance), scopeDefinition, new Options(false, z), list != null ? list : CollectionsKt.emptyList());
        scopeDefinition.save(beanDefinitionCreateSingle, z);
        return beanDefinitionCreateSingle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> BeanDefinition<? extends Object> saveNewDefinition(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean override) throws DefinitionOverrideException {
        T next;
        Intrinsics.checkParameterIsNotNull(instance, "instance");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Iterator<T> it2 = getDefinitions().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = (T) null;
                break;
            }
            next = it2.next();
            if (((BeanDefinition) next).m5644is(orCreateKotlinClass, qualifier, this)) {
                break;
            }
        }
        BeanDefinition beanDefinition = next;
        if (beanDefinition != null) {
            if (override) {
                remove(beanDefinition);
            } else {
                throw new DefinitionOverrideException("Trying to override existing definition '" + beanDefinition + "' with new definition typed '" + orCreateKotlinClass + '\'');
            }
        }
        Definitions definitions = Definitions.INSTANCE;
        ScopeDefinition$saveNewDefinition$beanDefinition$1 scopeDefinition$saveNewDefinition$beanDefinition$1 = new ScopeDefinition$saveNewDefinition$beanDefinition$1(instance);
        Options options = new Options(false, override);
        if (secondaryTypes == null) {
            secondaryTypes = CollectionsKt.emptyList();
        }
        BeanDefinition beanDefinitionCreateSingle = definitions.createSingle(orCreateKotlinClass, qualifier, scopeDefinition$saveNewDefinition$beanDefinition$1, this, options, secondaryTypes);
        save(beanDefinitionCreateSingle, override);
        return beanDefinitionCreateSingle;
    }

    public final void unloadDefinitions(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Iterator<T> it2 = scopeDefinition.getDefinitions().iterator();
        while (it2.hasNext()) {
            this._definitions.remove((BeanDefinition) it2.next());
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            ScopeDefinition scopeDefinition = (ScopeDefinition) other;
            return Intrinsics.areEqual(this.qualifier, scopeDefinition.qualifier) && this.isRoot == scopeDefinition.isRoot;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.koin.core.scope.ScopeDefinition");
    }

    public int hashCode() {
        return (this.qualifier.hashCode() * 31) + Boolean.valueOf(this.isRoot).hashCode();
    }

    public final ScopeDefinition copy() {
        ScopeDefinition scopeDefinition = new ScopeDefinition(this.qualifier, this.isRoot, new HashSet());
        scopeDefinition._definitions.addAll(getDefinitions());
        return scopeDefinition;
    }

    /* JADX INFO: compiled from: ScopeDefinition.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m5598d2 = {"Lorg/koin/core/scope/ScopeDefinition$Companion;", "", "()V", "ROOT_SCOPE_ID", "", "ROOT_SCOPE_QUALIFIER", "Lorg/koin/core/qualifier/StringQualifier;", "getROOT_SCOPE_QUALIFIER", "()Lorg/koin/core/qualifier/StringQualifier;", "rootDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StringQualifier getROOT_SCOPE_QUALIFIER() {
            return ScopeDefinition.ROOT_SCOPE_QUALIFIER;
        }

        public final ScopeDefinition rootDefinition() {
            return new ScopeDefinition(getROOT_SCOPE_QUALIFIER(), true, null, 4, null);
        }
    }
}
