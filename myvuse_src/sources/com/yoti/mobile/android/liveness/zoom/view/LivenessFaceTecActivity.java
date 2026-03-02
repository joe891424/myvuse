package com.yoti.mobile.android.liveness.zoom.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.facetec.sdk.FaceTecSessionActivity;
import com.facetec.sdk.FaceTecSessionResult;
import com.newrelic.agent.android.api.p044v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.zoom.databinding.YdsActivityLivenessFacetecBinding;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecSession;
import com.yoti.mobile.android.liveness.zoom.p072di.module.ForLivenessCapture;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/LivenessFaceTecActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/yoti/mobile/android/liveness/zoom/databinding/YdsActivityLivenessFacetecBinding;", "livenessCaptureViewModel", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;
    private YdsActivityLivenessFacetecBinding binding;
    private LivenessFaceTecCaptureViewModel livenessCaptureViewModel;

    @Inject
    public SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> viewModelFactory;

    @ForLivenessCapture
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    public final SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002) {
            LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel = null;
            FaceTecSessionResult sessionResultFromActivityResult = data != null ? FaceTecSessionActivity.getSessionResultFromActivityResult(data) : null;
            LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel2 = this.livenessCaptureViewModel;
            if (livenessFaceTecCaptureViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("livenessCaptureViewModel");
            } else {
                livenessFaceTecCaptureViewModel = livenessFaceTecCaptureViewModel2;
            }
            livenessFaceTecCaptureViewModel.handleFaceTecResult(sessionResultFromActivityResult);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TraceMachine.startTracing("LivenessFaceTecActivity");
        YdsActivityLivenessFacetecBinding ydsActivityLivenessFacetecBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "LivenessFaceTecActivity#onCreate", null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod(null, "LivenessFaceTecActivity#onCreate", null);
        }
        LivenessFaceTecSession.INSTANCE.getInstance().initComponent(this, savedInstanceState).inject(this);
        super.onCreate(savedInstanceState);
        YdsActivityLivenessFacetecBinding ydsActivityLivenessFacetecBindingInflate = YdsActivityLivenessFacetecBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(ydsActivityLivenessFacetecBindingInflate, "inflate(layoutInflater)");
        this.binding = ydsActivityLivenessFacetecBindingInflate;
        if (ydsActivityLivenessFacetecBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ydsActivityLivenessFacetecBinding = ydsActivityLivenessFacetecBindingInflate;
        }
        setContentView(ydsActivityLivenessFacetecBinding.getRoot());
        this.livenessCaptureViewModel = (LivenessFaceTecCaptureViewModel) getViewModelFactory().create(this);
        TraceMachine.exitMethod();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        if (isFinishing()) {
            LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel = this.livenessCaptureViewModel;
            if (livenessFaceTecCaptureViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("livenessCaptureViewModel");
                livenessFaceTecCaptureViewModel = null;
            }
            livenessFaceTecCaptureViewModel.cleanupCapture(this);
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

    public final void setViewModelFactory(SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
