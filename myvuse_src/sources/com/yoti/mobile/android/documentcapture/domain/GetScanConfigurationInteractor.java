package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.documentcapture.domain.model.IScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.domain.model.ScanConfigurationRequestParams;
import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001a\b\u0007\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/GetScanConfigurationInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/SingleUseCase;", "Lcom/yoti/mobile/android/documentcapture/domain/model/IScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/domain/model/ScanConfigurationRequestParams;", "configurationRepository", "Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/yoti/mobile/android/documentcapture/domain/IScanConfigurationRepository;)V", "buildUseCase", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GetScanConfigurationInteractor extends SingleUseCase<IScanConfigurationEntity, ScanConfigurationRequestParams> {
    private final IScanConfigurationRepository<IScanConfigurationEntity> configurationRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public GetScanConfigurationInteractor(IScanConfigurationRepository<IScanConfigurationEntity> configurationRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        this.configurationRepository = configurationRepository;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.SingleUseCase
    public Single<IScanConfigurationEntity> buildUseCase(ScanConfigurationRequestParams params) {
        if (params != null) {
            return this.configurationRepository.getScanConfiguration(params.getIso3Code(), params.getDocumentType());
        }
        Single<IScanConfigurationEntity> singleError = Single.error(new IllegalArgumentException("CountryEntity and document type are mandatory to request scan configuration!"));
        Intrinsics.checkNotNullExpressionValue(singleError, "error(\n                I…              )\n        )");
        return singleError;
    }
}
