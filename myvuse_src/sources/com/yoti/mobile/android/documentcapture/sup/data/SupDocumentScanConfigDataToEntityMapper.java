package com.yoti.mobile.android.documentcapture.sup.data;

import com.yoti.mobile.android.documentcapture.sup.data.remote.model.SupDocumentScanConfiguration;
import com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentScanConfigDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/sup/data/remote/model/SupDocumentScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupDocumentScanConfigurationEntity;", "documentTypeDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;)V", "map", "from", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class SupDocumentScanConfigDataToEntityMapper implements Mapper<SupDocumentScanConfiguration, SupDocumentScanConfigurationEntity> {
    private final DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper;

    @Inject
    public SupDocumentScanConfigDataToEntityMapper(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper) {
        Intrinsics.checkNotNullParameter(documentTypeDataToEntityMapper, "documentTypeDataToEntityMapper");
        this.documentTypeDataToEntityMapper = documentTypeDataToEntityMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public SupDocumentScanConfigurationEntity map(SupDocumentScanConfiguration from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new SupDocumentScanConfigurationEntity(from.getResourceId(), this.documentTypeDataToEntityMapper.map(from.getDocumentType()), from.getIssuingCountryIso3Code());
    }
}
