package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "", "scanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "getScanConfigurationRepository", "()Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "scanConfigurationToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "getScanConfigurationToViewDataMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "scanNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "getScanNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentScanDependenciesProvider {
    IScanConfigurationRepository<IScanConfigurationEntity> getScanConfigurationRepository();

    Mapper<IScanConfigurationEntity, IScanConfigurationViewData> getScanConfigurationToViewDataMapper();

    IScanNavigatorProvider<IScanConfigurationViewData> getScanNavigatorProvider();
}
