package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.data;

import com.yoti.mobile.android.yotidocs.common.Mapper;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import com.yoti.mobile.android.yotisdkcore.feature.documentcapture.domain.DocumentResourceConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/data/DocumentTypeEntityToDataMapper;", "Lcom/yoti/mobile/android/yotidocs/common/Mapper;", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/domain/DocumentResourceConfigEntity$DocumentTypeEntity;", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "()V", "map", "from", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentTypeEntityToDataMapper implements Mapper<DocumentResourceConfigEntity.DocumentTypeEntity, DocumentType> {

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
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.UTILITY_BILL.ordinal()] = 22;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.COUNCIL_TAX_BILL.ordinal()] = 23;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PHONE_BILL.ordinal()] = 24;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.BANK_STATEMENT.ordinal()] = 25;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.MILITARY_CARD.ordinal()] = 26;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.SUPPLEMENTARY_PASS_CARD.ordinal()] = 27;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.FIREARMS_LICENCE.ordinal()] = 28;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH.ordinal()] = 29;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.BIRTH_CERTIFICATE.ordinal()] = 30;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.ADOPTION_CERTIFICATE.ordinal()] = 31;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.PAPER_DRIVING_LICENCE.ordinal()] = 32;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.MARRIAGE_CERTIFICATE.ordinal()] = 33;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.ACCOUNT_OPENING_LETTER.ordinal()] = 34;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.BENEFIT_STATEMENT.ordinal()] = 35;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.MORTGAGE_STATEMENT.ordinal()] = 36;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.FINANCIAL_STATEMENT.ordinal()] = 37;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.EMPLOYEE_TAX_FORM.ordinal()] = 38;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.EMPLOYMENT_SPONSORSHIP_LETTER.ordinal()] = 39;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.IMMIGRATION_DOCUMENT.ordinal()] = 40;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.EDUCATION_LETTER.ordinal()] = 41;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.DVLA_FORM.ordinal()] = 42;
            iArr[DocumentResourceConfigEntity.DocumentTypeEntity.UNKNOWN.ordinal()] = 43;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DocumentTypeEntityToDataMapper() {
    }

    @Override // com.yoti.mobile.android.yotidocs.common.Mapper
    public DocumentType map(DocumentResourceConfigEntity.DocumentTypeEntity from) {
        Intrinsics.checkNotNullParameter(from, "from");
        switch (WhenMappings.$EnumSwitchMapping$0[from.ordinal()]) {
            case 1:
                return DocumentType.PASSPORT;
            case 2:
                return DocumentType.DRIVING_LICENCE;
            case 3:
                return DocumentType.NATIONAL_ID;
            case 4:
                return DocumentType.STATE_ID;
            case 5:
                return DocumentType.MYKAD;
            case 6:
                return DocumentType.AADHAAR;
            case 7:
                return DocumentType.PAN;
            case 8:
                return DocumentType.SSS_ID_CARD;
            case 9:
                return DocumentType.POSTAL_ID;
            case 10:
                return DocumentType.RESIDENCE_PERMIT;
            case 11:
                return DocumentType.PROFESSIONAL_ID;
            case 12:
                return DocumentType.VOTER_ID;
            case 13:
                return DocumentType.HEALTH_CARD_QUEBEC;
            case 14:
                return DocumentType.NEXUS_CARD;
            case 15:
                return DocumentType.PHILSYS_ID;
            case 16:
                return DocumentType.UMID;
            case 17:
                return DocumentType.YOUNG_SCOT_CARD;
            case 18:
                return DocumentType.INDIAN_STATUS_CARD;
            case 19:
                return DocumentType.CITIZEN_CARD;
            case 20:
                return DocumentType.POST_OFFICE_PASS_CARD;
            case 21:
                return DocumentType.HEALTH_CARD;
            case 22:
                return DocumentType.UTILITY_BILL;
            case 23:
                return DocumentType.COUNCIL_TAX_BILL;
            case 24:
                return DocumentType.PHONE_BILL;
            case 25:
                return DocumentType.BANK_STATEMENT;
            case 26:
                return DocumentType.MILITARY_CARD;
            case 27:
                return DocumentType.SUPPLEMENTARY_PASS_CARD;
            case 28:
                return DocumentType.FIREARMS_LICENCE;
            case 29:
                return DocumentType.BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH;
            case 30:
                return DocumentType.BIRTH_CERTIFICATE;
            case 31:
                return DocumentType.ADOPTION_CERTIFICATE;
            case 32:
                return DocumentType.PAPER_DRIVING_LICENCE;
            case 33:
                return DocumentType.MARRIAGE_CERTIFICATE;
            case 34:
                return DocumentType.ACCOUNT_OPENING_LETTER;
            case 35:
                return DocumentType.BENEFIT_STATEMENT;
            case 36:
                return DocumentType.MORTGAGE_STATEMENT;
            case 37:
                return DocumentType.FINANCIAL_STATEMENT;
            case 38:
                return DocumentType.EMPLOYEE_TAX_FORM;
            case 39:
                return DocumentType.EMPLOYMENT_SPONSORSHIP_LETTER;
            case 40:
                return DocumentType.IMMIGRATION_DOCUMENT;
            case 41:
                return DocumentType.EDUCATION_LETTER;
            case 42:
                return DocumentType.DVLA_FORM;
            case 43:
                return DocumentType.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
