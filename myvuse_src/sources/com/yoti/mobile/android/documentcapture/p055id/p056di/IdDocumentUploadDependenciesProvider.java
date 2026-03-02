package com.yoti.mobile.android.documentcapture.p055id.p056di;

import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider;
import com.yoti.mobile.android.documentcapture.p055id.data.IdDocumentRepository;
import com.yoti.mobile.android.documentcapture.p055id.view.navigation.IdDocumentUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.IdDocumentScanResultViewDataToEntityMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToSessionStatusTypeMapper;
import com.yoti.mobile.android.documentcapture.p055id.view.upload.UploadErrorToViewDataMapper;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00130&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006)"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/di/IdDocumentUploadDependenciesProvider;", "Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "navigatorProvider", "Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;", "docRepository", "Lcom/yoti/mobile/android/documentcapture/id/data/IdDocumentRepository;", "documentViewDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/IdDocumentScanResultViewDataToEntityMapper;", "uploadErrorToFailureMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/UploadErrorToViewDataMapper;", "uploadErrorToSessionStatusTypeMapper", "Lcom/yoti/mobile/android/documentcapture/id/view/upload/UploadErrorToSessionStatusTypeMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/view/navigation/IdDocumentUploadNavigatorProvider;Lcom/yoti/mobile/android/documentcapture/id/data/IdDocumentRepository;Lcom/yoti/mobile/android/documentcapture/id/view/upload/IdDocumentScanResultViewDataToEntityMapper;Lcom/yoti/mobile/android/documentcapture/id/view/upload/UploadErrorToViewDataMapper;Lcom/yoti/mobile/android/documentcapture/id/view/upload/UploadErrorToSessionStatusTypeMapper;)V", "documentCleanupInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "getDocumentCleanupInteractor", "()Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "documentRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "getDocumentRepository", "()Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "uploadErrorToSessionStatusMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "getUploadErrorToSessionStatusMapper", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "uploadErrorToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getUploadErrorToViewDataMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "uploadNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "getUploadNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "viewDataToDocumentEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "getViewDataToDocumentEntityMapper", "()Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdDocumentUploadDependenciesProvider implements IDocumentUploadDependenciesProvider {
    private final IDocumentCleanupInteractor documentCleanupInteractor;
    private final IDocumentRepository<IDocumentEntity> documentRepository;
    private final UploadErrorToViewDataMapper uploadErrorToFailureMapper;
    private final UploadErrorToSessionStatusTypeMapper uploadErrorToSessionStatusTypeMapper;
    private final IUploadNavigatorProvider<IDocumentViewData> uploadNavigatorProvider;
    private final SuspendMapper<IDocumentViewData, IDocumentEntity> viewDataToDocumentEntityMapper;

    @Inject
    public IdDocumentUploadDependenciesProvider(IdDocumentUploadNavigatorProvider navigatorProvider, IdDocumentRepository docRepository, IdDocumentScanResultViewDataToEntityMapper documentViewDataToEntityMapper, UploadErrorToViewDataMapper uploadErrorToFailureMapper, UploadErrorToSessionStatusTypeMapper uploadErrorToSessionStatusTypeMapper) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        Intrinsics.checkNotNullParameter(docRepository, "docRepository");
        Intrinsics.checkNotNullParameter(documentViewDataToEntityMapper, "documentViewDataToEntityMapper");
        Intrinsics.checkNotNullParameter(uploadErrorToFailureMapper, "uploadErrorToFailureMapper");
        Intrinsics.checkNotNullParameter(uploadErrorToSessionStatusTypeMapper, "uploadErrorToSessionStatusTypeMapper");
        this.uploadErrorToFailureMapper = uploadErrorToFailureMapper;
        this.uploadErrorToSessionStatusTypeMapper = uploadErrorToSessionStatusTypeMapper;
        this.viewDataToDocumentEntityMapper = documentViewDataToEntityMapper;
        this.documentRepository = docRepository;
        this.uploadNavigatorProvider = navigatorProvider;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public IDocumentCleanupInteractor getDocumentCleanupInteractor() {
        return this.documentCleanupInteractor;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public IDocumentRepository<IDocumentEntity> getDocumentRepository() {
        return this.documentRepository;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public ErrorToSessionStatusTypeMapper getUploadErrorToSessionStatusMapper() {
        return this.uploadErrorToSessionStatusTypeMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public Mapper<Throwable, YdsFailure> getUploadErrorToViewDataMapper() {
        return this.uploadErrorToFailureMapper;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public IUploadNavigatorProvider<IDocumentViewData> getUploadNavigatorProvider() {
        return this.uploadNavigatorProvider;
    }

    @Override // com.yoti.mobile.android.documentcapture.p054di.IDocumentUploadDependenciesProvider
    public SuspendMapper<IDocumentViewData, IDocumentEntity> getViewDataToDocumentEntityMapper() {
        return this.viewDataToDocumentEntityMapper;
    }
}
