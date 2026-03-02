package com.yoti.mobile.android.liveness.view.biometric_consent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.common.p049ui.widgets.YotiButton;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.WebViewFragmentArgs;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.HideButtonProgressWithDelayKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.liveness.C4871R;
import com.yoti.mobile.android.liveness.databinding.YdsFragmentBiometricConsentBinding;
import com.yoti.mobile.android.liveness.p071di.LivenessCoreSession;
import com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentViewModel;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001cH\u0016J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u000202H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00063"}, m5598d2 = {"Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentBiometricConsentBinding;", "getBinding", "()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentBiometricConsentBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "viewModel", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "configureView", "", "data", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewData;", "displayLoadingStateInCtaButton", "hideLoadingStateSoftlyInCtaButton", "navigateToEducationalScreen", "isFirstFlowScreen", "", "navigateToWebViewScreen", "url", "", "onAttach", "context", "Landroid/content/Context;", "onNavigationEventReceived", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentNavigationEvent;", "onPositiveButtonClick", "dialogTag", "onSideEffectReceived", "sideEffect", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentSideEffect;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateChanged", "state", "Lcom/yoti/mobile/android/liveness/view/biometric_consent/BiometricConsentViewModel$BiometricConsentViewState;", "showError", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "liveness-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BiometricConsentFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BiometricConsentFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/liveness/databinding/YdsFragmentBiometricConsentBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private BiometricConsentViewModel viewModel;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public BiometricConsentFragment() {
        super(C4871R.layout.yds_fragment_biometric_consent);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentBiometricConsentBinding>() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentBiometricConsentBinding invoke() {
                return YdsFragmentBiometricConsentBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final void configureView(BiometricConsentViewData data) {
        final YdsFragmentBiometricConsentBinding binding = getBinding();
        YotiAppbarTransparent appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, data.getNavigationIcon(), false, 0, 0, 0, 60, null);
        getBinding().title.setText(data.getLocKeys().getTitle());
        RecyclerView recyclerView = binding.bulletList;
        BiometricConsentViewModel biometricConsentViewModel = this.viewModel;
        if (biometricConsentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            biometricConsentViewModel = null;
        }
        BiometricConsentListAdapter biometricConsentListAdapter = new BiometricConsentListAdapter(biometricConsentViewModel);
        biometricConsentListAdapter.setListItems(data.getLocKeys().getListItems());
        recyclerView.setAdapter(biometricConsentListAdapter);
        binding.confirmConsentCheck.setChecked(false);
        binding.confirmConsentCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BiometricConsentFragment.m6865configureView$lambda8$lambda4(binding, compoundButton, z);
            }
        });
        binding.confirmConsentText.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiometricConsentFragment.m6866configureView$lambda8$lambda6(binding, view);
            }
        });
        binding.buttonAction.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.liveness.view.biometric_consent.BiometricConsentFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiometricConsentFragment.m6867configureView$lambda8$lambda7(this.f$0, view);
            }
        });
        NestedScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-4, reason: not valid java name */
    public static final void m6865configureView$lambda8$lambda4(YdsFragmentBiometricConsentBinding this_with, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.buttonAction.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-6, reason: not valid java name */
    public static final void m6866configureView$lambda8$lambda6(YdsFragmentBiometricConsentBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.confirmConsentCheck.setChecked(!r0.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: configureView$lambda-8$lambda-7, reason: not valid java name */
    public static final void m6867configureView$lambda8$lambda7(BiometricConsentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BiometricConsentViewModel biometricConsentViewModel = this$0.viewModel;
        if (biometricConsentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            biometricConsentViewModel = null;
        }
        biometricConsentViewModel.handleViewEvent(BiometricConsentViewModel.BiometricConsentViewEvent.OnBiometricConsentGiven.INSTANCE);
    }

    private final void displayLoadingStateInCtaButton() {
        YotiButton yotiButton = getBinding().buttonAction;
        yotiButton.setEnabled(false);
        yotiButton.showProgress();
    }

    private final YdsFragmentBiometricConsentBinding getBinding() {
        return (YdsFragmentBiometricConsentBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final void hideLoadingStateSoftlyInCtaButton() {
        YotiButton yotiButton = getBinding().buttonAction;
        yotiButton.setEnabled(true);
        Intrinsics.checkNotNullExpressionValue(yotiButton, "");
        HideButtonProgressWithDelayKt.hideProgressWithDelay(yotiButton);
    }

    private final void navigateToEducationalScreen(boolean isFirstFlowScreen) {
        if (isFirstFlowScreen) {
            NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(this), C4871R.id.action_educational_as_start_destination, null, null, null, 14, null);
        } else {
            NavigationKt.navigateSafe$default(androidx.navigation.fragment.FragmentKt.findNavController(this), C4871R.id.action_to_livenessEducationalFragment, null, null, null, 14, null);
        }
    }

    private final void navigateToWebViewScreen(String url) {
        NavigationKt.navigateSafeToNavGraph(androidx.navigation.fragment.FragmentKt.findNavController(this), C4871R.navigation.yds_webview_nav_graph, new WebViewFragmentArgs(url).toBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationEventReceived(BiometricConsentViewModel.BiometricConsentNavigationEvent event) {
        if (event instanceof BiometricConsentViewModel.BiometricConsentNavigationEvent.NavigateToWebViewScreen) {
            navigateToWebViewScreen(((BiometricConsentViewModel.BiometricConsentNavigationEvent.NavigateToWebViewScreen) event).getUrl());
        } else if (event instanceof BiometricConsentViewModel.BiometricConsentNavigationEvent.NavigateToEducational) {
            navigateToEducationalScreen(((BiometricConsentViewModel.BiometricConsentNavigationEvent.NavigateToEducational) event).isFirstFlowScreen());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSideEffectReceived(BiometricConsentViewModel.BiometricConsentSideEffect sideEffect) {
        if (Intrinsics.areEqual(sideEffect, BiometricConsentViewModel.BiometricConsentSideEffect.BiometricConsentRequestInProgress.INSTANCE)) {
            displayLoadingStateInCtaButton();
        } else if (Intrinsics.areEqual(sideEffect, BiometricConsentViewModel.BiometricConsentSideEffect.BiometricConsentRequestSuccess.INSTANCE)) {
            hideLoadingStateSoftlyInCtaButton();
        } else if (sideEffect instanceof BiometricConsentViewModel.BiometricConsentSideEffect.BiometricConsentRequestFailure) {
            showError(((BiometricConsentViewModel.BiometricConsentSideEffect.BiometricConsentRequestFailure) sideEffect).getFailure());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onViewStateChanged(BiometricConsentViewModel.BiometricConsentViewState state) {
        if (state instanceof BiometricConsentViewModel.BiometricConsentViewState.ViewConfiguration) {
            configureView(((BiometricConsentViewModel.BiometricConsentViewState.ViewConfiguration) state).getData());
        }
    }

    private final void showError(YdsFailure failure) {
        showFailure(failure, "GIVE_CONSENT_ERROR_DIALOG_TAG");
        YotiButton yotiButton = getBinding().buttonAction;
        yotiButton.setEnabled(true);
        yotiButton.hideProgress();
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
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (Intrinsics.areEqual(dialogTag, "GIVE_CONSENT_ERROR_DIALOG_TAG")) {
            BiometricConsentViewModel biometricConsentViewModel = this.viewModel;
            if (biometricConsentViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                biometricConsentViewModel = null;
            }
            biometricConsentViewModel.handleViewEvent(BiometricConsentViewModel.BiometricConsentViewEvent.OnBiometricConsentGiven.INSTANCE);
        }
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        getBinding();
        super.onViewCreated(view, savedInstanceState);
        BiometricConsentViewModel biometricConsentViewModel = (BiometricConsentViewModel) new ViewModelProvider(this, getViewModelFactory()).get(BiometricConsentViewModel.class);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, biometricConsentViewModel.getViewState(), new BiometricConsentFragment$onViewCreated$1$1$1(this));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner2, biometricConsentViewModel.getSideEffect(), new BiometricConsentFragment$onViewCreated$1$1$2(this));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner3, biometricConsentViewModel.getNavigationEvent(), new BiometricConsentFragment$onViewCreated$1$1$3(this));
        this.viewModel = biometricConsentViewModel;
    }

    public final void setViewModelFactory(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
