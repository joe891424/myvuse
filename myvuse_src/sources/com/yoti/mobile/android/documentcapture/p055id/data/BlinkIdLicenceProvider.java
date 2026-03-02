package com.yoti.mobile.android.documentcapture.p055id.data;

import android.util.Base64;
import com.yoti.mobile.android.documentcapture.p055id.BuildConfig;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CharSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, m5598d2 = {"Lcom/yoti/mobile/android/documentcapture/id/data/BlinkIdLicenceProvider;", "", "()V", "KEY_PART_1", "", "KEY_PART_2", "", "licence", "", "getLicence", "()Ljava/lang/String;", "licenseeName", "getLicenseeName", "decode", "xoredKey", "documentcapture-id_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class BlinkIdLicenceProvider {
    public static final BlinkIdLicenceProvider INSTANCE = new BlinkIdLicenceProvider();
    private static final char KEY_PART_1 = 'O';
    private static final char[] KEY_PART_2 = {'1', '@', '0'};

    private BlinkIdLicenceProvider() {
    }

    private final String decode(String xoredKey) {
        CharSpreadBuilder charSpreadBuilder = new CharSpreadBuilder(2);
        charSpreadBuilder.add(KEY_PART_1);
        charSpreadBuilder.addSpread(ArraysKt.reversedArray(KEY_PART_2));
        char[] array = charSpreadBuilder.toArray();
        StringBuilder sb = new StringBuilder();
        int length = xoredKey.length();
        for (int i = 0; i < length; i++) {
            sb.append((char) (xoredKey.charAt(i) ^ array[i % array.length]));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "output.toString()");
        return StringsKt.reversed((CharSequence) string).toString();
    }

    public final String getLicence() {
        byte[] bArrDecode = Base64.decode(BuildConfig.BLINK_ID_KEY, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(BuildConfig.BLINK_ID_KEY, Base64.DEFAULT)");
        return decode(new String(bArrDecode, Charsets.UTF_8));
    }

    public final String getLicenseeName() {
        return BuildConfig.BLINK_ID_LICENSEE_NAME;
    }
}
