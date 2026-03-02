package com.yoti.mobile.android.documentcapture.view.requirements;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.yoti.mobile.android.commons.navigation.NavigationEvent;
import com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator;
import com.yoti.mobile.android.commonui.GuidelinesViewData;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import com.yoti.mobile.android.documentcapture.view.requirements.DocumentRequirementsNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.scan.DocumentGuidelinesBottomSheetFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/requirements/DocumentRequirementsCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/NestedFragmentNavigationCoordinator;", "documentNavigationCoordinatorHelper", "Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;)V", "isCameraPermissionRequired", "", "()Z", "bind", "", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentContainerId", "", "closeSdk", "navigateToScanningGuidelines", "viewData", "Lcom/yoti/mobile/android/commonui/GuidelinesViewData;", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentRequirementsCoordinator extends NestedFragmentNavigationCoordinator {
    private final DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper;

    @Inject
    public DocumentRequirementsCoordinator(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        Intrinsics.checkNotNullParameter(documentNavigationCoordinatorHelper, "documentNavigationCoordinatorHelper");
        this.documentNavigationCoordinatorHelper = documentNavigationCoordinatorHelper;
    }

    private final boolean closeSdk() {
        FragmentActivity activity = getFragment().getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        FragmentActivityKt.closeYotiDocSDK(activity);
        return true;
    }

    private final boolean navigateToScanningGuidelines(GuidelinesViewData viewData) {
        DocumentGuidelinesBottomSheetFragment.INSTANCE.newInstance(viewData).show(getFragmentManager(), "DOCUMENT_GUIDELINES_FRAGMENT_TAG");
        return true;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator
    public void bind(Fragment fragment, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.bind(fragment, fragmentContainerId);
        this.documentNavigationCoordinatorHelper.bind(fragment, fragmentContainerId);
    }

    public final boolean isCameraPermissionRequired() {
        return this.documentNavigationCoordinatorHelper.isCameraPermissionRequired();
    }

    @Override // com.yoti.mobile.android.commons.navigation.INavigationCoordinator
    public boolean onNavigationEvent(NavigationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event instanceof DocumentRequirementsNavigationEvent.NavigateToScanningGuidelines ? navigateToScanningGuidelines(((DocumentRequirementsNavigationEvent.NavigateToScanningGuidelines) event).getViewData()) : Intrinsics.areEqual(event, DocumentRequirementsNavigationEvent.CloseSdk.INSTANCE) ? closeSdk() : this.documentNavigationCoordinatorHelper.onNavigationEvent(event);
    }
}
