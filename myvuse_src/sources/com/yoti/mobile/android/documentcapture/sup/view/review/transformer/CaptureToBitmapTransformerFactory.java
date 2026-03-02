package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.content.Context;
import android.net.Uri;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.remote.MimeType;
import com.yoti.mobile.android.remote.MimeTypeProvider;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/CaptureToBitmapTransformerFactory;", "", "context", "Landroid/content/Context;", "pdfRendererFactory", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfRendererFactory;", "mimeTypeProvider", "Lcom/yoti/mobile/android/remote/MimeTypeProvider;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfRendererFactory;Lcom/yoti/mobile/android/remote/MimeTypeProvider;Lkotlin/coroutines/CoroutineContext;)V", "createPdfToBitmapTransformer", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/FileOpenError;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfToBitmapTransformer;", "filePath", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransformer", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class CaptureToBitmapTransformerFactory {
    private final Context context;
    private final CoroutineContext ioContext;
    private final MimeTypeProvider mimeTypeProvider;
    private final PdfRendererFactory pdfRendererFactory;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MimeType.values().length];
            iArr[MimeType.PDF.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory$createPdfToBitmapTransformer$2 */
    @Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/FileOpenError;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfToBitmapTransformer;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.transformer.CaptureToBitmapTransformerFactory$createPdfToBitmapTransformer$2", m5608f = "CaptureToBitmapTransformerFactory.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends FileOpenError, ? extends PdfToBitmapTransformer>>, Object> {
        final /* synthetic */ Uri $filePath;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46742(Uri uri, Continuation<? super C46742> continuation) {
            super(2, continuation);
            this.$filePath = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46742 c46742 = CaptureToBitmapTransformerFactory.this.new C46742(this.$filePath, continuation);
            c46742.L$0 = obj;
            return c46742;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends FileOpenError, ? extends PdfToBitmapTransformer>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Either<FileOpenError, PdfToBitmapTransformer>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Either<FileOpenError, PdfToBitmapTransformer>> continuation) {
            return ((C46742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM7233constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CaptureToBitmapTransformerFactory captureToBitmapTransformerFactory = CaptureToBitmapTransformerFactory.this;
            try {
                objM7233constructorimpl = Result.m7233constructorimpl(new PdfToBitmapTransformer(captureToBitmapTransformerFactory.pdfRendererFactory, this.$filePath, captureToBitmapTransformerFactory.ioContext));
            } catch (Throwable th) {
                objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
            return thM7236exceptionOrNullimpl == null ? new Either.Success((PdfToBitmapTransformer) objM7233constructorimpl) : new Either.Failure(new FileOpenError(thM7236exceptionOrNullimpl));
        }
    }

    @Inject
    public CaptureToBitmapTransformerFactory(Context context, PdfRendererFactory pdfRendererFactory, MimeTypeProvider mimeTypeProvider, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pdfRendererFactory, "pdfRendererFactory");
        Intrinsics.checkNotNullParameter(mimeTypeProvider, "mimeTypeProvider");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.pdfRendererFactory = pdfRendererFactory;
        this.mimeTypeProvider = mimeTypeProvider;
        this.ioContext = ioContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createPdfToBitmapTransformer(Uri uri, Continuation<? super Either<FileOpenError, PdfToBitmapTransformer>> continuation) {
        return BuildersKt.withContext(this.ioContext, new C46742(uri, null), continuation);
    }

    public final Object getTransformer(Uri uri, Continuation<? super Either<FileOpenError, ? extends ICaptureToBitmapTransformer>> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[this.mimeTypeProvider.getMimeType(uri).ordinal()] != 1) {
            return new Either.Success(new ImageToBitmapTransformer(this.context, uri, null, 4, null));
        }
        Object objCreatePdfToBitmapTransformer = createPdfToBitmapTransformer(uri, continuation);
        return objCreatePdfToBitmapTransformer == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCreatePdfToBitmapTransformer : (Either) objCreatePdfToBitmapTransformer;
    }

    public /* synthetic */ CaptureToBitmapTransformerFactory(Context context, PdfRendererFactory pdfRendererFactory, MimeTypeProvider mimeTypeProvider, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, pdfRendererFactory, mimeTypeProvider, (i & 8) != 0 ? Dispatchers.getIO() : coroutineContext);
    }
}
