package com.yoti.mobile.android.mrtd.data;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.soloader.Elf64_Ehdr;
import com.yoti.mobile.android.mrtd.domain.INfcReadController;
import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import com.yoti.mobile.android.mrtd.domain.model.StateReadFailed;
import com.yoti.mobile.android.mrtd.domain.model.StateReadingProgress;
import com.yoti.mobile.mpp.mrtddump.LogLevel;
import com.yoti.mobile.mpp.mrtddump.MrtdReader;
import com.yoti.mobile.mpp.mrtddump.MrtdReaderConfig;
import com.yoti.mobile.mpp.mrtddump.MrtdReaderEvent;
import com.yoti.mobile.mpp.mrtddump.auth.MrtdAuthentication;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileType;
import com.yoti.mobile.mpp.smartcard.ISO7816Kt;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes4.dex */
@Singleton
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/data/NfcPlatformController;", "Lcom/yoti/mobile/android/mrtd/domain/INfcReadController;", "nfcAuthentication", "Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;", "readerProducer", "Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer;", "eventMapper", "Lcom/yoti/mobile/android/mrtd/data/NfcEventMapper;", "(Lcom/yoti/mobile/mpp/mrtddump/auth/MrtdAuthentication;Lcom/yoti/mobile/android/mrtd/data/MrtdReaderProducer;Lcom/yoti/mobile/android/mrtd/data/NfcEventMapper;)V", "readConfig", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "getReaderListener", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "registerForReadBroadcasts", "", "unregisterForReadBroadcasts", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class NfcPlatformController implements INfcReadController {
    private final NfcEventMapper eventMapper;
    private final MrtdAuthentication nfcAuthentication;
    private final MrtdReaderConfig readConfig;
    private final MrtdReaderProducer readerProducer;

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1 */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1", m5608f = "NfcPlatformController.kt", m5609i = {0, 1, 1, 2, 2, 2}, m5610l = {50, 57, Elf64_Ehdr.e_shentsize}, m5611m = "invokeSuspend", m5612n = {"$this$channelFlow", "$this$channelFlow", "ignoreConnectionError", "$this$channelFlow", "ignoreConnectionError", "reader"}, m5613s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C49021 extends SuspendLambda implements Function2<ProducerScope<? super MrtdReadState>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1, reason: invalid class name */
        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1", m5608f = "NfcPlatformController.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shstrndx}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<MrtdReadState> $$this$channelFlow;
            final /* synthetic */ Ref.BooleanRef $ignoreConnectionError;
            final /* synthetic */ MrtdReader $reader;
            int label;
            final /* synthetic */ NfcPlatformController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(MrtdReader mrtdReader, NfcPlatformController nfcPlatformController, Ref.BooleanRef booleanRef, ProducerScope<? super MrtdReadState> producerScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$reader = mrtdReader;
                this.this$0 = nfcPlatformController;
                this.$ignoreConnectionError = booleanRef;
                this.$$this$channelFlow = producerScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$reader, this.this$0, this.$ignoreConnectionError, this.$$this$channelFlow, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final Flow<MrtdReaderEvent> flow = this.$reader.read(this.this$0.readConfig);
                    final NfcEventMapper nfcEventMapper = this.this$0.eventMapper;
                    Flow<MrtdReadState> flow2 = new Flow<MrtdReadState>() { // from class: com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1

                        /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                        @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m5598d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ NfcEventMapper $receiver$inlined;
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                            @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                            @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2", m5608f = "NfcPlatformController.kt", m5609i = {}, m5610l = {ISO7816Kt.INS_CREATE_FILE, ISO7816Kt.INS_CREATE_FILE}, m5611m = "emit", m5612n = {}, m5613s = {})
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                Object L$0;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector, NfcEventMapper nfcEventMapper) {
                                this.$this_unsafeFlow = flowCollector;
                                this.$receiver$inlined = nfcEventMapper;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                                /*
                                    r6 = this;
                                    boolean r0 = r8 instanceof com.yoti.mobile.android.mrtd.data.C4903xbae9b873.AnonymousClass2.AnonymousClass1
                                    if (r0 == 0) goto L13
                                    r0 = r8
                                    com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.yoti.mobile.android.mrtd.data.C4903xbae9b873.AnonymousClass2.AnonymousClass1) r0
                                    int r1 = r0.label
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.label = r1
                                    goto L18
                                L13:
                                    com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1$invokeSuspend$$inlined$map$1$2$1
                                    r0.<init>(r8)
                                L18:
                                    java.lang.Object r8 = r0.result
                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r2 = r0.label
                                    r3 = 2
                                    r4 = 1
                                    if (r2 == 0) goto L3c
                                    if (r2 == r4) goto L34
                                    if (r2 != r3) goto L2c
                                    kotlin.ResultKt.throwOnFailure(r8)
                                    goto L5f
                                L2c:
                                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                    r7.<init>(r8)
                                    throw r7
                                L34:
                                    java.lang.Object r7 = r0.L$0
                                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                                    kotlin.ResultKt.throwOnFailure(r8)
                                    goto L53
                                L3c:
                                    kotlin.ResultKt.throwOnFailure(r8)
                                    kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                                    com.yoti.mobile.mpp.mrtddump.MrtdReaderEvent r7 = (com.yoti.mobile.mpp.mrtddump.MrtdReaderEvent) r7
                                    com.yoti.mobile.android.mrtd.data.NfcEventMapper r2 = r6.$receiver$inlined
                                    r0.L$0 = r8
                                    r0.label = r4
                                    java.lang.Object r7 = r2.mapSuspendable(r7, r0)
                                    if (r7 != r1) goto L50
                                    return r1
                                L50:
                                    r5 = r8
                                    r8 = r7
                                    r7 = r5
                                L53:
                                    r2 = 0
                                    r0.L$0 = r2
                                    r0.label = r3
                                    java.lang.Object r7 = r7.emit(r8, r0)
                                    if (r7 != r1) goto L5f
                                    return r1
                                L5f:
                                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                    return r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.mrtd.data.C4903xbae9b873.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super MrtdReadState> flowCollector, Continuation continuation) {
                            Object objCollect = flow.collect(new AnonymousClass2(flowCollector, nfcEventMapper), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    };
                    final Ref.BooleanRef booleanRef = this.$ignoreConnectionError;
                    final ProducerScope<MrtdReadState> producerScope = this.$$this$channelFlow;
                    FlowCollector<? super MrtdReadState> flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.mrtd.data.NfcPlatformController.getReaderListener.1.1.2
                        public final Object emit(MrtdReadState mrtdReadState, Continuation<? super Unit> continuation) {
                            if (mrtdReadState instanceof StateReadFailed) {
                                if (booleanRef.element) {
                                    return Unit.INSTANCE;
                                }
                            } else if (mrtdReadState instanceof StateReadingProgress) {
                                booleanRef.element = false;
                            }
                            Object objSend = producerScope.send(mrtdReadState, continuation);
                            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((MrtdReadState) obj2, (Continuation<? super Unit>) continuation);
                        }
                    };
                    this.label = 1;
                    if (flow2.collect(flowCollector, this) == coroutine_suspended) {
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

        C49021(Continuation<? super C49021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C49021 c49021 = NfcPlatformController.this.new C49021(continuation);
            c49021.L$0 = obj;
            return c49021;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super MrtdReadState> producerScope, Continuation<? super Unit> continuation) {
            return ((C49021) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b4  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009e -> B:8:0x0020). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L43
                if (r1 == r4) goto L3b
                if (r1 == r3) goto L2d
                if (r1 != r2) goto L25
                java.lang.Object r1 = r13.L$2
                com.yoti.mobile.mpp.mrtddump.MrtdReader r1 = (com.yoti.mobile.mpp.mrtddump.MrtdReader) r1
                java.lang.Object r4 = r13.L$1
                kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
                java.lang.Object r5 = r13.L$0
                kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
                kotlin.ResultKt.throwOnFailure(r14)
            L20:
                r7 = r1
                r9 = r4
                r1 = r5
                goto La1
            L25:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L2d:
                java.lang.Object r1 = r13.L$1
                kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
                java.lang.Object r4 = r13.L$0
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.ResultKt.throwOnFailure(r14)
                r5 = r4
                r4 = r1
                goto L8d
            L3b:
                java.lang.Object r1 = r13.L$0
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L58
            L43:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                r1 = r14
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                com.yoti.mobile.android.mrtd.domain.model.StateWaitingForChip r14 = com.yoti.mobile.android.mrtd.domain.model.StateWaitingForChip.INSTANCE
                r13.L$0 = r1
                r13.label = r4
                java.lang.Object r14 = r1.send(r14, r13)
                if (r14 != r0) goto L58
                return r0
            L58:
                kotlin.coroutines.CoroutineContext r14 = r1.getCoroutineContext()
                boolean r14 = kotlinx.coroutines.JobKt.isActive(r14)
                if (r14 == 0) goto Lb4
                kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
                r14.<init>()
                com.yoti.mobile.android.mrtd.data.NfcPlatformController r4 = com.yoti.mobile.android.mrtd.data.NfcPlatformController.this
                com.yoti.mobile.android.mrtd.data.MrtdReaderProducer r4 = com.yoti.mobile.android.mrtd.data.NfcPlatformController.access$getReaderProducer$p(r4)
                boolean r4 = r4.getReaderAvailable()
                r14.element = r4
                com.yoti.mobile.android.mrtd.data.NfcPlatformController r4 = com.yoti.mobile.android.mrtd.data.NfcPlatformController.this
                com.yoti.mobile.android.mrtd.data.MrtdReaderProducer r4 = com.yoti.mobile.android.mrtd.data.NfcPlatformController.access$getReaderProducer$p(r4)
                r13.L$0 = r1
                r13.L$1 = r14
                r5 = 0
                r13.L$2 = r5
                r13.label = r3
                java.lang.Object r4 = r4.getReader(r13)
                if (r4 != r0) goto L89
                return r0
            L89:
                r5 = r1
                r12 = r4
                r4 = r14
                r14 = r12
            L8d:
                r1 = r14
                com.yoti.mobile.mpp.mrtddump.MrtdReader r1 = (com.yoti.mobile.mpp.mrtddump.MrtdReader) r1
                com.yoti.mobile.android.mrtd.domain.model.StateChipFound r14 = com.yoti.mobile.android.mrtd.domain.model.StateChipFound.INSTANCE
                r13.L$0 = r5
                r13.L$1 = r4
                r13.L$2 = r1
                r13.label = r2
                java.lang.Object r14 = r5.send(r14, r13)
                if (r14 != r0) goto L20
                return r0
            La1:
                com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1 r14 = new com.yoti.mobile.android.mrtd.data.NfcPlatformController$getReaderListener$1$1
                com.yoti.mobile.android.mrtd.data.NfcPlatformController r8 = com.yoti.mobile.android.mrtd.data.NfcPlatformController.this
                r11 = 0
                r6 = r14
                r10 = r1
                r6.<init>(r7, r8, r9, r10, r11)
                r10 = 3
                r7 = 0
                r8 = 0
                r6 = r1
                r9 = r14
                kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
                goto L58
            Lb4:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.mrtd.data.NfcPlatformController.C49021.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Inject
    public NfcPlatformController(MrtdAuthentication nfcAuthentication, MrtdReaderProducer readerProducer, NfcEventMapper eventMapper) {
        Intrinsics.checkNotNullParameter(nfcAuthentication, "nfcAuthentication");
        Intrinsics.checkNotNullParameter(readerProducer, "readerProducer");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.nfcAuthentication = nfcAuthentication;
        this.readerProducer = readerProducer;
        this.eventMapper = eventMapper;
        MrtdReaderConfig.Builder builder = new MrtdReaderConfig.Builder();
        builder.setAuthentication(nfcAuthentication);
        builder.setRequiredFiles(CollectionsKt.listOf((Object[]) new MrtdFileType[]{MrtdFileType.DG1, MrtdFileType.DG2, MrtdFileType.SOD}));
        builder.setLogLevel(LogLevel.NONE);
        builder.setReusable(false);
        builder.setReadTimeoutMs(15000L);
        this.readConfig = builder.build();
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcReadController
    public Flow<MrtdReadState> getReaderListener() {
        return FlowKt.channelFlow(new C49021(null));
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcReadController
    public void registerForReadBroadcasts() {
        this.readerProducer.startReceiving();
    }

    @Override // com.yoti.mobile.android.mrtd.domain.INfcReadController
    public void unregisterForReadBroadcasts() {
        this.readerProducer.stopReceiving();
    }
}
