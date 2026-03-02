package org.koin.core.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.error.NoScopeDefFoundException;
import org.koin.core.error.ScopeAlreadyCreatedException;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;

/* JADX INFO: compiled from: ScopeRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\r\u0010\"\u001a\u00020!H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020!H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020!H\u0000¢\u0006\u0002\b'J&\u0010(\u001a\u00020\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u00172\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0001J&\u0010(\u001a\u00020\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u00172\u0006\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0016\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f04H\u0002J\u000e\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0006J\u0012\u00105\u001a\u00020!2\n\u0010)\u001a\u00060\u0013j\u0002`\u0017J\u0014\u00107\u001a\u0004\u0018\u00010\u00062\n\u0010)\u001a\u00060\u0013j\u0002`\u0017J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:H\u0002J\u001b\u0010;\u001a\u00020!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020:0=H\u0000¢\u0006\u0002\b>J\u0010\u0010?\u001a\u00020!2\u0006\u0010/\u001a\u00020\fH\u0002J\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010-\u001a\u00020\fH\u0002J\u0014\u0010D\u001a\u00020!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020:0=J\u000e\u0010D\u001a\u00020!2\u0006\u00109\u001a\u00020:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a&\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f0\u0012j\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u00060\u0012j\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u0006`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\bR!\u0010\u001a\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\f0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0017\u0012\u0004\u0012\u00020\u00060\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006E"}, m5598d2 = {"Lorg/koin/core/registry/ScopeRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_rootScope", "Lorg/koin/core/scope/Scope;", "get_rootScope", "()Lorg/koin/core/scope/Scope;", "set_rootScope", "(Lorg/koin/core/scope/Scope;)V", "_rootScopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "get_rootScopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "set_rootScopeDefinition", "(Lorg/koin/core/scope/ScopeDefinition;)V", "_scopeDefinitions", "Ljava/util/HashMap;", "", "Lorg/koin/core/qualifier/QualifierValue;", "Lkotlin/collections/HashMap;", "_scopes", "Lorg/koin/core/scope/ScopeID;", "rootScope", "getRootScope", "scopeDefinitions", "", "getScopeDefinitions", "()Ljava/util/Map;", "scopes", "getScopes", "clearScopes", "", "close", "close$koin_core", "createRootScope", "createRootScope$koin_core", "createRootScopeDefinition", "createRootScopeDefinition$koin_core", "createScope", "scopeId", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "source", "scopeDefinition", "declareDefinitions", "definition", "declareInstances", "declareScope", "declareScopes", "list", "", "deleteScope", "scope", "getScopeOrNull", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadModules", "modules", "", "loadModules$koin_core", "mergeDefinitions", "size", "", "unloadDefinitions", "unloadInstances", "unloadModules", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class ScopeRegistry {
    private final Koin _koin;
    private Scope _rootScope;
    private ScopeDefinition _rootScopeDefinition;
    private final HashMap<String, ScopeDefinition> _scopeDefinitions;
    private final HashMap<String, Scope> _scopes;

    public ScopeRegistry(Koin _koin) {
        Intrinsics.checkParameterIsNotNull(_koin, "_koin");
        this._koin = _koin;
        this._scopeDefinitions = new HashMap<>();
        this._scopes = new HashMap<>();
    }

    public final Map<String, ScopeDefinition> getScopeDefinitions() {
        return this._scopeDefinitions;
    }

    public final Map<String, Scope> getScopes() {
        return this._scopes;
    }

    public final ScopeDefinition get_rootScopeDefinition() {
        return this._rootScopeDefinition;
    }

    public final void set_rootScopeDefinition(ScopeDefinition scopeDefinition) {
        this._rootScopeDefinition = scopeDefinition;
    }

    public final Scope get_rootScope() {
        return this._rootScope;
    }

    public final void set_rootScope(Scope scope) {
        this._rootScope = scope;
    }

    public final Scope getRootScope() {
        Scope scope = this._rootScope;
        if (scope != null) {
            return scope;
        }
        throw new IllegalStateException("No root scoped initialized".toString());
    }

    public final int size() {
        Collection<ScopeDefinition> collectionValues = getScopeDefinitions().values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it2 = collectionValues.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(((ScopeDefinition) it2.next()).size$koin_core()));
        }
        return CollectionsKt.sumOfInt(arrayList);
    }

    private final void loadModule(Module module) throws DefinitionOverrideException {
        declareScope(module.getRootScope());
        declareScopes(module.getOtherScopes());
    }

    private final void declareScopes(List<ScopeDefinition> list) throws DefinitionOverrideException {
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            declareScope((ScopeDefinition) it2.next());
        }
    }

    private final void declareScope(ScopeDefinition scopeDefinition) throws DefinitionOverrideException {
        declareDefinitions(scopeDefinition);
        declareInstances(scopeDefinition);
    }

    private final void declareInstances(ScopeDefinition scopeDefinition) {
        Collection<Scope> collectionValues = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "_scopes.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (Intrinsics.areEqual(((Scope) obj).get_scopeDefinition(), scopeDefinition)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Scope) it2.next()).loadDefinitions(scopeDefinition);
        }
    }

    private final void declareDefinitions(ScopeDefinition definition) throws DefinitionOverrideException {
        if (getScopeDefinitions().containsKey(definition.getQualifier().getValue())) {
            mergeDefinitions(definition);
        } else {
            this._scopeDefinitions.put(definition.getQualifier().getValue(), definition.copy());
        }
    }

    private final void mergeDefinitions(ScopeDefinition definition) throws DefinitionOverrideException {
        ScopeDefinition scopeDefinition = getScopeDefinitions().get(definition.getQualifier().getValue());
        if (scopeDefinition == null) {
            throw new IllegalStateException(("Scope definition '" + definition + "' not found in " + this._scopeDefinitions).toString());
        }
        Iterator<T> it2 = definition.getDefinitions().iterator();
        while (it2.hasNext()) {
            ScopeDefinition.save$default(scopeDefinition, (BeanDefinition) it2.next(), false, 2, null);
        }
    }

    public final void createRootScopeDefinition$koin_core() {
        ScopeDefinition scopeDefinitionRootDefinition = ScopeDefinition.INSTANCE.rootDefinition();
        this._scopeDefinitions.put(ScopeDefinition.INSTANCE.getROOT_SCOPE_QUALIFIER().getValue(), scopeDefinitionRootDefinition);
        this._rootScopeDefinition = scopeDefinitionRootDefinition;
    }

    public final void createRootScope$koin_core() {
        if (this._rootScope == null) {
            this._rootScope = createScope(ScopeDefinition.ROOT_SCOPE_ID, ScopeDefinition.INSTANCE.getROOT_SCOPE_QUALIFIER(), (Object) null);
        }
    }

    public final Scope getScopeOrNull(String scopeId) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        return getScopes().get(scopeId);
    }

    public static /* synthetic */ Scope createScope$default(ScopeRegistry scopeRegistry, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return scopeRegistry.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String scopeId, Qualifier qualifier, Object source) throws ScopeAlreadyCreatedException, NoScopeDefFoundException {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        Intrinsics.checkParameterIsNotNull(qualifier, "qualifier");
        if (getScopes().containsKey(scopeId)) {
            throw new ScopeAlreadyCreatedException("Scope with id '" + scopeId + "' is already created");
        }
        ScopeDefinition scopeDefinition = getScopeDefinitions().get(qualifier.getValue());
        if (scopeDefinition != null) {
            Scope scopeCreateScope = createScope(scopeId, scopeDefinition, source);
            this._scopes.put(scopeId, scopeCreateScope);
            return scopeCreateScope;
        }
        throw new NoScopeDefFoundException("No Scope Definition found for qualifer '" + qualifier.getValue() + '\'');
    }

    private final Scope createScope(String scopeId, ScopeDefinition scopeDefinition, Object source) {
        List<Scope> listEmptyList;
        Scope scope = new Scope(scopeId, scopeDefinition, this._koin, source);
        Scope scope2 = this._rootScope;
        if (scope2 == null || (listEmptyList = CollectionsKt.listOf(scope2)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        scope.create$koin_core(listEmptyList);
        return scope;
    }

    public final void deleteScope(String scopeId) {
        Intrinsics.checkParameterIsNotNull(scopeId, "scopeId");
        this._scopes.remove(scopeId);
    }

    public final void deleteScope(Scope scope) {
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        this._scopes.remove(scope.getId());
    }

    public final void close$koin_core() {
        clearScopes();
        this._scopes.clear();
        this._scopeDefinitions.clear();
        this._rootScopeDefinition = null;
        this._rootScope = null;
    }

    private final void clearScopes() {
        Collection<Scope> collectionValues = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "_scopes.values");
        Iterator<T> it2 = collectionValues.iterator();
        while (it2.hasNext()) {
            ((Scope) it2.next()).clear$koin_core();
        }
    }

    public final void unloadModules(Module module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Iterator it2 = CollectionsKt.plus((Collection<? extends ScopeDefinition>) module.getOtherScopes(), module.getRootScope()).iterator();
        while (it2.hasNext()) {
            unloadDefinitions((ScopeDefinition) it2.next());
        }
        module.setLoaded$koin_core(false);
    }

    private final void unloadDefinitions(ScopeDefinition scopeDefinition) {
        Object next;
        unloadInstances(scopeDefinition);
        Collection<ScopeDefinition> collectionValues = this._scopeDefinitions.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "_scopeDefinitions.values");
        Iterator<T> it2 = collectionValues.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (Intrinsics.areEqual((ScopeDefinition) next, scopeDefinition)) {
                    break;
                }
            }
        }
        ScopeDefinition scopeDefinition2 = (ScopeDefinition) next;
        if (scopeDefinition2 != null) {
            scopeDefinition2.unloadDefinitions(scopeDefinition);
        }
    }

    private final void unloadInstances(ScopeDefinition scopeDefinition) {
        Collection<Scope> collectionValues = this._scopes.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "_scopes.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (Intrinsics.areEqual(((Scope) obj).get_scopeDefinition(), scopeDefinition)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Scope) it2.next()).dropInstances(scopeDefinition);
        }
    }

    public final void loadModules$koin_core(Iterable<Module> modules) throws DefinitionOverrideException {
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        for (Module module : modules) {
            if (!module.getIsLoaded()) {
                loadModule(module);
                module.setLoaded$koin_core(true);
            } else {
                this._koin.get_logger().error("module '" + module + "' already loaded!");
            }
        }
    }

    public final void unloadModules(Iterable<Module> modules) {
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        Iterator<Module> it2 = modules.iterator();
        while (it2.hasNext()) {
            unloadModules(it2.next());
        }
    }
}
