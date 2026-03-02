package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigator;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentScanNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "()V", "getNavigator", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigator;", "navController", "Landroidx/navigation/NavController;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentScanNavigatorProvider implements IScanNavigatorProvider<IdScanConfigurationViewData> {
    @Inject
    public IdDocumentScanNavigatorProvider() {
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider
    public IScanNavigator<IdScanConfigurationViewData> getNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return new IdDocumentScanNavigator(navController);
    }
}
