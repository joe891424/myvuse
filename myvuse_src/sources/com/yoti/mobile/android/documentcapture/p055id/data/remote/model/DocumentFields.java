package com.yoti.mobile.android.documentcapture.p055id.data.remote.model;

import androidx.autofill.HintConstants;
import com.google.gson.annotations.SerializedName;
import com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer;
import com.yoti.mobile.android.yotisdkcore.core.data.model.DocumentType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b]\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B½\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÁ\u0002\u0010}\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!HÆ\u0001J\u0014\u0010~\u001a\u00020\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0081\u0001\u001a\u00030\u0082\u0001HÖ\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0003HÖ\u0001R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010(\"\u0004\bL\u0010*R \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010(\"\u0004\bP\u0010*R \u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010,\"\u0004\bR\u0010.R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010(\"\u0004\bT\u0010*R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010(\"\u0004\bV\u0010*R \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010(\"\u0004\b\\\u0010*R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010(\"\u0004\b^\u0010*R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010(\"\u0004\b`\u0010*R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010(\"\u0004\bb\u0010*¨\u0006\u0084\u0001"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/DocumentFields;", "", "fullName", "", "birthDate", "Ljava/util/Date;", BlinkIdCombinedRecognizer.VerificationConstants.Nationality, "givenNames", "firstName", UsdlCombinedRecognizer.VerificationConstants.MiddleName, "familyName", "birthPlace", "birthCountry", HintConstants.AUTOFILL_HINT_GENDER, "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/GenderType;", "namePrefix", UsdlCombinedRecognizer.VerificationConstants.NameSuffix, "firstNameAlias", "middleNameAlias", "familyNameAlias", "weight", "height", "eyeColor", "address", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;", "documentType", "Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "issuingCountryIso3Code", "documentNumber", "expirationDate", "issuingDate", BlinkIdCombinedRecognizer.VerificationConstants.IssuingAuthority, "mrz", "Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Mrz;", "(Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/GenderType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Mrz;)V", "getAddress", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;", "setAddress", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Address;)V", "getBirthCountry", "()Ljava/lang/String;", "setBirthCountry", "(Ljava/lang/String;)V", "getBirthDate", "()Ljava/util/Date;", "setBirthDate", "(Ljava/util/Date;)V", "getBirthPlace", "setBirthPlace", "getDocumentNumber", "setDocumentNumber", "getDocumentType", "()Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;", "setDocumentType", "(Lcom/yoti/mobile/android/yotisdkcore/core/data/model/DocumentType;)V", "getExpirationDate", "setExpirationDate", "getEyeColor", "setEyeColor", "getFamilyName", "setFamilyName", "getFamilyNameAlias", "setFamilyNameAlias", "getFirstName", "setFirstName", "getFirstNameAlias", "setFirstNameAlias", "getFullName", "setFullName", "getGender", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/GenderType;", "setGender", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/GenderType;)V", "getGivenNames", "setGivenNames", "getHeight", "setHeight", "getIssuingAuthority", "setIssuingAuthority", "getIssuingCountryIso3Code", "setIssuingCountryIso3Code", "getIssuingDate", "setIssuingDate", "getMiddleName", "setMiddleName", "getMiddleNameAlias", "setMiddleNameAlias", "getMrz", "()Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Mrz;", "setMrz", "(Lcom/yoti/mobile/android/documentcapture/id/data/remote/model/Mrz;)V", "getNamePrefix", "setNamePrefix", "getNameSuffix", "setNameSuffix", "getNationality", "setNationality", "getWeight", "setWeight", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final /* data */ class DocumentFields {

    @SerializedName("structured_postal_address")
    private Address address;

    @SerializedName("country_of_birth")
    private String birthCountry;

    @SerializedName("date_of_birth")
    private Date birthDate;

    @SerializedName("place_of_birth")
    private String birthPlace;

    @SerializedName("document_number")
    private String documentNumber;

    @SerializedName("document_type")
    private DocumentType documentType;

    @SerializedName("expiration_date")
    private Date expirationDate;

    @SerializedName("eye_color")
    private String eyeColor;

    @SerializedName("family_name")
    private String familyName;

    @SerializedName("family_name_alias")
    private String familyNameAlias;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("first_name_alias")
    private String firstNameAlias;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName(HintConstants.AUTOFILL_HINT_GENDER)
    private GenderType gender;

    @SerializedName("given_names")
    private String givenNames;

    @SerializedName("height")
    private String height;

    @SerializedName("issuing_authority")
    private String issuingAuthority;

    @SerializedName("issuing_country")
    private String issuingCountryIso3Code;

    @SerializedName("date_of_issue")
    private Date issuingDate;

    @SerializedName("middle_name")
    private String middleName;

    @SerializedName("middle_name_alias")
    private String middleNameAlias;

    @SerializedName("mrz")
    private Mrz mrz;

    @SerializedName("name_prefix")
    private String namePrefix;

    @SerializedName("name_suffix")
    private String nameSuffix;

    @SerializedName(BlinkIdCombinedRecognizer.VerificationConstants.Nationality)
    private String nationality;

    @SerializedName("weight")
    private String weight;

    public DocumentFields() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
    }

    public DocumentFields(String str, Date date, String str2, String str3, String str4, String str5, String str6, String str7, String str8, GenderType genderType, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Address address, DocumentType documentType, String str17, String str18, Date date2, Date date3, String str19, Mrz mrz) {
        this.fullName = str;
        this.birthDate = date;
        this.nationality = str2;
        this.givenNames = str3;
        this.firstName = str4;
        this.middleName = str5;
        this.familyName = str6;
        this.birthPlace = str7;
        this.birthCountry = str8;
        this.gender = genderType;
        this.namePrefix = str9;
        this.nameSuffix = str10;
        this.firstNameAlias = str11;
        this.middleNameAlias = str12;
        this.familyNameAlias = str13;
        this.weight = str14;
        this.height = str15;
        this.eyeColor = str16;
        this.address = address;
        this.documentType = documentType;
        this.issuingCountryIso3Code = str17;
        this.documentNumber = str18;
        this.expirationDate = date2;
        this.issuingDate = date3;
        this.issuingAuthority = str19;
        this.mrz = mrz;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFullName() {
        return this.fullName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final GenderType getGender() {
        return this.gender;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getNamePrefix() {
        return this.namePrefix;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getNameSuffix() {
        return this.nameSuffix;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFirstNameAlias() {
        return this.firstNameAlias;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getMiddleNameAlias() {
        return this.middleNameAlias;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getFamilyNameAlias() {
        return this.familyNameAlias;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getEyeColor() {
        return this.eyeColor;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Address getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getBirthDate() {
        return this.birthDate;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Date getIssuingDate() {
        return this.issuingDate;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Mrz getMrz() {
        return this.mrz;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNationality() {
        return this.nationality;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGivenNames() {
        return this.givenNames;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMiddleName() {
        return this.middleName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFamilyName() {
        return this.familyName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getBirthPlace() {
        return this.birthPlace;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getBirthCountry() {
        return this.birthCountry;
    }

    public final DocumentFields copy(String fullName, Date birthDate, String nationality, String givenNames, String firstName, String middleName, String familyName, String birthPlace, String birthCountry, GenderType gender, String namePrefix, String nameSuffix, String firstNameAlias, String middleNameAlias, String familyNameAlias, String weight, String height, String eyeColor, Address address, DocumentType documentType, String issuingCountryIso3Code, String documentNumber, Date expirationDate, Date issuingDate, String issuingAuthority, Mrz mrz) {
        return new DocumentFields(fullName, birthDate, nationality, givenNames, firstName, middleName, familyName, birthPlace, birthCountry, gender, namePrefix, nameSuffix, firstNameAlias, middleNameAlias, familyNameAlias, weight, height, eyeColor, address, documentType, issuingCountryIso3Code, documentNumber, expirationDate, issuingDate, issuingAuthority, mrz);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentFields)) {
            return false;
        }
        DocumentFields documentFields = (DocumentFields) other;
        return Intrinsics.areEqual(this.fullName, documentFields.fullName) && Intrinsics.areEqual(this.birthDate, documentFields.birthDate) && Intrinsics.areEqual(this.nationality, documentFields.nationality) && Intrinsics.areEqual(this.givenNames, documentFields.givenNames) && Intrinsics.areEqual(this.firstName, documentFields.firstName) && Intrinsics.areEqual(this.middleName, documentFields.middleName) && Intrinsics.areEqual(this.familyName, documentFields.familyName) && Intrinsics.areEqual(this.birthPlace, documentFields.birthPlace) && Intrinsics.areEqual(this.birthCountry, documentFields.birthCountry) && this.gender == documentFields.gender && Intrinsics.areEqual(this.namePrefix, documentFields.namePrefix) && Intrinsics.areEqual(this.nameSuffix, documentFields.nameSuffix) && Intrinsics.areEqual(this.firstNameAlias, documentFields.firstNameAlias) && Intrinsics.areEqual(this.middleNameAlias, documentFields.middleNameAlias) && Intrinsics.areEqual(this.familyNameAlias, documentFields.familyNameAlias) && Intrinsics.areEqual(this.weight, documentFields.weight) && Intrinsics.areEqual(this.height, documentFields.height) && Intrinsics.areEqual(this.eyeColor, documentFields.eyeColor) && Intrinsics.areEqual(this.address, documentFields.address) && this.documentType == documentFields.documentType && Intrinsics.areEqual(this.issuingCountryIso3Code, documentFields.issuingCountryIso3Code) && Intrinsics.areEqual(this.documentNumber, documentFields.documentNumber) && Intrinsics.areEqual(this.expirationDate, documentFields.expirationDate) && Intrinsics.areEqual(this.issuingDate, documentFields.issuingDate) && Intrinsics.areEqual(this.issuingAuthority, documentFields.issuingAuthority) && Intrinsics.areEqual(this.mrz, documentFields.mrz);
    }

    public final Address getAddress() {
        return this.address;
    }

    public final String getBirthCountry() {
        return this.birthCountry;
    }

    public final Date getBirthDate() {
        return this.birthDate;
    }

    public final String getBirthPlace() {
        return this.birthPlace;
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final DocumentType getDocumentType() {
        return this.documentType;
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final String getEyeColor() {
        return this.eyeColor;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getFamilyNameAlias() {
        return this.familyNameAlias;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFirstNameAlias() {
        return this.firstNameAlias;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final GenderType getGender() {
        return this.gender;
    }

    public final String getGivenNames() {
        return this.givenNames;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    public final String getIssuingCountryIso3Code() {
        return this.issuingCountryIso3Code;
    }

    public final Date getIssuingDate() {
        return this.issuingDate;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getMiddleNameAlias() {
        return this.middleNameAlias;
    }

    public final Mrz getMrz() {
        return this.mrz;
    }

    public final String getNamePrefix() {
        return this.namePrefix;
    }

    public final String getNameSuffix() {
        return this.nameSuffix;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public final String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String str = this.fullName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Date date = this.birthDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        String str2 = this.nationality;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.givenNames;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firstName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.middleName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.familyName;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.birthPlace;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.birthCountry;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        GenderType genderType = this.gender;
        int iHashCode10 = (iHashCode9 + (genderType == null ? 0 : genderType.hashCode())) * 31;
        String str9 = this.namePrefix;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.nameSuffix;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.firstNameAlias;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.middleNameAlias;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.familyNameAlias;
        int iHashCode15 = (iHashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.weight;
        int iHashCode16 = (iHashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.height;
        int iHashCode17 = (iHashCode16 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.eyeColor;
        int iHashCode18 = (iHashCode17 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Address address = this.address;
        int iHashCode19 = (iHashCode18 + (address == null ? 0 : address.hashCode())) * 31;
        DocumentType documentType = this.documentType;
        int iHashCode20 = (iHashCode19 + (documentType == null ? 0 : documentType.hashCode())) * 31;
        String str17 = this.issuingCountryIso3Code;
        int iHashCode21 = (iHashCode20 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.documentNumber;
        int iHashCode22 = (iHashCode21 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Date date2 = this.expirationDate;
        int iHashCode23 = (iHashCode22 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.issuingDate;
        int iHashCode24 = (iHashCode23 + (date3 == null ? 0 : date3.hashCode())) * 31;
        String str19 = this.issuingAuthority;
        int iHashCode25 = (iHashCode24 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Mrz mrz = this.mrz;
        return iHashCode25 + (mrz != null ? mrz.hashCode() : 0);
    }

    public final void setAddress(Address address) {
        this.address = address;
    }

    public final void setBirthCountry(String str) {
        this.birthCountry = str;
    }

    public final void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public final void setBirthPlace(String str) {
        this.birthPlace = str;
    }

    public final void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public final void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public final void setExpirationDate(Date date) {
        this.expirationDate = date;
    }

    public final void setEyeColor(String str) {
        this.eyeColor = str;
    }

    public final void setFamilyName(String str) {
        this.familyName = str;
    }

    public final void setFamilyNameAlias(String str) {
        this.familyNameAlias = str;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final void setFirstNameAlias(String str) {
        this.firstNameAlias = str;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final void setGender(GenderType genderType) {
        this.gender = genderType;
    }

    public final void setGivenNames(String str) {
        this.givenNames = str;
    }

    public final void setHeight(String str) {
        this.height = str;
    }

    public final void setIssuingAuthority(String str) {
        this.issuingAuthority = str;
    }

    public final void setIssuingCountryIso3Code(String str) {
        this.issuingCountryIso3Code = str;
    }

    public final void setIssuingDate(Date date) {
        this.issuingDate = date;
    }

    public final void setMiddleName(String str) {
        this.middleName = str;
    }

    public final void setMiddleNameAlias(String str) {
        this.middleNameAlias = str;
    }

    public final void setMrz(Mrz mrz) {
        this.mrz = mrz;
    }

    public final void setNamePrefix(String str) {
        this.namePrefix = str;
    }

    public final void setNameSuffix(String str) {
        this.nameSuffix = str;
    }

    public final void setNationality(String str) {
        this.nationality = str;
    }

    public final void setWeight(String str) {
        this.weight = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DocumentFields(fullName=");
        sb.append(this.fullName).append(", birthDate=").append(this.birthDate).append(", nationality=").append(this.nationality).append(", givenNames=").append(this.givenNames).append(", firstName=").append(this.firstName).append(", middleName=").append(this.middleName).append(", familyName=").append(this.familyName).append(", birthPlace=").append(this.birthPlace).append(", birthCountry=").append(this.birthCountry).append(", gender=").append(this.gender).append(", namePrefix=").append(this.namePrefix).append(", nameSuffix=");
        sb.append(this.nameSuffix).append(", firstNameAlias=").append(this.firstNameAlias).append(", middleNameAlias=").append(this.middleNameAlias).append(", familyNameAlias=").append(this.familyNameAlias).append(", weight=").append(this.weight).append(", height=").append(this.height).append(", eyeColor=").append(this.eyeColor).append(", address=").append(this.address).append(", documentType=").append(this.documentType).append(", issuingCountryIso3Code=").append(this.issuingCountryIso3Code).append(", documentNumber=").append(this.documentNumber).append(", expirationDate=").append(this.expirationDate);
        sb.append(", issuingDate=").append(this.issuingDate).append(", issuingAuthority=").append(this.issuingAuthority).append(", mrz=").append(this.mrz).append(')');
        return sb.toString();
    }

    public /* synthetic */ DocumentFields(String str, Date date, String str2, String str3, String str4, String str5, String str6, String str7, String str8, GenderType genderType, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Address address, DocumentType documentType, String str17, String str18, Date date2, Date date3, String str19, Mrz mrz, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : date, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : genderType, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (i & 32768) != 0 ? null : str14, (i & 65536) != 0 ? null : str15, (i & 131072) != 0 ? null : str16, (i & 262144) != 0 ? null : address, (i & 524288) != 0 ? null : documentType, (i & 1048576) != 0 ? null : str17, (i & 2097152) != 0 ? null : str18, (i & 4194304) != 0 ? null : date2, (i & 8388608) != 0 ? null : date3, (i & 16777216) != 0 ? null : str19, (i & 33554432) != 0 ? null : mrz);
    }
}
