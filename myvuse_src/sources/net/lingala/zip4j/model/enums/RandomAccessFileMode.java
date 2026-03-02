package net.lingala.zip4j.model.enums;

import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: loaded from: classes6.dex */
public enum RandomAccessFileMode {
    READ(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME),
    WRITE("rw");

    private String value;

    RandomAccessFileMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
