package com.yoti.mobile.android.documentcapture.sup.view.scan;

import com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupDocumentScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/SupDocumentScanConfigurationViewData;", "documentEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;)V", "map", "from", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanConfigEntityToViewDataMapper implements Mapper<SupDocumentScanConfigurationEntity, SupDocumentScanConfigurationViewData> {
    private final DocumentTypeEntityToViewDataMapper documentEntityToViewDataMapper;

    @Inject
    public SupDocumentScanConfigEntityToViewDataMapper(DocumentTypeEntityToViewDataMapper documentEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(documentEntityToViewDataMapper, "documentEntityToViewDataMapper");
        this.documentEntityToViewDataMapper = documentEntityToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SupDocumentScanConfigurationViewData map(SupDocumentScanConfigurationEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new SupDocumentScanConfigurationViewData(from.getResourceId(), from.getCountryIso3Code(), this.documentEntityToViewDataMapper.map(from.getDocumentType()));
    }
}
