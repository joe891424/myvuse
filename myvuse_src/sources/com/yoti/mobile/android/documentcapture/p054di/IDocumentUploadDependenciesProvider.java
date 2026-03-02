package com.yoti.mobile.android.documentcapture.p054di;

import com.yoti.mobile.android.documentcapture.domain.IDocumentCleanupInteractor;
import com.yoti.mobile.android.documentcapture.domain.IDocumentRepository;
import com.yoti.mobile.android.documentcapture.domain.model.IDocumentEntity;
import com.yoti.mobile.android.documentcapture.view.navigation.IUploadNavigatorProvider;
import com.yoti.mobile.android.documentcapture.view.upload.IDocumentViewData;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotidocs.common.SuspendMapper;
import com.yoti.mobile.android.yotidocs.common.error.YdsFailure;
import com.yoti.mobile.android.yotisdkcore.core.data.ErrorToSessionStatusTypeMapper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/di/IDocumentUploadDependenciesProvider;", "", "documentCleanupInteractor", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "getDocumentCleanupInteractor", "()Lcom/yoti/mobile/android/documentcapture/domain/IDocumentCleanupInteractor;", "documentRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IDocumentEntity;", "getDocumentRepository", "()Lcom/yoti/mobile/android/documentcapture/domain/IDocumentRepository;", "uploadErrorToSessionStatusMapper", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "getUploadErrorToSessionStatusMapper", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/ErrorToSessionStatusTypeMapper;", "uploadErrorToViewDataMapper", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "", "Lcom/yoti/mobile/android/yotidocs/common/error/YdsFailure;", "getUploadErrorToViewDataMapper", "()Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "uploadNavigatorProvider", "Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "Lcom/yoti/mobile/android/documentcapture/view/upload/IDocumentViewData;", "getUploadNavigatorProvider", "()Lcom/yoti/mobile/android/documentcapture/view/navigation/IUploadNavigatorProvider;", "viewDataToDocumentEntityMapper", "Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "getViewDataToDocumentEntityMapper", "()Lcom/yoti/mobile/android/yotidocs/common/SuspendMapper;", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public interface IDocumentUploadDependenciesProvider {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DefaultImpls {
        public static ErrorToSessionStatusTypeMapper getUploadErrorToSessionStatusMapper(IDocumentUploadDependenciesProvider iDocumentUploadDependenciesProvider) {
            return new ErrorToSessionStatusTypeMapper();
        }
    }

    IDocumentCleanupInteractor getDocumentCleanupInteractor();

    IDocumentRepository<IDocumentEntity> getDocumentRepository();

    ErrorToSessionStatusTypeMapper getUploadErrorToSessionStatusMapper();

    Mapper<Throwable, YdsFailure> getUploadErrorToViewDataMapper();

    IUploadNavigatorProvider<IDocumentViewData> getUploadNavigatorProvider();

    SuspendMapper<IDocumentViewData, IDocumentEntity> getViewDataToDocumentEntityMapper();
}
