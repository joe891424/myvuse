package com.yoti.mobile.android.facecapture.view.capture;

import android.content.Context;
import com.yoti.mobile.android.commons.util.FileManager;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p099io.CloseableKt;
import kotlin.p099io.FilesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0011\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/CaptureResultProcessor;", "", "context", "Landroid/content/Context;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "readFaceCapture", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFaceCapture", "", "saveFaceCapture", "Ljava/io/File;", "capture", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CaptureResultProcessor {
    private final Context context;
    private final CoroutineContext ioContext;

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$readFaceCapture$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$readFaceCapture$2", m5608f = "CaptureResultProcessor.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        int label;

        C48392(Continuation<? super C48392> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureResultProcessor.this.new C48392(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C48392) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return FilesKt.readBytes(new File(CaptureResultProcessor.this.context.getDir("FaceCapture", 0), "FaceCapture.jpeg"));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$removeFaceCapture$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$removeFaceCapture$2", m5608f = "CaptureResultProcessor.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48402 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C48402(Continuation<? super C48402> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureResultProcessor.this.new C48402(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C48402) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(FileManager.deleteDir(CaptureResultProcessor.this.context.getDir("FaceCapture", 0)));
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$saveFaceCapture$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor$saveFaceCapture$2", m5608f = "CaptureResultProcessor.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ byte[] $capture;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48412(byte[] bArr, Continuation<? super C48412> continuation) {
            super(2, continuation);
            this.$capture = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureResultProcessor.this.new C48412(this.$capture, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((C48412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File file = new File(CaptureResultProcessor.this.context.getDir("FaceCapture", 0), "FaceCapture.jpeg");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream.write(this.$capture);
                bufferedOutputStream.flush();
                CloseableKt.closeFinally(bufferedOutputStream, null);
                return file;
            } finally {
            }
        }
    }

    @Inject
    public CaptureResultProcessor(Context context, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.ioContext = ioContext;
    }

    public final Object readFaceCapture(Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(this.ioContext, new C48392(null), continuation);
    }

    public final Object removeFaceCapture(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioContext, new C48402(null), continuation);
    }

    public final Object saveFaceCapture(byte[] bArr, Continuation<? super File> continuation) throws IOException, IllegalArgumentException {
        return BuildersKt.withContext(this.ioContext, new C48412(bArr, null), continuation);
    }

    public /* synthetic */ CaptureResultProcessor(Context context, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Dispatchers.getIO() : coroutineContext);
    }
}
