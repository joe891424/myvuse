package com.yoti.mobile.android.common.p049ui.components.utils;

import android.content.res.Resources;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\f"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/components/utils/LocaleCountryCodeHelper;", "Lcom/yoti/mobile/android/common/ui/components/utils/CountryCodeHelper;", "", "Ljava/util/Locale;", "a", "()[Ljava/util/Locale;", "Landroid/content/res/Resources;", "resources", "Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;", "demonymProvider", "<init>", "(Landroid/content/res/Resources;Lcom/yoti/mobile/android/common/ui/components/utils/IDemonymProvider;)V", "uiComponents_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class LocaleCountryCodeHelper extends CountryCodeHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocaleCountryCodeHelper(Resources resources, IDemonymProvider demonymProvider) {
        super(resources, demonymProvider);
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(demonymProvider, "demonymProvider");
    }

    @Override // com.yoti.mobile.android.common.p049ui.components.utils.CountryCodeHelper
    /* JADX INFO: renamed from: a */
    protected Locale[] mo4385a() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        Intrinsics.checkNotNullExpressionValue(availableLocales, "Locale.getAvailableLocales()");
        return availableLocales;
    }
}
