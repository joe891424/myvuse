package com.qualtrics.digital.utils;

import com.facebook.hermes.intl.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TranslationUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m5597d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J2\u0010\t\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004JJ\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00062&\u0010\f\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00060\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0006J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0014"}, m5598d2 = {"Lcom/qualtrics/digital/utils/TranslationUtils;", "", "()V", "getFromMapOrDefault", "", "map", "", "key", Constants.COLLATION_DEFAULT, "getTranslationFromMapOrDefault", "originalLangKey", "getTranslationsInSupportedLang", "translationsDictionary", "langCode", "isLanguageCodePresentAndEnabled", "", "translations", "mapToSupportedLangKey", "langKey", "Companion", "qualtrics_productionRelease"}, m5599k = 1, m5600mv = {1, 6, 0}, m5602xi = 48)
public final class TranslationUtils {
    private static final String LANG_ENABLED_KEY = "A";
    private static final Map<String, List<String>> TARGETING_LANGUAGE_CODES_MAP = MapsKt.mapOf(TuplesKt.m5605to("ZH-S", CollectionsKt.listOf((Object[]) new String[]{"ZH-CN", "ZH-HANS"})), TuplesKt.m5605to("ZH-T", CollectionsKt.listOf((Object[]) new String[]{"ZH-TW", "ZH-HANT"})));
    private static final Map<String, String> LOCAL_LANGUAGE_CODES_MAP = MapsKt.mapOf(TuplesKt.m5605to("ES", "ES-419"), TuplesKt.m5605to("ZH-S", "ZH-HANS"), TuplesKt.m5605to("ZH-T", "ZH-HANT"), TuplesKt.m5605to("ZH-CN", "ZH-HANS"), TuplesKt.m5605to("ZH-TW", "ZH-HANT"));

    public final String getTranslationFromMapOrDefault(Map<String, String> map, String originalLangKey, String str) {
        Intrinsics.checkNotNullParameter(map, "map");
        return getFromMapOrDefault(map, mapToSupportedLangKey(originalLangKey), str);
    }

    public final Map<String, String> getTranslationsInSupportedLang(Map<String, ? extends Map<String, String>> translationsDictionary, String langCode) {
        Intrinsics.checkNotNullParameter(translationsDictionary, "translationsDictionary");
        List<String> listListOf = TARGETING_LANGUAGE_CODES_MAP.get(langCode);
        if (listListOf == null) {
            listListOf = CollectionsKt.listOf(langCode);
        }
        Iterator<T> it2 = listListOf.iterator();
        while (it2.hasNext()) {
            Map<String, String> map = translationsDictionary.get((String) it2.next());
            if (isLanguageCodePresentAndEnabled(map)) {
                return map;
            }
        }
        return null;
    }

    public final boolean isLanguageCodePresentAndEnabled(Map<String, String> translations) {
        return (translations == null || translations.get("A") == null || !Boolean.parseBoolean(translations.get("A"))) ? false : true;
    }

    private final String mapToSupportedLangKey(String langKey) {
        Map<String, String> map = LOCAL_LANGUAGE_CODES_MAP;
        if (map != null) {
            return map.getOrDefault(langKey, langKey);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    private final String getFromMapOrDefault(Map<String, String> map, String key, String str) {
        String str2 = map.containsKey(key) ? map.get(key) : str;
        return str2 == null ? str : str2;
    }
}
