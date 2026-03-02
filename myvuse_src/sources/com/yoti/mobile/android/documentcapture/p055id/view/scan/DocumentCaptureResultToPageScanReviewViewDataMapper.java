package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import android.graphics.RectF;
import com.yoti.mobile.android.documentcapture.p055id.domain.NfcFlowType;
import com.yoti.mobile.android.documentscan.model.DocumentCaptureResult;
import com.yoti.mobile.android.documentscan.model.result.MetaData;
import com.yoti.mobile.android.remote.RemoteDefsKt;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentCaptureResultToPageScanReviewViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentCaptureResultToPageScanReviewViewDataMapper$MapperParams;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/PageScanReviewViewData;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "isLastPage", "", "scanConfigData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", RemoteDefsKt.PATH_PAGE_INDEX_KEY, "", "map", "from", "MapperParams", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentCaptureResultToPageScanReviewViewDataMapper implements Mapper<MapperParams, PageScanReviewViewData> {
    private final DocumentCaptureConfiguration featureConfiguration;

    @Metadata(m5597d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/DocumentCaptureResultToPageScanReviewViewDataMapper$MapperParams;", "", "scanConfigData", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "result", "Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", RemoteDefsKt.PATH_PAGE_INDEX_KEY, "", "nfcFlowType", "Lcom/yoti/mobile/android/documentcapture/id/domain/NfcFlowType;", "(Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;ILcom/yoti/mobile/android/documentcapture/id/domain/NfcFlowType;)V", "getNfcFlowType", "()Lcom/yoti/mobile/android/documentcapture/id/domain/NfcFlowType;", "getPageIndex", "()I", "getResult", "()Lcom/yoti/mobile/android/documentscan/model/DocumentCaptureResult;", "getScanConfigData", "()Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class MapperParams {
        private final NfcFlowType nfcFlowType;
        private final int pageIndex;
        private final DocumentCaptureResult result;
        private final IdScanConfigurationViewData scanConfigData;

        public MapperParams(IdScanConfigurationViewData scanConfigData, DocumentCaptureResult result, int i, NfcFlowType nfcFlowType) {
            Intrinsics.checkNotNullParameter(scanConfigData, "scanConfigData");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(nfcFlowType, "nfcFlowType");
            this.scanConfigData = scanConfigData;
            this.result = result;
            this.pageIndex = i;
            this.nfcFlowType = nfcFlowType;
        }

        public final NfcFlowType getNfcFlowType() {
            return this.nfcFlowType;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final DocumentCaptureResult getResult() {
            return this.result;
        }

        public final IdScanConfigurationViewData getScanConfigData() {
            return this.scanConfigData;
        }
    }

    @Inject
    public DocumentCaptureResultToPageScanReviewViewDataMapper(DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.featureConfiguration = featureConfiguration;
    }

    private final boolean isLastPage(IdScanConfigurationViewData scanConfigData, int pageIndex) {
        return pageIndex == scanConfigData.getScanConfigurations().size() - 1;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public PageScanReviewViewData map(MapperParams from) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(from, "from");
        MetaData metaData = from.getResult().getMetaData();
        String mainImage = metaData != null ? metaData.getMainImage() : null;
        MetaData metaData2 = from.getResult().getMetaData();
        RectF cropRegion = metaData2 != null ? metaData2.getCropRegion() : null;
        if (mainImage == null) {
            throw new IllegalArgumentException("MainImage is null".toString());
        }
        if (cropRegion == null) {
            throw new IllegalArgumentException("CropRegion is null".toString());
        }
        boolean zIsLastPage = isLastPage(from.getScanConfigData(), from.getPageIndex());
        return new PageScanReviewViewData(mainImage, cropRegion, from.getScanConfigData().getDocumentName(), zIsLastPage, zIsLastPage && from.getNfcFlowType() != NfcFlowType.NEVER, from.getScanConfigData().getConsent(), !this.featureConfiguration.getIsValidationAndGuidanceEnabled());
    }
}
