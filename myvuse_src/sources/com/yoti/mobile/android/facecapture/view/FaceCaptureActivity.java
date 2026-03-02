package com.yoti.mobile.android.facecapture.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.p070di.FaceCaptureSession;
import com.yoti.mobile.android.facecapture.view.capture.FaceCaptureViewModel;
import com.yoti.mobile.android.facecapture.view.capture.model.FaceCaptureViewEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/FaceCaptureActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$facecapture_productionRelease", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$facecapture_productionRelease", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private FaceCaptureViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public final ViewModelProvider.Factory getViewModelFactory$facecapture_productionRelease() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("FaceCaptureActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "FaceCaptureActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "FaceCaptureActivity#onCreate", null);
        }
        FaceCaptureSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(C4832R.layout.yds_activity_face_capture);
        this.viewModel = (FaceCaptureViewModel) new ViewModelProvider(this, getViewModelFactory$facecapture_productionRelease()).get(FaceCaptureViewModel.class);
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        if (isFinishing()) {
            FaceCaptureViewModel faceCaptureViewModel = this.viewModel;
            if (faceCaptureViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                faceCaptureViewModel = null;
            }
            faceCaptureViewModel.handleViewEvent(FaceCaptureViewEvent.OnFaceCaptureFinished.INSTANCE);
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

    public final void setViewModelFactory$facecapture_productionRelease(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
