package com.microblink.blinkid.secured;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.MicroblinkSDK;
import com.microblink.intent.IntentDataTransferMode;
import com.microblink.intent.MBIntentTransferable;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class lllIIlIlII {
    public static void llIIlIlIIl(Intent intent, String str, MBIntentTransferable mBIntentTransferable) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode != IntentDataTransferMode.STANDARD) {
            IIllIlIlII.llIIlIlIIl().llIIlIlIIl(llIIlIlIIl(), str, mBIntentTransferable, llIIlIlIIl(intentDataTransferMode));
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        mBIntentTransferable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length > 65536) {
            throw new IllegalStateException("Data cannot be saved to intent because its size exceeds intent limit!");
        }
        intent.putExtra(str, bArrMarshall);
    }

    public static <T extends MBIntentTransferable> T llIIlIlIIl(Intent intent, String str, Parcelable.Creator<T> creator) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode == IntentDataTransferMode.STANDARD) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(str);
            if (byteArrayExtra == null) {
                return null;
            }
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            T tCreateFromParcel = creator.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            return tCreateFromParcel;
        }
        return (T) IIllIlIlII.llIIlIlIIl().llIIlIlIIl(llIIlIlIIl(), str, creator, llIIlIlIIl(intentDataTransferMode));
    }

    public static void llIIlIlIIl(String str, MBIntentTransferable mBIntentTransferable) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode == IntentDataTransferMode.STANDARD) {
            return;
        }
        IIllIlIlII.llIIlIlIIl().llIIlIlIIl(llIIlIlIIl(), str, mBIntentTransferable, llIIlIlIIl(intentDataTransferMode));
    }

    public static void llIIlIlIIl(String str) {
        IntentDataTransferMode intentDataTransferMode = MicroblinkSDK.getIntentDataTransferMode();
        if (intentDataTransferMode == IntentDataTransferMode.STANDARD) {
            return;
        }
        IIllIlIlII.llIIlIlIIl().llIIlIlIIl(llIIlIlIIl(), str, llIIlIlIIl(intentDataTransferMode));
    }

    private static Context llIIlIlIIl() {
        Context applicationContext = MicroblinkSDK.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        throw new IllegalStateException("Application context has not been passed to the Microblink SDK. Please check whether you have set the license key for the Microblink SDK, where application context also has to be provided.");
    }

    private static boolean llIIlIlIIl(IntentDataTransferMode intentDataTransferMode) {
        return intentDataTransferMode == IntentDataTransferMode.PERSISTED_OPTIMISED;
    }
}
