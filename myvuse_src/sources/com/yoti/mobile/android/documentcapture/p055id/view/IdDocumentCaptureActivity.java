package com.yoti.mobile.android.documentcapture.p055id.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateHandleHolderViewModelFactoryProvider;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanViewModel;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentStartDestinationResolver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/IdDocumentCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "documentScanViewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanViewModel;", "startDestinationResolver", "Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;", "getStartDestinationResolver", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;", "setStartDestinationResolver", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentStartDestinationResolver;)V", "viewModelFactoryProvider", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "getViewModelFactoryProvider", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;", "setViewModelFactoryProvider", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateHandleHolderViewModelFactoryProvider;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentCaptureActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private DocumentScanViewModel documentScanViewModel;

    @Inject
    public DocumentStartDestinationResolver startDestinationResolver;

    @Inject
    public SavedStateHandleHolderViewModelFactoryProvider viewModelFactoryProvider;

    public final DocumentStartDestinationResolver getStartDestinationResolver() {
        DocumentStartDestinationResolver documentStartDestinationResolver = this.startDestinationResolver;
        if (documentStartDestinationResolver != null) {
            return documentStartDestinationResolver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startDestinationResolver");
        return null;
    }

    public final SavedStateHandleHolderViewModelFactoryProvider getViewModelFactoryProvider() {
        SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider = this.viewModelFactoryProvider;
        if (savedStateHandleHolderViewModelFactoryProvider != null) {
            return savedStateHandleHolderViewModelFactoryProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactoryProvider");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("IdDocumentCaptureActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "IdDocumentCaptureActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "IdDocumentCaptureActivity#onCreate", null);
        }
        IdDocumentCaptureSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(C4608R.layout.yds_activity_id_document_capture);
        DocumentStartDestinationResolver startDestinationResolver = getStartDestinationResolver();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        startDestinationResolver.resolve(supportFragmentManager, C4608R.id.idDocumentNavigationFragment, C4608R.navigation.yds_id_document_capture_nav_graph);
        this.documentScanViewModel = (DocumentScanViewModel) new ViewModelProvider(this, getViewModelFactoryProvider().create(this)).get(DocumentScanViewModel.class);
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        if (isFinishing()) {
            DocumentScanViewModel documentScanViewModel = this.documentScanViewModel;
            if (documentScanViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentScanViewModel");
                documentScanViewModel = null;
            }
            documentScanViewModel.handleViewEvent(DocumentScanViewModel.DocumentScanViewEvent.OnFinishCaptureFlow.INSTANCE);
        }
        super.onPause();
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

    public final void setStartDestinationResolver(DocumentStartDestinationResolver documentStartDestinationResolver) {
        Intrinsics.checkNotNullParameter(documentStartDestinationResolver, "<set-?>");
        this.startDestinationResolver = documentStartDestinationResolver;
    }

    public final void setViewModelFactoryProvider(SavedStateHandleHolderViewModelFactoryProvider savedStateHandleHolderViewModelFactoryProvider) {
        Intrinsics.checkNotNullParameter(savedStateHandleHolderViewModelFactoryProvider, "<set-?>");
        this.viewModelFactoryProvider = savedStateHandleHolderViewModelFactoryProvider;
    }
}
