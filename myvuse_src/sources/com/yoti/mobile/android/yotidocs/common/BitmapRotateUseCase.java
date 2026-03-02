package com.yoti.mobile.android.yotidocs.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.yoti.mobile.android.commons.functional.Either;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForComputation;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086Bø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/yotidocs/common/BitmapRotateUseCase;", "", "computationContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "invoke", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "Landroid/graphics/Bitmap;", "bitmap", "degrees", "", "(Landroid/graphics/Bitmap;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BitmapRotateUseCase {

    /* JADX INFO: renamed from: a */
    private final CoroutineContext f7447a;

    /* JADX INFO: renamed from: com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase$a */
    @Metadata(m5597d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0001*\u00020\u0005H\u008a@"}, m5598d2 = {"<anonymous>", "Lcom/yoti/mobile/android/commons/functional/Either;", "", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.yotidocs.common.BitmapRotateUseCase$invoke$2", m5608f = "BitmapRotateUseCase.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C4949a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Throwable, ? extends Bitmap>>, Object> {

        /* JADX INFO: renamed from: a */
        int f7448a;

        /* JADX INFO: renamed from: b */
        private /* synthetic */ Object f7449b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f7450c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ Bitmap f7451d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4949a(int i, Bitmap bitmap, Continuation<? super C4949a> continuation) {
            super(2, continuation);
            this.f7450c = i;
            this.f7451d = bitmap;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Throwable, Bitmap>> continuation) {
            return ((C4949a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C4949a c4949a = new C4949a(this.f7450c, this.f7451d, continuation);
            c4949a.f7449b = obj;
            return c4949a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM7233constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7448a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = this.f7450c;
            Bitmap bitmapCreateBitmap = this.f7451d;
            if (i != 0) {
                try {
                    int width = bitmapCreateBitmap.getWidth();
                    int height = bitmapCreateBitmap.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.setRotate(i);
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, width, height, matrix, true);
                } catch (Throwable th) {
                    objM7233constructorimpl = Result.m7233constructorimpl(ResultKt.createFailure(th));
                }
            }
            objM7233constructorimpl = Result.m7233constructorimpl(bitmapCreateBitmap);
            Throwable thM7236exceptionOrNullimpl = Result.m7236exceptionOrNullimpl(objM7233constructorimpl);
            return thM7236exceptionOrNullimpl == null ? new Either.Success((Bitmap) objM7233constructorimpl) : new Either.Failure(thM7236exceptionOrNullimpl);
        }
    }

    @Inject
    public BitmapRotateUseCase(@ForComputation CoroutineContext computationContext) {
        Intrinsics.checkNotNullParameter(computationContext, "computationContext");
        this.f7447a = computationContext;
    }

    public final Object invoke(Bitmap bitmap, int i, Continuation<? super Either<? extends Throwable, Bitmap>> continuation) {
        return BuildersKt.withContext(this.f7447a, new C4949a(i, bitmap, null), continuation);
    }
}
