package org.jose4j.jwe;

/* JADX INFO: loaded from: classes6.dex */
public class ContentEncryptionParts {
    private byte[] authenticationTag;
    private byte[] ciphertext;

    /* JADX INFO: renamed from: iv */
    private byte[] f8359iv;

    public ContentEncryptionParts(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f8359iv = bArr;
        this.ciphertext = bArr2;
        this.authenticationTag = bArr3;
    }

    public byte[] getIv() {
        return this.f8359iv;
    }

    public byte[] getCiphertext() {
        return this.ciphertext;
    }

    public byte[] getAuthenticationTag() {
        return this.authenticationTag;
    }
}
