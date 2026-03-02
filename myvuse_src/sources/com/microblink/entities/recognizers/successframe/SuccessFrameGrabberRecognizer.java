package com.microblink.entities.recognizers.successframe;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class SuccessFrameGrabberRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<SuccessFrameGrabberRecognizer> CREATOR;
    private Recognizer<?> IllIIIllII;

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer.Result.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Result createFromParcel(Parcel parcel) {
                Result result = new Result(Result.nativeConstruct(), (Recognizer.Result) parcel.readParcelable(getClass().getClassLoader()));
                result.llIIlIlIIl(parcel);
                return result;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Result[] newArray(int i) {
                return new Result[i];
            }
        };
        private Recognizer.Result IllIIIllII;

        protected Result(long j, Recognizer.Result result) {
            super(j);
            this.IllIIIllII = result;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static native long nativeConstruct();

        private static native long nativeCopy(long j);

        private static native void nativeDeserialize(long j, byte[] bArr);

        private static native void nativeDestruct(long j);

        private static native byte[] nativeSerialize(long j);

        private static native long successFrameNativeGet(long j);

        @Override // com.microblink.entities.Entity.Result
        protected byte[] IlIllIlIIl() {
            return nativeSerialize(getNativeContext());
        }

        public Recognizer.Result getSlaveResult() {
            return this.IllIIIllII;
        }

        public Image getSuccessFrame() {
            long jSuccessFrameNativeGet = successFrameNativeGet(getNativeContext());
            if (jSuccessFrameNativeGet != 0) {
                return ImageBuilder.buildImageFromNativeContext(jSuccessFrameNativeGet, true, this);
            }
            return null;
        }

        public String toString() {
            return this.IllIIIllII.toString();
        }

        @Override // com.microblink.entities.Entity.Result, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (this.IlIllIlIIl == null) {
                parcel.writeParcelable(this.IllIIIllII, i);
            }
            super.writeToParcel(parcel, i);
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
            return new Result(nativeCopy(getNativeContext()), this.IllIIIllII.mo6354clone());
        }
    }

    static {
        IIIlIllllI.llIIlIlIIl();
        CREATOR = new Parcelable.Creator<SuccessFrameGrabberRecognizer>() { // from class: com.microblink.entities.recognizers.successframe.SuccessFrameGrabberRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SuccessFrameGrabberRecognizer createFromParcel(Parcel parcel) {
                Recognizer recognizer = (Recognizer) parcel.readParcelable(SuccessFrameGrabberRecognizer.class.getClassLoader());
                return new SuccessFrameGrabberRecognizer(parcel, SuccessFrameGrabberRecognizer.nativeConstruct(recognizer.getNativeContext()), recognizer);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SuccessFrameGrabberRecognizer[] newArray(int i) {
                return new SuccessFrameGrabberRecognizer[i];
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct(long j);

    private static native void nativeConsumeResult(long j, long j2);

    private static native void nativeDestruct(long j);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        if (this == entity) {
            return;
        }
        if (!(entity instanceof SuccessFrameGrabberRecognizer)) {
            throw new IllegalArgumentException("Parameter type has to be SuccessFrameGrabberRecognizer");
        }
        SuccessFrameGrabberRecognizer successFrameGrabberRecognizer = (SuccessFrameGrabberRecognizer) entity;
        nativeConsumeResult(getNativeContext(), ((Result) successFrameGrabberRecognizer.getResult()).getNativeContext());
        this.IllIIIllII.consumeResultFrom(successFrameGrabberRecognizer.IllIIIllII);
    }

    public Recognizer<?> getSlaveRecognizer() {
        return this.IllIIIllII;
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

    @Override // com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.IllIIIllII, i);
        super.writeToParcel(parcel, i);
    }

    public SuccessFrameGrabberRecognizer(Recognizer<?> recognizer) {
        this(recognizer, nativeConstruct(recognizer.getNativeContext()));
    }

    private SuccessFrameGrabberRecognizer(Recognizer<?> recognizer, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j), (Recognizer.Result) recognizer.getResult()));
        this.IllIIIllII = recognizer;
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public SuccessFrameGrabberRecognizer mo6353clone() {
        throw new IllegalStateException("SuccessFrameGrabber recognizer does not support cloning!");
    }

    private SuccessFrameGrabberRecognizer(Parcel parcel, long j, Recognizer<?> recognizer) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j), (Recognizer.Result) recognizer.getResult()), parcel);
        this.IllIIIllII = recognizer;
    }
}
