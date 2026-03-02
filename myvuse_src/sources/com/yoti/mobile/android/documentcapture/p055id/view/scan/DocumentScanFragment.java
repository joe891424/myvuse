package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavArgsLazy;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsDocumentScanFragmentBinding;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentCapture;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentPageReviewFragment;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanState;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.VerifyYourDetailsFragmentArgs;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragmentArgs;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.DocumentCaptureException;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener;
import com.yoti.mobile.android.mrtd.MrtdCaptureLauncher;
import com.yoti.mobile.android.mrtd.MrtdCaptureLauncherKt;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020.H\u0002J\"\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020%2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020%H\u0016J\b\u0010K\u001a\u00020%H\u0016J\u0010\u0010L\u001a\u00020%2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010M\u001a\u00020%H\u0016J\u001a\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020?2\b\u0010P\u001a\u0004\u0018\u00010?H\u0016J\b\u0010Q\u001a\u00020%H\u0016J\u001a\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020%2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020%2\u0006\u0010[\u001a\u00020\\H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001e8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006d"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "Lcom/yoti/mobile/android/documentscan/ui/ScanMultiSideDocumentListener;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentPageReviewFragment$DocumentPageReviewListener;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsDocumentScanFragmentBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsDocumentScanFragmentBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "documentScanViewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel;", "fragmentArgs", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scanFragment", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "getScanFragment", "()Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "scanFragmentFactory", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;", "getScanFragmentFactory", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;", "setScanFragmentFactory", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;)V", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "displayError", "", "error", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "initialiseAppBar", "navigateToNfc", "bacCredential", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "navigateToNfcPrompt", "documentData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "navigateToUpload", "scanResultViewData", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onAttachFragment", "childFragment", "Landroidx/fragment/app/Fragment;", "onBackSideScanned", "capture", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "onError", RsaJsonWebKey.FACTOR_CRT_COEFFICIENT, "Lcom/yoti/mobile/android/documentscan/ui/DocumentCaptureException;", "onFrontSideScanned", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel$DocumentScanNavigationEvent;", "onNegativeButtonClick", "dialogTag", "", "onPageReviewApproved", "onPageReviewCancelled", "onPositiveButtonClick", "onResume", "onScanCompleted", "resultFront", "resultBack", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "scanState", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanState;", "renderScannerView", "scanConfiguration", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "setDocumentPageReviewed", "isPageApproved", "", "showReviewScreen", "reviewViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "startScan", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentScanFragment extends BaseFragment implements ScanMultiSideDocumentListener, DocumentPageReviewFragment.DocumentPageReviewListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentScanFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsDocumentScanFragmentBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private DocumentScanViewModel documentScanViewModel;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;

    @Inject
    public IScanFragmentFactoryWrapper scanFragmentFactory;

    @Inject
    public SavedStateViewModelFactory<DocumentScanViewModel> viewModelFactory;

    public DocumentScanFragment() {
        super(C4608R.layout.yds_document_scan_fragment);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsDocumentScanFragmentBinding>() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsDocumentScanFragmentBinding invoke() {
                return YdsDocumentScanFragmentBinding.bind(this.this$0.requireView());
            }
        });
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DocumentScanFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.id.view.scan.DocumentScanFragment$special$$inlined$navArgs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() {
                Bundle arguments = this.getArguments();
                if (arguments != null) {
                    return arguments;
                }
                throw new IllegalStateException("Fragment " + this + " has null arguments");
            }
        });
    }

    private final void displayError(YdsFailure error) {
        showFailure(error, "SCAN_ERROR_DIALOG_TAG");
    }

    private final YdsDocumentScanFragmentBinding getBinding() {
        return (YdsDocumentScanFragmentBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentScanFragmentArgs getFragmentArgs() {
        return (DocumentScanFragmentArgs) this.fragmentArgs.getValue();
    }

    private final IScanDocument getScanFragment() {
        ActivityResultCaller activityResultCallerFindFragmentByTag = getChildFragmentManager().findFragmentByTag("SCAN_FRAGMENT_TAG");
        if (activityResultCallerFindFragmentByTag instanceof IScanDocument) {
            return (IScanDocument) activityResultCallerFindFragmentByTag;
        }
        return null;
    }

    @ForDocumentCapture
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    private final void initialiseAppBar() {
        YotiAppbarTransparent yotiAppbarTransparent = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbarTransparent, "binding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbarTransparent, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
    }

    private final void navigateToNfc(BacCredential bacCredential) {
        new MrtdCaptureLauncher(bacCredential).start(this);
    }

    private final void navigateToNfcPrompt(DocumentScanResultViewData documentData) {
        NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(this), C4608R.id.action_id_nav_scan_fragment_to_verifyYourDetailsFragment, new VerifyYourDetailsFragmentArgs(documentData).toBundle(), null, null, 12, null);
    }

    private final void navigateToUpload(DocumentScanResultViewData scanResultViewData) {
        NavigationKt.navigateSafeToNavGraph(androidx.navigation.fragment.FragmentKt.findNavController(this), C4608R.navigation.yds_document_upload_nav_graph, new DocumentUploadFragmentArgs(scanResultViewData).toBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEvent(DocumentScanViewModel.DocumentScanNavigationEvent event) {
        if (event instanceof DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToUpload) {
            navigateToUpload(((DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToUpload) event).getData());
        } else if (event instanceof DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToNfcPrompt) {
            navigateToNfcPrompt(((DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToNfcPrompt) event).getData());
        } else if (event instanceof DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToNfcCapture) {
            navigateToNfc(((DocumentScanViewModel.DocumentScanNavigationEvent.NavigateToNfcCapture) event).getBacCredential());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewStateChanged(ScanState scanState) {
        if (scanState instanceof ScanState.ScanFront) {
            startScan(scanState.getScanConfiguration());
            return;
        }
        if (scanState instanceof ScanState.ReviewScreen) {
            showReviewScreen(((ScanState.ReviewScreen) scanState).getData());
            return;
        }
        if (scanState instanceof ScanState.PageApproved) {
            setDocumentPageReviewed(true);
            return;
        }
        if (scanState instanceof ScanState.PageRejected) {
            setDocumentPageReviewed(false);
        } else if (scanState instanceof ScanState.Error) {
            displayError(((ScanState.Error) scanState).getError());
        } else {
            boolean z = scanState instanceof ScanState.CaptureCompleted;
        }
    }

    private final void renderScannerView(IdScanConfigurationViewData scanConfiguration) {
        getChildFragmentManager().beginTransaction().replace(C4608R.id.frameLayoutScanContainer, (Fragment) getScanFragmentFactory().create(new DocumentScanDetailedConfig(scanConfiguration.getScanConfigurations()), scanConfiguration, new BlinkIDLicense(scanConfiguration.getBlinkIdKey(), scanConfiguration.getBlinkIdLicensee()), C4608R.layout.yds_fragment_document_scan_overlay, ImageFormat.JPEG), "SCAN_FRAGMENT_TAG").commitNow();
    }

    private final void setDocumentPageReviewed(boolean isPageApproved) {
        IScanDocument scanFragment = getScanFragment();
        if (scanFragment == null) {
            throw new IllegalArgumentException("Scan fragment must not be null when updating its state!".toString());
        }
        scanFragment.documentPageReviewed(isPageApproved);
    }

    private final void showReviewScreen(PageScanReviewViewData reviewViewData) {
        DocumentPageReviewFragment.INSTANCE.newInstance(reviewViewData).show(getChildFragmentManager(), DocumentPageReviewFragmentKt.REVIEW_FRAGMENT_TAG);
    }

    private final void startScan(IdScanConfigurationViewData scanConfiguration) {
        renderScannerView(scanConfiguration);
    }

    public final IScanFragmentFactoryWrapper getScanFragmentFactory() {
        IScanFragmentFactoryWrapper iScanFragmentFactoryWrapper = this.scanFragmentFactory;
        if (iScanFragmentFactoryWrapper != null) {
            return iScanFragmentFactoryWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scanFragmentFactory");
        return null;
    }

    public final SavedStateViewModelFactory<DocumentScanViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<DocumentScanViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1003) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        Serializable serializableExtra = data != null ? data.getSerializableExtra(MrtdCaptureLauncherKt.CHIP_DATA_EXTRA) : null;
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnNfcResult(resultCode, serializableExtra instanceof Map ? (Map) serializableExtra : null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        super.onAttachFragment(childFragment);
        if (childFragment instanceof IScanDocument) {
            ((IScanDocument) childFragment).setListener(this);
        }
    }

    @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
    public void onBackSideScanned(DocumentCaptureResult capture) {
        Intrinsics.checkNotNullParameter(capture, "capture");
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnBackPageCaptured(capture));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
    public void onError(DocumentCaptureException t) {
        Intrinsics.checkNotNullParameter(t, "t");
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnScanError(t));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
    public void onFrontSideScanned(DocumentCaptureResult capture) {
        Intrinsics.checkNotNullParameter(capture, "capture");
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnFrontPageCaptured(capture));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "SCAN_ERROR_DIALOG_TAG")) {
            cancelFlow();
        }
    }

    @Override // com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment.DocumentPageReviewListener
    public void onPageReviewApproved() {
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(DocumentScanViewModel.DocumentScanViewEvent.OnPageApproved.INSTANCE);
    }

    @Override // com.yoti.mobile.android.documentcapture.id.view.scan.DocumentPageReviewFragment.DocumentPageReviewListener
    public void onPageReviewCancelled() {
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(DocumentScanViewModel.DocumentScanViewEvent.OnPageRejected.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnViewStarted(getFragmentArgs().getIdScanConfigurationViewData()));
    }

    @Override // com.yoti.mobile.android.documentscan.ui.ScanMultiSideDocumentListener
    public void onScanCompleted(DocumentCaptureResult resultFront, DocumentCaptureResult resultBack) {
        Intrinsics.checkNotNullParameter(resultFront, "resultFront");
        DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
        if (documentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
            documentScanViewModel = null;
        }
        documentScanViewModel.handleViewEvent(new DocumentScanViewModel.DocumentScanViewEvent.OnScanCompleted(resultFront, resultBack));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(DocumentPageReviewFragmentKt.REVIEW_FRAGMENT_TAG);
        if (fragmentFindFragmentByTag != null) {
            ((DocumentPageReviewFragment) fragmentFindFragmentByTag).dismiss();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SavedStateViewModelFactory<DocumentScanViewModel> viewModelFactory = getViewModelFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        DocumentScanViewModel documentScanViewModel = (DocumentScanViewModel) viewModelFactory.create(fragmentActivityRequireActivity);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, documentScanViewModel.getDocumentViewScanState(), new DocumentScanFragment$onViewCreated$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, documentScanViewModel.getNavigationEvent(), new DocumentScanFragment$onViewCreated$1$2(this));
        this.documentScanViewModel = documentScanViewModel;
        initialiseAppBar();
    }

    public final void setScanFragmentFactory(IScanFragmentFactoryWrapper iScanFragmentFactoryWrapper) {
        Intrinsics.checkNotNullParameter(iScanFragmentFactoryWrapper, "<set-?>");
        this.scanFragmentFactory = iScanFragmentFactoryWrapper;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<DocumentScanViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
