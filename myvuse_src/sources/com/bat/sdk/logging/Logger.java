package com.bat.sdk.logging;

import com.bat.sdk.BatSdk;
import com.bat.sdk.domain.SdkLog;
import com.bat.sdk.persistence.repository.SdkLogRepository;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m5598d2 = {"Lcom/bat/sdk/logging/Logger;", "", "<init>", "()V", "logsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bat/sdk/domain/SdkLog;", "getLogsFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "repository", "Lcom/bat/sdk/persistence/repository/SdkLogRepository;", "getRepository", "()Lcom/bat/sdk/persistence/repository/SdkLogRepository;", "repository$delegate", "Lkotlin/Lazy;", "log", "", "message", "", HexAttribute.HEX_ATTR_CLASS_NAME, "getAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class Logger {
    public static final Logger INSTANCE = new Logger();
    private static final MutableSharedFlow<SdkLog> logsFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);

    /* JADX INFO: renamed from: repository$delegate, reason: from kotlin metadata */
    private static final Lazy repository = LazyKt.lazy(new Function0() { // from class: com.bat.sdk.logging.Logger$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Logger.repository_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.bat.sdk.logging.Logger$getAll$1 */
    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.logging.Logger", m5608f = "Logger.kt", m5609i = {}, m5610l = {50}, m5611m = "getAll", m5612n = {}, m5613s = {})
    static final class C15101 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C15101(Continuation<? super C15101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Logger.this.getAll(this);
        }
    }

    private Logger() {
    }

    public final MutableSharedFlow<SdkLog> getLogsFlow() {
        return logsFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SdkLogRepository getRepository() {
        return (SdkLogRepository) repository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SdkLogRepository repository_delegate$lambda$0() {
        return BatSdk.INSTANCE.getSdkLogsRepository();
    }

    public final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15111(new SdkLog(new Date(), message), null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.logging.Logger$log$1 */
    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.logging.Logger$log$1", m5608f = "Logger.kt", m5609i = {}, m5610l = {31, 32}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SdkLog $log;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15111(SdkLog sdkLog, Continuation<? super C15111> continuation) {
            super(2, continuation);
            this.$log = sdkLog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15111(this.$log, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SdkLogRepository repository = Logger.INSTANCE.getRepository();
                if (repository != null) {
                    this.label = 1;
                    if (repository.save(this.$log, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (Logger.INSTANCE.getLogsFlow().emit(this.$log, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void log(String className, String message) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15122(new SdkLog(new Date(), message), null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.logging.Logger$log$2 */
    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.logging.Logger$log$2", m5608f = "Logger.kt", m5609i = {}, m5610l = {44, 45}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SdkLog $log;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15122(SdkLog sdkLog, Continuation<? super C15122> continuation) {
            super(2, continuation);
            this.$log = sdkLog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15122(this.$log, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SdkLogRepository repository = Logger.INSTANCE.getRepository();
                if (repository != null) {
                    this.label = 1;
                    if (repository.save(this.$log, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (Logger.INSTANCE.getLogsFlow().emit(this.$log, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super java.util.List<com.bat.sdk.domain.SdkLog>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.bat.sdk.logging.Logger.C15101
            if (r0 == 0) goto L14
            r0 = r5
            com.bat.sdk.logging.Logger$getAll$1 r0 = (com.bat.sdk.logging.Logger.C15101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.bat.sdk.logging.Logger$getAll$1 r0 = new com.bat.sdk.logging.Logger$getAll$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            com.bat.sdk.persistence.repository.SdkLogRepository r5 = r4.getRepository()
            if (r5 == 0) goto L48
            r0.label = r3
            java.lang.Object r5 = r5.loadAll(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L4c
        L48:
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.logging.Logger.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object clear(Continuation<? super Unit> continuation) {
        SdkLogRepository repository2 = getRepository();
        if (repository2 == null) {
            return Unit.INSTANCE;
        }
        Object objClear = repository2.clear(continuation);
        return objClear == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objClear : Unit.INSTANCE;
    }
}
