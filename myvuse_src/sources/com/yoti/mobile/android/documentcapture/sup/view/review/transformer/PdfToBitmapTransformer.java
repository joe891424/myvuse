package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J%\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfToBitmapTransformer;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer;", "pdfRendererFactory", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfRendererFactory;", "filePath", "Landroid/net/Uri;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/PdfRendererFactory;Landroid/net/Uri;Lkotlin/coroutines/CoroutineContext;)V", "renderer", "Landroid/graphics/pdf/PdfRenderer;", "close", "", "getPageCount", "", ViewProps.TRANSFORM, "Landroid/graphics/Bitmap;", "pageNumber", "transformOptions", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;", "(ILcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class PdfToBitmapTransformer implements ICaptureToBitmapTransformer {
    private final CoroutineContext ioContext;
    private final PdfRenderer renderer;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfToBitmapTransformer$close$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfToBitmapTransformer$close$1", m5608f = "PdfToBitmapTransformer.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C46761(Continuation<? super C46761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46761 c46761 = PdfToBitmapTransformer.this.new C46761(continuation);
            c46761.L$0 = obj;
            return c46761;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                PdfToBitmapTransformer.this.renderer.close();
                Result.m7233constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.m7233constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfToBitmapTransformer$transform$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.transformer.PdfToBitmapTransformer$transform$2", m5608f = "PdfToBitmapTransformer.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ int $pageNumber;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46772(int i, Continuation<? super C46772> continuation) {
            super(2, continuation);
            this.$pageNumber = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46772 c46772 = PdfToBitmapTransformer.this.new C46772(this.$pageNumber, continuation);
            c46772.L$0 = obj;
            return c46772;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((C46772) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (!CoroutineScopeKt.isActive((CoroutineScope) this.L$0)) {
                return null;
            }
            PdfRenderer.Page pageOpenPage = PdfToBitmapTransformer.this.renderer.openPage(this.$pageNumber);
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(pageOpenPage.getWidth(), pageOpenPage.getHeight(), Bitmap.Config.ARGB_8888);
                pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                AutoCloseableKt.closeFinally(pageOpenPage, null);
                return bitmapCreateBitmap;
            } finally {
            }
        }
    }

    public PdfToBitmapTransformer(PdfRendererFactory pdfRendererFactory, Uri filePath, @ForIo CoroutineContext ioContext) throws IOException, SecurityException {
        Intrinsics.checkNotNullParameter(pdfRendererFactory, "pdfRendererFactory");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.ioContext = ioContext;
        this.renderer = pdfRendererFactory.create(filePath);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioContext), null, null, new C46761(null), 3, null);
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer
    public int getPageCount() {
        try {
            return this.renderer.getPageCount();
        } catch (FileNotFoundException unused) {
            return 0;
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer
    public Object transform(int i, ICaptureToBitmapTransformer.TransformOptions transformOptions, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.ioContext, new C46772(i, null), continuation);
    }
}
