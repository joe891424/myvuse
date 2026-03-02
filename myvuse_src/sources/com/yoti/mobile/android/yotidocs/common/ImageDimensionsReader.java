package com.yoti.mobile.android.yotidocs.common;

import android.graphics.BitmapFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/ImageDimensionsReader;", "", "bitmapFileDecoder", "Lcom/yoti/mobile/android/yotidocs/common/BitmapFileDecoder;", "(Lcom/yoti/mobile/android/yotidocs/common/BitmapFileDecoder;)V", "getDimensions", "Lcom/yoti/mobile/android/commons/functional/Either;", "Lcom/yoti/mobile/android/yotidocs/common/ImageDecodeError;", "Lcom/yoti/mobile/android/yotidocs/common/ImageDimensions;", "imagePath", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validate", "Landroid/graphics/BitmapFactory$Options;", "decodeOptions", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ImageDimensionsReader {

    /* JADX INFO: renamed from: a */
    private final BitmapFileDecoder f7461a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader$a */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader", m5608f = "ImageDimensionsReader.kt", m5609i = {0, 0}, m5610l = {22}, m5611m = "getDimensions", m5612n = {"$this$getDimensions_u24lambda_u2d1", "decodeOptions"}, m5613s = {"L$0", "L$1"})
    static final class C4950a extends ContinuationImpl {

        /* JADX INFO: renamed from: a */
        Object f7462a;

        /* JADX INFO: renamed from: b */
        Object f7463b;

        /* JADX INFO: renamed from: c */
        /* synthetic */ Object f7464c;

        /* JADX INFO: renamed from: e */
        int f7466e;

        C4950a(Continuation<? super C4950a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7464c = obj;
            this.f7466e |= Integer.MIN_VALUE;
            return ImageDimensionsReader.this.getDimensions(null, this);
        }
    }

    @Inject
    public ImageDimensionsReader(BitmapFileDecoder bitmapFileDecoder) {
        Intrinsics.checkNotNullParameter(bitmapFileDecoder, "bitmapFileDecoder");
        this.f7461a = bitmapFileDecoder;
    }

    /* JADX INFO: renamed from: a */
    private final BitmapFactory.Options m5080a(BitmapFactory.Options options) {
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException("Error trying to decode image".toString());
        }
        return options;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getDimensions(java.lang.String r5, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.commons.functional.Either<com.yoti.mobile.android.yotidocs.common.ImageDecodeError, com.yoti.mobile.android.yotidocs.common.ImageDimensions>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader.C4950a
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader$a r0 = (com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader.C4950a) r0
            int r1 = r0.f7466e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7466e = r1
            goto L18
        L13:
            com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader$a r0 = new com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f7464c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f7466e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f7463b
            android.graphics.BitmapFactory$Options r5 = (android.graphics.BitmapFactory.Options) r5
            java.lang.Object r0 = r0.f7462a
            com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader r0 = (com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L5d
            goto L54
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L5d
            r6.<init>()     // Catch: java.lang.Throwable -> L5d
            r6.inJustDecodeBounds = r3     // Catch: java.lang.Throwable -> L5d
            com.yoti.mobile.android.yotidocs.common.BitmapFileDecoder r2 = r4.f7461a     // Catch: java.lang.Throwable -> L5d
            r0.f7462a = r4     // Catch: java.lang.Throwable -> L5d
            r0.f7463b = r6     // Catch: java.lang.Throwable -> L5d
            r0.f7466e = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r5 = r2.decodeFile(r5, r6, r0)     // Catch: java.lang.Throwable -> L5d
            if (r5 != r1) goto L52
            return r1
        L52:
            r0 = r4
            r5 = r6
        L54:
            android.graphics.BitmapFactory$Options r5 = r0.m5080a(r5)     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r5 = kotlin.Result.m7233constructorimpl(r5)     // Catch: java.lang.Throwable -> L5d
            goto L66
        L5d:
            r5 = move-exception
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m7233constructorimpl(r5)
        L66:
            java.lang.Throwable r6 = kotlin.Result.m7236exceptionOrNullimpl(r5)
            if (r6 != 0) goto L7d
            android.graphics.BitmapFactory$Options r5 = (android.graphics.BitmapFactory.Options) r5
            com.yoti.mobile.android.commons.functional.Either$Success r6 = new com.yoti.mobile.android.commons.functional.Either$Success
            com.yoti.mobile.android.yotidocs.common.ImageDimensions r0 = new com.yoti.mobile.android.yotidocs.common.ImageDimensions
            int r1 = r5.outWidth
            int r5 = r5.outHeight
            r0.<init>(r1, r5)
            r6.<init>(r0)
            goto L8b
        L7d:
            java.lang.String r5 = "ImageDimensionsReader"
            java.lang.String r0 = "Error getting image dimensions"
            com.yoti.mobile.android.commons.util.C4588L.logError(r5, r0, r6)
            com.yoti.mobile.android.commons.functional.Either$Failure r6 = new com.yoti.mobile.android.commons.functional.Either$Failure
            com.yoti.mobile.android.yotidocs.common.ImageDecodeError r5 = com.yoti.mobile.android.yotidocs.common.ImageDecodeError.INSTANCE
            r6.<init>(r5)
        L8b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.yotidocs.common.ImageDimensionsReader.getDimensions(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
