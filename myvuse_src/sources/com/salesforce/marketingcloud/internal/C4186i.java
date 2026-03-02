package com.salesforce.marketingcloud.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.salesforce.marketingcloud.internal.i */
/* JADX INFO: loaded from: classes6.dex */
public class C4186i {
    private C4186i() {
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m3383a(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m3382a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }
}
