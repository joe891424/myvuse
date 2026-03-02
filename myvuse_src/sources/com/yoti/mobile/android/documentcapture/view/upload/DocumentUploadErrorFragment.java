package com.yoti.mobile.android.documentcapture.view.upload;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.commonui.GenericMessageFragment;
import com.yoti.mobile.android.documentcapture.p054di.DocumentCaptureCoreSession;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigator;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/upload/DocumentUploadErrorFragment;", "Lcom/yoti/mobile/android/commonui/GenericMessageFragment;", "()V", "navigator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "getNavigator", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;", "setNavigator", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigator;)V", "navigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "getNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "setNavigatorProvider", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;)V", "navigateBack", "", "onActionButtonClicked", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentUploadErrorFragment extends GenericMessageFragment {
    public IUploadNavigator<IDocumentViewData> navigator;

    @Inject
    public IUploadNavigatorProvider<IDocumentViewData> navigatorProvider;

    public final IUploadNavigator<IDocumentViewData> getNavigator() {
        IUploadNavigator<IDocumentViewData> iUploadNavigator = this.navigator;
        if (iUploadNavigator != null) {
            return iUploadNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public final IUploadNavigatorProvider<IDocumentViewData> getNavigatorProvider() {
        IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider = this.navigatorProvider;
        if (iUploadNavigatorProvider != null) {
            return iUploadNavigatorProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigatorProvider");
        return null;
    }

    @Override // com.yoti.mobile.android.commonui.BaseFragment
    protected void navigateBack() {
        getNavigator().navigateBackToFirstScreen();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment
    public void onActionButtonClicked() {
        super.onActionButtonClicked();
        getNavigator().navigateBackToFirstScreen();
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentCaptureCoreSession.INSTANCE.getInstance().getFeatureComponent().inject(this);
        super.onAttach(context);
    }

    @Override // com.yoti.mobile.android.commonui.GenericMessageFragment, com.yoti.mobile.android.commonui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setNavigator(getNavigatorProvider().getNavigator(FragmentKt.findNavController(this)));
    }

    public final void setNavigator(IUploadNavigator<IDocumentViewData> iUploadNavigator) {
        Intrinsics.checkNotNullParameter(iUploadNavigator, "<set-?>");
        this.navigator = iUploadNavigator;
    }

    public final void setNavigatorProvider(IUploadNavigatorProvider<IDocumentViewData> iUploadNavigatorProvider) {
        Intrinsics.checkNotNullParameter(iUploadNavigatorProvider, "<set-?>");
        this.navigatorProvider = iUploadNavigatorProvider;
    }
}
