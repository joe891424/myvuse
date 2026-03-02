package com.microblink.entities.recognizers.blinkid.generic.classinfo;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public final class ClassInfo {
    private Object IlIllIlIIl;
    private long llIIlIlIIl;

    public ClassInfo(long j, Object obj) {
        this.llIIlIlIIl = j;
        this.IlIllIlIIl = obj;
    }

    private static native String countryNameNativeGet(long j);

    private static native int countryNativeGet(long j);

    private static native boolean emptyNativeGet(long j);

    private static native String isoAlpha2CountryCodeNativeGet(long j);

    private static native String isoAlpha3CountryCodeNativeGet(long j);

    private static native String isoNumericCountryCodeNativeGet(long j);

    private static native int regionNativeGet(long j);

    private static native int typeNativeGet(long j);

    public Country getCountry() {
        return Country.values()[countryNativeGet(this.llIIlIlIIl)];
    }

    public String getCountryName() {
        return countryNameNativeGet(this.llIIlIlIIl);
    }

    public String getIsoAlpha2CountryCode() {
        return isoAlpha2CountryCodeNativeGet(this.llIIlIlIIl);
    }

    public String getIsoAlpha3CountryCode() {
        return isoAlpha3CountryCodeNativeGet(this.llIIlIlIIl);
    }

    public String getIsoNumericCountryCode() {
        return isoNumericCountryCodeNativeGet(this.llIIlIlIIl);
    }

    public Region getRegion() {
        return Region.values()[regionNativeGet(this.llIIlIlIIl)];
    }

    public Type getType() {
        return Type.values()[typeNativeGet(this.llIIlIlIIl)];
    }

    public boolean isEmpty() {
        return emptyNativeGet(this.llIIlIlIIl);
    }
}
