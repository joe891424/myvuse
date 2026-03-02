package com.yoti.mobile.android.common.p049ui.widgets.utils;

import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class YotiLocaleListCompat {

    /* JADX INFO: renamed from: a */
    private LocaleListCompat f6496a;

    public YotiLocaleListCompat(LocaleListCompat localeListCompat) {
        this.f6496a = localeListCompat;
    }

    public Locale getFirstMatch(String[] strArr) {
        return this.f6496a.getFirstMatch(strArr);
    }
}
