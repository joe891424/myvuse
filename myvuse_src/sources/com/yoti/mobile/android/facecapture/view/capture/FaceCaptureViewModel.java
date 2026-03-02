package com.yoti.mobile.android.facecapture.view.capture;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReasonCode;
import com.tinder.StateMachine;
import com.yoti.mobile.android.capture.face.p048ui.models.face.ImageQuality;
import com.yoti.mobile.android.capture.face.util.BufferConversion;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.view.capture.CaptureViewState;
import com.yoti.mobile.android.facecapture.view.capture.mapper.ViewEventToStateMachineMapper;
import com.yoti.mobile.android.facecapture.view.capture.model.CaptureConfig;
import com.yoti.mobile.android.facecapture.view.capture.model.Event;
import com.yoti.mobile.android.facecapture.view.capture.model.FaceCaptureViewEvent;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback;
import com.yoti.mobile.android.facecapture.view.capture.model.SideEffect;
import com.yoti.mobile.android.facecapture.view.capture.model.State;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureMode;
import com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.ForComputation;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010'\u001a\u00020(H\u0012J\b\u0010)\u001a\u00020(H\u0012J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020#H\u0012J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020!H\u0012J\"\u0010.\u001a\u00020(2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#00H\u0012J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020(H\u0017J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u000207H\u0012J\u0011\u00108\u001a\u00020(H\u0092@ø\u0001\u0000¢\u0006\u0002\u00109J\u0011\u0010:\u001a\u00020(H\u0092@ø\u0001\u0000¢\u0006\u0002\u00109R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0092\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010 X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001aX\u0092\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureViewModel;", "Landroidx/lifecycle/ViewModel;", "stateMachineFactory", "Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;", "eventMapper", "Lcom/yoti/mobile/android/facecapture/view/capture/mapper/ViewEventToStateMachineMapper;", "captureProcessor", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureResultProcessor;", "captureConfigurationProvider", "Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;", "computationContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/yoti/mobile/android/facecapture/view/capture/IFaceCaptureStateMachineFactory;Lcom/yoti/mobile/android/facecapture/view/capture/mapper/ViewEventToStateMachineMapper;Lcom/yoti/mobile/android/facecapture/view/capture/CaptureResultProcessor;Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;Lkotlin/coroutines/CoroutineContext;)V", "_navigationEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "_viewState", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState;", "captureConfig", "Lcom/yoti/mobile/android/facecapture/view/capture/model/CaptureConfig;", "currentScanningState", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "getCurrentScanningState", "()Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "flashTimeoutJob", "Lkotlinx/coroutines/Job;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "stateMachine", "Lcom/tinder/StateMachine;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/State;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/Event;", "Lcom/yoti/mobile/android/facecapture/view/capture/model/SideEffect;", "timeoutJob", "viewState", "getViewState", "cancelAllTimeouts", "", "deleteFaceCapture", "handleSideEffect", "sideEffect", "handleStateChange", "state", "handleStateTransition", "transition", "Lcom/tinder/StateMachine$Transition;", "handleViewEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/facecapture/view/capture/model/FaceCaptureViewEvent;", "onCleared", "saveFaceCapture", "capture", "", "startFlashTimeout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTimeout", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class FaceCaptureViewModel extends ViewModel {
    private final MutableLiveData<SingleEvent<CaptureNavigationEvent>> _navigationEvent;
    private final MutableLiveData<CaptureViewState> _viewState;
    private CaptureConfig captureConfig;
    private final CaptureConfigurationProvider captureConfigurationProvider;
    private final CaptureResultProcessor captureProcessor;
    private final CoroutineContext computationContext;
    private final ViewEventToStateMachineMapper eventMapper;
    private Job flashTimeoutJob;
    private final LiveData<SingleEvent<CaptureNavigationEvent>> navigationEvent;
    private StateMachine<State, Event, SideEffect> stateMachine;
    private final IFaceCaptureStateMachineFactory stateMachineFactory;
    private Job timeoutJob;
    private final LiveData<CaptureViewState> viewState;

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$deleteFaceCapture$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$deleteFaceCapture$1", m5608f = "FaceCaptureViewModel.kt", m5609i = {}, m5610l = {198}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48541(Continuation<? super C48541> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceCaptureViewModel.this.new C48541(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureResultProcessor captureResultProcessor = FaceCaptureViewModel.this.captureProcessor;
                this.label = 1;
                if (captureResultProcessor.removeFaceCapture(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleSideEffect$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleSideEffect$1", m5608f = "FaceCaptureViewModel.kt", m5609i = {}, m5610l = {159}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48551(Continuation<? super C48551> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceCaptureViewModel.this.new C48551(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FaceCaptureViewModel faceCaptureViewModel = FaceCaptureViewModel.this;
                this.label = 1;
                if (faceCaptureViewModel.startTimeout(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleSideEffect$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleSideEffect$2", m5608f = "FaceCaptureViewModel.kt", m5609i = {}, m5610l = {165}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48562(Continuation<? super C48562> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceCaptureViewModel.this.new C48562(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48562) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FaceCaptureViewModel faceCaptureViewModel = FaceCaptureViewModel.this;
                this.label = 1;
                if (faceCaptureViewModel.startFlashTimeout(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleSideEffect$3 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C48573 extends FunctionReferenceImpl implements Function1<StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> {
        C48573(Object obj) {
            super(1, obj, FaceCaptureViewModel.class, "handleStateTransition", "handleStateTransition(Lcom/tinder/StateMachine$Transition;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
            invoke2(transition);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FaceCaptureViewModel) this.receiver).handleStateTransition(p0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleViewEvent$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C48581 extends FunctionReferenceImpl implements Function1<StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> {
        C48581(Object obj) {
            super(1, obj, FaceCaptureViewModel.class, "handleStateTransition", "handleStateTransition(Lcom/tinder/StateMachine$Transition;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
            invoke2(transition);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FaceCaptureViewModel) this.receiver).handleStateTransition(p0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$handleViewEvent$2 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C48592 extends FunctionReferenceImpl implements Function1<StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect>, Unit> {
        C48592(Object obj) {
            super(1, obj, FaceCaptureViewModel.class, "handleStateTransition", "handleStateTransition(Lcom/tinder/StateMachine$Transition;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
            invoke2(transition);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((FaceCaptureViewModel) this.receiver).handleStateTransition(p0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$saveFaceCapture$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$saveFaceCapture$1", m5608f = "FaceCaptureViewModel.kt", m5609i = {1}, m5610l = {182, 185}, m5611m = "invokeSuspend", m5612n = {"file"}, m5613s = {"L$2"})
    static final class C48601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $capture;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48601(byte[] bArr, Continuation<? super C48601> continuation) {
            super(2, continuation);
            this.$capture = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C48601 c48601 = FaceCaptureViewModel.this.new C48601(this.$capture, continuation);
            c48601.L$0 = obj;
            return c48601;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L29
                if (r1 == r2) goto L25
                if (r1 != r3) goto L1d
                java.lang.Object r0 = r9.L$2
                java.io.File r0 = (java.io.File) r0
                java.lang.Object r1 = r9.L$1
                com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel r1 = (com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel) r1
                java.lang.Object r2 = r9.L$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L8d
            L1d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L25:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L48
                goto L41
            L29:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
                com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel r10 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.this
                byte[] r1 = r9.$capture
                com.yoti.mobile.android.facecapture.view.capture.CaptureResultProcessor r10 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.access$getCaptureProcessor$p(r10)     // Catch: java.lang.Throwable -> L48
                r9.label = r2     // Catch: java.lang.Throwable -> L48
                java.lang.Object r10 = r10.saveFaceCapture(r1, r9)     // Catch: java.lang.Throwable -> L48
                if (r10 != r0) goto L41
                return r0
            L41:
                java.io.File r10 = (java.io.File) r10     // Catch: java.lang.Throwable -> L48
                java.lang.Object r10 = kotlin.Result.m7233constructorimpl(r10)     // Catch: java.lang.Throwable -> L48
                goto L51
            L48:
                r10 = move-exception
                java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
                java.lang.Object r10 = kotlin.Result.m7233constructorimpl(r10)
            L51:
                r2 = r10
                com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel r1 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.this
                boolean r10 = kotlin.Result.m7240isSuccessimpl(r2)
                if (r10 == 0) goto Lb4
                r10 = r2
                java.io.File r10 = (java.io.File) r10
                androidx.lifecycle.MutableLiveData r5 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.access$get_viewState$p(r1)
                com.yoti.mobile.android.facecapture.view.capture.CaptureViewState$CaptureSuccess r6 = new com.yoti.mobile.android.facecapture.view.capture.CaptureViewState$CaptureSuccess
                com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback r7 = new com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback
                int r8 = com.yoti.mobile.android.facecapture.C4832R.string.yds_face_capture_success
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
                r7.<init>(r8, r4, r3, r4)
                r6.<init>(r7)
                r5.setValue(r6)
                kotlin.coroutines.CoroutineContext r5 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.access$getComputationContext$p(r1)
                com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$saveFaceCapture$1$2$1 r6 = new com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$saveFaceCapture$1$2$1
                r6.<init>(r4)
                r9.L$0 = r2
                r9.L$1 = r1
                r9.L$2 = r10
                r9.label = r3
                java.lang.Object r3 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9)
                if (r3 != r0) goto L8c
                return r0
            L8c:
                r0 = r10
            L8d:
                androidx.lifecycle.MutableLiveData r10 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.access$get_navigationEvent$p(r1)
                com.yoti.mobile.android.commonui.SingleEvent r3 = new com.yoti.mobile.android.commonui.SingleEvent
                com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent$NavigateToCaptureReview r5 = new com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent$NavigateToCaptureReview
                com.yoti.mobile.android.facecapture.view.capture.model.CaptureResult r6 = new com.yoti.mobile.android.facecapture.view.capture.model.CaptureResult
                com.yoti.mobile.android.facecapture.view.capture.model.CaptureConfig r1 = com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.access$getCaptureConfig$p(r1)
                if (r1 != 0) goto La3
                java.lang.String r1 = "captureConfig"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto La4
            La3:
                r4 = r1
            La4:
                java.lang.String r1 = r4.getResourceId()
                r6.<init>(r1, r0)
                r5.<init>(r6)
                r3.<init>(r5)
                r10.setValue(r3)
            Lb4:
                kotlin.Result.m7236exceptionOrNullimpl(r2)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.C48601.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel", m5608f = "FaceCaptureViewModel.kt", m5609i = {0}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_SHOW_PC_CALLED}, m5611m = "startFlashTimeout", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C48611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48611(Continuation<? super C48611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FaceCaptureViewModel.this.startFlashTimeout(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$2", m5608f = "FaceCaptureViewModel.kt", m5609i = {}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_NEW_GROUP_ADDED}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48622 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48622(Continuation<? super C48622> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C48622(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48622) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel", m5608f = "FaceCaptureViewModel.kt", m5609i = {0}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_RE_CONSENT}, m5611m = "startTimeout", m5612n = {"this"}, m5613s = {"L$0"})
    static final class C48631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C48631(Continuation<? super C48631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FaceCaptureViewModel.this.startTimeout(this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$2 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$2", m5608f = "FaceCaptureViewModel.kt", m5609i = {}, m5610l = {OTUIDisplayReasonCode.UIShownCode.PC_SHOWN_RE_CONSENT_EXPIRED}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C48642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C48642(Continuation<? super C48642> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C48642(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C48642) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(20000L, this) == coroutine_suspended) {
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

    @Inject
    public FaceCaptureViewModel(IFaceCaptureStateMachineFactory stateMachineFactory, ViewEventToStateMachineMapper eventMapper, CaptureResultProcessor captureProcessor, CaptureConfigurationProvider captureConfigurationProvider, @ForComputation CoroutineContext computationContext) {
        Intrinsics.checkNotNullParameter(stateMachineFactory, "stateMachineFactory");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        Intrinsics.checkNotNullParameter(captureProcessor, "captureProcessor");
        Intrinsics.checkNotNullParameter(captureConfigurationProvider, "captureConfigurationProvider");
        Intrinsics.checkNotNullParameter(computationContext, "computationContext");
        this.stateMachineFactory = stateMachineFactory;
        this.eventMapper = eventMapper;
        this.captureProcessor = captureProcessor;
        this.captureConfigurationProvider = captureConfigurationProvider;
        this.computationContext = computationContext;
        MutableLiveData<CaptureViewState> mutableLiveData = new MutableLiveData<>(FaceCaptureViewModelKt.INITIAL_VIEW_STATE);
        this._viewState = mutableLiveData;
        LiveData<CaptureViewState> liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(liveDataDistinctUntilChanged, "distinctUntilChanged(_viewState)");
        this.viewState = liveDataDistinctUntilChanged;
        MutableLiveData<SingleEvent<CaptureNavigationEvent>> mutableLiveData2 = new MutableLiveData<>();
        this._navigationEvent = mutableLiveData2;
        this.navigationEvent = mutableLiveData2;
    }

    private void cancelAllTimeouts() {
        Job job = this.timeoutJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.flashTimeoutJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    private void deleteFaceCapture() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C48541(null), 3, null);
    }

    private CaptureViewState.CaptureInProgress getCurrentScanningState() {
        CaptureViewState value = this._viewState.getValue();
        CaptureViewState.CaptureInProgress captureInProgress = value instanceof CaptureViewState.CaptureInProgress ? (CaptureViewState.CaptureInProgress) value : null;
        return captureInProgress == null ? FaceCaptureViewModelKt.INITIAL_VIEW_STATE : captureInProgress;
    }

    private void handleSideEffect(SideEffect sideEffect) {
        if (sideEffect instanceof SideEffect.CompleteCapture) {
            saveFaceCapture(((SideEffect.CompleteCapture) sideEffect).getFrame());
            return;
        }
        if (sideEffect instanceof SideEffect.CompleteCaptureRaw) {
            saveFaceCapture(BufferConversion.toJpeg(((SideEffect.CompleteCaptureRaw) sideEffect).getRawImage(), ImageQuality.HIGH));
            return;
        }
        if (Intrinsics.areEqual(sideEffect, SideEffect.StartTimeout.INSTANCE)) {
            this.timeoutJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C48551(null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(sideEffect, SideEffect.StopTimeout.INSTANCE)) {
            cancelAllTimeouts();
            return;
        }
        if (Intrinsics.areEqual(sideEffect, SideEffect.StartFlashTimeout.INSTANCE)) {
            cancelAllTimeouts();
            this.flashTimeoutJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C48562(null), 3, null);
        } else if (Intrinsics.areEqual(sideEffect, SideEffect.FallbackMode.INSTANCE)) {
            cancelAllTimeouts();
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), false, false, new ScanFeedback(null, null, 3, null), 3, null));
            StateMachine<State, Event, SideEffect> fallbackStateMachine = this.stateMachineFactory.getFallbackStateMachine(new C48573(this));
            fallbackStateMachine.transition(Event.OnLifecycleStart.INSTANCE);
            this.stateMachine = fallbackStateMachine;
        }
    }

    private void handleStateChange(State state) {
        if (state instanceof State.Initial) {
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), ((State.Initial) state).getReadyToCapture(), false, new ScanFeedback(Integer.valueOf(C4832R.string.yds_face_capture_frame_your_face), ScanFeedback.FrameType.DEFAULT), 2, null));
            return;
        }
        if (state instanceof State.Scanning) {
            State.Scanning scanning = (State.Scanning) state;
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), scanning.getReadyToCapture(), false, new ScanFeedback(scanning.getFeedback().getFeedbackText(), scanning.getFeedback().getFrameType()), 2, null));
        } else if (state instanceof State.WaitingForFlash) {
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), ((State.WaitingForFlash) state).getReadyToCapture(), true, null, 4, null));
        } else if (state instanceof State.WaitingForNextValidFrame) {
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), ((State.WaitingForNextValidFrame) state).getReadyToCapture(), false, null, 4, null));
        } else if (state instanceof State.WaitingForNextFrame) {
            this._viewState.setValue(CaptureViewState.CaptureInProgress.copy$default(getCurrentScanningState(), ((State.WaitingForNextFrame) state).getReadyToCapture(), false, null, 4, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateTransition(StateMachine.Transition<? extends State, ? extends Event, ? extends SideEffect> transition) {
        if (transition instanceof StateMachine.Transition.Valid) {
            StateMachine.Transition.Valid valid = (StateMachine.Transition.Valid) transition;
            SideEffect sideEffect = (SideEffect) valid.getSideEffect();
            if (sideEffect != null) {
                handleSideEffect(sideEffect);
            }
            handleStateChange((State) valid.getToState());
        }
    }

    private void saveFaceCapture(byte[] capture) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C48601(capture, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object startFlashTimeout(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.C48611
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$1 r0 = (com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.C48611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$1 r0 = new com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel r0 = (com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.computationContext
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$2 r2 = new com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startFlashTimeout$2
            r4 = 0
            r2.<init>(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r5
        L4c:
            com.tinder.StateMachine<com.yoti.mobile.android.facecapture.view.capture.model.State, com.yoti.mobile.android.facecapture.view.capture.model.Event, com.yoti.mobile.android.facecapture.view.capture.model.SideEffect> r6 = r0.stateMachine
            if (r6 == 0) goto L55
            com.yoti.mobile.android.facecapture.view.capture.model.Event$OnFlashTimeout r0 = com.yoti.mobile.android.facecapture.view.capture.model.Event.OnFlashTimeout.INSTANCE
            r6.transition(r0)
        L55:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.startFlashTimeout(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object startTimeout(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.C48631
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$1 r0 = (com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.C48631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$1 r0 = new com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel r0 = (com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.computationContext
            com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$2 r2 = new com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel$startTimeout$2
            r4 = 0
            r2.<init>(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r0 = r5
        L4c:
            com.tinder.StateMachine<com.yoti.mobile.android.facecapture.view.capture.model.State, com.yoti.mobile.android.facecapture.view.capture.model.Event, com.yoti.mobile.android.facecapture.view.capture.model.SideEffect> r6 = r0.stateMachine
            if (r6 == 0) goto L58
            com.yoti.mobile.android.facecapture.view.capture.model.Event$OnTimeout r0 = com.yoti.mobile.android.facecapture.view.capture.model.Event.OnTimeout.INSTANCE
            r6.transition(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L58:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Face capture state machine not initialized"
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel.startTimeout(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public LiveData<SingleEvent<CaptureNavigationEvent>> getNavigationEvent() {
        return this.navigationEvent;
    }

    public LiveData<CaptureViewState> getViewState() {
        return this.viewState;
    }

    public void handleViewEvent(FaceCaptureViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FaceCaptureViewEvent.OnAnalysisStarted) {
            this.captureConfig = ((FaceCaptureViewEvent.OnAnalysisStarted) event).getConfig();
            StateMachine<State, Event, SideEffect> autoCaptureStateMachine = this.captureConfigurationProvider.getCaptureMode() == CaptureMode.AUTO ? this.stateMachineFactory.getAutoCaptureStateMachine(new C48581(this)) : this.stateMachineFactory.getManualCaptureStateMachine(new C48592(this));
            autoCaptureStateMachine.transition(Event.OnLifecycleStart.INSTANCE);
            this.stateMachine = autoCaptureStateMachine;
            return;
        }
        if (event instanceof FaceCaptureViewEvent.OnCameraError) {
            C4588L.logError("FaceCaptureViewModel", "OnCameraError while initialising camera", ((FaceCaptureViewEvent.OnCameraError) event).getCause());
            return;
        }
        if (event instanceof FaceCaptureViewEvent.OnMissingPermissions) {
            C4588L.logError$default("FaceCaptureViewModel", "OnMissingPermissions while initialising camera", null, 4, null);
            return;
        }
        if (event instanceof FaceCaptureViewEvent.OnFaceCaptureFinished) {
            deleteFaceCapture();
            return;
        }
        StateMachine<State, Event, SideEffect> stateMachine = this.stateMachine;
        if (stateMachine == null) {
            throw new IllegalArgumentException("Face capture state machine not initialized".toString());
        }
        stateMachine.transition(this.eventMapper.map(event));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        StateMachine<State, Event, SideEffect> stateMachine = this.stateMachine;
        if (stateMachine != null) {
            stateMachine.transition(Event.OnLifecycleStop.INSTANCE);
        }
    }
}
