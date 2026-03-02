package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.facetec.sdk.FaceTecFaceScanProcessor;
import com.facetec.sdk.FaceTecFaceScanResultCallback;
import com.facetec.sdk.FaceTecSessionActivity;
import com.facetec.sdk.FaceTecSessionResult;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragmentArgs;
import com.yoti.mobile.android.liveness.zoom.C4888R;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecSession;
import com.yoti.mobile.android.liveness.zoom.p072di.module.ForLivenessCapture;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureViewModel;
import com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecFailureType;
import com.yoti.mobile.android.liveness.zoom.view.capture.model.LivenessFaceTecCaptureViewData;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "fragmentArgs", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "livenessCaptureViewModel", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "displayFaceTecLivenessCaptureFailureState", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "displayFaceTecLivenessCaptureSuccessState", "livenessCapture", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/model/LivenessFaceTecCaptureViewData;", "onAttach", "context", "Landroid/content/Context;", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureNavigationEvent;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "state", "Lcom/yoti/mobile/android/liveness/zoom/view/capture/LivenessFaceTecCaptureViewModel$LivenessCaptureViewState;", "showLivenessCaptureFailure", "showScanFaceErrorScreen", "startFaceTecCaptureScreen", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessFaceTecCaptureFragment extends BaseFragment {

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;
    private LivenessFaceTecCaptureViewModel livenessCaptureViewModel;

    @Inject
    public SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> viewModelFactory;

    public LivenessFaceTecCaptureFragment() {
        super(C4888R.layout.yds_fragment_liveness_facetec_capture);
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(LivenessFaceTecCaptureFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment$special$$inlined$navArgs$1
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

    private final void displayFaceTecLivenessCaptureFailureState(YdsFailure failure) {
        LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel = this.livenessCaptureViewModel;
        if (livenessFaceTecCaptureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("livenessCaptureViewModel");
            livenessFaceTecCaptureViewModel = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        livenessFaceTecCaptureViewModel.cleanupCapture(contextRequireContext);
        showLivenessCaptureFailure(failure);
    }

    private final void displayFaceTecLivenessCaptureSuccessState(LivenessFaceTecCaptureViewData livenessCapture) {
        NavigationKt.navigateSafeToNavGraph(FragmentKt.findNavController(this), C4888R.navigation.yds_liveness_upload_nav_graph, new LivenessUploadFragmentArgs(livenessCapture).toBundle());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LivenessFaceTecCaptureFragmentArgs getFragmentArgs() {
        return (LivenessFaceTecCaptureFragmentArgs) this.fragmentArgs.getValue();
    }

    @ForLivenessCapture
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEvent(LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent event) {
        if (event instanceof LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent.NavigateToUpload) {
            displayFaceTecLivenessCaptureSuccessState(((LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent.NavigateToUpload) event).getData());
        } else if (event instanceof LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent.NavigateToCaptureFailure) {
            displayFaceTecLivenessCaptureFailureState(((LivenessFaceTecCaptureViewModel.LivenessCaptureNavigationEvent.NavigateToCaptureFailure) event).getFailure());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewStateChanged(LivenessFaceTecCaptureViewModel.LivenessCaptureViewState state) {
        if (state instanceof LivenessFaceTecCaptureViewModel.LivenessCaptureViewState.LivenessCaptureInProgress) {
            startFaceTecCaptureScreen();
        }
    }

    private final void showLivenessCaptureFailure(YdsFailure failure) {
        if (failure.getFailureType() instanceof LivenessFaceTecFailureType.FaceTecSessionCancelledFailure) {
            navigateBack();
        } else if (failure.isRetryAllowed()) {
            showScanFaceErrorScreen(failure);
        } else {
            showDeadEndFailure(failure.getFailureType());
        }
    }

    private final void showScanFaceErrorScreen(YdsFailure failure) {
        NavigationKt.navigateSafe$default(FragmentKt.findNavController(this), C4888R.id.action_to_scanFaceErrorFragment, new GenericMessageFragmentArgs(failure.getFailureType().getF7488a(), failure.getFailureType().getF7489b(), null, failure.getFailureType().getF7490c(), null, C4888R.string.yds_invalid_liveness_attempt_primary_cta, null, C4888R.drawable.chevron_right_white, 0, null, 0, null, 3924, null).toBundle(), null, null, 12, null);
    }

    private final void startFaceTecCaptureScreen() {
        FaceTecSessionActivity.createAndLaunchSession(requireContext(), new FaceTecFaceScanProcessor() { // from class: com.yoti.mobile.android.liveness.zoom.view.capture.LivenessFaceTecCaptureFragment$$ExternalSyntheticLambda0
            @Override // com.facetec.sdk.FaceTecFaceScanProcessor
            public final void processSessionWhileFaceTecSDKWaits(FaceTecSessionResult faceTecSessionResult, FaceTecFaceScanResultCallback faceTecFaceScanResultCallback) {
                LivenessFaceTecCaptureFragment.m6886startFaceTecCaptureScreen$lambda1(this.f$0, faceTecSessionResult, faceTecFaceScanResultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startFaceTecCaptureScreen$lambda-1, reason: not valid java name */
    public static final void m6886startFaceTecCaptureScreen$lambda1(LivenessFaceTecCaptureFragment this$0, FaceTecSessionResult faceTecSessionResult, FaceTecFaceScanResultCallback faceTecFaceScanResultCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new LivenessFaceTecCaptureFragment$startFaceTecCaptureScreen$1$1(faceTecFaceScanResultCallback, null), 3, null);
    }

    public final SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LivenessFaceTecSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> viewModelFactory = getViewModelFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        LivenessFaceTecCaptureViewModel livenessFaceTecCaptureViewModel = (LivenessFaceTecCaptureViewModel) viewModelFactory.create(fragmentActivityRequireActivity);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, livenessFaceTecCaptureViewModel.getNavigationEvent(), new LivenessFaceTecCaptureFragment$onViewCreated$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, livenessFaceTecCaptureViewModel.getViewState(), new LivenessFaceTecCaptureFragment$onViewCreated$1$2(this));
        livenessFaceTecCaptureViewModel.startLivenessCapture(getFragmentArgs().getResourceId());
        this.livenessCaptureViewModel = livenessFaceTecCaptureViewModel;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<LivenessFaceTecCaptureViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
