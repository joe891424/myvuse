package com.yoti.mobile.mpp.mrtddump;

import androidx.core.app.NotificationCompat;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoGenerator;
import com.yoti.mobile.mpp.mrtddump.chipinfo.ChipInfoReader;
import com.yoti.mobile.mpp.mrtddump.commands.CommandBuilder;
import com.yoti.mobile.mpp.mrtddump.commands.CommandGeneratorFactory;
import com.yoti.mobile.mpp.mrtddump.p095io.NfcController;
import com.yoti.mobile.mpp.mrtddump.p096j.C5118b;
import com.yoti.mobile.mpp.mrtddump.p096j.C5119c;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileReader;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdFileType;
import com.yoti.mobile.mpp.mrtddump.reader.MrtdReaderWorker;
import com.yoti.mobile.mpp.mrtddump.session.MessagingSession;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ6\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007JN\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00180\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00180\u001f2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001fH\u0007JV\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00180\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00180\u001f2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%H\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m5598d2 = {"Lcom/yoti/mobile/mpp/mrtddump/MrtdReader;", "", "nfcController", "Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;", "(Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;)V", "commandGenerator", "Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;", "sessionFactory", "Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession$Factory;", "workerFactory", "Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdReaderWorker$Factory;", "(Lcom/yoti/mobile/mpp/mrtddump/io/NfcController;Lcom/yoti/mobile/mpp/mrtddump/commands/CommandGeneratorFactory;Lcom/yoti/mobile/mpp/mrtddump/session/MessagingSession$Factory;Lcom/yoti/mobile/mpp/mrtddump/reader/MrtdReaderWorker$Factory;)V", "attemptedRead", "", "readJob", "Lkotlinx/coroutines/Job;", "calculateProgressPercent", "", "completePartsSize", "totalPartsSize", "currentPartProgress", "currentPartEstimatedSize", "currentPartActualSize", "cancelRead", "", "read", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", "readerConfig", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderConfig;", "successCallback", "Lkotlin/Function1;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderResult;", "failCallback", "Lcom/yoti/mobile/mpp/mrtddump/MrtdException;", "progressCallback", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mrtddump_release"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReader {
    private boolean attemptedRead;
    private final CommandGeneratorFactory commandGenerator;
    private final NfcController nfcController;
    private Job readJob;
    private final MessagingSession.a sessionFactory;
    private final MrtdReaderWorker.a workerFactory;

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$a */
    @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.MrtdReader$read$1", m5608f = "MrtdReader.kt", m5609i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, m5610l = {91, 92, 94, 97, 109, 128}, m5611m = "invokeSuspend", m5612n = {"$this$channelFlow", "result", "filesToRead", "worker", "estimatedSizeSum", "estimatedTotalSize", "$this$channelFlow", "result", "filesToRead", "worker", "estimatedSizeSum", "chipInfo", "estimatedTotalSize", "$this$channelFlow", "result", "filesToRead", "worker", "estimatedSizeSum", "chipInfo", "estimatedTotalSize", "$this$channelFlow", "result", "filesToRead", "worker", "estimatedSizeSum", "chipInfo", "session", "estimatedTotalSize", "$this$channelFlow", "result", "worker", "estimatedSizeSum", "chipInfo", "session", "file", "estimatedTotalSize"}, m5613s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$8", "I$0"})
    static final class C5071a extends SuspendLambda implements Function2<ProducerScope<? super MrtdReaderEvent>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        Object f7927a;

        /* JADX INFO: renamed from: b */
        Object f7928b;

        /* JADX INFO: renamed from: c */
        Object f7929c;

        /* JADX INFO: renamed from: d */
        Object f7930d;

        /* JADX INFO: renamed from: e */
        Object f7931e;

        /* JADX INFO: renamed from: f */
        Object f7932f;

        /* JADX INFO: renamed from: g */
        Object f7933g;

        /* JADX INFO: renamed from: h */
        Object f7934h;

        /* JADX INFO: renamed from: i */
        int f7935i;

        /* JADX INFO: renamed from: j */
        int f7936j;

        /* JADX INFO: renamed from: k */
        private /* synthetic */ Object f7937k;

        /* JADX INFO: renamed from: m */
        final /* synthetic */ MrtdReaderConfig f7939m;

        /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$a$a */
        @Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "", "bytesRead", "", "totalBytes"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.MrtdReader$read$1$1$fileData$1", m5608f = "MrtdReader.kt", m5609i = {}, m5610l = {OTUIDisplayReasonCode.UIShownCode.BANNER_SHOWN_SHOW_BANNER_CALLED}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class a extends SuspendLambda implements Function3<Integer, Integer, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a */
            int f7940a;

            /* JADX INFO: renamed from: b */
            /* synthetic */ int f7941b;

            /* JADX INFO: renamed from: c */
            /* synthetic */ int f7942c;

            /* JADX INFO: renamed from: d */
            final /* synthetic */ ProducerScope<MrtdReaderEvent> f7943d;

            /* JADX INFO: renamed from: e */
            final /* synthetic */ MrtdReader f7944e;

            /* JADX INFO: renamed from: f */
            final /* synthetic */ Ref.IntRef f7945f;

            /* JADX INFO: renamed from: g */
            final /* synthetic */ int f7946g;

            /* JADX INFO: renamed from: h */
            final /* synthetic */ MrtdFileType f7947h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(ProducerScope<? super MrtdReaderEvent> producerScope, MrtdReader mrtdReader, Ref.IntRef intRef, int i, MrtdFileType mrtdFileType, Continuation<? super a> continuation) {
                super(3, continuation);
                this.f7943d = producerScope;
                this.f7944e = mrtdReader;
                this.f7945f = intRef;
                this.f7946g = i;
                this.f7947h = mrtdFileType;
            }

            /* JADX INFO: renamed from: a */
            public final Object m5376a(int i, int i2, Continuation<? super Unit> continuation) {
                a aVar = new a(this.f7943d, this.f7944e, this.f7945f, this.f7946g, this.f7947h, continuation);
                aVar.f7941b = i;
                aVar.f7942c = i2;
                return aVar.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Integer num2, Continuation<? super Unit> continuation) {
                return m5376a(num.intValue(), num2.intValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f7940a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i2 = this.f7941b;
                    int i3 = this.f7942c;
                    ProducerScope<MrtdReaderEvent> producerScope = this.f7943d;
                    ReadProgressEvent readProgressEvent = new ReadProgressEvent(this.f7944e.calculateProgressPercent(this.f7945f.element, this.f7946g, i2, this.f7947h.getEstimatedLength(), i3));
                    this.f7940a = 1;
                    if (producerScope.send(readProgressEvent, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5071a(MrtdReaderConfig mrtdReaderConfig, Continuation<? super C5071a> continuation) {
            super(2, continuation);
            this.f7939m = mrtdReaderConfig;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super MrtdReaderEvent> producerScope, Continuation<? super Unit> continuation) {
            return ((C5071a) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C5071a c5071a = MrtdReader.this.new C5071a(this.f7939m, continuation);
            c5071a.f7937k = obj;
            return c5071a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01a1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x01a2  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01bf A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01fd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0282  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x026b -> B:46:0x0272). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws com.yoti.mobile.mpp.mrtddump.MrtdCommunicationException {
            /*
                Method dump skipped, instruction units count: 714
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.mpp.mrtddump.MrtdReader.C5071a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$b */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", RsaJsonWebKey.EXPONENT_MEMBER_NAME, ""}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.MrtdReader$read$2", m5608f = "MrtdReader.kt", m5609i = {}, m5610l = {140}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C5072b extends SuspendLambda implements Function3<FlowCollector<? super MrtdReaderEvent>, Throwable, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f7948a;

        /* JADX INFO: renamed from: b */
        private /* synthetic */ Object f7949b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f7950c;

        C5072b(Continuation<? super C5072b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super MrtdReaderEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C5072b c5072b = new C5072b(continuation);
            c5072b.f7949b = flowCollector;
            c5072b.f7950c = th;
            return c5072b.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7948a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.f7949b;
                Throwable th = (Throwable) this.f7950c;
                if (JobKt.isActive(get$context())) {
                    if (!(th instanceof MrtdException)) {
                        throw th;
                    }
                    ReadError readError = new ReadError((MrtdException) th);
                    this.f7949b = null;
                    this.f7948a = 1;
                    if (flowCollector.emit(readError, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$c */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", "it", ""}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.MrtdReader$read$3", m5608f = "MrtdReader.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C5073c extends SuspendLambda implements Function3<FlowCollector<? super MrtdReaderEvent>, Throwable, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f7951a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ MrtdReaderConfig f7952b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ MrtdReader f7953c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5073c(MrtdReaderConfig mrtdReaderConfig, MrtdReader mrtdReader, Continuation<? super C5073c> continuation) {
            super(3, continuation);
            this.f7952b = mrtdReaderConfig;
            this.f7953c = mrtdReader;
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super MrtdReaderEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new C5073c(this.f7952b, this.f7953c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7951a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!this.f7952b.getReusable() || !JobKt.isActive(get$context())) {
                this.f7953c.cancelRead();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$d */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.mpp.mrtddump.MrtdReader$read$4", m5608f = "MrtdReader.kt", m5609i = {}, m5610l = {193}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C5074d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f7954a;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ MrtdReaderConfig f7956c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ Function1<Integer, Unit> f7957d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ Function1<MrtdReaderResult, Unit> f7958e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ Function1<MrtdException, Unit> f7959f;

        /* JADX INFO: renamed from: com.yoti.mobile.mpp.mrtddump.MrtdReader$d$a */
        @Metadata(m5597d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m5598d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;", "emit", "(Lcom/yoti/mobile/mpp/mrtddump/MrtdReaderEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        static final class a<T> implements FlowCollector, SuspendFunction {

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Function1<Integer, Unit> f7960a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Function1<MrtdReaderResult, Unit> f7961b;

            /* JADX INFO: renamed from: c */
            final /* synthetic */ Function1<MrtdException, Unit> f7962c;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super Integer, Unit> function1, Function1<? super MrtdReaderResult, Unit> function12, Function1<? super MrtdException, Unit> function13) {
                this.f7960a = function1;
                this.f7961b = function12;
                this.f7962c = function13;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(MrtdReaderEvent mrtdReaderEvent, Continuation<? super Unit> continuation) {
                Unit unitInvoke;
                Unit unit;
                if (mrtdReaderEvent instanceof ReadProgressEvent) {
                    Function1<Integer, Unit> function1 = this.f7960a;
                    if (function1 == null) {
                        unit = null;
                    } else {
                        function1.invoke(Boxing.boxInt(((ReadProgressEvent) mrtdReaderEvent).getProgressPercentage()));
                        unit = Unit.INSTANCE;
                    }
                    if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return unit;
                    }
                } else if (mrtdReaderEvent instanceof ReadComplete) {
                    Unit unitInvoke2 = this.f7961b.invoke(((ReadComplete) mrtdReaderEvent).getResult());
                    if (unitInvoke2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return unitInvoke2;
                    }
                } else if ((mrtdReaderEvent instanceof ReadError) && (unitInvoke = this.f7962c.invoke(((ReadError) mrtdReaderEvent).getError())) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return unitInvoke;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C5074d(MrtdReaderConfig mrtdReaderConfig, Function1<? super Integer, Unit> function1, Function1<? super MrtdReaderResult, Unit> function12, Function1<? super MrtdException, Unit> function13, Continuation<? super C5074d> continuation) {
            super(2, continuation);
            this.f7956c = mrtdReaderConfig;
            this.f7957d = function1;
            this.f7958e = function12;
            this.f7959f = function13;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C5074d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MrtdReader.this.new C5074d(this.f7956c, this.f7957d, this.f7958e, this.f7959f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7954a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<MrtdReaderEvent> flow = MrtdReader.this.read(this.f7956c);
                a aVar = new a(this.f7957d, this.f7958e, this.f7959f);
                this.f7954a = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MrtdReader(NfcController nfcController) {
        this(nfcController, new CommandGeneratorFactory(), null, null, 12, null);
        Intrinsics.checkNotNullParameter(nfcController, "nfcController");
    }

    private MrtdReader(NfcController nfcController, CommandGeneratorFactory commandGeneratorFactory, MessagingSession.a aVar, MrtdReaderWorker.a aVar2) {
        this.nfcController = nfcController;
        this.commandGenerator = commandGeneratorFactory;
        this.sessionFactory = aVar;
        this.workerFactory = aVar2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* synthetic */ MrtdReader(NfcController nfcController, CommandGeneratorFactory commandGeneratorFactory, MessagingSession.a aVar, MrtdReaderWorker.a aVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        aVar = (i & 4) != 0 ? new MessagingSession.a(new CommandBuilder()) : aVar;
        this(nfcController, commandGeneratorFactory, aVar, (i & 8) != 0 ? new MrtdReaderWorker.a(commandGeneratorFactory, aVar, new ChipInfoReader(new ChipInfoGenerator(), new MrtdFileReader.a()), new MrtdFileReader.a()) : aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateProgressPercent(int completePartsSize, int totalPartsSize, int currentPartProgress, int currentPartEstimatedSize, int currentPartActualSize) {
        return ((completePartsSize * 100) / totalPartsSize) + ((currentPartProgress * ((currentPartEstimatedSize * 100) / totalPartsSize)) / currentPartActualSize);
    }

    static /* synthetic */ int calculateProgressPercent$default(MrtdReader mrtdReader, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i3 = 0;
        }
        return mrtdReader.calculateProgressPercent(i, i2, i3, (i6 & 8) != 0 ? 1 : i4, (i6 & 16) != 0 ? 1 : i5);
    }

    public final void cancelRead() {
        Job job = this.readJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        try {
            this.nfcController.closeConnection();
        } catch (MrtdCommunicationException e) {
            C5119c.m5538d("MrtdReader", "Error closing tag", e);
        }
    }

    public final Flow<MrtdReaderEvent> read(MrtdReaderConfig readerConfig) {
        Intrinsics.checkNotNullParameter(readerConfig, "readerConfig");
        return FlowKt.onCompletion(FlowKt.m8766catch(FlowKt.channelFlow(new C5071a(readerConfig, null)), new C5072b(null)), new C5073c(readerConfig, this, null));
    }

    public final void read(MrtdReaderConfig readerConfig, Function1<? super MrtdReaderResult, Unit> successCallback, Function1<? super MrtdException, Unit> failCallback, Function1<? super Integer, Unit> progressCallback) {
        Intrinsics.checkNotNullParameter(readerConfig, "readerConfig");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "failCallback");
        read(readerConfig, successCallback, failCallback, progressCallback, CoroutineScopeKt.CoroutineScope(C5118b.m5529b()));
    }

    public final void read(MrtdReaderConfig readerConfig, Function1<? super MrtdReaderResult, Unit> successCallback, Function1<? super MrtdException, Unit> failCallback, Function1<? super Integer, Unit> progressCallback, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(readerConfig, "readerConfig");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failCallback, "failCallback");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Job job = this.readJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.readJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C5074d(readerConfig, progressCallback, successCallback, failCallback, null), 3, null);
    }
}
