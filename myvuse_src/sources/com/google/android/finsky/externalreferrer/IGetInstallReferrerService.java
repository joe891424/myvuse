package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p038a.BinderC2258b;
import com.google.android.p038a.C2257a;
import com.google.android.p038a.C2259c;

/* JADX INFO: loaded from: classes3.dex */
public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends BinderC2258b implements IGetInstallReferrerService {

        public static class Proxy extends C2257a implements IGetInstallReferrerService {
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            /* JADX INFO: renamed from: c */
            public final Bundle mo2354c(Bundle bundle) throws RemoteException {
                Parcel parcelM2314a = m2314a();
                C2259c.m2318b(parcelM2314a, bundle);
                Parcel parcelM2315b = m2315b(parcelM2314a);
                Bundle bundle2 = (Bundle) C2259c.m2317a(parcelM2315b, Bundle.CREATOR);
                parcelM2315b.recycle();
                return bundle2;
            }
        }

        /* JADX INFO: renamed from: b */
        public static IGetInstallReferrerService m2355b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) iInterfaceQueryLocalInterface : new Proxy(iBinder);
        }

        @Override // com.google.android.p038a.BinderC2258b
        /* JADX INFO: renamed from: a */
        protected final boolean mo2316a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle bundleC = mo2354c((Bundle) C2259c.m2317a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            C2259c.m2319c(parcel2, bundleC);
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    Bundle mo2354c(Bundle bundle) throws RemoteException;
}
