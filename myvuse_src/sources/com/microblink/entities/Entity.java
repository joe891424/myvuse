package com.microblink.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.entities.Entity.Result;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Entity<T extends Result> implements Parcelable {
    private long llIIlIlIIl = 0;
    private T IlIllIlIIl = null;

    /* JADX INFO: compiled from: line */
    public static abstract class Result implements Parcelable {
        protected Object IlIllIlIIl = null;
        private long llIIlIlIIl;

        protected Result(long j) {
            this.llIIlIlIIl = j;
        }

        protected abstract byte[] IlIllIlIIl();

        @Override // 
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public abstract Result mo6354clone();

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        protected void finalize() throws Throwable {
            super.finalize();
            if (this.IlIllIlIIl == null) {
                llIIlIlIIl(this.llIIlIlIIl);
            }
        }

        public final long getNativeContext() {
            return this.llIIlIlIIl;
        }

        protected abstract void llIIlIlIIl(long j);

        protected void llIIlIlIIl(Parcel parcel) {
            int i = parcel.readInt();
            if (i > 0) {
                byte[] bArr = new byte[i];
                parcel.readByteArray(bArr);
                llIIlIlIIl(bArr);
            }
        }

        protected abstract void llIIlIlIIl(byte[] bArr);

        protected abstract boolean llIIlIlIIl();

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            byte[] bArrIlIllIlIIl = IlIllIlIIl();
            if (bArrIlIllIlIIl == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(bArrIlIllIlIIl.length);
                parcel.writeByteArray(bArrIlIllIlIIl);
            }
        }
    }

    protected Entity(long j, T t) {
        llIIlIlIIl(j, t);
    }

    private void llIIlIlIIl(long j, T t) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = t;
        t.IlIllIlIIl = this;
    }

    protected static native long nativeGetNativeResultContext(long j);

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Entity mo6353clone();

    public abstract void consumeResultFrom(Entity entity);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        llIIlIlIIl(this.llIIlIlIIl);
    }

    public final long getNativeContext() {
        return this.llIIlIlIIl;
    }

    public final T getResult() {
        return this.IlIllIlIIl;
    }

    protected abstract void llIIlIlIIl(long j);

    protected abstract void llIIlIlIIl(byte[] bArr);

    protected abstract byte[] llIIlIlIIl();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        byte[] bArrLlIIlIlIIl = llIIlIlIIl();
        if (bArrLlIIlIlIIl != null) {
            parcel.writeInt(bArrLlIIlIlIIl.length);
            parcel.writeByteArray(bArrLlIIlIlIIl);
        } else {
            parcel.writeInt(0);
        }
        boolean zLlIIlIlIIl = this.IlIllIlIIl.llIIlIlIIl();
        parcel.writeByte(!zLlIIlIlIIl ? (byte) 1 : (byte) 0);
        if (zLlIIlIlIIl) {
            return;
        }
        this.IlIllIlIIl.writeToParcel(parcel, i);
    }

    protected void llIIlIlIIl(Parcel parcel) {
        int i = parcel.readInt();
        if (i > 0) {
            byte[] bArr = new byte[i];
            parcel.readByteArray(bArr);
            llIIlIlIIl(bArr);
        }
        if (parcel.readByte() != 0) {
            this.IlIllIlIIl.llIIlIlIIl(parcel);
        }
    }

    protected Entity(long j, T t, Parcel parcel) {
        llIIlIlIIl(j, t);
        llIIlIlIIl(parcel);
    }
}
