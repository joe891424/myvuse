package com.yoti.mobile.android.mrtd.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdCaptureSession;
import com.yoti.mobile.android.mrtd.databinding.YdsDialogNfcReadBinding;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u001a\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010 \u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdReadFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogNfcReadBinding;", "getBinding", "()Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogNfcReadBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "mrtdViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onViewCreated", "view", "updateReadStatus", "screen", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdReadFragment extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MrtdReadFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/mrtd/databinding/YdsDialogNfcReadBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding = FragmentKt.viewBindingLazy(this, new Function0<YdsDialogNfcReadBinding>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdReadFragment$binding$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final YdsDialogNfcReadBinding invoke() {
            return YdsDialogNfcReadBinding.bind(this.this$0.requireView());
        }
    });
    private MrtdScanViewModel mrtdViewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MrtdScreen.values().length];
            iArr[MrtdScreen.SCAN_START.ordinal()] = 1;
            iArr[MrtdScreen.SCAN_PROGRESS.ordinal()] = 2;
            iArr[MrtdScreen.SCAN_COMPLETE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final YdsDialogNfcReadBinding getBinding() {
        return (YdsDialogNfcReadBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-2$lambda-1, reason: not valid java name */
    public static final void m6893onViewCreated$lambda2$lambda1(MrtdReadFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReadStatus(SingleEvent<? extends MrtdScreen> screen) {
        LottieAnimationView lottieAnimationView;
        String str;
        YdsDialogNfcReadBinding binding = getBinding();
        int i = WhenMappings.$EnumSwitchMapping$0[screen.peekContent().ordinal()];
        if (i == 1) {
            binding.titleView.setText(C4900R.string.ios_android_yds_nfc_sheet_header_ready);
            binding.descriptionView.setText(C4900R.string.ios_android_yds_nfc_sheet_description_ready);
            lottieAnimationView = binding.readAnimation;
            str = "lottie/phone_loop.json";
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                binding.titleView.setText(C4900R.string.ios_android_yds_nfc_sheet_header_scan_complete);
                binding.descriptionView.setText(C4900R.string.ios_android_yds_nfc_sheet_description_scan_complete);
                binding.readAnimation.setAnimation("lottie/nfc_success.json");
                binding.readAnimation.setRepeatCount(0);
                binding.readAnimation.playAnimation();
                requireDialog().setCancelable(false);
                binding.cancelReadButton.setVisibility(4);
                return;
            }
            binding.titleView.setText(C4900R.string.android_yds_nfc_sheet_header_scanning);
            binding.descriptionView.setText(C4900R.string.ios_android_yds_nfc_sheet_description_scanning);
            lottieAnimationView = binding.readAnimation;
            str = "lottie/nfc_loop.json";
        }
        lottieAnimationView.setAnimation(str);
        binding.readAnimation.playAnimation();
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MrtdCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
        setStyle(0, C4900R.style.Yds_BottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C4900R.layout.yds_dialog_nfc_read, container, false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MrtdScanViewModel mrtdScanViewModel = this.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.cancelScan();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsDialogNfcReadBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        MrtdScanViewModel mrtdScanViewModel = (MrtdScanViewModel) new ViewModelProvider(fragmentActivityRequireActivity, getViewModelFactory()).get(MrtdScanViewModel.class);
        LifecycleKt.observe(this, mrtdScanViewModel.getCurrentScreen(), new MrtdReadFragment$onViewCreated$1$1$1(this));
        this.mrtdViewModel = mrtdScanViewModel;
        requireDialog().setCanceledOnTouchOutside(false);
        binding.cancelReadButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.mrtd.view.MrtdReadFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MrtdReadFragment.m6893onViewCreated$lambda2$lambda1(this.f$0, view2);
            }
        });
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }
}
