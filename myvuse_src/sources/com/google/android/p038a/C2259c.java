package com.google.android.p038a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.google.android.a.c */
/* JADX INFO: compiled from: Codecs.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2259c {
    static {
        C2259c.class.getClassLoader();
    }

    private C2259c() {
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m2317a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX INFO: renamed from: b */
    public static void m2318b(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    /* JADX INFO: renamed from: c */
    public static void m2319c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 1);
        }
    }
}
