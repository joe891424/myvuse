package com.microblink.entities.recognizers;

/* JADX INFO: compiled from: line */
/* JADX INFO: loaded from: classes3.dex */
public class SignedPayload {
    private String IlIllIlIIl;
    private String IllIIIllII;
    private String llIIlIlIIl;

    public SignedPayload(String str, String str2, String str3) {
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
        this.IllIIIllII = str3;
    }

    public String getPayload() {
        return this.llIIlIlIIl;
    }

    public String getSignature() {
        return this.IlIllIlIIl;
    }

    public String getSignatureVersion() {
        return this.IllIIIllII;
    }
}
