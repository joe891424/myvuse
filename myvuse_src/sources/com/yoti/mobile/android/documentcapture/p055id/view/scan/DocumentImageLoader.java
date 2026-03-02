package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.RectF;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentImageLoader;", "", "context", "Landroid/content/Context;", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "calculateMaximumImageFrameWidth", "", "widthPixels", "loadImage", "Landroid/graphics/Bitmap;", "cropRegion", "Landroid/graphics/RectF;", "imagePath", "", "(Landroid/graphics/RectF;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentImageLoader {
    private final Context context;
    private final CoroutineContext ioContext;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader", m5608f = "DocumentImageLoader.kt", m5609i = {}, m5610l = {28}, m5611m = "loadImage", m5612n = {}, m5613s = {})
    static final class C46291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C46291(Continuation<? super C46291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentImageLoader.this.loadImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$2 */
    @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$2", m5608f = "DocumentImageLoader.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ RectF $cropRegion;
        final /* synthetic */ String $imagePath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46302(RectF rectF, String str, Continuation<? super C46302> continuation) {
            super(2, continuation);
            this.$cropRegion = rectF;
            this.$imagePath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C46302(this.$cropRegion, this.$imagePath, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((C46302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Rect rect = new Rect();
            this.$cropRegion.round(rect);
            return BitmapRegionDecoder.newInstance(this.$imagePath, false).decodeRegion(rect, new BitmapFactory.Options());
        }
    }

    @Inject
    public DocumentImageLoader(Context context, @ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.context = context;
        this.ioContext = ioContext;
    }

    public final int calculateMaximumImageFrameWidth(int widthPixels) {
        return widthPixels - ((((int) this.context.getResources().getDimension(C4597R.dimen.yds_review_horizontal_margin)) + ((int) this.context.getResources().getDimension(C4597R.dimen.yds_image_review_border))) * 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadImage(android.graphics.RectF r6, java.lang.String r7, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader.C46291
            if (r0 == 0) goto L13
            r0 = r8
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader.C46291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.coroutines.CoroutineContext r8 = r5.ioContext
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$2 r2 = new com.yoti.mobile.android.documentcapture.id.view.scan.DocumentImageLoader$loadImage$2
            r4 = 0
            r2.<init>(r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            java.lang.String r6 = "cropRegion: RectF, image…tory.Options())\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentImageLoader.loadImage(android.graphics.RectF, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
