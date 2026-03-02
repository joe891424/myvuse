package com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.yoti.mobile.android.yotisdkcore.C4957R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'STATE_ID' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001BB)\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bA¨\u0006C"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData;", "", "Landroid/os/Parcelable;", "documentNames", "", "Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData$DocumentName;", "implicitNationality", "", "showEducational", "(Ljava/lang/String;ILjava/util/List;ZZ)V", "getImplicitNationality", "()Z", "getShowEducational", "describeContents", "", "getDocumentName", "countryIso3Code", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "PASSPORT", "DRIVING_LICENCE", "NATIONAL_ID", "STATE_ID", "MYKAD", "AADHAAR", "PAN", "SSS_ID_CARD", "POSTAL_ID", "RESIDENCE_PERMIT", "PROFESSIONAL_ID", "VOTER_ID", "HEALTH_CARD_QUEBEC", "NEXUS_CARD", "PHILSYS_ID", "UMID", "YOUNG_SCOT_CARD", "INDIAN_STATUS_CARD", "CITIZEN_CARD", "POST_OFFICE_PASS_CARD", "HEALTH_CARD", "UTILITY_BILL", "COUNCIL_TAX_BILL", "PHONE_BILL", "BANK_STATEMENT", "MILITARY_CARD", "SUPPLEMENTARY_PASS_CARD", "FIREARMS_LICENCE", "BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH", "BIRTH_CERTIFICATE", "ADOPTION_CERTIFICATE", "PAPER_DRIVING_LICENCE", "MARRIAGE_CERTIFICATE", "ACCOUNT_OPENING_LETTER", "BENEFIT_STATEMENT", "MORTGAGE_STATEMENT", "FINANCIAL_STATEMENT", "EMPLOYEE_TAX_FORM", "EMPLOYMENT_SPONSORSHIP_LETTER", "IMMIGRATION_DOCUMENT", "EDUCATION_LETTER", "DVLA_FORM", "UNKNOWN", "DocumentName", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class DocumentTypeViewData implements Parcelable {
    private static final /* synthetic */ DocumentTypeViewData[] $VALUES;
    public static final DocumentTypeViewData AADHAAR;
    public static final DocumentTypeViewData ACCOUNT_OPENING_LETTER;
    public static final DocumentTypeViewData ADOPTION_CERTIFICATE;
    public static final DocumentTypeViewData BANK_STATEMENT;
    public static final DocumentTypeViewData BENEFIT_STATEMENT;
    public static final DocumentTypeViewData BIRTH_CERTIFICATE;
    public static final DocumentTypeViewData BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH;
    public static final DocumentTypeViewData CITIZEN_CARD;
    public static final DocumentTypeViewData COUNCIL_TAX_BILL;
    public static final Parcelable.Creator<DocumentTypeViewData> CREATOR;
    public static final DocumentTypeViewData DVLA_FORM;
    public static final DocumentTypeViewData EDUCATION_LETTER;
    public static final DocumentTypeViewData EMPLOYEE_TAX_FORM;
    public static final DocumentTypeViewData EMPLOYMENT_SPONSORSHIP_LETTER;
    public static final DocumentTypeViewData FINANCIAL_STATEMENT;
    public static final DocumentTypeViewData FIREARMS_LICENCE;
    public static final DocumentTypeViewData HEALTH_CARD;
    public static final DocumentTypeViewData HEALTH_CARD_QUEBEC;
    public static final DocumentTypeViewData IMMIGRATION_DOCUMENT;
    public static final DocumentTypeViewData INDIAN_STATUS_CARD;
    public static final DocumentTypeViewData MARRIAGE_CERTIFICATE;
    public static final DocumentTypeViewData MILITARY_CARD;
    public static final DocumentTypeViewData MORTGAGE_STATEMENT;
    public static final DocumentTypeViewData MYKAD;
    public static final DocumentTypeViewData NEXUS_CARD;
    public static final DocumentTypeViewData PAN;
    public static final DocumentTypeViewData PAPER_DRIVING_LICENCE;
    public static final DocumentTypeViewData PHILSYS_ID;
    public static final DocumentTypeViewData PHONE_BILL;
    public static final DocumentTypeViewData POSTAL_ID;
    public static final DocumentTypeViewData POST_OFFICE_PASS_CARD;
    public static final DocumentTypeViewData PROFESSIONAL_ID;
    public static final DocumentTypeViewData RESIDENCE_PERMIT;
    public static final DocumentTypeViewData SSS_ID_CARD;
    public static final DocumentTypeViewData STATE_ID;
    public static final DocumentTypeViewData SUPPLEMENTARY_PASS_CARD;
    public static final DocumentTypeViewData UMID;
    public static final DocumentTypeViewData UNKNOWN;
    public static final DocumentTypeViewData UTILITY_BILL;
    public static final DocumentTypeViewData VOTER_ID;
    public static final DocumentTypeViewData YOUNG_SCOT_CARD;
    private final List<DocumentName> documentNames;
    private final boolean implicitNationality;
    private final boolean showEducational;
    public static final DocumentTypeViewData PASSPORT = new DocumentTypeViewData("PASSPORT", 0, CollectionsKt.listOf((Object[]) new DocumentName[]{new DocumentName(null, C4957R.string.yds_document_type_passport, Integer.valueOf(C4957R.string.yds_document_type_lowercase_passport), 1, null), new DocumentName(DocumentTypeViewDataKt.RUSSIA_ISO3CODE, C4957R.string.yds_document_type_international_passport, Integer.valueOf(C4957R.string.yds_document_type_lowercase_international_passport))}), false, false, 6, null);
    public static final DocumentTypeViewData DRIVING_LICENCE = new DocumentTypeViewData("DRIVING_LICENCE", 1, CollectionsKt.listOf((Object[]) new DocumentName[]{new DocumentName(null, C4957R.string.yds_document_type_driving_licence, Integer.valueOf(C4957R.string.yds_document_type_lowercase_driving_licence), 1, null), new DocumentName(DocumentTypeViewDataKt.ITALY_ISO3CODE, C4957R.string.yds_document_type_driving_licence_card_only, Integer.valueOf(C4957R.string.yds_document_type_lowercase_driving_licence_card_only)), new DocumentName(DocumentTypeViewDataKt.FRANCE_ISO3CODE, C4957R.string.yds_document_type_driving_licence_card_only, Integer.valueOf(C4957R.string.yds_document_type_lowercase_driving_licence_card_only)), new DocumentName(DocumentTypeViewDataKt.USA_ISO3CODE, C4957R.string.yds_document_type_driving_license, Integer.valueOf(C4957R.string.yds_document_type_lowercase_driving_license)), new DocumentName(DocumentTypeViewDataKt.PHILIPPINES_ISO3CODE, C4957R.string.yds_document_type_driving_license, Integer.valueOf(C4957R.string.yds_document_type_lowercase_driving_license))}), false, false, 6, null);
    public static final DocumentTypeViewData NATIONAL_ID = new DocumentTypeViewData("NATIONAL_ID", 2, CollectionsKt.listOf((Object[]) new DocumentName[]{new DocumentName(null, C4957R.string.yds_document_type_national_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_national_id), 1, null), new DocumentName(DocumentTypeViewDataKt.INDONESIA_ISO3CODE, C4957R.string.yds_document_type_national_id_indonesia, Integer.valueOf(C4957R.string.yds_document_type_lowercase_national_id_indonesia)), new DocumentName(DocumentTypeViewDataKt.CANADA_ISO3CODE, C4957R.string.yds_document_type_provincial_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_provincial_id)), new DocumentName(DocumentTypeViewDataKt.JAPAN_ISO3CODE, C4957R.string.yds_document_type_my_number_card, Integer.valueOf(C4957R.string.yds_document_type_lowercase_my_number_card)), new DocumentName(DocumentTypeViewDataKt.IRELAND_ISO3CODE, C4957R.string.yds_document_type_passport_card, Integer.valueOf(C4957R.string.yds_document_type_lowercase_passport_card))}), false, false, 6, null);

    @Metadata(m5597d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00058G¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0017"}, m5598d2 = {"Lcom/yoti/mobile/android/yotisdkcore/feature/documentcapture/view/DocumentTypeViewData$DocumentName;", "Landroid/os/Parcelable;", "iso3Code", "", "name", "", "_lowercaseName", "(Ljava/lang/String;ILjava/lang/Integer;)V", "Ljava/lang/Integer;", "getIso3Code", "()Ljava/lang/String;", "lowercaseName", "getLowercaseName$annotations", "()V", "getLowercaseName", "()I", "getName", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "yoti-sdk-core_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
    public static final class DocumentName implements Parcelable {
        public static final Parcelable.Creator<DocumentName> CREATOR = new Creator();
        private final Integer _lowercaseName;
        private final String iso3Code;
        private final int name;

        @Metadata(m5599k = 3, m5600mv = {1, 6, 0}, m5602xi = 48)
        public static final class Creator implements Parcelable.Creator<DocumentName> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentName createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DocumentName(parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentName[] newArray(int i) {
                return new DocumentName[i];
            }
        }

        public DocumentName(String str, int i, Integer num) {
            this.iso3Code = str;
            this.name = i;
            this._lowercaseName = num;
        }

        public /* synthetic */ DocumentName(String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, i, (i2 & 4) != 0 ? null : num);
        }

        public static /* synthetic */ void getLowercaseName$annotations() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getIso3Code() {
            return this.iso3Code;
        }

        public final int getLowercaseName() {
            Integer num = this._lowercaseName;
            return num != null ? num.intValue() : this.name;
        }

        public final int getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            int iIntValue;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.iso3Code);
            parcel.writeInt(this.name);
            Integer num = this._lowercaseName;
            if (num == null) {
                iIntValue = 0;
            } else {
                parcel.writeInt(1);
                iIntValue = num.intValue();
            }
            parcel.writeInt(iIntValue);
        }
    }

    private static final /* synthetic */ DocumentTypeViewData[] $values() {
        return new DocumentTypeViewData[]{PASSPORT, DRIVING_LICENCE, NATIONAL_ID, STATE_ID, MYKAD, AADHAAR, PAN, SSS_ID_CARD, POSTAL_ID, RESIDENCE_PERMIT, PROFESSIONAL_ID, VOTER_ID, HEALTH_CARD_QUEBEC, NEXUS_CARD, PHILSYS_ID, UMID, YOUNG_SCOT_CARD, INDIAN_STATUS_CARD, CITIZEN_CARD, POST_OFFICE_PASS_CARD, HEALTH_CARD, UTILITY_BILL, COUNCIL_TAX_BILL, PHONE_BILL, BANK_STATEMENT, MILITARY_CARD, SUPPLEMENTARY_PASS_CARD, FIREARMS_LICENCE, BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH, BIRTH_CERTIFICATE, ADOPTION_CERTIFICATE, PAPER_DRIVING_LICENCE, MARRIAGE_CERTIFICATE, ACCOUNT_OPENING_LETTER, BENEFIT_STATEMENT, MORTGAGE_STATEMENT, FINANCIAL_STATEMENT, EMPLOYEE_TAX_FORM, EMPLOYMENT_SPONSORSHIP_LETTER, IMMIGRATION_DOCUMENT, EDUCATION_LETTER, DVLA_FORM, UNKNOWN};
    }

    static {
        char c = 1 == true ? 1 : 0;
        STATE_ID = new DocumentTypeViewData("STATE_ID", 3, CollectionsKt.listOf(new DocumentName(null, C4957R.string.yds_document_type_state_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_state_id), 1, null)), c, false, 4, null);
        int i = 5;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        Integer num = null;
        MYKAD = new DocumentTypeViewData("MYKAD", 4, CollectionsKt.listOf(new DocumentName(str, C4957R.string.yds_document_type_my_kad, num, i, defaultConstructorMarker)), true, false, 4, null);
        AADHAAR = new DocumentTypeViewData("AADHAAR", 5, CollectionsKt.listOf(new DocumentName(str, C4957R.string.yds_document_type_aadhaar, num, i, defaultConstructorMarker)), true, true);
        int i2 = 5;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str2 = null;
        Integer num2 = null;
        PAN = new DocumentTypeViewData("PAN", 6, CollectionsKt.listOf(new DocumentName(str2, C4957R.string.yds_document_type_pan, num2, i2, defaultConstructorMarker2)), true, false, 4, null);
        SSS_ID_CARD = new DocumentTypeViewData("SSS_ID_CARD", 7, CollectionsKt.listOf(new DocumentName(str2, C4957R.string.yds_document_type_sss_id, num2, i2, defaultConstructorMarker2)), true, false, 4, null);
        POSTAL_ID = new DocumentTypeViewData("POSTAL_ID", 8, CollectionsKt.listOf(new DocumentName(str2, C4957R.string.yds_document_type_postal_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_postal_id), 1, defaultConstructorMarker2)), 1 == true ? 1 : 0, false, 4, null);
        RESIDENCE_PERMIT = new DocumentTypeViewData("RESIDENCE_PERMIT", 9, CollectionsKt.listOf((Object[]) new DocumentName[]{new DocumentName(null, C4957R.string.yds_document_type_residence_permit, Integer.valueOf(C4957R.string.yds_document_type_lowercase_residence_permit), 1 == true ? 1 : 0, null), new DocumentName(DocumentTypeViewDataKt.USA_ISO3CODE, C4957R.string.yds_document_type_usa_permanent_residence_card, Integer.valueOf(C4957R.string.yds_document_type_lowercase_usa_permanent_residence_card)), new DocumentName(DocumentTypeViewDataKt.CANADA_ISO3CODE, C4957R.string.yds_document_type_permanent_residence_permit, Integer.valueOf(C4957R.string.yds_document_type_lowercase_permanent_residence_permit))}), true, false, 4, null);
        PROFESSIONAL_ID = new DocumentTypeViewData("PROFESSIONAL_ID", 10, CollectionsKt.listOf((Object[]) new DocumentName[]{new DocumentName(null, C4957R.string.yds_document_type_professional_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_professional_id), 1, null), new DocumentName(DocumentTypeViewDataKt.PHILIPPINES_ISO3CODE, C4957R.string.yds_document_type_professional_id_philippines, Integer.valueOf(C4957R.string.yds_document_type_lowercase_professional_id_philippines))}), false, false, 6, null);
        DefaultConstructorMarker defaultConstructorMarker3 = null;
        VOTER_ID = new DocumentTypeViewData("VOTER_ID", 11, CollectionsKt.listOf(new DocumentName(null, C4957R.string.yds_document_type_voter_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_voter_id), 1, null)), false, false, 6, defaultConstructorMarker3);
        int i3 = 5;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        String str3 = null;
        Integer num3 = null;
        int i4 = 4;
        DefaultConstructorMarker defaultConstructorMarker5 = null;
        boolean z = true;
        boolean z2 = false;
        HEALTH_CARD_QUEBEC = new DocumentTypeViewData("HEALTH_CARD_QUEBEC", 12, CollectionsKt.listOf(new DocumentName(str3, C4957R.string.yds_document_type_health_card_quebec, num3, i3, defaultConstructorMarker4)), z, z2, i4, defaultConstructorMarker5);
        NEXUS_CARD = new DocumentTypeViewData("NEXUS_CARD", 13, CollectionsKt.listOf(new DocumentName(str3, C4957R.string.yds_document_type_nexus_card, num3, i3, defaultConstructorMarker4)), true, false, 4, defaultConstructorMarker3);
        DefaultConstructorMarker defaultConstructorMarker6 = null;
        String str4 = null;
        PHILSYS_ID = new DocumentTypeViewData("PHILSYS_ID", 14, CollectionsKt.listOf(new DocumentName(str4, C4957R.string.yds_document_type_philsys_id, Integer.valueOf(C4957R.string.yds_document_type_lowercase_philsys_id), 1 == true ? 1 : 0, defaultConstructorMarker6)), z, z2, i4, defaultConstructorMarker5);
        UMID = new DocumentTypeViewData("UMID", 15, CollectionsKt.listOf(new DocumentName(str4, C4957R.string.yds_document_type_umid, null, 5, defaultConstructorMarker6)), true, false, 4, defaultConstructorMarker3);
        DefaultConstructorMarker defaultConstructorMarker7 = null;
        String str5 = null;
        YOUNG_SCOT_CARD = new DocumentTypeViewData("YOUNG_SCOT_CARD", 16, CollectionsKt.listOf(new DocumentName(str5, C4957R.string.yds_document_type_young_scot_card, null, 5, defaultConstructorMarker7)), z, z2, i4, defaultConstructorMarker5);
        INDIAN_STATUS_CARD = new DocumentTypeViewData("INDIAN_STATUS_CARD", 17, CollectionsKt.listOf(new DocumentName(str5, C4957R.string.yds_document_type_secure_certificate_of_indian_status, Integer.valueOf(C4957R.string.yds_document_type_lowercase_secure_certificate_of_indian_status), 1, defaultConstructorMarker7)), 1 == true ? 1 : 0, false, 4, defaultConstructorMarker3);
        int i5 = 5;
        DefaultConstructorMarker defaultConstructorMarker8 = null;
        String str6 = null;
        Integer num4 = null;
        CITIZEN_CARD = new DocumentTypeViewData("CITIZEN_CARD", 18, CollectionsKt.listOf(new DocumentName(str6, C4957R.string.yds_document_type_citizen_card, num4, i5, defaultConstructorMarker8)), z, z2, i4, defaultConstructorMarker5);
        POST_OFFICE_PASS_CARD = new DocumentTypeViewData("POST_OFFICE_PASS_CARD", 19, CollectionsKt.listOf(new DocumentName(str6, C4957R.string.yds_document_type_post_office_pass_card, num4, i5, defaultConstructorMarker8)), true, false, 4, defaultConstructorMarker3);
        DefaultConstructorMarker defaultConstructorMarker9 = null;
        String str7 = null;
        HEALTH_CARD = new DocumentTypeViewData("HEALTH_CARD", 20, CollectionsKt.listOf(new DocumentName(str7, C4957R.string.yds_document_type_health_card, Integer.valueOf(C4957R.string.yds_document_type_lowercase_health_card), 1 == true ? 1 : 0, defaultConstructorMarker9)), z, z2, i4, defaultConstructorMarker5);
        UTILITY_BILL = new DocumentTypeViewData("UTILITY_BILL", 21, CollectionsKt.listOf(new DocumentName(str7, C4957R.string.yds_document_type_utility_bill, Integer.valueOf(C4957R.string.yds_document_type_lowercase_utility_bill), 1 == true ? 1 : 0, defaultConstructorMarker9)), false, true, 2, defaultConstructorMarker3);
        int i6 = 1;
        DefaultConstructorMarker defaultConstructorMarker10 = null;
        String str8 = null;
        int i7 = 2;
        boolean z3 = false;
        boolean z4 = true;
        COUNCIL_TAX_BILL = new DocumentTypeViewData("COUNCIL_TAX_BILL", 22, CollectionsKt.listOf(new DocumentName(str8, C4957R.string.yds_document_type_council_tax_bill, Integer.valueOf(C4957R.string.yds_document_type_lowercase_council_tax_bill), i6, defaultConstructorMarker10)), z3, z4, i7, defaultConstructorMarker5);
        PHONE_BILL = new DocumentTypeViewData("PHONE_BILL", 23, CollectionsKt.listOf(new DocumentName(str8, C4957R.string.yds_document_type_phone_bill, Integer.valueOf(C4957R.string.yds_document_type_lowercase_phone_bill), i6, defaultConstructorMarker10)), false, true, 2, defaultConstructorMarker3);
        int i8 = 1;
        DefaultConstructorMarker defaultConstructorMarker11 = null;
        String str9 = null;
        BANK_STATEMENT = new DocumentTypeViewData("BANK_STATEMENT", 24, CollectionsKt.listOf(new DocumentName(str9, C4957R.string.yds_document_type_bank_statement, Integer.valueOf(C4957R.string.yds_document_type_lowercase_bank_statement), i8, defaultConstructorMarker11)), z3, z4, i7, defaultConstructorMarker5);
        MILITARY_CARD = new DocumentTypeViewData("MILITARY_CARD", 25, CollectionsKt.listOf(new DocumentName(str9, C4957R.string.yds_document_type_military_card, Integer.valueOf(C4957R.string.yds_document_type_lowercase_military_card), i8, defaultConstructorMarker11)), false, true, 2, defaultConstructorMarker3);
        DefaultConstructorMarker defaultConstructorMarker12 = null;
        String str10 = null;
        SUPPLEMENTARY_PASS_CARD = new DocumentTypeViewData("SUPPLEMENTARY_PASS_CARD", 26, CollectionsKt.listOf(new DocumentName(str10, C4957R.string.yds_document_type_pass_card, null, 5, defaultConstructorMarker12)), z3, z4, i7, defaultConstructorMarker5);
        FIREARMS_LICENCE = new DocumentTypeViewData("FIREARMS_LICENCE", 27, CollectionsKt.listOf(new DocumentName(str10, C4957R.string.yds_document_type_firearms_licence, Integer.valueOf(C4957R.string.yds_document_type_lowercase_firearms_licence), 1, defaultConstructorMarker12)), false, true, 2, defaultConstructorMarker3);
        int i9 = 1;
        DefaultConstructorMarker defaultConstructorMarker13 = null;
        String str11 = null;
        BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH = new DocumentTypeViewData("BIRTH_CERTIFICATE_ISSUED_WITHIN_12_MONTHS_OF_BIRTH", 28, CollectionsKt.listOf(new DocumentName(str11, C4957R.string.yds_document_type_birth_certificate, Integer.valueOf(C4957R.string.yds_document_type_lowercase_birth_certificate), i9, defaultConstructorMarker13)), z3, z4, i7, defaultConstructorMarker5);
        BIRTH_CERTIFICATE = new DocumentTypeViewData("BIRTH_CERTIFICATE", 29, CollectionsKt.listOf(new DocumentName(str11, C4957R.string.yds_document_type_birth_certificate, Integer.valueOf(C4957R.string.yds_document_type_lowercase_birth_certificate), i9, defaultConstructorMarker13)), false, true, 2, defaultConstructorMarker3);
        int i10 = 1;
        DefaultConstructorMarker defaultConstructorMarker14 = null;
        String str12 = null;
        ADOPTION_CERTIFICATE = new DocumentTypeViewData("ADOPTION_CERTIFICATE", 30, CollectionsKt.listOf(new DocumentName(str12, C4957R.string.yds_document_type_adoption_certificate, Integer.valueOf(C4957R.string.yds_document_type_lowercase_adoption_certificate), i10, defaultConstructorMarker14)), z3, z4, i7, defaultConstructorMarker5);
        PAPER_DRIVING_LICENCE = new DocumentTypeViewData("PAPER_DRIVING_LICENCE", 31, CollectionsKt.listOf(new DocumentName(str12, C4957R.string.yds_document_type_paper_driving_licence, Integer.valueOf(C4957R.string.yds_document_type_lowercase_paper_driving_licence), i10, defaultConstructorMarker14)), false, true, 2, defaultConstructorMarker3);
        int i11 = 1;
        DefaultConstructorMarker defaultConstructorMarker15 = null;
        String str13 = null;
        MARRIAGE_CERTIFICATE = new DocumentTypeViewData("MARRIAGE_CERTIFICATE", 32, CollectionsKt.listOf(new DocumentName(str13, C4957R.string.yds_document_type_marriage_civil_partnership_certificate, Integer.valueOf(C4957R.string.f7518x349802c1), i11, defaultConstructorMarker15)), z3, z4, i7, defaultConstructorMarker5);
        ACCOUNT_OPENING_LETTER = new DocumentTypeViewData("ACCOUNT_OPENING_LETTER", 33, CollectionsKt.listOf(new DocumentName(str13, C4957R.string.yds_document_type_bank_opening_letter, Integer.valueOf(C4957R.string.yds_document_type_lowercase_bank_opening_letter), i11, defaultConstructorMarker15)), false, true, 2, defaultConstructorMarker3);
        int i12 = 1;
        DefaultConstructorMarker defaultConstructorMarker16 = null;
        String str14 = null;
        BENEFIT_STATEMENT = new DocumentTypeViewData("BENEFIT_STATEMENT", 34, CollectionsKt.listOf(new DocumentName(str14, C4957R.string.yds_document_type_benefit_statement, Integer.valueOf(C4957R.string.yds_document_type_lowercase_benefit_statement), i12, defaultConstructorMarker16)), z3, z4, i7, defaultConstructorMarker5);
        MORTGAGE_STATEMENT = new DocumentTypeViewData("MORTGAGE_STATEMENT", 35, CollectionsKt.listOf(new DocumentName(str14, C4957R.string.yds_document_type_mortgage_statement, Integer.valueOf(C4957R.string.yds_document_type_lowercase_mortgage_statement), i12, defaultConstructorMarker16)), false, true, 2, defaultConstructorMarker3);
        int i13 = 1;
        DefaultConstructorMarker defaultConstructorMarker17 = null;
        String str15 = null;
        FINANCIAL_STATEMENT = new DocumentTypeViewData("FINANCIAL_STATEMENT", 36, CollectionsKt.listOf(new DocumentName(str15, C4957R.string.yds_document_type_financial_statement, Integer.valueOf(C4957R.string.yds_document_type_lowercase_financial_statement), i13, defaultConstructorMarker17)), z3, z4, i7, defaultConstructorMarker5);
        EMPLOYEE_TAX_FORM = new DocumentTypeViewData("EMPLOYEE_TAX_FORM", 37, CollectionsKt.listOf(new DocumentName(str15, C4957R.string.yds_document_type_p45_p60_statement, Integer.valueOf(C4957R.string.yds_document_type_lowercase_p45_p60_statement), i13, defaultConstructorMarker17)), false, true, 2, defaultConstructorMarker3);
        int i14 = 1;
        DefaultConstructorMarker defaultConstructorMarker18 = null;
        String str16 = null;
        EMPLOYMENT_SPONSORSHIP_LETTER = new DocumentTypeViewData("EMPLOYMENT_SPONSORSHIP_LETTER", 38, CollectionsKt.listOf(new DocumentName(str16, C4957R.string.yds_document_type_employment_sponsorship_letter, Integer.valueOf(C4957R.string.yds_document_type_lowercase_employment_sponsorship_letter), i14, defaultConstructorMarker18)), z3, z4, i7, defaultConstructorMarker5);
        IMMIGRATION_DOCUMENT = new DocumentTypeViewData("IMMIGRATION_DOCUMENT", 39, CollectionsKt.listOf(new DocumentName(str16, C4957R.string.yds_document_type_immigration_document_permit, Integer.valueOf(C4957R.string.yds_document_type_lowercase_immigration_document_permit), i14, defaultConstructorMarker18)), false, true, 2, defaultConstructorMarker3);
        DefaultConstructorMarker defaultConstructorMarker19 = null;
        String str17 = null;
        EDUCATION_LETTER = new DocumentTypeViewData("EDUCATION_LETTER", 40, CollectionsKt.listOf(new DocumentName(str17, C4957R.string.yds_document_type_education_letter, Integer.valueOf(C4957R.string.yds_document_type_lowercase_education_letter), 1, defaultConstructorMarker19)), z3, z4, i7, defaultConstructorMarker5);
        DVLA_FORM = new DocumentTypeViewData("DVLA_FORM", 41, CollectionsKt.listOf(new DocumentName(str17, C4957R.string.yds_document_type_dvla_v5_v5c2, null, 5, defaultConstructorMarker19)), false, true, 2, defaultConstructorMarker3);
        UNKNOWN = new DocumentTypeViewData("UNKNOWN", 42, CollectionsKt.listOf(new DocumentName(null, C4957R.string.yds_document_type_generic, null, 5, null)), z3, false, 6, defaultConstructorMarker5);
        $VALUES = $values();
        CREATOR = new Parcelable.Creator<DocumentTypeViewData>() { // from class: com.yoti.mobile.android.yotisdkcore.feature.documentcapture.view.DocumentTypeViewData.Creator
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentTypeViewData createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return DocumentTypeViewData.valueOf(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final DocumentTypeViewData[] newArray(int i15) {
                return new DocumentTypeViewData[i15];
            }
        };
    }

    private DocumentTypeViewData(String str, int i, List list, boolean z, boolean z2) {
        this.documentNames = list;
        this.implicitNationality = z;
        this.showEducational = z2;
    }

    /* synthetic */ DocumentTypeViewData(String str, int i, List list, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, list, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2);
    }

    public static /* synthetic */ DocumentName getDocumentName$default(DocumentTypeViewData documentTypeViewData, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDocumentName");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return documentTypeViewData.getDocumentName(str);
    }

    public static DocumentTypeViewData valueOf(String str) {
        return (DocumentTypeViewData) Enum.valueOf(DocumentTypeViewData.class, str);
    }

    public static DocumentTypeViewData[] values() {
        return (DocumentTypeViewData[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final DocumentName getDocumentName(String countryIso3Code) {
        Object next;
        Iterator<T> it2 = this.documentNames.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((DocumentName) next).getIso3Code(), countryIso3Code)) {
                break;
            }
        }
        DocumentName documentName = (DocumentName) next;
        return documentName == null ? (DocumentName) CollectionsKt.first((List) this.documentNames) : documentName;
    }

    public final boolean getImplicitNationality() {
        return this.implicitNationality;
    }

    public final boolean getShowEducational() {
        return this.showEducational;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }
}
