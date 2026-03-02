package com.yoti.mobile.android.mrtd.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yoti.mobile.android.commons.util.C4588L;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.mrtd.domain.MrtdGetReadEventsUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcEnabledInteractor;
import com.yoti.mobile.android.mrtd.domain.NfcStartListeningUseCase;
import com.yoti.mobile.android.mrtd.domain.NfcStopListeningUseCase;
import com.yoti.mobile.android.mrtd.domain.model.MrtdReadState;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0011\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u001c\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00132\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H\u0012J\b\u0010)\u001a\u00020#H\u0016J\b\u0010*\u001a\u00020#H\u0012J\b\u0010+\u001a\u00020#H\u0017J\u0019\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020(H\u0092@ø\u0001\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020#H\u0016J\b\u00100\u001a\u00020#H\u0016R$\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\fX\u0092\u0004¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00138R@RX\u0092\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "Landroidx/lifecycle/ViewModel;", "nfcEnabledInteractor", "Lcom/yoti/mobile/android/mrtd/domain/NfcEnabledInteractor;", "startListening", "Lcom/yoti/mobile/android/mrtd/domain/NfcStartListeningUseCase;", "getReadEvents", "Lcom/yoti/mobile/android/mrtd/domain/MrtdGetReadEventsUseCase;", "stopListening", "Lcom/yoti/mobile/android/mrtd/domain/NfcStopListeningUseCase;", "(Lcom/yoti/mobile/android/mrtd/domain/NfcEnabledInteractor;Lcom/yoti/mobile/android/mrtd/domain/NfcStartListeningUseCase;Lcom/yoti/mobile/android/mrtd/domain/MrtdGetReadEventsUseCase;Lcom/yoti/mobile/android/mrtd/domain/NfcStopListeningUseCase;)V", "_chipData", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "_currentScreen", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;", "chipData", "Landroidx/lifecycle/LiveData;", "getChipData", "()Landroidx/lifecycle/LiveData;", "currentScreen", "getCurrentScreen", "value", "currentScreenValue", "getCurrentScreenValue", "()Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;", "setCurrentScreenValue", "(Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;)V", "readStateJob", "Lkotlinx/coroutines/Job;", "abortScan", "", "cancelScan", "cancelScanningState", FirebaseAnalytics.Param.DESTINATION, "errorState", "Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;", "checkScanStatus", "moveToScanningState", "onCleared", "onReadEvent", "newState", "(Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryScan", "startScan", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class MrtdScanViewModel extends ViewModel {
    private final MutableLiveData<Map<Integer, byte[]>> _chipData;
    private final MutableLiveData<SingleEvent<MrtdScreen>> _currentScreen;
    private final LiveData<Map<Integer, byte[]>> chipData;
    private final LiveData<SingleEvent<MrtdScreen>> currentScreen;
    private final MrtdGetReadEventsUseCase getReadEvents;
    private final NfcEnabledInteractor nfcEnabledInteractor;
    private Job readStateJob;
    private final NfcStartListeningUseCase startListening;
    private final NfcStopListeningUseCase stopListening;

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$moveToScanningState$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$moveToScanningState$1", m5608f = "MrtdScanViewModel.kt", m5609i = {}, m5610l = {102}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C49091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$moveToScanningState$1$1, reason: invalid class name */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        /* synthetic */ class AnonymousClass1 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ MrtdScanViewModel $tmp0;

            AnonymousClass1(MrtdScanViewModel mrtdScanViewModel) {
                this.$tmp0 = mrtdScanViewModel;
            }

            public final Object emit(MrtdReadState mrtdReadState, Continuation<? super Unit> continuation) {
                Object objOnReadEvent = this.$tmp0.onReadEvent(mrtdReadState, continuation);
                return objOnReadEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objOnReadEvent : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((MrtdReadState) obj, (Continuation<? super Unit>) continuation);
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return new FunctionReferenceImpl(2, this.$tmp0, MrtdScanViewModel.class, "onReadEvent", "onReadEvent(Lcom/yoti/mobile/android/mrtd/domain/model/MrtdReadState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }
        }

        C49091(Continuation<? super C49091> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MrtdScanViewModel.this.new C49091(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C49091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<MrtdReadState> flowInvoke = MrtdScanViewModel.this.getReadEvents.invoke();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(MrtdScanViewModel.this);
                this.label = 1;
                if (flowInvoke.collect(anonymousClass1, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$onReadEvent$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.mrtd.view.MrtdScanViewModel", m5608f = "MrtdScanViewModel.kt", m5609i = {0, 0}, m5610l = {114}, m5611m = "onReadEvent", m5612n = {"this", "newState"}, m5613s = {"L$0", "L$1"})
    static final class C49101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C49101(Continuation<? super C49101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MrtdScanViewModel.this.onReadEvent(null, this);
        }
    }

    @Inject
    public MrtdScanViewModel(NfcEnabledInteractor nfcEnabledInteractor, NfcStartListeningUseCase startListening, MrtdGetReadEventsUseCase getReadEvents, NfcStopListeningUseCase stopListening) {
        Intrinsics.checkNotNullParameter(nfcEnabledInteractor, "nfcEnabledInteractor");
        Intrinsics.checkNotNullParameter(startListening, "startListening");
        Intrinsics.checkNotNullParameter(getReadEvents, "getReadEvents");
        Intrinsics.checkNotNullParameter(stopListening, "stopListening");
        this.nfcEnabledInteractor = nfcEnabledInteractor;
        this.startListening = startListening;
        this.getReadEvents = getReadEvents;
        this.stopListening = stopListening;
        startListening.invoke();
        MutableLiveData<SingleEvent<MrtdScreen>> mutableLiveData = new MutableLiveData<>(new SingleEvent(MrtdScreen.EDUCATION));
        this._currentScreen = mutableLiveData;
        this.currentScreen = mutableLiveData;
        MutableLiveData<Map<Integer, byte[]>> mutableLiveData2 = new MutableLiveData<>();
        this._chipData = mutableLiveData2;
        this.chipData = mutableLiveData2;
    }

    private void cancelScanningState(MrtdScreen destination, MrtdReadState errorState) {
        C4588L.logError$default("MrtdScanViewModel", "Cancelling scanning state, error state: " + errorState, null, 4, null);
        Job job = this.readStateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        setCurrentScreenValue(destination);
    }

    static /* synthetic */ void cancelScanningState$default(MrtdScanViewModel mrtdScanViewModel, MrtdScreen mrtdScreen, MrtdReadState mrtdReadState, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelScanningState");
        }
        if ((i & 2) != 0) {
            mrtdReadState = null;
        }
        mrtdScanViewModel.cancelScanningState(mrtdScreen, mrtdReadState);
    }

    private MrtdScreen getCurrentScreenValue() {
        SingleEvent<MrtdScreen> value = this._currentScreen.getValue();
        MrtdScreen mrtdScreenPeekContent = value != null ? value.peekContent() : null;
        Intrinsics.checkNotNull(mrtdScreenPeekContent);
        return mrtdScreenPeekContent;
    }

    private void moveToScanningState() {
        setCurrentScreenValue(MrtdScreen.SCAN_START);
        this.readStateJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C49091(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object onReadEvent(com.yoti.mobile.android.mrtd.domain.model.MrtdReadState r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.yoti.mobile.android.mrtd.view.MrtdScanViewModel.C49101
            if (r0 == 0) goto L13
            r0 = r6
            com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$onReadEvent$1 r0 = (com.yoti.mobile.android.mrtd.view.MrtdScanViewModel.C49101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$onReadEvent$1 r0 = new com.yoti.mobile.android.mrtd.view.MrtdScanViewModel$onReadEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$1
            com.yoti.mobile.android.mrtd.domain.model.MrtdReadState r5 = (com.yoti.mobile.android.mrtd.domain.model.MrtdReadState) r5
            java.lang.Object r0 = r0.L$0
            com.yoti.mobile.android.mrtd.view.MrtdScanViewModel r0 = (com.yoti.mobile.android.mrtd.view.MrtdScanViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L67
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateReadingProgress
            if (r6 == 0) goto L4e
            com.yoti.mobile.android.mrtd.view.MrtdScreen r5 = r4.getCurrentScreenValue()
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.SCAN_START
            if (r5 != r6) goto L92
            com.yoti.mobile.android.mrtd.view.MrtdScreen r5 = com.yoti.mobile.android.mrtd.view.MrtdScreen.SCAN_PROGRESS
            r4.setCurrentScreenValue(r5)
            goto L92
        L4e:
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateReadingComplete
            if (r6 == 0) goto L73
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.SCAN_COMPLETE
            r4.setCurrentScreenValue(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            r2 = 2500(0x9c4, double:1.235E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r6 != r1) goto L66
            return r1
        L66:
            r0 = r4
        L67:
            androidx.lifecycle.MutableLiveData<java.util.Map<java.lang.Integer, byte[]>> r6 = r0._chipData
            com.yoti.mobile.android.mrtd.domain.model.StateReadingComplete r5 = (com.yoti.mobile.android.mrtd.domain.model.StateReadingComplete) r5
            java.util.Map r5 = r5.getResult()
            r6.setValue(r5)
            goto L92
        L73:
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateTimeout
            if (r6 == 0) goto L7d
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.ERROR_DETECT
        L79:
            r4.cancelScanningState(r6, r5)
            goto L92
        L7d:
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateTimeoutFinal
            if (r6 == 0) goto L84
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.FAIL_DETECT
            goto L79
        L84:
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateReadFailed
            if (r6 == 0) goto L8b
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.ERROR_READ
            goto L79
        L8b:
            boolean r6 = r5 instanceof com.yoti.mobile.android.mrtd.domain.model.StateReadFailedFinal
            if (r6 == 0) goto L92
            com.yoti.mobile.android.mrtd.view.MrtdScreen r6 = com.yoti.mobile.android.mrtd.view.MrtdScreen.FAIL_READ
            goto L79
        L92:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.mrtd.view.MrtdScanViewModel.onReadEvent(com.yoti.mobile.android.mrtd.domain.model.MrtdReadState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private void setCurrentScreenValue(MrtdScreen mrtdScreen) {
        this._currentScreen.setValue(new SingleEvent<>(mrtdScreen));
    }

    public void abortScan() {
        setCurrentScreenValue(MrtdScreen.ABORTED);
    }

    public void cancelScan() {
        if (getCurrentScreenValue() == MrtdScreen.SCAN_START || getCurrentScreenValue() == MrtdScreen.SCAN_PROGRESS) {
            cancelScanningState$default(this, MrtdScreen.EDUCATION, null, 2, null);
        }
    }

    public void checkScanStatus() {
        if (getCurrentScreenValue() == MrtdScreen.ENABLE_PROMPT) {
            if (this.nfcEnabledInteractor.isEnabled()) {
                moveToScanningState();
            } else {
                setCurrentScreenValue(MrtdScreen.EDUCATION);
            }
        }
    }

    public LiveData<Map<Integer, byte[]>> getChipData() {
        return this.chipData;
    }

    public LiveData<SingleEvent<MrtdScreen>> getCurrentScreen() {
        return this.currentScreen;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.stopListening.invoke();
        super.onCleared();
    }

    public void retryScan() {
        setCurrentScreenValue(MrtdScreen.EDUCATION);
    }

    public void startScan() {
        if (this.nfcEnabledInteractor.isEnabled()) {
            moveToScanningState();
        } else {
            setCurrentScreenValue(MrtdScreen.ENABLE_PROMPT);
        }
    }
}
