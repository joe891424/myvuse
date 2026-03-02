package com.yoti.mobile.android.remote.authentication;

import kotlin.Metadata;

/* JADX INFO: compiled from: TokenProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m5598d2 = {"HASH_ALGORITHM", "", "HEADER_ALGORITHM", "HEADER_ALGORITHM_VALUE", "HEADER_CERTIFICATE_CHAIN", "HEADER_KEY_ID", "IBV_AUDIENCE", "PAYLOAD_AUDIENCE", "PAYLOAD_DIGEST", "PAYLOAD_DIGEST_ALG", "PAYLOAD_DIGEST_HASH", "PAYLOAD_EXPIRE_AT", "PAYLOAD_FAD_CODE", "PAYLOAD_ISSUED_AT", "PAYLOAD_NONCE", "PAYLOAD_YOTI", "remote_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TokenProviderKt {
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String HEADER_ALGORITHM = "alg";
    private static final String HEADER_ALGORITHM_VALUE = "RS256";
    private static final String HEADER_CERTIFICATE_CHAIN = "x5c";
    private static final String HEADER_KEY_ID = "kid";
    private static final String IBV_AUDIENCE = "api.yoti.com";
    private static final String PAYLOAD_AUDIENCE = "aud";
    private static final String PAYLOAD_DIGEST = "digest";
    private static final String PAYLOAD_DIGEST_ALG = "alg";
    private static final String PAYLOAD_DIGEST_HASH = "value";
    private static final String PAYLOAD_EXPIRE_AT = "exp";
    private static final String PAYLOAD_FAD_CODE = "po_fad_code";
    private static final String PAYLOAD_ISSUED_AT = "iat";
    private static final String PAYLOAD_NONCE = "jti";
    private static final String PAYLOAD_YOTI = "yoti";
}
