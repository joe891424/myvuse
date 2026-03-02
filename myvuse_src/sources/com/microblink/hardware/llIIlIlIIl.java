package com.microblink.hardware;

import com.microblink.blinkid.secured.lIlIlIIIII;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
class llIIlIlIIl {
    private final String IlIllIlIIl;
    private lIlIlIIIII IllIIIIllI;
    private double IllIIIllII;
    private lIlIlIIIII llIIIlllll;
    private final String llIIlIlIIl;

    llIIlIlIIl(String str, String str2) {
        this.IllIIIllII = 1.0d;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
    }

    public double IlIllIlIIl() {
        return this.IllIIIllII;
    }

    public String IllIIIllII() {
        return this.llIIlIlIIl + "::" + this.IlIllIlIIl;
    }

    lIlIlIIIII llIIIlllll() {
        return this.llIIIlllll;
    }

    lIlIlIIIII llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    llIIlIlIIl(JSONObject jSONObject, String str) throws JSONException {
        this.IllIIIllII = 1.0d;
        String[] strArrSplit = str.split("::");
        this.IlIllIlIIl = strArrSplit[1];
        this.llIIlIlIIl = strArrSplit[0];
        if (jSONObject.has("zeroCopyBufferAllowed")) {
            this.llIIIlllll = new lIlIlIIIII(jSONObject.getString("zeroCopyBufferAllowed"));
        }
        if (jSONObject.has("eglPbufferNotSupported")) {
            this.IllIIIIllI = new lIlIlIIIII(jSONObject.getString("eglPbufferNotSupported"));
        }
        if (jSONObject.has("frameQualityFactor")) {
            this.IllIIIllII = jSONObject.getDouble("frameQualityFactor");
        }
    }
}
