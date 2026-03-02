package com.microblink.entities.recognizers.blinkid.mrtd;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult;
import com.microblink.entities.recognizers.blinkid.CombinedRecognizer;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.blinkid.DataMatchResult;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceDetectorType;
import com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.DpiOptionsUtils;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FaceImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFaceImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.ImageExtensionFactors;
import com.microblink.entities.recognizers.blinkid.imageresult.CombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedCombinedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class MrtdCombinedRecognizer extends Recognizer<Result> implements CombinedRecognizer, FaceImageOptions, FaceImageDpiOptions, EncodeFaceImageOptions, FullDocumentImageOptions, FullDocumentImageDpiOptions, FullDocumentImageExtensionOptions, EncodeFullDocumentImagesOptions {
    public static final Parcelable.Creator<MrtdCombinedRecognizer> CREATOR;
    private MrzFilterCallback IllIIIllII;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result implements CombinedResult, CombinedDataMatchResult, FaceImageResult, EncodedFaceImageResult, CombinedFullDocumentImageResult, EncodedCombinedFullDocumentImageResult {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer.Result.1
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

        private static native int documentDataMatchNativeGet(long j);

        private static native byte[] encodedBackFullDocumentImageNativeGet(long j);

        private static native byte[] encodedFaceImageNativeGet(long j);

        private static native byte[] encodedFrontFullDocumentImageNativeGet(long j);

        private static native long faceImageNativeGet(long j);

        private static native long fullDocumentBackImageNativeGet(long j);

        private static native long fullDocumentFrontImageNativeGet(long j);

        private static native long mrzResultNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native boolean scanningFirstSideDoneNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedDataMatchResult
        public DataMatchResult getDocumentDataMatch() {
            return DataMatchResult.values()[documentDataMatchNativeGet(getNativeContext())];
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

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult
        public Image getFaceImage() {
            long jFaceImageNativeGet = faceImageNativeGet(getNativeContext());
            if (jFaceImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFaceImageNativeGet, true, this);
            }
            return null;
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

        public MrzResult getMrzResult() {
            long jMrzResultNativeGet = mrzResultNativeGet(getNativeContext());
            if (jMrzResultNativeGet != 0) {
                return new MrzResult(jMrzResultNativeGet, this);
            }
            throw new RuntimeException("Invalid native context for mrzResult");
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedResult
        public boolean isScanningFirstSideDone() {
            return scanningFirstSideDoneNativeGet(getNativeContext());
        }

        public String toString() {
            return "Mrtd Combined Recognizer";
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
        public static final String DocumentDataMatch = "documentDataMatch";
        public static final String EncodedBackFullDocumentImage = "encodedBackFullDocumentImage";
        public static final String EncodedFaceImage = "encodedFaceImage";
        public static final String EncodedFrontFullDocumentImage = "encodedFrontFullDocumentImage";
        public static final String FaceImage = "faceImage";
        public static final String FullDocumentBackImage = "fullDocumentBackImage";
        public static final String FullDocumentFrontImage = "fullDocumentFrontImage";
        public static final String MrzResult = "mrzResult";
        public static final String ScanningFirstSideDone = "scanningFirstSideDone";
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<MrtdCombinedRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.mrtd.MrtdCombinedRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MrtdCombinedRecognizer createFromParcel(Parcel parcel) {
                return new MrtdCombinedRecognizer(parcel, MrtdCombinedRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MrtdCombinedRecognizer[] newArray(int i) {
                return new MrtdCombinedRecognizer[i];
            }
        };
    }

    private static native boolean allowSpecialCharactersNativeGet(long j);

    private static native void allowSpecialCharactersNativeSet(long j, boolean z);

    private static native boolean allowUnparsedResultsNativeGet(long j);

    private static native void allowUnparsedResultsNativeSet(long j, boolean z);

    private static native boolean allowUnverifiedResultsNativeGet(long j);

    private static native void allowUnverifiedResultsNativeSet(long j, boolean z);

    private static native int detectorTypeNativeGet(long j);

    private static native void detectorTypeNativeSet(long j, int i);

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

    private static native void mrzFilterNativeSet(long j, MrzFilterCallback mrzFilterCallback);

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
            if (!(entity instanceof MrtdCombinedRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be MrtdCombinedRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    @Override // com.microblink.entities.recognizers.blinkid.CombinedRecognizer
    public CombinedResult getCombinedResult() {
        return (CombinedResult) getResult();
    }

    public DocumentFaceDetectorType getDetectorType() {
        return DocumentFaceDetectorType.values()[detectorTypeNativeGet(getNativeContext())];
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

    public boolean isAllowSpecialCharacters() {
        return allowSpecialCharactersNativeGet(getNativeContext());
    }

    public boolean isAllowUnparsedResults() {
        return allowUnparsedResultsNativeGet(getNativeContext());
    }

    public boolean isAllowUnverifiedResults() {
        return allowUnverifiedResultsNativeGet(getNativeContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(Parcel parcel) {
        MrzFilter mrzFilter = (MrzFilter) parcel.readParcelable(MrzFilter.class.getClassLoader());
        this.IllIIIllII = null;
        if (mrzFilter != null) {
            this.IllIIIllII = new MrzFilterCallback(mrzFilter, ((Result) getResult()).getMrzResult());
        }
        mrzFilterNativeSet(getNativeContext(), this.IllIIIllII);
        super.llIIlIlIIl(parcel);
    }

    public void setAllowSpecialCharacters(boolean z) {
        allowSpecialCharactersNativeSet(getNativeContext(), z);
    }

    public void setAllowUnparsedResults(boolean z) {
        allowUnparsedResultsNativeSet(getNativeContext(), z);
    }

    public void setAllowUnverifiedResults(boolean z) {
        allowUnverifiedResultsNativeSet(getNativeContext(), z);
    }

    public void setDetectorType(DocumentFaceDetectorType documentFaceDetectorType) {
        detectorTypeNativeSet(getNativeContext(), documentFaceDetectorType.ordinal());
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

    /* JADX WARN: Multi-variable type inference failed */
    public void setMRZFilter(MrzFilter mrzFilter) {
        if (mrzFilter != null) {
            this.IllIIIllII = new MrzFilterCallback(mrzFilter, ((Result) getResult()).getMrzResult());
        } else {
            this.IllIIIllII = null;
        }
        mrzFilterNativeSet(getNativeContext(), this.IllIIIllII);
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

    @Override // com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        MrzFilterCallback mrzFilterCallback = this.IllIIIllII;
        if (mrzFilterCallback != null) {
            parcel.writeParcelable(mrzFilterCallback.IlIllIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        super.writeToParcel(parcel, i);
    }

    public MrtdCombinedRecognizer() {
        this(nativeConstruct());
    }

    private MrtdCombinedRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    private MrtdCombinedRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public MrtdCombinedRecognizer mo6353clone() {
        return new MrtdCombinedRecognizer(nativeCopy(getNativeContext()));
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
