package com.yoti.mobile.android.documentcapture.view.additional_instructions.navigation;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.yoti.mobile.android.commons.navigation.NavigationEvent;
import com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator;
import com.yoti.mobile.android.commonui.extension.FragmentActivityKt;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.view.additional_instructions.AdditionalInstructionsNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.navigation.DocumentNavigationCoordinatorHelper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/additional_instructions/navigation/AdditionalInstructionsCoordinator;", "Lcom/yoti/mobile/android/commons/navigation/NestedFragmentNavigationCoordinator;", "documentNavigationCoordinatorHelper", "Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;)V", "isCameraPermissionRequired", "", "()Z", "navController", "Landroidx/navigation/NavController;", "bind", "", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentContainerId", "", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AdditionalInstructionsCoordinator extends NestedFragmentNavigationCoordinator {
    private final DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper;
    private NavController navController;

    @Inject
    public AdditionalInstructionsCoordinator(DocumentNavigationCoordinatorHelper documentNavigationCoordinatorHelper) {
        Intrinsics.checkNotNullParameter(documentNavigationCoordinatorHelper, "documentNavigationCoordinatorHelper");
        this.documentNavigationCoordinatorHelper = documentNavigationCoordinatorHelper;
    }

    @Override // com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator
    public void bind(Fragment fragment, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.bind(fragment, fragmentContainerId);
        this.documentNavigationCoordinatorHelper.bind(fragment, fragmentContainerId);
        this.navController = FragmentKt.findNavController(fragment);
    }

    public final boolean isCameraPermissionRequired() {
        return this.documentNavigationCoordinatorHelper.isCameraPermissionRequired();
    }

    @Override // com.yoti.mobile.android.commons.navigation.INavigationCoordinator
    public boolean onNavigationEvent(NavigationEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, AdditionalInstructionsNavigationEvent.BackToSelection.INSTANCE)) {
            NavController navController = this.navController;
            if (navController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            }
            navController.popBackStack(C4597R.id.documentSelectionFragment, false);
            return true;
        }
        if (!Intrinsics.areEqual(event, AdditionalInstructionsNavigationEvent.CloseSdk.INSTANCE)) {
            return this.documentNavigationCoordinatorHelper.onNavigationEvent(event);
        }
        FragmentActivity fragmentActivityRequireActivity = getFragment().requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "fragment.requireActivity()");
        FragmentActivityKt.closeYotiDocSDK(fragmentActivityRequireActivity);
        return true;
    }
}
