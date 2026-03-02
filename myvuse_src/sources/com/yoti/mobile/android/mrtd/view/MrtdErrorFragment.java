package com.yoti.mobile.android.mrtd.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.MrtdCaptureSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdErrorFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "mrtdViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "navigateBack", "", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdErrorFragment extends GenericMessageFragment {
    private MrtdScanViewModel mrtdViewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        MrtdScanViewModel mrtdScanViewModel = this.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.abortScan();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        MrtdScanViewModel mrtdScanViewModel = this.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.abortScan();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MrtdCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.mrtdViewModel = (MrtdScanViewModel) new ViewModelProvider(fragmentActivityRequireActivity, getViewModelFactory()).get(MrtdScanViewModel.class);
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }
}
