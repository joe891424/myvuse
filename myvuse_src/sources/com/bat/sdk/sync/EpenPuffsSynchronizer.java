package com.bat.sdk.sync;

import androidx.exifinterface.media.ExifInterface;
import com.bat.sdk.FlowEvent;
import com.bat.sdk.client.epen.RecordsAvailableClient;
import com.bat.sdk.logging.Logger;
import com.facebook.soloader.Elf64_Ehdr;
import com.transistorsoft.tsbackgroundfetch.BackgroundFetch;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: EpenPuffsSynchronizer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m5597d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020!J\u0006\u0010*\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006+"}, m5598d2 = {"Lcom/bat/sdk/sync/EpenPuffsSynchronizer;", "", "recordsAvailableClient", "Lcom/bat/sdk/client/epen/RecordsAvailableClient;", "recordReader", "Lcom/bat/sdk/sync/EpenPuffReader;", "recordValidator", "Lcom/bat/sdk/sync/EPenPuffValidator;", "<init>", "(Lcom/bat/sdk/client/epen/RecordsAvailableClient;Lcom/bat/sdk/sync/EpenPuffReader;Lcom/bat/sdk/sync/EPenPuffValidator;)V", "syncJob", "Lkotlinx/coroutines/Job;", "progressJob", "readingDoneJob", "lastSavedRecordLoader", "Lkotlin/Function0;", "", "getLastSavedRecordLoader", "()Lkotlin/jvm/functions/Function0;", "setLastSavedRecordLoader", "(Lkotlin/jvm/functions/Function0;)V", "syncInProgressStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getSyncInProgressStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "syncCompleteEventFlow", "Lcom/bat/sdk/FlowEvent;", "", "getSyncCompleteEventFlow", "recordsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "", "getRecordsFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "totalRecordsStateFlow", "getTotalRecordsStateFlow", "currentRecordStateFlow", "getCurrentRecordStateFlow", "start", "deviceAddress", BackgroundFetch.ACTION_STOP, "sdk_release"}, m5599k = 1, m5600mv = {2, 0, 0}, m5602xi = 48)
public final class EpenPuffsSynchronizer {
    private final MutableStateFlow<Integer> currentRecordStateFlow;
    private Function0<Integer> lastSavedRecordLoader;
    private Job progressJob;
    private Job readingDoneJob;
    private final EpenPuffReader recordReader;
    private final EPenPuffValidator recordValidator;
    private final RecordsAvailableClient recordsAvailableClient;
    private final MutableSharedFlow<Pair<String, String>> recordsFlow;
    private final MutableStateFlow<FlowEvent<Unit>> syncCompleteEventFlow;
    private final MutableStateFlow<Boolean> syncInProgressStateFlow;
    private Job syncJob;
    private final MutableStateFlow<Integer> totalRecordsStateFlow;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int lastSavedRecordLoader$lambda$0() {
        return 0;
    }

    public EpenPuffsSynchronizer(RecordsAvailableClient recordsAvailableClient, EpenPuffReader recordReader, EPenPuffValidator recordValidator) {
        Intrinsics.checkNotNullParameter(recordsAvailableClient, "recordsAvailableClient");
        Intrinsics.checkNotNullParameter(recordReader, "recordReader");
        Intrinsics.checkNotNullParameter(recordValidator, "recordValidator");
        this.recordsAvailableClient = recordsAvailableClient;
        this.recordReader = recordReader;
        this.recordValidator = recordValidator;
        this.lastSavedRecordLoader = new Function0() { // from class: com.bat.sdk.sync.EpenPuffsSynchronizer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(EpenPuffsSynchronizer.lastSavedRecordLoader$lambda$0());
            }
        };
        this.syncInProgressStateFlow = StateFlowKt.MutableStateFlow(false);
        this.syncCompleteEventFlow = StateFlowKt.MutableStateFlow(null);
        this.recordsFlow = SharedFlowKt.MutableSharedFlow$default(4, 0, null, 6, null);
        this.totalRecordsStateFlow = StateFlowKt.MutableStateFlow(0);
        this.currentRecordStateFlow = StateFlowKt.MutableStateFlow(0);
    }

    public final Function0<Integer> getLastSavedRecordLoader() {
        return this.lastSavedRecordLoader;
    }

    public final void setLastSavedRecordLoader(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.lastSavedRecordLoader = function0;
    }

    public final MutableStateFlow<Boolean> getSyncInProgressStateFlow() {
        return this.syncInProgressStateFlow;
    }

    public final MutableStateFlow<FlowEvent<Unit>> getSyncCompleteEventFlow() {
        return this.syncCompleteEventFlow;
    }

    public final MutableSharedFlow<Pair<String, String>> getRecordsFlow() {
        return this.recordsFlow;
    }

    public final MutableStateFlow<Integer> getTotalRecordsStateFlow() {
        return this.totalRecordsStateFlow;
    }

    public final MutableStateFlow<Integer> getCurrentRecordStateFlow() {
        return this.currentRecordStateFlow;
    }

    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$1 */
    /* JADX INFO: compiled from: EpenPuffsSynchronizer.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffsSynchronizer$start$1", m5608f = "EpenPuffsSynchronizer.kt", m5609i = {}, m5610l = {32, 38}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceAddress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15811(String str, Continuation<? super C15811> continuation) {
            super(2, continuation);
            this.$deviceAddress = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EpenPuffsSynchronizer.this.new C15811(this.$deviceAddress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0045 -> B:11:0x0021). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005f -> B:20:0x0062). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 299
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.sync.EpenPuffsSynchronizer.C15811.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void start(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        Logger.INSTANCE.log("starting synchronizer");
        this.syncJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15811(deviceAddress, null), 3, null);
        this.progressJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15822(null), 3, null);
        this.readingDoneJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C15843(null), 3, null);
    }

    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$2 */
    /* JADX INFO: compiled from: EpenPuffsSynchronizer.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffsSynchronizer$start$2", m5608f = "EpenPuffsSynchronizer.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shstrndx}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15822 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15822(Continuation<? super C15822> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EpenPuffsSynchronizer.this.new C15822(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15822) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final MutableStateFlow<Boolean> readingInProgressStateFlow = EpenPuffsSynchronizer.this.recordReader.getReadingInProgressStateFlow();
                Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1

                    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2 */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                    public static final class C15832<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                        @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2", m5608f = "EpenPuffsSynchronizer.kt", m5609i = {}, m5610l = {223}, m5611m = "emit", m5612n = {}, m5613s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return C15832.this.emit(null, this);
                            }
                        }

                        public C15832(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1.C15832.AnonymousClass1
                                if (r0 == 0) goto L14
                                r0 = r6
                                com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1.C15832.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L14
                                int r6 = r0.label
                                int r6 = r6 - r2
                                r0.label = r6
                                goto L19
                            L14:
                                com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r6)
                            L19:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L32
                                if (r2 != r3) goto L2a
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4c
                            L2a:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L32:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r0
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r2 = r5
                                java.lang.Boolean r2 = (java.lang.Boolean) r2
                                boolean r2 = r2.booleanValue()
                                if (r2 == 0) goto L4c
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.sync.EpenPuffsSynchronizer$start$2$invokeSuspend$$inlined$filter$1.C15832.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Object objCollect = readingInProgressStateFlow.collect(new C15832(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final EpenPuffsSynchronizer epenPuffsSynchronizer = EpenPuffsSynchronizer.this;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.sync.EpenPuffsSynchronizer.start.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        Logger.INSTANCE.log("reading is in progress");
                        epenPuffsSynchronizer.getSyncInProgressStateFlow().setValue(Boxing.boxBoolean(true));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$3 */
    /* JADX INFO: compiled from: EpenPuffsSynchronizer.kt */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffsSynchronizer$start$3", m5608f = "EpenPuffsSynchronizer.kt", m5609i = {}, m5610l = {69}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C15843 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C15843(Continuation<? super C15843> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EpenPuffsSynchronizer.this.new C15843(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15843) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final MutableStateFlow<Boolean> readingInProgressStateFlow = EpenPuffsSynchronizer.this.recordReader.getReadingInProgressStateFlow();
                Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1

                    /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2 */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2"}, m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                    public static final class C15852<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(m5599k = 3, m5600mv = {2, 0, 0}, m5602xi = 48)
                        @DebugMetadata(m5607c = "com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2", m5608f = "EpenPuffsSynchronizer.kt", m5609i = {}, m5610l = {223}, m5611m = "emit", m5612n = {}, m5613s = {})
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return C15852.this.emit(null, this);
                            }
                        }

                        public C15852(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1.C15852.AnonymousClass1
                                if (r0 == 0) goto L14
                                r0 = r6
                                com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2$1 r0 = (com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1.C15852.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L14
                                int r6 = r0.label
                                int r6 = r6 - r2
                                r0.label = r6
                                goto L19
                            L14:
                                com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2$1 r0 = new com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1$2$1
                                r0.<init>(r6)
                            L19:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L32
                                if (r2 != r3) goto L2a
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4c
                            L2a:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L32:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r0
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r2 = r5
                                java.lang.Boolean r2 = (java.lang.Boolean) r2
                                boolean r2 = r2.booleanValue()
                                if (r2 != 0) goto L4c
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.bat.sdk.sync.EpenPuffsSynchronizer$start$3$invokeSuspend$$inlined$filterNot$1.C15852.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                        Object objCollect = readingInProgressStateFlow.collect(new C15852(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final EpenPuffsSynchronizer epenPuffsSynchronizer = EpenPuffsSynchronizer.this;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.bat.sdk.sync.EpenPuffsSynchronizer.start.3.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        Logger.INSTANCE.log("sync: reading stopped");
                        String string = epenPuffsSynchronizer.recordReader.getTotalBytes().toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        if (string.length() == 0) {
                            return Unit.INSTANCE;
                        }
                        int iIntValue = epenPuffsSynchronizer.getCurrentRecordStateFlow().getValue().intValue();
                        if (epenPuffsSynchronizer.recordValidator.validate(string)) {
                            Object objEmit = epenPuffsSynchronizer.getRecordsFlow().emit(TuplesKt.m5605to(iIntValue + ".csv", string), continuation);
                            return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                        }
                        Object objEmit2 = epenPuffsSynchronizer.getRecordsFlow().emit(TuplesKt.m5605to(iIntValue + ".csv", ""), continuation);
                        return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    public final void stop() {
        Logger.INSTANCE.log("stopping synchronizer");
        this.syncInProgressStateFlow.setValue(false);
        Job job = this.syncJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.syncJob = null;
        Job job2 = this.progressJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.progressJob = null;
        Job job3 = this.readingDoneJob;
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
        this.readingDoneJob = null;
    }
}
