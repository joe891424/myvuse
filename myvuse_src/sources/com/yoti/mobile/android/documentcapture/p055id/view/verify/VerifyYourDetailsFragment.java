package com.yoti.mobile.android.documentcapture.p055id.view.verify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavArgsLazy;
import com.yoti.mobile.android.common.p049ui.widgets.NavigationIcon;
import com.yoti.mobile.android.common.p049ui.widgets.YotiAppbar;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.SingleEvent;
import com.yoti.mobile.android.commonui.extension.FragmentKt;
import com.yoti.mobile.android.commonui.extension.LifecycleKt;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.databinding.YdsFragmentVerifyYourDetailsBinding;
import com.yoti.mobile.android.documentcapture.p055id.p056di.ForDocumentNfcVerification;
import com.yoti.mobile.android.documentcapture.p055id.p056di.IdDocumentCaptureSession;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.p055id.view.verify.ScreenState;
import com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragmentArgs;
import com.yoti.mobile.android.mrtd.MrtdCaptureLauncher;
import com.yoti.mobile.android.mrtd.MrtdCaptureLauncherKt;
import com.yoti.mobile.android.mrtd.domain.model.BacCredential;
import java.io.Serializable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\u0016\u0010.\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u001a\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u00067"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsFragment;", "Lcom/yoti/mobile/android/commonui/BaseFragment;", "()V", "binding", "Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentVerifyYourDetailsBinding;", "getBinding", "()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentVerifyYourDetailsBinding;", "binding$delegate", "Lkotlin/properties/ReadOnlyProperty;", "fragmentArgs", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "viewModel", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/VerifyYourDetailsViewModel;", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "displayCancelConfirmation", "", "navigateBack", "navigateToDocumentCapture", "navigateToNfcCapture", "bacCredential", "Lcom/yoti/mobile/android/mrtd/domain/model/BacCredential;", "navigateToUpload", "scanResultViewData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onPositiveButtonClick", "dialogTag", "", "onScreenStateChanged", "state", "Lcom/yoti/mobile/android/commonui/SingleEvent;", "Lcom/yoti/mobile/android/documentcapture/id/view/verify/ScreenState;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class VerifyYourDetailsFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VerifyYourDetailsFragment.class, "binding", "getBinding()Lcom/yoti/mobile/android/documentcapture/id/databinding/YdsFragmentVerifyYourDetailsBinding;", 0))};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final ReadOnlyProperty binding;

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs;
    private VerifyYourDetailsViewModel viewModel;

    @Inject
    public SavedStateViewModelFactory<VerifyYourDetailsViewModel> viewModelFactory;

    public VerifyYourDetailsFragment() {
        super(C4608R.layout.yds_fragment_verify_your_details);
        this.binding = FragmentKt.viewBindingLazy(this, new Function0<YdsFragmentVerifyYourDetailsBinding>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.VerifyYourDetailsFragment$binding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final YdsFragmentVerifyYourDetailsBinding invoke() {
                return YdsFragmentVerifyYourDetailsBinding.bind(this.this$0.requireView());
            }
        });
        this.fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(VerifyYourDetailsFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.VerifyYourDetailsFragment$special$$inlined$navArgs$1
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayCancelConfirmation() {
        BaseFragment.showDialog$default(this, C4608R.string.ios_android_yds_nfc_back_overlay_header, C4608R.string.ios_android_yds_nfc_back_overlay_description, C4608R.string.ios_android_yds_nfc_back_overlay_primary_cta, Integer.valueOf(C4608R.string.ios_android_yds_nfc_back_overlay_secondary_cta), null, "ScanPassportAgain", 16, null);
    }

    private final YdsFragmentVerifyYourDetailsBinding getBinding() {
        return (YdsFragmentVerifyYourDetailsBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final VerifyYourDetailsFragmentArgs getFragmentArgs() {
        return (VerifyYourDetailsFragmentArgs) this.fragmentArgs.getValue();
    }

    @ForDocumentNfcVerification
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToDocumentCapture() {
        androidx.navigation.fragment.FragmentKt.findNavController(this).popBackStack(C4608R.id.id_nav_scan_fragment, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToNfcCapture(BacCredential bacCredential) {
        new MrtdCaptureLauncher(bacCredential).start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToUpload(DocumentScanResultViewData scanResultViewData) {
        NavigationKt.navigateSafeToNavGraph(androidx.navigation.fragment.FragmentKt.findNavController(this), C4608R.navigation.yds_document_upload_nav_graph, new DocumentUploadFragmentArgs(scanResultViewData).toBundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScreenStateChanged(SingleEvent<? extends ScreenState> state) {
        state.getContentIfNotHandled(new Function1<ScreenState, Unit>() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.VerifyYourDetailsFragment.onScreenStateChanged.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScreenState screenState) {
                invoke2(screenState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScreenState it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ScreenState.CaptureNfc) {
                    VerifyYourDetailsFragment.this.navigateToNfcCapture(((ScreenState.CaptureNfc) it2).getBacCredential());
                    return;
                }
                if (it2 instanceof ScreenState.Upload) {
                    VerifyYourDetailsFragment.this.navigateToUpload(((ScreenState.Upload) it2).getDocumentScanResultViewData());
                } else if (it2 instanceof ScreenState.Cancel) {
                    VerifyYourDetailsFragment.this.displayCancelConfirmation();
                } else if (it2 instanceof ScreenState.CaptureDocument) {
                    VerifyYourDetailsFragment.this.navigateToDocumentCapture();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-0, reason: not valid java name */
    public static final void m6823onViewCreated$lambda0(VerifyYourDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = this$0.viewModel;
        if (verifyYourDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            verifyYourDetailsViewModel = null;
        }
        verifyYourDetailsViewModel.captureNfc(this$0.getFragmentArgs().getDocumentScanResultViewData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onViewCreated$lambda-1, reason: not valid java name */
    public static final void m6824onViewCreated$lambda1(VerifyYourDetailsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = this$0.viewModel;
        if (verifyYourDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            verifyYourDetailsViewModel = null;
        }
        verifyYourDetailsViewModel.upload(this$0.getFragmentArgs().getDocumentScanResultViewData());
    }

    public final SavedStateViewModelFactory<VerifyYourDetailsViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<VerifyYourDetailsViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yoti.mobile.android.commonui.BaseFragment
    public void navigateBack() {
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = this.viewModel;
        if (verifyYourDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            verifyYourDetailsViewModel = null;
        }
        verifyYourDetailsViewModel.cancel();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1003) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = null;
        if (resultCode != -1) {
            if (resultCode != 1) {
                return;
            }
            VerifyYourDetailsViewModel verifyYourDetailsViewModel2 = this.viewModel;
            if (verifyYourDetailsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                verifyYourDetailsViewModel = verifyYourDetailsViewModel2;
            }
            verifyYourDetailsViewModel.upload(getFragmentArgs().getDocumentScanResultViewData());
            return;
        }
        if (data != null) {
            Serializable serializableExtra = data.getSerializableExtra(MrtdCaptureLauncherKt.CHIP_DATA_EXTRA);
            if (serializableExtra == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.Int, kotlin.ByteArray>{ com.yoti.mobile.android.mrtd.MrtdCaptureLauncherKt.ChipData }");
            }
            Map<Integer, byte[]> map = (Map) serializableExtra;
            VerifyYourDetailsViewModel verifyYourDetailsViewModel3 = this.viewModel;
            if (verifyYourDetailsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                verifyYourDetailsViewModel = verifyYourDetailsViewModel3;
            }
            verifyYourDetailsViewModel.setNfcPayload(map, getFragmentArgs().getDocumentScanResultViewData());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdDocumentCaptureSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, com.yoti.mobile.android.commonui.YotiDocsDialogFragment.DialogListener
    public void onPositiveButtonClick(String dialogTag) {
        Intrinsics.checkNotNullParameter(dialogTag, "dialogTag");
        if (!Intrinsics.areEqual(dialogTag, "ScanPassportAgain")) {
            super.onPositiveButtonClick(dialogTag);
            return;
        }
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = this.viewModel;
        if (verifyYourDetailsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            verifyYourDetailsViewModel = null;
        }
        verifyYourDetailsViewModel.cancelConfirmed();
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YotiAppbar yotiAppbar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(yotiAppbar, "binding.appBar");
        BaseFragment.configureAppBar$default(this, yotiAppbar, NavigationIcon.BACK_BLUE, false, 0, 0, 0, 60, null);
        getBinding().buttonEPassport.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.VerifyYourDetailsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerifyYourDetailsFragment.m6823onViewCreated$lambda0(this.f$0, view2);
            }
        });
        getBinding().buttonTraditionalPassport.setOnClickListener(new View.OnClickListener() { // from class: com.yoti.mobile.android.documentcapture.id.view.verify.VerifyYourDetailsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerifyYourDetailsFragment.m6824onViewCreated$lambda1(this.f$0, view2);
            }
        });
        SavedStateViewModelFactory<VerifyYourDetailsViewModel> viewModelFactory = getViewModelFactory();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        VerifyYourDetailsViewModel verifyYourDetailsViewModel = (VerifyYourDetailsViewModel) viewModelFactory.create(fragmentActivityRequireActivity);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleKt.observe(viewLifecycleOwner, verifyYourDetailsViewModel.getScreenState$documentcapture_id_productionRelease(), new VerifyYourDetailsFragment$onViewCreated$3$1(this));
        this.viewModel = verifyYourDetailsViewModel;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<VerifyYourDetailsViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }
}
