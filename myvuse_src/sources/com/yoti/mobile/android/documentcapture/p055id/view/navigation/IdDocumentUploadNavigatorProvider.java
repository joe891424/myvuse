package com.yoti.mobile.android.documentcapture.p055id.view.navigation;

import androidx.navigation.NavController;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.DocumentScanResultViewData;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "documentFeatureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "getNavigator", "Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigator;", "navController", "Landroidx/navigation/NavController;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentUploadNavigatorProvider implements IUploadNavigatorProvider<DocumentScanResultViewData> {
    private final DocumentCaptureConfiguration documentFeatureConfiguration;

    @Inject
    public IdDocumentUploadNavigatorProvider(DocumentCaptureConfiguration documentFeatureConfiguration) {
        Intrinsics.checkNotNullParameter(documentFeatureConfiguration, "documentFeatureConfiguration");
        this.documentFeatureConfiguration = documentFeatureConfiguration;
    }

    @Override // com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider
    public IdDocumentUploadNavigator getNavigator(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        return new IdDocumentUploadNavigator(navController, this.documentFeatureConfiguration);
    }
}
