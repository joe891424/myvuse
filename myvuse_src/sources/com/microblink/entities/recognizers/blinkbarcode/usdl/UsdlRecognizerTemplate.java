package com.microblink.entities.recognizers.blinkbarcode.usdl;

import com.microblink.util.StringUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class UsdlRecognizerTemplate {

    /* JADX INFO: compiled from: line */
    static class Result {
        Result() {
        }

        private static native byte[][] dynamicElementsNativeGet(long j);

        private static native byte[] elementNativeGet(long j, int i);

        public String getField(UsdlKeys usdlKeys) {
            return StringUtils.convertByteArrayToString(elementNativeGet(0L, usdlKeys.ordinal()));
        }

        @Deprecated
        public String[] getOptionalElements() {
            byte[][] bArrDynamicElementsNativeGet = dynamicElementsNativeGet(0L);
            String[] strArr = new String[bArrDynamicElementsNativeGet.length];
            for (int i = 0; i < bArrDynamicElementsNativeGet.length; i++) {
                strArr[i] = StringUtils.convertByteArrayToString(bArrDynamicElementsNativeGet[i]);
            }
            return strArr;
        }

        public String toString() {
            return "US Driver's License\n\nnull";
        }
    }

    UsdlRecognizerTemplate() {
    }
}
