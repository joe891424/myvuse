package com.yoti.mobile.android.documentcapture.p055id.domain;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentEntity;
import com.yoti.mobile.android.mrtd.data.NfcStateRepository;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/domain/GetCanPerformNfcReadInteractor;", "", "nfcStateRepository", "Lcom/yoti/mobile/android/mrtd/data/NfcStateRepository;", "(Lcom/yoti/mobile/android/mrtd/data/NfcStateRepository;)V", "invoke", "", "scanDocumentEntity", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentEntity;", "isNfcSupportedByBackend", "scanConfig", "isNfcSupportedByClient", "isNfcSupportedByDevice", "isNfcSupportedByScan", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class GetCanPerformNfcReadInteractor {
    private final NfcStateRepository nfcStateRepository;

    @Inject
    public GetCanPerformNfcReadInteractor(NfcStateRepository nfcStateRepository) {
        Intrinsics.checkNotNullParameter(nfcStateRepository, "nfcStateRepository");
        this.nfcStateRepository = nfcStateRepository;
    }

    private final boolean isNfcSupportedByBackend(IdDocumentEntity scanConfig) {
        return scanConfig.getNfcAvailable();
    }

    private final boolean isNfcSupportedByClient(IdDocumentEntity scanConfig) {
        return scanConfig.getResourceInfo().getDocumentType() == DocumentResourceConfigEntity.DocumentTypeEntity.PASSPORT;
    }

    private final boolean isNfcSupportedByDevice() {
        return this.nfcStateRepository.getState().getHasAdapter();
    }

    private final boolean isNfcSupportedByScan(IdDocumentEntity scanConfig) {
        return scanConfig.isOcrDataValidForNfcRead();
    }

    public final boolean invoke(IdDocumentEntity scanDocumentEntity) {
        Intrinsics.checkNotNullParameter(scanDocumentEntity, "scanDocumentEntity");
        return isNfcSupportedByBackend(scanDocumentEntity) && isNfcSupportedByClient(scanDocumentEntity) && isNfcSupportedByDevice() && isNfcSupportedByScan(scanDocumentEntity);
    }
}
