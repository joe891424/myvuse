package com.microblink.entities.recognizers.templating;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.entities.processors.Processor;
import com.microblink.geometry.Rectangle;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ProcessorGroup implements Parcelable {
    public static final Parcelable.Creator<ProcessorGroup> CREATOR = new Parcelable.Creator<ProcessorGroup>() { // from class: com.microblink.entities.recognizers.templating.ProcessorGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessorGroup createFromParcel(Parcel parcel) {
            return new ProcessorGroup(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessorGroup[] newArray(int i) {
            return new ProcessorGroup[i];
        }
    };
    private long IlIllIlIIl;
    private Processor[] llIIlIlIIl;

    private long[] llIIlIlIIl(Processor[] processorArr) {
        long[] jArr = new long[processorArr.length];
        for (int i = 0; i < processorArr.length; i++) {
            jArr[i] = processorArr[i].getNativeContext();
        }
        return jArr;
    }

    private static native long nativeConstruct(long[] jArr);

    private static native void nativeDeserialize(long j, byte[] bArr);

    private static native void nativeDestruct(long j);

    private static native byte[] nativeSerialize(long j);

    private static native void processingLocationNativeSet(long j, float f, float f2, float f3, float f4);

    public void consumeResultFrom(ProcessorGroup processorGroup) {
        if (this == processorGroup) {
            return;
        }
        if (processorGroup.llIIlIlIIl.length != this.llIIlIlIIl.length) {
            throw new IllegalStateException("Consuming result from incompatible ProcessorGroup");
        }
        int i = 0;
        while (true) {
            Processor[] processorArr = this.llIIlIlIIl;
            if (i >= processorArr.length) {
                return;
            }
            processorArr[i].consumeResultFrom(processorGroup.llIIlIlIIl[i]);
            i++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestruct(this.IlIllIlIIl);
    }

    public Processor[] getProcessors() {
        return this.llIIlIlIIl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray(this.llIIlIlIIl, i);
        byte[] bArrNativeSerialize = nativeSerialize(this.IlIllIlIIl);
        parcel.writeInt(bArrNativeSerialize.length);
        parcel.writeByteArray(bArrNativeSerialize);
    }

    public ProcessorGroup(Rectangle rectangle, DewarpPolicy dewarpPolicy, Processor... processorArr) {
        this.IlIllIlIIl = 0L;
        if (rectangle == null) {
            throw new NullPointerException("Processing location cannot be null");
        }
        if (processorArr == null || processorArr.length == 0) {
            throw new NullPointerException("Processors cannot be null nor empty!");
        }
        if (dewarpPolicy == null) {
            throw new NullPointerException("Dewarp policy cannot be null");
        }
        for (Processor processor : processorArr) {
            if (processor == null) {
                throw new NullPointerException("It is not allowed to pass null processor to ProcessorGroup");
            }
        }
        this.llIIlIlIIl = processorArr;
        long jNativeConstruct = nativeConstruct(llIIlIlIIl(processorArr));
        this.IlIllIlIIl = jNativeConstruct;
        processingLocationNativeSet(jNativeConstruct, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        dewarpPolicy.llIIlIlIIl(this.IlIllIlIIl);
    }

    long llIIlIlIIl() {
        return this.IlIllIlIIl;
    }

    private ProcessorGroup(Parcel parcel) {
        this.IlIllIlIIl = 0L;
        Parcelable[] parcelableArray = parcel.readParcelableArray(Processor.class.getClassLoader());
        this.llIIlIlIIl = new Processor[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            this.llIIlIlIIl[i] = (Processor) parcelableArray[i];
        }
        this.IlIllIlIIl = nativeConstruct(llIIlIlIIl(this.llIIlIlIIl));
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        nativeDeserialize(this.IlIllIlIIl, bArr);
    }
}
