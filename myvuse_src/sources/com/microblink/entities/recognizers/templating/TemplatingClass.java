package com.microblink.entities.recognizers.templating;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class TemplatingClass implements Parcelable {
    public static final Parcelable.Creator<TemplatingClass> CREATOR = new Parcelable.Creator<TemplatingClass>() { // from class: com.microblink.entities.recognizers.templating.TemplatingClass.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplatingClass createFromParcel(Parcel parcel) {
            return new TemplatingClass(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TemplatingClass[] newArray(int i) {
            return new TemplatingClass[i];
        }
    };
    private ProcessorGroup[] IlIllIlIIl;
    private long IllIIIIllI;
    private NativeCallback IllIIIllII;
    private TemplatingRecognizer llIIIlllll;
    private ProcessorGroup[] llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    private static final class NativeCallback {
        private TemplatingClass IlIllIlIIl;
        private TemplatingClassifier llIIlIlIIl;

        NativeCallback(TemplatingClassifier templatingClassifier, TemplatingClass templatingClass) {
            this.llIIlIlIIl = templatingClassifier;
            this.IlIllIlIIl = templatingClass;
        }

        public boolean classify() {
            return this.llIIlIlIIl.classify(this.IlIllIlIIl);
        }
    }

    private static native void classificationProcessorGroupsNativeSet(long j, long[] jArr);

    private static native void classifierNativeSet(long j, NativeCallback nativeCallback);

    private long[] llIIlIlIIl(ProcessorGroup[] processorGroupArr) {
        if (processorGroupArr == null) {
            return null;
        }
        long[] jArr = new long[processorGroupArr.length];
        for (int i = 0; i < processorGroupArr.length; i++) {
            jArr[i] = processorGroupArr[i].llIIlIlIIl();
        }
        return jArr;
    }

    private static native long nativeConstruct();

    private static native void nativeDestruct(long j);

    private static native void nonClassificationProcessorGroupsNativeSet(long j, long[] jArr);

    public void consumeResultFrom(TemplatingClass templatingClass) {
        ProcessorGroup[] processorGroupArr;
        ProcessorGroup[] processorGroupArr2;
        if (this == templatingClass) {
            return;
        }
        ProcessorGroup[] processorGroupArr3 = this.llIIlIlIIl;
        int i = 0;
        if (processorGroupArr3 == null || (processorGroupArr2 = templatingClass.llIIlIlIIl) == null) {
            if (processorGroupArr3 != null || templatingClass.llIIlIlIIl != null) {
                throw new IllegalStateException("Consuming result from incompatible TemplatingClass");
            }
        } else {
            if (processorGroupArr3.length != processorGroupArr2.length) {
                throw new IllegalStateException("Consuming result from incompatible TemplatingClass");
            }
            int i2 = 0;
            while (true) {
                ProcessorGroup[] processorGroupArr4 = this.llIIlIlIIl;
                if (i2 >= processorGroupArr4.length) {
                    break;
                }
                processorGroupArr4[i2].consumeResultFrom(templatingClass.llIIlIlIIl[i2]);
                i2++;
            }
        }
        ProcessorGroup[] processorGroupArr5 = this.IlIllIlIIl;
        if (processorGroupArr5 == null || (processorGroupArr = templatingClass.IlIllIlIIl) == null) {
            if (processorGroupArr5 != null || templatingClass.IlIllIlIIl != null) {
                throw new IllegalStateException("Consuming result from incompatible TemplatingClass");
            }
        } else {
            if (processorGroupArr5.length != processorGroupArr.length) {
                throw new IllegalStateException("Consuming result from incompatible TemplatingClass");
            }
            while (true) {
                ProcessorGroup[] processorGroupArr6 = this.IlIllIlIIl;
                if (i >= processorGroupArr6.length) {
                    return;
                }
                processorGroupArr6[i].consumeResultFrom(templatingClass.IlIllIlIIl[i]);
                i++;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestruct(this.IllIIIIllI);
    }

    public ProcessorGroup[] getClassificationProcessorGroups() {
        return this.llIIlIlIIl;
    }

    public ProcessorGroup[] getNonClassificationProcessorGroups() {
        return this.IlIllIlIIl;
    }

    public <T extends TemplatingRecognizer> T getOwningRecognizer() {
        return (T) this.llIIIlllll;
    }

    public void setClassificationProcessorGroups(ProcessorGroup... processorGroupArr) {
        this.llIIlIlIIl = processorGroupArr;
        classificationProcessorGroupsNativeSet(this.IllIIIIllI, llIIlIlIIl(processorGroupArr));
    }

    public void setNonClassificationProcessorGroups(ProcessorGroup... processorGroupArr) {
        this.IlIllIlIIl = processorGroupArr;
        nonClassificationProcessorGroupsNativeSet(this.IllIIIIllI, llIIlIlIIl(processorGroupArr));
    }

    public void setTemplatingClassifier(TemplatingClassifier templatingClassifier) {
        if (templatingClassifier == null) {
            this.IllIIIllII = null;
        } else {
            this.IllIIIllII = new NativeCallback(templatingClassifier, this);
        }
        classifierNativeSet(this.IllIIIIllI, this.IllIIIllII);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        NativeCallback nativeCallback = this.IllIIIllII;
        if (nativeCallback != null) {
            parcel.writeParcelable(nativeCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        ProcessorGroup[] processorGroupArr = this.llIIlIlIIl;
        if (processorGroupArr != null) {
            parcel.writeInt(processorGroupArr.length);
            parcel.writeTypedArray(this.llIIlIlIIl, i);
        } else {
            parcel.writeInt(-1);
        }
        ProcessorGroup[] processorGroupArr2 = this.IlIllIlIIl;
        if (processorGroupArr2 == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(processorGroupArr2.length);
            parcel.writeTypedArray(this.IlIllIlIIl, i);
        }
    }

    public TemplatingClass() {
        this.IllIIIIllI = nativeConstruct();
    }

    private TemplatingClass(Parcel parcel) {
        this.IllIIIIllI = nativeConstruct();
        setTemplatingClassifier((TemplatingClassifier) parcel.readParcelable(TemplatingClassifier.class.getClassLoader()));
        int i = parcel.readInt();
        if (i > -1) {
            ProcessorGroup[] processorGroupArr = new ProcessorGroup[i];
            this.llIIlIlIIl = processorGroupArr;
            parcel.readTypedArray(processorGroupArr, ProcessorGroup.CREATOR);
            classificationProcessorGroupsNativeSet(this.IllIIIIllI, llIIlIlIIl(this.llIIlIlIIl));
        }
        int i2 = parcel.readInt();
        if (i2 > -1) {
            ProcessorGroup[] processorGroupArr2 = new ProcessorGroup[i2];
            this.IlIllIlIIl = processorGroupArr2;
            parcel.readTypedArray(processorGroupArr2, ProcessorGroup.CREATOR);
            nonClassificationProcessorGroupsNativeSet(this.IllIIIIllI, llIIlIlIIl(this.IlIllIlIIl));
        }
    }

    long llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    void llIIlIlIIl(TemplatingRecognizer templatingRecognizer) {
        this.llIIIlllll = templatingRecognizer;
    }
}
