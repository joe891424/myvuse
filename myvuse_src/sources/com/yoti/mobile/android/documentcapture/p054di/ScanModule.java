package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.view.navigation.IScanNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0017J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0017J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/ScanModule;", "", "dependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "(Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;)V", "providesEntityToScanConfigurationViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/view/scan/IScanConfigurationViewData;", "providesScanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "providesScanNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IScanNavigatorProvider;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class ScanModule {
    private final IDocumentScanDependenciesProvider dependenciesProvider;

    public ScanModule(IDocumentScanDependenciesProvider dependenciesProvider) {
        Intrinsics.checkNotNullParameter(dependenciesProvider, "dependenciesProvider");
        this.dependenciesProvider = dependenciesProvider;
    }

    @Provides
    public Mapper<IScanConfigurationEntity, IScanConfigurationViewData> providesEntityToScanConfigurationViewDataMapper() {
        return this.dependenciesProvider.getScanConfigurationToViewDataMapper();
    }

    @Provides
    @Singleton
    public IScanConfigurationRepository<IScanConfigurationEntity> providesScanConfigurationRepository() {
        return this.dependenciesProvider.getScanConfigurationRepository();
    }

    @Provides
    @Singleton
    public IScanNavigatorProvider<IScanConfigurationViewData> providesScanNavigatorProvider() {
        return this.dependenciesProvider.getScanNavigatorProvider();
    }
}
