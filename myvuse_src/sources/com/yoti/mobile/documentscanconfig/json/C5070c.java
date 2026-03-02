package com.yoti.mobile.documentscanconfig.json;

import com.yoti.mobile.documentscanconfig.CountryCode;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.yoti.mobile.documentscanconfig.json.c */
/* JADX INFO: loaded from: classes4.dex */
public final class C5070c {
    /* JADX INFO: renamed from: a */
    public final List<String> m5374a(CountryCode countryCode, Map<String, CountrySupportedDocumentsJsonConfig> configuration) {
        Intrinsics.checkParameterIsNotNull(countryCode, "countryCode");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        return ArraysKt.toList(((CountrySupportedDocumentsJsonConfig) MapsKt.getValue(configuration, countryCode.getCode())).getDocuments());
    }
}
