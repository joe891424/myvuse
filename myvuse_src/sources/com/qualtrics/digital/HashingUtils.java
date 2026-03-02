package com.qualtrics.digital;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jose4j.lang.HashUtil;

/* JADX INFO: compiled from: HashingUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, m5598d2 = {"Lcom/qualtrics/digital/HashingUtils;", "", "()V", "getGuid", "", "prefix", "hashSHA256", "value", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class HashingUtils {
    public static final HashingUtils INSTANCE = new HashingUtils();

    private HashingUtils() {
    }

    @JvmStatic
    public static final String hashSHA256(String value) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(value, "value");
        MessageDigest messageDigest = MessageDigest.getInstance(HashUtil.SHA_256);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = value.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        StringBuilder sb = new StringBuilder(new BigInteger(1, messageDigest.digest(bytes)).toString(16));
        while (sb.length() < 32) {
            sb.insert(0, '0');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "hexString.toString()");
        return string;
    }

    @JvmStatic
    public static final String getGuid(String prefix) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        String strSubstring = hashSHA256(string).substring(0, 15);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return prefix + strSubstring;
    }
}
