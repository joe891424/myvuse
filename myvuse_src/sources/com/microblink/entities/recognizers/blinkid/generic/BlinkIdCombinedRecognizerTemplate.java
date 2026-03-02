package com.microblink.entities.recognizers.blinkid.generic;

import android.os.Parcel;
import com.microblink.blinkid.secured.IlllIlllll;
import com.microblink.entities.recognizers.blinkid.CombinedResult;
import com.microblink.entities.recognizers.classifier.ClassifierCallback;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class BlinkIdCombinedRecognizerTemplate extends IlllIlllll implements BarcodeScanningStartedCallbackOptions {
    private NativeClassifierCallback IlIllIlIIl;
    private NativeBarcodeScanningStartedCallbackCallback IllIIIllII;
    private NativeClassFilter llIIIlllll;
    private NativeDewarpedImageCallback llIIlIlIIl;

    /* JADX INFO: compiled from: line */
    static class Result {
        Result() {
        }

        public String toString() {
            return "Blink Id Combined Recognizer";
        }
    }

    BlinkIdCombinedRecognizerTemplate() {
    }

    private static native void barcodeScanningStartedCallbackNativeSet(long j, NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback);

    private static native void classFilterNativeSet(long j, NativeClassFilter nativeClassFilter);

    private static native void classifierCallbackNativeSet(long j, NativeClassifierCallback nativeClassifierCallback);

    private static native void dewarpedImageCallbackNativeSet(long j, NativeDewarpedImageCallback nativeDewarpedImageCallback);

    public CombinedResult getCombinedResult() {
        return null;
    }

    @Override // com.microblink.entities.recognizers.blinkid.generic.BarcodeScanningStartedCallbackOptions
    public void setBarcodeScanningStartedCallback(BarcodeScanningStartedCallback barcodeScanningStartedCallback) {
        NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback = this.IllIIIllII;
        if (nativeBarcodeScanningStartedCallbackCallback != null) {
            nativeBarcodeScanningStartedCallbackCallback.llIIlIlIIl = barcodeScanningStartedCallback;
            return;
        }
        NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback2 = new NativeBarcodeScanningStartedCallbackCallback(barcodeScanningStartedCallback);
        this.IllIIIllII = nativeBarcodeScanningStartedCallbackCallback2;
        barcodeScanningStartedCallbackNativeSet(0L, nativeBarcodeScanningStartedCallbackCallback2);
    }

    public void setClassFilter(ClassFilter classFilter) {
        NativeClassFilter nativeClassFilter = this.llIIIlllll;
        if (nativeClassFilter != null) {
            nativeClassFilter.llIIlIlIIl = classFilter;
            return;
        }
        NativeClassFilter nativeClassFilter2 = new NativeClassFilter(classFilter);
        this.llIIIlllll = nativeClassFilter2;
        classFilterNativeSet(0L, nativeClassFilter2);
    }

    public void setClassifierCallback(ClassifierCallback classifierCallback) {
        NativeClassifierCallback nativeClassifierCallback = this.IlIllIlIIl;
        if (nativeClassifierCallback != null) {
            nativeClassifierCallback.llIIlIlIIl = classifierCallback;
            return;
        }
        NativeClassifierCallback nativeClassifierCallback2 = new NativeClassifierCallback(classifierCallback);
        this.IlIllIlIIl = nativeClassifierCallback2;
        classifierCallbackNativeSet(0L, nativeClassifierCallback2);
    }

    public void setDewarpedImageCallback(DewarpedImageCallback dewarpedImageCallback) {
        NativeDewarpedImageCallback nativeDewarpedImageCallback = this.llIIlIlIIl;
        if (nativeDewarpedImageCallback != null) {
            nativeDewarpedImageCallback.llIIlIlIIl = dewarpedImageCallback;
            return;
        }
        NativeDewarpedImageCallback nativeDewarpedImageCallback2 = new NativeDewarpedImageCallback(dewarpedImageCallback);
        this.llIIlIlIIl = nativeDewarpedImageCallback2;
        dewarpedImageCallbackNativeSet(0L, nativeDewarpedImageCallback2);
    }

    @Override // com.microblink.blinkid.secured.IlllIlllll
    public void writeToParcel(Parcel parcel, int i) {
        NativeDewarpedImageCallback nativeDewarpedImageCallback = this.llIIlIlIIl;
        if (nativeDewarpedImageCallback != null) {
            parcel.writeParcelable(nativeDewarpedImageCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeClassifierCallback nativeClassifierCallback = this.IlIllIlIIl;
        if (nativeClassifierCallback != null) {
            parcel.writeParcelable(nativeClassifierCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeBarcodeScanningStartedCallbackCallback nativeBarcodeScanningStartedCallbackCallback = this.IllIIIllII;
        if (nativeBarcodeScanningStartedCallbackCallback != null) {
            parcel.writeParcelable(nativeBarcodeScanningStartedCallbackCallback.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        NativeClassFilter nativeClassFilter = this.llIIIlllll;
        if (nativeClassFilter != null) {
            parcel.writeParcelable(nativeClassFilter.llIIlIlIIl, i);
        } else {
            parcel.writeParcelable(null, i);
        }
        super.writeToParcel(parcel, i);
    }
}
