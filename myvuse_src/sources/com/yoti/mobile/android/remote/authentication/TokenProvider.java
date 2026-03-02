package com.yoti.mobile.android.remote.authentication;

import android.util.Base64;
import com.google.android.gms.actions.SearchIntents;
import com.yoti.mobile.android.remote.model.IbvAuthenticationData;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.ReservedClaimNames;
import org.jose4j.lang.HashUtil;
import org.jose4j.lang.JoseException;

/* JADX INFO: compiled from: TokenProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m5598d2 = {"Lcom/yoti/mobile/android/remote/authentication/TokenProvider;", "", "authenticationData", "Lcom/yoti/mobile/android/remote/model/IbvAuthenticationData;", "keyChainManager", "Lcom/yoti/mobile/android/remote/authentication/KeyChainManager;", "(Lcom/yoti/mobile/android/remote/model/IbvAuthenticationData;Lcom/yoti/mobile/android/remote/authentication/KeyChainManager;)V", "generatePayload", "", "fadCode", "networkRequest", "Lcom/yoti/mobile/android/remote/authentication/NetworkRequest;", "generateToken", "hashRequest", "alg", "method", "path", SearchIntents.EXTRA_QUERY, "body", "", "remote_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TokenProvider {
    private final IbvAuthenticationData authenticationData;
    private final KeyChainManager keyChainManager;

    public TokenProvider(IbvAuthenticationData authenticationData, KeyChainManager keyChainManager) {
        Intrinsics.checkNotNullParameter(authenticationData, "authenticationData");
        Intrinsics.checkNotNullParameter(keyChainManager, "keyChainManager");
        this.authenticationData = authenticationData;
        this.keyChainManager = keyChainManager;
    }

    public final String generateToken(NetworkRequest networkRequest) throws JoseException {
        Intrinsics.checkNotNullParameter(networkRequest, "networkRequest");
        X509Certificate[] certificateChain = this.keyChainManager.getCertificateChain(this.authenticationData.getKeyAlias());
        PrivateKey privateKey = this.keyChainManager.getPrivateKey(this.authenticationData.getKeyAlias());
        if (certificateChain == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (privateKey == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (certificateChain.length < 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        JsonWebSignature jsonWebSignature = new JsonWebSignature();
        jsonWebSignature.setKey(privateKey);
        String strEncodeToString = Base64.encodeToString(certificateChain[1].getEncoded(), 2);
        String strEncodeToString2 = Base64.encodeToString(certificateChain[0].getEncoded(), 2);
        jsonWebSignature.setHeader("alg", AlgorithmIdentifiers.RSA_USING_SHA256);
        jsonWebSignature.setHeader("x5c", new String[]{strEncodeToString2, strEncodeToString});
        jsonWebSignature.setHeader("kid", this.authenticationData.getScheme());
        jsonWebSignature.setPayload(generatePayload(this.authenticationData.getFadCode(), networkRequest));
        String compactSerialization = jsonWebSignature.getCompactSerialization();
        Intrinsics.checkNotNullExpressionValue(compactSerialization, "jws.compactSerialization");
        return compactSerialization;
    }

    private final String generatePayload(String fadCode, NetworkRequest networkRequest) {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReservedClaimNames.AUDIENCE, "api.yoti.com");
        jSONObject.put(ReservedClaimNames.JWT_ID, string);
        jSONObject.put(ReservedClaimNames.ISSUED_AT, Integer.valueOf(iCurrentTimeMillis));
        jSONObject.put(ReservedClaimNames.EXPIRATION_TIME, Integer.valueOf(iCurrentTimeMillis + 300));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("po_fad_code", fadCode);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("alg", HashUtil.SHA_256);
        jSONObject3.put("value", hashRequest(HashUtil.SHA_256, networkRequest.getMethod(), networkRequest.getPath(), networkRequest.getQuery(), networkRequest.getBody()));
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("digest", jSONObject3);
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("yoti", jSONObject2);
        String jSONString = jSONObject.toJSONString();
        Intrinsics.checkNotNullExpressionValue(jSONString, "JSONObject().apply {\n   …\n        }.toJSONString()");
        return jSONString;
    }

    private final String hashRequest(String alg, String method, String path, String query, byte[] body) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(alg);
        Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(alg)");
        if (body == null) {
            body = new byte[0];
        }
        byte[] bytes = method.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bytes2 = path.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] bArrPlus = ArraysKt.plus(bytes, bytes2);
        byte[] bytes3 = query.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(messageDigest.digest(ArraysKt.plus(ArraysKt.plus(bArrPlus, bytes3), body)), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(hash, Base64.NO_WRAP)");
        return strEncodeToString;
    }
}
