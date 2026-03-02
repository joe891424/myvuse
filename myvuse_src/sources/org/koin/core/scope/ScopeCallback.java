package org.koin.core.scope;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScopeCallback.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m5598d2 = {"Lorg/koin/core/scope/ScopeCallback;", "", "onScopeClose", "", "scope", "Lorg/koin/core/scope/Scope;", "koin-core"}, m5599k = 1, m5600mv = {1, 1, 16})
public interface ScopeCallback {
    void onScopeClose(Scope scope);
}
