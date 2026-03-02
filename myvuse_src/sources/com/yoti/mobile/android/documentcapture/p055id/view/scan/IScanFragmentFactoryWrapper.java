package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentscan.domain.transformer.ImageFormat;
import com.yoti.mobile.android.documentscan.model.BlinkIDLicense;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedConfig;
import com.yoti.mobile.android.documentscan.ui.IScanDocument;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;", "", "create", "Lcom/yoti/mobile/android/documentscan/ui/IScanDocument;", "scanConfig", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedConfig;", "viewConfig", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "blinkIdLicence", "Lcom/yoti/mobile/android/documentscan/model/BlinkIDLicense;", "scanLayout", "", "imageFormat", "Lcom/yoti/mobile/android/documentscan/domain/transformer/ImageFormat;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IScanFragmentFactoryWrapper {
    IScanDocument create(DocumentScanDetailedConfig scanConfig, IdScanConfigurationViewData viewConfig, BlinkIDLicense blinkIdLicence, int scanLayout, ImageFormat imageFormat);
}
