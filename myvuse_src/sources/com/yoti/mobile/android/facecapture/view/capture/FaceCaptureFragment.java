package com.yoti.mobile.android.facecapture.view.capture;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yoti.mobile.android.capture.face.p048ui.FaceCapture;
import com.yoti.mobile.android.capture.face.p048ui.FaceCaptureListener;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraState;
import com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraStateListener;
import com.yoti.mobile.android.capture.face.p048ui.models.face.FaceCaptureResult;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.VerticalScrollingGradient;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.facecapture.C4832R;
import com.yoti.mobile.android.facecapture.databinding.YdsFragmentFaceCaptureBinding;
import com.yoti.mobile.android.facecapture.p070di.FaceCaptureSession;
import com.yoti.mobile.android.facecapture.view.capture.CaptureViewState;
import com.yoti.mobile.android.facecapture.view.capture.model.FaceCaptureViewEvent;
import com.yoti.mobile.android.facecapture.view.capture.model.ScanFeedback;
import com.yoti.mobile.android.facecapture.view.capture.util.CaptureConfigurationProvider;
import com.yoti.mobile.android.facecapture.view.capture.util.FaceCaptureConstants;
import com.yoti.mobile.android.facecapture.view.capture.util.LightSensor;
import com.yoti.mobile.android.facecapture.view.navigation.CaptureNavigationEvent;
import com.yoti.mobile.android.facecapture.view.review.FaceCaptureReviewFragmentArgs;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0016\u0010'\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0002J\u0019\u00106\u001a\u00020$2\n\b\u0001\u00107\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020$H\u0016J\b\u0010D\u001a\u00020$H\u0016J\u001a\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0014\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010KH\u0002J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020NH\u0002J\u001c\u0010Q\u001a\u00020N2\b\b\u0001\u0010R\u001a\u0002082\b\b\u0001\u0010S\u001a\u000208H\u0002J#\u0010T\u001a\u00020$2\n\b\u0001\u0010U\u001a\u0004\u0018\u0001082\b\b\u0003\u0010V\u001a\u000208H\u0002¢\u0006\u0002\u0010WJ\b\u0010X\u001a\u00020$H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006Y"}, m5598d2 = {"Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureBinding;", "getBinding", "()Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "configProvider", "Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;", "getConfigProvider$facecapture_productionRelease", "()Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;", "setConfigProvider$facecapture_productionRelease", "(Lcom/yoti/mobile/android/facecapture/view/capture/util/CaptureConfigurationProvider;)V", "lightSensor", "Lcom/yoti/mobile/android/facecapture/view/capture/util/LightSensor;", "getLightSensor$facecapture_productionRelease", "()Lcom/yoti/mobile/android/facecapture/view/capture/util/LightSensor;", "setLightSensor$facecapture_productionRelease", "(Lcom/yoti/mobile/android/facecapture/view/capture/util/LightSensor;)V", "navArguments", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragmentArgs;", "getNavArguments", "()Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureFragmentArgs;", "navArguments$delegate", "Landroidx/navigation/NavArgsLazy;", "viewModel", "Lcom/yoti/mobile/android/facecapture/view/capture/FaceCaptureViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$facecapture_productionRelease", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$facecapture_productionRelease", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "handleCaptureInProgressData", "", "data", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState$CaptureInProgress;", "handleNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/facecapture/view/navigation/CaptureNavigationEvent;", "handleViewState", "state", "Lcom/yoti/mobile/android/facecapture/view/capture/CaptureViewState;", "handleViewStateButton", "isVisible", "", "handleViewStateFlash", ViewProps.ENABLED, "handleViewStateFrame", "style", "Lcom/yoti/mobile/android/facecapture/view/capture/model/ScanFeedback$FrameType;", "handleViewStateScanFeedback", "tooltipText", "", "(Ljava/lang/Integer;)V", "onAttach", "context", "Landroid/content/Context;", "onCameraState", "cameraState", "Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;", "onFaceCaptureResult", "faceCaptureResult", "Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupWindow", "Landroid/view/Window;", "window", "showCaptureErrorFaceFrame", "Lcom/yoti/mobile/android/common/ui/widgets/VerticalScrollingGradient;", "showNoFaceFrame", "showScanningFaceFrame", "showShimmerFaceFrame", "bgColour", "highlightColour", "showStaticFaceFrame", "tintColour", "bgImage", "(Ljava/lang/Integer;I)V", "showSuccessFaceFrame", "facecapture_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class FaceCaptureFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FaceCaptureFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/facecapture/databinding/YdsFragmentFaceCaptureBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    @Inject
    public CaptureConfigurationProvider configProvider;

    @Inject
    public LightSensor lightSensor;

    /* JADX INFO: renamed from: navArguments$delegate, reason: from kotlin metadata */
    private final NavArgsLazy navArguments;
    private FaceCaptureViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScanFeedback.FrameType.values().length];
            iArr[ScanFeedback.FrameType.NONE.ordinal()] = 1;
            iArr[ScanFeedback.FrameType.DEFAULT.ordinal()] = 2;
            iArr[ScanFeedback.FrameType.CAPTURE_ERROR.ordinal()] = 3;
            iArr[ScanFeedback.FrameType.VALID_FACE_DETECTED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$onCameraState$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C48431 implements FaceCaptureListener, FunctionAdapter {
        C48431() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FaceCaptureListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, FaceCaptureFragment.this, FaceCaptureFragment.class, "onFaceCaptureResult", "onFaceCaptureResult(Lcom/yoti/mobile/android/capture/face/ui/models/face/FaceCaptureResult;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.yoti.mobile.android.capture.face.p048ui.FaceCaptureListener
        public final void onFaceCaptureResult(FaceCaptureResult p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            FaceCaptureFragment.this.onFaceCaptureResult(p0);
        }
    }

    /* JADX INFO: renamed from: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$onResume$1 */
    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    /* synthetic */ class C48441 implements CameraStateListener, FunctionAdapter {
        C48441() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof CameraStateListener) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, FaceCaptureFragment.this, FaceCaptureFragment.class, "onCameraState", "onCameraState(Lcom/yoti/mobile/android/capture/face/ui/models/camera/CameraState;)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.yoti.mobile.android.capture.face.p048ui.models.camera.CameraStateListener
        public final void onCameraState(CameraState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            FaceCaptureFragment.this.onCameraState(p0);
        }
    }

    public FaceCaptureFragment() {
        super(C4832R.layout.yds_fragment_face_capture);
        this.navArguments = new NavArgsLazy(Reflection.getOrCreateKotlinClass(FaceCaptureFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$special$$inlined$navArgs$1
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
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentFaceCaptureBinding>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentFaceCaptureBinding invoke() {
                return YdsFragmentFaceCaptureBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentFaceCaptureBinding getBinding() {
        return (YdsFragmentFaceCaptureBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FaceCaptureFragmentArgs getNavArguments() {
        return (FaceCaptureFragmentArgs) this.navArguments.getValue();
    }

    private final void handleCaptureInProgressData(CaptureViewState.CaptureInProgress data) {
        handleViewStateButton(data.isManualCapture());
        handleViewStateScanFeedback(data.getFeedback().getTooltipText());
        handleViewStateFrame(data.getFeedback().getFrameType());
        handleViewStateFlash(data.isFlashEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNavigationEvent(SingleEvent<? extends CaptureNavigationEvent> event) {
        event.getContentIfNotHandled(new Function1<CaptureNavigationEvent, Unit>() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment.handleNavigationEvent.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CaptureNavigationEvent captureNavigationEvent) {
                invoke2(captureNavigationEvent);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CaptureNavigationEvent it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof CaptureNavigationEvent.NavigateToCaptureReview) {
                    NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(FaceCaptureFragment.this), C4832R.id.action_to_captureReview, new FaceCaptureReviewFragmentArgs(((CaptureNavigationEvent.NavigateToCaptureReview) it2).getCapture()).toBundle(), null, null, 12, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewState(CaptureViewState state) {
        if (state instanceof CaptureViewState.CaptureInProgress) {
            handleCaptureInProgressData((CaptureViewState.CaptureInProgress) state);
        } else if (state instanceof CaptureViewState.CaptureSuccess) {
            handleViewStateScanFeedback(((CaptureViewState.CaptureSuccess) state).getFeedback().getTooltipText());
            showSuccessFaceFrame();
        }
    }

    private final void handleViewStateButton(boolean isVisible) {
        FloatingActionButton floatingActionButton = getBinding().manualCaptureButton;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.manualCaptureButton");
        floatingActionButton.setVisibility(isVisible ? 0 : 8);
    }

    private final void handleViewStateFlash(boolean enabled) {
        ConstraintLayout root = getBinding().getRoot();
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(500L);
        TransitionManager.beginDelayedTransition(root, autoTransition);
        getBinding().flashView.setAlpha(enabled ? 1.0f : 0.0f);
    }

    private final void handleViewStateFrame(ScanFeedback.FrameType style) {
        int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i == 1) {
            showNoFaceFrame();
            return;
        }
        if (i == 2) {
            showScanningFaceFrame();
        } else if (i == 3) {
            showCaptureErrorFaceFrame();
        } else {
            if (i != 4) {
                return;
            }
            showSuccessFaceFrame();
        }
    }

    private final void handleViewStateScanFeedback(Integer tooltipText) {
        Unit unit;
        TextView textView = getBinding().tooltip;
        if (tooltipText != null) {
            textView.setText(tooltipText.intValue());
            if (!textView.isShown()) {
                textView.setVisibility(0);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCameraState(CameraState cameraState) {
        FaceCaptureViewModel faceCaptureViewModel = null;
        if (cameraState instanceof CameraState.CameraInitializationError) {
            FaceCaptureViewModel faceCaptureViewModel2 = this.viewModel;
            if (faceCaptureViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                faceCaptureViewModel = faceCaptureViewModel2;
            }
            faceCaptureViewModel.handleViewEvent(new FaceCaptureViewEvent.OnCameraError(((CameraState.CameraInitializationError) cameraState).getCause()));
            return;
        }
        if (!(cameraState instanceof CameraState.MissingPermissions)) {
            if (cameraState instanceof CameraState.CameraReady) {
                getBinding().captureCameraView.startAnalysing(getConfigProvider$facecapture_productionRelease().createCaptureConfiguration(), new C48431());
            }
        } else {
            FaceCaptureViewModel faceCaptureViewModel3 = this.viewModel;
            if (faceCaptureViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                faceCaptureViewModel = faceCaptureViewModel3;
            }
            faceCaptureViewModel.handleViewEvent(FaceCaptureViewEvent.OnMissingPermissions.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFaceCaptureResult(FaceCaptureResult faceCaptureResult) {
        FaceCaptureViewModel faceCaptureViewModel = this.viewModel;
        if (faceCaptureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            faceCaptureViewModel = null;
        }
        faceCaptureViewModel.handleViewEvent(new FaceCaptureViewEvent.OnDetectionResult(faceCaptureResult, getLightSensor$facecapture_productionRelease().getLastLightLevel()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1, reason: not valid java name */
    public static final void m6859onViewCreated$lambda1(FaceCaptureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FaceCaptureViewModel faceCaptureViewModel = this$0.viewModel;
        if (faceCaptureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            faceCaptureViewModel = null;
        }
        faceCaptureViewModel.handleViewEvent(new FaceCaptureViewEvent.OnCapturePressed(this$0.getLightSensor$facecapture_productionRelease().getLastLightLevel()));
    }

    private final Window setupWindow(Window window) {
        if (window == null) {
            return null;
        }
        window.addFlags(128);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes.screenBrightness == 1.0f) {
            return window;
        }
        attributes.screenBrightness = 1.0f;
        window.setAttributes(attributes);
        return window;
    }

    private final VerticalScrollingGradient showCaptureErrorFaceFrame() {
        return showShimmerFaceFrame(C4832R.color.yds_theme_border_error, C4832R.color.yds_theme_border_liveness_error);
    }

    private final void showNoFaceFrame() {
        YdsFragmentFaceCaptureBinding binding = getBinding();
        binding.staticFrameBorder.setVisibility(8);
        binding.animatedFrameBorder.setVisibility(8);
    }

    private final VerticalScrollingGradient showScanningFaceFrame() {
        return showShimmerFaceFrame(C4832R.color.yds_theme_border_default, C4832R.color.yds_theme_border_liveness_default);
    }

    private final VerticalScrollingGradient showShimmerFaceFrame(int bgColour, int highlightColour) {
        YdsFragmentFaceCaptureBinding binding = getBinding();
        binding.staticFrameBorder.setVisibility(8);
        binding.animatedFrameBorder.setVisibility(0);
        binding.animatedFrameBorder.setColorFilterColor(bgColour);
        binding.animatedFrameBorder.setPorterDuffXferMode(PorterDuff.Mode.DST_ATOP);
        binding.animatedFrameBorder.setMask(C4832R.drawable.yds_face_mask_border);
        VerticalScrollingGradient verticalScrollingGradient = binding.animatedFrameGradient;
        verticalScrollingGradient.setDuration(FaceCaptureConstants.DURATION_FACE_DETECT_SHIMMER_ANIMATION_MS);
        verticalScrollingGradient.setLoopPauseDuration(750L);
        verticalScrollingGradient.setRepeatMode(1);
        verticalScrollingGradient.setGradientColors(ContextCompat.getColor(verticalScrollingGradient.getContext(), 17170445), ContextCompat.getColor(verticalScrollingGradient.getContext(), highlightColour), ContextCompat.getColor(verticalScrollingGradient.getContext(), 17170445));
        Intrinsics.checkNotNullExpressionValue(verticalScrollingGradient, "with(binding) {\n        …        )\n        }\n    }");
        return verticalScrollingGradient;
    }

    private final void showStaticFaceFrame(Integer tintColour, int bgImage) {
        YdsFragmentFaceCaptureBinding binding = getBinding();
        binding.animatedFrameBorder.setVisibility(8);
        binding.staticFrameBorder.setVisibility(0);
        binding.staticFrameBorder.setImageResource(bgImage);
        if (tintColour == null) {
            binding.staticFrameBorder.setColorFilter((ColorFilter) null);
        } else {
            binding.staticFrameBorder.setColorFilter(ContextCompat.getColor(requireContext(), tintColour.intValue()));
        }
    }

    static /* synthetic */ void showStaticFaceFrame$default(FaceCaptureFragment faceCaptureFragment, Integer num, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = C4832R.drawable.yds_face_mask_border;
        }
        faceCaptureFragment.showStaticFaceFrame(num, i);
    }

    private final void showSuccessFaceFrame() {
        showStaticFaceFrame$default(this, Integer.valueOf(C4832R.color.yds_theme_border_success), 0, 2, null);
    }

    public final CaptureConfigurationProvider getConfigProvider$facecapture_productionRelease() {
        CaptureConfigurationProvider captureConfigurationProvider = this.configProvider;
        if (captureConfigurationProvider != null) {
            return captureConfigurationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configProvider");
        return null;
    }

    public final LightSensor getLightSensor$facecapture_productionRelease() {
        LightSensor lightSensor = this.lightSensor;
        if (lightSensor != null) {
            return lightSensor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lightSensor");
        return null;
    }

    public final ViewModelProvider.Factory getViewModelFactory$facecapture_productionRelease() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FaceCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        YdsFragmentFaceCaptureBinding binding = getBinding();
        binding.captureCameraView.stopAnalysing();
        binding.animatedFrameGradient.stopAnimation();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FaceCapture faceCapture = getBinding().captureCameraView;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        faceCapture.startCamera(viewLifecycleOwner, new C48441(), getConfigProvider$facecapture_productionRelease().createCameraConfiguration());
        FaceCaptureViewModel faceCaptureViewModel = this.viewModel;
        if (faceCaptureViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            faceCaptureViewModel = null;
        }
        faceCaptureViewModel.handleViewEvent(new FaceCaptureViewEvent.OnAnalysisStarted(getNavArguments().getCaptureConfig()));
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupWindow(requireActivity().getWindow());
        getViewLifecycleOwner().getLifecycle().addObserver(getLightSensor$facecapture_productionRelease());
        YotiAppbar yotiAppbar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "binding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        FaceCaptureViewModel faceCaptureViewModel = (FaceCaptureViewModel) new ViewModelProvider(fragmentActivityRequireActivity, getViewModelFactory$facecapture_productionRelease()).get(FaceCaptureViewModel.class);
        faceCaptureViewModel.getViewState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.handleViewState((CaptureViewState) obj);
            }
        });
        faceCaptureViewModel.getNavigationEvent().observe(getViewLifecycleOwner(), new Observer() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.handleNavigationEvent((SingleEvent) obj);
            }
        });
        this.viewModel = faceCaptureViewModel;
        getBinding().manualCaptureButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.facecapture.view.capture.FaceCaptureFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FaceCaptureFragment.m6859onViewCreated$lambda1(this.f$0, view2);
            }
        });
    }

    public final void setConfigProvider$facecapture_productionRelease(CaptureConfigurationProvider captureConfigurationProvider) {
        Intrinsics.checkNotNullParameter(captureConfigurationProvider, "<set-?>");
        this.configProvider = captureConfigurationProvider;
    }

    public final void setLightSensor$facecapture_productionRelease(LightSensor lightSensor) {
        Intrinsics.checkNotNullParameter(lightSensor, "<set-?>");
        this.lightSensor = lightSensor;
    }

    public final void setViewModelFactory$facecapture_productionRelease(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
