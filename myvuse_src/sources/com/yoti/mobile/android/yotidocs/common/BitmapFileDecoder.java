package com.yoti.mobile.android.yotidocs.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForIo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/BitmapFileDecoder;", "", "ioContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "decodeFile", "Landroid/graphics/Bitmap;", "pathName", "", "options", "Landroid/graphics/BitmapFactory$Options;", "(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BitmapFileDecoder {

    /* JADX INFO: renamed from: a */
    private final CoroutineContext f7442a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.BitmapFileDecoder$a */
    @Metadata(m5597d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, m5598d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.yotidocs.common.BitmapFileDecoder$decodeFile$2", m5608f = "ImageDimensionsReader.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4948a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {

        /* JADX INFO: renamed from: a */
        int f7443a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f7444b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ BitmapFactory.Options f7445c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4948a(String str, BitmapFactory.Options options, Continuation<? super C4948a> continuation) {
            super(2, continuation);
            this.f7444b = str;
            this.f7445c = options;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((C4948a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C4948a(this.f7444b, this.f7445c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7443a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BitmapFactoryInstrumentation.decodeFile(this.f7444b, this.f7445c);
        }
    }

    @Inject
    public BitmapFileDecoder(@ForIo CoroutineContext ioContext) {
        Intrinsics.checkNotNullParameter(ioContext, "ioContext");
        this.f7442a = ioContext;
    }

    public final Object decodeFile(String str, BitmapFactory.Options options, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.f7442a, new C4948a(str, options, null), continuation);
    }
}
