package org.koin.core.context;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.KoinApplication;
import org.koin.core.module.Module;

/* JADX INFO: compiled from: ContextFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007\u001a-\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001b\u0010\u000b\u001a\u0017\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fj\u0002`\r¢\u0006\u0002\b\u000e\u001a\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0014\u0010\u0010\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u000e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0011"}, m5598d2 = {"loadKoinModules", "", "modules", "", "Lorg/koin/core/module/Module;", "module", "startKoin", "Lorg/koin/core/KoinApplication;", "koinContext", "Lorg/koin/core/context/KoinContext;", "koinApplication", "appDeclaration", "Lkotlin/Function1;", "Lorg/koin/dsl/KoinAppDeclaration;", "Lkotlin/ExtensionFunctionType;", "stopKoin", "unloadKoinModules", "koin-core"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class ContextFunctionsKt {
    public static /* synthetic */ KoinApplication startKoin$default(KoinContext koinContext, KoinApplication koinApplication, int i, Object obj) {
        if ((i & 1) != 0) {
            koinContext = new GlobalContext();
        }
        return startKoin(koinContext, koinApplication);
    }

    public static final KoinApplication startKoin(KoinContext koinContext, KoinApplication koinApplication) {
        Intrinsics.checkParameterIsNotNull(koinContext, "koinContext");
        Intrinsics.checkParameterIsNotNull(koinApplication, "koinApplication");
        KoinContextHandler.INSTANCE.register(koinContext);
        KoinContextHandler.INSTANCE.start(koinApplication);
        koinApplication.createEagerInstances();
        return koinApplication;
    }

    public static /* synthetic */ KoinApplication startKoin$default(KoinContext koinContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            koinContext = new GlobalContext();
        }
        return startKoin(koinContext, (Function1<? super KoinApplication, Unit>) function1);
    }

    public static final KoinApplication startKoin(KoinContext koinContext, Function1<? super KoinApplication, Unit> appDeclaration) {
        Intrinsics.checkParameterIsNotNull(koinContext, "koinContext");
        Intrinsics.checkParameterIsNotNull(appDeclaration, "appDeclaration");
        KoinContextHandler.INSTANCE.register(koinContext);
        KoinApplication koinApplicationInit = KoinApplication.INSTANCE.init();
        KoinContextHandler.INSTANCE.start(koinApplicationInit);
        appDeclaration.invoke(koinApplicationInit);
        koinApplicationInit.createEagerInstances();
        return koinApplicationInit;
    }

    public static final void stopKoin() {
        KoinContextHandler.INSTANCE.stop();
    }

    public static final void loadKoinModules(Module module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        KoinContextHandler.INSTANCE.get().loadModules(CollectionsKt.listOf(module));
    }

    public static final void loadKoinModules(List<Module> modules) {
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        KoinContextHandler.INSTANCE.get().loadModules(modules);
    }

    public static final void unloadKoinModules(Module module) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        KoinContextHandler.INSTANCE.get().unloadModules(CollectionsKt.listOf(module));
    }

    public static final void unloadKoinModules(List<Module> modules) {
        Intrinsics.checkParameterIsNotNull(modules, "modules");
        KoinContextHandler.INSTANCE.get().unloadModules(modules);
    }
}
