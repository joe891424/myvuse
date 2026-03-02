package com.yoti.mobile.android.documentcapture.sup.view.scan.automation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsActivityAutomationCaptureBinding;
import com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "supDocFileUriProvider", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;", "getSupDocFileUriProvider", "()Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;", "setSupDocFileUriProvider", "(Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationSupDocFileUriProvider;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationCaptureActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    @Inject
    public AutomationSupDocFileUriProvider supDocFileUriProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-3$lambda-0, reason: not valid java name */
    public static final void m6837onCreate$lambda3$lambda0(AutomationCaptureActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setResult(-1);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-3$lambda-1, reason: not valid java name */
    public static final void m6838onCreate$lambda3$lambda1(AutomationCaptureActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setData(this$0.getSupDocFileUriProvider().getPdfUri());
        this$0.setResult(-1, intent);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCreate$lambda-3$lambda-2, reason: not valid java name */
    public static final void m6839onCreate$lambda3$lambda2(AutomationCaptureActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.setData(this$0.getSupDocFileUriProvider().getImageUri());
        this$0.setResult(-1, intent);
        this$0.finish();
    }

    public final AutomationSupDocFileUriProvider getSupDocFileUriProvider() {
        AutomationSupDocFileUriProvider automationSupDocFileUriProvider = this.supDocFileUriProvider;
        if (automationSupDocFileUriProvider != null) {
            return automationSupDocFileUriProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supDocFileUriProvider");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("AutomationCaptureActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutomationCaptureActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "AutomationCaptureActivity#onCreate", null);
        }
        SupDocumentCaptureSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        YdsActivityAutomationCaptureBinding ydsActivityAutomationCaptureBindingInflate = YdsActivityAutomationCaptureBinding.inflate(getLayoutInflater());
        setContentView(ydsActivityAutomationCaptureBindingInflate.getRoot());
        if (!getIntent().getBooleanExtra(AutomationCaptureActivityKt.EXTRA_CAMERA_ENABLED, false)) {
            ydsActivityAutomationCaptureBindingInflate.takePictureButton.setVisibility(8);
        }
        ydsActivityAutomationCaptureBindingInflate.takePictureButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationCaptureActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutomationCaptureActivity.m6837onCreate$lambda3$lambda0(this.f$0, view);
            }
        });
        ydsActivityAutomationCaptureBindingInflate.selectPdfButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationCaptureActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutomationCaptureActivity.m6838onCreate$lambda3$lambda1(this.f$0, view);
            }
        });
        ydsActivityAutomationCaptureBindingInflate.selectImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationCaptureActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutomationCaptureActivity.m6839onCreate$lambda3$lambda2(this.f$0, view);
            }
        });
        TraceMachine.exitMethod();
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

    public final void setSupDocFileUriProvider(AutomationSupDocFileUriProvider automationSupDocFileUriProvider) {
        Intrinsics.checkNotNullParameter(automationSupDocFileUriProvider, "<set-?>");
        this.supDocFileUriProvider = automationSupDocFileUriProvider;
    }
}
