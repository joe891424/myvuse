package com.microblink.blinkid.secured;

import java.util.Map;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class IlIIlIIIll {
    private final Map<String, String> IlIllIlIIl;
    private final String llIIlIlIIl;

    public IlIIlIIIll(String str, Map<String, String> map) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = map;
    }

    public String IlIllIlIIl() {
        return this.llIIlIlIIl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IlIIlIIIll.class != obj.getClass()) {
            return false;
        }
        IlIIlIIIll ilIIlIIIll = (IlIIlIIIll) obj;
        String str = this.llIIlIlIIl;
        if (str == null ? ilIIlIIIll.llIIlIlIIl != null : !str.equals(ilIIlIIIll.llIIlIlIIl)) {
            return false;
        }
        Map<String, String> map = this.IlIllIlIIl;
        Map<String, String> map2 = ilIIlIIIll.IlIllIlIIl;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        String str = this.llIIlIlIIl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.IlIllIlIIl;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public Map<String, String> llIIlIlIIl() {
        return this.IlIllIlIIl;
    }
}
