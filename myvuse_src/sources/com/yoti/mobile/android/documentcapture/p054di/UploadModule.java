package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotidocs.common.test.EspressoOpen;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@EspressoOpen
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0017J\b\u0010\n\u001a\u00020\u000bH\u0017J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0017J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0017J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0014H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/UploadModule;", "", "dependenciesProvider", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "(Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;)V", "providesDocumentCleanupInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "providesDocumentRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "providesUploadErrorToSessionStatusMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "providesUploadErrorToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "providesUploadNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "providesViewDataToUploadableEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
@Module
public class UploadModule {
    private final IDocumentUploadDependenciesProvider dependenciesProvider;

    public UploadModule(IDocumentUploadDependenciesProvider dependenciesProvider) {
        Intrinsics.checkNotNullParameter(dependenciesProvider, "dependenciesProvider");
        this.dependenciesProvider = dependenciesProvider;
    }

    @Provides
    public IDocumentCleanupInteractor providesDocumentCleanupInteractor() {
        return this.dependenciesProvider.getDocumentCleanupInteractor();
    }

    @Provides
    @Singleton
    public IDocumentRepository<IDocumentEntity> providesDocumentRepository() {
        return this.dependenciesProvider.getDocumentRepository();
    }

    @Provides
    @DocumentUpload
    public ErrorToSessionStatusTypeMapper providesUploadErrorToSessionStatusMapper() {
        return this.dependenciesProvider.getUploadErrorToSessionStatusMapper();
    }

    @Provides
    @DocumentUpload
    public Mapper<Throwable, YdsFailure> providesUploadErrorToViewDataMapper() {
        return this.dependenciesProvider.getUploadErrorToViewDataMapper();
    }

    @Provides
    @Singleton
    public IUploadNavigatorProvider<IDocumentViewData> providesUploadNavigatorProvider() {
        return this.dependenciesProvider.getUploadNavigatorProvider();
    }

    @Provides
    public SuspendMapper<IDocumentViewData, IDocumentEntity> providesViewDataToUploadableEntityMapper() {
        return this.dependenciesProvider.getViewDataToDocumentEntityMapper();
    }
}
