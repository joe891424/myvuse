package com.microblink.entities.processors.imageReturn;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.processors.Processor;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ImageReturnProcessor extends Processor<Result> {
    public static final Parcelable.Creator<ImageReturnProcessor> CREATOR;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Processor.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.processors.imageReturn.ImageReturnProcessor.Result.1
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

        private static native byte[] encodedImageNativeGet(long j);

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native long rawImageNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public byte[] getEncodedImage() {
            return encodedImageNativeGet(getNativeContext());
        }

        public Image getRawImage() {
            long jRawImageNativeGet = rawImageNativeGet(getNativeContext());
            if (jRawImageNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jRawImageNativeGet, true, this);
            }
            return null;
        }

        public String toString() {
            return super.toString();
        }

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(byte[] bArr) {
            nativeDeserialize(getNativeContext(), bArr);
        }

        @Override // com.microblink.entities.Entity.Result
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
        CREATOR = new Parcelable.Creator<ImageReturnProcessor>() { // from class: com.microblink.entities.processors.imageReturn.ImageReturnProcessor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ImageReturnProcessor createFromParcel(Parcel parcel) {
                return new ImageReturnProcessor(parcel, ImageReturnProcessor.nativeConstruct());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ImageReturnProcessor[] newArray(int i) {
                return new ImageReturnProcessor[i];
            }
        };
    }

    private static native boolean encodeImageNativeGet(long j);

    private static native void encodeImageNativeSet(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct();

    private static native void nativeConsumeResult(long j, long j2);

    private static native long nativeCopy(long j);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this != entity) {
            if (!(entity instanceof ImageReturnProcessor)) {
                throw new IllegalArgumentException("Parameter type has to be ImageReturnProcessor");
            }
            nativeConsumeResult(getNativeContext(), entity.getResult().getNativeContext());
        }
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    public void setEncodeImage(boolean z) {
        encodeImageNativeSet(getNativeContext(), z);
    }

    public boolean shouldEncodeImage() {
        return encodeImageNativeGet(getNativeContext());
    }

    public ImageReturnProcessor() {
        this(nativeConstruct());
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private ImageReturnProcessor(long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
    }

    @Override // com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public ImageReturnProcessor mo6353clone() {
        return new ImageReturnProcessor(nativeCopy(getNativeContext()));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private ImageReturnProcessor(Parcel parcel, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
    }
}
