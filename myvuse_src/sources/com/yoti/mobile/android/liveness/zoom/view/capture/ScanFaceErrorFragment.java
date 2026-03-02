package com.yoti.mobile.android.liveness.zoom.view.capture;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.common.p049ui.widgets.CommonYotiAppBar;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.liveness.view.educational.LivenessEducationalGuidelineFragmentArgs;
import com.yoti.mobile.android.liveness.view.educational.LivenessGuidelinesViewData;
import com.yoti.mobile.android.liveness.view.upload.LivenessUploadFailureType;
import com.yoti.mobile.android.liveness.zoom.C4888R;
import com.yoti.mobile.android.liveness.zoom.p072di.LivenessFaceTecSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R)\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/zoom/view/capture/ScanFaceErrorFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "guidelinesViewDataFactory", "Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "Lcom/yoti/mobile/android/liveness/view/upload/LivenessUploadFailureType;", "Lkotlin/jvm/JvmSuppressWildcards;", "getGuidelinesViewDataFactory", "()Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;", "setGuidelinesViewDataFactory", "(Lcom/yoti/mobile/android/liveness/view/educational/LivenessGuidelinesViewData$Factory;)V", "navigateBack", "", "navigateToGuidelines", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "liveness-zoom_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScanFaceErrorFragment extends GenericMessageFragment {

    @Inject
    public LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> guidelinesViewDataFactory;

    private final void navigateToGuidelines() {
        NavigationKt.navigateSafe$default(FragmentKt.findNavController(this), C4888R.id.action_scanError_to_livenessEducationalGuidelineFragment, new LivenessEducationalGuidelineFragmentArgs(LivenessGuidelinesViewData.Factory.DefaultImpls.create$default(getGuidelinesViewDataFactory(), null, 1, null)).toBundle(), null, null, 12, null);
    }

    public final LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> getGuidelinesViewDataFactory() {
        LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory = this.guidelinesViewDataFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guidelinesViewDataFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        super.navigateBack();
        navigateToGuidelines();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        super.onActionButtonClicked();
        navigateToGuidelines();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LivenessFaceTecSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(C4888R.id.appBar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.appBar)");
        BaseFragment.configureAppBar$default(this, (CommonYotiAppBar) viewFindViewById, NavigationIcon.NONE, false, 0, 0, 0, 60, null);
    }

    public final void setGuidelinesViewDataFactory(LivenessGuidelinesViewData.Factory<LivenessUploadFailureType> factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.guidelinesViewDataFactory = factory;
    }
}
