package com.yoti.mobile.android.common.p049ui.components.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5596bv = {1, 0, 3}, m5597d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m5598d2 = {"Lcom/yoti/mobile/android/common/ui/components/utils/Demonym;", "", "", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Ljava/util/Locale;", "b", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "locale", "<init>", "(Ljava/lang/String;Ljava/util/Locale;)V", "uiComponents_release"}, m5599k = 1, m5600mv = {1, 4, 2})
public final class Demonym {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Locale locale;

    public Demonym(String name, Locale locale) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.name = name;
        this.locale = locale;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }
}
