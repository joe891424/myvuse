package com.yoti.mobile.android.mrtd.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdCaptureSession;
import com.yoti.mobile.android.mrtd.databinding.YdsFragmentEducationBinding;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdScanFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentEducationBinding;", "getBinding", "()Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentEducationBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "mrtdViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "onAttach", "", "context", "Landroid/content/Context;", "onPause", "onResume", "onScreenChanged", "newScreen", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/mrtd/view/MrtdScreen;", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdScanFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MrtdScanFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentEducationBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private MrtdScanViewModel mrtdViewModel;

    @Inject
    public ViewModelFactory viewModelFactory;

    public MrtdScanFragment() {
        super(C4900R.layout.yds_fragment_education);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentEducationBinding>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdScanFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentEducationBinding invoke() {
                return YdsFragmentEducationBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentEducationBinding getBinding() {
        return (YdsFragmentEducationBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScreenChanged(SingleEvent<? extends MrtdScreen> newScreen) {
        if (newScreen.peekContent() == MrtdScreen.EDUCATION) {
            getBinding().nfcEducationVideo.start();
        } else {
            getBinding().nfcEducationVideo.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-2, reason: not valid java name */
    public static final boolean m6897onViewCreated$lambda4$lambda2(MediaPlayer mediaPlayer, int i, int i2) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-3, reason: not valid java name */
    public static final void m6898onViewCreated$lambda4$lambda3(MrtdScanFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MrtdScanViewModel mrtdScanViewModel = this$0.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.startScan();
    }

    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MrtdCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        getBinding().nfcEducationVideo.pause();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().nfcEducationVideo.start();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getBinding().nfcEducationVideo.resume();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        getBinding().nfcEducationVideo.stopPlayback();
        super.onStop();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentEducationBinding binding = getBinding();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        MrtdScanViewModel mrtdScanViewModel = (MrtdScanViewModel) new ViewModelProvider(fragmentActivityRequireActivity, getViewModelFactory()).get(MrtdScanViewModel.class);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, mrtdScanViewModel.getCurrentScreen(), new MrtdScanFragment$onViewCreated$1$1$1(this));
        this.mrtdViewModel = mrtdScanViewModel;
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        binding.nfcEducationVideo.setVideoPath("android.resource://" + requireContext().getPackageName() + '/' + C4900R.raw.yds_nfc_educational);
        binding.nfcEducationVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.yoti.mobile.android.mrtd.view.MrtdScanFragment$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        binding.nfcEducationVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.yoti.mobile.android.mrtd.view.MrtdScanFragment$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return MrtdScanFragment.m6897onViewCreated$lambda4$lambda2(mediaPlayer, i, i2);
            }
        });
        binding.nfcStartButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.mrtd.view.MrtdScanFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MrtdScanFragment.m6898onViewCreated$lambda4$lambda3(this.f$0, view2);
            }
        });
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "<set-?>");
        this.viewModelFactory = viewModelFactory;
    }
}
