package com.microblink.entities.recognizers.blinkbarcode.usdl;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.blinkid.secured.IIllIllIIl;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;
import com.microblink.util.StringUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class UsdlRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<UsdlRecognizer> CREATOR;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer.Result.1
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

        private static native String addressNativeGet(long j);

        private static native String cityNativeGet(long j);

        private static native boolean dataIsUncertainNativeGet(long j);

        private static native DateResult dateOfBirthNativeGet(long j);

        private static native DateResult dateOfExpiryNativeGet(long j);

        private static native DateResult dateOfIssueNativeGet(long j);

        private static native String documentNumberNativeGet(long j);

        private static native byte[][] dynamicElementsNativeGet(long j);

        private static native byte[] elementNativeGet(long j, int i);

        private static native String endorsementsNativeGet(long j);

        private static native String firstNameNativeGet(long j);

        private static native String fullNameNativeGet(long j);

        private static native String jurisdictionNativeGet(long j);

        private static native String lastNameNativeGet(long j);

        private static native String middleNameNativeGet(long j);

        private static native String nameSuffixNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native String pdf417NativeGet(long j);

        private static native String postalCodeNativeGet(long j);

        private static native byte[] rawBytesNativeGet(long j);

        private static native String restrictionsNativeGet(long j);

        private static native String sexNativeGet(long j);

        private static native String streetNativeGet(long j);

        private static native String vehicleClassNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
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

        public String getDocumentNumber() {
            return documentNumberNativeGet(getNativeContext());
        }

        public String getEndorsements() {
            return endorsementsNativeGet(getNativeContext());
        }

        public String getField(UsdlKeys usdlKeys) {
            return StringUtils.convertByteArrayToString(elementNativeGet(getNativeContext(), usdlKeys.ordinal()));
        }

        public String getFirstName() {
            return firstNameNativeGet(getNativeContext());
        }

        public String getFullName() {
            return fullNameNativeGet(getNativeContext());
        }

        public String getJurisdiction() {
            return jurisdictionNativeGet(getNativeContext());
        }

        public String getLastName() {
            return lastNameNativeGet(getNativeContext());
        }

        public String getMiddleName() {
            return middleNameNativeGet(getNativeContext());
        }

        public String getNameSuffix() {
            return nameSuffixNativeGet(getNativeContext());
        }

        @Deprecated
        public String[] getOptionalElements() {
            byte[][] bArrDynamicElementsNativeGet = dynamicElementsNativeGet(getNativeContext());
            String[] strArr = new String[bArrDynamicElementsNativeGet.length];
            for (int i = 0; i < bArrDynamicElementsNativeGet.length; i++) {
                strArr[i] = StringUtils.convertByteArrayToString(bArrDynamicElementsNativeGet[i]);
            }
            return strArr;
        }

        public String getPostalCode() {
            return postalCodeNativeGet(getNativeContext());
        }

        public byte[] getRawData() {
            return rawBytesNativeGet(getNativeContext());
        }

        public String getRawStringData() {
            return pdf417NativeGet(getNativeContext());
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

        public String getVehicleClass() {
            return vehicleClassNativeGet(getNativeContext());
        }

        public boolean isUncertain() {
            return dataIsUncertainNativeGet(getNativeContext());
        }

        public String toString() {
            return IIllIllIIl.llIIlIlIIl("US Driver's License\n\n").append(getRawStringData()).toString();
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
        CREATOR = new Parcelable.Creator<UsdlRecognizer>() { // from class: com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UsdlRecognizer createFromParcel(Parcel parcel) {
                return new UsdlRecognizer(parcel, UsdlRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UsdlRecognizer[] newArray(int i) {
                return new UsdlRecognizer[i];
            }
        };
    }

    private static native boolean enableCompactParserNativeGet(long j);

    private static native void enableCompactParserNativeSet(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native boolean nullQuietZoneAllowedNativeGet(long j);

    private static native void nullQuietZoneAllowedNativeSet(long j, boolean z);

    private static native boolean uncertainDecodingNativeGet(long j);

    private static native void uncertainDecodingNativeSet(long j, boolean z);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof UsdlRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be UsdlRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    public boolean isEnableCompactParser() {
        return enableCompactParserNativeGet(getNativeContext());
    }

    public boolean isNullQuietZoneAllowed() {
        return nullQuietZoneAllowedNativeGet(getNativeContext());
    }

    public boolean isUncertainDecoding() {
        return uncertainDecodingNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void setEnableCompactParser(boolean z) {
        enableCompactParserNativeSet(getNativeContext(), z);
    }

    public void setNullQuietZoneAllowed(boolean z) {
        nullQuietZoneAllowedNativeSet(getNativeContext(), z);
    }

    public void setUncertainDecoding(boolean z) {
        uncertainDecodingNativeSet(getNativeContext(), z);
    }

    public UsdlRecognizer() {
        this(nativeConstruct());
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private UsdlRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private UsdlRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public UsdlRecognizer mo6353clone() {
        return new UsdlRecognizer(nativeCopy(getNativeContext()));
    }
}
