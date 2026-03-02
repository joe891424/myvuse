package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.sup.data.cache.SupDocumentScanConfigurationCacheDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: renamed from: com.yoti.mobile.android.documentcapture.sup.di.SupDocumentCaptureModule_ProvidesSupDocumentScanConfigurationCacheDataSourceFactory */
/* JADX INFO: loaded from: classes5.dex */
public final class C4661xab7d6ddb implements Factory<SupDocumentScanConfigurationCacheDataSource> {
    private final SupDocumentCaptureModule module;

    public C4661xab7d6ddb(SupDocumentCaptureModule supDocumentCaptureModule) {
        this.module = supDocumentCaptureModule;
    }

    public static C4661xab7d6ddb create(SupDocumentCaptureModule supDocumentCaptureModule) {
        return new C4661xab7d6ddb(supDocumentCaptureModule);
    }

    public static SupDocumentScanConfigurationCacheDataSource providesSupDocumentScanConfigurationCacheDataSource(SupDocumentCaptureModule supDocumentCaptureModule) {
        return (SupDocumentScanConfigurationCacheDataSource) Preconditions.checkNotNullFromProvides(supDocumentCaptureModule.providesSupDocumentScanConfigurationCacheDataSource());
    }

    @Override // javax.inject.Provider
    public SupDocumentScanConfigurationCacheDataSource get() {
        return providesSupDocumentScanConfigurationCacheDataSource(this.module);
    }
}
