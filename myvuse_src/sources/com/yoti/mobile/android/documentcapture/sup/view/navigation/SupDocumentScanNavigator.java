package com.yoti.mobile.android.documentcapture.sup.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.documentcapture.sup.C4653R;
import com.yoti.mobile.android.documentcapture.sup.view.scan.SupDocumentScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/navigation/SupDocumentScanNavigator;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigator;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;", "navController", "Landroidx/navigation/NavController;", "isValidationAndGuidanceEnabled", "", "(Landroidx/navigation/NavController;Z)V", "isCameraPermissionRequired", "()Z", "navigateToScan", "", "scanConfiguration", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanNavigator implements IScanNavigator<SupDocumentScanConfigurationViewData> {
    private final boolean isValidationAndGuidanceEnabled;
    private final NavController navController;

    public SupDocumentScanNavigator(NavController navController, boolean z) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
        this.isValidationAndGuidanceEnabled = z;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator
    public boolean isCameraPermissionRequired() {
        return false;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator
    public void navigateToScan(SupDocumentScanConfigurationViewData scanConfiguration) {
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        if (this.isValidationAndGuidanceEnabled) {
            return;
        }
        NavigationKt.navigateSafe$default(this.navController, C4653R.id.action_global_to_guidelines, null, null, null, 14, null);
    }
}
