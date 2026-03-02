package com.microblink.entities.recognizers.blinkid.mrtd;

import android.os.Parcel;
import com.microblink.blinkid.secured.IlllIlllll;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.blinkid.documentface.DocumentFaceDetectorType;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class MrtdCombinedRecognizerTemplate extends IlllIlllll {

    /* JADX INFO: compiled from: line */
    static class Result implements CombinedResult {
        Result() {
        }

        @Override // com.microblink.entities.recognizers.blinkid.CombinedResult
        public boolean isScanningFirstSideDone() {
            return false;
        }

        public String toString() {
            return "Mrtd Combined Recognizer";
        }
    }

    MrtdCombinedRecognizerTemplate() {
    }

    private static native int detectorTypeNativeGet(long j);

    private static native void detectorTypeNativeSet(long j, int i);

    private static native void mrzFilterNativeSet(long j, MrzFilterCallback mrzFilterCallback);

    public CombinedResult getCombinedResult() {
        return null;
    }

    public DocumentFaceDetectorType getDetectorType() {
        return DocumentFaceDetectorType.values()[detectorTypeNativeGet(0L)];
    }

    public void setDetectorType(DocumentFaceDetectorType documentFaceDetectorType) {
        detectorTypeNativeSet(0L, documentFaceDetectorType.ordinal());
    }

    public void setMRZFilter(MrzFilter mrzFilter) {
        if (mrzFilter != null) {
            throw null;
        }
        mrzFilterNativeSet(0L, null);
    }

    @Override // com.microblink.blinkid.secured.IlllIlllll
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(null, i);
        super.writeToParcel(parcel, i);
    }
}
