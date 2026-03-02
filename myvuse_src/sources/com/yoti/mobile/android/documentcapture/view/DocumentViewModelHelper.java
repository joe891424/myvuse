package com.yoti.mobile.android.documentcapture.view;

import com.yoti.mobile.android.documentcapture.domain.DocumentFeatureErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.domain.GetDocumentCaptureConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.GetScanConfigurationInteractor;
import com.yoti.mobile.android.documentcapture.domain.model.DocumentFeatureError;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.domain.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.p054di.DocumentSelection;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureFailureType;
import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.DocumentViewEvent;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsFragment;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.selection.CaptureObjectiveTypeViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsDialogViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DocumentRequirementViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.error.YotiDocsError;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatusType;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003@ABBs\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0019\b\u0001\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020-2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020-H\u0002J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u00020-H\u0002J\u000e\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020>J\"\u0010?\u001a\u00020-2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001f\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006C"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;", "", "getDocumentCaptureConfigurationInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/GetDocumentCaptureConfigurationInteractor;", "getScanConfigurationInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/GetScanConfigurationInteractor;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "additionalInstructionsFragmentArgsFactory", "Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment$FragmentArgsFactory;", "documentTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "Lkotlin/jvm/JvmSuppressWildcards;", "scanConfigurationEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "errorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/documentcapture/domain/DocumentFeatureErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/documentcapture/domain/GetDocumentCaptureConfigurationInteractor;Lcom/yoti/mobile/android/documentcapture/domain/GetScanConfigurationInteractor;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/AdditionalInstructionsFragment$FragmentArgsFactory;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/yotidocs/common/Mapper;Lcom/yoti/mobile/android/documentcapture/domain/DocumentFeatureErrorToSessionStatusTypeMapper;)V", "_state", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "countryIso3Code", "", "dateFromRequirement", "Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentRequirementViewData$DateFromViewData;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "objective", "Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "getObjective", "()Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;", "setObjective", "(Lcom/yoti/mobile/android/documentcapture/view/selection/CaptureObjectiveTypeViewData;)V", "state", "Lkotlinx/coroutines/flow/Flow;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "cleanup", "", "handleCameraPermissionsDenied", "shouldShowRationale", "", "handleDoNotHaveDocument", "handleError", "error", "handleFetchSuccess", "scanConfigurationEntity", "resourceConfigEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "handleMoreAboutVerification", "handleStartScan", "cameraPermissionNeeded", "handleViewCreated", "handleViewEvent", "viewEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewEvent;", "setDocumentData", "DocumentCaptureConfigurationObserver", "ScanConfigurationObserver", "State", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentViewModelHelper {
    private final MutableSharedFlow<State> _state;
    private final AdditionalInstructionsFragment.FragmentArgsFactory additionalInstructionsFragmentArgsFactory;
    private String countryIso3Code;
    private DocumentRequirementViewData.DateFromViewData dateFromRequirement;
    private DocumentResourceConfigEntity.DocumentTypeEntity documentType;
    private final DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper;
    private final Mapper<Throwable, YdsFailure> errorToFailureMapper;
    private final DocumentFeatureErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper;
    private final DocumentCaptureConfiguration featureConfiguration;
    private final GetDocumentCaptureConfigurationInteractor getDocumentCaptureConfigurationInteractor;
    private final GetScanConfigurationInteractor getScanConfigurationInteractor;
    private CaptureObjectiveTypeViewData objective;
    private final Mapper<IScanConfigurationEntity, IScanConfigurationViewData> scanConfigurationEntityToViewDataMapper;
    private final SessionStatus sessionStatus;

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$DocumentCaptureConfigurationObserver;", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;)V", "onError", "", "error", "", "onSuccess", "resourceConfigEntity", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class DocumentCaptureConfigurationObserver extends DisposableSingleObserver<DocumentResourceConfigEntity> {
        public DocumentCaptureConfigurationObserver() {
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            DocumentViewModelHelper.this.handleError(new DocumentFeatureError.DocumentResourceConfigError((YotiDocsError) error));
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(DocumentResourceConfigEntity resourceConfigEntity) {
            Intrinsics.checkNotNullParameter(resourceConfigEntity, "resourceConfigEntity");
            DocumentViewModelHelper.this.handleFetchSuccess(resourceConfigEntity);
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$ScanConfigurationObserver;", "Lio/reactivex/observers/DisposableSingleObserver;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper;)V", "onError", "", "error", "", "onSuccess", "scanConfigurationEntity", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    private final class ScanConfigurationObserver extends DisposableSingleObserver<IScanConfigurationEntity> {
        public ScanConfigurationObserver() {
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            DocumentViewModelHelper.this.handleError(new DocumentFeatureError.DocumentScanConfigError((YotiDocsError) error));
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(IScanConfigurationEntity scanConfigurationEntity) {
            Intrinsics.checkNotNullParameter(scanConfigurationEntity, "scanConfigurationEntity");
            DocumentViewModelHelper.this.handleFetchSuccess(scanConfigurationEntity);
        }
    }

    @Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "", "()V", "Failure", "LoadingData", "NavigationPending", "Successful", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$Failure;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$Successful;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$NavigationPending;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class State {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$Failure;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "(Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;)V", "getFailure", "()Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Failure extends State {
            private final YdsFailure failure;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(YdsFailure failure) {
                super(null);
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, YdsFailure ydsFailure, int i, Object obj) {
                if ((i & 1) != 0) {
                    ydsFailure = failure.failure;
                }
                return failure.copy(ydsFailure);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final YdsFailure getFailure() {
                return this.failure;
            }

            public final Failure copy(YdsFailure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Failure(failure);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Failure) && Intrinsics.areEqual(this.failure, ((Failure) other).failure);
            }

            public final YdsFailure getFailure() {
                return this.failure;
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failure(failure=" + this.failure + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "dataType", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData$DataType;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData$DataType;)V", "getDataType", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData$DataType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DataType", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class LoadingData extends State {
            private final DataType dataType;

            @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$LoadingData$DataType;", "", "(Ljava/lang/String;I)V", "DOCUMENT_RESOURCE_CONFIGURATION", "DOCUMENT_SCAN_CONFIGURATION", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
            public enum DataType {
                DOCUMENT_RESOURCE_CONFIGURATION,
                DOCUMENT_SCAN_CONFIGURATION
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadingData(DataType dataType) {
                super(null);
                Intrinsics.checkNotNullParameter(dataType, "dataType");
                this.dataType = dataType;
            }

            public static /* synthetic */ LoadingData copy$default(LoadingData loadingData, DataType dataType, int i, Object obj) {
                if ((i & 1) != 0) {
                    dataType = loadingData.dataType;
                }
                return loadingData.copy(dataType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DataType getDataType() {
                return this.dataType;
            }

            public final LoadingData copy(DataType dataType) {
                Intrinsics.checkNotNullParameter(dataType, "dataType");
                return new LoadingData(dataType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadingData) && this.dataType == ((LoadingData) other).dataType;
            }

            public final DataType getDataType() {
                return this.dataType;
            }

            public int hashCode() {
                return this.dataType.hashCode();
            }

            public String toString() {
                return "LoadingData(dataType=" + this.dataType + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$NavigationPending;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "navigationEvent", "Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "(Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;)V", "getNavigationEvent", "()Lcom/yoti/mobile/android/documentcapture/view/DocumentNavigationEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigationPending extends State {
            private final DocumentNavigationEvent navigationEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigationPending(DocumentNavigationEvent navigationEvent) {
                super(null);
                Intrinsics.checkNotNullParameter(navigationEvent, "navigationEvent");
                this.navigationEvent = navigationEvent;
            }

            public static /* synthetic */ NavigationPending copy$default(NavigationPending navigationPending, DocumentNavigationEvent documentNavigationEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentNavigationEvent = navigationPending.navigationEvent;
                }
                return navigationPending.copy(documentNavigationEvent);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentNavigationEvent getNavigationEvent() {
                return this.navigationEvent;
            }

            public final NavigationPending copy(DocumentNavigationEvent navigationEvent) {
                Intrinsics.checkNotNullParameter(navigationEvent, "navigationEvent");
                return new NavigationPending(navigationEvent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigationPending) && Intrinsics.areEqual(this.navigationEvent, ((NavigationPending) other).navigationEvent);
            }

            public final DocumentNavigationEvent getNavigationEvent() {
                return this.navigationEvent;
            }

            public int hashCode() {
                return this.navigationEvent.hashCode();
            }

            public String toString() {
                return "NavigationPending(navigationEvent=" + this.navigationEvent + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State$Successful;", "Lcom/yoti/mobile/android/documentcapture/view/DocumentViewModelHelper$State;", "resourceConfigEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;)V", "getResourceConfigEntity", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class Successful extends State {
            private final DocumentResourceConfigEntity resourceConfigEntity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Successful(DocumentResourceConfigEntity resourceConfigEntity) {
                super(null);
                Intrinsics.checkNotNullParameter(resourceConfigEntity, "resourceConfigEntity");
                this.resourceConfigEntity = resourceConfigEntity;
            }

            public static /* synthetic */ Successful copy$default(Successful successful, DocumentResourceConfigEntity documentResourceConfigEntity, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentResourceConfigEntity = successful.resourceConfigEntity;
                }
                return successful.copy(documentResourceConfigEntity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentResourceConfigEntity getResourceConfigEntity() {
                return this.resourceConfigEntity;
            }

            public final Successful copy(DocumentResourceConfigEntity resourceConfigEntity) {
                Intrinsics.checkNotNullParameter(resourceConfigEntity, "resourceConfigEntity");
                return new Successful(resourceConfigEntity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Successful) && Intrinsics.areEqual(this.resourceConfigEntity, ((Successful) other).resourceConfigEntity);
            }

            public final DocumentResourceConfigEntity getResourceConfigEntity() {
                return this.resourceConfigEntity;
            }

            public int hashCode() {
                return this.resourceConfigEntity.hashCode();
            }

            public String toString() {
                return "Successful(resourceConfigEntity=" + this.resourceConfigEntity + ')';
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DocumentViewModelHelper(GetDocumentCaptureConfigurationInteractor getDocumentCaptureConfigurationInteractor, GetScanConfigurationInteractor getScanConfigurationInteractor, SessionStatus sessionStatus, DocumentCaptureConfiguration featureConfiguration, AdditionalInstructionsFragment.FragmentArgsFactory additionalInstructionsFragmentArgsFactory, DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, @DocumentSelection Mapper<Throwable, YdsFailure> errorToFailureMapper, Mapper<IScanConfigurationEntity, IScanConfigurationViewData> scanConfigurationEntityToViewDataMapper, DocumentFeatureErrorToSessionStatusTypeMapper errorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(getDocumentCaptureConfigurationInteractor, "getDocumentCaptureConfigurationInteractor");
        Intrinsics.checkNotNullParameter(getScanConfigurationInteractor, "getScanConfigurationInteractor");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        Intrinsics.checkNotNullParameter(additionalInstructionsFragmentArgsFactory, "additionalInstructionsFragmentArgsFactory");
        Intrinsics.checkNotNullParameter(documentTypeEntityToViewDataMapper, "documentTypeEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(scanConfigurationEntityToViewDataMapper, "scanConfigurationEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusTypeMapper, "errorToSessionStatusTypeMapper");
        this.getDocumentCaptureConfigurationInteractor = getDocumentCaptureConfigurationInteractor;
        this.getScanConfigurationInteractor = getScanConfigurationInteractor;
        this.sessionStatus = sessionStatus;
        this.featureConfiguration = featureConfiguration;
        this.additionalInstructionsFragmentArgsFactory = additionalInstructionsFragmentArgsFactory;
        this.documentTypeEntityToViewDataMapper = documentTypeEntityToViewDataMapper;
        this.errorToFailureMapper = errorToFailureMapper;
        this.scanConfigurationEntityToViewDataMapper = scanConfigurationEntityToViewDataMapper;
        this.errorToSessionStatusTypeMapper = errorToSessionStatusTypeMapper;
        this._state = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
    }

    private final void handleCameraPermissionsDenied(boolean shouldShowRationale) {
        this.sessionStatus.setSessionStatus(SessionStatusType.NO_CAMERA_PERMISSION);
        if (shouldShowRationale) {
            return;
        }
        this._state.tryEmit(new State.NavigationPending(DocumentNavigationEvent.NavigateToCameraPermissionDenied.INSTANCE));
    }

    private final void handleDoNotHaveDocument() {
        Integer dialogTextId = ((DocumentFeatureFailureType.DocumentNotOwnedFailureType) this.errorToFailureMapper.map(DocumentFeatureError.DocumentNotOwnedError.INSTANCE).getFailureType()).getDialogTextId();
        if (dialogTextId == null) {
            throw new IllegalArgumentException("Failure type missing dialog text".toString());
        }
        this._state.tryEmit(new State.NavigationPending(new DocumentNavigationEvent.NavigateToDoNotHaveDocumentsDialog(new DoNotHaveDocumentsDialogViewData(dialogTextId.intValue(), 0, 0, 6, null))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Throwable error) {
        this._state.tryEmit(new State.Failure(this.errorToFailureMapper.map(error)));
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusTypeMapper.map(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchSuccess(DocumentResourceConfigEntity resourceConfigEntity) {
        this._state.tryEmit(new State.Successful(resourceConfigEntity));
    }

    private final void handleMoreAboutVerification() {
        CaptureObjectiveTypeViewData captureObjectiveTypeViewData = this.objective;
        if (captureObjectiveTypeViewData == null) {
            throw new IllegalArgumentException("Capture objective must not be null, did you set it?".toString());
        }
        this._state.tryEmit(new State.NavigationPending(new DocumentNavigationEvent.NavigateToMoreAboutVerification(captureObjectiveTypeViewData.getMoreAboutFragmentArgs(this.featureConfiguration.getUiSessionConfiguration()))));
    }

    private final void handleStartScan(boolean cameraPermissionNeeded) {
        DocumentRequirementViewData.DateFromViewData dateFromViewData = this.dateFromRequirement;
        if (dateFromViewData != null) {
            MutableSharedFlow<State> mutableSharedFlow = this._state;
            AdditionalInstructionsFragment.FragmentArgsFactory fragmentArgsFactory = this.additionalInstructionsFragmentArgsFactory;
            if (dateFromViewData == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper = this.documentTypeEntityToViewDataMapper;
            DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity = this.documentType;
            if (documentTypeEntity == null) {
                throw new IllegalArgumentException("Document type must not be null, did you set it?".toString());
            }
            DocumentTypeViewData map = documentTypeEntityToViewDataMapper.map(documentTypeEntity);
            String str = this.countryIso3Code;
            if (str == null) {
                throw new IllegalArgumentException("Country iso code must not be null, did you set it?".toString());
            }
            mutableSharedFlow.tryEmit(new State.NavigationPending(new DocumentNavigationEvent.NavigateToAdditionalInstructions(fragmentArgsFactory.create(dateFromViewData, map, str))));
            return;
        }
        if (cameraPermissionNeeded) {
            this._state.tryEmit(new State.NavigationPending(DocumentNavigationEvent.RequestCameraPermission.INSTANCE));
            return;
        }
        this.sessionStatus.resetSessionStatusType();
        this._state.tryEmit(new State.LoadingData(State.LoadingData.DataType.DOCUMENT_SCAN_CONFIGURATION));
        GetScanConfigurationInteractor getScanConfigurationInteractor = this.getScanConfigurationInteractor;
        ScanConfigurationObserver scanConfigurationObserver = new ScanConfigurationObserver();
        String str2 = this.countryIso3Code;
        if (str2 == null) {
            throw new IllegalArgumentException("Country iso code must not be null, did you set it?".toString());
        }
        DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity2 = this.documentType;
        if (documentTypeEntity2 == null) {
            throw new IllegalArgumentException("Document type must not be null, did you set it?".toString());
        }
        getScanConfigurationInteractor.execute(scanConfigurationObserver, new ScanConfigurationRequestParams(str2, documentTypeEntity2));
    }

    private final void handleViewCreated() {
        this._state.tryEmit(new State.LoadingData(State.LoadingData.DataType.DOCUMENT_RESOURCE_CONFIGURATION));
        SingleUseCase.execute$default(this.getDocumentCaptureConfigurationInteractor, new DocumentCaptureConfigurationObserver(), null, 2, null);
    }

    public static /* synthetic */ void setDocumentData$default(DocumentViewModelHelper documentViewModelHelper, DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity, String str, DocumentRequirementViewData.DateFromViewData dateFromViewData, int i, Object obj) {
        if ((i & 4) != 0) {
            dateFromViewData = null;
        }
        documentViewModelHelper.setDocumentData(documentTypeEntity, str, dateFromViewData);
    }

    public final void cleanup() {
        this.getDocumentCaptureConfigurationInteractor.clear();
        this.getScanConfigurationInteractor.clear();
    }

    public final CaptureObjectiveTypeViewData getObjective() {
        return this.objective;
    }

    public final Flow<State> getState() {
        return this._state;
    }

    public final void handleViewEvent(DocumentViewEvent viewEvent) {
        Intrinsics.checkNotNullParameter(viewEvent, "viewEvent");
        DocumentViewEvent.ViewCreated viewCreated = DocumentViewEvent.ViewCreated.INSTANCE;
        if (Intrinsics.areEqual(viewEvent, viewCreated)) {
            handleViewCreated();
            return;
        }
        if (viewEvent instanceof DocumentViewEvent.StartScan) {
            handleStartScan(((DocumentViewEvent.StartScan) viewEvent).isCameraPermissionNeeded());
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.CameraPermissionGranted.INSTANCE)) {
            handleStartScan(false);
            return;
        }
        if (viewEvent instanceof DocumentViewEvent.CameraPermissionsDenied) {
            handleCameraPermissionsDenied(((DocumentViewEvent.CameraPermissionsDenied) viewEvent).getShouldShowRationale());
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.MoreAboutVerification.INSTANCE)) {
            handleMoreAboutVerification();
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.DoNotHaveDocument.INSTANCE)) {
            handleDoNotHaveDocument();
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.ConfirmDoNotHaveDocument.INSTANCE)) {
            handleError(DocumentFeatureError.DocumentNotOwnedError.INSTANCE);
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.CancelDoNotHaveDocument.INSTANCE)) {
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.RetryGetDocumentResourceConfig.INSTANCE)) {
            handleViewEvent(viewCreated);
            return;
        }
        if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.CancelGetDocumentResourceConfig.INSTANCE)) {
            this._state.tryEmit(new State.NavigationPending(DocumentNavigationEvent.CancelFlow.INSTANCE));
            return;
        }
        if (viewEvent instanceof DocumentViewEvent.RetryGetScanConfiguration) {
            handleViewEvent(new DocumentViewEvent.StartScan(((DocumentViewEvent.RetryGetScanConfiguration) viewEvent).isCameraPermissionNeeded()));
        } else if (Intrinsics.areEqual(viewEvent, DocumentViewEvent.CancelGetScanConfiguration.INSTANCE)) {
            this._state.tryEmit(new State.NavigationPending(DocumentNavigationEvent.CancelFlow.INSTANCE));
        } else {
            boolean z = viewEvent instanceof DocumentViewEvent.AbstractDocumentViewEvent;
        }
    }

    public final void setDocumentData(DocumentResourceConfigEntity.DocumentTypeEntity documentType, String countryIso3Code, DocumentRequirementViewData.DateFromViewData dateFromRequirement) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        this.documentType = documentType;
        this.countryIso3Code = countryIso3Code;
        this.dateFromRequirement = dateFromRequirement;
    }

    public final void setObjective(CaptureObjectiveTypeViewData captureObjectiveTypeViewData) {
        this.objective = captureObjectiveTypeViewData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFetchSuccess(IScanConfigurationEntity scanConfigurationEntity) {
        this._state.tryEmit(new State.NavigationPending(new DocumentNavigationEvent.NavigateToScan(this.scanConfigurationEntityToViewDataMapper.map(scanConfigurationEntity))));
    }
}
