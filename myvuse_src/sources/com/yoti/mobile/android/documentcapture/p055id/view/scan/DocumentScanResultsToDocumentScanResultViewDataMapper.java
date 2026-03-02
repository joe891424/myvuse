package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultsToDocumentScanResultViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultsToDocumentScanResultViewDataMapper$MapperParams;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultViewData;", "()V", "map", "from", "MapperParams", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentScanResultsToDocumentScanResultViewDataMapper implements Mapper<MapperParams, DocumentScanResultViewData> {

    @Metadata(m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentScanResultsToDocumentScanResultViewDataMapper$MapperParams;", "", "scanConfigData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "resultFront", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "resultBack", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;)V", "getResultBack", "()Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "getResultFront", "getScanConfigData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MapperParams {
        private final DocumentCaptureResult resultBack;
        private final DocumentCaptureResult resultFront;
        private final IdScanConfigurationViewData scanConfigData;

        public MapperParams(IdScanConfigurationViewData scanConfigData, DocumentCaptureResult resultFront, DocumentCaptureResult documentCaptureResult) {
            Intrinsics.checkNotNullParameter(scanConfigData, "scanConfigData");
            Intrinsics.checkNotNullParameter(resultFront, "resultFront");
            this.scanConfigData = scanConfigData;
            this.resultFront = resultFront;
            this.resultBack = documentCaptureResult;
        }

        public final DocumentCaptureResult getResultBack() {
            return this.resultBack;
        }

        public final DocumentCaptureResult getResultFront() {
            return this.resultFront;
        }

        public final IdScanConfigurationViewData getScanConfigData() {
            return this.scanConfigData;
        }
    }

    @Inject
    public DocumentScanResultsToDocumentScanResultViewDataMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentScanResultViewData map(MapperParams from) {
        Intrinsics.checkNotNullParameter(from, "from");
        IdScanConfigurationViewData scanConfigData = from.getScanConfigData();
        return new DocumentScanResultViewData(scanConfigData.getResourceId(), scanConfigData.getCountryIso3Code(), scanConfigData.getDocumentType(), scanConfigData.getOcrRequired(), scanConfigData.getNfcAvailable(), null, CollectionsKt.listOfNotNull((Object[]) new DocumentCaptureResult[]{from.getResultFront(), from.getResultBack()}));
    }
}
