package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import org.jose4j.keys.RsaKeyUtil;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes6.dex */
public class RsaJsonWebKey extends PublicJsonWebKey {
    public static final String EXPONENT_MEMBER_NAME = "e";
    public static final String FACTOR_CRT_COEFFICIENT = "t";
    public static final String FACTOR_CRT_EXPONENT_OTHER_MEMBER_NAME = "d";
    public static final String FIRST_CRT_COEFFICIENT_MEMBER_NAME = "qi";
    public static final String FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dp";
    public static final String FIRST_PRIME_FACTOR_MEMBER_NAME = "p";
    public static final String KEY_TYPE = "RSA";
    public static final String MODULUS_MEMBER_NAME = "n";
    public static final String OTHER_PRIMES_INFO_MEMBER_NAME = "oth";
    public static final String PRIME_FACTOR_OTHER_MEMBER_NAME = "r";
    public static final String PRIVATE_EXPONENT_MEMBER_NAME = "d";
    public static final String SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dq";
    public static final String SECOND_PRIME_FACTOR_MEMBER_NAME = "q";

    public RsaJsonWebKey(RSAPublicKey rSAPublicKey) {
        super(rSAPublicKey);
    }

    public RsaJsonWebKey(Map<String, Object> map) throws JoseException {
        this(map, null);
    }

    public RsaJsonWebKey(Map<String, Object> map, String str) throws JoseException {
        char c;
        String str2;
        String str3;
        String str4;
        String str5;
        super(map, str);
        BigInteger bigIntFromBase64UrlEncodedParam = getBigIntFromBase64UrlEncodedParam(map, MODULUS_MEMBER_NAME, true);
        BigInteger bigIntFromBase64UrlEncodedParam2 = getBigIntFromBase64UrlEncodedParam(map, EXPONENT_MEMBER_NAME, true);
        RsaKeyUtil rsaKeyUtil = new RsaKeyUtil(str, null);
        this.key = rsaKeyUtil.publicKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2);
        checkForBareKeyCertMismatch();
        if (map.containsKey("d")) {
            BigInteger bigIntFromBase64UrlEncodedParam3 = getBigIntFromBase64UrlEncodedParam(map, "d", false);
            if (map.containsKey("p")) {
                BigInteger bigIntFromBase64UrlEncodedParam4 = getBigIntFromBase64UrlEncodedParam(map, "p", false);
                BigInteger bigIntFromBase64UrlEncodedParam5 = getBigIntFromBase64UrlEncodedParam(map, SECOND_PRIME_FACTOR_MEMBER_NAME, false);
                BigInteger bigIntFromBase64UrlEncodedParam6 = getBigIntFromBase64UrlEncodedParam(map, FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME, false);
                BigInteger bigIntFromBase64UrlEncodedParam7 = getBigIntFromBase64UrlEncodedParam(map, SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME, false);
                BigInteger bigIntFromBase64UrlEncodedParam8 = getBigIntFromBase64UrlEncodedParam(map, FIRST_CRT_COEFFICIENT_MEMBER_NAME, false);
                c = 0;
                str2 = "p";
                str3 = SECOND_PRIME_FACTOR_MEMBER_NAME;
                str4 = FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME;
                str5 = SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME;
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam2, bigIntFromBase64UrlEncodedParam3, bigIntFromBase64UrlEncodedParam4, bigIntFromBase64UrlEncodedParam5, bigIntFromBase64UrlEncodedParam6, bigIntFromBase64UrlEncodedParam7, bigIntFromBase64UrlEncodedParam8);
            } else {
                c = 0;
                str2 = "p";
                str3 = SECOND_PRIME_FACTOR_MEMBER_NAME;
                str4 = FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME;
                str5 = SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME;
                this.privateKey = rsaKeyUtil.privateKey(bigIntFromBase64UrlEncodedParam, bigIntFromBase64UrlEncodedParam3);
            }
        } else {
            c = 0;
            str2 = "p";
            str3 = SECOND_PRIME_FACTOR_MEMBER_NAME;
            str4 = FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME;
            str5 = SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME;
        }
        String[] strArr = new String[8];
        strArr[c] = MODULUS_MEMBER_NAME;
        strArr[1] = EXPONENT_MEMBER_NAME;
        strArr[2] = "d";
        strArr[3] = str2;
        strArr[4] = str3;
        strArr[5] = str4;
        strArr[6] = str5;
        strArr[7] = FIRST_CRT_COEFFICIENT_MEMBER_NAME;
        removeFromOtherParams(strArr);
    }

    @Override // org.jose4j.jwk.JsonWebKey
    public String getKeyType() {
        return "RSA";
    }

    public RSAPublicKey getRsaPublicKey() {
        return (RSAPublicKey) this.key;
    }

    public RSAPublicKey getRSAPublicKey() {
        return getRsaPublicKey();
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return (RSAPrivateKey) this.privateKey;
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPublicTypeSpecificParams(Map<String, Object> map) {
        RSAPublicKey rsaPublicKey = getRsaPublicKey();
        putBigIntAsBase64UrlEncodedParam(map, MODULUS_MEMBER_NAME, rsaPublicKey.getModulus());
        putBigIntAsBase64UrlEncodedParam(map, EXPONENT_MEMBER_NAME, rsaPublicKey.getPublicExponent());
    }

    @Override // org.jose4j.jwk.PublicJsonWebKey
    protected void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        RSAPrivateKey rsaPrivateKey = getRsaPrivateKey();
        if (rsaPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(map, "d", rsaPrivateKey.getPrivateExponent());
            if (rsaPrivateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rsaPrivateKey;
                putBigIntAsBase64UrlEncodedParam(map, "p", rSAPrivateCrtKey.getPrimeP());
                putBigIntAsBase64UrlEncodedParam(map, SECOND_PRIME_FACTOR_MEMBER_NAME, rSAPrivateCrtKey.getPrimeQ());
                putBigIntAsBase64UrlEncodedParam(map, FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME, rSAPrivateCrtKey.getPrimeExponentP());
                putBigIntAsBase64UrlEncodedParam(map, SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME, rSAPrivateCrtKey.getPrimeExponentQ());
                putBigIntAsBase64UrlEncodedParam(map, FIRST_CRT_COEFFICIENT_MEMBER_NAME, rSAPrivateCrtKey.getCrtCoefficient());
            }
        }
    }

    @Override // org.jose4j.jwk.JsonWebKey
    protected String produceThumbprintHashInput() {
        HashMap map = new HashMap();
        fillPublicTypeSpecificParams(map);
        return String.format("{\"e\":\"%s\",\"kty\":\"RSA\",\"n\":\"%s\"}", map.get(EXPONENT_MEMBER_NAME), map.get(MODULUS_MEMBER_NAME));
    }
}
