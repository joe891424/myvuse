package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.p054di.IDocumentScanDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentSelectionDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.IScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.ScanFragmentFactoryWrapper;
import com.yoti.mobile.android.documentcapture.p055id.view.scan.automation.AutomationScanFragmentFactoryWrapper;
import com.yoti.mobile.android.mrtd.p073di.MrtdCoreModule;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.p079di.schedulers.CoroutineContextModule;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.p085di.CountryHelperModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentCaptureModule;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "providesCoreScanDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentScanDependenciesProvider;", "idDocumentScanDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentScanDependenciesProvider;", "providesCoreSelectionDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentSelectionDependenciesProvider;", "idDocumentSelectionDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentSelectionDependenciesProvider;", "providesCoreUploadDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "idDocumentUploadDependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentUploadDependenciesProvider;", "providesScanFragmentFactory", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IScanFragmentFactoryWrapper;", "scanFragmentFactoryWrapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScanFragmentFactoryWrapper;", "automationScanFragmentFactoryWrapper", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/automation/AutomationScanFragmentFactoryWrapper;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {MrtdCoreModule.class, NfcPassportCountriesModule.class, RemoteModule.class, CoroutineContextModule.class, ResourceConfigurationModule.class, IdDocumentCaptureApiServiceModule.class, SessionStatusModule.class, CommonModule.class, CountryHelperModule.class, IdDocumentCaptureViewModelModule.class})
public class IdDocumentCaptureModule {
    private final DocumentCaptureConfiguration featureConfiguration;

    public IdDocumentCaptureModule(DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    @Provides
    /* JADX INFO: renamed from: featureConfiguration, reason: from getter */
    public DocumentCaptureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Provides
    public IDocumentScanDependenciesProvider providesCoreScanDependenciesProvider(IdDocumentScanDependenciesProvider idDocumentScanDependenciesProvider) {
        Intrinsics.checkNotNullParameter(idDocumentScanDependenciesProvider, "idDocumentScanDependenciesProvider");
        return idDocumentScanDependenciesProvider;
    }

    @Provides
    public IDocumentSelectionDependenciesProvider providesCoreSelectionDependenciesProvider(IdDocumentSelectionDependenciesProvider idDocumentSelectionDependenciesProvider) {
        Intrinsics.checkNotNullParameter(idDocumentSelectionDependenciesProvider, "idDocumentSelectionDependenciesProvider");
        return idDocumentSelectionDependenciesProvider;
    }

    @Provides
    public IDocumentUploadDependenciesProvider providesCoreUploadDependenciesProvider(IdDocumentUploadDependenciesProvider idDocumentUploadDependenciesProvider) {
        Intrinsics.checkNotNullParameter(idDocumentUploadDependenciesProvider, "idDocumentUploadDependenciesProvider");
        return idDocumentUploadDependenciesProvider;
    }

    @Provides
    @Singleton
    public IScanFragmentFactoryWrapper providesScanFragmentFactory(ScanFragmentFactoryWrapper scanFragmentFactoryWrapper, AutomationScanFragmentFactoryWrapper automationScanFragmentFactoryWrapper) {
        Intrinsics.checkNotNullParameter(scanFragmentFactoryWrapper, "scanFragmentFactoryWrapper");
        Intrinsics.checkNotNullParameter(automationScanFragmentFactoryWrapper, "automationScanFragmentFactoryWrapper");
        return Intrinsics.areEqual("production", "automation") ? automationScanFragmentFactoryWrapper : scanFragmentFactoryWrapper;
    }
}
