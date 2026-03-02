package com.microblink.entities.recognizers.blinkid.idbarcode;

import com.microblink.util.StringUtils;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class BarcodeElements {
    private Object IlIllIlIIl;
    private long llIIlIlIIl;

    public BarcodeElements(long j, Object obj) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = obj;
    }

    private static native boolean emptyNativeGet(long j);

    private static native byte[] valueNativeGet(long j, int i);

    public String getValue(BarcodeElementKey barcodeElementKey) {
        return StringUtils.convertByteArrayToString(valueNativeGet(this.llIIlIlIIl, barcodeElementKey.ordinal()));
    }

    public boolean isEmpty() {
        return emptyNativeGet(this.llIIlIlIIl);
    }
}
