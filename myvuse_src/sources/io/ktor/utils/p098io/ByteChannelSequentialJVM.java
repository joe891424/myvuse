package io.ktor.utils.p098io;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.brentvatne.react.ReactVideoViewManager;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.salesforce.marketingcloud.storage.p047db.C4352k;
import io.ktor.utils.p098io.bits.Memory;
import io.ktor.utils.p098io.core.ByteBuffersKt;
import io.ktor.utils.p098io.core.BytePacketBuilder;
import io.ktor.utils.p098io.core.ByteReadPacket;
import io.ktor.utils.p098io.core.ExperimentalIoApi;
import io.ktor.utils.p098io.core.IoBuffer;
import io.ktor.utils.p098io.core.OutputArraysJVMKt;
import io.ktor.utils.p098io.core.StringsKt;
import io.ktor.utils.p098io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@ExperimentalIoApi
@Metadata(m5597d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0011\u0010\f\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJM\u0010\u000e\u001a\u00020\n2:\u0010\u000f\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0010j\u0002`\u0016H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u0002H\u00190\u001a¢\u0006\u0002\b\u001cH\u0016¢\u0006\u0002\u0010\u001dJ@\u0010\u001e\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u00192'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190 \u0012\u0006\u0012\u0004\u0018\u00010!0\u0010¢\u0006\u0002\b\u001cH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J-\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J$\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020$2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u001aH\u0016J\u0019\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u0010,\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J!\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010.\u001a\u00020$H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u0011H\u0002J-\u00103\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u00104\u001a\u00020$2\u0006\u00102\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J$\u00104\u001a\u00020$2\u0006\u0010#\u001a\u00020$2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u001aH\u0016J\u0019\u00105\u001a\u00020$2\u0006\u00102\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u00106\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u00107\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J%\u00108\u001a\u00020\n2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u001aH\u0096@ø\u0001\u0000¢\u0006\u0002\u00109R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, m5598d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM;", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "initial", "Lio/ktor/utils/io/core/IoBuffer;", "autoFlush", "", "(Lio/ktor/utils/io/core/IoBuffer;Z)V", "attachedJob", "Lkotlinx/coroutines/Job;", "attachJob", "", "job", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeEachBufferRange", "visitor", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "last", "Lio/ktor/utils/io/ConsumeEachBufferVisitor;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "read", "min", "", "consumer", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", C4352k.a.f5652f, "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readAvailableSuspend", "readFully", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReadAvailable", "tryWriteAvailable", ReactVideoViewManager.PROP_SRC, "write", "writeAvailable", "writeAvailableSuspend", "writeFully", "writeFullySuspend", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {
    private volatile Job attachedJob;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$consumeEachBufferRange$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0, 0, 0}, m5610l = {162}, m5611m = "consumeEachBufferRange", m5612n = {"this", "visitor", "readable", "invokedWithLast"}, m5613s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C52981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C52981(Continuation<? super C52981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.consumeEachBufferRange(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$read$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0, 0}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED}, m5611m = "read", m5612n = {"this", "consumer", "min"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C52991 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52991(Continuation<? super C52991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.read(0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0}, m5610l = {108, 109}, m5611m = "readAvailableSuspend", m5612n = {"this", C4352k.a.f5652f}, m5613s = {"L$0", "L$1"})
    static final class C53001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53001(Continuation<? super C53001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.readAvailableSuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0, 0}, m5610l = {124}, m5611m = "readFullySuspend", m5612n = {"this", C4352k.a.f5652f, NewHtcHomeBadger.COUNT}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C53011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53011(Continuation<? super C53011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.readFullySuspend((ByteBuffer) null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$write$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0, 0}, m5610l = {246}, m5611m = "write", m5612n = {"this", "block", "min"}, m5613s = {"L$0", "L$1", "I$0"})
    static final class C53021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53021(Continuation<? super C53021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.write(0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0}, m5610l = {38, 39}, m5611m = "writeAvailableSuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C53031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53031(Continuation<? super C53031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeAvailableSuspend((ByteBuffer) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m5611m = "writeFullySuspend", m5612n = {"this", ReactVideoViewManager.PROP_SRC}, m5613s = {"L$0", "L$1"})
    static final class C53041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C53041(Continuation<? super C53041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeFullySuspend(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 */
    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5599k = 3, m5600mv = {1, 5, 1}, m5602xi = 48)
    @DebugMetadata(m5607c = "io.ktor.utils.io.ByteChannelSequentialJVM", m5608f = "ByteChannelSequentialJVM.kt", m5609i = {0, 0, 0}, m5610l = {258}, m5611m = "writeWhile", m5612n = {"this", "block", "shouldContinue"}, m5613s = {"L$0", "L$1", "L$2"})
    static final class C53051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C53051(Continuation<? super C53051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeWhile(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM(IoBuffer initial, boolean z) {
        super(initial, z, null, 4, null);
        Intrinsics.checkNotNullParameter(initial, "initial");
    }

    @Override // io.ktor.utils.p098io.ByteChannel
    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialJVM.attachJob.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ByteChannelSequentialJVM.this.attachedJob = null;
                if (th != null) {
                    ByteChannelSequentialJVM.this.cancel(th);
                }
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryWriteAvailable = tryWriteAvailable(byteBuffer);
        if (iTryWriteAvailable <= 0) {
            if (byteBuffer.hasRemaining()) {
                return writeAvailableSuspend(byteBuffer, continuation);
            }
            iTryWriteAvailable = 0;
        }
        return Boxing.boxInt(iTryWriteAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialJVM.C53031
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM.C53031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.p098io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable(r6, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.writeAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) throws Throwable {
        Object objWriteFullySuspend;
        tryWriteAvailable(byteBuffer);
        return (byteBuffer.hasRemaining() && (objWriteFullySuspend = writeFullySuspend(byteBuffer, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWriteFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.p098io.ByteChannelSequentialJVM.C53041
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM.C53041) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.p098io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L3e:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L59
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            int r6 = r2.tryWriteAvailable(r5)
            r2.afterWrite(r6)
            goto L3e
        L59:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int tryWriteAvailable(ByteBuffer src) throws Throwable {
        int iRemaining = src.remaining();
        int availableForWrite = getAvailableForWrite();
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (iRemaining != 0) {
            if (iRemaining <= availableForWrite) {
                OutputArraysJVMKt.writeFully(getWritable(), src);
                return iRemaining;
            }
            if (availableForWrite != 0) {
                int iLimit = src.limit();
                OutputArraysJVMKt.writeFully(getWritable(), src);
                return availableForWrite;
            }
        }
        return 0;
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryReadAvailable = tryReadAvailable(byteBuffer);
        if (iTryReadAvailable != 0) {
            return Boxing.boxInt(iTryReadAvailable);
        }
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(0) : readAvailableSuspend(byteBuffer, continuation);
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public int readAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        Intrinsics.checkNotNullParameter(block, "block");
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for read");
            }
            throw closedCause;
        }
        if (getAvailableForRead() < min) {
            return -1;
        }
        prepareFlushedBytes();
        ByteReadPacket readable = getReadable();
        ChunkBuffer chunkBufferPrepareRead = readable.prepareRead(min);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(min);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, readPosition2, writePosition);
            int iPosition = byteBufferM6961sliceSK3TCg8.position();
            block.invoke(byteBufferM6961sliceSK3TCg8);
            int iPosition2 = byteBufferM6961sliceSK3TCg8.position() - iPosition;
            if (!(byteBufferM6961sliceSK3TCg8.limit() == writePosition)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM6961sliceSK3TCg8.position());
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                readable.ensureNext(chunkBufferPrepareRead);
            } else {
                readable.setHeadPosition(readPosition3);
            }
            return iPosition2;
        } catch (Throwable th) {
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                readable.ensureNext(chunkBufferPrepareRead);
            } else {
                readable.setHeadPosition(readPosition4);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.p098io.ByteChannelSequentialJVM.C53001
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM.C53001) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.p098io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.await(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L60
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L60:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable(r6, r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.readAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryReadAvailable = tryReadAvailable(byteBuffer);
        if (iTryReadAvailable != -1) {
            return !byteBuffer.hasRemaining() ? Boxing.boxInt(iTryReadAvailable) : readFullySuspend(byteBuffer, iTryReadAvailable, continuation);
        }
        throw new EOFException("Channel closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:20:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(java.nio.ByteBuffer r8, int r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.utils.p098io.ByteChannelSequentialJVM.C53011
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM.C53011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.p098io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r9
            r9 = r8
            r8 = r6
            goto L58
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r7
        L43:
            boolean r10 = r8.hasRemaining()
            if (r10 == 0) goto L77
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r2.await(r3, r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            java.lang.String r4 = "Channel closed"
            if (r10 == 0) goto L71
            int r10 = r2.tryReadAvailable(r8)
            r5 = -1
            if (r10 == r5) goto L6b
            int r9 = r9 + r10
            goto L43
        L6b:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L71:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L77:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.readFullySuspend(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int tryReadAvailable(ByteBuffer dst) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (getClosed() && getAvailableForRead() == 0) {
            return -1;
        }
        if (!getReadable().canRead()) {
            prepareFlushedBytes();
        }
        int available = ByteBuffersKt.readAvailable(getReadable(), dst);
        afterRead(available);
        return available;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d3 -> B:43:0x00d5). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteChannelSequentialBase, io.ktor.utils.p098io.ByteReadChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ java.lang.Object consumeEachBufferRange(kotlin.jvm.functions.Function2 r18, kotlin.coroutines.Continuation r19) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.consumeEachBufferRange(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.invoke(new Session(this));
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return function2.invoke(new Session(this), continuation);
    }

    /* JADX INFO: compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM$Session;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "channel", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "(Lio/ktor/utils/io/ByteChannelSequentialJVM;)V", "awaitAtLeast", "", RsaJsonWebKey.MODULUS_MEMBER_NAME, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", "request", "Ljava/nio/ByteBuffer;", "skip", "atLeast", "ktor-io"}, m5599k = 1, m5600mv = {1, 5, 1}, m5602xi = 48)
    private static final class Session implements LookAheadSuspendSession {
        private final ByteChannelSequentialJVM channel;

        public Session(ByteChannelSequentialJVM channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        @Override // io.ktor.utils.p098io.LookAheadSuspendSession
        public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return this.channel.await(i, continuation);
        }

        @Override // io.ktor.utils.p098io.LookAheadSession
        /* JADX INFO: renamed from: consumed */
        public void mo7224consumed(int n) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            this.channel.discard(n);
        }

        @Override // io.ktor.utils.p098io.LookAheadSession
        public ByteBuffer request(int skip, int atLeast) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            if (this.channel.isClosedForRead()) {
                return null;
            }
            if (this.channel.getReadable().isEmpty()) {
                this.channel.prepareFlushedBytes();
            }
            ChunkBuffer head = this.channel.getReadable().getHead();
            ChunkBuffer chunkBuffer = head;
            if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() < atLeast + skip) {
                return null;
            }
            ByteBuffer byteBufferSlice = head.getMemory().slice();
            return byteBufferSlice;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // io.ktor.utils.p098io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object read(int r9, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.io.EOFException {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.read(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.p098io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        Object objAwait = await(1, continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.p098io.ByteWriteChannel
    public int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        Intrinsics.checkNotNullParameter(block, "block");
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (getAvailableForWrite() < min) {
            return 0;
        }
        BytePacketBuilder writable = getWritable();
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = writable.prepareWriteHead(min);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM6961sliceSK3TCg8 = Memory.m6961sliceSK3TCg8(memory, writePosition, limit);
            int iPosition = byteBufferM6961sliceSK3TCg8.position();
            block.invoke(byteBufferM6961sliceSK3TCg8);
            int iPosition2 = byteBufferM6961sliceSK3TCg8.position() - iPosition;
            if (!(byteBufferM6961sliceSK3TCg8.limit() == limit)) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition3 = byteBufferM6961sliceSK3TCg8.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition3);
            if (iPosition3 >= 0) {
                return iPosition2;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            writable.afterHeadWrite();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.p098io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object write(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.p098io.ByteChannelSequentialJVM.C53021
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM.C53021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r0 = (io.ktor.utils.p098io.ByteChannelSequentialJVM) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L65
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r5.getClosed()
            if (r8 == 0) goto L55
            java.lang.Throwable r6 = r5.getClosedCause()
            if (r6 != 0) goto L54
            kotlinx.coroutines.channels.ClosedSendChannelException r6 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r7 = "Channel closed for write"
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
        L54:
            throw r6
        L55:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r6, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            r0 = r5
        L65:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r0.getWritable()
            io.ktor.utils.io.core.AbstractOutput r8 = (io.ktor.utils.p098io.core.AbstractOutput) r8
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = r8.prepareWriteHead(r6)
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.p098io.core.Buffer) r6     // Catch: java.lang.Throwable -> Lc3
            java.nio.ByteBuffer r1 = r6.getMemory()     // Catch: java.lang.Throwable -> Lc3
            int r2 = r6.getWritePosition()     // Catch: java.lang.Throwable -> Lc3
            int r4 = r6.getLimit()     // Catch: java.lang.Throwable -> Lc3
            int r4 = r4 - r2
            java.nio.ByteBuffer r1 = io.ktor.utils.p098io.bits.Memory.m6961sliceSK3TCg8(r1, r2, r4)     // Catch: java.lang.Throwable -> Lc3
            r7.invoke(r1)     // Catch: java.lang.Throwable -> Lc3
            int r7 = r1.limit()     // Catch: java.lang.Throwable -> Lc3
            r2 = 0
            if (r7 != r4) goto L8e
            r7 = r3
            goto L8f
        L8e:
            r7 = r2
        L8f:
            if (r7 == 0) goto Lb5
            int r7 = r1.position()     // Catch: java.lang.Throwable -> Lc3
            r6.commitWritten(r7)     // Catch: java.lang.Throwable -> Lc3
            if (r7 < 0) goto L9b
            goto L9c
        L9b:
            r3 = r2
        L9c:
            if (r3 == 0) goto La7
            r8.afterHeadWrite()
            r0.afterWrite(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        La7:
            java.lang.String r6 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lc3
            r7.<init>(r6)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch: java.lang.Throwable -> Lc3
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lb5:
            java.lang.String r6 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lc3
            r7.<init>(r6)     // Catch: java.lang.Throwable -> Lc3
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch: java.lang.Throwable -> Lc3
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r6 = move-exception
            r8.afterHeadWrite()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.write(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3 A[Catch: all -> 0x00da, TRY_LEAVE, TryCatch #0 {all -> 0x00da, blocks: (B:26:0x0078, B:31:0x00a3, B:40:0x00be, B:41:0x00cb, B:42:0x00cc, B:43:0x00d9), top: B:47:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[Catch: all -> 0x00da, TryCatch #0 {all -> 0x00da, blocks: (B:26:0x0078, B:31:0x00a3, B:40:0x00be, B:41:0x00cb, B:42:0x00cc, B:43:0x00d9), top: B:47:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006c -> B:25:0x006e). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.p098io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeWhile(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.p098io.ByteChannelSequentialJVM.writeWhile(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
