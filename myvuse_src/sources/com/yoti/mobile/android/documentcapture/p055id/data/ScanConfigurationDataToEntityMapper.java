package com.yoti.mobile.android.documentcapture.p055id.data;

import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ChipPresentStatus;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.Page;
import com.yoti.mobile.android.documentcapture.p055id.data.remote.model.ScanConfiguration;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.NfcConfigTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.PageScanConfigurationEntity;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data.DocumentTypeDataToEntityMapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/ScanConfigurationDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/ScanConfiguration;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanConfigurationEntity;", "documentTypeDataToEntityMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeDataToEntityMapper;)V", "map", "from", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class ScanConfigurationDataToEntityMapper implements Mapper<ScanConfiguration, IdDocumentScanConfigurationEntity> {
    private final DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChipPresentStatus.values().length];
            iArr[ChipPresentStatus.UNKNOWN.ordinal()] = 1;
            iArr[ChipPresentStatus.YES.ordinal()] = 2;
            iArr[ChipPresentStatus.NO.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ScanConfigurationDataToEntityMapper(DocumentTypeDataToEntityMapper documentTypeDataToEntityMapper) {
        Intrinsics.checkNotNullParameter(documentTypeDataToEntityMapper, "documentTypeDataToEntityMapper");
        this.documentTypeDataToEntityMapper = documentTypeDataToEntityMapper;
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public IdDocumentScanConfigurationEntity map(ScanConfiguration from) {
        NfcConfigTypeEntity nfcConfigTypeEntity;
        Intrinsics.checkNotNullParameter(from, "from");
        DocumentResourceConfigEntity.DocumentTypeEntity map = this.documentTypeDataToEntityMapper.map(from.getDocumentType());
        List<Page> pages = from.getPages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        for (Page page : pages) {
            arrayList.add(new PageScanConfigurationEntity(page.getScanConfiguration().getType(), page.getScanConfiguration().getRecognizer(), page.getScanConfiguration().getOcrSupported(), page.getScanConfiguration().getNumberOfFrames()));
        }
        int i = WhenMappings.$EnumSwitchMapping$0[from.getChipPresent().ordinal()];
        if (i == 1) {
            nfcConfigTypeEntity = NfcConfigTypeEntity.UNKNOWN;
        } else if (i == 2) {
            nfcConfigTypeEntity = NfcConfigTypeEntity.AVAILABLE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            nfcConfigTypeEntity = NfcConfigTypeEntity.NOT_AVAILABLE;
        }
        return new IdDocumentScanConfigurationEntity(from.getResourceId(), map, from.getIssuingCountryIso3Code(), nfcConfigTypeEntity, arrayList, from.getConsentRequired(), from.getBlinkIdKey(), from.getBlinkIdLicensee(), from.getOcrRequired());
    }
}
