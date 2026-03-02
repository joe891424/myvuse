package com.microblink.entities.recognizers.templating;

import android.os.Parcel;
import com.microblink.entities.Entity;
import com.microblink.entities.recognizers.Recognizer;
import com.microblink.entities.recognizers.templating.TemplatingRecognizer.Result;
import com.microblink.entities.settings.GlareDetectorOptions;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TemplatingRecognizer<R extends Result> extends Recognizer<R> implements GlareDetectorOptions {
    public static final String CLASS_NAME = "com.microblink.entities.recognizers.templating.TemplatingRecognizer";
    private TemplatingClass[] IllIIIllII;

    /* JADX INFO: compiled from: line */
    public static abstract class Result extends Recognizer.Result {
        protected Result(long j) {
            super(j);
        }

        protected abstract int IlIllIlIIl(long j);

        public final TemplatingClass getTemplatingClass() {
            Object obj = this.IlIllIlIIl;
            if (obj == null || !(obj instanceof TemplatingRecognizer)) {
                return null;
            }
            TemplatingRecognizer templatingRecognizer = (TemplatingRecognizer) obj;
            int iIlIllIlIIl = IlIllIlIIl(templatingRecognizer.getNativeContext());
            if (iIlIllIlIIl >= 0) {
                return templatingRecognizer.IllIIIllII[iIlIllIlIIl];
            }
            return null;
        }

        protected abstract void llIIlIlIIl(long j, int i);

        @Override // com.microblink.entities.Entity.Result
        protected void llIIlIlIIl(Parcel parcel) {
            Object obj;
            int i = parcel.readInt();
            if (i >= 0 && (obj = this.IlIllIlIIl) != null && (obj instanceof TemplatingRecognizer)) {
                llIIlIlIIl(((TemplatingRecognizer) obj).getNativeContext(), i);
            }
            super.llIIlIlIIl(parcel);
        }

        @Override // com.microblink.entities.Entity.Result, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Object obj = this.IlIllIlIIl;
            if (obj == null || !(obj instanceof TemplatingRecognizer)) {
                parcel.writeInt(-1);
            } else {
                parcel.writeInt(IlIllIlIIl(((TemplatingRecognizer) obj).getNativeContext()));
            }
            super.writeToParcel(parcel, i);
        }
    }

    protected TemplatingRecognizer(long j, R r) {
        super(j, r);
    }

    @Override // com.microblink.entities.Entity
    public void consumeResultFrom(Entity entity) {
        TemplatingClass[] templatingClassArr;
        if (this == entity) {
            return;
        }
        if (!(entity instanceof TemplatingRecognizer)) {
            throw new IllegalArgumentException("Parameter type has to be TemplatingRecognizer");
        }
        TemplatingRecognizer templatingRecognizer = (TemplatingRecognizer) entity;
        TemplatingClass[] templatingClassArr2 = this.IllIIIllII;
        if (templatingClassArr2 == null || (templatingClassArr = templatingRecognizer.IllIIIllII) == null) {
            if (templatingClassArr2 != null || templatingRecognizer.IllIIIllII != null) {
                throw new IllegalStateException("Consuming result from incompatible Templating recognizer");
            }
        } else {
            if (templatingClassArr2.length != templatingClassArr.length) {
                throw new IllegalStateException("Consuming result from incompatible Templating recognizer");
            }
            int i = 0;
            while (true) {
                TemplatingClass[] templatingClassArr3 = this.IllIIIllII;
                if (i >= templatingClassArr3.length) {
                    return;
                }
                templatingClassArr3[i].consumeResultFrom(templatingRecognizer.IllIIIllII[i]);
                i++;
            }
        }
    }

    protected abstract void llIIlIlIIl(long[] jArr);

    public final void setTemplatingClasses(TemplatingClass... templatingClassArr) {
        this.IllIIIllII = templatingClassArr;
        llIIlIlIIl(llIIlIlIIl(templatingClassArr));
        TemplatingClass[] templatingClassArr2 = this.IllIIIllII;
        if (templatingClassArr2 != null) {
            for (TemplatingClass templatingClass : templatingClassArr2) {
                templatingClass.llIIlIlIIl(this);
            }
        }
    }

    @Override // com.microblink.entities.Entity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TemplatingClass[] templatingClassArr = this.IllIIIllII;
        if (templatingClassArr != null) {
            parcel.writeInt(templatingClassArr.length);
            parcel.writeTypedArray(this.IllIIIllII, i);
        } else {
            parcel.writeInt(-1);
        }
        super.writeToParcel(parcel, i);
    }

    protected TemplatingRecognizer(long j, R r, Parcel parcel) {
        super(j, r, parcel);
    }

    private long[] llIIlIlIIl(TemplatingClass[] templatingClassArr) {
        if (templatingClassArr == null) {
            return null;
        }
        long[] jArr = new long[templatingClassArr.length];
        for (int i = 0; i < templatingClassArr.length; i++) {
            jArr[i] = templatingClassArr[i].llIIlIlIIl();
        }
        return jArr;
    }

    @Override // com.microblink.entities.Entity
    protected void llIIlIlIIl(Parcel parcel) {
        int i = parcel.readInt();
        if (i > -1) {
            TemplatingClass[] templatingClassArr = new TemplatingClass[i];
            this.IllIIIllII = templatingClassArr;
            parcel.readTypedArray(templatingClassArr, TemplatingClass.CREATOR);
            llIIlIlIIl(llIIlIlIIl(this.IllIIIllII));
            TemplatingClass[] templatingClassArr2 = this.IllIIIllII;
            if (templatingClassArr2 != null) {
                for (TemplatingClass templatingClass : templatingClassArr2) {
                    templatingClass.llIIlIlIIl(this);
                }
            }
        }
        super.llIIlIlIIl(parcel);
    }
}
