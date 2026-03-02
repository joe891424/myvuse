package com.yoti.mobile.android.documentcapture.domain.model;

import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "", "countryIso3Code", "", "getCountryIso3Code", "()Ljava/lang/String;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "resourceId", "getResourceId", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IScanConfigurationEntity {
    String getCountryIso3Code();

    DocumentResourceConfigEntity.DocumentTypeEntity getDocumentType();

    String getResourceId();
}
