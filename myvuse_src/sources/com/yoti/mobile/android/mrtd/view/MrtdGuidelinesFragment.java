package com.yoti.mobile.android.mrtd.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.ViewModelFactory;
import com.yoti.mobile.android.mrtd.C4900R;
import com.yoti.mobile.android.mrtd.MrtdCaptureSession;
import com.yoti.mobile.android.mrtd.databinding.YdsFragmentMrtdGuidelinesBinding;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, m5598d2 = {"Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentMrtdGuidelinesBinding;", "getBinding", "()Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentMrtdGuidelinesBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "mrtdViewModel", "Lcom/yoti/mobile/android/mrtd/view/MrtdScanViewModel;", "navArguments", "Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragmentArgs;", "getNavArguments", "()Lcom/yoti/mobile/android/mrtd/view/MrtdGuidelinesFragmentArgs;", "navArguments$delegate", "Landroidx/navigation/NavArgsLazy;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/ViewModelFactory;)V", "navigateBack", "", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "mrtd_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class MrtdGuidelinesFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MrtdGuidelinesFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/mrtd/databinding/YdsFragmentMrtdGuidelinesBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private MrtdScanViewModel mrtdViewModel;

    /* JADX INFO: renamed from: navArguments$delegate, reason: from kotlin metadata */
    private final NavArgsLazy navArguments;

    @Inject
    public ViewModelFactory viewModelFactory;

    public MrtdGuidelinesFragment() {
        super(C4900R.layout.yds_fragment_mrtd_guidelines);
        this.navArguments = new NavArgsLazy(Reflection.getOrCreateKotlinClass(MrtdGuidelinesFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment$special$$inlined$navArgs$1
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
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentMrtdGuidelinesBinding>() { // from class: com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentMrtdGuidelinesBinding invoke() {
                return YdsFragmentMrtdGuidelinesBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentMrtdGuidelinesBinding getBinding() {
        return (YdsFragmentMrtdGuidelinesBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final MrtdGuidelinesFragmentArgs getNavArguments() {
        return (MrtdGuidelinesFragmentArgs) this.navArguments.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-2$lambda-1, reason: not valid java name */
    public static final void m6892onViewCreated$lambda2$lambda1(MrtdGuidelinesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MrtdScanViewModel mrtdScanViewModel = this$0.mrtdViewModel;
        if (mrtdScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mrtdViewModel");
            mrtdScanViewModel = null;
        }
        mrtdScanViewModel.retryScan();
    }

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
        mrtdScanViewModel.retryScan();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MrtdCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentMrtdGuidelinesBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.mrtdViewModel = (MrtdScanViewModel) new ViewModelProvider(fragmentActivityRequireActivity, getViewModelFactory()).get(MrtdScanViewModel.class);
        YotiAppbar appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.CLOSE_BLUE, false, 0, 0, 0, 60, null);
        binding.textViewNfcGuidelinesTitle.setText(getNavArguments().getTitleResId());
        binding.buttonNfcGuidelinesPrimary.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.mrtd.view.MrtdGuidelinesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MrtdGuidelinesFragment.m6892onViewCreated$lambda2$lambda1(this.f$0, view2);
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
