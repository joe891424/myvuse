package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0006\u0010%\u001a\u00020\u001bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u00108B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "scanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/sup/domain/ISupDocumentScanConfigurationRepository;", "scanConfigEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;Lcom/yoti/mobile/android/documentcapture/sup/domain/ISupDocumentScanConfigurationRepository;Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigEntityToViewDataMapper;)V", "_viewState", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "value", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;", "scanConfiguration", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;", "setScanConfiguration", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;)V", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "handleCheckCameraPermissionResult", "", "granted", "", "handleFilePickerResult", "uri", "Landroid/net/Uri;", "handleRequestCameraPermissionResult", "navigateToReview", "setSavedStateHandle", "handle", "start", "ViewState", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanViewModel extends ViewModel implements SavedStateHandleHolder {
    private final SingleLiveDataEvent<ViewState> _viewState;
    private final DocumentCaptureConfiguration featureConfiguration;
    private SavedStateHandle savedStateHandle;
    private final SupDocumentScanConfigEntityToViewDataMapper scanConfigEntityToViewDataMapper;
    private SupDocumentScanConfigurationViewData scanConfiguration;
    private final ISupDocumentScanConfigurationRepository scanConfigurationRepository;
    private final LiveData<ViewState> viewState;

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel$1", m5608f = "SupDocumentScanViewModel.kt", m5609i = {}, m5610l = {44}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C46781(Continuation<? super C46781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SupDocumentScanViewModel.this.new C46781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowFilterNotNull = FlowKt.filterNotNull(SupDocumentScanViewModel.this.scanConfigurationRepository.getScanConfigurationFlow());
                final SupDocumentScanViewModel supDocumentScanViewModel = SupDocumentScanViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SupDocumentScanConfigurationEntity) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SupDocumentScanConfigurationEntity supDocumentScanConfigurationEntity, Continuation<? super Unit> continuation) {
                        SupDocumentScanViewModel supDocumentScanViewModel2 = supDocumentScanViewModel;
                        supDocumentScanViewModel2.setScanConfiguration(supDocumentScanViewModel2.scanConfigEntityToViewDataMapper.map(supDocumentScanConfigurationEntity));
                        if (supDocumentScanViewModel.featureConfiguration.getIsValidationAndGuidanceEnabled()) {
                            supDocumentScanViewModel._viewState.setValue(ViewState.CheckCameraPermission.INSTANCE);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowFilterNotNull.collect(flowCollector, this) == coroutine_suspended) {
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

    @Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "", "()V", "CheckCameraPermission", "NavigateToReview", "RequestCameraPermission", "ShowCameraAndFilePickerChooser", "ShowFilePicker", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$CheckCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$RequestCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$ShowCameraAndFilePickerChooser;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$ShowFilePicker;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$NavigateToReview;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class ViewState {

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$CheckCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "()V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class CheckCameraPermission extends ViewState {
            public static final CheckCameraPermission INSTANCE = new CheckCameraPermission();

            private CheckCameraPermission() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$NavigateToReview;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "reviewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;)V", "getReviewData", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToReview extends ViewState {
            private final SupplementaryDocumentViewData reviewData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToReview(SupplementaryDocumentViewData reviewData) {
                super(null);
                Intrinsics.checkNotNullParameter(reviewData, "reviewData");
                this.reviewData = reviewData;
            }

            public static /* synthetic */ NavigateToReview copy$default(NavigateToReview navigateToReview, SupplementaryDocumentViewData supplementaryDocumentViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    supplementaryDocumentViewData = navigateToReview.reviewData;
                }
                return navigateToReview.copy(supplementaryDocumentViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SupplementaryDocumentViewData getReviewData() {
                return this.reviewData;
            }

            public final NavigateToReview copy(SupplementaryDocumentViewData reviewData) {
                Intrinsics.checkNotNullParameter(reviewData, "reviewData");
                return new NavigateToReview(reviewData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToReview) && Intrinsics.areEqual(this.reviewData, ((NavigateToReview) other).reviewData);
            }

            public final SupplementaryDocumentViewData getReviewData() {
                return this.reviewData;
            }

            public int hashCode() {
                return this.reviewData.hashCode();
            }

            public String toString() {
                return "NavigateToReview(reviewData=" + this.reviewData + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$RequestCameraPermission;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "()V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class RequestCameraPermission extends ViewState {
            public static final RequestCameraPermission INSTANCE = new RequestCameraPermission();

            private RequestCameraPermission() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$ShowCameraAndFilePickerChooser;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "()V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ShowCameraAndFilePickerChooser extends ViewState {
            public static final ShowCameraAndFilePickerChooser INSTANCE = new ShowCameraAndFilePickerChooser();

            private ShowCameraAndFilePickerChooser() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState$ShowFilePicker;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "()V", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class ShowFilePicker extends ViewState {
            public static final ShowFilePicker INSTANCE = new ShowFilePicker();

            private ShowFilePicker() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public SupDocumentScanViewModel(DocumentCaptureConfiguration featureConfiguration, ISupDocumentScanConfigurationRepository scanConfigurationRepository, SupDocumentScanConfigEntityToViewDataMapper scanConfigEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(scanConfigurationRepository, "scanConfigurationRepository");
        Intrinsics.checkNotNullParameter(scanConfigEntityToViewDataMapper, "scanConfigEntityToViewDataMapper");
        this.featureConfiguration = featureConfiguration;
        this.scanConfigurationRepository = scanConfigurationRepository;
        this.scanConfigEntityToViewDataMapper = scanConfigEntityToViewDataMapper;
        SingleLiveDataEvent<ViewState> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._viewState = singleLiveDataEvent;
        this.viewState = singleLiveDataEvent;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46781(null), 3, null);
    }

    private final SupDocumentScanConfigurationViewData getScanConfiguration() {
        SupDocumentScanConfigurationViewData supDocumentScanConfigurationViewData = this.scanConfiguration;
        if (supDocumentScanConfigurationViewData != null) {
            return supDocumentScanConfigurationViewData;
        }
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        return (SupDocumentScanConfigurationViewData) savedStateHandle.get(SupDocumentScanViewModelKt.KEY_SAVED_STATE_SCAN_CONFIGURATION);
    }

    private final void navigateToReview(Uri uri) {
        SupDocumentScanConfigurationViewData scanConfiguration = getScanConfiguration();
        if (scanConfiguration == null) {
            throw new IllegalArgumentException("Scan Configuration must not be null!".toString());
        }
        this._viewState.setValue(new ViewState.NavigateToReview(new SupplementaryDocumentViewData(scanConfiguration.getResourceId(), scanConfiguration.getCountryIso3Code(), scanConfiguration.getDocumentType(), uri)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setScanConfiguration(SupDocumentScanConfigurationViewData supDocumentScanConfigurationViewData) {
        this.scanConfiguration = supDocumentScanConfigurationViewData;
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set(SupDocumentScanViewModelKt.KEY_SAVED_STATE_SCAN_CONFIGURATION, supDocumentScanConfigurationViewData);
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final void handleCheckCameraPermissionResult(boolean granted) {
        this._viewState.setValue(granted ? ViewState.ShowCameraAndFilePickerChooser.INSTANCE : ViewState.RequestCameraPermission.INSTANCE);
    }

    public final void handleFilePickerResult(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        navigateToReview(uri);
    }

    public final void handleRequestCameraPermissionResult(boolean granted) {
        this._viewState.setValue(granted ? ViewState.ShowCameraAndFilePickerChooser.INSTANCE : ViewState.ShowFilePicker.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
    }

    public final void start() {
        if (this.featureConfiguration.getIsValidationAndGuidanceEnabled()) {
            return;
        }
        this._viewState.setValue(ViewState.CheckCameraPermission.INSTANCE);
    }
}
