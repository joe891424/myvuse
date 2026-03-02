package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.yoti.mobile.android.commonui.SavedStateHandleHolder;
import com.yoti.mobile.android.commonui.SingleLiveDataEvent;
import com.yoti.mobile.android.documentcapture.p055id.domain.CaptureStorage;
import com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor;
import com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultsToDocumentScanResultViewDataMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanState;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.DocumentScanResultViewDataToBacCredentialMapper;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import com.yoti.mobile.android.yotidocs.common.error.ExceptionToFailureMapper;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.domain.model.SessionStatus;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\\]BW\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010/\u001a\u000200H\u0012J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000104H\u0012J,\u00106\u001a\u0002022\u0006\u00107\u001a\u0002082\u001a\u00109\u001a\u0016\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020;\u0018\u00010:j\u0004\u0018\u0001`<H\u0012J\u0010\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?H\u0016J-\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020,2\u0006\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000104H\u0092@ø\u0001\u0000¢\u0006\u0002\u0010CJ)\u0010D\u001a\u00020E2\u0006\u0010B\u001a\u00020,2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u000208H\u0092@ø\u0001\u0000¢\u0006\u0002\u0010HJ$\u0010I\u001a\u00020J2\u0006\u0010B\u001a\u00020,2\u0006\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000104H\u0012J\u0010\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020JH\u0012J\b\u0010M\u001a\u000202H\u0012J\b\u0010N\u001a\u000202H\u0012J\u0010\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020JH\u0012J\u0018\u0010Q\u001a\u0002002\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u000208H\u0012J\u0010\u0010R\u001a\u0002022\u0006\u00105\u001a\u000204H\u0012J\b\u0010S\u001a\u000202H\u0012J\b\u0010T\u001a\u000202H\u0012J\u0010\u0010U\u001a\u0002022\u0006\u0010V\u001a\u00020WH\u0012J\u0010\u0010X\u001a\u0002022\u0006\u00103\u001a\u000204H\u0012J\u0010\u0010Y\u001a\u0002022\u0006\u0010Z\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u0002022\u0006\u0010B\u001a\u00020,H\u0012R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0092\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8R@RX\u0092\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0011\u001a\u00020\u0012X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u000e\u0010)\u001a\u00020*X\u0092.¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006^"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/yoti/mobile/android/commonui/SavedStateHandleHolder;", "getNfcFlowType", "Lcom/yoti/mobile/android/documentcapture/id/domain/GetNfcFlowTypeInteractor;", "captureStorage", "Lcom/yoti/mobile/android/documentcapture/id/domain/CaptureStorage;", "sessionStatus", "Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;", "bacCredentialMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/DocumentScanResultViewDataToBacCredentialMapper;", "documentCaptureResultToReviewViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentCaptureResultToPageScanReviewViewDataMapper;", "documentCaptureResultToResultViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultsToDocumentScanResultViewDataMapper;", "documentCaptureViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/IdDocumentScanResultViewDataToEntityMapper;", "errorToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToEntityMapper;", "errorToFailureMapper", "Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;", "errorToSessionStatusMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/domain/GetNfcFlowTypeInteractor;Lcom/yoti/mobile/android/documentcapture/id/domain/CaptureStorage;Lcom/yoti/mobile/android/yotisdkcore/core/domain/model/SessionStatus;Lcom/yoti/mobile/android/documentcapture/id/view/verify/DocumentScanResultViewDataToBacCredentialMapper;Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentCaptureResultToPageScanReviewViewDataMapper;Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultsToDocumentScanResultViewDataMapper;Lcom/yoti/mobile/android/documentcapture/id/view/upload/IdDocumentScanResultViewDataToEntityMapper;Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToEntityMapper;Lcom/yoti/mobile/android/yotidocs/common/error/ExceptionToFailureMapper;Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanErrorToSessionStatusTypeMapper;)V", "_documentScanViewState", "Lcom/yoti/mobile/android/commonui/SingleLiveDataEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "_navigationEvent", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "value", "documentCaptureViewState", "getDocumentCaptureViewState", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "setDocumentCaptureViewState", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;)V", "documentViewScanState", "Landroidx/lifecycle/LiveData;", "getDocumentViewScanState", "()Landroidx/lifecycle/LiveData;", "navigationEvent", "getNavigationEvent", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "getScanConfiguration", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "cleanupCapture", "Lkotlinx/coroutines/Job;", "completeScan", "", "resultFront", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "resultBack", "handleNfcResult", "resultCode", "", "nfcPayload", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "handleViewEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "mapResultToEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "scanConfig", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapResultToReviewViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "result", RemoteDefsKt.PATH_PAGE_INDEX_KEY, "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapResultToViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "navigateToNextScreen", "documentCaptureViewData", "navigateToNfc", "navigateToNfcPrompt", "navigateToUpload", "documentData", "review", "setBackSideCapture", "setDocumentPageApproved", "setDocumentPageRejected", "setDocumentScanningError", "error", "", "setFrontSideCapture", "setSavedStateHandle", "handle", "startCapture", "DocumentScanNavigationEvent", "DocumentScanViewEvent", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public class DocumentScanViewModel extends ViewModel implements SavedStateHandleHolder {
    private final SingleLiveDataEvent<ScanState> _documentScanViewState;
    private final SingleLiveDataEvent<DocumentScanNavigationEvent> _navigationEvent;
    private final DocumentScanResultViewDataToBacCredentialMapper bacCredentialMapper;
    private final CaptureStorage captureStorage;
    private final DocumentScanResultsToDocumentScanResultViewDataMapper documentCaptureResultToResultViewDataMapper;
    private final DocumentCaptureResultToPageScanReviewViewDataMapper documentCaptureResultToReviewViewDataMapper;
    private final IdDocumentScanResultViewDataToEntityMapper documentCaptureViewDataToEntityMapper;
    private final LiveData<ScanState> documentViewScanState;
    private final ScanErrorToEntityMapper errorToEntityMapper;
    private final ExceptionToFailureMapper errorToFailureMapper;
    private final ScanErrorToSessionStatusTypeMapper errorToSessionStatusMapper;
    private final GetNfcFlowTypeInteractor getNfcFlowType;
    private final LiveData<DocumentScanNavigationEvent> navigationEvent;
    private SavedStateHandle savedStateHandle;
    private final SessionStatus sessionStatus;

    @Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "", "()V", "NavigateToNfcCapture", "NavigateToNfcPrompt", "NavigateToUpload", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToNfcCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToNfcPrompt;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentScanNavigationEvent {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToNfcCapture;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "bacCredential", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "(Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;)V", "getBacCredential", "()Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToNfcCapture extends DocumentScanNavigationEvent {
            private final BacCredential bacCredential;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToNfcCapture(BacCredential bacCredential) {
                super(null);
                Intrinsics.checkNotNullParameter(bacCredential, "bacCredential");
                this.bacCredential = bacCredential;
            }

            public static /* synthetic */ NavigateToNfcCapture copy$default(NavigateToNfcCapture navigateToNfcCapture, BacCredential bacCredential, int i, Object obj) {
                if ((i & 1) != 0) {
                    bacCredential = navigateToNfcCapture.bacCredential;
                }
                return navigateToNfcCapture.copy(bacCredential);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BacCredential getBacCredential() {
                return this.bacCredential;
            }

            public final NavigateToNfcCapture copy(BacCredential bacCredential) {
                Intrinsics.checkNotNullParameter(bacCredential, "bacCredential");
                return new NavigateToNfcCapture(bacCredential);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToNfcCapture) && Intrinsics.areEqual(this.bacCredential, ((NavigateToNfcCapture) other).bacCredential);
            }

            public final BacCredential getBacCredential() {
                return this.bacCredential;
            }

            public int hashCode() {
                return this.bacCredential.hashCode();
            }

            public String toString() {
                return "NavigateToNfcCapture(bacCredential=" + this.bacCredential + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToNfcPrompt;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "data", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToNfcPrompt extends DocumentScanNavigationEvent {
            private final DocumentScanResultViewData data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToNfcPrompt(DocumentScanResultViewData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ NavigateToNfcPrompt copy$default(NavigateToNfcPrompt navigateToNfcPrompt, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentScanResultViewData = navigateToNfcPrompt.data;
                }
                return navigateToNfcPrompt.copy(documentScanResultViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentScanResultViewData getData() {
                return this.data;
            }

            public final NavigateToNfcPrompt copy(DocumentScanResultViewData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new NavigateToNfcPrompt(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToNfcPrompt) && Intrinsics.areEqual(this.data, ((NavigateToNfcPrompt) other).data);
            }

            public final DocumentScanResultViewData getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "NavigateToNfcPrompt(data=" + this.data + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent$NavigateToUpload;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "data", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;)V", "getData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class NavigateToUpload extends DocumentScanNavigationEvent {
            private final DocumentScanResultViewData data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToUpload(DocumentScanResultViewData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public static /* synthetic */ NavigateToUpload copy$default(NavigateToUpload navigateToUpload, DocumentScanResultViewData documentScanResultViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentScanResultViewData = navigateToUpload.data;
                }
                return navigateToUpload.copy(documentScanResultViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentScanResultViewData getData() {
                return this.data;
            }

            public final NavigateToUpload copy(DocumentScanResultViewData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new NavigateToUpload(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToUpload) && Intrinsics.areEqual(this.data, ((NavigateToUpload) other).data);
            }

            public final DocumentScanResultViewData getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "NavigateToUpload(data=" + this.data + ')';
            }
        }

        private DocumentScanNavigationEvent() {
        }

        public /* synthetic */ DocumentScanNavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(m5597d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "", "()V", "OnBackPageCaptured", "OnFinishCaptureFlow", "OnFrontPageCaptured", "OnNfcResult", "OnPageApproved", "OnPageRejected", "OnScanCompleted", "OnScanError", "OnViewStarted", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnViewStarted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnFrontPageCaptured;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnBackPageCaptured;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnPageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnPageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnScanCompleted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnScanError;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnFinishCaptureFlow;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnNfcResult;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static abstract class DocumentScanViewEvent {

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnBackPageCaptured;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "page", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "(Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;)V", "getPage", "()Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnBackPageCaptured extends DocumentScanViewEvent {
            private final DocumentCaptureResult page;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnBackPageCaptured(DocumentCaptureResult page) {
                super(null);
                Intrinsics.checkNotNullParameter(page, "page");
                this.page = page;
            }

            public static /* synthetic */ OnBackPageCaptured copy$default(OnBackPageCaptured onBackPageCaptured, DocumentCaptureResult documentCaptureResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentCaptureResult = onBackPageCaptured.page;
                }
                return onBackPageCaptured.copy(documentCaptureResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentCaptureResult getPage() {
                return this.page;
            }

            public final OnBackPageCaptured copy(DocumentCaptureResult page) {
                Intrinsics.checkNotNullParameter(page, "page");
                return new OnBackPageCaptured(page);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnBackPageCaptured) && Intrinsics.areEqual(this.page, ((OnBackPageCaptured) other).page);
            }

            public final DocumentCaptureResult getPage() {
                return this.page;
            }

            public int hashCode() {
                return this.page.hashCode();
            }

            public String toString() {
                return "OnBackPageCaptured(page=" + this.page + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnFinishCaptureFlow;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnFinishCaptureFlow extends DocumentScanViewEvent {
            public static final OnFinishCaptureFlow INSTANCE = new OnFinishCaptureFlow();

            private OnFinishCaptureFlow() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnFrontPageCaptured;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "page", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "(Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;)V", "getPage", "()Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnFrontPageCaptured extends DocumentScanViewEvent {
            private final DocumentCaptureResult page;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnFrontPageCaptured(DocumentCaptureResult page) {
                super(null);
                Intrinsics.checkNotNullParameter(page, "page");
                this.page = page;
            }

            public static /* synthetic */ OnFrontPageCaptured copy$default(OnFrontPageCaptured onFrontPageCaptured, DocumentCaptureResult documentCaptureResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentCaptureResult = onFrontPageCaptured.page;
                }
                return onFrontPageCaptured.copy(documentCaptureResult);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentCaptureResult getPage() {
                return this.page;
            }

            public final OnFrontPageCaptured copy(DocumentCaptureResult page) {
                Intrinsics.checkNotNullParameter(page, "page");
                return new OnFrontPageCaptured(page);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnFrontPageCaptured) && Intrinsics.areEqual(this.page, ((OnFrontPageCaptured) other).page);
            }

            public final DocumentCaptureResult getPage() {
                return this.page;
            }

            public int hashCode() {
                return this.page.hashCode();
            }

            public String toString() {
                return "OnFrontPageCaptured(page=" + this.page + ')';
            }
        }

        @Metadata(m5597d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnNfcResult;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "resultCode", "", "chipData", "", "", "Lcom/yoti/mobile/android/mrtd/ChipData;", "(ILjava/util/Map;)V", "getChipData", "()Ljava/util/Map;", "getResultCode", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnNfcResult extends DocumentScanViewEvent {
            private final Map<Integer, byte[]> chipData;
            private final int resultCode;

            public OnNfcResult(int i, Map<Integer, byte[]> map) {
                super(null);
                this.resultCode = i;
                this.chipData = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ OnNfcResult copy$default(OnNfcResult onNfcResult, int i, Map map, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = onNfcResult.resultCode;
                }
                if ((i2 & 2) != 0) {
                    map = onNfcResult.chipData;
                }
                return onNfcResult.copy(i, map);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getResultCode() {
                return this.resultCode;
            }

            public final Map<Integer, byte[]> component2() {
                return this.chipData;
            }

            public final OnNfcResult copy(int resultCode, Map<Integer, byte[]> chipData) {
                return new OnNfcResult(resultCode, chipData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnNfcResult)) {
                    return false;
                }
                OnNfcResult onNfcResult = (OnNfcResult) other;
                return this.resultCode == onNfcResult.resultCode && Intrinsics.areEqual(this.chipData, onNfcResult.chipData);
            }

            public final Map<Integer, byte[]> getChipData() {
                return this.chipData;
            }

            public final int getResultCode() {
                return this.resultCode;
            }

            public int hashCode() {
                int iHashCode = Integer.hashCode(this.resultCode) * 31;
                Map<Integer, byte[]> map = this.chipData;
                return iHashCode + (map == null ? 0 : map.hashCode());
            }

            public String toString() {
                return "OnNfcResult(resultCode=" + this.resultCode + ", chipData=" + this.chipData + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnPageApproved;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnPageApproved extends DocumentScanViewEvent {
            public static final OnPageApproved INSTANCE = new OnPageApproved();

            private OnPageApproved() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnPageRejected;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "()V", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class OnPageRejected extends DocumentScanViewEvent {
            public static final OnPageRejected INSTANCE = new OnPageRejected();

            private OnPageRejected() {
                super(null);
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnScanCompleted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "resultFront", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "resultBack", "(Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;)V", "getResultBack", "()Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "getResultFront", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnScanCompleted extends DocumentScanViewEvent {
            private final DocumentCaptureResult resultBack;
            private final DocumentCaptureResult resultFront;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnScanCompleted(DocumentCaptureResult resultFront, DocumentCaptureResult documentCaptureResult) {
                super(null);
                Intrinsics.checkNotNullParameter(resultFront, "resultFront");
                this.resultFront = resultFront;
                this.resultBack = documentCaptureResult;
            }

            public static /* synthetic */ OnScanCompleted copy$default(OnScanCompleted onScanCompleted, DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentCaptureResult = onScanCompleted.resultFront;
                }
                if ((i & 2) != 0) {
                    documentCaptureResult2 = onScanCompleted.resultBack;
                }
                return onScanCompleted.copy(documentCaptureResult, documentCaptureResult2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DocumentCaptureResult getResultFront() {
                return this.resultFront;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final DocumentCaptureResult getResultBack() {
                return this.resultBack;
            }

            public final OnScanCompleted copy(DocumentCaptureResult resultFront, DocumentCaptureResult resultBack) {
                Intrinsics.checkNotNullParameter(resultFront, "resultFront");
                return new OnScanCompleted(resultFront, resultBack);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnScanCompleted)) {
                    return false;
                }
                OnScanCompleted onScanCompleted = (OnScanCompleted) other;
                return Intrinsics.areEqual(this.resultFront, onScanCompleted.resultFront) && Intrinsics.areEqual(this.resultBack, onScanCompleted.resultBack);
            }

            public final DocumentCaptureResult getResultBack() {
                return this.resultBack;
            }

            public final DocumentCaptureResult getResultFront() {
                return this.resultFront;
            }

            public int hashCode() {
                int iHashCode = this.resultFront.hashCode() * 31;
                DocumentCaptureResult documentCaptureResult = this.resultBack;
                return iHashCode + (documentCaptureResult == null ? 0 : documentCaptureResult.hashCode());
            }

            public String toString() {
                return "OnScanCompleted(resultFront=" + this.resultFront + ", resultBack=" + this.resultBack + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnScanError;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnScanError extends DocumentScanViewEvent {
            private final Throwable error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnScanError(Throwable error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ OnScanError copy$default(OnScanError onScanError, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = onScanError.error;
                }
                return onScanError.copy(th);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Throwable getError() {
                return this.error;
            }

            public final OnScanError copy(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new OnScanError(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnScanError) && Intrinsics.areEqual(this.error, ((OnScanError) other).error);
            }

            public final Throwable getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "OnScanError(error=" + this.error + ')';
            }
        }

        @Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent$OnViewStarted;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanViewEvent;", "scanConfig", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;)V", "getScanConfig", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final /* data */ class OnViewStarted extends DocumentScanViewEvent {
            private final IdScanConfigurationViewData scanConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnViewStarted(IdScanConfigurationViewData scanConfig) {
                super(null);
                Intrinsics.checkNotNullParameter(scanConfig, "scanConfig");
                this.scanConfig = scanConfig;
            }

            public static /* synthetic */ OnViewStarted copy$default(OnViewStarted onViewStarted, IdScanConfigurationViewData idScanConfigurationViewData, int i, Object obj) {
                if ((i & 1) != 0) {
                    idScanConfigurationViewData = onViewStarted.scanConfig;
                }
                return onViewStarted.copy(idScanConfigurationViewData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final IdScanConfigurationViewData getScanConfig() {
                return this.scanConfig;
            }

            public final OnViewStarted copy(IdScanConfigurationViewData scanConfig) {
                Intrinsics.checkNotNullParameter(scanConfig, "scanConfig");
                return new OnViewStarted(scanConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OnViewStarted) && Intrinsics.areEqual(this.scanConfig, ((OnViewStarted) other).scanConfig);
            }

            public final IdScanConfigurationViewData getScanConfig() {
                return this.scanConfig;
            }

            public int hashCode() {
                return this.scanConfig.hashCode();
            }

            public String toString() {
                return "OnViewStarted(scanConfig=" + this.scanConfig + ')';
            }
        }

        private DocumentScanViewEvent() {
        }

        public /* synthetic */ DocumentScanViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$cleanupCapture$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$cleanupCapture$1", m5608f = "DocumentScanViewModel.kt", m5609i = {}, m5610l = {171}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C46331(Continuation<? super C46331> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentScanViewModel.this.new C46331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureStorage captureStorage = DocumentScanViewModel.this.captureStorage;
                this.label = 1;
                if (captureStorage.removeCapture(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$mapResultToReviewViewData$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel", m5608f = "DocumentScanViewModel.kt", m5609i = {}, m5610l = {213, 213}, m5611m = "mapResultToReviewViewData", m5612n = {}, m5613s = {})
    static final class C46341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C46341(Continuation<? super C46341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DocumentScanViewModel.this.mapResultToReviewViewData(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$navigateToNextScreen$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$navigateToNextScreen$1", m5608f = "DocumentScanViewModel.kt", m5609i = {}, m5610l = {138, 139}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DocumentScanResultViewData $documentCaptureViewData;
        int label;

        /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$navigateToNextScreen$1$WhenMappings */
        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NfcFlowType.values().length];
                iArr[NfcFlowType.USER_PROMPT.ordinal()] = 1;
                iArr[NfcFlowType.ALWAYS.ordinal()] = 2;
                iArr[NfcFlowType.NEVER.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46351(DocumentScanResultViewData documentScanResultViewData, Continuation<? super C46351> continuation) {
            super(2, continuation);
            this.$documentCaptureViewData = documentScanResultViewData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentScanViewModel.this.new C46351(this.$documentCaptureViewData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L43
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L32
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel r5 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.this
                com.yoti.mobile.android.documentcapture.id.view.upload.IdDocumentScanResultViewDataToEntityMapper r5 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.access$getDocumentCaptureViewDataToEntityMapper$p(r5)
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanResultViewData r1 = r4.$documentCaptureViewData
                r4.label = r3
                java.lang.Object r5 = r5.map(r1, r4)
                if (r5 != r0) goto L32
                return r0
            L32:
                com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity r5 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity) r5
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel r1 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.this
                com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor r1 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.access$getGetNfcFlowType$p(r1)
                r4.label = r2
                java.lang.Object r5 = r1.invoke(r5, r4)
                if (r5 != r0) goto L43
                return r0
            L43:
                com.yoti.mobile.android.documentcapture.id.domain.NfcFlowType r5 = (com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType) r5
                int[] r0 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.C46351.WhenMappings.$EnumSwitchMapping$0
                int r5 = r5.ordinal()
                r5 = r0[r5]
                if (r5 == r3) goto L63
                if (r5 == r2) goto L5d
                r0 = 3
                if (r5 == r0) goto L55
                goto L68
            L55:
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel r5 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.this
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanResultViewData r0 = r4.$documentCaptureViewData
                com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.access$navigateToUpload(r5, r0)
                goto L68
            L5d:
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel r5 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.this
                com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.access$navigateToNfc(r5)
                goto L68
            L63:
                com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel r5 = com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.this
                com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.access$navigateToNfcPrompt(r5)
            L68:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.C46351.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$review$1 */
    @Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m5598d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    @DebugMetadata(m5607c = "com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$review$1", m5608f = "DocumentScanViewModel.kt", m5609i = {}, m5610l = {157}, m5611m = "invokeSuspend", m5612n = {}, m5613s = {})
    static final class C46361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ DocumentCaptureResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C46361(DocumentCaptureResult documentCaptureResult, int i, Continuation<? super C46361> continuation) {
            super(2, continuation);
            this.$result = documentCaptureResult;
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DocumentScanViewModel.this.new C46361(this.$result, this.$pageIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C46361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DocumentScanViewModel documentScanViewModel = DocumentScanViewModel.this;
                    IdScanConfigurationViewData scanConfiguration = documentScanViewModel.getScanConfiguration();
                    DocumentCaptureResult documentCaptureResult = this.$result;
                    int i2 = this.$pageIndex;
                    this.label = 1;
                    obj = documentScanViewModel.mapResultToReviewViewData(scanConfiguration, documentCaptureResult, i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                DocumentScanViewModel.this.setDocumentCaptureViewState(new ScanState.ReviewScreen(DocumentScanViewModel.this.getScanConfiguration(), (PageScanReviewViewData) obj));
            } catch (IllegalArgumentException e) {
                DocumentScanViewModel.this.setDocumentScanningError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DocumentScanViewModel(GetNfcFlowTypeInteractor getNfcFlowType, CaptureStorage captureStorage, SessionStatus sessionStatus, DocumentScanResultViewDataToBacCredentialMapper bacCredentialMapper, DocumentCaptureResultToPageScanReviewViewDataMapper documentCaptureResultToReviewViewDataMapper, DocumentScanResultsToDocumentScanResultViewDataMapper documentCaptureResultToResultViewDataMapper, IdDocumentScanResultViewDataToEntityMapper documentCaptureViewDataToEntityMapper, ScanErrorToEntityMapper errorToEntityMapper, ExceptionToFailureMapper errorToFailureMapper, ScanErrorToSessionStatusTypeMapper errorToSessionStatusMapper) {
        Intrinsics.checkNotNullParameter(getNfcFlowType, "getNfcFlowType");
        Intrinsics.checkNotNullParameter(captureStorage, "captureStorage");
        Intrinsics.checkNotNullParameter(sessionStatus, "sessionStatus");
        Intrinsics.checkNotNullParameter(bacCredentialMapper, "bacCredentialMapper");
        Intrinsics.checkNotNullParameter(documentCaptureResultToReviewViewDataMapper, "documentCaptureResultToReviewViewDataMapper");
        Intrinsics.checkNotNullParameter(documentCaptureResultToResultViewDataMapper, "documentCaptureResultToResultViewDataMapper");
        Intrinsics.checkNotNullParameter(documentCaptureViewDataToEntityMapper, "documentCaptureViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(errorToEntityMapper, "errorToEntityMapper");
        Intrinsics.checkNotNullParameter(errorToFailureMapper, "errorToFailureMapper");
        Intrinsics.checkNotNullParameter(errorToSessionStatusMapper, "errorToSessionStatusMapper");
        this.getNfcFlowType = getNfcFlowType;
        this.captureStorage = captureStorage;
        this.sessionStatus = sessionStatus;
        this.bacCredentialMapper = bacCredentialMapper;
        this.documentCaptureResultToReviewViewDataMapper = documentCaptureResultToReviewViewDataMapper;
        this.documentCaptureResultToResultViewDataMapper = documentCaptureResultToResultViewDataMapper;
        this.documentCaptureViewDataToEntityMapper = documentCaptureViewDataToEntityMapper;
        this.errorToEntityMapper = errorToEntityMapper;
        this.errorToFailureMapper = errorToFailureMapper;
        this.errorToSessionStatusMapper = errorToSessionStatusMapper;
        SingleLiveDataEvent<ScanState> singleLiveDataEvent = new SingleLiveDataEvent<>(null, 1, null);
        this._documentScanViewState = singleLiveDataEvent;
        this.documentViewScanState = singleLiveDataEvent;
        SingleLiveDataEvent<DocumentScanNavigationEvent> singleLiveDataEvent2 = new SingleLiveDataEvent<>(null, 1, null);
        this._navigationEvent = singleLiveDataEvent2;
        this.navigationEvent = singleLiveDataEvent2;
    }

    private Job cleanupCapture() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46331(null), 3, null);
    }

    private void completeScan(DocumentCaptureResult resultFront, DocumentCaptureResult resultBack) {
        DocumentScanResultViewData documentScanResultViewDataMapResultToViewData = mapResultToViewData(getScanConfiguration(), resultFront, resultBack);
        setDocumentCaptureViewState(new ScanState.CaptureCompleted(getScanConfiguration(), documentScanResultViewDataMapResultToViewData));
        navigateToNextScreen(documentScanResultViewDataMapResultToViewData);
    }

    private ScanState getDocumentCaptureViewState() {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        ScanState scanState = (ScanState) savedStateHandle.get(DocumentScanViewModelKt.SCAN_VIEW_STATE_KEY);
        if (scanState != null) {
            return scanState;
        }
        throw new IllegalArgumentException(" Scan State has not been saved yet and it is null".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IdScanConfigurationViewData getScanConfiguration() {
        return getDocumentCaptureViewState().getScanConfiguration();
    }

    private void handleNfcResult(int resultCode, Map<Integer, byte[]> nfcPayload) {
        if (resultCode == -1 || resultCode == 1) {
            DocumentScanResultViewData data = ((ScanState.CaptureCompleted) getDocumentCaptureViewState()).getData();
            data.setMrtdCaptureResult(nfcPayload);
            navigateToUpload(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object mapResultToEntity(IdScanConfigurationViewData idScanConfigurationViewData, DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2, Continuation<? super IdDocumentEntity> continuation) {
        Object objMap2 = this.documentCaptureViewDataToEntityMapper.map(mapResultToViewData(idScanConfigurationViewData, documentCaptureResult, documentCaptureResult2), continuation);
        return objMap2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMap2 : (IdDocumentEntity) objMap2;
    }

    static /* synthetic */ Object mapResultToEntity$default(DocumentScanViewModel documentScanViewModel, IdScanConfigurationViewData idScanConfigurationViewData, DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mapResultToEntity");
        }
        if ((i & 4) != 0) {
            documentCaptureResult2 = null;
        }
        return documentScanViewModel.mapResultToEntity(idScanConfigurationViewData, documentCaptureResult, documentCaptureResult2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mapResultToReviewViewData(com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData r12, com.yoti.mobile.android.documentscan.model.DocumentCaptureResult r13, int r14, kotlin.coroutines.Continuation<? super com.yoti.mobile.android.documentcapture.p055id.view.scan.PageScanReviewViewData> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.C46341
            if (r0 == 0) goto L13
            r0 = r15
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$mapResultToReviewViewData$1 r0 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.C46341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$mapResultToReviewViewData$1 r0 = new com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanViewModel$mapResultToReviewViewData$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L58
            if (r1 == r2) goto L42
            if (r1 != r9) goto L3a
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$2
            com.yoti.mobile.android.documentscan.model.DocumentCaptureResult r13 = (com.yoti.mobile.android.documentscan.model.DocumentCaptureResult) r13
            java.lang.Object r14 = r0.L$1
            com.yoti.mobile.android.documentcapture.id.view.scan.IdScanConfigurationViewData r14 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData) r14
            java.lang.Object r0 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper r0 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L96
        L3a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L42:
            int r14 = r0.I$0
            java.lang.Object r12 = r0.L$3
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor r12 = (com.yoti.mobile.android.documentcapture.p055id.domain.GetNfcFlowTypeInteractor) r12
            java.lang.Object r13 = r0.L$2
            com.yoti.mobile.android.documentscan.model.DocumentCaptureResult r13 = (com.yoti.mobile.android.documentscan.model.DocumentCaptureResult) r13
            java.lang.Object r1 = r0.L$1
            com.yoti.mobile.android.documentcapture.id.view.scan.IdScanConfigurationViewData r1 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData) r1
            java.lang.Object r2 = r0.L$0
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper r2 = (com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L7d
        L58:
            kotlin.ResultKt.throwOnFailure(r15)
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper r15 = r11.documentCaptureResultToReviewViewDataMapper
            com.yoti.mobile.android.documentcapture.id.domain.GetNfcFlowTypeInteractor r10 = r11.getNfcFlowType
            r0.L$0 = r15
            r0.L$1 = r12
            r0.L$2 = r13
            r0.L$3 = r10
            r0.I$0 = r14
            r0.label = r2
            r6 = 4
            r7 = 0
            r4 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r5 = r0
            java.lang.Object r1 = mapResultToEntity$default(r1, r2, r3, r4, r5, r6, r7)
            if (r1 != r8) goto L79
            return r8
        L79:
            r2 = r15
            r15 = r1
            r1 = r12
            r12 = r10
        L7d:
            com.yoti.mobile.android.documentcapture.id.domain.model.IdDocumentEntity r15 = (com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity) r15
            r0.L$0 = r2
            r0.L$1 = r1
            r0.L$2 = r13
            r3 = 0
            r0.L$3 = r3
            r0.I$0 = r14
            r0.label = r9
            java.lang.Object r15 = r12.invoke(r15, r0)
            if (r15 != r8) goto L93
            return r8
        L93:
            r12 = r14
            r14 = r1
            r0 = r2
        L96:
            com.yoti.mobile.android.documentcapture.id.domain.NfcFlowType r15 = (com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType) r15
            com.yoti.mobile.android.documentcapture.id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper$MapperParams r1 = new com.yoti.mobile.android.documentcapture.id.view.scan.DocumentCaptureResultToPageScanReviewViewDataMapper$MapperParams
            r1.<init>(r14, r13, r12, r15)
            com.yoti.mobile.android.documentcapture.id.view.scan.PageScanReviewViewData r12 = r0.map(r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel.mapResultToReviewViewData(com.yoti.mobile.android.documentcapture.id.view.scan.IdScanConfigurationViewData, com.yoti.mobile.android.documentscan.model.DocumentCaptureResult, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private DocumentScanResultViewData mapResultToViewData(IdScanConfigurationViewData scanConfig, DocumentCaptureResult resultFront, DocumentCaptureResult resultBack) {
        return this.documentCaptureResultToResultViewDataMapper.map(new DocumentScanResultsToDocumentScanResultViewDataMapper.MapperParams(scanConfig, resultFront, resultBack));
    }

    static /* synthetic */ DocumentScanResultViewData mapResultToViewData$default(DocumentScanViewModel documentScanViewModel, IdScanConfigurationViewData idScanConfigurationViewData, DocumentCaptureResult documentCaptureResult, DocumentCaptureResult documentCaptureResult2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mapResultToViewData");
        }
        if ((i & 4) != 0) {
            documentCaptureResult2 = null;
        }
        return documentScanViewModel.mapResultToViewData(idScanConfigurationViewData, documentCaptureResult, documentCaptureResult2);
    }

    private Job navigateToNextScreen(DocumentScanResultViewData documentCaptureViewData) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46351(documentCaptureViewData, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToNfc() {
        this._navigationEvent.setValue(new DocumentScanNavigationEvent.NavigateToNfcCapture(this.bacCredentialMapper.map(((ScanState.CaptureCompleted) getDocumentCaptureViewState()).getData())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToNfcPrompt() {
        this._navigationEvent.setValue(new DocumentScanNavigationEvent.NavigateToNfcPrompt(((ScanState.CaptureCompleted) getDocumentCaptureViewState()).getData()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToUpload(DocumentScanResultViewData documentData) {
        this._navigationEvent.setValue(new DocumentScanNavigationEvent.NavigateToUpload(documentData));
    }

    private Job review(DocumentCaptureResult result, int pageIndex) {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C46361(result, pageIndex, null), 3, null);
    }

    private void setBackSideCapture(DocumentCaptureResult resultBack) {
        review(resultBack, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentCaptureViewState(ScanState scanState) {
        SavedStateHandle savedStateHandle = this.savedStateHandle;
        if (savedStateHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedStateHandle");
            savedStateHandle = null;
        }
        savedStateHandle.set(DocumentScanViewModelKt.SCAN_VIEW_STATE_KEY, scanState);
        this._documentScanViewState.setValue(scanState);
    }

    private void setDocumentPageApproved() {
        setDocumentCaptureViewState(new ScanState.PageApproved(getScanConfiguration()));
    }

    private void setDocumentPageRejected() {
        setDocumentCaptureViewState(new ScanState.PageRejected(getScanConfiguration()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentScanningError(Throwable error) {
        Throwable map = this.errorToEntityMapper.map(error);
        this.sessionStatus.setSessionStatus(this.errorToSessionStatusMapper.map(map));
        setDocumentCaptureViewState(new ScanState.Error(getScanConfiguration(), this.errorToFailureMapper.map(map)));
    }

    private void setFrontSideCapture(DocumentCaptureResult resultFront) {
        review(resultFront, 0);
    }

    private void startCapture(IdScanConfigurationViewData scanConfig) {
        setDocumentCaptureViewState(new ScanState.ScanFront(scanConfig));
    }

    public LiveData<ScanState> getDocumentViewScanState() {
        return this.documentViewScanState;
    }

    public LiveData<DocumentScanNavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public void handleViewEvent(DocumentScanViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof DocumentScanViewEvent.OnViewStarted) {
            startCapture(((DocumentScanViewEvent.OnViewStarted) event).getScanConfig());
            return;
        }
        if (event instanceof DocumentScanViewEvent.OnFrontPageCaptured) {
            setFrontSideCapture(((DocumentScanViewEvent.OnFrontPageCaptured) event).getPage());
            return;
        }
        if (event instanceof DocumentScanViewEvent.OnBackPageCaptured) {
            setBackSideCapture(((DocumentScanViewEvent.OnBackPageCaptured) event).getPage());
            return;
        }
        if (Intrinsics.areEqual(event, DocumentScanViewEvent.OnPageApproved.INSTANCE)) {
            setDocumentPageApproved();
            return;
        }
        if (Intrinsics.areEqual(event, DocumentScanViewEvent.OnPageRejected.INSTANCE)) {
            setDocumentPageRejected();
            return;
        }
        if (event instanceof DocumentScanViewEvent.OnScanCompleted) {
            DocumentScanViewEvent.OnScanCompleted onScanCompleted = (DocumentScanViewEvent.OnScanCompleted) event;
            completeScan(onScanCompleted.getResultFront(), onScanCompleted.getResultBack());
        } else {
            if (event instanceof DocumentScanViewEvent.OnScanError) {
                setDocumentScanningError(((DocumentScanViewEvent.OnScanError) event).getError());
                return;
            }
            if (event instanceof DocumentScanViewEvent.OnNfcResult) {
                DocumentScanViewEvent.OnNfcResult onNfcResult = (DocumentScanViewEvent.OnNfcResult) event;
                handleNfcResult(onNfcResult.getResultCode(), onNfcResult.getChipData());
            } else if (Intrinsics.areEqual(event, DocumentScanViewEvent.OnFinishCaptureFlow.INSTANCE)) {
                cleanupCapture();
            }
        }
    }

    @Override // com.yoti.mobile.android.commonui.SavedStateHandleHolder
    public void setSavedStateHandle(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.savedStateHandle = handle;
    }
}
