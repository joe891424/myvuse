package com.yoti.mobile.android.documentcapture.sup.p057di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import com.yoti.mobile.android.documentcapture.sup.data.SupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.data.cache.SupDocumentScanConfigurationCacheDataSource;
import com.yoti.mobile.android.documentcapture.sup.domain.ISupDocumentScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.sup.view.scan.ICaptureChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.IntentChooser;
import com.yoti.mobile.android.documentcapture.sup.view.scan.automation.AutomationChooser;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0003H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/sup/di/SupDocumentCaptureModule;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "providesCaptureChooser", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/ICaptureChooser;", "intentChooser", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/IntentChooser;", "automationChooser", "Lcom/yoti/mobile/android/documentcapture/sup/view/scan/automation/AutomationChooser;", "providesCoreScanDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "nonIdDocumentScanDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/sup/di/NonIdDocumentScanDependenciesProvider;", "providesCoreSelectionDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "supplementaryDocumentSelectionDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/sup/di/SupplementaryDocumentSelectionDependenciesProvider;", "providesCoreUploadDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "nonIdDocumentUploadDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/sup/di/NonIdDocumentUploadDependenciesProvider;", "providesFeatureConfiguration", "providesSupDocumentScanConfigurationCacheDataSource", "Lcom/yoti/mobile/android/documentcapture/sup/data/cache/SupDocumentScanConfigurationCacheDataSource;", "providesSupDocumentScanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/sup/domain/ISupDocumentScanConfigurationRepository;", "supDocumentScanConfigurationRepository", "Lcom/yoti/mobile/android/documentcapture/sup/data/SupDocumentScanConfigurationRepository;", "documentcapture-sup_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {CommonModule.class, RemoteModule.class, CoroutineContextModule.class, ResourceConfigurationModule.class, CountryHelperModule.class, SupDocumentCaptureApiServiceModule.class, SupDocumentCaptureViewModelModule.class})
public final class SupDocumentCaptureModule {
    private final DocumentCaptureConfiguration featureConfiguration;

    public SupDocumentCaptureModule(DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    @Provides
    public final ICaptureChooser providesCaptureChooser(IntentChooser intentChooser, AutomationChooser automationChooser) {
        Intrinsics.checkNotNullParameter(intentChooser, "intentChooser");
        Intrinsics.checkNotNullParameter(automationChooser, "automationChooser");
        return Intrinsics.areEqual("production", "automation") ? automationChooser : intentChooser;
    }

    @Provides
    public final IDocumentScanDependenciesProvider providesCoreScanDependenciesProvider(NonIdDocumentScanDependenciesProvider nonIdDocumentScanDependenciesProvider) {
        Intrinsics.checkNotNullParameter(nonIdDocumentScanDependenciesProvider, "nonIdDocumentScanDependenciesProvider");
        return nonIdDocumentScanDependenciesProvider;
    }

    @Provides
    public final IDocumentSelectionDependenciesProvider providesCoreSelectionDependenciesProvider(SupplementaryDocumentSelectionDependenciesProvider supplementaryDocumentSelectionDependenciesProvider) {
        Intrinsics.checkNotNullParameter(supplementaryDocumentSelectionDependenciesProvider, "supplementaryDocumentSelectionDependenciesProvider");
        return supplementaryDocumentSelectionDependenciesProvider;
    }

    @Provides
    public final IDocumentUploadDependenciesProvider providesCoreUploadDependenciesProvider(NonIdDocumentUploadDependenciesProvider nonIdDocumentUploadDependenciesProvider) {
        Intrinsics.checkNotNullParameter(nonIdDocumentUploadDependenciesProvider, "nonIdDocumentUploadDependenciesProvider");
        return nonIdDocumentUploadDependenciesProvider;
    }

    @Provides
    /* JADX INFO: renamed from: providesFeatureConfiguration, reason: from getter */
    public final DocumentCaptureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Provides
    public final SupDocumentScanConfigurationCacheDataSource providesSupDocumentScanConfigurationCacheDataSource() {
        return SupDocumentScanConfigurationCacheDataSource.INSTANCE;
    }

    @Provides
    public final ISupDocumentScanConfigurationRepository providesSupDocumentScanConfigurationRepository(SupDocumentScanConfigurationRepository supDocumentScanConfigurationRepository) {
        Intrinsics.checkNotNullParameter(supDocumentScanConfigurationRepository, "supDocumentScanConfigurationRepository");
        return supDocumentScanConfigurationRepository;
    }
}
