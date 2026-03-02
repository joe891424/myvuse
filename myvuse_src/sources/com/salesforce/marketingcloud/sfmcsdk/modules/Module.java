package com.salesforce.marketingcloud.sfmcsdk.modules;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.salesforce.marketingcloud.sfmcsdk.InitializationState;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.components.identity.ModuleIdentity;
import com.salesforce.marketingcloud.sfmcsdk.components.logging.SFMCSdkLogger;
import com.salesforce.marketingcloud.sfmcsdk.components.utils.NamedRunnable;
import com.salesforce.marketingcloud.sfmcsdk.modules.Module;
import com.salesforce.marketingcloud.sfmcsdk.modules.cdp.CdpModuleInterface;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModule;
import com.salesforce.marketingcloud.sfmcsdk.modules.push.PushModuleInterface;
import com.yoti.mobile.android.remote.debug.RemoteDebugPreferencesKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u0006\u0010(\u001a\u00020\u001eR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0084\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, m5598d2 = {"Lcom/salesforce/marketingcloud/sfmcsdk/modules/Module;", "", "()V", "MODULE_INSTANCE_REQUESTS", "", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleReadyHandler;", "getMODULE_INSTANCE_REQUESTS$annotations", "getMODULE_INSTANCE_REQUESTS", "()Ljava/util/List;", "initializationState", "Lcom/salesforce/marketingcloud/sfmcsdk/InitializationState;", "getInitializationState", "()Lcom/salesforce/marketingcloud/sfmcsdk/InitializationState;", "setInitializationState", "(Lcom/salesforce/marketingcloud/sfmcsdk/InitializationState;)V", "module", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;", "getModule", "()Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;", "setModule", "(Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleInterface;)V", "name", "", "getName", "()Ljava/lang/String;", "getIdentity", "Lcom/salesforce/marketingcloud/sfmcsdk/components/identity/ModuleIdentity;", "getState", "Lorg/json/JSONObject;", "initModule", "", "context", "Landroid/content/Context;", "config", "Lcom/salesforce/marketingcloud/sfmcsdk/modules/Config;", "components", "Lcom/salesforce/marketingcloud/sfmcsdk/SFMCSdkComponents;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/salesforce/marketingcloud/sfmcsdk/modules/ModuleReadyListener;", "requestModule", "tearDown", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public abstract class Module {
    private final List<ModuleReadyHandler> MODULE_INSTANCE_REQUESTS = new ArrayList();
    private InitializationState initializationState = InitializationState.NONE;
    private ModuleInterface module;

    /* JADX INFO: compiled from: Module.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationState.values().length];
            iArr[InitializationState.READY.ordinal()] = 1;
            iArr[InitializationState.NONE.ordinal()] = 2;
            iArr[InitializationState.ERROR.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected static /* synthetic */ void getMODULE_INSTANCE_REQUESTS$annotations() {
    }

    public abstract String getName();

    protected final List<ModuleReadyHandler> getMODULE_INSTANCE_REQUESTS() {
        return this.MODULE_INSTANCE_REQUESTS;
    }

    protected final InitializationState getInitializationState() {
        return this.initializationState;
    }

    protected final void setInitializationState(InitializationState initializationState) {
        Intrinsics.checkNotNullParameter(initializationState, "<set-?>");
        this.initializationState = initializationState;
    }

    protected final ModuleInterface getModule() {
        return this.module;
    }

    protected final void setModule(ModuleInterface moduleInterface) {
        this.module = moduleInterface;
    }

    public final void requestModule(ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final ModuleReadyHandler moduleReadyHandler = new ModuleReadyHandler(listener);
        synchronized (this.MODULE_INSTANCE_REQUESTS) {
            if (WhenMappings.$EnumSwitchMapping$0[this.initializationState.ordinal()] == 1) {
                try {
                    ModuleInterface moduleInterface = this.module;
                    if (moduleInterface != null) {
                        moduleReadyHandler.deliverModule(moduleInterface);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    SFMCSdkLogger.INSTANCE.mo3977e(PushModule.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$requestModule$1$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failure during requestPush() delivery for " + moduleReadyHandler + '.';
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                }
            } else {
                Boolean.valueOf(this.MODULE_INSTANCE_REQUESTS.add(moduleReadyHandler));
            }
        }
    }

    public final void tearDown() {
        this.MODULE_INSTANCE_REQUESTS.clear();
        this.module = null;
        this.initializationState = InitializationState.NONE;
    }

    public final ModuleIdentity getIdentity() {
        ModuleIdentity moduleIdentity;
        ModuleInterface moduleInterface = this.module;
        if (moduleInterface == null || (moduleIdentity = moduleInterface.getModuleIdentity()) == null) {
            throw new NotImplementedError("An operation is not implemented: Your module must implement getIdentity().");
        }
        return moduleIdentity;
    }

    public final JSONObject getState() throws JSONException {
        JSONObject jSONObjectPut;
        ModuleInterface moduleInterface = this.module;
        if (moduleInterface == null || (jSONObjectPut = moduleInterface.getState()) == null) {
            JSONObject jSONObject = new JSONObject();
            int i = WhenMappings.$EnumSwitchMapping$0[this.initializationState.ordinal()];
            if (i == 2) {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", "NOT IMPLEMENTED OR NOT INITIALIZED");
            } else if (i == 3) {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", RemoteDebugPreferencesKt.DEBUG_OPTIONS_REMOTE_BEHAVIOUR_ERROR);
            } else {
                jSONObjectPut = jSONObject.put("INITIALIZATION_STATUS", "NOT READY");
            }
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().run {\n    w…\", \"NOT READY\")\n    }\n  }");
        }
        return jSONObjectPut;
    }

    /* JADX INFO: renamed from: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1 */
    /* JADX INFO: compiled from: Module.kt */
    @Metadata(m5597d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, m5598d2 = {"com/salesforce/marketingcloud/sfmcsdk/modules/Module$initModule$1", "Lcom/salesforce/marketingcloud/sfmcsdk/components/utils/NamedRunnable;", "execute", "", "sfmcsdk_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class C43271 extends NamedRunnable {
        final /* synthetic */ SFMCSdkComponents $components;
        final /* synthetic */ Config $config;
        final /* synthetic */ Context $context;
        final /* synthetic */ ModuleReadyListener $listener;

        /* JADX INFO: renamed from: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$WhenMappings */
        /* JADX INFO: compiled from: Module.kt */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ModuleIdentifier.values().length];
                iArr[ModuleIdentifier.PUSH.ordinal()] = 1;
                iArr[ModuleIdentifier.CDP.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C43271(Config config, Context context, SFMCSdkComponents sFMCSdkComponents, ModuleReadyListener moduleReadyListener, String str, Object[] objArr) {
            super(str, objArr);
            this.$config = config;
            this.$context = context;
            this.$components = sFMCSdkComponents;
            this.$listener = moduleReadyListener;
        }

        @Override // com.salesforce.marketingcloud.sfmcsdk.components.utils.NamedRunnable
        protected void execute() {
            Module.this.setInitializationState(InitializationState.INITIALIZING);
            SFMCSdkLogger sFMCSdkLogger = SFMCSdkLogger.INSTANCE;
            String name = getName();
            final Config config = this.$config;
            sFMCSdkLogger.mo3976d(name, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "~~ " + config.getModuleIdentifier().name() + " Module Initialization Started ~~";
                }
            });
            final Config config2 = this.$config;
            Context context = this.$context;
            SFMCSdkComponents sFMCSdkComponents = this.$components;
            final Module module = Module.this;
            final ModuleReadyListener moduleReadyListener = this.$listener;
            config2.init(context, sFMCSdkComponents, new ModuleReadyListener() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$$ExternalSyntheticLambda0
                @Override // com.salesforce.marketingcloud.sfmcsdk.modules.ModuleReadyListener
                public final void ready(ModuleInterface moduleInterface) {
                    Module.C43271.m6736execute$lambda2(this.f$0, module, config2, moduleReadyListener, moduleInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: execute$lambda-2, reason: not valid java name */
        public static final void m6736execute$lambda2(C43271 this$0, Module this$1, final Config config, ModuleReadyListener listener, final ModuleInterface it2) {
            PushModuleInterface pushModuleInterface;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(config, "$config");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            Intrinsics.checkNotNullParameter(it2, "it");
            SFMCSdkLogger.INSTANCE.mo3976d(this$0.getName(), new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$2$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "~~ " + config.getModuleIdentifier().name() + " Module Initialization Completed ~~";
                }
            });
            int i = WhenMappings.$EnumSwitchMapping$0[config.getModuleIdentifier().ordinal()];
            if (i == 1) {
                pushModuleInterface = (PushModuleInterface) it2;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                pushModuleInterface = (CdpModuleInterface) it2;
            }
            this$1.setModule(pushModuleInterface);
            listener.ready(it2);
            this$1.setInitializationState(InitializationState.READY);
            synchronized (this$1.getMODULE_INSTANCE_REQUESTS()) {
                for (final ModuleReadyHandler moduleReadyHandler : this$1.getMODULE_INSTANCE_REQUESTS()) {
                    try {
                        moduleReadyHandler.deliverModule(it2);
                    } catch (Exception e) {
                        SFMCSdkLogger.INSTANCE.mo3977e(PushModule.TAG, e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module$initModule$1$execute$2$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failure during module " + it2 + " delivery for " + moduleReadyHandler + '.';
                            }
                        });
                    }
                }
                this$1.getMODULE_INSTANCE_REQUESTS().clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void initModule(Context context, Config config, SFMCSdkComponents components, ModuleReadyListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            components.getExecutors().getDiskIO().execute(new C43271(config, context, components, listener, config.getModuleIdentifier().name() + "_init_thread", new Object[0]));
        } catch (Error e) {
            SFMCSdkLogger.INSTANCE.mo3979w(getName(), e, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module.initModule.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An error occurred while initializing module " + Module.this;
                }
            });
        } catch (Exception e2) {
            SFMCSdkLogger.INSTANCE.mo3979w(getName(), e2, new Function0<String>() { // from class: com.salesforce.marketingcloud.sfmcsdk.modules.Module.initModule.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An exception occurred while initializing module " + Module.this;
                }
            });
        }
    }
}
