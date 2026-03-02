package com.yoti.mobile.android.documentcapture.sup.view.scan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.fragment.app.FragmentActivity;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbarTransparent;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.ShadowedScrollViewMediator;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.databinding.YdsFragmentSupDocumentGuidelinesBinding;
import com.yoti.mobile.android.documentcapture.sup.p057di.ForDocumentScan;
import com.yoti.mobile.android.documentcapture.sup.p057di.SupDocumentCaptureSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/DocumentGuidelinesFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentGuidelinesBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentGuidelinesBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentGuidelinesFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DocumentGuidelinesFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/sup/databinding/YdsFragmentSupDocumentGuidelinesBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;
    private SupDocumentScanViewModel viewModel;

    @Inject
    public SavedStateViewModelFactory<SupDocumentScanViewModel> viewModelFactory;

    public DocumentGuidelinesFragment() {
        super(C4653R.layout.yds_fragment_sup_document_guidelines);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentSupDocumentGuidelinesBinding>() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.DocumentGuidelinesFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentSupDocumentGuidelinesBinding invoke() {
                return YdsFragmentSupDocumentGuidelinesBinding.bind(this.this$0.requireView());
            }
        });
    }

    private final YdsFragmentSupDocumentGuidelinesBinding getBinding() {
        return (YdsFragmentSupDocumentGuidelinesBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @ForDocumentScan
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1$lambda-0, reason: not valid java name */
    public static final void m6833onViewCreated$lambda1$lambda0(DocumentGuidelinesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SupDocumentScanViewModel supDocumentScanViewModel = this$0.viewModel;
        if (supDocumentScanViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            supDocumentScanViewModel = null;
        }
        supDocumentScanViewModel.start();
    }

    public final SavedStateViewModelFactory<SupDocumentScanViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SupDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        YdsFragmentSupDocumentGuidelinesBinding binding = getBinding();
        super.onViewCreated(view, savedInstanceState);
        YotiAppbarTransparent appBar = binding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        BaseFragment.configureAppBar$default(this, appBar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        SavedStateViewModelFactory<SupDocumentScanViewModel> viewModelFactory = getViewModelFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        this.viewModel = (SupDocumentScanViewModel) viewModelFactory.create(fragmentActivityRequireActivity);
        binding.gotItButton.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.sup.view.scan.DocumentGuidelinesFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DocumentGuidelinesFragment.m6833onViewCreated$lambda1$lambda0(this.f$0, view2);
            }
        });
        ScrollView scrollView = binding.scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "scrollView");
        View shadow = binding.shadow;
        Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
        new ShadowedScrollViewMediator(scrollView, shadow).attach();
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<SupDocumentScanViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
