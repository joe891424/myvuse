package com.bat.sdk.asav;

import android.content.Context;
import com.bat.sdk.asav.core.AsavLog;
import com.bat.sdk.asav.core.AsavLogKt;
import com.bat.sdk.asav.core.AsavSettings;
import com.bat.sdk.asav.core.AsavStatus;
import com.bat.sdk.asav.core.AsavTimer;
import com.bat.sdk.asav.core.IAsavContext;
import com.bat.sdk.asav.core.IAsavLogger;
import com.bat.sdk.asav.core.IAsavTimer;
import com.bat.sdk.asav.handlers.AsavChallengeHandler;
import com.bat.sdk.asav.request.AsavChallengeRequest;
import com.bat.sdk.asav.response.IAsavResultListener;
import com.bat.sdk.ble.BatAdvertiser;
import com.bat.sdk.ble.BatScanner;
import com.brentvatne.react.ReactVideoView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: AsavModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020$H\u0016J\"\u0010%\u001a\u00020\u001c2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'\"\u00020(H\u0096\u0001¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0096\u0001J\u0011\u0010-\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0096\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020,0/X\u0096\u0005R\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020,0/X\u0096\u0005¨\u00061"}, m5598d2 = {"Lcom/bat/sdk/asav/AsavModule;", "Lcom/bat/sdk/asav/core/IAsavContext;", "Lcom/bat/sdk/asav/core/IAsavLogger;", "context", "Landroid/content/Context;", "settings", "Lcom/bat/sdk/asav/core/AsavSettings;", "<init>", "(Landroid/content/Context;Lcom/bat/sdk/asav/core/AsavSettings;)V", "getContext", "()Landroid/content/Context;", "getSettings", "()Lcom/bat/sdk/asav/core/AsavSettings;", "batScanner", "Lcom/bat/sdk/ble/BatScanner;", "batAdvertiser", "Lcom/bat/sdk/ble/BatAdvertiser;", "currentStatus", "Lcom/bat/sdk/asav/core/AsavStatus;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "asavTimer", "Lcom/bat/sdk/asav/core/AsavTimer;", "getAsavTimer", "()Lcom/bat/sdk/asav/core/AsavTimer;", "asavTimer$delegate", "Lkotlin/Lazy;", "start", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bat/sdk/asav/response/IAsavResultListener;", BackgroundFetch.ACTION_STOP, "scanner", "advertiser", "status", "timer", "Lcom/bat/sdk/asav/core/IAsavTimer;", "console", "any", "", "", "([Ljava/lang/Object;)V", "debug", ReactVideoView.EVENT_PROP_WHAT, "", "log", "asavDebugLogFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "asavLogFlow", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavModule implements IAsavContext, IAsavLogger {
    private final /* synthetic */ AsavLog $$delegate_0;

    /* JADX INFO: renamed from: asavTimer$delegate, reason: from kotlin metadata */
    private final Lazy asavTimer;
    private final BatAdvertiser batAdvertiser;
    private final BatScanner batScanner;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private AsavStatus currentStatus;
    private final AsavSettings settings;

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void console(Object... any) {
        Intrinsics.checkNotNullParameter(any, "any");
        this.$$delegate_0.console(any);
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void debug(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.$$delegate_0.debug(what);
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public MutableStateFlow<String> getAsavDebugLogFlow() {
        return this.$$delegate_0.getAsavDebugLogFlow();
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public MutableStateFlow<String> getAsavLogFlow() {
        return this.$$delegate_0.getAsavLogFlow();
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void log(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        this.$$delegate_0.log(what);
    }

    public AsavModule(Context context, AsavSettings settings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.$$delegate_0 = AsavLogKt.getLogger();
        this.context = context;
        this.settings = settings;
        this.batScanner = new BatScanner(context);
        this.batAdvertiser = new BatAdvertiser(context);
        this.currentStatus = AsavStatus.Idle.INSTANCE;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
        this.asavTimer = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.asav.AsavModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsavModule.asavTimer_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public /* synthetic */ AsavModule(Context context, AsavSettings asavSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new AsavSettings(null, 1, null) : asavSettings);
    }

    public final AsavSettings getSettings() {
        return this.settings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsavTimer asavTimer_delegate$lambda$0(AsavModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new AsavTimer(this$0);
    }

    private final AsavTimer getAsavTimer() {
        return (AsavTimer) this.asavTimer.getValue();
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    public void start(IAsavResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        stop();
        getAsavTimer().attach(listener);
        getAsavTimer().ping();
        this.settings.init();
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C14871(listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.AsavModule$start$1 */
    /* JADX INFO: compiled from: AsavModule.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.AsavModule$start$1", m5608f = "AsavModule.kt", m5609i = {}, m5610l = {30}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IAsavResultListener $listener;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14871(IAsavResultListener iAsavResultListener, Continuation<? super C14871> continuation) {
            super(2, continuation);
            this.$listener = iAsavResultListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AsavModule.this.new C14871(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AsavChallengeHandler asavChallengeHandler = new AsavChallengeHandler(AsavModule.this);
                IAsavResultListener iAsavResultListener = this.$listener;
                AsavModule asavModule = AsavModule.this;
                asavChallengeHandler.withListener(iAsavResultListener);
                AsavChallengeRequest asavChallengeRequest = new AsavChallengeRequest(asavModule.getSettings().getChallengeRequestChannel());
                this.L$0 = asavChallengeHandler;
                this.label = 1;
                if (asavChallengeHandler.consume(asavChallengeRequest, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    public void stop() {
        getAsavTimer().clear();
        status(AsavStatus.Idle.INSTANCE);
        AsavLogKt.getLogger().log(getCurrentStatus().toString());
        JobKt__JobKt.cancelChildren$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    /* JADX INFO: renamed from: scanner, reason: from getter */
    public BatScanner getBatScanner() {
        return this.batScanner;
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    /* JADX INFO: renamed from: advertiser, reason: from getter */
    public BatAdvertiser getBatAdvertiser() {
        return this.batAdvertiser;
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    public AsavSettings settings() {
        return this.settings;
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    /* JADX INFO: renamed from: status, reason: from getter */
    public AsavStatus getCurrentStatus() {
        return this.currentStatus;
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    public void status(AsavStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.currentStatus = status;
    }

    @Override // com.bat.sdk.asav.core.IAsavContext
    public IAsavTimer timer() {
        return getAsavTimer();
    }
}
