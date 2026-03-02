package org.koin.core.module;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¨\u0006\u0004"}, m5598d2 = {"plus", "", "Lorg/koin/core/module/Module;", "module", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class ModuleKt {
    public static final List<Module> plus(List<Module> plus, Module module) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(module, "module");
        return CollectionsKt.plus((Collection) plus, (Iterable) CollectionsKt.listOf(module));
    }
}
