package org.koin.core.scope;

import androidx.exifinterface.media.ExifInterface;
import com.onetrust.otpublishers.headless.Public.Keys.OTUXParamsKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Options;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.error.MissingPropertyException;
import org.koin.core.error.NoBeanDefFoundException;
import org.koin.core.logger.Level;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.time.MeasureKt;
import org.koin.ext.KClassExtKt;

/* JADX INFO: compiled from: Scope.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\nJ?\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+¢\u0006\u0002\u0010,J6\u0010#\u001a\u0002H$\"\u0006\b\u0000\u0010$\u0018\u0001\"\u0006\b\u0001\u0010-\u0018\u00012\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0086\b¢\u0006\u0002\u0010.J\r\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u000200J\r\u00103\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0001HÆ\u0003J7\u00107\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u001b\u00108\u001a\u0002002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00000:H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u000200H\u0000¢\u0006\u0002\b=JN\u0010>\u001a\u000200\"\n\b\u0000\u0010?\u0018\u0001*\u00020\u00012\u0006\u0010@\u001a\u0002H?2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0014\b\u0002\u0010C\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0018\u00010:2\b\b\u0002\u0010D\u001a\u00020\u0010H\u0086\b¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020\u0006J\u0013\u0010H\u001a\u00020\u00102\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003JA\u0010J\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\b\u0010A\u001a\u0004\u0018\u00010B2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0002¢\u0006\u0002\u0010LJC\u0010M\u001a\u0002H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030N2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0007¢\u0006\u0002\u0010OJA\u0010M\u001a\u0002H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+¢\u0006\u0002\u0010LJ:\u0010M\u001a\u0002H?\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0087\b¢\u0006\u0002\u0010PJ\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002H?0:\"\n\b\u0000\u0010?\u0018\u0001*\u00020\u0001H\u0086\bJ\"\u0010Q\u001a\b\u0012\u0004\u0012\u0002H?0:\"\b\b\u0000\u0010?*\u00020\u00012\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&J!\u0010R\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&H\u0002¢\u0006\u0002\u0010SJ\u0006\u0010T\u001a\u00020\bJE\u0010U\u001a\u0004\u0018\u0001H?\"\u0004\b\u0000\u0010?2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0007¢\u0006\u0002\u0010LJ<\u0010U\u001a\u0004\u0018\u0001H?\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0087\b¢\u0006\u0002\u0010PJ\u000e\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0003J\u0016\u0010V\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u00032\u0006\u0010W\u001a\u00020\u0003J\u0012\u0010Z\u001a\u00020\u00002\n\u0010[\u001a\u00060\u0003j\u0002`\u0004J\u001a\u0010\\\u001a\u0002H?\"\n\b\u0000\u0010?\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u001dJ\t\u0010]\u001a\u00020^HÖ\u0001J;\u0010_\u001a\b\u0012\u0004\u0012\u0002H?0`\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0087\bJ=\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H?0`\"\u0006\b\u0000\u0010?\u0018\u00012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0016\b\n\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0087\bJ\u001f\u0010b\u001a\u0002002\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u0002002\u0006\u0010G\u001a\u00020\u0006J\u000e\u0010g\u001a\u0002002\u0006\u0010h\u001a\u00020\rJ?\u0010i\u001a\u0002H?\"\u0004\b\u0000\u0010?2\b\u0010A\u001a\u0004\u0018\u00010B2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&2\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0004\u0018\u0001`+H\u0002¢\u0006\u0002\u0010jJ\u001e\u0010k\u001a\u00020l2\b\u0010A\u001a\u0004\u0018\u00010B2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030&H\u0002J\b\u0010m\u001a\u00020\u0003H\u0016J\u001f\u0010n\u001a\u0002002\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000d\"\u00020\u0000¢\u0006\u0002\u0010eR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00000\fj\b\u0012\u0004\u0012\u00020\u0000`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006o"}, m5598d2 = {"Lorg/koin/core/scope/Scope;", "", "id", "", "Lorg/koin/core/scope/ScopeID;", "_scopeDefinition", "Lorg/koin/core/scope/ScopeDefinition;", "_koin", "Lorg/koin/core/Koin;", "_source", "(Ljava/lang/String;Lorg/koin/core/scope/ScopeDefinition;Lorg/koin/core/Koin;Ljava/lang/Object;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "", "_instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "get_instanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "get_koin", "()Lorg/koin/core/Koin;", "_linkedScope", "get_linkedScope", "()Ljava/util/ArrayList;", "get_scopeDefinition", "()Lorg/koin/core/scope/ScopeDefinition;", "get_source", "()Ljava/lang/Object;", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "bind", ExifInterface.LATITUDE_SOUTH, "primaryType", "Lkotlin/reflect/KClass;", "secondaryType", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/DefinitionParameters;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "P", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "clear", "", "clear$koin_core", "close", "component1", "component2", "component3", "component4", "copy", "create", OTUXParamsKeys.OT_UX_LINKS, "", "create$koin_core", "createEagerInstances", "createEagerInstances$koin_core", "declare", ExifInterface.GPS_DIRECTION_TRUE, "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "override", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "dropInstances", "scopeDefinition", "equals", "other", "findInOtherScope", "clazz", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "Ljava/lang/Class;", "(Ljava/lang/Class;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", "key", "defaultValue", "getPropertyOrNull", "getScope", "scopeID", "getSource", "hashCode", "", "inject", "Lkotlin/Lazy;", "injectOrNull", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "loadDefinitions", "registerCallback", "callback", "resolveInstance", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", "toString", "unlink", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public final /* data */ class Scope {
    private final ArrayList<ScopeCallback> _callbacks;
    private boolean _closed;
    private final InstanceRegistry _instanceRegistry;
    private final Koin _koin;
    private final ArrayList<Scope> _linkedScope;
    private final ScopeDefinition _scopeDefinition;
    private final Object _source;
    private final String id;

    public static /* synthetic */ Scope copy$default(Scope scope, String str, ScopeDefinition scopeDefinition, Koin koin, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = scope.id;
        }
        if ((i & 2) != 0) {
            scopeDefinition = scope._scopeDefinition;
        }
        if ((i & 4) != 0) {
            koin = scope._koin;
        }
        if ((i & 8) != 0) {
            obj = scope._source;
        }
        return scope.copy(str, scopeDefinition, koin, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ScopeDefinition get_scopeDefinition() {
        return this._scopeDefinition;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Koin get_koin() {
        return this._koin;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object get_source() {
        return this._source;
    }

    public final Scope copy(String id, ScopeDefinition _scopeDefinition, Koin _koin, Object _source) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(_scopeDefinition, "_scopeDefinition");
        Intrinsics.checkParameterIsNotNull(_koin, "_koin");
        return new Scope(id, _scopeDefinition, _koin, _source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Scope)) {
            return false;
        }
        Scope scope = (Scope) other;
        return Intrinsics.areEqual(this.id, scope.id) && Intrinsics.areEqual(this._scopeDefinition, scope._scopeDefinition) && Intrinsics.areEqual(this._koin, scope._koin) && Intrinsics.areEqual(this._source, scope._source);
    }

    public final /* synthetic */ <T> T get() {
        return (T) get$default(this, null, null, 3, null);
    }

    public final <T> T get(Class<?> cls) {
        return (T) get$default(this, cls, (Qualifier) null, (Function0) null, 6, (Object) null);
    }

    public final <T> T get(Class<?> cls, Qualifier qualifier) {
        return (T) get$default(this, cls, qualifier, (Function0) null, 4, (Object) null);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier) {
        return (T) get$default(this, qualifier, null, 2, null);
    }

    public final /* synthetic */ <T> T getOrNull() {
        return (T) getOrNull$default(this, null, null, 3, null);
    }

    public final <T> T getOrNull(KClass<?> kClass) {
        return (T) getOrNull$default(this, kClass, null, null, 6, null);
    }

    public final <T> T getOrNull(KClass<?> kClass, Qualifier qualifier) {
        return (T) getOrNull$default(this, kClass, qualifier, null, 4, null);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier) {
        return (T) getOrNull$default(this, qualifier, null, 2, null);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ScopeDefinition scopeDefinition = this._scopeDefinition;
        int iHashCode2 = (iHashCode + (scopeDefinition != null ? scopeDefinition.hashCode() : 0)) * 31;
        Koin koin = this._koin;
        int iHashCode3 = (iHashCode2 + (koin != null ? koin.hashCode() : 0)) * 31;
        Object obj = this._source;
        return iHashCode3 + (obj != null ? obj.hashCode() : 0);
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

    public Scope(String id, ScopeDefinition _scopeDefinition, Koin _koin, Object obj) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        Intrinsics.checkParameterIsNotNull(_scopeDefinition, "_scopeDefinition");
        Intrinsics.checkParameterIsNotNull(_koin, "_koin");
        this.id = id;
        this._scopeDefinition = _scopeDefinition;
        this._koin = _koin;
        this._source = obj;
        this._linkedScope = new ArrayList<>();
        this._instanceRegistry = new InstanceRegistry(_koin, this);
        this._callbacks = new ArrayList<>();
    }

    public final String getId() {
        return this.id;
    }

    public final ScopeDefinition get_scopeDefinition() {
        return this._scopeDefinition;
    }

    public final Koin get_koin() {
        return this._koin;
    }

    public /* synthetic */ Scope(String str, ScopeDefinition scopeDefinition, Koin koin, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, scopeDefinition, koin, (i & 8) != 0 ? null : obj);
    }

    public final Object get_source() {
        return this._source;
    }

    public final ArrayList<Scope> get_linkedScope() {
        return this._linkedScope;
    }

    public final InstanceRegistry get_instanceRegistry() {
        return this._instanceRegistry;
    }

    /* JADX INFO: renamed from: getClosed, reason: from getter */
    public final boolean get_closed() {
        return this._closed;
    }

    public final void create$koin_core(List<Scope> links) {
        Intrinsics.checkParameterIsNotNull(links, "links");
        this._instanceRegistry.create$koin_core(this._scopeDefinition.getDefinitions());
        this._linkedScope.addAll(links);
    }

    public final /* synthetic */ <T> T getSource() {
        T t = (T) get_source();
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        if (t != null) {
            return t;
        }
        StringBuilder sb = new StringBuilder("Can't use Scope source for ");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw new IllegalStateException(sb.append(KClassExtKt.getFullName(Reflection.getOrCreateKotlinClass(Object.class))).append(" - source is:").append(get_source()).toString().toString());
    }

    public final void linkTo(Scope... scopes) {
        Intrinsics.checkParameterIsNotNull(scopes, "scopes");
        if (!this._scopeDefinition.getIsRoot()) {
            CollectionsKt.addAll(this._linkedScope, scopes);
            return;
        }
        throw new IllegalStateException("Can't add scope link to a root scope".toString());
    }

    public final void unlink(Scope... scopes) {
        Intrinsics.checkParameterIsNotNull(scopes, "scopes");
        if (!this._scopeDefinition.getIsRoot()) {
            CollectionsKt.removeAll(this._linkedScope, scopes);
            return;
        }
        throw new IllegalStateException("Can't remove scope link to a root scope".toString());
    }

    public static /* synthetic */ Lazy inject$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) scope.new C59181(qualifier, function0));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.scope.Scope$inject$1 */
    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m5598d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 1, 16})
    public static final class C59181<T> extends Lambda implements Function0<T> {
        final /* synthetic */ Function0 $parameters;
        final /* synthetic */ Qualifier $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59181(Qualifier qualifier, Function0 function0) {
            super(0);
            this.$qualifier = qualifier;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            Scope scope = Scope.this;
            Qualifier qualifier = this.$qualifier;
            Function0<DefinitionParameters> function0 = this.$parameters;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) scope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
        }
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new C59181(qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) scope.new C59191(qualifier, function0));
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: org.koin.core.scope.Scope$injectOrNull$1 */
    /* JADX INFO: compiled from: Scope.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m5598d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 1, 16})
    public static final class C59191<T> extends Lambda implements Function0<T> {
        final /* synthetic */ Function0 $parameters;
        final /* synthetic */ Qualifier $qualifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59191(Qualifier qualifier, Function0 function0) {
            super(0);
            this.$qualifier = qualifier;
            this.$parameters = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            Scope scope = Scope.this;
            Qualifier qualifier = this.$qualifier;
            Function0<DefinitionParameters> function0 = this.$parameters;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
        }
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Intrinsics.needClassReification();
        return LazyKt.lazy(lazyThreadSafetyMode, (Function0) new C59191(qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.get((KClass<?>) Reflection.getOrCreateKotlinClass(Object.class), qualifier, (Function0<DefinitionParameters>) function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return scope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        try {
            return (T) get(clazz, qualifier, parameters);
        } catch (Exception unused) {
            this._koin.get_logger().error("Can't get instance for " + KClassExtKt.getFullName(clazz));
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get((KClass<?>) kClass, qualifier, (Function0<DefinitionParameters>) function0);
    }

    public final <T> T get(final KClass<?> clazz, final Qualifier qualifier, final Function0<DefinitionParameters> parameters) {
        String str;
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        if (this._koin.get_logger().isAt(Level.DEBUG)) {
            if (qualifier == null || (str = " with qualifier '" + qualifier + '\'') == null) {
                str = "";
            }
            this._koin.get_logger().debug("+- '" + KClassExtKt.getFullName(clazz) + '\'' + str);
            Pair pairMeasureDurationForResult = MeasureKt.measureDurationForResult(new Function0<T>() { // from class: org.koin.core.scope.Scope.get.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return (T) Scope.this.resolveInstance(qualifier, clazz, parameters);
                }
            });
            T t = (T) pairMeasureDurationForResult.component1();
            this._koin.get_logger().debug("|- '" + KClassExtKt.getFullName(clazz) + "' in " + ((Number) pairMeasureDurationForResult.component2()).doubleValue() + " ms");
            return t;
        }
        return (T) resolveInstance(qualifier, clazz, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Scope scope, Class cls, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return scope.get((Class<?>) cls, qualifier, (Function0<DefinitionParameters>) function0);
    }

    public final <T> T get(Class<?> clazz, Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return (T) get(JvmClassMappingKt.getKotlinClass(clazz), qualifier, parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T resolveInstance(Qualifier qualifier, KClass<?> clazz, Function0<DefinitionParameters> parameters) throws ClosedScopeException, NoBeanDefFoundException {
        if (this._closed) {
            throw new ClosedScopeException("Scope '" + this.id + "' is closed");
        }
        Object objResolveInstance$koin_core = this._instanceRegistry.resolveInstance$koin_core(BeanDefinitionKt.indexKey(clazz, qualifier), parameters);
        if (objResolveInstance$koin_core == null) {
            objResolveInstance$koin_core = (T) findInOtherScope(clazz, qualifier, parameters);
        }
        if (objResolveInstance$koin_core == null) {
            objResolveInstance$koin_core = (T) getFromSource(clazz);
        }
        if (objResolveInstance$koin_core != null) {
            return (T) objResolveInstance$koin_core;
        }
        throwDefinitionNotFound(qualifier, clazz);
        throw null;
    }

    private final <T> T getFromSource(KClass<?> clazz) {
        if (!clazz.isInstance(this._source)) {
            return null;
        }
        T t = (T) this._source;
        if (t instanceof Object) {
            return t;
        }
        return null;
    }

    private final <T> T findInOtherScope(KClass<?> clazz, Qualifier qualifier, Function0<DefinitionParameters> parameters) {
        Iterator<Scope> it2 = this._linkedScope.iterator();
        T t = null;
        while (it2.hasNext() && (t = (T) it2.next().getOrNull(clazz, qualifier, parameters)) == null) {
        }
        return t;
    }

    private final Void throwDefinitionNotFound(Qualifier qualifier, KClass<?> clazz) throws NoBeanDefFoundException {
        String str;
        if (qualifier == null || (str = " & qualifier:'" + qualifier + '\'') == null) {
            str = "";
        }
        throw new NoBeanDefFoundException("No definition found for class:'" + KClassExtKt.getFullName(clazz) + '\'' + str + ". Check your definitions!");
    }

    public final void createEagerInstances$koin_core() {
        if (this._scopeDefinition.getIsRoot()) {
            this._instanceRegistry.createEagerInstances$koin_core();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void declare$default(Scope scope, Object instance, Qualifier qualifier, List list, boolean z, int i, Object obj) {
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
        synchronized (scope) {
            try {
                ScopeDefinition scopeDefinition = scope.get_scopeDefinition();
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
                scope.get_instanceRegistry().saveDefinition(beanDefinitionCreateSingle, true);
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
        synchronized (this) {
            try {
                ScopeDefinition scopeDefinition = get_scopeDefinition();
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
                if (secondaryTypes == null) {
                    secondaryTypes = CollectionsKt.emptyList();
                }
                BeanDefinition<?> beanDefinitionCreateSingle = definitions.createSingle(orCreateKotlinClass, qualifier, scopeDefinition$saveNewDefinition$beanDefinition$1, scopeDefinition, options, secondaryTypes);
                scopeDefinition.save(beanDefinitionCreateSingle, override);
                get_instanceRegistry().saveDefinition(beanDefinitionCreateSingle, true);
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

    public final Koin getKoin() {
        return this._koin;
    }

    public final Scope getScope(String scopeID) {
        Intrinsics.checkParameterIsNotNull(scopeID, "scopeID");
        return getKoin().getScope(scopeID);
    }

    public final void registerCallback(ScopeCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this._callbacks.add(callback);
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> List<T> getAll(KClass<?> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        return this._instanceRegistry.getAll$koin_core(clazz);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object bind$default(Scope scope, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return scope.bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, function0);
    }

    public final /* synthetic */ <S, P> S bind(Function0<DefinitionParameters> parameters) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.LATITUDE_SOUTH);
        KClass<?> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(4, "P");
        return (S) bind(Reflection.getOrCreateKotlinClass(Object.class), orCreateKotlinClass, parameters);
    }

    public final <S> S bind(KClass<?> primaryType, KClass<?> secondaryType, Function0<DefinitionParameters> parameters) throws NoBeanDefFoundException {
        Intrinsics.checkParameterIsNotNull(primaryType, "primaryType");
        Intrinsics.checkParameterIsNotNull(secondaryType, "secondaryType");
        S s = (S) this._instanceRegistry.bind$koin_core(primaryType, secondaryType, parameters);
        if (s != null) {
            return s;
        }
        throw new NoBeanDefFoundException("No definition found to bind class:'" + KClassExtKt.getFullName(primaryType) + "' & secondary type:'" + KClassExtKt.getFullName(secondaryType) + "'. Check your definitions!");
    }

    public final String getProperty(String key, String defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        return this._koin.getProperty(key, defaultValue);
    }

    public final String getPropertyOrNull(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this._koin.getProperty(key);
    }

    public final String getProperty(String key) throws MissingPropertyException {
        Intrinsics.checkParameterIsNotNull(key, "key");
        String property = this._koin.getProperty(key);
        if (property != null) {
            return property;
        }
        throw new MissingPropertyException("Property '" + key + "' not found");
    }

    public final void close() {
        synchronized (this) {
            clear$koin_core();
            this._koin.get_scopeRegistry().deleteScope(this);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear$koin_core() {
        synchronized (this) {
            this._closed = true;
            if (this._koin.get_logger().isAt(Level.DEBUG)) {
                this._koin.get_logger().info("closing scope:'" + this.id + '\'');
            }
            Iterator<T> it2 = this._callbacks.iterator();
            while (it2.hasNext()) {
                ((ScopeCallback) it2.next()).onScopeClose(this);
            }
            this._callbacks.clear();
            this._instanceRegistry.close$koin_core();
            Unit unit = Unit.INSTANCE;
        }
    }

    public String toString() {
        return "['" + this.id + "']";
    }

    public final void dropInstances(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Iterator<T> it2 = scopeDefinition.getDefinitions().iterator();
        while (it2.hasNext()) {
            this._instanceRegistry.dropDefinition$koin_core((BeanDefinition) it2.next());
        }
    }

    public final void loadDefinitions(ScopeDefinition scopeDefinition) {
        Intrinsics.checkParameterIsNotNull(scopeDefinition, "scopeDefinition");
        Iterator<T> it2 = scopeDefinition.getDefinitions().iterator();
        while (it2.hasNext()) {
            this._instanceRegistry.createDefinition$koin_core((BeanDefinition) it2.next());
        }
    }
}
