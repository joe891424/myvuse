package org.koin.androidx.scope.compat;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.koin.androidx.scope.LifecycleOwnerExtKt;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ScopeCompat.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m5598d2 = {"Lorg/koin/androidx/scope/compat/ScopeCompat;", "", "()V", "lifecycleScope", "Lorg/koin/core/scope/Scope;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "koin-androidx-scope_release"}, m5599k = 1, m5600mv = {1, 1, 16})
public final class ScopeCompat {
    public static final ScopeCompat INSTANCE = new ScopeCompat();

    private ScopeCompat() {
    }

    @JvmStatic
    public static final Scope lifecycleScope(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        return LifecycleOwnerExtKt.getLifecycleScope(owner);
    }
}
