package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.p099io.CloseableKt;
import org.koin.android.logger.AndroidLogger;
import org.koin.core.KoinApplication;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Definitions;
import org.koin.core.definition.Kind;
import org.koin.core.definition.Options;
import org.koin.core.error.DefinitionOverrideException;
import org.koin.core.logger.Level;
import org.koin.core.module.Module;
import org.koin.core.parameter.DefinitionParameters;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.core.scope.ScopeDefinition;
import org.koin.dsl.ModuleKt;

/* JADX INFO: compiled from: KoinExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m5598d2 = {"androidContext", "Lorg/koin/core/KoinApplication;", "Landroid/content/Context;", "androidFileProperties", "koinPropertyFile", "", "androidLogger", FirebaseAnalytics.Param.LEVEL, "Lorg/koin/core/logger/Level;", "koin-android_release"}, m5599k = 2, m5600mv = {1, 1, 16})
public final class KoinExtKt {
    public static /* synthetic */ KoinApplication androidLogger$default(KoinApplication koinApplication, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        return androidLogger(koinApplication, level);
    }

    public static final KoinApplication androidLogger(KoinApplication androidLogger, Level level) {
        Intrinsics.checkParameterIsNotNull(androidLogger, "$this$androidLogger");
        Intrinsics.checkParameterIsNotNull(level, "level");
        androidLogger.getKoin().set_logger(new AndroidLogger(level));
        return androidLogger;
    }

    public static final KoinApplication androidContext(KoinApplication androidContext, final Context androidContext2) {
        Intrinsics.checkParameterIsNotNull(androidContext, "$this$androidContext");
        Intrinsics.checkParameterIsNotNull(androidContext2, "androidContext");
        if (androidContext.getKoin().get_logger().isAt(Level.INFO)) {
            androidContext.getKoin().get_logger().info("[init] declare Android Context");
        }
        if (androidContext2 instanceof Application) {
            androidContext.getKoin().loadModules(CollectionsKt.listOf(ModuleKt.module$default(false, false, new Function1<Module, Unit>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Module module) throws DefinitionOverrideException {
                    invoke2(module);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Module receiver) throws DefinitionOverrideException {
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    Function2<Scope, DefinitionParameters, Application> function2 = new Function2<Scope, DefinitionParameters, Application>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Application invoke(Scope receiver2, DefinitionParameters it2) {
                            Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                            Intrinsics.checkParameterIsNotNull(it2, "it");
                            return (Application) androidContext2;
                        }
                    };
                    Definitions definitions = Definitions.INSTANCE;
                    ScopeDefinition rootScope = receiver.getRootScope();
                    Options optionsMakeOptions = receiver.makeOptions(false, false);
                    List listEmptyList = CollectionsKt.emptyList();
                    ScopeDefinition.save$default(rootScope, new BeanDefinition(rootScope, Reflection.getOrCreateKotlinClass(Application.class), null, function2, Kind.Single, listEmptyList, optionsMakeOptions, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
                }
            }, 3, null)));
        }
        androidContext.getKoin().loadModules(CollectionsKt.listOf(ModuleKt.module$default(false, false, new Function1<Module, Unit>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Module module) throws DefinitionOverrideException {
                invoke2(module);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Module receiver) throws DefinitionOverrideException {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                Function2<Scope, DefinitionParameters, Context> function2 = new Function2<Scope, DefinitionParameters, Context>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.2.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Context invoke(Scope receiver2, DefinitionParameters it2) {
                        Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                        Intrinsics.checkParameterIsNotNull(it2, "it");
                        return androidContext2;
                    }
                };
                Definitions definitions = Definitions.INSTANCE;
                ScopeDefinition rootScope = receiver.getRootScope();
                Options optionsMakeOptions = receiver.makeOptions(false, false);
                List listEmptyList = CollectionsKt.emptyList();
                ScopeDefinition.save$default(rootScope, new BeanDefinition(rootScope, Reflection.getOrCreateKotlinClass(Context.class), null, function2, Kind.Single, listEmptyList, optionsMakeOptions, null, null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, null), false, 2, null);
            }
        }, 3, null)));
        return androidContext;
    }

    public static /* synthetic */ KoinApplication androidFileProperties$default(KoinApplication koinApplication, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "koin.properties";
        }
        return androidFileProperties(koinApplication, str);
    }

    public static final KoinApplication androidFileProperties(KoinApplication androidFileProperties, String koinPropertyFile) {
        String[] list;
        Intrinsics.checkParameterIsNotNull(androidFileProperties, "$this$androidFileProperties");
        Intrinsics.checkParameterIsNotNull(koinPropertyFile, "koinPropertyFile");
        androidFileProperties.getKoin().createRootScope();
        Properties properties = new Properties();
        Context context = (Context) androidFileProperties.getKoin().get_scopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<DefinitionParameters>) null);
        try {
            AssetManager assets = context.getAssets();
            if ((assets == null || (list = assets.list("")) == null) ? false : ArraysKt.contains(list, koinPropertyFile)) {
                try {
                    InputStream inputStreamOpen = context.getAssets().open(koinPropertyFile);
                    try {
                        properties.load(inputStreamOpen);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpen, null);
                        androidFileProperties.getKoin().get_propertyRegistry().saveProperties(properties);
                        Unit unit2 = Unit.INSTANCE;
                        if (androidFileProperties.getKoin().get_logger().isAt(Level.INFO)) {
                            androidFileProperties.getKoin().get_logger().info("[Android-Properties] loaded " + unit2 + " properties from assets/" + koinPropertyFile);
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    androidFileProperties.getKoin().get_logger().error("[Android-Properties] error for binding properties : " + e);
                }
            } else if (androidFileProperties.getKoin().get_logger().isAt(Level.INFO)) {
                androidFileProperties.getKoin().get_logger().info("[Android-Properties] no assets/" + koinPropertyFile + " file to load");
            }
        } catch (Exception e2) {
            androidFileProperties.getKoin().get_logger().error("[Android-Properties] error while loading properties from assets/" + koinPropertyFile + " : " + e2);
        }
        return androidFileProperties;
    }
}
