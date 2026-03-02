package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.data.DocumentResourceConfigurationRepository;
import com.yoti.mobile.android.remote.p075di.RemoteModule;
import com.yoti.mobile.android.yotidocs.common.p079di.CommonModule;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.core.p085di.ResourceConfigurationModule;
import com.yoti.mobile.android.yotisdkcore.core.p085di.SessionStatusModule;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0017J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/DocumentCaptureCoreModule;", "", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "providesDocumentCaptureConfiguration", "providesDocumentResourceConfigurationRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "repository", "Lcom/yoti/mobile/android/documentcapture/data/DocumentResourceConfigurationRepository;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module(includes = {ResourceConfigurationModule.class, SelectionModule.class, ScanModule.class, UploadModule.class, RemoteModule.class, ViewModelModule.class, SessionStatusModule.class, CommonModule.class})
public class DocumentCaptureCoreModule {
    private final DocumentCaptureConfiguration featureConfiguration;

    public DocumentCaptureCoreModule(DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    @Provides
    @Singleton
    /* JADX INFO: renamed from: providesDocumentCaptureConfiguration, reason: from getter */
    public DocumentCaptureConfiguration getFeatureConfiguration() {
        return this.featureConfiguration;
    }

    @Provides
    @Singleton
    public ResourceConfigurationRepository<DocumentResourceConfigEntity> providesDocumentResourceConfigurationRepository(DocumentResourceConfigurationRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return repository;
    }
}
