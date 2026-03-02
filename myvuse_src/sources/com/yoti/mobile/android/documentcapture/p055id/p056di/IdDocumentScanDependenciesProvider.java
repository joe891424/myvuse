package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p055id.data.IdScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IdScanConfigurationEntityToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentScanDependenciesProvider;", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "scanNavProvider", "Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentScanNavigatorProvider;", "scanConfigRepository", "Lcom/yoti/mobile/android/documentcapture/id/data/IdScanConfigurationRepository;", "scanConfigEntityToViewDataMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationEntityToViewDataMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentScanNavigatorProvider;Lcom/yoti/mobile/android/documentcapture/id/data/IdScanConfigurationRepository;Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationEntityToViewDataMapper;)V", "scanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "getScanConfigurationRepository", "()Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "scanConfigurationToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "getScanConfigurationToViewDataMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "scanNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "getScanNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentScanDependenciesProvider implements IDocumentScanDependenciesProvider {
    private final IScanConfigurationRepository<IScanConfigurationEntity> scanConfigurationRepository;
    private final Mapper<IScanConfigurationEntity, IScanConfigurationViewData> scanConfigurationToViewDataMapper;
    private final IScanNavigatorProvider<IScanConfigurationViewData> scanNavigatorProvider;

    @Inject
    public IdDocumentScanDependenciesProvider(IdDocumentScanNavigatorProvider scanNavProvider, IdScanConfigurationRepository scanConfigRepository, IdScanConfigurationEntityToViewDataMapper scanConfigEntityToViewDataMapper) {
        Intrinsics.checkNotNullParameter(scanNavProvider, "scanNavProvider");
        Intrinsics.checkNotNullParameter(scanConfigRepository, "scanConfigRepository");
        Intrinsics.checkNotNullParameter(scanConfigEntityToViewDataMapper, "scanConfigEntityToViewDataMapper");
        this.scanNavigatorProvider = scanNavProvider;
        this.scanConfigurationToViewDataMapper = scanConfigEntityToViewDataMapper;
        this.scanConfigurationRepository = scanConfigRepository;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider
    public IScanConfigurationRepository<IScanConfigurationEntity> getScanConfigurationRepository() {
        return this.scanConfigurationRepository;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider
    public Mapper<IScanConfigurationEntity, IScanConfigurationViewData> getScanConfigurationToViewDataMapper() {
        return this.scanConfigurationToViewDataMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider
    public IScanNavigatorProvider<IScanConfigurationViewData> getScanNavigatorProvider() {
        return this.scanNavigatorProvider;
    }
}
