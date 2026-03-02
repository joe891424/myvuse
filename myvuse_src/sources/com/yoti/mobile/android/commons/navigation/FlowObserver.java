package com.yoti.mobile.android.commons.navigation;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: FlowObserver.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BD\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R5\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/commons/navigation/FlowObserver;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/Job;", "a", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "c", "Lkotlin/jvm/functions/Function2;", "collector", "Lkotlinx/coroutines/flow/Flow;", "b", "Lkotlinx/coroutines/flow/Flow;", "flow", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "commons-navigation_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class FlowObserver<T> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Job job;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Flow<T> flow;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Function2<T, Continuation<? super Unit>, Object> collector;

    /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.FlowObserver$1 */
    /* JADX INFO: compiled from: FlowObserver.kt */
    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, m5598d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "<anonymous>"}, m5599k = 3, m5600mv = {1, 4, 2})
    static final class C45741 implements LifecycleEventObserver {

        /* JADX INFO: renamed from: com.yoti.mobile.android.commons.navigation.FlowObserver$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: FlowObserver.kt */
        @DebugMetadata(m5607c = "com.yoti.mobile.android.commons.navigation.FlowObserver$1$1", m5608f = "FlowObserver.kt", m5609i = {}, m5610l = {LockFreeTaskQueueCore.CLOSED_SHIFT}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a */
            int f6528a;

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                return C45741.this.new AnonymousClass1(completion);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6528a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flow = FlowObserver.this.flow;
                    FlowCollector<T> flowCollector = new FlowCollector<T>() { // from class: com.yoti.mobile.android.commons.navigation.FlowObserver$1$1$invokeSuspend$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(Object obj2, Continuation continuation) {
                            Object objInvoke = FlowObserver.this.collector.invoke(obj2, continuation);
                            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
                        }
                    };
                    this.f6528a = 1;
                    if (flow.collect(flowCollector, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        C45741() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i == 1) {
                FlowObserver.this.job = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(source), null, null, new AnonymousClass1(null), 3, null);
            } else {
                if (i != 2) {
                    return;
                }
                Job job = FlowObserver.this.job;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                FlowObserver.this.job = null;
            }
        }
    }

    @Metadata(m5596bv = {1, 0, 3}, m5597d1 = {}, m5598d2 = {}, m5599k = 3, m5600mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowObserver(LifecycleOwner lifecycleOwner, Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> collector) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(collector, "collector");
        this.flow = flow;
        this.collector = collector;
        lifecycleOwner.getLifecycle().addObserver(new C45741());
    }
}
