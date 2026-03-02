package com.microblink.entities.recognizers.blinkid.usdl;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkbarcode.usdl.UsdlKeys;
import com.microblink.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult;
import com.microblink.entities.recognizers.blinkid.CombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;
import com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.DpiOptionsUtils;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.ImageExtensionFactors;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;
import com.microblink.util.StringUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class UsdlCombinedRecognizer extends Recognizer<Result> implements FullDocumentImageOptions, FullDocumentImageDpiOptions, EncodeFullDocumentImagesOptions, FaceImageOptions, FaceImageDpiOptions, FullDocumentImageExtensionOptions, EncodeFaceImageOptions, CombinedRecognizer {
    public static final Parcelable.Creator<UsdlCombinedRecognizer> CREATOR;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result implements FullDocumentImageResult, EncodedFullDocumentImageResult, FaceImageResult, EncodedFaceImageResult, CombinedResult, CombinedDataMatchResult {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer.Result.1
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

        private static native boolean dataIsUncertainNativeGet(long j);

        private static native DateResult dateOfBirthNativeGet(long j);

        private static native DateResult dateOfExpiryNativeGet(long j);

        private static native DateResult dateOfIssueNativeGet(long j);

        private static native int documentDataMatchNativeGet(long j);

        private static native String documentNumberNativeGet(long j);

        private static native byte[][] dynamicElementsNativeGet(long j);

        private static native byte[] elementNativeGet(long j, int i);

        private static native byte[] encodedFaceImageNativeGet(long j);

        private static native byte[] encodedFullDocumentImageNativeGet(long j);

        private static native String endorsementsNativeGet(long j);

        private static native long faceImageNativeGet(long j);

        private static native String firstNameNativeGet(long j);

        private static native long fullDocumentImageNativeGet(long j);

        private static native String fullNameNativeGet(long j);

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

        private static native byte[] rawBytesNativeGet(long j);

        private static native String restrictionsNativeGet(long j);

        private static native boolean scanningFirstSideDoneNativeGet(long j);

        private static native String sexNativeGet(long j);

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

        public DateResult getDateOfBirth() {
            return dateOfBirthNativeGet(getNativeContext());
        }

        public DateResult getDateOfExpiry() {
            return dateOfExpiryNativeGet(getNativeContext());
        }

        public DateResult getDateOfIssue() {
            return dateOfIssueNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult
        public DataMatchResult getDocumentDataMatch() {
            return DataMatchResult.values()[documentDataMatchNativeGet(getNativeContext())];
        }

        public String getDocumentNumber() {
            return documentNumberNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult
        public byte[] getEncodedFaceImage() {
            return encodedFaceImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult
        public byte[] getEncodedFullDocumentImage() {
            return encodedFullDocumentImageNativeGet(getNativeContext());
        }

        public String getEndorsements() {
            return endorsementsNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult
        public Image getFaceImage() {
            long jFaceImageNativeGet = faceImageNativeGet(getNativeContext());
            if (jFaceImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFaceImageNativeGet, true, this);
            }
            return null;
        }

        public String getField(UsdlKeys usdlKeys) {
            return StringUtils.convertByteArrayToString(elementNativeGet(getNativeContext(), usdlKeys.ordinal()));
        }

        public String getFirstName() {
            return firstNameNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult
        public Image getFullDocumentImage() {
            long jFullDocumentImageNativeGet = fullDocumentImageNativeGet(getNativeContext());
            if (jFullDocumentImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFullDocumentImageNativeGet, true, this);
            }
            return null;
        }

        public String getFullName() {
            return fullNameNativeGet(getNativeContext());
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

        public String getVehicleClass() {
            return vehicleClassNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedResult
        public boolean isScanningFirstSideDone() {
            return scanningFirstSideDoneNativeGet(getNativeContext());
        }

        public boolean isUncertain() {
            return dataIsUncertainNativeGet(getNativeContext());
        }

        public String toString() {
            return "Usdl combined";
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

    /* JADX INFO: compiled from: line */
    public static final class VerificationConstants {
        public static final String Address = "address";
        public static final String DateOfBirth = "dateOfBirth";
        public static final String DateOfExpiry = "dateOfExpiry";
        public static final String DateOfIssue = "dateOfIssue";
        public static final String DocumentDataMatch = "documentDataMatch";
        public static final String DocumentNumber = "documentNumber";
        public static final String EncodedFaceImage = "encodedFaceImage";
        public static final String EncodedFullDocumentImage = "encodedFullDocumentImage";
        public static final String Endorsements = "endorsements";
        public static final String FaceImage = "faceImage";
        public static final String FirstName = "firstName";
        public static final String FullDocumentImage = "fullDocumentImage";
        public static final String FullName = "fullName";
        public static final String LastName = "lastName";
        public static final String MiddleName = "middleName";
        public static final String NameSuffix = "nameSuffix";
        public static final String RawData = "rawBytes";
        public static final String RawStringData = "pdf417";
        public static final String Restrictions = "restrictions";
        public static final String ScanningFirstSideDone = "scanningFirstSideDone";
        public static final String Sex = "sex";
        public static final String Uncertain = "dataIsUncertain";
        public static final String VehicleClass = "vehicleClass";
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<UsdlCombinedRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.usdl.UsdlCombinedRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UsdlCombinedRecognizer createFromParcel(Parcel parcel) {
                return new UsdlCombinedRecognizer(parcel, UsdlCombinedRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UsdlCombinedRecognizer[] newArray(int i) {
                return new UsdlCombinedRecognizer[i];
            }
        };
    }

    private static native boolean encodeFaceImageNativeGet(long j);

    private static native void encodeFaceImageNativeSet(long j, boolean z);

    private static native boolean encodeFullDocumentImageNativeGet(long j);

    private static native void encodeFullDocumentImageNativeSet(long j, boolean z);

    private static native int faceImageDpiNativeGet(long j);

    private static native void faceImageDpiNativeSet(long j, int i);

    private static native int fullDocumentImageDpiNativeGet(long j);

    private static native void fullDocumentImageDpiNativeSet(long j, int i);

    private static native float[] fullDocumentImageExtensionFactorsNativeGet(long j);

    private static native void fullDocumentImageExtensionFactorsNativeSet(long j, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native int numStableDetectionsThresholdNativeGet(long j);

    private static native void numStableDetectionsThresholdNativeSet(long j, int i);

    private static native boolean returnFaceImageNativeGet(long j);

    private static native void returnFaceImageNativeSet(long j, boolean z);

    private static native boolean returnFullDocumentImageNativeGet(long j);

    private static native void returnFullDocumentImageNativeSet(long j, boolean z);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof UsdlCombinedRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be UsdlCombinedRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    @Override // com.microblink.entities.recognizers.blinkid.CombinedRecognizer
    public CombinedResult getCombinedResult() {
        return (CombinedResult) getResult();
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions
    public int getFaceImageDpi() {
        return faceImageDpiNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions
    public int getFullDocumentImageDpi() {
        return fullDocumentImageDpiNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions
    public ImageExtensionFactors getFullDocumentImageExtensionFactors() {
        return ImageExtensionFactors.createFromArray(fullDocumentImageExtensionFactorsNativeGet(getNativeContext()));
    }

    public int getNumStableDetectionsThreshold() {
        return numStableDetectionsThresholdNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions
    public void setEncodeFaceImage(boolean z) {
        encodeFaceImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public void setEncodeFullDocumentImage(boolean z) {
        encodeFullDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions
    public void setFaceImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        faceImageDpiNativeSet(getNativeContext(), i);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions
    public void setFullDocumentImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        fullDocumentImageDpiNativeSet(getNativeContext(), i);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions
    public void setFullDocumentImageExtensionFactors(ImageExtensionFactors imageExtensionFactors) {
        fullDocumentImageExtensionFactorsNativeSet(getNativeContext(), imageExtensionFactors.serializeToArray());
    }

    public void setNumStableDetectionsThreshold(int i) {
        numStableDetectionsThresholdNativeSet(getNativeContext(), i);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions
    public void setReturnFaceImage(boolean z) {
        returnFaceImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public void setReturnFullDocumentImage(boolean z) {
        returnFullDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions
    public boolean shouldEncodeFaceImage() {
        return encodeFaceImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public boolean shouldEncodeFullDocumentImage() {
        return encodeFullDocumentImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions
    public boolean shouldReturnFaceImage() {
        return returnFaceImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public boolean shouldReturnFullDocumentImage() {
        return returnFullDocumentImageNativeGet(getNativeContext());
    }

    public UsdlCombinedRecognizer() {
        this(nativeConstruct());
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private UsdlCombinedRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private UsdlCombinedRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public UsdlCombinedRecognizer mo6353clone() {
        return new UsdlCombinedRecognizer(nativeCopy(getNativeContext()));
    }
}
