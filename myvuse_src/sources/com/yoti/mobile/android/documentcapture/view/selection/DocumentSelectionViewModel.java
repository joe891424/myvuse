package com.yoti.mobile.android.documentcapture.view.selection;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commons.navigation.NavigationViewModel;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentFeatureError;
import com.yoti.mobile.android.documentcapture.p054di.DocumentSelection;
import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewModelHelper;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewEvent;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewState;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
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
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002Bc\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0019\b\u0001\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0002\b\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\tH\u0002J\u0018\u00108\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u00104\u001a\u000205H\u0002J\u000e\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020,H\u0014J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020$H\u0016J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\nH\u0002R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0002\b\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewModel;", "Lcom/yoti/mobile/android/commons/navigation/NavigationViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "documentViewModelHelper", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "documentResourceConfigEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "Lkotlin/jvm/JvmSuppressWildcards;", "documentTypeViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "errorToFailureMapper", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/documentcapture/domain/DocumentFeatureErrorToSessionStatusTypeMapper;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/documentcapture/domain/DocumentFeatureErrorToSessionStatusTypeMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState;", "value", "documentSelectionViewData", "getDocumentSelectionViewData", "()Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;", "setDocumentSelectionViewData", "(Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewData;)V", "navigationIcon", "Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "getNavigationIcon", "()Lcom/yoti/mobile/android/common/ui/widgets/NavigationIcon;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "viewState", "Lkotlinx/coroutines/flow/Flow;", "getViewState", "()Lkotlinx/coroutines/flow/Flow;", "visibilityToggles", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentSelectionViewState$VisibilityToggles;", "collectDocumentViewEventHandlerState", "", "handleCountryNotListed", "handleCountrySelected", "country", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountrySelectionOptionViewData;", "handleDocumentSelected", "document", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentViewData;", "isCameraPermissionNeeded", "", "handleFetchSuccess", "documentCaptureConfiguration", "handleShowDocumentEducational", "selectedCountry", "Lcom/yoti/mobile/android/documentcapture/view/selection/CountryViewData;", "handleStartScan", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "onCleared", "setSavedStateHandle", "handle", "updateDocumentSelectionViewData", "viewData", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentSelectionViewModel extends NavigationViewModel implements SavedStateHandleHolder {
    private final MutableSharedFlow<DocumentSelectionViewState> _viewState;
    private final Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> documentResourceConfigEntityToViewDataMapper;
    private final DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper;
    private final DocumentViewModelHelper documentViewModelHelper;
    private final Mapper<Throwable, YdsFailure> errorToFailureMapper;
    private final DocumentFeatureErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final DocumentCaptureConfiguration featureConfiguration;
    private SavedStateHandle savedStateHandle;
    private final SessionStatus sessionStatus;
    private final DocumentSelectionViewState.VisibilityToggles visibilityToggles;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel$collectDocumentViewEventHandlerState$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel$collectDocumentViewEventHandlerState$1", m5608f = "DocumentSelectionViewModel.kt", m5609i = {}, m5610l = {190}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C46911(Continuation<? super C46911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentSelectionViewModel.this.new C46911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<DocumentViewModelHelper.State> state = DocumentSelectionViewModel.this.documentViewModelHelper.getState();
                final DocumentSelectionViewModel documentSelectionViewModel = DocumentSelectionViewModel.this;
                FlowCollector<? super DocumentViewModelHelper.State> flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel.collectDocumentViewEventHandlerState.1.1

                    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.view.selection.DocumentSelectionViewModel$collectDocumentViewEventHandlerState$1$1$WhenMappings */
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
                        if (state2 instanceof DocumentViewModelHelper.State.LoadingData) {
                            if (WhenMappings.$EnumSwitchMapping$0[((DocumentViewModelHelper.State.LoadingData) state2).getDataType().ordinal()] == 1) {
                                documentSelectionViewModel._viewState.tryEmit(new DocumentSelectionViewState.Loading(documentSelectionViewModel.getNavigationIcon()));
                            }
                        } else if (state2 instanceof DocumentViewModelHelper.State.Failure) {
                            documentSelectionViewModel._viewState.tryEmit(new DocumentSelectionViewState.Error(((DocumentViewModelHelper.State.Failure) state2).getFailure()));
                        } else if (state2 instanceof DocumentViewModelHelper.State.NavigationPending) {
                            documentSelectionViewModel.sendCoordinatorEvent(((DocumentViewModelHelper.State.NavigationPending) state2).getNavigationEvent());
                        } else if (state2 instanceof DocumentViewModelHelper.State.Successful) {
                            documentSelectionViewModel.handleFetchSuccess(((DocumentViewModelHelper.State.Successful) state2).getResourceConfigEntity());
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
    public DocumentSelectionViewModel(DocumentViewModelHelper documentViewModelHelper, SessionStatus sessionStatus, Mapper<DocumentResourceConfigEntity, DocumentSelectionViewData> documentResourceConfigEntityToViewDataMapper, DocumentTypeViewDataToEntityMapper documentTypeViewDataToEntityMapper, @DocumentSelection Mapper<Throwable, YdsFailure> errorToFailureMapper, DocumentFeatureErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper, DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(documentViewModelHelper, "documentViewModelHelper");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(documentResourceConfigEntityToViewDataMapper, "documentResourceConfigEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(documentTypeViewDataToEntityMapper, "documentTypeViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.documentViewModelHelper = documentViewModelHelper;
        this.sessionStatus = sessionStatus;
        this.documentResourceConfigEntityToViewDataMapper = documentResourceConfigEntityToViewDataMapper;
        this.documentTypeViewDataToEntityMapper = documentTypeViewDataToEntityMapper;
        this.errorToFailureMapper = errorToFailureMapper;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        this.featureConfiguration = featureConfiguration;
        boolean showIdentityCheck = featureConfiguration.getUiSessionConfiguration().getShowIdentityCheck();
        this.visibilityToggles = new DocumentSelectionViewState.VisibilityToggles(showIdentityCheck, !showIdentityCheck && featureConfiguration.getIsMoreAboutVerificationEnabled(), featureConfiguration.getIsDoNotHaveDocumentOptionEnabled());
        collectDocumentViewEventHandlerState();
        this._viewState = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
    }

    private final void collectDocumentViewEventHandlerState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46911(null), 3, null);
    }

    private final DocumentSelectionViewData getDocumentSelectionViewData() {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        return (DocumentSelectionViewData) savedStateHandle.get(DocumentSelectionViewModelKt.KEY_DOCUMENT_SELECTION_VIEW_DATA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationIcon getNavigationIcon() {
        return this.featureConfiguration.getIsSingleStepFlow() ? NavigationIcon.BACK_BLUE : NavigationIcon.CLOSE_BLUE;
    }

    private final void handleCountryNotListed() {
        DocumentFeatureError.DocumentCountryNotListedError documentCountryNotListedError = DocumentFeatureError.DocumentCountryNotListedError.INSTANCE;
        this._viewState.tryEmit(new DocumentSelectionViewState.Error(this.errorToFailureMapper.map(documentCountryNotListedError)));
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map((Throwable) documentCountryNotListedError));
    }

    private final void handleCountrySelected(CountrySelectionOptionViewData country) {
        DocumentSelectionViewData documentSelectionViewData = getDocumentSelectionViewData();
        if (documentSelectionViewData == null) {
            throw new IllegalArgumentException("DocumentSelectionViewData must not be null".toString());
        }
        updateDocumentSelectionViewData(DocumentSelectionViewData.copy$default(documentSelectionViewData, null, null, country, null, null, null, 59, null));
        sendCoordinatorEvent(DocumentNavigationEvent.NavigateBack.INSTANCE);
    }

    private final void handleDocumentSelected(DocumentViewData document, boolean isCameraPermissionNeeded) {
        DocumentSelectionViewData documentSelectionViewData = getDocumentSelectionViewData();
        CountrySelectionOptionViewData selectedCountryOption = documentSelectionViewData != null ? documentSelectionViewData.getSelectedCountryOption() : null;
        CountryViewData countryViewData = selectedCountryOption instanceof CountryViewData ? (CountryViewData) selectedCountryOption : null;
        if (countryViewData == null) {
            throw new IllegalArgumentException("Selected country must not be null".toString());
        }
        if (document.getDocumentType().getShowEducational()) {
            handleShowDocumentEducational(document, countryViewData);
        } else {
            handleStartScan(document, countryViewData, isCameraPermissionNeeded);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchSuccess(DocumentResourceConfigEntity documentCaptureConfiguration) {
        DocumentSelectionViewData map = this.documentResourceConfigEntityToViewDataMapper.map(documentCaptureConfiguration);
        this.documentViewModelHelper.setObjective(map.getObjective());
        updateDocumentSelectionViewData(map);
    }

    private final void handleShowDocumentEducational(DocumentViewData document, CountryViewData selectedCountry) {
        String iso3Code = selectedCountry.getIso3Code();
        DocumentSelectionViewData documentSelectionViewData = getDocumentSelectionViewData();
        CaptureObjectiveTypeViewData objective = documentSelectionViewData != null ? documentSelectionViewData.getObjective() : null;
        if (objective == null) {
            throw new IllegalArgumentException("Capture objective must not be null!".toString());
        }
        sendCoordinatorEvent(new DocumentSelectionNavigationEvent.NavigateToDocumentEducational(document, iso3Code, objective));
    }

    private final void handleStartScan(DocumentViewData document, CountryViewData selectedCountry, boolean isCameraPermissionNeeded) {
        DocumentViewModelHelper documentViewModelHelper = this.documentViewModelHelper;
        documentViewModelHelper.setDocumentData(this.documentTypeViewDataToEntityMapper.map(document.getDocumentType()), selectedCountry.getIso3Code(), document.getDateFromRequirement());
        documentViewModelHelper.handleViewEvent(new DocumentViewEvent.StartScan(isCameraPermissionNeeded));
    }

    private final void setDocumentSelectionViewData(DocumentSelectionViewData documentSelectionViewData) {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set(DocumentSelectionViewModelKt.KEY_DOCUMENT_SELECTION_VIEW_DATA, documentSelectionViewData);
    }

    private final void updateDocumentSelectionViewData(DocumentSelectionViewData viewData) {
        setDocumentSelectionViewData(viewData);
        this._viewState.tryEmit(new DocumentSelectionViewState.Success(viewData, this.visibilityToggles, getNavigationIcon()));
    }

    public final Flow<DocumentSelectionViewState> getViewState() {
        return this._viewState;
    }

    public final void handleViewEvent(DocumentViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        if (viewEvent instanceof DocumentSelectionViewEvent.DocumentSelected) {
            DocumentSelectionViewEvent.DocumentSelected documentSelected = (DocumentSelectionViewEvent.DocumentSelected) viewEvent;
            handleDocumentSelected(documentSelected.getDocument(), documentSelected.isCameraPermissionNeeded());
        } else {
            if (viewEvent instanceof DocumentSelectionViewEvent.CountrySelected) {
                handleCountrySelected(((DocumentSelectionViewEvent.CountrySelected) viewEvent).getCountry());
                return;
            }
            if (Intrinsics.areEqual(viewEvent, DocumentSelectionViewEvent.ChangeCountry.INSTANCE)) {
                sendCoordinatorEvent(DocumentSelectionNavigationEvent.NavigateToCountrySelection.INSTANCE);
            } else if (Intrinsics.areEqual(viewEvent, DocumentSelectionViewEvent.CountryNotListed.INSTANCE)) {
                handleCountryNotListed();
            } else {
                this.documentViewModelHelper.handleViewEvent(viewEvent);
            }
        }
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
        DocumentSelectionViewData documentSelectionViewData = getDocumentSelectionViewData();
        if (documentSelectionViewData == null) {
            this.documentViewModelHelper.handleViewEvent(DocumentViewEvent.ViewCreated.INSTANCE);
        } else {
            this._viewState.tryEmit(new DocumentSelectionViewState.Success(documentSelectionViewData, this.visibilityToggles, getNavigationIcon()));
        }
    }
}
