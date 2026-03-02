package com.yoti.mobile.android.documentcapture.sup.view.review.transformer;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.react.uimanager.ViewProps;
import com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J%\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ImageToBitmapTransformer;", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer;", "context", "Landroid/content/Context;", "filePath", "Landroid/net/Uri;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/CoroutineContext;)V", "renderJob", "Lcom/bumptech/glide/request/FutureTarget;", "Landroid/graphics/Bitmap;", "close", "", "getPageCount", "", ViewProps.TRANSFORM, "pageNumber", "transformOptions", "Lcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;", "(ILcom/yoti/mobile/android/documentcapture/sup/view/review/transformer/ICaptureToBitmapTransformer$TransformOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ImageToBitmapTransformer implements ICaptureToBitmapTransformer {
    private final Context context;
    private final Uri filePath;
    private final CoroutineContext ioContext;
    private FutureTarget<Bitmap> renderJob;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ImageToBitmapTransformer$transform$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ImageToBitmapTransformer$transform$2", m5608f = "ImageToBitmapTransformer.kt", m5609i = {0}, m5610l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m5611m = "invokeSuspend", m5612n = {"$this$withContext"}, m5613s = {"L$0"})
    static final class C46752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ ICaptureToBitmapTransformer.TransformOptions $transformOptions;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46752(ICaptureToBitmapTransformer.TransformOptions transformOptions, Continuation<? super C46752> continuation) {
            super(2, continuation);
            this.$transformOptions = transformOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46752 c46752 = ImageToBitmapTransformer.this.new C46752(this.$transformOptions, continuation);
            c46752.L$0 = obj;
            return c46752;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((C46752) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                RequestBuilder requestBuilderSkipMemoryCache = Glide.with(ImageToBitmapTransformer.this.context).asBitmap().load(ImageToBitmapTransformer.this.filePath).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
                Intrinsics.checkNotNullExpressionValue(requestBuilderSkipMemoryCache, "with(context)\n          …   .skipMemoryCache(true)");
                RequestBuilder requestBuilder = requestBuilderSkipMemoryCache;
                ICaptureToBitmapTransformer.TransformOptions transformOptions = this.$transformOptions;
                if (transformOptions != null) {
                    RequestOptions requestOptionsOverride = new RequestOptions().override(transformOptions.getSize().getWidth(), transformOptions.getSize().getHeight());
                    if (transformOptions.getApplyCenterCrop()) {
                        requestOptionsOverride = requestOptionsOverride.centerCrop();
                    }
                    Intrinsics.checkNotNullExpressionValue(requestOptionsOverride, "RequestOptions()\n       …nterCrop() else options }");
                    requestBuilder.apply((BaseRequestOptions<?>) requestOptionsOverride);
                }
                ImageToBitmapTransformer.this.renderJob = requestBuilder.submit();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                FutureTarget futureTarget = ImageToBitmapTransformer.this.renderJob;
                if (futureTarget != null && futureTarget.isDone()) {
                    FutureTarget futureTarget2 = ImageToBitmapTransformer.this.renderJob;
                    if (futureTarget2 != null) {
                        return (Bitmap) futureTarget2.get();
                    }
                    return null;
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return null;
        }
    }

    public ImageToBitmapTransformer(Context context, Uri filePath, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.filePath = filePath;
        this.ioContext = ioContext;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        FutureTarget<Bitmap> futureTarget = this.renderJob;
        if (futureTarget != null) {
            futureTarget.cancel(true);
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer
    public int getPageCount() {
        return 1;
    }

    @Override // com.yoti.mobile.android.documentcapture.sup.view.review.transformer.ICaptureToBitmapTransformer
    public Object transform(int i, ICaptureToBitmapTransformer.TransformOptions transformOptions, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.ioContext, new C46752(transformOptions, null), continuation);
    }

    public /* synthetic */ ImageToBitmapTransformer(Context context, Uri uri, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, (i & 4) != 0 ? Dispatchers.getIO() : coroutineContext);
    }
}
