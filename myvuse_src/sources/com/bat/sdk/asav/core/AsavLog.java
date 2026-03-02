package com.bat.sdk.asav.core;

import com.bat.sdk.asav.core.AsavLog;
import com.bat.sdk.logging.Logger;
import com.brentvatne.react.ReactVideoView;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AsavLog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J!\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m5598d2 = {"Lcom/bat/sdk/asav/core/AsavLog;", "Lcom/bat/sdk/asav/core/IAsavLogger;", "<init>", "()V", "asavLogFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAsavLogFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "asavDebugLogFlow", "getAsavDebugLogFlow", "dateFormat", "Ljava/text/SimpleDateFormat;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "asavConsoleFlow", "", "", "log", "", ReactVideoView.EVENT_PROP_WHAT, "debug", "console", "any", "([Ljava/lang/Object;)V", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class AsavLog implements IAsavLogger {
    private final MutableStateFlow<Object[]> asavConsoleFlow;
    private final CoroutineScope coroutineScope;
    private final MutableStateFlow<String> asavLogFlow = StateFlowKt.MutableStateFlow("");
    private final MutableStateFlow<String> asavDebugLogFlow = StateFlowKt.MutableStateFlow("");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault());

    public AsavLog() {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null)));
        this.coroutineScope = CoroutineScope;
        MutableStateFlow<Object[]> MutableStateFlow = StateFlowKt.MutableStateFlow(new Object[0]);
        this.asavConsoleFlow = MutableStateFlow;
        FlowKt.launchIn(FlowKt.onEach(MutableStateFlow, new C14881(null)), CoroutineScope);
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public MutableStateFlow<String> getAsavLogFlow() {
        return this.asavLogFlow;
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public MutableStateFlow<String> getAsavDebugLogFlow() {
        return this.asavDebugLogFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.asav.core.AsavLog$1 */
    /* JADX INFO: compiled from: AsavLog.kt */
    @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H\n"}, m5598d2 = {"<anonymous>", "", "any", "", ""}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.asav.core.AsavLog$1", m5608f = "AsavLog.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C14881 extends SuspendLambda implements Function2<Object[], Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C14881(Continuation<? super C14881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14881 c14881 = AsavLog.this.new C14881(continuation);
            c14881.L$0 = obj;
            return c14881;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object[] objArr, Continuation<? super Unit> continuation) {
            return ((C14881) create(objArr, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            if (!(objArr.length == 0)) {
                String string = objArr[0].toString();
                List mutableList = ArraysKt.toMutableList(objArr);
                AsavLog asavLog = AsavLog.this;
                mutableList.remove(string);
                Logger.INSTANCE.log(string, asavLog.dateFormat.format(new Date()) + SafeJsonPrimitive.NULL_CHAR + CollectionsKt.joinToString$default(mutableList, " ", null, null, 0, null, new Function1() { // from class: com.bat.sdk.asav.core.AsavLog$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AsavLog.C14881.invokeSuspend$lambda$1$lambda$0(obj2);
                    }
                }, 30, null));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$1$lambda$0(Object obj) {
            return obj.toString();
        }
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void log(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        getAsavLogFlow().setValue(this.dateFormat.format(new Date()) + " - " + what);
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void debug(String what) {
        Intrinsics.checkNotNullParameter(what, "what");
        getAsavDebugLogFlow().setValue(this.dateFormat.format(new Date()) + " - " + what);
    }

    @Override // com.bat.sdk.asav.core.IAsavLogger
    public void console(Object... any) {
        Intrinsics.checkNotNullParameter(any, "any");
        this.asavConsoleFlow.tryEmit(any);
    }
}
