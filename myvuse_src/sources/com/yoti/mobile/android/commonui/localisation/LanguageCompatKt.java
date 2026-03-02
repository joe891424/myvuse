package com.yoti.mobile.android.commonui.localisation;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageCompat.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m5597d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0011\u0010\u000f\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m5598d2 = {"ARABIC", "Ljava/util/Locale;", "DUTCH", "ENGLISH", "kotlin.jvm.PlatformType", "FRENCH", "GERMAN", "ITALIAN", "RUSSIAN", "SPANISH", "TURKISH", "languagesCompat", "", "getLanguagesCompat", "()Ljava/util/List;", "localeCompat", "getLocaleCompat", "()Ljava/util/Locale;", "commonUI_productionRelease"}, m5599k = 2, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class LanguageCompatKt {
    private static final Locale ARABIC;
    private static final Locale DUTCH;
    private static final Locale ENGLISH;
    private static final Locale FRENCH;
    private static final Locale GERMAN;
    private static final Locale ITALIAN;
    private static final Locale RUSSIAN;
    private static final Locale SPANISH;
    private static final Locale TURKISH;
    private static final List<Locale> languagesCompat;

    static {
        Locale ENGLISH2 = Locale.ENGLISH;
        ENGLISH = ENGLISH2;
        Locale locale = new Locale("ar");
        ARABIC = locale;
        Locale GERMAN2 = Locale.GERMAN;
        GERMAN = GERMAN2;
        Locale locale2 = new Locale("es");
        SPANISH = locale2;
        Locale FRENCH2 = Locale.FRENCH;
        FRENCH = FRENCH2;
        Locale ITALIAN2 = Locale.ITALIAN;
        ITALIAN = ITALIAN2;
        Locale locale3 = new Locale("nl");
        DUTCH = locale3;
        Locale locale4 = new Locale("ru");
        RUSSIAN = locale4;
        Locale locale5 = new Locale("tr");
        TURKISH = locale5;
        Intrinsics.checkNotNullExpressionValue(ENGLISH2, "ENGLISH");
        Intrinsics.checkNotNullExpressionValue(GERMAN2, "GERMAN");
        Intrinsics.checkNotNullExpressionValue(FRENCH2, "FRENCH");
        Intrinsics.checkNotNullExpressionValue(ITALIAN2, "ITALIAN");
        languagesCompat = CollectionsKt.listOf((Object[]) new Locale[]{ENGLISH2, locale, GERMAN2, locale2, FRENCH2, ITALIAN2, locale3, locale4, locale5});
    }

    public static final List<Locale> getLanguagesCompat() {
        return languagesCompat;
    }

    public static final Locale getLocaleCompat() {
        Object next;
        Iterator<T> it2 = languagesCompat.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (Intrinsics.areEqual(((Locale) next).getLanguage(), Locale.getDefault().getLanguage())) {
                break;
            }
        }
        Locale locale = (Locale) next;
        if (locale != null) {
            return locale;
        }
        Locale locale2 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale2, "<get-localeCompat>");
        return locale2;
    }
}
