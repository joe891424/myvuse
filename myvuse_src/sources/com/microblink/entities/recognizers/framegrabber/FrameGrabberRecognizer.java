package com.microblink.entities.recognizers.framegrabber;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkid.secured.IIIlIllllI;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.image.Image;
import com.microblink.image.ImageBuilder;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameGrabberRecognizer extends Recognizer<Result> {
    public static final Parcelable.Creator<FrameGrabberRecognizer> CREATOR;
    private NativeCallback IllIIIllII;

    /* JADX INFO: compiled from: line */
    private static final class NativeCallback {
        private FrameCallback llIIlIlIIl;

        NativeCallback(FrameCallback frameCallback) {
            this.llIIlIlIIl = frameCallback;
        }

        public void onFrameAvailable(long j, boolean z, double d) {
            Image imageBuildImageFromNativeContext = ImageBuilder.buildImageFromNativeContext(j, false, null);
            this.llIIlIlIIl.onFrameAvailable(imageBuildImageFromNativeContext, z, d);
            imageBuildImageFromNativeContext.dispose();
        }
    }

    /* JADX INFO: compiled from: line */
    public static final class Result extends Recognizer.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer.Result.1
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
        CREATOR = new Parcelable.Creator<FrameGrabberRecognizer>() { // from class: com.microblink.entities.recognizers.framegrabber.FrameGrabberRecognizer.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FrameGrabberRecognizer createFromParcel(Parcel parcel) {
                NativeCallback nativeCallback = new NativeCallback((FrameCallback) parcel.readParcelable(FrameGrabberRecognizer.class.getClassLoader()));
                return new FrameGrabberRecognizer(parcel, FrameGrabberRecognizer.nativeConstruct(nativeCallback), nativeCallback);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public FrameGrabberRecognizer[] newArray(int i) {
                return new FrameGrabberRecognizer[i];
            }
        };
    }

    private static native boolean grabFocusedFramesNativeGet(long j);

    private static native void grabFocusedFramesNativeSet(long j, boolean z);

    private static native boolean grabUnfocusedFramesNativeGet(long j);

    private static native void grabUnfocusedFramesNativeSet(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeConstruct(NativeCallback nativeCallback);

    private static native long nativeCopy(long j, NativeCallback nativeCallback);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
    }

    public FrameCallback getFrameCallback() {
        return this.IllIIIllII.llIIlIlIIl;
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        this.IllIIIllII.llIIlIlIIl = frameCallback;
    }

    public void setGrabFocusedFrames(boolean z) {
        grabFocusedFramesNativeSet(getNativeContext(), z);
    }

    public void setGrabUnfocusedFrames(boolean z) {
        grabUnfocusedFramesNativeSet(getNativeContext(), z);
    }

    public boolean shouldGrabFocusedFrames() {
        return grabFocusedFramesNativeGet(getNativeContext());
    }

    public boolean shouldGrabUnfocusedFrames() {
        return grabUnfocusedFramesNativeGet(getNativeContext());
    }

    @Override // com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.IllIIIllII.llIIlIlIIl, i);
        super.writeToParcel(parcel, i);
    }

    public FrameGrabberRecognizer(FrameCallback frameCallback) {
        this(new NativeCallback(frameCallback));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(long j) {
        nativeDestruct(j);
    }

    private FrameGrabberRecognizer(NativeCallback nativeCallback) {
        this(nativeCallback, nativeConstruct(nativeCallback));
    }

    @Override // com.microblink.entities.Entity
    protected byte[] llIIlIlIIl() {
        return nativeSerialize(getNativeContext());
    }

    private FrameGrabberRecognizer(NativeCallback nativeCallback, long j) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)));
        this.IllIIIllII = nativeCallback;
    }

    @Override // com.microblink.entities.recognizers.Recognizer, com.microblink.entities.Entity
    /* JADX INFO: renamed from: clone */
    public FrameGrabberRecognizer mo6353clone() {
        NativeCallback nativeCallback = new NativeCallback(this.IllIIIllII.llIIlIlIIl);
        return new FrameGrabberRecognizer(nativeCallback, nativeCopy(getNativeContext(), nativeCallback));
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(byte[] bArr) {
        nativeDeserialize(getNativeContext(), bArr);
    }

    private FrameGrabberRecognizer(Parcel parcel, long j, NativeCallback nativeCallback) {
        super(j, new Result(Entity.nativeGetNativeResultContext(j)), parcel);
        this.IllIIIllII = nativeCallback;
    }
}
