package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.AgeLimitStatus;
import com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult;
import com.microblink.entities.recognizers.blinkid.CombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;
import com.microblink.entities.recognizers.blinkid.ProcessingStatusResult;
import com.microblink.entities.recognizers.blinkid.generic.barcode.BarcodeResult;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfo;
import com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfoResult;
import com.microblink.entities.recognizers.blinkid.generic.imageanalysis.ImageAnalysisResult;
import com.microblink.entities.recognizers.blinkid.generic.viz.VizResult;
import com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.SignatureImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.DpiOptionsUtils;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeSignatureImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.ImageExtensionFactors;
import com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedSignatureImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.SignatureImageResult;
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.entities.recognizers.classifier.ClassifierCallback;
import com.microblink.entities.recognizers.classifier.ClassifierCallbackOptions;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.results.date.Date;
import com.microblink.results.date.DateResult;
import com.microblink.results.date.DateUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class BlinkIdCombinedRecognizer extends Recognizer<Result> implements CombinedRecognizer, FaceImageOptions, FaceImageDpiOptions, EncodeFaceImageOptions, FullDocumentImageOptions, FullDocumentImageDpiOptions, FullDocumentImageExtensionOptions, EncodeFullDocumentImagesOptions, SignatureImageOptions, SignatureImageDpiOptions, EncodeSignatureImageOptions, ClassifierCallbackOptions, BarcodeScanningStartedCallbackOptions {
    public static final Parcelable.Creator<BlinkIdCombinedRecognizer> CREATOR;
    private NativeBarcodeScanningStartedCallbackCallback IllIIIIllI;
    private NativeDewarpedImageCallback IllIIIllII;
    private NativeClassFilter lIlIIIIlIl;
    private NativeClassifierCallback llIIIlllll;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result implements CombinedResult, CombinedDataMatchResult, FaceImageResult, EncodedFaceImageResult, CombinedFullDocumentImageResult, EncodedCombinedFullDocumentImageResult, SignatureImageResult, EncodedSignatureImageResult, ProcessingStatusResult, ClassInfoResult {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.Result.1
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

        private static native String additionalAddressInformationNativeGet(long j);

        private static native String additionalNameInformationNativeGet(long j);

        private static native String additionalOptionalAddressInformationNativeGet(long j);

        private static native String addressNativeGet(long j);

        private static native long backCameraFrameNativeGet(long j);

        private static native ImageAnalysisResult backImageAnalysisResultNativeGet(long j);

        private static native int backProcessingStatusNativeGet(long j);

        private static native long backVizResultNativeGet(long j);

        private static native long barcodeCameraFrameNativeGet(long j);

        private static native long barcodeResultNativeGet(long j);

        private static native long classInfoNativeGet(long j);

        private static native DataMatchDetailedInfo dataMatchDetailedInfoNativeGet(long j);

        private static native DateResult dateOfBirthNativeGet(long j);

        private static native DateResult dateOfExpiryNativeGet(long j);

        private static native boolean dateOfExpiryPermanentNativeGet(long j);

        private static native DateResult dateOfIssueNativeGet(long j);

        private static native String documentAdditionalNumberNativeGet(long j);

        private static native int documentDataMatchNativeGet(long j);

        private static native String documentNumberNativeGet(long j);

        private static native String documentOptionalAdditionalNumberNativeGet(long j);

        private static native DriverLicenseDetailedInfo driverLicenseDetailedInfoNativeGet(long j);

        private static native String employerNativeGet(long j);

        private static native byte[] encodedBackFullDocumentImageNativeGet(long j);

        private static native byte[] encodedFaceImageNativeGet(long j);

        private static native byte[] encodedFrontFullDocumentImageNativeGet(long j);

        private static native byte[] encodedSignatureImageNativeGet(long j);

        private static native long faceImageNativeGet(long j);

        private static native String fathersNameNativeGet(long j);

        private static native String firstNameNativeGet(long j);

        private static native long frontCameraFrameNativeGet(long j);

        private static native ImageAnalysisResult frontImageAnalysisResultNativeGet(long j);

        private static native int frontProcessingStatusNativeGet(long j);

        private static native long frontVizResultNativeGet(long j);

        private static native long fullDocumentBackImageNativeGet(long j);

        private static native long fullDocumentFrontImageNativeGet(long j);

        private static native String fullNameNativeGet(long j);

        private static native String issuingAuthorityNativeGet(long j);

        private static native String lastNameNativeGet(long j);

        private static native String localizedNameNativeGet(long j);

        private static native String maritalStatusNativeGet(long j);

        private static native String mothersNameNativeGet(long j);

        private static native long mrzResultNativeGet(long j);

        private static native String nationalityNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native String personalIdNumberNativeGet(long j);

        private static native String placeOfBirthNativeGet(long j);

        private static native int processingStatusNativeGet(long j);

        private static native String professionNativeGet(long j);

        private static native String raceNativeGet(long j);

        private static native int recognitionModeNativeGet(long j);

        private static native String religionNativeGet(long j);

        private static native String residentialStatusNativeGet(long j);

        private static native boolean scanningFirstSideDoneNativeGet(long j);

        private static native String sexNativeGet(long j);

        private static native long signatureImageNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public String getAdditionalAddressInformation() {
            return additionalAddressInformationNativeGet(getNativeContext());
        }

        public String getAdditionalNameInformation() {
            return additionalNameInformationNativeGet(getNativeContext());
        }

        public String getAdditionalOptionalAddressInformation() {
            return additionalOptionalAddressInformationNativeGet(getNativeContext());
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

        public Image getBackCameraFrame() {
            long jBackCameraFrameNativeGet = backCameraFrameNativeGet(getNativeContext());
            if (jBackCameraFrameNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jBackCameraFrameNativeGet, true, this);
            }
            return null;
        }

        public ImageAnalysisResult getBackImageAnalysisResult() {
            return backImageAnalysisResultNativeGet(getNativeContext());
        }

        public ProcessingStatus getBackProcessingStatus() {
            return ProcessingStatus.values()[backProcessingStatusNativeGet(getNativeContext())];
        }

        public VizResult getBackVizResult() {
            long jBackVizResultNativeGet = backVizResultNativeGet(getNativeContext());
            if (jBackVizResultNativeGet != 0) {
                return new VizResult(jBackVizResultNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for backVizResult");
        }

        public Image getBarcodeCameraFrame() {
            long jBarcodeCameraFrameNativeGet = barcodeCameraFrameNativeGet(getNativeContext());
            if (jBarcodeCameraFrameNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jBarcodeCameraFrameNativeGet, true, this);
            }
            return null;
        }

        public BarcodeResult getBarcodeResult() {
            long jBarcodeResultNativeGet = barcodeResultNativeGet(getNativeContext());
            if (jBarcodeResultNativeGet != 0) {
                return new BarcodeResult(jBarcodeResultNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for barcodeResult");
        }

        @Override // com.microblink.entities.recognizers.blinkid.generic.classinfo.ClassInfoResult
        public ClassInfo getClassInfo() {
            long jClassInfoNativeGet = classInfoNativeGet(getNativeContext());
            if (jClassInfoNativeGet != 0) {
                return new ClassInfo(jClassInfoNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for classInfo");
        }

        public DataMatchDetailedInfo getDataMatchDetailedInfo() {
            return dataMatchDetailedInfoNativeGet(getNativeContext());
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

        @Override // com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult
        public DataMatchResult getDocumentDataMatch() {
            return DataMatchResult.values()[documentDataMatchNativeGet(getNativeContext())];
        }

        public String getDocumentNumber() {
            return documentNumberNativeGet(getNativeContext());
        }

        public String getDocumentOptionalAdditionalNumber() {
            return documentOptionalAdditionalNumberNativeGet(getNativeContext());
        }

        public DriverLicenseDetailedInfo getDriverLicenseDetailedInfo() {
            return driverLicenseDetailedInfoNativeGet(getNativeContext());
        }

        public String getEmployer() {
            return employerNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult
        public byte[] getEncodedBackFullDocumentImage() {
            return encodedBackFullDocumentImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult
        public byte[] getEncodedFaceImage() {
            return encodedFaceImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult
        public byte[] getEncodedFrontFullDocumentImage() {
            return encodedFrontFullDocumentImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedSignatureImageResult
        public byte[] getEncodedSignatureImage() {
            return encodedSignatureImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult
        public Image getFaceImage() {
            long jFaceImageNativeGet = faceImageNativeGet(getNativeContext());
            if (jFaceImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFaceImageNativeGet, true, this);
            }
            return null;
        }

        public String getFathersName() {
            return fathersNameNativeGet(getNativeContext());
        }

        public String getFirstName() {
            return firstNameNativeGet(getNativeContext());
        }

        public Image getFrontCameraFrame() {
            long jFrontCameraFrameNativeGet = frontCameraFrameNativeGet(getNativeContext());
            if (jFrontCameraFrameNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFrontCameraFrameNativeGet, true, this);
            }
            return null;
        }

        public ImageAnalysisResult getFrontImageAnalysisResult() {
            return frontImageAnalysisResultNativeGet(getNativeContext());
        }

        public ProcessingStatus getFrontProcessingStatus() {
            return ProcessingStatus.values()[frontProcessingStatusNativeGet(getNativeContext())];
        }

        public VizResult getFrontVizResult() {
            long jFrontVizResultNativeGet = frontVizResultNativeGet(getNativeContext());
            if (jFrontVizResultNativeGet != 0) {
                return new VizResult(jFrontVizResultNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for frontVizResult");
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult
        public Image getFullDocumentBackImage() {
            long jFullDocumentBackImageNativeGet = fullDocumentBackImageNativeGet(getNativeContext());
            if (jFullDocumentBackImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFullDocumentBackImageNativeGet, true, this);
            }
            return null;
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult
        public Image getFullDocumentFrontImage() {
            long jFullDocumentFrontImageNativeGet = fullDocumentFrontImageNativeGet(getNativeContext());
            if (jFullDocumentFrontImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFullDocumentFrontImageNativeGet, true, this);
            }
            return null;
        }

        public String getFullName() {
            return fullNameNativeGet(getNativeContext());
        }

        public String getIssuingAuthority() {
            return issuingAuthorityNativeGet(getNativeContext());
        }

        public String getLastName() {
            return lastNameNativeGet(getNativeContext());
        }

        public String getLocalizedName() {
            return localizedNameNativeGet(getNativeContext());
        }

        public String getMaritalStatus() {
            return maritalStatusNativeGet(getNativeContext());
        }

        public String getMothersName() {
            return mothersNameNativeGet(getNativeContext());
        }

        public MrzResult getMrzResult() {
            long jMrzResultNativeGet = mrzResultNativeGet(getNativeContext());
            if (jMrzResultNativeGet != 0) {
                return new MrzResult(jMrzResultNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for mrzResult");
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

        @Override // com.microblink.entities.recognizers.blinkid.ProcessingStatusResult
        public ProcessingStatus getProcessingStatus() {
            return ProcessingStatus.values()[processingStatusNativeGet(getNativeContext())];
        }

        public String getProfession() {
            return professionNativeGet(getNativeContext());
        }

        public String getRace() {
            return raceNativeGet(getNativeContext());
        }

        public RecognitionMode getRecognitionMode() {
            return RecognitionMode.values()[recognitionModeNativeGet(getNativeContext())];
        }

        public String getReligion() {
            return religionNativeGet(getNativeContext());
        }

        public String getResidentialStatus() {
            return residentialStatusNativeGet(getNativeContext());
        }

        public String getSex() {
            return sexNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.SignatureImageResult
        public Image getSignatureImage() {
            long jSignatureImageNativeGet = signatureImageNativeGet(getNativeContext());
            if (jSignatureImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jSignatureImageNativeGet, true, this);
            }
            return null;
        }

        public boolean isDateOfExpiryPermanent() {
            return dateOfExpiryPermanentNativeGet(getNativeContext());
        }

        public boolean isExpired() {
            Date date;
            if (isDateOfExpiryPermanent() || (date = getDateOfExpiry().getDate()) == null) {
                return false;
            }
            return DateUtils.isDatePassed(date);
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedResult
        public boolean isScanningFirstSideDone() {
            return scanningFirstSideDoneNativeGet(getNativeContext());
        }

        public String toString() {
            return "Blink Id Combined Recognizer";
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
        public static final String AdditionalAddressInformation = "additionalAddressInformation";
        public static final String AdditionalNameInformation = "additionalNameInformation";
        public static final String AdditionalOptionalAddressInformation = "additionalOptionalAddressInformation";
        public static final String Address = "address";
        public static final String BackCameraFrame = "backCameraFrame";
        public static final String BackImageAnalysisResult = "backImageAnalysisResult";
        public static final String BackProcessingStatus = "backProcessingStatus";
        public static final String BackVizResult = "backVizResult";
        public static final String BarcodeCameraFrame = "barcodeCameraFrame";
        public static final String BarcodeResult = "barcodeResult";
        public static final String ClassInfo = "classInfo";
        public static final String DataMatchDetailedInfo = "dataMatchDetailedInfo";
        public static final String DateOfBirth = "dateOfBirth";
        public static final String DateOfExpiry = "dateOfExpiry";
        public static final String DateOfExpiryPermanent = "dateOfExpiryPermanent";
        public static final String DateOfIssue = "dateOfIssue";
        public static final String DocumentAdditionalNumber = "documentAdditionalNumber";
        public static final String DocumentDataMatch = "documentDataMatch";
        public static final String DocumentNumber = "documentNumber";
        public static final String DocumentOptionalAdditionalNumber = "documentOptionalAdditionalNumber";
        public static final String DriverLicenseDetailedInfo = "driverLicenseDetailedInfo";
        public static final String Employer = "employer";
        public static final String EncodedBackFullDocumentImage = "encodedBackFullDocumentImage";
        public static final String EncodedFaceImage = "encodedFaceImage";
        public static final String EncodedFrontFullDocumentImage = "encodedFrontFullDocumentImage";
        public static final String EncodedSignatureImage = "encodedSignatureImage";
        public static final String FaceImage = "faceImage";
        public static final String FathersName = "fathersName";
        public static final String FirstName = "firstName";
        public static final String FrontCameraFrame = "frontCameraFrame";
        public static final String FrontImageAnalysisResult = "frontImageAnalysisResult";
        public static final String FrontProcessingStatus = "frontProcessingStatus";
        public static final String FrontVizResult = "frontVizResult";
        public static final String FullDocumentBackImage = "fullDocumentBackImage";
        public static final String FullDocumentFrontImage = "fullDocumentFrontImage";
        public static final String FullName = "fullName";
        public static final String IssuingAuthority = "issuingAuthority";
        public static final String LastName = "lastName";
        public static final String LocalizedName = "localizedName";
        public static final String MaritalStatus = "maritalStatus";
        public static final String MothersName = "mothersName";
        public static final String MrzResult = "mrzResult";
        public static final String Nationality = "nationality";
        public static final String PersonalIdNumber = "personalIdNumber";
        public static final String PlaceOfBirth = "placeOfBirth";
        public static final String ProcessingStatus = "processingStatus";
        public static final String Profession = "profession";
        public static final String Race = "race";
        public static final String RecognitionMode = "recognitionMode";
        public static final String Religion = "religion";
        public static final String ResidentialStatus = "residentialStatus";
        public static final String ScanningFirstSideDone = "scanningFirstSideDone";
        public static final String Sex = "sex";
        public static final String SignatureImage = "signatureImage";
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<BlinkIdCombinedRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.generic.BlinkIdCombinedRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlinkIdCombinedRecognizer createFromParcel(Parcel parcel) {
                return new BlinkIdCombinedRecognizer(parcel, BlinkIdCombinedRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BlinkIdCombinedRecognizer[] newArray(int i) {
                return new BlinkIdCombinedRecognizer[i];
            }
        };
    }

    private static native boolean allowBlurFilterNativeGet(long j);

    private static native void allowBlurFilterNativeSet(long j, boolean z);

    private static native boolean allowUncertainFrontSideScanNativeGet(long j);

    private static native void allowUncertainFrontSideScanNativeSet(long j, boolean z);

    private static native boolean allowUnparsedMrzResultsNativeGet(long j);

    private static native void allowUnparsedMrzResultsNativeSet(long j, boolean z);

    private static native boolean allowUnverifiedMrzResultsNativeGet(long j);

    private static native void allowUnverifiedMrzResultsNativeSet(long j, boolean z);

    private static native int anonymizationModeNativeGet(long j);

    private static native void anonymizationModeNativeSet(long j, int i);

    private static native void barcodeScanningStartedCallbackNativeSet(long j, NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback);

    private static native void classFilterNativeSet(long j, NativeClassFilter nativeClassFilter);

    private static native void classifierCallbackNativeSet(long j, NativeClassifierCallback nativeClassifierCallback);

    private static native void dewarpedImageCallbackNativeSet(long j, NativeDewarpedImageCallback nativeDewarpedImageCallback);

    private static native boolean encodeFaceImageNativeGet(long j);

    private static native void encodeFaceImageNativeSet(long j, boolean z);

    private static native boolean encodeFullDocumentImageNativeGet(long j);

    private static native void encodeFullDocumentImageNativeSet(long j, boolean z);

    private static native boolean encodeSignatureImageNativeGet(long j);

    private static native void encodeSignatureImageNativeSet(long j, boolean z);

    private static native int faceImageDpiNativeGet(long j);

    private static native void faceImageDpiNativeSet(long j, int i);

    private static native int fullDocumentImageDpiNativeGet(long j);

    private static native void fullDocumentImageDpiNativeSet(long j, int i);

    private static native float[] fullDocumentImageExtensionFactorsNativeGet(long j);

    private static native void fullDocumentImageExtensionFactorsNativeSet(long j, float[] fArr);

    private static native int maxAllowedMismatchesPerFieldNativeGet(long j);

    private static native void maxAllowedMismatchesPerFieldNativeSet(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native float paddingEdgeNativeGet(long j);

    private static native void paddingEdgeNativeSet(long j, float f);

    private static native boolean[] recognitionModeFilterNativeGet(long j);

    private static native void recognitionModeFilterNativeSet(long j, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    private static native boolean returnFaceImageNativeGet(long j);

    private static native void returnFaceImageNativeSet(long j, boolean z);

    private static native boolean returnFullDocumentImageNativeGet(long j);

    private static native void returnFullDocumentImageNativeSet(long j, boolean z);

    private static native boolean returnSignatureImageNativeGet(long j);

    private static native void returnSignatureImageNativeSet(long j, boolean z);

    private static native boolean saveCameraFramesNativeGet(long j);

    private static native void saveCameraFramesNativeSet(long j, boolean z);

    private static native boolean scanCroppedDocumentImageNativeGet(long j);

    private static native void scanCroppedDocumentImageNativeSet(long j, boolean z);

    private static native int signatureImageDpiNativeGet(long j);

    private static native void signatureImageDpiNativeSet(long j, int i);

    private static native boolean skipUnsupportedBackNativeGet(long j);

    private static native void skipUnsupportedBackNativeSet(long j, boolean z);

    private static native boolean validateResultCharactersNativeGet(long j);

    private static native void validateResultCharactersNativeSet(long j, boolean z);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof BlinkIdCombinedRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be BlinkIdCombinedRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    public AnonymizationMode getAnonymizationMode() {
        return AnonymizationMode.values()[anonymizationModeNativeGet(getNativeContext())];
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

    public int getMaxAllowedMismatchesPerField() {
        return maxAllowedMismatchesPerFieldNativeGet(getNativeContext());
    }

    public float getPaddingEdge() {
        return paddingEdgeNativeGet(getNativeContext());
    }

    public RecognitionModeFilter getRecognitionModeFilter() {
        boolean[] zArrRecognitionModeFilterNativeGet = recognitionModeFilterNativeGet(getNativeContext());
        return zArrRecognitionModeFilterNativeGet.length == 5 ? new RecognitionModeFilter(zArrRecognitionModeFilterNativeGet[0], zArrRecognitionModeFilterNativeGet[1], zArrRecognitionModeFilterNativeGet[2], zArrRecognitionModeFilterNativeGet[3], zArrRecognitionModeFilterNativeGet[4], zArrRecognitionModeFilterNativeGet[5]) : new RecognitionModeFilter();
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiOptions
    public int getSignatureImageDpi() {
        return signatureImageDpiNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(Parcel parcel) {
        DewarpedImageCallback dewarpedImageCallback = (DewarpedImageCallback) parcel.readParcelable(DewarpedImageCallback.class.getClassLoader());
        this.IllIIIllII = null;
        if (dewarpedImageCallback != null) {
            this.IllIIIllII = new NativeDewarpedImageCallback(dewarpedImageCallback);
        }
        dewarpedImageCallbackNativeSet(getNativeContext(), this.IllIIIllII);
        ClassifierCallback classifierCallback = (ClassifierCallback) parcel.readParcelable(ClassifierCallback.class.getClassLoader());
        this.llIIIlllll = null;
        if (classifierCallback != null) {
            this.llIIIlllll = new NativeClassifierCallback(classifierCallback);
        }
        classifierCallbackNativeSet(getNativeContext(), this.llIIIlllll);
        BarcodeScanningStartedCallback barcodeScanningStartedCallback = (BarcodeScanningStartedCallback) parcel.readParcelable(BarcodeScanningStartedCallback.class.getClassLoader());
        this.IllIIIIllI = null;
        if (barcodeScanningStartedCallback != null) {
            this.IllIIIIllI = new NativeBarcodeScanningStartedCallbackCallback(barcodeScanningStartedCallback);
        }
        barcodeScanningStartedCallbackNativeSet(getNativeContext(), this.IllIIIIllI);
        ClassFilter classFilter = (ClassFilter) parcel.readParcelable(ClassFilter.class.getClassLoader());
        this.lIlIIIIlIl = null;
        if (classFilter != null) {
            this.lIlIIIIlIl = new NativeClassFilter(classFilter);
        }
        classFilterNativeSet(getNativeContext(), this.lIlIIIIlIl);
        super.llIIlIlIIl(parcel);
    }

    public void setAllowBlurFilter(boolean z) {
        allowBlurFilterNativeSet(getNativeContext(), z);
    }

    public void setAllowUncertainFrontSideScan(boolean z) {
        allowUncertainFrontSideScanNativeSet(getNativeContext(), z);
    }

    public void setAllowUnparsedMrzResults(boolean z) {
        allowUnparsedMrzResultsNativeSet(getNativeContext(), z);
    }

    public void setAllowUnverifiedMrzResults(boolean z) {
        allowUnverifiedMrzResultsNativeSet(getNativeContext(), z);
    }

    public void setAnonymizationMode(AnonymizationMode anonymizationMode) {
        anonymizationModeNativeSet(getNativeContext(), anonymizationMode.ordinal());
    }

    @Override // com.microblink.entities.recognizers.blinkid.generic.BarcodeScanningStartedCallbackOptions
    public void setBarcodeScanningStartedCallback(BarcodeScanningStartedCallback barcodeScanningStartedCallback) {
        NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback = this.IllIIIIllI;
        if (nativeBarcodeScanningStartedCallbackCallback != null) {
            nativeBarcodeScanningStartedCallbackCallback.llIIlIlIIl = barcodeScanningStartedCallback;
        } else {
            this.IllIIIIllI = new NativeBarcodeScanningStartedCallbackCallback(barcodeScanningStartedCallback);
            barcodeScanningStartedCallbackNativeSet(getNativeContext(), this.IllIIIIllI);
        }
    }

    public void setClassFilter(ClassFilter classFilter) {
        NativeClassFilter nativeClassFilter = this.lIlIIIIlIl;
        if (nativeClassFilter != null) {
            nativeClassFilter.llIIlIlIIl = classFilter;
        } else {
            this.lIlIIIIlIl = new NativeClassFilter(classFilter);
            classFilterNativeSet(getNativeContext(), this.lIlIIIIlIl);
        }
    }

    @Override // com.microblink.entities.recognizers.classifier.ClassifierCallbackOptions
    public void setClassifierCallback(ClassifierCallback classifierCallback) {
        NativeClassifierCallback nativeClassifierCallback = this.llIIIlllll;
        if (nativeClassifierCallback != null) {
            nativeClassifierCallback.llIIlIlIIl = classifierCallback;
        } else {
            this.llIIIlllll = new NativeClassifierCallback(classifierCallback);
            classifierCallbackNativeSet(getNativeContext(), this.llIIIlllll);
        }
    }

    public void setDewarpedImageCallback(DewarpedImageCallback dewarpedImageCallback) {
        NativeDewarpedImageCallback nativeDewarpedImageCallback = this.IllIIIllII;
        if (nativeDewarpedImageCallback != null) {
            nativeDewarpedImageCallback.llIIlIlIIl = dewarpedImageCallback;
        } else {
            this.IllIIIllII = new NativeDewarpedImageCallback(dewarpedImageCallback);
            dewarpedImageCallbackNativeSet(getNativeContext(), this.IllIIIllII);
        }
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions
    public void setEncodeFaceImage(boolean z) {
        encodeFaceImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public void setEncodeFullDocumentImage(boolean z) {
        encodeFullDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeSignatureImageOptions
    public void setEncodeSignatureImage(boolean z) {
        encodeSignatureImageNativeSet(getNativeContext(), z);
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

    public void setMaxAllowedMismatchesPerField(int i) {
        maxAllowedMismatchesPerFieldNativeSet(getNativeContext(), i);
    }

    public void setPaddingEdge(float f) {
        paddingEdgeNativeSet(getNativeContext(), f);
    }

    public void setRecognitionModeFilter(RecognitionModeFilter recognitionModeFilter) {
        recognitionModeFilterNativeSet(getNativeContext(), recognitionModeFilter.enableMrzId, recognitionModeFilter.enableMrzVisa, recognitionModeFilter.enableMrzPassport, recognitionModeFilter.enablePhotoId, recognitionModeFilter.enableBarcodeId, recognitionModeFilter.enableFullDocumentRecognition);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions
    public void setReturnFaceImage(boolean z) {
        returnFaceImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public void setReturnFullDocumentImage(boolean z) {
        returnFullDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.SignatureImageOptions
    public void setReturnSignatureImage(boolean z) {
        returnSignatureImageNativeSet(getNativeContext(), z);
    }

    public void setSaveCameraFrames(boolean z) {
        saveCameraFramesNativeSet(getNativeContext(), z);
    }

    public void setScanCroppedDocumentImage(boolean z) {
        scanCroppedDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.SignatureImageDpiOptions
    public void setSignatureImageDpi(int i) {
        DpiOptionsUtils.checkDpiRange(i);
        signatureImageDpiNativeSet(getNativeContext(), i);
    }

    public void setSkipUnsupportedBack(boolean z) {
        skipUnsupportedBackNativeSet(getNativeContext(), z);
    }

    public void setValidateResultCharacters(boolean z) {
        validateResultCharactersNativeSet(getNativeContext(), z);
    }

    public boolean shouldAllowBlurFilter() {
        return allowBlurFilterNativeGet(getNativeContext());
    }

    public boolean shouldAllowUncertainFrontSideScan() {
        return allowUncertainFrontSideScanNativeGet(getNativeContext());
    }

    public boolean shouldAllowUnparsedMrzResults() {
        return allowUnparsedMrzResultsNativeGet(getNativeContext());
    }

    public boolean shouldAllowUnverifiedMrzResults() {
        return allowUnverifiedMrzResultsNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions
    public boolean shouldEncodeFaceImage() {
        return encodeFaceImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public boolean shouldEncodeFullDocumentImage() {
        return encodeFullDocumentImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeSignatureImageOptions
    public boolean shouldEncodeSignatureImage() {
        return encodeSignatureImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions
    public boolean shouldReturnFaceImage() {
        return returnFaceImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public boolean shouldReturnFullDocumentImage() {
        return returnFullDocumentImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.SignatureImageOptions
    public boolean shouldReturnSignatureImage() {
        return returnSignatureImageNativeGet(getNativeContext());
    }

    public boolean shouldSaveCameraFrames() {
        return saveCameraFramesNativeGet(getNativeContext());
    }

    public boolean shouldScanCroppedDocumentImage() {
        return scanCroppedDocumentImageNativeGet(getNativeContext());
    }

    public boolean shouldSkipUnsupportedBack() {
        return skipUnsupportedBackNativeGet(getNativeContext());
    }

    public boolean shouldValidateResultCharacters() {
        return validateResultCharactersNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        NativeDewarpedImageCallback nativeDewarpedImageCallback = this.IllIIIllII;
        if (nativeDewarpedImageCallback != null) {
            parcel.writeParcelable(nativeDewarpedImageCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeClassifierCallback nativeClassifierCallback = this.llIIIlllll;
        if (nativeClassifierCallback != null) {
            parcel.writeParcelable(nativeClassifierCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback = this.IllIIIIllI;
        if (nativeBarcodeScanningStartedCallbackCallback != null) {
            parcel.writeParcelable(nativeBarcodeScanningStartedCallbackCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeClassFilter nativeClassFilter = this.lIlIIIIlIl;
        if (nativeClassFilter != null) {
            parcel.writeParcelable(nativeClassFilter.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        super.writeToParcel(parcel, i);
    }

    public BlinkIdCombinedRecognizer() {
        this(nativeConstruct());
    }

    private BlinkIdCombinedRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    private BlinkIdCombinedRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public BlinkIdCombinedRecognizer mo6353clone() {
        return new BlinkIdCombinedRecognizer(nativeCopy(getNativeContext()));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }
}
