package com.yoti.mobile.android.yotidocs.common.extension;

import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m5597d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¨\u0006\u0002"}, m5598d2 = {"validate", "Ljava/util/Locale;", "common_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LocaleExtensionKt {
    public static final Locale validate(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        try {
            String isO3Country = locale.getISO3Country();
            Intrinsics.checkNotNullExpressionValue(isO3Country, "isO3Country");
            if (isO3Country.length() <= 0) {
                return null;
            }
            String displayCountry = locale.getDisplayCountry();
            Intrinsics.checkNotNullExpressionValue(displayCountry, "displayCountry");
            if (displayCountry.length() > 0) {
                return locale;
            }
            return null;
        } catch (MissingResourceException unused) {
            return null;
        }
    }
}
