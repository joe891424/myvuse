package org.jose4j.jwa;

import java.security.Key;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes6.dex */
public class CryptoPrimitive {
    private final Cipher cip;
    private final KeyAgreement kag;
    private final Key key;
    private final Mac mac;
    private final Signature sig;

    public CryptoPrimitive(Signature signature) {
        this(signature, null, null, null, null);
    }

    public CryptoPrimitive(Cipher cipher) {
        this(null, cipher, null, null, null);
    }

    public CryptoPrimitive(Mac mac) {
        this(null, null, mac, null, null);
    }

    public CryptoPrimitive(Key key) {
        this(null, null, null, key, null);
    }

    public CryptoPrimitive(KeyAgreement keyAgreement) {
        this(null, null, null, null, keyAgreement);
    }

    private CryptoPrimitive(Signature signature, Cipher cipher, Mac mac, Key key, KeyAgreement keyAgreement) {
        this.sig = signature;
        this.cip = cipher;
        this.mac = mac;
        this.key = key;
        this.kag = keyAgreement;
    }

    public Signature getSignature() {
        return this.sig;
    }

    public Cipher getCipher() {
        return this.cip;
    }

    public Mac getMac() {
        return this.mac;
    }

    public Key getKey() {
        return this.key;
    }

    public KeyAgreement getKeyAgreement() {
        return this.kag;
    }
}
