package com.microblink.entities.recognizers.blinkid.mrtd;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.detectors.quad.mrtd.MrtdSpecification;
import com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.DpiOptionsUtils;
import com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions;
import com.microblink.entities.recognizers.blinkid.imageoptions.extension.ImageExtensionFactors;
import com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult;
import com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult;
import com.microblink.entities.recognizers.templating.TemplatingRecognizer;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;
import com.microblink.results.ocr.OcrResult;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class MrtdRecognizer extends TemplatingRecognizer<Result> implements FullDocumentImageOptions, FullDocumentImageDpiOptions, FullDocumentImageExtensionOptions, EncodeFullDocumentImagesOptions {
    public static final Parcelable.Creator<MrtdRecognizer> CREATOR;
    private MrzFilterCallback llIIIlllll;

    /* JADX INFO: compiled from: line */
    public static final class Result extends TemplatingRecognizer.Result implements FullDocumentImageResult, EncodedFullDocumentImageResult {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer.Result.1
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

        private static native byte[] encodedFullDocumentImageNativeGet(long j);

        private static native long fullDocumentImageNativeGet(long j);

        private static native long mrzOcrResultNativeGet(long j);

        private static native long mrzResultNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native int nativeGetClassID(long j);

        private static native byte[] nativeSerialize(long j);

        private static native void nativeSetNativeClass(long j, int i);

        @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer.Result
        protected int IlIllIlIIl(long j) {
            return nativeGetClassID(j);
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult
        public byte[] getEncodedFullDocumentImage() {
            return encodedFullDocumentImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult
        public Image getFullDocumentImage() {
            long jFullDocumentImageNativeGet = fullDocumentImageNativeGet(getNativeContext());
            if (jFullDocumentImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFullDocumentImageNativeGet, true, this);
            }
            return null;
        }

        public OcrResult getMrzOcrResult() {
            long jMrzOcrResultNativeGet = mrzOcrResultNativeGet(getNativeContext());
            if (jMrzOcrResultNativeGet != 0) {
                return new OcrResult(jMrzOcrResultNativeGet, this);
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

        public String toString() {
            return getMrzResult().toString();
        }

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer.Result
        protected void llIIlIlIIl(long j, int i) {
            nativeSetNativeClass(j, i);
        }

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        @Override // com.microblink.entities.recognizers.Recognizer.Result, com.microblink.entities.Entity.Result
        /* JADX INFO: renamed from: clone */
        public Result mo6354clone() {
            return new Result(nativeCopy(getNativeContext()));
        }

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(long j) {
            nativeDestruct(j);
        }
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<MrtdRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.mrtd.MrtdRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MrtdRecognizer createFromParcel(Parcel parcel) {
                return new MrtdRecognizer(parcel, MrtdRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MrtdRecognizer[] newArray(int i) {
                return new MrtdRecognizer[i];
            }
        };
    }

    private static native boolean allowSpecialCharactersNativeGet(long j);

    private static native void allowSpecialCharactersNativeSet(long j, boolean z);

    private static native boolean allowUnparsedResultsNativeGet(long j);

    private static native void allowUnparsedResultsNativeSet(long j, boolean z);

    private static native boolean allowUnverifiedResultsNativeGet(long j);

    private static native void allowUnverifiedResultsNativeSet(long j, boolean z);

    private static native boolean detectGlareNativeGet(long j);

    private static native void detectGlareNativeSet(long j, boolean z);

    private static native boolean encodeFullDocumentImageNativeGet(long j);

    private static native void encodeFullDocumentImageNativeSet(long j, boolean z);

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

    private static native void nativeSetTemplatingClasses(long j, long[] jArr);

    private static native boolean returnFullDocumentImageNativeGet(long j);

    private static native void returnFullDocumentImageNativeSet(long j, boolean z);

    private static native long[] specificationsNativeGet(long j);

    private static native void specificationsNativeSet(long j, long[] jArr);

    @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer, com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        super.consumeResultFrom(entity);
        if (this != entity) {
            if (!(entity instanceof MrtdRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be MrtdRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.dpi.FullDocumentImageDpiOptions
    public int getFullDocumentImageDpi() {
        return fullDocumentImageDpiNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.extension.FullDocumentImageExtensionOptions
    public ImageExtensionFactors getFullDocumentImageExtensionFactors() {
        return ImageExtensionFactors.createFromArray(fullDocumentImageExtensionFactorsNativeGet(getNativeContext()));
    }

    public MrtdSpecification[] getSpecifications() {
        long[] jArrSpecificationsNativeGet = specificationsNativeGet(getNativeContext());
        MrtdSpecification[] mrtdSpecificationArr = new MrtdSpecification[jArrSpecificationsNativeGet.length];
        for (int i = 0; i < jArrSpecificationsNativeGet.length; i++) {
            mrtdSpecificationArr[i] = new MrtdSpecification(jArrSpecificationsNativeGet[i]);
        }
        return mrtdSpecificationArr;
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

    @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer
    protected void llIIlIlIIl(long[] jArr) {
        nativeSetTemplatingClasses(getNativeContext(), jArr);
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

    @Override // com.microblink.entities.settings.GlareDetectorOptions
    public void setDetectGlare(boolean z) {
        detectGlareNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public void setEncodeFullDocumentImage(boolean z) {
        encodeFullDocumentImageNativeSet(getNativeContext(), z);
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
            this.llIIIlllll = new MrzFilterCallback(mrzFilter, ((Result) getResult()).getMrzResult());
        } else {
            this.llIIIlllll = null;
        }
        mrzFilterNativeSet(getNativeContext(), this.llIIIlllll);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public void setReturnFullDocumentImage(boolean z) {
        returnFullDocumentImageNativeSet(getNativeContext(), z);
    }

    public void setSpecifications(MrtdSpecification... mrtdSpecificationArr) {
        if (mrtdSpecificationArr == null || mrtdSpecificationArr.length == 0) {
            specificationsNativeSet(getNativeContext(), null);
            return;
        }
        long[] jArr = new long[mrtdSpecificationArr.length];
        for (int i = 0; i < mrtdSpecificationArr.length; i++) {
            jArr[i] = mrtdSpecificationArr[i].getNativeContext();
        }
        specificationsNativeSet(getNativeContext(), jArr);
    }

    @Override // com.microblink.entities.settings.GlareDetectorOptions
    public boolean shouldDetectGlare() {
        return detectGlareNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.encode.EncodeFullDocumentImagesOptions
    public boolean shouldEncodeFullDocumentImage() {
        return encodeFullDocumentImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public boolean shouldReturnFullDocumentImage() {
        return returnFullDocumentImageNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer, com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        MrzFilterCallback mrzFilterCallback = this.llIIIlllll;
        if (mrzFilterCallback != null) {
            parcel.writeParcelable(mrzFilterCallback.IlIllIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        super.writeToParcel(parcel, i);
    }

    public MrtdRecognizer() {
        this(nativeConstruct());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microblink.entities.recognizers.templating.TemplatingRecognizer, com.microblink.entities.Entity
    protected void llIIlIlIIl(Parcel parcel) {
        MrzFilter mrzFilter = (MrzFilter) parcel.readParcelable(MrzFilter.class.getClassLoader());
        this.llIIIlllll = null;
        if (mrzFilter != null) {
            this.llIIIlllll = new MrzFilterCallback(mrzFilter, ((Result) getResult()).getMrzResult());
        }
        mrzFilterNativeSet(getNativeContext(), this.llIIIlllll);
        super.llIIlIlIIl(parcel);
    }

    private MrtdRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    private MrtdRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public MrtdRecognizer mo6353clone() {
        return new MrtdRecognizer(nativeCopy(getNativeContext()));
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
