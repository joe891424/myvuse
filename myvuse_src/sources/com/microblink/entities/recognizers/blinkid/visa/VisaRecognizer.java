package com.microblink.entities.recognizers.blinkid.visa;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
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
import com.microblink.entities.recognizers.blinkid.mrtd.MrzResult;
import com.microblink.entities.settings.GlareDetectorOptions;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class VisaRecognizer extends Recognizer<Result> implements GlareDetectorOptions, FaceImageOptions, FaceImageDpiOptions, EncodeFaceImageOptions, FullDocumentImageOptions, FullDocumentImageDpiOptions, FullDocumentImageExtensionOptions, EncodeFullDocumentImagesOptions {
    public static final Parcelable.Creator<VisaRecognizer> CREATOR;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result implements FaceImageResult, EncodedFaceImageResult, FullDocumentImageResult, EncodedFullDocumentImageResult {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.blinkid.visa.VisaRecognizer.Result.1
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

        private static native byte[] encodedFaceImageNativeGet(long j);

        private static native byte[] encodedFullDocumentImageNativeGet(long j);

        private static native long faceImageNativeGet(long j);

        private static native long fullDocumentImageNativeGet(long j);

        private static native long mrzResultNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFaceImageResult
        public byte[] getEncodedFaceImage() {
            return encodedFaceImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.EncodedFullDocumentImageResult
        public byte[] getEncodedFullDocumentImage() {
            return encodedFullDocumentImageNativeGet(getNativeContext());
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FaceImageResult
        public Image getFaceImage() {
            long jFaceImageNativeGet = faceImageNativeGet(getNativeContext());
            if (jFaceImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFaceImageNativeGet, true, this);
            }
            return null;
        }

        @Override // com.microblink.entities.recognizers.blinkid.imageresult.FullDocumentImageResult
        public Image getFullDocumentImage() {
            long jFullDocumentImageNativeGet = fullDocumentImageNativeGet(getNativeContext());
            if (jFullDocumentImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jFullDocumentImageNativeGet, true, this);
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
            return "Visa Recognizer";
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
        CREATOR = new Parcelable.Creator<VisaRecognizer>() { // from class: com.microblink.entities.recognizers.blinkid.visa.VisaRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VisaRecognizer createFromParcel(Parcel parcel) {
                return new VisaRecognizer(parcel, VisaRecognizer.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VisaRecognizer[] newArray(int i) {
                return new VisaRecognizer[i];
            }
        };
    }

    private static native boolean detectGlareNativeGet(long j);

    private static native void detectGlareNativeSet(long j, boolean z);

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

    private static native boolean returnFaceImageNativeGet(long j);

    private static native void returnFaceImageNativeSet(long j, boolean z);

    private static native boolean returnFullDocumentImageNativeGet(long j);

    private static native void returnFullDocumentImageNativeSet(long j, boolean z);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof VisaRecognizer)) {
                throw new IllegalArgumentException("Parameter type has to be VisaRecognizer");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
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

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    @Override // com.microblink.entities.settings.GlareDetectorOptions
    public void setDetectGlare(boolean z) {
        detectGlareNativeSet(getNativeContext(), z);
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

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FaceImageOptions
    public void setReturnFaceImage(boolean z) {
        returnFaceImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.recognizers.blinkid.imageoptions.FullDocumentImageOptions
    public void setReturnFullDocumentImage(boolean z) {
        returnFullDocumentImageNativeSet(getNativeContext(), z);
    }

    @Override // com.microblink.entities.settings.GlareDetectorOptions
    public boolean shouldDetectGlare() {
        return detectGlareNativeGet(getNativeContext());
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

    public VisaRecognizer() {
        this(nativeConstruct());
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private VisaRecognizer(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private VisaRecognizer(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public VisaRecognizer mo6353clone() {
        return new VisaRecognizer(nativeCopy(getNativeContext()));
    }
}
