package com.microblink.entities.recognizers.blinkid.idbarcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.BarcodeType;
import com.microblink.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class IdBarcodeRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<IdBarcodeRecognizer> CREATOR;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer.Result.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Result createFromParcel(Parcel parcel) {
                Result result = new Result(Result.nativeConstruct());
                result.llIIlIlIIl(parcel);
                return result;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Result[] newArray(int i) {
                return new Result[i];
            }
        };

        protected Result(long j) {
            super(j);
        }

        private static native String additionalNameInformationNativeGet(long j);

        private static native String addressNativeGet(long j);

        private static native int barcodeTypeNativeGet(long j);

        private static native String cityNativeGet(long j);

        private static native DateResult dateOfBirthNativeGet(long j);

        private static native DateResult dateOfExpiryNativeGet(long j);

        private static native DateResult dateOfIssueNativeGet(long j);

        private static native String documentAdditionalNumberNativeGet(long j);

        private static native String documentNumberNativeGet(long j);

        private static native int documentTypeNativeGet(long j);

        private static native String employerNativeGet(long j);

        private static native String endorsementsNativeGet(long j);

        private static native long extendedElementsNativeGet(long j);

        private static native String firstNameNativeGet(long j);

        private static native String fullNameNativeGet(long j);

        private static native String issuingAuthorityNativeGet(long j);

        private static native String jurisdictionNativeGet(long j);

        private static native String lastNameNativeGet(long j);

        private static native String maritalStatusNativeGet(long j);

        private static native String middleNameNativeGet(long j);

        private static native String nationalityNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native String personalIdNumberNativeGet(long j);

        private static native String placeOfBirthNativeGet(long j);

        private static native String postalCodeNativeGet(long j);

        private static native String professionNativeGet(long j);

        private static native String raceNativeGet(long j);

        private static native byte[] rawBytesNativeGet(long j);

        private static native String religionNativeGet(long j);

        private static native String residentialStatusNativeGet(long j);

        private static native String restrictionsNativeGet(long j);

        private static native String sexNativeGet(long j);

        private static native String streetNativeGet(long j);

        private static native String stringDataNativeGet(long j);

        private static native boolean uncertainNativeGet(long j);

        private static native String vehicleClassNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public String getAdditionalNameInformation() {
            return additionalNameInformationNativeGet(getNativeContext());
        }

        public String getAddress() {
            return addressNativeGet(getNativeContext());
        }

        public int getAge() {
            Date date = getDateOfBirth().getDate();
            if (date == null) {
                return -1;
            }
            return DateUtils.yearsPassedFrom(date);
        }

        public AgeLimitStatus getAgeLimitStatus(int i) {
            int age = getAge();
            return age == -1 ? AgeLimitStatus.NotAvailable : age >= i ? AgeLimitStatus.OverAgeLimit : AgeLimitStatus.BelowAgeLimit;
        }

        public BarcodeType getBarcodeType() {
            return BarcodeType.values()[barcodeTypeNativeGet(getNativeContext())];
        }

        public String getCity() {
            return cityNativeGet(getNativeContext());
        }

        public DateResult getDateOfBirth() {
            return dateOfBirthNativeGet(getNativeContext());
        }

        public DateResult getDateOfExpiry() {
            return dateOfExpiryNativeGet(getNativeContext());
        }

        public DateResult getDateOfIssue() {
            return dateOfIssueNativeGet(getNativeContext());
        }

        public String getDocumentAdditionalNumber() {
            return documentAdditionalNumberNativeGet(getNativeContext());
        }

        public String getDocumentNumber() {
            return documentNumberNativeGet(getNativeContext());
        }

        public IdBarcodeDocumentType getDocumentType() {
            return IdBarcodeDocumentType.values()[documentTypeNativeGet(getNativeContext())];
        }

        public String getEmployer() {
            return employerNativeGet(getNativeContext());
        }

        public String getEndorsements() {
            return endorsementsNativeGet(getNativeContext());
        }

        public BarcodeElements getExtendedElements() {
            long jExtendedElementsNativeGet = extendedElementsNativeGet(getNativeContext());
            if (jExtendedElementsNativeGet != 0) {
                return new BarcodeElements(jExtendedElementsNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for extendedElements");
        }

        public String getFirstName() {
            return firstNameNativeGet(getNativeContext());
        }

        public String getFullName() {
            return fullNameNativeGet(getNativeContext());
        }

        public String getIssuingAuthority() {
            return issuingAuthorityNativeGet(getNativeContext());
        }

        public String getJurisdiction() {
            return jurisdictionNativeGet(getNativeContext());
        }

        public String getLastName() {
            return lastNameNativeGet(getNativeContext());
        }

        public String getMaritalStatus() {
            return maritalStatusNativeGet(getNativeContext());
        }

        public String getMiddleName() {
            return middleNameNativeGet(getNativeContext());
        }

        public String getNationality() {
            return nationalityNativeGet(getNativeContext());
        }

        public String getPersonalIdNumber() {
            return personalIdNumberNativeGet(getNativeContext());
        }

        public String getPlaceOfBirth() {
            return placeOfBirthNativeGet(getNativeContext());
        }

        public String getPostalCode() {
            return postalCodeNativeGet(getNativeContext());
        }

        public String getProfession() {
            return professionNativeGet(getNativeContext());
        }

        public String getRace() {
            return raceNativeGet(getNativeContext());
        }

        public byte[] getRawData() {
            return rawBytesNativeGet(getNativeContext());
        }

        public String getReligion() {
            return religionNativeGet(getNativeContext());
        }

        public String getResidentialStatus() {
            return residentialStatusNativeGet(getNativeContext());
        }

        public String getRestrictions() {
            return restrictionsNativeGet(getNativeContext());
        }

        public String getSex() {
            return sexNativeGet(getNativeContext());
        }

        public String getStreet() {
            return streetNativeGet(getNativeContext());
        }

        public String getStringData() {
            return stringDataNativeGet(getNativeContext());
        }

        public String getVehicleClass() {
            return vehicleClassNativeGet(getNativeContext());
        }

        public boolean isExpired() {
            Date date = getDateOfExpiry().getDate();
            if (date == null) {
                return false;
            }
            return DateUtils.isDatePassed(date);
        }

        public boolean isUncertain() {
            return uncertainNativeGet(getNativeContext());
        }

        public String toString() {
            return "ID Barcode Recognizer";
        }

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(long j) {
            nativeDestruct(j);
        }

        @Override // com.microblink.entities.recognizers.Recognizer.Result, com.microblink.entities.Entity.Result
        /* JADX INFO: renamed from: clone */
        public Result mo6354clone() {
            return new Result(nativeCopy(getNativeContext()));
        }
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<IdBarcodeRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public IdBarcodeRecognizer createFromParcel(Parcel parcel) {
                return new IdBarcodeRecognizer(parcel, IdBarcodeRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public IdBarcodeRecognizer[] newArray(int i) {
                return new IdBarcodeRecognizer[i];
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native void nativeDestruct(long j);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof IdBarcodeRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be IdBarcodeRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return null;
    }

    public IdBarcodeRecognizer() {
        this(nativeConstruct());
    }

    private IdBarcodeRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    private IdBarcodeRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public IdBarcodeRecognizer mo6353clone() {
        return new IdBarcodeRecognizer(nativeConstruct());
    }
}
