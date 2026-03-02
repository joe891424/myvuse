package com.microblink.entities.recognizers.blinkid.mrtd;

import android.os.Parcel;
import com.microblink.blinkid.secured.IlllIlllll;
import com.microblink.entities.detectors.quad.mrtd.MrtdSpecification;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class MrtdRecognizerTemplate extends IlllIlllll {

    /* JADX INFO: compiled from: line */
    static class Result {
        Result() {
        }

        public String toString() {
            throw null;
        }
    }

    MrtdRecognizerTemplate() {
    }

    private static native void mrzFilterNativeSet(long j, MrzFilterCallback mrzFilterCallback);

    private static native long[] specificationsNativeGet(long j);

    private static native void specificationsNativeSet(long j, long[] jArr);

    public MrtdSpecification[] getSpecifications() {
        long[] jArrSpecificationsNativeGet = specificationsNativeGet(0L);
        MrtdSpecification[] mrtdSpecificationArr = new MrtdSpecification[jArrSpecificationsNativeGet.length];
        for (int i = 0; i < jArrSpecificationsNativeGet.length; i++) {
            mrtdSpecificationArr[i] = new MrtdSpecification(jArrSpecificationsNativeGet[i]);
        }
        return mrtdSpecificationArr;
    }

    public void setMRZFilter(MrzFilter mrzFilter) {
        if (mrzFilter != null) {
            throw null;
        }
        mrzFilterNativeSet(0L, null);
    }

    public void setSpecifications(MrtdSpecification... mrtdSpecificationArr) {
        if (mrtdSpecificationArr == null || mrtdSpecificationArr.length == 0) {
            specificationsNativeSet(0L, null);
            return;
        }
        long[] jArr = new long[mrtdSpecificationArr.length];
        for (int i = 0; i < mrtdSpecificationArr.length; i++) {
            jArr[i] = mrtdSpecificationArr[i].getNativeContext();
        }
        specificationsNativeSet(0L, jArr);
    }

    @Override // com.microblink.blinkid.secured.IlllIlllll
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(null, i);
        super.writeToParcel(parcel, i);
    }
}
