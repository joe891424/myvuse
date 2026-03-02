package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.view.scan.IScanConfigurationViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.di.ScanModule_ProvidesEntityToScanConfigurationViewDataMapperFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4601x1e27f87 implements Factory<Mapper<IScanConfigurationEntity, IScanConfigurationViewData>> {
    private final ScanModule module;

    public C4601x1e27f87(ScanModule scanModule) {
        this.module = scanModule;
    }

    public static C4601x1e27f87 create(ScanModule scanModule) {
        return new C4601x1e27f87(scanModule);
    }

    public static Mapper<IScanConfigurationEntity, IScanConfigurationViewData> providesEntityToScanConfigurationViewDataMapper(ScanModule scanModule) {
        return (Mapper) Preconditions.checkNotNullFromProvides(scanModule.providesEntityToScanConfigurationViewDataMapper());
    }

    @Override // javax.inject.Provider
    public Mapper<IScanConfigurationEntity, IScanConfigurationViewData> get() {
        return providesEntityToScanConfigurationViewDataMapper(this.module);
    }
}
