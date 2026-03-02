package com.yoti.mobile.android.liveness.view.upload;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.p071di.module.ForLivenessUpload;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigator;
import com.yoti.mobile.android.liveness.view.navigation.ILivenessUploadNavigatorProvider;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006."}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFragment;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadFragment;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadViewModel;", "()V", "fragmentArgs", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "uploadInProgressTitle", "", "getUploadInProgressTitle", "()Ljava/lang/String;", "uploadNavigator", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigator;", "uploadNavigatorProvider", "Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "getUploadNavigatorProvider", "()Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;", "setUploadNavigatorProvider", "(Lcom/yoti/mobile/android/liveness/view/navigation/ILivenessUploadNavigatorProvider;)V", "uploadSuccessTitle", "getUploadSuccessTitle", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "createViewModel", "displayUploadFailureState", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "initialiseUploadProcess", "navigateToPreviousScreen", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LivenessUploadFragment extends UploadFragment<LivenessUploadViewModel> {

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(LivenessUploadFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.liveness.view.upload.LivenessUploadFragment$special$$inlined$navArgs$1
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
    private ILivenessUploadNavigator uploadNavigator;

    @Inject
    public ILivenessUploadNavigatorProvider uploadNavigatorProvider;

    @Inject
    public SavedStateViewModelFactory<LivenessUploadViewModel> viewModelFactory;

    /* JADX WARN: Multi-variable type inference failed */
    private final LivenessUploadFragmentArgs getFragmentArgs() {
        return (LivenessUploadFragmentArgs) this.fragmentArgs.getValue();
    }

    @ForLivenessUpload
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void displayUploadFailureState(YdsFailure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        ILivenessUploadNavigator iLivenessUploadNavigator = this.uploadNavigator;
        if (iLivenessUploadNavigator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadNavigator");
            iLivenessUploadNavigator = null;
        }
        if (iLivenessUploadNavigator.navigateToUploadError(failure)) {
            return;
        }
        super.displayUploadFailureState(failure);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public String getUploadInProgressTitle() {
        String string = getString(C4871R.string.yds_liveness_uploading_header);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.yds_liveness_uploading_header)");
        return string;
    }

    public final ILivenessUploadNavigatorProvider getUploadNavigatorProvider() {
        ILivenessUploadNavigatorProvider iLivenessUploadNavigatorProvider = this.uploadNavigatorProvider;
        if (iLivenessUploadNavigatorProvider != null) {
            return iLivenessUploadNavigatorProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadNavigatorProvider");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public String getUploadSuccessTitle() {
        String string = getString(C4871R.string.ios_android_yds_liveness_completion_header);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ios_a…veness_completion_header)");
        return string;
    }

    public final SavedStateViewModelFactory<LivenessUploadViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<LivenessUploadViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void initialiseUploadProcess() {
        getUploadViewModel().upload(getFragmentArgs().getLivenessCapture());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void navigateToPreviousScreen() {
        ILivenessUploadNavigator iLivenessUploadNavigator = this.uploadNavigator;
        if (iLivenessUploadNavigator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadNavigator");
            iLivenessUploadNavigator = null;
        }
        iLivenessUploadNavigator.navigateBack();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LivenessCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.uploadNavigator = getUploadNavigatorProvider().getNavigator(FragmentKt.findNavController(this));
    }

    public final void setUploadNavigatorProvider(ILivenessUploadNavigatorProvider iLivenessUploadNavigatorProvider) {
        Intrinsics.checkNotNullParameter(iLivenessUploadNavigatorProvider, "<set-?>");
        this.uploadNavigatorProvider = iLivenessUploadNavigatorProvider;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<LivenessUploadViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public LivenessUploadViewModel createViewModel() {
        return (LivenessUploadViewModel) getViewModelFactory().create(this);
    }
}
