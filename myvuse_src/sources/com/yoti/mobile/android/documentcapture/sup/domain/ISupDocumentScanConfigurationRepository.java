package com.yoti.mobile.android.documentcapture.sup.domain;

import com.yoti.mobile.android.documentcapture.sup.domain.model.SupDocumentScanConfigurationEntity;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&¨\u0006\u0005"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/domain/ISupDocumentScanConfigurationRepository;", "", "getScanConfigurationFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/yoti/mobile/android/documentcapture/sup/domain/model/SupDocumentScanConfigurationEntity;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface ISupDocumentScanConfigurationRepository {
    Flow<SupDocumentScanConfigurationEntity> getScanConfigurationFlow();
}
