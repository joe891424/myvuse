package com.facetec.sdk;

import android.os.Parcel;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.facetec.sdk.u */
/* JADX INFO: loaded from: classes3.dex */
final class C2230u {
    private static final HashMap<Integer, Object> Code = new HashMap<>();

    /* JADX INFO: renamed from: Z */
    private static Timer f3572Z = null;

    C2230u() {
    }

    static <T> void Code(T t, Parcel parcel) {
        if (t != null) {
            parcel.writeInt(m2295V(t));
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: renamed from: V */
    static <T> T m2296V(Parcel parcel) {
        int i = parcel.readInt();
        if (i != 0) {
            return (T) Code(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: V */
    private static synchronized int m2295V(Object obj) {
        final int iHashCode;
        iHashCode = obj.hashCode();
        if (f3572Z == null) {
            f3572Z = new Timer();
        }
        f3572Z.schedule(new TimerTask() { // from class: com.facetec.sdk.u.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                C2230u.Code(iHashCode);
            }
        }, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        Code.put(Integer.valueOf(iHashCode), obj);
        return iHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Object Code(int i) {
        Object objRemove;
        HashMap<Integer, Object> map = Code;
        objRemove = map.remove(Integer.valueOf(i));
        if (f3572Z != null && map.isEmpty()) {
            f3572Z.cancel();
            f3572Z = null;
        }
        return objRemove;
    }
}
