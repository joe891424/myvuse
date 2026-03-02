package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.commonui.extension.NavigationKt;
import com.yoti.mobile.android.documentcapture.p055id.C4608R;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanFragmentArgs;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentScanNavigator;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigator;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "navController", "Landroidx/navigation/NavController;", "(Landroidx/navigation/NavController;)V", "navigateToScan", "", "scanConfiguration", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentScanNavigator implements IScanNavigator<IdScanConfigurationViewData> {
    private final NavController navController;

    public IdDocumentScanNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.navController = navController;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator
    public boolean isCameraPermissionRequired() {
        return IScanNavigator.DefaultImpls.isCameraPermissionRequired(this);
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator
    public void navigateToScan(IdScanConfigurationViewData scanConfiguration) {
        Intrinsics.checkNotNullParameter(scanConfiguration, "scanConfiguration");
        NavigationKt.navigateSafe$default(this.navController, C4608R.id.action_global_to_scan, new DocumentScanFragmentArgs(scanConfiguration).toBundle(), null, null, 12, null);
    }
}
