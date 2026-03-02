package com.yoti.mobile.android.commons.navigation;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: FlowObserver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aY\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022$\b\b\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m5598d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "collector", "Lcom/yoti/mobile/android/commons/navigation/FlowObserver;", "observeOnLifecycle", "(Lkotlinx/coroutines/flow/Flow;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function2;)Lcom/yoti/mobile/android/commons/navigation/FlowObserver;", "observeInLifecycle", "(Lkotlinx/coroutines/flow/Flow;Landroidx/lifecycle/LifecycleOwner;)Lcom/yoti/mobile/android/commons/navigation/FlowObserver;", "commons-navigation_release"}, m5599k = 2, m5600mv = {1, 4, 2})
public final class FlowObserverKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.FlowObserverKt$observeInLifecycle$1 */
    /* JADX INFO: compiled from: FlowObserver.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m5598d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m5599k = 3, m5600mv = {1, 4, 2})
    @DebugMetadata(m5607c = "com.yoti.mobile.android.commons.navigation.FlowObserverKt$observeInLifecycle$1", m5608f = "FlowObserver.kt", m5609i = {}, m5610l = {}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    public static final class C45751<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a */
        int f6531a;

        public C45751(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new C45751(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C45751) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6531a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ <T> FlowObserver<T> observeOnLifecycle(Flow<? extends T> observeOnLifecycle, LifecycleOwner lifecycleOwner, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> collector) {
        Intrinsics.checkNotNullParameter(observeOnLifecycle, "$this$observeOnLifecycle");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(collector, "collector");
        return new FlowObserver<>(lifecycleOwner, observeOnLifecycle, collector);
    }

    public static final /* synthetic */ <T> FlowObserver<T> observeInLifecycle(Flow<? extends T> observeInLifecycle, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(observeInLifecycle, "$this$observeInLifecycle");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        return new FlowObserver<>(lifecycleOwner, observeInLifecycle, new C45751(null));
    }
}
