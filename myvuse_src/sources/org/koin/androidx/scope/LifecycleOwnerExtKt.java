package org.koin.androidx.scope;

import android.content.ComponentCallbacks;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.koin.android.ext.android.ComponentCallbackExtKt;
import org.koin.core.Koin;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.ext.InstanceScopeExtKt;

/* JADX INFO: compiled from: LifecycleOwnerExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0002H\u0002\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0018"}, m5598d2 = {"currentScope", "Lorg/koin/core/scope/Scope;", "Landroidx/lifecycle/LifecycleOwner;", "currentScope$annotations", "(Landroidx/lifecycle/LifecycleOwner;)V", "getCurrentScope", "(Landroidx/lifecycle/LifecycleOwner;)Lorg/koin/core/scope/Scope;", "lifecycleScope", "getLifecycleScope", "scope", "scope$annotations", "getScope", "bindScope", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "createAndBindAndroidScope", "scopeId", "", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "getKoin", "Lorg/koin/core/Koin;", "getOrCreateAndroidScope", "koin-androidx-scope_release"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class LifecycleOwnerExtKt {
    @Deprecated(message = "Use lifecycleScope instead", replaceWith = @ReplaceWith(expression = "lifecycleScope", imports = {}))
    public static /* synthetic */ void currentScope$annotations(LifecycleOwner lifecycleOwner) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use lifecycleScope instead", replaceWith = @ReplaceWith(expression = "lifecycleScope", imports = {}))
    public static /* synthetic */ void scope$annotations(LifecycleOwner lifecycleOwner) {
    }

    private static final Koin getKoin(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            return ComponentCallbackExtKt.getKoin((ComponentCallbacks) lifecycleOwner);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.ComponentCallbacks");
    }

    private static final Scope getOrCreateAndroidScope(LifecycleOwner lifecycleOwner) {
        String scopeId = InstanceScopeExtKt.getScopeId(lifecycleOwner);
        Scope scopeOrNull = getKoin(lifecycleOwner).getScopeOrNull(scopeId);
        return scopeOrNull != null ? scopeOrNull : createAndBindAndroidScope(lifecycleOwner, scopeId, InstanceScopeExtKt.getScopeName(lifecycleOwner));
    }

    private static final Scope createAndBindAndroidScope(LifecycleOwner lifecycleOwner, String str, Qualifier qualifier) {
        Scope scopeCreateScope = getKoin(lifecycleOwner).createScope(str, qualifier, lifecycleOwner);
        bindScope$default(lifecycleOwner, scopeCreateScope, null, 2, null);
        return scopeCreateScope;
    }

    public static /* synthetic */ void bindScope$default(LifecycleOwner lifecycleOwner, Scope scope, Lifecycle.Event event, int i, Object obj) {
        if ((i & 2) != 0) {
            event = Lifecycle.Event.ON_DESTROY;
        }
        bindScope(lifecycleOwner, scope, event);
    }

    public static final void bindScope(LifecycleOwner bindScope, Scope scope, Lifecycle.Event event) {
        Intrinsics.checkParameterIsNotNull(bindScope, "$this$bindScope");
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        Intrinsics.checkParameterIsNotNull(event, "event");
        bindScope.getLifecycle().addObserver(new ScopeObserver(event, bindScope, scope));
    }

    public static final Scope getLifecycleScope(LifecycleOwner lifecycleScope) {
        Intrinsics.checkParameterIsNotNull(lifecycleScope, "$this$lifecycleScope");
        return getOrCreateAndroidScope(lifecycleScope);
    }

    public static final Scope getScope(LifecycleOwner scope) {
        Intrinsics.checkParameterIsNotNull(scope, "$this$scope");
        throw new IllegalStateException("Don't use scope on a lifecycle component. Use lifecycleScope instead".toString());
    }

    public static final Scope getCurrentScope(LifecycleOwner currentScope) {
        Intrinsics.checkParameterIsNotNull(currentScope, "$this$currentScope");
        return getOrCreateAndroidScope(currentScope);
    }
}
