package com.yoti.mobile.android.documentcapture.p055id.view.scan;

import com.yoti.mobile.android.documentcapture.p055id.domain.model.IdDocumentScanConfigurationEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.NfcConfigTypeEntity;
import com.yoti.mobile.android.documentcapture.p055id.domain.model.PageScanConfigurationEntity;
import com.yoti.mobile.android.documentscan.model.DocumentScanDetailedPageConfig;
import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.view.DocumentCaptureConfiguration;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeEntityToViewDataMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationEntityToViewDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/documentcapture/id/domain/model/IdDocumentScanConfigurationEntity;", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/IdScanConfigurationViewData;", "documentTypeEntityToViewDataMapper", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;", "featureConfiguration", "Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;", "(Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeEntityToViewDataMapper;Lcom/yoti/mobile/android/yotisdkcore/core/view/DocumentCaptureConfiguration;)V", "map", "from", "mapPagesFromEntity", "", "Lcom/yoti/mobile/android/documentscan/model/DocumentScanDetailedPageConfig;", "documentScanConfigEntity", "mapScannableDocumentFromDocumentEntity", "Lcom/yoti/mobile/android/documentcapture/id/view/scan/ScannableDocument;", "documentTypeEntity", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class IdScanConfigurationEntityToViewDataMapper implements Mapper<IdDocumentScanConfigurationEntity, IdScanConfigurationViewData> {
    private final DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper;
    private final DocumentCaptureConfiguration featureConfiguration;

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentResourceConfigEntity.DocumentTypeEntity.values().length];
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PASSPORT.ordinal()] = 1;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.DRIVING_LICENCE.ordinal()] = 2;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.NATIONAL_ID.ordinal()] = 3;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.STATE_ID.ordinal()] = 4;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.MYKAD.ordinal()] = 5;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.AADHAAR.ordinal()] = 6;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PAN.ordinal()] = 7;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.SSS_ID_CARD.ordinal()] = 8;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.POSTAL_ID.ordinal()] = 9;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.RESIDENCE_PERMIT.ordinal()] = 10;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PROFESSIONAL_ID.ordinal()] = 11;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.VOTER_ID.ordinal()] = 12;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.HEALTH_CARD_QUEBEC.ordinal()] = 13;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.NEXUS_CARD.ordinal()] = 14;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PHILSYS_ID.ordinal()] = 15;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.UMID.ordinal()] = 16;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.YOUNG_SCOT_CARD.ordinal()] = 17;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.INDIAN_STATUS_CARD.ordinal()] = 18;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.CITIZEN_CARD.ordinal()] = 19;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.POST_OFFICE_PASS_CARD.ordinal()] = 20;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.HEALTH_CARD.ordinal()] = 21;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public IdScanConfigurationEntityToViewDataMapper(DocumentTypeEntityToViewDataMapper documentTypeEntityToViewDataMapper, DocumentCaptureConfiguration featureConfiguration) {
        Intrinsics.checkNotNullParameter(documentTypeEntityToViewDataMapper, "documentTypeEntityToViewDataMapper");
        Intrinsics.checkNotNullParameter(featureConfiguration, "featureConfiguration");
        this.documentTypeEntityToViewDataMapper = documentTypeEntityToViewDataMapper;
        this.featureConfiguration = featureConfiguration;
    }

    private final List<DocumentScanDetailedPageConfig> mapPagesFromEntity(IdDocumentScanConfigurationEntity documentScanConfigEntity) {
        ScannableDocument scannableDocumentMapScannableDocumentFromDocumentEntity = mapScannableDocumentFromDocumentEntity(documentScanConfigEntity.getDocumentType());
        List<PageScanConfigurationEntity> pages = documentScanConfigEntity.getPages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        int i = 0;
        for (Object obj : pages) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PageScanConfigurationEntity pageScanConfigurationEntity = (PageScanConfigurationEntity) obj;
            arrayList.add(new DocumentScanDetailedPageConfig(scannableDocumentMapScannableDocumentFromDocumentEntity.getConfigKey(), pageScanConfigurationEntity.getRecognizer(), i, pageScanConfigurationEntity.getNumberOfFrames(), true, true, 20000L, pageScanConfigurationEntity.getOcrSupported(), scannableDocumentMapScannableDocumentFromDocumentEntity.getRatio()));
            i = i2;
        }
        return arrayList;
    }

    public final ScannableDocument mapScannableDocumentFromDocumentEntity(DocumentResourceConfigEntity.DocumentTypeEntity documentTypeEntity) {
        Intrinsics.checkNotNullParameter(documentTypeEntity, "documentTypeEntity");
        switch (WhenMappings.$EnumSwitchMapping$0[documentTypeEntity.ordinal()]) {
            case 1:
                return ScannableDocument.PASSPORT;
            case 2:
                return ScannableDocument.DRIVING_LICENCE;
            case 3:
                return ScannableDocument.NATIONAL_ID;
            case 4:
                return ScannableDocument.STATE_ID;
            case 5:
                return ScannableDocument.MYKAD;
            case 6:
                return ScannableDocument.AADHAAR;
            case 7:
                return ScannableDocument.PAN;
            case 8:
                return ScannableDocument.SSS_ID;
            case 9:
                return ScannableDocument.POSTAL_ID;
            case 10:
                return ScannableDocument.RESIDENCE_PERMIT;
            case 11:
                return ScannableDocument.PROFESSIONAL_ID;
            case 12:
                return ScannableDocument.VOTER_ID;
            case 13:
                return ScannableDocument.HEALTH_CARD_QUEBEC;
            case 14:
                return ScannableDocument.NEXUS_CARD;
            case 15:
                return ScannableDocument.PHILSYS_ID;
            case 16:
                return ScannableDocument.UMID;
            case 17:
                return ScannableDocument.YOUNG_SCOT_CARD;
            case 18:
                return ScannableDocument.INDIAN_STATUS_CARD;
            case 19:
                return ScannableDocument.CITIZEN_CARD;
            case 20:
                return ScannableDocument.POST_OFFICE_PASS_CARD;
            case 21:
                return ScannableDocument.HEALTH_CARD;
            default:
                return ScannableDocument.UNDEFINED;
        }
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public IdScanConfigurationViewData map(IdDocumentScanConfigurationEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new IdScanConfigurationViewData(from.getResourceId(), from.getCountryIso3Code(), this.documentTypeEntityToViewDataMapper.map(from.getDocumentType()), mapPagesFromEntity(from), this.featureConfiguration.getUiSessionConfiguration().getLogo(), from.getBlinkIdKey(), from.getBlinkIdLicensee(), from.getOcrRequired(), from.getNfcConfigType() == NfcConfigTypeEntity.AVAILABLE, from.getConsentRequired() ? ConsentViewData.INSTANCE : null);
    }
}
