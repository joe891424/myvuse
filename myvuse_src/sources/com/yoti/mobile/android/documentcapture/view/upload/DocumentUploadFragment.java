package com.yoti.mobile.android.documentcapture.view.upload;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.commonui.p053di.viewmodel.SavedStateViewModelFactory;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.p054di.ForDocumentUpload;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0016J\u001a\u00100\u001a\u00020(2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00065"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadFragment;", "Lcom/yoti/mobile/android/yotisdkcore/core/view/upload/UploadFragment;", "Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadViewModel;", "()V", "documentName", "", "getDocumentName", "()Ljava/lang/String;", "fragmentArgs", "Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadFragmentArgs;", "getFragmentArgs", "()Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadFragmentArgs;", "fragmentArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "uploadInProgressTitle", "getUploadInProgressTitle", "uploadNavigationProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "getUploadNavigationProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "setUploadNavigationProvider", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;)V", "uploadNavigator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "getUploadNavigator", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "setUploadNavigator", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;)V", "uploadSuccessTitle", "getUploadSuccessTitle", "viewModelFactory", "Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "getViewModelFactory$annotations", "getViewModelFactory", "()Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;", "setViewModelFactory", "(Lcom/yoti/mobile/android/commonui/di/viewmodel/SavedStateViewModelFactory;)V", "createViewModel", "displayUploadFailureState", "", "failure", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "initialiseUploadProcess", "navigateToPreviousScreen", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentUploadFragment extends UploadFragment<DocumentUploadViewModel> {

    /* JADX INFO: renamed from: fragmentArgs$delegate, reason: from kotlin metadata */
    private final NavArgsLazy fragmentArgs = new NavArgsLazy(Reflection.getOrCreateKotlinClass(DocumentUploadFragmentArgs.class), new Function0<Bundle>() { // from class: com.yoti.mobile.android.documentcapture.view.upload.DocumentUploadFragment$special$$inlined$navArgs$1
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

    @Inject
    public IUploadNavigatorProvider<IDocumentViewData> uploadNavigationProvider;
    public IUploadNavigator<IDocumentViewData> uploadNavigator;

    @Inject
    public SavedStateViewModelFactory<DocumentUploadViewModel> viewModelFactory;

    private final String getDocumentName() {
        String string = getString(getFragmentArgs().getUploadableDocumentViewData().getDocumentType().getDocumentName(getFragmentArgs().getUploadableDocumentViewData().getCountryIso3Code()).getLowercaseName());
        Intrinsics.checkNotNullExpressionValue(string, "getString(fragmentArgs.u…(iso3Code).lowercaseName)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentUploadFragmentArgs getFragmentArgs() {
        return (DocumentUploadFragmentArgs) this.fragmentArgs.getValue();
    }

    @ForDocumentUpload
    public static /* synthetic */ void getViewModelFactory$annotations() {
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void displayUploadFailureState(YdsFailure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (getUploadNavigator().navigateToUploadError(failure, getFragmentArgs().getUploadableDocumentViewData())) {
            return;
        }
        super.displayUploadFailureState(failure);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public String getUploadInProgressTitle() {
        String string = getString(C4597R.string.ios_android_yds_document_uploading_header, getDocumentName());
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ios_a…ing_header, documentName)");
        return string;
    }

    public final IUploadNavigatorProvider<IDocumentViewData> getUploadNavigationProvider() {
        IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider = this.uploadNavigationProvider;
        if (iUploadNavigatorProvider != null) {
            return iUploadNavigatorProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadNavigationProvider");
        return null;
    }

    public final IUploadNavigator<IDocumentViewData> getUploadNavigator() {
        IUploadNavigator<IDocumentViewData> iUploadNavigator = this.uploadNavigator;
        if (iUploadNavigator != null) {
            return iUploadNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uploadNavigator");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public String getUploadSuccessTitle() {
        String string = getString(C4597R.string.ios_android_yds_document_completion_header, getDocumentName());
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ios_a…ion_header, documentName)");
        return string;
    }

    public final SavedStateViewModelFactory<DocumentUploadViewModel> getViewModelFactory() {
        SavedStateViewModelFactory<DocumentUploadViewModel> savedStateViewModelFactory = this.viewModelFactory;
        if (savedStateViewModelFactory != null) {
            return savedStateViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void initialiseUploadProcess() {
        getUploadViewModel().upload(getFragmentArgs().getUploadableDocumentViewData());
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public void navigateToPreviousScreen() {
        getUploadNavigator().navigateBackToScan();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentCaptureCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUploadNavigator(getUploadNavigationProvider().getNavigator(FragmentKt.findNavController(this)));
    }

    public final void setUploadNavigationProvider(IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider) {
        Intrinsics.checkNotNullParameter(iUploadNavigatorProvider, "<set-?>");
        this.uploadNavigationProvider = iUploadNavigatorProvider;
    }

    public final void setUploadNavigator(IUploadNavigator<IDocumentViewData> iUploadNavigator) {
        Intrinsics.checkNotNullParameter(iUploadNavigator, "<set-?>");
        this.uploadNavigator = iUploadNavigator;
    }

    public final void setViewModelFactory(SavedStateViewModelFactory<DocumentUploadViewModel> savedStateViewModelFactory) {
        Intrinsics.checkNotNullParameter(savedStateViewModelFactory, "<set-?>");
        this.viewModelFactory = savedStateViewModelFactory;
    }

    @Override // com.yoti.mobile.android.yotisdkcore.core.view.upload.UploadFragment
    public DocumentUploadViewModel createViewModel() {
        return (DocumentUploadViewModel) getViewModelFactory().create(this);
    }
}
