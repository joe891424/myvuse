package com.yoti.mobile.android.documentcapture.view.additional_instructions;

import androidx.lifecycle.ViewModelKt;
import com.facebook.soloader.Elf64_Ehdr;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewEvent;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewState;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentTypeViewDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import javax.inject.Inject;
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
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0018H\u0014R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewModel;", "Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "documentViewModelHelper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "documentTypeViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;)V", "_sideEffect", "Lkotlinx/coroutines/channels/Channel;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "_viewState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsViewState;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "viewState", "getViewState", "handleBackOrExitViewEvent", "", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "init", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "countryIso3Code", "", "onCleared", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AdditionalInstructionsViewModel extends NavigationViewModel {
    private final Channel<DocumentSideEffect> _sideEffect;
    private final MutableSharedFlow<AdditionalInstructionsViewState> _viewState;
    private final DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper;
    private final DocumentViewModelHelper documentViewModelHelper;
    private final DocumentCaptureConfiguration featureConfiguration;
    private final SessionStatus sessionStatus;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1", m5608f = "AdditionalInstructionsViewModel.kt", m5609i = {}, m5610l = {54}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C46801(Continuation<? super C46801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46801 c46801 = AdditionalInstructionsViewModel.this.new C46801(continuation);
            c46801.L$0 = obj;
            return c46801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<DocumentViewModelHelper.State> state = AdditionalInstructionsViewModel.this.documentViewModelHelper.getState();
                final AdditionalInstructionsViewModel additionalInstructionsViewModel = AdditionalInstructionsViewModel.this;
                FlowCollector<? super DocumentViewModelHelper.State> flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel.1.1

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$1", m5608f = "AdditionalInstructionsViewModel.kt", m5609i = {}, m5610l = {56}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class C60011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ AdditionalInstructionsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C60011(AdditionalInstructionsViewModel additionalInstructionsViewModel, Continuation<? super C60011> continuation) {
                            super(2, continuation);
                            this.this$0 = additionalInstructionsViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C60011(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C60011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.ShowCtaLoading showCtaLoading = DocumentSideEffect.ShowCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(showCtaLoading, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$2, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$2", m5608f = "AdditionalInstructionsViewModel.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shentsize}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ AdditionalInstructionsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(AdditionalInstructionsViewModel additionalInstructionsViewModel, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.this$0 = additionalInstructionsViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.HideCtaLoading hideCtaLoading = DocumentSideEffect.HideCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(hideCtaLoading, this) == coroutine_suspended) {
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$3, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsViewModel$1$1$3", m5608f = "AdditionalInstructionsViewModel.kt", m5609i = {}, m5610l = {Elf64_Ehdr.e_shstrndx}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ AdditionalInstructionsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(AdditionalInstructionsViewModel additionalInstructionsViewModel, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.this$0 = additionalInstructionsViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Channel channel = this.this$0._sideEffect;
                                DocumentSideEffect.HideCtaLoading hideCtaLoading = DocumentSideEffect.HideCtaLoading.INSTANCE;
                                this.label = 1;
                                if (channel.send(hideCtaLoading, this) == coroutine_suspended) {
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

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((DocumentViewModelHelper.State) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(DocumentViewModelHelper.State state2, Continuation<? super Unit> continuation) {
                        if (state2 instanceof DocumentViewModelHelper.State.LoadingData) {
                            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C60011(additionalInstructionsViewModel, null), 3, null);
                            if (jobLaunch$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return jobLaunch$default;
                            }
                        } else if (state2 instanceof DocumentViewModelHelper.State.Failure) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(additionalInstructionsViewModel, null), 3, null);
                            additionalInstructionsViewModel._viewState.tryEmit(new AdditionalInstructionsViewState.Error(((DocumentViewModelHelper.State.Failure) state2).getFailure()));
                        } else if (state2 instanceof DocumentViewModelHelper.State.NavigationPending) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(additionalInstructionsViewModel, null), 3, null);
                            additionalInstructionsViewModel.sendCoordinatorEvent(((DocumentViewModelHelper.State.NavigationPending) state2).getNavigationEvent());
                        } else {
                            boolean z = state2 instanceof DocumentViewModelHelper.State.Successful;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (state.collect(flowCollector, this) == coroutine_suspended) {
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
    public AdditionalInstructionsViewModel(DocumentViewModelHelper documentViewModelHelper, DocumentCaptureConfiguration featureConfiguration, SessionStatus sessionStatus, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper) {
        Intrinsics.checkNotNullParameter(documentViewModelHelper, "documentViewModelHelper");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(documentTypeViewDataToEntityMapper, "documentTypeViewDataToEntityMapper");
        this.documentViewModelHelper = documentViewModelHelper;
        this.featureConfiguration = featureConfiguration;
        this.sessionStatus = sessionStatus;
        this.documentTypeViewDataToEntityMapper = documentTypeViewDataToEntityMapper;
        this._viewState = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._sideEffect = ChannelKt.Channel$default(-2, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46801(null), 3, null);
    }

    private final void handleBackOrExitViewEvent() {
        if (this.featureConfiguration.getIsSelectableDocumentFlow()) {
            sendCoordinatorEvent(AdditionalInstructionsNavigationEvent.BackToSelection.INSTANCE);
        } else {
            this.sessionStatus.setSessionStatus(SessionStatusType.USER_WRONG_SUBMISSION);
            sendCoordinatorEvent(AdditionalInstructionsNavigationEvent.CloseSdk.INSTANCE);
        }
    }

    public final Flow<DocumentSideEffect> getSideEffect() {
        return FlowKt.receiveAsFlow(this._sideEffect);
    }

    public final Flow<AdditionalInstructionsViewState> getViewState() {
        return this._viewState;
    }

    public final void handleViewEvent(DocumentViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (Intrinsics.areEqual(viewEvent, AdditionalInstructionsViewEvent.OnBackOrExit.INSTANCE)) {
            handleBackOrExitViewEvent();
        } else {
            this.documentViewModelHelper.handleViewEvent(viewEvent);
        }
    }

    public final void init(DocumentTypeViewData documentType, String countryIso3Code) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        DocumentViewModelHelper.setDocumentData$default(this.documentViewModelHelper, this.documentTypeViewDataToEntityMapper.map(documentType), countryIso3Code, null, 4, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.documentViewModelHelper.cleanup();
    }
}
