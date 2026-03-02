package com.yoti.mobile.android.documentcapture.domain;

import com.yoti.mobile.android.yotidocs.common.SingleUseCase;
import com.yoti.mobile.android.yotisdkcore.core.data.ResourceConfigurationRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import io.branch.rnbranch.RNBranchModule;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0015\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/domain/GetDocumentCaptureConfigurationInteractor;", "Lcom/yoti/mobile/android/yotidocs/common/SingleUseCase;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity;", "Ljava/lang/Void;", "documentResourceRepository", "Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/ResourceConfigurationRepository;)V", "buildUseCase", "Lio/reactivex/Single;", RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS, "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GetDocumentCaptureConfigurationInteractor extends SingleUseCase<DocumentResourceConfigEntity, Void> {
    private final ResourceConfigurationRepository<DocumentResourceConfigEntity> documentResourceRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public GetDocumentCaptureConfigurationInteractor(ResourceConfigurationRepository<DocumentResourceConfigEntity> documentResourceRepository) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(documentResourceRepository, "documentResourceRepository");
        this.documentResourceRepository = documentResourceRepository;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.SingleUseCase
    public Single<DocumentResourceConfigEntity> buildUseCase(Void params) {
        return this.documentResourceRepository.getResourceConfiguration();
    }
}
