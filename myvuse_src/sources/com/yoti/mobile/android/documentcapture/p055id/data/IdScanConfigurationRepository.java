package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.data.remote.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.ScanConfigurationService;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ChipPresentStatus;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ScanConfiguration;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentScanConfigurationEntity;
import com.yoti.mobile.android.remote.exception.RemoteExceptionToEntityMapper;
import com.yoti.mobile.android.yotidocs.common.extension.SingleKt;
import com.yoti.mobile.android.yotisdkcore.core.data.model.ResourceConfiguration;
import com.yoti.mobile.android.yotisdkcore.core.data.model.StateType;
import com.yoti.mobile.android.yotisdkcore.core.data.model.Task;
import com.yoti.mobile.android.yotisdkcore.core.data.repository.IResourceConfigurationCacheDataStore;
import com.yoti.mobile.android.yotisdkcore.core.p085di.RequirementId;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeEntityToDataMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/IdScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanConfigurationEntity;", "configurationService", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/ScanConfigurationService;", "resourceConfigDataSource", "Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;", "requirementId", "", "scanConfigurationDataToEntityMapper", "Lcom/yoti/mobile/android/documentcapture/id/data/ScanConfigurationDataToEntityMapper;", "documentTypeEntityToDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "exceptionToEntityMapper", "Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/ScanConfigurationService;Lcom/yoti/mobile/android/yotisdkcore/core/data/repository/IResourceConfigurationCacheDataStore;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/data/ScanConfigurationDataToEntityMapper;Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;Lcom/yoti/mobile/android/remote/exception/RemoteExceptionToEntityMapper;)V", "getScanConfiguration", "Lio/reactivex/Single;", "countryIso3Code", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdScanConfigurationRepository implements IScanConfigurationRepository<IdDocumentScanConfigurationEntity> {
    private final ScanConfigurationService configurationService;
    private final DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper;
    private final RemoteExceptionToEntityMapper exceptionToEntityMapper;
    private final String requirementId;
    private final IResourceConfigurationCacheDataStore resourceConfigDataSource;
    private final ScanConfigurationDataToEntityMapper scanConfigurationDataToEntityMapper;

    @Inject
    public IdScanConfigurationRepository(ScanConfigurationService configurationService, IResourceConfigurationCacheDataStore resourceConfigDataSource, @RequirementId String requirementId, ScanConfigurationDataToEntityMapper scanConfigurationDataToEntityMapper, DocumentTypeEntityToDataMapper documentTypeEntityToDataMapper, RemoteExceptionToEntityMapper exceptionToEntityMapper) {
        Intrinsics.checkNotNullParameter(configurationService, "configurationService");
        Intrinsics.checkNotNullParameter(resourceConfigDataSource, "resourceConfigDataSource");
        Intrinsics.checkNotNullParameter(requirementId, "requirementId");
        Intrinsics.checkNotNullParameter(scanConfigurationDataToEntityMapper, "scanConfigurationDataToEntityMapper");
        Intrinsics.checkNotNullParameter(documentTypeEntityToDataMapper, "documentTypeEntityToDataMapper");
        Intrinsics.checkNotNullParameter(exceptionToEntityMapper, "exceptionToEntityMapper");
        this.configurationService = configurationService;
        this.resourceConfigDataSource = resourceConfigDataSource;
        this.requirementId = requirementId;
        this.scanConfigurationDataToEntityMapper = scanConfigurationDataToEntityMapper;
        this.documentTypeEntityToDataMapper = documentTypeEntityToDataMapper;
        this.exceptionToEntityMapper = exceptionToEntityMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getScanConfiguration$lambda-2, reason: not valid java name */
    public static final ScanConfiguration m6808getScanConfiguration$lambda2(IdScanConfigurationRepository this$0, ScanConfiguration scanConfig) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(scanConfig, "scanConfig");
        ResourceConfiguration resourceConfiguration = this$0.resourceConfigDataSource.getResourceConfiguration();
        ScanConfiguration scanConfigurationCopy$default = ScanConfiguration.copy$default(scanConfig, null, null, null, resourceConfiguration.getIgnoreNfcScanConfiguration() ? ChipPresentStatus.UNKNOWN : scanConfig.getChipPresent(), false, null, 55, null);
        BlinkIdLicenceProvider blinkIdLicenceProvider = BlinkIdLicenceProvider.INSTANCE;
        scanConfigurationCopy$default.setBlinkIdKey(blinkIdLicenceProvider.getLicence());
        scanConfigurationCopy$default.setBlinkIdLicensee(blinkIdLicenceProvider.getLicenseeName());
        Iterator<T> it2 = resourceConfiguration.getTasks().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            Task task = (Task) next;
            if (task.getType() == Task.TaskType.ID_DOCUMENT_TEXT_DATA_EXTRACTION && task.getState() == StateType.REQUIRED) {
                break;
            }
        }
        scanConfigurationCopy$default.setOcrRequired(next != null);
        return scanConfigurationCopy$default;
    }

    @Override // com.yoti.mobile.android.documentcapture.domain.IScanConfigurationRepository
    public Single<IdDocumentScanConfigurationEntity> getScanConfiguration(String countryIso3Code, DocumentResourceConfigEntity.DocumentTypeEntity documentType) {
        Intrinsics.checkNotNullParameter(countryIso3Code, "countryIso3Code");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Single<R> map = this.configurationService.execute(new ScanConfigurationRequestParams(this.requirementId, countryIso3Code, this.documentTypeEntityToDataMapper.map(documentType))).map(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.IdScanConfigurationRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return IdScanConfigurationRepository.m6808getScanConfiguration$lambda2(this.f$0, (ScanConfiguration) obj);
            }
        });
        final ScanConfigurationDataToEntityMapper scanConfigurationDataToEntityMapper = this.scanConfigurationDataToEntityMapper;
        Single map2 = map.map(new Function() { // from class: com.yoti.mobile.android.documentcapture.id.data.IdScanConfigurationRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return scanConfigurationDataToEntityMapper.map((ScanConfiguration) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "configurationService\n   …nDataToEntityMapper::map)");
        return SingleKt.onErrorMapToErrorEntity(map2, this.exceptionToEntityMapper);
    }
}
