package com.yoti.mobile.android.documentcapture.p055id.view.upload;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
@DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.upload.TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1", m5608f = "TextExtractionErrorViewModel.kt", m5609i = {}, m5610l = {116}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
final class TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ MetaData $it;
    int label;
    final /* synthetic */ TextExtractionErrorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1(TextExtractionErrorViewModel textExtractionErrorViewModel, MetaData metaData, Continuation<? super TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1> continuation) {
        super(2, continuation);
        this.this$0 = textExtractionErrorViewModel;
        this.$it = metaData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((TextExtractionErrorViewModel$loadImages$deferredImageSecond$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DocumentImageLoader documentImageLoader = this.this$0.imageLoader;
            RectF cropRegion = this.$it.getCropRegion();
            if (cropRegion == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            String mainImage = this.$it.getMainImage();
            if (mainImage == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            this.label = 1;
            obj = documentImageLoader.loadImage(cropRegion, mainImage, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
