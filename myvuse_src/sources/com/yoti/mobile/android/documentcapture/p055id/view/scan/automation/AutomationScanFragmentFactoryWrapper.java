package com.yoti.mobile.android.documentcapture.p055id.view.scan.automation;

import com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationViewData;
import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragmentFactoryWrapper;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;", "()V", "create", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "blinkIdLicence", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "scanLayout", "", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class AutomationScanFragmentFactoryWrapper implements IScanFragmentFactoryWrapper {
    @Inject
    public AutomationScanFragmentFactoryWrapper() {
    }

    @Override // com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanFragmentFactoryWrapper
    public IScanDocument create(DocumentScanDetailedConfig scanConfig, IdScanConfigurationViewData viewConfig, BlinkIDLicense blinkIdLicence, int scanLayout, ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(scanConfig, "scanConfig");
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        Intrinsics.checkNotNullParameter(blinkIdLicence, "blinkIdLicence");
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return AutomationScanFragment.INSTANCE.getInstance(scanConfig);
    }
}
