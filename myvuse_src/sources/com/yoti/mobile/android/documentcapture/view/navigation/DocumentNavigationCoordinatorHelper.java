package com.yoti.mobile.android.documentcapture.view.navigation;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.FragmentKt;
import com.newrelic.agent.android.instrumentation.androidx.navigation.NavigationController;
import com.yoti.mobile.android.commons.navigation.NavigationEvent;
import com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator;
import com.yoti.mobile.android.commonui.BaseFragment;
import com.yoti.mobile.android.commonui.DialogType;
import com.yoti.mobile.android.commonui.GenericMessageFragmentArgs;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.documentcapture.C4597R;
import com.yoti.mobile.android.documentcapture.view.DocumentFeatureErrorTag;
import com.yoti.mobile.android.documentcapture.view.DocumentNavigationEvent;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.selection.DoNotHaveDocumentsDialogViewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/navigation/DocumentNavigationCoordinatorHelper;", "Lcom/yoti/mobile/android/commons/navigation/NestedFragmentNavigationCoordinator;", "scanNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "(Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;)V", "isCameraPermissionRequired", "", "()Z", "navController", "Landroidx/navigation/NavController;", "scanNavigator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigator;", "bind", "", "fragment", "Landroidx/fragment/app/Fragment;", "fragmentContainerId", "", "navigateToCameraPermissionDenied", "onNavigationEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/yoti/mobile/android/commons/navigation/NavigationEvent;", "requestCameraPermission", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentNavigationCoordinatorHelper extends NestedFragmentNavigationCoordinator {
    private NavController navController;
    private IScanNavigator<IScanConfigurationViewData> scanNavigator;
    private final IScanNavigatorProvider<IScanConfigurationViewData> scanNavigatorProvider;

    @Inject
    public DocumentNavigationCoordinatorHelper(IScanNavigatorProvider<IScanConfigurationViewData> scanNavigatorProvider) {
        Intrinsics.checkNotNullParameter(scanNavigatorProvider, "scanNavigatorProvider");
        this.scanNavigatorProvider = scanNavigatorProvider;
    }

    private final void navigateToCameraPermissionDenied() {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavigationKt.navigateSafeToNavGraph(navController, C4597R.navigation.yds_camera_permission_denied_nav_graph, new GenericMessageFragmentArgs(C4597R.drawable.yds_ic_camera_access, C4597R.string.yds_camera_permission_denied_header, null, C4597R.string.ios_android_yds_camera_permission_denied_description, null, C4597R.string.ios_android_yds_camera_permission_denied_primary_cta, null, C4597R.drawable.chevron_right_white, 0, null, 0, null, 3924, null).toBundle());
    }

    private final void requestCameraPermission() {
        getFragment().requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
    }

    @Override // com.yoti.mobile.android.commons.navigation.NestedFragmentNavigationCoordinator
    public void bind(Fragment fragment, int fragmentContainerId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.bind(fragment, fragmentContainerId);
        NavController navControllerFindNavController = FragmentKt.findNavController(fragment);
        this.navController = navControllerFindNavController;
        IScanNavigatorProvider<IScanConfigurationViewData> iScanNavigatorProvider = this.scanNavigatorProvider;
        if (navControllerFindNavController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navControllerFindNavController = null;
        }
        this.scanNavigator = iScanNavigatorProvider.getNavigator(navControllerFindNavController);
    }

    public final boolean isCameraPermissionRequired() {
        IScanNavigator<IScanConfigurationViewData> iScanNavigator = this.scanNavigator;
        if (iScanNavigator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanNavigator");
            iScanNavigator = null;
        }
        return iScanNavigator.isCameraPermissionRequired();
    }

    @Override // com.yoti.mobile.android.commons.navigation.INavigationCoordinator
    public boolean onNavigationEvent(NavigationEvent event) {
        NavController navController;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, DocumentNavigationEvent.RequestCameraPermission.INSTANCE)) {
            requestCameraPermission();
            return true;
        }
        if (Intrinsics.areEqual(event, DocumentNavigationEvent.NavigateToCameraPermissionDenied.INSTANCE)) {
            navigateToCameraPermissionDenied();
            return true;
        }
        NavController navController2 = null;
        IScanNavigator<IScanConfigurationViewData> iScanNavigator = null;
        NavController navController3 = null;
        if (event instanceof DocumentNavigationEvent.NavigateToScan) {
            IScanNavigator<IScanConfigurationViewData> iScanNavigator2 = this.scanNavigator;
            if (iScanNavigator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanNavigator");
            } else {
                iScanNavigator = iScanNavigator2;
            }
            iScanNavigator.navigateToScan(((DocumentNavigationEvent.NavigateToScan) event).getScanConfiguration());
            return true;
        }
        if (event instanceof DocumentNavigationEvent.NavigateToAdditionalInstructions) {
            NavController navController4 = this.navController;
            if (navController4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            } else {
                navController = navController4;
            }
            NavigationKt.navigateSafe$default(navController, C4597R.id.action_global_to_additional_instructions, ((DocumentNavigationEvent.NavigateToAdditionalInstructions) event).getFragmentArgs(), null, null, 12, null);
            return true;
        }
        if (event instanceof DocumentNavigationEvent.NavigateToMoreAboutVerification) {
            NavController navController5 = this.navController;
            if (navController5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController3 = navController5;
            }
            NavigationKt.navigateSafeToNavGraph(navController3, C4597R.navigation.yds_more_about_nav_graph, ((DocumentNavigationEvent.NavigateToMoreAboutVerification) event).getFragmentArgs().toBundle());
            return true;
        }
        if (event instanceof DocumentNavigationEvent.NavigateToDoNotHaveDocumentsDialog) {
            DoNotHaveDocumentsDialogViewData dialogViewData = ((DocumentNavigationEvent.NavigateToDoNotHaveDocumentsDialog) event).getDialogViewData();
            BaseFragment.showDialog$default((BaseFragment) getFragment(), 0, dialogViewData.getTextId(), dialogViewData.getPositiveButtonId(), Integer.valueOf(dialogViewData.getNegativeButtonId()), DialogType.DESTRUCTIVE, DocumentFeatureErrorTag.TAG_DOES_NOT_HAVE_DOCUMENT_ERROR.name(), 1, null);
            return true;
        }
        if (Intrinsics.areEqual(event, DocumentNavigationEvent.CancelFlow.INSTANCE)) {
            ((BaseFragment) getFragment()).cancelFlow();
            return true;
        }
        if (!Intrinsics.areEqual(event, DocumentNavigationEvent.NavigateBack.INSTANCE)) {
            return false;
        }
        NavController navController6 = this.navController;
        if (navController6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
        } else {
            navController2 = navController6;
        }
        return !(navController2 instanceof NavHostController) ? navController2.popBackStack() : NavigationController.popBackStack((NavHostController) navController2);
    }
}
