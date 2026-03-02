package com.yoti.mobile.android.documentcapture.view.selection;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/view/selection/DocumentTypeViewDataToEntityMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "()V", "map", "from", "documentcapture-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentTypeViewDataToEntityMapper implements Mapper<DocumentTypeViewData, DocumentResourceConfigEntity.DocumentTypeEntity> {

    @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentTypeViewData.values().length];
            iArr[DocumentTypeViewData.PASSPORT.ordinal()] = 1;
            iArr[DocumentTypeViewData.DRIVING_LICENCE.ordinal()] = 2;
            iArr[DocumentTypeViewData.NATIONAL_ID.ordinal()] = 3;
            iArr[DocumentTypeViewData.STATE_ID.ordinal()] = 4;
            iArr[DocumentTypeViewData.MYKAD.ordinal()] = 5;
            iArr[DocumentTypeViewData.AADHAAR.ordinal()] = 6;
            iArr[DocumentTypeViewData.PAN.ordinal()] = 7;
            iArr[DocumentTypeViewData.SSS_ID_CARD.ordinal()] = 8;
            iArr[DocumentTypeViewData.POSTAL_ID.ordinal()] = 9;
            iArr[DocumentTypeViewData.RESIDENCE_PERMIT.ordinal()] = 10;
            iArr[DocumentTypeViewData.PROFESSIONAL_ID.ordinal()] = 11;
            iArr[DocumentTypeViewData.VOTER_ID.ordinal()] = 12;
            iArr[DocumentTypeViewData.HEALTH_CARD_QUEBEC.ordinal()] = 13;
            iArr[DocumentTypeViewData.NEXUS_CARD.ordinal()] = 14;
            iArr[DocumentTypeViewData.PHILSYS_ID.ordinal()] = 15;
            iArr[DocumentTypeViewData.UMID.ordinal()] = 16;
            iArr[DocumentTypeViewData.YOUNG_SCOT_CARD.ordinal()] = 17;
            iArr[DocumentTypeViewData.INDIAN_STATUS_CARD.ordinal()] = 18;
            iArr[DocumentTypeViewData.CITIZEN_CARD.ordinal()] = 19;
            iArr[DocumentTypeViewData.POST_OFFICE_PASS_CARD.ordinal()] = 20;
            iArr[DocumentTypeViewData.HEALTH_CARD.ordinal()] = 21;
            iArr[DocumentTypeViewData.UTILITY_BILL.ordinal()] = 22;
            iArr[DocumentTypeViewData.COUNCIL_TAX_BILL.ordinal()] = 23;
            iArr[DocumentTypeViewData.PHONE_BILL.ordinal()] = 24;
            iArr[DocumentTypeViewData.BANK_STATEMENT.ordinal()] = 25;
            iArr[DocumentTypeViewData.MILITARY_CARD.ordinal()] = 26;
            iArr[DocumentTypeViewData.SUPPLEMENTARY_PASS_CARD.ordinal()] = 27;
            iArr[DocumentTypeViewData.FIREARMS_LICENCE.ordinal()] = 28;
            iArr[DocumentTypeViewData.BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH.ordinal()] = 29;
            iArr[DocumentTypeViewData.BIRTH_CERTIFICATE.ordinal()] = 30;
            iArr[DocumentTypeViewData.ADOPTION_CERTIFICATE.ordinal()] = 31;
            iArr[DocumentTypeViewData.PAPER_DRIVING_LICENCE.ordinal()] = 32;
            iArr[DocumentTypeViewData.MARRIAGE_CERTIFICATE.ordinal()] = 33;
            iArr[DocumentTypeViewData.ACCOUNT_OPENING_LETTER.ordinal()] = 34;
            iArr[DocumentTypeViewData.BENEFIT_STATEMENT.ordinal()] = 35;
            iArr[DocumentTypeViewData.MORTGAGE_STATEMENT.ordinal()] = 36;
            iArr[DocumentTypeViewData.FINANCIAL_STATEMENT.ordinal()] = 37;
            iArr[DocumentTypeViewData.EMPLOYEE_TAX_FORM.ordinal()] = 38;
            iArr[DocumentTypeViewData.EMPLOYMENT_SPONSORSHIP_LETTER.ordinal()] = 39;
            iArr[DocumentTypeViewData.IMMIGRATION_DOCUMENT.ordinal()] = 40;
            iArr[DocumentTypeViewData.EDUCATION_LETTER.ordinal()] = 41;
            iArr[DocumentTypeViewData.DVLA_FORM.ordinal()] = 42;
            iArr[DocumentTypeViewData.UNKNOWN.ordinal()] = 43;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DocumentTypeViewDataToEntityMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentResourceConfigEntity.DocumentTypeEntity map(DocumentTypeViewData from) {
        Intrinsics.checkNotNullParameter(from, "from");
        switch (WhenMappings.$EnumSwitchMapping$0[from.ordinal()]) {
            case 1:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PASSPORT;
            case 2:
                return DocumentResourceConfigEntity.DocumentTypeEntity.DRIVING_LICENCE;
            case 3:
                return DocumentResourceConfigEntity.DocumentTypeEntity.NATIONAL_ID;
            case 4:
                return DocumentResourceConfigEntity.DocumentTypeEntity.STATE_ID;
            case 5:
                return DocumentResourceConfigEntity.DocumentTypeEntity.MYKAD;
            case 6:
                return DocumentResourceConfigEntity.DocumentTypeEntity.AADHAAR;
            case 7:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PAN;
            case 8:
                return DocumentResourceConfigEntity.DocumentTypeEntity.SSS_ID_CARD;
            case 9:
                return DocumentResourceConfigEntity.DocumentTypeEntity.POSTAL_ID;
            case 10:
                return DocumentResourceConfigEntity.DocumentTypeEntity.RESIDENCE_PERMIT;
            case 11:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PROFESSIONAL_ID;
            case 12:
                return DocumentResourceConfigEntity.DocumentTypeEntity.VOTER_ID;
            case 13:
                return DocumentResourceConfigEntity.DocumentTypeEntity.HEALTH_CARD_QUEBEC;
            case 14:
                return DocumentResourceConfigEntity.DocumentTypeEntity.NEXUS_CARD;
            case 15:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PHILSYS_ID;
            case 16:
                return DocumentResourceConfigEntity.DocumentTypeEntity.UMID;
            case 17:
                return DocumentResourceConfigEntity.DocumentTypeEntity.YOUNG_SCOT_CARD;
            case 18:
                return DocumentResourceConfigEntity.DocumentTypeEntity.INDIAN_STATUS_CARD;
            case 19:
                return DocumentResourceConfigEntity.DocumentTypeEntity.CITIZEN_CARD;
            case 20:
                return DocumentResourceConfigEntity.DocumentTypeEntity.POST_OFFICE_PASS_CARD;
            case 21:
                return DocumentResourceConfigEntity.DocumentTypeEntity.HEALTH_CARD;
            case 22:
                return DocumentResourceConfigEntity.DocumentTypeEntity.UTILITY_BILL;
            case 23:
                return DocumentResourceConfigEntity.DocumentTypeEntity.COUNCIL_TAX_BILL;
            case 24:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PHONE_BILL;
            case 25:
                return DocumentResourceConfigEntity.DocumentTypeEntity.BANK_STATEMENT;
            case 26:
                return DocumentResourceConfigEntity.DocumentTypeEntity.MILITARY_CARD;
            case 27:
                return DocumentResourceConfigEntity.DocumentTypeEntity.SUPPLEMENTARY_PASS_CARD;
            case 28:
                return DocumentResourceConfigEntity.DocumentTypeEntity.FIREARMS_LICENCE;
            case 29:
                return DocumentResourceConfigEntity.DocumentTypeEntity.BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH;
            case 30:
                return DocumentResourceConfigEntity.DocumentTypeEntity.BIRTH_CERTIFICATE;
            case 31:
                return DocumentResourceConfigEntity.DocumentTypeEntity.ADOPTION_CERTIFICATE;
            case 32:
                return DocumentResourceConfigEntity.DocumentTypeEntity.PAPER_DRIVING_LICENCE;
            case 33:
                return DocumentResourceConfigEntity.DocumentTypeEntity.MARRIAGE_CERTIFICATE;
            case 34:
                return DocumentResourceConfigEntity.DocumentTypeEntity.ACCOUNT_OPENING_LETTER;
            case 35:
                return DocumentResourceConfigEntity.DocumentTypeEntity.BENEFIT_STATEMENT;
            case 36:
                return DocumentResourceConfigEntity.DocumentTypeEntity.MORTGAGE_STATEMENT;
            case 37:
                return DocumentResourceConfigEntity.DocumentTypeEntity.FINANCIAL_STATEMENT;
            case 38:
                return DocumentResourceConfigEntity.DocumentTypeEntity.EMPLOYEE_TAX_FORM;
            case 39:
                return DocumentResourceConfigEntity.DocumentTypeEntity.EMPLOYMENT_SPONSORSHIP_LETTER;
            case 40:
                return DocumentResourceConfigEntity.DocumentTypeEntity.IMMIGRATION_DOCUMENT;
            case 41:
                return DocumentResourceConfigEntity.DocumentTypeEntity.EDUCATION_LETTER;
            case 42:
                return DocumentResourceConfigEntity.DocumentTypeEntity.DVLA_FORM;
            case 43:
                return DocumentResourceConfigEntity.DocumentTypeEntity.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
