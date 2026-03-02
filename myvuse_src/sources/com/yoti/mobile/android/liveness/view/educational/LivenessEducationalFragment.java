package com.yoti.mobile.android.liveness.view.educational;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.MediaResource;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.databinding.YdsFragmentLivenessEducationalBinding;
import com.yoti.mobile.android.liveness.domain.model.ILivenessResourceEntity;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalViewModel;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigator;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessEducationalNavigatorProvider;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import okhttp3.internal.p103ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0016J+\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u000200052\u0006\u00106\u001a\u000207H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\u001fH\u0016J\b\u0010:\u001a\u00020\u001fH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\u001a\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\b\u0001\u0010G\u001a\u00020\u0004H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002J\u0012\u0010L\u001a\u00020M2\b\b\u0001\u0010N\u001a\u00020\u0004H\u0002J\u0010\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006S"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "CAMERA_PERMISSIONS_REQUEST", "", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalBinding;", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "isMusicPlaying", "", "navigator", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigator;", "Lcom/yoti/mobile/android/liveness/domain/model/ILivenessResourceEntity;", "navigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "getNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;", "setNavigatorProvider", "(Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessEducationalNavigatorProvider;)V", "viewModel", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "configureView", "", "viewConfiguration", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState$ViewConfiguration;", "displayCameraPermissionDeniedScreen", "hideEducationalMediaFrame", "hideProgress", "isCameraPermissionGranted", "onAttach", "context", "Landroid/content/Context;", "onCameraPermissionRequestResultChanged", "granted", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalNavigationEvent;", "onNegativeButtonClick", "dialogTag", "", "onPositiveButtonClick", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "state", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessEducationalViewModel$EducationalViewState;", "requestCameraPermissions", "restartMusic", "showEducationalImage", "imageResId", "showEducationalMedia", "", "educationalMedia", "Lcom/yoti/mobile/android/commonui/MediaResource;", "showEducationalVideo", "Landroid/widget/VideoView;", "mediaResource", "showErrorState", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "showProgress", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessEducationalFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LivenessEducationalFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentLivenessEducationalBinding;", 0))};
    private final int CAMERA_PERMISSIONS_REQUEST;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private boolean isMusicPlaying;
    private ILivenessEducationalNavigator<ILivenessResourceEntity> navigator;

    @Inject
    public ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> navigatorProvider;
    private LivenessEducationalViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaResource.MediaType.values().length];
            iArr[MediaResource.MediaType.VIDEO.ordinal()] = 1;
            iArr[MediaResource.MediaType.IMAGE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LivenessEducationalFragment() {
        super(C4871R.layout.yds_fragment_liveness_educational);
        this.CAMERA_PERMISSIONS_REQUEST = 1;
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentLivenessEducationalBinding>() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentLivenessEducationalBinding invoke() {
                return YdsFragmentLivenessEducationalBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final void configureView(LivenessEducationalViewModel.EducationalViewState.ViewConfiguration viewConfiguration) {
        YdsFragmentLivenessEducationalBinding binding = getBinding();
        ILivenessEducationalViewConfiguration viewConfig = viewConfiguration.getViewConfig();
        YotiAppbarTransparent appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, viewConfig.getNavigationIcon(), false, 0, 0, 0, 60, null);
        MediaResource media = viewConfig.getMedia();
        if (media == null || showEducationalMedia(media) == null) {
            hideEducationalMediaFrame();
        }
        binding.textViewLivenessEducationalTitle.setText(viewConfig.getTitle());
        binding.textViewLivenessEducationalMessage.setText(viewConfig.getText());
        YotiButton yotiButton = binding.guidelines;
        if (viewConfig.isGuidelinesLinkVisible()) {
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            yotiButton.setVisibility(0);
            yotiButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LivenessEducationalFragment.m6870configureView$lambda8$lambda5$lambda2$lambda1(this.f$0, view);
                }
            });
        } else {
            Intrinsics.checkNotNullExpressionValue(yotiButton, "");
            yotiButton.setVisibility(8);
        }
        YotiButton yotiButton2 = binding.buttonStartScan;
        yotiButton2.setText(viewConfig.getPrimaryCtaText());
        yotiButton2.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivenessEducationalFragment.m6871configureView$lambda8$lambda5$lambda4$lambda3(this.f$0, view);
            }
        });
        binding.textViewLivenessEducationGuidelineTitle.setText(viewConfig.getGuidelinesTitle());
        YotiButton yotiButton3 = binding.buttonLivenessEducationalMoreAbout;
        yotiButton3.setVisibility(viewConfiguration.isMoreAboutVerificationAvailable() ? 0 : 8);
        yotiButton3.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivenessEducationalFragment.m6872configureView$lambda8$lambda7$lambda6(this.f$0, view);
            }
        });
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-5$lambda-2$lambda-1, reason: not valid java name */
    public static final void m6870configureView$lambda8$lambda5$lambda2$lambda1(LivenessEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LivenessEducationalViewModel livenessEducationalViewModel = this$0.viewModel;
        if (livenessEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessEducationalViewModel = null;
        }
        livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnGuidelinesClick.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-5$lambda-4$lambda-3, reason: not valid java name */
    public static final void m6871configureView$lambda8$lambda5$lambda4$lambda3(LivenessEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isCameraPermissionGranted()) {
            this$0.requestCameraPermissions();
            return;
        }
        LivenessEducationalViewModel livenessEducationalViewModel = this$0.viewModel;
        if (livenessEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessEducationalViewModel = null;
        }
        livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnStartScan.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-7$lambda-6, reason: not valid java name */
    public static final void m6872configureView$lambda8$lambda7$lambda6(LivenessEducationalFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LivenessEducationalViewModel livenessEducationalViewModel = this$0.viewModel;
        if (livenessEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessEducationalViewModel = null;
        }
        livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnMoreAboutVerificationClick.INSTANCE);
    }

    private final void displayCameraPermissionDeniedScreen() {
        NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(this), C4871R.id.action_to_cameraPermissionDeniedFragment, new GenericMessageFragmentArgs(C4871R.drawable.yds_ic_camera_access, C4871R.string.yds_camera_permission_denied_header, null, C4871R.string.ios_android_yds_camera_permission_denied_description, null, C4871R.string.ios_android_yds_camera_permission_denied_primary_cta, null, C4871R.drawable.chevron_right_white, 0, null, 0, null, 3924, null).toBundle(), null, null, 12, null);
    }

    private final YdsFragmentLivenessEducationalBinding getBinding() {
        return (YdsFragmentLivenessEducationalBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final void hideEducationalMediaFrame() {
        getBinding().videoCardView.setVisibility(8);
    }

    private final void hideProgress() {
        getBinding().buttonStartScan.hideProgress();
    }

    private final boolean isCameraPermissionGranted() {
        return ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0;
    }

    private final void onCameraPermissionRequestResultChanged(boolean granted) {
        if (!granted && !shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            displayCameraPermissionDeniedScreen();
            return;
        }
        if (granted) {
            LivenessEducationalViewModel livenessEducationalViewModel = this.viewModel;
            if (livenessEducationalViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                livenessEducationalViewModel = null;
            }
            livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnStartScan.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEvent(LivenessEducationalViewModel.EducationalNavigationEvent event) {
        ILivenessEducationalNavigator<ILivenessResourceEntity> iLivenessEducationalNavigator = null;
        if (event instanceof LivenessEducationalViewModel.EducationalNavigationEvent.NavigateToMoreAboutVerification) {
            ILivenessEducationalNavigator<ILivenessResourceEntity> iLivenessEducationalNavigator2 = this.navigator;
            if (iLivenessEducationalNavigator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigator");
            } else {
                iLivenessEducationalNavigator = iLivenessEducationalNavigator2;
            }
            iLivenessEducationalNavigator.navigateToMoreAbout(((LivenessEducationalViewModel.EducationalNavigationEvent.NavigateToMoreAboutVerification) event).getFeatureConfiguration());
            return;
        }
        if (event instanceof LivenessEducationalViewModel.EducationalNavigationEvent.NavigateToGuidelines) {
            ILivenessEducationalNavigator<ILivenessResourceEntity> iLivenessEducationalNavigator3 = this.navigator;
            if (iLivenessEducationalNavigator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigator");
            } else {
                iLivenessEducationalNavigator = iLivenessEducationalNavigator3;
            }
            iLivenessEducationalNavigator.navigateToGuidelines();
            return;
        }
        if (event instanceof LivenessEducationalViewModel.EducationalNavigationEvent.NavigateToLivenessCapture) {
            ILivenessEducationalNavigator<ILivenessResourceEntity> iLivenessEducationalNavigator4 = this.navigator;
            if (iLivenessEducationalNavigator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigator");
            } else {
                iLivenessEducationalNavigator = iLivenessEducationalNavigator4;
            }
            iLivenessEducationalNavigator.navigateToLivenessCapture(((LivenessEducationalViewModel.EducationalNavigationEvent.NavigateToLivenessCapture) event).getLivenessResource());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewStateChanged(LivenessEducationalViewModel.EducationalViewState state) {
        if (state instanceof LivenessEducationalViewModel.EducationalViewState.ViewConfiguration) {
            configureView((LivenessEducationalViewModel.EducationalViewState.ViewConfiguration) state);
            return;
        }
        if (state instanceof LivenessEducationalViewModel.EducationalViewState.CameraPermissionsGranted) {
            onCameraPermissionRequestResultChanged(true);
            return;
        }
        if (state instanceof LivenessEducationalViewModel.EducationalViewState.CameraPermissionsDenied) {
            onCameraPermissionRequestResultChanged(false);
        } else if (state instanceof LivenessEducationalViewModel.EducationalViewState.ResourceIdRequestInProgress) {
            showProgress();
        } else if (state instanceof LivenessEducationalViewModel.EducationalViewState.ResourceIdRequestFailure) {
            showErrorState(((LivenessEducationalViewModel.EducationalViewState.ResourceIdRequestFailure) state).getFailure());
        }
    }

    private final void requestCameraPermissions() {
        requestPermissions(new String[]{"android.permission.CAMERA"}, this.CAMERA_PERMISSIONS_REQUEST);
    }

    private final void restartMusic() {
        AudioManager audioManager;
        if (!this.isMusicPlaying || (audioManager = (AudioManager) requireActivity().getSystemService("audio")) == null) {
            return;
        }
        audioManager.dispatchMediaKeyEvent(new KeyEvent(0, WebSocketProtocol.PAYLOAD_SHORT));
    }

    private final void showEducationalImage(int imageResId) {
        YdsFragmentLivenessEducationalBinding binding = getBinding();
        binding.videoCardView.setVisibility(8);
        binding.imageView.setVisibility(0);
        binding.imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), imageResId));
    }

    private final Object showEducationalMedia(MediaResource educationalMedia) {
        int i = WhenMappings.$EnumSwitchMapping$0[educationalMedia.getMediaType().ordinal()];
        if (i == 1) {
            return showEducationalVideo(educationalMedia.getMediaResId());
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        showEducationalImage(educationalMedia.getMediaResId());
        return Unit.INSTANCE;
    }

    private final VideoView showEducationalVideo(int mediaResource) {
        YdsFragmentLivenessEducationalBinding binding = getBinding();
        binding.videoCardView.setVisibility(0);
        binding.imageView.setVisibility(8);
        AudioManager audioManager = (AudioManager) requireActivity().getSystemService("audio");
        if (audioManager != null) {
            this.isMusicPlaying = audioManager.isMusicActive();
        }
        VideoView videoView = binding.videoView;
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.yoti.mobile.android.liveness.view.educational.LivenessEducationalFragment$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView.setVideoURI(Uri.parse("android.resource://" + requireActivity().getPackageName() + '/' + mediaResource));
        videoView.start();
        Intrinsics.checkNotNullExpressionValue(videoView, "with(binding) {\n        …  start()\n        }\n    }");
        return videoView;
    }

    private final void showErrorState(YdsFailure failure) {
        hideProgress();
        showFailure(failure, "RESOURCE_CREATION_ERROR_DIALOG_TAG");
    }

    private final void showProgress() {
        getBinding().buttonStartScan.showProgress();
    }

    public final ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> getNavigatorProvider() {
        ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> iLivenessEducationalNavigatorProvider = this.navigatorProvider;
        if (iLivenessEducationalNavigatorProvider != null) {
            return iLivenessEducationalNavigatorProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigatorProvider");
        return null;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
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
        LivenessCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onNegativeButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "RESOURCE_CREATION_ERROR_DIALOG_TAG")) {
            cancelFlow();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "RESOURCE_CREATION_ERROR_DIALOG_TAG")) {
            LivenessEducationalViewModel livenessEducationalViewModel = this.viewModel;
            if (livenessEducationalViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                livenessEducationalViewModel = null;
            }
            livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnStartScan.INSTANCE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == this.CAMERA_PERMISSIONS_REQUEST) {
            LivenessEducationalViewModel livenessEducationalViewModel = null;
            if ((grantResults.length == 0) || grantResults[0] != 0) {
                LivenessEducationalViewModel livenessEducationalViewModel2 = this.viewModel;
                if (livenessEducationalViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    livenessEducationalViewModel = livenessEducationalViewModel2;
                }
                livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnCameraPermissionsDenied.INSTANCE);
                return;
            }
            LivenessEducationalViewModel livenessEducationalViewModel3 = this.viewModel;
            if (livenessEducationalViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                livenessEducationalViewModel = livenessEducationalViewModel3;
            }
            livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnCameraPermissionsGranted.INSTANCE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CardView cardView = getBinding().videoCardView;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.videoCardView");
        if (cardView.getVisibility() == 0) {
            getBinding().videoView.start();
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LivenessEducationalViewModel livenessEducationalViewModel = this.viewModel;
        if (livenessEducationalViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            livenessEducationalViewModel = null;
        }
        livenessEducationalViewModel.handleViewEvent(LivenessEducationalViewModel.LivenessEducationalViewEvent.OnViewShown.INSTANCE);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        restartMusic();
        super.onStop();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.navigator = getNavigatorProvider().getNavigator(androidx.navigation.fragment.FragmentKt.findNavController(this));
        LivenessEducationalViewModel livenessEducationalViewModel = (LivenessEducationalViewModel) new ViewModelProvider(this, getViewModelFactory()).get(LivenessEducationalViewModel.class);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, livenessEducationalViewModel.getViewState(), new LivenessEducationalFragment$onViewCreated$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, livenessEducationalViewModel.getNavigationEvent(), new LivenessEducationalFragment$onViewCreated$1$2(this));
        this.viewModel = livenessEducationalViewModel;
    }

    public final void setNavigatorProvider(ILivenessEducationalNavigatorProvider<ILivenessResourceEntity> iLivenessEducationalNavigatorProvider) {
        Intrinsics.checkNotNullParameter(iLivenessEducationalNavigatorProvider, "<set-?>");
        this.navigatorProvider = iLivenessEducationalNavigatorProvider;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
