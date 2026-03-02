package com.google.android.p038a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: com.google.android.a.a */
/* JADX INFO: compiled from: BaseProxy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2257a implements IInterface {

    /* JADX INFO: renamed from: a */
    private final IBinder f3635a;

    /* JADX INFO: renamed from: b */
    private final String f3636b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    protected C2257a(IBinder iBinder) {
        this.f3635a = iBinder;
    }

    /* JADX INFO: renamed from: a */
    protected final Parcel m2314a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f3636b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3635a;
    }

    /* JADX INFO: renamed from: b */
    protected final Parcel m2315b(Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f3635a.transact(1, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
