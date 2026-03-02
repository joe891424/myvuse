package com.reactnativenavigation.utils;

import android.content.res.Resources;
import kotlin.Metadata;
import org.jose4j.jwk.RsaJsonWebKey;

/* JADX INFO: compiled from: PrimitiveExt.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, m5598d2 = {RsaJsonWebKey.FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME, "", "", "getDp", "(F)I", "(I)I", "react-native-navigation_reactNative71Release"}, m5599k = 2, m5600mv = {1, 9, 0}, m5602xi = 48)
public final class PrimitiveExtKt {
    public static final int getDp(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static final int getDp(float f) {
        return (int) (f * Resources.getSystem().getDisplayMetrics().density);
    }
}
