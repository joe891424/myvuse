package com.yoti.mobile.android.documentcapture.view.requirements;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.GuidelinesViewData;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.documentcapture.view.DocumentSideEffect;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewEvent;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewState;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementsViewData;
import com.yoti.mobile.android.documentcapture.view.selection.ValidationAndGuidanceEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
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
@Metadata(m5597d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u001fH\u0014J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0017H\u0016R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewModel;", "Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "documentViewModelHelper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "validationAndGuidanceEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;Lcom/yoti/mobile/android/documentcapture/view/selection/ValidationAndGuidanceEntityToViewDataMapper;)V", "_sideEffect", "Lkotlinx/coroutines/channels/Channel;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentSideEffect;", "_viewState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsViewState;", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "sideEffect", "Lkotlinx/coroutines/flow/Flow;", "getSideEffect", "()Lkotlinx/coroutines/flow/Flow;", "viewState", "getViewState", "handleFetchSuccess", "", "documentCaptureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "handleIncorrectDocument", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "onCleared", "setSavedStateHandle", "handle", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentRequirementsViewModel extends NavigationViewModel implements SavedStateHandleHolder {
    private final Channel<DocumentSideEffect> _sideEffect;
    private final MutableSharedFlow<DocumentRequirementsViewState> _viewState;
    private final DocumentViewModelHelper documentViewModelHelper;
    private final DocumentCaptureConfiguration featureConfiguration;
    private SavedStateHandle savedStateHandle;
    private final SessionStatus sessionStatus;
    private final ValidationAndGuidanceEntityToViewDataMapper validationAndGuidanceEntityToViewDataMapper;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1", m5608f = "DocumentRequirementsViewModel.kt", m5609i = {}, m5610l = {82}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C46841(Continuation<? super C46841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C46841 c46841 = DocumentRequirementsViewModel.this.new C46841(continuation);
            c46841.L$0 = obj;
            return c46841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Flow<DocumentViewModelHelper.State> state = DocumentRequirementsViewModel.this.documentViewModelHelper.getState();
                final DocumentRequirementsViewModel documentRequirementsViewModel = DocumentRequirementsViewModel.this;
                FlowCollector<? super DocumentViewModelHelper.State> flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel.1.1

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$1", m5608f = "DocumentRequirementsViewModel.kt", m5609i = {}, m5610l = {86}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class C60091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentRequirementsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C60091(DocumentRequirementsViewModel documentRequirementsViewModel, Continuation<? super C60091> continuation) {
                            super(2, continuation);
                            this.this$0 = documentRequirementsViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C60091(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C60091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$2, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$2", m5608f = "DocumentRequirementsViewModel.kt", m5609i = {}, m5610l = {89}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentRequirementsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(DocumentRequirementsViewModel documentRequirementsViewModel, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.this$0 = documentRequirementsViewModel;
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$3, reason: invalid class name */
                    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$3", m5608f = "DocumentRequirementsViewModel.kt", m5609i = {}, m5610l = {93}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ DocumentRequirementsViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(DocumentRequirementsViewModel documentRequirementsViewModel, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.this$0 = documentRequirementsViewModel;
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

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsViewModel$1$1$WhenMappings */
                    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[DocumentViewModelHelper.State.LoadingData.DataType.values().length];
                            iArr[DocumentViewModelHelper.State.LoadingData.DataType.DOCUMENT_RESOURCE_CONFIGURATION.ordinal()] = 1;
                            iArr[DocumentViewModelHelper.State.LoadingData.DataType.DOCUMENT_SCAN_CONFIGURATION.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((DocumentViewModelHelper.State) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(DocumentViewModelHelper.State state2, Continuation<? super Unit> continuation) {
                        Job jobLaunch$default;
                        if (state2 instanceof DocumentViewModelHelper.State.LoadingData) {
                            int i2 = WhenMappings.$EnumSwitchMapping$0[((DocumentViewModelHelper.State.LoadingData) state2).getDataType().ordinal()];
                            if (i2 == 1) {
                                documentRequirementsViewModel._viewState.tryEmit(new DocumentRequirementsViewState.Loading(documentRequirementsViewModel.getNavigationIcon()));
                            } else if (i2 == 2 && (jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C60091(documentRequirementsViewModel, null), 3, null)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return jobLaunch$default;
                            }
                        } else if (state2 instanceof DocumentViewModelHelper.State.Failure) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(documentRequirementsViewModel, null), 3, null);
                            documentRequirementsViewModel._viewState.tryEmit(new DocumentRequirementsViewState.Error(((DocumentViewModelHelper.State.Failure) state2).getFailure()));
                        } else if (state2 instanceof DocumentViewModelHelper.State.NavigationPending) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(documentRequirementsViewModel, null), 3, null);
                            documentRequirementsViewModel.sendCoordinatorEvent(((DocumentViewModelHelper.State.NavigationPending) state2).getNavigationEvent());
                        } else if (state2 instanceof DocumentViewModelHelper.State.Successful) {
                            documentRequirementsViewModel.handleFetchSuccess(((DocumentViewModelHelper.State.Successful) state2).getResourceConfigEntity());
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
    public DocumentRequirementsViewModel(DocumentViewModelHelper documentViewModelHelper, SessionStatus sessionStatus, DocumentCaptureConfiguration featureConfiguration, ValidationAndGuidanceEntityToViewDataMapper validationAndGuidanceEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(documentViewModelHelper, "documentViewModelHelper");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(validationAndGuidanceEntityToViewDataMapper, "validationAndGuidanceEntityToViewDataMapper");
        this.documentViewModelHelper = documentViewModelHelper;
        this.sessionStatus = sessionStatus;
        this.featureConfiguration = featureConfiguration;
        this.validationAndGuidanceEntityToViewDataMapper = validationAndGuidanceEntityToViewDataMapper;
        this._viewState = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._sideEffect = ChannelKt.Channel$default(-2, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46841(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationIcon getNavigationIcon() {
        return this.featureConfiguration.getIsSingleStepFlow() ? NavigationIcon.BACK_BLUE : NavigationIcon.CLOSE_BLUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchSuccess(DocumentResourceConfigEntity documentCaptureConfiguration) {
        DocumentResourceConfigEntity.DocumentTypeEntity documentType = documentCaptureConfiguration.getDocument().getDocumentType();
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        SavedStateHandle savedStateHandle2 = null;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set(DocumentRequirementsViewModelKt.KEY_DOCUMENT_TYPE, documentType);
        DocumentResourceConfigEntity.CountryEntity country = documentCaptureConfiguration.getCountry();
        String iso3Code = country != null ? country.getIso3Code() : null;
        if (iso3Code == null) {
            throw new IllegalArgumentException("Country iso code should not be null, validation and guidance is only applicable for non selectable document flows!".toString());
        }
        SavedStateHandle savedStateHandle3 = this.savedStateHandle;
        if (savedStateHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle3 = null;
        }
        savedStateHandle3.set("KEY_ISO_3_CODE", iso3Code);
        DocumentViewModelHelper.setDocumentData$default(this.documentViewModelHelper, documentType, iso3Code, null, 4, null);
        DocumentResourceConfigEntity.ValidationAndGuidanceEntity validationAndGuidanceEntity = documentCaptureConfiguration.getValidationAndGuidanceConfiguration().get(documentType);
        if (validationAndGuidanceEntity == null) {
            throw new IllegalArgumentException("ValidationAndGuidanceEntity should not be null, validation and guidance is only applicable for non selectable document flows!".toString());
        }
        DocumentRequirementsViewData documentRequirementsViewDataMap2 = this.validationAndGuidanceEntityToViewDataMapper.map(new ValidationAndGuidanceEntityToViewDataMapper.MapperParams(validationAndGuidanceEntity, new ValidationAndGuidanceEntityToViewDataMapper.MapperParams.DynamicCopyValues(iso3Code, documentType, documentCaptureConfiguration.getApplicantProfileEntity())));
        SavedStateHandle savedStateHandle4 = this.savedStateHandle;
        if (savedStateHandle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
        } else {
            savedStateHandle2 = savedStateHandle4;
        }
        savedStateHandle2.set(DocumentRequirementsViewModelKt.KEY_DOCUMENT_REQUIREMENTS_VIEW_DATA, documentRequirementsViewDataMap2);
        this._viewState.tryEmit(new DocumentRequirementsViewState.Success(documentRequirementsViewDataMap2, getNavigationIcon()));
    }

    private final void handleIncorrectDocument() {
        this.sessionStatus.setSessionStatus(SessionStatusType.MANDATORY_DOCUMENT_NOT_PROVIDED);
        sendCoordinatorEvent(DocumentRequirementsNavigationEvent.CloseSdk.INSTANCE);
    }

    public final Flow<DocumentSideEffect> getSideEffect() {
        return FlowKt.receiveAsFlow(this._sideEffect);
    }

    public final Flow<DocumentRequirementsViewState> getViewState() {
        return this._viewState;
    }

    public final void handleViewEvent(DocumentViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (!Intrinsics.areEqual(viewEvent, DocumentRequirementsViewEvent.SeeScanningGuidelines.INSTANCE)) {
            if (Intrinsics.areEqual(viewEvent, DocumentRequirementsViewEvent.IncorrectDocument.INSTANCE)) {
                handleIncorrectDocument();
                return;
            } else {
                this.documentViewModelHelper.handleViewEvent(viewEvent);
                return;
            }
        }
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        DocumentRequirementsViewData documentRequirementsViewData = (DocumentRequirementsViewData) savedStateHandle.get(DocumentRequirementsViewModelKt.KEY_DOCUMENT_REQUIREMENTS_VIEW_DATA);
        GuidelinesViewData guidelinesViewData = documentRequirementsViewData != null ? documentRequirementsViewData.getGuidelinesViewData() : null;
        if (guidelinesViewData == null) {
            throw new IllegalArgumentException("DocumentRequirementsViewData must not be null".toString());
        }
        sendCoordinatorEvent(new DocumentRequirementsNavigationEvent.NavigateToScanningGuidelines(guidelinesViewData));
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.documentViewModelHelper.cleanup();
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
        SavedStateHandle savedStateHandle = null;
        if (handle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            handle = null;
        }
        DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity = (DocumentResourceConfigEntity.DocumentTypeEntity) handle.get(DocumentRequirementsViewModelKt.KEY_DOCUMENT_TYPE);
        SavedStateHandle savedStateHandle2 = this.savedStateHandle;
        if (savedStateHandle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle2 = null;
        }
        String str = (String) savedStateHandle2.get("KEY_ISO_3_CODE");
        if (documentTypeEntity != null && str != null) {
            DocumentViewModelHelper.setDocumentData$default(this.documentViewModelHelper, documentTypeEntity, str, null, 4, null);
        }
        SavedStateHandle savedStateHandle3 = this.savedStateHandle;
        if (savedStateHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
        } else {
            savedStateHandle = savedStateHandle3;
        }
        DocumentRequirementsViewData documentRequirementsViewData = (DocumentRequirementsViewData) savedStateHandle.get(DocumentRequirementsViewModelKt.KEY_DOCUMENT_REQUIREMENTS_VIEW_DATA);
        if (documentRequirementsViewData == null) {
            this.documentViewModelHelper.handleViewEvent(DocumentViewEvent.ViewCreated.INSTANCE);
        } else {
            this._viewState.tryEmit(new DocumentRequirementsViewState.Success(documentRequirementsViewData, getNavigationIcon()));
        }
    }
}
