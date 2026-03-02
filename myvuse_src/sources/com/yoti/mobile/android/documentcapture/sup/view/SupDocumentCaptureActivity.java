package com.yoti.mobile.android.documentcapture.sup.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ActivityKt;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentScan;
import com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.sup.view.review.DocumentReviewFragmentArgs;
import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupplementaryDocumentViewData;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J-\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'H\u0014J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\b\u00106\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00067"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/SupDocumentCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cameraFileUri", "Landroid/net/Uri;", "captureChooser", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "getCaptureChooser", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "setCaptureChooser", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;)V", "startDestinationResolver", "Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;", "getStartDestinationResolver", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;", "setStartDestinationResolver", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;)V", "viewModel", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "checkCameraPermission", "", "navigateToReview", "reviewData", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupplementaryDocumentViewData;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSaveInstanceState", "outState", "onViewState", "viewState", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel$ViewState;", "requestCameraPermission", "showCameraAndFilePickerChooser", "showFilePicker", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentCaptureActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private Uri cameraFileUri;

    @Inject
    public ICaptureChooser captureChooser;

    @Inject
    public DocumentStartDestinationResolver startDestinationResolver;
    private SupDocumentScanViewModel viewModel;

    @Inject
    public SavedStateViewModelFactory<SupDocumentScanViewModel> viewModelFactory;

    private final void checkCameraPermission() {
        SupDocumentScanViewModel supDocumentScanViewModel = this.viewModel;
        if (supDocumentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            supDocumentScanViewModel = null;
        }
        supDocumentScanViewModel.handleCheckCameraPermissionResult(ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0);
    }

    @ForDocumentScan
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    private final void navigateToReview(SupplementaryDocumentViewData reviewData) {
        NavigationKt.navigateSafe$default(ActivityKt.findNavController(this, C4653R.id.idDocumentNavigationFragment), C4653R.id.action_global_to_review, new DocumentReviewFragmentArgs(reviewData).toBundle(), null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewState(SupDocumentScanViewModel.ViewState viewState) {
        if (Intrinsics.areEqual(viewState, SupDocumentScanViewModel.ViewState.CheckCameraPermission.INSTANCE)) {
            checkCameraPermission();
            return;
        }
        if (Intrinsics.areEqual(viewState, SupDocumentScanViewModel.ViewState.RequestCameraPermission.INSTANCE)) {
            requestCameraPermission();
            return;
        }
        if (Intrinsics.areEqual(viewState, SupDocumentScanViewModel.ViewState.ShowCameraAndFilePickerChooser.INSTANCE)) {
            showCameraAndFilePickerChooser();
        } else if (Intrinsics.areEqual(viewState, SupDocumentScanViewModel.ViewState.ShowFilePicker.INSTANCE)) {
            showFilePicker();
        } else if (viewState instanceof SupDocumentScanViewModel.ViewState.NavigateToReview) {
            navigateToReview(((SupDocumentScanViewModel.ViewState.NavigateToReview) viewState).getReviewData());
        }
    }

    private final void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
    }

    private final void showCameraAndFilePickerChooser() {
        this.cameraFileUri = getCaptureChooser().showCameraAndFilePickerChooser(this);
    }

    private final void showFilePicker() {
        getCaptureChooser().showFilePicker(this);
    }

    public final ICaptureChooser getCaptureChooser() {
        ICaptureChooser iCaptureChooser = this.captureChooser;
        if (iCaptureChooser != null) {
            return iCaptureChooser;
        }
        Intrinsics.throwUninitializedPropertyAccessException("captureChooser");
        return null;
    }

    public final DocumentStartDestinationResolver getStartDestinationResolver() {
        DocumentStartDestinationResolver documentStartDestinationResolver = this.startDestinationResolver;
        if (documentStartDestinationResolver != null) {
            return documentStartDestinationResolver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startDestinationResolver");
        return null;
    }

    public final SavedStateViewModelFactory<SupDocumentScanViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri data2;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 2) {
            if (data == null || (data2 = data.getData()) == null) {
                data2 = this.cameraFileUri;
            }
            if (data2 != null) {
                SupDocumentScanViewModel supDocumentScanViewModel = this.viewModel;
                if (supDocumentScanViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    supDocumentScanViewModel = null;
                }
                supDocumentScanViewModel.handleFilePickerResult(data2);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Uri uri;
        TraceMachine.startTracing("SupDocumentCaptureActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupDocumentCaptureActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "SupDocumentCaptureActivity#onCreate", null);
        }
        SupDocumentCaptureSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(C4653R.layout.yds_activity_sup_document_capture);
        DocumentStartDestinationResolver startDestinationResolver = getStartDestinationResolver();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        startDestinationResolver.resolve(supportFragmentManager, C4653R.id.idDocumentNavigationFragment, C4653R.navigation.yds_sup_document_capture_nav_graph);
        if (savedInstanceState != null && (uri = (Uri) savedInstanceState.getParcelable("KEY_CAMERA_FILE_URI")) != null) {
            this.cameraFileUri = uri;
        }
        SupDocumentScanViewModel supDocumentScanViewModel = (SupDocumentScanViewModel) getViewModelFactory().create(this);
        LifecycleKt.observe(this, supDocumentScanViewModel.getViewState(), new SupDocumentCaptureActivity$onCreate$2$1(this));
        this.viewModel = supDocumentScanViewModel;
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            SupDocumentScanViewModel supDocumentScanViewModel = this.viewModel;
            if (supDocumentScanViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                supDocumentScanViewModel = null;
            }
            Integer orNull = ArraysKt.getOrNull(grantResults, 0);
            supDocumentScanViewModel.handleRequestCameraPermissionResult(orNull != null && orNull.intValue() == 0);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("KEY_CAMERA_FILE_URI", this.cameraFileUri);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setCaptureChooser(ICaptureChooser iCaptureChooser) {
        Intrinsics.checkNotNullParameter(iCaptureChooser, "<set-?>");
        this.captureChooser = iCaptureChooser;
    }

    public final void setStartDestinationResolver(DocumentStartDestinationResolver documentStartDestinationResolver) {
        Intrinsics.checkNotNullParameter(documentStartDestinationResolver, "<set-?>");
        this.startDestinationResolver = documentStartDestinationResolver;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
